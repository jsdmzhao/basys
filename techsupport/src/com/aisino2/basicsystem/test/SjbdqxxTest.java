package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Sjbdqxx;
import com.aisino2.basicsystem.service.ISjbdqxxService;
import com.aisino2.core.test.BaseTestCase;

public class SjbdqxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ISjbdqxxService sjbdqxxService;

	/** @param 手机被盗抢信息(t_sjbdqxx) */

	public void test() {
		Sjbdqxx sjbdqxx = new Sjbdqxx();

	/** @ 手机被盗抢信息ID(sjbdqxxid) */
	sjbdqxx.setSjbdqxxid(0);

	/** @ 行政区划编码(xzqhbm) */
	sjbdqxx.setXzqhbm("test");

	/** @ 行政区划(xzqh) */
	sjbdqxx.setXzqh("test");

	/** @ 手机串号(sjch) */
	sjbdqxx.setSjch("test");

	/** @ 品牌(pp) */
	sjbdqxx.setPp("test");

	/** @ 型号(xh) */
	sjbdqxx.setXh("test");

	/** @ 颜色(ys) */
	sjbdqxx.setYs("test");

	/** @ 案件级别编码(ajjbbm) */
	sjbdqxx.setAjjbbm("test");

	/** @ 案件级别(ajjb) */
	sjbdqxx.setAjjb("test");

	/** @ 案件类别编码(ajlbbm) */
	sjbdqxx.setAjlbbm("test");

	/** @ 案件类别(ajlb) */
	sjbdqxx.setAjlb("test");

	/** @ 简要案情(jyaq) */
	sjbdqxx.setJyaq("test");

	/** @ 登记日期(djrq) */
	sjbdqxx.setDjrq(new Date());

	/** @ 登记人(djr) */
	sjbdqxx.setDjr("test");

	/** @ 立案地区编码(ladqbm) */
	sjbdqxx.setLadqbm("test");

	/** @ 立案地区(ladq) */
	sjbdqxx.setLadq("test");

	/** @ 办案单位编码(badwbm) */
	sjbdqxx.setBadwbm("test");

	/** @ 办案单位(badw) */
	sjbdqxx.setBadw("test");

	/** @ 填表人(tbr) */
	sjbdqxx.setTbr("test");

	/** @ 联系人(lxr) */
	sjbdqxx.setLxr("test");

	/** @ 联系方式(lxfs) */
	sjbdqxx.setLxfs("test");

	/** @ 联系人身份号码(lxrsfhm) */
	sjbdqxx.setLxrsfhm("test");

		/*
		//插入对象
		sjbdqxxService.insertSjbdqxx(sjbdqxx);

		//读取对象比较
		BaseObject bo = sjbdqxxService.getSjbdqxx(sjbdqxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Sjbdqxx sjbdqxxNew = (Sjbdqxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(sjbdqxxNew.getSjbdqxxid(), sjbdqxx.getSjbdqxxid());
		assertEquals(sjbdqxxNew.getXzqhbm(), sjbdqxx.getXzqhbm());
		assertEquals(sjbdqxxNew.getXzqh(), sjbdqxx.getXzqh());
		assertEquals(sjbdqxxNew.getSjch(), sjbdqxx.getSjch());
		assertEquals(sjbdqxxNew.getPp(), sjbdqxx.getPp());
		assertEquals(sjbdqxxNew.getXh(), sjbdqxx.getXh());
		assertEquals(sjbdqxxNew.getYs(), sjbdqxx.getYs());
		assertEquals(sjbdqxxNew.getAjjbbm(), sjbdqxx.getAjjbbm());
		assertEquals(sjbdqxxNew.getAjjb(), sjbdqxx.getAjjb());
		assertEquals(sjbdqxxNew.getAjlbbm(), sjbdqxx.getAjlbbm());
		assertEquals(sjbdqxxNew.getAjlb(), sjbdqxx.getAjlb());
		assertEquals(sjbdqxxNew.getJyaq(), sjbdqxx.getJyaq());
		assertEquals(sjbdqxxNew.getDjrq(), sjbdqxx.getDjrq());
		assertEquals(sjbdqxxNew.getDjr(), sjbdqxx.getDjr());
		assertEquals(sjbdqxxNew.getLadqbm(), sjbdqxx.getLadqbm());
		assertEquals(sjbdqxxNew.getLadq(), sjbdqxx.getLadq());
		assertEquals(sjbdqxxNew.getBadwbm(), sjbdqxx.getBadwbm());
		assertEquals(sjbdqxxNew.getBadw(), sjbdqxx.getBadw());
		assertEquals(sjbdqxxNew.getTbr(), sjbdqxx.getTbr());
		assertEquals(sjbdqxxNew.getLxr(), sjbdqxx.getLxr());
		assertEquals(sjbdqxxNew.getLxfs(), sjbdqxx.getLxfs());
		assertEquals(sjbdqxxNew.getLxrsfhm(), sjbdqxx.getLxrsfhm());

		//删除对象
		// @ 手机被盗抢信息ID(sjbdqxxid) 
		sjbdqxx.setSjbdqxxid(1)

		sjbdqxxService.deleteSjbdqxx(sjbdqxx);

		//修改对象
		// @ 手机被盗抢信息ID(sjbdqxxid) 
		sjbdqxx.setSjbdqxxid(1)

		sjbdqxxService.updateSjbdqxx(sjbdqxx);

		//查询单条
		// @ 手机被盗抢信息ID(sjbdqxxid) 
		sjbdqxx.setSjbdqxxid(1)

		sjbdqxxService.getSjbdqxx(sjbdqxx);

		//查询多条
		// @ 手机被盗抢信息ID(sjbdqxxid) 
		sjbdqxx.setSjbdqxxid(1)

		sjbdqxxService.getListSjbdqxx(sjbdqxx);

		//翻页查询
		// @ 手机被盗抢信息ID(sjbdqxxid) 
		sjbdqxx.setSjbdqxxid(1)

		sjbdqxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		sjbdqxxService.insertSjbdqxx(sjbdqxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setSjbdqxxService(ISjbdqxxService sjbdqxxService) {
		this.sjbdqxxService = sjbdqxxService;
	}
}
