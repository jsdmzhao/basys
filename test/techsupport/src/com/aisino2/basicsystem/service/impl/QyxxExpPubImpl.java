package com.aisino2.basicsystem.service.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.XmlReader;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;

public class QyxxExpPubImpl {
	
	private com.aisino2.publicsystem.service.IQyjbxxService qyjbxxService = null;
	private com.aisino2.publicsystem.domain.Qyjbxx setQyjbxx = null;
	private User user = null;
	public QyxxExpPubImpl(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		user = (User)session.getAttribute(Constants.userKey);
		final String[] application = new String[] {
				"config/spring/applicationContext.xml",
				"config/spring/sysadmin-dao.xml",
				"config/spring/sysadmin-service.xml",
				"config/spring/basicsystem-dao.xml",
				"config/spring/basicsystem-service.xml",
				"config/spring/icksystem-dao.xml",
				"config/spring/icksystem-service.xml",
				"config/spring/publicsystem-dao.xml",
				"config/spring/publicsystem-service.xml"};   
		ApplicationContext context =  new ClassPathXmlApplicationContext(application);
		qyjbxxService = (com.aisino2.publicsystem.service.IQyjbxxService)context.getBean("qyjbxxService");
	}
	
	/**
	 * 添加公共模块企业基本信息
	 * @param recode
	 * @throws Exception 
	 */
	public String uploadPubQyxx(Element recode) throws Exception{
		setQyjbxx = new com.aisino2.publicsystem.domain.Qyjbxx();
		setQyjbxx.setHylbdm(XmlReader.getNodeText(recode,"K_KHLX")); //行业类别
		setQyjbxx.setQyzflbm(XmlReader.getNodeText(recode,"K_JXQYFL")); //企业主分类
		setQyjbxx.setQybm(XmlReader.getNodeText(recode,"STATIONID")); //企业编码
		setQyjbxx.setQymc(XmlReader.getNodeText(recode,"K_MINGCHENG")); //企业名称
		setQyjbxx.setFrdb(XmlReader.getNodeText(recode,"K_FARENMINGCHENG")); //法人名称
		String res = valIsHaveQyxx(setQyjbxx);
		if(!"".equals(res)){
			return res;
		}
		setQyjbxx.setDwfzr(XmlReader.getNodeText(recode,"K_ZONGJINGLI")); //总经理
		setQyjbxx.setBafzrxm(XmlReader.getNodeText(recode,"K_ZHIANZERENREN")); //治安负责人
		setQyjbxx.setJydz(XmlReader.getNodeText(recode,"K_XIANGZHI")); //详细地址
		setQyjbxx.setLxdh(XmlReader.getNodeText(recode,"K_LIANXIDIANHUA")); //联系电话
		setQyjbxx.setGxdwbm(XmlReader.getNodeText(recode,"K_PAICHUSUOBM")); //管辖单位编码
		setQyjbxx.setGxdwmc(XmlReader.getNodeText(recode,"K_PAICHUSUO")); //管辖单位名称
		setQyjbxx.setDcbs(new Integer(2));
		String zbrs = XmlReader.getNodeText(recode,"K_ZHIBAORENYUANSHU");
		setQyjbxx.setBars(Integer.parseInt((!"".equals(zbrs))?zbrs:"0")); //治保人员数
		String jpxs = XmlReader.getNodeText(recode,"K_JINGPEIXUNDE");
		setQyjbxx.setJgpxrs(Integer.parseInt((!"".equals(jpxs))?jpxs:"0")); //经培训人员数
		setQyjbxx.setLrr(user.getUseraccount());
		setQyjbxx.setLrdwbm(user.getDepartment().getDepartcode());
		setQyjbxx.setLrdwmc(user.getDepartment().getDepartname());
		tranDictItem(setQyjbxx);
		setQyjbxx = qyjbxxService.insertQyjbxx(setQyjbxx);
		setQyjbxx.setLQyzjbList(new ArrayList());
		setQyjbxx.setHcr(user.getUseraccount());
		setQyjbxx.setHcdw(user.getDepartment().getDepartname());
		qyjbxxService.updateQyjbxxHc(setQyjbxx);
		return "";
	}
	
	public String valIsHaveQyxx(com.aisino2.publicsystem.domain.Qyjbxx setQyjbxx){
		String res = "";
		String qiYeBianMa = setQyjbxx.getQybm();
		String qiYeMc = setQyjbxx.getQymc();
		String qiYeZfl = setQyjbxx.getQyfflbm();
		String qiYeFr = setQyjbxx.getFrdb();
		if("".equals(qiYeBianMa)){
			res += "企业编码为空值.\r\n";
		} else if("".equals(qiYeMc)){
			res += "企业编码["+qiYeBianMa+"] 企业名称为空值.\r\n";
		} else if("".equals(qiYeZfl)){
			res += "企业编码["+qiYeBianMa+"],企业名称["+qiYeMc+"] 企业主分类为空值.\r\n";
		} else if("".equals(qiYeFr)){
			res += "企业编码["+qiYeBianMa+"],企业名称["+qiYeMc+"] 法人姓名为空值.\r\n";
		}
		if("".equals(res)){
			setQyjbxx = qyjbxxService.getQyjbxx(setQyjbxx);
			if(setQyjbxx!=null){
				res += "企业编码["+qiYeBianMa+"],企业名称["+qiYeMc+"] 系统已经存在.\r\n";
			}
		}
		return res;
	}
	
	public void tranDictItem(com.aisino2.publicsystem.domain.Qyjbxx setQyjbxx){
		Dict_item dict_item = CacheManager.getCacheDictitemOne("dm_hylb", setQyjbxx.getHylbdm());
		if (dict_item != null){
			setQyjbxx.setHylb(dict_item.getDisplay_name());
		}
		String qybm = setQyjbxx.getQybm();
		if(qybm.contains("J")){ //公用模块-J娱乐业
			dict_item = CacheManager.getCacheDictitemOne("dm_ylcsfl", setQyjbxx.getQyzflbm());
		}
		if(qybm.contains("E01")){ //公用模块-E01二手车
			dict_item = CacheManager.getCacheDictitemOne("dm_qyzfl(esc)", setQyjbxx.getQyzflbm());
		}
		if(qybm.contains("E02")){ //公用模块-E02二手机
			dict_item = CacheManager.getCacheDictitemOne("dm_qyzfl(esj)", setQyjbxx.getQyzflbm());
		}
		if(qybm.contains("E04")){ //公用模块-E04废旧金属
			dict_item = CacheManager.getCacheDictitemOne("dm_qyzfl(fjjs)", setQyjbxx.getQyzflbm());
		}
		if(qybm.contains("F01")){ //公用模块-F01汽车出租
			dict_item = CacheManager.getCacheDictitemOne("dm_qyzfl(czc)", setQyjbxx.getQyzflbm());
		}
		if(qybm.contains("F02")){ //公用模块-F02汽车租赁
			dict_item = CacheManager.getCacheDictitemOne("dm_qyzfl(qczl)", setQyjbxx.getQyzflbm());
		}
		if(qybm.contains("C")){ //公用模块-机修
			dict_item = CacheManager.getCacheDictitemOne("dm_jxqyfl", setQyjbxx.getQyzflbm());
		}
		if(qybm.contains("X")){ //公用模块-剧毒
			dict_item = CacheManager.getCacheDictitemOne("dm_dwlx_jdhxp", setQyjbxx.getQyzflbm());
		}
		
		if (dict_item != null){
			setQyjbxx.setQyzflmc(dict_item.getDisplay_name());
		}
	}
}
