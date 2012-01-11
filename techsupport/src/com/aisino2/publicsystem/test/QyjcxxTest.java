package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyjcxx;
import com.aisino2.publicsystem.service.IQyjcxxService;

public class QyjcxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyjcxxService qyjcxxService;

	/** @param 企业奖惩信息(t_qyjcxx) */

	public void test() {
		Qyjcxx qyjcxx = new Qyjcxx();

	/** @ 企业ID(qyid) */
	qyjcxx.setQyid(0);

	/** @ 企业处罚ID(qycfid) */
	qyjcxx.setQycfid(0);

	/** @ 行业类别代码(hylbdm) */
	qyjcxx.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyjcxx.setHylb("test");

	/** @ 企业奖惩日期(qyjcrq) */
	qyjcxx.setQyjcrq(new Date());

	/** @ 处罚登记序号(cfdjxh) */
	qyjcxx.setCfdjxh("test");

	/** @ 奖惩类别代码(cflbbm) */
	qyjcxx.setCflbbm("test");

	/** @ 奖惩类别(cflb) */
	qyjcxx.setCflb("test");

	/** @ 奖惩明细类别代码(jcmxlbdm) */
	qyjcxx.setJcmxlbdm("test");

	/** @ 奖惩明细类别(jcmxlb) */
	qyjcxx.setJcmxlb("test");

	/** @ 行政处罚批准文号(xzcfpzwh) */
	qyjcxx.setXzcfpzwh("test");

	/** @ 批准机构代码(pzjgdm) */
	qyjcxx.setPzjgdm("test");

	/** @ 批准机构(pzjg) */
	qyjcxx.setPzjg("test");

	/** @ 批准人编号(pzrbh) */
	qyjcxx.setPzrbh("test");

	/** @ 批准人姓名(pzrxm) */
	qyjcxx.setPzrxm("test");

	/** @ 批准日期(pzrq) */
	qyjcxx.setPzrq(new Date());

	/** @ 执行人编号(zxrbh) */
	qyjcxx.setZxrbh("test");

	/** @ 执行人姓名(zxrxm) */
	qyjcxx.setZxrxm("test");

	/** @ 执行日期(zxrq) */
	qyjcxx.setZxrq(new Date());

	/** @ 情况描述(qkms) */
	qyjcxx.setQkms("test");

	/** @ 依据理由(yjly) */
	qyjcxx.setYjly("test");

	/** @ 奖惩幅度(jcfd) */
	qyjcxx.setJcfd("test");

	/** @ 被奖惩人(bjcr) */
	qyjcxx.setBjcr("test");

		/*
		//插入对象
		qyjcxxService.insertQyjcxx(qyjcxx);

		//读取对象比较
		BaseObject bo = qyjcxxService.getQyjcxx(qyjcxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyjcxx qyjcxxNew = (Qyjcxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyjcxxNew.getQyid(), qyjcxx.getQyid());
		assertEquals(qyjcxxNew.getQycfid(), qyjcxx.getQycfid());
		assertEquals(qyjcxxNew.getHylbdm(), qyjcxx.getHylbdm());
		assertEquals(qyjcxxNew.getHylb(), qyjcxx.getHylb());
		assertEquals(qyjcxxNew.getQyjcrq(), qyjcxx.getQyjcrq());
		assertEquals(qyjcxxNew.getCfdjxh(), qyjcxx.getCfdjxh());
		assertEquals(qyjcxxNew.getCflbbm(), qyjcxx.getCflbbm());
		assertEquals(qyjcxxNew.getCflb(), qyjcxx.getCflb());
		assertEquals(qyjcxxNew.getJcmxlbdm(), qyjcxx.getJcmxlbdm());
		assertEquals(qyjcxxNew.getJcmxlb(), qyjcxx.getJcmxlb());
		assertEquals(qyjcxxNew.getXzcfpzwh(), qyjcxx.getXzcfpzwh());
		assertEquals(qyjcxxNew.getPzjgdm(), qyjcxx.getPzjgdm());
		assertEquals(qyjcxxNew.getPzjg(), qyjcxx.getPzjg());
		assertEquals(qyjcxxNew.getPzrbh(), qyjcxx.getPzrbh());
		assertEquals(qyjcxxNew.getPzrxm(), qyjcxx.getPzrxm());
		assertEquals(qyjcxxNew.getPzrq(), qyjcxx.getPzrq());
		assertEquals(qyjcxxNew.getZxrbh(), qyjcxx.getZxrbh());
		assertEquals(qyjcxxNew.getZxrxm(), qyjcxx.getZxrxm());
		assertEquals(qyjcxxNew.getZxrq(), qyjcxx.getZxrq());
		assertEquals(qyjcxxNew.getQkms(), qyjcxx.getQkms());
		assertEquals(qyjcxxNew.getYjly(), qyjcxx.getYjly());
		assertEquals(qyjcxxNew.getJcfd(), qyjcxx.getJcfd());
		assertEquals(qyjcxxNew.getBjcr(), qyjcxx.getBjcr());

		//删除对象
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业处罚ID(qycfid) 
		qyjcxx.setQycfid(1)

		qyjcxxService.deleteQyjcxx(qyjcxx);

		//修改对象
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业处罚ID(qycfid) 
		qyjcxx.setQycfid(1)

		qyjcxxService.updateQyjcxx(qyjcxx);

		//查询单条
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业处罚ID(qycfid) 
		qyjcxx.setQycfid(1)

		qyjcxxService.getQyjcxx(qyjcxx);

		//查询多条
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业处罚ID(qycfid) 
		qyjcxx.setQycfid(1)

		qyjcxxService.getListQyjcxx(qyjcxx);

		//翻页查询
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyjcxx.setQyid(1)
		// @ 企业处罚ID(qycfid) 
		qyjcxx.setQycfid(1)

		qyjcxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyjcxxService.insertQyjcxx(qyjcxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyjcxxService(IQyjcxxService qyjcxxService) {
		this.qyjcxxService = qyjcxxService;
	}
}
