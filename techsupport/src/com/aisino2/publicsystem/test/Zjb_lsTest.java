package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Zjb_ls;
import com.aisino2.publicsystem.service.IZjb_lsService;

public class Zjb_lsTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IZjb_lsService zjb_lsService;

	/** @param 证件历史表(t_zjb_ls) */

	public void test() {
		Zjb_ls zjb_ls = new Zjb_ls();

	/** @ 企业ID(qyid) */
	zjb_ls.setQyid(0);

	/** @ 企业历史ID(qylsid) */
	zjb_ls.setQylsid(0);

	/** @ 证件历史ID(zjlsid) */
	zjb_ls.setZjlsid(0);

	/** @ 证件ID(fk_zjid) */
	zjb_ls.setFk_zjid(0);

	/** @ 证件分类(zjfl) */
	zjb_ls.setZjfl("test");

	/** @ 证件编号(zjbh) */
	zjb_ls.setZjbh("test");

	/** @ 发证机关(fzjg) */
	zjb_ls.setFzjg("test");

	/** @ 起始日期(qsrq) */
	zjb_ls.setQsrq(new Date());

	/** @ 截止日期(jzrq) */
	zjb_ls.setJzrq(new Date());

		/*
		//插入对象
		zjb_lsService.insertZjb_ls(zjb_ls);

		//读取对象比较
		BaseObject bo = zjb_lsService.getZjb_ls(zjb_ls);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Zjb_ls zjb_lsNew = (Zjb_ls)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(zjb_lsNew.getQyid(), zjb_ls.getQyid());
		assertEquals(zjb_lsNew.getQylsid(), zjb_ls.getQylsid());
		assertEquals(zjb_lsNew.getZjlsid(), zjb_ls.getZjlsid());
		assertEquals(zjb_lsNew.getFk_zjid(), zjb_ls.getFk_zjid());
		assertEquals(zjb_lsNew.getZjfl(), zjb_ls.getZjfl());
		assertEquals(zjb_lsNew.getZjbh(), zjb_ls.getZjbh());
		assertEquals(zjb_lsNew.getFzjg(), zjb_ls.getFzjg());
		assertEquals(zjb_lsNew.getQsrq(), zjb_ls.getQsrq());
		assertEquals(zjb_lsNew.getJzrq(), zjb_ls.getJzrq());

		//删除对象
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 证件历史ID(zjlsid) 
		zjb_ls.setZjlsid(1)

		zjb_lsService.deleteZjb_ls(zjb_ls);

		//修改对象
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 证件历史ID(zjlsid) 
		zjb_ls.setZjlsid(1)

		zjb_lsService.updateZjb_ls(zjb_ls);

		//查询单条
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 证件历史ID(zjlsid) 
		zjb_ls.setZjlsid(1)

		zjb_lsService.getZjb_ls(zjb_ls);

		//查询多条
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 证件历史ID(zjlsid) 
		zjb_ls.setZjlsid(1)

		zjb_lsService.getListZjb_ls(zjb_ls);

		//翻页查询
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业ID(qyid) 
		zjb_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		zjb_ls.setQylsid(1)
		// @ 证件历史ID(zjlsid) 
		zjb_ls.setZjlsid(1)

		zjb_lsService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		zjb_lsService.insertZjb_ls(zjb_ls);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setZjb_lsService(IZjb_lsService zjb_lsService) {
		this.zjb_lsService = zjb_lsService;
	}
}
