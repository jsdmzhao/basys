package com.aisino2.techsupport.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.techsupport.domain.Supervision;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;

public class ExcelExportTest {
	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException, RowsExceededException, WriteException {
		// 临时文件名
		String filename = new Date().getTime() + ".xls";
		// 文件地址
		String filestorepath = "e:/" + filename;
		// 表头
		String title[] = { "技术支持单编号", "申请人", "大区/区域", "所属项目名称", "支持类型",
				"技术支持内容", "技术支持负责人", "技术支持部门", "技术支持单状态", "日期", "填写人", "进展情况",
				"日期", "填写人", "督办情况" };
//		表头列的宽度
		int [] header_width = {17,9,9,16,13,12,16,16,15,11,13,15,11,13,15};
		WritableWorkbook workbook = Workbook
				.createWorkbook(new FileOutputStream(filestorepath));
		WritableSheet sheet = workbook.createSheet("导出的技术支持单", 0);
		// 标题显示标签
		Label label = null;
		WritableCellFormat headerFormat = new WritableCellFormat();
		headerFormat.setAlignment(Alignment.CENTRE);
		headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		headerFormat.setFont(new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD));
		
		for (int i = 0; i < title.length; i++) {
			
			label = new Label(i, 0, title[i],headerFormat);
			sheet.setColumnView(i, header_width[i]);
			sheet.addCell(label);
			
		}
		SupportTicket test_st = new SupportTicket();
		// 填报人
		User user = new User();
		user.setUserid(1);
		user.setUsername("徐毅");
		test_st.setApplicant(user);
		test_st.setStNo("重庆-20120228-1");
		test_st.setRegion("重庆");
		test_st.setSupportContent("测试内容");
		test_st.setId(1);
		// 公司审批
		Department d = new Department();
		d.setDepartid(1);
		d.setDepartname("技术部");
		List<Department> departments = new ArrayList();
		departments.add(d);
		d = new Department();
		d.setDepartid(2);
		d.setDepartname("开发部");
		departments.add(d);
		test_st.setSupportDeptList(departments);
		Tracking tracking = new Tracking();
		tracking.setStId(test_st.getId());
		tracking.setNewProcess("总工同意");
		tracking.setTrackingDate(new Date());
		user = new User();
		user.setUserid(2);
		user.setUsername("总工");
		tracking.setProcessor(user);
		List<Tracking> trackings = new ArrayList<Tracking>();
		trackings.add(tracking);
		// 部门审批
		List<User> sls = new ArrayList<User>();
		tracking = new Tracking();
		tracking.setStId(test_st.getId());
		tracking.setNewProcess("技术部同意");
		tracking.setTrackingDate(new Date());
		user = new User();
		user.setUserid(3);
		user.setUsername("技术部门审批人");
		sls.add(user);
		tracking.setProcessor(user);
		trackings.add(tracking);
		tracking = new Tracking();
		tracking.setStId(test_st.getId());
		tracking.setNewProcess("产品部同意");
		tracking.setTrackingDate(new Date());
		user = new User();
		user.setUserid(4);
		user.setUsername("产品部审批人");
		sls.add(user);
		tracking.setProcessor(user);
		trackings.add(tracking);

		test_st.setLstSupportLeaders(sls);
		// 追踪批复
		tracking = new Tracking();
		tracking.setStId(test_st.getId());
		tracking.setNewProcess("追踪批复完成");
		tracking.setTrackingDate(new Date());
		user = new User();
		user.setUserid(5);
		user.setUsername("批复人");
		tracking.setProcessor(user);
		trackings.add(tracking);
		// 反馈
		tracking = new Tracking();
		tracking.setStId(test_st.getId());
		tracking.setNewProcess("反馈完成");
		tracking.setTrackingDate(new Date());
		user = new User();
		user.setUserid(6);
		user.setUsername("反馈人");
		tracking.setProcessor(user);
		trackings.add(tracking);
		// 归档
		tracking = new Tracking();
		tracking.setStId(test_st.getId());
		tracking.setNewProcess("归档完成");
		tracking.setTrackingDate(new Date());
		user = new User();
		user.setUserid(7);
		user.setUsername("归档人");
		tracking.setProcessor(user);
		trackings.add(tracking);

		test_st.setTrackList(trackings);
		// 督办
		String[][] supervision_infos = { { "李红", "李红意见" }, { "张三", "张三意见" },
				{ "谢家伟", "谢家伟意见" } };
		Supervision supervision = null;
		List<Supervision> supervisions = new ArrayList<Supervision>();
		for (int i = 0; i < supervision_infos.length; i++) {
			user = new User();
			user.setUsername(supervision_infos[i][0]);
			supervision = new Supervision();
			supervision.setSt_id(test_st.getId());
			supervision.setSupervision_person(user);
			supervision.setSupervision_suggestion(supervision_infos[i][1]);
			supervision.setSupervision_date(new Date());

			supervisions.add(supervision);
		}
		test_st.setSupervision_list(supervisions);
		test_st.setStStatus("已完成");
		label = new Label(0, 1, test_st.getStNo());
		sheet.addCell(label);
		label = new Label(1, 1, test_st.getApplicant().getUsername());
		sheet.addCell(label);
		label = new Label(2, 1, test_st.getRegion());
		sheet.addCell(label);
		label = new Label(3, 1, "");
		sheet.addCell(label);
		label = new Label(4, 1, "");
		sheet.addCell(label);
		label = new Label(5, 1, test_st.getSupportContent());
		sheet.addCell(label);
		String slName = "";
		for (User sl : test_st.getLstSupportLeaders()) {
			slName += "," + sl.getUsername();
		}
		slName = slName.substring(1);

		label = new Label(6, 1, slName);
		sheet.addCell(label);
		String departName = "";
		for (Department dp : test_st.getSupportDeptList()) {
			departName += "," + dp.getDepartname();
		}
		departName = departName.substring(1);
		label = new Label(7, 1, departName);
		sheet.addCell(label);
		label = new Label(8, 1, test_st.getStStatus());
		sheet.addCell(label);
		int i = 1;
		int k = 0;
		for (int j = 0; j < trackings.size(); j++) {
			k = i + j;
			tracking = trackings.get(j);
			label = new Label(10, k, tracking.getProcessor().getUsername());
			sheet.addCell(label);
			label = new Label(11, k, tracking.getNewProcess());
			sheet.addCell(label);
			label = new Label(9, k,
					new SimpleDateFormat("yyyy-MM-dd").format(tracking
							.getTrackingDate()));
			sheet.addCell(label);
		}
		
		for (int j=0;j<supervisions.size();j++){
			k = i + j;
			supervision = supervisions.get(j);
			label = new Label(13, k, supervision.getSupervision_person().getUsername());
			sheet.addCell(label);
			label = new Label(14, k, supervision.getSupervision_suggestion());
			sheet.addCell(label);
			label = new Label(12, k,
					new SimpleDateFormat("yyyy-MM-dd").format(supervision.getSupervision_date()));
			sheet.addCell(label);
		}
		
		workbook.write();
		workbook.close();
	}
}
