package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Lhjc;
import com.aisino2.publicsystem.service.ILhjcService;

public class LhjcTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ILhjcService lhjcService;

	/** @param 联合检查(t_lhjc) */

	public void test() {
		Lhjc lhjc = new Lhjc();

	/** @ 企业ID(qyid) */
	lhjc.setQyid(0);

	/** @ 联合检查ID(lhjcid) */
	lhjc.setLhjcid(0);

	/** @ 管理部门联合检查登记序号(glbmlhjcdjxh) */
	lhjc.setGlbmlhjcdjxh("test");

	/** @ 联查机构级别代码(lcjgjbdm) */
	lhjc.setLcjgjbdm("te");

	/** @ 联查机构级别(lcjgjb) */
	lhjc.setLcjgjb("test");

	/** @ 联查机构类型代码(lcjglxdm) */
	lhjc.setLcjglxdm("te");

	/** @ 联查机构类型(lcjglx) */
	lhjc.setLcjglx("test");

	/** @ 联查机构代码(lcjgdm) */
	lhjc.setLcjgdm("test");

	/** @ 联查机构名称(lcjgmc) */
	lhjc.setLcjgmc("test");

	/** @ 联查时间(lcsj) */
	lhjc.setLcsj(new Date());

	/** @ 联查人员姓名(lcryxm) */
	lhjc.setLcryxm("test");

	/** @ 联查事项(lcsx) */
	lhjc.setLcsx("test");

	/** @ 发现问题(fxwt) */
	lhjc.setFxwt("test");

	/** @ 联查结果(lcjg) */
	lhjc.setLcjg("test");

		/*
		//插入对象
		lhjcService.insertLhjc(lhjc);

		//读取对象比较
		BaseObject bo = lhjcService.getLhjc(lhjc);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Lhjc lhjcNew = (Lhjc)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(lhjcNew.getQyid(), lhjc.getQyid());
		assertEquals(lhjcNew.getLhjcid(), lhjc.getLhjcid());
		assertEquals(lhjcNew.getGlbmlhjcdjxh(), lhjc.getGlbmlhjcdjxh());
		assertEquals(lhjcNew.getLcjgjbdm(), lhjc.getLcjgjbdm());
		assertEquals(lhjcNew.getLcjgjb(), lhjc.getLcjgjb());
		assertEquals(lhjcNew.getLcjglxdm(), lhjc.getLcjglxdm());
		assertEquals(lhjcNew.getLcjglx(), lhjc.getLcjglx());
		assertEquals(lhjcNew.getLcjgdm(), lhjc.getLcjgdm());
		assertEquals(lhjcNew.getLcjgmc(), lhjc.getLcjgmc());
		assertEquals(lhjcNew.getLcsj(), lhjc.getLcsj());
		assertEquals(lhjcNew.getLcryxm(), lhjc.getLcryxm());
		assertEquals(lhjcNew.getLcsx(), lhjc.getLcsx());
		assertEquals(lhjcNew.getFxwt(), lhjc.getFxwt());
		assertEquals(lhjcNew.getLcjg(), lhjc.getLcjg());

		//删除对象
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 联合检查ID(lhjcid) 
		lhjc.setLhjcid(1)

		lhjcService.deleteLhjc(lhjc);

		//修改对象
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 联合检查ID(lhjcid) 
		lhjc.setLhjcid(1)

		lhjcService.updateLhjc(lhjc);

		//查询单条
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 联合检查ID(lhjcid) 
		lhjc.setLhjcid(1)

		lhjcService.getLhjc(lhjc);

		//查询多条
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 联合检查ID(lhjcid) 
		lhjc.setLhjcid(1)

		lhjcService.getListLhjc(lhjc);

		//翻页查询
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 企业ID(qyid) 
		lhjc.setQyid(1)
		// @ 联合检查ID(lhjcid) 
		lhjc.setLhjcid(1)

		lhjcService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		lhjcService.insertLhjc(lhjc);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setLhjcService(ILhjcService lhjcService) {
		this.lhjcService = lhjcService;
	}
}
