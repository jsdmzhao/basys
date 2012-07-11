package com.aisino2.techsupport.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.common.PageUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IUserService;
import com.aisino2.sysadmin.service.IUser_roleService;
import com.aisino2.techsupport.domain.Attachment;
import com.aisino2.techsupport.service.IAttachmentService;
import com.aisino2.techsupport.service.WorksheetService;

/**
 * 
 * 支持单公用视图
 */
@SuppressWarnings("serial")
@Component("TSCommonAction")
@Scope("prototype")
public class TSCommonAction extends PageAction {
	private IDepartmentService departmentService;
	private IUserService userService;
	private WorksheetService sheet_service;
	private List<User> userList;
	private User user;
	private Department dept;
	private String result;
	private String tabledata = "";
	// 文件上传部分
	private String upload;
	private String uploadContentType;
	private String uploadFileName;
	
	// 临时存放目录
	private String uploadTempPath;
	private List<Attachment> attachmentList;
	private String uploadId;
	
	private IAttachmentService attachmentService;
	//机构代码列表
	private List departcode_list;
	private IUser_roleService userrole_service;
	
	private int totalrows;
	
	/**
	 * 批号 
	 */
	private String batchNumber;
	
	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	@Resource(name="user_roleService")
	public void setUserrole_service(IUser_roleService userrole_service) {
		this.userrole_service = userrole_service;
	}

	public List getDepartcode_list() {
		return departcode_list;
	}

	public void setDepartcode_list(List departcode_list) {
		this.departcode_list = departcode_list;
	}

	// ++ 通过角色筛选用户
	
	public String querylistUserofDept() throws Exception {

		User setUser = new User();
		user = (User) this.setClass(setUser, null);
		
		Map map = new HashMap();
		//是否递归,用user对象里面checkbox字段来存放递归标识
		map.put("is_recursive", Boolean.parseBoolean(user.getCheckbox()));
		departcode_list = new ArrayList<String>();
		dept = new Department();
		if(user.getDepartcode()!=null && !"".equals(user.getDepartcode())){
			for(String departcode : user.getDepartcode().split(",")){
				dept.setDepartcode(departcode);
				dept = departmentService.getDepartment(dept);
				if(map.get("is_recursive") == Boolean.FALSE)
					departcode_list.add(dept.getDepartcode());
				else
					departcode_list.add(dept.getDepartfullcode());
			}
			
		}
		
		

		map.put("username", user.getUsername());
		//多个机构
		map.put("departcodes", departcode_list);
		
		
		//++设置角色名称列表
		List<String> rolename_list = new ArrayList<String>();
		rolename_list.addAll(Arrays.asList(user.getUseridSet().split(",")));
		map.put("userRoles", rolename_list);
		//--设置角色名称列表

		Page userpageList = userService.getListForPage(map, pagesize, pagerow,
				null, "desc");

		userList = userpageList.getData();
		for (User user : userList) {
			user.setDepartname(user.getDepartment().getDepartname());
		}
		totalpage = userpageList.getTotalPages();
		totalrows = userpageList.getTotalRows();

		setTabledata(userList);
		this.result = "success";
		return SUCCESS;
	}

	// -- 通过角色筛选用户
	/**
	 * 获取用户管辖地区的机构代码
	 * @return
	 * @throws Exception
	 */
	public String find_departcode_of_userrole() throws Exception{
		if(user == null || user.getUserid() == null)
			throw new RuntimeException("需要获取用户管辖地区机构代码的用户ID为空");
		
		return SUCCESS;
	}
	
	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("userid");
		lPro.add("username");
		lPro.add("userid");
		lPro.add("departname");

		List lModify = new ArrayList();
		lModify.add("setSzxxModify");
		lModify.add("修改");

		List lDel = new ArrayList();
		lDel.add("setSzxxDelete");
		lDel.add("删除");

		List lDetail = new ArrayList();
		lDetail.add("setSzxxDetail");
		lDetail.add("详情");

		this.setDataCustomer(user, lData, lPro, null, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public void setTabledataForAttachment(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("attachmentId");
		lPro.add("attachmentName");
		lPro.add("attachmentSize");
		lPro.add("attachmentComment");

		List lCol = new ArrayList();
		List lModify = new ArrayList();

		//填报人,技术质量员权限的用户可以删除附件。
		
		if(PageUtil.checkFunction("ts_removeAttachment")){
			lModify.add("removeAttachment");
			lModify.add("删除");
			lCol.add(lModify);
		}
		if(PageUtil.checkFunction("ts_downloadAttachment")){
			List lDownload = new ArrayList();
			lDownload.add("downloadAttachment");
			lDownload.add("下载");

			lCol.add(lDownload);
		}
		if(PageUtil.checkFunction("ts_viewAttachment")){
			List lDetail = new ArrayList();
			lDetail.add("detailAttachemnt");
			lDetail.add("查看");
			
			lCol.add(lDetail);
		}

		//
		// this.setData(getGlryzmdzcl,lData,lPro,lCol);
		Attachment attachment_ = new Attachment();
		this.setData(attachment_, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	/**
	 * 文件上传
	 * 
	 * @return
	 * @throws Exception
	 */
	public String uploadFile() throws Exception {
		HttpServletRequest req = this.getRequest();
		this.uploadTempPath=req.getParameter("folder");
		File dir = new File(this.getUploadTempPath());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		File upload_file = new File(upload);
		if(!upload_file.exists())
			throw new RuntimeException("文件不存在，可能被别人或者自动清理程序删除");
		String real_filename = uploadId+"__"+System.currentTimeMillis();
		
		Attachment attachment = new Attachment();
		attachment.setAttachmentContentType(uploadContentType);
		attachment.setAttachmentName(uploadFileName);
		attachment.setBatchNumber(uploadId);
		attachment.setUploadTime(new Date());
		attachment.setAttachmentPath(uploadTempPath + "/" + real_filename);
		
		attachmentService.insertAttachment(attachment);
		
		//存放文件到指定地点
		byte[] buff = new byte[8192];
		int len = 0;
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(upload_file));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(this.getUploadTempPath()+"/"+real_filename));
		while((len = bis.read(buff, 0, buff.length)) > -1){
			bos.write(buff, 0, len);
		}
		
		bos.close();
		bis.close();
		
		return SUCCESS;
	}

	/**
	 * 文件下载
	 * 
	 * @return
	 * @throws Exception
	 */
	public String downloadFile() throws Exception {
		
		return SUCCESS;
	}

	/**
	 * 文件删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteFile() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 生成批号
	 * @return
	 * @throws Exception
	 */
	public String generateBatchNumber() throws Exception{
		//生成一个128位的随机的UUID
		batchNumber = UUID.randomUUID().toString();
		
		return SUCCESS;
	}
	
	// ++ 通过角色筛选地区字典
	
	public String querylistRegionByRole() throws Exception{
		User current_user = (User) this.getRequest().getSession().getAttribute(Constants.userKey);
		Dict_item item = new Dict_item();
		item = (Dict_item)this.setClass(item, null);
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("userid", current_user.getUserid());
		map.put("departcode", current_user.getDepartment().getDepartcode());
		
		Page page = sheet_service.get_region_with_userrole_for_page(map,pagesize,pagerow,dir,sort);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		setTabledataDict(page.getData());
		this.result = SUCCESS;
		return SUCCESS;
	}
	
	public void setTabledataDict(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("item_id");
		
		lPro.add("display_name");
		lPro.add("item_simplepin");
		lPro.add("item_allpin");
		lPro.add("fact_value");
    	
    	Dict_item getDict_item=new Dict_item();
    	
        this.setData(getDict_item,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	// -- 通过角色筛选地区字典
	
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public String getTabledata() {
		return tabledata;
	}

	public void setTabledata(String tabledata) {
		this.tabledata = tabledata;
	}

	@Resource(name = "departmentService")
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Resource(name = "userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	public String getUploadTempPath() {
		return this.getRequest().getSession().getServletContext().getRealPath("/")+ uploadTempPath;
	}

	public void setUploadTempPath(String uploadTempPath) {
		this.uploadTempPath = uploadTempPath;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getUploadId() {
		return uploadId;
	}

	public void setUploadId(String uploadId) {
		this.uploadId = uploadId;
	}

	@Resource(name="attachmentServiceImpl")
	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

	@Resource(name="WorksheetServiceImpl")
	public void setSheet_service(WorksheetService sheet_service) {
		this.sheet_service = sheet_service;
	}


	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}
