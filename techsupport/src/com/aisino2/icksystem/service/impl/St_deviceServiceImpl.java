package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.ISt_deviceDao;
import com.aisino2.icksystem.domain.St_device;
import com.aisino2.icksystem.service.ISt_deviceService;

public class St_deviceServiceImpl extends BaseService implements ISt_deviceService {

	private ISt_deviceDao ST_DEVICEDao;

	/** @param 无线终端设备(ST_DEVICE) 增加 */
	public St_device insertSt_device(St_device ST_DEVICE){
		// TODO: implement
		ST_DEVICE.setNote_ok(0);//默认0
		return (St_device)ST_DEVICEDao.insertSt_device(ST_DEVICE);
	}

	/** @param 无线终端设备(ST_DEVICE) 删除 */
	public boolean deleteSt_device(St_device ST_DEVICE){
		// TODO: implement
		return ST_DEVICEDao.deleteSt_device(ST_DEVICE)>0;
	}

	/** @param 无线终端设备(ST_DEVICE) 修改 */
	public boolean updateSt_device(St_device ST_DEVICE){
		// TODO: implement
		return ST_DEVICEDao.updateSt_device(ST_DEVICE)>0;
	}

	/** @param 无线终端设备(ST_DEVICE) 查询单条 */
	public St_device getSt_device(St_device ST_DEVICE){
		// TODO: implement
		return (St_device)ST_DEVICEDao.getSt_device(ST_DEVICE);
	}

	/** @param 无线终端设备(ST_DEVICE) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return ST_DEVICEDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 无线终端设备(ST_DEVICE) 多条查询 */
	public List getListSt_device(St_device ST_DEVICE){
		// TODO: implement
		return ST_DEVICEDao.getListSt_device(ST_DEVICE);
	}

	public ISt_deviceDao getSt_deviceDao() {
		return ST_DEVICEDao;
	}

	public void setSt_deviceDao(ISt_deviceDao ST_DEVICEDao) {
		this.ST_DEVICEDao = ST_DEVICEDao;
	}

	public Page getListMoRenForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return ST_DEVICEDao.getListMoRenForPage(map, pageNo, pageSize, sort, desc);
	}
}
