package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Ycskqy;
import com.aisino2.icksystem.service.IYcskqyService;

public class YcskqyTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IYcskqyService ycskqyService;

	/** @param 异常刷卡企业(t_ycskqy) */

	public void test() {
		Ycskqy ycskqy = new Ycskqy();

	/** @ 异常刷卡企业ID(ycskqyid) */
	ycskqy.setYcskqyid(0);

	/** @ 异常刷卡日期(ycskrq) */
	ycskqy.setYcskrq(new Date());

	/** @ 地市机关代码(dsjgdm) */
	ycskqy.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	ycskqy.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	ycskqy.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	ycskqy.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	ycskqy.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	ycskqy.setGxdwmc("test");

	/** @ 企业编码(qybm) */
	ycskqy.setQybm("test");

	/** @ 企业名称(qymc) */
	ycskqy.setQymc("test");

	/** @ 营业状态代码(yyztdm) */
	ycskqy.setYyztdm("test");

	/** @ 营业状态名称(yyztmc) */
	ycskqy.setYyztmc("test");

	/** @ 单位负责人姓名(dwfzr) */
	ycskqy.setDwfzr("test");

	/** @ 单位负责人联系方式(dwfzrlxfs) */
	ycskqy.setDwfzrlxfs("test");

		/*
		//插入对象
		ycskqyService.insertYcskqy(ycskqy);

		//读取对象比较
		BaseObject bo = ycskqyService.getYcskqy(ycskqy);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Ycskqy ycskqyNew = (Ycskqy)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ycskqyNew.getYcskqyid(), ycskqy.getYcskqyid());
		assertEquals(ycskqyNew.getYcskrq(), ycskqy.getYcskrq());
		assertEquals(ycskqyNew.getDsjgdm(), ycskqy.getDsjgdm());
		assertEquals(ycskqyNew.getDsjgmc(), ycskqy.getDsjgmc());
		assertEquals(ycskqyNew.getFxjdm(), ycskqy.getFxjdm());
		assertEquals(ycskqyNew.getFxjmc(), ycskqy.getFxjmc());
		assertEquals(ycskqyNew.getGxdwdm(), ycskqy.getGxdwdm());
		assertEquals(ycskqyNew.getGxdwmc(), ycskqy.getGxdwmc());
		assertEquals(ycskqyNew.getQybm(), ycskqy.getQybm());
		assertEquals(ycskqyNew.getQymc(), ycskqy.getQymc());
		assertEquals(ycskqyNew.getYyztdm(), ycskqy.getYyztdm());
		assertEquals(ycskqyNew.getYyztmc(), ycskqy.getYyztmc());
		assertEquals(ycskqyNew.getDwfzr(), ycskqy.getDwfzr());
		assertEquals(ycskqyNew.getDwfzrlxfs(), ycskqy.getDwfzrlxfs());

		//删除对象
		// @ 异常刷卡企业ID(ycskqyid) 
		ycskqy.setYcskqyid(1)

		ycskqyService.deleteYcskqy(ycskqy);

		//修改对象
		// @ 异常刷卡企业ID(ycskqyid) 
		ycskqy.setYcskqyid(1)

		ycskqyService.updateYcskqy(ycskqy);

		//查询单条
		// @ 异常刷卡企业ID(ycskqyid) 
		ycskqy.setYcskqyid(1)

		ycskqyService.getYcskqy(ycskqy);

		//查询多条
		// @ 异常刷卡企业ID(ycskqyid) 
		ycskqy.setYcskqyid(1)

		ycskqyService.getListYcskqy(ycskqy);

		//翻页查询
		// @ 异常刷卡企业ID(ycskqyid) 
		ycskqy.setYcskqyid(1)

		ycskqyService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//ycskqyService.insertYcskqy(ycskqy);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setYcskqyService(IYcskqyService ycskqyService) {
		this.ycskqyService = ycskqyService;
	}
}
