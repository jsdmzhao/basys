package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bkcl;
import com.aisino2.basicsystem.service.IBkclService;
import com.aisino2.core.test.BaseTestCase;

public class BkclTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBkclService bkclService;

	/** @param 布控车辆(t_bkcl) */

	public void test() {
		Bkcl bkcl = new Bkcl();

	/** @ 布控物品基本信息ID(bkwpjbxxid) */
	bkcl.setBkwpjbxxid(0);

	/** @ 布控车辆ID(bkclid) */
	bkcl.setBkclid(0);

	/** @ 车辆类型代码(cllxdm) */
	bkcl.setCllxdm("test");

	/** @ 车辆类型(cllx) */
	bkcl.setCllx("test");

	/** @ 车辆品牌(clpp) */
	bkcl.setClpp("test");

	/** @ 车辆型号(clxh) */
	bkcl.setClxh("test");

	/** @ 号牌种类代码(hpzldm) */
	bkcl.setHpzldm("test");

	/** @ 号牌种类(hpzl) */
	bkcl.setHpzl("test");

	/** @ 号牌号码(hphm) */
	bkcl.setHphm("test");

	/** @ 车身颜色(csys) */
	bkcl.setCsys("test");

	/** @ 机动车所有人(syr) */
	bkcl.setSyr("test");

	/** @ 初次登记时间(ccdjrq) */
	bkcl.setCcdjrq(new Date());

	/** @ 发动机号(fdjh) */
	bkcl.setFdjh("test");

	/** @ 车辆识别代号(clsbdh) */
	bkcl.setClsbdh("test");

	/** @ 车架号(cjh) */
	bkcl.setCjh("test");

		/*
		//插入对象
		bkclService.insertBkcl(bkcl);

		//读取对象比较
		BaseObject bo = bkclService.getBkcl(bkcl);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bkcl bkclNew = (Bkcl)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bkclNew.getBkwpjbxxid(), bkcl.getBkwpjbxxid());
		assertEquals(bkclNew.getBkclid(), bkcl.getBkclid());
		assertEquals(bkclNew.getCllxdm(), bkcl.getCllxdm());
		assertEquals(bkclNew.getCllx(), bkcl.getCllx());
		assertEquals(bkclNew.getClpp(), bkcl.getClpp());
		assertEquals(bkclNew.getClxh(), bkcl.getClxh());
		assertEquals(bkclNew.getHpzldm(), bkcl.getHpzldm());
		assertEquals(bkclNew.getHpzl(), bkcl.getHpzl());
		assertEquals(bkclNew.getHphm(), bkcl.getHphm());
		assertEquals(bkclNew.getCsys(), bkcl.getCsys());
		assertEquals(bkclNew.getSyr(), bkcl.getSyr());
		assertEquals(bkclNew.getCcdjrq(), bkcl.getCcdjrq());
		assertEquals(bkclNew.getFdjh(), bkcl.getFdjh());
		assertEquals(bkclNew.getClsbdh(), bkcl.getClsbdh());
		assertEquals(bkclNew.getCjh(), bkcl.getCjh());

		//删除对象
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控车辆ID(bkclid) 
		bkcl.setBkclid(1)

		bkclService.deleteBkcl(bkcl);

		//修改对象
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控车辆ID(bkclid) 
		bkcl.setBkclid(1)

		bkclService.updateBkcl(bkcl);

		//查询单条
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控车辆ID(bkclid) 
		bkcl.setBkclid(1)

		bkclService.getBkcl(bkcl);

		//查询多条
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控车辆ID(bkclid) 
		bkcl.setBkclid(1)

		bkclService.getListBkcl(bkcl);

		//翻页查询
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkcl.setBkwpjbxxid(1)
		// @ 布控车辆ID(bkclid) 
		bkcl.setBkclid(1)

		bkclService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bkclService.insertBkcl(bkcl);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBkclService(IBkclService bkclService) {
		this.bkclService = bkclService;
	}
}
