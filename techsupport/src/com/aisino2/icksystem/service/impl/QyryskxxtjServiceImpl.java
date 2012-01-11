package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IQyryskxxtjDao;
import com.aisino2.icksystem.domain.Qyryskxxtj;
import com.aisino2.icksystem.service.IQyryskxxtjService;

public class QyryskxxtjServiceImpl extends BaseService implements IQyryskxxtjService {

	private IQyryskxxtjDao qyryskxxtjDao;

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 增加 */
	public Qyryskxxtj insertQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		return (Qyryskxxtj)qyryskxxtjDao.insertQyryskxxtj(qyryskxxtj);
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 删除 */
	public boolean deleteQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		return qyryskxxtjDao.deleteQyryskxxtj(qyryskxxtj)>0;
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 修改 */
	public boolean updateQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		return qyryskxxtjDao.updateQyryskxxtj(qyryskxxtj)>0;
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 查询单条 */
	public Qyryskxxtj getQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		return (Qyryskxxtj)qyryskxxtjDao.getQyryskxxtj(qyryskxxtj);
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyryskxxtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 多条查询 */
	public List getListQyryskxxtj(Qyryskxxtj qyryskxxtj){
		// TODO: implement
		return qyryskxxtjDao.getListQyryskxxtj(qyryskxxtj);
	}
	
	/** @param 刷卡信息统计明细(t_qyryskxxtj) 分页查询  公安端 从业轨迹查询*/
	public Page getCygjForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryskxxtjDao.getCygjForPage(map, pageNo, pageSize, sort, desc);
	}

	public IQyryskxxtjDao getQyryskxxtjDao() {
		return qyryskxxtjDao;
	}

	public void setQyryskxxtjDao(IQyryskxxtjDao qyryskxxtjDao) {
		this.qyryskxxtjDao = qyryskxxtjDao;
	}

	public Page getStatistics(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		return qyryskxxtjDao.getStatistics(map, pageNo, pageSize, sort, desc);
	}
	/** @param 从业人员信息(t_qyryskxxtj) 分页查询  公安端 频繁变换场所统计查询*/
	public Page getPfbhcsForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		return qyryskxxtjDao.getPfbhcsForPage(map, pageNo, pageSize, sort, desc);
	}

}
