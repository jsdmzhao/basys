package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.DepartmentUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.ISystemService;
import com.opensymphony.xwork2.ActionContext;

public class DepartmentAction extends PageAction{
	private IDepartmentService departmentService;
	private ISystemService systemService;
	private List lDepartment;
	private List ldata;
	private Department department;
	private Department nowDepartment;
	private String tabledata;
	private int totalrows;
	private String result="";
	private String strResult;
	private String query_simplepin;
	
	private String moveParentid;
	private String moveSelectId;
	private String moveWay;
	
	public List getLdata() {
		return ldata;
	}
	public void setLdata(List ldata) {
		this.ldata = ldata;
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
	public Department getDepartment() {
		return department;
	}
	public List getLDepartment() {
		return lDepartment;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setMoveParentid(String moveParentid) {
		this.moveParentid = moveParentid;
	}
	public void setMoveSelectId(String moveSelectId) {
		this.moveSelectId = moveSelectId;
	}
	public void setMoveWay(String moveWay) {
		this.moveWay = moveWay;
	}
	public Department getNowDepartment() {
		return nowDepartment;
	}
	public String getStrResult() {
		return strResult;
	}
	public void setSystemService(ISystemService systemService) {
		this.systemService = systemService;
	}
	
	public String getQuery_simplepin() {
		return query_simplepin;
	}
	public void setQuery_simplepin(String query_simplepin) {
		this.query_simplepin = query_simplepin;
	}
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
        lPro.add("departid");
		lPro.add("departcode");
		lPro.add("departname");
		lPro.add("parentdepartname");
		
        List lXzcz=new ArrayList();
    	List lCk = new ArrayList();
    	lCk.add("dept");
    	lCk.add("详细");
    	lCk.add("child_count");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("dept");
    	lCk.add("详细");
    	lCk.add("child_count");
    	lCk.add("1");
    	lXzcz.add(lCk);

    	lCk = new ArrayList();
    	lCk.add("dept");
    	lCk.add("修改");
    	lCk.add("child_count");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	lCk = new ArrayList();
    	lCk.add("dept");
    	lCk.add("修改");
    	lCk.add("child_count");
    	lCk.add("1");
    	lXzcz.add(lCk);

    	lCk = new ArrayList();
    	lCk.add("dept");
    	lCk.add("删除");
    	lCk.add("child_count");
    	lCk.add("0");
    	lXzcz.add(lCk);
    	
    	lCk = new ArrayList();
    	lCk.add("cantdept");
    	lCk.add("删除");
    	lCk.add("child_count");
    	lCk.add("1");
    	lXzcz.add(lCk);
    	
    	Department getDepartment=new Department();
    	
        this.setDataCustomer(getDepartment,lData,lPro,null,lXzcz);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	/**
	 * 为管辖单位筛选框赋值
	 * @param lData
	 * @throws Exception
	 */
	public void setTabledataGxdw(List lData) throws Exception{
        List lPro=new ArrayList();
        lPro.add("departid");
        lPro.add("departname");
        lPro.add("departsimplepin");
        lPro.add("departcode");
    	
    	Department getDepartment=new Department();
    	
        this.setData(getDepartment,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
        
    
	}
	public String queryDepartment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String departid = request.getParameter("departid");
		if(departid==null||"".equals(departid)){
			departid = String.valueOf(user.getDepartid());
		}
		request.setAttribute("departid", departid);
		return SUCCESS;
	}
	public String showDepart() throws Exception{
		try {
			Department setDepartment=new Department();
			nowDepartment=(Department)this.setClass(setDepartment, null);
			nowDepartment=departmentService.getDepartment(nowDepartment);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	/**
	 * 获取下一级机构信息

	 * @return
	 * @throws Exception
	 */
	public String querylist() throws Exception{
		if (sort!=null){
			if (sort.equals("0"))
				sort="departcode ";
			else if (sort.equals("1"))
				sort="departname ";
			else if (sort.equals("2"))
				sort="parentdepartid ";
			else{
				sort=null;
			}
		}
		try {
			Department setDepartment=new Department();
			department=(Department)this.setClass(setDepartment, null);
			Map map = new HashMap();
			if(department!=null){
				map.put("parentdepartid", department.getDepartid());
			}
			Page page = departmentService.getListForPage(map, pagesize, pagerow,null,null);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledata(page.getData());
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	/**
	 * 根据主键取一条机构信息

	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception{
		try {
			Department setDepartment=new Department();
			department=(Department)this.setClass(setDepartment, null);
			department=departmentService.getDepartment(department);
			lDepartment = new ArrayList();
			lDepartment.add(department);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Department setDepartment=new Department();
			department=(Department)this.setClass(setDepartment, null);
			department=departmentService.insertDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Department setDepartment=new Department();
			department=(Department)this.setClass(setDepartment, null);
			departmentService.updateDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Department setDepartment=new Department();
			department=(Department)this.setClass(setDepartment, null);
			departmentService.deleteDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
        this.result="success";
        return "success";
    }
	/**
	 * 移动排序
	 * @return
	 */
	public String moveSort(){
		try {
			Department temp = new Department();
			temp.setParentdepartid(Integer.parseInt(moveParentid));
			temp.setDepartid(Integer.parseInt(moveSelectId));
			temp.setWay(moveWay);
			departmentService.updateDeptEditEdOrder(temp);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
	}
	/**
	 * 获取 兄弟节点最大排序号
	 * @return
	 */
	public String nextNodeorder(){
		try {
			strResult = "";
			Department setDepartment=new Department();
			setDepartment=(Department)this.setClass(setDepartment, null);
			strResult = String.valueOf(departmentService.getNextNodeorder(setDepartment));
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
	}
	public String validateDepartment(){
		try {
			strResult = "";
			Department setDepartment=new Department();
			department=(Department)this.setClass(setDepartment, null);
			String departcode = department.getDepartcode();
			Map map = new HashMap();
			map.put("tableName", "t_department");
			if(departcode!=""){
				map.put("departcode", departcode);
			}
			boolean result = systemService.isExit(map);
			if(result){	
				strResult = "1";
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
	 * 字典下拉列表查询,分页,用于每次从数据库中取数据,暂时注释掉,勿删！！
	 * @return
	 * @throws Exception
	 */
	/*public String queryGxdw() throws Exception{
		try {
			Department setDepartment=new Department();
			department=(Department)this.setClass(setDepartment, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		User user = new User();
		user = (User)session.getAttribute(Constants.userKey);
		String deptCode = "";
		deptCode = user.getDepartment().getDepartcode();
		deptCode = com.aisino2.common.StringUtil.trimEven0(deptCode);
		if(deptCode != null)
		{
			if(deptCode.indexOf("CJD")!=-1)
			{
				deptCode = deptCode.substring(3);
			}
		}
        Map map = new HashMap();
        //登录用户所在部门
        map.put("deptCode", deptCode);
        //筛选条件
        if(department.getQuery_simplepin() != null)
        	map.put("query_simplepin", department.getQuery_simplepin());
        
        if(lDepartment ==null)
        	lDepartment = new ArrayList();
        lDepartment.clear();
        Page page = departmentService.getDicListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lDepartment=page.getData();
        setTabledataGxdw(lDepartment); 
		this.result="success";
        return "success";
    }*/
	
	/**
	 * 字典下拉列表查询,分页,用于每次从内存中取数据
	 * @return
	 * @throws Exception
	 */
	public String queryGxdw() throws Exception{
		try {
			Department setDepartment=new Department();
			department=(Department)this.setClass(setDepartment, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		User user = new User();
		user = (User)session.getAttribute(Constants.userKey);
		String deptCode = "";
		deptCode = user.getDepartment().getDepartcode();
		deptCode = DepartmentUtil.doWithDepartmentCode(deptCode);
		//登录用户所在部门
		//deptCode = "32";//测试数据
		department.setDeptCode(deptCode);
		//department.setDepartcode(deptCode);
        //筛选条件
        if(department.getQuery_simplepin() != null)
        {
        	String tempStr = department.getQuery_simplepin() ;
        	if(tempStr==null)
        		tempStr = "";
        	department.setDepartcode(tempStr);
        	department.setDepartname(tempStr);
        	department.setDepartallpin(tempStr);
        	department.setDepartsimplepin(tempStr);
        	department.setDepartbrevitycode(tempStr);
        }
        if(lDepartment ==null)
        	lDepartment = new ArrayList();
        lDepartment.clear();
        
        List tempDepartmentList = new ArrayList();
		//内存中查询数据
        tempDepartmentList = CacheManager.getCacheDepartment(department);
		//总页数及总记录数
		totalpage=(tempDepartmentList.size()%pagerow==0)?tempDepartmentList.size()%pagerow:tempDepartmentList.size()%pagerow+1;
        totalrows=tempDepartmentList.size();
        //当前页开始及结束序号
		int startIndex = 0;
		int endIndex = 0;
		startIndex  = (pagesize-1)*pagerow;
		endIndex = (totalrows<pagesize*pagerow)?totalrows:pagesize*pagerow;
		//取得当前页记录列表
		lDepartment = tempDepartmentList.subList(startIndex, endIndex);
		
        setTabledataGxdw(lDepartment); 
		this.result="success";
        return "success";
    }
	
	/**
	 * 机构采集点下拉列表查询
	 * @return
	 * @throws Exception
	 */	
public String querySelDepart() throws Exception{
	try {
		Department setDepartment=new Department();
		department=(Department)this.setClass(setDepartment, null);
		//setDict_item.setDict_code(dict_code);
		//}
		ldata = new ArrayList();
		
		ldata=departmentService.getListDepartment(department);
		
		if(ldata==null)
			ldata = new ArrayList();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.result="success";
	return "success";
}

/**
 * 机构公安机关下拉列表查询
 * @return
 * @throws Exception
 */	
public String querySelDepartGa() throws Exception{
try {
	Department setDepartment=new Department();
	department=(Department)this.setClass(setDepartment, null);
	//setDict_item.setDict_code(dict_code);
	//}
	setDepartment.setDepartcode(department.getDeptCode());
	setDepartment = departmentService.getDepartment(setDepartment);
	ldata = new ArrayList();
	
	department.setParentdepartid(setDepartment.getDepartid());
	department.setDeptCode(null);
	ldata=departmentService.getListDepartment(department);
	
	if(ldata==null)
		ldata = new ArrayList();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
this.result="success";
return "success";
}
/**
 * 机构公安机关下拉列表查询(当公安机关选择全部时，下一级的全部数据检索)
 * @return
 * @throws Exception
 */	
public String queryAllDepartGa() throws Exception{
try {
	Department setDepartment=new Department();
	ActionContext ctx = ActionContext.getContext();
	HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
	HttpSession session = request.getSession();
	User user = new User();
	user = (User)session.getAttribute(Constants.userKey);
	
	//setDepartment.setDeptCode(user.getDepartment().getDepartcode());
	setDepartment.setDepartcode(user.getDepartment().getDepartcode());
	setDepartment.setDepartid(user.getDepartment().getDepartid());
	setDepartment.setParentdepartid(user.getDepartment().getDepartid());
	ldata = new ArrayList();
	ldata=departmentService.getListAllDepartment(setDepartment);
	
	if(ldata==null)
		ldata = new ArrayList();
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
this.result="success";
return "success";
}


}