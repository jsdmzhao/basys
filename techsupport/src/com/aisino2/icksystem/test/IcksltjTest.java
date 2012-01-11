package com.aisino2.icksystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Icksltj;
import com.aisino2.icksystem.service.IIcksltjService;

public class IcksltjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IIcksltjService icksltjService;

	/** @param IC卡受理统计(t_icksltj) */

	public void test() {
		Icksltj icksltj = new Icksltj();

	/** @ IC卡受理统计ID(icksltjid) */
	icksltj.setIcksltjid(0);

	/** @ 地市机关代码(dsjgdm) */
	icksltj.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	icksltj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	icksltj.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	icksltj.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	icksltj.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	icksltj.setGxdwmc("test");

	/** @ 企业名称(qymc) */
	icksltj.setQymc("test");

	/** @ 企业编码(qybm) */
	icksltj.setQybm("test");

	/** @ 当前在职人数(dqzzrs) */
	icksltj.setDqzzrs(0);

	/** @ 已受理人数(yslrs) */
	icksltj.setYslrs(0);

	/** @ 发放数(ffs) */
	icksltj.setFfs(0);

	/** @ 状态(zt) */
	icksltj.setZt("test");

		/*
		//插入对象
		icksltjService.insertIcksltj(icksltj);

		//读取对象比较
		BaseObject bo = icksltjService.getIcksltj(icksltj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Icksltj icksltjNew = (Icksltj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(icksltjNew.getIcksltjid(), icksltj.getIcksltjid());
		assertEquals(icksltjNew.getDsjgdm(), icksltj.getDsjgdm());
		assertEquals(icksltjNew.getDsjgmc(), icksltj.getDsjgmc());
		assertEquals(icksltjNew.getFxjdm(), icksltj.getFxjdm());
		assertEquals(icksltjNew.getFxjmc(), icksltj.getFxjmc());
		assertEquals(icksltjNew.getGxdwdm(), icksltj.getGxdwdm());
		assertEquals(icksltjNew.getGxdwmc(), icksltj.getGxdwmc());
		assertEquals(icksltjNew.getQymc(), icksltj.getQymc());
		assertEquals(icksltjNew.getQybm(), icksltj.getQybm());
		assertEquals(icksltjNew.getDqzzrs(), icksltj.getDqzzrs());
		assertEquals(icksltjNew.getYslrs(), icksltj.getYslrs());
		assertEquals(icksltjNew.getFfs(), icksltj.getFfs());
		assertEquals(icksltjNew.getZt(), icksltj.getZt());

		//删除对象
		// @ IC卡受理统计ID(icksltjid) 
		icksltj.setIcksltjid(1)

		icksltjService.deleteIcksltj(icksltj);

		//修改对象
		// @ IC卡受理统计ID(icksltjid) 
		icksltj.setIcksltjid(1)

		icksltjService.updateIcksltj(icksltj);

		//查询单条
		// @ IC卡受理统计ID(icksltjid) 
		icksltj.setIcksltjid(1)

		icksltjService.getIcksltj(icksltj);

		//查询多条
		// @ IC卡受理统计ID(icksltjid) 
		icksltj.setIcksltjid(1)

		icksltjService.getListIcksltj(icksltj);

		//翻页查询
		// @ IC卡受理统计ID(icksltjid) 
		icksltj.setIcksltjid(1)

		icksltjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		icksltjService.insertIcksltj(icksltj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setIcksltjService(IIcksltjService icksltjService) {
		this.icksltjService = icksltjService;
	}
}
