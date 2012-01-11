package com.aisino2.icksystem.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Qyryskjl;
import com.aisino2.icksystem.service.IQyryskjlService;

public class QyryskjlTest {
	
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/icksystem-service.xml",
				"/config/spring/icksystem-dao.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/publicsystem-service.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		//this.setAutowireMode(0);

		return paths;
	}

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyryskjlService qyryskjlService;

	/** @param 企业人员刷卡记录(t_qyryskjl) */

	public void test() {
		Qyryskjl qyryskjl = new Qyryskjl();

	/** @ 企业ID(qyid) */
	qyryskjl.setQyid(0);

	/** @ 企业编码(qybm) */
	qyryskjl.setQybm("test");

	/** @ 行业类别代码(hylbdm) */
	qyryskjl.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyryskjl.setHylb("test");

	/** @ 刷卡ID(skid) */
	qyryskjl.setSkid(0);

	/** @ 卡ID号(ickh) */
	qyryskjl.setIckh("test");

	/** @ 刷卡时间(sksj) */
	qyryskjl.setSksj(new Date());

	/** @ 上传时间(scsj) */
	qyryskjl.setScsj(new Date());

	/** @ 卡号(kh) */
	qyryskjl.setKh("test");

	/** @ 从业人员编号(cyrybh) */
	qyryskjl.setCyrybh("test");

	/** @ IC卡受理流水号(icksllsh) */
	qyryskjl.setIcksllsh(0);

		/*
		//插入对象
		qyryskjlService.insertQyryskjl(qyryskjl);

		//读取对象比较
		BaseObject bo = qyryskjlService.getQyryskjl(qyryskjl);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyryskjl qyryskjlNew = (Qyryskjl)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyryskjlNew.getQyid(), qyryskjl.getQyid());
		assertEquals(qyryskjlNew.getQybm(), qyryskjl.getQybm());
		assertEquals(qyryskjlNew.getHylbdm(), qyryskjl.getHylbdm());
		assertEquals(qyryskjlNew.getHylb(), qyryskjl.getHylb());
		assertEquals(qyryskjlNew.getSkid(), qyryskjl.getSkid());
		assertEquals(qyryskjlNew.getIckh(), qyryskjl.getIckh());
		assertEquals(qyryskjlNew.getSksj(), qyryskjl.getSksj());
		assertEquals(qyryskjlNew.getScsj(), qyryskjl.getScsj());
		assertEquals(qyryskjlNew.getKh(), qyryskjl.getKh());
		assertEquals(qyryskjlNew.getCyrybh(), qyryskjl.getCyrybh());
		assertEquals(qyryskjlNew.getIcksllsh(), qyryskjl.getIcksllsh());

		//删除对象
		// @ 刷卡ID(skid) 
		qyryskjl.setSkid(1)

		qyryskjlService.deleteQyryskjl(qyryskjl);

		//修改对象
		// @ 刷卡ID(skid) 
		qyryskjl.setSkid(1)

		qyryskjlService.updateQyryskjl(qyryskjl);

		//查询单条
		// @ 刷卡ID(skid) 
		qyryskjl.setSkid(1)

		qyryskjlService.getQyryskjl(qyryskjl);

		//查询多条
		// @ 刷卡ID(skid) 
		qyryskjl.setSkid(1)

		qyryskjlService.getListQyryskjl(qyryskjl);

		//翻页查询
		// @ 刷卡ID(skid) 
		qyryskjl.setSkid(1)

		qyryskjlService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/
	qyryskjlService = (IQyryskjlService)this.applicationContext.getBean("qyryskjlService");
		//插入对象
		//qyryskjlService.insertQyryskjl(qyryskjl);
	Map map = new HashMap();
	map.put("qyid", 34);
	map.put("qybm", "E024107020001090001");
	//qyryskjlService.getListForPage(map, 1, 10, "1", "desc");
	//qyryskjlService.getCyrygzrzForPage(map, 1, 10, "1", "desc");
	//qyryskjlService.getQyryskjlGadForPage(map, 1, 10, "1", "desc");
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyryskjlService(IQyryskjlService qyryskjlService) {
		this.qyryskjlService = qyryskjlService;
	}
}
