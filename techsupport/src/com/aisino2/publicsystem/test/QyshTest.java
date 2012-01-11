package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qysh;
import com.aisino2.publicsystem.service.IQyshService;

public class QyshTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyshService qyshService;

	/** @param 企业审核(t_qysh) */

	public void test() {
		Qysh qysh = new Qysh();

	/** @ 企业审核ID(qyshid) */
	qysh.setQyshid(0);

	/** @ 企业ID(qyid) */
	qysh.setQyid(0);

	/** @ 审核时间(shsj) */
	qysh.setShsj(new Date());

	/** @ 审核人(shr) */
	qysh.setShr("test");

	/** @ 审核单位代码(shdwdm) */
	qysh.setShdwdm("test");

	/** @ 审核单位名称(shdwmc) */
	qysh.setShdwmc("test");

	/** @ 审核失败原因(shsbyy) */
	qysh.setShsbyy("test");

	/** @ 上级审核ID(sjshid) */
	qysh.setSjshid(0);

	/** @ 审核状态(shzt) */
	qysh.setShzt("test");

		/*
		//插入对象
		qyshService.insertQysh(qysh);

		//读取对象比较
		BaseObject bo = qyshService.getQysh(qysh);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qysh qyshNew = (Qysh)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyshNew.getQyshid(), qysh.getQyshid());
		assertEquals(qyshNew.getQyid(), qysh.getQyid());
		assertEquals(qyshNew.getShsj(), qysh.getShsj());
		assertEquals(qyshNew.getShr(), qysh.getShr());
		assertEquals(qyshNew.getShdwdm(), qysh.getShdwdm());
		assertEquals(qyshNew.getShdwmc(), qysh.getShdwmc());
		assertEquals(qyshNew.getShsbyy(), qysh.getShsbyy());
		assertEquals(qyshNew.getSjshid(), qysh.getSjshid());
		assertEquals(qyshNew.getShzt(), qysh.getShzt());

		//删除对象
		// @ 企业审核ID(qyshid) 
		qysh.setQyshid(1)
		// @ 企业ID(qyid) 
		qysh.setQyid(1)

		qyshService.deleteQysh(qysh);

		//修改对象
		// @ 企业审核ID(qyshid) 
		qysh.setQyshid(1)
		// @ 企业ID(qyid) 
		qysh.setQyid(1)

		qyshService.updateQysh(qysh);

		//查询单条
		// @ 企业审核ID(qyshid) 
		qysh.setQyshid(1)
		// @ 企业ID(qyid) 
		qysh.setQyid(1)

		qyshService.getQysh(qysh);

		//查询多条
		// @ 企业审核ID(qyshid) 
		qysh.setQyshid(1)
		// @ 企业ID(qyid) 
		qysh.setQyid(1)

		qyshService.getListQysh(qysh);

		//翻页查询
		// @ 企业审核ID(qyshid) 
		qysh.setQyshid(1)
		// @ 企业ID(qyid) 
		qysh.setQyid(1)

		qyshService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyshService.insertQysh(qysh);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyshService(IQyshService qyshService) {
		this.qyshService = qyshService;
	}
}
