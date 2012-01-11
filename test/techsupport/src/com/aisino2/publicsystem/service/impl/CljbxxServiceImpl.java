package com.aisino2.publicsystem.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.basicsystem.service.IBjxxbService;
import com.aisino2.basicsystem.service.IWpbjxxbService;
import com.aisino2.cache.CacheManager;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.ICljbxxDao;
import com.aisino2.publicsystem.dao.IClxx_zpDao;
import com.aisino2.publicsystem.dao.IClxxry_zpDao;
import com.aisino2.publicsystem.dao.IClxxwgryxxDao;
import com.aisino2.publicsystem.domain.Cljbxx;
import com.aisino2.publicsystem.domain.Clxx_zp;
import com.aisino2.publicsystem.domain.Clxxry_zp;
import com.aisino2.publicsystem.domain.Clxxwgryxx;
import com.aisino2.publicsystem.domain.Khxx;
import com.aisino2.publicsystem.service.ICljbxxService;
import com.aisino2.publicsystem.service.IKhxxService;
import com.aisino2.sysadmin.domain.Globalpar;

public class CljbxxServiceImpl extends BaseService implements ICljbxxService {

	private ICljbxxDao cljbxxDao;
	private IClxx_zpDao clxx_zpDao;
	private IClxxry_zpDao clxxry_zpDao;
	private IScbmDao scbmDao;
	private IClxxwgryxxDao clxxwgryxxDao;
	private IWpbjxxbService wpbjxxbService;
	private IBjxxbService bjxxbService;
	private IKhxxService khxxService;

	/** @param 车辆基本信息(t_cljbxx) 增加 */
	public Cljbxx insertCljbxx(Cljbxx cljbxx){
		// TODO: implement		
		//参数Map
		Map parameterMap = cljbxx.getParameterMap(); 
		
		Clxxwgryxx clxxwgryxx = cljbxx.getClxxwgryxx();
		boolean wgryIsNull = (clxxwgryxx!=null);
		//如果是外国人设置相关属性
		if(wgryIsNull){
			cljbxx.setCzm(clxxwgryxx.getYwx() + " " + clxxwgryxx.getYwm());//车主姓名
			cljbxx.setCzcyzjlxdm(clxxwgryxx.getQzzldm());//证件种类代码——签证种类代码
			cljbxx.setCzcyzj(clxxwgryxx.getQzzl());//证件种类——签证种类
			cljbxx.setCzzjhm(clxxwgryxx.getQzhm());//证件号码——签证号码
		}else{
			cljbxx.setCzgj("中国");
			cljbxx.setCzgjdm("CHN");
		}
		
		//生成cldjxh（车辆登记序号）
		String sssf = "hn";
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode("sssf");
		List globalparList = CacheManager.getCacheGlobalpar(globalpar);
		if(globalparList!=null && globalparList.size()==1)
			sssf = ((Globalpar)globalparList.get(0)).getGlobalparvalue();
		Map map = new HashMap();
		map.put("p_bmfl", "CLDJXH");
		map.put("p_xzqh", parameterMap.get("qybm"));
		map.put("p_sssf", sssf);
		map.put("p_scgz", 2);
		cljbxx.setCldjxh(scbmDao.getScbm(map));
		
		//企业ID
		cljbxx.setQyid((Integer)parameterMap.get("qyid"));
		
		//添加车辆基本信息
		cljbxx.setSfycphbz("0");//是否有车牌标示 0：有车牌 1：无车牌
		cljbxx.setClzt("0");//车辆状态
		cljbxx.setCzzt("0");//车主状态
		cljbxx.setLrsj(new Date());//录入时间 
		cljbxx.setCxbz("0");//撤销标志  0：未撤销  1：已撤销
		cljbxx = (Cljbxx)cljbxxDao.insertCljbxx(cljbxx);
		Integer cljbxxid = cljbxx.getCljbxxid();
		
		//添加车辆照片
		List clxx_zpList = cljbxx.getLClxx_zpList();
		if(clxx_zpList!=null){
			Clxx_zp clxx_zp ;
			int listLength = clxx_zpList.size();
			for(int index=0;index<listLength;index++){
				clxx_zp = (Clxx_zp)clxx_zpList.get(index);
				clxx_zp.setCljbxxid(cljbxxid);
				clxx_zpDao.insertClxx_zp(clxx_zp);
			}
		}
		
		//添加人员照片
		List clxxryList = cljbxx.getLClxxry_zpList();
		Clxxry_zp clxxry_zp;
		if(clxxryList!=null && clxxryList.size()>0){
			int listLength = clxxryList.size();
			for(int index=0;index<listLength;index++){
				clxxry_zp = (Clxxry_zp)clxxryList.get(index);
				clxxry_zp.setCljbxxid(cljbxxid);
				clxxry_zpDao.insertClxxry_zp(clxxry_zp);
			}
		}else{
			clxxry_zp = new Clxxry_zp();
			clxxry_zp.setCljbxxid(cljbxxid);
			clxxry_zpDao.insertClxxry_zp(clxxry_zp);
		}
		
		//添加外国人员信息
		if(wgryIsNull){
			clxxwgryxx.setCljbxxid(cljbxxid);
			clxxwgryxxDao.insertClxxwgryxx(clxxwgryxx);
		}
		
		//报警
		baojingClAndCz(cljbxx, parameterMap);
		
		//报警后，更新信息
		Cljbxx updateCljbxx = new Cljbxx();
		updateCljbxx.setCljbxxid(cljbxxid);
		updateCljbxx.setCzzt(cljbxx.getCzzt());
		updateCljbxx.setClzt(cljbxx.getClzt());
		cljbxxDao.updateCljbxx(updateCljbxx);
		
		return cljbxx;
	}
	
	//车辆和车主报警方法
	private void baojingClAndCz(Cljbxx cljbxx, Map parameterMap){
		if(parameterMap==null)
			parameterMap = new HashMap();
		parameterMap.put("biduiflag", 0);
		if(cljbxx.getCzzjhm()==null)cljbxx.setCzzjhm("");
		if(cljbxx.getCph()==null)cljbxx.setCph("");
		if(cljbxx.getCjh()==null)cljbxx.setCjh("");
		if(cljbxx.getFdjh()==null)cljbxx.setFdjh("");
			
		Integer qiyeId = (Integer)parameterMap.get("qyid");
		//String hylbdm = (String)parameterMap.get("hylbdm");
		//车主报警
		String sfgczbj = (String)parameterMap.get("sfgczbj");
		if(sfgczbj==null || (!sfgczbj.equals("no"))){
			Bjxxb bjxxbIn = new Bjxxb();
			bjxxbIn.setYwbzj1(cljbxx.getCljbxxid());
			bjxxbIn.setYwbzj2(qiyeId);
			bjxxbIn.setZjhm(cljbxx.getCzzjhm());
			bjxxbIn.setXm(cljbxx.getCzm());
			try {
				int biduiflagRy = bjxxbService.baojingKhxx(bjxxbIn, null, (String)parameterMap.get("sfyx"));
				cljbxx.setCzzt(biduiflagRy+"");
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//车辆报警
		String sfgclbj = (String)parameterMap.get("sfgclbj");
		if(sfgclbj==null || (!sfgclbj.equals("no"))){
			Wpbjxxb wpbjxxbIn = new Wpbjxxb();
			wpbjxxbIn.setYwbzj2(qiyeId);//企业ID
			wpbjxxbIn.setYwbzj1(cljbxx.getCljbxxid());//车辆ID
			wpbjxxbIn.setHphm(cljbxx.getCph());//车牌号
			wpbjxxbIn.setFdjh(cljbxx.getFdjh());//发动机号
			wpbjxxbIn.setCjh(cljbxx.getCjh());//车架号
			//wpbjxxbIn.setHylbdm(hylbdm);
			//wpbjxxbIn.setHylb((String)parameterMap.get("hylb"));
			try {
				int biduiflag = wpbjxxbService.BaoJingCl(wpbjxxbIn, (String)parameterMap.get("wplb"));
				parameterMap.put("biduiflag", biduiflag);
				cljbxx.setParameterMap(parameterMap);
				cljbxx.setClzt(biduiflag+"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//客户信息管理
		Khxx khxx = new Khxx();
		khxx.setGjdm(cljbxx.getCzgjdm());
		khxx.setZjhm(cljbxx.getCzzjhm());
		String existsFlag = khxxService.isKhxxExist(khxx);
		if(existsFlag.equals(0)){
			Khxx latestKhxx = khxxService.getLatestKhxx(khxx);
			khxx.setKhxxid(latestKhxx.getKhxxid());
			sheZhiKhXinXi(khxx,cljbxx);
			khxxService.updateKhxx(latestKhxx);
		}else{
			sheZhiKhXinXi(khxx,cljbxx);
			khxxService.insertKhxx(khxx);
		}
	}
	
	private void sheZhiKhXinXi(Khxx khxx, Cljbxx cljbxx){
		khxx.setXm(cljbxx.getCzm());
		khxx.setLxdh(cljbxx.getCzdh());
		khxx.setXbdm(cljbxx.getCzxbdm());
		khxx.setXb(cljbxx.getCzxb());
		khxx.setHjdxz(cljbxx.getCzhjdz());
		khxx.setCyzjdm(cljbxx.getCzcyzjlxdm());
		khxx.setCyzj(cljbxx.getCzcyzj());
	}

	/** @param 车辆基本信息(t_cljbxx) 删除 */
	public boolean deleteCljbxx(Cljbxx cljbxx){
		// TODO: implement
		//不做物理删除，制撤销标志为 0，action设置撤销人
		return cljbxxDao.updateCljbxx(cljbxx)>0;
	}

	/** @param 车辆基本信息(t_cljbxx) 修改  有报警*/
	public Cljbxx updateCljbxxBj(Cljbxx cljbxx){
		//参数Map
		Cljbxx bjCljbxx;
		String czzjhm = cljbxx.getCzzjhm();
		if(cljbxx.getCzzjhm()==null || cljbxx.getCph()==null || cljbxx.getCjh()==null || cljbxx.getFdjh()==null){
			bjCljbxx = cljbxxDao.getCljbxx(cljbxx);
		}else{
			bjCljbxx = cljbxx;
		}
		//报警
		baojingClAndCz(bjCljbxx, cljbxx.getParameterMap());
		
		cljbxx.setCzzt(bjCljbxx.getCzzt());
		cljbxx.setClzt(bjCljbxx.getClzt());
		updateCljbxxCommon(cljbxx);
		return cljbxx;
	}

	/** @param 车辆基本信息(t_cljbxx) 修改 无报警*/
	public boolean updateCljbxx(Cljbxx cljbxx){
		
		return updateCljbxxCommon(cljbxx);
	}
	
	/** @param 通用修改车辆基本信息方法*/
	private boolean updateCljbxxCommon(Cljbxx cljbxx){
		// TODO: implement
		boolean isSuccess = true;
		Map parameterMap = cljbxx.getParameterMap();
		Clxxwgryxx clxxwgryxx = cljbxx.getClxxwgryxx();
		boolean wgryIsNull = (clxxwgryxx!=null);
		//如果是外国人设置相关属性
		if(wgryIsNull){
			cljbxx.setCzm(clxxwgryxx.getYwx() + " " + clxxwgryxx.getYwm());//车主姓名
			cljbxx.setCzcyzjlxdm(clxxwgryxx.getQzzldm());//证件种类代码——签证种类代码
			cljbxx.setCzcyzj(clxxwgryxx.getQzzl());//证件种类——签证种类
			cljbxx.setCzzjhm(clxxwgryxx.getQzhm());//证件号码——签证号码
		}
		//企业ID
		cljbxx.setQyid((Integer)parameterMap.get("qyid"));
		
		isSuccess = cljbxxDao.updateCljbxx(cljbxx)>0;
		Integer cljbxxid = cljbxx.getCljbxxid();
		//添加车辆照片
		List clxx_zpList = cljbxx.getLClxx_zpList();
		if(clxx_zpList!=null){
			Clxx_zp clxx_zp ;
			String zpsfsc;
			Integer clxxzpid;
			byte []clxxtpnr;
			int listLength = clxx_zpList.size();
			for(int index=0;index<listLength;index++){
				clxx_zp = (Clxx_zp)clxx_zpList.get(index);
				clxxzpid = clxx_zp.getClxxzpid();
				clxx_zp.setCljbxxid(cljbxxid);
				//照片id为空，新增车辆照片
				if(clxxzpid==null || clxxzpid.equals(new Integer(0))){
					clxx_zpDao.insertClxx_zp(clxx_zp);
				}else{
					clxxtpnr = clxx_zp.getTpnr();
					zpsfsc = clxx_zp.getZpsfsc();
					//照片id不为空（已有照片），图片内容不为空，修改照片
					if(clxxtpnr!=null){
						clxx_zpDao.updateClxx_zp(clxx_zp);
					}else{
						//图片内容为空，zpsfsc标志为 1 ，删除车辆照片
						if(zpsfsc!=null && zpsfsc.equals("1")){
							clxx_zpDao.deleteClxx_zp(clxx_zp);
						}
					}
				}
			}
		}
		
		//添加人员照片
		List clxxryList = cljbxx.getLClxxry_zpList();
		if(clxxryList!=null){
			byte []clxxrytpnr;
			Clxxry_zp clxxry_zp;
			int listLength = clxxryList.size();
			for(int index=0;index<listLength;index++){
				clxxry_zp = (Clxxry_zp)clxxryList.get(index);
				clxxry_zp.setCljbxxid(cljbxxid);
				//图片内容不为空，进行添加或修改操作
				if(clxxry_zp.getTpnr()!=null && clxxry_zp.getTpnr().length>0){
					clxxry_zp.setCljbxxid(cljbxxid);
					List list = clxxry_zpDao.getListClxxry_zp(clxxry_zp);
					//车辆下没有车主照片，添加
					if(list==null || list.size()==0){
						clxxry_zpDao.insertClxxry_zp(clxxry_zp);
					}else{//车辆下有车主照片，修改
						clxxry_zpDao.updateClxxry_zp(clxxry_zp);
					}
				}else{
					//图片内容为空，进行删除操作
					clxxry_zpDao.deleteClxxry_zp(clxxry_zp);
				}
			}
		}
		
		Object xgbz_cl = (Object)parameterMap.get("xgbz_cl");
		//添加外国人员信息
		if(wgryIsNull && (xgbz_cl==null || ((String)xgbz_cl).equals("0"))){
			clxxwgryxx.setCljbxxid(cljbxxid);
			List wgryxxList = clxxwgryxxDao.getListClxxwgryxx(clxxwgryxx);
			if(wgryxxList!=null && wgryxxList.size()>0){
				clxxwgryxxDao.updateClxxwgryxx(clxxwgryxx);
			}else{
				clxxwgryxxDao.insertClxxwgryxx(clxxwgryxx);
			}
		}else{
			Clxxwgryxx delClxxwgryxx = new Clxxwgryxx();
			delClxxwgryxx.setCljbxxid(cljbxxid);
			clxxwgryxxDao.deleteClxxwgryxx(delClxxwgryxx);
		}
		
		return isSuccess;
	}

	/** @param 车辆基本信息(t_cljbxx) 查询单条 */
	public Cljbxx getCljbxx(Cljbxx cljbxx){
		// TODO: implement
		return (Cljbxx)cljbxxDao.getCljbxx(cljbxx);
	}

	/** @param 车辆基本信息(t_cljbxx) 查询单条(包括人员照片、外国车主等信息) */
	public Cljbxx getCljbxxCommon(Cljbxx cljbxx){
		// TODO: implement  
		Integer cljbxxid = cljbxx.getCljbxxid();
		Clxx_zp clxx_zp = new Clxx_zp();
		clxx_zp.setCljbxxid(cljbxxid);
		Clxxry_zp clxxry_zp = new Clxxry_zp();
		clxxry_zp.setCljbxxid(cljbxxid);
		Clxxwgryxx clxxwgryxx = new Clxxwgryxx();
		clxxwgryxx.setCljbxxid(cljbxxid);
		
		cljbxx = (Cljbxx)cljbxxDao.getCljbxx(cljbxx);
		//取外国车主
		cljbxx.setClxxwgryxx(clxxwgryxxDao.getClxxwgryxx(clxxwgryxx));
		//取车主照片
		cljbxx.setLClxxry_zpList(clxxry_zpDao.getListClxxry_zpNoZp(clxxry_zp));
		//取车辆照片
		cljbxx.setLClxx_zpList(clxx_zpDao.getListClxx_zpNoTp(clxx_zp));
		
		return cljbxx;
	}

	/** @param 车辆基本信息(t_cljbxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return cljbxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 车辆基本信息(t_cljbxx) 多条查询 */
	public List getListCljbxx(Cljbxx cljbxx){
		// TODO: implement
		return cljbxxDao.getListCljbxx(cljbxx);
	}

	public ICljbxxDao getCljbxxDao() {
		return cljbxxDao;
	}

	public void setCljbxxDao(ICljbxxDao cljbxxDao) {
		this.cljbxxDao = cljbxxDao;
	}

	public IClxx_zpDao getClxx_zpDao() {
		return clxx_zpDao;
	}

	public void setClxx_zpDao(IClxx_zpDao clxx_zpDao) {
		this.clxx_zpDao = clxx_zpDao;
	}

	public IClxxry_zpDao getClxxry_zpDao() {
		return clxxry_zpDao;
	}

	public void setClxxry_zpDao(IClxxry_zpDao clxxry_zpDao) {
		this.clxxry_zpDao = clxxry_zpDao;
	}

	public IClxxwgryxxDao getClxxwgryxxDao() {
		return clxxwgryxxDao;
	}

	public void setClxxwgryxxDao(IClxxwgryxxDao clxxwgryxxDao) {
		this.clxxwgryxxDao = clxxwgryxxDao;
	}

	public IWpbjxxbService getWpbjxxbService() {
		return wpbjxxbService;
	}

	public void setWpbjxxbService(IWpbjxxbService wpbjxxbService) {
		this.wpbjxxbService = wpbjxxbService;
	}

	public IScbmDao getScbmDao() {
		return scbmDao;
	}

	public void setScbmDao(IScbmDao scbmDao) {
		this.scbmDao = scbmDao;
	}

	public IBjxxbService getBjxxbService() {
		return bjxxbService;
	}

	public void setBjxxbService(IBjxxbService bjxxbService) {
		this.bjxxbService = bjxxbService;
	}

	public IKhxxService getKhxxService() {
		return khxxService;
	}

	public void setKhxxService(IKhxxService khxxService) {
		this.khxxService = khxxService;
	}
	
}
