package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Qgztjx;
import com.aisino2.basicsystem.service.IQgztjxService;
import com.aisino2.core.test.BaseTestCase;

public class QgztjxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQgztjxService qgztjxService;

	/** @param 全国在逃简项(t_qgztjx) */

	public void test() {
		Qgztjx qgztjx = new Qgztjx();

	/** @ 全国在逃简项ID(qgztjxid) */
	qgztjx.setQgztjxid(0);

	/** @ 通报编号(tbbh) */
	qgztjx.setTbbh("test");

	/** @ 行政区划编码(xzqhbm) */
	qgztjx.setXzqhbm("test");

	/** @ 行政区划(xzqh) */
	qgztjx.setXzqh("test");

	/** @ 姓名拼音(xmpy) */
	qgztjx.setXmpy("test");

	/** @ 姓名(xm) */
	qgztjx.setXm("test");

	/** @ 别名(bm) */
	qgztjx.setBm("test");

	/** @ 性别代码(xbdm) */
	qgztjx.setXbdm("test");

	/** @ 性别(xb) */
	qgztjx.setXb("test");

	/** @ 出生日期(csrq) */
	qgztjx.setCsrq(new Date());

	/** @ 公民身份号码(gmsfhm) */
	qgztjx.setGmsfhm("test");

	/** @ 户籍地编码(hjdbm) */
	qgztjx.setHjdbm("test");

	/** @ 户籍地(hjd) */
	qgztjx.setHjd("test");

	/** @ 户籍详细地址(hjxxdz) */
	qgztjx.setHjxxdz("test");

	/** @ 现住地区编码(xzdqbm) */
	qgztjx.setXzdqbm("test");

	/** @ 现住地区(xzdq) */
	qgztjx.setXzdq("test");

	/** @ 现住地详细地址(xzdxxdz) */
	qgztjx.setXzdxxdz("test");

	/** @ 其他证件类型(qtzjlx) */
	qgztjx.setQtzjlx("test");

	/** @ 其他证件号码(qtzjhm) */
	qgztjx.setQtzjhm("test");

	/** @ 案件级别编码(ajjbbm) */
	qgztjx.setAjjbbm("test");

	/** @ 案件级别(ajjb) */
	qgztjx.setAjjb("test");

	/** @ 案件类别编码(ajlbbm) */
	qgztjx.setAjlbbm("test");

	/** @ 案件类别(ajlb) */
	qgztjx.setAjlb("test");

	/** @ 简要案情(jyaq) */
	qgztjx.setJyaq("test");

	/** @ 登记日期(djrq) */
	qgztjx.setDjrq(new Date());

	/** @ 登记人(djr) */
	qgztjx.setDjr("test");

	/** @ 立案地区编码(ladqbm) */
	qgztjx.setLadqbm("test");

	/** @ 立案地区(ladq) */
	qgztjx.setLadq("test");

	/** @ 办案单位编码(badwbm) */
	qgztjx.setBadwbm("test");

	/** @ 办案单位(badw) */
	qgztjx.setBadw("test");

	/** @ 填表人(tbr) */
	qgztjx.setTbr("test");

	/** @ 联系人(lxr) */
	qgztjx.setLxr("test");

	/** @ 联系方式(lxfs) */
	qgztjx.setLxfs("test");

		/*
		//插入对象
		qgztjxService.insertQgztjx(qgztjx);

		//读取对象比较
		BaseObject bo = qgztjxService.getQgztjx(qgztjx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qgztjx qgztjxNew = (Qgztjx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qgztjxNew.getQgztjxid(), qgztjx.getQgztjxid());
		assertEquals(qgztjxNew.getTbbh(), qgztjx.getTbbh());
		assertEquals(qgztjxNew.getXzqhbm(), qgztjx.getXzqhbm());
		assertEquals(qgztjxNew.getXzqh(), qgztjx.getXzqh());
		assertEquals(qgztjxNew.getXmpy(), qgztjx.getXmpy());
		assertEquals(qgztjxNew.getXm(), qgztjx.getXm());
		assertEquals(qgztjxNew.getBm(), qgztjx.getBm());
		assertEquals(qgztjxNew.getXbdm(), qgztjx.getXbdm());
		assertEquals(qgztjxNew.getXb(), qgztjx.getXb());
		assertEquals(qgztjxNew.getCsrq(), qgztjx.getCsrq());
		assertEquals(qgztjxNew.getGmsfhm(), qgztjx.getGmsfhm());
		assertEquals(qgztjxNew.getHjdbm(), qgztjx.getHjdbm());
		assertEquals(qgztjxNew.getHjd(), qgztjx.getHjd());
		assertEquals(qgztjxNew.getHjxxdz(), qgztjx.getHjxxdz());
		assertEquals(qgztjxNew.getXzdqbm(), qgztjx.getXzdqbm());
		assertEquals(qgztjxNew.getXzdq(), qgztjx.getXzdq());
		assertEquals(qgztjxNew.getXzdxxdz(), qgztjx.getXzdxxdz());
		assertEquals(qgztjxNew.getQtzjlx(), qgztjx.getQtzjlx());
		assertEquals(qgztjxNew.getQtzjhm(), qgztjx.getQtzjhm());
		assertEquals(qgztjxNew.getAjjbbm(), qgztjx.getAjjbbm());
		assertEquals(qgztjxNew.getAjjb(), qgztjx.getAjjb());
		assertEquals(qgztjxNew.getAjlbbm(), qgztjx.getAjlbbm());
		assertEquals(qgztjxNew.getAjlb(), qgztjx.getAjlb());
		assertEquals(qgztjxNew.getJyaq(), qgztjx.getJyaq());
		assertEquals(qgztjxNew.getDjrq(), qgztjx.getDjrq());
		assertEquals(qgztjxNew.getDjr(), qgztjx.getDjr());
		assertEquals(qgztjxNew.getLadqbm(), qgztjx.getLadqbm());
		assertEquals(qgztjxNew.getLadq(), qgztjx.getLadq());
		assertEquals(qgztjxNew.getBadwbm(), qgztjx.getBadwbm());
		assertEquals(qgztjxNew.getBadw(), qgztjx.getBadw());
		assertEquals(qgztjxNew.getTbr(), qgztjx.getTbr());
		assertEquals(qgztjxNew.getLxr(), qgztjx.getLxr());
		assertEquals(qgztjxNew.getLxfs(), qgztjx.getLxfs());

		//删除对象
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx.setQgztjxid(1)

		qgztjxService.deleteQgztjx(qgztjx);

		//修改对象
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx.setQgztjxid(1)

		qgztjxService.updateQgztjx(qgztjx);

		//查询单条
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx.setQgztjxid(1)

		qgztjxService.getQgztjx(qgztjx);

		//查询多条
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx.setQgztjxid(1)

		qgztjxService.getListQgztjx(qgztjx);

		//翻页查询
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx.setQgztjxid(1)

		qgztjxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//qgztjxService.insertQgztjx(qgztjx);
		//保存到数据库，如不想保存到数据库，可注释此句
		//Date date=DateToString.toDate("2009-01-18");
		//qgztjxService.getFtpUpdate(date);
		//this.setComplete();
		qgztjxService.getDictitem();
		this.setComplete();
	}

	public void setQgztjxService(IQgztjxService qgztjxService) {
		this.qgztjxService = qgztjxService;
	}
}
