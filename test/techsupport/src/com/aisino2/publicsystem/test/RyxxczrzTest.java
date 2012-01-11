package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Ryxxczrz;
import com.aisino2.publicsystem.service.IRyxxczrzService;

public class RyxxczrzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IRyxxczrzService ryxxczrzService;

	/** @param 人员信息操作日志(t_ryxxczrz) */

	public void test() {
		Ryxxczrz ryxxczrz = new Ryxxczrz();

	/** @ 人员信息操作日志ID(ryxxczrzid) */
	ryxxczrz.setRyxxczrzid(0);

	/** @ 操作时间(czsj) */
	ryxxczrz.setCzsj(new Date());

	/** @ 操作类型(czlx) */
	ryxxczrz.setCzlx("test");

	/** @ 操作内容(cznr) */
	ryxxczrz.setCznr("test");

	/** @ 操作人(czr) */
	ryxxczrz.setCzr("test");

	/** @ 企业编码(qybm) */
	ryxxczrz.setQybm("test");

	/** @ 从业人员编号(cyrybh) */
	ryxxczrz.setCyrybh("test");

		/*
		//插入对象
		ryxxczrzService.insertRyxxczrz(ryxxczrz);

		//读取对象比较
		BaseObject bo = ryxxczrzService.getRyxxczrz(ryxxczrz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Ryxxczrz ryxxczrzNew = (Ryxxczrz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ryxxczrzNew.getRyxxczrzid(), ryxxczrz.getRyxxczrzid());
		assertEquals(ryxxczrzNew.getCzsj(), ryxxczrz.getCzsj());
		assertEquals(ryxxczrzNew.getCzlx(), ryxxczrz.getCzlx());
		assertEquals(ryxxczrzNew.getCznr(), ryxxczrz.getCznr());
		assertEquals(ryxxczrzNew.getCzr(), ryxxczrz.getCzr());
		assertEquals(ryxxczrzNew.getQybm(), ryxxczrz.getQybm());
		assertEquals(ryxxczrzNew.getCyrybh(), ryxxczrz.getCyrybh());

		//删除对象
		// @ 人员信息操作日志ID(ryxxczrzid) 
		ryxxczrz.setRyxxczrzid(1)

		ryxxczrzService.deleteRyxxczrz(ryxxczrz);

		//修改对象
		// @ 人员信息操作日志ID(ryxxczrzid) 
		ryxxczrz.setRyxxczrzid(1)

		ryxxczrzService.updateRyxxczrz(ryxxczrz);

		//查询单条
		// @ 人员信息操作日志ID(ryxxczrzid) 
		ryxxczrz.setRyxxczrzid(1)

		ryxxczrzService.getRyxxczrz(ryxxczrz);

		//查询多条
		// @ 人员信息操作日志ID(ryxxczrzid) 
		ryxxczrz.setRyxxczrzid(1)

		ryxxczrzService.getListRyxxczrz(ryxxczrz);

		//翻页查询
		// @ 人员信息操作日志ID(ryxxczrzid) 
		ryxxczrz.setRyxxczrzid(1)

		ryxxczrzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		ryxxczrzService.insertRyxxczrz(ryxxczrz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setRyxxczrzService(IRyxxczrzService ryxxczrzService) {
		this.ryxxczrzService = ryxxczrzService;
	}
}
