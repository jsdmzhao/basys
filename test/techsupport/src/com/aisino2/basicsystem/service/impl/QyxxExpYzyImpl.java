package com.aisino2.basicsystem.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aisino2.common.XmlReader;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

public class QyxxExpYzyImpl {
	
	private com.aisino2.yzyzagl.service.IYzzzdwxxService yzzzdwxxService = null;
	private com.aisino2.yzyzagl.domain.Yzzzdwxx setYzzzdwxx = null;
	private User user = null;
	public QyxxExpYzyImpl(){
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
				"config/spring/yzyzagl-dao.xml",
				"config/spring/yzyzagl-service.xml"};
		ApplicationContext context =  new ClassPathXmlApplicationContext(application);
		yzzzdwxxService = (com.aisino2.yzyzagl.service.IYzzzdwxxService)context.getBean("yzzzdwxxService");
	}
	
	/**
	 * 添加旅馆业基本信息
	 * @param recode
	 * @throws Exception 
	 */
	public String uploadJxyQyxx(Element recode) throws Exception{
		setYzzzdwxx = new com.aisino2.yzyzagl.domain.Yzzzdwxx();
		
		setYzzzdwxx.setZzdwbm(XmlReader.getNodeText(recode,"STATIONID"));
		setYzzzdwxx.setZzdwmc(XmlReader.getNodeText(recode,"K_MINGCHENG"));
		setYzzzdwxx.setFrdb(XmlReader.getNodeText(recode,"K_FARENMINGCHENG"));
		String res = valIsHaveYzy(setYzzzdwxx);
		if(!"".equals(res)){
			return res;
		}
		setYzzzdwxx.setDwfzr(XmlReader.getNodeText(recode,"K_ZONGJINGLI")); //总经理
		setYzzzdwxx.setJydz(XmlReader.getNodeText(recode,"K_XIANGZHI")); //详细地址
		setYzzzdwxx.setLxdh(XmlReader.getNodeText(recode,"K_LIANXIDIANHUA")); //联系电话
		setYzzzdwxx.setGxdwbm(XmlReader.getNodeText(recode,"K_PAICHUSUOBM")); //管辖单位编码
		setYzzzdwxx.setGxdwmc(XmlReader.getNodeText(recode,"K_PAICHUSUO")); //管辖单位编码
		
		setYzzzdwxx.setDcbs(new Integer(2));
		setYzzzdwxx.setLrr(user.getUseraccount());
		setYzzzdwxx.setLrdwbm(user.getDepartment().getDepartcode());
		setYzzzdwxx.setLrdwmc(user.getDepartment().getDepartname());
		yzzzdwxxService.insertYzzzdwxx(setYzzzdwxx);
		return "";
	}
	
	public String valIsHaveYzy(com.aisino2.yzyzagl.domain.Yzzzdwxx setYzzzdwx){
		String res = "";
		String qiYeBianMa = setYzzzdwx.getZzdwbm();
		String qiYeMc = setYzzzdwx.getZzdwmc();
		String qiYeFr = setYzzzdwx.getFrdb();
		if("".equals(qiYeBianMa)){
			res += "企业编码为空值.\r\n";
		} else if("".equals(qiYeMc)){
			res += "企业编码["+qiYeBianMa+"] 企业名称为空值.\r\n";
		} else if("".equals(qiYeFr)){
			res += "企业编码["+qiYeBianMa+"],企业名称["+qiYeMc+"] 法人姓名为空值.\r\n";
		}
		if("".equals(res)){
			setYzzzdwx = yzzzdwxxService.getYzzzdwxx(setYzzzdwx);
			if(setYzzzdwx!=null){
				res += "企业编码["+qiYeBianMa+"],企业名称["+qiYeMc+"]系统已经存在.\r\n";
			}
		}
		return res;
	}
}
