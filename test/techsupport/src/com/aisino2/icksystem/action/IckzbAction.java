package com.aisino2.icksystem.action;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.ImageUtil;
import com.aisino2.common.QjblUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.domain.Ickzb;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.icksystem.service.IIckzbService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;

public class IckzbAction extends PageAction{
	private IIckzbService ickzbService;
	private IIckslService ickslService;
	private List lIckzb = new ArrayList();
	private Ickzb ickzb;
	private String tabledata;
	private int totalrows;
	private String result="";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Ickzb getIckzb() {
		return ickzb;
	}
	
	public List getLIckzb() {
		return lIckzb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}

	public void setIckzbService(IIckzbService ickzbService) {
		this.ickzbService = ickzbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("pch");
		lPro.add("pchSel");
		lPro.add("zbsl");
		lPro.add("zbr");
		lPro.add("zbsj");
    	
    	List lXzcz=new ArrayList();
    	
		List lYs = new ArrayList();
		lYs.add("loadIckYs");//链接ID开头
		lYs.add("印刷"); //链接显示文字
		lYs.add("sfqbys");//需要比对的属性
		lYs.add("0");//需要比对的属性的值
    	lXzcz.add(lYs);
    	
    	lYs = new ArrayList();
 		lYs.add("loadIckYs");//链接ID开头
 		lYs.add("<font color='blue'>印刷</font>"); //链接显示文字
 		lYs.add("sfqbys");//需要比对的属性
 		lYs.add("1");//需要比对的属性的值
    	lXzcz.add(lYs);
 		
 		lYs = new ArrayList();
		lYs.add("loadIckDxr");//链接ID开头
		lYs.add(""); //链接显示文字
		lYs.add("dxrbz");//需要比对的属性
		lYs.add("0");//需要比对的属性的值
    	lXzcz.add(lYs);
    	
    	lYs = new ArrayList();
 		lYs.add("loadIckDxr");//链接ID开头
 		lYs.add("电写入"); //链接显示文字
 		lYs.add("dxrbz");//需要比对的属性
 		lYs.add("1");//需要比对的属性的值
     	lXzcz.add(lYs);
     	
    	Ickzb getIckzb=new Ickzb();
    	
        //this.setData(getIckzb,lData,lPro,lCol);
    	this.setDataCustomer(getIckzb,lData,lPro,null,lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Ickzb setIckzb=new Ickzb();
			//ickzb=(Ickzb)this.setClass(setIckzb, null);
	        Map map = new HashMap();
	        Page page = ickzbService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        //lIckzb=page.getData();
	        List ickzbList = page.getData();
	        for(Iterator iter=ickzbList.iterator();iter.hasNext();){
	        	Ickzb oneIckzb = (Ickzb)iter.next();
	        	Integer slds = oneIckzb.getSlds();
	        	if(slds!=null && slds.intValue()>1)
	        		oneIckzb.setPchSel(oneIckzb.getPch()+"<font color='red'>*</font>");
	        	else
	        		oneIckzb.setPchSel(oneIckzb.getPch());
	        }
	        
	        setTabledata(ickzbList); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.result="success";
        return "success";
    }
	
	public String querylistYl() throws Exception{
		try {
			Ickzb setIckzb=new Ickzb();
			ickzb=(Ickzb)this.setClass(setIckzb, null);
	        Map map = new HashMap();
	        int maxRowsOfPage = Integer.parseInt(QjblUtil.queryQjblVal("zdpbh"));
	        if(ickzb!=null){
	        	map.put("pch", ickzb.getPch());
	        	map.put("kssxh", ickzb.getKssxh());
	        	map.put("bcyssl", ickzb.getBcyssl());
	        	map.put("bcysym", ickzb.getBcysym());
	        	map.put("maxRowsOfPage", maxRowsOfPage);
	        }
	        Page page = ickzbService.getIckzbYsListForPage(map, pagesize, pagerow,sort,dir);
	        //ickslService  通过ickslService调用方法，获得IC卡组包里卡列表信息(分页)
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lIckzb=page.getData();
	        setTabledata(lIckzb); 
	        
			HttpSession session = ServletActionContext.getRequest().getSession();
			Map rytpMap = new HashMap();
			for(Iterator iter=lIckzb.iterator();iter.hasNext();){
				Ickzb oneIckzb = (Ickzb)iter.next();
				rytpMap.put(oneIckzb.getIckslid(),oneIckzb.getTpnr());
				oneIckzb.setTpnr(null);
			}
			session.setAttribute("rytpnr", rytpMap);
			session.setAttribute("lIckzb", lIckzb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Ickzb setIckzb=new Ickzb();
			ickzb=(Ickzb)this.setClass(setIckzb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ickzb=ickzbService.getIckzb(ickzb);
        lIckzb.clear();
        lIckzb.add(ickzb);
		this.result="success";
        return "success";
    }	
	
	public String ysymByPch() throws Exception{
		try {
			Ickzb setIckzb=new Ickzb();
			ickzb=(Ickzb)this.setClass(setIckzb, null);
	        ickzb=ickzbService.getIckzbYsxx(ickzb);
	        if(ickzb!=null){
	        	int zbsl = ickzb.getBcysslByPage();
	        	
		        javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
		        
		        Globalpar globalpar = new Globalpar();
				String zdpbh = null;//从缓存中得到最大排版号(全局参数)
				 globalpar.setGlobalparcode("zdpbh");
				 List list = CacheManager.getCacheGlobalpar(globalpar);
					if(list!=null&&list.size()>0)
						zdpbh = ((Globalpar)list.get(0)).getGlobalparvalue();
				ickzb.setMaxRowsOfPage(new Integer(zdpbh));
				
	        	int rowsOfPage = ickzb.getMaxRowsOfPage();
	        	int ysym ;
	        	if(zbsl%rowsOfPage==0)
	        		ysym = zbsl / rowsOfPage;
	        	else
	        		ysym = zbsl / rowsOfPage + 1;
	        	
	        	ickzb.setYsyms(ysym);
	        }	
	        
	        lIckzb = new ArrayList();
	        lIckzb.add(ickzb);
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	public String insertZy() throws Exception{
		try {
			int isSuccess = 0;
			Ickzb setIckzb=new Ickzb();
			ickzb=(Ickzb)this.setClass(setIckzb, null);
			
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			ickzb.setZbr(user.getUseraccount());

			Globalpar globalpar = new Globalpar();
			String zdpbh = null;//从缓存中得到最大排版号(全局参数)
			 globalpar.setGlobalparcode("zdpbh");
			 List list = CacheManager.getCacheGlobalpar(globalpar);
				if(list!=null&&list.size()>0)
					zdpbh = ((Globalpar)list.get(0)).getGlobalparvalue();
			ickzb.setMaxRowsOfPage(new Integer(zdpbh));
			isSuccess = ickzbService.insertIckzbFree(ickzb);
	        if(isSuccess==1)
	        	this.result="success";
	        else if(isSuccess==0)
	        	this.result="没有组包数据";
	        else
	        	this.result="自由组包失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        this.result="自由组包失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public String insertZdy() throws Exception{
		try {
			Ickzb setIckzb=new Ickzb();
			ickzb=(Ickzb)this.setClass(setIckzb, null);
			
			if(ickzb!=null){
				String ryidSet = ickzb.getRyidSet();	//人员ID集合
				String ickslidSet = ickzb.getIckslidSet();	//IC卡受理ID集合
				String qyidSet = ickzb.getQyidSet();	//场所ID集合
				String cjdbmSet = ickzb.getCjdbmSet();	//采集点编码集合
				
				if(ickslidSet!=null && !ickslidSet.equals("")){
					String[] ickslidArry = ickslidSet.split("_,,");
					String[] ryidArry = ryidSet.split("_,,");
					String[] qyidArry = qyidSet.split("_,,");
					String[] cjdbmArry = cjdbmSet.split("_,,");
					List icksl_ickzbList = new ArrayList();
					
					for(int index=0,max=ickslidArry.length;index<max;index++){
						Icksl_ickzb newObject = new Icksl_ickzb();
						newObject.setIckslid(new Integer(ickslidArry[index]));
						/*newObject.setRyid(new Integer(ryidArry[index]));
						newObject.setCsid(new Integer(qyidArry[index]));*/
						newObject.setCjdbmInIcksl(cjdbmArry[index]);
						icksl_ickzbList.add(newObject);
					}
					ickzb.setLIcksl_ickzb(icksl_ickzbList);
				}
				
				HttpSession session = ServletActionContext.getRequest().getSession();
				User user = (User)session.getAttribute(Constants.userKey);
				ickzb.setZbr(user.getUseraccount());
				
				Globalpar globalpar = new Globalpar();
				String zdpbh = null;//从缓存中得到最大排版号(全局参数)
				 globalpar.setGlobalparcode("zdpbh");
				 List list = CacheManager.getCacheGlobalpar(globalpar);
					if(list!=null&&list.size()>0)
						zdpbh = ((Globalpar)list.get(0)).getGlobalparvalue();
				ickzb.setMaxRowsOfPage(new Integer(zdpbh));
			}
			if(ickzb==null)
				ickzb = new Ickzb();
			
	        ickzb=ickzbService.insertIckzbCustom(ickzb);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
	        this.result="自定义组包失败";
			e.printStackTrace();
		}
        return "success";
    }
	/** 印刷 */
	public String modifyYs() throws Exception{
		try {
			Ickzb setIckzb=new Ickzb();
			ickzb=(Ickzb)this.setClass(setIckzb, null);

			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute(Constants.userKey);
			String ysr = user.getUseraccount();
			
			String ryidSet = ickzb.getRyidSet();
			String ickslidSet = ickzb.getIckslidSet();
			if(ryidSet!=null && !ryidSet.equals("")){
				String[] ryidArry = ryidSet.split("_,,");
				String[] ickslidArry = ickslidSet.split("_,,");
				List ickslList = new ArrayList();
				for(int index=0,max=ryidArry.length;index<max;index++){
					Icksl temp = new Icksl();
					temp.setRyid(new Integer(ryidArry[index]));
					temp.setIckslid(new Integer(ickslidArry[index]));
					temp.setYsr(ysr);
					ickslList.add(temp);
				}
				ickzb.setLIcksl(ickslList);
			}
			
	        if(ickzbService.updateIckzbYs(ickzb))
	        	this.result="success";
	        else
	        	this.result = "打印失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
        	this.result = "打印失败";
			e.printStackTrace();
		}
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Ickzb setIckzb=new Ickzb();
			ickzb=(Ickzb)this.setClass(setIckzb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ickzbService.deleteIckzb(ickzb);
        this.result="success";
        return "success";
    }	
	
	//根据人员ID查询人员照片
	public void queryTp() throws Exception{
		try{
			javax.servlet.http.HttpSession session = ServletActionContext.getRequest().getSession();
    		HttpServletResponse response = ServletActionContext.getResponse();
    		HttpServletRequest requeset = ServletActionContext.getRequest();
    		
			Map rytpMap = (Map)session.getAttribute("rytpnr");
			
        	String ryId = requeset.getParameter("ryId");
        		
    		
			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			OutputStream out = response.getOutputStream();
			byte [] by = (byte[])rytpMap.get(new Integer(ryId));
    		if(by==null || by.length==0){
    			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
				by = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
    		}
        	
    		out.write(by);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	/** 下面的是电写入操作 */
	
	/**
	 * 获取开始顺序号和写卡数量 url
	 */
	public String querySnAndWc() {
		try {
			lIckzb = new ArrayList();
			String isHaveDate = "0";
			String startNum = "";
			String maxNum = "";
			String writeCount = "";
			Ickzb setIckzb=new Ickzb();
			setIckzb = (Ickzb)this.setClass(setIckzb, null);
			setIckzb = ickzbService.getIckzbDxrxx(setIckzb);
			if(setIckzb!=null){ //正常查到数据
				isHaveDate = "1";
				startNum = String.valueOf(setIckzb.getKssxh());
				maxNum = String.valueOf(setIckzb.getZdsxh());
				writeCount = String.valueOf(setIckzb.getBcdxrsl());
			}
			lIckzb.add(isHaveDate);
			lIckzb.add(startNum);
			lIckzb.add(maxNum);
			lIckzb.add(writeCount);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 获取从业人员信息 - 批写入
	 * @return
	 */
	public String queryCyryxxMes(){
		try {
			lIckzb = new ArrayList();
			Ickzb setIckzb=new Ickzb();
			setIckzb = (Ickzb)this.setClass(setIckzb, null);
			int maxRowsOfPage = Integer.parseInt(QjblUtil.queryQjblVal("zdpbh"));
			setIckzb.setMaxRowsOfPage(maxRowsOfPage);
			List tempList = ickzbService.getIckzbDxrList(setIckzb);
			
			List ickMesList = new ArrayList();
			if(tempList!=null&&tempList.size()>0){
				lIckzb.add(tempList); //从数据库查出来 直接放到JSON中
				for(int index=0,max=tempList.size();index<max;index++){
					Icksl ickslTemp = (Icksl)tempList.get(index);
					ickMesList.add(dianXieRuString(ickslTemp));
				}
				lIckzb.add(ickMesList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 获取从业人员信息 - 自定义写入
	 * @return
	 */
	public String queryCyryxxMesByCyrybh(){
		try {
			lIckzb = new ArrayList();
			Ickzb setIckzb=new Ickzb();
			setIckzb = (Ickzb)this.setClass(setIckzb, null);
			int maxRowsOfPage = Integer.parseInt(QjblUtil.queryQjblVal("zdpbh"));
			setIckzb.setMaxRowsOfPage(maxRowsOfPage);
			List tempList = ickzbService.getIckzbDxrList(setIckzb);
			
			List ickMesList = new ArrayList();
			if(tempList!=null&&tempList.size()>0){
				lIckzb.add(tempList); //从数据库查出来 直接放到JSON中
				Icksl temp = (Icksl)tempList.get(0);
				ickMesList.add(dianXieRuString(temp));
				lIckzb.add(ickMesList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	
	/**
	 * 将ic卡号(芯片号)写到数据库
	 * @return
	 */
	public String backWriteIckh(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		try {
			lIckzb = new ArrayList();
			String isSuccess = "0";
			Icksl setIcksl=new Icksl();
			setIcksl = (Icksl)this.setClass(setIcksl, null);
			if(!"".equals(setIcksl.getIckh())){
				
				setIcksl.setDxrr(user.getUseraccount()); //电写入人
				setIcksl.setDxrsj(new Date()); //电写入时间
				if(ickslService.updateIckslDxr(setIcksl)){
					isSuccess = "1";
				}
				lIckzb.add(isSuccess);
			} else {
				this.result="";
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
		return "success";
	}
	/**
	 * 得到写入ICK的内容
	 * @param resIcksl
	 * @return
	 */
	public String dianXieRuString(Icksl resIcksl){
		String cyrybh = resIcksl.getCyrybh();
		String hylbdm = resIcksl.getHylbdm();
		StringBuffer dxrResult = new StringBuffer();
			dxrResult.append(formatString(resIcksl.getXm(),30));
			if("N".equals(hylbdm)){
				dxrResult.append(formatString(cyrybh.substring(0,17),30));
			}else{
				dxrResult.append(formatString(cyrybh.substring(0,12),12));
				dxrResult.append(formatString(resIcksl.getZjhm(),18));
			}
			dxrResult.append(formatString(resIcksl.getXbdm(),1));
			dxrResult.append(formatString(resIcksl.getMzdm(),2));
			if("N".equals(hylbdm)){
				if("0".equals(resIcksl.getSfzx())){
					dxrResult.append(formatString("4",1));  //是否注销
				}else{
					dxrResult.append(formatString("5",1));
				}
			}else{
				dxrResult.append(formatString(resIcksl.getSfzx(),1));  
			}
			
			
			dxrResult.append(formatString(strDate(resIcksl.getCsrq()),8));
			dxrResult.append(formatString(resIcksl.getHjdxzqhdm(),6));
			dxrResult.append(formatString("",2));
			dxrResult.append(formatString(resIcksl.getHjdxz(),70));
			dxrResult.append(formatString(strDate(resIcksl.getYxsksrq()),8));
			dxrResult.append(formatString(strDate(resIcksl.getYxqhzrq()),8));
			dxrResult.append(formatString("",10));
			dxrResult.append(formatString(resIcksl.getYwx(),30));
			dxrResult.append(formatString(resIcksl.getYwm(),30));
			dxrResult.append(formatString(resIcksl.getGjdm(),3));
			dxrResult.append(formatString(resIcksl.getWgrjyxkz(),20));
			dxrResult.append(formatString("",13));
			
			if("N".equals(hylbdm)){
				// 从业人员编号小于等于20位的情况
//				dxrResult.append(formatString(cyrybh.replace(cyrybh.substring(0,12), ""),8));
				dxrResult.append(formatString(resIcksl.getKh(),14));
				dxrResult.append(formatString(resIcksl.getZjhm(),18));
				dxrResult.append(formatString(resIcksl.getCylbdm(),2));//从业人员类别代码
				dxrResult.append(formatString(resIcksl.getHjlbdm(),1)); //户籍类别代码
				dxrResult.append(formatString("",13));
			}else{
				if(cyrybh.length() > 20){
					// 从业人员编号21位的情况
					dxrResult.append(formatString((cyrybh.replace(cyrybh.substring(0,12), "")).substring(0,8),8));
					dxrResult.append(formatString(resIcksl.getKh(),14)+cyrybh.substring(cyrybh.length()-1, cyrybh.length()));
					dxrResult.append(formatString("",9));
				}else{
					// 从业人员编号小于等于20位的情况
					dxrResult.append(formatString(cyrybh.replace(cyrybh.substring(0,12), ""),8));
					dxrResult.append(formatString(resIcksl.getKh(),14));
					dxrResult.append(formatString("",10));
				}
			}
//			dxrResult.toString().getBytes("utf-8").length;
//			Integer i= dxrResult.length();
//			System.out.println("============================="+dxrResult.substring(0, i).getBytes().length);
		return dxrResult.toString();
	}
	/**
	 * 格式化字符串
	 * @param waitString
	 * @param length
	 * @return
	 */
	public String formatString(String waitString ,int length){
		String resultStr = "";
		if(waitString!=null){
			resultStr = waitString.trim();
		}else{
			resultStr = "";
		}
		try {
			int waitlength=0;
			for (int i=0;i<resultStr.length();i++){
				if (resultStr.substring(i, i+1).getBytes("utf-8").length>1){
					waitlength+=2;
					if (waitlength>length){
						waitlength-=2;
						resultStr=resultStr.substring(0, i);
						break;
					}
				}
				else{
					waitlength+=1;
					if (waitlength>length){
						waitlength-=1;
						resultStr=resultStr.substring(0, i);
						break;
					}
				}
			}
			if(waitlength<length){
				int cha = length-waitlength;
				for(int index=0;index<cha;index++){
					resultStr += " ";
				}
			} 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultStr;
	}
	/**
	 * 取得服务器时间 yyyy-MM-dd
	 * @return
	 */
	public static String strDate(Date date) {
		try {
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
			return formatter.format(date);
		} catch (Exception e) {  }
		return "";
	}
}