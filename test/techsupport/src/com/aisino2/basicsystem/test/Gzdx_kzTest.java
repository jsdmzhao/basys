package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Gzdx_kz;
import com.aisino2.basicsystem.service.IGzdx_kzService;
import com.aisino2.core.test.BaseTestCase;

public class Gzdx_kzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IGzdx_kzService gzdx_kzService;

	/** @param 关注对象快照(t_gzdx_kz) */

	public void test() {
		Gzdx_kz gzdx_kz = new Gzdx_kz();

	/** @ 关注对象ID(gzdxid) */
	gzdx_kz.setGzdxid(0);

	/** @ 预警规则ID(yjgzid) */
	gzdx_kz.setYjgzid(0);

	/** @ 预警信息ID(yjxxid) */
	gzdx_kz.setYjxxid(0);

	/** @ 关注对象快照ID(gzdxkzid) */
	gzdx_kz.setGzdxkzid(0);

	/** @ 姓名(xm) */
	gzdx_kz.setXm("test");

	/** @ 别名(bm) */
	gzdx_kz.setBm("test");

	/** @ 姓名拼音(xmpy) */
	gzdx_kz.setXmpy("test");

	/** @ 民族代码(mzdm) */
	gzdx_kz.setMzdm("test");

	/** @ 民族(minzu) */
	gzdx_kz.setMinzu("test");

	/** @ 性别代码(xbdm) */
	gzdx_kz.setXbdm("test");

	/** @ 性别(xb) */
	gzdx_kz.setXb("test");

	/** @ 出生日期(csrq) */
	gzdx_kz.setCsrq(new Date());

	/** @ 户籍地行政区划(hjdxzqh) */
	gzdx_kz.setHjdxzqh("test");

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	gzdx_kz.setHjdxzqhdm("test");

	/** @ 户籍地详址(hjdxz) */
	gzdx_kz.setHjdxz("test");

	/** @ 常用证件代码(cyzjdm) */
	gzdx_kz.setCyzjdm("test");

	/** @ 常用证件(cyzj) */
	gzdx_kz.setCyzj("test");

	/** @ 证件号码(zjhm) */
	gzdx_kz.setZjhm("test");

	/** @ 文化程度(whcd) */
	gzdx_kz.setWhcd("test");

	/** @ 关注对象身份(gzdxsf) */
	gzdx_kz.setGzdxsf("test");

	/** @ 身高(shengao) */
	gzdx_kz.setShengao(new Float(9.9));

	/** @ 现住地区(xzdq) */
	gzdx_kz.setXzdq("test");

	/** @ 现住地区祥址(xzdqxz) */
	gzdx_kz.setXzdqxz("test");

	/** @ 填报单位(tbdw) */
	gzdx_kz.setTbdw("test");

	/** @ 填表人(tbr) */
	gzdx_kz.setTbr("test");

	/** @ 填报日期(tbrq) */
	gzdx_kz.setTbrq(new Date());

	/** @ 填报单位编码(tbdabm) */
	gzdx_kz.setTbdabm("test");

	/** @ 注销标志(zxbz) */
	gzdx_kz.setZxbz("test");

	/** @ 注销日期(zxrq) */
	gzdx_kz.setZxrq(new Date());

	/** @ 注销人(zxr) */
	gzdx_kz.setZxr("test");

	/** @ 备注(bz) */
	gzdx_kz.setBz("test");

		/*
		//插入对象
		gzdx_kzService.insertGzdx_kz(gzdx_kz);

		//读取对象比较
		BaseObject bo = gzdx_kzService.getGzdx_kz(gzdx_kz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Gzdx_kz gzdx_kzNew = (Gzdx_kz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(gzdx_kzNew.getGzdxid(), gzdx_kz.getGzdxid());
		assertEquals(gzdx_kzNew.getYjgzid(), gzdx_kz.getYjgzid());
		assertEquals(gzdx_kzNew.getYjxxid(), gzdx_kz.getYjxxid());
		assertEquals(gzdx_kzNew.getGzdxkzid(), gzdx_kz.getGzdxkzid());
		assertEquals(gzdx_kzNew.getXm(), gzdx_kz.getXm());
		assertEquals(gzdx_kzNew.getBm(), gzdx_kz.getBm());
		assertEquals(gzdx_kzNew.getXmpy(), gzdx_kz.getXmpy());
		assertEquals(gzdx_kzNew.getMzdm(), gzdx_kz.getMzdm());
		assertEquals(gzdx_kzNew.getMinzu(), gzdx_kz.getMinzu());
		assertEquals(gzdx_kzNew.getXbdm(), gzdx_kz.getXbdm());
		assertEquals(gzdx_kzNew.getXb(), gzdx_kz.getXb());
		assertEquals(gzdx_kzNew.getCsrq(), gzdx_kz.getCsrq());
		assertEquals(gzdx_kzNew.getHjdxzqh(), gzdx_kz.getHjdxzqh());
		assertEquals(gzdx_kzNew.getHjdxzqhdm(), gzdx_kz.getHjdxzqhdm());
		assertEquals(gzdx_kzNew.getHjdxz(), gzdx_kz.getHjdxz());
		assertEquals(gzdx_kzNew.getCyzjdm(), gzdx_kz.getCyzjdm());
		assertEquals(gzdx_kzNew.getCyzj(), gzdx_kz.getCyzj());
		assertEquals(gzdx_kzNew.getZjhm(), gzdx_kz.getZjhm());
		assertEquals(gzdx_kzNew.getWhcd(), gzdx_kz.getWhcd());
		assertEquals(gzdx_kzNew.getGzdxsf(), gzdx_kz.getGzdxsf());
		assertEquals(gzdx_kzNew.getShengao(), gzdx_kz.getShengao());
		assertEquals(gzdx_kzNew.getXzdq(), gzdx_kz.getXzdq());
		assertEquals(gzdx_kzNew.getXzdqxz(), gzdx_kz.getXzdqxz());
		assertEquals(gzdx_kzNew.getTbdw(), gzdx_kz.getTbdw());
		assertEquals(gzdx_kzNew.getTbr(), gzdx_kz.getTbr());
		assertEquals(gzdx_kzNew.getTbrq(), gzdx_kz.getTbrq());
		assertEquals(gzdx_kzNew.getTbdabm(), gzdx_kz.getTbdabm());
		assertEquals(gzdx_kzNew.getZxbz(), gzdx_kz.getZxbz());
		assertEquals(gzdx_kzNew.getZxrq(), gzdx_kz.getZxrq());
		assertEquals(gzdx_kzNew.getZxr(), gzdx_kz.getZxr());
		assertEquals(gzdx_kzNew.getBz(), gzdx_kz.getBz());

		//删除对象
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 关注对象快照ID(gzdxkzid) 
		gzdx_kz.setGzdxkzid(1)

		gzdx_kzService.deleteGzdx_kz(gzdx_kz);

		//修改对象
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 关注对象快照ID(gzdxkzid) 
		gzdx_kz.setGzdxkzid(1)

		gzdx_kzService.updateGzdx_kz(gzdx_kz);

		//查询单条
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 关注对象快照ID(gzdxkzid) 
		gzdx_kz.setGzdxkzid(1)

		gzdx_kzService.getGzdx_kz(gzdx_kz);

		//查询多条
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 关注对象快照ID(gzdxkzid) 
		gzdx_kz.setGzdxkzid(1)

		gzdx_kzService.getListGzdx_kz(gzdx_kz);

		//翻页查询
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 关注对象ID(gzdxid) 
		gzdx_kz.setGzdxid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		gzdx_kz.setYjgzid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 预警信息ID(yjxxid) 
		gzdx_kz.setYjxxid(1)
		// @ 关注对象快照ID(gzdxkzid) 
		gzdx_kz.setGzdxkzid(1)

		gzdx_kzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		gzdx_kzService.insertGzdx_kz(gzdx_kz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setGzdx_kzService(IGzdx_kzService gzdx_kzService) {
		this.gzdx_kzService = gzdx_kzService;
	}
}
