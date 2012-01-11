package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyfltj;
import com.aisino2.publicsystem.service.IQyfltjService;

public class QyfltjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyfltjService qyfltjService;

	/** @param 企业分类统计(t_qyfltj) */

	public void test() {
		Qyfltj qyfltj = new Qyfltj();

	/** @ 企业分类统计ID(qyfltjid) */
	qyfltj.setQyfltjid(0);

	/** @ 行业类别代码(hylbdm) */
	qyfltj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyfltj.setHylb("test");

	/** @ 地市机关代码(dsjgdm) */
	qyfltj.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	qyfltj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	qyfltj.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	qyfltj.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	qyfltj.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	qyfltj.setGxdwmc("test");

	/** @ 歌舞娱乐(gwyl) */
	qyfltj.setGwyl(0);

	/** @ 酒吧(jb) */
	//qyfltj.setJb(0);

	/** @ 各类休闲活动场所(glxxhdcs) */
	//qyfltj.setGlxxhdcs(0);

	/** @ 游艺室、电子游戏厅(yysdzyxt) */
	qyfltj.setYysdzyxt(0);

	/** @ 桑拿、洗浴(snxy) */
	//qyfltj.setSnxy(0);

	/** @ 按摩(am) */
	//qyfltj.setAm(0);

	/** @ 住宿(zs) */
	//qyfltj.setZs(0);

	/** @ 网上服务（网吧）(wsfw) */
	//qyfltj.setWsfw(0);

	/** @ 其他(qt) */
	//qyfltj.setQt(0);

	/** @ 合计(hj) */
	qyfltj.setHj(0);

		/*
		//插入对象
		qyfltjService.insertQyfltj(qyfltj);

		//读取对象比较
		BaseObject bo = qyfltjService.getQyfltj(qyfltj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyfltj qyfltjNew = (Qyfltj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyfltjNew.getQyfltjid(), qyfltj.getQyfltjid());
		assertEquals(qyfltjNew.getHylbdm(), qyfltj.getHylbdm());
		assertEquals(qyfltjNew.getHylb(), qyfltj.getHylb());
		assertEquals(qyfltjNew.getDsjgdm(), qyfltj.getDsjgdm());
		assertEquals(qyfltjNew.getDsjgmc(), qyfltj.getDsjgmc());
		assertEquals(qyfltjNew.getFxjdm(), qyfltj.getFxjdm());
		assertEquals(qyfltjNew.getFxjmc(), qyfltj.getFxjmc());
		assertEquals(qyfltjNew.getGxdwdm(), qyfltj.getGxdwdm());
		assertEquals(qyfltjNew.getGxdwmc(), qyfltj.getGxdwmc());
		assertEquals(qyfltjNew.getGwyl(), qyfltj.getGwyl());
		assertEquals(qyfltjNew.getJb(), qyfltj.getJb());
		assertEquals(qyfltjNew.getGlxxhdcs(), qyfltj.getGlxxhdcs());
		assertEquals(qyfltjNew.getYysdzyxt(), qyfltj.getYysdzyxt());
		assertEquals(qyfltjNew.getSnxy(), qyfltj.getSnxy());
		assertEquals(qyfltjNew.getAm(), qyfltj.getAm());
		assertEquals(qyfltjNew.getZs(), qyfltj.getZs());
		assertEquals(qyfltjNew.getWsfw(), qyfltj.getWsfw());
		assertEquals(qyfltjNew.getQt(), qyfltj.getQt());
		assertEquals(qyfltjNew.getHj(), qyfltj.getHj());

		//删除对象
		// @ 企业分类统计ID(qyfltjid) 
		qyfltj.setQyfltjid(1)

		qyfltjService.deleteQyfltj(qyfltj);

		//修改对象
		// @ 企业分类统计ID(qyfltjid) 
		qyfltj.setQyfltjid(1)

		qyfltjService.updateQyfltj(qyfltj);

		//查询单条
		// @ 企业分类统计ID(qyfltjid) 
		qyfltj.setQyfltjid(1)

		qyfltjService.getQyfltj(qyfltj);

		//查询多条
		// @ 企业分类统计ID(qyfltjid) 
		qyfltj.setQyfltjid(1)

		qyfltjService.getListQyfltj(qyfltj);

		//翻页查询
		// @ 企业分类统计ID(qyfltjid) 
		qyfltj.setQyfltjid(1)

		qyfltjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyfltjService.insertQyfltj(qyfltj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyfltjService(IQyfltjService qyfltjService) {
		this.qyfltjService = qyfltjService;
	}
}
