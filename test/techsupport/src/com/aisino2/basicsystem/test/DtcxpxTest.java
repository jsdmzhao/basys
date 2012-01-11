package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Dtcxpx;
import com.aisino2.basicsystem.service.IDtcxpxService;
import com.aisino2.core.test.BaseTestCase;

public class DtcxpxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IDtcxpxService dtcxpxService;

	/** @param 动态查询排序(t_dtcxpx) */

	public void test() {
		Dtcxpx dtcxpx = new Dtcxpx();

	/** @ 动态查询排序ID(dtcxpxid) */
	dtcxpx.setDtcxpxid(0);

	/** @ 高级查询方案ID(gjcxfaid) */
	dtcxpx.setGjcxfaid(0);

	/** @ 数据表名(sjbm) */
	dtcxpx.setSjbm("test");

	/** @ 字段名(zdm) */
	dtcxpx.setZdm("test");

	/** @ 字段中文名(zdzwm) */
	dtcxpx.setZdzwm("test");

	/** @ 排序方式(pxfs) */
	dtcxpx.setPxfs("test");

		/*
		//插入对象
		dtcxpxService.insertDtcxpx(dtcxpx);

		//读取对象比较
		BaseObject bo = dtcxpxService.getDtcxpx(dtcxpx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Dtcxpx dtcxpxNew = (Dtcxpx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(dtcxpxNew.getDtcxpxid(), dtcxpx.getDtcxpxid());
		assertEquals(dtcxpxNew.getGjcxfaid(), dtcxpx.getGjcxfaid());
		assertEquals(dtcxpxNew.getSjbm(), dtcxpx.getSjbm());
		assertEquals(dtcxpxNew.getZdm(), dtcxpx.getZdm());
		assertEquals(dtcxpxNew.getZdzwm(), dtcxpx.getZdzwm());
		assertEquals(dtcxpxNew.getPxfs(), dtcxpx.getPxfs());

		//删除对象
		// @ 动态查询排序ID(dtcxpxid) 
		dtcxpx.setDtcxpxid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxpx.setGjcxfaid(1)

		dtcxpxService.deleteDtcxpx(dtcxpx);

		//修改对象
		// @ 动态查询排序ID(dtcxpxid) 
		dtcxpx.setDtcxpxid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxpx.setGjcxfaid(1)

		dtcxpxService.updateDtcxpx(dtcxpx);

		//查询单条
		// @ 动态查询排序ID(dtcxpxid) 
		dtcxpx.setDtcxpxid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxpx.setGjcxfaid(1)

		dtcxpxService.getDtcxpx(dtcxpx);

		//查询多条
		// @ 动态查询排序ID(dtcxpxid) 
		dtcxpx.setDtcxpxid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxpx.setGjcxfaid(1)

		dtcxpxService.getListDtcxpx(dtcxpx);

		//翻页查询
		// @ 动态查询排序ID(dtcxpxid) 
		dtcxpx.setDtcxpxid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxpx.setGjcxfaid(1)

		dtcxpxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		dtcxpxService.insertDtcxpx(dtcxpx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setDtcxpxService(IDtcxpxService dtcxpxService) {
		this.dtcxpxService = dtcxpxService;
	}
}
