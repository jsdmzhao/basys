package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Wscqy;
import com.aisino2.publicsystem.service.IWscqyService;

public class WscqyTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWscqyService wscqyService;

	/** @param 未上传企业(t_wscqy) */

	public void test() {
		Wscqy wscqy = new Wscqy();

	/** @ 未上传企业ID(wscqyid) */
	wscqy.setWscqyid(0);

	/** @ 行业类别代码(hylbdm) */
	wscqy.setHylbdm("test");

	/** @ 行业类别(hylb) */
	wscqy.setHylb("test");

	/** @ 未上传日期(wscrq) */
	wscqy.setWscrq(new Date());

	/** @ 地市机关代码(dsjgdm) */
	wscqy.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	wscqy.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	wscqy.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	wscqy.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	wscqy.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	wscqy.setGxdwmc("test");

	/** @ 企业编码(qybm) */
	wscqy.setQybm("test");

	/** @ 企业名称(qymc) */
	wscqy.setQymc("test");

	/** @ 联系电话(lxdh) */
	wscqy.setLxdh("test");

	/** @ 状态代码(ztdm) */
	wscqy.setZtdm("test");

		/*
		//插入对象
		wscqyService.insertWscqy(wscqy);

		//读取对象比较
		BaseObject bo = wscqyService.getWscqy(wscqy);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wscqy wscqyNew = (Wscqy)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wscqyNew.getWscqyid(), wscqy.getWscqyid());
		assertEquals(wscqyNew.getHylbdm(), wscqy.getHylbdm());
		assertEquals(wscqyNew.getHylb(), wscqy.getHylb());
		assertEquals(wscqyNew.getWscrq(), wscqy.getWscrq());
		assertEquals(wscqyNew.getDsjgdm(), wscqy.getDsjgdm());
		assertEquals(wscqyNew.getDsjgmc(), wscqy.getDsjgmc());
		assertEquals(wscqyNew.getFxjdm(), wscqy.getFxjdm());
		assertEquals(wscqyNew.getFxjmc(), wscqy.getFxjmc());
		assertEquals(wscqyNew.getGxdwdm(), wscqy.getGxdwdm());
		assertEquals(wscqyNew.getGxdwmc(), wscqy.getGxdwmc());
		assertEquals(wscqyNew.getQybm(), wscqy.getQybm());
		assertEquals(wscqyNew.getQymc(), wscqy.getQymc());
		assertEquals(wscqyNew.getLxdh(), wscqy.getLxdh());
		assertEquals(wscqyNew.getZtdm(), wscqy.getZtdm());

		//删除对象
		// @ 未上传企业ID(wscqyid) 
		wscqy.setWscqyid(1)

		wscqyService.deleteWscqy(wscqy);

		//修改对象
		// @ 未上传企业ID(wscqyid) 
		wscqy.setWscqyid(1)

		wscqyService.updateWscqy(wscqy);

		//查询单条
		// @ 未上传企业ID(wscqyid) 
		wscqy.setWscqyid(1)

		wscqyService.getWscqy(wscqy);

		//查询多条
		// @ 未上传企业ID(wscqyid) 
		wscqy.setWscqyid(1)

		wscqyService.getListWscqy(wscqy);

		//翻页查询
		// @ 未上传企业ID(wscqyid) 
		wscqy.setWscqyid(1)

		wscqyService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		wscqyService.insertWscqy(wscqy);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWscqyService(IWscqyService wscqyService) {
		this.wscqyService = wscqyService;
	}
}
