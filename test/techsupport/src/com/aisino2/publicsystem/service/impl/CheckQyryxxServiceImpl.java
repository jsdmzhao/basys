package com.aisino2.publicsystem.service.impl;

import java.text.DateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.basicsystem.domain.Gabrkxx;
import com.aisino2.basicsystem.service.IGabRkhcService;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyryxxDao;
import com.aisino2.publicsystem.domain.Garkktbsj;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Qyryxxhc;
import com.aisino2.publicsystem.service.ICheckQyryxxService;
import com.aisino2.publicsystem.service.IGarkktbsjService;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IQyryxxhcService;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IGlobalparService;

public class CheckQyryxxServiceImpl extends BaseService implements ICheckQyryxxService {

	private IQyryxxDao qyryxxDao;
	private IQyryxxService qyryxxService;
	private IGabRkhcService gabRkhcService;
	private IQyryxxhcService qyryxxhcService;
	private IGarkktbsjService garkktbsjService;
	private IQyjbxxService qyjbxxService;
	private IDepartmentService departmentService;
	private IGlobalparService globalparService;
	
	/** @param 公安人口库比对程序  更新从业人员状态及制卡状态，且比对错误信息插入t_garkktbsj表及t_cyryxxhc表*/
	public boolean updateCheckCyryxx(Qyryxx qyryxx) throws Exception
	{
		boolean isSuccess = false;
		// 1：查询到此人信息且姓名与身份证相符 2：姓名与身份证号不符 0：查无此人
		int hcFlag = 0;
		Gabrkxx gabrkxx = new Gabrkxx();
		hcFlag = gabRkhcService.hcFlag(qyryxx.getZjhm(), qyryxx.getXm());
		gabrkxx = gabRkhcService.getGabrkxx();
		/*//webservice无法调用时的测试数据,可代替上面两个语句
		//hcFlag = 0;//查无此人
		//hcFlag = 1;//姓名相符
		hcFlag = 2;//姓名不符
		//姓名不符时从公安人口库得到的数据
		gabrkxx.setChushengriqi("1988-01-02");
		gabrkxx.setMinzu("02");
		gabrkxx.setXingbie("0");
		gabrkxx.setXingming("测试比对人姓名不符");
		gabrkxx.setZhuzhi("北京市海淀区姓名不符");*/
		if(hcFlag==1)
			updateFindCorrectRecord(qyryxx);
		else 
			updateFindUncorrectRecord(qyryxx,gabrkxx,hcFlag);
		isSuccess = true;
		return isSuccess;
	}
	
	/**
	 * 与公安人口库比对，返回姓名相符记录时，对人员状态和制卡状态置位
	 * @param qyryxx
	 */
	public void updateFindCorrectRecord(Qyryxx qyryxx) throws Exception
	{
		
		//从业人员状态-已核对
		qyryxx.setZt("1");
		qyryxx.setCzlx("与公安人口库比对");
		qyryxx.setCzr("公安人口库比对程序");
		qyryxxService.updateQyryxxOnly(qyryxx);
	}
	
	/**
	 * 关掉比对开关时，将人员自动置为已核对
	 * @param qyryxx
	 */
	public void updateFindRecord(Qyryxx qyryxx) throws Exception
	{
		
		//从业人员状态-已核对
		qyryxx.setZt("1");
		qyryxx.setCzlx("无需与人口库比对时自动置标");
		qyryxx.setCzr("公安人口库比对程序");
		qyryxxService.updateQyryxxOnly(qyryxx);
	}
	/**
	 * 与公安人口库比对，返回姓名不相符记录或空记录(查无此人)时对人员状态和制卡状态置位，并插入t_garkktbsj和t_qyryxxhc
	 * @param qyryxx
	 * @param gabrkxx 从公安人口库返回的人员信息
	 * @param hcFlag 与公安人口库比对后的标志 0-未找到此人，1-姓名相符，2-姓名不符，-1-web服务内部错误，-2-没有权限访问wb服务
	 * @throws Exception 
	 */
	public void updateFindUncorrectRecord(Qyryxx qyryxx,Gabrkxx gabrkxx,int hcFlag) throws Exception
	{
		//查询出该从业人员的详细信息
		Qyryxx qyryxxNew = new Qyryxx();
		qyryxxNew.setRyid(qyryxx.getRyid());
		qyryxxNew = qyryxxService.getQyryxx(qyryxxNew);
		Date currentDate = new Date();
		Department department = new Department();
		Qyjbxx qyjbxx = new Qyjbxx();
		Qyryxxhc  qyryxxhc = new Qyryxxhc();
		Garkktbsj garkktbsj = new Garkktbsj();
		//从业人员状态置位
		String zt = "";
		if(!"5".equals(qyryxxNew.getZt()))//证件号码错时，无需修改人员状态
		{
			//若比对服务出现错误，则将未核对人员(0)置为待修改(2)。20090821 暂时注释，是否要修改成这样，需与开发经理确认
			/*if(hcFlag==-1||hcFlag==-2)
			{
				if("0".equals(qyryxxNew.getZt()))
					zt = "2";
			}*/
			if("7".equals(qyryxxNew.getZt()))
				zt = "4";
			else if("6".equals(qyryxxNew.getZt()))
				zt = "2";
			qyryxx.setZt(zt);
			qyryxx.setCzlx("与公安人口库比对");
			qyryxx.setCzr("公安人口库比对程序");
			qyryxxService.updateQyryxxOnly(qyryxx);
		}
		//若为二次核对错，则写入从业人员核查预警表
		if("7".equals(qyryxxNew.getZt()))
		{
			qyjbxx.setQyid(qyryxxNew.getQyid());
			qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);
			//插入公安人口库同步数据
			if(hcFlag == 2)	//姓名不符。若查无此人，则在该表中插入一条只有主键的数据
			{
				garkktbsj.setGmsfzhm(qyryxxNew.getZjhm());
				garkktbsj.setXm(gabrkxx.getXingming());
				garkktbsj.setXb(gabrkxx.getXingbie());
				garkktbsj.setMz(gabrkxx.getMinzu());
				//garkktbsj.setHyzk("");
				garkktbsj.setHjsx(gabrkxx.getJiguanssx());
				garkktbsj.setHjdxz(gabrkxx.getZhuzhi());
				garkktbsj.setCsrq(DateFormat.getDateInstance().parse(gabrkxx.getChushengriqi()));
				garkktbsj.setZp(gabrkxx.getZhaopian());
			}
			garkktbsj = garkktbsjService.insertGarkktbsj(garkktbsj);
			//插入从业人员核查信息
			qyryxxhc.setGarkktbsjid(garkktbsj.getGarkktbsjid());
			if(hcFlag == 2)
				qyryxxhc.setHcwt("姓名不符");
			else if(hcFlag==0)
				qyryxxhc.setHcwt("未找到此人");
			qyryxxhc.setBdsj(currentDate);
			qyryxxhc.setHczt("0");//未核查
			if(qyryxxNew != null)
				BeanUtils.copyProperties(qyryxxhc,qyryxxNew);
			if(qyjbxx != null)
			{
				BeanUtils.copyProperties(qyryxxhc,qyjbxx);
				qyryxxhc.setGxdwdm(qyjbxx.getGxdwbm());
			}
			if(qyjbxx != null)
			{
				if(!qyjbxx.getGxdwbm().substring(0, 2).equals("11")
						&&!qyjbxx.getGxdwbm().substring(0, 2).equals("12")
						&&!qyjbxx.getGxdwbm().substring(0, 2).equals("31")
						&&!qyjbxx.getGxdwbm().substring(0, 2).equals("50"))
					qyryxxhc.setDsjgdm(com.aisino2.common.StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 4),12));
				else
					qyryxxhc.setDsjgdm(com.aisino2.common.StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 2),12));
				department.setDepartcode(qyryxxhc.getDsjgdm());
				department = departmentService.getDepartment(department);
				if(department != null)
					qyryxxhc.setDsjgmc(department.getDepartname());
				
				qyryxxhc.setFxjdm(com.aisino2.common.StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 6),12));
				department = null;
				department = new Department();
				department.setDepartcode(qyryxxhc.getDsjgdm());
				department = departmentService.getDepartment(department);
				if(department != null)
					qyryxxhc.setFxjmc(department.getDepartname());
				
			}
			qyryxxhc.setHcr("");
			qyryxxhc.setHcdw("");
			qyryxxhcService.insertQyryxxhc(qyryxxhc);
		}
		
		
	}

	public IQyryxxDao getQyryxxDao() {
		return qyryxxDao;
	}

	public void setQyryxxDao(IQyryxxDao qyryxxDao) {
		this.qyryxxDao = qyryxxDao;
	}

	public IQyryxxService getQyryxxService() {
		return qyryxxService;
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}

	public IGabRkhcService getGabRkhcService() {
		return gabRkhcService;
	}

	public void setGabRkhcService(IGabRkhcService gabRkhcService) {
		this.gabRkhcService = gabRkhcService;
	}

	public IQyryxxhcService getQyryxxhcService() {
		return qyryxxhcService;
	}

	public void setQyryxxhcService(IQyryxxhcService qyryxxhcService) {
		this.qyryxxhcService = qyryxxhcService;
	}

	public IGarkktbsjService getGarkktbsjService() {
		return garkktbsjService;
	}

	public void setGarkktbsjService(IGarkktbsjService garkktbsjService) {
		this.garkktbsjService = garkktbsjService;
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

	public IGlobalparService getGlobalparService() {
		return globalparService;
	}

	public void setGlobalparService(IGlobalparService globalparService) {
		this.globalparService = globalparService;
	}
}
