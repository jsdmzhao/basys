package com.aisino2.basicsystem.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aisino2.common.XmlReader;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

public class QyxxExpDdyImpl {
	
	private com.aisino2.ddhyzagl.service.IDdqyxxService ddqyxxService = null;
	private com.aisino2.ddhyzagl.domain.Ddcdryxx setDdcdryxx = null;
	private com.aisino2.ddhyzagl.domain.Ddqyxx setDdqyxx = null;
	private User user = null;
	public QyxxExpDdyImpl(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		user = (User)session.getAttribute(Constants.userKey);
		final String[] application = new String[] {
				"config/spring/applicationContext.xml",
				"config/spring/sysadmin-dao.xml",
				"config/spring/sysadmin-service.xml",
				"config/spring/basicsystem-dao.xml",
				"config/spring/basicsystem-service.xml",
				"config/spring/publicsystem-dao.xml",
				"config/spring/publicsystem-service.xml",
				"config/spring/ddhyzagl-dao.xml",
				"config/spring/ddhyzagl-service.xml"};   
		ApplicationContext context =  new ClassPathXmlApplicationContext(application);
		ddqyxxService = (com.aisino2.ddhyzagl.service.IDdqyxxService)context.getBean("ddqyxxService");
	}
	
	/**
	 * 添加旅馆业基本信息
	 * @param recode
	 */
	public String uploadDdyQyxx(Element recode){
		setDdqyxx = new com.aisino2.ddhyzagl.domain.Ddqyxx();
		
		setDdqyxx.setDdqybm(XmlReader.getNodeText(recode,"STATIONID")); //企业编码
		setDdqyxx.setDdqymc(XmlReader.getNodeText(recode,"K_MINGCHENG")); //企业名称
		setDdqyxx.setFrdb(XmlReader.getNodeText(recode,"K_FARENMINGCHENG")); //法人代表
		String res = valIsHaveDdy(setDdqyxx);
		if(!"".equals(res)){
			return res;
		}
		
		setDdqyxx.setDwfzr(XmlReader.getNodeText(recode,"K_ZONGJINGLI")); //总经理
		setDdqyxx.setJydz(XmlReader.getNodeText(recode,"K_XIANGZHI")); //详细地址
		setDdqyxx.setLxdh(XmlReader.getNodeText(recode,"K_LIANXIDIANHUA")); //联系电话
		setDdqyxx.setGxdwbm(XmlReader.getNodeText(recode,"K_PAICHUSUOBM")); //管辖单位编码
		setDdqyxx.setGxdwmc(XmlReader.getNodeText(recode,"K_PAICHUSUO")); //管辖单位名称
		setDdcdryxx = new com.aisino2.ddhyzagl.domain.Ddcdryxx();
		String zbrs = XmlReader.getNodeText(recode,"K_ZHIBAORENYUANSHU");
		setDdcdryxx.setBars(Integer.parseInt((!"".equals(zbrs))?zbrs:"0")); //治安人数
		String jpxs = XmlReader.getNodeText(recode,"K_JINGPEIXUNDE");
		setDdcdryxx.setJgpxrs(Integer.parseInt((!"".equals(jpxs))?jpxs:"0")); //经培训数
		
		setDdqyxx.setDcbs(new Integer(2));
		setDdqyxx.setDdcdryxx(setDdcdryxx);
		setDdqyxx.setLrr(user.getUseraccount());
		setDdqyxx.setLrdwbm(user.getDepartment().getDepartcode());
		setDdqyxx.setLrdwmc(user.getDepartment().getDepartname());
		setDdqyxx = ddqyxxService.insertDdqyxx(setDdqyxx);
		
		Date nowDate = new Date();
		setDdqyxx.setCzlx("审核");
		setDdqyxx.setCzr(user.getUseraccount());
		setDdqyxx.setHcr(user.getUseraccount());
		setDdqyxx.setHcdw(user.getDepartment().getDepartname());
		setDdqyxx.setHcsj(nowDate);
		setDdqyxx.setZtgbrq(nowDate);
		setDdqyxx.setBcsj(nowDate);
		ddqyxxService.hechaDdqyxx(setDdqyxx);
		return "";
	}
	
	public String valIsHaveDdy(com.aisino2.ddhyzagl.domain.Ddqyxx setDdqyxx){
		String res = "";
		String qiYeBianMa = setDdqyxx.getDdqybm();
		String qiYeMc = setDdqyxx.getDdqymc();
		String qiYeFr = setDdqyxx.getFrdb();
		if("".equals(qiYeBianMa)){
			res += "企业编码为空值.\r\n";
		} else if("".equals(qiYeMc)){
			res += "企业编码["+qiYeBianMa+"] 企业名称为空值.\r\n";
		} else if("".equals(qiYeFr)){
			res += "企业编码["+qiYeBianMa+"],企业名称["+qiYeMc+"] 法人姓名为空值.\r\n";
		}
		if("".equals(res)){
			setDdqyxx = ddqyxxService.getDdqyxx(setDdqyxx);
			if(setDdqyxx!=null){
				res += "企业编码["+qiYeBianMa+"],企业名称["+qiYeMc+"]系统已经存在.\r\n";
			}
		}
		return res;
	}
}
