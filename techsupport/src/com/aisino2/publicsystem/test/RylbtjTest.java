package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Rylbtj;
import com.aisino2.publicsystem.service.IRylbtjService;

public class RylbtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IRylbtjService rylbtjService;

	/** @param 人员类别统计(t_rylbtj) */

	public void test() {
		Rylbtj rylbtj = new Rylbtj();

	/** @ 人员类别统计ID(rybtjid) */
	rylbtj.setRybtjid(0);

	/** @ 行业类别代码(hylbdm) */
	rylbtj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	rylbtj.setHylb("test");

	/** @ 地市机关代码(dsjgdm) */
	rylbtj.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	rylbtj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	rylbtj.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	rylbtj.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	rylbtj.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	rylbtj.setGxdwmc("test");

	/** @ 企业编码(qybm) */
	rylbtj.setQybm("test");

	/** @ 企业名称(qymc) */
	rylbtj.setQymc("test");

	/** @ 管理人员(glry) */
	rylbtj.setGlry(0);

	/** @ 法定代表人或主要负责人(fddbr) */
	rylbtj.setFddbr(0);

	/** @ 主要股东组成人员(zygdzcry) */
	rylbtj.setZygdzcry(0);

	/** @ 治安负责人(zafzr) */
	rylbtj.setZafzr(0);

	/** @ 其他管理人员(qtglry) */
	rylbtj.setQtglry(0);

	/** @ 服务人员(fwry) */
	rylbtj.setFwry(0);

	/** @ 一般服务人员(ybfwry) */
	rylbtj.setYbfwry(0);

	/** @ 临时服务人员(lsfwry) */
	rylbtj.setLsfwry(0);

	/** @ 演艺人员(yyry) */
	rylbtj.setYyry(0);

	/** @ 其他服务人员(qtfwry) */
	rylbtj.setQtfwry(0);

	/** @ 保安人员(bary) */
	rylbtj.setBary(0);

	/** @ 安全检查人员(aqjcry) */
	rylbtj.setAqjcry(0);

	/** @ 其他(qt) */
	rylbtj.setQt(0);

	/** @ 合计(hj) */
	rylbtj.setHj(0);

		/*
		//插入对象
		rylbtjService.insertRylbtj(rylbtj);

		//读取对象比较
		BaseObject bo = rylbtjService.getRylbtj(rylbtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Rylbtj rylbtjNew = (Rylbtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(rylbtjNew.getRybtjid(), rylbtj.getRybtjid());
		assertEquals(rylbtjNew.getHylbdm(), rylbtj.getHylbdm());
		assertEquals(rylbtjNew.getHylb(), rylbtj.getHylb());
		assertEquals(rylbtjNew.getDsjgdm(), rylbtj.getDsjgdm());
		assertEquals(rylbtjNew.getDsjgmc(), rylbtj.getDsjgmc());
		assertEquals(rylbtjNew.getFxjdm(), rylbtj.getFxjdm());
		assertEquals(rylbtjNew.getFxjmc(), rylbtj.getFxjmc());
		assertEquals(rylbtjNew.getGxdwdm(), rylbtj.getGxdwdm());
		assertEquals(rylbtjNew.getGxdwmc(), rylbtj.getGxdwmc());
		assertEquals(rylbtjNew.getQybm(), rylbtj.getQybm());
		assertEquals(rylbtjNew.getQymc(), rylbtj.getQymc());
		assertEquals(rylbtjNew.getGlry(), rylbtj.getGlry());
		assertEquals(rylbtjNew.getFddbr(), rylbtj.getFddbr());
		assertEquals(rylbtjNew.getZygdzcry(), rylbtj.getZygdzcry());
		assertEquals(rylbtjNew.getZafzr(), rylbtj.getZafzr());
		assertEquals(rylbtjNew.getQtglry(), rylbtj.getQtglry());
		assertEquals(rylbtjNew.getFwry(), rylbtj.getFwry());
		assertEquals(rylbtjNew.getYbfwry(), rylbtj.getYbfwry());
		assertEquals(rylbtjNew.getLsfwry(), rylbtj.getLsfwry());
		assertEquals(rylbtjNew.getYyry(), rylbtj.getYyry());
		assertEquals(rylbtjNew.getQtfwry(), rylbtj.getQtfwry());
		assertEquals(rylbtjNew.getBary(), rylbtj.getBary());
		assertEquals(rylbtjNew.getAqjcry(), rylbtj.getAqjcry());
		assertEquals(rylbtjNew.getQt(), rylbtj.getQt());
		assertEquals(rylbtjNew.getHj(), rylbtj.getHj());

		//删除对象
		// @ 人员类别统计ID(rybtjid) 
		rylbtj.setRybtjid(1)

		rylbtjService.deleteRylbtj(rylbtj);

		//修改对象
		// @ 人员类别统计ID(rybtjid) 
		rylbtj.setRybtjid(1)

		rylbtjService.updateRylbtj(rylbtj);

		//查询单条
		// @ 人员类别统计ID(rybtjid) 
		rylbtj.setRybtjid(1)

		rylbtjService.getRylbtj(rylbtj);

		//查询多条
		// @ 人员类别统计ID(rybtjid) 
		rylbtj.setRybtjid(1)

		rylbtjService.getListRylbtj(rylbtj);

		//翻页查询
		// @ 人员类别统计ID(rybtjid) 
		rylbtj.setRybtjid(1)

		rylbtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		rylbtjService.insertRylbtj(rylbtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setRylbtjService(IRylbtjService rylbtjService) {
		this.rylbtjService = rylbtjService;
	}
}
