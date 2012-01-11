package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Zzzxsc;
import com.aisino2.icksystem.service.IZzzxscService;

public class ZzzxscTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IZzzxscService zzzxscService;

	/** @param 制证中心上传(t_zzzxsc) */

	public void test() {
		Zzzxsc zzzxsc = new Zzzxsc();

	/** @ IC卡受理ID(ickslid) */
	zzzxsc.setIckslid(0);

	/** @ 制证中心上传ID(zzzxscid) */
	zzzxsc.setZzzxscid(0);

	/** @ 数据上传标志(sjscbz) */
	zzzxsc.setSjscbz("test");

	/** @ 发送时间(fssj) */
	zzzxsc.setFssj(new Date());

	/** @ 回馈时间(hksj) */
	zzzxsc.setHksj(new Date());

	/** @ 制证中心记录编号(zzzxjlbh) */
	zzzxsc.setZzzxjlbh("test");

	/** @ 制证错误原因(zzcwyy) */
	zzzxsc.setZzcwyy("test");

		/*
		//插入对象
		zzzxscService.insertZzzxsc(zzzxsc);

		//读取对象比较
		BaseObject bo = zzzxscService.getZzzxsc(zzzxsc);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Zzzxsc zzzxscNew = (Zzzxsc)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(zzzxscNew.getIckslid(), zzzxsc.getIckslid());
		assertEquals(zzzxscNew.getZzzxscid(), zzzxsc.getZzzxscid());
		assertEquals(zzzxscNew.getSjscbz(), zzzxsc.getSjscbz());
		assertEquals(zzzxscNew.getFssj(), zzzxsc.getFssj());
		assertEquals(zzzxscNew.getHksj(), zzzxsc.getHksj());
		assertEquals(zzzxscNew.getZzzxjlbh(), zzzxsc.getZzzxjlbh());
		assertEquals(zzzxscNew.getZzcwyy(), zzzxsc.getZzcwyy());

		//删除对象
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ 制证中心上传ID(zzzxscid) 
		zzzxsc.setZzzxscid(1)

		zzzxscService.deleteZzzxsc(zzzxsc);

		//修改对象
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ 制证中心上传ID(zzzxscid) 
		zzzxsc.setZzzxscid(1)

		zzzxscService.updateZzzxsc(zzzxsc);

		//查询单条
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ 制证中心上传ID(zzzxscid) 
		zzzxsc.setZzzxscid(1)

		zzzxscService.getZzzxsc(zzzxsc);

		//查询多条
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ 制证中心上传ID(zzzxscid) 
		zzzxsc.setZzzxscid(1)

		zzzxscService.getListZzzxsc(zzzxsc);

		//翻页查询
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ IC卡受理ID(ickslid) 
		zzzxsc.setIckslid(1)
		// @ 制证中心上传ID(zzzxscid) 
		zzzxsc.setZzzxscid(1)

		zzzxscService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		zzzxscService.insertZzzxsc(zzzxsc);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setZzzxscService(IZzzxscService zzzxscService) {
		this.zzzxscService = zzzxscService;
	}
}
