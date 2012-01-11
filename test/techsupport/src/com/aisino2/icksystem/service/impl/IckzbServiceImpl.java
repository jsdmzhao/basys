package com.aisino2.icksystem.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.DateToString;
import com.aisino2.common.QjblUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIcksl_ickzbDao;
import com.aisino2.icksystem.dao.IIckzbDao;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.domain.Ickzb;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.icksystem.service.IIckzbService;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.service.IDepartmentService;

public class IckzbServiceImpl extends BaseService implements IIckzbService {

	private IIckzbDao ickzbDao;
	private IIcksl_ickzbDao icksl_ickzbDao;
	private IIckslService ickslService;
	private IDepartmentService departmentService;

	/** @param IC卡组包(t_ickzb) IC卡组包公用服务 */
	public Ickzb insertIckzb(Ickzb ickzbOrigin)throws Exception{
		// TODO: implement
		Ickzb ickzb = new Ickzb();
		Icksl icksl = null;
		List icksl_ickzbList = new ArrayList();
		DateToString dateToString = null;
		int slds = 0;//包内受理点数
		int maxRowsOfPage = ickzbOrigin.getMaxRowsOfPage();//每页最大排版号
		int iRowsOfPage = 0;//当前卡的排版号
		int maxPage = 0;//组包后的总页数
		int iPage = 1;//当前卡所在页数
		Icksl_ickzb icksl_ickzb = null;
		Date currentDate = new Date();
		
		
		if(ickzbOrigin.getLIcksl_ickzb() != null)
		{
			icksl_ickzbList = ickzbOrigin.getLIcksl_ickzb();
			
			//增加IC卡组包表
			//获得所有IC卡所在的受理点数量
			slds = getSlds(ickzbOrigin.getLIcksl_ickzb());
			ickzbOrigin.setSlds(slds);
			//设置18位批次号yyyymmddhhmmssmmmm
			//modified at 20100714 by mds
			//原有产生批次号的方式：dateToString.getDateTimeNoFormat20(new Date())，这种方式经常造成批次号重复
			String tempPch = dateToString.getDateTimeNoFormat14(new Date());
			Map map = new HashMap();
			map.put("pch", tempPch);
			map.put("likepch", tempPch+"%");
			ickzbOrigin.setPch(getNextPch(map));
			//ickzbOrigin.setPch(dateToString.getDateTimeNoFormat20(new Date()));
			
			//设置组包数量
			ickzbOrigin.setZbsl(icksl_ickzbList.size());
			ickzbOrigin.setZbsj(currentDate);
			ickzb = ickzbDao.insertIckzb(ickzbOrigin);
			
			//增加IC卡受理IC卡组包表
			if(icksl_ickzbList.size()%maxRowsOfPage == 0)
				maxPage = icksl_ickzbList.size()/maxRowsOfPage;
			else
				maxPage = icksl_ickzbList.size()/maxRowsOfPage + 1;
			for(int i = 0;i<icksl_ickzbList.size();i++)
			{
				icksl_ickzb = new Icksl_ickzb();
				icksl_ickzb = (Icksl_ickzb)icksl_ickzbList.get(i);
				icksl_ickzb.setZbid(ickzb.getZbid());
				if(iRowsOfPage<maxRowsOfPage)
					iRowsOfPage++;
				else
				{
					iRowsOfPage = 1;
					iPage++;
				}
				icksl_ickzb.setPczdpbh(iRowsOfPage);
				icksl_ickzb.setZbhsuym(iPage);
				icksl_ickzb = icksl_ickzbDao.insertIcksl_ickzb(icksl_ickzb);
				//修改IC卡受理信息
				icksl = new Icksl();
				//icksl.setRyid(icksl_ickzb.getRyid());
				icksl.setIckslid(icksl_ickzb.getIckslid());
				icksl.setZkztbs("3");//制卡状态标识 3-IC卡已组包
				icksl.setCzlx("IC卡组包");
				icksl.setCzr(ickzbOrigin.getZbr());
				ickslService.updateIcksl(icksl);
				
				icksl = null;
				icksl_ickzb = null;
			}
		}
		return ickzb;
	}
	
	/** @param IC卡组包(t_ickzb) IC卡自定义组包 */
	public Ickzb insertIckzbCustom(Ickzb ickzbOrigin)throws Exception
	{
		Ickzb ickzb = new Ickzb();
		List icksl_ickzbList = new ArrayList();
		icksl_ickzbList = ickzbOrigin.getLIcksl_ickzb();
		if(icksl_ickzbList != null)
		{
			if(icksl_ickzbList.size()<=80)
			{
				ickzb = insertIckzb(ickzbOrigin);
			}
		}
		return ickzb;
	}
	
	/** @param IC卡组包(t_ickzb) IC卡自由组包 */
	public int insertIckzbFree(Ickzb ickzb)throws Exception
	{
		int isSuccessInt = 0;
		boolean isSuccess = false;
		boolean isSuccessTemp = false;
		Department department = new Department();
		List cjdList = new ArrayList();
		department.setIsCjd("1");
		Ickzb ickzbback = new Ickzb();
		if(ickzb!=null)
			BeanUtils.copyProperties(ickzbback, ickzb);
		String[] allhylbdm=ickzb.getAllhylbdm().trim().replace("'","").split(",");
		try
		{
			//先进行正常组包流程
			//（一个包中数据来自两个或两个以上采集点的包成为混合包）
			//若参数中的采集点编码不为空，则直接组包；若参数中的采集点编码为空，则按照下面规则进行组包
			//遍历每个采集点，依次组包。每个采集点单独组包后可能余下不能组包的数据，则将每个采集点余下的数据组混合包
			if(ickzb.getCjdbm()!= null&&!"".equals(ickzb.getCjdbm()))
			{
				for(int j= 0;j<allhylbdm.length;j++){
					ickzb.setAllhylbdm("'"+allhylbdm[j]+"'");
					isSuccessTemp = insertIckzbFreeCommon(ickzb);
					isSuccess = isSuccess||isSuccessTemp;
				}
			}
			else
			{
				//取出所有采集点
				cjdList = departmentService.getListDepartment(department);
				if(cjdList!=null)
				{
					for(int i= 0;i<cjdList.size();i++)
					{
						department = null;
						department = new Department();
						department = (Department)cjdList.get(i);
						ickzb.setCjdbm(department.getDepartcode());
						for(int j= 0;j<allhylbdm.length;j++){
							ickzb.setAllhylbdm("'"+allhylbdm[j]+"'");
							isSuccessTemp = insertIckzbFreeCommon(ickzb);
							isSuccess = isSuccess||isSuccessTemp;
						}
					}
					//所有采集点组完包后，把每个采集点余下的数据统一组混合包
					ickzb.setCjdbm("");
					ickzb.setAllhylbdm(ickzbback.getAllhylbdm());
					isSuccessTemp = insertIckzbFreeCommon(ickzb);
					isSuccess = isSuccess||isSuccessTemp;
				}
				
			}
			//先查询所有采集点采集时间在三天及以前的所有记录，若这些记录不足maxRowsOfPage条，则组包。否则
			//先组采集时间达到或超过三天且的记录，这些记录不能超过maxRowsOfPage条，
			//若ickzb中传入了采集点，则只组该采集点超过三天的记录；若ickzb中未传入采集点，则所有采集点的数据组成一个包
			Ickzb ickzbMoreThan3days = new Ickzb();
			if(ickzbback!=null)
				BeanUtils.copyProperties(ickzbMoreThan3days, ickzbback);
			ickzbMoreThan3days.setMoreThan3days("1");
			isSuccessTemp = insertIckzbFreeCommonMoreThan3days(ickzbMoreThan3days);
			isSuccess = isSuccess||isSuccessTemp;
			
			if(isSuccess)
				isSuccessInt = 1;
			else
				isSuccessInt = 0;
		}
		catch(Exception e)
		{
			isSuccessInt = 2;
		}
		
		return isSuccessInt;
	}
	
	/** @param IC卡组包(t_ickzb) IC卡自由组包 自动程序调用方法*/
	public void insertIckzbFreeAuto()throws Exception
	{
		Ickzb ickzb = new Ickzb();
		//取最大排版号
		String zdpbh = QjblUtil.queryQjblVal("zdpbh");
		if(zdpbh!= null&&!"".equals(zdpbh))
			ickzb.setMaxRowsOfPage(Integer.parseInt(zdpbh));
		else
			ickzb.setMaxRowsOfPage(16);
		
		ickzb.setMbjls(80);//每包记录数
		insertIckzbFree(ickzb);
	}
	
	/** @param IC卡组包(t_ickzb) 单个采集点或不限制采集点IC卡自由组包 公用服务 只组满足传入参数条件的且采集时间超过三天的记录*/
	public boolean insertIckzbFreeCommonMoreThan3days(Ickzb ickzbOrigin)throws Exception
	{
		boolean isSuccess = false;
		List yzbList = new ArrayList();//存放本次组的包
		int recordsOfIckzb = ickzbOrigin.getMbjls();//每包记录数
		int maxRowsOfPage = ickzbOrigin.getMaxRowsOfPage();//最大排版号
		int intIckzb = 0;//整包数
		int intIckzbCounter = 0;//整包计数器
		Ickzb ickzb = new Ickzb();
		List wzbMoreThan3daysList = new ArrayList();//超过三天未组包List
		List wzbList = null;//未组包List
		Icksl ickslTemp = null;
		Icksl_ickzb icksl_ickzb = null;
		List icksl_ickzbList = null;
		
		//先查询连续三天以上未组包的记录
		Icksl icksl = new Icksl();
		//若传入采集点作为参数，则只对指定采集点组包；否则，对所有采集点数据组包
		if(ickzbOrigin.getCjdbm()!=null && !"".equals(ickzbOrigin.getCjdbm()))
			icksl.setCjdbm(ickzbOrigin.getCjdbm());
		if(ickzbOrigin.getCjdbm()==null || "".equals(ickzbOrigin.getCjdbm()))
			icksl.setOrderByCjdbm("1");
		if(ickzbOrigin.getAllhylbdm()!=null && !"".equals(ickzbOrigin.getAllhylbdm()))
			icksl.setAllhylbdm(ickzbOrigin.getAllhylbdm());
		icksl.setMoreThan3days("1");
		wzbMoreThan3daysList = ickslService.getWzbIckslList(icksl);
		
		//若存在三天以上未组包数据，则将所有未组包记录组包
		if(wzbMoreThan3daysList != null&&wzbMoreThan3daysList.size()>0)
		{
			//查询所有未组包List
			icksl = new Icksl();
			if(ickzbOrigin.getCjdbm()!=null && !"".equals(ickzbOrigin.getCjdbm()))
				icksl.setCjdbm(ickzbOrigin.getCjdbm());
			if(ickzbOrigin.getCjdbm()==null || "".equals(ickzbOrigin.getCjdbm()))
				icksl.setOrderByCjdbm("1");
			if(ickzbOrigin.getAllhylbdm()!=null && !"".equals(ickzbOrigin.getAllhylbdm()))
				icksl.setAllhylbdm(ickzbOrigin.getAllhylbdm());
			icksl.setMoreThan3days("");
			wzbList = ickslService.getWzbIckslList(icksl);
			icksl_ickzbList = new ArrayList();
			for(int j = 0;j<wzbList.size();j++)
			{
				icksl_ickzb = new Icksl_ickzb();
				/*icksl_ickzb.setCsid(((Icksl)wzbMoreThan3daysList.get(j)).getCsid());
				icksl_ickzb.setRyid(((Icksl)wzbMoreThan3daysList.get(j)).getRyid());*/
				icksl_ickzb.setIckslid(((Icksl)wzbList.get(j)).getIckslid());
				icksl_ickzb.setCjdbmInIcksl(((Icksl)wzbList.get(j)).getCjdbm());
				icksl_ickzbList.add(icksl_ickzb);
				icksl_ickzb = null;
			}
			ickzbOrigin.setLIcksl_ickzb(icksl_ickzbList);
			ickzb = insertIckzb(ickzbOrigin);
			if(ickzb != null)
				yzbList.add(ickzb);
			icksl_ickzbList = null;
		}
		if(yzbList != null && yzbList.size()>0)
			isSuccess = true;
		return isSuccess;
	}
	
	/** @param IC卡组包(t_ickzb) 单个采集点或不限制采集点IC卡自由组包 公用服务*/
	public boolean insertIckzbFreeCommon(Ickzb ickzbOrigin)throws Exception
	{
		boolean isSuccess = false;
		List yzbList = new ArrayList();//存放本次组的包
		int recordsOfIckzb = ickzbOrigin.getMbjls();//每包记录数
		int maxRowsOfPage = ickzbOrigin.getMaxRowsOfPage();//最大排版号
		int intIckzb = 0;//整包数
		int intIckzbCounter = 0;//整包计数器
		Ickzb ickzb = new Ickzb();
		List wzbList = new ArrayList();//未组包List
		Icksl ickslTemp = null;
		List subWzbList = null;//未组包List的子集
		Icksl_ickzb icksl_ickzb = null;
		List icksl_ickzbList = null;
		//查询所有未组包List
		Icksl icksl = new Icksl();
		//若传入采集点作为参数，则只对指定采集点组包；否则，对所有采集点数据组包
		if(ickzbOrigin.getCjdbm()!=null && !"".equals(ickzbOrigin.getCjdbm()))
			icksl.setCjdbm(ickzbOrigin.getCjdbm());
		if(ickzbOrigin.getCjdbm()==null || "".equals(ickzbOrigin.getCjdbm()))
			icksl.setOrderByCjdbm("1");
		if(ickzbOrigin.getAllhylbdm()!=null && !"".equals(ickzbOrigin.getAllhylbdm()))
			icksl.setAllhylbdm(ickzbOrigin.getAllhylbdm());
		icksl.setMoreThan3days("");
		wzbList = ickslService.getWzbIckslList(icksl);
		if(wzbList != null)
		{
			if(wzbList.size()>0)
			{
					//先组达到recordsOfIckzb个记录的包
					intIckzb = wzbList.size()/recordsOfIckzb;
					if(intIckzb>=1)
					{
						for(int i = 0;i<intIckzb;i++)
						{
							subWzbList = new ArrayList();
							subWzbList = wzbList.subList(i*recordsOfIckzb, (i+1)*recordsOfIckzb);
							icksl_ickzbList = new ArrayList();
							for(int j = 0;j<subWzbList.size();j++)
							{
								icksl_ickzb = new Icksl_ickzb();
								/*icksl_ickzb.setCsid(((Icksl)subWzbList.get(j)).getCsid());
								icksl_ickzb.setRyid(((Icksl)subWzbList.get(j)).getRyid());*/
								icksl_ickzb.setIckslid(((Icksl)subWzbList.get(j)).getIckslid());
								icksl_ickzb.setCjdbmInIcksl(((Icksl)subWzbList.get(j)).getCjdbm());
								icksl_ickzbList.add(icksl_ickzb);
								icksl_ickzb = null;
							}
							ickzbOrigin.setLIcksl_ickzb(icksl_ickzbList);
							ickzb = insertIckzb(ickzbOrigin);
							if(ickzb != null)
								yzbList.add(ickzb);
							icksl_ickzbList = null;
							subWzbList = null;
						}
					}
					//组完达到recordsOfIckzb个记录的包后，所剩记录取出满足maxRowsOfPage的整数倍的记录组包，余下的记录顺延到下一日
					if((wzbList.size()-intIckzb*recordsOfIckzb)>maxRowsOfPage)
					{
						subWzbList = new ArrayList();
						subWzbList = wzbList.subList(intIckzb*recordsOfIckzb, wzbList.size()-(wzbList.size()%maxRowsOfPage));
						icksl_ickzbList = new ArrayList();
						for(int j = 0;j<subWzbList.size();j++)
						{
							icksl_ickzb = new Icksl_ickzb();
							/*icksl_ickzb.setCsid(((Icksl)subWzbList.get(j)).getCsid());
							icksl_ickzb.setRyid(((Icksl)subWzbList.get(j)).getRyid());*/
							icksl_ickzb.setIckslid(((Icksl)subWzbList.get(j)).getIckslid());
							icksl_ickzb.setCjdbmInIcksl(((Icksl)subWzbList.get(j)).getCjdbm());
							icksl_ickzbList.add(icksl_ickzb);
							icksl_ickzb = null;
						}
						ickzbOrigin.setLIcksl_ickzb(icksl_ickzbList);
						ickzb = insertIckzb(ickzbOrigin);
						if(ickzb != null)
							yzbList.add(ickzb);
						icksl_ickzbList = null;
						subWzbList = null;
					}
			}
		}
		if(yzbList != null && yzbList.size()>0)
			isSuccess = true;
		return isSuccess;
	}
	
	/** @param IC卡组包(t_ickzb) 印刷 */
	public boolean updateIckzbYs(Ickzb ickzb)throws Exception
	{
		boolean isSuccess = false;
		List ickslList = new ArrayList();
		Icksl icksl = null;
		Icksl ickslTemp = null;
		ickslList = ickzb.getLIcksl();
		if(ickslList != null)
		{
			if(ickslList.size()>0)
			{
				for(int i = 0;i<ickslList.size();i++)
				{
					icksl = new Icksl();
					ickslTemp = new Icksl();
					icksl = (Icksl)ickslList.get(i);
					ickslTemp.setIckslid(icksl.getIckslid());
					ickslTemp = ickslService.getIcksl(ickslTemp);
					//已组包的IC卡，印刷时，zkztbs才改变，其他状态的IC卡印刷时，zkztbs不改变
					if("3".equals(ickslTemp.getZkztbs()))
						icksl.setZkztbs("4");//制卡状态标识 4-IC卡已印刷
					icksl.setCzlx("IC卡印刷");
					icksl.setYssj(new Date());
					icksl.setCzr(icksl.getYsr());
					ickslService.updateIcksl(icksl);
					ickslTemp = null;
					icksl = null;
				}
			}
		}
		isSuccess = true;
		return isSuccess;
	}
	
	/** @param IC卡组包(t_ickzb) 多条查询 需电写入的IC卡查询*/
	public List getIckzbDxrList(Ickzb ickzb)
	{
		return ickzbDao.getIckzbDxrList(ickzb);
	}
	/**
	 * 获得两个日期之间的天数
	 * @param datef 起始日期
	 * @param datet 截止日期
	 * @return
	 */
	public int getDays(Date datef,Date datet)
	{
		int minusDay = 0;
		long DAY = 24L * 60L * 60L * 1000L;    
		SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );    
		String d1 = datef.getYear()+1900+"-"+datef.getMonth()+1+"-"+datef.getDate();    
		String d2 = datet.getYear()+1900+"-"+datet.getMonth()+1+"-"+datet.getDate();    
		try {
			minusDay = (int) ((df.parse(d2).getTime()-df.parse(d1).getTime())/86400000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return minusDay;
	}
	
	/** @param IC卡组包(t_ickzb) 分页查询 查询包内需打印的卡的信息*/
	public Page getIckzbYsListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String maxRowsOfPage = QjblUtil.queryQjblVal("zdpbh");
		map.put("maxRowsOfPage", maxRowsOfPage);
		return ickzbDao.getIckzbYsListForPage(map, pageNo, pageSize, sort, desc);
	}

	/** @param IC卡组包(t_ickzb) 删除 */
	public boolean deleteIckzb(Ickzb ickzb){
		// TODO: implement
		return ickzbDao.deleteIckzb(ickzb)>0;
	}

	/** @param IC卡组包(t_ickzb) 修改 */
	public boolean updateIckzb(Ickzb ickzb){
		// TODO: implement
		return ickzbDao.updateIckzb(ickzb)>0;
	}

	/** @param IC卡组包(t_ickzb) 查询单条 */
	public Ickzb getIckzb(Ickzb ickzb){
		// TODO: implement
		return (Ickzb)ickzbDao.getIckzb(ickzb);
	}

	/** @param IC卡组包(t_ickzb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return ickzbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param IC卡组包(t_ickzb) 多条查询 */
	public List getListIckzb(Ickzb ickzb){
		// TODO: implement
		return ickzbDao.getListIckzb(ickzb);
	}
	/**
	 * 获得列表中各卡所在的受理点的总数
	 * @param icksl_ickzbList 
	 * @return
	 */
	public int getSlds(List icksl_ickzbList)
	{
		int slds = 0;
		String cjdbm = "";
		if(icksl_ickzbList!= null)
		{
			if(icksl_ickzbList.size()>0)
			{
				cjdbm = ((Icksl_ickzb)icksl_ickzbList.get(0)).getCjdbmInIcksl();
				slds = 1;
				for(int i = 1;i<icksl_ickzbList.size();i++)
				{
					if(!cjdbm.equals(((Icksl_ickzb)icksl_ickzbList.get(i)).getCjdbmInIcksl()))
					{
						slds++;
						cjdbm = ((Icksl_ickzb)icksl_ickzbList.get(i)).getCjdbmInIcksl();
					}
				}
			}
		}
		return slds;
	}
	
	/** @param IC卡组包(t_ickzb) 印刷信息查询 */
	public Ickzb getIckzbYsxx(Ickzb ickzb)
	{
		ickzb.setMaxRowsOfPage(16);
		
		Globalpar globalpar = new Globalpar();
		List globalparList = new ArrayList();
		globalpar.setGlobalparcode("zdpbh");
		globalparList = CacheManager.getCacheGlobalpar(globalpar);//内存中取全局参数
		if(globalparList != null)
			if(globalparList.size()>0)
			{
				globalpar = (Globalpar)globalparList.get(0);
				if(globalpar!= null)
					if(globalpar.getGlobalparvalue()!=null)
						if(!globalpar.getGlobalparvalue().equals(""))
							ickzb.setMaxRowsOfPage(Integer.parseInt(globalpar.getGlobalparvalue()));
			}
		return ickzbDao.getIckzbYsxx(ickzb);
	}
	
	/** @param IC卡组包(t_ickzb) 电写入信息查询 */
	public Ickzb getIckzbDxrxx(Ickzb ickzb)
	{
		ickzb.setMaxRowsOfPage(16);
		
		Globalpar globalpar = new Globalpar();
		List globalparList = new ArrayList();
		globalpar.setGlobalparcode("zdpbh");
		globalparList = CacheManager.getCacheGlobalpar(globalpar);//内存中取全局参数
		if(globalparList != null)
			if(globalparList.size()>0)
			{
				globalpar = (Globalpar)globalparList.get(0);
				if(globalpar!= null)
					if(globalpar.getGlobalparvalue()!=null)
						if(!globalpar.getGlobalparvalue().equals(""))
							ickzb.setMaxRowsOfPage(Integer.parseInt(globalpar.getGlobalparvalue()));
			}
		return ickzbDao.getIckzbDxrxx(ickzb);
	}
	
	/**
	 * 获得下一个pch
	 * @param map 
	 * @return
	 */
	public String getNextPch(Map map)
	{
		return ickzbDao.getNextPch(map);
	}

	public IIckzbDao getIckzbDao() {
		return ickzbDao;
	}

	public void setIckzbDao(IIckzbDao ickzbDao) {
		this.ickzbDao = ickzbDao;
	}

	public IIcksl_ickzbDao getIcksl_ickzbDao() {
		return icksl_ickzbDao;
	}

	public void setIcksl_ickzbDao(IIcksl_ickzbDao icksl_ickzbDao) {
		this.icksl_ickzbDao = icksl_ickzbDao;
	}

	public IIckslService getIckslService() {
		return ickslService;
	}

	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
}
