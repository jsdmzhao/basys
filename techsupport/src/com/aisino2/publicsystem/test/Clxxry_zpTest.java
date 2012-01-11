package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Clxxry_zp;
import com.aisino2.publicsystem.service.IClxxry_zpService;

public class Clxxry_zpTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IClxxry_zpService clxxry_zpService;

	/** @param 车辆信息人员_照片(t_clxxry_zp) */
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
		return paths;
	}
	
	public void test() {
		Clxxry_zp clxxry_zp = new Clxxry_zp();

	/** @ 车辆基本信息ID(cljbxxid) */
	clxxry_zp.setCljbxxid(0);

	/** @ 车辆信息人员照片ID(clxxryzpid) */
	clxxry_zp.setClxxryzpid(0);

	/** @ 图片名称(tpmc) */
	clxxry_zp.setTpmc("test");

	/** @ 图片类型(tplx) */
	clxxry_zp.setTplx("test");

	/** @ 图片内容(tpnr) */
	clxxry_zp.setTpnr(null);

		/*
		//插入对象
		clxxry_zpService.insertClxxry_zp(clxxry_zp);

		//读取对象比较
		BaseObject bo = clxxry_zpService.getClxxry_zp(clxxry_zp);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Clxxry_zp clxxry_zpNew = (Clxxry_zp)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(clxxry_zpNew.getCljbxxid(), clxxry_zp.getCljbxxid());
		assertEquals(clxxry_zpNew.getClxxryzpid(), clxxry_zp.getClxxryzpid());
		assertEquals(clxxry_zpNew.getTpmc(), clxxry_zp.getTpmc());
		assertEquals(clxxry_zpNew.getTplx(), clxxry_zp.getTplx());
		assertEquals(clxxry_zpNew.getTpnr(), clxxry_zp.getTpnr());

		//删除对象
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆信息人员照片ID(clxxryzpid) 
		clxxry_zp.setClxxryzpid(1)

		clxxry_zpService.deleteClxxry_zp(clxxry_zp);

		//修改对象
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆信息人员照片ID(clxxryzpid) 
		clxxry_zp.setClxxryzpid(1)

		clxxry_zpService.updateClxxry_zp(clxxry_zp);

		//查询单条
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆信息人员照片ID(clxxryzpid) 
		clxxry_zp.setClxxryzpid(1)

		clxxry_zpService.getClxxry_zp(clxxry_zp);

		//查询多条
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆信息人员照片ID(clxxryzpid) 
		clxxry_zp.setClxxryzpid(1)

		clxxry_zpService.getListClxxry_zp(clxxry_zp);

		//翻页查询
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxry_zp.setCljbxxid(1)
		// @ 车辆信息人员照片ID(clxxryzpid) 
		clxxry_zp.setClxxryzpid(1)

		clxxry_zpService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
	clxxry_zp = new Clxxry_zp();

	/** @ 车辆基本信息ID(cljbxxid) */
	clxxry_zp.setCljbxxid(1);

	/** @ 车辆信息人员照片ID(clxxryzpid) */
	clxxry_zp.setClxxryzpid(1);
	clxxry_zpService.deleteClxxry_zp(clxxry_zp);
		//clxxry_zpService.insertClxxry_zp(clxxry_zp);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setClxxry_zpService(IClxxry_zpService clxxry_zpService) {
		this.clxxry_zpService = clxxry_zpService;
	}
}
