package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Tjclxx;
import com.aisino2.publicsystem.service.ITjclxxService;

public class TjclxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ITjclxxService tjclxxService;

	/** @param 提交材料信息(t_tjclxx) */

	public void test() {
		Tjclxx tjclxx = new Tjclxx();

	/** @ 提交材料信息ID(tjclxxid) */
	tjclxx.setTjclxxid(0);

	/** @ 企业ID(qyid) */
	tjclxx.setQyid(0);

	/** @ 企业备案信息ID(qybaxxid) */
	tjclxx.setQybaxxid(0);

	/** @ 提交材料类型代码(tjcllxdm) */
	tjclxx.setTjcllxdm("test");

	/** @ 提交材料类型(tjcllx) */
	tjclxx.setTjcllx("test");

	/** @ 提交日期(tijiaorq) */
	tjclxx.setTijiaorq(new Date());

	/** @ 提交人姓名(tjrxm) */
	tjclxx.setTjrxm("test");

	/** @ 提交材料内容(tjclnr) */
	tjclxx.setTjclnr(null);

		/*
		//插入对象
		tjclxxService.insertTjclxx(tjclxx);

		//读取对象比较
		BaseObject bo = tjclxxService.getTjclxx(tjclxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Tjclxx tjclxxNew = (Tjclxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(tjclxxNew.getTjclxxid(), tjclxx.getTjclxxid());
		assertEquals(tjclxxNew.getQyid(), tjclxx.getQyid());
		assertEquals(tjclxxNew.getQybaxxid(), tjclxx.getQybaxxid());
		assertEquals(tjclxxNew.getTjcllxdm(), tjclxx.getTjcllxdm());
		assertEquals(tjclxxNew.getTjcllx(), tjclxx.getTjcllx());
		assertEquals(tjclxxNew.getTijiaorq(), tjclxx.getTijiaorq());
		assertEquals(tjclxxNew.getTjrxm(), tjclxx.getTjrxm());
		assertEquals(tjclxxNew.getTjclnr(), tjclxx.getTjclnr());

		//删除对象
		// @ 提交材料信息ID(tjclxxid) 
		tjclxx.setTjclxxid(1)
		// @ 企业ID(qyid) 
		tjclxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		tjclxx.setQybaxxid(1)

		tjclxxService.deleteTjclxx(tjclxx);

		//修改对象
		// @ 提交材料信息ID(tjclxxid) 
		tjclxx.setTjclxxid(1)
		// @ 企业ID(qyid) 
		tjclxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		tjclxx.setQybaxxid(1)

		tjclxxService.updateTjclxx(tjclxx);

		//查询单条
		// @ 提交材料信息ID(tjclxxid) 
		tjclxx.setTjclxxid(1)
		// @ 企业ID(qyid) 
		tjclxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		tjclxx.setQybaxxid(1)

		tjclxxService.getTjclxx(tjclxx);

		//查询多条
		// @ 提交材料信息ID(tjclxxid) 
		tjclxx.setTjclxxid(1)
		// @ 企业ID(qyid) 
		tjclxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		tjclxx.setQybaxxid(1)

		tjclxxService.getListTjclxx(tjclxx);

		//翻页查询
		// @ 提交材料信息ID(tjclxxid) 
		tjclxx.setTjclxxid(1)
		// @ 企业ID(qyid) 
		tjclxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		tjclxx.setQybaxxid(1)

		tjclxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		tjclxxService.insertTjclxx(tjclxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setTjclxxService(ITjclxxService tjclxxService) {
		this.tjclxxService = tjclxxService;
	}
}
