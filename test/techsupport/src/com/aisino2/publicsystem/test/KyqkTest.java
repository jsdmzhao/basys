package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Kyqk;
import com.aisino2.publicsystem.service.IKyqkService;

public class KyqkTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IKyqkService kyqkService;

	/** @param 可疑情况(t_kyqk) */

	public void test() {
		Kyqk kyqk = new Kyqk();

	/** @ 企业ID(qyid) */
	kyqk.setQyid(0);

	/** @ 可疑情况ID(kyqkid) */
	kyqk.setKyqkid(0);

	/** @ 可疑情况登记序号(kyqkdjxh) */
	kyqk.setKyqkdjxh("test");

	/** @ 可疑情况类型代码(kyqklxbm) */
	kyqk.setKyqklxbm("test");

	/** @ 可疑情况类型(kyqklx) */
	kyqk.setKyqklx("test");

	/** @ 疑点详细描述(ydxxms) */
	kyqk.setYdxxms("test");

	/** @ 填报人编号(tbrbh) */
	kyqk.setTbrbh("test");

	/** @ 填报人姓名(tbrxm) */
	kyqk.setTbrxm("test");

	/** @ 填报时间(tbsj) */
	kyqk.setTbsj(new Date());

	/** @ 接警时间(jjsj) */
	kyqk.setJjsj(new Date());

	/** @ 接警人姓名(jjrxm) */
	kyqk.setJjrxm("test");

	/** @ 接警处理结果(jjcljg) */
	kyqk.setJjcljg("test");

		/*
		//插入对象
		kyqkService.insertKyqk(kyqk);

		//读取对象比较
		BaseObject bo = kyqkService.getKyqk(kyqk);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Kyqk kyqkNew = (Kyqk)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(kyqkNew.getQyid(), kyqk.getQyid());
		assertEquals(kyqkNew.getKyqkid(), kyqk.getKyqkid());
		assertEquals(kyqkNew.getKyqkdjxh(), kyqk.getKyqkdjxh());
		assertEquals(kyqkNew.getKyqklxbm(), kyqk.getKyqklxbm());
		assertEquals(kyqkNew.getKyqklx(), kyqk.getKyqklx());
		assertEquals(kyqkNew.getYdxxms(), kyqk.getYdxxms());
		assertEquals(kyqkNew.getTbrbh(), kyqk.getTbrbh());
		assertEquals(kyqkNew.getTbrxm(), kyqk.getTbrxm());
		assertEquals(kyqkNew.getTbsj(), kyqk.getTbsj());
		assertEquals(kyqkNew.getJjsj(), kyqk.getJjsj());
		assertEquals(kyqkNew.getJjrxm(), kyqk.getJjrxm());
		assertEquals(kyqkNew.getJjcljg(), kyqk.getJjcljg());

		//删除对象
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 可疑情况ID(kyqkid) 
		kyqk.setKyqkid(1)

		kyqkService.deleteKyqk(kyqk);

		//修改对象
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 可疑情况ID(kyqkid) 
		kyqk.setKyqkid(1)

		kyqkService.updateKyqk(kyqk);

		//查询单条
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 可疑情况ID(kyqkid) 
		kyqk.setKyqkid(1)

		kyqkService.getKyqk(kyqk);

		//查询多条
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 可疑情况ID(kyqkid) 
		kyqk.setKyqkid(1)

		kyqkService.getListKyqk(kyqk);

		//翻页查询
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 企业ID(qyid) 
		kyqk.setQyid(1)
		// @ 可疑情况ID(kyqkid) 
		kyqk.setKyqkid(1)

		kyqkService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		kyqkService.insertKyqk(kyqk);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setKyqkService(IKyqkService kyqkService) {
		this.kyqkService = kyqkService;
	}
}
