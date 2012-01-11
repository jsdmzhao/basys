package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyryxxtj;
import com.aisino2.publicsystem.service.IQyryxxtjService;

public class QyryxxtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyryxxtjService qyryxxtjService;

	/** @param 企业人员信息统计表(t_qyryxxtj) */

	public void test() {
		Qyryxxtj qyryxxtj = new Qyryxxtj();

	/** @ 企业人员信息统计ID(qyryxxtj) */
	qyryxxtj.setQyryxxtj(0);

	/** @ 行业类别代码(hylbdm) */
	qyryxxtj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyryxxtj.setHylb("test");

	/** @ 地市机关代码(dsjgdm) */
	qyryxxtj.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	qyryxxtj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	qyryxxtj.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	qyryxxtj.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	qyryxxtj.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	qyryxxtj.setGxdwmc("test");

	/** @ 企业名称(qymc) */
	qyryxxtj.setQymc("test");

	/** @ 企业编码(qybm) */
	qyryxxtj.setQybm("test");

	/** @ 总人数(zrs) */
	qyryxxtj.setZrs(0);

	/** @ 当月注册人数(dyzcrs) */
	qyryxxtj.setDyzcrs(0);

	/** @ 当月离职人数(dylzrs) */
	qyryxxtj.setDylzrs(0);

	/** @ 最近7日注册人数(zjqrzcrs) */
	qyryxxtj.setZjqrzcrs(0);

	/** @ 最近7日离职人数(zjqrlzrs) */
	qyryxxtj.setZjqrlzrs(0);

	/** @ 当前在职人数(dqzzrs) */
	qyryxxtj.setDqzzrs(0);

	/** @ 最低刷卡比(zdskb) */
	qyryxxtj.setZdskb(new Float(9.9));

	/** @ 前一日刷卡数(qyrsks) */
	qyryxxtj.setQyrsks(0);

	/** @ 状态代码(ztdm) */
	qyryxxtj.setZtdm("test");

		/*
		//插入对象
		qyryxxtjService.insertQyryxxtj(qyryxxtj);

		//读取对象比较
		BaseObject bo = qyryxxtjService.getQyryxxtj(qyryxxtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyryxxtj qyryxxtjNew = (Qyryxxtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyryxxtjNew.getQyryxxtj(), qyryxxtj.getQyryxxtj());
		assertEquals(qyryxxtjNew.getHylbdm(), qyryxxtj.getHylbdm());
		assertEquals(qyryxxtjNew.getHylb(), qyryxxtj.getHylb());
		assertEquals(qyryxxtjNew.getDsjgdm(), qyryxxtj.getDsjgdm());
		assertEquals(qyryxxtjNew.getDsjgmc(), qyryxxtj.getDsjgmc());
		assertEquals(qyryxxtjNew.getFxjdm(), qyryxxtj.getFxjdm());
		assertEquals(qyryxxtjNew.getFxjmc(), qyryxxtj.getFxjmc());
		assertEquals(qyryxxtjNew.getGxdwdm(), qyryxxtj.getGxdwdm());
		assertEquals(qyryxxtjNew.getGxdwmc(), qyryxxtj.getGxdwmc());
		assertEquals(qyryxxtjNew.getQymc(), qyryxxtj.getQymc());
		assertEquals(qyryxxtjNew.getQybm(), qyryxxtj.getQybm());
		assertEquals(qyryxxtjNew.getZrs(), qyryxxtj.getZrs());
		assertEquals(qyryxxtjNew.getDyzcrs(), qyryxxtj.getDyzcrs());
		assertEquals(qyryxxtjNew.getDylzrs(), qyryxxtj.getDylzrs());
		assertEquals(qyryxxtjNew.getZjqrzcrs(), qyryxxtj.getZjqrzcrs());
		assertEquals(qyryxxtjNew.getZjqrlzrs(), qyryxxtj.getZjqrlzrs());
		assertEquals(qyryxxtjNew.getDqzzrs(), qyryxxtj.getDqzzrs());
		assertEquals(qyryxxtjNew.getZdskb(), qyryxxtj.getZdskb());
		assertEquals(qyryxxtjNew.getQyrsks(), qyryxxtj.getQyrsks());
		assertEquals(qyryxxtjNew.getZtdm(), qyryxxtj.getZtdm());

		//删除对象
		// @ 企业人员信息统计ID(qyryxxtj) 
		qyryxxtj.setQyryxxtj(1)

		qyryxxtjService.deleteQyryxxtj(qyryxxtj);

		//修改对象
		// @ 企业人员信息统计ID(qyryxxtj) 
		qyryxxtj.setQyryxxtj(1)

		qyryxxtjService.updateQyryxxtj(qyryxxtj);

		//查询单条
		// @ 企业人员信息统计ID(qyryxxtj) 
		qyryxxtj.setQyryxxtj(1)

		qyryxxtjService.getQyryxxtj(qyryxxtj);

		//查询多条
		// @ 企业人员信息统计ID(qyryxxtj) 
		qyryxxtj.setQyryxxtj(1)

		qyryxxtjService.getListQyryxxtj(qyryxxtj);

		//翻页查询
		// @ 企业人员信息统计ID(qyryxxtj) 
		qyryxxtj.setQyryxxtj(1)

		qyryxxtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyryxxtjService.insertQyryxxtj(qyryxxtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyryxxtjService(IQyryxxtjService qyryxxtjService) {
		this.qyryxxtjService = qyryxxtjService;
	}
}
