package com.aisino2.icksystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.St_device;

public interface ISt_deviceService {
	/** @param 无线终端设备(ST_DEVICE) 增加 */
	St_device insertSt_device(St_device ST_DEVICE);

	/** @param 无线终端设备(ST_DEVICE) 删除 */
	boolean deleteSt_device(St_device ST_DEVICE);

	/** @param 无线终端设备(ST_DEVICE) 修改 */
	boolean updateSt_device(St_device ST_DEVICE);

	/** @param 无线终端设备(ST_DEVICE) 查询单条 */
	St_device getSt_device(St_device ST_DEVICE);

	/** @param 无线终端设备(ST_DEVICE) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 无线终端设备(ST_DEVICE) 多条查询 */
	List getListSt_device(St_device ST_DEVICE);
	
	/** @param 无线终端设备默认服务(ST_DEVICE) 分页查询 */
	Page getListMoRenForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
