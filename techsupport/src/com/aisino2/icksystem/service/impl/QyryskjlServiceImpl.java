package com.aisino2.icksystem.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IQyryskjlDao;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Qyryskjl;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.icksystem.service.IQyryskjlService;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.service.IQyjbxxService;

public class QyryskjlServiceImpl extends BaseService implements IQyryskjlService {

	private IQyryskjlDao qyryskjlDao;
	private IIckslService ickslService;
	private IQyjbxxService qyjbxxService;

	/** @param 企业人员刷卡记录(t_qyryskjl) 增加 */
	public Qyryskjl insertQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		return (Qyryskjl)qyryskjlDao.insertQyryskjl(qyryskjl);
	}
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 增加 用于手动输入卡号、从业人员编号或证件号码*/
	public Qyryskjl insertQyryskjlSdsr(Icksl icksl)
	{
		Qyryskjl qyryskjl = null;
		Icksl ickslNew = new Icksl();
		//qyid应为登录用户的qyid，而非刷卡人员所在企业
		Qyjbxx qyjbxx = new Qyjbxx();
		qyjbxx.setQybm(icksl.getQybm());
		qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);
		ickslNew = ickslService.getValidIcksl(icksl);
		if(ickslNew!=null){
			qyryskjl = new Qyryskjl();
			Date currentDate = new Date();
			qyryskjl.setQyid(qyjbxx.getQyid());
			qyryskjl.setQybm(qyjbxx.getQybm());
			qyryskjl.setSksj(currentDate);
			qyryskjl.setScsj(currentDate);
			qyryskjl.setKh(ickslNew.getKh());
			qyryskjl.setCyrybh(ickslNew.getCyrybh());
			qyryskjl = qyryskjlDao.insertQyryskjl(qyryskjl);
		}
		return qyryskjl;
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 删除 */
	public boolean deleteQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		return qyryskjlDao.deleteQyryskjl(qyryskjl)>0;
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 修改 */
	public boolean updateQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		return qyryskjlDao.updateQyryskjl(qyryskjl)>0;
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 查询单条 */
	public Qyryskjl getQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		return (Qyryskjl)qyryskjlDao.getQyryskjl(qyryskjl);
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询  企业端人员工作日志*/
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyryskjlDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 公安端企业刷卡记录查询*/
	public Page getQyryskjlGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryskjlDao.getQyryskjlGadForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 公安端从业人员工作日志*/
	public Page getCyrygzrzForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryskjlDao.getCyrygzrzForPage(map, pageNo, pageSize, sort, desc);
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 多条查询 */
	public List getListQyryskjl(Qyryskjl qyryskjl){
		// TODO: implement
		return qyryskjlDao.getListQyryskjl(qyryskjl);
	}
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 频繁刷卡*/
	public Page getPfskForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryskjlDao.getPfskForPage(map, pageNo, pageSize, sort, desc);
	}

	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 频繁刷卡轨迹*/
	public Page getPfskGjForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryskjlDao.getPfskGjForPage(map, pageNo, pageSize, sort, desc);
	}
	
	public IQyryskjlDao getQyryskjlDao() {
		return qyryskjlDao;
	}

	public void setQyryskjlDao(IQyryskjlDao qyryskjlDao) {
		this.qyryskjlDao = qyryskjlDao;
	}

	public IIckslService getIckslService() {
		return ickslService;
	}

	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}

	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}

	public IQyjbxxService getQyjbxxService() {
		return qyjbxxService;
	}
}
