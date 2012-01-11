package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bkwpkbxxkz;
import com.aisino2.basicsystem.service.IBkwpkbxxkzService;
import com.aisino2.core.test.BaseTestCase;

public class BkwpkbxxkzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBkwpkbxxkzService bkwpkbxxkzService;

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) */

	public void test() {
		Bkwpkbxxkz bkwpkbxxkz = new Bkwpkbxxkz();

	/** @ 报警信息ID(bjxxid2) */
	bkwpkbxxkz.setBjxxid2(0);

	/** @ 布控物品基本信息快照ID(bkwpjbxxkzid) */
	bkwpkbxxkz.setBkwpjbxxkzid(0);

	/** @ 行业类别代码(hylbdm) */
	bkwpkbxxkz.setHylbdm("test");

	/** @ 行业类别(hylb) */
	bkwpkbxxkz.setHylb("test");

	/** @ 布控物品类型代码(bkwplxdm) */
	bkwpkbxxkz.setBkwplxdm("test");

	/** @ 布控物品类型(bkwplx) */
	bkwpkbxxkz.setBkwplx("test");

	/** @ 布控物品名称(bkwpmc) */
	bkwpkbxxkz.setBkwpmc("test");

	/** @ 布控物品描述(bkwpms) */
	bkwpkbxxkz.setBkwpms("test");

	/** @ 发文单位(fwdw) */
	bkwpkbxxkz.setFwdw("test");

	/** @ 发文单位编码(fwdwbm) */
	bkwpkbxxkz.setFwdwbm("test");

	/** @ 案件类别编码(ajlbbm) */
	bkwpkbxxkz.setAjlbbm("test");

	/** @ 案件类别(ajlb) */
	bkwpkbxxkz.setAjlb("test");

	/** @ 通报编号(tbbh) */
	bkwpkbxxkz.setTbbh("test");

	/** @ 通报时间(tbsj2) */
	bkwpkbxxkz.setTbsj2(new Date());

	/** @ 简要案情(jyaq) */
	bkwpkbxxkz.setJyaq("test");

	/** @ 处理结果(cljg) */
	bkwpkbxxkz.setCljg("test");

	/** @ 布控人(bkr) */
	bkwpkbxxkz.setBkr("test");

	/** @ 布控操作员(bkczy) */
	bkwpkbxxkz.setBkczy("test");

	/** @ 布控操作时间(bkczsj) */
	bkwpkbxxkz.setBkczsj(new Date());

	/** @ 布控到期时间(bkdqsj) */
	bkwpkbxxkz.setBkdqsj(new Date());

	/** @ 布控范围编码(bkfwbm) */
	bkwpkbxxkz.setBkfwbm("test");

	/** @ 布控范围(bkfw) */
	bkwpkbxxkz.setBkfw("test");

	/** @ 布控审批意见(bkspyj) */
	bkwpkbxxkz.setBkspyj("test");

	/** @ 联系人(lxr) */
	bkwpkbxxkz.setLxr("test");

	/** @ 联系方式(lxfs) */
	bkwpkbxxkz.setLxfs("test");

	/** @ 是否同意发布(sftyfb) */
	bkwpkbxxkz.setSftyfb("test");

	/** @ 审批单位(spdw) */
	bkwpkbxxkz.setSpdw("test");

	/** @ 审批人(spr2) */
	bkwpkbxxkz.setSpr2("test");

	/** @ 审批日期(sprq) */
	bkwpkbxxkz.setSprq(new Date());

	/** @ 请求撤控标识(qqckbs) */
	bkwpkbxxkz.setQqckbs("test");

	/** @ 撤控标识(ckbs) */
	bkwpkbxxkz.setCkbs("test");

	/** @ 撤控原因(ckyy) */
	bkwpkbxxkz.setCkyy("test");

	/** @ 撤控时间(cksj) */
	bkwpkbxxkz.setCksj(new Date());

	/** @ 撤控人(ckr) */
	bkwpkbxxkz.setCkr("test");

	/** @ 撤控操作员(ckczy) */
	bkwpkbxxkz.setCkczy("test");

	/** @ 撤控操作时间(ckczsj) */
	bkwpkbxxkz.setCkczsj(new Date());

	/** @ 撤控部门编码(ckbmbm) */
	bkwpkbxxkz.setCkbmbm("test");

	/** @ 撤控部门名称(ckbmmc) */
	bkwpkbxxkz.setCkbmmc("test");

	/** @ 撤控审批单位(ckspdw) */
	bkwpkbxxkz.setCkspdw("test");

	/** @ 撤控审批人(ckspr) */
	bkwpkbxxkz.setCkspr("test");

	/** @ 撤控审批意见(ckspyj) */
	bkwpkbxxkz.setCkspyj("test");

	/** @ 撤控审批日期(cksprq) */
	bkwpkbxxkz.setCksprq(new Date());

	/** @ 行政区划(xzqh) */
	bkwpkbxxkz.setXzqh("test");

	/** @ 发送标识(fsbs) */
	bkwpkbxxkz.setFsbs("test");

	/** @ 布控对象照片(bkdxzp) */
	bkwpkbxxkz.setBkdxzp(null);

	/** @ 物品简拼(wpjp) */
	bkwpkbxxkz.setWpjp("test");

		/*
		//插入对象
		bkwpkbxxkzService.insertBkwpkbxxkz(bkwpkbxxkz);

		//读取对象比较
		BaseObject bo = bkwpkbxxkzService.getBkwpkbxxkz(bkwpkbxxkz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bkwpkbxxkz bkwpkbxxkzNew = (Bkwpkbxxkz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bkwpkbxxkzNew.getBjxxid2(), bkwpkbxxkz.getBjxxid2());
		assertEquals(bkwpkbxxkzNew.getBkwpjbxxkzid(), bkwpkbxxkz.getBkwpjbxxkzid());
		assertEquals(bkwpkbxxkzNew.getHylbdm(), bkwpkbxxkz.getHylbdm());
		assertEquals(bkwpkbxxkzNew.getHylb(), bkwpkbxxkz.getHylb());
		assertEquals(bkwpkbxxkzNew.getBkwplxdm(), bkwpkbxxkz.getBkwplxdm());
		assertEquals(bkwpkbxxkzNew.getBkwplx(), bkwpkbxxkz.getBkwplx());
		assertEquals(bkwpkbxxkzNew.getBkwpmc(), bkwpkbxxkz.getBkwpmc());
		assertEquals(bkwpkbxxkzNew.getBkwpms(), bkwpkbxxkz.getBkwpms());
		assertEquals(bkwpkbxxkzNew.getFwdw(), bkwpkbxxkz.getFwdw());
		assertEquals(bkwpkbxxkzNew.getFwdwbm(), bkwpkbxxkz.getFwdwbm());
		assertEquals(bkwpkbxxkzNew.getAjlbbm(), bkwpkbxxkz.getAjlbbm());
		assertEquals(bkwpkbxxkzNew.getAjlb(), bkwpkbxxkz.getAjlb());
		assertEquals(bkwpkbxxkzNew.getTbbh(), bkwpkbxxkz.getTbbh());
		assertEquals(bkwpkbxxkzNew.getTbsj2(), bkwpkbxxkz.getTbsj2());
		assertEquals(bkwpkbxxkzNew.getJyaq(), bkwpkbxxkz.getJyaq());
		assertEquals(bkwpkbxxkzNew.getCljg(), bkwpkbxxkz.getCljg());
		assertEquals(bkwpkbxxkzNew.getBkr(), bkwpkbxxkz.getBkr());
		assertEquals(bkwpkbxxkzNew.getBkczy(), bkwpkbxxkz.getBkczy());
		assertEquals(bkwpkbxxkzNew.getBkczsj(), bkwpkbxxkz.getBkczsj());
		assertEquals(bkwpkbxxkzNew.getBkdqsj(), bkwpkbxxkz.getBkdqsj());
		assertEquals(bkwpkbxxkzNew.getBkfwbm(), bkwpkbxxkz.getBkfwbm());
		assertEquals(bkwpkbxxkzNew.getBkfw(), bkwpkbxxkz.getBkfw());
		assertEquals(bkwpkbxxkzNew.getBkspyj(), bkwpkbxxkz.getBkspyj());
		assertEquals(bkwpkbxxkzNew.getLxr(), bkwpkbxxkz.getLxr());
		assertEquals(bkwpkbxxkzNew.getLxfs(), bkwpkbxxkz.getLxfs());
		assertEquals(bkwpkbxxkzNew.getSftyfb(), bkwpkbxxkz.getSftyfb());
		assertEquals(bkwpkbxxkzNew.getSpdw(), bkwpkbxxkz.getSpdw());
		assertEquals(bkwpkbxxkzNew.getSpr2(), bkwpkbxxkz.getSpr2());
		assertEquals(bkwpkbxxkzNew.getSprq(), bkwpkbxxkz.getSprq());
		assertEquals(bkwpkbxxkzNew.getQqckbs(), bkwpkbxxkz.getQqckbs());
		assertEquals(bkwpkbxxkzNew.getCkbs(), bkwpkbxxkz.getCkbs());
		assertEquals(bkwpkbxxkzNew.getCkyy(), bkwpkbxxkz.getCkyy());
		assertEquals(bkwpkbxxkzNew.getCksj(), bkwpkbxxkz.getCksj());
		assertEquals(bkwpkbxxkzNew.getCkr(), bkwpkbxxkz.getCkr());
		assertEquals(bkwpkbxxkzNew.getCkczy(), bkwpkbxxkz.getCkczy());
		assertEquals(bkwpkbxxkzNew.getCkczsj(), bkwpkbxxkz.getCkczsj());
		assertEquals(bkwpkbxxkzNew.getCkbmbm(), bkwpkbxxkz.getCkbmbm());
		assertEquals(bkwpkbxxkzNew.getCkbmmc(), bkwpkbxxkz.getCkbmmc());
		assertEquals(bkwpkbxxkzNew.getCkspdw(), bkwpkbxxkz.getCkspdw());
		assertEquals(bkwpkbxxkzNew.getCkspr(), bkwpkbxxkz.getCkspr());
		assertEquals(bkwpkbxxkzNew.getCkspyj(), bkwpkbxxkz.getCkspyj());
		assertEquals(bkwpkbxxkzNew.getCksprq(), bkwpkbxxkz.getCksprq());
		assertEquals(bkwpkbxxkzNew.getXzqh(), bkwpkbxxkz.getXzqh());
		assertEquals(bkwpkbxxkzNew.getFsbs(), bkwpkbxxkz.getFsbs());
		assertEquals(bkwpkbxxkzNew.getBkdxzp(), bkwpkbxxkz.getBkdxzp());
		assertEquals(bkwpkbxxkzNew.getWpjp(), bkwpkbxxkz.getWpjp());

		//删除对象
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkwpkbxxkz.setBkwpjbxxkzid(1)

		bkwpkbxxkzService.deleteBkwpkbxxkz(bkwpkbxxkz);

		//修改对象
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkwpkbxxkz.setBkwpjbxxkzid(1)

		bkwpkbxxkzService.updateBkwpkbxxkz(bkwpkbxxkz);

		//查询单条
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkwpkbxxkz.setBkwpjbxxkzid(1)

		bkwpkbxxkzService.getBkwpkbxxkz(bkwpkbxxkz);

		//查询多条
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkwpkbxxkz.setBkwpjbxxkzid(1)

		bkwpkbxxkzService.getListBkwpkbxxkz(bkwpkbxxkz);

		//翻页查询
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bkwpkbxxkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bkwpkbxxkz.setBkwpjbxxkzid(1)

		bkwpkbxxkzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bkwpkbxxkzService.insertBkwpkbxxkz(bkwpkbxxkz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBkwpkbxxkzService(IBkwpkbxxkzService bkwpkbxxkzService) {
		this.bkwpkbxxkzService = bkwpkbxxkzService;
	}
}
