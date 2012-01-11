package com.aisino2.basicsystem.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.basicsystem.service.IBjxxbService;

public class BjxxbTest extends AbstractTransactionalDataSourceSpringContextTests {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBjxxbService bjxxbService;
	
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/publicsystem-service.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		return paths;
	}


	/** @param 报警信息表(t_bjxxb) */

	public void test() {
		Bjxxb bjxxb = new Bjxxb();

	/** @ 报警规则ID(bjgzid) */
	bjxxb.setBjgzid(0);

	/** @ 报警信息ID(bjxxid) */
	bjxxb.setBjxxid(0);

	/** @ 所属企业名称(ssqymc) */
	bjxxb.setSsqymc("test");

	/** @ 所属企业地址(ssqydz) */
	bjxxb.setSsqydz("test");

	/** @ 管辖单位代码(gxdwbm) */
	bjxxb.setGxdwbm("test");

	/** @ 管辖单位名称(gxdwmc) */
	bjxxb.setGxdwmc("test");

	/** @ 报警类型(bjlx) */
	bjxxb.setBjlx("test");

	/** @ 报警时间(bjsj) */
	bjxxb.setBjsj(new Date());

	/** @ 比对表名(bdbm) */
	bjxxb.setBdbm("test");

	/** @ 业务表名(ywbm) */
	bjxxb.setYwbm("test");

	/** @ 行业类别(hylb) */
	bjxxb.setHylb("test");

	/** @ 姓名(xm) */
	bjxxb.setXm("test");

	/** @ 公民身份号码(gmsfhm) */
	bjxxb.setGmsfhm("test");

	/** @ 简要案情(jyaq) */
	bjxxb.setJyaq("test");

	/** @ 立案单位编码(ladwbm) */
	bjxxb.setLadwbm("test");

	/** @ 立案单位名称(ladwmc) */
	bjxxb.setLadwmc("test");

	/** @ 更新版本号(gxbbh) */
	bjxxb.setGxbbh(0);

	/** @ 业务类别(ywlb) */
	bjxxb.setYwlb("test");

	/** @ 派警部门名称(pjbmmc) */
	bjxxb.setPjbmmc("test");

	/** @ 派警人(pjr) */
	bjxxb.setPjr("test");

	/** @ 派警时间(pjsj) */
	bjxxb.setPjsj(new Date());

	/** @ 警情状态(jqzt) */
	bjxxb.setJqzt("test");

	/** @ 出警部门(cjbm) */
	bjxxb.setCjbm("test");

	/** @ 出警时间(chjsj) */
	bjxxb.setChjsj(new Date());

	/** @ 出警负责人(cjfzr) */
	bjxxb.setCjfzr("test");

	/** @ 联系电话(lxdh) */
	bjxxb.setLxdh("test");

	/** @ 处警反馈类别(cjfklb) */
	bjxxb.setCjfklb("test");

	/** @ 处警反馈备注(cjfkbz) */
	bjxxb.setCjfkbz("test");

	/** @ 反馈单位(fkdw) */
	bjxxb.setFkdw("test");

	/** @ 反馈单位编码(fkdwbm) */
	bjxxb.setFkdwbm("test");

	/** @ 反馈日期(fkrq) */
	bjxxb.setFkrq(new Date());

	/** @ 处警经过(cjjg) */
	bjxxb.setCjjg("test");

	/** @ 处警结果(chjjg) */
	bjxxb.setChjjg("test");

	/** @ 抓获时间(zhsj) */
	bjxxb.setZhsj(new Date());

	/** @ 无效原因(wxyy) */
	bjxxb.setWxyy("test");

		/*
		//插入对象
		bjxxbService.insertBjxxb(bjxxb);

		//读取对象比较
		BaseObject bo = bjxxbService.getBjxxb(bjxxb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bjxxb bjxxbNew = (Bjxxb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bjxxbNew.getBjgzid(), bjxxb.getBjgzid());
		assertEquals(bjxxbNew.getBjxxid(), bjxxb.getBjxxid());
		assertEquals(bjxxbNew.getSsqymc(), bjxxb.getSsqymc());
		assertEquals(bjxxbNew.getSsqydz(), bjxxb.getSsqydz());
		assertEquals(bjxxbNew.getGxdwbm(), bjxxb.getGxdwbm());
		assertEquals(bjxxbNew.getGxdwmc(), bjxxb.getGxdwmc());
		assertEquals(bjxxbNew.getBjlx(), bjxxb.getBjlx());
		assertEquals(bjxxbNew.getBjsj(), bjxxb.getBjsj());
		assertEquals(bjxxbNew.getBdbm(), bjxxb.getBdbm());
		assertEquals(bjxxbNew.getYwbm(), bjxxb.getYwbm());
		assertEquals(bjxxbNew.getHylb(), bjxxb.getHylb());
		assertEquals(bjxxbNew.getXm(), bjxxb.getXm());
		assertEquals(bjxxbNew.getGmsfhm(), bjxxb.getGmsfhm());
		assertEquals(bjxxbNew.getJyaq(), bjxxb.getJyaq());
		assertEquals(bjxxbNew.getLadwbm(), bjxxb.getLadwbm());
		assertEquals(bjxxbNew.getLadwmc(), bjxxb.getLadwmc());
		assertEquals(bjxxbNew.getGxbbh(), bjxxb.getGxbbh());
		assertEquals(bjxxbNew.getYwlb(), bjxxb.getYwlb());
		assertEquals(bjxxbNew.getPjbmdm(), bjxxb.getPjbmdm());
		assertEquals(bjxxbNew.getPjbmmc(), bjxxb.getPjbmmc());
		assertEquals(bjxxbNew.getPjr(), bjxxb.getPjr());
		assertEquals(bjxxbNew.getPjsj(), bjxxb.getPjsj());
		assertEquals(bjxxbNew.getJqzt(), bjxxb.getJqzt());
		assertEquals(bjxxbNew.getCjbm(), bjxxb.getCjbm());
		assertEquals(bjxxbNew.getCjbmdm(), bjxxb.getCjbmdm());
		assertEquals(bjxxbNew.getChjsj(), bjxxb.getChjsj());
		assertEquals(bjxxbNew.getCjfzr(), bjxxb.getCjfzr());
		assertEquals(bjxxbNew.getLxdh(), bjxxb.getLxdh());
		assertEquals(bjxxbNew.getCjfklb(), bjxxb.getCjfklb());
		assertEquals(bjxxbNew.getCjfkbz(), bjxxb.getCjfkbz());
		assertEquals(bjxxbNew.getFkdw(), bjxxb.getFkdw());
		assertEquals(bjxxbNew.getFkdwbm(), bjxxb.getFkdwbm());
		assertEquals(bjxxbNew.getFkrq(), bjxxb.getFkrq());
		assertEquals(bjxxbNew.getCjjg(), bjxxb.getCjjg());
		assertEquals(bjxxbNew.getChjjg(), bjxxb.getChjjg());
		assertEquals(bjxxbNew.getZhsj(), bjxxb.getZhsj());
		assertEquals(bjxxbNew.getWxyy(), bjxxb.getWxyy());

		//删除对象
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bjxxb.setBjxxid(1)

		bjxxbService.deleteBjxxb(bjxxb);

		//修改对象
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bjxxb.setBjxxid(1)

		bjxxbService.updateBjxxb(bjxxb);

		//查询单条
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bjxxb.setBjxxid(1)

		bjxxbService.getBjxxb(bjxxb);

		//查询多条
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bjxxb.setBjxxid(1)

		bjxxbService.getListBjxxb(bjxxb);

		//翻页查询
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjxxb.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bjxxb.setBjxxid(1)

		bjxxbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//bjxxbService.insertBjxxb(bjxxb);
	
	
	Bjxxb bjxxbIn = new Bjxxb();
	bjxxbIn.setYwbzj1(30);//该人员所在记录的主键值
	bjxxbIn.setYwbzj2(34);//企业id
	bjxxbIn.setXm("摊主姓名");//人员的姓名
	bjxxbIn.setZjhm("110101197004095019");//人员证件号码
	
	try {
		bjxxbService.baojingKhxx(bjxxbIn, "E02", "72");
		
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBjxxbService(IBjxxbService bjxxbService) {
		this.bjxxbService = bjxxbService;
	}
}
