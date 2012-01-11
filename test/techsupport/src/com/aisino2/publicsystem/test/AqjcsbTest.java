package com.aisino2.publicsystem.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.aisino2.publicsystem.domain.Aqjcsb;
import com.aisino2.publicsystem.service.IAqjcsbService;

public class AqjcsbTest extends AbstractTransactionalDataSourceSpringContextTests {
	
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
	private IAqjcsbService aqjcsbService;

	/** @param 安全检查设备(t_aqjcsb) */

	public void test() {
		Aqjcsb aqjcsb = new Aqjcsb();

	/** @ 企业ID(qyid) */
	aqjcsb.setQyid(0);

	/** @ 安全检查设备ID(anjcsbid) */
	aqjcsb.setAnjcsbid(0);

	/** @ 安全检查设备种类编码(aqjcsbzlbm) */
	aqjcsb.setAqjcsbzlbm("test");

	/** @ 安全检查设备种类名称(aqjcsbzlmc) */
	aqjcsb.setAqjcsbzlmc("test");

	/** @ 设备序号(sbxh) */
	aqjcsb.setSbxh("0");

	/** @ 规格型号(ggxh) */
	aqjcsb.setGgxh("test");

	/** @ 设备名称(sbmc) */
	aqjcsb.setSbmc("test");

	/** @ 安装数量(azsl) */
	aqjcsb.setAzsl(0);

		/*
		//插入对象
		aqjcsbService.insertAqjcsb(aqjcsb);

		//读取对象比较
		BaseObject bo = aqjcsbService.getAqjcsb(aqjcsb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Aqjcsb aqjcsbNew = (Aqjcsb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(aqjcsbNew.getQyid(), aqjcsb.getQyid());
		assertEquals(aqjcsbNew.getAnjcsbid(), aqjcsb.getAnjcsbid());
		assertEquals(aqjcsbNew.getAqjcsbzlbm(), aqjcsb.getAqjcsbzlbm());
		assertEquals(aqjcsbNew.getAqjcsbzlmc(), aqjcsb.getAqjcsbzlmc());
		assertEquals(aqjcsbNew.getSbxh(), aqjcsb.getSbxh());
		assertEquals(aqjcsbNew.getGgxh(), aqjcsb.getGgxh());
		assertEquals(aqjcsbNew.getSbmc(), aqjcsb.getSbmc());
		assertEquals(aqjcsbNew.getAzsl(), aqjcsb.getAzsl());

		//删除对象
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 安全检查设备ID(anjcsbid) 
		aqjcsb.setAnjcsbid(1)

		aqjcsbService.deleteAqjcsb(aqjcsb);

		//修改对象
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 安全检查设备ID(anjcsbid) 
		aqjcsb.setAnjcsbid(1)

		aqjcsbService.updateAqjcsb(aqjcsb);

		//查询单条
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 安全检查设备ID(anjcsbid) 
		aqjcsb.setAnjcsbid(1)

		aqjcsbService.getAqjcsb(aqjcsb);

		//查询多条
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 安全检查设备ID(anjcsbid) 
		aqjcsb.setAnjcsbid(1)

		aqjcsbService.getListAqjcsb(aqjcsb);

		//翻页查询
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 企业ID(qyid) 
		aqjcsb.setQyid(1)
		// @ 安全检查设备ID(anjcsbid) 
		aqjcsb.setAnjcsbid(1)*/

		Map map = new HashMap();
		//map.put("qybm", "J01");
		map.put("hylbdm", "J");
		//aqjcsbService.getListForPage(map, 1, 15, "0", "desc");
		aqjcsbService.getAqjcsbGadListForPage(map, 1, 15, "0", "desc");

		//插入对象
		//aqjcsbService.insertAqjcsb(aqjcsb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setAqjcsbService(IAqjcsbService aqjcsbService) {
		this.aqjcsbService = aqjcsbService;
	}
}
