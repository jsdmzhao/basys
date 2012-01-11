package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyryxxhc;
import com.aisino2.publicsystem.service.IQyryxxhcService;

public class QyryxxhcTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyryxxhcService qyryxxhcService;

	/** @param 企业人员信息核查(t_qyryxxhc) */

	public void test() {
		Qyryxxhc qyryxxhc = new Qyryxxhc();

	/** @ 公安人口库同步数据ID(garkktbsjid) */
	qyryxxhc.setGarkktbsjid(0);

	/** @ 企业ID(qyid) */
	qyryxxhc.setQyid(0);

	/** @ 从业人员ID(ryid) */
	qyryxxhc.setRyid(0);

	/** @ 核查ID(hcid) */
	qyryxxhc.setHcid(0);

	/** @ 地市机关代码(dsjgdm) */
	qyryxxhc.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	qyryxxhc.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	qyryxxhc.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	qyryxxhc.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	qyryxxhc.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	qyryxxhc.setGxdwmc("test");

	/** @ 企业编码(qybm) */
	qyryxxhc.setQybm("test");

	/** @ 企业名称(qymc) */
	qyryxxhc.setQymc("test");

	/** @ 姓名(xm) */
	qyryxxhc.setXm("test");

	/** @ 性别代码(xbdm) */
	qyryxxhc.setXbdm("test");

	/** @ 性别(xb) */
	qyryxxhc.setXb("test");

	/** @ 英文名(ywm) */
	qyryxxhc.setYwm("test");

	/** @ 英文姓(ywx) */
	qyryxxhc.setYwx("test");

	/** @ 外国人就业许可证号(wgrjyxkz) */
	qyryxxhc.setWgrjyxkz("test");

	/** @ 常用证件代码(cyzjdm) */
	qyryxxhc.setCyzjdm("test");

	/** @ 常用证件(cyzj) */
	qyryxxhc.setCyzj("test");

	/** @ 证件号码(zjhm) */
	qyryxxhc.setZjhm("test");

	/** @ 岗位编号(gwbh) */
	qyryxxhc.setGwbh("test");

	/** @ 岗位名称(gemc) */
	qyryxxhc.setGemc("test");

	/** @ 姓名拼音(xmpy) */
	qyryxxhc.setXmpy("test");

	/** @ 比对时间(bdsj) */
	qyryxxhc.setBdsj(new Date());

	/** @ 核查时间(hcsj) */
	qyryxxhc.setHcsj(new Date());

	/** @ 核查问题(hcwt) */
	qyryxxhc.setHcwt("test");

	/** @ 核查意见(hcyj) */
	qyryxxhc.setHcyj("test");

	/** @ 核查人(hcr) */
	qyryxxhc.setHcr("test");

	/** @ 核查单位(hcdw) */
	qyryxxhc.setHcdw("test");

	/** @ 核查单位代码(hcdwdm) */
	qyryxxhc.setHcdwdm("test");

	/** @ 核查状态(hczt) */
	qyryxxhc.setHczt("test");

		/*
		//插入对象
		qyryxxhcService.insertQyryxxhc(qyryxxhc);

		//读取对象比较
		BaseObject bo = qyryxxhcService.getQyryxxhc(qyryxxhc);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyryxxhc qyryxxhcNew = (Qyryxxhc)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyryxxhcNew.getGarkktbsjid(), qyryxxhc.getGarkktbsjid());
		assertEquals(qyryxxhcNew.getQyid(), qyryxxhc.getQyid());
		assertEquals(qyryxxhcNew.getRyid(), qyryxxhc.getRyid());
		assertEquals(qyryxxhcNew.getHcid(), qyryxxhc.getHcid());
		assertEquals(qyryxxhcNew.getDsjgdm(), qyryxxhc.getDsjgdm());
		assertEquals(qyryxxhcNew.getDsjgmc(), qyryxxhc.getDsjgmc());
		assertEquals(qyryxxhcNew.getFxjdm(), qyryxxhc.getFxjdm());
		assertEquals(qyryxxhcNew.getFxjmc(), qyryxxhc.getFxjmc());
		assertEquals(qyryxxhcNew.getGxdwdm(), qyryxxhc.getGxdwdm());
		assertEquals(qyryxxhcNew.getGxdwmc(), qyryxxhc.getGxdwmc());
		assertEquals(qyryxxhcNew.getQybm(), qyryxxhc.getQybm());
		assertEquals(qyryxxhcNew.getQymc(), qyryxxhc.getQymc());
		assertEquals(qyryxxhcNew.getXm(), qyryxxhc.getXm());
		assertEquals(qyryxxhcNew.getXbdm(), qyryxxhc.getXbdm());
		assertEquals(qyryxxhcNew.getXb(), qyryxxhc.getXb());
		assertEquals(qyryxxhcNew.getYwm(), qyryxxhc.getYwm());
		assertEquals(qyryxxhcNew.getYwx(), qyryxxhc.getYwx());
		assertEquals(qyryxxhcNew.getWgrjyxkz(), qyryxxhc.getWgrjyxkz());
		assertEquals(qyryxxhcNew.getCyzjdm(), qyryxxhc.getCyzjdm());
		assertEquals(qyryxxhcNew.getCyzj(), qyryxxhc.getCyzj());
		assertEquals(qyryxxhcNew.getZjhm(), qyryxxhc.getZjhm());
		assertEquals(qyryxxhcNew.getGwbh(), qyryxxhc.getGwbh());
		assertEquals(qyryxxhcNew.getGemc(), qyryxxhc.getGemc());
		assertEquals(qyryxxhcNew.getXmpy(), qyryxxhc.getXmpy());
		assertEquals(qyryxxhcNew.getBdsj(), qyryxxhc.getBdsj());
		assertEquals(qyryxxhcNew.getHcsj(), qyryxxhc.getHcsj());
		assertEquals(qyryxxhcNew.getHcwt(), qyryxxhc.getHcwt());
		assertEquals(qyryxxhcNew.getHcyj(), qyryxxhc.getHcyj());
		assertEquals(qyryxxhcNew.getHcr(), qyryxxhc.getHcr());
		assertEquals(qyryxxhcNew.getHcdw(), qyryxxhc.getHcdw());
		assertEquals(qyryxxhcNew.getHcdwdm(), qyryxxhc.getHcdwdm());
		assertEquals(qyryxxhcNew.getHczt(), qyryxxhc.getHczt());

		//删除对象
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 核查ID(hcid) 
		qyryxxhc.setHcid(1)

		qyryxxhcService.deleteQyryxxhc(qyryxxhc);

		//修改对象
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 核查ID(hcid) 
		qyryxxhc.setHcid(1)

		qyryxxhcService.updateQyryxxhc(qyryxxhc);

		//查询单条
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 核查ID(hcid) 
		qyryxxhc.setHcid(1)

		qyryxxhcService.getQyryxxhc(qyryxxhc);

		//查询多条
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 核查ID(hcid) 
		qyryxxhc.setHcid(1)

		qyryxxhcService.getListQyryxxhc(qyryxxhc);

		//翻页查询
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 公安人口库同步数据ID(garkktbsjid) 
		qyryxxhc.setGarkktbsjid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxxhc.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyryxxhc.setRyid(1)
		// @ 核查ID(hcid) 
		qyryxxhc.setHcid(1)

		qyryxxhcService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyryxxhcService.insertQyryxxhc(qyryxxhc);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyryxxhcService(IQyryxxhcService qyryxxhcService) {
		this.qyryxxhcService = qyryxxhcService;
	}
}
