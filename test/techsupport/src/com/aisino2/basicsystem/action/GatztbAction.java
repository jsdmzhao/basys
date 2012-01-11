package com.aisino2.basicsystem.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.aisino2.basicsystem.domain.Gatztb;
import com.aisino2.basicsystem.domain.Gatztb_fj;
import com.aisino2.basicsystem.domain.Gatztbjsdw;
import com.aisino2.basicsystem.domain.YlcsjbxxForTree;
import com.aisino2.basicsystem.service.IDepartAndQiYeService;
import com.aisino2.basicsystem.service.IGatztbService;
import com.aisino2.basicsystem.service.IGatztbjsdwService;
import com.aisino2.cache.CacheManager;
import com.aisino2.common.IpMac;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.json.JsonUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.opensymphony.xwork2.ActionContext;

public class GatztbAction extends PageAction{
	private IGatztbjsdwService gatztbjsdwService;
	private IGatztbService gatztbService;
	private IDepartAndQiYeService departAndQiYeService;
	private IDepartmentService departmentService;
	private List lGatztb=new ArrayList();
	private Gatztb gatztb=new Gatztb();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	private User user;
	public void setDepartAndQiYeService(IDepartAndQiYeService departAndQiYeService) {
		this.departAndQiYeService = departAndQiYeService;
	}
	 //////////////////////////////////////////
	private String fileNamecon;
	private String base64codecon;
	private String fileTempNamecon;
	
	////////////////////////////////////////////////////
	private String title;
    private File[] upload;
    private String[] uploadContentType;
    private String[] uploadFileName;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Gatztb getGatztb() {
		return gatztb;
	}
	
	public List getLGatztb() {
		return lGatztb;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setGatztbService(IGatztbService gatztbService) {
		this.gatztbService = gatztbService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("gatbid");
		lPro.add("fbsj");
		lPro.add("fbdw");
		lPro.add("bt");
		lPro.add("fbr");
		lPro.add("qssl");
		lPro.add("gqbs");
		List lModify=new ArrayList();
		
    	List lTemp=new ArrayList();

    	lTemp=new ArrayList();
    	lTemp.add("gatbid");
    	lTemp.add("修改");
    	lTemp.add("gqbsFlg");
    	lTemp.add("0");
    	lModify.add(lTemp);
    	lTemp=new ArrayList();
    	lTemp.add("gatbid");
    	lTemp.add("撤销");
    	lTemp.add("gqbsFlg");
    	lTemp.add("0");
    	lModify.add(lTemp);
		
		
		
//    	List lModify=new ArrayList();
//    	lModify.add("setModifyQuery");
//    	lModify.add("修改");
//    	
//    	List lDel=new ArrayList();
//    	lDel.add("setDelete");
//    	lDel.add("撤销");
//    	
//    	List lCol=new ArrayList();
//    	lCol.add(lModify);
//    	lCol.add(lDel);
    	Gatztb getXctb=new Gatztb();
    	
    	this.setDataCustomer(getXctb, lData, lPro, null, lModify);
    	//this.setData(getXctb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	public void setTabledataCx(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("gatbid");
		lPro.add("fbsj");
		lPro.add("fbdw");
		lPro.add("bt");
		lPro.add("fbr");
		lPro.add("qssl");
		
		List lModify=new ArrayList();
    	lModify.add("setQianShouQuery");
    	lModify.add("签收");
    	
    	List lbg=new ArrayList();
    	lbg.add("setQsQuery");
    	lbg.add("签收详情");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lbg);
    	
		Gatztb getXctb=new Gatztb();
		
		this.setData(getXctb,lData,lPro,lCol);
		this.tabledata=this.getData();
		totalrows=this.getTotalrows(); 
	}
	
	public String querylist() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		  HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		  HttpSession session= request.getSession();
		  user= (User)session.getAttribute(Constants.userKey);
		  
        Gatztb setGatztb=new Gatztb();
        setGatztb=(Gatztb)this.setClass(setGatztb, null);
        Map map = new HashMap();
        map=addMap(setGatztb);
        map.put("fbdwbm", user.getDepartment().getDepartcode());
        Page page = gatztbService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lGatztb=page.getData();
        for(int i=0;i<lGatztb.size();i++){
        	Gatztb tempGatztb=(Gatztb)lGatztb.get(i);
        	if("0".equals(tempGatztb.getGqbs())){
        		tempGatztb.setGqbs("未撤销");
        		tempGatztb.setGqbsFlg("0");
        	}
        	if("1".equals(tempGatztb.getGqbs())){
        		tempGatztb.setGqbs("已撤销");
        		tempGatztb.setGqbsFlg("1");
        	}
        }
        setTabledata(lGatztb); 
		 this.result="success";
        return "success";
    }
	public String querylistCx() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		  HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		  HttpSession session= request.getSession();
		  user= (User)session.getAttribute(Constants.userKey);
		Gatztb setGatztb=new Gatztb();
		setGatztb=(Gatztb)this.setClass(setGatztb, null);
		Map map = new HashMap();
		map=addMap(setGatztb);
		map.put("qsFlg", setGatztb.getQsFlg());
		if(setGatztb.getFbdwbm()!=null&&!"".equals(setGatztb.getFbdwbm())){
			map.put("fbdwbm", StringUtil.trimEven0(setGatztb.getFbdwbm()));
		}else{
			map.put("fbdwbm", StringUtil.trimEven0(user.getDepartment().getDepartcode()));
		}
		map.put("jsdwbm", user.getDepartment().getDepartcode());
		Page page = gatztbService.getListForPage(map, pagesize, pagerow,sort,dir);
		totalpage=page.getTotalPages();
		totalrows=page.getTotalRows();
		lGatztb=page.getData();
		setTabledataCx(lGatztb); 
		this.result="success";
		return "success";
	}
	public Map addMap(Gatztb setGatztb){
		Map map=new HashMap();
		map.put("fbsj", setGatztb.getFbsj());
		map.put("fbsjzhi", setGatztb.getFbsjzhi());
		map.put("bt", setGatztb.getBt());
		map.put("fbr", setGatztb.getFbr());
		map.put("gqbs", setGatztb.getGqbs());
		return map;
	}
	
	public String query() throws Exception{
		try {
			Gatztb setGatztb=new Gatztb();
			gatztb=(Gatztb)this.setClass(setGatztb, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        gatztb=gatztbService.getGatztb(gatztb);
        lGatztb.clear();
        lGatztb.add(gatztb);
		this.result="success";
        return "success";
    }
	public String queryDetail() throws Exception{
		try {
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
			HttpSession session= request.getSession();
			User user= (User)session.getAttribute(Constants.userKey);
			Gatztb setGatztb=new Gatztb();
			setGatztb=(Gatztb)this.setClass(setGatztb, null);
			setGatztb=gatztbService.getGatztb(setGatztb);
			lGatztb.clear();
			lGatztb.add(setGatztb);
//			Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
//			setGatztbjsdw.setGatbid(setGatztb.getGatbid());
//			setGatztbjsdw.setJsdwbm(user.getDepartment().getDepartcode());
//			setGatztbjsdw=gatztbjsdwService.getGatztbjsdw(setGatztbjsdw);
//			if(setGatztbjsdw!=null&&setGatztbjsdw.getSqsj()==null){
//				IpMac ipMac = new IpMac();
//				String loginip = ipMac.getIpAddr(request);
//				setGatztbjsdw.setSqsj(new Date());
//				setGatztbjsdw.setSqip(loginip);
//				gatztbjsdwService.updateGatztbjsdw(setGatztbjsdw);
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}
	public String qianShou() throws Exception{
		try {
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
			HttpSession session= request.getSession();
			User user= (User)session.getAttribute(Constants.userKey);
			
			Gatztbjsdw setGatztbjsdw=new Gatztbjsdw();
			setGatztbjsdw=(Gatztbjsdw)this.setClass(setGatztbjsdw, null);
			Gatztbjsdw findGatztbjsdw=new Gatztbjsdw();
			findGatztbjsdw.setGatbid(setGatztbjsdw.getGatbid());
			findGatztbjsdw.setJsdwbm(user.getDepartment().getDepartcode());
			findGatztbjsdw=gatztbjsdwService.getGatztbjsdw(findGatztbjsdw);
			if(findGatztbjsdw!=null&&findGatztbjsdw.getSqsj()==null){
				IpMac ipMac = new IpMac();
				String loginip = ipMac.getIpAddr(request);
				setGatztbjsdw.setSqsj(new Date());
				setGatztbjsdw.setSqip(loginip);
				setGatztbjsdw.setGajsdwid(findGatztbjsdw.getGajsdwid());
				gatztbjsdwService.updateGatztbjsdw(setGatztbjsdw);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}
	
	public String insert() throws Exception{
		try {
			Gatztb_fj xctbfj = new Gatztb_fj();
			Object[] child = {xctbfj};///  绑定子属性
			Gatztb setGatztb=new Gatztb();
			setGatztb=(Gatztb)this.setClass(setGatztb, child);
			setGatztb.setGqbs("0");  ///////过期标志,0未过期，1过期
			formatFj(setGatztb);
			gatztb=null;
			gatztbService.insertGatztb(setGatztb);
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	public void formatFj(Gatztb gatztb){
		ActionContext ctx = ActionContext.getContext();
		  HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		  HttpSession session= request.getSession();
		 Map map= (Map)session.getAttribute("gztztbListMap");
		 gatztb.setJsdwMap(map);
		 session.removeAttribute("gztztbListMap");
		String serviceFile = ServletActionContext.getRequest().getRealPath("uploadTemp");  ///读取文件的目录
		List fjinfoList=gatztb.getLXctbfjList();
		for(int i=0;i<fjinfoList.size();i++){
			Gatztb_fj xctb_fj = new Gatztb_fj();
			xctb_fj = (Gatztb_fj)fjinfoList.get(i);
			String fjmc = xctb_fj.getFjmc();           //文件名称
			
			String[] fjlxarray = fjmc.split("\\.");
			String fjlx = fjlxarray[fjlxarray.length-1];  ////得到附件类型
			
			String fjbase = xctb_fj.getFjbase(); ///得到附件的临时文件名
			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
			BufferedInputStream bis = null;
			byte[] fjnr = null;        ///附件内容
			
			try {
				bis = new BufferedInputStream(new FileInputStream(serviceFile+"\\"+fjbase));
				fjnr = new byte[bis.available()];
				bis.read(fjnr);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(bis!=null){ bis.close(); }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			/////////删除临时文件夹中的文件
			File file = new File(serviceFile+"\\"+fjbase);
			if(file.exists()){
				file.delete(); //删除文件
			}
			//////////////////
			
			xctb_fj.setFjmc(fjmc);
			xctb_fj.setFjlx(fjlx);
			xctb_fj.setFjnr(fjnr);
			xctb_fj.setFjxh(i+1);
			//xctbfjList.add(xctb_fj);
		}
	}
	public String modify() throws Exception{
		try {
			Gatztb_fj xctbfj = new Gatztb_fj();
			Object[] child = {xctbfj};///  绑定子属性
			Gatztb setGatztb=new Gatztb();
			setGatztb=(Gatztb)this.setClass(setGatztb, child);
			formatFj(setGatztb);
			gatztbService.updateGatztb(setGatztb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Gatztb setGatztb=new Gatztb();
			setGatztb=(Gatztb)this.setClass(setGatztb, null);
			Gatztb updateGatztb=new Gatztb();
			updateGatztb.setGatbid(setGatztb.getGatbid());
			updateGatztb.setGqbs("1");
			gatztbService.updateGatztb(updateGatztb);
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	/**
	    * 根据部门树的选择 返回场所信息
	    * @throws Exception
	    */
	 private String reXml; 
	   public String getReXml() {
		return reXml;
	}

	public void setReXml(String reXml) {
		this.reXml = reXml;
	}
	 private String id;
	 public String getId() {
	 		return id;
    	}
	 public void setId(String id) {
	 		this.id = id;
	 	}	
	  /**
	    * 访问其他工程的action方法  得到指定管辖单位及其下属管辖单位下所有企业
	    * @return
	    */
	   public List getdataListall(String keyvalue,String para,String keyvalue2, String para2, String hylxdm){
		   	List dataList = new ArrayList();
		   
	 		List lParam=new ArrayList();
	  		List lChild=new ArrayList();
	  		List lChildRow=new ArrayList();
	  		List lChildRows=new ArrayList();
	  		List lChilds=new ArrayList();
	  		
	  		List lColValue=new ArrayList();
	  		lColValue.add(keyvalue);
	  		lColValue.add(para);
	  		lParam.add(lColValue);
	  		lColValue = new ArrayList();
	  		lColValue.add(keyvalue2);
	  		lColValue.add(para2);
	  		lParam.add(lColValue);
	  		
			Globalpar globalpar = new Globalpar();
			
		    /*************New source modify on 2010-1-5 begin**************/
			dataxml=JsonUtil.getXML(lParam,lChilds);
	        YlcsjbxxForTree ylcsjbxxForTree = new YlcsjbxxForTree();
	          try {
				ylcsjbxxForTree = (YlcsjbxxForTree)this.setClass(ylcsjbxxForTree, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        dataList = departAndQiYeService.QyTreeList(ylcsjbxxForTree,hylxdm);
			/*************New source modify on 2010-1-5 end**************/   		
		   return dataList;
	   }
	public String treeQiye() throws Exception{ 	//增加session中的节点   
		YlcsjbxxForTree ylcsjbxxForTree = new YlcsjbxxForTree();
		ylcsjbxxForTree = (YlcsjbxxForTree)this.setClass(ylcsjbxxForTree, null);
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<YlcsjbxxForTree> sessionCsList = (List)session.getAttribute("seesionCslist");
		if(sessionCsList!=null && sessionCsList.size()>0){
			  sessionCsList.remove(ylcsjbxxForTree); 
			 if(reXml!=null && reXml.equals("1"))
				 sessionCsList.add(ylcsjbxxForTree);
		}else{
			sessionCsList = new ArrayList();
			sessionCsList.add(ylcsjbxxForTree);
		}
		reXml="";
		int listLength = sessionCsList.size();
		int firstLength = 15>listLength?listLength:15;
		   for(int index=0; index<firstLength; index++) {
			   ylcsjbxxForTree = (YlcsjbxxForTree)sessionCsList.get(index); 
			   reXml += ylcsjbxxForTree.getCsmc()+";";
		   }  
		session.setAttribute("seesionCslist", sessionCsList);
		sessionCsList = null;
		return "success";
	}
	public String treeGa(){
		Map<String,String> map=new HashMap<String,String>();
		 String alldepartid = id;             ///返回部门节点的id 第一位是行业类型的编码 后边是公安部门的部门id
		 Department department = new Department();
		 Department tempDepartment = new Department();
		 ///树点击的是 是顶端的行业类别
		  ActionContext ctx = ActionContext.getContext();
		  HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		  HttpSession session= request.getSession();
		  user= (User)session.getAttribute(Constants.userKey);
		  map= (Map)session.getAttribute("gztztbListMap");
		  if(map==null){
				map=new HashMap();
			}
		  String deptCode = "";
		  deptCode = user.getDepartment().getDepartcode();
		  //depart = user.getDepartment();
		  
		  department.setDeptCode(StringUtil.trimEven0(deptCode));
		  department.setDepartid(Integer.parseInt(alldepartid));
		 List list= CacheManager.getCacheDepartment(department);
		 if(list!=null&&list.size()>0){
			 department = (Department)list.get(0);
		 }
		  tempDepartment.setDeptCode(StringUtil.trimEven0(department.getDepartcode()));
		  tempDepartment.setDepartname("");
		  tempDepartment.setDepartcode("");
		  tempDepartment.setDepartallpin("");
		  tempDepartment.setDepartsimplepin("");
		  tempDepartment.setDepartbrevitycode("");
		  List tempDepartmentList=CacheManager.getCacheDepartment(tempDepartment);
		  reXml=chengeMap(map,tempDepartmentList,reXml);
		  session.removeAttribute("gztztbListMap");
		  session.setAttribute("gztztbListMap", map);
		return "success";
	}
	public String chengeMap(Map<String,String> map,List list,String flg){
		String returnName="";
		
		for(int i=0;i<list.size();i++){
			Department department =(Department)list.get(i);
			if("1".equals(flg)){
				map.put(department.getDepartcode(), department.getDepartname());
			}
			if("0".equals(flg)){
				map.remove(department.getDepartcode());
			}
		}
		for( Entry<String,String> e : map.entrySet()){
			returnName+=e.getValue()+";";
		}
		return returnName;
	}
	/*************New source modify on 2010-1-5 begin**************/
	public String treeCs() throws Exception{//session中的节点
		   ////解析id值
		   String alldepartid = id;             ///返回部门节点的id 第一位是行业类型的编码 后边是公安部门的部门id
		   String hylxflag = id.substring(0, 1);  ////行业类型编码
		  
		   List<YlcsjbxxForTree> cslist = new ArrayList();          ///场所叶子节点的list
		   Department depart = new Department();

        if("*".equals(hylxflag)){ // 行业类别根节点
     	   hylxflag = id.substring(1,2);
     	   if("E".equals(hylxflag)||"F".equals(hylxflag)){ // 行业类别为旧货业时，行业类别为E01二手车；E02二手机；E03典当
    			 hylxflag = id.substring(1,4);
   	       }
     	   
     	   ///树点击的是 是顶端的行业类别
		  ActionContext ctx = ActionContext.getContext();
		  HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		  HttpSession session= request.getSession();
		  user= (User)session.getAttribute(Constants.userKey);
		  depart = user.getDepartment();
				  
		  cslist = getdataListall("gxdwbm",depart.getDepartcode(),"isAllGxdwbm","0",hylxflag); ///访问印章业的action 得到行业的机修业当企业(根据用户权限)
        }else{
        	String departid = id.substring(1); ///部门id
     	    if("E".equals(hylxflag)||"F".equals(hylxflag)){ // 行业类别为旧货业时，行业类别为E01二手车；E02二手机；E03典当
    			 hylxflag = id.substring(0,3);
    			 departid = id.substring(3);
    		}
          depart.setDepartid(Integer.parseInt(departid));
		  depart = departmentService.getDepartment(depart);
	      String departCode = depart.getDepartcode(); //得到部门编码
			 
		  cslist = getdataListall("gxdwbm",departCode,"isAllGxdwbm","0",hylxflag); //访问action 得到该部门下的全部企业
        }
        if(cslist==null){
	 		  cslist = new ArrayList();
	 	  }
		   HttpSession session = ServletActionContext.getRequest().getSession();
		   List<YlcsjbxxForTree> sessionCsList = (List)session.getAttribute("seesionCslist");
		  //sessionCsList.remove(o)
		   int listLength = cslist.size();
		  YlcsjbxxForTree ylcs1;
		   if(sessionCsList!=null && sessionCsList.size()>0){
		   int seListLength=sessionCsList.size();

		  if(listLength>seListLength){
			 for (int index=0; index<seListLength; index++) {
				cslist.remove((YlcsjbxxForTree)sessionCsList.get(index)); 
	 		  } 
		  }else{
			 for (int index=0; index<listLength; index++) {
				sessionCsList.remove((YlcsjbxxForTree)cslist.get(index)); 
	 		  } 
		  }
		  if(reXml!=null && reXml.equals("1"))
			  cslist.addAll(sessionCsList);
		  else
			 cslist = sessionCsList;
		 listLength = cslist.size();
		  }
		  reXml="";
		  int firstLength = 15>listLength?listLength:15;
		  for (int index=0; index<firstLength; index++) {
			  ylcs1 = (YlcsjbxxForTree)cslist.get(index); 
			  reXml += ylcs1.getCsmc()+";";
		  }  
		 session.setAttribute("seesionCslist", cslist);
		 	
		cslist = null;
		sessionCsList = null;
			id = null;
			
			return "success";
		   
	   }
	public void tree2() throws Exception{
		   
	    //id = null;
	    List departlistshow = new ArrayList();
	    List cslist = new ArrayList();          ///场所叶子节点的list  
	    List hylblist = new ArrayList();        ////行业类别的节点
	    Map condition = new HashMap();
	    Department depart = new Department();
	    
	    //////start
	    String hylbflag = ""; /////行业类别标志  在公安机关每一级的id前加上行业类别标志的字母如Y32
	    if(id!=null){
	    	hylbflag = id.substring(0,1);
	    }
	    //////end
	    
	    if(id==null){
	    	
//	    	String hylbauth = "";  //权限字段
//	    	String[] arrHylbAuth = null;
//	    	if(hylbdmall!=null){
//	    		hylbauth = hylbdmall;
//	    		arrHylbAuth = hylbauth.split(";");
//	    	}
//	    	Dict_item dict_item = new Dict_item();
//		    dict_item.setDict_code("dm_hylb");
//		    List hylblistshow = dict_itemService.getListDict_item(dict_item);
		    
		    ////只显示选择的行业
//		    for(int u=0;u<hylblistshow.size();u++){
//		    	Dict_item testdict = new Dict_item();
//		    	testdict = (Dict_item)hylblistshow.get(u);
//		    
//		    	/*************New source modify on 2010-1-5 begin**************/
//		    	if(arrHylbAuth != null){
//		    		for(int index=0;index<arrHylbAuth.length;index++){
//			    	    if(arrHylbAuth[index].equals(testdict.getFact_value())){
//			    		    hylblist.add(testdict);
//			    	    }
//			    	}
//		    	}
//		    	/*************New source modify on 2010-1-5 end**************/
//		    }
		    ////
		    
		    if(hylblist==null){
		    	hylblist = new ArrayList(); 
		    }
		    id = Integer.toString(0);
		  
		    /*************New source modify on 2010-1-5 begin**************/
	    }else if("*".equals(id.substring(0,1))){ // 行业类别根节点
	    	hylbflag = id.substring(1,2);
	    	if("E".equals(hylbflag)||"F".equals(hylbflag)){ // 行业类别为旧货业时，行业类别为E01二手车；E02二手机；E03典当  F01 出租车  F02 汽车租赁
	    		hylbflag = id.substring(1,4);
   	        }
	    	
	    	/*************New source modify on 2010-1-5 end**************/
	      ActionContext ctx = ActionContext.getContext();
		  HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		  HttpSession session = request.getSession();
		  User user = (User) session.getAttribute(Constants.userKey);
		  Department userdepartment = new Department();		  
		  userdepartment.setDepartid(user.getDepartid());
		  userdepartment = departmentService.getDepartment(userdepartment);
		  departlistshow.add(userdepartment);
		  
	    }else{ // 公安根节点
	    	String departid = id.substring(1,id.length());///部门id
	    	/*************New source modify on 2010-1-5 begin**************/
	    	if("E".equals(hylbflag)||"F".equals(hylbflag)){ // 行业类别为旧货业时，行业类别为E01二手车；E02二手机；E03典当
	    		hylbflag = id.substring(0,3);
	    		departid = id.substring(3);
	    	}
	    	
	    	/*************New source modify on 2010-1-5 end**************/
	    	depart.setDepartid(Integer.parseInt(departid));  //除去第一个字母才是部门id
		    depart = departmentService.getDepartment(depart);
		    String departCode = depart.getDepartcode(); //得到部门编码
		    String departCodetrim = StringUtil.trimEven0(departCode); /////去掉后边0的部门编码
		    	
		    /*************New source modify on 2010-1-5 begin**************/
//			departlistshow = getdepartListall("departid",departid,"departcode",departCodetrim,hylbflag);  ////访问印章业的action 得到部门
//			cslist = getdataListall("gxdwbm",departCode,"isAllGxdwbm","1",hylbflag); ///访问典当业的action 得到下属的印章企业
		    /*************New source modify on 2010-1-5 begin**************/
		    if(departlistshow==null){
				departlistshow = new ArrayList();
			}
		    if(cslist==null){
				cslist = new ArrayList();
			}
	    }
		
		String xml = "<?xml version='1.0' encoding='utf-8'?> \n";
		    xml += "<tree id=\"" + id + "\"> \n";
		    /////行业类别
		    for (int i = 0; i < hylblist.size(); i++) {
		    	Dict_item dict_item  = (Dict_item)hylblist.get(i);
			     xml += "<item text=\"" + dict_item.getDisplay_name()+ "\" id=\"" + "*" +
			              dict_item.getFact_value()
			              +"\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
			            xml += "child=\"1\">\n";
			      xml += "</item>\n";
			    }
		    
		    ///公安机关
		    for (int i = 0; i < departlistshow.size(); i++) {
		    Department department = (Department)departlistshow.get(i);
		     xml += "<item text=\"" + department.getDepartname()+ "\" id=\"" +
		              hylbflag+Integer.toString(department.getDepartid())
		              +"\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
		            xml += "child=\"1\">\n";
		      xml += "</item>\n";
		    }
		      
		    ////场所节点
		    for (int n = 0; n<cslist.size();n++){
		       YlcsjbxxForTree ylcs1 = new YlcsjbxxForTree();
		       ylcs1 = (YlcsjbxxForTree)cslist.get(n);
		       /////userdata 字符串 场所编码||场所名称||行业类别编码||行业类别名称
		       String userdateStr = ylcs1.getHylxbm()+"||"+ylcs1.getHylxmc();
		       xml += "<item text=\"" + ylcs1.getCsmc()+ "\" id=\"" +"-"+ylcs1.getCsbm()
	              +"\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
	           xml += "child=\"0\">\n";
	      
	           xml += "<userdata name=\""+"-"+ylcs1.getCsbm()+"\">"+userdateStr+"</userdata>\n";
	           xml += "</item>\n";
		    }  
		    xml += "</tree>";
		    //System.out.println(xml);
		    
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(xml);
			//关闭流 
			out.close();
			
			id = null;
    }
	/**
	 * 上传临时文件
	 * @return
	 * @throws Exception
	 */
	public String uptempfile() throws Exception{
		
		BASE64Decoder base64Decoder = new BASE64Decoder();
		RandomAccessFile os = null;
		String serviceFile = ServletActionContext.getRequest().getRealPath("uploadTemp"); ///文件存放路径
		
		long nowtime = System.currentTimeMillis();   /////根据时间得到文件名字
		String[] fjlxarray = fileNamecon.split("\\.");
		String fjlx = fjlxarray[fjlxarray.length-1];  ////得到附件类型
		String fileTempName = String.valueOf(nowtime)+"."+fjlx;
		try {
			byte[] bytetemp = base64Decoder.decodeBuffer(base64codecon);
			os = new RandomAccessFile(serviceFile+"\\"+fileTempName,"rw");
			os.write(bytetemp, 0, bytetemp.length);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(os!=null){ os.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		fileTempNamecon = fileTempName;   /////把临时文件的名字回传给页面
		base64codecon = "";
		this.result="success";
        return "success";
		
	}
	
	/**
	 * 删除单条临时文件
	 * @return
	 * @throws Exception
	 */
	public String deleteFile() throws Exception{
		
		String serviceFile = ServletActionContext.getRequest().getRealPath("uploadTemp"); ///文件存放路径
		File file = new File(serviceFile+"\\"+fileTempNamecon);
		if(file.exists()){
			file.delete(); //删除文件
		}
		fileTempNamecon="";
		this.result="success";
        return "success";
	}
	
	/**
	 * 删除 本条通报的全部临时文件
	 * @return
	 * @throws Exception
	 */
	public String deleteAllFile() throws Exception{
		
		try{
		   Gatztb_fj xctbfj = new Gatztb_fj();
		   Object[] child = {xctbfj};///  绑定子属性
		   Gatztb setXctb=new Gatztb();
		   setXctb=(Gatztb)this.setClass(setXctb, child);
		   List fjinfoList = setXctb.getLXctbfjList();
		   String serviceFile = ServletActionContext.getRequest().getRealPath("uploadTemp");  ///读取文件的目录
		   for(int i=0;i<fjinfoList.size();i++){
			   xctbfj = (Gatztb_fj)fjinfoList.get(i);
			   String fjbase = xctbfj.getFjbase(); ///得到附件的临时文件名
			   File file = new File(serviceFile+"\\"+fjbase);
				if(file.exists()){
					file.delete(); //删除文件
				}
		   }
			
		}catch(Exception e){
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
    /**
     * 初始化 修改
     * @return
     * @throws Exception
     */
	public String initxctbupdate() throws Exception{
		try {
			Gatztb setGatztb=new Gatztb();
			gatztb=(Gatztb)this.setClass(setGatztb, null);
			gatztb = gatztbService.getGatztb(gatztb);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.result="success";
		return "success";
	}
	/**
	 * 部门树的生成
	 * 
	 * @throws Exception
	 */
	public void deptTree() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		Department UserDepartment = new Department();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.userKey);
		Map<String,String> map= (Map)session.getAttribute("gztztbListMap");
		if(user.getDepartment().getDepartcode().indexOf("ZKD")!=-1){//制卡端用户登录
			UserDepartment.setDepartcode(user.getDepartment().getDepartcode().substring(3));
		}else{
			UserDepartment.setDepartid(user.getDepartid());
		}
		//UserDepartment.setDepartid(user.getDepartid());
		UserDepartment = departmentService.getDepartment(UserDepartment);
		List lst = new ArrayList();
		Department departmentOne = new Department();
		// id = "0";
		if (id == null
				|| id.trim().equals(
						String.valueOf(UserDepartment.getParentdepartid()))) {
			
			id = String.valueOf(UserDepartment.getParentdepartid());
			departmentOne = UserDepartment;
			lst.clear();
			lst.add(departmentOne);
		} else {
			departmentOne.setDepartid(Integer.parseInt(id));
			// departmentOne.setDepartid(UserDepartment.getDepartid());
			lst = departmentService.getChildDepart(departmentOne);
		}
		String xml = "";
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version='1.0' encoding='utf-8'?> \n");
		xmlBuffer.append("<tree id=\"" + id + "\"> \n");

		for (int i = 0; i < lst.size(); i++) {
			departmentOne = (Department) lst.get(i);
			String checked="";
			if(map!=null){
				String code=StringUtil.trimEven0(departmentOne.getDepartcode());
				for( Entry<String,String> e : map.entrySet()){
					if(e.getKey().indexOf(code)!=-1){
						checked=" im3=\"1\" ";
						break;
					}
				}
			}
			xmlBuffer.append("<item text=\""
					+ departmentOne.getDepartname()
					+ "\" id=\""
					+ departmentOne.getDepartid()
					+ "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" "+checked);
			if ("Y".equals(departmentOne.getIsleaf())) {
				xmlBuffer.append("child=\"0\">");
			} else {
				xmlBuffer.append("child=\"1\">");
			}
			xmlBuffer.append("<userdata name=\""+ departmentOne.getDepartid()+ "\">"
					+ departmentOne.getDepartcode()
					+ ","
					+ com.aisino2.common.StringUtil.trimEven0(departmentOne.getDepartcode())
					+","
					+departmentOne.getDepartlevel() 
					+","
					+departmentOne.getParentdepartid() 
					+","
					+departmentOne.getDepartfullcode()
					+","
					+departmentOne.getIsleaf()
					+ "</userdata>");
			xmlBuffer.append("</item>");
		}
		xmlBuffer.append("</tree>");
		xml = xmlBuffer.toString();
		// java.lang.System.out.println(xml);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(xml);
		out.close();
	}
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String getFileNamecon() {
		return fileNamecon;
	}

	public void setFileNamecon(String fileNamecon) {
		this.fileNamecon = fileNamecon;
	}

	public String getBase64codecon() {
		return base64codecon;
	}

	public void setBase64codecon(String base64codecon) {
		this.base64codecon = base64codecon;
	}

	public String getFileTempNamecon() {
		return fileTempNamecon;
	}

	public void setFileTempNamecon(String fileTempNamecon) {
		this.fileTempNamecon = fileTempNamecon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public void setGatztbjsdwService(IGatztbjsdwService gatztbjsdwService) {
		this.gatztbjsdwService = gatztbjsdwService;
	}
}