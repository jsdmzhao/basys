package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Khxx;
import com.aisino2.publicsystem.domain.Wgkhxx;
import com.aisino2.publicsystem.service.IKhxxService;

public class KhxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IKhxxService khxxService;
	
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/publicsystem-service.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		
		this.setAutowireMode(0);
		return paths;
	}

	/** @param 客户信息表(t_khxx) */

	public void test() {
		Khxx khxx = new Khxx();
		Wgkhxx wgkhxx = new Wgkhxx();

	/** @ 客户信息ID(khxxid) */
	khxx.setKhxxid(2);

	/** @ 姓名(xm) */
	khxx.setXm("test");

	/** @ 联系电话(lxdh) */
	khxx.setLxdh("test");

	/** @ 民族代码(mzdm) */
	khxx.setMzdm("01");

	/** @ 民族(minzu) */
	khxx.setMinzu("汉族");

	/** @ 性别代码(xbdm) */
	khxx.setXbdm("01");

	/** @ 性别(xb) */
	khxx.setXb("男");
	khxx.setGjdm("01");
	khxx.setGj("中国");

	/** @ 户籍地详址(hjdxz) */
	khxx.setHjdxz("test");

	/** @ 常用证件代码(cyzjdm) */
	khxx.setCyzjdm("01");

	/** @ 常用证件(cyzj) */
	khxx.setCyzj("护照");

	/** @ 证件号码(zjhm) */
	khxx.setZjhm("1111111");

	/** @ 比对标志(biduiflag) */
	khxx.setBiduiflag("0");

	/** @ 状态(zt) */
	//khxx.setZt("0");

	
	wgkhxx.setYwx("test");
	wgkhxx.setYwm("22");
	wgkhxx.setQzzldm("02");
	wgkhxx.setQzzl("测试护照");
	wgkhxx.setQzhm("1111");
	
	khxxService = (IKhxxService) this.applicationContext.getBean("khxxService");
	
	khxx = null;
	khxx = new Khxx();
	khxx.setZjhm("测试签证号码一");
	khxx.setGjdm("1");
	khxx = khxxService.getLatestKhxx(khxx);
	System.out.println("====");
	
	//khxx.setWgkhxx(wgkhxx);
		/*
		//插入对象
		khxxService.insertKhxx(khxx);

		//读取对象比较
		BaseObject bo = khxxService.getKhxx(khxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Khxx khxxNew = (Khxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(khxxNew.getKhxxid(), khxx.getKhxxid());
		assertEquals(khxxNew.getXm(), khxx.getXm());
		assertEquals(khxxNew.getLxdh(), khxx.getLxdh());
		assertEquals(khxxNew.getMzdm(), khxx.getMzdm());
		assertEquals(khxxNew.getMinzu(), khxx.getMinzu());
		assertEquals(khxxNew.getXbdm(), khxx.getXbdm());
		assertEquals(khxxNew.getXb(), khxx.getXb());
		assertEquals(khxxNew.getHjdxz(), khxx.getHjdxz());
		assertEquals(khxxNew.getCyzjdm(), khxx.getCyzjdm());
		assertEquals(khxxNew.getCyzj(), khxx.getCyzj());
		assertEquals(khxxNew.getZjhm(), khxx.getZjhm());
		assertEquals(khxxNew.getBiduiflag(), khxx.getBiduiflag());
		assertEquals(khxxNew.getZt(), khxx.getZt());

		//删除对象
		// @ 客户信息ID(khxxid) 
		khxx.setKhxxid(1)

		khxxService.deleteKhxx(khxx);

		//修改对象
		// @ 客户信息ID(khxxid) 
		khxx.setKhxxid(1)

		khxxService.updateKhxx(khxx);

		//查询单条
		// @ 客户信息ID(khxxid) 
		khxx.setKhxxid(1)

		khxxService.getKhxx(khxx);

		//查询多条
		// @ 客户信息ID(khxxid) 
		khxx.setKhxxid(1)

		khxxService.getListKhxx(khxx);

		//翻页查询
		// @ 客户信息ID(khxxid) 
		khxx.setKhxxid(1)

		khxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//khxxService.insertKhxx(khxx);
	//khxxService.updateKhxx(khxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setKhxxService(IKhxxService khxxService) {
		this.khxxService = khxxService;
	}
}
