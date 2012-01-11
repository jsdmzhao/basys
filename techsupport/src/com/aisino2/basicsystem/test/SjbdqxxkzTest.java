package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Sjbdqxxkz;
import com.aisino2.basicsystem.service.ISjbdqxxkzService;
import com.aisino2.core.test.BaseTestCase;

public class SjbdqxxkzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ISjbdqxxkzService sjbdqxxkzService;

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) */

	public void test() {
		Sjbdqxxkz sjbdqxxkz = new Sjbdqxxkz();

	/** @ 报警信息ID(bjxxid2) */
	sjbdqxxkz.setBjxxid2(0);

	/** @ 手机被盗抢信息快照ID(sjbdqxxkzid) */
	sjbdqxxkz.setSjbdqxxkzid(0);

	/** @ 行政区划编码(xzqhbm) */
	sjbdqxxkz.setXzqhbm("test");

	/** @ 行政区划(xzqh) */
	sjbdqxxkz.setXzqh("test");

	/** @ 手机串号(sjch) */
	sjbdqxxkz.setSjch("test");

	/** @ 品牌(pp) */
	sjbdqxxkz.setPp("test");

	/** @ 型号(xh) */
	sjbdqxxkz.setXh("test");

	/** @ 颜色(ys) */
	sjbdqxxkz.setYs("test");

	/** @ 案件级别编码(ajjbbm) */
	sjbdqxxkz.setAjjbbm("test");

	/** @ 案件级别(ajjb) */
	sjbdqxxkz.setAjjb("test");

	/** @ 案件类别编码(ajlbbm) */
	sjbdqxxkz.setAjlbbm("test");

	/** @ 案件类别(ajlb) */
	sjbdqxxkz.setAjlb("test");

	/** @ 简要案情(jyaq) */
	sjbdqxxkz.setJyaq("test");

	/** @ 登记日期(djrq) */
	sjbdqxxkz.setDjrq(new Date());

	/** @ 登记人(djr) */
	sjbdqxxkz.setDjr("test");

	/** @ 立案地区编码(ladqbm) */
	sjbdqxxkz.setLadqbm("test");

	/** @ 立案地区(ladq) */
	sjbdqxxkz.setLadq("test");

	/** @ 办案单位编码(badwbm) */
	sjbdqxxkz.setBadwbm("test");

	/** @ 办案单位(badw) */
	sjbdqxxkz.setBadw("test");

	/** @ 填表人(tbr) */
	sjbdqxxkz.setTbr("test");

	/** @ 联系人(lxr) */
	sjbdqxxkz.setLxr("test");

	/** @ 联系方式(lxfs) */
	sjbdqxxkz.setLxfs("test");

	/** @ 联系人身份号码(lxrsfhm) */
	sjbdqxxkz.setLxrsfhm("test");

		/*
		//插入对象
		sjbdqxxkzService.insertSjbdqxxkz(sjbdqxxkz);

		//读取对象比较
		BaseObject bo = sjbdqxxkzService.getSjbdqxxkz(sjbdqxxkz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Sjbdqxxkz sjbdqxxkzNew = (Sjbdqxxkz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(sjbdqxxkzNew.getBjxxid2(), sjbdqxxkz.getBjxxid2());
		assertEquals(sjbdqxxkzNew.getSjbdqxxkzid(), sjbdqxxkz.getSjbdqxxkzid());
		assertEquals(sjbdqxxkzNew.getXzqhbm(), sjbdqxxkz.getXzqhbm());
		assertEquals(sjbdqxxkzNew.getXzqh(), sjbdqxxkz.getXzqh());
		assertEquals(sjbdqxxkzNew.getSjch(), sjbdqxxkz.getSjch());
		assertEquals(sjbdqxxkzNew.getPp(), sjbdqxxkz.getPp());
		assertEquals(sjbdqxxkzNew.getXh(), sjbdqxxkz.getXh());
		assertEquals(sjbdqxxkzNew.getYs(), sjbdqxxkz.getYs());
		assertEquals(sjbdqxxkzNew.getAjjbbm(), sjbdqxxkz.getAjjbbm());
		assertEquals(sjbdqxxkzNew.getAjjb(), sjbdqxxkz.getAjjb());
		assertEquals(sjbdqxxkzNew.getAjlbbm(), sjbdqxxkz.getAjlbbm());
		assertEquals(sjbdqxxkzNew.getAjlb(), sjbdqxxkz.getAjlb());
		assertEquals(sjbdqxxkzNew.getJyaq(), sjbdqxxkz.getJyaq());
		assertEquals(sjbdqxxkzNew.getDjrq(), sjbdqxxkz.getDjrq());
		assertEquals(sjbdqxxkzNew.getDjr(), sjbdqxxkz.getDjr());
		assertEquals(sjbdqxxkzNew.getLadqbm(), sjbdqxxkz.getLadqbm());
		assertEquals(sjbdqxxkzNew.getLadq(), sjbdqxxkz.getLadq());
		assertEquals(sjbdqxxkzNew.getBadwbm(), sjbdqxxkz.getBadwbm());
		assertEquals(sjbdqxxkzNew.getBadw(), sjbdqxxkz.getBadw());
		assertEquals(sjbdqxxkzNew.getTbr(), sjbdqxxkz.getTbr());
		assertEquals(sjbdqxxkzNew.getLxr(), sjbdqxxkz.getLxr());
		assertEquals(sjbdqxxkzNew.getLxfs(), sjbdqxxkz.getLxfs());
		assertEquals(sjbdqxxkzNew.getLxrsfhm(), sjbdqxxkz.getLxrsfhm());

		//删除对象
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 手机被盗抢信息快照ID(sjbdqxxkzid) 
		sjbdqxxkz.setSjbdqxxkzid(1)

		sjbdqxxkzService.deleteSjbdqxxkz(sjbdqxxkz);

		//修改对象
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 手机被盗抢信息快照ID(sjbdqxxkzid) 
		sjbdqxxkz.setSjbdqxxkzid(1)

		sjbdqxxkzService.updateSjbdqxxkz(sjbdqxxkz);

		//查询单条
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 手机被盗抢信息快照ID(sjbdqxxkzid) 
		sjbdqxxkz.setSjbdqxxkzid(1)

		sjbdqxxkzService.getSjbdqxxkz(sjbdqxxkz);

		//查询多条
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 手机被盗抢信息快照ID(sjbdqxxkzid) 
		sjbdqxxkz.setSjbdqxxkzid(1)

		sjbdqxxkzService.getListSjbdqxxkz(sjbdqxxkz);

		//翻页查询
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		sjbdqxxkz.setBjxxid2(1)
		// @ 手机被盗抢信息快照ID(sjbdqxxkzid) 
		sjbdqxxkz.setSjbdqxxkzid(1)

		sjbdqxxkzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		sjbdqxxkzService.insertSjbdqxxkz(sjbdqxxkz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setSjbdqxxkzService(ISjbdqxxkzService sjbdqxxkzService) {
		this.sjbdqxxkzService = sjbdqxxkzService;
	}
}
