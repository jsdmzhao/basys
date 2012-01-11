package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Rylbtj;
import com.aisino2.publicsystem.service.IRylbtjService;
import com.aisino2.sysadmin.domain.Globalpar;

public class RylbtjAction extends PageAction{
	private IRylbtjService rylbtjService;
	private List lRylbtj=new ArrayList();
	private Rylbtj rylbtj=new Rylbtj();
	private String tabledata="";
	private int totalrows=0;
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

	public Rylbtj getRylbtj() {
		return rylbtj;
	}
	
	public List getLRylbtj() {
		return lRylbtj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setRylbtjService(IRylbtjService rylbtjService) {
		this.rylbtjService = rylbtjService;
	}
	
	public void setTabledata(List lData,Rylbtj rylbtj) throws Exception{
		List lPro=new ArrayList();
		if("1".equals(rylbtj.getCsbz())){
			lPro.add("qybm");
			lPro.add("qymc");
		} else if("1".equals(rylbtj.getGxdwbz())){
			lPro.add("gxdwdm");
			lPro.add("gxdwmc");
		} else if("1".equals(rylbtj.getFxjbz())){
			lPro.add("fxjdm");
			lPro.add("fxjmc");
		} else if("1".equals(rylbtj.getDsjgbz())){
			lPro.add("dsjgdm");
			lPro.add("dsjgmc");
		} else {
			lPro.add("rybtjid");
		}
		lPro.add("hjT");
		lPro.add("glryT");
		lPro.add("fwryT");
		lPro.add("baryT");
		lPro.add("aqjcryT");
		lPro.add("qtT");
		lPro.add("hj");
		lPro.add("glry");
		lPro.add("fwry");
		lPro.add("bary");
		lPro.add("aqjcry");
		lPro.add("qt");
    	
    	Rylbtj getRylbtj=new Rylbtj();
    	
        this.setData(getRylbtj,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			int hjT = 0;
			int glryT = 0;
			int fwryT = 0;
			int baryT = 0;
			int aqjcryT = 0;
			int qtT = 0;
			int hj = 0;
			int glry = 0;
			int fwry = 0;
			int bary = 0;
			int aqjcry = 0;
			int qt = 0;
			Rylbtj sumRylbtj = new Rylbtj();
			Rylbtj setRylbtj = new Rylbtj();
			setRylbtj = (Rylbtj) this.setClass(setRylbtj, null);

			Map map = new HashMap();
			map.put("dsjgdm", setRylbtj.getDsjgdm());
			map.put("fxjdm", setRylbtj.getFxjdm());
			map.put("gxdwdm", setRylbtj.getGxdwdm());
			map.put("qybm", setRylbtj.getCsbm());
			map.put("dsjgbz", setRylbtj.getDsjgbz());
			map.put("fxjbz", setRylbtj.getFxjbz());
			map.put("gxdwbz", setRylbtj.getGxdwbz());
			map.put("qybz", setRylbtj.getCsbz());
			map.put("qsrq", setRylbtj.getQsrq());
			map.put("jzrq", setRylbtj.getJzrq());
			map.put("hylbdm", setRylbtj.getHylbdm());
			
			Page page = rylbtjService.getListForPage(map, pagesize, pagerow,
					sort, dir);
			totalpage = page.getTotalPages();
			totalrows = page.getTotalRows();
			lRylbtj = page.getData();
			for(Iterator iter = lRylbtj.iterator(); iter.hasNext();){
				Rylbtj oneRylbtj = (Rylbtj)iter.next();
				hjT += oneRylbtj.getHjT().intValue();
				glryT += oneRylbtj.getGlryT().intValue();
				fwryT += oneRylbtj.getFwryT().intValue();
				baryT += oneRylbtj.getBaryT().intValue();
				aqjcryT += oneRylbtj.getAqjcryT().intValue();
				qtT += oneRylbtj.getQtT().intValue();
				hj += oneRylbtj.getHj().intValue();
				glry += oneRylbtj.getGlry().intValue();
				fwry += oneRylbtj.getFwry().intValue();
				bary += oneRylbtj.getBary().intValue();
				aqjcry += oneRylbtj.getAqjcry().intValue();
				qt += oneRylbtj.getQt().intValue();
			}
			sumRylbtj.setHjT(hjT);
			sumRylbtj.setGlryT(glryT);
			sumRylbtj.setFwryT(fwryT);
			sumRylbtj.setBaryT(baryT);
			sumRylbtj.setAqjcryT(aqjcryT);
			sumRylbtj.setQtT(qtT);
			sumRylbtj.setHj(hj);
			sumRylbtj.setGlry(glry);
			sumRylbtj.setFwry(fwry);
			sumRylbtj.setBary(bary);
			sumRylbtj.setAqjcry(aqjcry);
			sumRylbtj.setQt(qt);
			sumRylbtj.setDsjgmc("总计");
			if("1".equals(setRylbtj.getDsjgbz())){
			    lRylbtj.add(sumRylbtj);
			}
			//setTabledata(lRylbtj, setRylbtj);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
    }
	
	/**
	 * 人员统计 中的 管理人员
	 * @return
	 * @throws Exception
	 */
	public String querylistGlry() throws Exception{
		try {
			Rylbtj setRylbtj=new Rylbtj();
			setRylbtj=(Rylbtj)this.setClass(setRylbtj, null);
			
			Map map = new HashMap();
			if("1".equals(setRylbtj.getDsjgbz())){
				map.put("dsjgdm", setRylbtj.getDsjgdm());
			}
			if("1".equals(setRylbtj.getFxjbz())){
				map.put("fxjdm", setRylbtj.getFxjdm());
			}
			if("1".equals(setRylbtj.getGxdwbz())){
				map.put("gxdwdm", setRylbtj.getGxdwdm());
			}
			if("1".equals(setRylbtj.getCsbz())){
				map.put("qybm", setRylbtj.getCsbm());
			}
			
			
			map.put("dsjgbz", setRylbtj.getDsjgbz());
			map.put("fxjbz", setRylbtj.getFxjbz());
			map.put("gxdwbz", setRylbtj.getGxdwbz());
			map.put("qybz", setRylbtj.getCsbz());
			Page page = rylbtjService.getListForPage(map, 1, 10,null,null);
			lRylbtj = page.getData();
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	/**
	 * 人员统计 中的 服务人员
	 * @return
	 * @throws Exception
	 */
	public String querylistFwry() throws Exception{
		try {
			Rylbtj setRylbtj=new Rylbtj();
			setRylbtj=(Rylbtj)this.setClass(setRylbtj, null);
			
			Map map = new HashMap();
			if("1".equals(setRylbtj.getDsjgbz())){
				map.put("dsjgdm", setRylbtj.getDsjgdm());
			}
			if("1".equals(setRylbtj.getFxjbz())){
				map.put("fxjdm", setRylbtj.getFxjdm());
			}
			if("1".equals(setRylbtj.getGxdwbz())){
				map.put("gxdwdm", setRylbtj.getGxdwdm());
			}
			if("1".equals(setRylbtj.getCsbz())){
				map.put("qybm", setRylbtj.getCsbm());
			}
			
			
			map.put("dsjgbz", setRylbtj.getDsjgbz());
			map.put("fxjbz", setRylbtj.getFxjbz());
			map.put("gxdwbz", setRylbtj.getGxdwbz());
			map.put("qybz", setRylbtj.getCsbz());
			Page page = rylbtjService.getListForPage(map, 1, 10,null,null);
			lRylbtj = page.getData();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String querylistExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Rylbtj setRylbtj=new Rylbtj();
			setRylbtj=(Rylbtj)this.setClass(setRylbtj, null);
			
			Map map = new HashMap();
			map.put("dsjgdm", setRylbtj.getDsjgdm());
			map.put("fxjdm", setRylbtj.getFxjdm());
			map.put("gxdwdm", setRylbtj.getGxdwdm());
			map.put("qybm", setRylbtj.getCsbm());
			map.put("dsjgbz", setRylbtj.getDsjgbz());
			map.put("fxjbz", setRylbtj.getFxjbz());
			map.put("gxdwbz", setRylbtj.getGxdwbz());
			map.put("qybz", setRylbtj.getCsbz());
			if("0".equals(setRylbtj.getDsjgbz())&&sort!=null){
				sort = String.valueOf(Integer.parseInt(sort)+1);
			}
			Page page = rylbtjService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("rylbtjList", page.getData());
		}catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	public void querylistExcel() throws Exception{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			Rylbtj setRylbtj=new Rylbtj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			StringBuffer sb = new StringBuffer();
			sb.append("<tr>");
			sb.append(tabletitle);
			sb.append("<th name='l_hjT' datatype='Integer' sumflag='0'>人员总数(至截止日期)</th>");
			sb.append("<th name='l_glryT' datatype='Integer' sumflag='0'>管理人员(至截止日期)</th>");
			sb.append("<th name='l_fwryT' datatype='Integer' sumflag='0'>服务人员(至截止日期)</th>");
			sb.append("<th name='l_baryT' datatype='Integer' sumflag='0'>保安人员(至截止日期)</th>");
			sb.append("<th name='l_aqjcryT' datatype='Integer' sumflag='0'>安检人员(至截止日期)</th>");
			sb.append("<th name='l_qtT' datatype='Integer' sumflag='0'>其他人员(周期内新增)</th>");
			sb.append("<th name='l_hj' datatype='Integer' sumflag='0'>人员总数(周期内新增)</th>");
			sb.append("<th name='l_glry' datatype='Integer' sumflag='0'>管理人员(周期内新增)</th>");
			sb.append("<th name='l_fwry' datatype='Integer' sumflag='0'>服务人员(周期内新增)</th>");
			sb.append("<th name='l_bary' datatype='Integer' sumflag='0'>保安人员(周期内新增)</th>");
			sb.append("<th name='l_aqjcry' datatype='Integer' sumflag='0'>安检人员(周期内新增)</th>");
			sb.append("<th name='l_qt' datatype='Integer' sumflag='0'>其他人员(周期内新增)</th>");
			sb.append("</tr>");
			
			List lColumn = this.getExcelColumn(sb.toString());
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("rylbtjList"));
			lResult.add(setRylbtj);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	public String query() throws Exception{
		try {
			Rylbtj setRylbtj=new Rylbtj();
			rylbtj=(Rylbtj)this.setClass(setRylbtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        rylbtj=rylbtjService.getRylbtj(rylbtj);
        lRylbtj.clear();
        lRylbtj.add(rylbtj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Rylbtj setRylbtj=new Rylbtj();
			rylbtj=(Rylbtj)this.setClass(setRylbtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        rylbtj=rylbtjService.insertRylbtj(rylbtj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Rylbtj setRylbtj=new Rylbtj();
			rylbtj=(Rylbtj)this.setClass(setRylbtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        rylbtjService.updateRylbtj(rylbtj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Rylbtj setRylbtj=new Rylbtj();
			rylbtj=(Rylbtj)this.setClass(setRylbtj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        rylbtjService.deleteRylbtj(rylbtj);
        this.result="success";
        return "success";
    }
}