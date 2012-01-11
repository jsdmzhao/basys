package com.aisino2.publicsystem.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.publicsystem.domain.Qyrygzrz;
import com.aisino2.publicsystem.service.IQyrygzrzService;

public class QyrygzrzTest extends AbstractTransactionalDataSourceSpringContextTests {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyrygzrzService qyrygzrzService;
	
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

	/** @param 企业人员工作日志(t_qyrygzrz) */

	public void test() {
		Qyrygzrz qyrygzrz = new Qyrygzrz();

	/** @ 企业ID(qyid) */
	qyrygzrz.setQyid(0);

	/** @ 从业人员ID(ryid) */
	qyrygzrz.setRyid(0);

	/** @ 企业人员工作日志ID(qyrygzrzid) */
	qyrygzrz.setQyrygzrzid(0);

	/** @ 工作开始时间(gzkssj) */
	qyrygzrz.setGzkssj(new Date());

	/** @ 工作结束时间(gzjssj) */
	qyrygzrz.setGzjssj(new Date());

	/** @ 工作地点(gzdd) */
	qyrygzrz.setGzdd("test");

	/** @ 岗位信息(gwxx) */
	qyrygzrz.setGwxx("test");
	
	qyrygzrzService = (IQyrygzrzService)this.applicationContext.getBean("qyrygzrzService");

		/*
		//插入对象
		qyrygzrzService.insertQyrygzrz(qyrygzrz);

		//读取对象比较
		BaseObject bo = qyrygzrzService.getQyrygzrz(qyrygzrz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyrygzrz qyrygzrzNew = (Qyrygzrz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyrygzrzNew.getQyid(), qyrygzrz.getQyid());
		assertEquals(qyrygzrzNew.getRyid(), qyrygzrz.getRyid());
		assertEquals(qyrygzrzNew.getQyrygzrzid(), qyrygzrz.getQyrygzrzid());
		assertEquals(qyrygzrzNew.getGzkssj(), qyrygzrz.getGzkssj());
		assertEquals(qyrygzrzNew.getGzjssj(), qyrygzrz.getGzjssj());
		assertEquals(qyrygzrzNew.getGzdd(), qyrygzrz.getGzdd());
		assertEquals(qyrygzrzNew.getGwxx(), qyrygzrz.getGwxx());

		//删除对象
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 企业人员工作日志ID(qyrygzrzid) 
		qyrygzrz.setQyrygzrzid(1)

		qyrygzrzService.deleteQyrygzrz(qyrygzrz);

		//修改对象
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 企业人员工作日志ID(qyrygzrzid) 
		qyrygzrz.setQyrygzrzid(1)

		qyrygzrzService.updateQyrygzrz(qyrygzrz);

		//查询单条
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 企业人员工作日志ID(qyrygzrzid) 
		qyrygzrz.setQyrygzrzid(1)

		qyrygzrzService.getQyrygzrz(qyrygzrz);

		//查询多条
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 企业人员工作日志ID(qyrygzrzid) 
		qyrygzrz.setQyrygzrzid(1)

		qyrygzrzService.getListQyrygzrz(qyrygzrz);

		//翻页查询
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 企业ID(qyid) 
		qyrygzrz.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyrygzrz.setRyid(1)
		// @ 企业人员工作日志ID(qyrygzrzid) 
		qyrygzrz.setQyrygzrzid(1)

		qyrygzrzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/
	
	Map map = new HashMap();
	//map.put("hylbdm", "J");
	//map.put("hylbdm", "J");
	qyrygzrzService.getListForPage(map, 1, 10, "0", "desc");
	qyrygzrzService.getListForPageGad(map, 1, 10, "0", "desc");

		//插入对象
		//qyrygzrzService.insertQyrygzrz(qyrygzrz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyrygzrzService(IQyrygzrzService qyrygzrzService) {
		this.qyrygzrzService = qyrygzrzService;
	}
}
