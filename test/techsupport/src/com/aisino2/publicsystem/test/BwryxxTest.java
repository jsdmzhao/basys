package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Bwryxx;
import com.aisino2.publicsystem.service.IBwryxxService;

public class BwryxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBwryxxService bwryxxService;

	/** @param 保卫人员信息(t_bwryxx) */

	public void test() {
		Bwryxx bwryxx = new Bwryxx();

	/** @ 企业ID(qyid) */
	bwryxx.setQyid(0);

	/** @ 保卫人员ID(bwryid) */
	bwryxx.setBwryid(0);

	/** @ 姓名(xm) */
	bwryxx.setXm("test");

	/** @ 出生日期(csrq) */
	bwryxx.setCsrq(new Date());

	/** @ 性别代码(xbdm) */
	bwryxx.setXbdm("test");

	/** @ 性别(xb) */
	bwryxx.setXb("test");

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	bwryxx.setHjdxzqhdm("test");

	/** @ 户籍地行政区划(hjdxzqh) */
	bwryxx.setHjdxzqh("test");

	/** @ 户籍地详址(hjdxz) */
	bwryxx.setHjdxz("test");

	/** @ 公民身份号码(gmsfhm) */
	bwryxx.setGmsfhm("test");

	/** @ 上岗日期(sgrq) */
	bwryxx.setSgrq(new Date());

	/** @ 离职原因(lzyy) */
	bwryxx.setLzyy("test");

	/** @ 离职日期(lzrq) */
	bwryxx.setLzrq(new Date());

	/** @ 备注(bz) */
	bwryxx.setBz("test");

	/** @ 状态(zt) */
	bwryxx.setZt("test");

	/** @ 录入人(lrr) */
	bwryxx.setLrr("test");

	/** @ 录入时间(lrsj) */
	bwryxx.setLrsj(new Date());

		/*
		//插入对象
		bwryxxService.insertBwryxx(bwryxx);

		//读取对象比较
		BaseObject bo = bwryxxService.getBwryxx(bwryxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bwryxx bwryxxNew = (Bwryxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bwryxxNew.getQyid(), bwryxx.getQyid());
		assertEquals(bwryxxNew.getBwryid(), bwryxx.getBwryid());
		assertEquals(bwryxxNew.getXm(), bwryxx.getXm());
		assertEquals(bwryxxNew.getCsrq(), bwryxx.getCsrq());
		assertEquals(bwryxxNew.getXbdm(), bwryxx.getXbdm());
		assertEquals(bwryxxNew.getXb(), bwryxx.getXb());
		assertEquals(bwryxxNew.getHjdxzqhdm(), bwryxx.getHjdxzqhdm());
		assertEquals(bwryxxNew.getHjdxzqh(), bwryxx.getHjdxzqh());
		assertEquals(bwryxxNew.getHjdxz(), bwryxx.getHjdxz());
		assertEquals(bwryxxNew.getGmsfhm(), bwryxx.getGmsfhm());
		assertEquals(bwryxxNew.getSgrq(), bwryxx.getSgrq());
		assertEquals(bwryxxNew.getLzyy(), bwryxx.getLzyy());
		assertEquals(bwryxxNew.getLzrq(), bwryxx.getLzrq());
		assertEquals(bwryxxNew.getBz(), bwryxx.getBz());
		assertEquals(bwryxxNew.getZt(), bwryxx.getZt());
		assertEquals(bwryxxNew.getLrr(), bwryxx.getLrr());
		assertEquals(bwryxxNew.getLrsj(), bwryxx.getLrsj());

		//删除对象
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 保卫人员ID(bwryid) 
		bwryxx.setBwryid(1)

		bwryxxService.deleteBwryxx(bwryxx);

		//修改对象
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 保卫人员ID(bwryid) 
		bwryxx.setBwryid(1)

		bwryxxService.updateBwryxx(bwryxx);

		//查询单条
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 保卫人员ID(bwryid) 
		bwryxx.setBwryid(1)

		bwryxxService.getBwryxx(bwryxx);

		//查询多条
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 保卫人员ID(bwryid) 
		bwryxx.setBwryid(1)

		bwryxxService.getListBwryxx(bwryxx);

		//翻页查询
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 企业ID(qyid) 
		bwryxx.setQyid(1)
		// @ 保卫人员ID(bwryid) 
		bwryxx.setBwryid(1)

		bwryxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bwryxxService.insertBwryxx(bwryxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBwryxxService(IBwryxxService bwryxxService) {
		this.bwryxxService = bwryxxService;
	}
}
