package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Asjgl;
import com.aisino2.basicsystem.service.IAsjglService;
import com.aisino2.core.test.BaseTestCase;

public class AsjglTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IAsjglService asjglService;

	/** @param 案事件管理(t_asjgl) */

	public void test() {
		Asjgl asjgl = new Asjgl();

	/** @ 案事件管理ID(asjglid) */
	asjgl.setAsjglid(0);

	/** @ 行业类别(hylb) */
	asjgl.setHylb("test");

	/** @ 企业编码(qybm) */
	asjgl.setQybm("test");

	/** @ 企业名称(qymc) */
	asjgl.setQymc("test");

	/** @ 案件编号(ajbh) */
	asjgl.setAjbh("test");

	/** @ 案件性质(ajxz) */
	asjgl.setAjxz("test");

	/** @ 案件类别(ajlb) */
	asjgl.setAjlb("test");

	/** @ 发案时间(fasj) */
	asjgl.setFasj(new Date());

	/** @ 发案地点(fadd) */
	asjgl.setFadd("test");

	/** @ 情况描述(qkms) */
	asjgl.setQkms("test");

	/** @ 所属单位编码(ssdwbm) */
	asjgl.setSsdwbm("test");

	/** @ 所属单位名称(ssdwmc) */
	asjgl.setSsdwmc("test");

	/** @ 企业涉案类型(qysalx) */
	asjgl.setQysalx("test");

	/** @ 登记人(djr) */
	asjgl.setDjr("test");

	/** @ 登记单位编码(djdwbm) */
	asjgl.setDjdwbm("test");

	/** @ 登记单位名称(djdwmc) */
	asjgl.setDjdwmc("test");

	/** @ 登记时间(djsj) */
	asjgl.setDjsj(new Date());

		/*
		//插入对象
		asjglService.insertAsjgl(asjgl);

		//读取对象比较
		BaseObject bo = asjglService.getAsjgl(asjgl);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Asjgl asjglNew = (Asjgl)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(asjglNew.getAsjglid(), asjgl.getAsjglid());
		assertEquals(asjglNew.getHylb(), asjgl.getHylb());
		assertEquals(asjglNew.getQybm(), asjgl.getQybm());
		assertEquals(asjglNew.getQymc(), asjgl.getQymc());
		assertEquals(asjglNew.getAjbh(), asjgl.getAjbh());
		assertEquals(asjglNew.getAjxz(), asjgl.getAjxz());
		assertEquals(asjglNew.getAjlb(), asjgl.getAjlb());
		assertEquals(asjglNew.getFasj(), asjgl.getFasj());
		assertEquals(asjglNew.getFadd(), asjgl.getFadd());
		assertEquals(asjglNew.getQkms(), asjgl.getQkms());
		assertEquals(asjglNew.getSsdwbm(), asjgl.getSsdwbm());
		assertEquals(asjglNew.getSsdwmc(), asjgl.getSsdwmc());
		assertEquals(asjglNew.getQysalx(), asjgl.getQysalx());
		assertEquals(asjglNew.getDjr(), asjgl.getDjr());
		assertEquals(asjglNew.getDjdwbm(), asjgl.getDjdwbm());
		assertEquals(asjglNew.getDjdwmc(), asjgl.getDjdwmc());
		assertEquals(asjglNew.getDjsj(), asjgl.getDjsj());

		//删除对象
		// @ 案事件管理ID(asjglid) 
		asjgl.setAsjglid(1)

		asjglService.deleteAsjgl(asjgl);

		//修改对象
		// @ 案事件管理ID(asjglid) 
		asjgl.setAsjglid(1)

		asjglService.updateAsjgl(asjgl);

		//查询单条
		// @ 案事件管理ID(asjglid) 
		asjgl.setAsjglid(1)

		asjglService.getAsjgl(asjgl);

		//查询多条
		// @ 案事件管理ID(asjglid) 
		asjgl.setAsjglid(1)

		asjglService.getListAsjgl(asjgl);

		//翻页查询
		// @ 案事件管理ID(asjglid) 
		asjgl.setAsjglid(1)

		asjglService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		asjglService.insertAsjgl(asjgl);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setAsjglService(IAsjglService asjglService) {
		this.asjglService = asjglService;
	}
}
