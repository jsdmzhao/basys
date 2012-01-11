package com.aisino2.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Function;
import com.opensymphony.xwork2.ActionContext;

public class PageUtil {
	public static List pageList(List pageDataList,int pagesize,int pagerow){
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		
		List returnList=new ArrayList();
		if(pageDataList==null){
			return null;
		}else{
			session.setAttribute("pageDataListSession", pageDataList);
			int StartRow=(pagesize-1)*pagerow;
			int EndRow=pagesize*pagerow;
			 for(int i=StartRow;i<EndRow;i++){
				 if(i>=pageDataList.size()){
					 break;
				 }else{
					 returnList.add(pageDataList.get(i));
				 }
			 }
			return returnList;
		}
	}
	
	public static void removeSession(String sessionName){
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		if(sessionName==null){
			session.removeAttribute("pageSate");
		}else{
			session.removeAttribute(sessionName);
		}
		
	}
	
	/*单个功能权限判断方法
	 * 1.参数：String型。值意义：功能权限code
	 * 2.返回值：布尔型。返回值为true时，有参数传入的功能权限；false时，没有参数传入的功能权限
	 */
	public static boolean checkFunction(String funcCode){
		boolean isSuceess = false;
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session!=null){
			List funcList = (List)session.getAttribute(Constants.functionList);
			if(funcList!=null){
				for(int index=0,length=funcList.size();index<length;index++){
					Function func = (Function)funcList.get(index);
					if(func.getFunccode().equals(funcCode)){
						isSuceess = true;
						break;
					}
				}
			}
		}
		return isSuceess;
	}

	/*多个功能权限判断方法
	 * 1.参数：String数组型。值意义：功能权限code数组
	 * 2.返回值：List型(值为boolean型)。list的大小(size)与参数数组的长度(length)相同，并且相同索引的元素
	 *有一一对应关系。假设funcCodeList的第二个元素(索引为1)值为"a"，返回值list的第二个元素(索引为1)与之对应，
	 *值为"false"时，不具备"a"功能权限，值为"true"时，具备"a"功能权限。
	 */
	public static List checkFunctionList(String[] funcCodeList){
		int funcListLength = funcCodeList.length;
		List isSuceess = new ArrayList();
		//初始化list
		for(int funcIndex=0;funcIndex<funcListLength;funcIndex++){
			isSuceess.add(false);
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session!=null){
			List funcList = (List)session.getAttribute(Constants.functionList);
			if(funcList!=null){
				for(int funcIndex=0;funcIndex<funcListLength;funcIndex++){
					for(int index=0,length=funcList.size();index<length;index++){
						Function func = (Function)funcList.get(index);
						if(func.getFunccode().equals(funcCodeList[funcIndex])){
							isSuceess.set(funcIndex, true);
							break;
						}
					}
				}
			}
		}
		return isSuceess;
	}
}
