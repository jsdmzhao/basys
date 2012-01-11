package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qysctj;
import com.aisino2.publicsystem.service.IQysctjService;

public class QysctjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQysctjService qysctjService;

	/** @param 企业上传统计表(t_qysctj) */

	public void test() {
		Qysctj qysctj = new Qysctj();

	/** @ 企业上传统计ID(qysctjid) */
	qysctj.setQysctjid(0);

	/** @ 行业类别代码(hylbdm) */
	qysctj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qysctj.setHylb("test");

	/** @ 统计日期(tjrq) */
	qysctj.setTjrq(new Date());

	/** @ 地市机关代码(dsjgdm) */
	qysctj.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	qysctj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	qysctj.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	qysctj.setFxjmc("test");

	/** @ 管辖单位名称(gxdwmc) */
	qysctj.setGxdwmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	qysctj.setGxdwdm("test");

	/** @ 企业编码(qybm) */
	qysctj.setQybm("test");

	/** @ 企业名称(qymc) */
	qysctj.setQymc("test");

	/** @ 联系电话(lxdh) */
	qysctj.setLxdh("test");

	/** @ 是否达标(sfdb) */
	qysctj.setSfdb(0);

	/** @ 总人数(zrs) */
	qysctj.setZrs(0);

	/** @ 工作人数(gzrs) */
	qysctj.setGzrs(0);

	/** @ 实刷卡人数(sskrs) */
	qysctj.setSskrs(0);

	/** @ 最低刷卡比(zdskb) */
	qysctj.setZdskb(new Float(9.9));

	/** @ 一次刷卡人数(ycskrs) */
	qysctj.setYcskrs(0);

	/** @ 多次刷卡人数(dcskrs) */
	qysctj.setDcskrs(0);

	/** @ 本场所刷卡人数(bcsskrs) */
	qysctj.setBcsskrs(0);

	/** @ 走台刷卡人数(ztskrs) */
	qysctj.setZtskrs(0);

	/** @ 总刷卡比(zskb) */
	qysctj.setZskb(new Float(9.9));

	/** @ 一次刷卡率(ycskb) */
	qysctj.setYcskb(new Float(9.9));

	/** @ 多次刷卡率(dcskb) */
	qysctj.setDcskb(new Float(9.9));

		/*
		//插入对象
		qysctjService.insertQysctj(qysctj);

		//读取对象比较
		BaseObject bo = qysctjService.getQysctj(qysctj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qysctj qysctjNew = (Qysctj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qysctjNew.getQysctjid(), qysctj.getQysctjid());
		assertEquals(qysctjNew.getHylbdm(), qysctj.getHylbdm());
		assertEquals(qysctjNew.getHylb(), qysctj.getHylb());
		assertEquals(qysctjNew.getTjrq(), qysctj.getTjrq());
		assertEquals(qysctjNew.getDsjgdm(), qysctj.getDsjgdm());
		assertEquals(qysctjNew.getDsjgmc(), qysctj.getDsjgmc());
		assertEquals(qysctjNew.getFxjdm(), qysctj.getFxjdm());
		assertEquals(qysctjNew.getFxjmc(), qysctj.getFxjmc());
		assertEquals(qysctjNew.getGxdwmc(), qysctj.getGxdwmc());
		assertEquals(qysctjNew.getGxdwdm(), qysctj.getGxdwdm());
		assertEquals(qysctjNew.getQybm(), qysctj.getQybm());
		assertEquals(qysctjNew.getQymc(), qysctj.getQymc());
		assertEquals(qysctjNew.getLxdh(), qysctj.getLxdh());
		assertEquals(qysctjNew.getSfdb(), qysctj.getSfdb());
		assertEquals(qysctjNew.getZrs(), qysctj.getZrs());
		assertEquals(qysctjNew.getGzrs(), qysctj.getGzrs());
		assertEquals(qysctjNew.getSskrs(), qysctj.getSskrs());
		assertEquals(qysctjNew.getZdskb(), qysctj.getZdskb());
		assertEquals(qysctjNew.getYcskrs(), qysctj.getYcskrs());
		assertEquals(qysctjNew.getDcskrs(), qysctj.getDcskrs());
		assertEquals(qysctjNew.getBcsskrs(), qysctj.getBcsskrs());
		assertEquals(qysctjNew.getZtskrs(), qysctj.getZtskrs());
		assertEquals(qysctjNew.getZskb(), qysctj.getZskb());
		assertEquals(qysctjNew.getYcskb(), qysctj.getYcskb());
		assertEquals(qysctjNew.getDcskb(), qysctj.getDcskb());

		//删除对象
		// @ 企业上传统计ID(qysctjid) 
		qysctj.setQysctjid(1)

		qysctjService.deleteQysctj(qysctj);

		//修改对象
		// @ 企业上传统计ID(qysctjid) 
		qysctj.setQysctjid(1)

		qysctjService.updateQysctj(qysctj);

		//查询单条
		// @ 企业上传统计ID(qysctjid) 
		qysctj.setQysctjid(1)

		qysctjService.getQysctj(qysctj);

		//查询多条
		// @ 企业上传统计ID(qysctjid) 
		qysctj.setQysctjid(1)

		qysctjService.getListQysctj(qysctj);

		//翻页查询
		// @ 企业上传统计ID(qysctjid) 
		qysctj.setQysctjid(1)

		qysctjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qysctjService.insertQysctj(qysctj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQysctjService(IQysctjService qysctjService) {
		this.qysctjService = qysctjService;
	}
}
