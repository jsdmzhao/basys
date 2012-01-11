package com.aisino2.basicsystem.test;

import java.util.Date;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.basicsystem.service.IWpbjxxbService;

public class WpbjxxbTest extends AbstractTransactionalDataSourceSpringContextTests {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWpbjxxbService wpbjxxbService;
	
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


	/** @param 物品报警信息表(t_wpbjxxb) */

	public void test() {
		Wpbjxxb wpbjxxb = new Wpbjxxb();

	/** @ 报警信息ID(bjxxid2) */
	wpbjxxb.setBjxxid2(0);

	/** @ 所属企业名称(ssqymc) */
	wpbjxxb.setSsqymc("test");

	/** @ 所属企业地址(ssqydz) */
	wpbjxxb.setSsqydz("test");

	/** @ 管辖单位代码(gxdwbm) */
	wpbjxxb.setGxdwbm("test");

	/** @ 管辖单位名称(gxdwmc) */
	wpbjxxb.setGxdwmc("test");

	/** @ 报警类型代码(bjlxdm) */
	wpbjxxb.setBjlxdm("test");

	/** @ 报警类型(bjlx) */
	wpbjxxb.setBjlx("test");

	/** @ 报警时间(bjsj) */
	wpbjxxb.setBjsj(new Date());

	/** @ 比对表名(bdbm) */
	wpbjxxb.setBdbm("test");

	/** @ 业务表名(ywbm) */
	wpbjxxb.setYwbm("test");

	/** @ 行业类别代码(hylbdm) */
	wpbjxxb.setHylbdm("test");

	/** @ 行业类别(hylb) */
	wpbjxxb.setHylb("test");

	/** @ 简要案情(jyaq) */
	wpbjxxb.setJyaq("test");

	/** @ 立案单位编码(ladwbm) */
	wpbjxxb.setLadwbm("test");

	/** @ 立案单位名称(ladwmc) */
	wpbjxxb.setLadwmc("test");

	/** @ 更新版本号(gxbbh) */
	wpbjxxb.setGxbbh(0);

	/** @ 业务类别代码(ywlbdm) */
	wpbjxxb.setYwlbdm("test");

	/** @ 业务类别(ywlb) */
	wpbjxxb.setYwlb("test");

	/** @ 派警部门编码(pjbmbm) */
	wpbjxxb.setPjbmbm("test");

	/** @ 派警部门名称(pjbmmc) */
	wpbjxxb.setPjbmmc("test");

	/** @ 派警人(pjr) */
	wpbjxxb.setPjr("test");

	/** @ 派警时间(pjsj) */
	wpbjxxb.setPjsj(new Date());

	/** @ 警情状态代码(jqztdm) */
	wpbjxxb.setJqztdm("test");

	/** @ 警情状态(jqzt) */
	wpbjxxb.setJqzt("test");

	/** @ 出警部门编码(cjbmbm) */
	wpbjxxb.setCjbmbm("test");

	/** @ 出警部门(cjbm) */
	wpbjxxb.setCjbm("test");

	/** @ 出警时间(chjsj) */
	wpbjxxb.setChjsj(new Date());

	/** @ 出警负责人(cjfzr) */
	wpbjxxb.setCjfzr("test");

	/** @ 联系电话(lxdh) */
	wpbjxxb.setLxdh("test");

	/** @ 处警反馈类别代码(cjfklbdm) */
	wpbjxxb.setCjfklbdm("test");

	/** @ 处警反馈类别(cjfklb) */
	wpbjxxb.setCjfklb("test");

	/** @ 处警反馈备注(cjfkbz) */
	wpbjxxb.setCjfkbz("test");

	/** @ 反馈单位编码(fkdwbm) */
	wpbjxxb.setFkdwbm("test");

	/** @ 反馈单位(fkdw) */
	wpbjxxb.setFkdw("test");

	/** @ 反馈日期(fkrq) */
	wpbjxxb.setFkrq(new Date());

	/** @ 处警经过(cjjg) */
	wpbjxxb.setCjjg("test");

	/** @ 处警结果代码(cjjgdm) */
	wpbjxxb.setCjjgdm("test");

	/** @ 处警结果(chjjg) */
	wpbjxxb.setChjjg("test");

	/** @ 抓获时间(zhsj) */
	wpbjxxb.setZhsj(new Date());

	/** @ 无效原因代码(wxyydm) */
	wpbjxxb.setWxyydm("test");

	/** @ 无效原因(wxyy) */
	wpbjxxb.setWxyy("test");

	/** @ 是否有效报警代码(sfyxbjdm) */
	wpbjxxb.setSfyxbjdm("test");

	/** @ 是否有效报警(sfyxbj) */
	wpbjxxb.setSfyxbj("test");

	/** @ 反馈人(fkr) */
	wpbjxxb.setFkr("test");

	/** @ 业务表主键(ywbzj) */
	wpbjxxb.setYwbzj("test");

	/** @ 比对表主键(bdbzj) */
	wpbjxxb.setBdbzj("test");

		/*
		//插入对象
		wpbjxxbService.insertWpbjxxb(wpbjxxb);

		//读取对象比较
		BaseObject bo = wpbjxxbService.getWpbjxxb(wpbjxxb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wpbjxxb wpbjxxbNew = (Wpbjxxb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wpbjxxbNew.getBjxxid2(), wpbjxxb.getBjxxid2());
		assertEquals(wpbjxxbNew.getSsqymc(), wpbjxxb.getSsqymc());
		assertEquals(wpbjxxbNew.getSsqydz(), wpbjxxb.getSsqydz());
		assertEquals(wpbjxxbNew.getGxdwbm(), wpbjxxb.getGxdwbm());
		assertEquals(wpbjxxbNew.getGxdwmc(), wpbjxxb.getGxdwmc());
		assertEquals(wpbjxxbNew.getBjlxdm(), wpbjxxb.getBjlxdm());
		assertEquals(wpbjxxbNew.getBjlx(), wpbjxxb.getBjlx());
		assertEquals(wpbjxxbNew.getBjsj(), wpbjxxb.getBjsj());
		assertEquals(wpbjxxbNew.getBdbm(), wpbjxxb.getBdbm());
		assertEquals(wpbjxxbNew.getYwbm(), wpbjxxb.getYwbm());
		assertEquals(wpbjxxbNew.getHylbdm(), wpbjxxb.getHylbdm());
		assertEquals(wpbjxxbNew.getHylb(), wpbjxxb.getHylb());
		assertEquals(wpbjxxbNew.getJyaq(), wpbjxxb.getJyaq());
		assertEquals(wpbjxxbNew.getLadwbm(), wpbjxxb.getLadwbm());
		assertEquals(wpbjxxbNew.getLadwmc(), wpbjxxb.getLadwmc());
		assertEquals(wpbjxxbNew.getGxbbh(), wpbjxxb.getGxbbh());
		assertEquals(wpbjxxbNew.getYwlbdm(), wpbjxxb.getYwlbdm());
		assertEquals(wpbjxxbNew.getYwlb(), wpbjxxb.getYwlb());
		assertEquals(wpbjxxbNew.getPjbmbm(), wpbjxxb.getPjbmbm());
		assertEquals(wpbjxxbNew.getPjbmmc(), wpbjxxb.getPjbmmc());
		assertEquals(wpbjxxbNew.getPjr(), wpbjxxb.getPjr());
		assertEquals(wpbjxxbNew.getPjsj(), wpbjxxb.getPjsj());
		assertEquals(wpbjxxbNew.getJqztdm(), wpbjxxb.getJqztdm());
		assertEquals(wpbjxxbNew.getJqzt(), wpbjxxb.getJqzt());
		assertEquals(wpbjxxbNew.getCjbmbm(), wpbjxxb.getCjbmbm());
		assertEquals(wpbjxxbNew.getCjbm(), wpbjxxb.getCjbm());
		assertEquals(wpbjxxbNew.getChjsj(), wpbjxxb.getChjsj());
		assertEquals(wpbjxxbNew.getCjfzr(), wpbjxxb.getCjfzr());
		assertEquals(wpbjxxbNew.getLxdh(), wpbjxxb.getLxdh());
		assertEquals(wpbjxxbNew.getCjfklbdm(), wpbjxxb.getCjfklbdm());
		assertEquals(wpbjxxbNew.getCjfklb(), wpbjxxb.getCjfklb());
		assertEquals(wpbjxxbNew.getCjfkbz(), wpbjxxb.getCjfkbz());
		assertEquals(wpbjxxbNew.getFkdwbm(), wpbjxxb.getFkdwbm());
		assertEquals(wpbjxxbNew.getFkdw(), wpbjxxb.getFkdw());
		assertEquals(wpbjxxbNew.getFkrq(), wpbjxxb.getFkrq());
		assertEquals(wpbjxxbNew.getCjjg(), wpbjxxb.getCjjg());
		assertEquals(wpbjxxbNew.getCjjgdm(), wpbjxxb.getCjjgdm());
		assertEquals(wpbjxxbNew.getChjjg(), wpbjxxb.getChjjg());
		assertEquals(wpbjxxbNew.getZhsj(), wpbjxxb.getZhsj());
		assertEquals(wpbjxxbNew.getWxyydm(), wpbjxxb.getWxyydm());
		assertEquals(wpbjxxbNew.getWxyy(), wpbjxxb.getWxyy());
		assertEquals(wpbjxxbNew.getSfyxbjdm(), wpbjxxb.getSfyxbjdm());
		assertEquals(wpbjxxbNew.getSfyxbj(), wpbjxxb.getSfyxbj());
		assertEquals(wpbjxxbNew.getFkr(), wpbjxxb.getFkr());
		assertEquals(wpbjxxbNew.getYwbzj(), wpbjxxb.getYwbzj());
		assertEquals(wpbjxxbNew.getBdbzj(), wpbjxxb.getBdbzj());

		//删除对象
		// @ 报警信息ID(bjxxid2) 
		wpbjxxb.setBjxxid2(1)

		wpbjxxbService.deleteWpbjxxb(wpbjxxb);

		//修改对象
		// @ 报警信息ID(bjxxid2) 
		wpbjxxb.setBjxxid2(1)

		wpbjxxbService.updateWpbjxxb(wpbjxxb);

		//查询单条
		// @ 报警信息ID(bjxxid2) 
		wpbjxxb.setBjxxid2(1)

		wpbjxxbService.getWpbjxxb(wpbjxxb);

		//查询多条
		// @ 报警信息ID(bjxxid2) 
		wpbjxxb.setBjxxid2(1)

		wpbjxxbService.getListWpbjxxb(wpbjxxb);

		//翻页查询
		// @ 报警信息ID(bjxxid2) 
		wpbjxxb.setBjxxid2(1)

		wpbjxxbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//wpbjxxbService.insertWpbjxxb(wpbjxxb);
	
		/*Map map = new HashMap();
		map.put("wpqp", "qp1");
		wpbjxxbService.getListForPage(map, 1, 10, "0", "desc");*/
		Wpbjxxb wpbjxxb1 = new Wpbjxxb();
		//wpbjxxb1.setYwbzj1(34);
		//wpbjxxb1.setYwbzj2(17);
		wpbjxxb1.setYwbzj1(43);
		wpbjxxb1.setYwbzj2(34);
		/*wpbjxxb1.setWpmc("奥迪");
		wpbjxxb1.setWpqp("aodi");
		wpbjxxb1.setWpjp("AD");*/
		/*wpbjxxb1.setHphm("京A88888");
		wpbjxxb1.setCjbm("ABCD123456");
		wpbjxxb1.setFdjh("9876");
		wpbjxxb1.setClsbdh("6396896");*/
		wpbjxxb1.setSjch("111111");
		
	try {
		int flag = 0;
		
		flag = wpbjxxbService.BaoJingCl(wpbjxxb1,"6");
		System.out.println("比对结果============="+flag);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWpbjxxbService(IWpbjxxbService wpbjxxbService) {
		this.wpbjxxbService = wpbjxxbService;
	}
}
