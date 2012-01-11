package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Wldj;
import com.aisino2.icksystem.service.IWldjService;

public class WldjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWldjService wldjService;

	/** @param 物流登记信息(t_wldj) */

	public void test() {
		Wldj wldj = new Wldj();

	/** @ 物流ID(wlid) */
	wldj.setWlid(0);

	/** @ 物流批次(wlpc) */
	wldj.setWlpc("test");

	/** @ 登记人(djr) */
	wldj.setDjr("test");

	/** @ 组包时间(zbsj) */
	wldj.setZbsj(new Date());

	/** @ 目标受理点编号(mbsldbh) */
	wldj.setMbsldbh("test");

	/** @ 目标受理点名称(mbsldmc) */
	wldj.setMbsldmc("test");

	/** @ 状态代码(ztdm) */
	wldj.setZtdm("test");

	/** @ 状态代码名称(ztdmmc) */
	wldj.setZtdmmc("test");

	/** @ 反馈信息(fkxx) */
	wldj.setFkxx("test");

	/** @ 反馈时间(fksj) */
	wldj.setFksj(new Date());

	/** @ 发送人(fsr) */
	wldj.setFsr("test");

	/** @ 发送时间(fssj) */
	wldj.setFssj(new Date());

	/** @ 所在地市编码(szdsbm) */
	wldj.setSzdsbm("test");

	/** @ 所在地市(szds) */
	wldj.setSzds("test");

	/** @ 接收人(jsr) */
	wldj.setJsr("test");

	/** @ 接收时间(jssj) */
	wldj.setJssj(new Date());

	/** @ 备注(bz) */
	wldj.setBz("test");

	/** @ 物流公司(wlgs) */
	wldj.setWlgs("test");

	/** @ 包内卡数量(bnksl) */
	wldj.setBnksl(0);

		/*
		//插入对象
		wldjService.insertWldj(wldj);

		//读取对象比较
		BaseObject bo = wldjService.getWldj(wldj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wldj wldjNew = (Wldj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wldjNew.getWlid(), wldj.getWlid());
		assertEquals(wldjNew.getWlpc(), wldj.getWlpc());
		assertEquals(wldjNew.getDjr(), wldj.getDjr());
		assertEquals(wldjNew.getZbsj(), wldj.getZbsj());
		assertEquals(wldjNew.getMbsldbh(), wldj.getMbsldbh());
		assertEquals(wldjNew.getMbsldmc(), wldj.getMbsldmc());
		assertEquals(wldjNew.getZtdm(), wldj.getZtdm());
		assertEquals(wldjNew.getZtdmmc(), wldj.getZtdmmc());
		assertEquals(wldjNew.getFkxx(), wldj.getFkxx());
		assertEquals(wldjNew.getFksj(), wldj.getFksj());
		assertEquals(wldjNew.getFsr(), wldj.getFsr());
		assertEquals(wldjNew.getFssj(), wldj.getFssj());
		assertEquals(wldjNew.getSzdsbm(), wldj.getSzdsbm());
		assertEquals(wldjNew.getSzds(), wldj.getSzds());
		assertEquals(wldjNew.getJsr(), wldj.getJsr());
		assertEquals(wldjNew.getJssj(), wldj.getJssj());
		assertEquals(wldjNew.getBz(), wldj.getBz());
		assertEquals(wldjNew.getWlgs(), wldj.getWlgs());
		assertEquals(wldjNew.getBnksl(), wldj.getBnksl());

		//删除对象
		// @ 物流ID(wlid) 
		wldj.setWlid(1)

		wldjService.deleteWldj(wldj);

		//修改对象
		// @ 物流ID(wlid) 
		wldj.setWlid(1)

		wldjService.updateWldj(wldj);

		//查询单条
		// @ 物流ID(wlid) 
		wldj.setWlid(1)

		wldjService.getWldj(wldj);

		//查询多条
		// @ 物流ID(wlid) 
		wldj.setWlid(1)

		wldjService.getListWldj(wldj);

		//翻页查询
		// @ 物流ID(wlid) 
		wldj.setWlid(1)

		wldjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		try {
			wldjService.insertWldj(wldj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWldjService(IWldjService wldjService) {
		this.wldjService = wldjService;
	}
}
