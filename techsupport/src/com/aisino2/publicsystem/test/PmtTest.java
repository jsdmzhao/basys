package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Pmt;
import com.aisino2.publicsystem.service.IPmtService;

public class PmtTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IPmtService pmtService;

	/** @param 平面图(t_pmt) */

	public void test() {
		Pmt pmt = new Pmt();

	/** @ 企业ID(qyid) */
	pmt.setQyid(0);

	/** @ 平面图ID(pmtid) */
	pmt.setPmtid(0);

	/** @ 平面图类型代码(pmtlxdm) */
	pmt.setPmtlxdm("test");

	/** @ 平面图类型名称(pmtlxmc) */
	pmt.setPmtlxmc("test");

	/** @ 平面图纸(pmtz) */
	pmt.setPmtz(null);

		/*
		//插入对象
		pmtService.insertPmt(pmt);

		//读取对象比较
		BaseObject bo = pmtService.getPmt(pmt);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Pmt pmtNew = (Pmt)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(pmtNew.getQyid(), pmt.getQyid());
		assertEquals(pmtNew.getPmtid(), pmt.getPmtid());
		assertEquals(pmtNew.getPmtlxdm(), pmt.getPmtlxdm());
		assertEquals(pmtNew.getPmtlxmc(), pmt.getPmtlxmc());
		assertEquals(pmtNew.getPmtz(), pmt.getPmtz());

		//删除对象
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 平面图ID(pmtid) 
		pmt.setPmtid(1)

		pmtService.deletePmt(pmt);

		//修改对象
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 平面图ID(pmtid) 
		pmt.setPmtid(1)

		pmtService.updatePmt(pmt);

		//查询单条
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 平面图ID(pmtid) 
		pmt.setPmtid(1)

		pmtService.getPmt(pmt);

		//查询多条
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 平面图ID(pmtid) 
		pmt.setPmtid(1)

		pmtService.getListPmt(pmt);

		//翻页查询
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 企业ID(qyid) 
		pmt.setQyid(1)
		// @ 平面图ID(pmtid) 
		pmt.setPmtid(1)

		pmtService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		pmtService.insertPmt(pmt);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setPmtService(IPmtService pmtService) {
		this.pmtService = pmtService;
	}
}
