package com.aisino2.publicsystem.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.basicsystem.domain.Bkry;
import com.aisino2.basicsystem.domain.Bkry_kz;
import com.aisino2.basicsystem.domain.Qgztjx;
import com.aisino2.basicsystem.domain.Qgztjx_kz;
import com.aisino2.basicsystem.service.IBjbdtjService;
import com.aisino2.basicsystem.service.IBjgzService;
import com.aisino2.basicsystem.service.IBjxxbService;
import com.aisino2.basicsystem.service.IBkryService;
import com.aisino2.basicsystem.service.IBkry_kzService;
import com.aisino2.basicsystem.service.IQgztjxService;
import com.aisino2.basicsystem.service.IQgztjx_kzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IKhxxDao;
import com.aisino2.publicsystem.dao.IWgkhxxDao;
import com.aisino2.publicsystem.domain.Khxx;
import com.aisino2.publicsystem.domain.Wgkhxx;
import com.aisino2.publicsystem.service.IKhxxService;

public class KhxxServiceImpl extends BaseService implements IKhxxService {

	private IKhxxDao khxxDao;
	private IWgkhxxDao wgkhxxDao;
	private IBjxxbService bjxxbService;
	private IBjbdtjService bjbdtjService;
	private IQgztjxService qgztjxService;
	private IQgztjx_kzService qgztjxkzService;
	private IBkryService bkryService;
	private IBkry_kzService bkrykzService;
	private IBjgzService bjgzService;

	/** @param 客户信息表(t_khxx) 增加 */
	public Khxx insertKhxx(Khxx khxx){
		// TODO: implement
		
		Khxx khxxNew = new Khxx();
		Wgkhxx wgkhxx = new Wgkhxx();
		
		if(khxx!=null)
		{
			khxx.setZt("0");
			khxx.setBiduiflag("0");
			wgkhxx = khxx.getWgkhxx();
			if(wgkhxx==null)
			{
				khxxNew = khxxDao.insertKhxx(khxx);
			}
			else
			{
				khxx.setXm(wgkhxx.getYwm()+" "+wgkhxx.getYwx());
				khxx.setCyzjdm(wgkhxx.getQzzldm());
				khxx.setCyzj(wgkhxx.getQzzl());
				khxx.setZjhm(wgkhxx.getQzhm());
				khxxNew = khxxDao.insertKhxx(khxx);
				wgkhxx.setKhxxid(khxxNew.getKhxxid());
				wgkhxx = wgkhxxDao.insertWgkhxx(wgkhxx);
				khxxNew.setWgkhxx(wgkhxx);
			}
		}
		
		return khxxNew;
	}
	
	/** @param 客户信息表(t_khxx) 增加  含报警
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public Khxx insertKhxxBj(Khxx khxx) throws Exception
	{
		//增加客户信息
		Khxx khxxNew = new Khxx();
		khxxNew = khxxDao.insertKhxx(khxx);
		
		
		Map parameterMap = new HashMap();
		parameterMap = khxx.getParameterMap();
		int biduiflag = 0;
		biduiflag = updateKhxxBjCommon(khxxNew,parameterMap);
		parameterMap.put("biduiflag", biduiflag);
		
		return khxxNew;
	}

	/** @param 客户信息表(t_khxx) 删除 */
	public boolean deleteKhxx(Khxx khxx){
		// TODO: implement
		return khxxDao.deleteKhxx(khxx)>0;
	}

	/** @param 客户信息表(t_khxx) 修改 */
	public boolean updateKhxx(Khxx khxx){
		// TODO: implement
		boolean isSuccess = false;
		Khxx khxxNew = new Khxx();
		Wgkhxx wgkhxx = new Wgkhxx();
		
		if(khxx!=null)
		{
			wgkhxx = khxx.getWgkhxx();
			if(wgkhxx==null)
			{
				wgkhxx = new Wgkhxx();
				wgkhxx.setKhxxid(khxx.getKhxxid());
				wgkhxxDao.deleteWgkhxx(wgkhxx);
				
				khxxDao.updateKhxx(khxx);
				isSuccess = true;
			}
			else
			{
				khxx.setXm(wgkhxx.getYwm()+" "+wgkhxx.getYwx());
				khxx.setCyzjdm(wgkhxx.getQzzldm());
				khxx.setCyzj(wgkhxx.getQzzl());
				khxx.setZjhm(wgkhxx.getQzhm());
				khxxDao.updateKhxx(khxx);
				wgkhxx.setKhxxid(khxx.getKhxxid());
				wgkhxxDao.updateWgkhxx(wgkhxx);
				isSuccess = true;
			}
		}
		return isSuccess;
	}

	
	/** @param 客户信息表(t_khxx) 修改 含报警*/
	public Khxx updateKhxxBj(Khxx khxx) throws Exception
	{
		updateKhxx(khxx);
		Map parameterMap = new HashMap();
		parameterMap = khxx.getParameterMap();
		int biduiflag = 0;
		biduiflag = updateKhxxBjCommon(khxx,parameterMap);
		parameterMap.put("biduiflag", biduiflag);
		
		khxx.setParameterMap(parameterMap);
		return khxx;
	}
	
	
	/** @param 客户信息表(t_khxx) 修改 调用报警功能*/
	public int updateKhxxBjCommon(Khxx khxx,Map parameterMap) throws Exception
	{
		//调用报警接口
		Bjxxb bjxxb = new Bjxxb();
		bjxxb.setYwbzj1((Integer)(parameterMap.get("esccljbxxid")==null?0:parameterMap.get("esccljbxxid")));
		bjxxb.setYwbzj2((Integer)(parameterMap.get("qyid")==null?0:parameterMap.get("qyid")));
		bjxxb.setXm(khxx.getXm());
		bjxxb.setZjhm(khxx.getZjhm());
		
		int biduiflag = 0;
		biduiflag = bjxxbService.baojingKhxx(bjxxb, (String)parameterMap.get("hylbdm"), (String)parameterMap.get("sfyx"));
		
		if(biduiflag==1)
		{
			Khxx khxxNew = new Khxx();
			khxxNew.setKhxxid(khxx.getKhxxid());
			khxxNew.setZjhm(khxx.getZjhm());
			khxxNew.setGjdm(khxx.getGjdm());
			khxxNew.setZt("2");
			khxxDao.updateKhxx(khxxNew);
		}
		return biduiflag;
	}

	/** @param 客户信息表(t_khxx) 查询单条 */
	public Khxx getKhxx(Khxx khxx){
		// TODO: implement
		return (Khxx)khxxDao.getKhxx(khxx);
	}
	
	/** @param 客户信息表(t_khxx) 查询单条 获得证件号码及国籍代码相同的客户信息中最新一条信息*/
	public Khxx getLatestKhxx(Khxx khxx)
	{
		Khxx khxxNew = new Khxx();
		khxxNew = khxxDao.getLatestKhxx(khxx);
		if(khxxNew!=null)
		{
			Integer khxxid = khxxNew.getKhxxid();
			Wgkhxx wgkhxx = new Wgkhxx();
			wgkhxx.setKhxxid(khxxid);
			wgkhxx = wgkhxxDao.getWgkhxx(wgkhxx);
			khxxNew.setWgkhxx(wgkhxx);
		}
		return khxxNew;
	}
	
	/**
	 * 查询客户信息 ，含外国客户信息
	 * @param khxx中传入的参数：国内人员传入zjhm。国外人员传入gjdm和zjhm
	 * @return
	 */
	public Khxx getKhxxAll(Khxx khxx)
	{
		Khxx khxxNew = new Khxx();
		Wgkhxx wgkhxxNew = new Wgkhxx();
		khxxNew = khxxDao.getKhxx(khxx);
		wgkhxxNew.setKhxxid(khxxNew.getKhxxid());
		wgkhxxNew = wgkhxxDao.getWgkhxx(wgkhxxNew);
		khxxNew.setWgkhxx(wgkhxxNew);
		return khxxNew;
	}
	
	/**
	 * 判断客户信息是否已存在
	 * @param khxx中传入的参数：gjdm和zjhm
	 * @return 0-不存在 1-存在
	 */
	public String isKhxxExist(Khxx khxx)
	{
		String isKhxxExist = "0";
		List khxxList = new ArrayList();
		khxxList = khxxDao.isKhxxExist(khxx);
		if(khxxList!=null)
		{
			if(khxxList.size()>0)
			{
				isKhxxExist = "1";
				
			}
		}
		return isKhxxExist;
	}
	
	/**
	 * 判断客户信息是否已存在。国内人员通过证件号码判断，外国人员通过国籍和证件号码判断
	 * @param khxx中传入的参数：国内人员传入zjhm;国外人员传入gjdm和zjhm
	 * @return Map::isKhxxExist:0-不存在 1-存在;biduiflag:1-报警
	 */
	public Khxx getKhxxExistAndBj(Khxx khxx) throws Exception
	{
		Map parameterMap = new HashMap();
		Khxx khxxNew = new Khxx();
		String isKhxxExist = "0";
		int biduiflag = 0;
		List khxxList = new ArrayList();
		khxxList = khxxDao.getListKhxx(khxx);
		if(khxxList!=null)
		{
			if(khxxList.size()>0)
			{
				isKhxxExist = "1";

				parameterMap = khxx.getParameterMap();
				biduiflag = updateKhxxBjCommon(khxx,parameterMap);
			}
		}
		
	
		parameterMap.put("isKhxxExist", isKhxxExist);
		parameterMap.put("biduiflag", biduiflag);
		
		khxxNew.setParameterMap(parameterMap);
		
		return khxxNew;
	}
	
	/**
	 * 客户报警
	 * @param Bjxxb 报警信息表，内含业务表相关字段（ddqyid、khxxid、xm、zjhm;）
	 * @return int baojingJg 0-传入参数有误,1-比中，2-未比中
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public int baojingDdkhxx(Bjxxb bjxxbIn) throws IllegalAccessException, InvocationTargetException
	{
		int baojingJg = 0;//报警返回结果
		String ywbzjValue = "";//业务表主键值
		ywbzjValue = String.valueOf(bjxxbIn.getYwbzj1());
		if(ywbzjValue!=null&&!"".equals(ywbzjValue))
		{
			boolean baojingJgTemp = false;
			Bjgz bjgz=new Bjgz();
			//此处只查询典当行业的报警规则
			bjgz.setHylbdm("E");
			//此处只查询有效的报警规则 是否有效(sfyx)：0-无效，1-自动报警有效，2-典当业客户手动报警有效
			bjgz.setSfyx("2");
	    	List bjgzList=bjgzService.getListBjgz(bjgz);
	    	Bjxxb bjxx=null;
	    	
	    	int count=0;
	    	if(bjgzList!=null)
	    	{
	    		String tmpYwbm="";
	    		for(int i=0;i<bjgzList.size();i++)
	    		{
	    			bjgz=(Bjgz)bjgzList.get(i);
	    			String ywbm=bjgz.getYwbm();
	    			if(!tmpYwbm.equals(ywbm))
	    			{
	    				tmpYwbm=ywbm;
	    				count++;
	    			}
	    		}
	    		List[] bjgzListCount = new ArrayList[count]; //分组列表，按照ywbm分组，每组的ywb进行所有规则比对后变更标志位
	    		//对每组ArrayList进行初始化
	    		int k=0;
	    		tmpYwbm="";
	    		for(int i=0;i<bjgzList.size();i++)
	    		{
	    			bjgz=(Bjgz)bjgzList.get(i);
	    			String ywbm=bjgz.getYwbm();
	    			if(!tmpYwbm.equals(ywbm))
	    			{
	    				tmpYwbm=ywbm;
	    				k++;
	    				bjgzListCount[k-1]=new ArrayList();
	    			}
	    			bjgzListCount[k-1].add(bjgz);
	    		}
	    		//与比对表比中的报警信息，由于存在身份证重号现象，所以使用列表
	    		List bjxxList = new ArrayList();
	    		for(int j=0;j<count;j++)
	    		{
	    			for(int i=0;i<bjgzListCount[j].size();i++)
	    			{
	    				bjgz=(Bjgz)bjgzListCount[j].get(i);
	    				String bdtjSql=bjbdtjService.getBjbdtjSql(bjgz,bjxxbIn);
	    				if(bjxxList!=null&&bjxxList.size()>0)
	    					bjxxList.clear();
	    				bjxxList=bjxxbService.getBjxxByBdtjSql(bjgz, bdtjSql, ywbzjValue);
	    				if(bjxxList!=null&&bjxxList.size()>0)
	    				{
	    					baojingJgTemp=baojingJgTemp||true;//比中
		    				for(int m=0;m<bjxxList.size();m++)
		    				{
		    					bjxx = new Bjxxb();
		    					bjxx = (Bjxxb)bjxxList.get(m);
		    					if(bjxx!=null)
		    					{
		        					String bdbm=bjxx.getBdbm();
		        					bjxx.setBjsj(new Date());
		        					bjxx.setJqztdm("0");
		        					bjxx.setJqzt("新报警");
		        					bjxxbService.insertBjxxb(bjxx);
		        						
		        					if(bdbm.toUpperCase().equals("T_QGZTJX"))
		        					{//增加全国在逃人员快照
		        						Qgztjx qgztjx=new Qgztjx();
		        						qgztjx.setQgztjxid(new Integer(bjxx.getBdbzj()));
		        						qgztjx=qgztjxService.getQgztjx(qgztjx);
		        						Qgztjx_kz qgztjx_kz=new Qgztjx_kz();
		        						BeanUtils.copyProperties(qgztjx_kz, qgztjx);
		        						qgztjx_kz.setBjgzid(bjgz.getBjgzid());
		        						qgztjx_kz.setBjxxid(bjxx.getBjxxid());
		        						//kz_id通过DAO insertQgztjx_kz方法获取
		        						qgztjxkzService.insertQgztjx_kz(qgztjx_kz);	
		        					}
		        					else if(bdbm.toUpperCase().equals("T_BKRY"))
		        					{//增加布控人员快照
		        						Bkry bkry=new Bkry();
		        						bkry.setBkryid(new Integer(bjxx.getBdbzj()));
		        						bkry=bkryService.getBkry(bkry);
		        						Bkry_kz bkry_kz=new Bkry_kz();
		        						BeanUtils.copyProperties(bkry_kz, bkry);
		        						bkry_kz.setBjgzid(bjgz.getBjgzid());
		        						bkry_kz.setBjxxid(bjxx.getBjxxid());
		        						//KZID 同上一样获取
		        						bkrykzService.insertBkry_kz(bkry_kz);
		        					}
	 	        				}
		        			}
		            	}
	    			}
	    		}
	    	}
	    	if(baojingJgTemp)
	    		baojingJg=1;
	    	else
	    		baojingJg=2;
		}
		return baojingJg;
	}

	/** @param 客户信息表(t_khxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return khxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 客户信息表(t_khxx) 多条查询 */
	public List getListKhxx(Khxx khxx){
		// TODO: implement
		return khxxDao.getListKhxx(khxx);
	}

	public IKhxxDao getKhxxDao() {
		return khxxDao;
	}

	public void setKhxxDao(IKhxxDao khxxDao) {
		this.khxxDao = khxxDao;
	}

	public IWgkhxxDao getWgkhxxDao() {
		return wgkhxxDao;
	}

	public void setWgkhxxDao(IWgkhxxDao wgkhxxDao) {
		this.wgkhxxDao = wgkhxxDao;
	}

	public IBjxxbService getBjxxbService() {
		return bjxxbService;
	}

	public void setBjxxbService(IBjxxbService bjxxbService) {
		this.bjxxbService = bjxxbService;
	}

	public void setBjbdtjService(IBjbdtjService bjbdtjService) {
		this.bjbdtjService = bjbdtjService;
	}

	public void setQgztjxService(IQgztjxService qgztjxService) {
		this.qgztjxService = qgztjxService;
	}

	public void setQgztjxkzService(IQgztjx_kzService qgztjxkzService) {
		this.qgztjxkzService = qgztjxkzService;
	}

	public void setBkryService(IBkryService bkryService) {
		this.bkryService = bkryService;
	}

	public void setBkrykzService(IBkry_kzService bkrykzService) {
		this.bkrykzService = bkrykzService;
	}

	public void setBjgzService(IBjgzService bjgzService) {
		this.bjgzService = bjgzService;
	}
}
