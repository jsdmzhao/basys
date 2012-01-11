package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Sjbjg;
import com.aisino2.basicsystem.service.ISjbjgService;
import com.aisino2.core.test.BaseTestCase;

public class SjbjgTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ISjbjgService sjbjgService;

	/** @param 数据表结构(t_sjbjg) */

	public void test() {
		Sjbjg sjbjg = new Sjbjg();

	/** @ 数据表结构ID(sjbjgid) */
	sjbjg.setSjbjgid(0);

	/** @ 数据表ID(sjbid) */
	sjbjg.setSjbid(0);

	/** @ 字段名(zdm) */
	sjbjg.setZdm("test");

	/** @ 字段中文名(zdzwm) */
	sjbjg.setZdzwm("test");

	/** @ 字段类型(zdlx) */
	sjbjg.setZdlx("test");

	/** @ 字段长度(zdcd) */
	sjbjg.setZdcd("test");

	/** @ 缺省值(qsz) */
	sjbjg.setQsz("test");

	/** @ 排序(px) */
	sjbjg.setPx(0);

	/** @ 格式(gs) */
	sjbjg.setGs("test");

	/** @ 是否多行文本(sfdjhwb) */
	sjbjg.setSfdjhwb("te");

	/** @ 是否必填(sfbt) */
	sjbjg.setSfbt("te");

	/** @ 是否只读(sfzd) */
	sjbjg.setSfzd("te");

	/** @ 是否可见(sfkj) */
	sjbjg.setSfkj("te");

	/** @ 是否查询(sfcx) */
	sjbjg.setSfcx("te");

	/** @ 下拉框类型(xlklx) */
	sjbjg.setXlklx("test");

	/** @ 定制下拉框读取域列表(dzxlkdqy) */
	sjbjg.setDzxlkdqy("test");

	/** @ 下拉框宽度(xlkkd) */
	sjbjg.setXlkkd(0);

	/** @ 下拉框高度(xlkgd) */
	sjbjg.setXlkgd(0);

	/** @ 备注(bz) */
	sjbjg.setBz("test");

		/*
		//插入对象
		sjbjgService.insertSjbjg(sjbjg);

		//读取对象比较
		BaseObject bo = sjbjgService.getSjbjg(sjbjg);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Sjbjg sjbjgNew = (Sjbjg)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(sjbjgNew.getSjbjgid(), sjbjg.getSjbjgid());
		assertEquals(sjbjgNew.getSjbid(), sjbjg.getSjbid());
		assertEquals(sjbjgNew.getZdm(), sjbjg.getZdm());
		assertEquals(sjbjgNew.getZdzwm(), sjbjg.getZdzwm());
		assertEquals(sjbjgNew.getZdlx(), sjbjg.getZdlx());
		assertEquals(sjbjgNew.getZdcd(), sjbjg.getZdcd());
		assertEquals(sjbjgNew.getQsz(), sjbjg.getQsz());
		assertEquals(sjbjgNew.getPx(), sjbjg.getPx());
		assertEquals(sjbjgNew.getGs(), sjbjg.getGs());
		assertEquals(sjbjgNew.getSfdjhwb(), sjbjg.getSfdjhwb());
		assertEquals(sjbjgNew.getSfbt(), sjbjg.getSfbt());
		assertEquals(sjbjgNew.getSfzd(), sjbjg.getSfzd());
		assertEquals(sjbjgNew.getSfkj(), sjbjg.getSfkj());
		assertEquals(sjbjgNew.getSfcx(), sjbjg.getSfcx());
		assertEquals(sjbjgNew.getXlklx(), sjbjg.getXlklx());
		assertEquals(sjbjgNew.getDzxlkdqy(), sjbjg.getDzxlkdqy());
		assertEquals(sjbjgNew.getXlkkd(), sjbjg.getXlkkd());
		assertEquals(sjbjgNew.getXlkgd(), sjbjg.getXlkgd());
		assertEquals(sjbjgNew.getBz(), sjbjg.getBz());

		//删除对象
		// @ 数据表结构ID(sjbjgid) 
		sjbjg.setSjbjgid(1)
		// @ 数据表ID(sjbid) 
		sjbjg.setSjbid(1)

		sjbjgService.deleteSjbjg(sjbjg);

		//修改对象
		// @ 数据表结构ID(sjbjgid) 
		sjbjg.setSjbjgid(1)
		// @ 数据表ID(sjbid) 
		sjbjg.setSjbid(1)

		sjbjgService.updateSjbjg(sjbjg);

		//查询单条
		// @ 数据表结构ID(sjbjgid) 
		sjbjg.setSjbjgid(1)
		// @ 数据表ID(sjbid) 
		sjbjg.setSjbid(1)

		sjbjgService.getSjbjg(sjbjg);

		//查询多条
		// @ 数据表结构ID(sjbjgid) 
		sjbjg.setSjbjgid(1)
		// @ 数据表ID(sjbid) 
		sjbjg.setSjbid(1)

		sjbjgService.getListSjbjg(sjbjg);

		//翻页查询
		// @ 数据表结构ID(sjbjgid) 
		sjbjg.setSjbjgid(1)
		// @ 数据表ID(sjbid) 
		sjbjg.setSjbid(1)

		sjbjgService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		sjbjgService.insertSjbjg(sjbjg);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setSjbjgService(ISjbjgService sjbjgService) {
		this.sjbjgService = sjbjgService;
	}
}
