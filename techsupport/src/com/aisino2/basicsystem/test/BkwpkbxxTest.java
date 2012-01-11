package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bkwpkbxx;
import com.aisino2.basicsystem.service.IBkwpkbxxService;
import com.aisino2.core.test.BaseTestCase;

public class BkwpkbxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBkwpkbxxService bkwpkbxxService;

	/** @param 布控物品基本信息(t_bkwpkbxx) */

	public void test() {
		Bkwpkbxx bkwpkbxx = new Bkwpkbxx();

	/** @ 布控物品基本信息ID(bkwpjbxxid) */
	bkwpkbxx.setBkwpjbxxid(0);

	/** @ 行业类别代码(hylbdm) */
	bkwpkbxx.setHylbdm("test");

	/** @ 行业类别(hylb) */
	bkwpkbxx.setHylb("test");

	/** @ 布控物品类型代码(bkwplxdm) */
	bkwpkbxx.setBkwplxdm("test");

	/** @ 布控物品类型(bkwplx) */
	bkwpkbxx.setBkwplx("test");

	/** @ 布控物品名称(bkwpmc) */
	bkwpkbxx.setBkwpmc("test");

	/** @ 布控物品描述(bkwpms) */
	bkwpkbxx.setBkwpms("test");

	/** @ 发文单位(fwdw) */
	bkwpkbxx.setFwdw("test");

	/** @ 发文单位编码(fwdwbm) */
	bkwpkbxx.setFwdwbm("test");

	/** @ 案件类别编码(ajlbbm) */
	bkwpkbxx.setAjlbbm("test");

	/** @ 案件类别(ajlb) */
	bkwpkbxx.setAjlb("test");

	/** @ 通报编号(tbbh) */
	bkwpkbxx.setTbbh("test");

	/** @ 通报时间(tbsj2) */
	bkwpkbxx.setTbsj2(new Date());

	/** @ 简要案情(jyaq) */
	bkwpkbxx.setJyaq("test");

	/** @ 处理结果(cljg) */
	bkwpkbxx.setCljg("test");

	/** @ 布控人(bkr) */
	bkwpkbxx.setBkr("test");

	/** @ 布控操作员(bkczy) */
	bkwpkbxx.setBkczy("test");

	/** @ 布控操作时间(bkczsj) */
	bkwpkbxx.setBkczsj(new Date());

	/** @ 布控到期时间(bkdqsj) */
	bkwpkbxx.setBkdqsj(new Date());

	/** @ 布控范围编码(bkfwbm) */
	bkwpkbxx.setBkfwbm("test");

	/** @ 布控范围(bkfw) */
	bkwpkbxx.setBkfw("test");

	/** @ 布控审批意见(bkspyj) */
	bkwpkbxx.setBkspyj("test");

	/** @ 联系人(lxr) */
	bkwpkbxx.setLxr("test");

	/** @ 联系方式(lxfs) */
	bkwpkbxx.setLxfs("test");

	/** @ 是否同意发布(sftyfb) */
	bkwpkbxx.setSftyfb("test");

	/** @ 审批单位(spdw) */
	bkwpkbxx.setSpdw("test");

	/** @ 审批人(spr2) */
	bkwpkbxx.setSpr2("test");

	/** @ 审批日期(sprq) */
	bkwpkbxx.setSprq(new Date());

	/** @ 请求撤控标识(qqckbs) */
	bkwpkbxx.setQqckbs("test");

	/** @ 撤控标识(ckbs) */
	bkwpkbxx.setCkbs("test");

	/** @ 撤控原因(ckyy) */
	bkwpkbxx.setCkyy("test");

	/** @ 撤控时间(cksj) */
	bkwpkbxx.setCksj(new Date());

	/** @ 撤控人(ckr) */
	bkwpkbxx.setCkr("test");

	/** @ 撤控操作员(ckczy) */
	bkwpkbxx.setCkczy("test");

	/** @ 撤控操作时间(ckczsj) */
	bkwpkbxx.setCkczsj(new Date());

	/** @ 撤控部门编码(ckbmbm) */
	bkwpkbxx.setCkbmbm("test");

	/** @ 撤控部门名称(ckbmmc) */
	bkwpkbxx.setCkbmmc("test");

	/** @ 撤控审批单位(ckspdw) */
	bkwpkbxx.setCkspdw("test");

	/** @ 撤控审批人(ckspr) */
	bkwpkbxx.setCkspr("test");

	/** @ 撤控审批意见(ckspyj) */
	bkwpkbxx.setCkspyj("test");

	/** @ 撤控审批日期(cksprq) */
	bkwpkbxx.setCksprq(new Date());

	/** @ 行政区划(xzqh) */
	bkwpkbxx.setXzqh("test");

	/** @ 发送标识(fsbs) */
	bkwpkbxx.setFsbs("test");

	/** @ 布控对象照片(bkdxzp) */
	bkwpkbxx.setBkdxzp(null);

	/** @ 物品简拼(wpjp) */
	bkwpkbxx.setWpjp("test");

		/*
		//插入对象
		bkwpkbxxService.insertBkwpkbxx(bkwpkbxx);

		//读取对象比较
		BaseObject bo = bkwpkbxxService.getBkwpkbxx(bkwpkbxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bkwpkbxx bkwpkbxxNew = (Bkwpkbxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bkwpkbxxNew.getBkwpjbxxid(), bkwpkbxx.getBkwpjbxxid());
		assertEquals(bkwpkbxxNew.getHylbdm(), bkwpkbxx.getHylbdm());
		assertEquals(bkwpkbxxNew.getHylb(), bkwpkbxx.getHylb());
		assertEquals(bkwpkbxxNew.getBkwplxdm(), bkwpkbxx.getBkwplxdm());
		assertEquals(bkwpkbxxNew.getBkwplx(), bkwpkbxx.getBkwplx());
		assertEquals(bkwpkbxxNew.getBkwpmc(), bkwpkbxx.getBkwpmc());
		assertEquals(bkwpkbxxNew.getBkwpms(), bkwpkbxx.getBkwpms());
		assertEquals(bkwpkbxxNew.getFwdw(), bkwpkbxx.getFwdw());
		assertEquals(bkwpkbxxNew.getFwdwbm(), bkwpkbxx.getFwdwbm());
		assertEquals(bkwpkbxxNew.getAjlbbm(), bkwpkbxx.getAjlbbm());
		assertEquals(bkwpkbxxNew.getAjlb(), bkwpkbxx.getAjlb());
		assertEquals(bkwpkbxxNew.getTbbh(), bkwpkbxx.getTbbh());
		assertEquals(bkwpkbxxNew.getTbsj2(), bkwpkbxx.getTbsj2());
		assertEquals(bkwpkbxxNew.getJyaq(), bkwpkbxx.getJyaq());
		assertEquals(bkwpkbxxNew.getCljg(), bkwpkbxx.getCljg());
		assertEquals(bkwpkbxxNew.getBkr(), bkwpkbxx.getBkr());
		assertEquals(bkwpkbxxNew.getBkczy(), bkwpkbxx.getBkczy());
		assertEquals(bkwpkbxxNew.getBkczsj(), bkwpkbxx.getBkczsj());
		assertEquals(bkwpkbxxNew.getBkdqsj(), bkwpkbxx.getBkdqsj());
		assertEquals(bkwpkbxxNew.getBkfwbm(), bkwpkbxx.getBkfwbm());
		assertEquals(bkwpkbxxNew.getBkfw(), bkwpkbxx.getBkfw());
		assertEquals(bkwpkbxxNew.getBkspyj(), bkwpkbxx.getBkspyj());
		assertEquals(bkwpkbxxNew.getLxr(), bkwpkbxx.getLxr());
		assertEquals(bkwpkbxxNew.getLxfs(), bkwpkbxx.getLxfs());
		assertEquals(bkwpkbxxNew.getSftyfb(), bkwpkbxx.getSftyfb());
		assertEquals(bkwpkbxxNew.getSpdw(), bkwpkbxx.getSpdw());
		assertEquals(bkwpkbxxNew.getSpr2(), bkwpkbxx.getSpr2());
		assertEquals(bkwpkbxxNew.getSprq(), bkwpkbxx.getSprq());
		assertEquals(bkwpkbxxNew.getQqckbs(), bkwpkbxx.getQqckbs());
		assertEquals(bkwpkbxxNew.getCkbs(), bkwpkbxx.getCkbs());
		assertEquals(bkwpkbxxNew.getCkyy(), bkwpkbxx.getCkyy());
		assertEquals(bkwpkbxxNew.getCksj(), bkwpkbxx.getCksj());
		assertEquals(bkwpkbxxNew.getCkr(), bkwpkbxx.getCkr());
		assertEquals(bkwpkbxxNew.getCkczy(), bkwpkbxx.getCkczy());
		assertEquals(bkwpkbxxNew.getCkczsj(), bkwpkbxx.getCkczsj());
		assertEquals(bkwpkbxxNew.getCkbmbm(), bkwpkbxx.getCkbmbm());
		assertEquals(bkwpkbxxNew.getCkbmmc(), bkwpkbxx.getCkbmmc());
		assertEquals(bkwpkbxxNew.getCkspdw(), bkwpkbxx.getCkspdw());
		assertEquals(bkwpkbxxNew.getCkspr(), bkwpkbxx.getCkspr());
		assertEquals(bkwpkbxxNew.getCkspyj(), bkwpkbxx.getCkspyj());
		assertEquals(bkwpkbxxNew.getCksprq(), bkwpkbxx.getCksprq());
		assertEquals(bkwpkbxxNew.getXzqh(), bkwpkbxx.getXzqh());
		assertEquals(bkwpkbxxNew.getFsbs(), bkwpkbxx.getFsbs());
		assertEquals(bkwpkbxxNew.getBkdxzp(), bkwpkbxx.getBkdxzp());
		assertEquals(bkwpkbxxNew.getWpjp(), bkwpkbxx.getWpjp());

		//删除对象
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkwpkbxx.setBkwpjbxxid(1)

		bkwpkbxxService.deleteBkwpkbxx(bkwpkbxx);

		//修改对象
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkwpkbxx.setBkwpjbxxid(1)

		bkwpkbxxService.updateBkwpkbxx(bkwpkbxx);

		//查询单条
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkwpkbxx.setBkwpjbxxid(1)

		bkwpkbxxService.getBkwpkbxx(bkwpkbxx);

		//查询多条
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkwpkbxx.setBkwpjbxxid(1)

		bkwpkbxxService.getListBkwpkbxx(bkwpkbxx);

		//翻页查询
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bkwpkbxx.setBkwpjbxxid(1)

		bkwpkbxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bkwpkbxxService.insertBkwpkbxx(bkwpkbxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBkwpkbxxService(IBkwpkbxxService bkwpkbxxService) {
		this.bkwpkbxxService = bkwpkbxxService;
	}
}
