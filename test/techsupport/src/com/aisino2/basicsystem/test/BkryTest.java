package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bkry;
import com.aisino2.basicsystem.service.IBkryService;
import com.aisino2.core.test.BaseTestCase;

public class BkryTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBkryService bkryService;

	/** @param 布控人员(t_bkry) */

	public void test() {
		Bkry bkry = new Bkry();

	/** @ 布控人员ID(bkryid) */
	bkry.setBkryid(0);

	/** @ 通报编号(tbbh) */
	bkry.setTbbh("test");

	/** @ 姓名(xm) */
	bkry.setXm("test");

	/** @ 曾用名(cym) */
	bkry.setCym("test");

	/** @ 公民身份号码(gmsfhm) */
	bkry.setGmsfhm("test");

	/** @ 姓名拼音(xmpy) */
	bkry.setXmpy("test");

	/** @ 籍贯代码(jgdm) */
	bkry.setJgdm("test");

	/** @ 籍贯(jg) */
	bkry.setJg("test");

	/** @ 出生日期(csrq) */
	bkry.setCsrq(new Date());

	/** @ 性别代码(xbdm) */
	bkry.setXbdm("test");

	/** @ 性别(xb) */
	bkry.setXb("test");

	/** @ 民族代码(mzdm) */
	bkry.setMzdm("test");

	/** @ 民族(minzu) */
	bkry.setMinzu("test");

	/** @ 口音编码(kybm) */
	bkry.setKybm("test");

	/** @ 口音(ky) */
	bkry.setKy("test");

	/** @ 身高(shengao) */
	bkry.setShengao(new Float(9.9));

	/** @ 体征编码(tzbm) */
	bkry.setTzbm("test");

	/** @ 体征(tz) */
	bkry.setTz("test");

	/** @ 体态编码(ttbm) */
	bkry.setTtbm("test");

	/** @ 体态(tt) */
	bkry.setTt("test");

	/** @ 衣着(yz) */
	bkry.setYz("test");

	/** @ 住址(zz) */
	bkry.setZz("test");

	/** @ 发文单位(fwdw) */
	bkry.setFwdw("test");

	/** @ 发文单位编码(fwdwbm) */
	bkry.setFwdwbm("test");

	/** @ 案件类别编码(ajlbbm) */
	bkry.setAjlbbm("test");

	/** @ 案件类别(ajlb) */
	bkry.setAjlb("test");

	/** @ 通报时间(tbsj) */
	bkry.setTbsj(new Date());

	/** @ 简要案情(jyaq) */
	bkry.setJyaq("test");

	/** @ 处理结果(cljg) */
	bkry.setCljg("test");

	/** @ 布控人(bkr) */
	bkry.setBkr("test");

	/** @ 布控操作员(bkczy) */
	bkry.setBkczy("test");

	/** @ 布控操作时间(bkczsj) */
	bkry.setBkczsj(new Date());

	/** @ 布控到期时间(bkdqsj) */
	bkry.setBkdqsj(new Date());

	/** @ 布控范围编码(bkfwbm) */
	bkry.setBkfwbm("test");

	/** @ 布控范围(bkfw) */
	bkry.setBkfw("test");

	/** @ 布控审批意见(bkspyj) */
	bkry.setBkspyj("test");

	/** @ 联系人(lxr) */
	bkry.setLxr("test");

	/** @ 联系方式(lxfs) */
	bkry.setLxfs("test");

	/** @ 是否同意发布(sftyfb) */
	bkry.setSftyfb("test");

	/** @ 审批单位(spdw) */
	bkry.setSpdw("test");

	/** @ 审批人(spr) */
	bkry.setSpr("test");

	/** @ 审批日期(sprq) */
	bkry.setSprq(new Date());

	/** @ 请求撤控标识(qqckbs) */
	bkry.setQqckbs("test");

	/** @ 撤控标识(ckbs) */
	bkry.setCkbs("test");

	/** @ 撤控原因(ckyy) */
	bkry.setCkyy("test");

	/** @ 撤控时间(cksj) */
	bkry.setCksj(new Date());

	/** @ 撤控人(ckr) */
	bkry.setCkr("test");

	/** @ 撤控操作员(ckczy) */
	bkry.setCkczy("test");

	/** @ 撤控操作时间(ckczsj) */
	bkry.setCkczsj(new Date());

	/** @ 撤控部门编码(ckbmbm) */
	bkry.setCkbmbm("test");

	/** @ 撤控部门名称(ckbmmc) */
	bkry.setCkbmmc("test");

	/** @ 撤控审批单位(ckspdw) */
	bkry.setCkspdw("test");

	/** @ 撤控审批人(ckspr) */
	bkry.setCkspr("test");

	/** @ 撤控审批意见(ckspyj) */
	bkry.setCkspyj("test");

	/** @ 撤控审批日期(cksprq) */
	bkry.setCksprq(new Date());

	/** @ 行政区划(xzqh) */
	bkry.setXzqh("test");

	/** @ 发送标识(fsbs) */
	bkry.setFsbs("test");

	/** @ 布控对象照片(bkdxzp) */
	bkry.setBkdxzp(null);

		/*
		//插入对象
		bkryService.insertBkry(bkry);

		//读取对象比较
		BaseObject bo = bkryService.getBkry(bkry);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bkry bkryNew = (Bkry)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bkryNew.getBkryid(), bkry.getBkryid());
		assertEquals(bkryNew.getTbbh(), bkry.getTbbh());
		assertEquals(bkryNew.getXm(), bkry.getXm());
		assertEquals(bkryNew.getCym(), bkry.getCym());
		assertEquals(bkryNew.getGmsfhm(), bkry.getGmsfhm());
		assertEquals(bkryNew.getXmpy(), bkry.getXmpy());
		assertEquals(bkryNew.getJgdm(), bkry.getJgdm());
		assertEquals(bkryNew.getJg(), bkry.getJg());
		assertEquals(bkryNew.getCsrq(), bkry.getCsrq());
		assertEquals(bkryNew.getXbdm(), bkry.getXbdm());
		assertEquals(bkryNew.getXb(), bkry.getXb());
		assertEquals(bkryNew.getMzdm(), bkry.getMzdm());
		assertEquals(bkryNew.getMinzu(), bkry.getMinzu());
		assertEquals(bkryNew.getKybm(), bkry.getKybm());
		assertEquals(bkryNew.getKy(), bkry.getKy());
		assertEquals(bkryNew.getShengao(), bkry.getShengao());
		assertEquals(bkryNew.getTzbm(), bkry.getTzbm());
		assertEquals(bkryNew.getTz(), bkry.getTz());
		assertEquals(bkryNew.getTtbm(), bkry.getTtbm());
		assertEquals(bkryNew.getTt(), bkry.getTt());
		assertEquals(bkryNew.getYz(), bkry.getYz());
		assertEquals(bkryNew.getZz(), bkry.getZz());
		assertEquals(bkryNew.getFwdw(), bkry.getFwdw());
		assertEquals(bkryNew.getFwdwbm(), bkry.getFwdwbm());
		assertEquals(bkryNew.getAjlbbm(), bkry.getAjlbbm());
		assertEquals(bkryNew.getAjlb(), bkry.getAjlb());
		assertEquals(bkryNew.getTbsj(), bkry.getTbsj());
		assertEquals(bkryNew.getJyaq(), bkry.getJyaq());
		assertEquals(bkryNew.getCljg(), bkry.getCljg());
		assertEquals(bkryNew.getBkr(), bkry.getBkr());
		assertEquals(bkryNew.getBkczy(), bkry.getBkczy());
		assertEquals(bkryNew.getBkczsj(), bkry.getBkczsj());
		assertEquals(bkryNew.getBkdqsj(), bkry.getBkdqsj());
		assertEquals(bkryNew.getBkfwbm(), bkry.getBkfwbm());
		assertEquals(bkryNew.getBkfw(), bkry.getBkfw());
		assertEquals(bkryNew.getBkspyj(), bkry.getBkspyj());
		assertEquals(bkryNew.getLxr(), bkry.getLxr());
		assertEquals(bkryNew.getLxfs(), bkry.getLxfs());
		assertEquals(bkryNew.getSftyfb(), bkry.getSftyfb());
		assertEquals(bkryNew.getSpdw(), bkry.getSpdw());
		assertEquals(bkryNew.getSpr(), bkry.getSpr());
		assertEquals(bkryNew.getSprq(), bkry.getSprq());
		assertEquals(bkryNew.getQqckbs(), bkry.getQqckbs());
		assertEquals(bkryNew.getCkbs(), bkry.getCkbs());
		assertEquals(bkryNew.getCkyy(), bkry.getCkyy());
		assertEquals(bkryNew.getCksj(), bkry.getCksj());
		assertEquals(bkryNew.getCkr(), bkry.getCkr());
		assertEquals(bkryNew.getCkczy(), bkry.getCkczy());
		assertEquals(bkryNew.getCkczsj(), bkry.getCkczsj());
		assertEquals(bkryNew.getCkbmbm(), bkry.getCkbmbm());
		assertEquals(bkryNew.getCkbmmc(), bkry.getCkbmmc());
		assertEquals(bkryNew.getCkspdw(), bkry.getCkspdw());
		assertEquals(bkryNew.getCkspr(), bkry.getCkspr());
		assertEquals(bkryNew.getCkspyj(), bkry.getCkspyj());
		assertEquals(bkryNew.getCksprq(), bkry.getCksprq());
		assertEquals(bkryNew.getXzqh(), bkry.getXzqh());
		assertEquals(bkryNew.getFsbs(), bkry.getFsbs());
		assertEquals(bkryNew.getBkdxzp(), bkry.getBkdxzp());

		//删除对象
		// @ 布控人员ID(bkryid) 
		bkry.setBkryid(1)

		bkryService.deleteBkry(bkry);

		//修改对象
		// @ 布控人员ID(bkryid) 
		bkry.setBkryid(1)

		bkryService.updateBkry(bkry);

		//查询单条
		// @ 布控人员ID(bkryid) 
		bkry.setBkryid(1)

		bkryService.getBkry(bkry);

		//查询多条
		// @ 布控人员ID(bkryid) 
		bkry.setBkryid(1)

		bkryService.getListBkry(bkry);

		//翻页查询
		// @ 布控人员ID(bkryid) 
		bkry.setBkryid(1)

		bkryService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bkryService.insertBkry(bkry);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBkryService(IBkryService bkryService) {
		this.bkryService = bkryService;
	}
}
