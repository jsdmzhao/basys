package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Dtcxtj;
import com.aisino2.basicsystem.service.IDtcxtjService;
import com.aisino2.core.test.BaseTestCase;

public class DtcxtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IDtcxtjService dtcxtjService;

	/** @param 动态查询条件(t_dtcxtj) */

	public void test() {
		Dtcxtj dtcxtj = new Dtcxtj();

	/** @ 动态查询条件ID(dtcxtjid) */
	dtcxtj.setDtcxtjid(0);

	/** @ 高级查询方案ID(gjcxfaid) */
	dtcxtj.setGjcxfaid(0);

	/** @ 数据表名(sjbm) */
	dtcxtj.setSjbm("test");

	/** @ 字段名(zdm) */
	dtcxtj.setZdm("test");

	/** @ 字段中文名(zdzwm) */
	dtcxtj.setZdzwm("test");

	/** @ 字段类型(zdlx) */
	dtcxtj.setZdlx("test");

	/** @ 字段值(zdz) */
	dtcxtj.setZdz("test");

	/** @ 显示值(xsz) */
	dtcxtj.setXsz("test");

	/** @ 匹配符(ppf) */
	dtcxtj.setPpf("test");

	/** @ 开始括号(kskh) */
	dtcxtj.setKskh("te");

	/** @ 结束括号(jskh) */
	dtcxtj.setJskh("te");

	/** @ 关系符(gxf) */
	dtcxtj.setGxf("test");

		/*
		//插入对象
		dtcxtjService.insertDtcxtj(dtcxtj);

		//读取对象比较
		BaseObject bo = dtcxtjService.getDtcxtj(dtcxtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Dtcxtj dtcxtjNew = (Dtcxtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(dtcxtjNew.getDtcxtjid(), dtcxtj.getDtcxtjid());
		assertEquals(dtcxtjNew.getGjcxfaid(), dtcxtj.getGjcxfaid());
		assertEquals(dtcxtjNew.getSjbm(), dtcxtj.getSjbm());
		assertEquals(dtcxtjNew.getZdm(), dtcxtj.getZdm());
		assertEquals(dtcxtjNew.getZdzwm(), dtcxtj.getZdzwm());
		assertEquals(dtcxtjNew.getZdlx(), dtcxtj.getZdlx());
		assertEquals(dtcxtjNew.getZdz(), dtcxtj.getZdz());
		assertEquals(dtcxtjNew.getXsz(), dtcxtj.getXsz());
		assertEquals(dtcxtjNew.getPpf(), dtcxtj.getPpf());
		assertEquals(dtcxtjNew.getKskh(), dtcxtj.getKskh());
		assertEquals(dtcxtjNew.getJskh(), dtcxtj.getJskh());
		assertEquals(dtcxtjNew.getGxf(), dtcxtj.getGxf());

		//删除对象
		// @ 动态查询条件ID(dtcxtjid) 
		dtcxtj.setDtcxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxtj.setGjcxfaid(1)

		dtcxtjService.deleteDtcxtj(dtcxtj);

		//修改对象
		// @ 动态查询条件ID(dtcxtjid) 
		dtcxtj.setDtcxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxtj.setGjcxfaid(1)

		dtcxtjService.updateDtcxtj(dtcxtj);

		//查询单条
		// @ 动态查询条件ID(dtcxtjid) 
		dtcxtj.setDtcxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxtj.setGjcxfaid(1)

		dtcxtjService.getDtcxtj(dtcxtj);

		//查询多条
		// @ 动态查询条件ID(dtcxtjid) 
		dtcxtj.setDtcxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxtj.setGjcxfaid(1)

		dtcxtjService.getListDtcxtj(dtcxtj);

		//翻页查询
		// @ 动态查询条件ID(dtcxtjid) 
		dtcxtj.setDtcxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		dtcxtj.setGjcxfaid(1)

		dtcxtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		dtcxtjService.insertDtcxtj(dtcxtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setDtcxtjService(IDtcxtjService dtcxtjService) {
		this.dtcxtjService = dtcxtjService;
	}
}
