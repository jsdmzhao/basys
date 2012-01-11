package com.aisino2.basicsystem.service.impl;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.basicsystem.dao.IBjxxbDao;
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

public class BjxxbServiceImpl extends BaseService implements IBjxxbService {

	private IBjxxbDao bjxxbDao;
	
	
	private IBjgzService bjgzService;
	private IBjbdtjService bjbdtjService;
	private IQgztjx_kzService qgztjxkzService;
	private IQgztjxService qgztjxService;
	private IBkryService bkryService;
	private IBkry_kzService bkrykzService;
	/**
	 * @param 报警信息表(t_bjxxb)
	 *            增加
	 */
	public Bjxxb insertBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		return (Bjxxb) bjxxbDao.insertBjxxb(bjxxb);
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            删除
	 */
	public boolean deleteBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		return bjxxbDao.deleteBjxxb(bjxxb) > 0;
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            修改
	 */
	public boolean updateBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		return bjxxbDao.updateBjxxb(bjxxb) > 0;
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            查询单条
	 */
	public Bjxxb getBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		return (Bjxxb) bjxxbDao.getBjxxb(bjxxb);
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {
		// TODO: implement
		return bjxxbDao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	/**
	 * @param 报警信息表(t_bjxxb)
	 *            多条查询
	 */
	public List getListBjxxb(Bjxxb bjxxb) {
		// TODO: implement
		return bjxxbDao.getListBjxxb(bjxxb);
	}

	public IBjxxbDao getBjxxbDao() {
		return bjxxbDao;
	}

	public void setBjxxbDao(IBjxxbDao bjxxbDao) {
		this.bjxxbDao = bjxxbDao;
	}

	public Map getKzbmc(Bjxxb bjxxb) {
		return bjxxbDao.getKzbmc(bjxxb);
	}
	
	/** @param 报警信息表(t_bjxxb) 分页查询 主页面 */
	public Page getMainListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		
		return bjxxbDao.getMainListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List getListExportBjxxb(Map map, String sort, String dir) {
		// TODO Auto-generated method stub
		return bjxxbDao.getListExportBjxxb(map,sort,dir);
	}
	
	/** @param 报警信息表(t_bjxxb) 分页查询 报警客户端得页面 */
	public Page getClientListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		
		return bjxxbDao.getClientListForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 报警信息表(t_bjxxb)条数 */
	public int getBjxxbCount(Map map){
		return bjxxbDao.getBjxxbCount(map);
	}
	
	/** ByTy 按照比对规则SQL执行查询，由于身份证重号现象，所以返回报警信息列表 bjgz-报警规则（业务表名，业务表字段名）, bdtjSql-自定义sql,zjhm-证件号码*/
	public List getBjxxByBdtjSql(Bjgz bjgz, String bdtjSql,String zjhm)
	{
		//bdtjSql=bdtjSql+" and "+bjgz.getYwbm()+"."+bjgz.getYwbzdm()+"="+zjhm;
		Bjxxb bjxxb = new Bjxxb();
		bjxxb.setBdtjSql(bdtjSql);
		return bjxxbDao.getBjxxByBdtjSql(bjxxb);
	}
	
	/**
	 * 客户信息报警
	 * @param 传入参数1： bjxxbIn 存放：ywbzj1-客户id，ywbzj2-企业id，xm-姓名，zjhm-证件号码
	 * @param 传入参数2：hylbdm 行业类别代码
	 * @param 传入参数3：sfyx 报警规则有效标志,增加新的行业时，可增加如下注释说明：
	 * @param sfyx 0-所有人员报警条件无效
	 * @param sfyx 1-从业人员自动报警条件有效
	 * @param sfyx 2-典当业客户 (报警规则中另外增加：21-国内当户，22-国内委托人，23-国内赎当人 此3个规则仅供报警后台客户报警方法使用)
	 * @param sfyx 31-机修业送车人, 32-机修业取车人
	 * @param sfyx 4-公用模块车主
	 * @param sfyx 5-二手车车主委托人、购买人、卖车人、卖车委托人、卖车被委托人(报警规则中另外增加：51-车主委托人，52-购买人，53-卖车人，54-卖车委托人，54-卖车被委托人 此5个规则仅供报警后台客户报警方法使用)
	 * @param sfyx 61-出租车驾驶员
	 * @param sfyx 71-二手手机出售人员，72-二手手机摊主,73-摊位从业人员
	 * @param sfyx 8-汽车租赁业租车客户
	 * @param sfyx 91-委托寄卖业物品所有人，92-委托寄卖业物品委托人，93-委托寄卖业货物去向联系人
	 * @param sfyx 101-机动车拆解业送车人
	 * 
	 * @return int 0-传入参数有误,1-比中，2-未比中
	 */
	public int baojingKhxx(Bjxxb bjxxbIn,String hylbdm,String sfyx) throws IllegalAccessException, InvocationTargetException{
		// TODO Auto-generated method stub
		int baojingJg = 0;//报警返回结果
		String ywbzjValue = "";//业务表主键值
		ywbzjValue = String.valueOf(bjxxbIn.getYwbzj1());
		if(ywbzjValue!=null&&!"".equals(ywbzjValue))
		{
			boolean baojingJgTemp = false;
			Bjgz bjgz=new Bjgz();
			//此处只查询指定行业的报警规则
			bjgz.setHylbdm(hylbdm);
			//此处只查询有效的报警规则
			bjgz.setSfyx(sfyx);
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
	    				bjxxList=getBjxxByBdtjSql(bjgz, bdtjSql, ywbzjValue);
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
		        					insertBjxxb(bjxx);
		        						
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

	public IBjgzService getBjgzService() {
		return bjgzService;
	}

	public void setBjgzService(IBjgzService bjgzService) {
		this.bjgzService = bjgzService;
	}

	public IBjbdtjService getBjbdtjService() {
		return bjbdtjService;
	}

	public void setBjbdtjService(IBjbdtjService bjbdtjService) {
		this.bjbdtjService = bjbdtjService;
	}

	public IQgztjx_kzService getQgztjxkzService() {
		return qgztjxkzService;
	}

	public void setQgztjxkzService(IQgztjx_kzService qgztjxkzService) {
		this.qgztjxkzService = qgztjxkzService;
	}

	public IQgztjxService getQgztjxService() {
		return qgztjxService;
	}

	public void setQgztjxService(IQgztjxService qgztjxService) {
		this.qgztjxService = qgztjxService;
	}

	public IBkryService getBkryService() {
		return bkryService;
	}

	public void setBkryService(IBkryService bkryService) {
		this.bkryService = bkryService;
	}

	public IBkry_kzService getBkrykzService() {
		return bkrykzService;
	}

	public void setBkrykzService(IBkry_kzService bkrykzService) {
		this.bkrykzService = bkrykzService;
	}
}
