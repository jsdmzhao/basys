package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Ryjcxx;
import com.aisino2.publicsystem.service.IRyjcxxService;

public class RyjcxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IRyjcxxService ryjcxxService;

	/** @param 人员奖惩信息(t_ryjcxx) */

	public void test() {
		Ryjcxx ryjcxx = new Ryjcxx();

	/** @ 企业ID(qyid) */
	ryjcxx.setQyid(0);

	/** @ 从业人员ID(ryid) */
	ryjcxx.setRyid(0);

	/** @ 人员处罚ID(rycfid) */
	ryjcxx.setRycfid(0);

	/** @ 行业类别代码(hylbdm) */
	ryjcxx.setHylbdm("test");

	/** @ 行业类别(hylb) */
	ryjcxx.setHylb("test");

	/** @ 企业奖惩日期(qyjcrq) */
	ryjcxx.setRyjcrq(new Date());

	/** @ 处罚登记序号(cfdjxh) */
	ryjcxx.setCfdjxh("test");

	/** @ 奖惩类别代码(cflbbm) */
	ryjcxx.setCflbbm("test");

	/** @ 奖惩类别(cflb) */
	ryjcxx.setCflb("test");

	/** @ 奖惩明细类别代码(jcmxlbdm) */
	ryjcxx.setJcmxlbdm("test");

	/** @ 奖惩明细类别(jcmxlb) */
	ryjcxx.setJcmxlb("test");

	/** @ 行政处罚批准文号(xzcfpzwh) */
	ryjcxx.setXzcfpzwh("test");

	/** @ 批准机构代码(pzjgdm) */
	ryjcxx.setPzjgdm("test");

	/** @ 批准机构(pzjg) */
	ryjcxx.setPzjg("test");

	/** @ 批准人编号(pzrbh) */
	ryjcxx.setPzrbh("test");

	/** @ 批准人姓名(pzrxm) */
	ryjcxx.setPzrxm("test");

	/** @ 批准日期(pzrq) */
	ryjcxx.setPzrq(new Date());

	/** @ 执行人编号(zxrbh) */
	ryjcxx.setZxrbh("test");

	/** @ 执行人姓名(zxrxm) */
	ryjcxx.setZxrxm("test");

	/** @ 执行日期(zxrq) */
	ryjcxx.setZxrq(new Date());

	/** @ 情况描述(qkms) */
	ryjcxx.setQkms("test");

	/** @ 依据理由(yjly) */
	ryjcxx.setYjly("test");

	/** @ 奖惩幅度(jcfd) */
	ryjcxx.setJcfd("test");

		/*
		//插入对象
		ryjcxxService.insertRyjcxx(ryjcxx);

		//读取对象比较
		BaseObject bo = ryjcxxService.getRyjcxx(ryjcxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Ryjcxx ryjcxxNew = (Ryjcxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ryjcxxNew.getQyid(), ryjcxx.getQyid());
		assertEquals(ryjcxxNew.getRyid(), ryjcxx.getRyid());
		assertEquals(ryjcxxNew.getRycfid(), ryjcxx.getRycfid());
		assertEquals(ryjcxxNew.getHylbdm(), ryjcxx.getHylbdm());
		assertEquals(ryjcxxNew.getHylb(), ryjcxx.getHylb());
		assertEquals(ryjcxxNew.getQyjcrq(), ryjcxx.getQyjcrq());
		assertEquals(ryjcxxNew.getCfdjxh(), ryjcxx.getCfdjxh());
		assertEquals(ryjcxxNew.getCflbbm(), ryjcxx.getCflbbm());
		assertEquals(ryjcxxNew.getCflb(), ryjcxx.getCflb());
		assertEquals(ryjcxxNew.getJcmxlbdm(), ryjcxx.getJcmxlbdm());
		assertEquals(ryjcxxNew.getJcmxlb(), ryjcxx.getJcmxlb());
		assertEquals(ryjcxxNew.getXzcfpzwh(), ryjcxx.getXzcfpzwh());
		assertEquals(ryjcxxNew.getPzjgdm(), ryjcxx.getPzjgdm());
		assertEquals(ryjcxxNew.getPzjg(), ryjcxx.getPzjg());
		assertEquals(ryjcxxNew.getPzrbh(), ryjcxx.getPzrbh());
		assertEquals(ryjcxxNew.getPzrxm(), ryjcxx.getPzrxm());
		assertEquals(ryjcxxNew.getPzrq(), ryjcxx.getPzrq());
		assertEquals(ryjcxxNew.getZxrbh(), ryjcxx.getZxrbh());
		assertEquals(ryjcxxNew.getZxrxm(), ryjcxx.getZxrxm());
		assertEquals(ryjcxxNew.getZxrq(), ryjcxx.getZxrq());
		assertEquals(ryjcxxNew.getQkms(), ryjcxx.getQkms());
		assertEquals(ryjcxxNew.getYjly(), ryjcxx.getYjly());
		assertEquals(ryjcxxNew.getJcfd(), ryjcxx.getJcfd());

		//删除对象
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 人员处罚ID(rycfid) 
		ryjcxx.setRycfid(1)

		ryjcxxService.deleteRyjcxx(ryjcxx);

		//修改对象
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 人员处罚ID(rycfid) 
		ryjcxx.setRycfid(1)

		ryjcxxService.updateRyjcxx(ryjcxx);

		//查询单条
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 人员处罚ID(rycfid) 
		ryjcxx.setRycfid(1)

		ryjcxxService.getRyjcxx(ryjcxx);

		//查询多条
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 人员处罚ID(rycfid) 
		ryjcxx.setRycfid(1)

		ryjcxxService.getListRyjcxx(ryjcxx);

		//翻页查询
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 企业ID(qyid) 
		ryjcxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		ryjcxx.setRyid(1)
		// @ 人员处罚ID(rycfid) 
		ryjcxx.setRycfid(1)

		ryjcxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		ryjcxxService.insertRyjcxx(ryjcxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setRyjcxxService(IRyjcxxService ryjcxxService) {
		this.ryjcxxService = ryjcxxService;
	}
}
