package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Wbjkdyczrz;
import com.aisino2.basicsystem.service.IWbjkdyczrzService;
import com.aisino2.core.test.BaseTestCase;

public class WbjkdyczrzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWbjkdyczrzService wbjkdyczrzService;

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) */

	public void test() {
		Wbjkdyczrz wbjkdyczrz = new Wbjkdyczrz();

	/** @ 操作日志id(czrzid) */
	wbjkdyczrz.setCzrzid(0);

	/** @ 操作账号(czzh) */
	wbjkdyczrz.setCzzh("test");

	/** @ 操作公司名称(czgsmc) */
	wbjkdyczrz.setCzgsmc("test");

	/** @ 操作时间(czsj) */
	wbjkdyczrz.setCzsj(new Date());

	/** @ 调用接口名称(dyjkmc) */
	wbjkdyczrz.setDyjkmc("test");

	/** @ 操作类型(czlx) */
	wbjkdyczrz.setCzlx("test");

	/** @ 总共条数(zgts) */
	wbjkdyczrz.setZgts(0);

	/** @ 操作结果(czjg) */
	wbjkdyczrz.setCzjg("test");

	/** @ 成功条数(cgts) */
	wbjkdyczrz.setCgts(0);

	/** @ 失败条数(sbts) */
	wbjkdyczrz.setSbts(0);

	/** @ 行业名称(hymc) */
	wbjkdyczrz.setHymc("test");

	/** @ 行业编码(hybm) */
	wbjkdyczrz.setHybm("test");

		/*
		//插入对象
		wbjkdyczrzService.insertWbjkdyczrz(wbjkdyczrz);

		//读取对象比较
		BaseObject bo = wbjkdyczrzService.getWbjkdyczrz(wbjkdyczrz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wbjkdyczrz wbjkdyczrzNew = (Wbjkdyczrz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wbjkdyczrzNew.getCzrzid(), wbjkdyczrz.getCzrzid());
		assertEquals(wbjkdyczrzNew.getCzzh(), wbjkdyczrz.getCzzh());
		assertEquals(wbjkdyczrzNew.getCzgsmc(), wbjkdyczrz.getCzgsmc());
		assertEquals(wbjkdyczrzNew.getCzsj(), wbjkdyczrz.getCzsj());
		assertEquals(wbjkdyczrzNew.getDyjkmc(), wbjkdyczrz.getDyjkmc());
		assertEquals(wbjkdyczrzNew.getCzlx(), wbjkdyczrz.getCzlx());
		assertEquals(wbjkdyczrzNew.getZgts(), wbjkdyczrz.getZgts());
		assertEquals(wbjkdyczrzNew.getCzjg(), wbjkdyczrz.getCzjg());
		assertEquals(wbjkdyczrzNew.getCgts(), wbjkdyczrz.getCgts());
		assertEquals(wbjkdyczrzNew.getSbts(), wbjkdyczrz.getSbts());
		assertEquals(wbjkdyczrzNew.getHymc(), wbjkdyczrz.getHymc());
		assertEquals(wbjkdyczrzNew.getHybm(), wbjkdyczrz.getHybm());

		//删除对象
		// @ 操作日志id(czrzid) 
		wbjkdyczrz.setCzrzid(1)

		wbjkdyczrzService.deleteWbjkdyczrz(wbjkdyczrz);

		//修改对象
		// @ 操作日志id(czrzid) 
		wbjkdyczrz.setCzrzid(1)

		wbjkdyczrzService.updateWbjkdyczrz(wbjkdyczrz);

		//查询单条
		// @ 操作日志id(czrzid) 
		wbjkdyczrz.setCzrzid(1)

		wbjkdyczrzService.getWbjkdyczrz(wbjkdyczrz);

		//查询多条
		// @ 操作日志id(czrzid) 
		wbjkdyczrz.setCzrzid(1)

		wbjkdyczrzService.getListWbjkdyczrz(wbjkdyczrz);

		//翻页查询
		// @ 操作日志id(czrzid) 
		wbjkdyczrz.setCzrzid(1)

		wbjkdyczrzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		wbjkdyczrzService.insertWbjkdyczrz(wbjkdyczrz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWbjkdyczrzService(IWbjkdyczrzService wbjkdyczrzService) {
		this.wbjkdyczrzService = wbjkdyczrzService;
	}
}
