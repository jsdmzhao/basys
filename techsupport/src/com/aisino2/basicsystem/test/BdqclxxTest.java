package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bdqclxx;
import com.aisino2.basicsystem.service.IBdqclxxService;
import com.aisino2.core.test.BaseTestCase;

public class BdqclxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBdqclxxService bdqclxxService;

	/** @param 被盗抢车辆信息(t_bdqclxx) */

	public void test() {
		Bdqclxx bdqclxx = new Bdqclxx();

	/** @ 被盗抢车辆信息ID(bdqclxxid) */
	bdqclxx.setBdqclxxid(0);

	/** @ 被盗抢_被盗抢车辆信息ID(t_b_bdqclxxid) */
	bdqclxx.setT_b_bdqclxxid(0);

	/** @ 序号(id) */
	bdqclxx.setId("test");

	/** @ 案件编号(ajbh) */
	bdqclxx.setAjbh("test");

	/** @ 案件性质代码(ajxzdm) */
	bdqclxx.setAjxzdm("test");

	/** @ 案件性质(ajxz) */
	bdqclxx.setAjxz("test");

	/** @ 车辆类型代码(cllxdm) */
	bdqclxx.setCllxdm("test");

	/** @ 车辆类型(cllx) */
	bdqclxx.setCllx("test");

	/** @ 车辆品牌(clpp) */
	bdqclxx.setClpp("test");

	/** @ 车辆型号(clxh) */
	bdqclxx.setClxh("test");

	/** @ 号牌种类代码(hpzldm) */
	bdqclxx.setHpzldm("test");

	/** @ 号牌种类(hpzl) */
	bdqclxx.setHpzl("test");

	/** @ 号牌号码(hphm) */
	bdqclxx.setHphm("test");

	/** @ 车身颜色(csys) */
	bdqclxx.setCsys("test");

	/** @ 机动车所有人(syr) */
	bdqclxx.setSyr("test");

	/** @ 初次登记时间(ccdjrq) */
	bdqclxx.setCcdjrq(new Date());

	/** @ 发动机号(fdjh) */
	bdqclxx.setFdjh("test");

	/** @ 车辆识别代号(clsbdh) */
	bdqclxx.setClsbdh("test");

	/** @ 车架号(cjh) */
	bdqclxx.setCjh("test");

	/** @ 是否参加被盗抢险(sfbx) */
	bdqclxx.setSfbx("test");

	/** @ 报案人(bar) */
	bdqclxx.setBar("test");

	/** @ 立案单位区划编码(ladwqhbm) */
	bdqclxx.setLadwqhbm("test");

	/** @ 立案单位区划(ladwqh) */
	bdqclxx.setLadwqh("test");

	/** @ 立案单位编码(ladwbm) */
	bdqclxx.setLadwbm("test");

	/** @ 立案单位名称(ladwmc) */
	bdqclxx.setLadwmc("test");

	/** @ 立案时间(lasj) */
	bdqclxx.setLasj(new Date());

	/** @ 立案经办人(lajbr) */
	bdqclxx.setLajbr("test");

	/** @ 立案单位联系电话(ladh) */
	bdqclxx.setLadh("test");

	/** @ 受理单位区划编码(sldwqhbm) */
	bdqclxx.setSldwqhbm("test");

	/** @ 受理单位区划(sldwqh) */
	bdqclxx.setSldwqh("test");

	/** @ 受理单位编码(sldwbm) */
	bdqclxx.setSldwbm("test");

	/** @ 受理单位名称(sldwmc) */
	bdqclxx.setSldwmc("test");

	/** @ 受理时间(slsj) */
	bdqclxx.setSlsj(new Date());

	/** @ 受理经办人(sljbr) */
	bdqclxx.setSljbr("test");

	/** @ 受理单位联系电话(sldh) */
	bdqclxx.setSldh("test");

	/** @ 备注(bz) */
	bdqclxx.setBz("test");

	/** @ 填报单位区划编码(tbdwqhbm) */
	bdqclxx.setTbdwqhbm("test");

	/** @ 填报单位区划(tbdwqh) */
	bdqclxx.setTbdwqh("test");

	/** @ 填报单位编码(tbdwbm) */
	bdqclxx.setTbdwbm("test");

	/** @ 填报单位名称(tbdwmc) */
	bdqclxx.setTbdwmc("test");

	/** @ 填表人(tbtbr) */
	bdqclxx.setTbtbr("test");

	/** @ 填表时间(tbsj3) */
	bdqclxx.setTbsj3(new Date());

	/** @ 状态(zt) */
	bdqclxx.setZt("test");

	/** @ 删除标志(scbz) */
	bdqclxx.setScbz(0);

	/** @ 录入单位编码(lrdwbm) */
	bdqclxx.setLrdwbm("test");

	/** @ 录入单位(lrdw) */
	bdqclxx.setLrdw("test");

	/** @ 录入人(lrr) */
	bdqclxx.setLrr("test");

	/** @ 录入时间(lrsj) */
	bdqclxx.setLrsj(new Date());

	/** @ 修改单位编码(xgdwbm) */
	bdqclxx.setXgdwbm("test");

	/** @ 修改单位(xgdw) */
	bdqclxx.setXgdw("test");

	/** @ 修改人(xgr) */
	bdqclxx.setXgr("test");

	/** @ 修改时间(xgsj) */
	bdqclxx.setXgsj(new Date());

	/** @ 审批人(spr3) */
	bdqclxx.setSpr3("test");

	/** @ 审批意见(spyj) */
	bdqclxx.setSpyj("test");

	/** @ 使用单位编码(sydwbm) */
	bdqclxx.setSydwbm("test");

	/** @ 使用单位(sydw) */
	bdqclxx.setSydw("test");

		/*
		//插入对象
		bdqclxxService.insertBdqclxx(bdqclxx);

		//读取对象比较
		BaseObject bo = bdqclxxService.getBdqclxx(bdqclxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bdqclxx bdqclxxNew = (Bdqclxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bdqclxxNew.getBdqclxxid(), bdqclxx.getBdqclxxid());
		assertEquals(bdqclxxNew.getT_b_bdqclxxid(), bdqclxx.getT_b_bdqclxxid());
		assertEquals(bdqclxxNew.getId(), bdqclxx.getId());
		assertEquals(bdqclxxNew.getAjbh(), bdqclxx.getAjbh());
		assertEquals(bdqclxxNew.getAjxzdm(), bdqclxx.getAjxzdm());
		assertEquals(bdqclxxNew.getAjxz(), bdqclxx.getAjxz());
		assertEquals(bdqclxxNew.getCllxdm(), bdqclxx.getCllxdm());
		assertEquals(bdqclxxNew.getCllx(), bdqclxx.getCllx());
		assertEquals(bdqclxxNew.getClpp(), bdqclxx.getClpp());
		assertEquals(bdqclxxNew.getClxh(), bdqclxx.getClxh());
		assertEquals(bdqclxxNew.getHpzldm(), bdqclxx.getHpzldm());
		assertEquals(bdqclxxNew.getHpzl(), bdqclxx.getHpzl());
		assertEquals(bdqclxxNew.getHphm(), bdqclxx.getHphm());
		assertEquals(bdqclxxNew.getCsys(), bdqclxx.getCsys());
		assertEquals(bdqclxxNew.getSyr(), bdqclxx.getSyr());
		assertEquals(bdqclxxNew.getCcdjrq(), bdqclxx.getCcdjrq());
		assertEquals(bdqclxxNew.getFdjh(), bdqclxx.getFdjh());
		assertEquals(bdqclxxNew.getClsbdh(), bdqclxx.getClsbdh());
		assertEquals(bdqclxxNew.getCjh(), bdqclxx.getCjh());
		assertEquals(bdqclxxNew.getSfbx(), bdqclxx.getSfbx());
		assertEquals(bdqclxxNew.getBar(), bdqclxx.getBar());
		assertEquals(bdqclxxNew.getLadwqhbm(), bdqclxx.getLadwqhbm());
		assertEquals(bdqclxxNew.getLadwqh(), bdqclxx.getLadwqh());
		assertEquals(bdqclxxNew.getLadwbm(), bdqclxx.getLadwbm());
		assertEquals(bdqclxxNew.getLadwmc(), bdqclxx.getLadwmc());
		assertEquals(bdqclxxNew.getLasj(), bdqclxx.getLasj());
		assertEquals(bdqclxxNew.getLajbr(), bdqclxx.getLajbr());
		assertEquals(bdqclxxNew.getLadh(), bdqclxx.getLadh());
		assertEquals(bdqclxxNew.getSldwqhbm(), bdqclxx.getSldwqhbm());
		assertEquals(bdqclxxNew.getSldwqh(), bdqclxx.getSldwqh());
		assertEquals(bdqclxxNew.getSldwbm(), bdqclxx.getSldwbm());
		assertEquals(bdqclxxNew.getSldwmc(), bdqclxx.getSldwmc());
		assertEquals(bdqclxxNew.getSlsj(), bdqclxx.getSlsj());
		assertEquals(bdqclxxNew.getSljbr(), bdqclxx.getSljbr());
		assertEquals(bdqclxxNew.getSldh(), bdqclxx.getSldh());
		assertEquals(bdqclxxNew.getBz(), bdqclxx.getBz());
		assertEquals(bdqclxxNew.getTbdwqhbm(), bdqclxx.getTbdwqhbm());
		assertEquals(bdqclxxNew.getTbdwqh(), bdqclxx.getTbdwqh());
		assertEquals(bdqclxxNew.getTbdwbm(), bdqclxx.getTbdwbm());
		assertEquals(bdqclxxNew.getTbdwmc(), bdqclxx.getTbdwmc());
		assertEquals(bdqclxxNew.getTbtbr(), bdqclxx.getTbtbr());
		assertEquals(bdqclxxNew.getTbsj3(), bdqclxx.getTbsj3());
		assertEquals(bdqclxxNew.getZt(), bdqclxx.getZt());
		assertEquals(bdqclxxNew.getScbz(), bdqclxx.getScbz());
		assertEquals(bdqclxxNew.getLrdwbm(), bdqclxx.getLrdwbm());
		assertEquals(bdqclxxNew.getLrdw(), bdqclxx.getLrdw());
		assertEquals(bdqclxxNew.getLrr(), bdqclxx.getLrr());
		assertEquals(bdqclxxNew.getLrsj(), bdqclxx.getLrsj());
		assertEquals(bdqclxxNew.getXgdwbm(), bdqclxx.getXgdwbm());
		assertEquals(bdqclxxNew.getXgdw(), bdqclxx.getXgdw());
		assertEquals(bdqclxxNew.getXgr(), bdqclxx.getXgr());
		assertEquals(bdqclxxNew.getXgsj(), bdqclxx.getXgsj());
		assertEquals(bdqclxxNew.getSpr3(), bdqclxx.getSpr3());
		assertEquals(bdqclxxNew.getSpyj(), bdqclxx.getSpyj());
		assertEquals(bdqclxxNew.getSydwbm(), bdqclxx.getSydwbm());
		assertEquals(bdqclxxNew.getSydw(), bdqclxx.getSydw());

		//删除对象
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxx.setBdqclxxid(1)

		bdqclxxService.deleteBdqclxx(bdqclxx);

		//修改对象
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxx.setBdqclxxid(1)

		bdqclxxService.updateBdqclxx(bdqclxx);

		//查询单条
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxx.setBdqclxxid(1)

		bdqclxxService.getBdqclxx(bdqclxx);

		//查询多条
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxx.setBdqclxxid(1)

		bdqclxxService.getListBdqclxx(bdqclxx);

		//翻页查询
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxx.setBdqclxxid(1)

		bdqclxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bdqclxxService.insertBdqclxx(bdqclxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBdqclxxService(IBdqclxxService bdqclxxService) {
		this.bdqclxxService = bdqclxxService;
	}
}
