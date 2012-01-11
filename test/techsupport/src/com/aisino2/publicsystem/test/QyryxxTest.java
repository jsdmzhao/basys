package com.aisino2.publicsystem.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.service.IQyryxxService;

public class QyryxxTest extends AbstractTransactionalDataSourceSpringContextTests {
	
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/ylfwzagl-service.xml",
				"/config/spring/ylfwzagl-dao.xml",
				"/config/spring/icksystem-service.xml",
				"/config/spring/icksystem-dao.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/publicsystem-service.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		this.setAutowireMode(0);

		return paths;
	}

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyryxxService qyryxxService;

	/** @param 企业人员信息(t_qyryxx) */

	public void test() {
		Qyryxx qyryxx = new Qyryxx();

	/** @ 企业ID(qyid) */
	qyryxx.setQyid(0);

	/** @ 从业人员ID(ryid) */
	qyryxx.setRyid(0);

	/** @ 行业类别代码(hylbdm) */
	qyryxx.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyryxx.setHylb("test");

	/** @ 从业人员编号(cyrybh) */
	qyryxx.setCyrybh("test");

	/** @ 从业人员类别代码(cyrylbdm) */
	qyryxx.setCyrylbdm("test");

	/** @ 从业人员类别名称(cyrylbmc) */
	qyryxx.setCyrylbmc("test");

	/** @ 姓名(xm) */
	qyryxx.setXm("test");

	/** @ 全名(qm) */
	qyryxx.setQm("test");

	/** @ 别名(bm) */
	qyryxx.setBm("test");

	/** @ 姓名拼音(xmpy) */
	qyryxx.setXmpy("test");

	/** @ 国籍代码(gjdm) */
	qyryxx.setGjdm("test");

	/** @ 国籍(gj) */
	qyryxx.setGj("test");

	/** @ 民族代码(mzdm) */
	qyryxx.setMzdm("test");

	/** @ 民族(minzu) */
	qyryxx.setMinzu("test");

	/** @ 性别代码(xbdm) */
	qyryxx.setXbdm("test");

	/** @ 性别(xb) */
	qyryxx.setXb("test");

	/** @ 出生日期(csrq) */
	qyryxx.setCsrq(new Date());

	/** @ 婚姻状况代码(hyzkdm) */
	qyryxx.setHyzkdm("test");

	/** @ 婚姻状况(hyzk) */
	qyryxx.setHyzk("test");

	/** @ 身高(shengao) */
	qyryxx.setShengao(new Float(9.9));

	/** @ 体重(tizh) */
	qyryxx.setTizh(new Float(9.9));

	/** @ 户籍地行政区划(hjdxzqh) */
	qyryxx.setHjdxzqh("test");

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	qyryxx.setHjdxzqhdm("test");

	/** @ 户籍地详址(hjdxz) */
	qyryxx.setHjdxz("test");

	/** @ 常用证件代码(cyzjdm) */
	qyryxx.setCyzjdm("test");

	/** @ 常用证件(cyzj) */
	qyryxx.setCyzj("test");

	/** @ 证件号码(zjhm) */
	qyryxx.setZjhm("test");

	/** @ 暂住证号码(zzzhm) */
	qyryxx.setZzzhm("test");

	/** @ 暂住地址(zzdz) */
	qyryxx.setZzdz("test");

	/** @ 岗位编号(gwbh) */
	qyryxx.setGwbh("test");

	/** @ 岗位名称(gwmc) */
	qyryxx.setGwmc("test");

	/** @ 岗位责任描述(gwzrms) */
	qyryxx.setGwzrms("test");

	/** @ 手机(shouji) */
	qyryxx.setShouji("test");

	/** @ 联系电话(lxdh) */
	qyryxx.setLxdh("test");

	/** @ 紧急联系人(jjlxr) */
	qyryxx.setJjlxr("test");

	/** @ 紧急联系人电话(jjlxrdh) */
	qyryxx.setJjlxrdh("test");

	/** @ 工种代码(gzdm) */
	qyryxx.setGzdm("test");

	/** @ 工种(gz) */
	qyryxx.setGz("test");

	/** @ 职务(zhiwu) */
	qyryxx.setZhiwu("test");

	/** @ 入职日期(rzrq) */
	qyryxx.setRzrq(new Date());

	/** @ 从业人员状态代码(cyryztdm) */
	qyryxx.setCyryztdm("test");

	/** @ 从业人员状态(cyryzt) */
	qyryxx.setCyryzt("test");

	/** @ 注销人(zxr) */
	qyryxx.setZxr("test");

	/** @ 注销标志(zxbz) */
	qyryxx.setZxbz("test");

	/** @ 注销时间(zxsj) */
	qyryxx.setZxsj(new Date());

	/** @ 录入时间(lrsj) */
	qyryxx.setLrsj(new Date());

	/** @ 录入人(lrr) */
	qyryxx.setLrr("test");

	/** @ 录入单位编码(lrdwbm) */
	qyryxx.setLrdwbm("test");

	/** @ 录入单位名称(lrdwmc) */
	qyryxx.setLrdwmc("test");

	/** @ 核查单位(hcdw) */
	qyryxx.setHcdw("test");

	/** @ 核查人(hcr) */
	qyryxx.setHcr("test");

	/** @ 核查时间(hcsj) */
	qyryxx.setHcsj(new Date());

	/** @ 注销原因(zxyy) */
	qyryxx.setZxyy("test");

	/** @ 制卡状态(zkzt) */
	qyryxx.setZkzt("test");

	/** @ 保存时间(bcsj) */
	qyryxx.setBcsj(new Date());

	/** @ 导出标识(dcbs) */
	qyryxx.setDcbs(0);

	/** @ 备注(bz) */
	qyryxx.setBz("test");

	/** @ 删除标志(scbz) */
	qyryxx.setScbz(0);

	/** @ 比对标志(biduiflag) */
	qyryxx.setBiduiflag("te");

	/** @ 照片未通过原因(zpwtgyy) */
	qyryxx.setZpwtgyy("test");

	/** @ 状态(zt) */
	qyryxx.setZt("test");
	
	qyryxxService = (IQyryxxService)this.applicationContext.getBean("qyryxxService");

		/*
		//插入对象
		qyryxxService.insertQyryxx(qyryxx);

		//读取对象比较
		BaseObject bo = qyryxxService.getQyryxx(qyryxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyryxx qyryxxNew = (Qyryxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyryxxNew.getQyid(), qyryxx.getQyid());
		assertEquals(qyryxxNew.getRyid(), qyryxx.getRyid());
		assertEquals(qyryxxNew.getHylbdm(), qyryxx.getHylbdm());
		assertEquals(qyryxxNew.getHylb(), qyryxx.getHylb());
		assertEquals(qyryxxNew.getCyrybh(), qyryxx.getCyrybh());
		assertEquals(qyryxxNew.getCyrylbdm(), qyryxx.getCyrylbdm());
		assertEquals(qyryxxNew.getCyrylbmc(), qyryxx.getCyrylbmc());
		assertEquals(qyryxxNew.getXm(), qyryxx.getXm());
		assertEquals(qyryxxNew.getQm(), qyryxx.getQm());
		assertEquals(qyryxxNew.getBm(), qyryxx.getBm());
		assertEquals(qyryxxNew.getXmpy(), qyryxx.getXmpy());
		assertEquals(qyryxxNew.getGjdm(), qyryxx.getGjdm());
		assertEquals(qyryxxNew.getGj(), qyryxx.getGj());
		assertEquals(qyryxxNew.getMzdm(), qyryxx.getMzdm());
		assertEquals(qyryxxNew.getMinzu(), qyryxx.getMinzu());
		assertEquals(qyryxxNew.getXbdm(), qyryxx.getXbdm());
		assertEquals(qyryxxNew.getXb(), qyryxx.getXb());
		assertEquals(qyryxxNew.getCsrq(), qyryxx.getCsrq());
		assertEquals(qyryxxNew.getHyzkdm(), qyryxx.getHyzkdm());
		assertEquals(qyryxxNew.getHyzk(), qyryxx.getHyzk());
		assertEquals(qyryxxNew.getShengao(), qyryxx.getShengao());
		assertEquals(qyryxxNew.getTizh(), qyryxx.getTizh());
		assertEquals(qyryxxNew.getHjdxzqh(), qyryxx.getHjdxzqh());
		assertEquals(qyryxxNew.getHjdxzqhdm(), qyryxx.getHjdxzqhdm());
		assertEquals(qyryxxNew.getHjdxz(), qyryxx.getHjdxz());
		assertEquals(qyryxxNew.getCyzjdm(), qyryxx.getCyzjdm());
		assertEquals(qyryxxNew.getCyzj(), qyryxx.getCyzj());
		assertEquals(qyryxxNew.getZjhm(), qyryxx.getZjhm());
		assertEquals(qyryxxNew.getZzzhm(), qyryxx.getZzzhm());
		assertEquals(qyryxxNew.getZzdz(), qyryxx.getZzdz());
		assertEquals(qyryxxNew.getGwbh(), qyryxx.getGwbh());
		assertEquals(qyryxxNew.getGwmc(), qyryxx.getGwmc());
		assertEquals(qyryxxNew.getGwzrms(), qyryxx.getGwzrms());
		assertEquals(qyryxxNew.getShouji(), qyryxx.getShouji());
		assertEquals(qyryxxNew.getLxdh(), qyryxx.getLxdh());
		assertEquals(qyryxxNew.getJjlxr(), qyryxx.getJjlxr());
		assertEquals(qyryxxNew.getJjlxrdh(), qyryxx.getJjlxrdh());
		assertEquals(qyryxxNew.getGzdm(), qyryxx.getGzdm());
		assertEquals(qyryxxNew.getGz(), qyryxx.getGz());
		assertEquals(qyryxxNew.getZhiwu(), qyryxx.getZhiwu());
		assertEquals(qyryxxNew.getRzrq(), qyryxx.getRzrq());
		assertEquals(qyryxxNew.getCyryztdm(), qyryxx.getCyryztdm());
		assertEquals(qyryxxNew.getCyryzt(), qyryxx.getCyryzt());
		assertEquals(qyryxxNew.getZxr(), qyryxx.getZxr());
		assertEquals(qyryxxNew.getZxbz(), qyryxx.getZxbz());
		assertEquals(qyryxxNew.getZxsj(), qyryxx.getZxsj());
		assertEquals(qyryxxNew.getLrsj(), qyryxx.getLrsj());
		assertEquals(qyryxxNew.getLrr(), qyryxx.getLrr());
		assertEquals(qyryxxNew.getLrdwbm(), qyryxx.getLrdwbm());
		assertEquals(qyryxxNew.getLrdwmc(), qyryxx.getLrdwmc());
		assertEquals(qyryxxNew.getHcdw(), qyryxx.getHcdw());
		assertEquals(qyryxxNew.getHcr(), qyryxx.getHcr());
		assertEquals(qyryxxNew.getHcsj(), qyryxx.getHcsj());
		assertEquals(qyryxxNew.getZxyy(), qyryxx.getZxyy());
		assertEquals(qyryxxNew.getZkzt(), qyryxx.getZkzt());
		assertEquals(qyryxxNew.getBcsj(), qyryxx.getBcsj());
		assertEquals(qyryxxNew.getDcbs(), qyryxx.getDcbs());
		assertEquals(qyryxxNew.getBz(), qyryxx.getBz());
		assertEquals(qyryxxNew.getScbz(), qyryxx.getScbz());
		assertEquals(qyryxxNew.getBiduiflag(), qyryxx.getBiduiflag());
		assertEquals(qyryxxNew.getZpwtgyy(), qyryxx.getZpwtgyy());
		assertEquals(qyryxxNew.getZt(), qyryxx.getZt());

		//删除对象
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx.setRyid(1)

		qyryxxService.deleteQyryxx(qyryxx);

		//修改对象
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx.setRyid(1)

		qyryxxService.updateQyryxx(qyryxx);

		//查询单条
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx.setRyid(1)

		qyryxxService.getQyryxx(qyryxx);

		//查询多条
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx.setRyid(1)

		qyryxxService.getListQyryxx(qyryxx);

		//翻页查询
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx.setRyid(1)

		qyryxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/
	Map map = new HashMap();
	map.put("hylbdm", "J");
	//qyryxxService.getWtjListForPage(map, 1, 10, "0", "desc");
	//qyryxxService.getListZkdForPage(map, 1, 10, "0", "desc");
	//qyryxxService.getListZkdByCsidForPage(map, 1, 10, "0", "desc");
	qyryxx = new Qyryxx();
	qyryxx.setLrdwbm("CJD410701");
	qyryxxService.getWtjListQyryxx(qyryxx);
		//插入对象
	try{
		//qyryxxService.insertQyryxx(qyryxx);
	}catch(Exception e){
		
	}
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}
}
