package com.aisino2.publicsystem.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.publicsystem.domain.Aqjcsb;
import com.aisino2.publicsystem.domain.Bafwht;
import com.aisino2.publicsystem.domain.Bldsjksb;
import com.aisino2.publicsystem.domain.Pmt;
import com.aisino2.publicsystem.domain.Qyffl;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyzjb;
import com.aisino2.publicsystem.domain.Wgtzrxx;
import com.aisino2.publicsystem.service.IQyfflService;
import com.aisino2.publicsystem.service.IQyjbxxService;

public class QyjbxxTest extends AbstractTransactionalDataSourceSpringContextTests {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyjbxxService qyjbxxService;
	private IQyfflService qyfflService;
	
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
		this.setAutowireMode(0);

		return paths;
	}


	/** @param 企业基本信息(t_qyjbxx) */

	public void test() {
		Qyjbxx qyjbxx = new Qyjbxx();
		/** 证件表 */
		List lQyzjbList = new ArrayList();
		/** 场所副分类 */
		List lQyfflList = new ArrayList();
		/** 外国投资人 */
		List lWgtzrxxList = new ArrayList();
		/** 保安服务合同 */
		List lBafwhtList = new ArrayList();
		/** 闭路电视监控设备 */
		List lBldsjksbList = new ArrayList();
		/** 安全检查设备 */
		List lAqjcsbList = new ArrayList();
		/** 平面图 */
		List lPmtList = new ArrayList();
		
		Qyzjb qyzjb = new Qyzjb();
		Qyffl qyffl = new Qyffl();
		Wgtzrxx wgtzrxx = new Wgtzrxx();
		Bafwht bafwht = new Bafwht();
		Bldsjksb bldsjksb = new Bldsjksb();
		Aqjcsb aqjcsb = new Aqjcsb();
		Pmt pmt = new Pmt();

	/** @ 企业ID(qyid) */
	qyjbxx.setQyid(59);

	/** @ 行业类别代码(hylbdm) */
	qyjbxx.setHylbdm("E01");

	/** @ 行业类别(hylb) */
	qyjbxx.setHylb("旧机动车交易业");

	/** @ 企业编码(qybm) */
	qyjbxx.setQybm("E014107000003");

	/** @ 企业名称(qymc) */
	qyjbxx.setQymc("测试备案日期");

	/** @ 企业全拼(qyqp) */
	//qyjbxx.setQyqp("test");

	/** @ 企业简拼(qyjp) */
	//qyjbxx.setQyjp("test");

	/** @ 企业主分类编码(qyzflbm) */
	qyjbxx.setQyzflbm("E01");

	/** @ 企业主分类名称(qyzflmc) */
	qyjbxx.setQyzflmc("旧机动车交易业");

	/** @ 企业副分类编码(qyfflbm) */
	//qyjbxx.setQyfflbm("J02|J01");

	/** @ 企业副分类名称(qyfflmc) */
	//qyjbxx.setQyfflmc("歌舞娱乐|酒吧");

	/** @ 管辖单位代码(gxdwbm) */
	qyjbxx.setGxdwbm("410700000000");

	/** @ 管辖单位名称(gxdwmc) */
	qyjbxx.setGxdwmc("新乡市公安局");

	/** @ 所属地县级公安机关机构代码(ssdxjgajgdm) */
	//qyjbxx.setSsdxjgajgdm("test");

	/** @ 所属地县级公安机关名称(ssdxjgajgmc) */
	//qyjbxx.setSsdxjgajgmc("test");

	/** @ 所属地地市机构代码(ssddsjgdm) */
	//qyjbxx.setSsddsjgdm("test");

	/** @ 所属地地市机构名称(ssddsjgmc) */
	//qyjbxx.setSsddsjgmc("test");

	/** @ 企业组织机构代码(qyzzjgdm) */
	qyjbxx.setQyzzjgdm("test");

	/** @ 联系电话(lxdh) */
	qyjbxx.setLxdh("test");

	/** @ 邮政编码(yzbm) */
	qyjbxx.setYzbm("test");

	/** @ 传真(chzh) */
	qyjbxx.setChzh("test");

	/** @ 经纬度坐标(jwdzb) */
	qyjbxx.setJwdzb("test");

	/** @ 经济类型编码(jjlxbm) */
	qyjbxx.setJjlxbm("21");

	/** @ 经济类型名称(jjlxmc) */
	qyjbxx.setJjlxmc("test");

	/** @ 经营范围（主营）(jyfwzy) */
	qyjbxx.setJyfwzy("test");

	/** @ 经营范围（兼营）(jyfwjy) */
	qyjbxx.setJyfwjy("test");

	/** @ 注册资金(zczj) */
	qyjbxx.setZczj(new Float(9.9));

	/** @ 经营面积(jymj) */
	qyjbxx.setJymj(new Float(9.9));

	/** @ 治安级别代码(zabdm) */
	qyjbxx.setZabdm("01");

	/** @ 治安级别名称(zajbmc) */
	qyjbxx.setZajbmc("test");

	/** @ 营业状态代码(yyztdm) */
	qyjbxx.setYyztdm("10");

	/** @ 营业状态名称(yyztmc) */
	qyjbxx.setYyztmc("test");

	/** @ 法人代表姓名(frdb) */
	qyjbxx.setFrdb("test");

	/** @ 法人代表证件类别(frdbzjlb) */
	qyjbxx.setFrdbzjlb("01");

	/** @ 法人代表证件号码(frdbzjhm) */
	qyjbxx.setFrdbzjhm("test");

	/** @ 法人代表联系方式(frdblxfs) */
	qyjbxx.setFrdblxfs("test");

	/** @ 开业日期(kyrq) */
	qyjbxx.setKyrq(new Date());

	/** @ 营业时间(yysj) */
	qyjbxx.setYysj("test");

	/** @ 备案编号(babh) */
	qyjbxx.setBabh("test");

	/** @ 备案日期(barq) */
	//qyjbxx.setBarq(new Date());

	/** @ 停业日期(tyrq) */
	qyjbxx.setTyrq(new Date());

	/** @ 经营方式(jyfs) */
	qyjbxx.setJyfs("test");

	/** @ 经营地址(jydz) */
	qyjbxx.setJydz("test");

	/** @ 单位负责人证件类别(dwfzrzjlb) */
	qyjbxx.setDwfzrzjlb("test");

	/** @ 单位负责人证件号码(dwfzrzjhm) */
	qyjbxx.setDwfzrzjhm("test");

	/** @ 单位负责人姓名(dwfzr) */
	qyjbxx.setDwfzr("test");

	/** @ 单位负责人联系方式(dwfzrlxfs) */
	qyjbxx.setDwfzrlxfs("test");

	/** @ 消防审核单位(xfshdw) */
	qyjbxx.setXfshdw("test");

	/** @ 消防合格证号(xfhgzh) */
	qyjbxx.setXfhgzh("test");
	qyjbxx.setCzr("单元测试者mds");

	/** @ 核查单位(hcdw) */
	//qyjbxx.setHcdw("test");

	/** @ 核查人(hcr) */
	//qyjbxx.setHcr("test");

	/** @ 核查时间(hcsj) */
	//qyjbxx.setHcsj(new Date());

	/** @ 股东信息(gdxx) */
	qyjbxx.setGdxx("test");

	/** @ 总人数(zrs) */
	//qyjbxx.setZrs(0);

	/** @ 核定人数(hdrs) */
	qyjbxx.setHdrs(0);

	/** @ 保安公司名称(bagsmc) */
	qyjbxx.setBagsmc("test");

	/** @ 保安负责人公民身份号码(bafzrgmsfhm) */
	qyjbxx.setBafzrgmsfhm("test");

	/** @ 保安负责人姓名(bafzrxm) */
	qyjbxx.setBafzrxm("test");

	/** @ 保安负责人电话(bafzrdh) */
	qyjbxx.setBafzrdh("test");

	/** @ 保安人数(bars) */
	qyjbxx.setBars(0);

	/** @ 经岗位培训人数(jgpxrs) */
	qyjbxx.setJgpxrs(0);

	/** @ 保安公司意见(bagsyj) */
	qyjbxx.setBagsyj("test");

	/** @ 出口数量(cksl) */
	qyjbxx.setCksl(0);

	/** @ 包厢包间数量(bxbjsl) */
	qyjbxx.setBxbjsl(0);

	/** @ 备注(bz) */
	qyjbxx.setBz("test");

	/** @ 导出标识(dcbs) */
	qyjbxx.setDcbs(0);

	/** @ 导出时间(dcsj) */
	qyjbxx.setDcsj(new Date());

	/** @ 状态(zt) */
	//qyjbxx.setZt("test");

	/** @ 状态改变日期(ztgbrq) */
	//qyjbxx.setZtgbrq(new Date());

	/** @ 删除标志(scbz) */
	qyjbxx.setScbz(0);

	/** @ 机器编码(jqbm) */
	//qyjbxx.setJqbm("test");

	/** @ 注销标志(zxbz) */
	//qyjbxx.setZxbz("test");

	/** @ 注销原因(zxyy) */
	//qyjbxx.setZxyy("test");

	/** @ 最低刷卡比(zdskb) */
	qyjbxx.setZdskb(new Float(9.9));

	/** @ 保存时间(bcsj) */
	//qyjbxx.setBcsj(new Date());

	/** @ 录入时间(lrsj) */
	//qyjbxx.setLrsj(new Date());

	/** @ 录入人(lrr) */
	qyjbxx.setLrr("test");

	/** @ 录入单位编码(lrdwbm) */
	qyjbxx.setLrdwbm("410700000000");

	/** @ 录入单位名称(lrdwmc) */
	qyjbxx.setLrdwmc("新乡市公安局");
//==========================================
	
	/** @ 证件ID(zjid) */
	//zjb.setZjid(0);

	/** @ 场所ID(csid) */
	//zjb.setCsid(0);

	/** @ 证件分类(zjfl) */
	qyzjb.setZjfl("营业执照");

	/** @ 证件编号(zjbh) */
	qyzjb.setZjbh("00003");

	/** @ 发证机关(fzjg) */
	qyzjb.setFzjg("营业执照");

	/** @ 起始日期(qsrq) */
	qyzjb.setQsrq(new Date());

	/** @ 截止日期(jzrq) */
	qyzjb.setJzrq(new Date());
	lQyzjbList.add(qyzjb);
	
	
	qyzjb = null;
	qyzjb = new Qyzjb();
	/** @ 证件ID(zjid) */
	//qyzjb.setZjid(0);

	/** @ 场所ID(csid) */
	//qyzjb.setCsid(0);

	/** @ 证件分类(zjfl) */
	qyzjb.setZjfl("经营许可证");

	/** @ 证件编号(zjbh) */
	qyzjb.setZjbh("22222");

	/** @ 发证机关(fzjg) */
	qyzjb.setFzjg("经营许可证");

	/** @ 起始日期(qsrq) */
	qyzjb.setQsrq(new Date());

	/** @ 截止日期(jzrq) */
	qyzjb.setJzrq(new Date());
	lQyzjbList.add(qyzjb);
	
	
	//==========================================
	/** @ 场所分类ID(csflid) */
	//csffl.setCsflid(0);

	/** @ 场所ID(csid) */
	//csffl.setCsid(0);

	/** @ 场所分类编码(csflbm) */
	qyffl.setQyflbm("J02");

	/** @ 上级场所分类名称(sjcsflmc) */
	qyffl.setSjcsflmc("测试副分类1");

	/** @ 场所分类名称(csflmc) */
	qyffl.setQyflmc("测试副分类1");
	lQyfflList.add(qyffl);
	
	qyffl = null;
	qyffl = new Qyffl();
	/** @ 场所分类编码(csflbm) */
	qyffl.setQyflbm("J05");

	/** @ 上级场所分类名称(sjcsflmc) */
	qyffl.setSjcsflmc("测试副分类2");

	/** @ 场所分类名称(csflmc) */
	qyffl.setQyflmc("测试副分类2");
	lQyfflList.add(qyffl);
	
	
	qyffl = null;
	qyffl = new Qyffl();
	/** @ 场所分类编码(csflbm) */
	qyffl.setQyflbm("J03");

	/** @ 上级场所分类名称(sjcsflmc) */
	qyffl.setSjcsflmc("测试副分类3");

	/** @ 场所分类名称(csflmc) */
	qyffl.setQyflmc("测试副分类3");
	lQyfflList.add(qyffl);
	
	qyffl = null;
	qyffl = new Qyffl();
	/** @ 场所分类编码(csflbm) */
	qyffl.setQyflbm("J99");

	/** @ 上级场所分类名称(sjcsflmc) */
	qyffl.setSjcsflmc("测试副分类5");

	/** @ 场所分类名称(csflmc) */
	qyffl.setQyflmc("测试副分类5");
	lQyfflList.add(qyffl);
	//==========================================
	/** @ 外国投资人信息ID(wgtzrxxid) */
	//wgtzrxx.setWgtzrxxid(0);

	/** @ 场所ID(csid) */
	//wgtzrxx.setCsid(0);

	/** @ 联系电话(lxdh) */
	wgtzrxx.setLxdh("test");

	/** @ 国籍代码(gjdm) */
	wgtzrxx.setGjdm("001");

	/** @ 国籍(gj) */
	wgtzrxx.setGj("测试标签三");

	/** @ 签证种类代码(qzzldm) */
	wgtzrxx.setQzzldm("01");

	/** @ 签证种类名称(qzzlmc) */
	wgtzrxx.setQzzlmc("test");

	/** @ 签证号码(qzhm) */
	wgtzrxx.setQzhm("test");

	/** @ 护照种类代码(hzzldm) */
	wgtzrxx.setHzzldm("01");

	/** @ 护照种类名称(hzzlmc) */
	wgtzrxx.setHzzlmc("测试标签三");

	/** @ 护照号码(hzhm) */
	wgtzrxx.setHzhm("test");
	lWgtzrxxList.add(wgtzrxx);
	//==========================================
	/** @ 保安服务合同ID(bafwhtid) */
	//bafwht.setBafwhtid(0);

	/** @ 场所ID(csid) */
	//bafwht.setCsid(0);

	/** @ 保安服务公司名称(bafwgsmc) */
	bafwht.setBafwgsmc("宿迁钱柜");

	/** @ 保安人员资格证书名称(baryzgzsmc) */
	bafwht.setBaryzgzsmc("宿迁钱柜");

	/** @ 保安人员培训结束日期(barypxjsrq) */
	bafwht.setBarypxjsrq(new Date());

	/** @ 合同编号(htbh) */
	bafwht.setHtbh("test");

	/** @ 签订日期(qdrq) */
	bafwht.setQdrq(new Date());
	
	bafwht.setHtyxq(6);

	/** @ 结束日期(jsrq) */
	//bafwht.setJsrq(new Date());

	/** @ 保安人员培训内容(barypxnr) */
	bafwht.setBarypxnr("test");
	lBafwhtList.add(bafwht);
	//==========================================
	/** @ 场所ID(csid) */
	//bldsjksb.setCsid(0);

	/** @ 闭路电视监控设备ID(bldsjksbid) */
	//bldsjksb.setBldsjksbid(0);

	/** @ 网络传输类型编码(wlcslxbm) */
	bldsjksb.setWlcslxbm("test");

	/** @ 网络传输类型名称(wlcslxmc) */
	bldsjksb.setWlcslxmc("宿迁钱柜");

	/** @ 设备检测机构名称(sbjcjgmc) */
	bldsjksb.setSbjcjgmc("test");

	/** @ 安装摄像头数量(azsxtsl) */
	bldsjksb.setAzsxtsl(0);

	/** @ 设备序号(sbxh) */
	bldsjksb.setSbxh("");

	/** @ 生产厂商名称(sccsmc) */
	bldsjksb.setSccsmc("test");

	/** @ 规格型号(ggxh) */
	bldsjksb.setGgxh("test");

	/** @ 安装数量(azsl) */
	bldsjksb.setAzsl(0);

	/** @ 设备名称(sbmc) */
	bldsjksb.setSbmc("test");

	/** @ 是否录像(sflx) */
	bldsjksb.setSflx("01");

	/** @ 服务器IP地址(ipdz) */
	bldsjksb.setIpdz("test");

	/** @ 安装位置(anwz) */
	bldsjksb.setAnwz("test");
	lBldsjksbList.add(bldsjksb);
	//==========================================
	/** @ 场所ID(csid) */
	//aqjcsb.setCsid(0);

	/** @ 安全检查设备ID(anjcsbid) */
	//aqjcsb.setAnjcsbid(0);

	/** @ 安全检查设备种类编码(aqjcsbzlbm) */
	aqjcsb.setAqjcsbzlbm("test");

	/** @ 安全检查设备种类名称(aqjcsbzlmc) */
	aqjcsb.setAqjcsbzlmc("宿迁钱柜");

	/** @ 设备序号(sbxh) */
	aqjcsb.setSbxh("");

	/** @ 规格型号(ggxh) */
	aqjcsb.setGgxh("test");

	/** @ 设备名称(sbmc) */
	aqjcsb.setSbmc("宿迁钱柜");
	lAqjcsbList.add(aqjcsb);
	
	
	//pmt.setCsid(0);
	//pmt.setPmtid(0);
	pmt.setPmtlxdm("pmtlxdm1");
	pmt.setPmtlxmc("平面图类型1");
	pmt.setPmtz(null);
	pmt.setSPmtid("NEW");
	//lPmtList.add(pmt);
	
	Pmt pmt1 = new Pmt();
	pmt1.setPmtlxdm("pmtlxdm2");
	pmt1.setPmtlxmc("平面图类型2");
	pmt1.setPmtz(null);
	pmt1.setSPmtid("NEW");
	lPmtList.add(pmt1);
	
	
	Pmt pmt2 = new Pmt();
	pmt2.setPmtlxdm("pmtlxdm3");
	pmt2.setPmtlxmc("平面图类型3");
	pmt2.setPmtz(null);
	pmt2.setSPmtid("NEW");
	lPmtList.add(pmt2);
	
	
	
	Pmt pmt3 = new Pmt();
	pmt3.setPmtlxdm("pmtlxdm4");
	pmt3.setPmtlxmc("平面图类型4");
	pmt3.setPmtz(null);
	pmt3.setSPmtid("NEW");
	lPmtList.add(pmt3);
	
	
	
	Pmt pmt4 = new Pmt();
	pmt4.setPmtlxdm("pmtlxdm5");
	pmt4.setPmtlxmc("平面图类型5");
	pmt4.setPmtz(null);
	pmt4.setSPmtid("NEW");
	lPmtList.add(pmt4);
	
	
	
	Pmt pmt5 = new Pmt();
	pmt5.setPmtlxdm("55555");
	pmt5.setPmtlxmc("55555");
	pmt5.setPmtz(null);
	pmt5.setSPmtid("NEW");
	lPmtList.add(pmt5);
	
	Pmt pmt6 = new Pmt();
	pmt6.setPmtlxdm("pmtlxdm5xn");
	pmt6.setPmtlxmc("平面图类型xn");
	pmt6.setPmtz(null);
	pmt6.setSPmtid("NEW");
	lPmtList.add(pmt6);
	
	Pmt pmt7 = new Pmt();
	pmt7.setPmtlxdm("33333");
	pmt7.setPmtlxmc("33333");
	pmt7.setPmtz(null);
	pmt7.setSPmtid("");
	lPmtList.add(pmt7);
	
	Pmt pmt8 = new Pmt();
	pmt8.setPmtlxdm("平面图类型8");
	pmt8.setPmtlxmc("平面图类型8");
	pmt8.setPmtz(null);
	pmt8.setSPmtid("NEW");
	lPmtList.add(pmt8);
	//==========================================
	qyjbxx.setLAqjcsbList(lAqjcsbList);
	qyjbxx.setLWgtzrxxList(lWgtzrxxList);
	qyjbxx.setLBafwhtList(lBafwhtList);
	qyjbxx.setLBldsjksbList(lBldsjksbList);
	qyjbxx.setLPmtList(lPmtList);
	//qyjbxx.setLQyfflList(lQyfflList);
	qyjbxx.setLQyzjbList(lQyzjbList);
	
	qyjbxx.setActivePageTwo("1");
	qyjbxx.setActivePageThree("1");
	
	
	
	qyjbxxService = (IQyjbxxService)this.applicationContext.getBean("qyjbxxService");
		/*
		//插入对象
		qyjbxxService.insertQyjbxx(qyjbxx);

		//读取对象比较
		BaseObject bo = qyjbxxService.getQyjbxx(qyjbxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyjbxx qyjbxxNew = (Qyjbxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyjbxxNew.getQyid(), qyjbxx.getQyid());
		assertEquals(qyjbxxNew.getHylbdm(), qyjbxx.getHylbdm());
		assertEquals(qyjbxxNew.getHylb(), qyjbxx.getHylb());
		assertEquals(qyjbxxNew.getQybm(), qyjbxx.getQybm());
		assertEquals(qyjbxxNew.getQymc(), qyjbxx.getQymc());
		assertEquals(qyjbxxNew.getQyqp(), qyjbxx.getQyqp());
		assertEquals(qyjbxxNew.getQyjp(), qyjbxx.getQyjp());
		assertEquals(qyjbxxNew.getQyzflbm(), qyjbxx.getQyzflbm());
		assertEquals(qyjbxxNew.getQyzflmc(), qyjbxx.getQyzflmc());
		assertEquals(qyjbxxNew.getQyfflbm(), qyjbxx.getQyfflbm());
		assertEquals(qyjbxxNew.getQyfflmc(), qyjbxx.getQyfflmc());
		assertEquals(qyjbxxNew.getGxdwbm(), qyjbxx.getGxdwbm());
		assertEquals(qyjbxxNew.getGxdwmc(), qyjbxx.getGxdwmc());
		assertEquals(qyjbxxNew.getSsdxjgajgdm(), qyjbxx.getSsdxjgajgdm());
		assertEquals(qyjbxxNew.getSsdxjgajgmc(), qyjbxx.getSsdxjgajgmc());
		assertEquals(qyjbxxNew.getSsdpcsjgdm(), qyjbxx.getSsdpcsjgdm());
		assertEquals(qyjbxxNew.getSsdpcsjgmc(), qyjbxx.getSsdpcsjgmc());
		assertEquals(qyjbxxNew.getQyzzjgdm(), qyjbxx.getQyzzjgdm());
		assertEquals(qyjbxxNew.getLxdh(), qyjbxx.getLxdh());
		assertEquals(qyjbxxNew.getYzbm(), qyjbxx.getYzbm());
		assertEquals(qyjbxxNew.getChzh(), qyjbxx.getChzh());
		assertEquals(qyjbxxNew.getJwdzb(), qyjbxx.getJwdzb());
		assertEquals(qyjbxxNew.getJjlxbm(), qyjbxx.getJjlxbm());
		assertEquals(qyjbxxNew.getJjlxmc(), qyjbxx.getJjlxmc());
		assertEquals(qyjbxxNew.getJyfwzy(), qyjbxx.getJyfwzy());
		assertEquals(qyjbxxNew.getJyfwjy(), qyjbxx.getJyfwjy());
		assertEquals(qyjbxxNew.getZczj(), qyjbxx.getZczj());
		assertEquals(qyjbxxNew.getJymj(), qyjbxx.getJymj());
		assertEquals(qyjbxxNew.getZabdm(), qyjbxx.getZabdm());
		assertEquals(qyjbxxNew.getZajbmc(), qyjbxx.getZajbmc());
		assertEquals(qyjbxxNew.getYyztdm(), qyjbxx.getYyztdm());
		assertEquals(qyjbxxNew.getYyztmc(), qyjbxx.getYyztmc());
		assertEquals(qyjbxxNew.getFrdb(), qyjbxx.getFrdb());
		assertEquals(qyjbxxNew.getFrdbzjlb(), qyjbxx.getFrdbzjlb());
		assertEquals(qyjbxxNew.getFrdbzjhm(), qyjbxx.getFrdbzjhm());
		assertEquals(qyjbxxNew.getFrdblxfs(), qyjbxx.getFrdblxfs());
		assertEquals(qyjbxxNew.getKyrq(), qyjbxx.getKyrq());
		assertEquals(qyjbxxNew.getYysj(), qyjbxx.getYysj());
		assertEquals(qyjbxxNew.getBabh(), qyjbxx.getBabh());
		assertEquals(qyjbxxNew.getBarq(), qyjbxx.getBarq());
		assertEquals(qyjbxxNew.getTyrq(), qyjbxx.getTyrq());
		assertEquals(qyjbxxNew.getJyfs(), qyjbxx.getJyfs());
		assertEquals(qyjbxxNew.getJydz(), qyjbxx.getJydz());
		assertEquals(qyjbxxNew.getDwfzrzjlb(), qyjbxx.getDwfzrzjlb());
		assertEquals(qyjbxxNew.getDwfzrzjhm(), qyjbxx.getDwfzrzjhm());
		assertEquals(qyjbxxNew.getDwfzr(), qyjbxx.getDwfzr());
		assertEquals(qyjbxxNew.getDwfzrlxfs(), qyjbxx.getDwfzrlxfs());
		assertEquals(qyjbxxNew.getXfshdw(), qyjbxx.getXfshdw());
		assertEquals(qyjbxxNew.getXfhgzh(), qyjbxx.getXfhgzh());
		assertEquals(qyjbxxNew.getHcdw(), qyjbxx.getHcdw());
		assertEquals(qyjbxxNew.getHcr(), qyjbxx.getHcr());
		assertEquals(qyjbxxNew.getHcsj(), qyjbxx.getHcsj());
		assertEquals(qyjbxxNew.getGdxx(), qyjbxx.getGdxx());
		assertEquals(qyjbxxNew.getZrs(), qyjbxx.getZrs());
		assertEquals(qyjbxxNew.getHdrs(), qyjbxx.getHdrs());
		assertEquals(qyjbxxNew.getBagsmc(), qyjbxx.getBagsmc());
		assertEquals(qyjbxxNew.getBafzrgmsfhm(), qyjbxx.getBafzrgmsfhm());
		assertEquals(qyjbxxNew.getBafzrxm(), qyjbxx.getBafzrxm());
		assertEquals(qyjbxxNew.getBafzrdh(), qyjbxx.getBafzrdh());
		assertEquals(qyjbxxNew.getBars(), qyjbxx.getBars());
		assertEquals(qyjbxxNew.getJgpxrs(), qyjbxx.getJgpxrs());
		assertEquals(qyjbxxNew.getBagsyj(), qyjbxx.getBagsyj());
		assertEquals(qyjbxxNew.getCksl(), qyjbxx.getCksl());
		assertEquals(qyjbxxNew.getBxbjsl(), qyjbxx.getBxbjsl());
		assertEquals(qyjbxxNew.getBz(), qyjbxx.getBz());
		assertEquals(qyjbxxNew.getDcbs(), qyjbxx.getDcbs());
		assertEquals(qyjbxxNew.getDcsj(), qyjbxx.getDcsj());
		assertEquals(qyjbxxNew.getZt(), qyjbxx.getZt());
		assertEquals(qyjbxxNew.getZtgbrq(), qyjbxx.getZtgbrq());
		assertEquals(qyjbxxNew.getScbz(), qyjbxx.getScbz());
		assertEquals(qyjbxxNew.getJqbm(), qyjbxx.getJqbm());
		assertEquals(qyjbxxNew.getZxbz(), qyjbxx.getZxbz());
		assertEquals(qyjbxxNew.getZxyy(), qyjbxx.getZxyy());
		assertEquals(qyjbxxNew.getZdskb(), qyjbxx.getZdskb());
		assertEquals(qyjbxxNew.getBcsj(), qyjbxx.getBcsj());
		assertEquals(qyjbxxNew.getLrsj(), qyjbxx.getLrsj());
		assertEquals(qyjbxxNew.getLrr(), qyjbxx.getLrr());
		assertEquals(qyjbxxNew.getLrdwbm(), qyjbxx.getLrdwbm());
		assertEquals(qyjbxxNew.getLrdwmc(), qyjbxx.getLrdwmc());

		//删除对象
		// @ 企业ID(qyid) 
		qyjbxx.setQyid(1)

		qyjbxxService.deleteQyjbxx(qyjbxx);

		//修改对象
		// @ 企业ID(qyid) 
		qyjbxx.setQyid(1)

		qyjbxxService.updateQyjbxx(qyjbxx);

		//查询单条
		// @ 企业ID(qyid) 
		qyjbxx.setQyid(1)

		qyjbxxService.getQyjbxx(qyjbxx);

		//查询多条
		// @ 企业ID(qyid) 
		qyjbxx.setQyid(1)

		qyjbxxService.getListQyjbxx(qyjbxx);

		//翻页查询
		// @ 企业ID(qyid) 
		qyjbxx.setQyid(1)

		qyjbxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//qyjbxxService.insertQyjbxx(qyjbxx);
	try {
		/*qyjbxx.setCzr("测试者");
		qyjbxxService.updateQyjbxx(qyjbxx);*/
		/*qyjbxx.setBcsj(new Date());
		qyjbxx.setZtgbrq(new Date());
		qyjbxxService.updateQyjbxxOnly(qyjbxx);*/
		/*qyjbxx.setHcr("单元测试mds");
		qyjbxx.setHcdw("新乡市公安局红旗分局");
		qyjbxxService.updateQyjbxxHc(qyjbxx);*/
		/*qyjbxx.setCzr("单元测试变更");
		qyjbxx.setBgyy("测试变更");
		qyjbxx.setBglb("测试变更");
		qyjbxx.setBglbdm("1");
		qyjbxxService.updateQyjbxxBg(qyjbxx);*/
		/*Qyffl qyffl1 = new Qyffl();
		qyffl1.setQyid(4);
		List qyfflList = new ArrayList();
		qyfflList = qyfflService.getListQyffl(qyffl1);
		System.out.println("==="+qyjbxxService.getQyfflStr(qyfflList, "1")+"===");*/
		
		/*qyjbxx.setCzr("单元测试注销");
		qyjbxxService.updateQyjbxxZx(qyjbxx);*/
		/*String csfflbm = "";
		System.out.println(csfflbm.split("\\|").length);*/
		Map map = new HashMap();
		map.put("qybm", "J01");
		map.put("hylbdm", "J");
		map.put("djrqt", new Date());
		qyjbxxService.getListForPage(map, 1, 15, "0", "desc");
		/*map.put("sfhc", "0");
		map.put("zxbz", "0");
		map.put("hylbdm", "E01");
		qyjbxxService.getListForPageHc(map, 1, 15, "0", "desc");*/
		/*map.put("sfhc", "1");
		map.put("zxbz", "0");
		qyjbxxService.getListForPageQybg(map, 1, 15, "0", "desc");*/
		/*map.put("sfyx", "1");
		qyjbxxService.getListForPageQycx(map, 1, 15, "0", "desc");*/
		/*map.put("qyid", 4);
		qyjbxxService.getListForPageQybgxq(map, 1, 15, "4", "desc");*/
		/*Qyjbxx qyjbxx1 = new Qyjbxx();
		//qyjbxx1.setQyid(6);
		qyjbxx1.setZjbh("00003");
		System.out.println("=="+qyjbxxService.isQyjbxxExist(qyjbxx1));*/
		/*QyjbxxModel qyjbxxModel = new QyjbxxModel();
		BeanUtils.copyProperties(qyjbxxModel, qyjbxx);
		System.out.println("====="+qyjbxxModel.toString());
		
		qyjbxx = new Qyjbxx();
		qyjbxx.setQyid(59);
		qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);
		QyjbxxModel qyjbxxModel1 = new QyjbxxModel();
		BeanUtils.copyProperties(qyjbxxModel1, qyjbxx);
		System.out.println("====="+qyjbxxModel1.toString());
		
		System.out.println("====="+qyjbxxModel1.toString().equals(qyjbxxModel.toString()));*/
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}


	public void setQyfflService(IQyfflService qyfflService) {
		this.qyfflService = qyfflService;
	}
}
