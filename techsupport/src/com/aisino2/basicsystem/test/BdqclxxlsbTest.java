package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bdqclxxlsb;
import com.aisino2.basicsystem.service.IBdqclxxlsbService;
import com.aisino2.core.test.BaseTestCase;

public class BdqclxxlsbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBdqclxxlsbService bdqclxxlsbService;

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) */

	public void test() {
		Bdqclxxlsb bdqclxxlsb = new Bdqclxxlsb();

	/** @ 被盗抢车辆信息ID(bdqclxxid) */
	bdqclxxlsb.setBdqclxxid(0);

	/** @ 序号(id) */
	bdqclxxlsb.setId("test");

	/** @ 案件编号(ajbh) */
	bdqclxxlsb.setAjbh("test");

	/** @ 案件性质代码(ajxzdm) */
	bdqclxxlsb.setAjxzdm("test");

	/** @ 案件性质(ajxz) */
	bdqclxxlsb.setAjxz("test");

	/** @ 车辆类型代码(cllxdm) */
	bdqclxxlsb.setCllxdm("test");

	/** @ 车辆类型(cllx) */
	bdqclxxlsb.setCllx("test");

	/** @ 车辆品牌(clpp) */
	bdqclxxlsb.setClpp("test");

	/** @ 车辆型号(clxh) */
	bdqclxxlsb.setClxh("test");

	/** @ 号牌种类代码(hpzldm) */
	bdqclxxlsb.setHpzldm("test");

	/** @ 号牌种类(hpzl) */
	bdqclxxlsb.setHpzl("test");

	/** @ 号牌号码(hphm) */
	bdqclxxlsb.setHphm("test");

	/** @ 车身颜色(csys) */
	bdqclxxlsb.setCsys("test");

	/** @ 机动车所有人(syr) */
	bdqclxxlsb.setSyr("test");

	/** @ 初次登记时间(ccdjrq) */
	bdqclxxlsb.setCcdjrq(new Date());

	/** @ 发动机号(fdjh) */
	bdqclxxlsb.setFdjh("test");

	/** @ 车辆识别代号(clsbdh) */
	bdqclxxlsb.setClsbdh("test");

	/** @ 车架号(cjh) */
	bdqclxxlsb.setCjh("test");

	/** @ 是否参加被盗抢险(sfbx) */
	bdqclxxlsb.setSfbx("test");

	/** @ 报案人(bar) */
	bdqclxxlsb.setBar("test");

	/** @ 立案单位区划编码(ladwqhbm) */
	bdqclxxlsb.setLadwqhbm("test");

	/** @ 立案单位区划(ladwqh) */
	bdqclxxlsb.setLadwqh("test");

	/** @ 立案单位编码(ladwbm) */
	bdqclxxlsb.setLadwbm("test");

	/** @ 立案单位名称(ladwmc) */
	bdqclxxlsb.setLadwmc("test");

	/** @ 立案时间(lasj) */
	bdqclxxlsb.setLasj(new Date());

	/** @ 立案经办人(lajbr) */
	bdqclxxlsb.setLajbr("test");

	/** @ 立案单位联系电话(ladh) */
	bdqclxxlsb.setLadh("test");

	/** @ 受理单位区划编码(sldwqhbm) */
	bdqclxxlsb.setSldwqhbm("test");

	/** @ 受理单位区划(sldwqh) */
	bdqclxxlsb.setSldwqh("test");

	/** @ 受理单位编码(sldwbm) */
	bdqclxxlsb.setSldwbm("test");

	/** @ 受理单位名称(sldwmc) */
	bdqclxxlsb.setSldwmc("test");

	/** @ 受理时间(slsj) */
	bdqclxxlsb.setSlsj(new Date());

	/** @ 受理经办人(sljbr) */
	bdqclxxlsb.setSljbr("test");

	/** @ 受理单位联系电话(sldh) */
	bdqclxxlsb.setSldh("test");

	/** @ 备注(bz) */
	bdqclxxlsb.setBz("test");

	/** @ 填报单位区划编码(tbdwqhbm) */
	bdqclxxlsb.setTbdwqhbm("test");

	/** @ 填报单位区划(tbdwqh) */
	bdqclxxlsb.setTbdwqh("test");

	/** @ 填报单位编码(tbdwbm) */
	bdqclxxlsb.setTbdwbm("test");

	/** @ 填报单位名称(tbdwmc) */
	bdqclxxlsb.setTbdwmc("test");

	/** @ 填表人(tbtbr) */
	bdqclxxlsb.setTbtbr("test");

	/** @ 填表时间(tbsj3) */
	bdqclxxlsb.setTbsj3(new Date());

	/** @ 状态(zt) */
	bdqclxxlsb.setZt("test");

	/** @ 删除标志(scbz) */
	bdqclxxlsb.setScbz(0);

	/** @ 录入单位编码(lrdwbm) */
	bdqclxxlsb.setLrdwbm("test");

	/** @ 录入单位(lrdw) */
	bdqclxxlsb.setLrdw("test");

	/** @ 录入人(lrr) */
	bdqclxxlsb.setLrr("test");

	/** @ 录入时间(lrsj) */
	bdqclxxlsb.setLrsj(new Date());

	/** @ 修改单位编码(xgdwbm) */
	bdqclxxlsb.setXgdwbm("test");

	/** @ 修改单位(xgdw) */
	bdqclxxlsb.setXgdw("test");

	/** @ 修改人(xgr) */
	bdqclxxlsb.setXgr("test");

	/** @ 修改时间(xgsj) */
	bdqclxxlsb.setXgsj(new Date());

	/** @ 审批人(spr3) */
	bdqclxxlsb.setSpr3("test");

	/** @ 审批意见(spyj) */
	bdqclxxlsb.setSpyj("test");

	/** @ 使用单位编码(sydwbm) */
	bdqclxxlsb.setSydwbm("test");

	/** @ 使用单位(sydw) */
	bdqclxxlsb.setSydw("test");

		/*
		//插入对象
		bdqclxxlsbService.insertBdqclxxlsb(bdqclxxlsb);

		//读取对象比较
		BaseObject bo = bdqclxxlsbService.getBdqclxxlsb(bdqclxxlsb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bdqclxxlsb bdqclxxlsbNew = (Bdqclxxlsb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bdqclxxlsbNew.getBdqclxxid(), bdqclxxlsb.getBdqclxxid());
		assertEquals(bdqclxxlsbNew.getId(), bdqclxxlsb.getId());
		assertEquals(bdqclxxlsbNew.getAjbh(), bdqclxxlsb.getAjbh());
		assertEquals(bdqclxxlsbNew.getAjxzdm(), bdqclxxlsb.getAjxzdm());
		assertEquals(bdqclxxlsbNew.getAjxz(), bdqclxxlsb.getAjxz());
		assertEquals(bdqclxxlsbNew.getCllxdm(), bdqclxxlsb.getCllxdm());
		assertEquals(bdqclxxlsbNew.getCllx(), bdqclxxlsb.getCllx());
		assertEquals(bdqclxxlsbNew.getClpp(), bdqclxxlsb.getClpp());
		assertEquals(bdqclxxlsbNew.getClxh(), bdqclxxlsb.getClxh());
		assertEquals(bdqclxxlsbNew.getHpzldm(), bdqclxxlsb.getHpzldm());
		assertEquals(bdqclxxlsbNew.getHpzl(), bdqclxxlsb.getHpzl());
		assertEquals(bdqclxxlsbNew.getHphm(), bdqclxxlsb.getHphm());
		assertEquals(bdqclxxlsbNew.getCsys(), bdqclxxlsb.getCsys());
		assertEquals(bdqclxxlsbNew.getSyr(), bdqclxxlsb.getSyr());
		assertEquals(bdqclxxlsbNew.getCcdjrq(), bdqclxxlsb.getCcdjrq());
		assertEquals(bdqclxxlsbNew.getFdjh(), bdqclxxlsb.getFdjh());
		assertEquals(bdqclxxlsbNew.getClsbdh(), bdqclxxlsb.getClsbdh());
		assertEquals(bdqclxxlsbNew.getCjh(), bdqclxxlsb.getCjh());
		assertEquals(bdqclxxlsbNew.getSfbx(), bdqclxxlsb.getSfbx());
		assertEquals(bdqclxxlsbNew.getBar(), bdqclxxlsb.getBar());
		assertEquals(bdqclxxlsbNew.getLadwqhbm(), bdqclxxlsb.getLadwqhbm());
		assertEquals(bdqclxxlsbNew.getLadwqh(), bdqclxxlsb.getLadwqh());
		assertEquals(bdqclxxlsbNew.getLadwbm(), bdqclxxlsb.getLadwbm());
		assertEquals(bdqclxxlsbNew.getLadwmc(), bdqclxxlsb.getLadwmc());
		assertEquals(bdqclxxlsbNew.getLasj(), bdqclxxlsb.getLasj());
		assertEquals(bdqclxxlsbNew.getLajbr(), bdqclxxlsb.getLajbr());
		assertEquals(bdqclxxlsbNew.getLadh(), bdqclxxlsb.getLadh());
		assertEquals(bdqclxxlsbNew.getSldwqhbm(), bdqclxxlsb.getSldwqhbm());
		assertEquals(bdqclxxlsbNew.getSldwqh(), bdqclxxlsb.getSldwqh());
		assertEquals(bdqclxxlsbNew.getSldwbm(), bdqclxxlsb.getSldwbm());
		assertEquals(bdqclxxlsbNew.getSldwmc(), bdqclxxlsb.getSldwmc());
		assertEquals(bdqclxxlsbNew.getSlsj(), bdqclxxlsb.getSlsj());
		assertEquals(bdqclxxlsbNew.getSljbr(), bdqclxxlsb.getSljbr());
		assertEquals(bdqclxxlsbNew.getSldh(), bdqclxxlsb.getSldh());
		assertEquals(bdqclxxlsbNew.getBz(), bdqclxxlsb.getBz());
		assertEquals(bdqclxxlsbNew.getTbdwqhbm(), bdqclxxlsb.getTbdwqhbm());
		assertEquals(bdqclxxlsbNew.getTbdwqh(), bdqclxxlsb.getTbdwqh());
		assertEquals(bdqclxxlsbNew.getTbdwbm(), bdqclxxlsb.getTbdwbm());
		assertEquals(bdqclxxlsbNew.getTbdwmc(), bdqclxxlsb.getTbdwmc());
		assertEquals(bdqclxxlsbNew.getTbtbr(), bdqclxxlsb.getTbtbr());
		assertEquals(bdqclxxlsbNew.getTbsj3(), bdqclxxlsb.getTbsj3());
		assertEquals(bdqclxxlsbNew.getZt(), bdqclxxlsb.getZt());
		assertEquals(bdqclxxlsbNew.getScbz(), bdqclxxlsb.getScbz());
		assertEquals(bdqclxxlsbNew.getLrdwbm(), bdqclxxlsb.getLrdwbm());
		assertEquals(bdqclxxlsbNew.getLrdw(), bdqclxxlsb.getLrdw());
		assertEquals(bdqclxxlsbNew.getLrr(), bdqclxxlsb.getLrr());
		assertEquals(bdqclxxlsbNew.getLrsj(), bdqclxxlsb.getLrsj());
		assertEquals(bdqclxxlsbNew.getXgdwbm(), bdqclxxlsb.getXgdwbm());
		assertEquals(bdqclxxlsbNew.getXgdw(), bdqclxxlsb.getXgdw());
		assertEquals(bdqclxxlsbNew.getXgr(), bdqclxxlsb.getXgr());
		assertEquals(bdqclxxlsbNew.getXgsj(), bdqclxxlsb.getXgsj());
		assertEquals(bdqclxxlsbNew.getSpr3(), bdqclxxlsb.getSpr3());
		assertEquals(bdqclxxlsbNew.getSpyj(), bdqclxxlsb.getSpyj());
		assertEquals(bdqclxxlsbNew.getSydwbm(), bdqclxxlsb.getSydwbm());
		assertEquals(bdqclxxlsbNew.getSydw(), bdqclxxlsb.getSydw());

		//删除对象
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxxlsb.setBdqclxxid(1)

		bdqclxxlsbService.deleteBdqclxxlsb(bdqclxxlsb);

		//修改对象
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxxlsb.setBdqclxxid(1)

		bdqclxxlsbService.updateBdqclxxlsb(bdqclxxlsb);

		//查询单条
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxxlsb.setBdqclxxid(1)

		bdqclxxlsbService.getBdqclxxlsb(bdqclxxlsb);

		//查询多条
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxxlsb.setBdqclxxid(1)

		bdqclxxlsbService.getListBdqclxxlsb(bdqclxxlsb);

		//翻页查询
		// @ 被盗抢车辆信息ID(bdqclxxid) 
		bdqclxxlsb.setBdqclxxid(1)

		bdqclxxlsbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bdqclxxlsbService.insertBdqclxxlsb(bdqclxxlsb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBdqclxxlsbService(IBdqclxxlsbService bdqclxxlsbService) {
		this.bdqclxxlsbService = bdqclxxlsbService;
	}
}
