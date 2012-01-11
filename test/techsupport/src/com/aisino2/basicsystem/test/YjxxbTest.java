package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Yjxxb;
import com.aisino2.basicsystem.service.IYjxxbService;
import com.aisino2.core.test.BaseTestCase;

public class YjxxbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IYjxxbService yjxxbService;

	/** @param 预警信息表(t_yjxxb) */

	public void test() {
		Yjxxb yjxxb = new Yjxxb();

	/** @ 预警规则ID(yjgzid) */
	yjxxb.setYjgzid(0);

	/** @ 预警信息ID(yjxxid) */
	yjxxb.setYjxxid(0);

	/** @ 所属企业名称(ssqymc) */
	yjxxb.setSsqymc("test");

	/** @ 所属企业地址(ssqydz) */
	yjxxb.setSsqydz("test");

	/** @ 管辖单位代码(gxdwbm) */
	yjxxb.setGxdwbm("test");

	/** @ 管辖单位名称(gxdwmc) */
	yjxxb.setGxdwmc("test");

	/** @ 预警类型(yjlx) */
	yjxxb.setYjlx("test");

	/** @ 预警时间(yjsj) */
	yjxxb.setYjsj(new Date());

	/** @ 比对表名(bdbm) */
	yjxxb.setBdbm("test");

	/** @ 业务表名(ywbm) */
	yjxxb.setYwbm("test");

	/** @ 行业类别(hylb) */
	yjxxb.setHylb("test");

	/** @ 姓名(xm) */
	yjxxb.setXm("test");

	/** @ 公民身份号码(gmsfhm) */
	yjxxb.setGmsfhm("test");

	/** @ 更新版本号(gxbbh) */
	yjxxb.setGxbbh(0);

	/** @ 业务类别(ywlb) */
	yjxxb.setYwlb("test");

	/** @ 联系电话(lxdh) */
	yjxxb.setLxdh("test");

	/** @ 情况描述(qkms) */
	yjxxb.setQkms("test");

		/*
		//插入对象
		yjxxbService.insertYjxxb(yjxxb);

		//读取对象比较
		BaseObject bo = yjxxbService.getYjxxb(yjxxb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Yjxxb yjxxbNew = (Yjxxb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(yjxxbNew.getYjgzid(), yjxxb.getYjgzid());
		assertEquals(yjxxbNew.getYjxxid(), yjxxb.getYjxxid());
		assertEquals(yjxxbNew.getSsqymc(), yjxxb.getSsqymc());
		assertEquals(yjxxbNew.getSsqydz(), yjxxb.getSsqydz());
		assertEquals(yjxxbNew.getGxdwbm(), yjxxb.getGxdwbm());
		assertEquals(yjxxbNew.getGxdwmc(), yjxxb.getGxdwmc());
		assertEquals(yjxxbNew.getYjlx(), yjxxb.getYjlx());
		assertEquals(yjxxbNew.getYjsj(), yjxxb.getYjsj());
		assertEquals(yjxxbNew.getBdbm(), yjxxb.getBdbm());
		assertEquals(yjxxbNew.getYwbm(), yjxxb.getYwbm());
		assertEquals(yjxxbNew.getHylb(), yjxxb.getHylb());
		assertEquals(yjxxbNew.getXm(), yjxxb.getXm());
		assertEquals(yjxxbNew.getGmsfhm(), yjxxb.getGmsfhm());
		assertEquals(yjxxbNew.getGxbbh(), yjxxb.getGxbbh());
		assertEquals(yjxxbNew.getYwlb(), yjxxb.getYwlb());
		assertEquals(yjxxbNew.getLxdh(), yjxxb.getLxdh());
		assertEquals(yjxxbNew.getQkms(), yjxxb.getQkms());

		//删除对象
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		yjxxb.setYjxxid(1)

		yjxxbService.deleteYjxxb(yjxxb);

		//修改对象
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		yjxxb.setYjxxid(1)

		yjxxbService.updateYjxxb(yjxxb);

		//查询单条
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		yjxxb.setYjxxid(1)

		yjxxbService.getYjxxb(yjxxb);

		//查询多条
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		yjxxb.setYjxxid(1)

		yjxxbService.getListYjxxb(yjxxb);

		//翻页查询
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjxxb.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		yjxxb.setYjxxid(1)

		yjxxbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		yjxxbService.insertYjxxb(yjxxb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setYjxxbService(IYjxxbService yjxxbService) {
		this.yjxxbService = yjxxbService;
	}
}
