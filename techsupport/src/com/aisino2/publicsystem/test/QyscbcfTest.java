package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyscbcf;
import com.aisino2.publicsystem.service.IQyscbcfService;

public class QyscbcfTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyscbcfService qyscbcfService;

	/** @param 企业上传不充分(t_qyscbcf) */

	public void test() {
		Qyscbcf qyscbcf = new Qyscbcf();

	/** @ 企业上传不充分ID(qyscbcfid) */
	qyscbcf.setQyscbcfid(0);

	/** @ 行业类别代码(hylbdm) */
	qyscbcf.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyscbcf.setHylb("test");

	/** @ 未达标日期(wdbrq) */
	qyscbcf.setWdbrq(new Date());

	/** @ 地市机关代码(dsjgdm) */
	qyscbcf.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	qyscbcf.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	qyscbcf.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	qyscbcf.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	qyscbcf.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	qyscbcf.setGxdwmc("test");

	/** @ 企业编码(qybm) */
	qyscbcf.setQybm("test");

	/** @ 企业名称(qymc) */
	qyscbcf.setQymc("test");

	/** @ 联系电话(lxdh) */
	qyscbcf.setLxdh("test");

	/** @ 总人数(zrs) */
	qyscbcf.setZrs(0);

	/** @ 实刷卡人数(sskrs) */
	qyscbcf.setSskrs(0);

	/** @ 核定刷卡比(hdskb) */
	qyscbcf.setHdskb(new Float(9.9));

	/** @ 实际刷卡比(sjsrb) */
	qyscbcf.setSjsrb(new Float(9.9));

	/** @ 状态代码(ztdm) */
	qyscbcf.setZtdm("test");

		/*
		//插入对象
		qyscbcfService.insertQyscbcf(qyscbcf);

		//读取对象比较
		BaseObject bo = qyscbcfService.getQyscbcf(qyscbcf);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyscbcf qyscbcfNew = (Qyscbcf)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyscbcfNew.getQyscbcfid(), qyscbcf.getQyscbcfid());
		assertEquals(qyscbcfNew.getHylbdm(), qyscbcf.getHylbdm());
		assertEquals(qyscbcfNew.getHylb(), qyscbcf.getHylb());
		assertEquals(qyscbcfNew.getWdbrq(), qyscbcf.getWdbrq());
		assertEquals(qyscbcfNew.getDsjgdm(), qyscbcf.getDsjgdm());
		assertEquals(qyscbcfNew.getDsjgmc(), qyscbcf.getDsjgmc());
		assertEquals(qyscbcfNew.getFxjdm(), qyscbcf.getFxjdm());
		assertEquals(qyscbcfNew.getFxjmc(), qyscbcf.getFxjmc());
		assertEquals(qyscbcfNew.getGxdwdm(), qyscbcf.getGxdwdm());
		assertEquals(qyscbcfNew.getGxdwmc(), qyscbcf.getGxdwmc());
		assertEquals(qyscbcfNew.getQybm(), qyscbcf.getQybm());
		assertEquals(qyscbcfNew.getQymc(), qyscbcf.getQymc());
		assertEquals(qyscbcfNew.getLxdh(), qyscbcf.getLxdh());
		assertEquals(qyscbcfNew.getZrs(), qyscbcf.getZrs());
		assertEquals(qyscbcfNew.getSskrs(), qyscbcf.getSskrs());
		assertEquals(qyscbcfNew.getHdskb(), qyscbcf.getHdskb());
		assertEquals(qyscbcfNew.getSjsrb(), qyscbcf.getSjsrb());
		assertEquals(qyscbcfNew.getZtdm(), qyscbcf.getZtdm());

		//删除对象
		// @ 企业上传不充分ID(qyscbcfid) 
		qyscbcf.setQyscbcfid(1)

		qyscbcfService.deleteQyscbcf(qyscbcf);

		//修改对象
		// @ 企业上传不充分ID(qyscbcfid) 
		qyscbcf.setQyscbcfid(1)

		qyscbcfService.updateQyscbcf(qyscbcf);

		//查询单条
		// @ 企业上传不充分ID(qyscbcfid) 
		qyscbcf.setQyscbcfid(1)

		qyscbcfService.getQyscbcf(qyscbcf);

		//查询多条
		// @ 企业上传不充分ID(qyscbcfid) 
		qyscbcf.setQyscbcfid(1)

		qyscbcfService.getListQyscbcf(qyscbcf);

		//翻页查询
		// @ 企业上传不充分ID(qyscbcfid) 
		qyscbcf.setQyscbcfid(1)

		qyscbcfService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyscbcfService.insertQyscbcf(qyscbcf);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyscbcfService(IQyscbcfService qyscbcfService) {
		this.qyscbcfService = qyscbcfService;
	}
}
