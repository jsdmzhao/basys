package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Ickslbg;
import com.aisino2.icksystem.service.IIckslbgService;

public class IckslbgTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IIckslbgService ickslbgService;

	/** @param IC卡受理变更(t_ickslbg) */

	public void test() {
		Ickslbg ickslbg = new Ickslbg();

	/** @ IC卡受理ID(ickslid) */
	ickslbg.setIckslid(0);

	/** @ IC卡受理变更ID(ickslbgid) */
	ickslbg.setIckslbgid(0);

	/** @ 物流ID(wlid) */
	ickslbg.setWlid(0);

	/** @ 组包ID(zbid) */
	ickslbg.setZbid(0);

	/** @ 卡号(kh) */
	ickslbg.setKh("test");

	/** @ 卡ID号(ickh) */
	ickslbg.setIckh("test");

	/** @ 申领原因(slyy) */
	ickslbg.setSlyy("test");

	/** @ 受理人(slr) */
	ickslbg.setSlr("test");

	/** @ 受理时间(slsj) */
	ickslbg.setSlsj(new Date());

	/** @ 有效期开始日期(yxsksrq) */
	ickslbg.setYxsksrq(new Date());

	/** @ 有效期截至日期(yxqhzrq) */
	ickslbg.setYxqhzrq(new Date());

	/** @ 采集时间(cjsj) */
	ickslbg.setCjsj(new Date());

	/** @ 采集人(cjr) */
	ickslbg.setCjr("test");

	/** @ 采集点编码(cjdbm) */
	ickslbg.setCjdbm("test");

	/** @ 采集点名称(cjdmc) */
	ickslbg.setCjdmc("test");

	/** @ 接收时间(jssj) */
	ickslbg.setJssj(new Date());

	/** @ 接收包名称(jsbmc) */
	ickslbg.setJsbmc("test");

	/** @ 发放人(ffr) */
	ickslbg.setFfr("test");

	/** @ 发放时间(ffsj) */
	ickslbg.setFfsj(new Date());

	/** @ 领取人(lqr) */
	ickslbg.setLqr("test");

	/** @ 领取时间(lqsj) */
	ickslbg.setLqsj(new Date());

	/** @ 领取人证件类型(lqrzjlx) */
	ickslbg.setLqrzjlx("test");

	/** @ 领取人证件号码(lqrzjhm) */
	ickslbg.setLqrzjhm("test");

	/** @ IC卡注销人(ickzxr) */
	ickslbg.setIckzxr("test");

	/** @ IC卡注销时间(ickzxsj) */
	ickslbg.setIckzxsj(new Date());

	/** @ IC卡注销原因(ickzxyy) */
	ickslbg.setIckzxyy("test");

	/** @ 年检人(njr) */
	ickslbg.setNjr("test");

	/** @ 年检时间(njsj) */
	ickslbg.setNjsj(new Date());

	/** @ 制卡状态标识(zkztbs) */
	ickslbg.setZkztbs("test");

	/** @ 是否确认(sfqr) */
	ickslbg.setSfqr("te");

	/** @ 印刷人(ysr) */
	ickslbg.setYsr("test");

	/** @ 印刷时间(yssj) */
	ickslbg.setYssj(new Date());

	/** @ 电写入人(dxrr) */
	ickslbg.setDxrr("test");

	/** @ 电写入时间(dxrsj) */
	ickslbg.setDxrsj(new Date());

	/** @ 重印刷时间(cyssj) */
	ickslbg.setCyssj(new Date());

	/** @ 重印刷原因(cysyy) */
	ickslbg.setCysyy("test");

	/** @ 重电写入时间(cdxrsj) */
	ickslbg.setCdxrsj(new Date());

	/** @ 重电写入原因(cdxryy) */
	ickslbg.setCdxryy("test");

	/** @ 补换卡原因(bhkyy) */
	ickslbg.setBhkyy("test");

	/** @ 原卡是否收回(yksfsh) */
	ickslbg.setYksfsh("te");

		/*
		//插入对象
		ickslbgService.insertIckslbg(ickslbg);

		//读取对象比较
		BaseObject bo = ickslbgService.getIckslbg(ickslbg);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Ickslbg ickslbgNew = (Ickslbg)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ickslbgNew.getIckslid(), ickslbg.getIckslid());
		assertEquals(ickslbgNew.getIckslbgid(), ickslbg.getIckslbgid());
		assertEquals(ickslbgNew.getWlid(), ickslbg.getWlid());
		assertEquals(ickslbgNew.getZbid(), ickslbg.getZbid());
		assertEquals(ickslbgNew.getKh(), ickslbg.getKh());
		assertEquals(ickslbgNew.getIckh(), ickslbg.getIckh());
		assertEquals(ickslbgNew.getSlyy(), ickslbg.getSlyy());
		assertEquals(ickslbgNew.getSlr(), ickslbg.getSlr());
		assertEquals(ickslbgNew.getSlsj(), ickslbg.getSlsj());
		assertEquals(ickslbgNew.getYxsksrq(), ickslbg.getYxsksrq());
		assertEquals(ickslbgNew.getYxqhzrq(), ickslbg.getYxqhzrq());
		assertEquals(ickslbgNew.getCjsj(), ickslbg.getCjsj());
		assertEquals(ickslbgNew.getCjr(), ickslbg.getCjr());
		assertEquals(ickslbgNew.getCjdbm(), ickslbg.getCjdbm());
		assertEquals(ickslbgNew.getCjdmc(), ickslbg.getCjdmc());
		assertEquals(ickslbgNew.getJssj(), ickslbg.getJssj());
		assertEquals(ickslbgNew.getJsbmc(), ickslbg.getJsbmc());
		assertEquals(ickslbgNew.getFfr(), ickslbg.getFfr());
		assertEquals(ickslbgNew.getFfsj(), ickslbg.getFfsj());
		assertEquals(ickslbgNew.getLqr(), ickslbg.getLqr());
		assertEquals(ickslbgNew.getLqsj(), ickslbg.getLqsj());
		assertEquals(ickslbgNew.getLqrzjlx(), ickslbg.getLqrzjlx());
		assertEquals(ickslbgNew.getLqrzjhm(), ickslbg.getLqrzjhm());
		assertEquals(ickslbgNew.getIckzxr(), ickslbg.getIckzxr());
		assertEquals(ickslbgNew.getIckzxsj(), ickslbg.getIckzxsj());
		assertEquals(ickslbgNew.getIckzxyy(), ickslbg.getIckzxyy());
		assertEquals(ickslbgNew.getNjr(), ickslbg.getNjr());
		assertEquals(ickslbgNew.getNjsj(), ickslbg.getNjsj());
		assertEquals(ickslbgNew.getZkztbs(), ickslbg.getZkztbs());
		assertEquals(ickslbgNew.getSfqr(), ickslbg.getSfqr());
		assertEquals(ickslbgNew.getYsr(), ickslbg.getYsr());
		assertEquals(ickslbgNew.getYssj(), ickslbg.getYssj());
		assertEquals(ickslbgNew.getDxrr(), ickslbg.getDxrr());
		assertEquals(ickslbgNew.getDxrsj(), ickslbg.getDxrsj());
		assertEquals(ickslbgNew.getCyssj(), ickslbg.getCyssj());
		assertEquals(ickslbgNew.getCysyy(), ickslbg.getCysyy());
		assertEquals(ickslbgNew.getCdxrsj(), ickslbg.getCdxrsj());
		assertEquals(ickslbgNew.getCdxryy(), ickslbg.getCdxryy());
		assertEquals(ickslbgNew.getBhkyy(), ickslbg.getBhkyy());
		assertEquals(ickslbgNew.getYksfsh(), ickslbg.getYksfsh());

		//删除对象
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理变更ID(ickslbgid) 
		ickslbg.setIckslbgid(1)
		// @ 物流ID(wlid) 
		ickslbg.setWlid(1)
		// @ 组包ID(zbid) 
		ickslbg.setZbid(1)

		ickslbgService.deleteIckslbg(ickslbg);

		//修改对象
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理变更ID(ickslbgid) 
		ickslbg.setIckslbgid(1)
		// @ 物流ID(wlid) 
		ickslbg.setWlid(1)
		// @ 组包ID(zbid) 
		ickslbg.setZbid(1)

		ickslbgService.updateIckslbg(ickslbg);

		//查询单条
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理变更ID(ickslbgid) 
		ickslbg.setIckslbgid(1)
		// @ 物流ID(wlid) 
		ickslbg.setWlid(1)
		// @ 组包ID(zbid) 
		ickslbg.setZbid(1)

		ickslbgService.getIckslbg(ickslbg);

		//查询多条
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理变更ID(ickslbgid) 
		ickslbg.setIckslbgid(1)
		// @ 物流ID(wlid) 
		ickslbg.setWlid(1)
		// @ 组包ID(zbid) 
		ickslbg.setZbid(1)

		ickslbgService.getListIckslbg(ickslbg);

		//翻页查询
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		ickslbg.setIckslid(1)
		// @ IC卡受理变更ID(ickslbgid) 
		ickslbg.setIckslbgid(1)
		// @ 物流ID(wlid) 
		ickslbg.setWlid(1)
		// @ 组包ID(zbid) 
		ickslbg.setZbid(1)

		ickslbgService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		ickslbgService.insertIckslbg(ickslbg);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setIckslbgService(IIckslbgService ickslbgService) {
		this.ickslbgService = ickslbgService;
	}
}
