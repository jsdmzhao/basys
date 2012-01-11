package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Qycf;
import com.aisino2.basicsystem.service.IQycfService;
import com.aisino2.core.test.BaseTestCase;

public class QycfTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQycfService qycfService;

	/** @param 企业处罚(t_qycf) */

	public void test() {
		Qycf qycf = new Qycf();

	/** @ 企业处罚ID(qycfid) */
	qycf.setQycfid(0);

	/** @ 行业类别(hylb) */
	qycf.setHylb("test");

	/** @ 企业编码(qybm) */
	qycf.setQybm("test");

	/** @ 企业名称(qymc) */
	qycf.setQymc("test");

	/** @ 所属单位编码(ssdwbm) */
	qycf.setSsdwbm("test");

	/** @ 所属单位名称(ssdwmc) */
	qycf.setSsdwmc("test");

	/** @ 违规情况描述(wgqkms) */
	qycf.setWgqkms("test");

	/** @ 处罚依据(cfyj) */
	qycf.setCfyj("test");

	/** @ 处罚类型(cflx) */
	qycf.setCflx("test");

	/** @ 处罚结果(cfjg) */
	qycf.setCfjg("test");

	/** @ 批准机构编码(pzjgbm) */
	qycf.setPzjgbm("test");

	/** @ 批准机构名称(pzjgmc) */
	qycf.setPzjgmc("test");

	/** @ 批准人姓名(pzrxm) */
	qycf.setPzrxm("test");

	/** @ 处罚执行人姓名(cfzxrxm) */
	qycf.setCfzxrxm("test");

	/** @ 处罚日期(cfrq) */
	qycf.setCfrq(new Date());

	/** @ 登记时间(djsj) */
	qycf.setDjsj(new Date());

	/** @ 登记人(djr) */
	qycf.setDjr("test");

		/*
		//插入对象
		qycfService.insertQycf(qycf);

		//读取对象比较
		BaseObject bo = qycfService.getQycf(qycf);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qycf qycfNew = (Qycf)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qycfNew.getQycfid(), qycf.getQycfid());
		assertEquals(qycfNew.getHylb(), qycf.getHylb());
		assertEquals(qycfNew.getQybm(), qycf.getQybm());
		assertEquals(qycfNew.getQymc(), qycf.getQymc());
		assertEquals(qycfNew.getSsdwbm(), qycf.getSsdwbm());
		assertEquals(qycfNew.getSsdwmc(), qycf.getSsdwmc());
		assertEquals(qycfNew.getWgqkms(), qycf.getWgqkms());
		assertEquals(qycfNew.getCfyj(), qycf.getCfyj());
		assertEquals(qycfNew.getCflx(), qycf.getCflx());
		assertEquals(qycfNew.getCfjg(), qycf.getCfjg());
		assertEquals(qycfNew.getPzjgbm(), qycf.getPzjgbm());
		assertEquals(qycfNew.getPzjgmc(), qycf.getPzjgmc());
		assertEquals(qycfNew.getPzrxm(), qycf.getPzrxm());
		assertEquals(qycfNew.getCfzxrxm(), qycf.getCfzxrxm());
		assertEquals(qycfNew.getCfrq(), qycf.getCfrq());
		assertEquals(qycfNew.getDjsj(), qycf.getDjsj());
		assertEquals(qycfNew.getDjr(), qycf.getDjr());

		//删除对象
		// @ 企业处罚ID(qycfid) 
		qycf.setQycfid(1)

		qycfService.deleteQycf(qycf);

		//修改对象
		// @ 企业处罚ID(qycfid) 
		qycf.setQycfid(1)

		qycfService.updateQycf(qycf);

		//查询单条
		// @ 企业处罚ID(qycfid) 
		qycf.setQycfid(1)

		qycfService.getQycf(qycf);

		//查询多条
		// @ 企业处罚ID(qycfid) 
		qycf.setQycfid(1)

		qycfService.getListQycf(qycf);

		//翻页查询
		// @ 企业处罚ID(qycfid) 
		qycf.setQycfid(1)

		qycfService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qycfService.insertQycf(qycf);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQycfService(IQycfService qycfService) {
		this.qycfService = qycfService;
	}
}
