package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Rcjc;
import com.aisino2.publicsystem.service.IRcjcService;

public class RcjcTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IRcjcService rcjcService;

	/** @param 日常检查(t_rcjc) */

	public void test() {
		Rcjc rcjc = new Rcjc();

	/** @ 企业ID(qyid) */
	rcjc.setQyid(0);

	/** @ 日常检查ID(rcjcid) */
	rcjc.setRcjcid(0);

	/** @ 日常检查编号(rcjcbh) */
	rcjc.setRcjcbh("test");

	/** @ 检查机构代码(jcjgdm) */
	rcjc.setJcjgdm("test");

	/** @ 检查机构名称(jcjgmc) */
	rcjc.setJcjgmc("test");

	/** @ 检查人员编号(jcrybh) */
	rcjc.setJcrybh("test");

	/** @ 检查人姓名(jcrxm) */
	rcjc.setJcrxm("test");

	/** @ 职务代码(zwdm) */
	rcjc.setZwdm("test");

	/** @ 检查人职务(jcrzw) */
	rcjc.setJcrzw("test");

	/** @ 检查方式(jcfs) */
	rcjc.setJcfs("test");

	/** @ 隶属单位(lsdw) */
	rcjc.setLsdw("test");

	/** @ 检查日期(jcrq) */
	rcjc.setJcrq(new Date());

	/** @ 检查事项(jcsx) */
	rcjc.setJcsx("test");

	/** @ 发现问题(fxwt) */
	rcjc.setFxwt("test");

	/** @ 处理结果(cljg) */
	rcjc.setCljg("test");

	/** @ 企业负责人(csfzr) */
	rcjc.setCsfzr("test");

	/** @ 是否知道检查结果(sfzdjcjg) */
	rcjc.setSfzdjcjg("te");

	/** @ 备注(bz) */
	rcjc.setBz("test");

		/*
		//插入对象
		rcjcService.insertRcjc(rcjc);

		//读取对象比较
		BaseObject bo = rcjcService.getRcjc(rcjc);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Rcjc rcjcNew = (Rcjc)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(rcjcNew.getQyid(), rcjc.getQyid());
		assertEquals(rcjcNew.getRcjcid(), rcjc.getRcjcid());
		assertEquals(rcjcNew.getRcjcbh(), rcjc.getRcjcbh());
		assertEquals(rcjcNew.getJcjgdm(), rcjc.getJcjgdm());
		assertEquals(rcjcNew.getJcjgmc(), rcjc.getJcjgmc());
		assertEquals(rcjcNew.getJcrybh(), rcjc.getJcrybh());
		assertEquals(rcjcNew.getJcrxm(), rcjc.getJcrxm());
		assertEquals(rcjcNew.getZwdm(), rcjc.getZwdm());
		assertEquals(rcjcNew.getJcrzw(), rcjc.getJcrzw());
		assertEquals(rcjcNew.getJcfs(), rcjc.getJcfs());
		assertEquals(rcjcNew.getLsdw(), rcjc.getLsdw());
		assertEquals(rcjcNew.getJcrq(), rcjc.getJcrq());
		assertEquals(rcjcNew.getJcsx(), rcjc.getJcsx());
		assertEquals(rcjcNew.getFxwt(), rcjc.getFxwt());
		assertEquals(rcjcNew.getCljg(), rcjc.getCljg());
		assertEquals(rcjcNew.getCsfzr(), rcjc.getCsfzr());
		assertEquals(rcjcNew.getSfzdjcjg(), rcjc.getSfzdjcjg());
		assertEquals(rcjcNew.getBz(), rcjc.getBz());

		//删除对象
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 日常检查ID(rcjcid) 
		rcjc.setRcjcid(1)

		rcjcService.deleteRcjc(rcjc);

		//修改对象
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 日常检查ID(rcjcid) 
		rcjc.setRcjcid(1)

		rcjcService.updateRcjc(rcjc);

		//查询单条
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 日常检查ID(rcjcid) 
		rcjc.setRcjcid(1)

		rcjcService.getRcjc(rcjc);

		//查询多条
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 日常检查ID(rcjcid) 
		rcjc.setRcjcid(1)

		rcjcService.getListRcjc(rcjc);

		//翻页查询
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 企业ID(qyid) 
		rcjc.setQyid(1)
		// @ 日常检查ID(rcjcid) 
		rcjc.setRcjcid(1)

		rcjcService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		rcjcService.insertRcjc(rcjc);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setRcjcService(IRcjcService rcjcService) {
		this.rcjcService = rcjcService;
	}
}
