package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.ISt_deviceDao;
import com.aisino2.icksystem.domain.St_device;

public class St_deviceDaoImpl extends BaseDao implements ISt_deviceDao {
	/** @param 无线终端设备(ST_DEVICE) 增加 */
	public St_device insertSt_device(St_device ST_DEVICE){
		// TODO: implement
		return (St_device)insert("insertSt_device", ST_DEVICE);
	}

	/** @param 无线终端设备(ST_DEVICE) 删除 */
	public int deleteSt_device(St_device ST_DEVICE){
		// TODO: implement
		return delete("deleteSt_device", ST_DEVICE);
	}

	/** @param 无线终端设备(ST_DEVICE) 修改 */
	public int updateSt_device(St_device ST_DEVICE){
		// TODO: implement
		return update("updateSt_device", ST_DEVICE);
	}

	/** @param 无线终端设备(ST_DEVICE) 查询单条 */
	public St_device getSt_device(St_device ST_DEVICE){
		// TODO: implement
		return (St_device)queryForObject("getSt_device", ST_DEVICE);
	}

	/** @param 无线终端设备(ST_DEVICE) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
	
		
		
		
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.dev_name "+ desc;
			else if(sort.equals("1"))
				sCol = " a.mac "+ desc;
			else if(sort.equals("2"))
				sCol = " a.dev_ip "+ desc;
			else if(sort.equals("3"))
				sCol = " a.port "+ desc;
			else if(sort.equals("4"))
				sCol = " a.csbm "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.run_state "+ desc;
			else
				sCol = " a.Dev_serial desc ";
		}else{
			sCol="a.Dev_serial desc";
		}
		
		
		
		
		
		
		
		
		map.put("pageSort", sCol);
		return queryForPage("getSt_deviceList", map, pageNo,pageSize);
	}

	/** @param 无线终端设备(ST_DEVICE) 多条查询 */
	public List getListSt_device(St_device ST_DEVICE){
		// TODO: implement
		return queryForList("getSt_deviceListNoPage", ST_DEVICE);
	}

	public Page getListMoRenForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Dev_serial ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getSt_deviceMoRenList", map, pageNo,pageSize);
	}
}
