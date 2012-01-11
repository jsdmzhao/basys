package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bkclkz;
import com.aisino2.basicsystem.service.IBkclkzService;
import com.aisino2.core.test.BaseTestCase;

public class BkclkzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBkclkzService bkclkzService;

	/** @param 布控车辆快照(t_bkclkz) */

	public void test() {
		Bkclkz bkclkz = new Bkclkz();

	/** @ 报警信息ID(bjxxid2) */
	bkclkz.setBjxxid2(0);

	/** @ 布控物品基本信息快照ID(bkwpjbxxkzid) */
	bkclkz.setBkwpjbxxkzid(0);

	/** @ 布控车辆快照ID(bkclkzid) */
	bkclkz.setBkclkzid(0);

	/** @ 车辆类型代码(cllxdm) */
	bkclkz.setCllxdm("test");

	/** @ 车辆类型(cllx) */
	bkclkz.setCllx("test");

	/** @ 车辆品牌(clpp) */
	bkclkz.setClpp("test");

	/** @ 车辆型号(clxh) */
	bkclkz.setClxh("test");

	/** @ 号牌种类代码(hpzldm) */
	bkclkz.setHpzldm("test");

	/** @ 号牌种类(hpzl) */
	bkclkz.setHpzl("test");

	/** @ 号牌号码(hphm) */
	bkclkz.setHphm("test");

	/** @ 车身颜色(csys) */
	bkclkz.setCsys("test");

	/** @ 机动车所有人(syr) */
	bkclkz.setSyr("test");

	/** @ 初次登记时间(ccdjrq) */
	bkclkz.setCcdjrq(new Date());

	/** @ 发动机号(fdjh) */
	bkclkz.setFdjh("test");

	/** @ 车辆识别代号(clsbdh) */
	bkclkz.setClsbdh("test");

	/** @ 车架号(cjh) */
	bkclkz.setCjh("test");

		/*
		//插入对象
		bkclkzService.insertBkclkz(bkclkz);

		//读取对象比较
		BaseObject bo = bkclkzService.getBkclkz(bkclkz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bkclkz bkclkzNew = (Bkclkz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bkclkzNew.getBjxxid2(), bkclkz.getBjxxid2());
		assertEquals(bkclkzNew.getBkwpjbxxkzid(), bkclkz.getBkwpjbxxkzid());
		assertEquals(bkclkzNew.getBkclkzid(), bkclkz.getBkclkzid());
		assertEquals(bkclkzNew.getCllxdm(), bkclkz.getCllxdm());
		assertEquals(bkclkzNew.getCllx(), bkclkz.getCllx());
		assertEquals(bkclkzNew.getClpp(), bkclkz.getClpp());
		assertEquals(bkclkzNew.getClxh(), bkclkz.getClxh());
		assertEquals(bkclkzNew.getHpzldm(), bkclkz.getHpzldm());
		assertEquals(bkclkzNew.getHpzl(), bkclkz.getHpzl());
		assertEquals(bkclkzNew.getHphm(), bkclkz.getHphm());
		assertEquals(bkclkzNew.getCsys(), bkclkz.getCsys());
		assertEquals(bkclkzNew.getSyr(), bkclkz.getSyr());
		assertEquals(bkclkzNew.getCcdjrq(), bkclkz.getCcdjrq());
		assertEquals(bkclkzNew.getFdjh(), bkclkz.getFdjh());
		assertEquals(bkclkzNew.getClsbdh(), bkclkz.getClsbdh());
		assertEquals(bkclkzNew.getCjh(), bkclkz.getCjh());

		//删除对象
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控车辆快照ID(bkclkzid) 
		bkclkz.setBkclkzid(1)

		bkclkzService.deleteBkclkz(bkclkz);

		//修改对象
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控车辆快照ID(bkclkzid) 
		bkclkz.setBkclkzid(1)

		bkclkzService.updateBkclkz(bkclkz);

		//查询单条
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控车辆快照ID(bkclkzid) 
		bkclkz.setBkclkzid(1)

		bkclkzService.getBkclkz(bkclkz);

		//查询多条
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控车辆快照ID(bkclkzid) 
		bkclkz.setBkclkzid(1)

		bkclkzService.getListBkclkz(bkclkz);

		//翻页查询
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkclkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkclkz.setBkwpjbxxkzid(1)
		// @ 布控车辆快照ID(bkclkzid) 
		bkclkz.setBkclkzid(1)

		bkclkzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bkclkzService.insertBkclkz(bkclkz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBkclkzService(IBkclkzService bkclkzService) {
		this.bkclkzService = bkclkzService;
	}
}
