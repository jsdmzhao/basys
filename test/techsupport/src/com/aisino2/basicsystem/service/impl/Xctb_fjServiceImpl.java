package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IXctb_fjDao;
import com.aisino2.basicsystem.domain.Xctb_fj;
import com.aisino2.basicsystem.service.IXctb_fjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class Xctb_fjServiceImpl extends BaseService implements IXctb_fjService {

	private IXctb_fjDao xctb_fjDao;

	/** @param 协查通报_附件(t_xctb_fj) 增加 */
	public Xctb_fj insertXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		return (Xctb_fj)xctb_fjDao.insertXctb_fj(xctb_fj);
	}

	/** @param 协查通报_附件(t_xctb_fj) 删除 */
	public boolean deleteXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		return xctb_fjDao.deleteXctb_fj(xctb_fj)>0;
	}

	/** @param 协查通报_附件(t_xctb_fj) 修改 */
	public boolean updateXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		return xctb_fjDao.updateXctb_fj(xctb_fj)>0;
	}

	/** @param 协查通报_附件(t_xctb_fj) 查询单条 */
	public Xctb_fj getXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		return (Xctb_fj)xctb_fjDao.getXctb_fj(xctb_fj);
	}

	/** @param 协查通报_附件(t_xctb_fj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return xctb_fjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 协查通报_附件(t_xctb_fj) 多条查询 */
	public List getListXctb_fj(Xctb_fj xctb_fj){
		// TODO: implement
		return xctb_fjDao.getListXctb_fj(xctb_fj);
	}

	public IXctb_fjDao getXctb_fjDao() {
		return xctb_fjDao;
	}

	public void setXctb_fjDao(IXctb_fjDao xctb_fjDao) {
		this.xctb_fjDao = xctb_fjDao;
	}
}
