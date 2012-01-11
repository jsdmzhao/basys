package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Dxyj;
import com.aisino2.basicsystem.service.IDxyjService;
import com.aisino2.core.test.BaseTestCase;

public class DxyjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IDxyjService dxyjService;

	/** @param 短信预警(t_dxyj) */

	public void test() {
		Dxyj dxyj = new Dxyj();

	/** @ 预警规则ID(yjgzid) */
	dxyj.setYjgzid(0);

	/** @ 预警信息ID(yjxxid) */
	dxyj.setYjxxid(0);

	/** @ 短信预警ID(dxyjid) */
	dxyj.setDxyjid(0);

	/** @ 短信号码(dxhm) */
	dxyj.setDxhm("test");

	/** @ 第一次发送时间(dycfssj) */
	dxyj.setDycfssj(new Date());

	/** @ 最后一次发送时间(zhycfssj) */
	dxyj.setZhycfssj(new Date());

	/** @ 发送次数(fscs) */
	dxyj.setFscs(0);

	/** @ 短信状态(dxzt) */
	dxyj.setDxzt("test");

	/** @ 短信内容(dxnr) */
	dxyj.setDxnr("test");

		/*
		//插入对象
		dxyjService.insertDxyj(dxyj);

		//读取对象比较
		BaseObject bo = dxyjService.getDxyj(dxyj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Dxyj dxyjNew = (Dxyj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(dxyjNew.getYjgzid(), dxyj.getYjgzid());
		assertEquals(dxyjNew.getYjxxid(), dxyj.getYjxxid());
		assertEquals(dxyjNew.getDxyjid(), dxyj.getDxyjid());
		assertEquals(dxyjNew.getDxhm(), dxyj.getDxhm());
		assertEquals(dxyjNew.getDycfssj(), dxyj.getDycfssj());
		assertEquals(dxyjNew.getZhycfssj(), dxyj.getZhycfssj());
		assertEquals(dxyjNew.getFscs(), dxyj.getFscs());
		assertEquals(dxyjNew.getDxzt(), dxyj.getDxzt());
		assertEquals(dxyjNew.getDxnr(), dxyj.getDxnr());

		//删除对象
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 短信预警ID(dxyjid) 
		dxyj.setDxyjid(1)

		dxyjService.deleteDxyj(dxyj);

		//修改对象
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 短信预警ID(dxyjid) 
		dxyj.setDxyjid(1)

		dxyjService.updateDxyj(dxyj);

		//查询单条
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 短信预警ID(dxyjid) 
		dxyj.setDxyjid(1)

		dxyjService.getDxyj(dxyj);

		//查询多条
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 短信预警ID(dxyjid) 
		dxyj.setDxyjid(1)

		dxyjService.getListDxyj(dxyj);

		//翻页查询
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		dxyj.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		dxyj.setYjxxid(1)
		// @ 短信预警ID(dxyjid) 
		dxyj.setDxyjid(1)

		dxyjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		dxyjService.insertDxyj(dxyj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setDxyjService(IDxyjService dxyjService) {
		this.dxyjService = dxyjService;
	}
}
