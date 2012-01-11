package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.St_device;
import com.aisino2.icksystem.service.ISt_deviceService;

public class St_deviceTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ISt_deviceService ST_DEVICEService;

	/** @param 无线终端设备(ST_DEVICE) */

	public void test() {
		St_device ST_DEVICE = new St_device();

	/** @ 设备序号(dev_serial) */
	ST_DEVICE.setDev_serial(0);

	/** @ 设备名称(dev_name) */
	ST_DEVICE.setDev_name("test");

	/** @ 设备IP(dev_ip) */
	ST_DEVICE.setDev_ip("test");

	/** @ 设备连接密码(dev_password) */
	ST_DEVICE.setDev_password("test");

	/** @ 设备日志(dev_log) */
	ST_DEVICE.setDev_log("test");

	/** @ 常关规则(dev_devrulezuc) */
	ST_DEVICE.setDev_devrulezuc(0);

	/** @ 常开规则(dev_devrulezuo) */
	ST_DEVICE.setDev_devrulezuo(0);

	/** @ 管理员编号(gly_no) */
	ST_DEVICE.setGly_no("test");

	/** @ 设备更新时间(dev_update) */
	ST_DEVICE.setDev_update(new Date());

	/** @ 联机，禁用时段设置(dev_devrulezul) */
	ST_DEVICE.setDev_devrulezul("test");

	/** @ 连接类型(com) */
	ST_DEVICE.setCom(0);

	/** @ 端口号(port) */
	ST_DEVICE.setPort(0);

	/** @ 波特率(btl) */
	ST_DEVICE.setBtl(0);

	/** @ 终端显示信息(xs) */
	ST_DEVICE.setXs("test");

	/** @ 管理员密码(gly_psw) */
	ST_DEVICE.setGly_psw("test");

	/** @ 档案最近更新时间(dw_sj) */
	ST_DEVICE.setDw_sj(new Date());

	/** @ 所属服务序号(parent) */
	ST_DEVICE.setParent(0);

	/** @ 终端MAC地址(mac) */
	ST_DEVICE.setMac("test");

	/** @ 脱机数据实时存数据库标志(tjkq) */
	ST_DEVICE.setTjkq(0);

	/** @ 设备最后在线时间(on_line) */
	ST_DEVICE.setOn_line(new Date());

	/** @ 设备当前状态(run_state) */
	ST_DEVICE.setRun_state(0);

	/** @ 下发通知状态(note_ok) */
	ST_DEVICE.setNote_ok(0);

	/** @ 档案变更时间(da_update) */
	ST_DEVICE.setDa_update(new Date());

	/** @ 协查通报编号(notice_serial) */
	ST_DEVICE.setNotice_serial(0);

	/** @ 设备CPU型号(dev_cpu) */
	ST_DEVICE.setDev_cpu("test");

	/** @ 操作系统版本(dev_os) */
	ST_DEVICE.setDev_os("test");

	/** @ 本次流量（字节）(flow_rate) */
	ST_DEVICE.setFlow_rate(0);

	/** @ 保存时间(savetime) */
	ST_DEVICE.setSavetime(new Date());

	/** @ 本设备采集的最大流水号(max_flow_no) */
	ST_DEVICE.setMax_flow_no(0);

	/** @ 本设备内核版本号(dev_version) */
	ST_DEVICE.setDev_version("test");

	/** @ 设备更新状态(dev_up) */
	ST_DEVICE.setDev_up(0);

	/** @ 企业ID(qyid) */
	ST_DEVICE.setQyid(0);

		/*
		//插入对象
		ST_DEVICEService.insertSt_device(ST_DEVICE);

		//读取对象比较
		BaseObject bo = ST_DEVICEService.getSt_device(ST_DEVICE);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		St_device ST_DEVICENew = (St_device)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ST_DEVICENew.getDev_serial(), ST_DEVICE.getDev_serial());
		assertEquals(ST_DEVICENew.getDev_name(), ST_DEVICE.getDev_name());
		assertEquals(ST_DEVICENew.getDev_ip(), ST_DEVICE.getDev_ip());
		assertEquals(ST_DEVICENew.getDev_password(), ST_DEVICE.getDev_password());
		assertEquals(ST_DEVICENew.getDev_log(), ST_DEVICE.getDev_log());
		assertEquals(ST_DEVICENew.getDev_devrulezuc(), ST_DEVICE.getDev_devrulezuc());
		assertEquals(ST_DEVICENew.getDev_devrulezuo(), ST_DEVICE.getDev_devrulezuo());
		assertEquals(ST_DEVICENew.getGly_no(), ST_DEVICE.getGly_no());
		assertEquals(ST_DEVICENew.getDev_update(), ST_DEVICE.getDev_update());
		assertEquals(ST_DEVICENew.getDev_devrulezul(), ST_DEVICE.getDev_devrulezul());
		assertEquals(ST_DEVICENew.getCom(), ST_DEVICE.getCom());
		assertEquals(ST_DEVICENew.getPort(), ST_DEVICE.getPort());
		assertEquals(ST_DEVICENew.getBtl(), ST_DEVICE.getBtl());
		assertEquals(ST_DEVICENew.getXs(), ST_DEVICE.getXs());
		assertEquals(ST_DEVICENew.getGly_psw(), ST_DEVICE.getGly_psw());
		assertEquals(ST_DEVICENew.getDw_sj(), ST_DEVICE.getDw_sj());
		assertEquals(ST_DEVICENew.getParent(), ST_DEVICE.getParent());
		assertEquals(ST_DEVICENew.getMac(), ST_DEVICE.getMac());
		assertEquals(ST_DEVICENew.getTjkq(), ST_DEVICE.getTjkq());
		assertEquals(ST_DEVICENew.getOn_line(), ST_DEVICE.getOn_line());
		assertEquals(ST_DEVICENew.getRun_state(), ST_DEVICE.getRun_state());
		assertEquals(ST_DEVICENew.getNote_ok(), ST_DEVICE.getNote_ok());
		assertEquals(ST_DEVICENew.getDa_update(), ST_DEVICE.getDa_update());
		assertEquals(ST_DEVICENew.getNotice_serial(), ST_DEVICE.getNotice_serial());
		assertEquals(ST_DEVICENew.getDev_cpu(), ST_DEVICE.getDev_cpu());
		assertEquals(ST_DEVICENew.getDev_os(), ST_DEVICE.getDev_os());
		assertEquals(ST_DEVICENew.getFlow_rate(), ST_DEVICE.getFlow_rate());
		assertEquals(ST_DEVICENew.getSavetime(), ST_DEVICE.getSavetime());
		assertEquals(ST_DEVICENew.getMax_flow_no(), ST_DEVICE.getMax_flow_no());
		assertEquals(ST_DEVICENew.getDev_version(), ST_DEVICE.getDev_version());
		assertEquals(ST_DEVICENew.getDev_up(), ST_DEVICE.getDev_up());
		assertEquals(ST_DEVICENew.getQyid(), ST_DEVICE.getQyid());

		//删除对象
		// @ 设备序号(dev_serial) 
		ST_DEVICE.setDev_serial(1)

		ST_DEVICEService.deleteSt_device(ST_DEVICE);

		//修改对象
		// @ 设备序号(dev_serial) 
		ST_DEVICE.setDev_serial(1)

		ST_DEVICEService.updateSt_device(ST_DEVICE);

		//查询单条
		// @ 设备序号(dev_serial) 
		ST_DEVICE.setDev_serial(1)

		ST_DEVICEService.getSt_device(ST_DEVICE);

		//查询多条
		// @ 设备序号(dev_serial) 
		ST_DEVICE.setDev_serial(1)

		ST_DEVICEService.getListSt_device(ST_DEVICE);

		//翻页查询
		// @ 设备序号(dev_serial) 
		ST_DEVICE.setDev_serial(1)

		ST_DEVICEService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		ST_DEVICEService.insertSt_device(ST_DEVICE);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setSt_deviceService(ISt_deviceService ST_DEVICEService) {
		this.ST_DEVICEService = ST_DEVICEService;
	}
}
