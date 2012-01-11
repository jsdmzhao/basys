package com.aisino2.icksystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.common.DateToString;
import com.aisino2.common.DepartmentUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIckrzjlDao;
import com.aisino2.icksystem.dao.IIckslDao;
import com.aisino2.icksystem.dao.IIcksl_ickzbDao;
import com.aisino2.icksystem.dao.IIcksl_wldjDao;
import com.aisino2.icksystem.dao.IIckslbgDao;
import com.aisino2.icksystem.dao.IWldjDao;
import com.aisino2.icksystem.domain.Ickrzjl;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.domain.Icksl_wldj;
import com.aisino2.icksystem.domain.Ickslbg;
import com.aisino2.icksystem.domain.Wldj;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.icksystem.service.IWldjService;
import com.aisino2.publicsystem.dao.IQyryxxDao;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.sysadmin.dao.IDepartmentDao;
import com.aisino2.sysadmin.domain.Department;


public class WldjServiceImpl extends BaseService implements IWldjService {

	private IWldjDao wldjDao;
	private IQyryxxDao qyryxxDao;
	private IIckslDao ickslDao;
	private IIcksl_wldjDao icksl_wldjDao;
	private IIckslbgDao ickslbgDao;
	private IIckrzjlDao ickrzjlDao;
	private IIcksl_ickzbDao icksl_ickzbDao;
	private IDepartmentDao departmentDao;
	private IIckslService ickslService;

	/** @param 物流登记信息(t_wldj) 增加 */
	public Wldj insertWldj(Wldj wldjOrigin) throws Exception{
		// TODO: implement
		//sreturn (Wldj)wldjDao.insertWldj(wldj);
		Wldj wldj = new Wldj();
		Icksl icksl = null;
		List icksl_wldjList = new ArrayList();
		List ickslList = new ArrayList();
		Icksl_wldj icksl_wldj = null;
		String cyrybhSet;//从业人员编号串
		String khSet;//卡号编号串
		Map map = new HashMap();
		DateToString dateToString = null;
		Date currentDate = new Date();
		String cjdbm = null;
		
		if(wldjOrigin != null)
		{
			cyrybhSet = wldjOrigin.getCyrybhSet();
			khSet = wldjOrigin.getKhSet();
			if(khSet != null)
			{
				if(!"".equals(khSet))
				{
					map.put("cyrybhSet", cyrybhSet);
					map.put("khSet", khSet);
					ickslList = ickslDao.getIckslByCyrybhAndKh(map);
				
					if(ickslList != null)
					{
						if(ickslList.size()>0)
						{
							Department department = new Department();
							
							//新增物流登记信息
							wldjOrigin.setZbsj(currentDate);
							wldjOrigin.setZtdm("0");
							wldjOrigin.setZtdmmc("物流已组包");
							wldjOrigin.setWlpc(dateToString.getDateTimeNoFormat20(currentDate));
							cjdbm=((Icksl)ickslList.get(0)).getCjdbm();
							if(cjdbm.indexOf("CJD")!=-1){//采集点采集
								wldjOrigin.setMbsldbh(((Icksl)ickslList.get(0)).getCjdbm());
								wldjOrigin.setMbsldmc(((Icksl)ickslList.get(0)).getCjdmc());
							}else{//企业端采集
								//若企业受理，则发送到所属地市第一个采集点
								cjdbm = "CJD"+cjdbm.substring(3,7);
								department = new Department();
								department.setIsCjd("1");
								department.setDeptCode(StringUtil.trimEven0(cjdbm));
								department.setLength(9);
								List departmentList = new ArrayList();
								departmentList = departmentDao.getListDepartment(department);
								if(departmentList!=null&&departmentList.size()>0)
								{
									department = (Department)departmentList.get(0);
									wldjOrigin.setMbsldbh(department.getDepartcode());
									wldjOrigin.setMbsldmc(department.getDepartname());
								}
							}
							
							wldjOrigin.setBnksl(ickslList.size());
							// wldjOrigin.setSzdsbm(StringUtil.add0(StringUtil.trimEven0(wldjOrigin.getMbsldbh().substring(3).length()>4?wldjOrigin.getMbsldbh().substring(3).substring(0, 4):wldjOrigin.getMbsldbh().substring(3)), 12));
							String deptCode = DepartmentUtil.doWithDepartmentCode(wldjOrigin.getMbsldbh());
							wldjOrigin.setSzdsbm(StringUtil.add0(StringUtil.trimEven0(deptCode), 12));
							
							department = new Department();
							department.setDepartcode(wldjOrigin.getSzdsbm());
							wldjOrigin.setSzds(departmentDao.getDepartment(department).getDepartname());
							/*if(wldjOrigin.getMbsldmc()==null || "".equals(wldjOrigin.getMbsldmc())){
								department.setDepartcode(cjdbm);
								wldjOrigin.setMbsldmc(departmentDao.getDepartment(department).getDepartname());
							}*/
							wldj = wldjDao.insertWldj(wldjOrigin);
							
							//增加IC卡受理物流登记信息及修改IC卡受理信息
							for(int i = 0;i<ickslList.size();i++)
							{
								icksl = new Icksl();
								icksl = (Icksl)ickslList.get(i);
								icksl.setZkztbs("20");
								icksl.setCzlx("IC卡物流组包");
								icksl.setCzr(wldj.getDjr());
								ickslService.updateIcksl(icksl);
								
								icksl_wldj = new Icksl_wldj();
								icksl_wldj.setIckslid(icksl.getIckslid());
								icksl_wldj.setWlid(wldj.getWlid());
								// IC卡物流组包
								icksl_wldj.setWlbzkztbs("20");
								// 更新t_icksl_wldj中的物流包制卡状态标识
								icksl_wldjDao.insertIcksl_wldj(icksl_wldj);
								
								icksl_wldj = null;
								icksl = null;
								
							}
						}
					}
					
				}
			}
		}
		return wldj;
	}

	/** @param 物流登记信息(t_wldj) 删除 */
	public boolean deleteWldj(Wldj wldj) throws Exception{
		// TODO: implement
		boolean isSuccess = false;
		//复位物流包中所有IC卡，删除IC卡受理物流登记
		wldj.setCzlx("IC卡物流包删除");
		deleteWldjCommon(wldj);
		wldjDao.deleteWldj(wldj);
		isSuccess = true;
		return isSuccess;
	}

	/** @param 物流登记信息(t_wldj) 修改 */
	public boolean updateWldj(Wldj wldj) throws Exception{
		// TODO: implement
		boolean isSuccess = false;
		
		List icksl_wldjList = new ArrayList();
		List ickslList = new ArrayList();
		Icksl_wldj icksl_wldj = null;
		Icksl icksl = null;
		String cyrybhSet;//从业人员编号串
		String khSet;//卡号编号串
		Map map = new HashMap();
		DateToString dateToString = null;
		Date currentDate = new Date();
		
		//复位物流包中所有IC卡，删除IC卡受理物流登记
		wldj.setCzlx("IC卡物流包修改");
		deleteWldjCommon(wldj);
		
		cyrybhSet = wldj.getCyrybhSet();
		khSet = wldj.getKhSet();
		if(khSet != null)
		{
			if(!"".equals(khSet))
			{
				map.put("cyrybhSet", cyrybhSet);
				map.put("khSet", khSet);
				ickslList = ickslDao.getIckslByCyrybhAndKh(map);
			
				if(ickslList != null)
				{
					if(ickslList.size()>0)
					{
						//增加IC卡受理物流登记信息及修改IC卡受理信息
						for(int i = 0;i<ickslList.size();i++)
						{
							icksl = new Icksl();
							icksl = (Icksl)ickslList.get(i);
							icksl.setZkztbs("20");
							icksl.setCzlx("IC卡物流组包");
							icksl.setCzr(wldj.getCzr());
							ickslService.updateIcksl(icksl);
							
							icksl_wldj = new Icksl_wldj();
							icksl_wldj.setIckslid(icksl.getIckslid());
							icksl_wldj.setWlid(wldj.getWlid());
							// IC卡物流组包
							icksl_wldj.setWlbzkztbs("20");
							// 更新t_icksl_wldj中的物流包制卡状态标识
							icksl_wldjDao.insertIcksl_wldj(icksl_wldj);
							
							icksl_wldj = null;
							icksl = null;
						}
						
						
					}
					//修改物流包内卡数量
					wldj.setBnksl(ickslList.size());
				}
				else
					wldj.setBnksl(0);
				wldjDao.updateWldj(wldj);
				
			}
		}
		isSuccess = true;
		return isSuccess;
		
	}
	
	/** @param 物流登记信息(t_wldj) 删除物流包时，包内IC卡复位及IC卡受理物流登记删除 公用服务*/
	public boolean deleteWldjCommon(Wldj wldj) throws Exception
	{
		boolean isSuccess = false;
		List ickslList = new ArrayList();
		Icksl icksl = null;
		Icksl_wldj icksl_wldj = new Icksl_wldj();
		Map map = new HashMap();
		//获得物流包内所有IC卡，复位为制卡状态标识=5
		map.put("wlid", wldj.getWlid());
		ickslList = ickslDao.getListIckslByWlid(map);
		
		
		
		//删除所有IC卡受理物流登记信息
		icksl_wldj.setWlid(wldj.getWlid());
		icksl_wldjDao.deleteIcksl_wldj(icksl_wldj);
		
		
		if(ickslList!=null)
		{
			for(int i = 0;i<ickslList.size();i++)
			{
				icksl = new Icksl();
				icksl = (Icksl)ickslList.get(i);
				icksl.setZkztbs("5");
				icksl.setCzlx(wldj.getCzlx());
				icksl.setCzr(wldj.getCzr());
				ickslService.updateIcksl(icksl);
				icksl = null;
			}
		}
		
		
		isSuccess = true;
		return isSuccess;
	}
	
	/** 物流发送 */
	public boolean updateWldjWlfs(Wldj wldj) throws Exception
	{
		boolean isSuccess = false;
		Date currentDate = new Date();
		List ickslList = new ArrayList();
		Icksl icksl = null;
		Icksl_wldj icksl_wldj = new Icksl_wldj();
		Map map = new HashMap();
		//获得物流包内所有IC卡，置位制卡状态标识=23
		map.put("wlid", wldj.getWlid());
		ickslList = ickslDao.getListIckslByWlid(map);
		if(ickslList!=null)
		{
			for(int i = 0;i<ickslList.size();i++)
			{
				icksl = new Icksl();
				icksl = (Icksl)ickslList.get(i);
				icksl.setZkztbs("23");
				icksl.setCzlx("IC卡物流包发送");
				icksl.setCzr(wldj.getFsr());
				ickslService.updateIcksl(icksl);
				icksl = null;
			}
		}
		//修改物流登记信息
		wldj.setZtdm("1");
		wldj.setZtdmmc("物流包已发送");
		wldj.setFssj(currentDate);
		wldjDao.updateWldj(wldj);
		// IC卡物流包发送
		icksl_wldj.setWlid(wldj.getWlid());
		icksl_wldj.setWlbzkztbs("23");
		// 更新t_icksl_wldj中的物流包制卡状态标识
		icksl_wldjDao.updateIcksl_wldj(icksl_wldj);
		isSuccess = true;
		return isSuccess;
	}
	

	/**  物流接收*/
	public boolean updateWldjWljs(Wldj wldjOrigin) throws Exception
	{
		boolean isSuccess = false;
		int bnksl = 0;//物流包内卡数量
		int bcqrsksl = 0;//本次确认刷卡数量
		int yjssl = 0;//物流包内已被接收的卡数量
		String cyrybhSet;//从业人员编号串
		String khSet;//卡号编号串
		
		
		Wldj wldj = new Wldj();
		String cyrybh;
		String[] cyrybhArr;
		String kh;
		String[] khArr;
		Map map = new HashMap();
		List<Icksl> ickslList = new ArrayList<Icksl>();
		Qyryxx cyryxx = null;
		Icksl icksl = null;
		Icksl icksl_bak = null;
		Icksl_wldj icksl_wldj = null;
		Icksl_ickzb icksl_ickzb = null;
		Ickslbg ickslbg = null;
		Ickrzjl ickrzjl = null;
		List yjsIclslList = new ArrayList();
		
		
		if(wldjOrigin != null)
		{
			wldj.setWlid(wldjOrigin.getWlid());
			wldj = wldjDao.getWldj(wldj);
			cyrybhSet = wldjOrigin.getCyrybhSet();
			khSet = wldjOrigin.getKhSet();
			bnksl = wldj.getBnksl();
			bcqrsksl = wldjOrigin.getBcqrsksl();
			
			//查询该物流包内已接收的IC卡数量
			map.put("wlid", wldj.getWlid());
			yjsIclslList = ickslDao.getYjsIckslListInWldj(map);
			if(yjsIclslList == null)
				yjssl = 0;
			else
				yjssl = yjsIclslList.size();
			//物流包状态 1-物流包已发送,2-部分接收,4-物流包接收不成功
			if(wldj.getZtdm().equals("1")||wldj.getZtdm().equals("2")||wldj.getZtdm().equals("4"))
			{
				//物流登记信息 物流包接收
				if( bcqrsksl+yjssl==bnksl)
				{
					wldj.setZtdm("3");
					wldj.setZtdmmc("物流包已接收");
				}
				else if(bcqrsksl+yjssl>0 && bcqrsksl+yjssl<bnksl)
				{
					wldj.setZtdm("2");
					wldj.setZtdmmc("部分接收");
				}
				else
				{
					wldj.setZtdm("4");
					wldj.setZtdmmc("物流包接收不成功");
				}
				wldj.setJssj(new Date());
				wldj.setJsr(wldjOrigin.getJsr());
				wldjDao.updateWldj(wldj);
				
				//物流包内卡接收。物流包接收成功或部分接收时进行
				//wldj = wldjDao.getWldj(wldj);
				if(wldj.getZtdm().equals("2")||wldj.getZtdm().equals("3"))
				{
					if(cyrybhSet != null)
					{
						if(!cyrybhSet.equals(""))
						{
							//由从业人员编号及物流Id获得IC卡受理信息
							map.put("cyrybhSet", cyrybhSet);
							map.put("khSet", khSet);
							//map.put("wlid", wldj.getWlid());
							ickslList = ickslDao.getListIckslByCyrybhAndWlid(map);
							if(ickslList != null)
							{
								for(int i = 0;i<ickslList.size();i++)
								{
									cyryxx = new Qyryxx();
									icksl = new Icksl();
									icksl_bak = new Icksl();
									icksl_wldj = new Icksl_wldj();
									icksl_ickzb = new Icksl_ickzb();
									ickslbg = new Ickslbg();
									ickrzjl = new Ickrzjl();
									
									
									icksl = (Icksl)ickslList.get(i);
									//保存IC卡历史信息
									icksl_bak.setIckslid(icksl.getIckslid());
									icksl_bak = ickslDao.getIcksl(icksl_bak);
									icksl_wldj.setIckslid(icksl.getIckslid());
									icksl_ickzb.setIckslid(icksl.getIckslid());
									// 设定物流ID
									icksl_wldj.setWlid(wldjOrigin.getWlid());
									icksl_wldj = icksl_wldjDao.getIcksl_wldj(icksl_wldj);
									icksl_ickzb = icksl_ickzbDao.getIcksl_ickzb(icksl_ickzb);
									//wldj.setWlid(icksl_wldj.getWlid());
									//wldj = wldjDao.getWldj(wldj);
									if(icksl_bak!=null)
										BeanUtils.copyProperties(ickslbg, icksl_bak);
									if(icksl_wldj != null){
										ickslbg.setWlid(icksl_wldj.getWlid());
										// IC卡接收
										icksl_wldj.setWlbzkztbs("24");
										// 更新t_icksl_wldj中的物流包制卡状态标识
										icksl_wldjDao.updateIcksl_wldj(icksl_wldj);
									}
									if(icksl_ickzb != null)
										ickslbg.setZbid(icksl_ickzb.getZbid());
									ickslbgDao.insertIckslbg(ickslbg);
									//修改IC卡受理信息 IC卡接收
									icksl.setJssj(new Date());
									icksl.setJsbmc(wldj.getWlpc());
									icksl.setZkztbs("24");
									ickslDao.updateIcksl(icksl);
									//IC卡日志记录
									cyryxx.setRyid(icksl.getRyid());
									cyryxx = qyryxxDao.getQyryxx(cyryxx);
									ickrzjl.setPch(wldj.getWlpc());
									ickrzjl.setCyrybh(cyryxx.getCyrybh());
									ickrzjl.setCzlb("IC卡接收");
									ickrzjl.setCzyy("IC卡接收");
									ickrzjl.setCzr(wldj.getJsr());
									ickrzjl.setCzsj(new Date());
									ickrzjlDao.insertIckrzjl(ickrzjl);
									
									cyryxx = null;
									icksl = null;
									icksl_bak = null;
									icksl_wldj = null;
									icksl_ickzb = null;
									ickslbg = null;
									ickrzjl = null;
									
								}
							}
						}
					}
						
				}
				isSuccess = true;
			}
		}
		
		
		return isSuccess;
	}
	
	/**  物流反馈*/
	public boolean updateWldjWlfk(Wldj wldjOrigin) throws Exception
	{
		boolean isSuccess = false;
		
		Map map = new HashMap();
		List<Icksl> ickslList = new ArrayList<Icksl>();
		Qyryxx cyryxx = null;
		Icksl icksl = null;
		Icksl icksl_bak = null;
		Icksl_wldj icksl_wldj = null;
		Ickslbg ickslbg = null;
		Ickrzjl ickrzjl = null;
		Icksl_ickzb icksl_ickzb = null;
		Wldj wldj = new Wldj();
		
		if(wldjOrigin != null)
		{
			wldj.setWlid(wldjOrigin.getWlid());
			wldj = wldjDao.getWldj(wldj);
			//物流包已发送或物流包已被接收过 1-物流包已发送 2-部分接收 3-物流包接收成功 4-物流包接收不成功
			if(wldj.getZtdm().equals("1")||wldj.getZtdm().equals("2")||wldj.getZtdm().equals("3")||wldj.getZtdm().equals("4"))
			{
				//若物流包未接受（已发送）、部分接收或接收不成功，则更新IC卡受理信息，则制卡状态置为：25-IC卡接收不成功
				if(!wldj.getZtdm().equals("3"))
				{
					//由物流Id获得IC卡受理信息
					map.put("wlid", wldj.getWlid());
					ickslList = ickslDao.getListIckslByWlid(map);
					if(ickslList != null)
					{
						for(int i = 0;i<ickslList.size();i++)
						{
							icksl = new Icksl();

							
							icksl = (Icksl)ickslList.get(i);
							//若IC卡未接收，则制卡状态置为：25-IC卡接收不成功
							if(!icksl.getZkztbs().equals("24"))
							{
								cyryxx = new Qyryxx();
								icksl_bak = new Icksl();
								icksl_wldj = new Icksl_wldj();
								ickslbg = new Ickslbg();
								ickrzjl = new Ickrzjl();
								icksl_ickzb = new Icksl_ickzb();
								//保存IC卡历史信息
								icksl_bak.setIckslid(icksl.getIckslid());
								icksl_bak = ickslDao.getIcksl(icksl_bak);
								icksl_wldj.setIckslid(icksl.getIckslid());
								icksl_ickzb.setIckslid(icksl.getIckslid());
								// 设定物流ID
								icksl_wldj.setWlid(wldjOrigin.getWlid());
								icksl_wldj = icksl_wldjDao.getIcksl_wldj(icksl_wldj);
								icksl_ickzb = icksl_ickzbDao.getIcksl_ickzb(icksl_ickzb);
								//wldj.setWlid(icksl_wldj.getWlid());
								//wldj = wldjDao.getWldj(wldj);
								if(icksl_bak!=null)
									BeanUtils.copyProperties(ickslbg, icksl_bak);
								if(icksl_wldj != null){
									ickslbg.setWlid(icksl_wldj.getWlid());
									// IC卡接收不成功
									icksl_wldj.setWlbzkztbs("25");
									// 更新t_icksl_wldj中的物流包制卡状态标识
									icksl_wldjDao.updateIcksl_wldj(icksl_wldj);
								}
								if(icksl_ickzb != null)
									ickslbg.setZbid(icksl_ickzb.getZbid());
								ickslbgDao.insertIckslbg(ickslbg);
								//修改IC卡受理信息 IC卡接收不成功置标
								icksl.setZkztbs("25");
								ickslDao.updateIcksl(icksl);
								//IC卡日志记录
								cyryxx.setRyid(icksl.getRyid());
								cyryxx = qyryxxDao.getQyryxx(cyryxx);
								ickrzjl.setPch(wldj.getWlpc());
								ickrzjl.setCyrybh(cyryxx.getCyrybh());
								ickrzjl.setCzlb("IC卡接收不成功物流包反馈");
								ickrzjl.setCzyy("IC卡接收不成功物流包反馈");
								ickrzjl.setCzr(wldj.getCzr());
								ickrzjl.setCzsj(new Date());
								ickrzjlDao.insertIckrzjl(ickrzjl);
								
								cyryxx = null;
								icksl_bak = null;
								icksl_wldj = null;
								ickslbg = null;
								ickrzjl = null;
								icksl_ickzb = null;
							}
							icksl = null;
						}
					}
				}
				if(wldj.getZtdm().equals("1"))//若物流状态为物流包已发送时进行反馈，则反馈后物流包状态置为物流包接收不成功
				{
					wldj.setZtdm("4");
					wldj.setZtdmmc("物流包接收不成功");
				}
				wldj.setWlgs(wldjOrigin.getWlgs());//物流公司
				wldj.setYdh(wldjOrigin.getYdh());//运单号
				wldj.setFkxx(wldjOrigin.getFkxx());
				wldj.setFksj(new Date());
				wldjDao.updateWldj(wldj);
			}
		}
		
		isSuccess = true;
		return isSuccess;
	}

	/** @param 物流登记信息(t_wldj) 查询单条 */
	public Wldj getWldj(Wldj wldj){
		// TODO: implement
		return (Wldj)wldjDao.getWldj(wldj);
	}

	/** @param 物流登记信息(t_wldj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wldjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 物流登记信息(t_wldj) 分页查询 制卡端*/
	public Page getListZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wldjDao.getListZkdForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 物流登记信息(t_wldj) 分页查询 制卡端台账*/
	public Page getListZkdTzForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wldjDao.getListZkdTzForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 物流登记信息(t_wldj) 多条查询 */
	public List getListWldj(Wldj wldj){
		// TODO: implement
		return wldjDao.getListWldj(wldj);
	}

	public IWldjDao getWldjDao() {
		return wldjDao;
	}

	public void setWldjDao(IWldjDao wldjDao) {
		this.wldjDao = wldjDao;
	}

	public IQyryxxDao getQyryxxDao() {
		return qyryxxDao;
	}

	public void setQyryxxDao(IQyryxxDao qyryxxDao) {
		this.qyryxxDao = qyryxxDao;
	}

	public IIckslDao getIckslDao() {
		return ickslDao;
	}

	public void setIckslDao(IIckslDao ickslDao) {
		this.ickslDao = ickslDao;
	}

	public IIcksl_wldjDao getIcksl_wldjDao() {
		return icksl_wldjDao;
	}

	public void setIcksl_wldjDao(IIcksl_wldjDao icksl_wldjDao) {
		this.icksl_wldjDao = icksl_wldjDao;
	}

	public IIckslbgDao getIckslbgDao() {
		return ickslbgDao;
	}

	public void setIckslbgDao(IIckslbgDao ickslbgDao) {
		this.ickslbgDao = ickslbgDao;
	}

	public IIckrzjlDao getIckrzjlDao() {
		return ickrzjlDao;
	}

	public void setIckrzjlDao(IIckrzjlDao ickrzjlDao) {
		this.ickrzjlDao = ickrzjlDao;
	}

	public IIcksl_ickzbDao getIcksl_ickzbDao() {
		return icksl_ickzbDao;
	}

	public void setIcksl_ickzbDao(IIcksl_ickzbDao icksl_ickzbDao) {
		this.icksl_ickzbDao = icksl_ickzbDao;
	}

	public IDepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(IDepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public IIckslService getIckslService() {
		return ickslService;
	}

	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}
}
