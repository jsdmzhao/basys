package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Ztryskxxtj;
import com.aisino2.icksystem.service.IZtryskxxtjService;

public class ZtryskxxtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IZtryskxxtjService ztryskxxtjService;

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) */

	public void test() {
		Ztryskxxtj ztryskxxtj = new Ztryskxxtj();

	/** @ 企业人员刷卡信息统计明细ID(qyryskxxtjmxid) */
	ztryskxxtj.setQyryskxxtjmxid(0);

	/** @ 企业编码(qybm) */
	ztryskxxtj.setQybm("test");

	/** @ 企业名称(qymc) */
	ztryskxxtj.setQymc("test");

	/** @ 企业主分类编码(qyzflbm) */
	ztryskxxtj.setQyzflbm("test");

	/** @ 企业主分类名称(qyzflmc) */
	ztryskxxtj.setQyzflmc("test");

	/** @ 企业副分类编码(qyfflbm) */
	ztryskxxtj.setQyfflbm("test");

	/** @ 企业副分类名称(qyfflmc) */
	ztryskxxtj.setQyfflmc("test");

	/** @ 管辖单位代码(gxdwbm) */
	ztryskxxtj.setGxdwbm("test");

	/** @ 管辖单位名称(gxdwmc) */
	ztryskxxtj.setGxdwmc("test");

	/** @ 所属企业ID(ssqyid) */
	ztryskxxtj.setSsqyid(0);

	/** @ 所属企业编码(ssqybm) */
	ztryskxxtj.setSsqybm("test");

	/** @ 所属企业名称(ssqymc) */
	ztryskxxtj.setSsqymc("test");

	/** @ 所属企业管辖单位代码(ssqygxdwdm) */
	ztryskxxtj.setSsqygxdwdm("test");

	/** @ 所属企业管辖单位名称(ssqygxdwmc) */
	ztryskxxtj.setSsqygxdwmc("test");

	/** @ 所属企业主分类代码(ssqyzfldm) */
	ztryskxxtj.setSsqyzfldm("test");

	/** @ 所属企业主分类名称(ssqyzflmc) */
	ztryskxxtj.setSsqyzflmc("test");

	/** @ 行业类别代码(hylbdm) */
	ztryskxxtj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	ztryskxxtj.setHylb("test");

	/** @ 刷卡时间(sksj) */
	ztryskxxtj.setSksj(new Date());

	/** @ 上传时间(scsj) */
	ztryskxxtj.setScsj(new Date());

	/** @ 从业人员ID(ryid) */
	ztryskxxtj.setRyid(0);

	/** @ 从业人员编号(cyrybh) */
	ztryskxxtj.setCyrybh("test");

	/** @ 从业人员类别代码(cyrylbdm) */
	ztryskxxtj.setCyrylbdm("test");

	/** @ 从业人员类别名称(cyrylbmc) */
	ztryskxxtj.setCyrylbmc("test");

	/** @ 姓名(xm) */
	ztryskxxtj.setXm("test");

	/** @ 全名(qm) */
	ztryskxxtj.setQm("test");

	/** @ 别名(bm) */
	ztryskxxtj.setBm("test");

	/** @ 姓名拼音(xmpy) */
	ztryskxxtj.setXmpy("test");

	/** @ 国籍代码(gjdm) */
	ztryskxxtj.setGjdm("test");

	/** @ 国籍(gj) */
	ztryskxxtj.setGj("test");

	/** @ 民族代码(mzdm) */
	ztryskxxtj.setMzdm("test");

	/** @ 民族(minzu) */
	ztryskxxtj.setMinzu("test");

	/** @ 性别代码(xbdm) */
	ztryskxxtj.setXbdm("test");

	/** @ 性别(xb) */
	ztryskxxtj.setXb("test");

	/** @ 出生日期(csrq) */
	ztryskxxtj.setCsrq(new Date());

	/** @ 婚姻状况代码(hyzkdm) */
	ztryskxxtj.setHyzkdm("test");

	/** @ 婚姻状况(hyzk) */
	ztryskxxtj.setHyzk("test");

	/** @ 身高(shengao) */
	ztryskxxtj.setShengao(new Float(9.9));

	/** @ 体重(tizh) */
	ztryskxxtj.setTizh(new Float(9.9));

	/** @ 血型代码(xxdm) */
	ztryskxxtj.setXxdm("test");

	/** @ 血型(xx) */
	ztryskxxtj.setXx("test");

	/** @ 户籍地行政区划(hjdxzqh) */
	ztryskxxtj.setHjdxzqh("test");

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	ztryskxxtj.setHjdxzqhdm("test");

	/** @ 户籍地详址(hjdxz) */
	ztryskxxtj.setHjdxz("test");

	/** @ 常用证件代码(cyzjdm) */
	ztryskxxtj.setCyzjdm("test");

	/** @ 常用证件(cyzj) */
	ztryskxxtj.setCyzj("test");

	/** @ 证件号码(zjhm) */
	ztryskxxtj.setZjhm("test");

	/** @ 暂住证号码(zzzhm) */
	ztryskxxtj.setZzzhm("test");

	/** @ 暂住地址(zzdz) */
	ztryskxxtj.setZzdz("test");

	/** @ 岗位编号(gwbh) */
	ztryskxxtj.setGwbh("test");

	/** @ 岗位名称(gwmc) */
	ztryskxxtj.setGwmc("test");

	/** @ 岗位责任描述(gwzrms) */
	ztryskxxtj.setGwzrms("test");

	/** @ 手机(shouji) */
	ztryskxxtj.setShouji("test");

	/** @ 联系电话(lxdh) */
	ztryskxxtj.setLxdh("test");

	/** @ 紧急联系人(jjlxr) */
	ztryskxxtj.setJjlxr("test");

	/** @ 紧急联系人电话(jjlxrdh) */
	ztryskxxtj.setJjlxrdh("test");

	/** @ 工种代码(gzdm) */
	ztryskxxtj.setGzdm("test");

	/** @ 工种(gz) */
	ztryskxxtj.setGz("test");

	/** @ 职务(zhiwu) */
	ztryskxxtj.setZhiwu("test");

	/** @ 入职日期(rzrq) */
	ztryskxxtj.setRzrq(new Date());

	/** @ 离职日期(lzrq) */
	ztryskxxtj.setLzrq(new Date());

	/** @ 从业人员状态代码(cyryztdm) */
	ztryskxxtj.setCyryztdm("test");

	/** @ 从业人员状态(cyryzt) */
	ztryskxxtj.setCyryzt("test");

	/** @ 撤销人(cxr) */
	ztryskxxtj.setCxr("test");

	/** @ 注销标志(zxbz) */
	ztryskxxtj.setZxbz("test");

	/** @ 撤销时间(cxsj) */
	ztryskxxtj.setCxsj(new Date());

	/** @ 录入时间(lrsj) */
	ztryskxxtj.setLrsj(new Date());

	/** @ 录入人(lrr) */
	ztryskxxtj.setLrr("test");

	/** @ 录入单位编码(lrdwbm) */
	ztryskxxtj.setLrdwbm("test");

	/** @ 录入单位名称(lrdwmc) */
	ztryskxxtj.setLrdwmc("test");

	/** @ 核查单位(hcdw) */
	ztryskxxtj.setHcdw("test");

	/** @ 核查人(hcr) */
	ztryskxxtj.setHcr("test");

	/** @ 核查时间(hcsj) */
	ztryskxxtj.setHcsj(new Date());

	/** @ 注销原因(zxyy) */
	ztryskxxtj.setZxyy("test");

	/** @ 制卡状态(zkzt) */
	ztryskxxtj.setZkzt("test");

	/** @ 保存时间(bcsj) */
	ztryskxxtj.setBcsj(new Date());

	/** @ 导出标识(dcbs) */
	ztryskxxtj.setDcbs(0);

	/** @ 备注(bz) */
	ztryskxxtj.setBz("test");

	/** @ 删除标志(scbz) */
	ztryskxxtj.setScbz(0);

	/** @ 比对标志(biduiflag) */
	ztryskxxtj.setBiduiflag("te");

	/** @ 照片未通过原因(zpwtgyy) */
	ztryskxxtj.setZpwtgyy("test");

	/** @ 状态(zt) */
	ztryskxxtj.setZt("test");

	/** @ 英文姓(ywx) */
	ztryskxxtj.setYwx("test");

	/** @ 英文名(ywm) */
	ztryskxxtj.setYwm("test");

	/** @ 外国人就业许可证号(wgrjyxkz) */
	ztryskxxtj.setWgrjyxkz("test");

	/** @ 签证种类代码(qzzldm) */
	ztryskxxtj.setQzzldm("test");

	/** @ 签证号码(qzhm) */
	ztryskxxtj.setQzhm("test");

	/** @ 在华停留期至(zatlq) */
	ztryskxxtj.setZatlq(new Date());

	/** @ 签发机关(qfjg) */
	ztryskxxtj.setQfjg("test");

	/** @ 入境日期(rjrq) */
	ztryskxxtj.setRjrq(new Date());

	/** @ 入境口岸(rjka) */
	ztryskxxtj.setRjka("test");

	/** @ 卡号(kh) */
	ztryskxxtj.setKh("test");

	/** @ 卡ID号(ickh) */
	ztryskxxtj.setIckh("test");

	/** @ 申领原因(slyy) */
	ztryskxxtj.setSlyy("test");

	/** @ 受理人(slr) */
	ztryskxxtj.setSlr("test");

	/** @ 受理时间(slsj) */
	ztryskxxtj.setSlsj(new Date());

	/** @ 有效期开始日期(yxsksrq) */
	ztryskxxtj.setYxsksrq(new Date());

	/** @ 有效期截至日期(yxqhzrq) */
	ztryskxxtj.setYxqhzrq(new Date());

	/** @ IC卡采集时间(ickcjsj) */
	ztryskxxtj.setIckcjsj(new Date());

	/** @ IC卡采集人(ickcjr) */
	ztryskxxtj.setIckcjr("test");

	/** @ IC卡采集点编码(ickcjdbm) */
	ztryskxxtj.setIckcjdbm("test");

	/** @ IC卡采集点名称(ickcjdmc) */
	ztryskxxtj.setIckcjdmc("test");

	/** @ 接收时间(jssj) */
	ztryskxxtj.setJssj(new Date());

	/** @ 接收包名称(jsbmc) */
	ztryskxxtj.setJsbmc("test");

	/** @ 发放人(ffr) */
	ztryskxxtj.setFfr("test");

	/** @ 发放时间(ffsj) */
	ztryskxxtj.setFfsj(new Date());

	/** @ 领取人(lqr) */
	ztryskxxtj.setLqr("test");

	/** @ 领取时间(lqsj) */
	ztryskxxtj.setLqsj(new Date());

	/** @ 领取人证件类型(lqrzjlx) */
	ztryskxxtj.setLqrzjlx("test");

	/** @ 领取人证件号码(lqrzjhm) */
	ztryskxxtj.setLqrzjhm("test");

	/** @ IC卡注销人(ickzxr) */
	ztryskxxtj.setIckzxr("test");

	/** @ IC卡注销时间(ickzxsj) */
	ztryskxxtj.setIckzxsj(new Date());

	/** @ IC卡注销原因(ickzxyy) */
	ztryskxxtj.setIckzxyy("test");

	/** @ 年检人(njr) */
	ztryskxxtj.setNjr("test");

	/** @ 年检时间(njsj) */
	ztryskxxtj.setNjsj(new Date());

	/** @ 制卡状态标识(zkztbs) */
	ztryskxxtj.setZkztbs("test");

	/** @ 是否确认(sfqr) */
	ztryskxxtj.setSfqr("te");

	/** @ 印刷人(ysr) */
	ztryskxxtj.setYsr("test");

	/** @ 印刷时间(yssj) */
	ztryskxxtj.setYssj(new Date());

	/** @ 电写入人(dxrr) */
	ztryskxxtj.setDxrr("test");

	/** @ 电写入时间(dxrsj) */
	ztryskxxtj.setDxrsj(new Date());

	/** @ 重印刷时间(cyssj) */
	ztryskxxtj.setCyssj(new Date());

	/** @ 重印刷原因(cysyy) */
	ztryskxxtj.setCysyy("test");

	/** @ 重电写入时间(cdxrsj) */
	ztryskxxtj.setCdxrsj(new Date());

	/** @ 重电写入原因(cdxryy) */
	ztryskxxtj.setCdxryy("test");

	/** @ 补换卡原因(bhkyy) */
	ztryskxxtj.setBhkyy("test");

	/** @ 原卡是否收回(yksfsh) */
	ztryskxxtj.setYksfsh("te");

	/** @ 走台人员刷卡信息统计明细id(ztryskxxtjmxid) */
	ztryskxxtj.setZtryskxxtjmxid(0);

	/** @ 刷卡ID(skid3) */
	ztryskxxtj.setSkid3(0);

	/** @ 统计日期(tjrq) */
	ztryskxxtj.setTjrq(new Date());

		/*
		//插入对象
		ztryskxxtjService.insertZtryskxxtj(ztryskxxtj);

		//读取对象比较
		BaseObject bo = ztryskxxtjService.getZtryskxxtj(ztryskxxtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Ztryskxxtj ztryskxxtjNew = (Ztryskxxtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ztryskxxtjNew.getQyryskxxtjmxid(), ztryskxxtj.getQyryskxxtjmxid());
		assertEquals(ztryskxxtjNew.getQybm(), ztryskxxtj.getQybm());
		assertEquals(ztryskxxtjNew.getQymc(), ztryskxxtj.getQymc());
		assertEquals(ztryskxxtjNew.getQyzflbm(), ztryskxxtj.getQyzflbm());
		assertEquals(ztryskxxtjNew.getQyzflmc(), ztryskxxtj.getQyzflmc());
		assertEquals(ztryskxxtjNew.getQyfflbm(), ztryskxxtj.getQyfflbm());
		assertEquals(ztryskxxtjNew.getQyfflmc(), ztryskxxtj.getQyfflmc());
		assertEquals(ztryskxxtjNew.getGxdwbm(), ztryskxxtj.getGxdwbm());
		assertEquals(ztryskxxtjNew.getGxdwmc(), ztryskxxtj.getGxdwmc());
		assertEquals(ztryskxxtjNew.getSsqyid(), ztryskxxtj.getSsqyid());
		assertEquals(ztryskxxtjNew.getSsqybm(), ztryskxxtj.getSsqybm());
		assertEquals(ztryskxxtjNew.getSsqymc(), ztryskxxtj.getSsqymc());
		assertEquals(ztryskxxtjNew.getSsqygxdwdm(), ztryskxxtj.getSsqygxdwdm());
		assertEquals(ztryskxxtjNew.getSsqygxdwmc(), ztryskxxtj.getSsqygxdwmc());
		assertEquals(ztryskxxtjNew.getSsqyzfldm(), ztryskxxtj.getSsqyzfldm());
		assertEquals(ztryskxxtjNew.getSsqyzflmc(), ztryskxxtj.getSsqyzflmc());
		assertEquals(ztryskxxtjNew.getHylbdm(), ztryskxxtj.getHylbdm());
		assertEquals(ztryskxxtjNew.getHylb(), ztryskxxtj.getHylb());
		assertEquals(ztryskxxtjNew.getSksj(), ztryskxxtj.getSksj());
		assertEquals(ztryskxxtjNew.getScsj(), ztryskxxtj.getScsj());
		assertEquals(ztryskxxtjNew.getRyid(), ztryskxxtj.getRyid());
		assertEquals(ztryskxxtjNew.getCyrybh(), ztryskxxtj.getCyrybh());
		assertEquals(ztryskxxtjNew.getCyrylbdm(), ztryskxxtj.getCyrylbdm());
		assertEquals(ztryskxxtjNew.getCyrylbmc(), ztryskxxtj.getCyrylbmc());
		assertEquals(ztryskxxtjNew.getXm(), ztryskxxtj.getXm());
		assertEquals(ztryskxxtjNew.getQm(), ztryskxxtj.getQm());
		assertEquals(ztryskxxtjNew.getBm(), ztryskxxtj.getBm());
		assertEquals(ztryskxxtjNew.getXmpy(), ztryskxxtj.getXmpy());
		assertEquals(ztryskxxtjNew.getGjdm(), ztryskxxtj.getGjdm());
		assertEquals(ztryskxxtjNew.getGj(), ztryskxxtj.getGj());
		assertEquals(ztryskxxtjNew.getMzdm(), ztryskxxtj.getMzdm());
		assertEquals(ztryskxxtjNew.getMinzu(), ztryskxxtj.getMinzu());
		assertEquals(ztryskxxtjNew.getXbdm(), ztryskxxtj.getXbdm());
		assertEquals(ztryskxxtjNew.getXb(), ztryskxxtj.getXb());
		assertEquals(ztryskxxtjNew.getCsrq(), ztryskxxtj.getCsrq());
		assertEquals(ztryskxxtjNew.getHyzkdm(), ztryskxxtj.getHyzkdm());
		assertEquals(ztryskxxtjNew.getHyzk(), ztryskxxtj.getHyzk());
		assertEquals(ztryskxxtjNew.getShengao(), ztryskxxtj.getShengao());
		assertEquals(ztryskxxtjNew.getTizh(), ztryskxxtj.getTizh());
		assertEquals(ztryskxxtjNew.getXxdm(), ztryskxxtj.getXxdm());
		assertEquals(ztryskxxtjNew.getXx(), ztryskxxtj.getXx());
		assertEquals(ztryskxxtjNew.getHjdxzqh(), ztryskxxtj.getHjdxzqh());
		assertEquals(ztryskxxtjNew.getHjdxzqhdm(), ztryskxxtj.getHjdxzqhdm());
		assertEquals(ztryskxxtjNew.getHjdxz(), ztryskxxtj.getHjdxz());
		assertEquals(ztryskxxtjNew.getCyzjdm(), ztryskxxtj.getCyzjdm());
		assertEquals(ztryskxxtjNew.getCyzj(), ztryskxxtj.getCyzj());
		assertEquals(ztryskxxtjNew.getZjhm(), ztryskxxtj.getZjhm());
		assertEquals(ztryskxxtjNew.getZzzhm(), ztryskxxtj.getZzzhm());
		assertEquals(ztryskxxtjNew.getZzdz(), ztryskxxtj.getZzdz());
		assertEquals(ztryskxxtjNew.getGwbh(), ztryskxxtj.getGwbh());
		assertEquals(ztryskxxtjNew.getGwmc(), ztryskxxtj.getGwmc());
		assertEquals(ztryskxxtjNew.getGwzrms(), ztryskxxtj.getGwzrms());
		assertEquals(ztryskxxtjNew.getShouji(), ztryskxxtj.getShouji());
		assertEquals(ztryskxxtjNew.getLxdh(), ztryskxxtj.getLxdh());
		assertEquals(ztryskxxtjNew.getJjlxr(), ztryskxxtj.getJjlxr());
		assertEquals(ztryskxxtjNew.getJjlxrdh(), ztryskxxtj.getJjlxrdh());
		assertEquals(ztryskxxtjNew.getGzdm(), ztryskxxtj.getGzdm());
		assertEquals(ztryskxxtjNew.getGz(), ztryskxxtj.getGz());
		assertEquals(ztryskxxtjNew.getZhiwu(), ztryskxxtj.getZhiwu());
		assertEquals(ztryskxxtjNew.getRzrq(), ztryskxxtj.getRzrq());
		assertEquals(ztryskxxtjNew.getLzrq(), ztryskxxtj.getLzrq());
		assertEquals(ztryskxxtjNew.getCyryztdm(), ztryskxxtj.getCyryztdm());
		assertEquals(ztryskxxtjNew.getCyryzt(), ztryskxxtj.getCyryzt());
		assertEquals(ztryskxxtjNew.getCxr(), ztryskxxtj.getCxr());
		assertEquals(ztryskxxtjNew.getZxbz(), ztryskxxtj.getZxbz());
		assertEquals(ztryskxxtjNew.getCxsj(), ztryskxxtj.getCxsj());
		assertEquals(ztryskxxtjNew.getLrsj(), ztryskxxtj.getLrsj());
		assertEquals(ztryskxxtjNew.getLrr(), ztryskxxtj.getLrr());
		assertEquals(ztryskxxtjNew.getLrdwbm(), ztryskxxtj.getLrdwbm());
		assertEquals(ztryskxxtjNew.getLrdwmc(), ztryskxxtj.getLrdwmc());
		assertEquals(ztryskxxtjNew.getHcdw(), ztryskxxtj.getHcdw());
		assertEquals(ztryskxxtjNew.getHcr(), ztryskxxtj.getHcr());
		assertEquals(ztryskxxtjNew.getHcsj(), ztryskxxtj.getHcsj());
		assertEquals(ztryskxxtjNew.getZxyy(), ztryskxxtj.getZxyy());
		assertEquals(ztryskxxtjNew.getZkzt(), ztryskxxtj.getZkzt());
		assertEquals(ztryskxxtjNew.getBcsj(), ztryskxxtj.getBcsj());
		assertEquals(ztryskxxtjNew.getDcbs(), ztryskxxtj.getDcbs());
		assertEquals(ztryskxxtjNew.getBz(), ztryskxxtj.getBz());
		assertEquals(ztryskxxtjNew.getScbz(), ztryskxxtj.getScbz());
		assertEquals(ztryskxxtjNew.getBiduiflag(), ztryskxxtj.getBiduiflag());
		assertEquals(ztryskxxtjNew.getZpwtgyy(), ztryskxxtj.getZpwtgyy());
		assertEquals(ztryskxxtjNew.getZt(), ztryskxxtj.getZt());
		assertEquals(ztryskxxtjNew.getYwx(), ztryskxxtj.getYwx());
		assertEquals(ztryskxxtjNew.getYwm(), ztryskxxtj.getYwm());
		assertEquals(ztryskxxtjNew.getWgrjyxkz(), ztryskxxtj.getWgrjyxkz());
		assertEquals(ztryskxxtjNew.getQzzldm(), ztryskxxtj.getQzzldm());
		assertEquals(ztryskxxtjNew.getQzhm(), ztryskxxtj.getQzhm());
		assertEquals(ztryskxxtjNew.getZatlq(), ztryskxxtj.getZatlq());
		assertEquals(ztryskxxtjNew.getQfjg(), ztryskxxtj.getQfjg());
		assertEquals(ztryskxxtjNew.getRjrq(), ztryskxxtj.getRjrq());
		assertEquals(ztryskxxtjNew.getRjka(), ztryskxxtj.getRjka());
		assertEquals(ztryskxxtjNew.getKh(), ztryskxxtj.getKh());
		assertEquals(ztryskxxtjNew.getIckh(), ztryskxxtj.getIckh());
		assertEquals(ztryskxxtjNew.getSlyy(), ztryskxxtj.getSlyy());
		assertEquals(ztryskxxtjNew.getSlr(), ztryskxxtj.getSlr());
		assertEquals(ztryskxxtjNew.getSlsj(), ztryskxxtj.getSlsj());
		assertEquals(ztryskxxtjNew.getYxsksrq(), ztryskxxtj.getYxsksrq());
		assertEquals(ztryskxxtjNew.getYxqhzrq(), ztryskxxtj.getYxqhzrq());
		assertEquals(ztryskxxtjNew.getIckcjsj(), ztryskxxtj.getIckcjsj());
		assertEquals(ztryskxxtjNew.getIckcjr(), ztryskxxtj.getIckcjr());
		assertEquals(ztryskxxtjNew.getIckcjdbm(), ztryskxxtj.getIckcjdbm());
		assertEquals(ztryskxxtjNew.getIckcjdmc(), ztryskxxtj.getIckcjdmc());
		assertEquals(ztryskxxtjNew.getJssj(), ztryskxxtj.getJssj());
		assertEquals(ztryskxxtjNew.getJsbmc(), ztryskxxtj.getJsbmc());
		assertEquals(ztryskxxtjNew.getFfr(), ztryskxxtj.getFfr());
		assertEquals(ztryskxxtjNew.getFfsj(), ztryskxxtj.getFfsj());
		assertEquals(ztryskxxtjNew.getLqr(), ztryskxxtj.getLqr());
		assertEquals(ztryskxxtjNew.getLqsj(), ztryskxxtj.getLqsj());
		assertEquals(ztryskxxtjNew.getLqrzjlx(), ztryskxxtj.getLqrzjlx());
		assertEquals(ztryskxxtjNew.getLqrzjhm(), ztryskxxtj.getLqrzjhm());
		assertEquals(ztryskxxtjNew.getIckzxr(), ztryskxxtj.getIckzxr());
		assertEquals(ztryskxxtjNew.getIckzxsj(), ztryskxxtj.getIckzxsj());
		assertEquals(ztryskxxtjNew.getIckzxyy(), ztryskxxtj.getIckzxyy());
		assertEquals(ztryskxxtjNew.getNjr(), ztryskxxtj.getNjr());
		assertEquals(ztryskxxtjNew.getNjsj(), ztryskxxtj.getNjsj());
		assertEquals(ztryskxxtjNew.getZkztbs(), ztryskxxtj.getZkztbs());
		assertEquals(ztryskxxtjNew.getSfqr(), ztryskxxtj.getSfqr());
		assertEquals(ztryskxxtjNew.getYsr(), ztryskxxtj.getYsr());
		assertEquals(ztryskxxtjNew.getYssj(), ztryskxxtj.getYssj());
		assertEquals(ztryskxxtjNew.getDxrr(), ztryskxxtj.getDxrr());
		assertEquals(ztryskxxtjNew.getDxrsj(), ztryskxxtj.getDxrsj());
		assertEquals(ztryskxxtjNew.getCyssj(), ztryskxxtj.getCyssj());
		assertEquals(ztryskxxtjNew.getCysyy(), ztryskxxtj.getCysyy());
		assertEquals(ztryskxxtjNew.getCdxrsj(), ztryskxxtj.getCdxrsj());
		assertEquals(ztryskxxtjNew.getCdxryy(), ztryskxxtj.getCdxryy());
		assertEquals(ztryskxxtjNew.getBhkyy(), ztryskxxtj.getBhkyy());
		assertEquals(ztryskxxtjNew.getYksfsh(), ztryskxxtj.getYksfsh());
		assertEquals(ztryskxxtjNew.getZtryskxxtjmxid(), ztryskxxtj.getZtryskxxtjmxid());
		assertEquals(ztryskxxtjNew.getSkid3(), ztryskxxtj.getSkid3());
		assertEquals(ztryskxxtjNew.getTjrq(), ztryskxxtj.getTjrq());

		//删除对象
		// @ 走台人员刷卡信息统计明细id(ztryskxxtjmxid) 
		ztryskxxtj.setZtryskxxtjmxid(1)

		ztryskxxtjService.deleteZtryskxxtj(ztryskxxtj);

		//修改对象
		// @ 走台人员刷卡信息统计明细id(ztryskxxtjmxid) 
		ztryskxxtj.setZtryskxxtjmxid(1)

		ztryskxxtjService.updateZtryskxxtj(ztryskxxtj);

		//查询单条
		// @ 走台人员刷卡信息统计明细id(ztryskxxtjmxid) 
		ztryskxxtj.setZtryskxxtjmxid(1)

		ztryskxxtjService.getZtryskxxtj(ztryskxxtj);

		//查询多条
		// @ 走台人员刷卡信息统计明细id(ztryskxxtjmxid) 
		ztryskxxtj.setZtryskxxtjmxid(1)

		ztryskxxtjService.getListZtryskxxtj(ztryskxxtj);

		//翻页查询
		// @ 走台人员刷卡信息统计明细id(ztryskxxtjmxid) 
		ztryskxxtj.setZtryskxxtjmxid(1)

		ztryskxxtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		ztryskxxtjService.insertZtryskxxtj(ztryskxxtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setZtryskxxtjService(IZtryskxxtjService ztryskxxtjService) {
		this.ztryskxxtjService = ztryskxxtjService;
	}
}
