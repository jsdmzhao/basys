package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyyyzttj;
import com.aisino2.publicsystem.service.IQyyyzttjService;

public class QyyyzttjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyyyzttjService qyyyzttjService;

	/** @param 企业营业状态统计(t_qyyyzttj) */

	public void test() {
		Qyyyzttj qyyyzttj = new Qyyyzttj();

	/** @ 企业营业状态统计ID(qyyyzttjid) */
	qyyyzttj.setQyyyzttjid(0);

	/** @ 统计日期(tjrq) */
	qyyyzttj.setTjrq(new Date());

	/** @ 行业类别代码(hylbdm) */
	qyyyzttj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyyyzttj.setHylb("test");

	/** @ 地市机关代码(dsjgdm) */
	qyyyzttj.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	qyyyzttj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	qyyyzttj.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	qyyyzttj.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	qyyyzttj.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	qyyyzttj.setGxdwmc("test");

	/** @ 营业(yy) */
	qyyyzttj.setYy(0);

	/** @ 自主停业(zzty) */
	qyyyzttj.setZzty(0);

	/** @ 勒令停业(llty) */
	qyyyzttj.setLlty(0);

	/** @ 歇业(xy) */
	qyyyzttj.setXy(0);

	/** @ 注销(zx) */
	qyyyzttj.setZx(0);

	/** @ 其他(qt) */
	qyyyzttj.setQt(0);

	/** @ 合计(hj) */
	qyyyzttj.setHj(0);

		/*
		//插入对象
		qyyyzttjService.insertQyyyzttj(qyyyzttj);

		//读取对象比较
		BaseObject bo = qyyyzttjService.getQyyyzttj(qyyyzttj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyyyzttj qyyyzttjNew = (Qyyyzttj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyyyzttjNew.getQyyyzttjid(), qyyyzttj.getQyyyzttjid());
		assertEquals(qyyyzttjNew.getTjrq(), qyyyzttj.getTjrq());
		assertEquals(qyyyzttjNew.getHylbdm(), qyyyzttj.getHylbdm());
		assertEquals(qyyyzttjNew.getHylb(), qyyyzttj.getHylb());
		assertEquals(qyyyzttjNew.getDsjgdm(), qyyyzttj.getDsjgdm());
		assertEquals(qyyyzttjNew.getDsjgmc(), qyyyzttj.getDsjgmc());
		assertEquals(qyyyzttjNew.getFxjdm(), qyyyzttj.getFxjdm());
		assertEquals(qyyyzttjNew.getFxjmc(), qyyyzttj.getFxjmc());
		assertEquals(qyyyzttjNew.getGxdwdm(), qyyyzttj.getGxdwdm());
		assertEquals(qyyyzttjNew.getGxdwmc(), qyyyzttj.getGxdwmc());
		assertEquals(qyyyzttjNew.getYy(), qyyyzttj.getYy());
		assertEquals(qyyyzttjNew.getZzty(), qyyyzttj.getZzty());
		assertEquals(qyyyzttjNew.getLlty(), qyyyzttj.getLlty());
		assertEquals(qyyyzttjNew.getXy(), qyyyzttj.getXy());
		assertEquals(qyyyzttjNew.getZx(), qyyyzttj.getZx());
		assertEquals(qyyyzttjNew.getQt(), qyyyzttj.getQt());
		assertEquals(qyyyzttjNew.getHj(), qyyyzttj.getHj());

		//删除对象
		// @ 企业营业状态统计ID(qyyyzttjid) 
		qyyyzttj.setQyyyzttjid(1)

		qyyyzttjService.deleteQyyyzttj(qyyyzttj);

		//修改对象
		// @ 企业营业状态统计ID(qyyyzttjid) 
		qyyyzttj.setQyyyzttjid(1)

		qyyyzttjService.updateQyyyzttj(qyyyzttj);

		//查询单条
		// @ 企业营业状态统计ID(qyyyzttjid) 
		qyyyzttj.setQyyyzttjid(1)

		qyyyzttjService.getQyyyzttj(qyyyzttj);

		//查询多条
		// @ 企业营业状态统计ID(qyyyzttjid) 
		qyyyzttj.setQyyyzttjid(1)

		qyyyzttjService.getListQyyyzttj(qyyyzttj);

		//翻页查询
		// @ 企业营业状态统计ID(qyyyzttjid) 
		qyyyzttj.setQyyyzttjid(1)

		qyyyzttjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyyyzttjService.insertQyyyzttj(qyyyzttj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyyyzttjService(IQyyyzttjService qyyyzttjService) {
		this.qyyyzttjService = qyyyzttjService;
	}
}
