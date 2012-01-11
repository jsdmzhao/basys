package com.aisino2.publicsystem.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyryxxhcDao;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Qyryxxhc;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IQyryxxhcService;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.service.IDepartmentService;

public class QyryxxhcServiceImpl extends BaseService implements IQyryxxhcService {

	private IQyryxxhcDao qyryxxhcDao;
	private IQyryxxService qyryxxService;
	private IQyjbxxService qyjbxxService;
	private IDepartmentService departmentService;

	/** @param 企业人员信息核查(t_qyryxxhc) 增加 */
	public Qyryxxhc insertQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		return (Qyryxxhc)qyryxxhcDao.insertQyryxxhc(qyryxxhc);
	}

	/** @param 企业人员信息核查(t_qyryxxhc) 删除 */
	public boolean deleteQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		return qyryxxhcDao.deleteQyryxxhc(qyryxxhc)>0;
	}

	/** @param 企业人员信息核查(t_qyryxxhc) 修改 */
	public boolean updateQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		boolean isSuccess = false;
		if(qyryxxhc != null)
		{
			qyryxxhc.setHczt("1");
			qyryxxhcDao.updateQyryxxhc(qyryxxhc);
		}
		
		isSuccess = true;
		return isSuccess;
	}

	/** @param 企业人员信息核查(t_qyryxxhc) 查询单条 */
	public Qyryxxhc getQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		return (Qyryxxhc)qyryxxhcDao.getQyryxxhc(qyryxxhc);
	}

	/** @param 企业人员信息核查(t_qyryxxhc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyryxxhcDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业人员信息核查(t_qyryxxhc) 多条查询 */
	public List getListQyryxxhc(Qyryxxhc qyryxxhc){
		// TODO: implement
		return qyryxxhcDao.getListQyryxxhc(qyryxxhc);
	}

	public IQyryxxhcDao getQyryxxhcDao() {
		return qyryxxhcDao;
	}

	public void setQyryxxhcDao(IQyryxxhcDao qyryxxhcDao) {
		this.qyryxxhcDao = qyryxxhcDao;
	}

	public Qyryxxhc insertQyryxxhcByRyid(Qyryxxhc qyryxxhc) {
		// TODO Auto-generated method stub
		
		
		Qyryxxhc qyryxxhcNew = new Qyryxxhc();
		Qyryxx qyryxx = new Qyryxx();
		Qyjbxx qyjbxx = new Qyjbxx();
		Department department = new Department();
		
		qyryxx.setRyid(qyryxxhc.getRyid());
		qyryxx = qyryxxService.getQyryxx(qyryxx);
		if(qyryxx!=null)
		{
			qyjbxx.setQyid(qyryxx.getQyid());
			qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);
			if(qyjbxx!=null)
			{
				try {
					BeanUtils.copyProperties(qyryxxhcNew,qyryxx);
					BeanUtils.copyProperties(qyryxxhcNew,qyjbxx);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					qyryxxhc =  null;
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					qyryxxhc =  null;
					e.printStackTrace();
				}
				qyryxxhcNew.setGarkktbsjid(qyryxxhc.getGarkktbsjid());
				qyryxxhcNew.setHcwt(qyryxxhc.getHcwt());
				qyryxxhcNew.setBdsj(new Date());
				qyryxxhcNew.setHczt("0");
				
				qyryxxhcNew.setGxdwdm(qyjbxx.getGxdwbm());
				qyryxxhcNew.setDsjgdm(com.aisino2.common.StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 4),12));
				department.setDepartcode(qyryxxhcNew.getDsjgdm());
				department = departmentService.getDepartment(department);
				if(department != null)
					qyryxxhcNew.setDsjgmc(department.getDepartname());
				
				qyryxxhcNew.setFxjdm(com.aisino2.common.StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 6),12));
				department.setDepartcode(qyryxxhcNew.getDsjgdm());
				department = departmentService.getDepartment(department);
				if(department != null)
					qyryxxhcNew.setFxjmc(department.getDepartname());
				
				qyryxxhc = insertQyryxxhc(qyryxxhcNew);
			}
			else
			{
				qyryxxhc =  null;
			}
		}
		else
		{
			qyryxxhc =  null;
		}
		return qyryxxhc;
	
	}

	public IQyryxxService getQyryxxService() {
		return qyryxxService;
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}

	public IQyjbxxService getQyjbxxService() {
		return qyjbxxService;
	}

	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	/** @param 企业人员信息核查(t_qyryxxhc) 未核查总数查询 */
	public int getDhcryCount(Map map){
		return qyryxxhcDao.getDhcryCount(map);
	}
}
