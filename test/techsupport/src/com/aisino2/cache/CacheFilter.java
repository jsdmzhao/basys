package com.aisino2.cache;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;

public class CacheFilter implements Filter {

	//系统启动执行
	public CacheFilter(){
		
	}

	public void destroy() {
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		arg2.doFilter(arg0, arg1);
	}
	public void init(FilterConfig arg0) throws ServletException {
		ServletContext scontext = arg0.getServletContext();
		ApplicationContext context  =     
			WebApplicationContextUtils.getRequiredWebApplicationContext(scontext); 
		CacheManager.setContext(context);
		Department department=new Department();
		CacheManager.getCacheDepartment(department);
		Dict dict=new Dict();
		CacheManager.getCacheDict(dict);
		Dict_item dict_item=new Dict_item();
		CacheManager.getCacheDictitem(dict_item);
		Globalpar globalpar=new Globalpar();
		CacheManager.getCacheGlobalpar(globalpar);
	}	
}
