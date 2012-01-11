package com.aisino2.basicsystem.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import com.aisino2.basicsystem.domain.Qycftj;
import com.aisino2.basicsystem.service.IQycftjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.test.BaseTestCase;


public class QycftjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQycftjService qycftjService;
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/jxyzagl-service.xml",
				"/config/spring/jxyzagl-dao.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		this.setAutowireMode(0);
		return paths;
	}
	/** @param 企业处罚统计表(t_qycftj) */

	public void test() {
		Qycftj qycftj = new Qycftj();
PropertyConfigurator.configure(QycftjTest.class.getClassLoader().getResource("log4j.properties"));  
		
qycftjService = (IQycftjService)this.applicationContext.getBean("qycftjService");

	/** @ 企业处罚统计ID(qycftjid) */
	qycftj.setQycftjid(0);

	/** @ 行业类别代码(hylbdm) */
	qycftj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qycftj.setHylb("test");

	/** @ 统计日期(tjrq) */
	qycftj.setTjrq(new Date());

	/** @ 地市机关代码(dsjgdm) */
	qycftj.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	qycftj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	qycftj.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	qycftj.setFxjmc("test");

	/** @ 管辖单位名称(gxdwmc) */
	qycftj.setGxdwmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	qycftj.setGxdwdm("test");

	/** @ 场所编码(csbm) */
	qycftj.setCsbm("test");

	/** @ 场所名称(csmc) */
	qycftj.setCsmc("test");

	/** @ 警告次数(jgcs) */
	qycftj.setJgcs(0);

	/** @ 罚没次数(fmcs) */
	qycftj.setFmcs(0);

	/** @ 停吊次数(tdcs) */
	qycftj.setTdcs(0);

	/** @ 追究次数(zjcs) */
	qycftj.setZjcs(0);

	/** @ 其他处罚次数(qtfmcs) */
	qycftj.setQtfmcs(0);

		/*
		//插入对象
		qycftjService.insertQycftj(qycftj);

		//读取对象比较
		BaseObject bo = qycftjService.getQycftj(qycftj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qycftj qycftjNew = (Qycftj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qycftjNew.getQycftjid(), qycftj.getQycftjid());
		assertEquals(qycftjNew.getHylbdm(), qycftj.getHylbdm());
		assertEquals(qycftjNew.getHylb(), qycftj.getHylb());
		assertEquals(qycftjNew.getTjrq(), qycftj.getTjrq());
		assertEquals(qycftjNew.getDsjgdm(), qycftj.getDsjgdm());
		assertEquals(qycftjNew.getDsjgmc(), qycftj.getDsjgmc());
		assertEquals(qycftjNew.getFxjdm(), qycftj.getFxjdm());
		assertEquals(qycftjNew.getFxjmc(), qycftj.getFxjmc());
		assertEquals(qycftjNew.getGxdwmc(), qycftj.getGxdwmc());
		assertEquals(qycftjNew.getGxdwdm(), qycftj.getGxdwdm());
		assertEquals(qycftjNew.getCsbm(), qycftj.getCsbm());
		assertEquals(qycftjNew.getCsmc(), qycftj.getCsmc());
		assertEquals(qycftjNew.getJgcs(), qycftj.getJgcs());
		assertEquals(qycftjNew.getFmcs(), qycftj.getFmcs());
		assertEquals(qycftjNew.getTdcs(), qycftj.getTdcs());
		assertEquals(qycftjNew.getZjcs(), qycftj.getZjcs());
		assertEquals(qycftjNew.getQtfmcs(), qycftj.getQtfmcs());

		//删除对象
		// @ 企业处罚统计ID(qycftjid) 
		qycftj.setQycftjid(1)

		qycftjService.deleteQycftj(qycftj);

		//修改对象
		// @ 企业处罚统计ID(qycftjid) 
		qycftj.setQycftjid(1)

		qycftjService.updateQycftj(qycftj);

		//查询单条
		// @ 企业处罚统计ID(qycftjid) 
		qycftj.setQycftjid(1)

		qycftjService.getQycftj(qycftj);

		//查询多条
		// @ 企业处罚统计ID(qycftjid) 
		qycftj.setQycftjid(1)

		qycftjService.getListQycftj(qycftj);

		//翻页查询
		// @ 企业处罚统计ID(qycftjid) 
		qycftj.setQycftjid(1)

		qycftjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//qycftjService.insertQycftj(qycftj);
		//保存到数据库，如不想保存到数据库，可注释此句

	Map map = new HashMap();
	
	
	map.put("dsjgbz", "2");
	map.put("fxjbz", "2");
	map.put("gxdwbz","1");
	
//	map.put("csbm", "1");
	
	//Page page =sjwsbqyService.getListForPage(map,1,20,null,"desc");
	Page page =qycftjService.getListForPage(map,1,20,null,"desc");
	System.out.println(page.getData().size());
	}

	public void setQycftjService(IQycftjService qycftjService) {
		this.qycftjService = qycftjService;
	}
}
