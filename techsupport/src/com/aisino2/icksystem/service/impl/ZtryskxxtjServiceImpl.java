package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IZtryskxxtjDao;
import com.aisino2.icksystem.domain.Ztryskxxtj;
import com.aisino2.icksystem.service.IZtryskxxtjService;

public class ZtryskxxtjServiceImpl extends BaseService implements IZtryskxxtjService {

	private IZtryskxxtjDao ztryskxxtjDao;

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 增加 */
	public Ztryskxxtj insertZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		return (Ztryskxxtj)ztryskxxtjDao.insertZtryskxxtj(ztryskxxtj);
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 删除 */
	public boolean deleteZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		return ztryskxxtjDao.deleteZtryskxxtj(ztryskxxtj)>0;
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 修改 */
	public boolean updateZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		return ztryskxxtjDao.updateZtryskxxtj(ztryskxxtj)>0;
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 查询单条 */
	public Ztryskxxtj getZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		return (Ztryskxxtj)ztryskxxtjDao.getZtryskxxtj(ztryskxxtj);
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return ztryskxxtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 走台人员刷卡信息统计明细(t_ztryskxxtj) 多条查询 */
	public List getListZtryskxxtj(Ztryskxxtj ztryskxxtj){
		// TODO: implement
		return ztryskxxtjDao.getListZtryskxxtj(ztryskxxtj);
	}

	public IZtryskxxtjDao getZtryskxxtjDao() {
		return ztryskxxtjDao;
	}

	public void setZtryskxxtjDao(IZtryskxxtjDao ztryskxxtjDao) {
		this.ztryskxxtjDao = ztryskxxtjDao;
	}
}
