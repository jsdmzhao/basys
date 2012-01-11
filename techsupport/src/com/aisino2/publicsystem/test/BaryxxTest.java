package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Baryxx;
import com.aisino2.publicsystem.service.IBaryxxService;

public class BaryxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBaryxxService baryxxService;

	/** @param 保安人员信息(t_baryxx) */

	public void test() {
		Baryxx baryxx = new Baryxx();

	/** @ 企业ID(qyid) */
	baryxx.setQyid(0);

	/** @ 保安人员ID(baryid) */
	baryxx.setBaryid(0);

	/** @ 姓名(xm) */
	baryxx.setXm("test");

	/** @ 性别代码(xbdm) */
	baryxx.setXbdm("test");

	/** @ 性别(xb) */
	baryxx.setXb("test");

	/** @ 出生日期(csrq) */
	baryxx.setCsrq(new Date());

	/** @ 公民身份号码(gmsfhm) */
	baryxx.setGmsfhm("test");

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	baryxx.setHjdxzqhdm("test");

	/** @ 户籍地行政区划(hjdxzqh) */
	baryxx.setHjdxzqh("test");

	/** @ 户籍地详址(hjdxz) */
	baryxx.setHjdxz("test");

	/** @ 保安类型编码(balxbm) */
	baryxx.setBalxbm("test");

	/** @ 保安类型(balx) */
	baryxx.setBalx("test");

	/** @ 发证机关(fzjg) */
	baryxx.setFzjg("test");

	/** @ 上岗日期(sgrq) */
	baryxx.setSgrq(new Date());

	/** @ 离职原因(lzyy) */
	baryxx.setLzyy("test");

	/** @ 离职日期(lzrq) */
	baryxx.setLzrq(new Date());

	/** @ 备注(bz) */
	baryxx.setBz("test");

	/** @ 状态(zt) */
	baryxx.setZt("test");

	/** @ 录入人(lrr) */
	baryxx.setLrr("test");

	/** @ 录入时间(lrsj) */
	baryxx.setLrsj(new Date());

		/*
		//插入对象
		baryxxService.insertBaryxx(baryxx);

		//读取对象比较
		BaseObject bo = baryxxService.getBaryxx(baryxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Baryxx baryxxNew = (Baryxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(baryxxNew.getQyid(), baryxx.getQyid());
		assertEquals(baryxxNew.getBaryid(), baryxx.getBaryid());
		assertEquals(baryxxNew.getXm(), baryxx.getXm());
		assertEquals(baryxxNew.getXbdm(), baryxx.getXbdm());
		assertEquals(baryxxNew.getXb(), baryxx.getXb());
		assertEquals(baryxxNew.getCsrq(), baryxx.getCsrq());
		assertEquals(baryxxNew.getGmsfhm(), baryxx.getGmsfhm());
		assertEquals(baryxxNew.getHjdxzqhdm(), baryxx.getHjdxzqhdm());
		assertEquals(baryxxNew.getHjdxzqh(), baryxx.getHjdxzqh());
		assertEquals(baryxxNew.getHjdxz(), baryxx.getHjdxz());
		assertEquals(baryxxNew.getBalxbm(), baryxx.getBalxbm());
		assertEquals(baryxxNew.getBalx(), baryxx.getBalx());
		assertEquals(baryxxNew.getFzjg(), baryxx.getFzjg());
		assertEquals(baryxxNew.getSgrq(), baryxx.getSgrq());
		assertEquals(baryxxNew.getLzyy(), baryxx.getLzyy());
		assertEquals(baryxxNew.getLzrq(), baryxx.getLzrq());
		assertEquals(baryxxNew.getBz(), baryxx.getBz());
		assertEquals(baryxxNew.getZt(), baryxx.getZt());
		assertEquals(baryxxNew.getLrr(), baryxx.getLrr());
		assertEquals(baryxxNew.getLrsj(), baryxx.getLrsj());

		//删除对象
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 保安人员ID(baryid) 
		baryxx.setBaryid(1)

		baryxxService.deleteBaryxx(baryxx);

		//修改对象
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 保安人员ID(baryid) 
		baryxx.setBaryid(1)

		baryxxService.updateBaryxx(baryxx);

		//查询单条
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 保安人员ID(baryid) 
		baryxx.setBaryid(1)

		baryxxService.getBaryxx(baryxx);

		//查询多条
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 保安人员ID(baryid) 
		baryxx.setBaryid(1)

		baryxxService.getListBaryxx(baryxx);

		//翻页查询
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 企业ID(qyid) 
		baryxx.setQyid(1)
		// @ 保安人员ID(baryid) 
		baryxx.setBaryid(1)

		baryxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		baryxxService.insertBaryxx(baryxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBaryxxService(IBaryxxService baryxxService) {
		this.baryxxService = baryxxService;
	}
}
