package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyxxczrz;
import com.aisino2.publicsystem.service.IQyxxczrzService;

public class QyxxczrzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyxxczrzService qyxxczrzService;

	/** @param 企业信息操作日志(t_qyxxczrz) */

	public void test() {
		Qyxxczrz qyxxczrz = new Qyxxczrz();

	/** @ 企业信息操作日志ID(qyxxczrzid) */
	qyxxczrz.setQyxxczrzid(0);

	/** @ 操作时间(czsj) */
	qyxxczrz.setCzsj(new Date());

	/** @ 操作类型(czlx) */
	qyxxczrz.setCzlx("test");

	/** @ 操作内容(cznr) */
	qyxxczrz.setCznr("test");

	/** @ 操作人(czr) */
	qyxxczrz.setCzr("test");

	/** @ 企业编码(qybm) */
	qyxxczrz.setQybm("test");

		/*
		//插入对象
		qyxxczrzService.insertQyxxczrz(qyxxczrz);

		//读取对象比较
		BaseObject bo = qyxxczrzService.getQyxxczrz(qyxxczrz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyxxczrz qyxxczrzNew = (Qyxxczrz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyxxczrzNew.getQyxxczrzid(), qyxxczrz.getQyxxczrzid());
		assertEquals(qyxxczrzNew.getCzsj(), qyxxczrz.getCzsj());
		assertEquals(qyxxczrzNew.getCzlx(), qyxxczrz.getCzlx());
		assertEquals(qyxxczrzNew.getCznr(), qyxxczrz.getCznr());
		assertEquals(qyxxczrzNew.getCzr(), qyxxczrz.getCzr());
		assertEquals(qyxxczrzNew.getQybm(), qyxxczrz.getQybm());

		//删除对象
		// @ 企业信息操作日志ID(qyxxczrzid) 
		qyxxczrz.setQyxxczrzid(1)

		qyxxczrzService.deleteQyxxczrz(qyxxczrz);

		//修改对象
		// @ 企业信息操作日志ID(qyxxczrzid) 
		qyxxczrz.setQyxxczrzid(1)

		qyxxczrzService.updateQyxxczrz(qyxxczrz);

		//查询单条
		// @ 企业信息操作日志ID(qyxxczrzid) 
		qyxxczrz.setQyxxczrzid(1)

		qyxxczrzService.getQyxxczrz(qyxxczrz);

		//查询多条
		// @ 企业信息操作日志ID(qyxxczrzid) 
		qyxxczrz.setQyxxczrzid(1)

		qyxxczrzService.getListQyxxczrz(qyxxczrz);

		//翻页查询
		// @ 企业信息操作日志ID(qyxxczrzid) 
		qyxxczrz.setQyxxczrzid(1)

		qyxxczrzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyxxczrzService.insertQyxxczrz(qyxxczrz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyxxczrzService(IQyxxczrzService qyxxczrzService) {
		this.qyxxczrzService = qyxxczrzService;
	}
}
