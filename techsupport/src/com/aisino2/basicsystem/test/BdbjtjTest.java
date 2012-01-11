package com.aisino2.basicsystem.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import com.aisino2.basicsystem.domain.Bdbjtj;
import com.aisino2.basicsystem.service.IBdbjtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.test.BaseTestCase;


public class BdbjtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBdbjtjService bdbjtjService;

	/** @param 比对报警统计表(t_bdbjtj) */
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
	public void test() {
		Bdbjtj bdbjtj = new Bdbjtj();
		PropertyConfigurator.configure(BdbjtjTest.class.getClassLoader().getResource("log4j.properties"));  
		bdbjtjService = (IBdbjtjService)this.applicationContext.getBean("bdbjtjService");
	/** @ 比对报警统计ID(bdbjtjid) */
	bdbjtj.setBdbjtjid(0);

	/** @ 行业类别代码(hylbdm) */
	bdbjtj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	bdbjtj.setHylb("test");

	/** @ 统计日期(tjrq) */
	bdbjtj.setTjrq(new Date());

	/** @ 地市机关代码(dsjgdm) */
	bdbjtj.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	bdbjtj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	bdbjtj.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	bdbjtj.setFxjmc("test");

	/** @ 管辖单位名称(gxdwmc) */
	bdbjtj.setGxdwmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	bdbjtj.setGxdwdm("test");

	/** @ 场所编码(csbm) */
	bdbjtj.setCsbm("test");

	/** @ 场所名称(csmc) */
	bdbjtj.setCsmc("test");

	/** @ 车辆报警次数(clbjcs) */
	bdbjtj.setClbjcs(0);

	/** @ 从业人员报警次数(cyrybjcs) */
	bdbjtj.setCyrybjcs(0);

	/** @ 涉车人员报警次数(scrybjcs) */
	bdbjtj.setScrybjcs(0);

	/** @ 可疑车辆报警次数(kyclbjcs) */
	bdbjtj.setKyclbjcs(0);

		/*
		//插入对象
		bdbjtjService.insertBdbjtj(bdbjtj);

		//读取对象比较
		BaseObject bo = bdbjtjService.getBdbjtj(bdbjtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bdbjtj bdbjtjNew = (Bdbjtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bdbjtjNew.getBdbjtjid(), bdbjtj.getBdbjtjid());
		assertEquals(bdbjtjNew.getHylbdm(), bdbjtj.getHylbdm());
		assertEquals(bdbjtjNew.getHylb(), bdbjtj.getHylb());
		assertEquals(bdbjtjNew.getTjrq(), bdbjtj.getTjrq());
		assertEquals(bdbjtjNew.getDsjgdm(), bdbjtj.getDsjgdm());
		assertEquals(bdbjtjNew.getDsjgmc(), bdbjtj.getDsjgmc());
		assertEquals(bdbjtjNew.getFxjdm(), bdbjtj.getFxjdm());
		assertEquals(bdbjtjNew.getFxjmc(), bdbjtj.getFxjmc());
		assertEquals(bdbjtjNew.getGxdwmc(), bdbjtj.getGxdwmc());
		assertEquals(bdbjtjNew.getGxdwdm(), bdbjtj.getGxdwdm());
		assertEquals(bdbjtjNew.getCsbm(), bdbjtj.getCsbm());
		assertEquals(bdbjtjNew.getCsmc(), bdbjtj.getCsmc());
		assertEquals(bdbjtjNew.getClbjcs(), bdbjtj.getClbjcs());
		assertEquals(bdbjtjNew.getCyrybjcs(), bdbjtj.getCyrybjcs());
		assertEquals(bdbjtjNew.getScrybjcs(), bdbjtj.getScrybjcs());
		assertEquals(bdbjtjNew.getKyclbjcs(), bdbjtj.getKyclbjcs());

		//删除对象
		// @ 比对报警统计ID(bdbjtjid) 
		bdbjtj.setBdbjtjid(1)

		bdbjtjService.deleteBdbjtj(bdbjtj);

		//修改对象
		// @ 比对报警统计ID(bdbjtjid) 
		bdbjtj.setBdbjtjid(1)

		bdbjtjService.updateBdbjtj(bdbjtj);

		//查询单条
		// @ 比对报警统计ID(bdbjtjid) 
		bdbjtj.setBdbjtjid(1)

		bdbjtjService.getBdbjtj(bdbjtj);

		//查询多条
		// @ 比对报警统计ID(bdbjtjid) 
		bdbjtj.setBdbjtjid(1)

		bdbjtjService.getListBdbjtj(bdbjtj);

		//翻页查询
		// @ 比对报警统计ID(bdbjtjid) 
		bdbjtj.setBdbjtjid(1)

		bdbjtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//bdbjtjService.insertBdbjtj(bdbjtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		//this.setComplete();
	
	Map map = new HashMap();
	
	
	map.put("dsjgbz", "1");
	map.put("fxjbz", "2");
	map.put("gxdwbz","2");
	
	//map.put("csbm", "1");
	
	//Page page =sjwsbqyService.getListForPage(map,1,20,null,"desc");
	Page page =bdbjtjService.getListForPage(map,1,20,null,"desc");
	System.out.println(page.getData().size());
	}

	public void setBdbjtjService(IBdbjtjService bdbjtjService) {
		this.bdbjtjService = bdbjtjService;
	}
}
