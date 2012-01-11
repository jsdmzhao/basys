package com.aisino2.basicsystem.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDepartAndQiYeDao;
import com.aisino2.basicsystem.domain.YlcsjbxxForTree;
import com.aisino2.basicsystem.service.IDepartAndQiYeService;
import com.aisino2.cache.CacheManager;
import com.aisino2.common.StringUtil;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Globalpar;

public class DepartAndQiYeServiceImpl extends BaseService implements IDepartAndQiYeService {

	private IDepartAndQiYeDao departAndQiYeDao;
	
	public List ChildDepartmentForTree(Department department,String hylbdm) {
		
		List departlist = new ArrayList();
		// TODO Auto-generated method stub
		String sqlString = "";
		if("A".equals(hylbdm)){///旅馆业
			
			sqlString = " substr(a.departcode, 0, length('"+department.getDepartcode()+"')+2) " +
					"in (select substr(t.gxdwbm, 0, length('"+department.getDepartcode()+"')+2)  from t_lvguan t " +
					"where t.zhuxiaobz = '0' and t.gxdwbm like CONCAT(substr(a.departCode, 0, length('"+department.getDepartcode()+"')+2), '%')) ";
			
			//System.out.println(sqlString);
			department.setDepartcode(sqlString);
			
			departlist = departAndQiYeDao.ChildDepartmentForTree(department);
			
		}else if("J".equals(hylbdm)){ //娱乐业
			
			sqlString = " substr(a.departcode, 0, length('"+department.getDepartcode()+"')+2) " +
			" in (select substr(t.gxdwbm, 0, length('"+department.getDepartcode()+"')+2) from t_qyjbxx t  " +
			"where t.zxbz = '0' and t.gxdwbm like  CONCAT(substr(a.departCode, 0, length('"+department.getDepartcode()+"')+2), '%') and t.HYLBDM='"+hylbdm+"') ";
			
			department.setDepartcode(sqlString);
	
	        departlist = departAndQiYeDao.ChildDepartmentForTree(department);
			
		}else if("Z".equals(hylbdm)){ //出租房业
			
			sqlString = " substr(a.departcode, 0, length('"+department.getDepartcode()+"')+2) " +
			" in (select substr(t.gxdwbm, 0, length('"+department.getDepartcode()+"')+2) from t_caijidian t  " +
			"where t.iszhuxiao = '0' and t.gxdwbm like  CONCAT(substr(a.departCode, 0, length('"+department.getDepartcode()+"')+2), '%')) ";
			
			department.setDepartcode(sqlString);
	
	        departlist = departAndQiYeDao.ChildDepartmentForTree(department);
			
		}else if("N".equals(hylbdm)){ //重点单位
			
			sqlString = " substr(a.departcode, 0, length('"+department.getDepartcode()+"')+2) " +
			" in (select substr(t.gxdwbm, 0, length('"+department.getDepartcode()+"')+2) from t_nbdwjbxx t  " +
			"where t.zxzt = '0' and t.gxdwbm like  CONCAT(substr(a.departCode, 0, length('"+department.getDepartcode()+"')+2), '%')) ";
			
			department.setDepartcode(sqlString);
	
	        departlist = departAndQiYeDao.ChildDepartmentForTree(department);
			
		}else { // E01二手车、E02二手机、废旧金属、机修、典当、印章等  
			
			sqlString = " substr(a.departcode, 0, length('"+department.getDepartcode()+"')+2) " +
			" in (select substr(t.gxdwbm, 0, length('"+department.getDepartcode()+"')+2) from t_qyjbxx t  " +
			"where t.zxbz = '0' and t.gxdwbm like  CONCAT(substr(a.departCode, 0, length('"+department.getDepartcode()+"')+2), '%') and t.HYLBDM='"+hylbdm+"') ";
			
			department.setDepartcode(sqlString);
	
	        departlist = departAndQiYeDao.ChildDepartmentForTree(department);
			
		}
		
		return departlist;
	}

	public List QyTreeList(YlcsjbxxForTree ylcsjbxxForTree, String hylbdm) {
		// TODO Auto-generated method stub
		//String hylbdm = ylcsjbxxForTree.getHylxbm();
		String isAllGxdwbm = ylcsjbxxForTree.getIsAllGxdwbm();
		String gxdwbm = ylcsjbxxForTree.getGxdwbm();
		String chaXun = "";
		if("A".equals(hylbdm)){//旅馆业
			chaXun = "select a.qiyeid csid,a.qiyebianma csbm,a.qiyemc csmc, 'A' hylxbm,'旅馆业' hylxmc,'"+isAllGxdwbm+"'isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_lvguan a where a.zhuxiaobz = '0' and";
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.gxdwbm='"+gxdwbm+"'";
			}
		}else if("J".equals(hylbdm)){//娱乐业
			chaXun = "select a.qyid csid,a.qybm csbm,a.qymc csmc, 'J' hylxbm, '营业性娱乐场所' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a  where a.zxbz = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.HYLBDM='J' and  a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.HYLBDM='J' and  a.gxdwbm='"+gxdwbm+"'";
			} 
		}else if("C".equals(hylbdm)){//机修业
			
			chaXun = " select a.qyid csid,a.qybm csbm,a.qymc csmc, 'C' hylxbm,'机修业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a where a.zxbz = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.HYLBDM='C' and a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.HYLBDM='C' and a.gxdwbm='"+gxdwbm+"'";
			} 
		}else if("B".equals(hylbdm)){//印章业
			
			chaXun = " select a.qyid csid,a.qybm csbm,a.qymc csmc, 'B' hylxbm,'印章业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a where a.zxbz = '0' and";
			
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.HYLBDM='B' and a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.HYLBDM='B' and a.gxdwbm='"+gxdwbm+"'";
			} 
		}else if("E03".equals(hylbdm)){//典当业
			//获取全局变量ddyversion，解决新老版本问题
		    	String ddyversion = "";
			Globalpar globalpar = new Globalpar();
			globalpar.setGlobalparcode("ddyversion");
			List globalparList = new ArrayList();
			globalparList = CacheManager.getCacheGlobalpar(globalpar);
			if (globalparList != null && globalparList.size() > 0) {
			    Globalpar glo = ((Globalpar) globalparList.get(0));
			    ddyversion = glo.getGlobalparvalue();
			}
			if ("old".equals(ddyversion)) {
				chaXun = " select a.ddqyid csid,a.ddqybm csbm,a.ddqymc csmc, 'E03' hylxbm,'典当业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_ddqyxx a where a.zxbz = '0' and";
				if("0".equals(isAllGxdwbm)){
					chaXun += " a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
				}else{
					chaXun += " a.gxdwbm='"+gxdwbm+"'";
				}
			} else {
				chaXun = " select a.qyid csid,a.qybm csbm,a.qymc csmc, 'E03' hylxbm,'典当业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a where a.zxbz = '0' and";
				if("0".equals(isAllGxdwbm)){
					chaXun += " a.HYLBDM='E03' and a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
				}else{
					chaXun += " a.HYLBDM='E03' and a.gxdwbm='"+gxdwbm+"'";
				} 
			}
			
		}else if("E02".equals(hylbdm)){//二手机
			
			chaXun = " select a.qyid csid,a.qybm csbm,a.qymc csmc, 'E02' hylxbm,'二手机业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a where a.zxbz = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.HYLBDM='E02' and a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.HYLBDM='E02' and a.gxdwbm='"+gxdwbm+"'";
			} 
		}else if("E01".equals(hylbdm)){//二手车
			
			chaXun = " select a.qyid csid,a.qybm csbm,a.qymc csmc, 'E01' hylxbm,'二手车业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a where a.zxbz = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.HYLBDM='E01' and a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.HYLBDM='E01' and a.gxdwbm='"+gxdwbm+"'";
			} 
		}else if("E04".equals(hylbdm)){// 废旧金属
			
			chaXun = " select a.qyid csid,a.qybm csbm,a.qymc csmc, 'E04' hylxbm,'废旧金属回收行业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a where a.zxbz = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.HYLBDM='E04' and a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.HYLBDM='E04' and a.gxdwbm='"+gxdwbm+"'";
			} 
		}else if("Z".equals(hylbdm)){// 出租房行业
			
			chaXun = " select a.wybz csid,a.CAIJIDIANBM csbm,a.CAIJIDIANMC csmc, '"+hylbdm+"' hylxbm,'出租房行业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_caijidian a where a.iszhuxiao = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.gxdwbm='"+gxdwbm+"'";
			} 
		}else if("N".equals(hylbdm)){// 重点单位
			
			chaXun = " select a.nbdwid csid,a.qybm csbm,a.qymc csmc, '"+hylbdm+"' hylxbm,'重点单位' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_nbdwjbxx a  where a.zxzt = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.gxdwbm='"+gxdwbm+"'";
			} 
		}else if("C01".equals(hylbdm)){//机动车拆解
			
			chaXun = " select a.qyid csid,a.qybm csbm,a.qymc csmc, 'C01' hylxbm,'机动车拆解业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a where a.zxbz = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.HYLBDM='C01' and a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.HYLBDM='C01' and a.gxdwbm='"+gxdwbm+"'";
			} 
		}else if("E07".equals(hylbdm)){//委托寄卖
			
			chaXun = " select a.qyid csid,a.qybm csbm,a.qymc csmc, 'E07' hylxbm,'委托寄卖业' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a where a.zxbz = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.HYLBDM='E07' and a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.HYLBDM='E07' and a.gxdwbm='"+gxdwbm+"'";
			} 
		}else{//出租车   汽车租赁
			
			chaXun = " select a.qyid csid,a.qybm csbm,a.qymc csmc, '"+hylbdm+"' hylxbm,'' hylxmc,'"+isAllGxdwbm+"' isAllGxdwbm, a.gxdwbm gxdwbm, a.gxdwmc gxdwmc from t_qyjbxx a where a.zxbz = '0' and";
			
			if("0".equals(isAllGxdwbm)){
				chaXun += " a.HYLBDM='"+hylbdm+"' and a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
			}else{
				chaXun += " a.HYLBDM='"+hylbdm+"' and a.gxdwbm='"+gxdwbm+"'";
			} 
		}
		
		Map map = new HashMap();
		map.put("yuju", chaXun);
		return departAndQiYeDao.QyTreeList(map);
	}
	
	public List QyJlTreeList(YlcsjbxxForTree ylcsjbxxForTree) {
		// TODO Auto-generated method stub
		String hylbdm = ylcsjbxxForTree.getHylxbm();
		String isAllGxdwbm = ylcsjbxxForTree.getIsAllGxdwbm();
		String gxdwbm = ylcsjbxxForTree.getGxdwbm();
		String chaXun = "select a.qiyeid csid,a.qiyebianma csbm,a.qiyemc csmc,a.gxdwbm gxdwbm,a.gxdwmc gxdwmc from t_lvguan a where a.zhuxiaobz = '0' and";
		if("0".equals(isAllGxdwbm)){
			chaXun += " a.gxdwbm like '"+StringUtil.trimEven0(gxdwbm)+"%'";
		}else{
			chaXun += " a.gxdwbm='"+gxdwbm+"'";
		}
		Map map = new HashMap();
		map.put("yuju", chaXun);
		return departAndQiYeDao.QyJlTreeList(map);
	}

	public void setDepartAndQiYeDao(IDepartAndQiYeDao departAndQiYeDao) {
		this.departAndQiYeDao = departAndQiYeDao;
	}

}
