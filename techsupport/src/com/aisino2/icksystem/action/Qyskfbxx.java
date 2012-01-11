package com.aisino2.icksystem.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aisino2.icksystem.domain.Qyryskjl;

public class Qyskfbxx {
	private com.aisino2.nbdw.service.ISkjlxxService skjlxxService =null;
	private com.aisino2.nbdw.domain.Skjlxx setSkjlxx=null;
	private String result="";

	public String insertqyskfb(Qyryskjl qyryskjl) throws Exception {
		ClassPathXmlApplicationContext contextLg = new ClassPathXmlApplicationContext(new String[] {
				"/config/spring/applicationContext.xml",
				"/config/spring/applicationContext-nbdw.xml",
				"/config/spring/uKey-dao.xml",
				"/config/spring/sysadmin-dao.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/nbdw-dao.xml",
		        "/config/spring/nbdw-service.xml" });
		skjlxxService= (com.aisino2.nbdw.service.ISkjlxxService)contextLg.getBean("skjlxxService");
		try {
			setSkjlxx=new com.aisino2.nbdw.domain.Skjlxx();
			setSkjlxx.setDwlb(qyryskjl.getDwlb());
			setSkjlxx.setDwlbdm(qyryskjl.getDwlbdm());
			setSkjlxx.setSkid(qyryskjl.getSkid());
			setSkjlxx.setQyid(qyryskjl.getQyid());
			if("0".equals(qyryskjl.getJczt())){
				setSkjlxx.setJczt("1");
			}else{
				setSkjlxx.setJczt("2");
			}
			setSkjlxx.setQymc(qyryskjl.getQymc());
			setSkjlxx.setQybm(qyryskjl.getQybm());
			setSkjlxx.setGxdwbm(qyryskjl.getGxdwbm());
			setSkjlxx.setGxdwmc(qyryskjl.getGxdwmc());
			setSkjlxx.setRyid(qyryskjl.getRyid());
			skjlxxService.insertSkjxx(setSkjlxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="保存失败";
		}
		this.result="success";
        return "success";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


}
