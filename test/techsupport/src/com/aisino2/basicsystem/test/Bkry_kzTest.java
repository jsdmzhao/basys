package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bkry_kz;
import com.aisino2.basicsystem.service.IBkry_kzService;
import com.aisino2.core.test.BaseTestCase;

public class Bkry_kzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBkry_kzService bkry_kzService;

	/** @param 布控人员快照(t_bkry_kz) */

	public void test() {
		Bkry_kz bkry_kz = new Bkry_kz();

	/** @ 报警规则ID(bjgzid) */
	bkry_kz.setBjgzid(0);

	/** @ 报警信息ID(bjxxid) */
	bkry_kz.setBjxxid(0);

	/** @ 布控人员ID(bkryid) */
	bkry_kz.setBkryid(0);

	/** @ 布控人员快照ID(bkrykzid) */
	bkry_kz.setBkrykzid(0);

	/** @ 通报编号(tbbh) */
	bkry_kz.setTbbh("test");

	/** @ 姓名(xm) */
	bkry_kz.setXm("test");

	/** @ 曾用名(cym) */
	bkry_kz.setCym("test");

	/** @ 公民身份号码(gmsfhm) */
	bkry_kz.setGmsfhm("test");

	/** @ 姓名拼音(xmpy) */
	bkry_kz.setXmpy("test");

	/** @ 籍贯代码(jgdm) */
	bkry_kz.setJgdm("test");

	/** @ 籍贯(jg) */
	bkry_kz.setJg("test");

	/** @ 出生日期(csrq) */
	bkry_kz.setCsrq(new Date());

	/** @ 性别代码(xbdm) */
	bkry_kz.setXbdm("test");

	/** @ 性别(xb) */
	bkry_kz.setXb("test");

	/** @ 民族代码(mzdm) */
	bkry_kz.setMzdm("test");

	/** @ 民族(minzu) */
	bkry_kz.setMinzu("test");

	/** @ 口音编码(kybm) */
	bkry_kz.setKybm("test");

	/** @ 口音(ky) */
	bkry_kz.setKy("test");

	/** @ 身高(shengao) */
	bkry_kz.setShengao(new Float(9.9));

	/** @ 体征编码(tzbm) */
	bkry_kz.setTzbm("test");

	/** @ 体征(tz) */
	bkry_kz.setTz("test");

	/** @ 体态编码(ttbm) */
	bkry_kz.setTtbm("test");

	/** @ 体态(tt) */
	bkry_kz.setTt("test");

	/** @ 衣着(yz) */
	bkry_kz.setYz("test");

	/** @ 住址(zz) */
	bkry_kz.setZz("test");

	/** @ 发文单位(fwdw) */
	bkry_kz.setFwdw("test");

	/** @ 发文单位编码(fwdwbm) */
	bkry_kz.setFwdwbm("test");

	/** @ 案件类别编码(ajlbbm) */
	bkry_kz.setAjlbbm("test");

	/** @ 案件类别(ajlb) */
	bkry_kz.setAjlb("test");

	/** @ 通报时间(tbsj) */
	bkry_kz.setTbsj(new Date());

	/** @ 简要案情(jyaq) */
	bkry_kz.setJyaq("test");

	/** @ 处理结果(cljg) */
	bkry_kz.setCljg("test");

	/** @ 布控人(bkr) */
	bkry_kz.setBkr("test");

	/** @ 布控操作员(bkczy) */
	bkry_kz.setBkczy("test");

	/** @ 布控操作时间(bkczsj) */
	bkry_kz.setBkczsj(new Date());

	/** @ 布控到期时间(bkdqsj) */
	bkry_kz.setBkdqsj(new Date());

	/** @ 布控范围编码(bkfwbm) */
	bkry_kz.setBkfwbm("test");

	/** @ 布控范围(bkfw) */
	bkry_kz.setBkfw("test");

	/** @ 布控审批意见(bkspyj) */
	bkry_kz.setBkspyj("test");

	/** @ 联系人(lxr) */
	bkry_kz.setLxr("test");

	/** @ 联系方式(lxfs) */
	bkry_kz.setLxfs("test");

	/** @ 是否同意发布(sftyfb) */
	bkry_kz.setSftyfb("test");

	/** @ 审批单位(spdw) */
	bkry_kz.setSpdw("test");

	/** @ 审批人(spr) */
	bkry_kz.setSpr("test");

	/** @ 审批日期(sprq) */
	bkry_kz.setSprq(new Date());

	/** @ 请求撤控标识(qqckbs) */
	bkry_kz.setQqckbs("test");

	/** @ 撤控标识(ckbs) */
	bkry_kz.setCkbs("test");

	/** @ 撤控原因(ckyy) */
	bkry_kz.setCkyy("test");

	/** @ 撤控时间(cksj) */
	bkry_kz.setCksj(new Date());

	/** @ 撤控人(ckr) */
	bkry_kz.setCkr("test");

	/** @ 撤控操作员(ckczy) */
	bkry_kz.setCkczy("test");

	/** @ 撤控操作时间(ckczsj) */
	bkry_kz.setCkczsj(new Date());

	/** @ 撤控部门编码(ckbmbm) */
	bkry_kz.setCkbmbm("test");

	/** @ 撤控部门名称(ckbmmc) */
	bkry_kz.setCkbmmc("test");

	/** @ 撤控审批单位(ckspdw) */
	bkry_kz.setCkspdw("test");

	/** @ 撤控审批人(ckspr) */
	bkry_kz.setCkspr("test");

	/** @ 撤控审批意见(ckspyj) */
	bkry_kz.setCkspyj("test");

	/** @ 撤控审批日期(cksprq) */
	bkry_kz.setCksprq(new Date());

	/** @ 行政区划编码(xzqhbm) */
	bkry_kz.setXzqhbm("test");

	/** @ 行政区划(xzqh) */
	bkry_kz.setXzqh("test");

	/** @ 发送标识(fsbs) */
	bkry_kz.setFsbs("test");

	/** @ 布控对象照片(bkdxzp) */
	bkry_kz.setBkdxzp(null);

		/*
		//插入对象
		bkry_kzService.insertBkry_kz(bkry_kz);

		//读取对象比较
		BaseObject bo = bkry_kzService.getBkry_kz(bkry_kz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bkry_kz bkry_kzNew = (Bkry_kz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bkry_kzNew.getBjgzid(), bkry_kz.getBjgzid());
		assertEquals(bkry_kzNew.getBjxxid(), bkry_kz.getBjxxid());
		assertEquals(bkry_kzNew.getBkryid(), bkry_kz.getBkryid());
		assertEquals(bkry_kzNew.getBkrykzid(), bkry_kz.getBkrykzid());
		assertEquals(bkry_kzNew.getTbbh(), bkry_kz.getTbbh());
		assertEquals(bkry_kzNew.getXm(), bkry_kz.getXm());
		assertEquals(bkry_kzNew.getCym(), bkry_kz.getCym());
		assertEquals(bkry_kzNew.getGmsfhm(), bkry_kz.getGmsfhm());
		assertEquals(bkry_kzNew.getXmpy(), bkry_kz.getXmpy());
		assertEquals(bkry_kzNew.getJgdm(), bkry_kz.getJgdm());
		assertEquals(bkry_kzNew.getJg(), bkry_kz.getJg());
		assertEquals(bkry_kzNew.getCsrq(), bkry_kz.getCsrq());
		assertEquals(bkry_kzNew.getXbdm(), bkry_kz.getXbdm());
		assertEquals(bkry_kzNew.getXb(), bkry_kz.getXb());
		assertEquals(bkry_kzNew.getMzdm(), bkry_kz.getMzdm());
		assertEquals(bkry_kzNew.getMinzu(), bkry_kz.getMinzu());
		assertEquals(bkry_kzNew.getKybm(), bkry_kz.getKybm());
		assertEquals(bkry_kzNew.getKy(), bkry_kz.getKy());
		assertEquals(bkry_kzNew.getShengao(), bkry_kz.getShengao());
		assertEquals(bkry_kzNew.getTzbm(), bkry_kz.getTzbm());
		assertEquals(bkry_kzNew.getTz(), bkry_kz.getTz());
		assertEquals(bkry_kzNew.getTtbm(), bkry_kz.getTtbm());
		assertEquals(bkry_kzNew.getTt(), bkry_kz.getTt());
		assertEquals(bkry_kzNew.getYz(), bkry_kz.getYz());
		assertEquals(bkry_kzNew.getZz(), bkry_kz.getZz());
		assertEquals(bkry_kzNew.getFwdw(), bkry_kz.getFwdw());
		assertEquals(bkry_kzNew.getFwdwbm(), bkry_kz.getFwdwbm());
		assertEquals(bkry_kzNew.getAjlbbm(), bkry_kz.getAjlbbm());
		assertEquals(bkry_kzNew.getAjlb(), bkry_kz.getAjlb());
		assertEquals(bkry_kzNew.getTbsj(), bkry_kz.getTbsj());
		assertEquals(bkry_kzNew.getJyaq(), bkry_kz.getJyaq());
		assertEquals(bkry_kzNew.getCljg(), bkry_kz.getCljg());
		assertEquals(bkry_kzNew.getBkr(), bkry_kz.getBkr());
		assertEquals(bkry_kzNew.getBkczy(), bkry_kz.getBkczy());
		assertEquals(bkry_kzNew.getBkczsj(), bkry_kz.getBkczsj());
		assertEquals(bkry_kzNew.getBkdqsj(), bkry_kz.getBkdqsj());
		assertEquals(bkry_kzNew.getBkfwbm(), bkry_kz.getBkfwbm());
		assertEquals(bkry_kzNew.getBkfw(), bkry_kz.getBkfw());
		assertEquals(bkry_kzNew.getBkspyj(), bkry_kz.getBkspyj());
		assertEquals(bkry_kzNew.getLxr(), bkry_kz.getLxr());
		assertEquals(bkry_kzNew.getLxfs(), bkry_kz.getLxfs());
		assertEquals(bkry_kzNew.getSftyfb(), bkry_kz.getSftyfb());
		assertEquals(bkry_kzNew.getSpdw(), bkry_kz.getSpdw());
		assertEquals(bkry_kzNew.getSpr(), bkry_kz.getSpr());
		assertEquals(bkry_kzNew.getSprq(), bkry_kz.getSprq());
		assertEquals(bkry_kzNew.getQqckbs(), bkry_kz.getQqckbs());
		assertEquals(bkry_kzNew.getCkbs(), bkry_kz.getCkbs());
		assertEquals(bkry_kzNew.getCkyy(), bkry_kz.getCkyy());
		assertEquals(bkry_kzNew.getCksj(), bkry_kz.getCksj());
		assertEquals(bkry_kzNew.getCkr(), bkry_kz.getCkr());
		assertEquals(bkry_kzNew.getCkczy(), bkry_kz.getCkczy());
		assertEquals(bkry_kzNew.getCkczsj(), bkry_kz.getCkczsj());
		assertEquals(bkry_kzNew.getCkbmbm(), bkry_kz.getCkbmbm());
		assertEquals(bkry_kzNew.getCkbmmc(), bkry_kz.getCkbmmc());
		assertEquals(bkry_kzNew.getCkspdw(), bkry_kz.getCkspdw());
		assertEquals(bkry_kzNew.getCkspr(), bkry_kz.getCkspr());
		assertEquals(bkry_kzNew.getCkspyj(), bkry_kz.getCkspyj());
		assertEquals(bkry_kzNew.getCksprq(), bkry_kz.getCksprq());
		assertEquals(bkry_kzNew.getXzqhbm(), bkry_kz.getXzqhbm());
		assertEquals(bkry_kzNew.getXzqh(), bkry_kz.getXzqh());
		assertEquals(bkry_kzNew.getFsbs(), bkry_kz.getFsbs());
		assertEquals(bkry_kzNew.getBkdxzp(), bkry_kz.getBkdxzp());

		//删除对象
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员快照ID(bkrykzid) 
		bkry_kz.setBkrykzid(1)

		bkry_kzService.deleteBkry_kz(bkry_kz);

		//修改对象
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员快照ID(bkrykzid) 
		bkry_kz.setBkrykzid(1)

		bkry_kzService.updateBkry_kz(bkry_kz);

		//查询单条
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员快照ID(bkrykzid) 
		bkry_kz.setBkrykzid(1)

		bkry_kzService.getBkry_kz(bkry_kz);

		//查询多条
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员快照ID(bkrykzid) 
		bkry_kz.setBkrykzid(1)

		bkry_kzService.getListBkry_kz(bkry_kz);

		//翻页查询
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bkry_kz.setBjgzid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 报警信息ID(bjxxid) 
		bkry_kz.setBjxxid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员ID(bkryid) 
		bkry_kz.setBkryid(1)
		// @ 布控人员快照ID(bkrykzid) 
		bkry_kz.setBkrykzid(1)

		bkry_kzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bkry_kzService.insertBkry_kz(bkry_kz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBkry_kzService(IBkry_kzService bkry_kzService) {
		this.bkry_kzService = bkry_kzService;
	}
}
