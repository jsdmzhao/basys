package com.aisino2.publicsystem.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.publicsystem.domain.Bldsjksb;
import com.aisino2.publicsystem.service.IBldsjksbService;

public class BldsjksbTest extends AbstractTransactionalDataSourceSpringContextTests {
	
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/publicsystem-service.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/icksystem-service.xml",
				"/config/spring/icksystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		return paths;
	}

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBldsjksbService bldsjksbService;

	/** @param 闭路电视监控设备(t_bldsjksb) */

	public void test() {
		Bldsjksb bldsjksb = new Bldsjksb();

	/** @ 企业ID(qyid) */
	bldsjksb.setQyid(0);

	/** @ 闭路电视监控设备ID(bldsjksbid) */
	bldsjksb.setBldsjksbid(0);

	/** @ 网络传输类型编码(wlcslxbm) */
	bldsjksb.setWlcslxbm("test");

	/** @ 网络传输类型名称(wlcslxmc) */
	bldsjksb.setWlcslxmc("test");

	/** @ 设备检测机构名称(sbjcjgmc) */
	bldsjksb.setSbjcjgmc("test");

	/** @ 安装摄像头数量(azsxtsl) */
	bldsjksb.setAzsxtsl(0);

	/** @ 设备序号(sbxh) */
	bldsjksb.setSbxh("0");

	/** @ 生产厂商名称(sccsmc) */
	bldsjksb.setSccsmc("test");

	/** @ 规格型号(ggxh) */
	bldsjksb.setGgxh("test");

	/** @ 安装数量(azsl) */
	bldsjksb.setAzsl(0);

	/** @ 设备名称(sbmc) */
	bldsjksb.setSbmc("test");

	/** @ 是否录像(sflx) */
	bldsjksb.setSflx("test");

	/** @ 服务器IP地址(ipdz) */
	bldsjksb.setIpdz("test");

	/** @ 安装位置(anwz) */
	bldsjksb.setAnwz("test");

		/*
		//插入对象
		bldsjksbService.insertBldsjksb(bldsjksb);

		//读取对象比较
		BaseObject bo = bldsjksbService.getBldsjksb(bldsjksb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bldsjksb bldsjksbNew = (Bldsjksb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bldsjksbNew.getQyid(), bldsjksb.getQyid());
		assertEquals(bldsjksbNew.getBldsjksbid(), bldsjksb.getBldsjksbid());
		assertEquals(bldsjksbNew.getWlcslxbm(), bldsjksb.getWlcslxbm());
		assertEquals(bldsjksbNew.getWlcslxmc(), bldsjksb.getWlcslxmc());
		assertEquals(bldsjksbNew.getSbjcjgmc(), bldsjksb.getSbjcjgmc());
		assertEquals(bldsjksbNew.getAzsxtsl(), bldsjksb.getAzsxtsl());
		assertEquals(bldsjksbNew.getSbxh(), bldsjksb.getSbxh());
		assertEquals(bldsjksbNew.getSccsmc(), bldsjksb.getSccsmc());
		assertEquals(bldsjksbNew.getGgxh(), bldsjksb.getGgxh());
		assertEquals(bldsjksbNew.getAzsl(), bldsjksb.getAzsl());
		assertEquals(bldsjksbNew.getSbmc(), bldsjksb.getSbmc());
		assertEquals(bldsjksbNew.getSflx(), bldsjksb.getSflx());
		assertEquals(bldsjksbNew.getIpdz(), bldsjksb.getIpdz());
		assertEquals(bldsjksbNew.getAnwz(), bldsjksb.getAnwz());

		//删除对象
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 闭路电视监控设备ID(bldsjksbid) 
		bldsjksb.setBldsjksbid(1)

		bldsjksbService.deleteBldsjksb(bldsjksb);

		//修改对象
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 闭路电视监控设备ID(bldsjksbid) 
		bldsjksb.setBldsjksbid(1)

		bldsjksbService.updateBldsjksb(bldsjksb);

		//查询单条
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 闭路电视监控设备ID(bldsjksbid) 
		bldsjksb.setBldsjksbid(1)

		bldsjksbService.getBldsjksb(bldsjksb);

		//查询多条
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 闭路电视监控设备ID(bldsjksbid) 
		bldsjksb.setBldsjksbid(1)

		bldsjksbService.getListBldsjksb(bldsjksb);

		//翻页查询
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 企业ID(qyid) 
		bldsjksb.setQyid(1)
		// @ 闭路电视监控设备ID(bldsjksbid) 
		bldsjksb.setBldsjksbid(1)*/
		
		Map map = new HashMap();
		map.put("qymc", "标准化");
		map.put("hylbdm", "J");

		//bldsjksbService.getListForPage(map,pageNo,pageSize,sort,desc);
		bldsjksbService.getBldsjksbGadListForPage(map, 1, 15, "0", "desc");

		//插入对象
		//bldsjksbService.insertBldsjksb(bldsjksb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBldsjksbService(IBldsjksbService bldsjksbService) {
		this.bldsjksbService = bldsjksbService;
	}
}
