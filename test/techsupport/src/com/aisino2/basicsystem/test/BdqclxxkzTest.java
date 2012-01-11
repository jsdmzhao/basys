package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bdqclxxkz;
import com.aisino2.basicsystem.service.IBdqclxxkzService;
import com.aisino2.core.test.BaseTestCase;

public class BdqclxxkzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBdqclxxkzService bdqclxxkzService;

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) */

	public void test() {
		Bdqclxxkz bdqclxxkz = new Bdqclxxkz();

	/** @ 报警信息ID(bjxxid2) */
	bdqclxxkz.setBjxxid2(0);

	/** @ 被盗抢车辆信息快照ID(bdqclxxkzid) */
	bdqclxxkz.setBdqclxxkzid(0);

	/** @ 序号(id) */
	bdqclxxkz.setId("test");

	/** @ 车辆类型代码(cllxdm) */
	bdqclxxkz.setCllxdm("test");

	/** @ 车辆类型(cllx) */
	bdqclxxkz.setCllx("test");

	/** @ 车辆品牌(clpp) */
	bdqclxxkz.setClpp("test");

	/** @ 车辆型号(clxh) */
	bdqclxxkz.setClxh("test");

	/** @ 号牌种类代码(hpzldm) */
	bdqclxxkz.setHpzldm("test");

	/** @ 号牌种类(hpzl) */
	bdqclxxkz.setHpzl("test");

	/** @ 号牌号码(hphm) */
	bdqclxxkz.setHphm("test");

	/** @ 车身颜色(csys) */
	bdqclxxkz.setCsys("test");

	/** @ 机动车所有人(syr) */
	bdqclxxkz.setSyr("test");

	/** @ 初次登记时间(ccdjrq) */
	bdqclxxkz.setCcdjrq(new Date());

	/** @ 发动机号(fdjh) */
	bdqclxxkz.setFdjh("test");

	/** @ 车辆识别代号(clsbdh) */
	bdqclxxkz.setClsbdh("test");

	/** @ 车架号(cjh) */
	bdqclxxkz.setCjh("test");

	/** @ 是否参加被盗抢险(sfbx) */
	bdqclxxkz.setSfbx("test");

	/** @ 报案人(bar) */
	bdqclxxkz.setBar("test");

	/** @ 立案单位区划编码(ladwqhbm) */
	bdqclxxkz.setLadwqhbm("test");

	/** @ 立案单位区划(ladwqh) */
	bdqclxxkz.setLadwqh("test");

	/** @ 立案单位编码(ladwbm) */
	bdqclxxkz.setLadwbm("test");

	/** @ 立案单位名称(ladwmc) */
	bdqclxxkz.setLadwmc("test");

	/** @ 立案时间(lasj) */
	bdqclxxkz.setLasj(new Date());

	/** @ 立案经办人(lajbr) */
	bdqclxxkz.setLajbr("test");

	/** @ 立案单位联系电话(ladh) */
	bdqclxxkz.setLadh("test");

	/** @ 受理单位区划编码(sldwqhbm) */
	bdqclxxkz.setSldwqhbm("test");

	/** @ 受理单位区划(sldwqh) */
	bdqclxxkz.setSldwqh("test");

	/** @ 受理单位编码(sldwbm) */
	bdqclxxkz.setSldwbm("test");

	/** @ 受理单位名称(sldwmc) */
	bdqclxxkz.setSldwmc("test");

	/** @ 受理时间(slsj) */
	bdqclxxkz.setSlsj(new Date());

	/** @ 受理经办人(sljbr) */
	bdqclxxkz.setSljbr("test");

	/** @ 受理单位联系电话(sldh) */
	bdqclxxkz.setSldh("test");

	/** @ 备注(bz) */
	bdqclxxkz.setBz("test");

	/** @ 填报单位区划编码(tbdwqhbm) */
	bdqclxxkz.setTbdwqhbm("test");

	/** @ 填报单位区划(tbdwqh) */
	bdqclxxkz.setTbdwqh("test");

	/** @ 填报单位编码(tbdwbm) */
	bdqclxxkz.setTbdwbm("test");

	/** @ 填报单位名称(tbdwmc) */
	bdqclxxkz.setTbdwmc("test");

	/** @ 填表人(tbtbr) */
	bdqclxxkz.setTbtbr("test");

	/** @ 填表时间(tbsj3) */
	bdqclxxkz.setTbsj3(new Date());

	/** @ 状态(zt) */
	bdqclxxkz.setZt("test");

	/** @ 删除标志(scbz) */
	bdqclxxkz.setScbz(0);

	/** @ 录入单位编码(lrdwbm) */
	bdqclxxkz.setLrdwbm("test");

	/** @ 录入单位(lrdw) */
	bdqclxxkz.setLrdw("test");

	/** @ 录入人(lrr) */
	bdqclxxkz.setLrr("test");

	/** @ 录入时间(lrsj) */
	bdqclxxkz.setLrsj(new Date());

	/** @ 修改单位编码(xgdwbm) */
	bdqclxxkz.setXgdwbm("test");

	/** @ 修改单位(xgdw) */
	bdqclxxkz.setXgdw("test");

	/** @ 修改人(xgr) */
	bdqclxxkz.setXgr("test");

	/** @ 修改时间(xgsj) */
	bdqclxxkz.setXgsj(new Date());

	/** @ 审批人(spr3) */
	bdqclxxkz.setSpr3("test");

	/** @ 审批意见(spyj) */
	bdqclxxkz.setSpyj("test");

	/** @ 使用单位编码(sydwbm) */
	bdqclxxkz.setSydwbm("test");

	/** @ 使用单位(sydw) */
	bdqclxxkz.setSydw("test");

		/*
		//插入对象
		bdqclxxkzService.insertBdqclxxkz(bdqclxxkz);

		//读取对象比较
		BaseObject bo = bdqclxxkzService.getBdqclxxkz(bdqclxxkz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bdqclxxkz bdqclxxkzNew = (Bdqclxxkz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bdqclxxkzNew.getBjxxid2(), bdqclxxkz.getBjxxid2());
		assertEquals(bdqclxxkzNew.getBdqclxxkzid(), bdqclxxkz.getBdqclxxkzid());
		assertEquals(bdqclxxkzNew.getId(), bdqclxxkz.getId());
		assertEquals(bdqclxxkzNew.getCllxdm(), bdqclxxkz.getCllxdm());
		assertEquals(bdqclxxkzNew.getCllx(), bdqclxxkz.getCllx());
		assertEquals(bdqclxxkzNew.getClpp(), bdqclxxkz.getClpp());
		assertEquals(bdqclxxkzNew.getClxh(), bdqclxxkz.getClxh());
		assertEquals(bdqclxxkzNew.getHpzldm(), bdqclxxkz.getHpzldm());
		assertEquals(bdqclxxkzNew.getHpzl(), bdqclxxkz.getHpzl());
		assertEquals(bdqclxxkzNew.getHphm(), bdqclxxkz.getHphm());
		assertEquals(bdqclxxkzNew.getCsys(), bdqclxxkz.getCsys());
		assertEquals(bdqclxxkzNew.getSyr(), bdqclxxkz.getSyr());
		assertEquals(bdqclxxkzNew.getCcdjrq(), bdqclxxkz.getCcdjrq());
		assertEquals(bdqclxxkzNew.getFdjh(), bdqclxxkz.getFdjh());
		assertEquals(bdqclxxkzNew.getClsbdh(), bdqclxxkz.getClsbdh());
		assertEquals(bdqclxxkzNew.getCjh(), bdqclxxkz.getCjh());
		assertEquals(bdqclxxkzNew.getSfbx(), bdqclxxkz.getSfbx());
		assertEquals(bdqclxxkzNew.getBar(), bdqclxxkz.getBar());
		assertEquals(bdqclxxkzNew.getLadwqhbm(), bdqclxxkz.getLadwqhbm());
		assertEquals(bdqclxxkzNew.getLadwqh(), bdqclxxkz.getLadwqh());
		assertEquals(bdqclxxkzNew.getLadwbm(), bdqclxxkz.getLadwbm());
		assertEquals(bdqclxxkzNew.getLadwmc(), bdqclxxkz.getLadwmc());
		assertEquals(bdqclxxkzNew.getLasj(), bdqclxxkz.getLasj());
		assertEquals(bdqclxxkzNew.getLajbr(), bdqclxxkz.getLajbr());
		assertEquals(bdqclxxkzNew.getLadh(), bdqclxxkz.getLadh());
		assertEquals(bdqclxxkzNew.getSldwqhbm(), bdqclxxkz.getSldwqhbm());
		assertEquals(bdqclxxkzNew.getSldwqh(), bdqclxxkz.getSldwqh());
		assertEquals(bdqclxxkzNew.getSldwbm(), bdqclxxkz.getSldwbm());
		assertEquals(bdqclxxkzNew.getSldwmc(), bdqclxxkz.getSldwmc());
		assertEquals(bdqclxxkzNew.getSlsj(), bdqclxxkz.getSlsj());
		assertEquals(bdqclxxkzNew.getSljbr(), bdqclxxkz.getSljbr());
		assertEquals(bdqclxxkzNew.getSldh(), bdqclxxkz.getSldh());
		assertEquals(bdqclxxkzNew.getBz(), bdqclxxkz.getBz());
		assertEquals(bdqclxxkzNew.getTbdwqhbm(), bdqclxxkz.getTbdwqhbm());
		assertEquals(bdqclxxkzNew.getTbdwqh(), bdqclxxkz.getTbdwqh());
		assertEquals(bdqclxxkzNew.getTbdwbm(), bdqclxxkz.getTbdwbm());
		assertEquals(bdqclxxkzNew.getTbdwmc(), bdqclxxkz.getTbdwmc());
		assertEquals(bdqclxxkzNew.getTbtbr(), bdqclxxkz.getTbtbr());
		assertEquals(bdqclxxkzNew.getTbsj3(), bdqclxxkz.getTbsj3());
		assertEquals(bdqclxxkzNew.getZt(), bdqclxxkz.getZt());
		assertEquals(bdqclxxkzNew.getScbz(), bdqclxxkz.getScbz());
		assertEquals(bdqclxxkzNew.getLrdwbm(), bdqclxxkz.getLrdwbm());
		assertEquals(bdqclxxkzNew.getLrdw(), bdqclxxkz.getLrdw());
		assertEquals(bdqclxxkzNew.getLrr(), bdqclxxkz.getLrr());
		assertEquals(bdqclxxkzNew.getLrsj(), bdqclxxkz.getLrsj());
		assertEquals(bdqclxxkzNew.getXgdwbm(), bdqclxxkz.getXgdwbm());
		assertEquals(bdqclxxkzNew.getXgdw(), bdqclxxkz.getXgdw());
		assertEquals(bdqclxxkzNew.getXgr(), bdqclxxkz.getXgr());
		assertEquals(bdqclxxkzNew.getXgsj(), bdqclxxkz.getXgsj());
		assertEquals(bdqclxxkzNew.getSpr3(), bdqclxxkz.getSpr3());
		assertEquals(bdqclxxkzNew.getSpyj(), bdqclxxkz.getSpyj());
		assertEquals(bdqclxxkzNew.getSydwbm(), bdqclxxkz.getSydwbm());
		assertEquals(bdqclxxkzNew.getSydw(), bdqclxxkz.getSydw());

		//删除对象
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 被盗抢车辆信息快照ID(bdqclxxkzid) 
		bdqclxxkz.setBdqclxxkzid(1)

		bdqclxxkzService.deleteBdqclxxkz(bdqclxxkz);

		//修改对象
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 被盗抢车辆信息快照ID(bdqclxxkzid) 
		bdqclxxkz.setBdqclxxkzid(1)

		bdqclxxkzService.updateBdqclxxkz(bdqclxxkz);

		//查询单条
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 被盗抢车辆信息快照ID(bdqclxxkzid) 
		bdqclxxkz.setBdqclxxkzid(1)

		bdqclxxkzService.getBdqclxxkz(bdqclxxkz);

		//查询多条
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 被盗抢车辆信息快照ID(bdqclxxkzid) 
		bdqclxxkz.setBdqclxxkzid(1)

		bdqclxxkzService.getListBdqclxxkz(bdqclxxkz);

		//翻页查询
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bdqclxxkz.setBjxxid2(1)
		// @ 被盗抢车辆信息快照ID(bdqclxxkzid) 
		bdqclxxkz.setBdqclxxkzid(1)

		bdqclxxkzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bdqclxxkzService.insertBdqclxxkz(bdqclxxkz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBdqclxxkzService(IBdqclxxkzService bdqclxxkzService) {
		this.bdqclxxkzService = bdqclxxkzService;
	}
}
