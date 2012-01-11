package com.aisino2.basicsystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aisino2.common.XmlReader;
import com.aisino2.core.util.DateUtil;

public class QyxxExpLgyImpl {
	
	private com.aisino2.lgyzagl.service.ILvguanService lvguanService = null;
	private com.aisino2.lgyzagl.domain.Lvguan setLvguan = null;
	private Map hyxlMap = new HashMap();
	public QyxxExpLgyImpl(){
		final String[] application = new String[] {
				"config/spring/applicationContext.xml",
				"config/spring/lgyzagl-dao.xml",
				"config/spring/lgyzagl-service.xml"};   
		ApplicationContext context =  new ClassPathXmlApplicationContext(application);
		lvguanService = (com.aisino2.lgyzagl.service.ILvguanService)context.getBean("lvguanService");
		hyxlMap.put("", "旅馆业"); hyxlMap.put("A01", "旅馆业"); hyxlMap.put("A02", "洗浴业");
	}
	
	/**
	 * 添加旅馆业基本信息
	 * @param recode
	 */
	public String uploadLvGaunQyxx(Element recode){
		String res = valIsHaveLvguan(recode);
		if(!"".equals(res)){
			return res;
		}
		setLvguan = new com.aisino2.lgyzagl.domain.Lvguan();
		setLvguan.setHangyelx(XmlReader.getNodeText(recode,"K_KHLX")); //行业类别
		setLvguan.setQiyebianma(XmlReader.getNodeText(recode,"STATIONID")); //企业编码
		setLvguan.setQiyemc(XmlReader.getNodeText(recode,"K_MINGCHENG")); //企业名称
		setLvguan.setJiqijiamibh(XmlReader.getNodeText(recode,"ENCODESTR")); //企业授权码
		setLvguan.setFarenmc(XmlReader.getNodeText(recode,"K_FARENMINGCHENG")); //法人名称
		setLvguan.setZongjingli(XmlReader.getNodeText(recode,"K_ZONGJINGLI")); //总经理
		setLvguan.setLianxidh(XmlReader.getNodeText(recode,"K_LIANXIDIANHUA")); //联系电话
		setLvguan.setXiangxidizhi(XmlReader.getNodeText(recode,"K_XIANGZHI")); //详细地址
		setLvguan.setBaoanbudh(XmlReader.getNodeText(recode,"K_BAOANBUDIANHUA")); //保安部电话
		setLvguan.setZhuangtai(XmlReader.getNodeText(recode,"K_ZHUANGTAI")); //企业状态
		String fjs = XmlReader.getNodeText(recode,"K_FANGJIANSHU");
		String cws = XmlReader.getNodeText(recode,"K_CHUANGWEISHU");
		setLvguan.setFangjianshu(Integer.parseInt(fjs));
		setLvguan.setChuangweishu(Integer.parseInt(cws));
		setLvguan.setQiyexingji(XmlReader.getNodeText(recode,"K_GUANXINGJI"));
		setLvguan.setQiyedengji(XmlReader.getNodeText(recode,"K_GUANDENGJI"));
		setLvguan.setGxdwbm(XmlReader.getNodeText(recode,"K_PAICHUSUOBM")); //管辖单位编码
		setLvguan.setGxdwmc(XmlReader.getNodeText(recode,"K_PAICHUSUO")); //管辖单位名称
		String hyxl = XmlReader.getNodeText(recode,"K_JXQYFL");
		setLvguan.setYewulbbm(("".equals(hyxl))?"A01":hyxl); //业务类别
		setLvguan.setYewulb((String)hyxlMap.get(hyxl)); //业务类别
		setLvguan.setQitaisblx(XmlReader.getNodeText(recode,"K_KHCPLX")); //产品类型编码
		setLvguan.setZhianzrr(XmlReader.getNodeText(recode,"K_ZHIANZERENREN")); //治安负责人
		
		String ztgbrqs = XmlReader.getNodeText(recode,"K_ZTGBRQ");
		Date ztgbrq = null;
		try {
			if("".equals(ztgbrqs)){ ztgbrq = new Date(); }
			else { ztgbrq = DateUtil.convertStringToDate("yyyy-MM-dd", ztgbrqs); }
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLvguan.setZhuangtaigbrq(ztgbrq); //企业状态改变日期
		
		setLvguan.setQiyexingzhi(XmlReader.getNodeText(recode,"K_QIYEXINGZHI")); //企业行政
		String cyrs = XmlReader.getNodeText(recode,"K_CONGYERENSHU");
		setLvguan.setCongyerenshu(Integer.parseInt((!"".equals(cyrs))?cyrs:"0")); //从业人数
		
		String zbrs = XmlReader.getNodeText(recode,"K_ZHIBAORENYUANSHU");
		setLvguan.setZhibaorenshu(Integer.parseInt((!"".equals(zbrs))?zbrs:"0")); //治保人员数
		String jpxs = XmlReader.getNodeText(recode,"K_JINGPEIXUNDE");
		setLvguan.setJingpeixunrs(Integer.parseInt((!"".equals(jpxs))?jpxs:"0")); //经培训人员数
		
		setLvguan.setLPmtList(new ArrayList());
		setLvguan.setDcbs("2");
		setLvguan.setZhuxiaobz("0");
		setLvguan.setWaiwangtbbz("0"); //外网同步标志1.29改成0 秦环岛为空请注意
		setLvguan = lvguanService.insertLvguan(setLvguan);
		return "";
	}
	
	/** 添加旅馆业前的验证 */
	public String valIsHaveLvguan(Element recode){
		com.aisino2.lgyzagl.domain.Lvguan temp = null;
		String res = "";
		String hylb = XmlReader.getNodeText(recode,"K_KHLX"); //行业类别
		String qybm = XmlReader.getNodeText(recode,"STATIONID"); //企业编码
		String qymc = XmlReader.getNodeText(recode,"K_MINGCHENG"); //企业名称
		String sqm = XmlReader.getNodeText(recode,"ENCODESTR"); //企业授权码
		String famc = XmlReader.getNodeText(recode,"K_FARENMINGCHENG"); //法人名称
		String zjl = XmlReader.getNodeText(recode,"K_ZONGJINGLI"); //总经理
		String lxdh = XmlReader.getNodeText(recode,"K_LIANXIDIANHUA"); //联系电话
		String xxdz = XmlReader.getNodeText(recode,"K_XIANGZHI"); //详细地址
		String babdh = XmlReader.getNodeText(recode,"K_BAOANBUDIANHUA"); //保安部电话
		String qyzt = XmlReader.getNodeText(recode,"K_ZHUANGTAI"); //企业状态
		String fjs = XmlReader.getNodeText(recode,"K_FANGJIANSHU"); //房间数
		String cws = XmlReader.getNodeText(recode,"K_CHUANGWEISHU"); //床位数
		String xj = XmlReader.getNodeText(recode,"K_GUANXINGJI"); //企业星级
		String dj = XmlReader.getNodeText(recode,"K_GUANDENGJI"); //企业等级
		String pcsbm = XmlReader.getNodeText(recode,"K_PAICHUSUOBM"); //派出所编码
		String pcsmc = XmlReader.getNodeText(recode,"K_PAICHUSUO"); //派出所名称
		
		String qybmAndQymc = "(企业编码:"+qybm+",企业名称:"+qymc+")";
		if("".equals(hylb)){ //行业类别
			res += "行业类别[K_KHLX]为空值.\r\n";
		}else if("".equals(qybm)){ //企业编码
			res += "企业编码[STATIONID]为空值.\r\n";
		}else if("".equals(qymc)){ //企业名称
			res += "(企业编码:"+qybm+") 企业名称[K_MINGCHENG]为空值.\r\n";
		}else if("".equals(sqm)){ //企业授权码
			res += qybmAndQymc+" 授权码[ENCODESTR]为空值.\r\n";
		}else if("".equals(famc)){ //法人名称
			res += qybmAndQymc+" 法人名称[K_FARENMINGCHENG]为空值.\r\n";
		}else if("".equals(zjl)){ //总经理
			res += qybmAndQymc+" 总经理[K_ZONGJINGLI]为空值.\r\n";
		}else if("".equals(lxdh)){ //联系电话
			res += qybmAndQymc+" 联系电话[K_LIANXIDIANHUA]为空值.\r\n";
		}else if("".equals(xxdz)){ //详细地址
			res += qybmAndQymc+" 详细地址[K_XIANGZHI]为空值.\r\n";
		}else if("".equals(babdh)){ //保安部电话
			res += qybmAndQymc+" 保安部电话[K_BAOANBUDIANHUA]为空值.\r\n";
		}else if("".equals(qyzt)){ //企业状态
			res += qybmAndQymc+" 企业状态[K_ZHUANGTAI]为空值.\r\n";
		}else if("".equals(fjs)){ //房间数
			res += qybmAndQymc+" 房间数[K_FANGJIANSHU]为空值.\r\n";
		}else if("".equals(cws)){ //床位数
			res += qybmAndQymc+" 床位数[K_CHUANGWEISHU]为空值.\r\n";
		}else if("".equals(xj)){ //企业星级
			res += qybmAndQymc+" 企业星级[K_GUANXINGJI]为空值.\r\n";
		}else if("".equals(dj)){ //企业等级
			res += qybmAndQymc+" 企业等级[K_GUANDENGJI]为空值.\r\n";
		}else if("".equals(pcsbm)){ //派出所编码
			res += qybmAndQymc+" 派出所编码[K_PAICHUSUOBM]为空值.\r\n";
		}else if("".equals(pcsmc)){ //派出所名称
			res += qybmAndQymc+" 派出所名称[K_PAICHUSUO]为空值.\r\n";
		}
		if("".equals(res)){
			temp = new com.aisino2.lgyzagl.domain.Lvguan();
			temp.setQiyebianma(qybm);
			temp = lvguanService.getLvguan(temp);
			if(temp!=null){
				res += qybmAndQymc+" 系统已经存在此旅馆企业信息.\r\n";
			}
		}
		return res;
	}
	
	/** 验证企业编码、授权码、企业是否存在 */
	public String uploadLvGaunSqxxVal(Element recode){
		setLvguan = new com.aisino2.lgyzagl.domain.Lvguan();
		
		setLvguan.setQiyebianma(XmlReader.getNodeText(recode,"STATIONID")); //企业编码
		setLvguan.setJiqijiamibh(XmlReader.getNodeText(recode,"ENCODESTR")); //企业授权码
		
		String res = valIsHaveLvguanBm(setLvguan);
		return res;
	}
	
	/** 验证企业编码、授权码、企业是否存在 */
	public String valIsHaveLvguanBm(com.aisino2.lgyzagl.domain.Lvguan setLvguan){
		String res = "";
		String qiYeBianMa = setLvguan.getQiyebianma();
		String qiYeSqm = setLvguan.getJiqijiamibh();
		if("".equals(qiYeBianMa)){
			res += "企业编码为空值.\r\n";
		} else if("".equals(qiYeSqm)){
			res += "企业编码["+qiYeBianMa+"] 授权码[ENCODESTR]为空值.\r\n";
		}
		if("".equals(res)){
			setLvguan = lvguanService.getLvguan(setLvguan);
			if(setLvguan==null){
				res += "企业编码["+qiYeBianMa+"] 系统不存在此企业编码.\r\n";
			}
		}
		return res;
	}
}
