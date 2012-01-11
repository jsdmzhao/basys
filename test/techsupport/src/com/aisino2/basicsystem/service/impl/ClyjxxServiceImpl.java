package com.aisino2.basicsystem.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IClyjxxDao;
import com.aisino2.basicsystem.domain.Clyjxx;
import com.aisino2.basicsystem.service.IClyjxxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class ClyjxxServiceImpl extends BaseService implements IClyjxxService {

	private IClyjxxDao clyjxxDao;

	/** @param 车辆预警信息(t_clyjxx) 增加 superbWhere*/
	public Clyjxx insertClyjxx(Clyjxx clyjxx){
		// TODO: implement
		Map map = new HashMap();
		List checkClList = null;
		StringBuffer superbWhere = new StringBuffer();
		int isFirst = 0;
		String jcValue = clyjxx.getCph();
		if(jcValue!=null && !jcValue.equals("")){
			superbWhere.append(" cph='");
			superbWhere.append(jcValue);
			superbWhere.append("' ");
		
			map.put("superbWhere", superbWhere.toString());
			map.put("hylbdm", "F02");
			checkClList = clyjxxDao.checkClxxExist(map);
		}
		if(checkClList!=null && checkClList.size()>0){
			Clyjxx oneClyjxx = (Clyjxx)checkClList.get(0);
			clyjxx.setByjqyid(oneClyjxx.getByjqyid());//被预警企业id
			clyjxx.setByjclid(oneClyjxx.getByjclid());//被预警车辆id
			clyjxx.setByjclhylbbm(oneClyjxx.getByjclhylbbm());//被预警车辆行业类别编码
			clyjxx.setByjclhylb(oneClyjxx.getByjclhylb());//被预警车辆行业类别
			clyjxx.setYjsj(new Date());
			clyjxx = (Clyjxx)clyjxxDao.insertClyjxx(clyjxx);
		}
		return clyjxx;
	}
	
	/** @param 车辆预警信息(t_clyjxx) 增加 superbWhere
	 * 用于有自己的车辆表的行业
	 */
	public Clyjxx insertOtherClyjxx(Clyjxx clyjxx, Map paramsMap){
		if(paramsMap!=null){
			String czbz = (String)paramsMap.get("czbz");
			if(czbz!=null && czbz.equals("xg")){
				paramsMap.put("yjclhylbbm", clyjxx.getYjclhylbbm());
				paramsMap.put("cph", clyjxx.getCph());
				paramsMap.put("yjclid", clyjxx.getYjclid());
				Integer existNum = clyjxxDao.checkOtherYjxxExist(paramsMap);
				if(existNum==null || existNum.intValue()==0){
					insertClyjxx(clyjxx);
				}
			}else{
				insertClyjxx(clyjxx);
			}
		}else{
			insertClyjxx(clyjxx);
		}
		return clyjxx;
	}

	/** @param 车辆预警信息(t_clyjxx) 删除 */
	public boolean deleteClyjxx(Clyjxx clyjxx){
		// TODO: implement
		return clyjxxDao.deleteClyjxx(clyjxx)>0;
	}

	/** @param 车辆预警信息(t_clyjxx) 修改 */
	public boolean updateClyjxx(Clyjxx clyjxx){
		// TODO: implement
		return clyjxxDao.updateClyjxx(clyjxx)>0;
	}

	/** @param 车辆预警信息(t_clyjxx) 查询单条 */
	public Clyjxx getClyjxx(Clyjxx clyjxx){
		// TODO: implement
		return (Clyjxx)clyjxxDao.getClyjxx(clyjxx);
	}

	/** @param 车辆预警信息(t_clyjxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return clyjxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 车辆预警信息(t_clyjxx) 多条查询 */
	public List getListClyjxx(Clyjxx clyjxx){
		// TODO: implement
		return clyjxxDao.getListClyjxx(clyjxx);
	}

	public IClyjxxDao getClyjxxDao() {
		return clyjxxDao;
	}

	public void setClyjxxDao(IClyjxxDao clyjxxDao) {
		this.clyjxxDao = clyjxxDao;
	}
}
