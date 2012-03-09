package com.aisino2.techsupport.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.common.ItemChange;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.sysadmin.service.IUser_roleService;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.Supervision;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.ISupervisionService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;
import com.aisino2.techsupport.service.WorksheetService;

@Component
@Scope("prototype")
public class SupportTicketAction extends PageAction implements
		ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3098731859151256393L;

	private SupportTicketService stService;
	private TrackingService trackingService;

	private SupportTicket supportTicket;
	private Department limitDeparement;
	private List<SupportTicket> lSupportTicket = new ArrayList<SupportTicket>();
	private Tracking tracking;
	private String tabledata;
	private String result;
	private int totalrows = 0;

	private WorksheetService worksheet_service;
	private IUser_roleService user_role_service;
	private HttpServletResponse response;
	private ISupervisionService supervision_service;
	private IDict_itemService dict_item_service;
	
	@Resource(name="dict_itemService")
	public void setDict_item_service(IDict_itemService dict_item_service) {
		this.dict_item_service = dict_item_service;
	}

	@Resource(name = "SupervisionServiceImpl")
	public void setSupervision_service(ISupervisionService supervision_service) {
		this.supervision_service = supervision_service;
	}

	@Resource(name = "user_roleService")
	public void setUser_role_service(IUser_roleService user_role_service) {
		this.user_role_service = user_role_service;
	}

	@Resource(name = "WorksheetServiceImpl")
	public void setWorksheet_service(WorksheetService worksheet_service) {
		this.worksheet_service = worksheet_service;
	}

	/**
	 * 导出excel
	 * 
	 * @return
	 * @throws Exception
	 */
	public String export_excel() throws Exception {
		SupportTicket para_st = new SupportTicket();
		List<SupportTicket> support_ticket_list = stService
				.getListSupportTicket(para_st);
		String name = "导出的全部技术支持单";
		// 临时文件名
		String filename = new Date().getTime() + ".xls";
		// 文件地址
		String filepath = "/"+"uploadTemp" + "/"+ filename;
		String filestorepath = this.getRequest().getSession()
				.getServletContext().getRealPath("/")
				+ "/" + "uploadTemp" + "/" + filename;

		
		
		// 表头
		String title[] = { "技术支持单编号", "申请人", "大区/区域", "所属项目名称", "支持类型",
				"技术支持内容", "技术支持负责人", "技术支持部门", "技术支持单状态", "日期", "填写人", "进展情况",
				"日期", "填写人", "督办情况" };
		// 表头列的宽度
		int[] header_width = { 17, 9, 9, 16, 13, 12, 16, 16, 15, 11, 13, 15,
				11, 13, 15 };
		File tempfile = new File(filestorepath);
		WritableWorkbook workbook = Workbook
				.createWorkbook(tempfile);
		WritableSheet sheet = workbook.createSheet(name, 0);
		// 标题显示标签
		Label label = null;
		WritableCellFormat headerFormat = new WritableCellFormat();
		headerFormat.setAlignment(Alignment.CENTRE);
		headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		headerFormat.setFont(new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.BOLD));

		for (int i = 0; i < title.length; i++) {
			label = new Label(i, 0, title[i], headerFormat);
			sheet.setColumnView(i, header_width[i]);
			sheet.addCell(label);
		}

		int y = 1;
		for (int i = 0; i < support_ticket_list.size(); i++) {
			SupportTicket excel_st = support_ticket_list.get(i);
			// 进展
			Tracking track = new Tracking();
			track.setStId(excel_st.getId());
			List<Tracking> trackings = trackingService.getTrackingList(track);
			excel_st.setTrackList(trackings);
			// 督办信息
			Supervision superv = new Supervision();
			superv.setSt_id(excel_st.getId());
			List<Supervision> supervision_list = supervision_service
					.query_supervision(superv);
			excel_st.setSupervision_list(supervision_list);
			//地区
			Dict_item dictitem=new Dict_item();
			dictitem.setDict_code(Constants.ST_REGION_DICT_CODE);
			dictitem.setFact_value(excel_st.getRegion());
			dictitem = dict_item_service.getDict_item(dictitem);
			excel_st.setRegion(dictitem.getDisplay_name());
			//状态
			dictitem=new Dict_item();
			dictitem.setDict_code(Constants.ST_STATUS_DICT_CODE);
			dictitem.setFact_value(excel_st.getStStatus());
			dictitem = dict_item_service.getDict_item(dictitem);
			excel_st.setStStatus(dictitem.getDisplay_name());
			
			label = new Label(0, y, excel_st.getStNo());
			sheet.addCell(label);
			label = new Label(1, y, excel_st.getApplicant().getUsername());
			sheet.addCell(label);
			label = new Label(2, y, excel_st.getRegion());
			sheet.addCell(label);
			label = new Label(3, y, "");
			sheet.addCell(label);
			label = new Label(4, y, "");
			sheet.addCell(label);
			label = new Label(5, y, excel_st.getSupportContent());
			sheet.addCell(label);
			String slName = "";
			for (User sl : excel_st.getLstSupportLeaders()) {
				slName += "," + sl.getUsername();
			}
			slName = slName.length() > 0 ? slName.substring(1) : slName;

			label = new Label(6, y, slName);
			sheet.addCell(label);
			String departName = "";
			for (Department dp : excel_st.getSupportDeptList()) {
				departName += "," + dp.getDepartname();
			}
			departName = departName.length() > 0 ? departName.substring(1)
					: departName;

			label = new Label(7, y, departName);
			sheet.addCell(label);
			label = new Label(8, y, excel_st.getStStatus());
			sheet.addCell(label);
			int k = y;
			int q = y;
			for (int j = 0; j < excel_st.getTrackList().size(); j++) {
				k = y + j;
				Tracking tracking = excel_st.getTrackList().get(j);
				DateFormat df = new DateFormat("yyyy-MM-dd");
				DateTime dt = new DateTime(9, k, tracking.getTrackingDate(),
						new WritableCellFormat(df));
				// label = new Label(9, k,
				// new SimpleDateFormat("yyyy-MM-dd").format(tracking
				// .getTrackingDate()));
				sheet.addCell(dt);
				label = new Label(10, k, tracking.getProcessor().getUsername());
				sheet.addCell(label);
				label = new Label(11, k, tracking.getNewProcess());
				sheet.addCell(label);

			}

			for (int j = 0; j < excel_st.getSupervision_list().size(); j++) {
				q = y + j;
				Supervision supervision = excel_st.getSupervision_list().get(j);
				DateFormat df = new DateFormat("yyyy-MM-dd");
				DateTime dt = new DateTime(12, q,
						supervision.getSupervision_date(),
						new WritableCellFormat(df));
				// label = new Label(12, k,
				// new SimpleDateFormat("yyyy-MM-dd").format());
				sheet.addCell(dt);
				label = new Label(13, q, supervision.getSupervision_person()
						.getUsername());
				sheet.addCell(label);
				label = new Label(14, q,
						supervision.getSupervision_suggestion());
				sheet.addCell(label);
			}
			y = q >= k ? q + 1 : k + 1;
		}
		workbook.write();
		workbook.close();
		this.getRequest().setAttribute("filefullname", filestorepath);
		this.getRequest().setAttribute("need_remove", true);
		this.getRequest().setAttribute("filename", name+".xls");
		this.getRequest().getRequestDispatcher("/business/techSupport/common/attach_download.jsp").forward(getRequest(), response);
		
		return null;
	}

	/**
	 * 支持单查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String querylist() throws Exception {
		SupportTicket setsupportTicket = new SupportTicket();
		supportTicket = (SupportTicket) this.setClass(setsupportTicket, null);
		Tracking settrack = new Tracking();
		tracking = (Tracking) this.setClass(settrack, null);
		Department setdept = new Department();
		limitDeparement = (Department) this.setClass(setdept, null);

		Map<String, Object> params = new HashMap<String, Object>();
		if (supportTicket.getApplicantId() != null
				&& supportTicket.getApplicantId() > 0) {
			User user = new User();
			user.setUserid(supportTicket.getApplicantId());
			supportTicket.setApplicant(user);

		}
		if (supportTicket.getSupportLeaderId() != null
				&& supportTicket.getSupportLeaderId() > 0) {
			User user = new User();
			user.setUserid(supportTicket.getSupportLeaderId());
			supportTicket.getLstSupportLeaders().add(user);
		}

		params.put("applicant", supportTicket.getApplicant());
		params.put("lstSupportLeaders", supportTicket.getLstSupportLeaders());
		params.put("stStatus", supportTicket.getStStatus());
		params.put("region", supportTicket.getRegion());
		params.put("id", supportTicket.getId());
		params.put("type", tracking.getType());
		params.put("trackDateFrom", tracking.getTrackingDateFrom());
		params.put("trackDateTo", tracking.getTrackingDateTo());
		if (limitDeparement.getDepartid() != null) {
			// 单位筛选
			params.put("limitUserDeparement", 1);
			params.put("limitDeparement", limitDeparement.getDepartid());
		}

		// ++ 最后更改时间天数
		params.put("last_update_day", Constants.LAST_UPDATE_DAY);
		params.put("use_last_update_day", supportTicket.getUseLastUpdateDate());
		// -- 最后更改时间天数

		// ++ 意见回复人
		params.put("tracking_person", tracking.getProcessorId());
		// -- 意见回复人
		// ++ 默认用户管辖范围
		User current_user = (User) this.getRequest().getSession()
				.getAttribute(com.aisino2.sysadmin.Constants.userKey);
		Map map = new HashMap();
		map.put("userid", current_user.getUserid());
		map.put("departcode", current_user.getDepartcode());
		List region_list = worksheet_service.get_region_with_userrole(map);
		params.put("user_region_list", region_list);
		// -- 默认用户管辖范围
		// 设置TRACKING关联标识
		if ((params.get("type") != null && !params.get("type").equals("")) 
				|| (params.get("tracking_person") != null && !params.get("tracking_person").equals("")))
			params.put("join_tracking", true);
		Page page = stService.getListSupportTicketForPage(params,
				this.pagesize, this.pagerow, this.sort, this.dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();

		if (supportTicket.getTag().equals("dxts"))
			setTabledataDxts(page.getData());
		else
			setTabledata(page.getData());
		this.result = "success";
		return SUCCESS;
	}

	/**
	 * 支持单详情
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		try {
			if (supportTicket == null) {
				SupportTicket setSupportTicket = new SupportTicket();
				supportTicket = (SupportTicket) this.setClass(setSupportTicket,
						null);
			}

		} catch (Exception e) {

		}

		supportTicket = stService.getSupportTicket(supportTicket);
		if (supportTicket != null) {
			lSupportTicket.clear();
			lSupportTicket.add(supportTicket);
			Tracking tracking = new Tracking();
			tracking.setStId(supportTicket.getId());
			List<Tracking> lstTracking = trackingService
					.getTrackingListForPage(1, 999, tracking, "99", "desc")
					.getData();
			supportTicket.setTrackList(lstTracking);
		}
		this.result = "success";
		return SUCCESS;
	}

	/**
	 * 综合查询TABLEDATA设置
	 * 
	 * @param ldata
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setTabledata(List ldata) throws Exception {
		List lPro = new ArrayList();
		lPro.add("id");
		lPro.add("stNo");
		lPro.add("regionName");
		lPro.add("applicantName");
		lPro.add("supportLeaderName");
		lPro.add("supportDeptName");
		lPro.add("stStatusName");

		List lCol = new ArrayList();
		List lDetail = new ArrayList();
		lDetail.add("setDetail");
		lDetail.add("详情");
		lCol.add(lDetail);

		// ++ 督办角色的操作
		User current_user = (User) this.getRequest().getSession()
				.getAttribute(com.aisino2.sysadmin.Constants.userKey);
		User_role ur = new User_role();
		ur.setUserid(current_user.getUserid());
		List<User_role> user_role_list = this.user_role_service
				.getUser_roleListByUserid(ur);
		for (User_role user_role : user_role_list) {

			if (user_role.getRolename().equals(
					Constants.ST_ROLE_NAME_SUPERVISION)) {
				List supervision_list = new ArrayList();
				supervision_list.add("set_supervision");
				supervision_list.add("督办");
				lCol.add(supervision_list);

				break;
			}
		}

		// -- 督办角色的操作
		for (SupportTicket st : (List<SupportTicket>) ldata) {
			st.setStStatusName(ItemChange.codeChange(
					Constants.ST_STATUS_DICT_CODE, st.getStStatus()));
			// @fixed 技术负责人变成多个指派
			String supportLeaderNames = "";
			for (User sl : st.getLstSupportLeaders())
				supportLeaderNames += "," + sl.getUsername();
			supportLeaderNames = supportLeaderNames.length() > 0 ? supportLeaderNames
					.substring(1) : supportLeaderNames;
			st.setSupportLeaderName(supportLeaderNames);

			String deptNames = "";
			for (Department dept : st.getSupportDeptList())
				deptNames += "," + dept.getDepartname();
			deptNames = deptNames.length() > 0 ? deptNames.substring(1)
					: deptNames;
			st.setSupportDeptName(deptNames);
			st.setRegionName(ItemChange.codeChange(
					Constants.ST_REGION_DICT_CODE, st.getRegion()));
			// set applicantName value
			String applicantNames = "";
			applicantNames = st.getApplicant() != null ? st.getApplicant()
					.getUsername() : applicantNames;
			st.setApplicantName(applicantNames);
		}
		SupportTicket supportTicket = new SupportTicket();
		this.setData(supportTicket, ldata, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	/**
	 * 短信提示TABLEDATA设置
	 * 
	 * @param ldata
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setTabledataDxts(List ldata) throws Exception {
		List lPro = new ArrayList();
		lPro.add("id");
		lPro.add("checkbox");
		lPro.add("stNo");
		lPro.add("regionName");
		lPro.add("applicantName");
		lPro.add("supportLeaderName");
		lPro.add("supportDeptName");
		lPro.add("supportContent");
		lPro.add("trackingProcess");
		lPro.add("lastUpdateDate");
		// List lCol = new ArrayList();

		for (int i = 0; i < ldata.size(); i++) {
			SupportTicket st = (SupportTicket) ldata.get(i);
			Tracking t = new Tracking();
			t.setStId(st.getId());
			st.setTrackList(trackingService.getTrackingList(t));
			if(!st.getTrackList().isEmpty())
				st.setTrackingProcess(st.getTrackList()
					.get(0).getNewProcess());
			st.setCheckbox("<input type=\"checkbox\" name=\"lSt[" + i
					+ "].id\" value=\"" + st.getId() + "\">");

			// @fixed 技术负责人变成多个指派
			String supportLeaderNames = "";
			for (User sl : st.getLstSupportLeaders())
				supportLeaderNames += "," + sl.getUsername();
			supportLeaderNames = supportLeaderNames.length() > 0 ? supportLeaderNames
					.substring(1) : supportLeaderNames;
			st.setSupportLeaderName(supportLeaderNames);
			
			String deptNames = "";
			for (Department dept : st.getSupportDeptList())
				deptNames += "," + dept.getDepartname();
			deptNames = deptNames.length() > 0?deptNames.substring(1):deptNames;
			st.setSupportDeptName(deptNames);
			st.setRegionName(ItemChange.codeChange(
					Constants.ST_REGION_DICT_CODE, st.getRegion()));

			String applicantNames = "";
			applicantNames = st.getApplicant() != null ? st.getApplicant()
					.getUsername() : applicantNames;
			st.setApplicantName(applicantNames);
		}
		SupportTicket supportTicket = new SupportTicket();
		this.setData(supportTicket, ldata, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	@Resource(name = "SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	public SupportTicket getSupportTicket() {
		return supportTicket;
	}

	public void setSupportTicket(SupportTicket supportTicket) {
		this.supportTicket = supportTicket;
	}

	public List<SupportTicket> getlSupportTicket() {
		return lSupportTicket;
	}

	public void setlSupportTicket(List<SupportTicket> lSupportTicket) {
		this.lSupportTicket = lSupportTicket;
	}

	public String getTabledata() {
		return tabledata;
	}

	public void setTabledata(String tabledata) {
		this.tabledata = tabledata;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	@Resource(name = "TrackingServiceImpl")
	public void setTrackingService(TrackingService trackingService) {
		this.trackingService = trackingService;
	}

	public Tracking getTracking() {
		return tracking;
	}

	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}

	public Department getLimitDeparement() {
		return limitDeparement;
	}

	public void setLimitDeparement(Department limitDeparement) {
		this.limitDeparement = limitDeparement;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

}
