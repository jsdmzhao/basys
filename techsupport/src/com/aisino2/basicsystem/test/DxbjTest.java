package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Dxbj;
import com.aisino2.basicsystem.service.IDxbjService;
import com.aisino2.core.test.BaseTestCase;

public class DxbjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IDxbjService dxbjService;

	/** @param 短信报警(t_dxbj) */

	public void test() {
		Dxbj dxbj = new Dxbj();

	/** @ 报警规则ID(bjgzid) */
	dxbj.setBjgzid(0);

	/** @ 报警信息ID(bjxxid) */
	dxbj.setBjxxid(0);

	/** @ 短信报警ID(dxbjid) */
	dxbj.setDxbjid(0);

	/** @ 短信号码(dxhm) */
	dxbj.setDxhm("test");

	/** @ 第一次发送时间(dycfssj) */
	dxbj.setDycfssj(new Date());

	/** @ 最后一次发送时间(zhycfssj) */
	dxbj.setZhycfssj(new Date());

	/** @ 发送次数(fscs) */
	dxbj.setFscs(0);

	/** @ 短信状态(dxzt) */
	dxbj.setDxzt("test");

	/** @ 短信内容(dxnr) */
	dxbj.setDxnr("test");

		/*
		//插入对象
		dxbjService.insertDxbj(dxbj);

		//读取对象比较
		BaseObject bo = dxbjService.getDxbj(dxbj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Dxbj dxbjNew = (Dxbj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(dxbjNew.getBjgzid(), dxbj.getBjgzid());
		assertEquals(dxbjNew.getBjxxid(), dxbj.getBjxxid());
		assertEquals(dxbjNew.getDxbjid(), dxbj.getDxbjid());
		assertEquals(dxbjNew.getDxhm(), dxbj.getDxhm());
		assertEquals(dxbjNew.getDycfssj(), dxbj.getDycfssj());
		assertEquals(dxbjNew.getZhycfssj(), dxbj.getZhycfssj());
		assertEquals(dxbjNew.getFscs(), dxbj.getFscs());
		assertEquals(dxbjNew.getDxzt(), dxbj.getDxzt());
		assertEquals(dxbjNew.getDxnr(), dxbj.getDxnr());

		//删除对象
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 短信报警ID(dxbjid) 
		dxbj.setDxbjid(1)

		dxbjService.deleteDxbj(dxbj);

		//修改对象
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 短信报警ID(dxbjid) 
		dxbj.setDxbjid(1)

		dxbjService.updateDxbj(dxbj);

		//查询单条
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 短信报警ID(dxbjid) 
		dxbj.setDxbjid(1)

		dxbjService.getDxbj(dxbj);

		//查询多条
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 短信报警ID(dxbjid) 
		dxbj.setDxbjid(1)

		dxbjService.getListDxbj(dxbj);

		//翻页查询
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		dxbj.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		dxbj.setBjxxid(1)
		// @ 短信报警ID(dxbjid) 
		dxbj.setDxbjid(1)

		dxbjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		dxbjService.insertDxbj(dxbj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setDxbjService(IDxbjService dxbjService) {
		this.dxbjService = dxbjService;
	}
}
