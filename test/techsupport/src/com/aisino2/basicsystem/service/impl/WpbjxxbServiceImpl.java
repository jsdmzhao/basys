package com.aisino2.basicsystem.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.basicsystem.dao.IWpbjxxbDao;
import com.aisino2.basicsystem.domain.Bdqclxx;
import com.aisino2.basicsystem.domain.Bdqclxxkz;
import com.aisino2.basicsystem.domain.Bkcl;
import com.aisino2.basicsystem.domain.Bkclkz;
import com.aisino2.basicsystem.domain.Bksj;
import com.aisino2.basicsystem.domain.Bksjkz;
import com.aisino2.basicsystem.domain.Bkwpkbxx;
import com.aisino2.basicsystem.domain.Bkwpkbxxkz;
import com.aisino2.basicsystem.domain.Sjbdqxx;
import com.aisino2.basicsystem.domain.Sjbdqxxkz;
import com.aisino2.basicsystem.domain.WpbaojingTemp;
import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.basicsystem.service.IBdqclxxService;
import com.aisino2.basicsystem.service.IBdqclxxkzService;
import com.aisino2.basicsystem.service.IBkclService;
import com.aisino2.basicsystem.service.IBkclkzService;
import com.aisino2.basicsystem.service.IBksjService;
import com.aisino2.basicsystem.service.IBksjkzService;
import com.aisino2.basicsystem.service.IBkwpkbxxService;
import com.aisino2.basicsystem.service.IBkwpkbxxkzService;
import com.aisino2.basicsystem.service.ISjbdqxxService;
import com.aisino2.basicsystem.service.ISjbdqxxkzService;
import com.aisino2.basicsystem.service.IWpbjbdtjService;
import com.aisino2.basicsystem.service.IWpbjgzService;
import com.aisino2.basicsystem.service.IWpbjxxbService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

/**
 * 
 * @author cuixiaosong
 *
 */
public class WpbjxxbServiceImpl extends BaseService implements IWpbjxxbService {

	private IWpbjxxbDao wpbjxxbDao;
	private IWpbjgzService wpbjgzService;
	private IWpbjbdtjService wpbjbdtjService;
	
	private IBkclService bkclService;
	private IBkwpkbxxService bkwpkbxxService;
	private IBkclkzService bkclkzService;
	private IBkwpkbxxkzService bkwpkbxxkzService;
	
	private IBdqclxxService bdqclxxService;
	private IBdqclxxkzService bdqclxxkzService;
	
	private IBksjService bksjService;
	private IBksjkzService bksjkzService;
	private ISjbdqxxService sjbdqxxService;
	private ISjbdqxxkzService sjbdqxxkzService;


	

	public void setBdqclxxService(IBdqclxxService bdqclxxService) {
		this.bdqclxxService = bdqclxxService;
	}

	public void setBdqclxxkzService(IBdqclxxkzService bdqclxxkzService) {
		this.bdqclxxkzService = bdqclxxkzService;
	}

	public void setBkwpkbxxkzService(IBkwpkbxxkzService bkwpkbxxkzService) {
		this.bkwpkbxxkzService = bkwpkbxxkzService;
	}

	public void setBkclkzService(IBkclkzService bkclkzService) {
		this.bkclkzService = bkclkzService;
	}

	public void setBkwpkbxxService(IBkwpkbxxService bkwpkbxxService) {
		this.bkwpkbxxService = bkwpkbxxService;
	}

	public void setBkclService(IBkclService bkclService) {
		this.bkclService = bkclService;
	}

	public void setWpbjgzService(IWpbjgzService wpbjgzService) {
		this.wpbjgzService = wpbjgzService;
	}

	/** @param 物品报警信息表(t_wpbjxxb) 增加 */
	public Wpbjxxb insertWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		return (Wpbjxxb)wpbjxxbDao.insertWpbjxxb(wpbjxxb);
	}

	/** @param 物品报警信息表(t_wpbjxxb) 删除 */
	public boolean deleteWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		return wpbjxxbDao.deleteWpbjxxb(wpbjxxb)>0;
	}

	/** @param 物品报警信息表(t_wpbjxxb) 修改 */
	public boolean updateWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		return wpbjxxbDao.updateWpbjxxb(wpbjxxb)>0;
	}

	/** @param 物品报警信息表(t_wpbjxxb) 查询单条 */
	public Wpbjxxb getWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		return (Wpbjxxb)wpbjxxbDao.getWpbjxxb(wpbjxxb);
	}
	
	
	/** @param 物品报警信息表(t_wpbjxxb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wpbjxxbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 物品报警信息表(t_wpbjxxb) 多条查询 */
	public List getListWpbjxxb(Wpbjxxb wpbjxxb){
		// TODO: implement
		return wpbjxxbDao.getListWpbjxxb(wpbjxxb);
	}

	public IWpbjxxbDao getWpbjxxbDao() {
		return wpbjxxbDao;
	}

	public void setWpbjxxbDao(IWpbjxxbDao wpbjxxbDao) {
		this.wpbjxxbDao = wpbjxxbDao;
	}
	
	/**
	 * 车辆物品的信息
	 * @param wpbjgz
	 * @param recordNum
	 * @return
	 */
	public List getWpBaojingTempList(Wpbjgz wpbjgz, Integer recordNum){
		return wpbjxxbDao.getWpBaojingTempList(wpbjgz, recordNum);
	}
	
	
	/**
	 *  报警方法 车辆、手机
	 * @param Wpbjxxb 物品报警信息表，内含业务表相关字段（ddqyid、ddwpclid、ddwpsjid、wpmc、wpjp、wpqp、hphm、fdjhcl、sbdh、cjh、sjch）
	 * @param sfyx-物品类别,增加新的行业时，可增加如下注释说明：
	 * @param sfyx 1-典当车辆
	 * @param sfyx 2-典当手机
	 * @param sfyx 3-机修业车辆
	 * @param sfyx 4-公用车辆
	 * @param sfyx 
	 * @param sfyx 6-二手手机
	 * @param sfyx 
	 * @return int 1-比中，2-未比中
	 */
   public int BaoJingCl(Wpbjxxb wpbjxxbIn,String sfyx)throws IllegalAccessException, InvocationTargetException{
	   int baojingJg = 0;//报警返回结果
	   Wpbjgz wpbjgz = new Wpbjgz();
		wpbjgz.setSfyx(sfyx);//报警规则中，设置是否有效字段：0-该规则无效，1-典当车辆规则，2-典当手机规则 ，3-机修业车辆

		List wpbjgzList = wpbjgzService.getListWpbjgz(wpbjgz);
		List wpbaojingTempList = new ArrayList();
		WpbaojingTemp wpbaojingTemp = null;      //临时报警信息实体bean
		Wpbjxxb wpbjxxb = null;
		int count=0;
		String ywbzjvalue = "";
		ywbzjvalue = String.valueOf(wpbjxxbIn.getYwbzj1());
		//报警规则不为空的,进行比对；为空，则直接返回未比中
		if(wpbjgzList!=null)
		{
			boolean baojingJgTemp = false;
			String tmpYwbm="";
			for(int i=0;i<wpbjgzList.size();i++){
				wpbjgz=(Wpbjgz)wpbjgzList.get(i);
    			String ywbm=wpbjgz.getYwbm();
    			if(!tmpYwbm.equals(ywbm)){
    				tmpYwbm=ywbm;
    				count++;
    			}
    		}
			///这种算法要求业务表名相同的规则在表中的id要相邻
			List[] wpbjgzListCount = new ArrayList[count]; //分组列表，按照ywbm分组，每组的ywb进行所有规则比对后变更标志位
			//对每组ArrayList进行初始化
    		int k=0;
    		tmpYwbm="";
    		for(int i=0;i<wpbjgzList.size();i++){
    			wpbjgz=(Wpbjgz)wpbjgzList.get(i);
    			String ywbm=wpbjgz.getYwbm();
    			if(!tmpYwbm.equals(ywbm)){
    				tmpYwbm=ywbm;
    				k++;
    				wpbjgzListCount[k-1]=new ArrayList();
    			}
    			wpbjgzListCount[k-1].add(wpbjgz);
    		}
    		List wpbjxxList = new ArrayList();
    		for(int j=0;j<count;j++){
    			for(int i=0;i<wpbjgzListCount[j].size();i++){
    				wpbjgz = (Wpbjgz)wpbjgzListCount[j].get(i);
    				String sql=wpbjbdtjService.getBjbdtjSql(wpbjgz,wpbjxxbIn);  //通过报警规则 和条件  生成的sql
    				
    				if(wpbjxxList!=null&&wpbjxxList.size()>0)
    					wpbjxxList.clear();
    				wpbjxxList=selectBjxxCl(wpbjgz.getYwbm(),wpbjgz.getYwbzdm(),ywbzjvalue,sql);
    				//与比对表比中的报警信息，由于存在重复记录，所以使用列表

    				if(wpbjxxList!=null&&wpbjxxList.size()>0)
    				{
    					baojingJgTemp=baojingJgTemp||true;//比中
	    				for(int m=0;m<wpbjxxList.size();m++)
	    				{
	    					wpbjxxb = new Wpbjxxb();
	    					wpbjxxb = (Wpbjxxb)wpbjxxList.get(m);
	    					if(wpbjxxb!=null)
	        				{
	    						String bdbm=wpbjxxb.getBdbm();   ///得到比对表名称

	    						//去除hylb、bjlx、wpmc的空格.查询结果无空格，但经ibatis映射到结果集后，出现空格。尚未找到原因，只能先做如下处理
	    						if(wpbjxxb.getBjlx()!=null)
	    							wpbjxxb.setBjlx(wpbjxxb.getBjlx().trim());
	    						if(wpbjxxb.getHylb()!=null)
	    							wpbjxxb.setHylb(wpbjxxb.getHylb().trim());
	    						if(wpbjxxb.getWpmc()!=null)
	    							wpbjxxb.setWpmc(wpbjxxb.getWpmc().trim());
	    						insertWpbjxxb(wpbjxxb);          //比中数据 插入到物品报警信息表
	    						if(bdbm.toUpperCase().equals("T_BDQCLXX"))
	    						{//被盗抢车辆表快照
	    							Bdqclxx  bdqclxx = new Bdqclxx();
	    							bdqclxx.setBdqclxxid(Integer.parseInt(wpbjxxb.getBdbzj()));
	    							bdqclxx=bdqclxxService.getBdqclxx(bdqclxx);
	    							Bdqclxxkz bdqclxxkz = new Bdqclxxkz();
	    							BeanUtils.copyProperties(bdqclxxkz, bdqclxx);
	    							bdqclxxkz.setWpbjgzid(wpbjgz.getWpbjgzid());
	    							bdqclxxkz.setBjxxid2(wpbjxxb.getBjxxid2());
	    							bdqclxxkzService.insertBdqclxxkz(bdqclxxkz);

	    						}
	    						else if(bdbm.toUpperCase().equals("T_BKCL"))
	    						{//车辆布控表快照

	    							Bkcl bkcl = new Bkcl(); //布控车辆
	    							bkcl.setBkwpjbxxid(Integer.parseInt(wpbjxxb.getBdbzj()));
	    							Bkwpkbxx bkwpkbxx = new Bkwpkbxx(); //布控物品基本信息
	    							bkwpkbxx.setBkwpjbxxid(Integer.parseInt(wpbjxxb.getBdbzj()));
	    							bkcl= bkclService.getBkcl(bkcl);
	    							bkwpkbxx = bkwpkbxxService.getBkwpkbxx(bkwpkbxx);
	    							Bkclkz bkclkz = new Bkclkz();
	    							Bkwpkbxxkz bkwpkbxxkz = new Bkwpkbxxkz();
	    							
	    							BeanUtils.copyProperties(bkclkz, bkcl);
	    							BeanUtils.copyProperties(bkwpkbxxkz, bkwpkbxx);
	    							bkclkz.setBjxxid2(wpbjxxb.getBjxxid2());
	    							bkwpkbxxkz.setBjxxid2(wpbjxxb.getBjxxid2());
	    							bkwpkbxxkz.setWpbjgzid(wpbjgz.getWpbjgzid());
	    							bkwpkbxxkzService.insertBkwpkbxxkz(bkwpkbxxkz);
	    							
	    							bkclkz.setBkwpjbxxkzid(bkwpkbxxkz.getBkwpjbxxkzid());
	    							bkclkz.setWpbjgzid(wpbjgz.getWpbjgzid());
	    							bkclkzService.insertBkclkz(bkclkz);

	    						}
	    						else if(bdbm.toUpperCase().equals("T_SJBDQXX"))
	    						{//手机被盗抢快照

	    							Sjbdqxx  sjbdqxx = new Sjbdqxx();
	    							sjbdqxx.setSjbdqxxid(Integer.parseInt(wpbjxxb.getBdbzj()));
	    							sjbdqxx=sjbdqxxService.getSjbdqxx(sjbdqxx);
	    							Sjbdqxxkz sjbdqxxkz = new Sjbdqxxkz();
	    							BeanUtils.copyProperties(sjbdqxxkz, sjbdqxx);
	    							sjbdqxxkz.setWpbjgzid(wpbjgz.getWpbjgzid());
	    							sjbdqxxkz.setBjxxid2(wpbjxxb.getBjxxid2());
	    							sjbdqxxkzService.insertSjbdqxxkz(sjbdqxxkz);

	    						}
	    						else if(bdbm.toUpperCase().equals("T_BKSJ"))
	    						{//手机布控表快照

	    							Bksj bksj = new Bksj(); //布控手机
	    							bksj.setBkwpjbxxid(Integer.parseInt(wpbjxxb.getBdbzj()));
	    							Bkwpkbxx bkwpkbxx = new Bkwpkbxx(); //布控物品基本信息
	    							bkwpkbxx.setBkwpjbxxid(Integer.parseInt(wpbjxxb.getBdbzj()));
	    							bksj= bksjService.getBksj(bksj);
	    							bkwpkbxx = bkwpkbxxService.getBkwpkbxx(bkwpkbxx);
	    							Bksjkz bksjkz = new Bksjkz();
	    							Bkwpkbxxkz bkwpkbxxkz = new Bkwpkbxxkz();
	    							
	    							BeanUtils.copyProperties(bksjkz, bksj);
	    							BeanUtils.copyProperties(bkwpkbxxkz, bkwpkbxx);
	    							bksjkz.setBjxxid2(wpbjxxb.getBjxxid2());
	    							bkwpkbxxkz.setWpbjgzid(wpbjgz.getWpbjgzid());
	    							bkwpkbxxkz.setBjxxid2(wpbjxxb.getBjxxid2());
	    							bkwpkbxxkzService.insertBkwpkbxxkz(bkwpkbxxkz);
	    							
	    							bksjkz.setWpbjgzid(wpbjgz.getWpbjgzid());
	    							bksjkz.setBkwpjbxxkzid(bkwpkbxxkz.getBkwpjbxxkzid());
	    							bksjkzService.insertBksjkz(bksjkz);

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
	
	public List selectBjxxCl(String ywb, String ywbzjzd, String ywbzjvalue, String sql) {
		//sql=sql+" and "+ywb+"."+ywbzjzd+"="+ywbzjvalue;
		return wpbjxxbDao.getWpBaoJingXX(sql);
	}
	
	
	/**
	 * 物品报警方法
	 * 
	 * 自动比对的方法   由于页面改变  不需要物品的自动比对 要在输入物品的时候实时比对
	 * 因此这个方法暂时没有用
	 * 该方法未完成，如果需要物品自动比较 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void BaoJingWp(Wpbjxxb wpbjxxbIn,Integer recordNum) throws Exception{
		Wpbjgz wpbjgz = new Wpbjgz();
		List wpbjgzList = wpbjgzService.getListWpbjgz(wpbjgz);
		List wpbaojingTempList = new ArrayList();
		WpbaojingTemp wpbaojingTemp = null;      ////临时报警信息实体bean
		Wpbjxxb wpbjxxb = null;
		//System.out.println(wpbjgzList.size());
		int count=0;
		if(wpbjgzList!=null){
			///////报警规则不为空的情况
			String tmpYwbm="";
			for(int i=0;i<wpbjgzList.size();i++){
				wpbjgz=(Wpbjgz)wpbjgzList.get(i);
    			String ywbm=wpbjgz.getYwbm();
    			if(!tmpYwbm.equals(ywbm)){
    				tmpYwbm=ywbm;
    				count++;
    			}
    		}
			///这种算法要求业务表名相同的规则在表中的id要相邻
			List[] wpbjgzListCount = new ArrayList[count]; //分组列表，按照ywbm分组，每组的ywb进行所有规则比对后变更标志位
			//对每组ArrayList进行初始化
    		int k=0;
    		tmpYwbm="";
    		for(int i=0;i<wpbjgzList.size();i++){
    			wpbjgz=(Wpbjgz)wpbjgzList.get(i);
    			String ywbm=wpbjgz.getYwbm();
    			if(!tmpYwbm.equals(ywbm)){
    				tmpYwbm=ywbm;
    				k++;
    				wpbjgzListCount[k-1]=new ArrayList();
    			}
    			wpbjgzListCount[k-1].add(wpbjgz);
    		}
    		
    		for(int j=0;j<count;j++){
    			for(int i=0;i<wpbjgzListCount[j].size();i++){
    				wpbjgz = (Wpbjgz)wpbjgzListCount[j].get(i);
    				String sql=wpbjbdtjService.getBjbdtjSql(wpbjgz,wpbjxxbIn);  ////////////通过报警规则 和条件  生成的sql
    				if(wpbjgz.getYwbm().toUpperCase().equals("T_DDWPCL")){
    					/////业务表式典当物品_车辆
    					wpbaojingTempList=getWpBaojingTempList(wpbjgz,recordNum);	
    				}
    				for(int m=0;m<wpbaojingTempList.size();m++){
    					wpbaojingTemp=(WpbaojingTemp)wpbaojingTempList.get(m);
    				    
    					//wpbjxxb=selectBjxx(wpbaojingTemp,sql);
    					
    					String ywbm=wpbaojingTemp.getYwb();  ////业务表名
    					
    					if(wpbjxxb!=null){////比中
    						String bdbm=wpbjxxb.getBdbm();   ///得到比对表名称
    						insertWpbjxxb(wpbjxxb);          ////比中数据 插入到物品报警信息表
    						
    						if(bdbm.toUpperCase().equals("T_BKCL")){//物品布控表快照
    							
    							Bkcl bkcl = new Bkcl(); //布控车辆
    							bkcl.setBkwpjbxxid(Integer.parseInt(wpbjxxb.getBdbzj()));
    							Bkwpkbxx bkwpkbxx = new Bkwpkbxx(); //布控物品基本信息
    							bkwpkbxx.setBkwpjbxxid(Integer.parseInt(wpbjxxb.getBdbzj()));
    							bkcl= bkclService.getBkcl(bkcl);
    							bkwpkbxx = bkwpkbxxService.getBkwpkbxx(bkwpkbxx);
    							Bkclkz bkclkz = new Bkclkz();
    							Bkwpkbxxkz bkwpkbxxkz = new Bkwpkbxxkz();
    							
    							BeanUtils.copyProperties(bkclkz, bkcl);
    							BeanUtils.copyProperties(bkwpkbxxkz, bkwpkbxx);
    							
    							
    							bkclkz.setBjxxid2(wpbjxxb.getBjxxid2());
    							bkwpkbxxkz.setBjxxid2(wpbjxxb.getBjxxid2());
    							
    							bkclkzService.insertBkclkz(bkclkz);
    							bkwpkbxxkzService.insertBkwpkbxxkz(bkwpkbxxkz);
    							
    						}
    						else if(bdbm.toUpperCase().equals("T_BDQCLXX"))
    						{
    						}
    					}
    				}
    			}
    		}
		}
	}
    

	public List selectBjxx(WpbaojingTemp wpbaojingTemp,String sql) {
		sql=sql+" and "+wpbaojingTemp.getYwbzjzd()+"="+wpbaojingTemp.getYwbzj();
		return wpbjxxbDao.getWpBaoJingXX(sql);
	}
	
	public void setWpbjbdtjService(IWpbjbdtjService wpbjbdtjService) {
		this.wpbjbdtjService = wpbjbdtjService;
	}

	public void setSjbdqxxService(ISjbdqxxService sjbdqxxService) {
		this.sjbdqxxService = sjbdqxxService;
	}

	public void setSjbdqxxkzService(ISjbdqxxkzService sjbdqxxkzService) {
		this.sjbdqxxkzService = sjbdqxxkzService;
	}

	public void setBksjService(IBksjService bksjService) {
		this.bksjService = bksjService;
	}

	public void setBksjkzService(IBksjkzService bksjkzService) {
		this.bksjkzService = bksjkzService;
	}

	
}
