package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Clxx_zp;
import com.aisino2.publicsystem.service.IClxx_zpService;

public class Clxx_zpTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IClxx_zpService clxx_zpService;

	/** @param 车辆信息_照片(t_clxx_zp) */
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
		Clxx_zp clxx_zp = new Clxx_zp();

	/** @ 车辆基本信息ID(cljbxxid) */
	clxx_zp.setCljbxxid(0);

	/** @ 车辆信息照片ID(clxxzpid) */
	clxx_zp.setClxxzpid(0);

	/** @ 图片名称(tpmc) */
	clxx_zp.setTpmc("test");

	/** @ 图片类型(tplx) */
	clxx_zp.setTplx("test");

	/** @ 图片内容(tpnr) */
	clxx_zp.setTpnr(null);

		/*
		//插入对象
		clxx_zpService.insertClxx_zp(clxx_zp);

		//读取对象比较
		BaseObject bo = clxx_zpService.getClxx_zp(clxx_zp);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Clxx_zp clxx_zpNew = (Clxx_zp)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(clxx_zpNew.getCljbxxid(), clxx_zp.getCljbxxid());
		assertEquals(clxx_zpNew.getClxxzpid(), clxx_zp.getClxxzpid());
		assertEquals(clxx_zpNew.getTpmc(), clxx_zp.getTpmc());
		assertEquals(clxx_zpNew.getTplx(), clxx_zp.getTplx());
		assertEquals(clxx_zpNew.getTpnr(), clxx_zp.getTpnr());

		//删除对象
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆信息照片ID(clxxzpid) 
		clxx_zp.setClxxzpid(1)

		clxx_zpService.deleteClxx_zp(clxx_zp);

		//修改对象
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆信息照片ID(clxxzpid) 
		clxx_zp.setClxxzpid(1)

		clxx_zpService.updateClxx_zp(clxx_zp);

		//查询单条
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆信息照片ID(clxxzpid) 
		clxx_zp.setClxxzpid(1)

		clxx_zpService.getClxx_zp(clxx_zp);

		//查询多条
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆信息照片ID(clxxzpid) 
		clxx_zp.setClxxzpid(1)

		clxx_zpService.getListClxx_zp(clxx_zp);

		//翻页查询
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxx_zp.setCljbxxid(1)
		// @ 车辆信息照片ID(clxxzpid) 
		clxx_zp.setClxxzpid(1)

		clxx_zpService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//clxx_zpService.insertClxx_zp(clxx_zp);
	clxx_zp = new Clxx_zp();
	clxx_zp.setClxxzpid(1);
	clxx_zp.setCljbxxid(1);
	clxx_zpService.deleteClxx_zp(clxx_zp);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setClxx_zpService(IClxx_zpService clxx_zpService) {
		this.clxx_zpService = clxx_zpService;
	}
}
