package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Clxxwgryxx;
import com.aisino2.publicsystem.service.IClxxwgryxxService;

public class ClxxwgryxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IClxxwgryxxService clxxwgryxxService;

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) */

	public void test() {
		Clxxwgryxx clxxwgryxx = new Clxxwgryxx();

	/** @ 车辆基本信息ID(cljbxxid) */
	clxxwgryxx.setCljbxxid(0);

	/** @ 外国人信息ID(wgrxxid) */
	clxxwgryxx.setWgrxxid(0);

	/** @ 外国人员类别(wgrylb) */
	clxxwgryxx.setWgrylb("test");

	/** @ 英文姓(ywx) */
	clxxwgryxx.setYwx("test");

	/** @ 英文名(ywm) */
	clxxwgryxx.setYwm("test");

	/** @ 签证种类代码(qzzldm) */
	clxxwgryxx.setQzzldm("test");

	/** @ 签证种类(qzzl) */
	clxxwgryxx.setQzzl("test");

	/** @ 签证号码(qzhm) */
	clxxwgryxx.setQzhm("test");

	/** @ 在华停留期至(zatlq) */
	clxxwgryxx.setZatlq(new Date());

	/** @ 签发机关(qfjg) */
	clxxwgryxx.setQfjg("test");

	/** @ 入境日期(rjrq) */
	clxxwgryxx.setRjrq(new Date());

	/** @ 入境口岸(rjka) */
	clxxwgryxx.setRjka("test");

		/*
		//插入对象
		clxxwgryxxService.insertClxxwgryxx(clxxwgryxx);

		//读取对象比较
		BaseObject bo = clxxwgryxxService.getClxxwgryxx(clxxwgryxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Clxxwgryxx clxxwgryxxNew = (Clxxwgryxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(clxxwgryxxNew.getCljbxxid(), clxxwgryxx.getCljbxxid());
		assertEquals(clxxwgryxxNew.getWgrxxid(), clxxwgryxx.getWgrxxid());
		assertEquals(clxxwgryxxNew.getWgrylb(), clxxwgryxx.getWgrylb());
		assertEquals(clxxwgryxxNew.getYwx(), clxxwgryxx.getYwx());
		assertEquals(clxxwgryxxNew.getYwm(), clxxwgryxx.getYwm());
		assertEquals(clxxwgryxxNew.getQzzldm(), clxxwgryxx.getQzzldm());
		assertEquals(clxxwgryxxNew.getQzzl(), clxxwgryxx.getQzzl());
		assertEquals(clxxwgryxxNew.getQzhm(), clxxwgryxx.getQzhm());
		assertEquals(clxxwgryxxNew.getZatlq(), clxxwgryxx.getZatlq());
		assertEquals(clxxwgryxxNew.getQfjg(), clxxwgryxx.getQfjg());
		assertEquals(clxxwgryxxNew.getRjrq(), clxxwgryxx.getRjrq());
		assertEquals(clxxwgryxxNew.getRjka(), clxxwgryxx.getRjka());

		//删除对象
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 外国人信息ID(wgrxxid) 
		clxxwgryxx.setWgrxxid(1)

		clxxwgryxxService.deleteClxxwgryxx(clxxwgryxx);

		//修改对象
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 外国人信息ID(wgrxxid) 
		clxxwgryxx.setWgrxxid(1)

		clxxwgryxxService.updateClxxwgryxx(clxxwgryxx);

		//查询单条
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 外国人信息ID(wgrxxid) 
		clxxwgryxx.setWgrxxid(1)

		clxxwgryxxService.getClxxwgryxx(clxxwgryxx);

		//查询多条
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 外国人信息ID(wgrxxid) 
		clxxwgryxx.setWgrxxid(1)

		clxxwgryxxService.getListClxxwgryxx(clxxwgryxx);

		//翻页查询
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 车辆基本信息ID(cljbxxid) 
		clxxwgryxx.setCljbxxid(1)
		// @ 外国人信息ID(wgrxxid) 
		clxxwgryxx.setWgrxxid(1)

		clxxwgryxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		clxxwgryxxService.insertClxxwgryxx(clxxwgryxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setClxxwgryxxService(IClxxwgryxxService clxxwgryxxService) {
		this.clxxwgryxxService = clxxwgryxxService;
	}
}
