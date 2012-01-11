package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Icksl_lsb;
import com.aisino2.icksystem.service.IIcksl_lsbService;

public class Icksl_lsbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IIcksl_lsbService icksl_lsbService;

	/** @param IC卡受理临时表(t_icksl_lsb) */

	public void test() {
		Icksl_lsb icksl_lsb = new Icksl_lsb();

	/** @ 原IC卡芯片号(ickhold) */
	icksl_lsb.setIckhold("test");

	/** @ 现IC卡芯片号(ickhnew) */
	icksl_lsb.setIckhnew("test");

	/** @ 录入时间(lrsj) */
	icksl_lsb.setLrsj(new Date());

	/** @ 处理时间(clsj) */
	icksl_lsb.setClsj(new Date());

	/** @ 处理标识(clbz) */
	icksl_lsb.setClbz(0);

		/*
		//插入对象
		icksl_lsbService.insertIcksl_lsb(icksl_lsb);

		//读取对象比较
		BaseObject bo = icksl_lsbService.getIcksl_lsb(icksl_lsb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Icksl_lsb icksl_lsbNew = (Icksl_lsb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(icksl_lsbNew.getIckhold(), icksl_lsb.getIckhold());
		assertEquals(icksl_lsbNew.getIckhnew(), icksl_lsb.getIckhnew());
		assertEquals(icksl_lsbNew.getLrsj(), icksl_lsb.getLrsj());
		assertEquals(icksl_lsbNew.getClsj(), icksl_lsb.getClsj());
		assertEquals(icksl_lsbNew.getClbz(), icksl_lsb.getClbz());

		//删除对象
		// @ 原IC卡芯片号(ickhold) 
		icksl_lsb.setIckhold(1)

		icksl_lsbService.deleteIcksl_lsb(icksl_lsb);

		//修改对象
		// @ 原IC卡芯片号(ickhold) 
		icksl_lsb.setIckhold(1)

		icksl_lsbService.updateIcksl_lsb(icksl_lsb);

		//查询单条
		// @ 原IC卡芯片号(ickhold) 
		icksl_lsb.setIckhold(1)

		icksl_lsbService.getIcksl_lsb(icksl_lsb);

		//查询多条
		// @ 原IC卡芯片号(ickhold) 
		icksl_lsb.setIckhold(1)

		icksl_lsbService.getListIcksl_lsb(icksl_lsb);

		//翻页查询
		// @ 原IC卡芯片号(ickhold) 
		icksl_lsb.setIckhold(1)

		icksl_lsbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		icksl_lsbService.insertIcksl_lsb(icksl_lsb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setIcksl_lsbService(IIcksl_lsbService icksl_lsbService) {
		this.icksl_lsbService = icksl_lsbService;
	}
}
