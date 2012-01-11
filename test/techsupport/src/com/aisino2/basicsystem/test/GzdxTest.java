package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Gzdx;
import com.aisino2.basicsystem.service.IGzdxService;
import com.aisino2.core.test.BaseTestCase;

public class GzdxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IGzdxService gzdxService;

	/** @param 关注对象(t_gzdx) */

	public void test() {
		Gzdx gzdx = new Gzdx();

	/** @ 关注对象ID(gzdxid) */
	gzdx.setGzdxid(0);

	/** @ 姓名(xm) */
	gzdx.setXm("test");

	/** @ 别名(bm) */
	gzdx.setBm("test");

	/** @ 姓名拼音(xmpy) */
	gzdx.setXmpy("test");

	/** @ 民族代码(mzdm) */
	gzdx.setMzdm("test");

	/** @ 民族(minzu) */
	gzdx.setMinzu("test");

	/** @ 性别代码(xbdm) */
	gzdx.setXbdm("test");

	/** @ 性别(xb) */
	gzdx.setXb("test");

	/** @ 出生日期(csrq) */
	gzdx.setCsrq(new Date());

	/** @ 户籍地行政区划(hjdxzqh) */
	gzdx.setHjdxzqh("test");

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	gzdx.setHjdxzqhdm("test");

	/** @ 户籍地详址(hjdxz) */
	gzdx.setHjdxz("test");

	/** @ 常用证件代码(cyzjdm) */
	gzdx.setCyzjdm("test");

	/** @ 常用证件(cyzj) */
	gzdx.setCyzj("test");

	/** @ 证件号码(zjhm) */
	gzdx.setZjhm("test");

	/** @ 文化程度编码(whcdbm) */
	gzdx.setWhcdbm("test");

	/** @ 文化程度(whcd) */
	gzdx.setWhcd("test");

	/** @ 关注对象身份(gzdxsf) */
	gzdx.setGzdxsf("test");

	/** @ 身高(shengao) */
	gzdx.setShengao(new Float(9.9));

	/** @ 现住地区编码(xzdqbm) */
	gzdx.setXzdqbm("test");

	/** @ 现住地区(xzdq) */
	gzdx.setXzdq("test");

	/** @ 现住地区祥址(xzdqxz) */
	gzdx.setXzdqxz("test");

	/** @ 专长编码(zcbm) */
	gzdx.setZcbm("test");

	/** @ 专长(zc) */
	gzdx.setZc("test");

	/** @ 填报单位编码(tbdabm) */
	gzdx.setTbdabm("test");

	/** @ 填报单位(tbdw) */
	gzdx.setTbdw("test");

	/** @ 填表人(tbr) */
	gzdx.setTbr("test");

	/** @ 填报日期(tbrq) */
	gzdx.setTbrq(new Date());

	/** @ 注销标志(zxbz) */
	gzdx.setZxbz("test");

	/** @ 注销日期(zxrq) */
	gzdx.setZxrq(new Date());

	/** @ 注销人(zxr) */
	gzdx.setZxr("test");

	/** @ 备注(bz) */
	gzdx.setBz("test");

		/*
		//插入对象
		gzdxService.insertGzdx(gzdx);

		//读取对象比较
		BaseObject bo = gzdxService.getGzdx(gzdx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Gzdx gzdxNew = (Gzdx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(gzdxNew.getGzdxid(), gzdx.getGzdxid());
		assertEquals(gzdxNew.getXm(), gzdx.getXm());
		assertEquals(gzdxNew.getBm(), gzdx.getBm());
		assertEquals(gzdxNew.getXmpy(), gzdx.getXmpy());
		assertEquals(gzdxNew.getMzdm(), gzdx.getMzdm());
		assertEquals(gzdxNew.getMinzu(), gzdx.getMinzu());
		assertEquals(gzdxNew.getXbdm(), gzdx.getXbdm());
		assertEquals(gzdxNew.getXb(), gzdx.getXb());
		assertEquals(gzdxNew.getCsrq(), gzdx.getCsrq());
		assertEquals(gzdxNew.getHjdxzqh(), gzdx.getHjdxzqh());
		assertEquals(gzdxNew.getHjdxzqhdm(), gzdx.getHjdxzqhdm());
		assertEquals(gzdxNew.getHjdxz(), gzdx.getHjdxz());
		assertEquals(gzdxNew.getCyzjdm(), gzdx.getCyzjdm());
		assertEquals(gzdxNew.getCyzj(), gzdx.getCyzj());
		assertEquals(gzdxNew.getZjhm(), gzdx.getZjhm());
		assertEquals(gzdxNew.getWhcdbm(), gzdx.getWhcdbm());
		assertEquals(gzdxNew.getWhcd(), gzdx.getWhcd());
		assertEquals(gzdxNew.getGzdxsf(), gzdx.getGzdxsf());
		assertEquals(gzdxNew.getShengao(), gzdx.getShengao());
		assertEquals(gzdxNew.getXzdqbm(), gzdx.getXzdqbm());
		assertEquals(gzdxNew.getXzdq(), gzdx.getXzdq());
		assertEquals(gzdxNew.getXzdqxz(), gzdx.getXzdqxz());
		assertEquals(gzdxNew.getZcbm(), gzdx.getZcbm());
		assertEquals(gzdxNew.getZc(), gzdx.getZc());
		assertEquals(gzdxNew.getTbdabm(), gzdx.getTbdabm());
		assertEquals(gzdxNew.getTbdw(), gzdx.getTbdw());
		assertEquals(gzdxNew.getTbr(), gzdx.getTbr());
		assertEquals(gzdxNew.getTbrq(), gzdx.getTbrq());
		assertEquals(gzdxNew.getZxbz(), gzdx.getZxbz());
		assertEquals(gzdxNew.getZxrq(), gzdx.getZxrq());
		assertEquals(gzdxNew.getZxr(), gzdx.getZxr());
		assertEquals(gzdxNew.getBz(), gzdx.getBz());

		//删除对象
		// @ 关注对象ID(gzdxid) 
		gzdx.setGzdxid(1)

		gzdxService.deleteGzdx(gzdx);

		//修改对象
		// @ 关注对象ID(gzdxid) 
		gzdx.setGzdxid(1)

		gzdxService.updateGzdx(gzdx);

		//查询单条
		// @ 关注对象ID(gzdxid) 
		gzdx.setGzdxid(1)

		gzdxService.getGzdx(gzdx);

		//查询多条
		// @ 关注对象ID(gzdxid) 
		gzdx.setGzdxid(1)

		gzdxService.getListGzdx(gzdx);

		//翻页查询
		// @ 关注对象ID(gzdxid) 
		gzdx.setGzdxid(1)

		gzdxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		gzdxService.insertGzdx(gzdx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setGzdxService(IGzdxService gzdxService) {
		this.gzdxService = gzdxService;
	}
}
