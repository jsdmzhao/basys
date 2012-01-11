package com.aisino2.publicsystem.test;

import java.util.Date;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.publicsystem.domain.Qyyyrz;
import com.aisino2.publicsystem.service.IQyyyrzService;

public class QyyyrzTest extends AbstractTransactionalDataSourceSpringContextTests {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyyyrzService qyyyrzService;
	
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/icksystem-service.xml",
				"/config/spring/icksystem-dao.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/publicsystem-service.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		this.setAutowireMode(0);

		return paths;
	}

	/** @param 企业营业日志(t_qyyyrz) */

	public void test() {
		Qyyyrz qyyyrz = new Qyyyrz();

	/** @ 企业ID(qyid) */
	qyyyrz.setQyid(29);

	/** @ 营业日志ID(yyrzid) */
	qyyyrz.setYyrzid(1);

	/** @ 行业类别代码(hylbdm) */
	qyyyrz.setHylbdm("J");

	/** @ 行业类别(hylb) */
	qyyyrz.setHylb("营业性娱乐场所");

	/** @ 日期(riqi) */
	qyyyrz.setRiqi(new Date());

	/** @ 开始营业时间(ksyysj) */
	qyyyrz.setKsyysj(new Date());

	/** @ 结束营业时间(jsyysj) */
	qyyyrz.setJsyysj(new Date());

	/** @ 场所负责人编号(csfzrbh) */
	qyyyrz.setCsfzrbh("哈哈哈哈");

	/** @ 场所负责人姓名(csfe) */
	qyyyrz.setCsfe("哈哈哈哈");

	/** @ 治安负责人编号(zafzrbh) */
	qyyyrz.setZafzrbh("哈哈哈哈");

	/** @ 治安负责人姓名(zafzrxm) */
	qyyyrz.setZafzrxm("哈哈哈哈");

	/** @ 是否有治安、刑事案件或事故发生(sffsaj) */
	qyyyrz.setSffsaj("0");

	/** @ 是否有管理部门检查(sfglbmjc) */
	qyyyrz.setSfglbmjc("0");

	/** @ 当日营业状况(dryysj) */
	qyyyrz.setDryysj("哈哈哈哈哈哈哈哈哈哈哈哈");
	
	
	qyyyrzService = (IQyyyrzService)this.applicationContext.getBean("qyyyrzService");

		/*
		//插入对象
		qyyyrzService.insertQyyyrz(qyyyrz);

		//读取对象比较
		BaseObject bo = qyyyrzService.getQyyyrz(qyyyrz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyyyrz qyyyrzNew = (Qyyyrz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyyyrzNew.getQyid(), qyyyrz.getQyid());
		assertEquals(qyyyrzNew.getYyrzid(), qyyyrz.getYyrzid());
		assertEquals(qyyyrzNew.getHylbdm(), qyyyrz.getHylbdm());
		assertEquals(qyyyrzNew.getHylb(), qyyyrz.getHylb());
		assertEquals(qyyyrzNew.getRiqi(), qyyyrz.getRiqi());
		assertEquals(qyyyrzNew.getKsyysj(), qyyyrz.getKsyysj());
		assertEquals(qyyyrzNew.getJsyysj(), qyyyrz.getJsyysj());
		assertEquals(qyyyrzNew.getCsfzrbh(), qyyyrz.getCsfzrbh());
		assertEquals(qyyyrzNew.getCsfe(), qyyyrz.getCsfe());
		assertEquals(qyyyrzNew.getZafzrbh(), qyyyrz.getZafzrbh());
		assertEquals(qyyyrzNew.getZafzrxm(), qyyyrz.getZafzrxm());
		assertEquals(qyyyrzNew.getSffsaj(), qyyyrz.getSffsaj());
		assertEquals(qyyyrzNew.getSfglbmjc(), qyyyrz.getSfglbmjc());
		assertEquals(qyyyrzNew.getDryysj(), qyyyrz.getDryysj());

		//删除对象
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrz.setYyrzid(1)

		qyyyrzService.deleteQyyyrz(qyyyrz);

		//修改对象
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrz.setYyrzid(1)

		qyyyrzService.updateQyyyrz(qyyyrz);

		//查询单条
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrz.setYyrzid(1)

		qyyyrzService.getQyyyrz(qyyyrz);

		//查询多条
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrz.setYyrzid(1)

		qyyyrzService.getListQyyyrz(qyyyrz);

		//翻页查询
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrz.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrz.setYyrzid(1)

		qyyyrzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//qyyyrzService.insertQyyyrz(qyyyrz);
	qyyyrzService.updateQyyyrz(qyyyrz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyyyrzService(IQyyyrzService qyyyrzService) {
		this.qyyyrzService = qyyyrzService;
	}
}
