package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyzlxxfj;
import com.aisino2.publicsystem.service.IQyzlxxfjService;

public class QyzlxxfjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyzlxxfjService qyzlxxfjService;

	/** @param 企业质量信息附件(t_qyzlxxfj) */

	public void test() {
		Qyzlxxfj qyzlxxfj = new Qyzlxxfj();

	/** @ 企业质量信息附件ID(qyzlxxfjid) */
	qyzlxxfj.setQyzlxxfjid(0);

	/** @ 企业质量信息ID(qyzlxxid) */
	qyzlxxfj.setQyzlxxid(0);

	/** @ 附件名称(fjmc) */
	qyzlxxfj.setFjmc("test");

	/** @ 附件类型(fjlx) */
	qyzlxxfj.setFjlx("test");

	/** @ 附件内容(fjnr) */
	qyzlxxfj.setFjnr(null);

		/*
		//插入对象
		qyzlxxfjService.insertQyzlxxfj(qyzlxxfj);

		//读取对象比较
		BaseObject bo = qyzlxxfjService.getQyzlxxfj(qyzlxxfj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyzlxxfj qyzlxxfjNew = (Qyzlxxfj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyzlxxfjNew.getQyzlxxfjid(), qyzlxxfj.getQyzlxxfjid());
		assertEquals(qyzlxxfjNew.getQyzlxxid(), qyzlxxfj.getQyzlxxid());
		assertEquals(qyzlxxfjNew.getFjmc(), qyzlxxfj.getFjmc());
		assertEquals(qyzlxxfjNew.getFjlx(), qyzlxxfj.getFjlx());
		assertEquals(qyzlxxfjNew.getFjnr(), qyzlxxfj.getFjnr());

		//删除对象
		// @ 企业质量信息附件ID(qyzlxxfjid) 
		qyzlxxfj.setQyzlxxfjid(1)
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxxfj.setQyzlxxid(1)

		qyzlxxfjService.deleteQyzlxxfj(qyzlxxfj);

		//修改对象
		// @ 企业质量信息附件ID(qyzlxxfjid) 
		qyzlxxfj.setQyzlxxfjid(1)
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxxfj.setQyzlxxid(1)

		qyzlxxfjService.updateQyzlxxfj(qyzlxxfj);

		//查询单条
		// @ 企业质量信息附件ID(qyzlxxfjid) 
		qyzlxxfj.setQyzlxxfjid(1)
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxxfj.setQyzlxxid(1)

		qyzlxxfjService.getQyzlxxfj(qyzlxxfj);

		//查询多条
		// @ 企业质量信息附件ID(qyzlxxfjid) 
		qyzlxxfj.setQyzlxxfjid(1)
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxxfj.setQyzlxxid(1)

		qyzlxxfjService.getListQyzlxxfj(qyzlxxfj);

		//翻页查询
		// @ 企业质量信息附件ID(qyzlxxfjid) 
		qyzlxxfj.setQyzlxxfjid(1)
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxxfj.setQyzlxxid(1)

		qyzlxxfjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyzlxxfjService.insertQyzlxxfj(qyzlxxfj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyzlxxfjService(IQyzlxxfjService qyzlxxfjService) {
		this.qyzlxxfjService = qyzlxxfjService;
	}
}
