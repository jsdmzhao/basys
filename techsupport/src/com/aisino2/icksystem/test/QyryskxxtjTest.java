package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Qyryskxxtj;
import com.aisino2.icksystem.service.IQyryskxxtjService;

public class QyryskxxtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyryskxxtjService qyryskxxtjService;

	/** @param 企业人员刷卡信息统计明细(t_qyryskxxtj) */

	public void test() {
		Qyryskxxtj qyryskxxtj = new Qyryskxxtj();

	/** @ 刷卡ID2(skid) */
	qyryskxxtj.setSkid(0);

	/** @ 刷卡ID(skid2) */
	qyryskxxtj.setSkid2(0);

	/** @ 企业人员刷卡信息统计明细ID(qyryskxxtjmxid) */
	qyryskxxtj.setQyryskxxtjmxid(0);

	/** @ 企业编码(qybm) */
	qyryskxxtj.setQybm("test");

	/** @ 企业名称(qymc) */
	qyryskxxtj.setQymc("test");

	/** @ 企业主分类编码(qyzflbm) */
	qyryskxxtj.setQyzflbm("test");

	/** @ 企业主分类名称(qyzflmc) */
	qyryskxxtj.setQyzflmc("test");

	/** @ 企业副分类编码(qyfflbm) */
	qyryskxxtj.setQyfflbm("test");

	/** @ 企业副分类名称(qyfflmc) */
	qyryskxxtj.setQyfflmc("test");

	/** @ 管辖单位代码(gxdwbm) */
	qyryskxxtj.setGxdwbm("test");

	/** @ 管辖单位名称(gxdwmc) */
	qyryskxxtj.setGxdwmc("test");

	/** @ 所属企业ID(ssqyid) */
	qyryskxxtj.setSsqyid(0);

	/** @ 所属企业编码(ssqybm) */
	qyryskxxtj.setSsqybm("test");

	/** @ 所属企业名称(ssqymc) */
	qyryskxxtj.setSsqymc("test");

	/** @ 所属企业管辖单位代码(ssqygxdwdm) */
	qyryskxxtj.setSsqygxdwdm("test");

	/** @ 所属企业管辖单位名称(ssqygxdwmc) */
	qyryskxxtj.setSsqygxdwmc("test");

	/** @ 所属企业主分类代码(ssqyzfldm) */
	qyryskxxtj.setSsqyzfldm("test");

	/** @ 所属企业主分类名称(ssqyzflmc) */
	qyryskxxtj.setSsqyzflmc("test");

	/** @ 行业类别代码(hylbdm) */
	qyryskxxtj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyryskxxtj.setHylb("test");

	/** @ IC卡受理ID(ickslid) */
	qyryskxxtj.setIckslid(0);

	/** @ 物流ID(wlid) */
	qyryskxxtj.setWlid(0);

	/** @ 组包ID(zbid) */
	qyryskxxtj.setZbid(0);

	/** @ 刷卡时间(sksj) */
	qyryskxxtj.setSksj(new Date());

	/** @ 上传时间(scsj) */
	qyryskxxtj.setScsj(new Date());

	/** @ 从业人员ID(ryid) */
	qyryskxxtj.setRyid(0);

	/** @ 从业人员编号(cyrybh) */
	qyryskxxtj.setCyrybh("test");

	/** @ 从业人员类别代码(cyrylbdm) */
	qyryskxxtj.setCyrylbdm("test");

	/** @ 从业人员类别名称(cyrylbmc) */
	qyryskxxtj.setCyrylbmc("test");

	/** @ 姓名(xm) */
	qyryskxxtj.setXm("test");

	/** @ 全名(qm) */
	qyryskxxtj.setQm("test");

	/** @ 别名(bm) */
	qyryskxxtj.setBm("test");

	/** @ 姓名拼音(xmpy) */
	qyryskxxtj.setXmpy("test");

	/** @ 国籍代码(gjdm) */
	qyryskxxtj.setGjdm("test");

	/** @ 国籍(gj) */
	qyryskxxtj.setGj("test");

	/** @ 民族代码(mzdm) */
	qyryskxxtj.setMzdm("test");

	/** @ 民族(minzu) */
	qyryskxxtj.setMinzu("test");

	/** @ 性别代码(xbdm) */
	qyryskxxtj.setXbdm("test");

	/** @ 性别(xb) */
	qyryskxxtj.setXb("test");

	/** @ 出生日期(csrq) */
	qyryskxxtj.setCsrq(new Date());

	/** @ 婚姻状况代码(hyzkdm) */
	qyryskxxtj.setHyzkdm("test");

	/** @ 婚姻状况(hyzk) */
	qyryskxxtj.setHyzk("test");

	/** @ 身高(shengao) */
	qyryskxxtj.setShengao(new Float(9.9));

	/** @ 体重(tizh) */
	qyryskxxtj.setTizh(new Float(9.9));

	/** @ 血型代码(xxdm) */
	qyryskxxtj.setXxdm("test");

	/** @ 血型(xx) */
	qyryskxxtj.setXx("test");

	/** @ 户籍地行政区划(hjdxzqh) */
	qyryskxxtj.setHjdxzqh("test");

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	qyryskxxtj.setHjdxzqhdm("test");

	/** @ 户籍地详址(hjdxz) */
	qyryskxxtj.setHjdxz("test");

	/** @ 常用证件代码(cyzjdm) */
	qyryskxxtj.setCyzjdm("test");

	/** @ 常用证件(cyzj) */
	qyryskxxtj.setCyzj("test");

	/** @ 证件号码(zjhm) */
	qyryskxxtj.setZjhm("test");

	/** @ 暂住证号码(zzzhm) */
	qyryskxxtj.setZzzhm("test");

	/** @ 暂住地址(zzdz) */
	qyryskxxtj.setZzdz("test");

	/** @ 岗位编号(gwbh) */
	qyryskxxtj.setGwbh("test");

	/** @ 岗位名称(gwmc) */
	qyryskxxtj.setGwmc("test");

	/** @ 岗位责任描述(gwzrms) */
	qyryskxxtj.setGwzrms("test");

	/** @ 手机(shouji) */
	qyryskxxtj.setShouji("test");

	/** @ 联系电话(lxdh) */
	qyryskxxtj.setLxdh("test");

	/** @ 紧急联系人(jjlxr) */
	qyryskxxtj.setJjlxr("test");

	/** @ 紧急联系人电话(jjlxrdh) */
	qyryskxxtj.setJjlxrdh("test");

	/** @ 工种代码(gzdm) */
	qyryskxxtj.setGzdm("test");

	/** @ 工种(gz) */
	qyryskxxtj.setGz("test");

	/** @ 职务(zhiwu) */
	qyryskxxtj.setZhiwu("test");

	/** @ 入职日期(rzrq) */
	qyryskxxtj.setRzrq(new Date());

	/** @ 离职日期(lzrq) */
	qyryskxxtj.setLzrq(new Date());

	/** @ 从业人员状态代码(cyryztdm) */
	qyryskxxtj.setCyryztdm("test");

	/** @ 从业人员状态(cyryzt) */
	qyryskxxtj.setCyryzt("test");

	/** @ 撤销人(cxr) */
	qyryskxxtj.setCxr("test");

	/** @ 注销标志(zxbz) */
	qyryskxxtj.setZxbz("test");

	/** @ 撤销时间(cxsj) */
	qyryskxxtj.setCxsj(new Date());

	/** @ 录入时间(lrsj) */
	qyryskxxtj.setLrsj(new Date());

	/** @ 录入人(lrr) */
	qyryskxxtj.setLrr("test");

	/** @ 录入单位编码(lrdwbm) */
	qyryskxxtj.setLrdwbm("test");

	/** @ 录入单位名称(lrdwmc) */
	qyryskxxtj.setLrdwmc("test");

	/** @ 核查单位(hcdw) */
	qyryskxxtj.setHcdw("test");

	/** @ 核查人(hcr) */
	qyryskxxtj.setHcr("test");

	/** @ 核查时间(hcsj) */
	qyryskxxtj.setHcsj(new Date());

	/** @ 注销原因(zxyy) */
	qyryskxxtj.setZxyy("test");

	/** @ 制卡状态(zkzt) */
	qyryskxxtj.setZkzt("test");

	/** @ 保存时间(bcsj) */
	qyryskxxtj.setBcsj(new Date());

	/** @ 导出标识(dcbs) */
	qyryskxxtj.setDcbs(0);

	/** @ 备注(bz) */
	qyryskxxtj.setBz("test");

	/** @ 删除标志(scbz) */
	qyryskxxtj.setScbz(0);

	/** @ 比对标志(biduiflag) */
	qyryskxxtj.setBiduiflag("te");

	/** @ 照片未通过原因(zpwtgyy) */
	qyryskxxtj.setZpwtgyy("test");

	/** @ 状态(zt) */
	qyryskxxtj.setZt("test");

	/** @ 英文姓(ywx) */
	qyryskxxtj.setYwx("test");

	/** @ 英文名(ywm) */
	qyryskxxtj.setYwm("test");

	/** @ 外国人就业许可证号(wgrjyxkz) */
	qyryskxxtj.setWgrjyxkz("test");

	/** @ 签证种类代码(qzzldm) */
	qyryskxxtj.setQzzldm("test");

	/** @ 签证号码(qzhm) */
	qyryskxxtj.setQzhm("test");

	/** @ 在华停留期至(zatlq) */
	qyryskxxtj.setZatlq(new Date());

	/** @ 签发机关(qfjg) */
	qyryskxxtj.setQfjg("test");

	/** @ 入境日期(rjrq) */
	qyryskxxtj.setRjrq(new Date());

	/** @ 入境口岸(rjka) */
	qyryskxxtj.setRjka("test");

	/** @ 卡号(kh) */
	qyryskxxtj.setKh("test");

	/** @ 卡ID号(ickh) */
	qyryskxxtj.setIckh("test");

	/** @ 申领原因(slyy) */
	qyryskxxtj.setSlyy("test");

	/** @ 受理人(slr) */
	qyryskxxtj.setSlr("test");

	/** @ 受理时间(slsj) */
	qyryskxxtj.setSlsj(new Date());

	/** @ 有效期开始日期(yxsksrq) */
	qyryskxxtj.setYxsksrq(new Date());

	/** @ 有效期截至日期(yxqhzrq) */
	qyryskxxtj.setYxqhzrq(new Date());

	/** @ IC卡采集时间(ickcjsj) */
	qyryskxxtj.setIckcjsj(new Date());

	/** @ IC卡采集人(ickcjr) */
	qyryskxxtj.setIckcjr("test");

	/** @ IC卡采集点编码(ickcjdbm) */
	qyryskxxtj.setIckcjdbm("test");

	/** @ IC卡采集点名称(ickcjdmc) */
	qyryskxxtj.setIckcjdmc("test");

	/** @ 接收时间(jssj) */
	qyryskxxtj.setJssj(new Date());

	/** @ 接收包名称(jsbmc) */
	qyryskxxtj.setJsbmc("test");

	/** @ 发放人(ffr) */
	qyryskxxtj.setFfr("test");

	/** @ 发放时间(ffsj) */
	qyryskxxtj.setFfsj(new Date());

	/** @ 领取人(lqr) */
	qyryskxxtj.setLqr("test");

	/** @ 领取时间(lqsj) */
	qyryskxxtj.setLqsj(new Date());

	/** @ 领取人证件类型(lqrzjlx) */
	qyryskxxtj.setLqrzjlx("test");

	/** @ 领取人证件号码(lqrzjhm) */
	qyryskxxtj.setLqrzjhm("test");

	/** @ IC卡注销人(ickzxr) */
	qyryskxxtj.setIckzxr("test");

	/** @ IC卡注销时间(ickzxsj) */
	qyryskxxtj.setIckzxsj(new Date());

	/** @ IC卡注销原因(ickzxyy) */
	qyryskxxtj.setIckzxyy("test");

	/** @ 年检人(njr) */
	qyryskxxtj.setNjr("test");

	/** @ 年检时间(njsj) */
	qyryskxxtj.setNjsj(new Date());

	/** @ 制卡状态标识(zkztbs) */
	qyryskxxtj.setZkztbs("test");

	/** @ 是否确认(sfqr) */
	qyryskxxtj.setSfqr("te");

	/** @ 印刷人(ysr) */
	qyryskxxtj.setYsr("test");

	/** @ 印刷时间(yssj) */
	qyryskxxtj.setYssj(new Date());

	/** @ 电写入人(dxrr) */
	qyryskxxtj.setDxrr("test");

	/** @ 电写入时间(dxrsj) */
	qyryskxxtj.setDxrsj(new Date());

	/** @ 重印刷时间(cyssj) */
	qyryskxxtj.setCyssj(new Date());

	/** @ 重印刷原因(cysyy) */
	qyryskxxtj.setCysyy("test");

	/** @ 重电写入时间(cdxrsj) */
	qyryskxxtj.setCdxrsj(new Date());

	/** @ 重电写入原因(cdxryy) */
	qyryskxxtj.setCdxryy("test");

	/** @ 补换卡原因(bhkyy) */
	qyryskxxtj.setBhkyy("test");

	/** @ 原卡是否收回(yksfsh) */
	qyryskxxtj.setYksfsh("te");

		/*
		//插入对象
		qyryskxxtjService.insertQyryskxxtj(qyryskxxtj);

		//读取对象比较
		BaseObject bo = qyryskxxtjService.getQyryskxxtj(qyryskxxtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyryskxxtj qyryskxxtjNew = (Qyryskxxtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyryskxxtjNew.getSkid(), qyryskxxtj.getSkid());
		assertEquals(qyryskxxtjNew.getSkid2(), qyryskxxtj.getSkid2());
		assertEquals(qyryskxxtjNew.getQyryskxxtjmxid(), qyryskxxtj.getQyryskxxtjmxid());
		assertEquals(qyryskxxtjNew.getQybm(), qyryskxxtj.getQybm());
		assertEquals(qyryskxxtjNew.getQymc(), qyryskxxtj.getQymc());
		assertEquals(qyryskxxtjNew.getQyzflbm(), qyryskxxtj.getQyzflbm());
		assertEquals(qyryskxxtjNew.getQyzflmc(), qyryskxxtj.getQyzflmc());
		assertEquals(qyryskxxtjNew.getQyfflbm(), qyryskxxtj.getQyfflbm());
		assertEquals(qyryskxxtjNew.getQyfflmc(), qyryskxxtj.getQyfflmc());
		assertEquals(qyryskxxtjNew.getGxdwbm(), qyryskxxtj.getGxdwbm());
		assertEquals(qyryskxxtjNew.getGxdwmc(), qyryskxxtj.getGxdwmc());
		assertEquals(qyryskxxtjNew.getSsqyid(), qyryskxxtj.getSsqyid());
		assertEquals(qyryskxxtjNew.getSsqybm(), qyryskxxtj.getSsqybm());
		assertEquals(qyryskxxtjNew.getSsqymc(), qyryskxxtj.getSsqymc());
		assertEquals(qyryskxxtjNew.getSsqygxdwdm(), qyryskxxtj.getSsqygxdwdm());
		assertEquals(qyryskxxtjNew.getSsqygxdwmc(), qyryskxxtj.getSsqygxdwmc());
		assertEquals(qyryskxxtjNew.getSsqyzfldm(), qyryskxxtj.getSsqyzfldm());
		assertEquals(qyryskxxtjNew.getSsqyzflmc(), qyryskxxtj.getSsqyzflmc());
		assertEquals(qyryskxxtjNew.getHylbdm(), qyryskxxtj.getHylbdm());
		assertEquals(qyryskxxtjNew.getHylb(), qyryskxxtj.getHylb());
		assertEquals(qyryskxxtjNew.getIckslid(), qyryskxxtj.getIckslid());
		assertEquals(qyryskxxtjNew.getWlid(), qyryskxxtj.getWlid());
		assertEquals(qyryskxxtjNew.getZbid(), qyryskxxtj.getZbid());
		assertEquals(qyryskxxtjNew.getSksj(), qyryskxxtj.getSksj());
		assertEquals(qyryskxxtjNew.getScsj(), qyryskxxtj.getScsj());
		assertEquals(qyryskxxtjNew.getRyid(), qyryskxxtj.getRyid());
		assertEquals(qyryskxxtjNew.getCyrybh(), qyryskxxtj.getCyrybh());
		assertEquals(qyryskxxtjNew.getCyrylbdm(), qyryskxxtj.getCyrylbdm());
		assertEquals(qyryskxxtjNew.getCyrylbmc(), qyryskxxtj.getCyrylbmc());
		assertEquals(qyryskxxtjNew.getXm(), qyryskxxtj.getXm());
		assertEquals(qyryskxxtjNew.getQm(), qyryskxxtj.getQm());
		assertEquals(qyryskxxtjNew.getBm(), qyryskxxtj.getBm());
		assertEquals(qyryskxxtjNew.getXmpy(), qyryskxxtj.getXmpy());
		assertEquals(qyryskxxtjNew.getGjdm(), qyryskxxtj.getGjdm());
		assertEquals(qyryskxxtjNew.getGj(), qyryskxxtj.getGj());
		assertEquals(qyryskxxtjNew.getMzdm(), qyryskxxtj.getMzdm());
		assertEquals(qyryskxxtjNew.getMinzu(), qyryskxxtj.getMinzu());
		assertEquals(qyryskxxtjNew.getXbdm(), qyryskxxtj.getXbdm());
		assertEquals(qyryskxxtjNew.getXb(), qyryskxxtj.getXb());
		assertEquals(qyryskxxtjNew.getCsrq(), qyryskxxtj.getCsrq());
		assertEquals(qyryskxxtjNew.getHyzkdm(), qyryskxxtj.getHyzkdm());
		assertEquals(qyryskxxtjNew.getHyzk(), qyryskxxtj.getHyzk());
		assertEquals(qyryskxxtjNew.getShengao(), qyryskxxtj.getShengao());
		assertEquals(qyryskxxtjNew.getTizh(), qyryskxxtj.getTizh());
		assertEquals(qyryskxxtjNew.getXxdm(), qyryskxxtj.getXxdm());
		assertEquals(qyryskxxtjNew.getXx(), qyryskxxtj.getXx());
		assertEquals(qyryskxxtjNew.getHjdxzqh(), qyryskxxtj.getHjdxzqh());
		assertEquals(qyryskxxtjNew.getHjdxzqhdm(), qyryskxxtj.getHjdxzqhdm());
		assertEquals(qyryskxxtjNew.getHjdxz(), qyryskxxtj.getHjdxz());
		assertEquals(qyryskxxtjNew.getCyzjdm(), qyryskxxtj.getCyzjdm());
		assertEquals(qyryskxxtjNew.getCyzj(), qyryskxxtj.getCyzj());
		assertEquals(qyryskxxtjNew.getZjhm(), qyryskxxtj.getZjhm());
		assertEquals(qyryskxxtjNew.getZzzhm(), qyryskxxtj.getZzzhm());
		assertEquals(qyryskxxtjNew.getZzdz(), qyryskxxtj.getZzdz());
		assertEquals(qyryskxxtjNew.getGwbh(), qyryskxxtj.getGwbh());
		assertEquals(qyryskxxtjNew.getGwmc(), qyryskxxtj.getGwmc());
		assertEquals(qyryskxxtjNew.getGwzrms(), qyryskxxtj.getGwzrms());
		assertEquals(qyryskxxtjNew.getShouji(), qyryskxxtj.getShouji());
		assertEquals(qyryskxxtjNew.getLxdh(), qyryskxxtj.getLxdh());
		assertEquals(qyryskxxtjNew.getJjlxr(), qyryskxxtj.getJjlxr());
		assertEquals(qyryskxxtjNew.getJjlxrdh(), qyryskxxtj.getJjlxrdh());
		assertEquals(qyryskxxtjNew.getGzdm(), qyryskxxtj.getGzdm());
		assertEquals(qyryskxxtjNew.getGz(), qyryskxxtj.getGz());
		assertEquals(qyryskxxtjNew.getZhiwu(), qyryskxxtj.getZhiwu());
		assertEquals(qyryskxxtjNew.getRzrq(), qyryskxxtj.getRzrq());
		assertEquals(qyryskxxtjNew.getLzrq(), qyryskxxtj.getLzrq());
		assertEquals(qyryskxxtjNew.getCyryztdm(), qyryskxxtj.getCyryztdm());
		assertEquals(qyryskxxtjNew.getCyryzt(), qyryskxxtj.getCyryzt());
		assertEquals(qyryskxxtjNew.getCxr(), qyryskxxtj.getCxr());
		assertEquals(qyryskxxtjNew.getZxbz(), qyryskxxtj.getZxbz());
		assertEquals(qyryskxxtjNew.getCxsj(), qyryskxxtj.getCxsj());
		assertEquals(qyryskxxtjNew.getLrsj(), qyryskxxtj.getLrsj());
		assertEquals(qyryskxxtjNew.getLrr(), qyryskxxtj.getLrr());
		assertEquals(qyryskxxtjNew.getLrdwbm(), qyryskxxtj.getLrdwbm());
		assertEquals(qyryskxxtjNew.getLrdwmc(), qyryskxxtj.getLrdwmc());
		assertEquals(qyryskxxtjNew.getHcdw(), qyryskxxtj.getHcdw());
		assertEquals(qyryskxxtjNew.getHcr(), qyryskxxtj.getHcr());
		assertEquals(qyryskxxtjNew.getHcsj(), qyryskxxtj.getHcsj());
		assertEquals(qyryskxxtjNew.getZxyy(), qyryskxxtj.getZxyy());
		assertEquals(qyryskxxtjNew.getZkzt(), qyryskxxtj.getZkzt());
		assertEquals(qyryskxxtjNew.getBcsj(), qyryskxxtj.getBcsj());
		assertEquals(qyryskxxtjNew.getDcbs(), qyryskxxtj.getDcbs());
		assertEquals(qyryskxxtjNew.getBz(), qyryskxxtj.getBz());
		assertEquals(qyryskxxtjNew.getScbz(), qyryskxxtj.getScbz());
		assertEquals(qyryskxxtjNew.getBiduiflag(), qyryskxxtj.getBiduiflag());
		assertEquals(qyryskxxtjNew.getZpwtgyy(), qyryskxxtj.getZpwtgyy());
		assertEquals(qyryskxxtjNew.getZt(), qyryskxxtj.getZt());
		assertEquals(qyryskxxtjNew.getYwx(), qyryskxxtj.getYwx());
		assertEquals(qyryskxxtjNew.getYwm(), qyryskxxtj.getYwm());
		assertEquals(qyryskxxtjNew.getWgrjyxkz(), qyryskxxtj.getWgrjyxkz());
		assertEquals(qyryskxxtjNew.getQzzldm(), qyryskxxtj.getQzzldm());
		assertEquals(qyryskxxtjNew.getQzhm(), qyryskxxtj.getQzhm());
		assertEquals(qyryskxxtjNew.getZatlq(), qyryskxxtj.getZatlq());
		assertEquals(qyryskxxtjNew.getQfjg(), qyryskxxtj.getQfjg());
		assertEquals(qyryskxxtjNew.getRjrq(), qyryskxxtj.getRjrq());
		assertEquals(qyryskxxtjNew.getRjka(), qyryskxxtj.getRjka());
		assertEquals(qyryskxxtjNew.getKh(), qyryskxxtj.getKh());
		assertEquals(qyryskxxtjNew.getIckh(), qyryskxxtj.getIckh());
		assertEquals(qyryskxxtjNew.getSlyy(), qyryskxxtj.getSlyy());
		assertEquals(qyryskxxtjNew.getSlr(), qyryskxxtj.getSlr());
		assertEquals(qyryskxxtjNew.getSlsj(), qyryskxxtj.getSlsj());
		assertEquals(qyryskxxtjNew.getYxsksrq(), qyryskxxtj.getYxsksrq());
		assertEquals(qyryskxxtjNew.getYxqhzrq(), qyryskxxtj.getYxqhzrq());
		assertEquals(qyryskxxtjNew.getIckcjsj(), qyryskxxtj.getIckcjsj());
		assertEquals(qyryskxxtjNew.getIckcjr(), qyryskxxtj.getIckcjr());
		assertEquals(qyryskxxtjNew.getIckcjdbm(), qyryskxxtj.getIckcjdbm());
		assertEquals(qyryskxxtjNew.getIckcjdmc(), qyryskxxtj.getIckcjdmc());
		assertEquals(qyryskxxtjNew.getJssj(), qyryskxxtj.getJssj());
		assertEquals(qyryskxxtjNew.getJsbmc(), qyryskxxtj.getJsbmc());
		assertEquals(qyryskxxtjNew.getFfr(), qyryskxxtj.getFfr());
		assertEquals(qyryskxxtjNew.getFfsj(), qyryskxxtj.getFfsj());
		assertEquals(qyryskxxtjNew.getLqr(), qyryskxxtj.getLqr());
		assertEquals(qyryskxxtjNew.getLqsj(), qyryskxxtj.getLqsj());
		assertEquals(qyryskxxtjNew.getLqrzjlx(), qyryskxxtj.getLqrzjlx());
		assertEquals(qyryskxxtjNew.getLqrzjhm(), qyryskxxtj.getLqrzjhm());
		assertEquals(qyryskxxtjNew.getIckzxr(), qyryskxxtj.getIckzxr());
		assertEquals(qyryskxxtjNew.getIckzxsj(), qyryskxxtj.getIckzxsj());
		assertEquals(qyryskxxtjNew.getIckzxyy(), qyryskxxtj.getIckzxyy());
		assertEquals(qyryskxxtjNew.getNjr(), qyryskxxtj.getNjr());
		assertEquals(qyryskxxtjNew.getNjsj(), qyryskxxtj.getNjsj());
		assertEquals(qyryskxxtjNew.getZkztbs(), qyryskxxtj.getZkztbs());
		assertEquals(qyryskxxtjNew.getSfqr(), qyryskxxtj.getSfqr());
		assertEquals(qyryskxxtjNew.getYsr(), qyryskxxtj.getYsr());
		assertEquals(qyryskxxtjNew.getYssj(), qyryskxxtj.getYssj());
		assertEquals(qyryskxxtjNew.getDxrr(), qyryskxxtj.getDxrr());
		assertEquals(qyryskxxtjNew.getDxrsj(), qyryskxxtj.getDxrsj());
		assertEquals(qyryskxxtjNew.getCyssj(), qyryskxxtj.getCyssj());
		assertEquals(qyryskxxtjNew.getCysyy(), qyryskxxtj.getCysyy());
		assertEquals(qyryskxxtjNew.getCdxrsj(), qyryskxxtj.getCdxrsj());
		assertEquals(qyryskxxtjNew.getCdxryy(), qyryskxxtj.getCdxryy());
		assertEquals(qyryskxxtjNew.getBhkyy(), qyryskxxtj.getBhkyy());
		assertEquals(qyryskxxtjNew.getYksfsh(), qyryskxxtj.getYksfsh());

		//删除对象
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID(skid2) 
		qyryskxxtj.setSkid2(1)
		// @ IC卡受理ID(ickslid) 
		qyryskxxtj.setIckslid(1)
		// @ 物流ID(wlid) 
		qyryskxxtj.setWlid(1)
		// @ 组包ID(zbid) 
		qyryskxxtj.setZbid(1)

		qyryskxxtjService.deleteQyryskxxtj(qyryskxxtj);

		//修改对象
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID(skid2) 
		qyryskxxtj.setSkid2(1)
		// @ IC卡受理ID(ickslid) 
		qyryskxxtj.setIckslid(1)
		// @ 物流ID(wlid) 
		qyryskxxtj.setWlid(1)
		// @ 组包ID(zbid) 
		qyryskxxtj.setZbid(1)

		qyryskxxtjService.updateQyryskxxtj(qyryskxxtj);

		//查询单条
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID(skid2) 
		qyryskxxtj.setSkid2(1)
		// @ IC卡受理ID(ickslid) 
		qyryskxxtj.setIckslid(1)
		// @ 物流ID(wlid) 
		qyryskxxtj.setWlid(1)
		// @ 组包ID(zbid) 
		qyryskxxtj.setZbid(1)

		qyryskxxtjService.getQyryskxxtj(qyryskxxtj);

		//查询多条
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID(skid2) 
		qyryskxxtj.setSkid2(1)
		// @ IC卡受理ID(ickslid) 
		qyryskxxtj.setIckslid(1)
		// @ 物流ID(wlid) 
		qyryskxxtj.setWlid(1)
		// @ 组包ID(zbid) 
		qyryskxxtj.setZbid(1)

		qyryskxxtjService.getListQyryskxxtj(qyryskxxtj);

		//翻页查询
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID2(skid) 
		qyryskxxtj.setSkid(1)
		// @ 刷卡ID(skid2) 
		qyryskxxtj.setSkid2(1)
		// @ IC卡受理ID(ickslid) 
		qyryskxxtj.setIckslid(1)
		// @ 物流ID(wlid) 
		qyryskxxtj.setWlid(1)
		// @ 组包ID(zbid) 
		qyryskxxtj.setZbid(1)

		qyryskxxtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyryskxxtjService.insertQyryskxxtj(qyryskxxtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyryskxxtjService(IQyryskxxtjService qyryskxxtjService) {
		this.qyryskxxtjService = qyryskxxtjService;
	}
}
