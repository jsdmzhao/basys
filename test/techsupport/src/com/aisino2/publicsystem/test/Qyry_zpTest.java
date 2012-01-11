package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.service.IQyry_zpService;

public class Qyry_zpTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyry_zpService qyry_zpService;

	/** @param 企业人员_照片(t_qyry_zp) */

	public void test() {
		Qyry_zp qyry_zp = new Qyry_zp();

	/** @ 企业ID(qyid) */
	qyry_zp.setQyid(0);

	/** @ 从业人员ID(ryid) */
	qyry_zp.setRyid(0);

	/** @ 照片ID(zpid) */
	qyry_zp.setZpid(0);

	/** @ 图片名称(tpmc) */
	qyry_zp.setTpmc("test");

	/** @ 图片类型(tplx) */
	qyry_zp.setTplx("test");

	/** @ 图片内容(tpnr) */
	qyry_zp.setTpnr(null);

		/*
		//插入对象
		qyry_zpService.insertQyry_zp(qyry_zp);

		//读取对象比较
		BaseObject bo = qyry_zpService.getQyry_zp(qyry_zp);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyry_zp qyry_zpNew = (Qyry_zp)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyry_zpNew.getQyid(), qyry_zp.getQyid());
		assertEquals(qyry_zpNew.getRyid(), qyry_zp.getRyid());
		assertEquals(qyry_zpNew.getZpid(), qyry_zp.getZpid());
		assertEquals(qyry_zpNew.getTpmc(), qyry_zp.getTpmc());
		assertEquals(qyry_zpNew.getTplx(), qyry_zp.getTplx());
		assertEquals(qyry_zpNew.getTpnr(), qyry_zp.getTpnr());

		//删除对象
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 照片ID(zpid) 
		qyry_zp.setZpid(1)

		qyry_zpService.deleteQyry_zp(qyry_zp);

		//修改对象
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 照片ID(zpid) 
		qyry_zp.setZpid(1)

		qyry_zpService.updateQyry_zp(qyry_zp);

		//查询单条
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 照片ID(zpid) 
		qyry_zp.setZpid(1)

		qyry_zpService.getQyry_zp(qyry_zp);

		//查询多条
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 照片ID(zpid) 
		qyry_zp.setZpid(1)

		qyry_zpService.getListQyry_zp(qyry_zp);

		//翻页查询
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_zp.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_zp.setRyid(1)
		// @ 照片ID(zpid) 
		qyry_zp.setZpid(1)

		qyry_zpService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyry_zpService.insertQyry_zp(qyry_zp);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyry_zpService(IQyry_zpService qyry_zpService) {
		this.qyry_zpService = qyry_zpService;
	}
}
