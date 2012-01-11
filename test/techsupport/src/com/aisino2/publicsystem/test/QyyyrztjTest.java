package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyyyrztj;
import com.aisino2.publicsystem.service.IQyyyrztjService;

public class QyyyrztjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyyyrztjService qyyyrztjService;

	/** @param 企业营业日志统计(t_qyyyrztj) */

	public void test() {
		Qyyyrztj qyyyrztj = new Qyyyrztj();

	/** @ 企业ID(qyid) */
	qyyyrztj.setQyid(0);

	/** @ 营业日志ID(yyrzid) */
	qyyyrztj.setYyrzid(0);

	/** @ 营业日志统计ID(yyrztjid) */
	qyyyrztj.setYyrztjid(0);

	/** @ 日期(riqi) */
	qyyyrztj.setRiqi(new Date());

	/** @ 开始营业时间(ksyysj) */
	qyyyrztj.setKsyysj(new Date());

	/** @ 结束营业时间(jsyysj) */
	qyyyrztj.setJsyysj(new Date());

	/** @ 场所负责人编号(csfzrbh) */
	qyyyrztj.setCsfzrbh("test");

	/** @ 场所负责人姓名(csfe) */
	qyyyrztj.setCsfe("test");

	/** @ 治安负责人编号(zafzrbh) */
	qyyyrztj.setZafzrbh("test");

	/** @ 治安负责人姓名(zafzrxm) */
	qyyyrztj.setZafzrxm("test");

	/** @ 是否有治安、刑事案件或事故发生(sffsaj) */
	qyyyrztj.setSffsaj("te");

	/** @ 是否有管理部门检查(sfglbmjc) */
	qyyyrztj.setSfglbmjc("te");

	/** @ 当日营业状况(dryysj) */
	qyyyrztj.setDryysj("test");

	/** @ 行业类别代码(hylbdm) */
	qyyyrztj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyyyrztj.setHylb("test");

	/** @ 企业编码(qybm) */
	qyyyrztj.setQybm("test");

	/** @ 企业名称(qymc) */
	qyyyrztj.setQymc("test");

	/** @ 企业全拼(qyqp) */
	qyyyrztj.setQyqp("test");

	/** @ 企业简拼(qyjp) */
	qyyyrztj.setQyjp("test");

	/** @ 企业主分类编码(qyzflbm) */
	qyyyrztj.setQyzflbm("test");

	/** @ 企业主分类名称(qyzflmc) */
	qyyyrztj.setQyzflmc("test");

	/** @ 企业副分类编码(qyfflbm) */
	qyyyrztj.setQyfflbm("test");

	/** @ 企业副分类名称(qyfflmc) */
	qyyyrztj.setQyfflmc("test");

	/** @ 管辖单位代码(gxdwbm) */
	qyyyrztj.setGxdwbm("test");

	/** @ 管辖单位名称(gxdwmc) */
	qyyyrztj.setGxdwmc("test");

	/** @ 所属地县级公安机关机构代码(ssdxjgajgdm) */
	qyyyrztj.setSsdxjgajgdm("test");

	/** @ 所属地县级公安机关名称(ssdxjgajgmc) */
	qyyyrztj.setSsdxjgajgmc("test");

	/** @ 所属地地市机构代码(ssddsjgdm) */
	qyyyrztj.setSsddsjgdm("test");

	/** @ 所属地地市机构名称(ssddsjgmc) */
	qyyyrztj.setSsddsjgmc("test");

	/** @ 企业组织机构代码(qyzzjgdm) */
	qyyyrztj.setQyzzjgdm("test");

	/** @ 联系电话(lxdh) */
	qyyyrztj.setLxdh("test");

	/** @ 邮政编码(yzbm) */
	qyyyrztj.setYzbm("test");

	/** @ 传真(chzh) */
	qyyyrztj.setChzh("test");

	/** @ 经纬度坐标(jwdzb) */
	qyyyrztj.setJwdzb("test");

	/** @ 经济类型编码(jjlxbm) */
	qyyyrztj.setJjlxbm("test");

	/** @ 经济类型名称(jjlxmc) */
	qyyyrztj.setJjlxmc("test");

	/** @ 经营范围（主营）(jyfwzy) */
	qyyyrztj.setJyfwzy("test");

	/** @ 经营范围（兼营）(jyfwjy) */
	qyyyrztj.setJyfwjy("test");

	/** @ 注册资金(zczj) */
	qyyyrztj.setZczj(new Float(9.9));

	/** @ 经营面积(jymj) */
	qyyyrztj.setJymj(new Float(9.9));

	/** @ 治安级别代码(zabdm) */
	qyyyrztj.setZabdm("test");

	/** @ 治安级别名称(zajbmc) */
	qyyyrztj.setZajbmc("test");

	/** @ 营业状态代码(yyztdm) */
	qyyyrztj.setYyztdm("test");

	/** @ 营业状态名称(yyztmc) */
	qyyyrztj.setYyztmc("test");

	/** @ 法人代表姓名(frdb) */
	qyyyrztj.setFrdb("test");

	/** @ 法人代表证件类别(frdbzjlb) */
	qyyyrztj.setFrdbzjlb("test");

	/** @ 法人代表证件号码(frdbzjhm) */
	qyyyrztj.setFrdbzjhm("test");

	/** @ 法人代表联系方式(frdblxfs) */
	qyyyrztj.setFrdblxfs("test");

	/** @ 开业日期(kyrq) */
	qyyyrztj.setKyrq(new Date());

	/** @ 营业时间(yysj) */
	qyyyrztj.setYysj("test");

	/** @ 备案编号(babh) */
	qyyyrztj.setBabh("test");

	/** @ 备案日期(barq) */
	qyyyrztj.setBarq(new Date());

	/** @ 停业日期(tyrq) */
	qyyyrztj.setTyrq(new Date());

	/** @ 经营方式(jyfs) */
	qyyyrztj.setJyfs("test");

	/** @ 经营地址(jydz) */
	qyyyrztj.setJydz("test");

	/** @ 单位负责人证件类别(dwfzrzjlb) */
	qyyyrztj.setDwfzrzjlb("test");

	/** @ 单位负责人证件号码(dwfzrzjhm) */
	qyyyrztj.setDwfzrzjhm("test");

	/** @ 单位负责人姓名(dwfzr) */
	qyyyrztj.setDwfzr("test");

	/** @ 单位负责人联系方式(dwfzrlxfs) */
	qyyyrztj.setDwfzrlxfs("test");

	/** @ 消防审核单位(xfshdw) */
	qyyyrztj.setXfshdw("test");

	/** @ 消防合格证号(xfhgzh) */
	qyyyrztj.setXfhgzh("test");

	/** @ 核查单位(hcdw) */
	qyyyrztj.setHcdw("test");

	/** @ 核查人(hcr) */
	qyyyrztj.setHcr("test");

	/** @ 核查时间(hcsj) */
	qyyyrztj.setHcsj(new Date());

	/** @ 股东信息(gdxx) */
	qyyyrztj.setGdxx("test");

	/** @ 总人数(zrs) */
	qyyyrztj.setZrs(0);

	/** @ 核定人数(hdrs) */
	qyyyrztj.setHdrs(0);

	/** @ 保安公司名称(bagsmc) */
	qyyyrztj.setBagsmc("test");

	/** @ 保安负责人公民身份号码(bafzrgmsfhm) */
	qyyyrztj.setBafzrgmsfhm("test");

	/** @ 保安负责人姓名(bafzrxm) */
	qyyyrztj.setBafzrxm("test");

	/** @ 保安负责人电话(bafzrdh) */
	qyyyrztj.setBafzrdh("test");

	/** @ 保安人数(bars) */
	qyyyrztj.setBars(0);

	/** @ 经岗位培训人数(jgpxrs) */
	qyyyrztj.setJgpxrs(0);

	/** @ 保安公司意见(bagsyj) */
	qyyyrztj.setBagsyj("test");

	/** @ 出口数量(cksl) */
	qyyyrztj.setCksl(0);

	/** @ 包厢包间数量(bxbjsl) */
	qyyyrztj.setBxbjsl(0);

	/** @ 备注(bz) */
	qyyyrztj.setBz("test");

	/** @ 导出标识(dcbs) */
	qyyyrztj.setDcbs(0);

	/** @ 导出时间(dcsj) */
	qyyyrztj.setDcsj(new Date());

	/** @ 状态(zt) */
	qyyyrztj.setZt("test");

	/** @ 状态改变日期(ztgbrq) */
	qyyyrztj.setZtgbrq(new Date());

	/** @ 删除标志(scbz) */
	qyyyrztj.setScbz(0);

	/** @ 机器编码(jqbm) */
	qyyyrztj.setJqbm("test");

	/** @ 注销标志(zxbz) */
	qyyyrztj.setZxbz("test");

	/** @ 注销原因(zxyy) */
	qyyyrztj.setZxyy("test");

	/** @ 最低刷卡比(zdskb) */
	qyyyrztj.setZdskb(new Float(9.9));

	/** @ 保存时间(bcsj) */
	qyyyrztj.setBcsj(new Date());

	/** @ 录入时间(lrsj) */
	qyyyrztj.setLrsj(new Date());

	/** @ 录入人(lrr) */
	qyyyrztj.setLrr("test");

	/** @ 录入单位编码(lrdwbm) */
	qyyyrztj.setLrdwbm("test");

	/** @ 录入单位名称(lrdwmc) */
	qyyyrztj.setLrdwmc("test");

		/*
		//插入对象
		qyyyrztjService.insertQyyyrztj(qyyyrztj);

		//读取对象比较
		BaseObject bo = qyyyrztjService.getQyyyrztj(qyyyrztj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyyyrztj qyyyrztjNew = (Qyyyrztj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyyyrztjNew.getQyid(), qyyyrztj.getQyid());
		assertEquals(qyyyrztjNew.getYyrzid(), qyyyrztj.getYyrzid());
		assertEquals(qyyyrztjNew.getYyrztjid(), qyyyrztj.getYyrztjid());
		assertEquals(qyyyrztjNew.getRiqi(), qyyyrztj.getRiqi());
		assertEquals(qyyyrztjNew.getKsyysj(), qyyyrztj.getKsyysj());
		assertEquals(qyyyrztjNew.getJsyysj(), qyyyrztj.getJsyysj());
		assertEquals(qyyyrztjNew.getCsfzrbh(), qyyyrztj.getCsfzrbh());
		assertEquals(qyyyrztjNew.getCsfe(), qyyyrztj.getCsfe());
		assertEquals(qyyyrztjNew.getZafzrbh(), qyyyrztj.getZafzrbh());
		assertEquals(qyyyrztjNew.getZafzrxm(), qyyyrztj.getZafzrxm());
		assertEquals(qyyyrztjNew.getSffsaj(), qyyyrztj.getSffsaj());
		assertEquals(qyyyrztjNew.getSfglbmjc(), qyyyrztj.getSfglbmjc());
		assertEquals(qyyyrztjNew.getDryysj(), qyyyrztj.getDryysj());
		assertEquals(qyyyrztjNew.getHylbdm(), qyyyrztj.getHylbdm());
		assertEquals(qyyyrztjNew.getHylb(), qyyyrztj.getHylb());
		assertEquals(qyyyrztjNew.getQybm(), qyyyrztj.getQybm());
		assertEquals(qyyyrztjNew.getQymc(), qyyyrztj.getQymc());
		assertEquals(qyyyrztjNew.getQyqp(), qyyyrztj.getQyqp());
		assertEquals(qyyyrztjNew.getQyjp(), qyyyrztj.getQyjp());
		assertEquals(qyyyrztjNew.getQyzflbm(), qyyyrztj.getQyzflbm());
		assertEquals(qyyyrztjNew.getQyzflmc(), qyyyrztj.getQyzflmc());
		assertEquals(qyyyrztjNew.getQyfflbm(), qyyyrztj.getQyfflbm());
		assertEquals(qyyyrztjNew.getQyfflmc(), qyyyrztj.getQyfflmc());
		assertEquals(qyyyrztjNew.getGxdwbm(), qyyyrztj.getGxdwbm());
		assertEquals(qyyyrztjNew.getGxdwmc(), qyyyrztj.getGxdwmc());
		assertEquals(qyyyrztjNew.getSsdxjgajgdm(), qyyyrztj.getSsdxjgajgdm());
		assertEquals(qyyyrztjNew.getSsdxjgajgmc(), qyyyrztj.getSsdxjgajgmc());
		assertEquals(qyyyrztjNew.getSsddsjgdm(), qyyyrztj.getSsddsjgdm());
		assertEquals(qyyyrztjNew.getSsddsjgmc(), qyyyrztj.getSsddsjgmc());
		assertEquals(qyyyrztjNew.getQyzzjgdm(), qyyyrztj.getQyzzjgdm());
		assertEquals(qyyyrztjNew.getLxdh(), qyyyrztj.getLxdh());
		assertEquals(qyyyrztjNew.getYzbm(), qyyyrztj.getYzbm());
		assertEquals(qyyyrztjNew.getChzh(), qyyyrztj.getChzh());
		assertEquals(qyyyrztjNew.getJwdzb(), qyyyrztj.getJwdzb());
		assertEquals(qyyyrztjNew.getJjlxbm(), qyyyrztj.getJjlxbm());
		assertEquals(qyyyrztjNew.getJjlxmc(), qyyyrztj.getJjlxmc());
		assertEquals(qyyyrztjNew.getJyfwzy(), qyyyrztj.getJyfwzy());
		assertEquals(qyyyrztjNew.getJyfwjy(), qyyyrztj.getJyfwjy());
		assertEquals(qyyyrztjNew.getZczj(), qyyyrztj.getZczj());
		assertEquals(qyyyrztjNew.getJymj(), qyyyrztj.getJymj());
		assertEquals(qyyyrztjNew.getZabdm(), qyyyrztj.getZabdm());
		assertEquals(qyyyrztjNew.getZajbmc(), qyyyrztj.getZajbmc());
		assertEquals(qyyyrztjNew.getYyztdm(), qyyyrztj.getYyztdm());
		assertEquals(qyyyrztjNew.getYyztmc(), qyyyrztj.getYyztmc());
		assertEquals(qyyyrztjNew.getFrdb(), qyyyrztj.getFrdb());
		assertEquals(qyyyrztjNew.getFrdbzjlb(), qyyyrztj.getFrdbzjlb());
		assertEquals(qyyyrztjNew.getFrdbzjhm(), qyyyrztj.getFrdbzjhm());
		assertEquals(qyyyrztjNew.getFrdblxfs(), qyyyrztj.getFrdblxfs());
		assertEquals(qyyyrztjNew.getKyrq(), qyyyrztj.getKyrq());
		assertEquals(qyyyrztjNew.getYysj(), qyyyrztj.getYysj());
		assertEquals(qyyyrztjNew.getBabh(), qyyyrztj.getBabh());
		assertEquals(qyyyrztjNew.getBarq(), qyyyrztj.getBarq());
		assertEquals(qyyyrztjNew.getTyrq(), qyyyrztj.getTyrq());
		assertEquals(qyyyrztjNew.getJyfs(), qyyyrztj.getJyfs());
		assertEquals(qyyyrztjNew.getJydz(), qyyyrztj.getJydz());
		assertEquals(qyyyrztjNew.getDwfzrzjlb(), qyyyrztj.getDwfzrzjlb());
		assertEquals(qyyyrztjNew.getDwfzrzjhm(), qyyyrztj.getDwfzrzjhm());
		assertEquals(qyyyrztjNew.getDwfzr(), qyyyrztj.getDwfzr());
		assertEquals(qyyyrztjNew.getDwfzrlxfs(), qyyyrztj.getDwfzrlxfs());
		assertEquals(qyyyrztjNew.getXfshdw(), qyyyrztj.getXfshdw());
		assertEquals(qyyyrztjNew.getXfhgzh(), qyyyrztj.getXfhgzh());
		assertEquals(qyyyrztjNew.getHcdw(), qyyyrztj.getHcdw());
		assertEquals(qyyyrztjNew.getHcr(), qyyyrztj.getHcr());
		assertEquals(qyyyrztjNew.getHcsj(), qyyyrztj.getHcsj());
		assertEquals(qyyyrztjNew.getGdxx(), qyyyrztj.getGdxx());
		assertEquals(qyyyrztjNew.getZrs(), qyyyrztj.getZrs());
		assertEquals(qyyyrztjNew.getHdrs(), qyyyrztj.getHdrs());
		assertEquals(qyyyrztjNew.getBagsmc(), qyyyrztj.getBagsmc());
		assertEquals(qyyyrztjNew.getBafzrgmsfhm(), qyyyrztj.getBafzrgmsfhm());
		assertEquals(qyyyrztjNew.getBafzrxm(), qyyyrztj.getBafzrxm());
		assertEquals(qyyyrztjNew.getBafzrdh(), qyyyrztj.getBafzrdh());
		assertEquals(qyyyrztjNew.getBars(), qyyyrztj.getBars());
		assertEquals(qyyyrztjNew.getJgpxrs(), qyyyrztj.getJgpxrs());
		assertEquals(qyyyrztjNew.getBagsyj(), qyyyrztj.getBagsyj());
		assertEquals(qyyyrztjNew.getCksl(), qyyyrztj.getCksl());
		assertEquals(qyyyrztjNew.getBxbjsl(), qyyyrztj.getBxbjsl());
		assertEquals(qyyyrztjNew.getBz(), qyyyrztj.getBz());
		assertEquals(qyyyrztjNew.getDcbs(), qyyyrztj.getDcbs());
		assertEquals(qyyyrztjNew.getDcsj(), qyyyrztj.getDcsj());
		assertEquals(qyyyrztjNew.getZt(), qyyyrztj.getZt());
		assertEquals(qyyyrztjNew.getZtgbrq(), qyyyrztj.getZtgbrq());
		assertEquals(qyyyrztjNew.getScbz(), qyyyrztj.getScbz());
		assertEquals(qyyyrztjNew.getJqbm(), qyyyrztj.getJqbm());
		assertEquals(qyyyrztjNew.getZxbz(), qyyyrztj.getZxbz());
		assertEquals(qyyyrztjNew.getZxyy(), qyyyrztj.getZxyy());
		assertEquals(qyyyrztjNew.getZdskb(), qyyyrztj.getZdskb());
		assertEquals(qyyyrztjNew.getBcsj(), qyyyrztj.getBcsj());
		assertEquals(qyyyrztjNew.getLrsj(), qyyyrztj.getLrsj());
		assertEquals(qyyyrztjNew.getLrr(), qyyyrztj.getLrr());
		assertEquals(qyyyrztjNew.getLrdwbm(), qyyyrztj.getLrdwbm());
		assertEquals(qyyyrztjNew.getLrdwmc(), qyyyrztj.getLrdwmc());

		//删除对象
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志统计ID(yyrztjid) 
		qyyyrztj.setYyrztjid(1)

		qyyyrztjService.deleteQyyyrztj(qyyyrztj);

		//修改对象
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志统计ID(yyrztjid) 
		qyyyrztj.setYyrztjid(1)

		qyyyrztjService.updateQyyyrztj(qyyyrztj);

		//查询单条
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志统计ID(yyrztjid) 
		qyyyrztj.setYyrztjid(1)

		qyyyrztjService.getQyyyrztj(qyyyrztj);

		//查询多条
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志统计ID(yyrztjid) 
		qyyyrztj.setYyrztjid(1)

		qyyyrztjService.getListQyyyrztj(qyyyrztj);

		//翻页查询
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 企业ID(qyid) 
		qyyyrztj.setQyid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志ID(yyrzid) 
		qyyyrztj.setYyrzid(1)
		// @ 营业日志统计ID(yyrztjid) 
		qyyyrztj.setYyrztjid(1)

		qyyyrztjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyyyrztjService.insertQyyyrztj(qyyyrztj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyyyrztjService(IQyyyrztjService qyyyrztjService) {
		this.qyyyrztjService = qyyyrztjService;
	}
}
