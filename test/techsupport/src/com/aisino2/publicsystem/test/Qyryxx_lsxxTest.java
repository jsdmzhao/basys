package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;
import com.aisino2.publicsystem.service.IQyryxx_lsxxService;

public class Qyryxx_lsxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyryxx_lsxxService qyryxx_lsxxService;

	/** @param 企业人员历史信息(t_qyryxx_lsxx) */

	public void test() {
		Qyryxx_lsxx qyryxx_lsxx = new Qyryxx_lsxx();

	/** @ 人员历史ID(rylsid) */
	qyryxx_lsxx.setRylsid(0);

	/** @ 企业ID(qyid) */
	qyryxx_lsxx.setQyid(0);

	/** @ 从业人员ID(ryid) */
	qyryxx_lsxx.setRyid(0);

	/** @ 行业类别代码(hylbdm) */
	qyryxx_lsxx.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyryxx_lsxx.setHylb("test");

	/** @ 从业人员编号(cyrybh) */
	qyryxx_lsxx.setCyrybh("test");

	/** @ 从业人员类别代码(cyrylbdm) */
	qyryxx_lsxx.setCyrylbdm("test");

	/** @ 从业人员类别名称(cyrylbmc) */
	qyryxx_lsxx.setCyrylbmc("test");

	/** @ 姓名(xm) */
	qyryxx_lsxx.setXm("test");

	/** @ 全名(qm) */
	qyryxx_lsxx.setQm("test");

	/** @ 别名(bm) */
	qyryxx_lsxx.setBm("test");

	/** @ 姓名拼音(xmpy) */
	qyryxx_lsxx.setXmpy("test");

	/** @ 国籍代码(gjdm) */
	qyryxx_lsxx.setGjdm("test");

	/** @ 国籍(gj) */
	qyryxx_lsxx.setGj("test");

	/** @ 民族代码(mzdm) */
	qyryxx_lsxx.setMzdm("test");

	/** @ 民族(minzu) */
	qyryxx_lsxx.setMinzu("test");

	/** @ 性别代码(xbdm) */
	qyryxx_lsxx.setXbdm("test");

	/** @ 性别(xb) */
	qyryxx_lsxx.setXb("test");

	/** @ 出生日期(csrq) */
	qyryxx_lsxx.setCsrq(new Date());

	/** @ 婚姻状况代码(hyzkdm) */
	qyryxx_lsxx.setHyzkdm("test");

	/** @ 婚姻状况(hyzk) */
	qyryxx_lsxx.setHyzk("test");

	/** @ 身高(shengao) */
	qyryxx_lsxx.setShengao(new Float(9.9));

	/** @ 体重(tizh) */
	qyryxx_lsxx.setTizh(new Float(9.9));

	/** @ 户籍地行政区划(hjdxzqh) */
	qyryxx_lsxx.setHjdxzqh("test");

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	qyryxx_lsxx.setHjdxzqhdm("test");

	/** @ 户籍地详址(hjdxz) */
	qyryxx_lsxx.setHjdxz("test");

	/** @ 常用证件代码(cyzjdm) */
	qyryxx_lsxx.setCyzjdm("test");

	/** @ 常用证件(cyzj) */
	qyryxx_lsxx.setCyzj("test");

	/** @ 证件号码(zjhm) */
	qyryxx_lsxx.setZjhm("test");

	/** @ 暂住证号码(zzzhm) */
	qyryxx_lsxx.setZzzhm("test");

	/** @ 暂住地址(zzdz) */
	qyryxx_lsxx.setZzdz("test");

	/** @ 岗位编号(gwbh) */
	qyryxx_lsxx.setGwbh("test");

	/** @ 岗位名称(gwmc) */
	qyryxx_lsxx.setGwmc("test");

	/** @ 岗位责任描述(gwzrms) */
	qyryxx_lsxx.setGwzrms("test");

	/** @ 手机(shouji) */
	qyryxx_lsxx.setShouji("test");

	/** @ 联系电话(lxdh) */
	qyryxx_lsxx.setLxdh("test");

	/** @ 紧急联系人(jjlxr) */
	qyryxx_lsxx.setJjlxr("test");

	/** @ 紧急联系人电话(jjlxrdh) */
	qyryxx_lsxx.setJjlxrdh("test");

	/** @ 职务(zhiwu) */
	qyryxx_lsxx.setZhiwu("test");

	/** @ 入职日期(rzrq) */
	qyryxx_lsxx.setRzrq(new Date());

	/** @ 从业人员状态代码(cyryztdm) */
	qyryxx_lsxx.setCyryztdm("test");

	/** @ 从业人员状态(cyryzt) */
	qyryxx_lsxx.setCyryzt("test");

	/** @ 注销人(zxr) */
	qyryxx_lsxx.setZxr("test");

	/** @ 注销标志(zxbz) */
	qyryxx_lsxx.setZxbz("test");

	/** @ 注销时间(zxsj) */
	qyryxx_lsxx.setZxsj(new Date());

	/** @ 录入时间(lrsj) */
	qyryxx_lsxx.setLrsj(new Date());

	/** @ 录入人(lrr) */
	qyryxx_lsxx.setLrr("test");

	/** @ 录入单位编码(lrdwbm) */
	qyryxx_lsxx.setLrdwbm("test");

	/** @ 录入单位名称(lrdwmc) */
	qyryxx_lsxx.setLrdwmc("test");

	/** @ 核查单位(hcdw) */
	qyryxx_lsxx.setHcdw("test");

	/** @ 核查人(hcr) */
	qyryxx_lsxx.setHcr("test");

	/** @ 核查时间(hcsj) */
	qyryxx_lsxx.setHcsj(new Date());

	/** @ 注销原因(zxyy) */
	qyryxx_lsxx.setZxyy("test");

	/** @ 制卡状态(zkzt) */
	qyryxx_lsxx.setZkzt("test");

	/** @ 保存时间(bcsj) */
	qyryxx_lsxx.setBcsj(new Date());

	/** @ 导出标识(dcbs) */
	qyryxx_lsxx.setDcbs(0);

	/** @ 备注(bz) */
	qyryxx_lsxx.setBz("test");

	/** @ 删除标志(scbz) */
	qyryxx_lsxx.setScbz(0);

	/** @ 比对标志(biduiflag) */
	qyryxx_lsxx.setBiduiflag("te");

	/** @ 照片未通过原因(zpwtgyy) */
	qyryxx_lsxx.setZpwtgyy("test");

	/** @ 状态(zt) */
	qyryxx_lsxx.setZt("test");

	/** @ 英文姓(ywx) */
	qyryxx_lsxx.setYwx("test");

	/** @ 英文名(ywm) */
	qyryxx_lsxx.setYwm("test");

	/** @ 外国人就业许可证号(wgrjyxkz) */
	qyryxx_lsxx.setWgrjyxkz("test");

	/** @ 签证种类代码(qzzldm) */
	qyryxx_lsxx.setQzzldm("test");

	/** @ 签证号码(qzhm) */
	qyryxx_lsxx.setQzhm("test");

	/** @ 在华停留期至(zatlq) */
	qyryxx_lsxx.setZatlq(new Date());

	/** @ 签发机关(qfjg) */
	qyryxx_lsxx.setQfjg("test");

	/** @ 入境日期(rjrq) */
	qyryxx_lsxx.setRjrq(new Date());

	/** @ 入境口岸(rjka) */
	qyryxx_lsxx.setRjka("test");

	/** @ 操作类型(czlx) */
	qyryxx_lsxx.setCzlx("test");

	/** @ 变更原因(bgyy) */
	qyryxx_lsxx.setBgyy("test");

	/** @ 变更类别代码(bglbdm) */
	qyryxx_lsxx.setBglbdm("test");

	/** @ 变更类别(bglb) */
	qyryxx_lsxx.setBglb("test");

	/** @ 工种代码(gzdm) */
	qyryxx_lsxx.setGzdm("test");

	/** @ 工种(gz) */
	qyryxx_lsxx.setGz("test");

		/*
		//插入对象
		qyryxx_lsxxService.insertQyryxx_lsxx(qyryxx_lsxx);

		//读取对象比较
		BaseObject bo = qyryxx_lsxxService.getQyryxx_lsxx(qyryxx_lsxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyryxx_lsxx qyryxx_lsxxNew = (Qyryxx_lsxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyryxx_lsxxNew.getRylsid(), qyryxx_lsxx.getRylsid());
		assertEquals(qyryxx_lsxxNew.getQyid(), qyryxx_lsxx.getQyid());
		assertEquals(qyryxx_lsxxNew.getRyid(), qyryxx_lsxx.getRyid());
		assertEquals(qyryxx_lsxxNew.getHylbdm(), qyryxx_lsxx.getHylbdm());
		assertEquals(qyryxx_lsxxNew.getHylb(), qyryxx_lsxx.getHylb());
		assertEquals(qyryxx_lsxxNew.getCyrybh(), qyryxx_lsxx.getCyrybh());
		assertEquals(qyryxx_lsxxNew.getCyrylbdm(), qyryxx_lsxx.getCyrylbdm());
		assertEquals(qyryxx_lsxxNew.getCyrylbmc(), qyryxx_lsxx.getCyrylbmc());
		assertEquals(qyryxx_lsxxNew.getXm(), qyryxx_lsxx.getXm());
		assertEquals(qyryxx_lsxxNew.getQm(), qyryxx_lsxx.getQm());
		assertEquals(qyryxx_lsxxNew.getBm(), qyryxx_lsxx.getBm());
		assertEquals(qyryxx_lsxxNew.getXmpy(), qyryxx_lsxx.getXmpy());
		assertEquals(qyryxx_lsxxNew.getGjdm(), qyryxx_lsxx.getGjdm());
		assertEquals(qyryxx_lsxxNew.getGj(), qyryxx_lsxx.getGj());
		assertEquals(qyryxx_lsxxNew.getMzdm(), qyryxx_lsxx.getMzdm());
		assertEquals(qyryxx_lsxxNew.getMinzu(), qyryxx_lsxx.getMinzu());
		assertEquals(qyryxx_lsxxNew.getXbdm(), qyryxx_lsxx.getXbdm());
		assertEquals(qyryxx_lsxxNew.getXb(), qyryxx_lsxx.getXb());
		assertEquals(qyryxx_lsxxNew.getCsrq(), qyryxx_lsxx.getCsrq());
		assertEquals(qyryxx_lsxxNew.getHyzkdm(), qyryxx_lsxx.getHyzkdm());
		assertEquals(qyryxx_lsxxNew.getHyzk(), qyryxx_lsxx.getHyzk());
		assertEquals(qyryxx_lsxxNew.getShengao(), qyryxx_lsxx.getShengao());
		assertEquals(qyryxx_lsxxNew.getTizh(), qyryxx_lsxx.getTizh());
		assertEquals(qyryxx_lsxxNew.getHjdxzqh(), qyryxx_lsxx.getHjdxzqh());
		assertEquals(qyryxx_lsxxNew.getHjdxzqhdm(), qyryxx_lsxx.getHjdxzqhdm());
		assertEquals(qyryxx_lsxxNew.getHjdxz(), qyryxx_lsxx.getHjdxz());
		assertEquals(qyryxx_lsxxNew.getCyzjdm(), qyryxx_lsxx.getCyzjdm());
		assertEquals(qyryxx_lsxxNew.getCyzj(), qyryxx_lsxx.getCyzj());
		assertEquals(qyryxx_lsxxNew.getZjhm(), qyryxx_lsxx.getZjhm());
		assertEquals(qyryxx_lsxxNew.getZzzhm(), qyryxx_lsxx.getZzzhm());
		assertEquals(qyryxx_lsxxNew.getZzdz(), qyryxx_lsxx.getZzdz());
		assertEquals(qyryxx_lsxxNew.getGwbh(), qyryxx_lsxx.getGwbh());
		assertEquals(qyryxx_lsxxNew.getGwmc(), qyryxx_lsxx.getGwmc());
		assertEquals(qyryxx_lsxxNew.getGwzrms(), qyryxx_lsxx.getGwzrms());
		assertEquals(qyryxx_lsxxNew.getShouji(), qyryxx_lsxx.getShouji());
		assertEquals(qyryxx_lsxxNew.getLxdh(), qyryxx_lsxx.getLxdh());
		assertEquals(qyryxx_lsxxNew.getJjlxr(), qyryxx_lsxx.getJjlxr());
		assertEquals(qyryxx_lsxxNew.getJjlxrdh(), qyryxx_lsxx.getJjlxrdh());
		assertEquals(qyryxx_lsxxNew.getZhiwu(), qyryxx_lsxx.getZhiwu());
		assertEquals(qyryxx_lsxxNew.getRzrq(), qyryxx_lsxx.getRzrq());
		assertEquals(qyryxx_lsxxNew.getCyryztdm(), qyryxx_lsxx.getCyryztdm());
		assertEquals(qyryxx_lsxxNew.getCyryzt(), qyryxx_lsxx.getCyryzt());
		assertEquals(qyryxx_lsxxNew.getZxr(), qyryxx_lsxx.getZxr());
		assertEquals(qyryxx_lsxxNew.getZxbz(), qyryxx_lsxx.getZxbz());
		assertEquals(qyryxx_lsxxNew.getZxsj(), qyryxx_lsxx.getZxsj());
		assertEquals(qyryxx_lsxxNew.getLrsj(), qyryxx_lsxx.getLrsj());
		assertEquals(qyryxx_lsxxNew.getLrr(), qyryxx_lsxx.getLrr());
		assertEquals(qyryxx_lsxxNew.getLrdwbm(), qyryxx_lsxx.getLrdwbm());
		assertEquals(qyryxx_lsxxNew.getLrdwmc(), qyryxx_lsxx.getLrdwmc());
		assertEquals(qyryxx_lsxxNew.getHcdw(), qyryxx_lsxx.getHcdw());
		assertEquals(qyryxx_lsxxNew.getHcr(), qyryxx_lsxx.getHcr());
		assertEquals(qyryxx_lsxxNew.getHcsj(), qyryxx_lsxx.getHcsj());
		assertEquals(qyryxx_lsxxNew.getZxyy(), qyryxx_lsxx.getZxyy());
		assertEquals(qyryxx_lsxxNew.getZkzt(), qyryxx_lsxx.getZkzt());
		assertEquals(qyryxx_lsxxNew.getBcsj(), qyryxx_lsxx.getBcsj());
		assertEquals(qyryxx_lsxxNew.getDcbs(), qyryxx_lsxx.getDcbs());
		assertEquals(qyryxx_lsxxNew.getBz(), qyryxx_lsxx.getBz());
		assertEquals(qyryxx_lsxxNew.getScbz(), qyryxx_lsxx.getScbz());
		assertEquals(qyryxx_lsxxNew.getBiduiflag(), qyryxx_lsxx.getBiduiflag());
		assertEquals(qyryxx_lsxxNew.getZpwtgyy(), qyryxx_lsxx.getZpwtgyy());
		assertEquals(qyryxx_lsxxNew.getZt(), qyryxx_lsxx.getZt());
		assertEquals(qyryxx_lsxxNew.getYwx(), qyryxx_lsxx.getYwx());
		assertEquals(qyryxx_lsxxNew.getYwm(), qyryxx_lsxx.getYwm());
		assertEquals(qyryxx_lsxxNew.getWgrjyxkz(), qyryxx_lsxx.getWgrjyxkz());
		assertEquals(qyryxx_lsxxNew.getQzzldm(), qyryxx_lsxx.getQzzldm());
		assertEquals(qyryxx_lsxxNew.getQzhm(), qyryxx_lsxx.getQzhm());
		assertEquals(qyryxx_lsxxNew.getZatlq(), qyryxx_lsxx.getZatlq());
		assertEquals(qyryxx_lsxxNew.getQfjg(), qyryxx_lsxx.getQfjg());
		assertEquals(qyryxx_lsxxNew.getRjrq(), qyryxx_lsxx.getRjrq());
		assertEquals(qyryxx_lsxxNew.getRjka(), qyryxx_lsxx.getRjka());
		assertEquals(qyryxx_lsxxNew.getCzlx(), qyryxx_lsxx.getCzlx());
		assertEquals(qyryxx_lsxxNew.getBgyy(), qyryxx_lsxx.getBgyy());
		assertEquals(qyryxx_lsxxNew.getBglbdm(), qyryxx_lsxx.getBglbdm());
		assertEquals(qyryxx_lsxxNew.getBglb(), qyryxx_lsxx.getBglb());
		assertEquals(qyryxx_lsxxNew.getGzdm(), qyryxx_lsxx.getGzdm());
		assertEquals(qyryxx_lsxxNew.getGz(), qyryxx_lsxx.getGz());

		//删除对象
		// @ 人员历史ID(rylsid) 
		qyryxx_lsxx.setRylsid(1)
		// @ 企业ID(qyid) 
		qyryxx_lsxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx_lsxx.setRyid(1)

		qyryxx_lsxxService.deleteQyryxx_lsxx(qyryxx_lsxx);

		//修改对象
		// @ 人员历史ID(rylsid) 
		qyryxx_lsxx.setRylsid(1)
		// @ 企业ID(qyid) 
		qyryxx_lsxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx_lsxx.setRyid(1)

		qyryxx_lsxxService.updateQyryxx_lsxx(qyryxx_lsxx);

		//查询单条
		// @ 人员历史ID(rylsid) 
		qyryxx_lsxx.setRylsid(1)
		// @ 企业ID(qyid) 
		qyryxx_lsxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx_lsxx.setRyid(1)

		qyryxx_lsxxService.getQyryxx_lsxx(qyryxx_lsxx);

		//查询多条
		// @ 人员历史ID(rylsid) 
		qyryxx_lsxx.setRylsid(1)
		// @ 企业ID(qyid) 
		qyryxx_lsxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx_lsxx.setRyid(1)

		qyryxx_lsxxService.getListQyryxx_lsxx(qyryxx_lsxx);

		//翻页查询
		// @ 人员历史ID(rylsid) 
		qyryxx_lsxx.setRylsid(1)
		// @ 企业ID(qyid) 
		qyryxx_lsxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyryxx_lsxx.setRyid(1)

		qyryxx_lsxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyryxx_lsxxService.insertQyryxx_lsxx(qyryxx_lsxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyryxx_lsxxService(IQyryxx_lsxxService qyryxx_lsxxService) {
		this.qyryxx_lsxxService = qyryxx_lsxxService;
	}
}
