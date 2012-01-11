package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Qgztjx_kz;
import com.aisino2.basicsystem.service.IQgztjx_kzService;
import com.aisino2.core.test.BaseTestCase;

public class Qgztjx_kzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQgztjx_kzService qgztjx_kzService;

	/** @param 全国在逃简项快照(t_qgztjx_kz) */

	public void test() {
		Qgztjx_kz qgztjx_kz = new Qgztjx_kz();

	/** @ 报警规则ID(bjgzid) */
	qgztjx_kz.setBjgzid(0);

	/** @ 报警信息ID(bjxxid) */
	qgztjx_kz.setBjxxid(0);

	/** @ 全国在逃简项快照ID(qgztjxkzid) */
	qgztjx_kz.setQgztjxkzid(0);

	/** @ 通报编号(tbbh) */
	qgztjx_kz.setTbbh("test");

	/** @ 行政区划编码(xzqhbm) */
	qgztjx_kz.setXzqhbm("test");

	/** @ 行政区划(xzqh) */
	qgztjx_kz.setXzqh("test");

	/** @ 姓名拼音(xmpy) */
	qgztjx_kz.setXmpy("test");

	/** @ 姓名(xm) */
	qgztjx_kz.setXm("test");

	/** @ 别名(bm) */
	qgztjx_kz.setBm("test");

	/** @ 性别代码(xbdm) */
	qgztjx_kz.setXbdm("test");

	/** @ 性别(xb) */
	qgztjx_kz.setXb("test");

	/** @ 出生日期(csrq) */
	qgztjx_kz.setCsrq(new Date());

	/** @ 公民身份号码(gmsfhm) */
	qgztjx_kz.setGmsfhm("test");

	/** @ 户籍地编码(hjdbm) */
	qgztjx_kz.setHjdbm("test");

	/** @ 户籍地(hjd) */
	qgztjx_kz.setHjd("test");

	/** @ 户籍详细地址(hjxxdz) */
	qgztjx_kz.setHjxxdz("test");

	/** @ 现住地区编码(xzdqbm) */
	qgztjx_kz.setXzdqbm("test");

	/** @ 现住地区(xzdq) */
	qgztjx_kz.setXzdq("test");

	/** @ 现住地详细地址(xzdxxdz) */
	qgztjx_kz.setXzdxxdz("test");

	/** @ 其他证件类型(qtzjlx) */
	qgztjx_kz.setQtzjlx("test");

	/** @ 其他证件号码(qtzjhm) */
	qgztjx_kz.setQtzjhm("test");

	/** @ 案件级别编码(ajjbbm) */
	qgztjx_kz.setAjjbbm("test");

	/** @ 案件级别(ajjb) */
	qgztjx_kz.setAjjb("test");

	/** @ 案件类别编码(ajlbbm) */
	qgztjx_kz.setAjlbbm("test");

	/** @ 案件类别(ajlb) */
	qgztjx_kz.setAjlb("test");

	/** @ 简要案情(jyaq) */
	qgztjx_kz.setJyaq("test");

	/** @ 登记日期(djrq) */
	qgztjx_kz.setDjrq(new Date());

	/** @ 登记人(djr) */
	qgztjx_kz.setDjr("test");

	/** @ 立案地区编码(ladqbm) */
	qgztjx_kz.setLadqbm("test");

	/** @ 立案地区(ladq) */
	qgztjx_kz.setLadq("test");

	/** @ 办案单位编码(badwbm) */
	qgztjx_kz.setBadwbm("test");

	/** @ 办案单位(badw) */
	qgztjx_kz.setBadw("test");

	/** @ 填表人(tbr) */
	qgztjx_kz.setTbr("test");

	/** @ 联系人(lxr) */
	qgztjx_kz.setLxr("test");

	/** @ 联系方式(lxfs) */
	qgztjx_kz.setLxfs("test");

		/*
		//插入对象
		qgztjx_kzService.insertQgztjx_kz(qgztjx_kz);

		//读取对象比较
		BaseObject bo = qgztjx_kzService.getQgztjx_kz(qgztjx_kz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qgztjx_kz qgztjx_kzNew = (Qgztjx_kz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qgztjx_kzNew.getQgztjxid(), qgztjx_kz.getQgztjxid());
		assertEquals(qgztjx_kzNew.getBjgzid(), qgztjx_kz.getBjgzid());
		assertEquals(qgztjx_kzNew.getBjxxid(), qgztjx_kz.getBjxxid());
		assertEquals(qgztjx_kzNew.getQgztjxkzid(), qgztjx_kz.getQgztjxkzid());
		assertEquals(qgztjx_kzNew.getTbbh(), qgztjx_kz.getTbbh());
		assertEquals(qgztjx_kzNew.getXzqhbm(), qgztjx_kz.getXzqhbm());
		assertEquals(qgztjx_kzNew.getXzqh(), qgztjx_kz.getXzqh());
		assertEquals(qgztjx_kzNew.getXmpy(), qgztjx_kz.getXmpy());
		assertEquals(qgztjx_kzNew.getXm(), qgztjx_kz.getXm());
		assertEquals(qgztjx_kzNew.getBm(), qgztjx_kz.getBm());
		assertEquals(qgztjx_kzNew.getXbdm(), qgztjx_kz.getXbdm());
		assertEquals(qgztjx_kzNew.getXb(), qgztjx_kz.getXb());
		assertEquals(qgztjx_kzNew.getCsrq(), qgztjx_kz.getCsrq());
		assertEquals(qgztjx_kzNew.getGmsfhm(), qgztjx_kz.getGmsfhm());
		assertEquals(qgztjx_kzNew.getHjdbm(), qgztjx_kz.getHjdbm());
		assertEquals(qgztjx_kzNew.getHjd(), qgztjx_kz.getHjd());
		assertEquals(qgztjx_kzNew.getHjxxdz(), qgztjx_kz.getHjxxdz());
		assertEquals(qgztjx_kzNew.getXzdqbm(), qgztjx_kz.getXzdqbm());
		assertEquals(qgztjx_kzNew.getXzdq(), qgztjx_kz.getXzdq());
		assertEquals(qgztjx_kzNew.getXzdxxdz(), qgztjx_kz.getXzdxxdz());
		assertEquals(qgztjx_kzNew.getQtzjlx(), qgztjx_kz.getQtzjlx());
		assertEquals(qgztjx_kzNew.getQtzjhm(), qgztjx_kz.getQtzjhm());
		assertEquals(qgztjx_kzNew.getAjjbbm(), qgztjx_kz.getAjjbbm());
		assertEquals(qgztjx_kzNew.getAjjb(), qgztjx_kz.getAjjb());
		assertEquals(qgztjx_kzNew.getAjlbbm(), qgztjx_kz.getAjlbbm());
		assertEquals(qgztjx_kzNew.getAjlb(), qgztjx_kz.getAjlb());
		assertEquals(qgztjx_kzNew.getJyaq(), qgztjx_kz.getJyaq());
		assertEquals(qgztjx_kzNew.getDjrq(), qgztjx_kz.getDjrq());
		assertEquals(qgztjx_kzNew.getDjr(), qgztjx_kz.getDjr());
		assertEquals(qgztjx_kzNew.getLadqbm(), qgztjx_kz.getLadqbm());
		assertEquals(qgztjx_kzNew.getLadq(), qgztjx_kz.getLadq());
		assertEquals(qgztjx_kzNew.getBadwbm(), qgztjx_kz.getBadwbm());
		assertEquals(qgztjx_kzNew.getBadw(), qgztjx_kz.getBadw());
		assertEquals(qgztjx_kzNew.getTbr(), qgztjx_kz.getTbr());
		assertEquals(qgztjx_kzNew.getLxr(), qgztjx_kz.getLxr());
		assertEquals(qgztjx_kzNew.getLxfs(), qgztjx_kz.getLxfs());

		//删除对象
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 全国在逃简项快照ID(qgztjxkzid) 
		qgztjx_kz.setQgztjxkzid(1)

		qgztjx_kzService.deleteQgztjx_kz(qgztjx_kz);

		//修改对象
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 全国在逃简项快照ID(qgztjxkzid) 
		qgztjx_kz.setQgztjxkzid(1)

		qgztjx_kzService.updateQgztjx_kz(qgztjx_kz);

		//查询单条
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 全国在逃简项快照ID(qgztjxkzid) 
		qgztjx_kz.setQgztjxkzid(1)

		qgztjx_kzService.getQgztjx_kz(qgztjx_kz);

		//查询多条
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 全国在逃简项快照ID(qgztjxkzid) 
		qgztjx_kz.setQgztjxkzid(1)

		qgztjx_kzService.getListQgztjx_kz(qgztjx_kz);

		//翻页查询
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 全国在逃简项ID(qgztjxid) 
		qgztjx_kz.setQgztjxid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		qgztjx_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		qgztjx_kz.setBjxxid(1)
		// @ 全国在逃简项快照ID(qgztjxkzid) 
		qgztjx_kz.setQgztjxkzid(1)

		qgztjx_kzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qgztjx_kzService.insertQgztjx_kz(qgztjx_kz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQgztjx_kzService(IQgztjx_kzService qgztjx_kzService) {
		this.qgztjx_kzService = qgztjx_kzService;
	}
}
