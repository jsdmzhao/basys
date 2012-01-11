package com.aisino2.publicsystem.test;

import java.util.Date;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.publicsystem.domain.Qyjbxx_ls;
import com.aisino2.publicsystem.service.IQyjbxx_lsService;

public class Qyjbxx_lsTest extends AbstractTransactionalDataSourceSpringContextTests {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyjbxx_lsService qyjbxx_lsService;
	
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/publicsystem-service.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		return paths;
	}


	/** @param 企业基本信息—历史(t_qyjbxx_ls) */

	public void test() {
		Qyjbxx_ls qyjbxx_ls = new Qyjbxx_ls();

	/** @ 企业ID(qyid) */
	qyjbxx_ls.setQyid(0);

	/** @ 企业历史ID(qylsid) */
	qyjbxx_ls.setQylsid(0);

	/** @ 行业类别代码(hylbdm) */
	qyjbxx_ls.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyjbxx_ls.setHylb("test");

	/** @ 企业编码(qybm) */
	qyjbxx_ls.setQybm("test");

	/** @ 企业名称(qymc) */
	qyjbxx_ls.setQymc("test");

	/** @ 企业全拼(qyqp) */
	qyjbxx_ls.setQyqp("test");

	/** @ 企业简拼(qyjp) */
	qyjbxx_ls.setQyjp("test");

	/** @ 企业主分类编码(qyzflbm) */
	qyjbxx_ls.setQyzflbm("test");

	/** @ 企业主分类名称(qyzflmc) */
	qyjbxx_ls.setQyzflmc("test");

	/** @ 企业副分类编码(qyfflbm) */
	qyjbxx_ls.setQyfflbm("test");

	/** @ 企业副分类名称(qyfflmc) */
	qyjbxx_ls.setQyfflmc("test");

	/** @ 管辖单位代码(gxdwbm) */
	qyjbxx_ls.setGxdwbm("test");

	/** @ 管辖单位名称(gxdwmc) */
	qyjbxx_ls.setGxdwmc("test");

	/** @ 所属地县级公安机关机构代码(ssdxjgajgdm) */
	qyjbxx_ls.setSsdxjgajgdm("test");

	/** @ 所属地县级公安机关名称(ssdxjgajgmc) */
	qyjbxx_ls.setSsdxjgajgmc("test");

	/** @ 所属地派出所机构代码(ssdpcsjgdm) */
	qyjbxx_ls.setSsddsjgdm("test");

	/** @ 所属地派出所机构名称(ssdpcsjgmc) */
	qyjbxx_ls.setSsddsjgmc("test");

	/** @ 企业组织机构代码(qyzzjgdm) */
	qyjbxx_ls.setQyzzjgdm("test");

	/** @ 联系电话(lxdh) */
	qyjbxx_ls.setLxdh("test");

	/** @ 邮政编码(yzbm) */
	qyjbxx_ls.setYzbm("test");

	/** @ 传真(chzh) */
	qyjbxx_ls.setChzh("test");

	/** @ 经纬度坐标(jwdzb) */
	qyjbxx_ls.setJwdzb("test");

	/** @ 经济类型编码(jjlxbm) */
	qyjbxx_ls.setJjlxbm("test");

	/** @ 经济类型名称(jjlxmc) */
	qyjbxx_ls.setJjlxmc("test");

	/** @ 经营范围（主营）(jyfwzy) */
	qyjbxx_ls.setJyfwzy("test");

	/** @ 经营范围（兼营）(jyfwjy) */
	qyjbxx_ls.setJyfwjy("test");

	/** @ 注册资金(zczj) */
	qyjbxx_ls.setZczj(new Float(9.9));

	/** @ 经营面积(jymj) */
	qyjbxx_ls.setJymj(new Float(9.9));

	/** @ 治安级别代码(zabdm) */
	qyjbxx_ls.setZabdm("test");

	/** @ 治安级别名称(zajbmc) */
	qyjbxx_ls.setZajbmc("test");

	/** @ 营业状态代码(yyztdm) */
	qyjbxx_ls.setYyztdm("test");

	/** @ 营业状态名称(yyztmc) */
	qyjbxx_ls.setYyztmc("test");

	/** @ 法人代表姓名(frdb) */
	qyjbxx_ls.setFrdb("test");

	/** @ 法人代表证件类别(frdbzjlb) */
	qyjbxx_ls.setFrdbzjlb("test");

	/** @ 法人代表证件号码(frdbzjhm) */
	qyjbxx_ls.setFrdbzjhm("test");

	/** @ 法人代表联系方式(frdblxfs) */
	qyjbxx_ls.setFrdblxfs("test");

	/** @ 开业日期(kyrq) */
	qyjbxx_ls.setKyrq(new Date());

	/** @ 营业时间(yysj) */
	qyjbxx_ls.setYysj("test");

	/** @ 备案编号(babh) */
	qyjbxx_ls.setBabh("test");

	/** @ 备案日期(barq) */
	qyjbxx_ls.setBarq(new Date());

	/** @ 停业日期(tyrq) */
	qyjbxx_ls.setTyrq(new Date());

	/** @ 经营方式(jyfs) */
	qyjbxx_ls.setJyfs("test");

	/** @ 经营地址(jydz) */
	qyjbxx_ls.setJydz("test");

	/** @ 单位负责人证件类别(dwfzrzjlb) */
	qyjbxx_ls.setDwfzrzjlb("test");

	/** @ 单位负责人证件号码(dwfzrzjhm) */
	qyjbxx_ls.setDwfzrzjhm("test");

	/** @ 单位负责人姓名(dwfzr) */
	qyjbxx_ls.setDwfzr("test");

	/** @ 单位负责人联系方式(dwfzrlxfs) */
	qyjbxx_ls.setDwfzrlxfs("test");

	/** @ 消防审核单位(xfshdw) */
	qyjbxx_ls.setXfshdw("test");

	/** @ 消防合格证号(xfhgzh) */
	qyjbxx_ls.setXfhgzh("test");

	/** @ 核查单位(hcdw) */
	qyjbxx_ls.setHcdw("test");

	/** @ 核查人(hcr) */
	qyjbxx_ls.setHcr("test");

	/** @ 核查时间(hcsj) */
	qyjbxx_ls.setHcsj(new Date());

	/** @ 股东信息(gdxx) */
	qyjbxx_ls.setGdxx("test");

	/** @ 总人数(zrs) */
	qyjbxx_ls.setZrs(0);

	/** @ 核定人数(hdrs) */
	qyjbxx_ls.setHdrs(0);

	/** @ 保安公司名称(bagsmc) */
	qyjbxx_ls.setBagsmc("test");

	/** @ 保安负责人公民身份号码(bafzrgmsfhm) */
	qyjbxx_ls.setBafzrgmsfhm("test");

	/** @ 保安负责人姓名(bafzrxm) */
	qyjbxx_ls.setBafzrxm("test");

	/** @ 保安负责人电话(bafzrdh) */
	qyjbxx_ls.setBafzrdh("test");

	/** @ 保安人数(bars) */
	qyjbxx_ls.setBars(0);

	/** @ 经岗位培训人数(jgpxrs) */
	qyjbxx_ls.setJgpxrs(0);

	/** @ 保安公司意见(bagsyj) */
	qyjbxx_ls.setBagsyj("test");

	/** @ 出口数量(cksl) */
	qyjbxx_ls.setCksl(0);

	/** @ 包厢包间数量(bxbjsl) */
	qyjbxx_ls.setBxbjsl(0);

	/** @ 备注(bz) */
	qyjbxx_ls.setBz("test");

	/** @ 导出标识(dcbs) */
	qyjbxx_ls.setDcbs(0);

	/** @ 导出时间(dcsj) */
	qyjbxx_ls.setDcsj(new Date());

	/** @ 状态(zt) */
	qyjbxx_ls.setZt("test");

	/** @ 状态改变日期(ztgbrq) */
	qyjbxx_ls.setZtgbrq(new Date());

	/** @ 删除标志(scbz) */
	qyjbxx_ls.setScbz(0);

	/** @ 机器编码(jqbm) */
	qyjbxx_ls.setJqbm("test");

	/** @ 注销标志(zxbz) */
	qyjbxx_ls.setZxbz("test");

	/** @ 注销原因(zxyy) */
	qyjbxx_ls.setZxyy("test");

	/** @ 最低刷卡比(zdskb) */
	qyjbxx_ls.setZdskb(new Float(9.9));

	/** @ 保存时间(bcsj) */
	qyjbxx_ls.setBcsj(new Date());

	/** @ 录入时间(lrsj) */
	qyjbxx_ls.setLrsj(new Date());

	/** @ 录入人(lrr) */
	qyjbxx_ls.setLrr("test");

	/** @ 录入单位编码(lrdwbm) */
	qyjbxx_ls.setLrdwbm("test");

	/** @ 录入单位名称(lrdwmc) */
	qyjbxx_ls.setLrdwmc("test");

	/** @ 操作类型(czlx) */
	qyjbxx_ls.setCzlx("test");

	/** @ 变更原因(bgyy) */
	qyjbxx_ls.setBgyy("test");

	/** @ 变更类别代码(bglbdm) */
	qyjbxx_ls.setBglbdm("test");

	/** @ 变更类别(bglb) */
	qyjbxx_ls.setBglb("test");

		/*
		//插入对象
		qyjbxx_lsService.insertQyjbxx_ls(qyjbxx_ls);

		//读取对象比较
		BaseObject bo = qyjbxx_lsService.getQyjbxx_ls(qyjbxx_ls);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyjbxx_ls qyjbxx_lsNew = (Qyjbxx_ls)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyjbxx_lsNew.getQyid(), qyjbxx_ls.getQyid());
		assertEquals(qyjbxx_lsNew.getQylsid(), qyjbxx_ls.getQylsid());
		assertEquals(qyjbxx_lsNew.getHylbdm(), qyjbxx_ls.getHylbdm());
		assertEquals(qyjbxx_lsNew.getHylb(), qyjbxx_ls.getHylb());
		assertEquals(qyjbxx_lsNew.getQybm(), qyjbxx_ls.getQybm());
		assertEquals(qyjbxx_lsNew.getQymc(), qyjbxx_ls.getQymc());
		assertEquals(qyjbxx_lsNew.getQyqp(), qyjbxx_ls.getQyqp());
		assertEquals(qyjbxx_lsNew.getQyjp(), qyjbxx_ls.getQyjp());
		assertEquals(qyjbxx_lsNew.getQyzflbm(), qyjbxx_ls.getQyzflbm());
		assertEquals(qyjbxx_lsNew.getQyzflmc(), qyjbxx_ls.getQyzflmc());
		assertEquals(qyjbxx_lsNew.getQyfflbm(), qyjbxx_ls.getQyfflbm());
		assertEquals(qyjbxx_lsNew.getQyfflmc(), qyjbxx_ls.getQyfflmc());
		assertEquals(qyjbxx_lsNew.getGxdwbm(), qyjbxx_ls.getGxdwbm());
		assertEquals(qyjbxx_lsNew.getGxdwmc(), qyjbxx_ls.getGxdwmc());
		assertEquals(qyjbxx_lsNew.getSsdxjgajgdm(), qyjbxx_ls.getSsdxjgajgdm());
		assertEquals(qyjbxx_lsNew.getSsdxjgajgmc(), qyjbxx_ls.getSsdxjgajgmc());
		assertEquals(qyjbxx_lsNew.getSsdpcsjgdm(), qyjbxx_ls.getSsdpcsjgdm());
		assertEquals(qyjbxx_lsNew.getSsdpcsjgmc(), qyjbxx_ls.getSsdpcsjgmc());
		assertEquals(qyjbxx_lsNew.getQyzzjgdm(), qyjbxx_ls.getQyzzjgdm());
		assertEquals(qyjbxx_lsNew.getLxdh(), qyjbxx_ls.getLxdh());
		assertEquals(qyjbxx_lsNew.getYzbm(), qyjbxx_ls.getYzbm());
		assertEquals(qyjbxx_lsNew.getChzh(), qyjbxx_ls.getChzh());
		assertEquals(qyjbxx_lsNew.getJwdzb(), qyjbxx_ls.getJwdzb());
		assertEquals(qyjbxx_lsNew.getJjlxbm(), qyjbxx_ls.getJjlxbm());
		assertEquals(qyjbxx_lsNew.getJjlxmc(), qyjbxx_ls.getJjlxmc());
		assertEquals(qyjbxx_lsNew.getJyfwzy(), qyjbxx_ls.getJyfwzy());
		assertEquals(qyjbxx_lsNew.getJyfwjy(), qyjbxx_ls.getJyfwjy());
		assertEquals(qyjbxx_lsNew.getZczj(), qyjbxx_ls.getZczj());
		assertEquals(qyjbxx_lsNew.getJymj(), qyjbxx_ls.getJymj());
		assertEquals(qyjbxx_lsNew.getZabdm(), qyjbxx_ls.getZabdm());
		assertEquals(qyjbxx_lsNew.getZajbmc(), qyjbxx_ls.getZajbmc());
		assertEquals(qyjbxx_lsNew.getYyztdm(), qyjbxx_ls.getYyztdm());
		assertEquals(qyjbxx_lsNew.getYyztmc(), qyjbxx_ls.getYyztmc());
		assertEquals(qyjbxx_lsNew.getFrdb(), qyjbxx_ls.getFrdb());
		assertEquals(qyjbxx_lsNew.getFrdbzjlb(), qyjbxx_ls.getFrdbzjlb());
		assertEquals(qyjbxx_lsNew.getFrdbzjhm(), qyjbxx_ls.getFrdbzjhm());
		assertEquals(qyjbxx_lsNew.getFrdblxfs(), qyjbxx_ls.getFrdblxfs());
		assertEquals(qyjbxx_lsNew.getKyrq(), qyjbxx_ls.getKyrq());
		assertEquals(qyjbxx_lsNew.getYysj(), qyjbxx_ls.getYysj());
		assertEquals(qyjbxx_lsNew.getBabh(), qyjbxx_ls.getBabh());
		assertEquals(qyjbxx_lsNew.getBarq(), qyjbxx_ls.getBarq());
		assertEquals(qyjbxx_lsNew.getTyrq(), qyjbxx_ls.getTyrq());
		assertEquals(qyjbxx_lsNew.getJyfs(), qyjbxx_ls.getJyfs());
		assertEquals(qyjbxx_lsNew.getJydz(), qyjbxx_ls.getJydz());
		assertEquals(qyjbxx_lsNew.getDwfzrzjlb(), qyjbxx_ls.getDwfzrzjlb());
		assertEquals(qyjbxx_lsNew.getDwfzrzjhm(), qyjbxx_ls.getDwfzrzjhm());
		assertEquals(qyjbxx_lsNew.getDwfzr(), qyjbxx_ls.getDwfzr());
		assertEquals(qyjbxx_lsNew.getDwfzrlxfs(), qyjbxx_ls.getDwfzrlxfs());
		assertEquals(qyjbxx_lsNew.getXfshdw(), qyjbxx_ls.getXfshdw());
		assertEquals(qyjbxx_lsNew.getXfhgzh(), qyjbxx_ls.getXfhgzh());
		assertEquals(qyjbxx_lsNew.getHcdw(), qyjbxx_ls.getHcdw());
		assertEquals(qyjbxx_lsNew.getHcr(), qyjbxx_ls.getHcr());
		assertEquals(qyjbxx_lsNew.getHcsj(), qyjbxx_ls.getHcsj());
		assertEquals(qyjbxx_lsNew.getGdxx(), qyjbxx_ls.getGdxx());
		assertEquals(qyjbxx_lsNew.getZrs(), qyjbxx_ls.getZrs());
		assertEquals(qyjbxx_lsNew.getHdrs(), qyjbxx_ls.getHdrs());
		assertEquals(qyjbxx_lsNew.getBagsmc(), qyjbxx_ls.getBagsmc());
		assertEquals(qyjbxx_lsNew.getBafzrgmsfhm(), qyjbxx_ls.getBafzrgmsfhm());
		assertEquals(qyjbxx_lsNew.getBafzrxm(), qyjbxx_ls.getBafzrxm());
		assertEquals(qyjbxx_lsNew.getBafzrdh(), qyjbxx_ls.getBafzrdh());
		assertEquals(qyjbxx_lsNew.getBars(), qyjbxx_ls.getBars());
		assertEquals(qyjbxx_lsNew.getJgpxrs(), qyjbxx_ls.getJgpxrs());
		assertEquals(qyjbxx_lsNew.getBagsyj(), qyjbxx_ls.getBagsyj());
		assertEquals(qyjbxx_lsNew.getCksl(), qyjbxx_ls.getCksl());
		assertEquals(qyjbxx_lsNew.getBxbjsl(), qyjbxx_ls.getBxbjsl());
		assertEquals(qyjbxx_lsNew.getBz(), qyjbxx_ls.getBz());
		assertEquals(qyjbxx_lsNew.getDcbs(), qyjbxx_ls.getDcbs());
		assertEquals(qyjbxx_lsNew.getDcsj(), qyjbxx_ls.getDcsj());
		assertEquals(qyjbxx_lsNew.getZt(), qyjbxx_ls.getZt());
		assertEquals(qyjbxx_lsNew.getZtgbrq(), qyjbxx_ls.getZtgbrq());
		assertEquals(qyjbxx_lsNew.getScbz(), qyjbxx_ls.getScbz());
		assertEquals(qyjbxx_lsNew.getJqbm(), qyjbxx_ls.getJqbm());
		assertEquals(qyjbxx_lsNew.getZxbz(), qyjbxx_ls.getZxbz());
		assertEquals(qyjbxx_lsNew.getZxyy(), qyjbxx_ls.getZxyy());
		assertEquals(qyjbxx_lsNew.getZdskb(), qyjbxx_ls.getZdskb());
		assertEquals(qyjbxx_lsNew.getBcsj(), qyjbxx_ls.getBcsj());
		assertEquals(qyjbxx_lsNew.getLrsj(), qyjbxx_ls.getLrsj());
		assertEquals(qyjbxx_lsNew.getLrr(), qyjbxx_ls.getLrr());
		assertEquals(qyjbxx_lsNew.getLrdwbm(), qyjbxx_ls.getLrdwbm());
		assertEquals(qyjbxx_lsNew.getLrdwmc(), qyjbxx_ls.getLrdwmc());
		assertEquals(qyjbxx_lsNew.getCzlx(), qyjbxx_ls.getCzlx());
		assertEquals(qyjbxx_lsNew.getBgyy(), qyjbxx_ls.getBgyy());
		assertEquals(qyjbxx_lsNew.getBglbdm(), qyjbxx_ls.getBglbdm());
		assertEquals(qyjbxx_lsNew.getBglb(), qyjbxx_ls.getBglb());

		//删除对象
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qyjbxx_ls.setQylsid(1)

		qyjbxx_lsService.deleteQyjbxx_ls(qyjbxx_ls);

		//修改对象
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qyjbxx_ls.setQylsid(1)

		qyjbxx_lsService.updateQyjbxx_ls(qyjbxx_ls);

		//查询单条
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qyjbxx_ls.setQylsid(1)

		qyjbxx_lsService.getQyjbxx_ls(qyjbxx_ls);

		//查询多条
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qyjbxx_ls.setQylsid(1)

		qyjbxx_lsService.getListQyjbxx_ls(qyjbxx_ls);

		//翻页查询
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业ID(qyid) 
		qyjbxx_ls.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qyjbxx_ls.setQylsid(1)

		qyjbxx_lsService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//qyjbxx_lsService.insertQyjbxx_ls(qyjbxx_ls);
	
	qyjbxx_ls = null;
	qyjbxx_ls = new Qyjbxx_ls();
	//qyjbxx_ls.setQyid(4);
	qyjbxx_ls.setQylsid(16);
	//System.out.println("==="+qyjbxx_lsService.isLatestBgQyjbxx_ls(qyjbxx_ls));
	qyjbxx_lsService.getNextBgQyjbxx_ls(qyjbxx_ls);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyjbxx_lsService(IQyjbxx_lsService qyjbxx_lsService) {
		this.qyjbxx_lsService = qyjbxx_lsService;
	}
}
