package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Ickrzjl;
import com.aisino2.icksystem.service.IIckrzjlService;

public class IckrzjlTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IIckrzjlService ickrzjlService;

	/** @param IC卡日志记录(t_ickrzjl) */

	public void test() {
		Ickrzjl ickrzjl = new Ickrzjl();

	/** @ 日志编号(rzbh) */
	ickrzjl.setRzbh(0);

	/** @ 批次号(pch) */
	ickrzjl.setPch("test");

	/** @ 关联编号(glbh) */
	ickrzjl.setGlbh("test");

	/** @ 从业人员编号(cyrybh) */
	ickrzjl.setCyrybh("test");

	/** @ 操作类别(czlb) */
	ickrzjl.setCzlb("test");

	/** @ 操作原因(czyy) */
	ickrzjl.setCzyy("test");

	/** @ 操作人(czr) */
	ickrzjl.setCzr("test");

	/** @ 操作时间(czsj) */
	ickrzjl.setCzsj(new Date());

		/*
		//插入对象
		ickrzjlService.insertIckrzjl(ickrzjl);

		//读取对象比较
		BaseObject bo = ickrzjlService.getIckrzjl(ickrzjl);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Ickrzjl ickrzjlNew = (Ickrzjl)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ickrzjlNew.getRzbh(), ickrzjl.getRzbh());
		assertEquals(ickrzjlNew.getPch(), ickrzjl.getPch());
		assertEquals(ickrzjlNew.getGlbh(), ickrzjl.getGlbh());
		assertEquals(ickrzjlNew.getCyrybh(), ickrzjl.getCyrybh());
		assertEquals(ickrzjlNew.getCzlb(), ickrzjl.getCzlb());
		assertEquals(ickrzjlNew.getCzyy(), ickrzjl.getCzyy());
		assertEquals(ickrzjlNew.getCzr(), ickrzjl.getCzr());
		assertEquals(ickrzjlNew.getCzsj(), ickrzjl.getCzsj());

		//删除对象
		// @ 日志编号(rzbh) 
		ickrzjl.setRzbh(1)

		ickrzjlService.deleteIckrzjl(ickrzjl);

		//修改对象
		// @ 日志编号(rzbh) 
		ickrzjl.setRzbh(1)

		ickrzjlService.updateIckrzjl(ickrzjl);

		//查询单条
		// @ 日志编号(rzbh) 
		ickrzjl.setRzbh(1)

		ickrzjlService.getIckrzjl(ickrzjl);

		//查询多条
		// @ 日志编号(rzbh) 
		ickrzjl.setRzbh(1)

		ickrzjlService.getListIckrzjl(ickrzjl);

		//翻页查询
		// @ 日志编号(rzbh) 
		ickrzjl.setRzbh(1)

		ickrzjlService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		ickrzjlService.insertIckrzjl(ickrzjl);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setIckrzjlService(IIckrzjlService ickrzjlService) {
		this.ickrzjlService = ickrzjlService;
	}
}
