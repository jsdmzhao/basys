package com.aisino2.cache;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.aisino2.cache.ehcache.MethodCacheInterceptor;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IDictService;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.sysadmin.service.IGlobalparService;

public class CacheManager {
	
	static MethodCacheInterceptor methodCacheInterceptor;
	static final Log logger = LogFactory.getLog(CacheManager.class); 
//	static String[] DEFAULT_CONTEXT_FILE = new String[] {"config/spring/applicationContext.xml",
//			"config/spring/sysadmin-action.xml",
//			"config/spring/sysadmin-dao.xml",
//			"config/spring/sysadmin-service.xml",
//			"config/cacheContext.xml",
//			"config/spring/sysadmin-authorization.xml"};   
//    static ApplicationContext context =  new ClassPathXmlApplicationContext(DEFAULT_CONTEXT_FILE);   
	
	static ApplicationContext context;
	
  //字典
	public static List getCacheDict(Dict dict){
		IDictService dictService=(IDictService)context.getBean("dictService");
		List lResultDict=dictService.getListDict(null);
		List lDict=new ArrayList();
		Dict dictReturn;
		int iFlag=0;
		for (int i=0;i<lResultDict.size();i++){
			dictReturn=(Dict)lResultDict.get(i);
			if (dict.getDict_allpin()!=null && !dict.getDict_allpin().equals("")){
				if (dictReturn.getDict_allpin().indexOf(dict.getDict_allpin().toLowerCase())>=0){
					iFlag=1;
				}else{
					iFlag=0;
				}
			}else if (dict.getDict_code()!=null && !dict.getDict_code().equals("")){
				if (dictReturn.getDict_code().startsWith(dict.getDict_code())){
					iFlag=1;
				}else{
					iFlag=0;
				}
			}else if (dict.getDict_simplepin()!=null && !dict.getDict_simplepin().equals("")){
				if (dictReturn.getDict_simplepin().startsWith(dict.getDict_simplepin().toUpperCase())){
					iFlag=1;
				}else{
					iFlag=0;
				}
			}else if (dict.getDict_type()!=null && !dict.getDict_type().equals("")){
				if (dictReturn.getDict_type().equals(dict.getDict_type())){
					iFlag=1;
				}else{
					iFlag=0;
				}
			}else if (dict.getSuper_dict_code()!=null && !dict.getSuper_dict_code().equals("")){
				if (dictReturn.getSuper_dict_code().equals(dict.getSuper_dict_code())){
					iFlag=1;
				}else{
					iFlag=0;
				}
			}	
			if (iFlag==1){
				lDict.add(dictReturn);
			}
		}
		return lDict;
	}
	//字典项
	public static List getCacheDictitem(Dict_item dict_item){
		IDict_itemService dict_itemService=(IDict_itemService)context.getBean("dict_itemService");
		List lResultDictitem=dict_itemService.getListDict_item(null);
		List lDict_item=new ArrayList();
		Dict_item dict_itemReturn;
		int iFlag=0;
		for (int i=0;i<lResultDictitem.size();i++){
			dict_itemReturn=(Dict_item)lResultDictitem.get(i);
			if ( dict_item.getDict_code()!=null && !dict_item.getDict_code().equals("") && dict_itemReturn.getDict_code().equals(dict_item.getDict_code())){
				
				if (dict_item.getDict_code()!=null && !dict_item.getDict_code().equals("") 
						 && ("").equals(dict_item.getItem_allpin())
						 && ("").equals(dict_item.getItem_simplepin())
						 && dict_item.getSuper_item_id()==null
						 && ("").equals(dict_item.getFact_value())
						 && ("").equals(dict_item.getDisplay_name()) 
						 && ("").equals(dict_item.getAppend_value())
						 ){
					if (dict_itemReturn.getDict_code().equals(dict_item.getDict_code())){
						iFlag=iFlag+1;
					}
				}
				
				
				if ( dict_item.getItem_allpin()!=null && !dict_item.getItem_allpin().equals("")){
					if ( dict_itemReturn.getItem_allpin()!=null){
 						if (dict_itemReturn.getItem_allpin().indexOf(dict_item.getItem_allpin().toLowerCase())>=0){
							iFlag=iFlag+1;
						}
					}			
				}
				
				if ( dict_item.getItem_simplepin()!=null && !dict_item.getItem_simplepin().equals("")){
					dict_item.setItem_simplepin(dict_item.getItem_simplepin().toUpperCase());
					if ( dict_itemReturn.getItem_simplepin()!=null){
 						if (dict_itemReturn.getItem_simplepin().indexOf(dict_item.getItem_simplepin().toUpperCase())>=0){
							iFlag=iFlag+1;
						}
					}			
				}
				if ( dict_item.getSuper_item_id()!=null && !dict_item.getSuper_item_id().equals("")){
					if ( dict_itemReturn.getSuper_item_id()!=null){
 						if (dict_itemReturn.getSuper_item_id().equals(dict_item.getSuper_item_id())){
							iFlag=iFlag+1;
						}
					}			
				}
				if ( dict_item.getFact_value()!=null && !dict_item.getFact_value().equals("")){
					if ( dict_itemReturn.getFact_value()!=null){
 						if (dict_itemReturn.getFact_value().startsWith(dict_item.getFact_value())){
							iFlag=iFlag+1;
						}
					}			
				}
				if ( dict_item.getDisplay_name()!=null && !dict_item.getDisplay_name().equals("")){
					if ( dict_itemReturn.getDisplay_name()!=null){
 						if (dict_itemReturn.getDisplay_name().indexOf(dict_item.getDisplay_name())>=0){
							iFlag=iFlag+1;
						}
					}			
				}
				if ( dict_item.getAppend_value()!=null && !dict_item.getAppend_value().equals("")){
					if ( dict_itemReturn.getAppend_value()!=null){
 						if (dict_itemReturn.getAppend_value().startsWith(dict_item.getAppend_value())){
							iFlag=iFlag+1;
						}
					}			
				}
				if (iFlag>0){
					lDict_item.add(dict_itemReturn);
					iFlag=0;
				}
			}
			
		}
		return lDict_item;
	}
	//字典项精确
	public static Dict_item getCacheDictitemOne(Dict_item dict_item){
		IDict_itemService dict_itemService=(IDict_itemService)context.getBean("dict_itemService");
		List lResultDictitem=dict_itemService.getListDict_item(null);
		List lDict_item=new ArrayList();
		Dict_item dict_itemReturn;
		int iFlag=0;
		for (int i=0;i<lResultDictitem.size();i++){
			dict_itemReturn=(Dict_item)lResultDictitem.get(i);
			if ( dict_item.getDict_code()!=null && !dict_item.getDict_code().equals("") && dict_itemReturn.getDict_code().equals(dict_item.getDict_code())){
				
				if (dict_item.getDict_code()!=null && !dict_item.getDict_code().equals("") 
						 && ("").equals(dict_item.getItem_allpin())
						 && ("").equals(dict_item.getItem_simplepin())
						 && dict_item.getSuper_item_id()==null
						 && ("").equals(dict_item.getFact_value())
						 && ("").equals(dict_item.getDisplay_name()) 
						 && ("").equals(dict_item.getAppend_value())
						 ){
					if (dict_itemReturn.getDict_code().equals(dict_item.getDict_code())){
						iFlag=iFlag+1;
					}
				}
				
				
				if ( dict_item.getItem_allpin()!=null && !dict_item.getItem_allpin().equals("")){
					if ( dict_itemReturn.getItem_allpin()!=null){
 						if (dict_itemReturn.getItem_allpin().equals(dict_item.getItem_allpin().toLowerCase())){
							iFlag=iFlag+1;
						}
					}			
				}
				
				if ( dict_item.getItem_simplepin()!=null && !dict_item.getItem_simplepin().equals("")){
					dict_item.setItem_simplepin(dict_item.getItem_simplepin().toUpperCase());
					if ( dict_itemReturn.getItem_simplepin()!=null){
 						if (dict_itemReturn.getItem_simplepin().equals(dict_item.getItem_simplepin().toUpperCase())){
							iFlag=iFlag+1;
						}
					}			
				}
				if ( dict_item.getSuper_item_id()!=null && !dict_item.getSuper_item_id().equals("")){
					if ( dict_itemReturn.getSuper_item_id()!=null){
 						if (dict_itemReturn.getSuper_item_id().equals(dict_item.getSuper_item_id())){
							iFlag=iFlag+1;
						}
					}			
				}
				if ( dict_item.getFact_value()!=null && !dict_item.getFact_value().equals("")){
					if ( dict_itemReturn.getFact_value()!=null){
 						if (dict_itemReturn.getFact_value().equals(dict_item.getFact_value())){
							iFlag=iFlag+1;
						}
					}			
				}
				if ( dict_item.getDisplay_name()!=null && !dict_item.getDisplay_name().equals("")){
					if ( dict_itemReturn.getDisplay_name()!=null){
 						if (dict_itemReturn.getDisplay_name().equals(dict_item.getDisplay_name())){
							iFlag=iFlag+1;
						}
					}			
				}
				if ( dict_item.getAppend_value()!=null && !dict_item.getAppend_value().equals("")){
					if ( dict_itemReturn.getAppend_value()!=null){
 						if (dict_itemReturn.getAppend_value().equals(dict_item.getAppend_value())){
							iFlag=iFlag+1;
						}
					}			
				}
				if (iFlag>0){
					lDict_item.add(dict_itemReturn);
					iFlag=0;
				}
			}
			
		}
		if (lDict_item!=null&&lDict_item.size()>0)
			return (Dict_item)lDict_item.get(0);
		else
			return null;
	}
	//字典项精确
	public static Dict_item getCacheDictitemOne(String dictcode,String factvalue){
		Dict_item dictitem=new Dict_item();
		dictitem.setDict_code(dictcode);
		dictitem.setFact_value(factvalue);
		
		return getCacheDictitemOne(dictitem);
	}
	//机构
	public static List getCacheDepartment(Department department){
		IDepartmentService departmentService=(IDepartmentService)context.getBean("departmentService");
		List lResultDepartment=departmentService.getListDepartment(null,"1");
		List lDepartment=new ArrayList();
		Department departmentReturn;
		int iFlag=0;
		for (int i=0;i<lResultDepartment.size();i++){
			departmentReturn=(Department)lResultDepartment.get(i);
			if (department.getDeptCode()!=null && !"".equals(department.getDeptCode()) && departmentReturn.getDepartcode().indexOf(department.getDeptCode())>=0){
				if (department.getDeptCode()!=null && !department.getDeptCode().equals("") 
						&& ("").equals(department.getDepartcode())
						&& ("").equals(department.getDepartallpin())
						&& ("").equals(department.getDepartsimplepin())
						&& ("").equals(department.getDepartbrevitycode())
						&& department.getParentdepartid()==null){
					//if (department.getDeptCode().equals(departmentReturn.getDeptCode())){
					if (departmentReturn.getDepartcode().indexOf(department.getDeptCode())>=0){
						iFlag=iFlag+1;
					}
				}
				if (department.getDepartcode()!=null && !department.getDepartcode().equals("")){
					if (departmentReturn.getDepartcode().startsWith(department.getDepartcode())){
						iFlag=iFlag+1;
					}
				}
				if (department.getDepartallpin()!=null && !department.getDepartallpin().equals("")){
					if (departmentReturn.getDepartallpin().indexOf(department.getDepartallpin().toLowerCase())>=0){
						iFlag=iFlag+1;
					}
				}
				if (department.getDepartsimplepin()!=null && !department.getDepartsimplepin().equals("")){
					if (departmentReturn.getDepartsimplepin().indexOf(department.getDepartsimplepin().toUpperCase())>=0){
						iFlag=iFlag+1;
					}
				}
				if (department.getDepartbrevitycode()!=null && !department.getDepartbrevitycode().equals("")){
					if (departmentReturn.getDepartbrevitycode().startsWith(department.getDepartbrevitycode())){
						iFlag=iFlag+1;
					}
				}
				if (department.getDepartname()!=null && !department.getDepartname().equals("")){
					if (departmentReturn.getDepartname().indexOf(department.getDepartname())>=0){
						iFlag=iFlag+1;
					}
				}
				if (department.getParentdepartid()!=null){
					if (departmentReturn.getParentdepartid()==department.getParentdepartid()){
						iFlag=iFlag+1;
					}
				}
				if (department.getDepartid()!=null){
					if (departmentReturn.getDepartid().equals(department.getDepartid())){
						iFlag=iFlag+1;
					}
				}
			}	
			if (iFlag>0){
				lDepartment.add(departmentReturn);
				iFlag=0;
			}
		}
		return lDepartment;
	}
	//全局参数
	public static List getCacheGlobalpar(Globalpar globalpar){
		IGlobalparService globalparService = null;
		try{
			globalparService=(IGlobalparService)context.getBean("globalparService");
		}catch (Exception e) {
			logger.warn("init globalparService error");
			return null;
		}
		List lResultGlobalpar=globalparService.getListGlobalpar(null);
		List lGlobalpar=new ArrayList();
		Globalpar globalparReturn;
		int iFlag=0;
		for (int i=0;i<lResultGlobalpar.size();i++){
			globalparReturn=(Globalpar)lResultGlobalpar.get(i);
			if (globalpar.getGlobalparcode()!=null && !globalpar.getGlobalparcode().equals("")){
				if (globalparReturn.getGlobalparcode().startsWith(globalpar.getGlobalparcode())){
					iFlag=1;
				}else{
					iFlag=0;
				}
			}
			if (iFlag==1){
				lGlobalpar.add(globalparReturn);
			}
		}
		return lGlobalpar;
	}
	public void setMethodCacheInterceptor(
			MethodCacheInterceptor methodCacheInterceptor) {
		this.methodCacheInterceptor = methodCacheInterceptor;
	}
	public static ApplicationContext getContext() {
		return context;
	}
	public static void setContext(ApplicationContext context) {
		CacheManager.context = context;
	}
}
