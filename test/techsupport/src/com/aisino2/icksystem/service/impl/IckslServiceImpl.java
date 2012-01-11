package com.aisino2.icksystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.common.QjblUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIckrzjlDao;
import com.aisino2.icksystem.dao.IIckslDao;
import com.aisino2.icksystem.dao.IIcksl_ickzbDao;
import com.aisino2.icksystem.dao.IIcksl_wldjDao;
import com.aisino2.icksystem.dao.IIckslbgDao;
import com.aisino2.icksystem.dao.IIckzbDao;
import com.aisino2.icksystem.dao.IWldjDao;
import com.aisino2.icksystem.domain.Ickrzjl;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.domain.Icksl_lsb;
import com.aisino2.icksystem.domain.Icksl_wldj;
import com.aisino2.icksystem.domain.Ickslbg;
import com.aisino2.icksystem.domain.Ickzb;
import com.aisino2.icksystem.domain.Wldj;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.icksystem.service.IIcksl_lsbService;
import com.aisino2.publicsystem.dao.IQyZrsProcDao;
import com.aisino2.publicsystem.dao.IQyjbxxDao;
import com.aisino2.publicsystem.dao.IQyry_zpDao;
import com.aisino2.publicsystem.dao.IQyryxxDao;
import com.aisino2.publicsystem.dao.IQyryxx_lsxxDao;
import com.aisino2.publicsystem.dao.IRyxxczrzDao;
import com.aisino2.publicsystem.dao.IWgcyryxxDao;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;
import com.aisino2.publicsystem.domain.Ryxxczrz;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyryxxService;

public class IckslServiceImpl extends BaseService implements IIckslService {

	private IIckslDao ickslDao;
	private IIckslbgDao ickslbgDao;
	private IIckrzjlDao ickrzjlDao;
	private IIcksl_wldjDao icksl_wldjDao;
	private IWldjDao wldjDao;
	private IIcksl_ickzbDao icksl_ickzbDao;
	private IIckzbDao ickzbDao;
	private IQyryxxDao qyryxxDao;
	private IScbmDao scbmDao;
	private IQyry_zpDao qyry_zpDao;
	private IWgcyryxxDao wgcyryxxDao;
	private IQyryxx_lsxxDao qyryxx_lsxxDao;
	private IQyjbxxDao qyjbxxDao;
	private IRyxxczrzDao ryxxczrzDao;
	private IQyryxxService qyryxxService;
	private IQyZrsProcDao qyZrsProcDao;
	private IQyjbxxService qyjbxxService;
	private IIcksl_lsbService icksl_lsbService;

	/** @param IC卡受理(t_icksl) 增加 */
	public Icksl insertIcksl(Icksl icksl){
		// TODO: implement
		//return (Icksl)ickslDao.insertIcksl(icksl);
		Icksl ickslNew = new Icksl();
		Icksl ickslExist = new Icksl();
		List ickslExistList = new ArrayList();
		boolean isIckslExist = true;
		Date currentDate = new Date();
		
		Qyryxx qyryxx = new Qyryxx();
		qyryxx = icksl.getQyryxx();
		if(qyryxx != null)
		{
			
			//判断该人员是否存在除Ic卡注销和补换卡注销外的其他记录
			ickslExist.setRyid(qyryxx.getRyid());
			ickslExistList = ickslDao.getIckslExist(ickslExist);
			if(ickslExistList == null)
				isIckslExist = false;
			else if(ickslExistList.size()==0)
				isIckslExist = false;
			
			if(!isIckslExist)
			{
				//获得IC卡受理号
				Map scbmMap = new HashMap();
				String deptCodeKH = "";
				
				//原有受理号规则：去掉"CJD"的采集点编码或去掉企业主分类的企业编码的前6位（不足6位补0）+6位流水号
				//新规则：人员所在企业的管辖单位的前6位+6位流水号 （2010-05-07修改）
				//deptCodeKH = qyryxx.getLrdwbm().substring(3, qyryxx.getLrdwbm().length());//去掉"CJD"的采集点编码或去掉企业主分类的企业编码
				
				Qyjbxx qyjbxxTemp = new Qyjbxx();
				qyjbxxTemp.setQyid(qyryxx.getQyid());
				qyjbxxTemp = qyjbxxService.getQyjbxx(qyjbxxTemp);
				deptCodeKH = qyjbxxTemp.getGxdwbm().substring(0, 6);
				scbmMap.put("p_bmfl", "ICKH");
				//scbmMap.put("p_xzqh", StringUtil.add0(deptCodeKH, 6).substring(0, 6));
				scbmMap.put("p_xzqh", deptCodeKH);
				String sssf = "hn";//所属省份

				String tempSssf = QjblUtil.queryQjblVal("sssf");
				if(tempSssf!=null&&!"".equals(tempSssf))
					sssf = tempSssf;
				scbmMap.put("p_sssf", sssf);
				scbmMap.put("p_scgz", 3);
				//若前台传入的kh为空，则调用编码生成程序生成编码。


				if(icksl.getKh()==null||"".equals(icksl.getKh()))
					icksl.setKh(scbmDao.getScbm(scbmMap));
				
				//IC卡受理

				/**
				 * 从业人员状态： 1-已核对，4-二次核对错，5-证件号码错

				 * 制卡状态：0-IC卡受理未结束，1-IC卡受理已结束
				 */
				if(qyryxx.getZt()!=null)
				{
					if(qyryxx.getZt().equals("1")||qyryxx.getZt().equals("4")||qyryxx.getZt().equals("5"))
					{
						icksl.setZkztbs("1");
					}
					else
					{
						icksl.setZkztbs("0");
					}
				}
				Qyjbxx qyjbxx = new Qyjbxx();
				qyjbxx.setQyid(qyryxx.getQyid());
				qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
				icksl.setQybm(qyjbxx.getQybm());
				icksl.setHylbdm(qyjbxx.getHylbdm());
				icksl.setHylb(qyjbxx.getHylb());
				icksl.setRyid(qyryxx.getRyid());
				icksl.setQyid(qyryxx.getQyid());
				icksl.setCjr(qyryxx.getLrr());
				icksl.setCjsj(qyryxx.getLrsj());
				icksl.setCjdbm(qyryxx.getLrdwbm());
				icksl.setCjdmc(qyryxx.getLrdwmc());
				icksl.setSlsj(currentDate);
				ickslNew = ickslDao.insertIcksl(icksl);
				
				//IC卡日志记录表
				Ickrzjl ickrzjl = new Ickrzjl();
				ickrzjl.setCyrybh(qyryxx.getCyrybh());
				ickrzjl.setCzlb("IC卡受理");
				ickrzjl.setCzyy("IC卡受理");
				ickrzjl.setCzr(icksl.getSlr());
				ickrzjl.setCzsj(currentDate);
				ickrzjlDao.insertIckrzjl(ickrzjl);
				
				ickslNew.setQyryxx(qyryxx);
			}
		}
		return ickslNew;
	}
	/** @param IC卡受理(t_icksl) 删除 */
	public boolean deleteIcksl(Icksl icksl){
		// TODO: implement
		return ickslDao.deleteIcksl(icksl)>0;
	}

	/** @param IC卡受理(t_icksl) 修改 */
	public boolean updateIcksl(Icksl icksl) throws Exception{
		// TODO: implement
		boolean isSuccess = false;
		Date currentDate = new Date();
		Icksl icksl_bak = new Icksl();
		Ickslbg ickslbg = new Ickslbg();
		Ickrzjl ickrzjl = new Ickrzjl();
		Icksl_wldj icksl_wldj = new Icksl_wldj();
		Wldj wldj = new Wldj();
		Icksl_ickzb icksl_ickzb = new Icksl_ickzb();
		Qyryxx qyryxx = new Qyryxx();

		
		//保存IC卡受理历史信息


		icksl_bak.setIckslid(icksl.getIckslid());
		icksl_bak = ickslDao.getIcksl(icksl_bak);
		icksl_wldj.setIckslid(icksl.getIckslid());
		icksl_ickzb.setIckslid(icksl.getIckslid());
		icksl_wldj = icksl_wldjDao.getIcksl_wldj(icksl_wldj);
		icksl_ickzb = icksl_ickzbDao.getIcksl_ickzb(icksl_ickzb);
		if(icksl_wldj != null)
		{
			wldj.setWlid(icksl_wldj.getWlid());
			wldj = wldjDao.getWldj(wldj);
		}
		if(icksl_bak!=null)
			BeanUtils.copyProperties(ickslbg, icksl_bak);
		if(icksl_wldj != null)
			ickslbg.setWlid(icksl_wldj.getWlid());
		if(icksl_ickzb != null)
			ickslbg.setZbid(icksl_ickzb.getZbid());
		ickslbgDao.insertIckslbg(ickslbg);
		//获得对应的从业人员


		qyryxx.setRyid(icksl_bak.getRyid());
		qyryxx = qyryxxDao.getQyryxx(qyryxx);
		//更新IC卡受理表
		ickslDao.updateIcksl(icksl);
		//IC卡日志记录


		if(wldj != null)
			ickrzjl.setPch(wldj.getWlpc());
		if(qyryxx != null)
			ickrzjl.setCyrybh(qyryxx.getCyrybh());
		if(icksl.getCzlx()==null)
		{
			ickrzjl.setCzlb("IC卡修改");
			ickrzjl.setCzyy("IC卡修改");
		}
		else
		{
			ickrzjl.setCzlb(icksl.getCzlx());
			ickrzjl.setCzyy(icksl.getCzlx());
		}
		ickrzjl.setCzr(icksl.getCzr());
		ickrzjl.setCzsj(currentDate);
		ickrzjlDao.insertIckrzjl(ickrzjl);
		
		isSuccess = true;
		return isSuccess;
	}
	/** @param IC卡受理(t_icksl) 照片审核 */
	public boolean updateIckslZpsh(Icksl ickslOrigin) throws Exception
	{
		boolean isSuccess = false;
		Icksl icksl = null;
		List ickslList = new ArrayList();
		Qyryxx qyryxx = null;
		Qyryxx cyryxxOld = null;
		List cyryxxList = new ArrayList();
		ickslList = ickslOrigin.getLIcksl();
		cyryxxList = ickslOrigin.getLQyryxx();
		if(ickslList != null)
		{
			if(ickslList.size()>0)
			{
				for(int i = 0;i<ickslList.size();i++)
				{
					icksl = new Icksl();
					icksl = (Icksl)ickslList.get(i);
					cyryxxOld = new Qyryxx();
					cyryxxOld.setRyid(icksl.getRyid());
					cyryxxOld = qyryxxDao.getQyryxx(cyryxxOld);
					qyryxx = new Qyryxx();
					qyryxx = (Qyryxx)cyryxxList.get(i);
					if("1".equals(icksl.getSftg()))
					{
						if(cyryxxOld.getZpwtgyy()!=null)
						{
							if(!"".equals(cyryxxOld.getZpwtgyy()))
							{
								qyryxx.setCzlx("IC卡照片审核");
								qyryxx.setCzr(ickslOrigin.getCzr());
								qyryxx.setZpwtgyy("");
								qyryxxService.updateQyryxxOnly(qyryxx);
							}
						}
						icksl.setZkztbs("2");
						icksl.setCzlx("IC卡照片审核");
						icksl.setCzr(ickslOrigin.getCzr());
						updateIcksl(icksl);
					}
					else
					{
						qyryxx = new Qyryxx();
						qyryxx = (Qyryxx)cyryxxList.get(i);
						qyryxx.setCzlx("IC卡照片审核");
						qyryxx.setCzr(ickslOrigin.getCzr());
						qyryxxService.updateQyryxxOnly(qyryxx);
					}
					cyryxxOld = null;
					qyryxx = null;
					icksl = null;
				}
			}
		}
		
		isSuccess = true;
		return isSuccess;
	}
	/**
	 * 照片审核 全部通过 
	 * @param ickslOrigin: sfjxgarkkbd,czr,gxdwbm,cjdbm
	 * @return
	 */
	public boolean updateIckslZpshAll(Icksl ickslOrigin) throws Exception
	{
		boolean isSuccess = false;
		String ejshkg = "0";//二级审核开关

		String sfjxgarkkbd = "0";//是否进行公安人口库比对

		ejshkg = QjblUtil.queryQjblVal("ejshkg");
		if(ejshkg==null||"".equals(ejshkg))
			ejshkg = "0";
		sfjxgarkkbd = QjblUtil.queryQjblVal("sfjxgarkkbd");

		Icksl icksl = null;
		List ickslListOrigin = new ArrayList();
		List ickslList = new ArrayList();
		Qyryxx qyryxx = null;
		List qyryxxList = new ArrayList();
		
		//取出指定地市指定采集点下所有未审核通过的记录
		ickslOrigin.setEjshkg("0");
		ickslOrigin.setSfjxgarkkbd("0");
		ickslListOrigin = ickslDao.getWshzpListNoPage(ickslOrigin);
		if(ickslListOrigin != null)
		{
			if(ickslListOrigin.size()>0)
			{
				for(int i = 0;i<ickslListOrigin.size();i++)
				{
					icksl = new Icksl();
					icksl = (Icksl)ickslListOrigin.get(i);
					icksl.setSftg("1");
					ickslList.add(icksl);
					qyryxx = new Qyryxx();
					qyryxx.setRyid(icksl.getRyid());
					qyryxx.setQyid(icksl.getQyid());
					qyryxxList.add(qyryxx);
					qyryxx = null;
					icksl = null;
					
				}
				ickslOrigin.setLQyryxx(qyryxxList);
				ickslOrigin.setLIcksl(ickslList);
				isSuccess = updateIckslZpsh(ickslOrigin);
			}
		}
		return isSuccess;
	}
	/** @param IC卡常规发放 icksl中存放从业人员编号串和卡号*/
	public boolean updateIckslFf(Icksl icksl) throws Exception
	{
		boolean isSuccess = false;
		Date currentDate = new Date();
		String cyrybh = icksl.getCyrybhSet();
		String ffr = icksl.getFfr();
		
		//Icksl ickslNew = new Icksl();
		Icksl icksl_bak = new Icksl();
		Ickslbg ickslbg = new Ickslbg();
		Ickrzjl ickrzjl = new Ickrzjl();
		Icksl_wldj icksl_wldj = new Icksl_wldj();
		Wldj wldj = new Wldj();
		Icksl_ickzb icksl_ickzb = new Icksl_ickzb();
		Qyryxx qyryxx = new Qyryxx();
		
		qyryxx.setCyrybh(cyrybh);
		qyryxx = qyryxxDao.getQyryxx(qyryxx);
		if(qyryxx !=null)
		{
			//获得IC卡受理信息
			/**
			 * 制卡状态：6-IC卡已发放，24-IC卡物流已接收
			 */
			icksl.setRyid(qyryxx.getRyid());
			icksl.setZkztbs("24");
			icksl = ickslDao.getIcksl(icksl);
			if(icksl !=null)
			{
					//保存IC卡受理历史信息
					icksl_bak.setIckslid(icksl.getIckslid());
					icksl_bak = ickslDao.getIcksl(icksl_bak);
					icksl_wldj.setIckslid(icksl.getIckslid());
					icksl_ickzb.setIckslid(icksl.getIckslid());
					icksl_wldj = icksl_wldjDao.getIcksl_wldj(icksl_wldj);
					icksl_ickzb = icksl_ickzbDao.getIcksl_ickzb(icksl_ickzb);
					if(icksl_wldj!=null)
					{
						wldj.setWlid(icksl_wldj.getWlid());
						wldj = wldjDao.getWldj(wldj);
					}
					if(icksl_bak!=null)
						BeanUtils.copyProperties(ickslbg, icksl_bak);
					ickslbg.setWlid(icksl_wldj.getWlid());
					ickslbg.setZbid(icksl_ickzb.getZbid());
					ickslbgDao.insertIckslbg(ickslbg);
					//更新IC卡受理表
					icksl.setFfr(ffr);
					icksl.setFfsj(currentDate);
					icksl.setZkztbs("6");
					ickslDao.updateIcksl(icksl);
					//IC卡日志记录
					if(wldj!=null)
						ickrzjl.setPch(wldj.getWlpc());
					ickrzjl.setCyrybh(qyryxx.getCyrybh());
					ickrzjl.setCzlb("IC卡发放");
					ickrzjl.setCzyy("IC卡发放");
					ickrzjl.setCzr(icksl.getFfr());
					ickrzjl.setCzsj(currentDate);
					ickrzjlDao.insertIckrzjl(ickrzjl);
					
					isSuccess = true;
			}
		}
		
		return isSuccess;
	}
	
	/** @param IC卡受理(t_icksl) 重印刷 ryid，ickslid，cysyy,czr*/
	public boolean updateIckslCys(Icksl icksl) throws Exception
	{
		boolean isSuccess = false;
		Date currentDate = new Date();
		//修改IC卡受理信息


		icksl.setZkztbs("2");
		icksl.setCyssj(currentDate);
		icksl.setCzlx("IC卡重印刷");
		updateIcksl(icksl);
		//修删除IC卡受理IC卡组包
		Icksl_ickzb icksl_ickzb = new Icksl_ickzb();
		icksl_ickzb.setIckslid(icksl.getIckslid());
		icksl_ickzb = icksl_ickzbDao.getIcksl_ickzb(icksl_ickzb);
		icksl_ickzbDao.deleteIcksl_ickzb(icksl_ickzb);
		//IC卡组包数量减1
		Ickzb ickzb = new Ickzb();
		ickzb.setZbid(icksl_ickzb.getZbid());
		ickzb = ickzbDao.getIckzb(ickzb);
		int currentZbsl = ickzb.getZbsl()-1;
		if(currentZbsl>0)
		{
			ickzb.setZbsl(currentZbsl);
			ickzbDao.updateIckzb(ickzb);
		}
		else
		{
			ickzbDao.deleteIckzb(ickzb);
		}
		
		isSuccess = true;
		return isSuccess;
	}
	
	/** @param icksl.kh,icksl.czr
	 *  IC卡受理(t_icksl)物流接受不成功而被反馈回制卡端的卡的物流发送 */
	public boolean updateIckslWlfs(Icksl icksl) throws Exception
	{
		boolean isSuccess = false;
		Icksl ickslTemp = new Icksl();
		String isExistWlzb = "0";
		ickslTemp.setKh(icksl.getKh());
		ickslTemp = ickslDao.getIcksl(ickslTemp);
		isExistWlzb = isExistWlzb(ickslTemp);
		if(ickslTemp != null)
			if("2".equals(isExistWlzb))
			{
				ickslTemp.setZkztbs("23");
				ickslTemp.setCzlx("IC卡物流发送");
				ickslTemp.setCzr(icksl.getCzr());
				updateIcksl(ickslTemp);
			}
		isSuccess = true;
		return isSuccess;
	}
	
	
	/** @param IC卡受理(t_icksl) IC卡电写入 */
	public boolean updateIckslDxr(Icksl icksl) throws Exception
	{
		boolean isSuccess = false;
		icksl.setZkztbs("5");
		icksl.setCzlx("IC卡电写入");
		icksl.setDxrsj(new Date());
		icksl.setCzr(icksl.getDxrr());
		updateIcksl(icksl);
		isSuccess = true;
		return isSuccess;
	}
	
	/** @param IC卡受理(t_icksl) IC卡重电写入 */
	public boolean updateIckslCdxr(Icksl icksl) throws Exception
	{
		boolean isSuccess = false;
		icksl.setZkztbs("4");
		icksl.setCzlx("IC卡重电写入");
		icksl.setCdxrsj(new Date());
		updateIcksl(icksl);
		isSuccess = true;
		return isSuccess;
	}

	/** IC卡强制发放 */ 
	public boolean updateIckslQzff(Icksl ickslParam) throws Exception
	{
		boolean isSuccess = false;
		Date currentDate = new Date();
		String cyrybhs = ickslParam.getCyrybhSet();//从业人员编号
		String khs = ickslParam.getKhSet();//IC卡号
		String ffr = ickslParam.getFfr();//发放人


		
		if(cyrybhs != null)
		{
			if(!cyrybhs.equals(""))
			{
				String[] cyrybhArr = cyrybhs.split(",");
				String[] khArr = khs.split(",");
				String cyrybh = "";
				boolean[] succ = new boolean[cyrybhArr.length];
				for(int i = 0;i<succ.length;i++)
				{
					succ[i] = false;
				}
				
				Icksl icksl = null;
				Ickslbg ickslbg = null;
				Icksl icksl_bak = null;
				Ickrzjl ickrzjl = null;
				Icksl_wldj icksl_wldj = null;
				Icksl_ickzb icksl_ickzb = null;
				Wldj wldj = null;
				
				
				Qyryxx qyryxx = null;
				
				for(int i=0;i<cyrybhArr.length;i++)
				{
					cyrybh = cyrybhArr[i];
					qyryxx = new Qyryxx();
					qyryxx.setCyrybh(cyrybh);
					qyryxx = qyryxxDao.getQyryxx(qyryxx);
					if(qyryxx !=null)
					{
						//获得IC卡受理信息
						/**
						 * 制卡状态：6-IC卡已发放，24-IC卡物流已接收
						 */
						icksl = new Icksl();
						icksl.setRyid(qyryxx.getRyid());
						icksl.setKh(khArr[i]);
						icksl.setZkztbs("24");
						icksl = ickslDao.getIcksl(icksl);
						if(icksl !=null)
						{
								//保存IC卡受理历史信息
								ickslbg = new Ickslbg();
								icksl_bak = new Icksl();
								ickrzjl = new Ickrzjl();
								icksl_wldj = new Icksl_wldj();
								icksl_ickzb = new Icksl_ickzb();
								wldj = new Wldj();
								
								icksl_bak.setIckslid(icksl.getIckslid());
								icksl_bak = ickslDao.getIcksl(icksl_bak);
								icksl_wldj.setIckslid(icksl.getIckslid());
								icksl_ickzb.setIckslid(icksl.getIckslid());
								icksl_wldj = icksl_wldjDao.getIcksl_wldj(icksl_wldj);
								icksl_ickzb = icksl_ickzbDao.getIcksl_ickzb(icksl_ickzb);
								if(icksl_wldj!=null)
								{
									wldj.setWlid(icksl_wldj.getWlid());
									wldj = wldjDao.getWldj(wldj);
								}
								if(icksl_bak!=null)
									BeanUtils.copyProperties(ickslbg, icksl_bak);
								if(icksl_wldj != null)
									ickslbg.setWlid(icksl_wldj.getWlid());
								if(icksl_ickzb != null)
									ickslbg.setZbid(icksl_ickzb.getZbid());
								ickslbgDao.insertIckslbg(ickslbg);
								//更新IC卡受理表
								icksl.setFfr(ffr);
								icksl.setFfsj(currentDate);
								icksl.setZkztbs("6");
								ickslDao.updateIcksl(icksl);
								//IC卡日志记录
								if(wldj!=null)
									ickrzjl.setPch(wldj.getWlpc());
								ickrzjl.setCyrybh(qyryxx.getCyrybh());
								ickrzjl.setCzlb("IC卡强制发放");
								ickrzjl.setCzyy("IC卡强制发放");
								ickrzjl.setCzr(icksl.getFfr());
								ickrzjl.setCzsj(currentDate);
								ickrzjlDao.insertIckrzjl(ickrzjl);
								
								ickslbg = null;
								icksl_bak = null;
								ickrzjl = null;
								icksl_wldj = null;
								icksl_ickzb = null;
								wldj = null;
								
								succ[i] = true;
						}
						icksl = null;
					}
					qyryxx = null;
				}
				for(int i = 0;i<succ.length;i++)
				{
					if(i == 0)
						isSuccess = succ[i];
					else isSuccess = isSuccess&&succ[i];
				}
			}
		}
		return isSuccess;
	}

	/** @param IC卡补换卡*/
	public boolean updateIckslBhk(Icksl icksl)throws Exception
	{
		boolean isSuccess = false;
		Date currentDate = new Date();
		//Qyryxx qyryxx = new Qyryxx();
		Qyry_zp qyry_zp = new Qyry_zp();
		Wgcyryxx wgcyryxx = new Wgcyryxx();
		Qyryxx qyryxx = new Qyryxx();
		qyryxx = icksl.getQyryxx();
		wgcyryxx = qyryxx.getWgcyryxx();
		qyry_zp = qyryxx.getQyry_zp();
		/* IC卡制卡状态为6-已发放或7-IC卡已注销时，才能进行补换卡*/
		if(icksl != null)
		{
			if(icksl.getZkztbs()!=null)
			{
				if(icksl.getZkztbs().equals("6")||icksl.getZkztbs().equals("7"))
				{
					//保存人员历史信息
					Qyryxx_lsxx cyryxx_lsxx = new Qyryxx_lsxx();
					Qyryxx cyryxx_bak = new Qyryxx();
					cyryxx_bak.setRyid(qyryxx.getRyid());
					cyryxx_bak = qyryxxDao.getQyryxx(cyryxx_bak);
					Wgcyryxx wgcyryxx_bak = new Wgcyryxx();
					wgcyryxx_bak.setRyid(qyryxx.getRyid());
					if(wgcyryxx != null)
						wgcyryxx_bak = wgcyryxxDao.getWgcyryxx(wgcyryxx_bak);

					if(wgcyryxx != null)
						if(wgcyryxx_bak!=null)
							BeanUtils.copyProperties(cyryxx_lsxx, wgcyryxx_bak);
					if(cyryxx_bak!=null)
						BeanUtils.copyProperties(cyryxx_lsxx, cyryxx_bak);
					qyryxx_lsxxDao.insertQyryxx_lsxx(cyryxx_lsxx);
					
					//若从业人员服务场所改变，则需修改与t_cyryxx表有直接或间接外键关联的所有表的qyid,但不包括人员历史表和IC卡受理变更表
					if(!cyryxx_bak.getQyid().equals(qyryxx.getQyid()))
					{
						Qyjbxx qyjbxxNow = new Qyjbxx();
						qyjbxxNow.setQyid(qyryxx.getQyid());
						qyjbxxNow = qyjbxxDao.getQyjbxx(qyjbxxNow);
						qyryxx.setHylbdm(qyjbxxNow.getHylbdm());
						qyryxx.setHylb(qyjbxxNow.getHylb());
						updateQyryxxForeignKey(qyryxx,cyryxx_bak);
					}
					else
					{
						qyryxxDao.updateQyryxx(qyryxx);
					}
					if(qyry_zp!=null)
					{
						qyry_zp.setRyid(qyryxx.getRyid());
						qyry_zp.setTplx("0");
						qyry_zpDao.updateQyry_zp(qyry_zp);
					}
						
					//更新外国从业人员信息
					if(wgcyryxx != null)
					{
						wgcyryxx.setRyid(qyryxx.getRyid());
						wgcyryxxDao.updateWgcyryxx(wgcyryxx);
					}
					//更新场所总人数
					if(!cyryxx_bak.getQyid().equals(qyryxx.getQyid()))
					{
						Map map = new HashMap();
						map.put("p_oldQyid", cyryxx_bak.getQyid());
						map.put("p_newQyid", qyryxx.getQyid());
						qyZrsProcDao.updateQyzrs(map);
					}
					//人员信息操作日志
					Qyjbxx qyjbxx  = new Qyjbxx();
					qyjbxx.setQyid(qyryxx.getQyid());
					qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
					Ryxxczrz ryxxczrz = new Ryxxczrz();
					ryxxczrz.setCzr(icksl.getIckzxr());
					ryxxczrz.setCzsj(currentDate);
					ryxxczrz.setCzlx("修改");
					ryxxczrz.setQybm(qyjbxx.getQybm());
					ryxxczrz.setCyrybh(qyryxx.getCyrybh());
					ryxxczrzDao.insertRyxxczrz(ryxxczrz);
					
					//保存IC卡受理信息到Ic卡受理变更表
					Icksl icksl_bak = new Icksl();
					Ickslbg ickslbg = new Ickslbg();
					Ickrzjl ickrzjl = new Ickrzjl();
					Icksl_wldj icksl_wldj = new Icksl_wldj();
					Wldj wldj = new Wldj();
					Icksl_ickzb icksl_ickzb = new Icksl_ickzb();
					
					//保存IC卡受理历史信息
					icksl_bak.setIckslid(icksl.getIckslid());
					icksl_bak = ickslDao.getIcksl(icksl_bak);
					icksl_wldj.setIckslid(icksl.getIckslid());
					icksl_ickzb.setIckslid(icksl.getIckslid());
					icksl_wldj = icksl_wldjDao.getIcksl_wldj(icksl_wldj);
					icksl_ickzb = icksl_ickzbDao.getIcksl_ickzb(icksl_ickzb);
					if(icksl_wldj!=null)
					{
						wldj.setWlid(icksl_wldj.getWlid());
						wldj = wldjDao.getWldj(wldj);
					}
					if(icksl_bak!=null)
						BeanUtils.copyProperties(ickslbg, icksl_bak);
					if(icksl_wldj!=null)
						ickslbg.setWlid(icksl_wldj.getWlid());
					if(icksl_ickzb!=null)
						ickslbg.setZbid(icksl_ickzb.getZbid());
					ickslbgDao.insertIckslbg(ickslbg);
					
					//更新IC卡受理表 制卡状态：9-补换卡注销
					Qyryxx qyryxxNew = new Qyryxx();
					qyryxxNew.setCyrybh(qyryxx.getCyrybh());
					qyryxxNew.setScbz(0);
					qyryxxNew = qyryxxService.getQyryxx(qyryxxNew);
					icksl.setRyid(qyryxxNew.getRyid());
					icksl.setZkztbs("9");
					icksl.setIckzxsj(currentDate);
					icksl.setIckzxyy(icksl.getBhkyy());
					ickslDao.updateIcksl(icksl);
					//IC卡日志记录


					if(wldj != null)
						ickrzjl.setPch(wldj.getWlpc());
					ickrzjl.setCyrybh(qyryxx.getCyrybh());
					ickrzjl.setCzlb("IC卡补换卡");
					ickrzjl.setCzyy("IC卡补换卡");
					ickrzjl.setCzr(icksl.getIckzxr());
					ickrzjl.setCzsj(currentDate);
					ickrzjlDao.insertIckrzjl(ickrzjl);
					isSuccess = true;
		
				}
			}
		}
		
		return isSuccess;
	}
	/** @param 从业人员信息(t_qyryxx) 修改与t_qyryxx表有直接或间接外键关联的所有表的qyid,但不包括人员历史表和IC卡受理变更表 */
	  public boolean updateQyryxxForeignKey(Qyryxx qyryxx,Qyryxx qyryxx_bak)
	  {
	    boolean isSuccess = false;
	    int ryid=qyryxx_bak.getRyid();
	    int qyid = qyryxx_bak.getQyid();
	    
	    isSuccess = qyryxxService.updateQyryxxForeignKey(qyryxx, qyryxx_bak);
	    
	    Icksl icksla = new Icksl();
	    icksla.setRyid(ryid);
	    icksla.setZxbz("0");
	    icksla =ickslDao.getIckslyj(icksla);//拿出这个ryid的最后的icksl记录
	    
	    Icksl ickslgx = new Icksl();
	    ickslgx.setIckslid(icksla.getIckslid());
	    Qyjbxx qyjbxx = new Qyjbxx();
	    qyjbxx.setQyid(qyryxx.getQyid());
	    qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
	    ickslgx.setQybm(qyjbxx.getQybm());
	    ickslgx.setQyid(qyryxx.getQyid());
	    ickslgx.setRyid(qyryxx.getRyid());
	    ickslgx.setHylbdm(qyryxx.getHylbdm());
	    ickslgx.setHylb(qyryxx.getHylb());
	    isSuccess = (ickslDao.updateIckslByqybg(ickslgx)>0)&&isSuccess;
	  
	    return isSuccess;
	  }
	  /** @param 人员注册，更新对应的icksl记录 
	 * @throws Exception */
	  public boolean updateIckslByryzc(Qyryxx qyryxx) throws Exception
	  {
		Qyryxx qyryxxtemp=new Qyryxx();
		if(qyryxx!=null)
			BeanUtils.copyProperties(qyryxxtemp, qyryxx);
		qyryxxService.updateQyryxx(qyryxxtemp);
	    //qyryxxtemp中有注册前的ryid和cyrybh值，qyryxxnew为注册后值
		boolean isSuccess = false;
	    Qyryxx qyryxxnew = new Qyryxx();
	    qyryxxnew.setCyrybh(qyryxx.getCyrybh());
	    qyryxxnew = qyryxxService.getQyryxx(qyryxxnew);
	    
	    Icksl icksla = new Icksl();
	    icksla.setRyid(qyryxx.getRyid());
	    icksla.setZxbz("0");
	    icksla =ickslDao.getIckslyj(icksla);//拿出这个ryid的最后的icksl记录
	    
	    Qyjbxx qyjbxx = new Qyjbxx();
	    qyjbxx.setQyid(qyryxxnew.getQyid());
	    qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
	    
	    Icksl ickslgx = new Icksl();
	    ickslgx.setIckslid(icksla.getIckslid());
	    ickslgx.setQybm(qyjbxx.getQybm());
	    ickslgx.setQyid(qyryxxnew.getQyid());
	    ickslgx.setRyid(qyryxxnew.getRyid());
	    ickslgx.setHylbdm(qyryxxnew.getHylbdm());
	    ickslgx.setHylb(qyryxxnew.getHylb());
	    isSuccess = (ickslDao.updateIckslByqybg(ickslgx)>0);
	  
	    return isSuccess;
	  }
	/** @param IC卡注销 已发放的卡才能注销 zkztbs=6(已发放)*/
	public boolean updateIckslZx(Icksl icksl)throws Exception
	{
		boolean isSuccess = false;
		Date currentDate = new Date();
		//保存IC卡受理信息到Ic卡受理变更表
		Icksl icksl_bak = new Icksl();
		Ickslbg ickslbg = new Ickslbg();
		Ickrzjl ickrzjl = new Ickrzjl();
		Icksl_wldj icksl_wldj = new Icksl_wldj();
		Wldj wldj = new Wldj();
		Icksl_ickzb icksl_ickzb = new Icksl_ickzb();
		
		//保存IC卡受理历史信息
		icksl_bak.setIckslid(icksl.getIckslid());
		icksl_bak = ickslDao.getIcksl(icksl_bak);
		icksl_wldj.setIckslid(icksl.getIckslid());
		icksl_ickzb.setIckslid(icksl.getIckslid());
		icksl_wldj = icksl_wldjDao.getIcksl_wldj(icksl_wldj);
		icksl_ickzb = icksl_ickzbDao.getIcksl_ickzb(icksl_ickzb);
		if(icksl_wldj!=null)
		{
			wldj.setWlid(icksl_wldj.getWlid());
			wldj = wldjDao.getWldj(wldj);
		}
		if(icksl_bak!=null)
			BeanUtils.copyProperties(ickslbg, icksl_bak);
		if(icksl_wldj!=null)
			ickslbg.setWlid(icksl_wldj.getWlid());
		if(icksl_ickzb!=null)
			ickslbg.setZbid(icksl_ickzb.getZbid());
		ickslbgDao.insertIckslbg(ickslbg);
		//更新IC卡受理表 制卡状态：7-IC卡已注销,8-人注销
		if("IC卡注销".equals(icksl.getCzlx()))
			icksl.setZkztbs("7");
		else if("人注销".equals(icksl.getCzlx()))
			icksl.setZkztbs("8");
		icksl.setIckzxsj(currentDate);
		ickslDao.updateIcksl(icksl);
		
		//IC卡日志记录
		Qyryxx qyryxx = new Qyryxx();
		if(icksl.getRyid()==null)
		{
			Icksl ickslNew = new Icksl();
			ickslNew.setIckslid(icksl.getIckslid());
			ickslNew = ickslDao.getIcksl(ickslNew);
			qyryxx.setRyid(ickslNew.getRyid());
		}
		else
			qyryxx.setRyid(icksl.getRyid());
		qyryxx = qyryxxDao.getQyryxx(qyryxx);
		if(wldj!=null)
			ickrzjl.setPch(wldj.getWlpc());
		ickrzjl.setCyrybh(qyryxx.getCyrybh());
		if("IC卡注销".equals(icksl.getCzlx()))
		{
			ickrzjl.setCzlb("IC卡注销");
			ickrzjl.setCzyy("IC卡注销");
		}
		else if("人注销".equals(icksl.getCzlx()))
		{	
			ickrzjl.setCzlb("人注销");
			ickrzjl.setCzyy("人注销");
		}
		ickrzjl.setCzr(icksl.getIckzxr());
		ickrzjl.setCzsj(currentDate);
		ickrzjlDao.insertIckrzjl(ickrzjl);
		isSuccess = true;
		
		return isSuccess;
	}
	
	/** @param 查询已受理的从业人员 */
	public Page getYslIckslCyryxxList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getYslIckslCyryxxList(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 查询未进行受理的从业人员 */
	public Page getWslIckslCyryxxList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getWslIckslCyryxxList(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 查询具备发放条件或注销条件的IC卡的IC卡  分页查询*/
	public Page getWffOrWzxIckslList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getWffOrWzxIckslList(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 查询具备补换卡条件的IC卡  分页查询*/
	public Page getBhkIckslList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getBhkIckslList(map, pageNo, pageSize, sort, desc);
	}

	/** @param IC卡受理(t_icksl) 查询单条 */
	public Icksl getIcksl(Icksl icksl){
		// TODO: implement
		return (Icksl)ickslDao.getIcksl(icksl);
	}
	
	/** @param IC卡受理(t_icksl) 电写入校验信息 */
	public Icksl getDxrValidate(Icksl icksl)
	{
		return (Icksl)ickslDao.getDxrValidate(icksl);
	}

	/** @param IC卡受理(t_icksl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return ickslDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 由物流ID获得IC卡受理信息 分页*/
	public Page getListIckslByWlidForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getListIckslByWlidForPage(map, pageNo, pageSize, sort, desc);
	}

	/** @param 制卡端关联查询 ；采集点第三方制卡统计钻取 分页查询*/
	public Page getIckslZkdglcxList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getIckslZkdglcxList(map, pageNo, pageSize, sort, desc);
	}
	
	/**
	 * 查询指定从业人员是否存在除Ic卡注销和补换卡注销外的其他记录
	 * @param icksl中存放ryid
	 * @return boolean true-存在受理记录，false-不存在受理记录

	 */
	public boolean getIckslExist(Icksl icksl)
	{
		boolean isIckslExist = false;
		List isIckslExistList = new ArrayList();
		isIckslExistList = ickslDao.getIckslExist(icksl);
		if(isIckslExistList != null)
			if(isIckslExistList.size()>0)
				isIckslExist = true;
		return isIckslExist;
	}
	
	/** @param 判断IC卡是否具备接收或发放条件*/
	public List isCyrybhExistInIckslAndWldj(Map map)
	{
		return ickslDao.isCyrybhExistInIckslAndWldj(map);
	}
	
	/** @param IC卡综合查询  分页查询*/
	public Page getIckslZhList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getIckslZhList(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 制卡端信息查询  分页查询*/
	public Page getIckslZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getIckslZkdForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 获得物流包内所有IC卡所在场所*/
	public List getYlcsListInWldj(Icksl icksl)
	{
		return ickslDao.getYlcsListInWldj(icksl);
	}
	
	/** @param 判断IC卡是否已电写入，若是，则返回从业人员编号*/
	public String sfDxr(Icksl icksl)
	{
		String cyrybh="";
		Map map = new HashMap();
		map.put("zkztbs", "5");
		map.put("ickh", icksl.getIckh());
		icksl = ickslDao.isDxr(map);
		if(icksl != null)
		{
			if(icksl.getCyrybh()!=null)
				cyrybh = icksl.getCyrybh();
		}
		return cyrybh;
	}
	
	/** @param 获得物流包内指定场所需打印的人员及IC卡信息*/
	public List getCyryAndIckInWldj(Icksl icksl)
	{
		return ickslDao.getCyryAndIckInWldj(icksl);
	}
	
	/** @param 获得未组包的IC卡受理信息*/
	public List getWzbIckslList(Icksl icksl)
	{
		return ickslDao.getWzbIckslList(icksl);
	}

	/** @param IC卡受理(t_icksl) 多条查询 */
	public List getListIcksl(Icksl icksl){
		// TODO: implement
		return ickslDao.getListIcksl(icksl);
	}
	
	/** @param 判断IC卡是否具备物流组包条件 zkztbs=5(IC卡已电写入)且未组过物流包  用于首次被确认的卡 返回icksl=null：验证未通过，icksl!=null:验证通过*/
	public Icksl isWlzb(Icksl icksl)
	{
		String isWlzb = "0";
		Icksl ickslNew  = new Icksl();
		Icksl ickslNew2  = new Icksl();
		ickslNew = ickslDao.isWlzb(icksl);
		ickslNew2.setKh(icksl.getKh());
		ickslNew2 = ickslDao.getIcksl(ickslNew2);
		String isExistWlzb = "0";
		//isExistWlzb = isExistWlzb(ickslNew2);//根据重庆新流程，一张卡可以在多个物流包中，这句注释掉
		//if(ickslNew != null&&"0".equals(isExistWlzb))
		if(ickslNew != null)
			isWlzb = "1";
		if(!"1".equals(isWlzb))
			ickslNew = null;
		return ickslNew;
	}
	
	/** @param 判断IC卡是否具备物流组包条件 zkztbs=5(IC卡已电写入)且未组过物流包 用于非首次被确认的卡 0-验证不通过，1-验证通过*/
	public String isWlzb2(Icksl icksl)
	{
		String isWlzb = "0";
		Icksl ickslNew  = new Icksl();
		Icksl ickslNew2  = new Icksl();
		ickslNew = ickslDao.isWlzb(icksl);
		ickslNew2.setKh(icksl.getKh());
		ickslNew2 = ickslDao.getIcksl(ickslNew2);
		String isExistWlzb = "0";
		//isExistWlzb = isExistWlzb(ickslNew2);//根据重庆新流程，一张卡可以在多个物流包中，这句注释掉
		//if(ickslNew != null&&"0".equals(isExistWlzb))
		if(ickslNew != null)
			isWlzb = "1";
		return isWlzb;
	}
	
	/** 判断IC卡是否组过物流包，若组过物流包，则是否被反馈过


	 * @param Icksl.ickslid
	 * @return 0-未组过物流包，1-组过物流包但未被反馈，2-组过物流包且已被反馈*/
	public String isExistWlzb(Icksl icksl)
	{
		String flag = "0";
		List icksl_wldjList = new ArrayList();
		Icksl_wldj icksl_wldj = new Icksl_wldj();
		Icksl_wldj icksl_wldjTemp = null;
		Wldj wldj = null;
		icksl_wldj.setIckslid(icksl.getIckslid());
		icksl_wldjList = icksl_wldjDao.getListIcksl_wldj(icksl_wldj);
		if(icksl_wldjList!=null)
		{
			if(icksl_wldjList.size()>0)
			{
				flag = "1";
				for(int i = 0;i<icksl_wldjList.size();i++)
				{
					icksl_wldjTemp = new Icksl_wldj();
					icksl_wldjTemp = (Icksl_wldj)icksl_wldjList.get(i);
					wldj = new Wldj();
					wldj.setWlid(icksl_wldjTemp.getWlid());
					wldj = wldjDao.getWldj(wldj);
					if(wldj != null)
					{
						if(!"".equals(wldj.getFkxx()))
						{
							flag = "2";
							break;
						}
					}
				}
			}
			
		}
		return flag;
	}
	
	/** @param icksl.kh 判断IC卡是否组过物流包，若组过物流包，则是否被反馈过*/
	public String isExistWlzbByKh(Icksl icksl)
	{
		String flag = "0";
		Icksl ickslTemp = new Icksl();
		ickslTemp.setKh(icksl.getKh());
		ickslTemp = ickslDao.getIcksl(ickslTemp);
		flag = isExistWlzb(ickslTemp);
		return flag;
	}
	
	/** @param 查询未审核通过照片信息  分页查询*/
	public Page getWshzpList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String ejshkg = "0";//二级审核开关

		String sfjxgarkkbd = "0";//是否进行公安人口库比对

		ejshkg = QjblUtil.queryQjblVal("ejshkg");
		if(ejshkg==null||"".equals(ejshkg))
			ejshkg = "0";
		sfjxgarkkbd = QjblUtil.queryQjblVal("sfjxgarkkbd");
		map.put("ejshkg", ejshkg);
		map.put("sfjxgarkkbd", sfjxgarkkbd);
		return ickslDao.getWshzpList(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 由物流ID获得IC卡受理信息 不分页*/
	public List getIckslByWlidListNoPage(Icksl icksl)
	{
		return ickslDao.getIckslByWlidListNoPage(icksl);
	}
	
	/** @param IC卡受理(t_icksl) 查询单条 场所端刷卡时，查询该卡是否有效，若有效则返回有效记录 制卡状态为6、7、9时可以刷卡*/
	public Icksl getValidIcksl(Icksl icksl)
	{
		return ickslDao.getValidIcksl(icksl);
	}
	
	public Page getDsfzktjList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getDsfzktjList(map, pageNo, pageSize, sort, desc);
	}
	
	public Page getDsfzktjListQyd(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getDsfzktjListQyd(map, pageNo, pageSize, sort, desc);
	}
	

	/** @param IC卡受理(t_icksl) 从业人员编号查询 */
	public Icksl getIckslCyrybh(Icksl icksl){
		// TODO: implement
		return (Icksl)ickslDao.getIckslCyrybh(icksl);
	}
	
	/**
	 * 用于电写入时部分卡的芯片号负号被认为去掉的情况。
	 * 将受理表中相应芯片号的负号加上，并在受理临时表中增加一条记录
	 * @2010-08-16
	 * @author mds
	 * @param Icksl-ickh 芯片号
	 * @return boolean
	 */
	public boolean updateIckslIckh(Icksl icksl)
	{
		boolean isSuccess = false;
		if(icksl!=null)
		{
			String ickh_minus = icksl.getIckh();
			if(StringUtil.isNotEmpty(ickh_minus))
			{
				if(ickh_minus.startsWith("-"))//芯片号带负号
				{
					String ickh_plus = ickh_minus.substring(1);
					Icksl ickslOld = new Icksl();
					ickslOld.setIckh(ickh_plus);
					ickslOld = getIckslCyrybh(ickslOld);
					if(ickslOld!=null)
					{
						ickslOld.setIckh(ickh_minus);//将受理表中的芯片号加上负号
						isSuccess = ickslDao.updateIcksl(ickslOld)>0;
						
						//判断IC卡受理临时表中是否存在不带负号的芯片号，若不存在，则增加
						Icksl_lsb icksl_lsb = new Icksl_lsb();
						icksl_lsb.setIckhold(ickh_plus);
						icksl_lsb = icksl_lsbService.getIcksl_lsb(icksl_lsb);
						if(icksl_lsb==null)
						{
							icksl_lsb = new Icksl_lsb();
							icksl_lsb.setIckhold(ickh_plus);
							icksl_lsb.setIckhnew(ickh_minus);
							icksl_lsb.setLrsj(new Date());
							icksl_lsb.setClbz(0);//默认未处理
							icksl_lsb = icksl_lsbService.insertIcksl_lsb(icksl_lsb);
							isSuccess = (icksl_lsb!=null)&&isSuccess;
						}
					}
				}
			}
		}
		
		return isSuccess;
	}
	
	public Icksl getIckslWs(Icksl icksl) {
		// TODO Auto-generated method stub
		return ickslDao.getIckslWs(icksl);
	}
	public List getIckslListWs(Icksl icksl) {
		// TODO Auto-generated method stub
		return ickslDao.getIckslListWs(icksl);
	}
	public void setIckslDao(IIckslDao ickslDao) {
		this.ickslDao = ickslDao;
	}
	public void setIckslbgDao(IIckslbgDao ickslbgDao) {
		this.ickslbgDao = ickslbgDao;
	}
	public void setIckrzjlDao(IIckrzjlDao ickrzjlDao) {
		this.ickrzjlDao = ickrzjlDao;
	}
	public void setIcksl_wldjDao(IIcksl_wldjDao icksl_wldjDao) {
		this.icksl_wldjDao = icksl_wldjDao;
	}
	public void setWldjDao(IWldjDao wldjDao) {
		this.wldjDao = wldjDao;
	}
	public void setIcksl_ickzbDao(IIcksl_ickzbDao icksl_ickzbDao) {
		this.icksl_ickzbDao = icksl_ickzbDao;
	}
	public void setIckzbDao(IIckzbDao ickzbDao) {
		this.ickzbDao = ickzbDao;
	}
	public void setQyryxxDao(IQyryxxDao qyryxxDao) {
		this.qyryxxDao = qyryxxDao;
	}
	public void setScbmDao(IScbmDao scbmDao) {
		this.scbmDao = scbmDao;
	}
	public void setQyry_zpDao(IQyry_zpDao qyry_zpDao) {
		this.qyry_zpDao = qyry_zpDao;
	}
	public void setWgcyryxxDao(IWgcyryxxDao wgcyryxxDao) {
		this.wgcyryxxDao = wgcyryxxDao;
	}
	public void setQyryxx_lsxxDao(IQyryxx_lsxxDao qyryxx_lsxxDao) {
		this.qyryxx_lsxxDao = qyryxx_lsxxDao;
	}
	public void setQyjbxxDao(IQyjbxxDao qyjbxxDao) {
		this.qyjbxxDao = qyjbxxDao;
	}
	public void setRyxxczrzDao(IRyxxczrzDao ryxxczrzDao) {
		this.ryxxczrzDao = ryxxczrzDao;
	}
	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}
	public void setQyZrsProcDao(IQyZrsProcDao qyZrsProcDao) {
		this.qyZrsProcDao = qyZrsProcDao;
	}
	public Icksl getIckslyj(Icksl icksl) {
		// TODO Auto-generated method stub
		return ickslDao.getIckslyj(icksl);
	}
	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}

	public Icksl getIckTjxx(Map map){
		return ickslDao.getIckTjxx(map);
	}
	public Page getDsfzkxxList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return ickslDao.getDsfzkxxList(map, pageNo, pageSize, sort, desc);
	}
	public Icksl getCjdIckTjxx(Map map){
		return ickslDao.getCjdIckTjxx(map);
	}
	
	public int getCjdIckDslCount(Map map){
		return ickslDao.getCjdIckDslCount(map);
	}
	public void setIcksl_lsbService(IIcksl_lsbService icksl_lsbService) {
		this.icksl_lsbService = icksl_lsbService;
	}
	public List getIckslByCyrybhAndKh(Map map){
		return ickslDao.getIckslByCyrybhAndKh(map);
	}
	
}
