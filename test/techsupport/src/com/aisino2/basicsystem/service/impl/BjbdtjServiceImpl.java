package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBjbdtjDao;
import com.aisino2.basicsystem.domain.Bjbdtj;
import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.basicsystem.service.IBjbdtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BjbdtjServiceImpl extends BaseService implements IBjbdtjService {

	private IBjbdtjDao bjbdtjDao;

	/** @param 报警比对条件(t_bjbdtj) 增加 */
	public Bjbdtj insertBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		return (Bjbdtj)bjbdtjDao.insertBjbdtj(bjbdtj);
	}

	/** @param 报警比对条件(t_bjbdtj) 删除 */
	public boolean deleteBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		return bjbdtjDao.deleteBjbdtj(bjbdtj)>0;
	}

	/** @param 报警比对条件(t_bjbdtj) 修改 */
	public boolean updateBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		return bjbdtjDao.updateBjbdtj(bjbdtj)>0;
	}

	/** @param 报警比对条件(t_bjbdtj) 查询单条 */
	public Bjbdtj getBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		return (Bjbdtj)bjbdtjDao.getBjbdtj(bjbdtj);
	}
	
	/**通过比对规则获取比对条件*/
	public String getBjbdtjSql(Bjgz bjgz,Bjxxb bjxxbIn)
	{
		return bjbdtjDao.getBjbdtjSql(bjgz,bjxxbIn);
	}

	/** @param 报警比对条件(t_bjbdtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bjbdtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 报警比对条件(t_bjbdtj) 多条查询 */
	public List getListBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		return bjbdtjDao.getListBjbdtj(bjbdtj);
	}

	public IBjbdtjDao getBjbdtjDao() {
		return bjbdtjDao;
	}

	public void setBjbdtjDao(IBjbdtjDao bjbdtjDao) {
		this.bjbdtjDao = bjbdtjDao;
	}
}
