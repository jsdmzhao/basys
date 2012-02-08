package com.aisino2.techsupport.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.techsupport.domain.Supervision;
import com.aisino2.techsupport.service.ISupervisionService;

@Component("SupervisionAction")
@Scope("prototype")
public class SupervisionAction extends PageAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8487751081915805086L;

	private ISupervisionService supervision_service;
	private Supervision supervision;
	private String tabledata;
	private String result;
	private int totalrows;
	
	public int getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}
	@Resource(name="SupervisionServiceImpl")
	public void setSupervision_service(ISupervisionService supervision_service) {
		this.supervision_service = supervision_service;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Supervision getSupervision() {
		return supervision;
	}
	public void setSupervision(Supervision supervision) {
		this.supervision = supervision;
	}
	public String getTabledata() {
		return tabledata;
	}
	public void setTabledata(String tabledata) {
		this.tabledata = tabledata;
	}
	/**
	 *  保存
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		if(supervision == null )
			throw new RuntimeException("需要保存的 督办进展为空");
		supervision_service.insert_supervision(supervision);
		return SUCCESS;
	}
	// ++ 分页查询
	/**
	 * 查询列表分页
	 * @return
	 * @throws Exception
	 */
	public String querylist() throws Exception{
		supervision = new Supervision();
		supervision = (Supervision) this.setClass(supervision, null);
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("st_id", supervision.getSt_id());
		
		Page page = this.supervision_service.query_supervision_for_page(params, this.pagesize, this.pagerow, dir, sort);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		setTabledata(page.getData());
		this.result = "success";
		return SUCCESS;
	}
	public void setTabledata(List data_list) throws Exception{
		List lPro = new ArrayList();
		lPro.add("id");
		lPro.add("supervision_person_name");
		lPro.add("supervision_suggestion");
		lPro.add("supervision_date");

		List lCol = new ArrayList();
		List lDetail = new ArrayList();
		lDetail.add("setDetail");
		lDetail.add("详情");
		lCol.add(lDetail);

		//设置督办人列表信息
		for(Supervision sv : (List<Supervision>)data_list){
			
			sv.setSupervision_person_id(sv.getSupervision_person().getUserid());
			sv.setSupervision_person_name(sv.getSupervision_person().getUsername());
		}
		
		Supervision supervision = new Supervision();
		this.setData(supervision, data_list, lPro, null);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	// -- 分页查询
	// ++ 单一查询
	/**
	 * 单一查询
	 */
	public String query() throws Exception{
		supervision = new Supervision();
		supervision = (Supervision) this.setClass(supervision, null);
		
		if(supervision.getId()==null)
			throw new RuntimeException("督办进展ID为空");
		supervision = supervision_service.get_supervision(supervision);
		
		return SUCCESS;
	}
	
	// -- 单一查询
}
