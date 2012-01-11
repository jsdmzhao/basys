package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Ickyj;
import com.aisino2.icksystem.service.IIckyjService;

public class IckyjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IIckyjService ickyjService;

	/** @param IC卡预警(t_ickyj) */

	public void test() {
		Ickyj ickyj = new Ickyj();

	/** @ IC卡预警ID(ickyjid) */
	ickyj.setIckyjid(0);

	/** @ 企业ID(qyid) */
	ickyj.setQyid(0);

	/** @ 企业编码(qybm) */
	ickyj.setQybm("test");

	/** @ 企业名称(qymc) */
	ickyj.setQymc("test");

	/** @ 刷卡时间(sksj) */
	ickyj.setSksj(new Date());

	/** @ 地市机关代码(dsjgdm) */
	ickyj.setDsjgdm("test");

	/** @ 地市机关名称(dsjgmc) */
	ickyj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	ickyj.setFxjdm("test");

	/** @ 分县局名称(fxjmc) */
	ickyj.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	ickyj.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	ickyj.setGxdwmc("test");

	/** @ 从业人员编号(cyrybh) */
	ickyj.setCyrybh("test");

	/** @ 姓名(xm) */
	ickyj.setXm("test");

	/** @ 姓名拼音(xmpy) */
	ickyj.setXmpy("test");

	/** @ 卡ID号(ickh) */
	ickyj.setIckh("test");

	/** @ 卡号(kh) */
	ickyj.setKh("test");

	/** @ 性别(xb) */
	ickyj.setXb("test");

	/** @ 英文名(ywm) */
	ickyj.setYwm("test");

	/** @ 英文姓(ywx) */
	ickyj.setYwx("test");

	/** @ 外国人就业许可证号(wgrjyxkz) */
	ickyj.setWgrjyxkz("test");

	/** @ 常用证件代码(cyzjdm) */
	ickyj.setCyzjdm("test");

	/** @ 常用证件(cyzj) */
	ickyj.setCyzj("test");

	/** @ 证件号码(zjhm) */
	ickyj.setZjhm("test");

	/** @ 从业类别代码(cylbdm) */
	ickyj.setCylbdm("test");

	/** @ 从业类别(cylb) */
	ickyj.setCylb("test");

	/** @ 预警原因(yjyy) */
	ickyj.setYjyy("test");

		/*
		//插入对象
		ickyjService.insertIckyj(ickyj);

		//读取对象比较
		BaseObject bo = ickyjService.getIckyj(ickyj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Ickyj ickyjNew = (Ickyj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ickyjNew.getIckyjid(), ickyj.getIckyjid());
		assertEquals(ickyjNew.getQyid(), ickyj.getQyid());
		assertEquals(ickyjNew.getQybm(), ickyj.getQybm());
		assertEquals(ickyjNew.getQymc(), ickyj.getQymc());
		assertEquals(ickyjNew.getSksj(), ickyj.getSksj());
		assertEquals(ickyjNew.getDsjgdm(), ickyj.getDsjgdm());
		assertEquals(ickyjNew.getDsjgmc(), ickyj.getDsjgmc());
		assertEquals(ickyjNew.getFxjdm(), ickyj.getFxjdm());
		assertEquals(ickyjNew.getFxjmc(), ickyj.getFxjmc());
		assertEquals(ickyjNew.getGxdwdm(), ickyj.getGxdwdm());
		assertEquals(ickyjNew.getGxdwmc(), ickyj.getGxdwmc());
		assertEquals(ickyjNew.getCyrybh(), ickyj.getCyrybh());
		assertEquals(ickyjNew.getXm(), ickyj.getXm());
		assertEquals(ickyjNew.getXmpy(), ickyj.getXmpy());
		assertEquals(ickyjNew.getIckh(), ickyj.getIckh());
		assertEquals(ickyjNew.getKh(), ickyj.getKh());
		assertEquals(ickyjNew.getXb(), ickyj.getXb());
		assertEquals(ickyjNew.getYwm(), ickyj.getYwm());
		assertEquals(ickyjNew.getYwx(), ickyj.getYwx());
		assertEquals(ickyjNew.getWgrjyxkz(), ickyj.getWgrjyxkz());
		assertEquals(ickyjNew.getCyzjdm(), ickyj.getCyzjdm());
		assertEquals(ickyjNew.getCyzj(), ickyj.getCyzj());
		assertEquals(ickyjNew.getZjhm(), ickyj.getZjhm());
		assertEquals(ickyjNew.getCylbdm(), ickyj.getCylbdm());
		assertEquals(ickyjNew.getCylb(), ickyj.getCylb());
		assertEquals(ickyjNew.getYjyy(), ickyj.getYjyy());

		//删除对象
		// @ IC卡预警ID(ickyjid) 
		ickyj.setIckyjid(1)

		ickyjService.deleteIckyj(ickyj);

		//修改对象
		// @ IC卡预警ID(ickyjid) 
		ickyj.setIckyjid(1)

		ickyjService.updateIckyj(ickyj);

		//查询单条
		// @ IC卡预警ID(ickyjid) 
		ickyj.setIckyjid(1)

		ickyjService.getIckyj(ickyj);

		//查询多条
		// @ IC卡预警ID(ickyjid) 
		ickyj.setIckyjid(1)

		ickyjService.getListIckyj(ickyj);

		//翻页查询
		// @ IC卡预警ID(ickyjid) 
		ickyj.setIckyjid(1)

		ickyjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		ickyjService.insertIckyj(ickyj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setIckyjService(IIckyjService ickyjService) {
		this.ickyjService = ickyjService;
	}
}
