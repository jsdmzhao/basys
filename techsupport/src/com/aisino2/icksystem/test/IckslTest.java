package com.aisino2.icksystem.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.service.IIckslService;

public class IckslTest extends AbstractTransactionalDataSourceSpringContextTests {
	
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/icksystem-service.xml",
				"/config/spring/icksystem-dao.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/publicsystem-service.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		//this.setAutowireMode(0);

		return paths;
	}

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IIckslService ickslService;

	/** @param IC卡受理(t_icksl) */

	public void test() {
		Icksl icksl = new Icksl();

	/** @ IC卡受理ID(ickslid) */
	icksl.setIckslid(6);

	/** @ 企业编码(qybm) */
	//icksl.setQybm("test");

	/** @ 企业ID(qyid) */
	icksl.setQyid(71);

	/** @ 从业人员ID(ryid) */
	//icksl.setRyid(141);

	/** @ 行业类别代码(hylbdm) */
	icksl.setHylbdm("J");

	/** @ 行业类别(hylb) */
	icksl.setHylb("营业性娱乐场所");

	/** @ 卡号(kh) */
	//icksl.setKh("test");

	/** @ 卡ID号(ickh) */
	//icksl.setIckh("test");

	/** @ 申领原因(slyy) */
	icksl.setSlyy("1");

	/** @ 受理人(slr) */
	icksl.setSlr("mm");

	/** @ 受理时间(slsj) */
	//icksl.setSlsj(new Date());

	/** @ 有效期开始日期(yxsksrq) */
	//icksl.setYxsksrq(new Date());

	/** @ 有效期截至日期(yxqhzrq) */
	//icksl.setYxqhzrq(new Date());

	/** @ 采集时间(cjsj) */
	//icksl.setCjsj(new Date());

	/** @ 采集人(cjr) */
	//icksl.setCjr("mm");

	/** @ 采集点编码(cjdbm) */
	//icksl.setCjdbm("test");

	/** @ 采集点名称(cjdmc) */
	//icksl.setCjdmc("test");

	/** @ 接收时间(jssj) */
	//icksl.setJssj(new Date());

	/** @ 接收包名称(jsbmc) */
	//icksl.setJsbmc("test");

	/** @ 发放人(ffr) */
	//icksl.setFfr("test");

	/** @ 发放时间(ffsj) */
	//icksl.setFfsj(new Date());

	/** @ 领取人(lqr) */
	//icksl.setLqr("test");

	/** @ 领取时间(lqsj) */
	//icksl.setLqsj(new Date());

	/** @ 领取人证件类型(lqrzjlx) */
	//icksl.setLqrzjlx("test");

	/** @ 领取人证件号码(lqrzjhm) */
	//icksl.setLqrzjhm("test");

	/** @ IC卡注销人(ickzxr) */
	//icksl.setIckzxr("test");

	/** @ IC卡注销时间(ickzxsj) */
	//icksl.setIckzxsj(new Date());

	/** @ IC卡注销原因(ickzxyy) */
	//icksl.setIckzxyy("test");

	/** @ 年检人(njr) */
	//icksl.setNjr("test");

	/** @ 年检时间(njsj) */
	//icksl.setNjsj(new Date());

	/** @ 制卡状态标识(zkztbs) */
	//icksl.setZkztbs("test");

	/** @ 是否确认(sfqr) */
	//icksl.setSfqr("te");

	/** @ 印刷人(ysr) */
	//icksl.setYsr("test");

	/** @ 印刷时间(yssj) */
	//icksl.setYssj(new Date());

	/** @ 电写入人(dxrr) */
	//icksl.setDxrr("test");

	/** @ 电写入时间(dxrsj) */
	//icksl.setDxrsj(new Date());

	/** @ 重印刷时间(cyssj) */
	//icksl.setCyssj(new Date());

	/** @ 重印刷原因(cysyy) */
	//icksl.setCysyy("test");

	/** @ 重电写入时间(cdxrsj) */
	//icksl.setCdxrsj(new Date());

	/** @ 重电写入原因(cdxryy) */
	//icksl.setCdxryy("test");

	/** @ 补换卡原因(bhkyy) */
	//icksl.setBhkyy("test");

	/** @ 原卡是否收回(yksfsh) */
	//icksl.setYksfsh("te");
	
	
	//ickslService = (IIckslService)this.applicationContext.getBean("ickslService");

		/*
		//插入对象
		ickslService.insertIcksl(icksl);

		//读取对象比较
		BaseObject bo = ickslService.getIcksl(icksl);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Icksl ickslNew = (Icksl)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ickslNew.getIckslid(), icksl.getIckslid());
		assertEquals(ickslNew.getQybm(), icksl.getQybm());
		assertEquals(ickslNew.getQyid(), icksl.getQyid());
		assertEquals(ickslNew.getRyid(), icksl.getRyid());
		assertEquals(ickslNew.getHylbdm(), icksl.getHylbdm());
		assertEquals(ickslNew.getHylb(), icksl.getHylb());
		assertEquals(ickslNew.getKh(), icksl.getKh());
		assertEquals(ickslNew.getIckh(), icksl.getIckh());
		assertEquals(ickslNew.getSlyy(), icksl.getSlyy());
		assertEquals(ickslNew.getSlr(), icksl.getSlr());
		assertEquals(ickslNew.getSlsj(), icksl.getSlsj());
		assertEquals(ickslNew.getYxsksrq(), icksl.getYxsksrq());
		assertEquals(ickslNew.getYxqhzrq(), icksl.getYxqhzrq());
		assertEquals(ickslNew.getCjsj(), icksl.getCjsj());
		assertEquals(ickslNew.getCjr(), icksl.getCjr());
		assertEquals(ickslNew.getCjdbm(), icksl.getCjdbm());
		assertEquals(ickslNew.getCjdmc(), icksl.getCjdmc());
		assertEquals(ickslNew.getJssj(), icksl.getJssj());
		assertEquals(ickslNew.getJsbmc(), icksl.getJsbmc());
		assertEquals(ickslNew.getFfr(), icksl.getFfr());
		assertEquals(ickslNew.getFfsj(), icksl.getFfsj());
		assertEquals(ickslNew.getLqr(), icksl.getLqr());
		assertEquals(ickslNew.getLqsj(), icksl.getLqsj());
		assertEquals(ickslNew.getLqrzjlx(), icksl.getLqrzjlx());
		assertEquals(ickslNew.getLqrzjhm(), icksl.getLqrzjhm());
		assertEquals(ickslNew.getIckzxr(), icksl.getIckzxr());
		assertEquals(ickslNew.getIckzxsj(), icksl.getIckzxsj());
		assertEquals(ickslNew.getIckzxyy(), icksl.getIckzxyy());
		assertEquals(ickslNew.getNjr(), icksl.getNjr());
		assertEquals(ickslNew.getNjsj(), icksl.getNjsj());
		assertEquals(ickslNew.getZkztbs(), icksl.getZkztbs());
		assertEquals(ickslNew.getSfqr(), icksl.getSfqr());
		assertEquals(ickslNew.getYsr(), icksl.getYsr());
		assertEquals(ickslNew.getYssj(), icksl.getYssj());
		assertEquals(ickslNew.getDxrr(), icksl.getDxrr());
		assertEquals(ickslNew.getDxrsj(), icksl.getDxrsj());
		assertEquals(ickslNew.getCyssj(), icksl.getCyssj());
		assertEquals(ickslNew.getCysyy(), icksl.getCysyy());
		assertEquals(ickslNew.getCdxrsj(), icksl.getCdxrsj());
		assertEquals(ickslNew.getCdxryy(), icksl.getCdxryy());
		assertEquals(ickslNew.getBhkyy(), icksl.getBhkyy());
		assertEquals(ickslNew.getYksfsh(), icksl.getYksfsh());

		//删除对象
		// @ IC卡受理ID(ickslid) 
		icksl.setIckslid(1)

		ickslService.deleteIcksl(icksl);

		//修改对象
		// @ IC卡受理ID(ickslid) 
		icksl.setIckslid(1)

		ickslService.updateIcksl(icksl);

		//查询单条
		// @ IC卡受理ID(ickslid) 
		icksl.setIckslid(1)

		ickslService.getIcksl(icksl);

		//查询多条
		// @ IC卡受理ID(ickslid) 
		icksl.setIckslid(1)

		ickslService.getListIcksl(icksl);

		//翻页查询
		// @ IC卡受理ID(ickslid) 
		icksl.setIckslid(1)

		ickslService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//受理
		/*Qyryxx qyryxx = new Qyryxx();
		qyryxx.setRyid(85);
		qyryxx.setQyid(58);
		qyryxx.setCyrybh("E014107000002100003");
		qyryxx.setZt("0");
		qyryxx.setLrr("E014107000002");
		qyryxx.setLrsj(new Date());
		qyryxx.setLrdwbm("E014107000002");
		qyryxx.setLrdwmc("新乡市公安局");
		
		icksl.setQyryxx(qyryxx);
		
		icksl.setSlr("mm");
		icksl.setSlsj(new Date());
		ickslService.insertIcksl(icksl);*/
	
	try{
		/*//修改
		icksl.setCzr("mm");
		ickslService.updateIcksl(icksl);*/
		/*//照片审核
		icksl = null;
		icksl = new Icksl();
		List ickslList = new ArrayList();
		List cyryxxList = new ArrayList();
		Icksl ickslTemp = null;
		Qyryxx cyryxxTemp = null;
		
		cyryxxTemp = new Qyryxx();
		cyryxxTemp.setRyid(13);
		cyryxxTemp.setQyid(1);
		cyryxxTemp.setZpwtgyy("呵呵未通过1");
		cyryxxList.add(cyryxxTemp);
		
		cyryxxTemp = new Qyryxx();
		cyryxxTemp.setRyid(14);
		cyryxxTemp.setQyid(1);
		cyryxxTemp.setZpwtgyy("呵呵未通过3");
		cyryxxList.add(cyryxxTemp);
		
		ickslTemp = new Icksl();
		ickslTemp.setIckslid(7);
		ickslTemp.setRyid(13);
		ickslTemp.setSftg("1");
		ickslList.add(ickslTemp);
		
		ickslTemp = new Icksl();
		ickslTemp.setIckslid(8);
		ickslTemp.setRyid(14);
		ickslTemp.setSftg("0");
		ickslList.add(ickslTemp);
		
		icksl.setLQyryxx(cyryxxList);
		icksl.setLIcksl(ickslList);
		icksl.setCzr("测试照片审核");
		
		ickslService.updateIckslZpsh(icksl);*/
		/*//照片全部通过
		icksl = null;
		icksl = new Icksl();
		icksl.setCzr("测试全部审核通过");
		icksl.setCjdbm("CJD410701");
		ickslService.updateIckslZpshAll(icksl);*/
		
		icksl = new Icksl();
		icksl.setIckslid(13);
		icksl.setRyid(44);
		icksl.setCysyy("0");
		icksl.setCzr("mm");
		ickslService.updateIckslCys(icksl);
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
		Map map = new HashMap();
		//map.put("hylbdm", "J");
		//map.put("deptCode", "410702520000");
		//map.put("ejshkg", "0");
		//map.put("sfjxgarkkbd", "0");
		//map.put("lrdwbm", "CJD4107");
		//ickslService.getWslIckslCyryxxList(map, 1, 10, "1", "desc");//查询未受理从业人员
		//ickslService.getWshzpList(map, 1, 10, "1", "desc");//查询未审核通过照片
		
		//未组包查询
		/*icksl = new Icksl();
		icksl.setCjdbm("CJD410701");
		icksl.setOrderByCjdbm("1");*/
		//icksl.setMoreThan3days("1");
		//ickslService.getWzbIckslList(icksl);
		
		
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}
}
