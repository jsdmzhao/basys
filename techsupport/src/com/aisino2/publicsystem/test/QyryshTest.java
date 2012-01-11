package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyrysh;
import com.aisino2.publicsystem.service.IQyryshService;

public class QyryshTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyryshService qyryshService;

	/** @param 企业人员审核(t_qyrysh) */

	public void test() {
		Qyrysh qyrysh = new Qyrysh();

	/** @ 人员审核ID(ryshid) */
	qyrysh.setRyshid(0);

	/** @ 企业ID(qyid) */
	qyrysh.setQyid(0);

	/** @ 从业人员ID(ryid) */
	qyrysh.setRyid(0);

	/** @ 审核时间(shsj) */
	qyrysh.setShsj(new Date());

	/** @ 审核人(shr) */
	qyrysh.setShr("test");

	/** @ 审核单位代码(shdwdm) */
	qyrysh.setShdwdm("test");

	/** @ 审核单位名称(shdwmc) */
	qyrysh.setShdwmc("test");

	/** @ 审核失败原因(shsbyy) */
	qyrysh.setShsbyy("test");

	/** @ 上级审核ID(sjshid) */
	qyrysh.setSjshid(0);

	/** @ 审核状态(shzt) */
	qyrysh.setShzt("test");

		/*
		//插入对象
		qyryshService.insertQyrysh(qyrysh);

		//读取对象比较
		BaseObject bo = qyryshService.getQyrysh(qyrysh);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyrysh qyryshNew = (Qyrysh)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyryshNew.getRyshid(), qyrysh.getRyshid());
		assertEquals(qyryshNew.getQyid(), qyrysh.getQyid());
		assertEquals(qyryshNew.getRyid(), qyrysh.getRyid());
		assertEquals(qyryshNew.getShsj(), qyrysh.getShsj());
		assertEquals(qyryshNew.getShr(), qyrysh.getShr());
		assertEquals(qyryshNew.getShdwdm(), qyrysh.getShdwdm());
		assertEquals(qyryshNew.getShdwmc(), qyrysh.getShdwmc());
		assertEquals(qyryshNew.getShsbyy(), qyrysh.getShsbyy());
		assertEquals(qyryshNew.getSjshid(), qyrysh.getSjshid());
		assertEquals(qyryshNew.getShzt(), qyrysh.getShzt());

		//删除对象
		// @ 人员审核ID(ryshid) 
		qyrysh.setRyshid(1)
		// @ 企业ID(qyid) 
		qyrysh.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrysh.setRyid(1)

		qyryshService.deleteQyrysh(qyrysh);

		//修改对象
		// @ 人员审核ID(ryshid) 
		qyrysh.setRyshid(1)
		// @ 企业ID(qyid) 
		qyrysh.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrysh.setRyid(1)

		qyryshService.updateQyrysh(qyrysh);

		//查询单条
		// @ 人员审核ID(ryshid) 
		qyrysh.setRyshid(1)
		// @ 企业ID(qyid) 
		qyrysh.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrysh.setRyid(1)

		qyryshService.getQyrysh(qyrysh);

		//查询多条
		// @ 人员审核ID(ryshid) 
		qyrysh.setRyshid(1)
		// @ 企业ID(qyid) 
		qyrysh.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrysh.setRyid(1)

		qyryshService.getListQyrysh(qyrysh);

		//翻页查询
		// @ 人员审核ID(ryshid) 
		qyrysh.setRyshid(1)
		// @ 企业ID(qyid) 
		qyrysh.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyrysh.setRyid(1)

		qyryshService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyryshService.insertQyrysh(qyrysh);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyryshService(IQyryshService qyryshService) {
		this.qyryshService = qyryshService;
	}
}
