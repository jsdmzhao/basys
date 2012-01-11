package com.aisino2.basicsystem.test;

import java.util.Date;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.basicsystem.domain.DoublePY;
import com.aisino2.basicsystem.domain.Xctb;
import com.aisino2.basicsystem.service.IDpyService;
import com.aisino2.basicsystem.service.IXctbService;

public class XctbTest extends AbstractTransactionalDataSourceSpringContextTests {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IXctbService xctbService;
	private IDpyService dpyService;
    
	
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml"};
		return paths;
	}

	/** @param 协查通报(t_xctb) */

	public void wtest() {
		Xctb xctb = new Xctb();

	/** @ 通报ID(tbid) */
	xctb.setTbid(0);

	/** @ 标题(bt) */
	xctb.setBt("test");

	/** @ 发布时间(fbsj) */
	xctb.setFbsj(new Date());

	/** @ 发布内容(fbnr) */
	xctb.setFbnr("test");

	/** @ 发布人(fbr) */
	xctb.setFbr("test");

	/** @ 发布单位(fbdw) */
	xctb.setFbdw("test");

	/** @ 行业类型(hylx) */
	xctb.setHylx("test");

	/** @ 截止日期(jzrq) */
	xctb.setJzrq(new Date());

	/** @ 过期标识(gqbs) */
	xctb.setGqbs("test");

		/*
		//插入对象
		xctbService.insertXctb(xctb);

		//读取对象比较
		BaseObject bo = xctbService.getXctb(xctb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Xctb xctbNew = (Xctb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(xctbNew.getTbid(), xctb.getTbid());
		assertEquals(xctbNew.getBt(), xctb.getBt());
		assertEquals(xctbNew.getFbsj(), xctb.getFbsj());
		assertEquals(xctbNew.getFbnr(), xctb.getFbnr());
		assertEquals(xctbNew.getFbr(), xctb.getFbr());
		assertEquals(xctbNew.getFbdw(), xctb.getFbdw());
		assertEquals(xctbNew.getHylx(), xctb.getHylx());
		assertEquals(xctbNew.getJzrq(), xctb.getJzrq());
		assertEquals(xctbNew.getGqbs(), xctb.getGqbs());

		//删除对象
		// @ 通报ID(tbid) 
		xctb.setTbid(1)

		xctbService.deleteXctb(xctb);

		//修改对象
		// @ 通报ID(tbid) 
		xctb.setTbid(1)

		xctbService.updateXctb(xctb);

		//查询单条
		// @ 通报ID(tbid) 
		xctb.setTbid(1)

		xctbService.getXctb(xctb);

		//查询多条
		// @ 通报ID(tbid) 
		xctb.setTbid(1)

		xctbService.getListXctb(xctb);

		//翻页查询
		// @ 通报ID(tbid) 
		xctb.setTbid(1)

		xctbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		xctbService.insertXctb(xctb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setXctbService(IXctbService xctbService) {
		this.xctbService = xctbService;
	}
	
	public void testxctb1(){
		
		DoublePY doublePY = new DoublePY();
		doublePY.setName("一二");
		String test = dpyService.getDoublepy(doublePY);
		System.out.println(test);

		
	}

	public void setDpyService(IDpyService dpyService) {
		this.dpyService = dpyService;
	}
}
