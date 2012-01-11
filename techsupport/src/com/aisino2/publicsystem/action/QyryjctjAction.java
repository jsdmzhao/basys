package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyryjctj;
import com.aisino2.publicsystem.service.IQyryjctjService;
import com.aisino2.sysadmin.domain.Globalpar;

public class QyryjctjAction extends PageAction{
	private IQyryjctjService qyryjctjService;
	private List lQyryjctj=new ArrayList();
	private Qyryjctj qyryjctj=new Qyryjctj();
	private String tabledata="";
	private int totalrows=0;
	private String result="success";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Qyryjctj getQyryjctj() {
		return qyryjctj;
	}
	
	public List getLQyryjctj() {
		return lQyryjctj;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyryjctjService(IQyryjctjService qyryjctjService) {
		this.qyryjctjService = qyryjctjService;
	}
	
	public void setTabledata(List lData,Qyryjctj setQyryjctj) throws Exception{
		List lPro=new ArrayList();
		lPro.add("qyryjctjid");
		if("1".equals(setQyryjctj.getGxdwbz())){
			lPro.add("gxdwmc");
		} else if("1".equals(setQyryjctj.getFxjbz())){
			lPro.add("fxjmc");
		} else {
			lPro.add("dsjgmc");
		}
		lPro.add("jzrqJczs"); //1 截止日期 奖惩数
		lPro.add("jzrqCfzs"); //2 截止日期 处罚数
		lPro.add("jzrqJlzs"); //3 截止日期 奖励数
		lPro.add("zqnJczs"); //4 周期内 奖惩数
		lPro.add("zqnCfzs"); //5 周期内 处罚数
		lPro.add("jg"); //6 警告
		lPro.add("fk"); //7 罚款
		lPro.add("jl"); //8 拘留
		lPro.add("jlbfk"); //9 拘留并罚款
		lPro.add("zjxszr"); //10 追究刑事责任
		lPro.add("xqcjhqzcj"); //11 限期出境或驱逐出境
		lPro.add("qtfklx"); //12 其他处罚类型
		lPro.add("zqnJlzs"); //13 周期内 奖励数
		lPro.add("tbbycs"); //14 通报表扬次数
		lPro.add("wzjlcs"); //15 物质奖励次数
		lPro.add("qtjlcs"); //16 其他奖励次数
		
    	List lCol=new ArrayList();
    	Qyryjctj getQyryjctj = new Qyryjctj();
        this.setData(getQyryjctj,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			int jzrqJczs = 0; //1 截止日期 奖惩数
			int jzrqCfzs = 0; //2 截止日期 处罚数
			int jzrqJlzs = 0; //3 截止日期 奖励数
			int zqnJczs = 0; //4 周期内 奖惩数
			int zqnCfzs = 0; //5 周期内 处罚数
			int jg = 0; //6 警告
			int fk = 0; //7 罚款
			int jl = 0; //8 拘留
			int jlbfk = 0; //9 拘留并罚款
			int zjxszr = 0; //10 追究刑事责任
			int xqcjhqzcj = 0; //11 限期出境或驱逐出境
			int qtfklx = 0; //12 其他处罚类型
			int zqnJlzs = 0; //13 周期内 奖励数
			int tbbycs = 0; //14 通报表扬次数
			int wzjlcs = 0; //15 物质奖励次数
			int qtjlcs = 0; //16 其他奖励次数
			Qyryjctj sumQyryjctj = new Qyryjctj();
			Qyryjctj setQyryjctj = new Qyryjctj();
			setQyryjctj = (Qyryjctj)this.setClass(setQyryjctj, null);
			Map map = new HashMap();
			map.put("dsjgdm", setQyryjctj.getDsjgdm());
			map.put("fxjdm", setQyryjctj.getFxjdm());
			map.put("gxdwdm", setQyryjctj.getGxdwdm());
			map.put("dsjgbz", setQyryjctj.getDsjgbz());
			map.put("fxjbz", setQyryjctj.getFxjbz());
			map.put("gxdwbz", setQyryjctj.getGxdwbz());
			map.put("hylbdm", setQyryjctj.getHylbdm());
			map.put("qsrq", setQyryjctj.getQsrq());
			map.put("jzrq", setQyryjctj.getJzrq());
			
	        Page page = qyryjctjService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lQyryjctj=page.getData();
	        for(java.util.Iterator iter = lQyryjctj.iterator(); iter.hasNext();){
	        	Qyryjctj oneQyryjctj = (Qyryjctj)iter.next();
	        	jzrqJczs += oneQyryjctj.getJzrqJczs().intValue();
        		jzrqCfzs += oneQyryjctj.getJzrqCfzs().intValue();
	        	jzrqJlzs += oneQyryjctj.getJzrqJlzs().intValue();
	        	zqnJczs += oneQyryjctj.getZqnJczs().intValue();
	        	zqnCfzs += oneQyryjctj.getZqnCfzs().intValue();
	        	jg += oneQyryjctj.getJg().intValue(); 
	        	fk += oneQyryjctj.getFk().intValue(); 
	        	jl += oneQyryjctj.getJl().intValue(); 
	        	jlbfk += oneQyryjctj.getJlbfk().intValue(); 
	        	zjxszr += oneQyryjctj.getZjxszr().intValue();
	        	xqcjhqzcj += oneQyryjctj.getXqcjhqzcj().intValue();
	        	qtfklx += oneQyryjctj.getQtfklx().intValue();
	        	zqnJlzs += oneQyryjctj.getZqnJlzs().intValue();
	        	tbbycs += oneQyryjctj.getTbbycs().intValue();
	        	wzjlcs += oneQyryjctj.getWzjlcs().intValue();
	        	qtjlcs += oneQyryjctj.getQtjlcs().intValue();
	        }
	        sumQyryjctj.setJzrqJczs(jzrqJczs);
	        sumQyryjctj.setJzrqCfzs(jzrqCfzs);
	        sumQyryjctj.setJzrqJlzs(jzrqJlzs);
	        sumQyryjctj.setZqnJczs(zqnJczs);
	        sumQyryjctj.setZqnCfzs(zqnCfzs);
	        sumQyryjctj.setJg(jg);
	        sumQyryjctj.setFk(fk);
	        sumQyryjctj.setJl(jl);
	        sumQyryjctj.setJlbfk(jlbfk);
	        sumQyryjctj.setZjxszr(zjxszr);
	        sumQyryjctj.setXqcjhqzcj(xqcjhqzcj);
	        sumQyryjctj.setQtfklx(qtfklx);
	        sumQyryjctj.setZqnJlzs(zqnJlzs);
	        sumQyryjctj.setTbbycs(tbbycs);
	        sumQyryjctj.setWzjlcs(wzjlcs);
	        sumQyryjctj.setQtjlcs(qtjlcs);
	        sumQyryjctj.setDsjgmc("总计");
	        if("1".equals(setQyryjctj.getDsjgbz())){
	            lQyryjctj.add(sumQyryjctj);
	        }
	        //setTabledata(page.getData(),setQyryjctj); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	public String querylistExcelTemp(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Globalpar glo = this.getCacheGlobalpar("exportmaxrows");
			String maxRows = glo.getGlobalparvalue();
			
			Qyryjctj setQyryjctj = new Qyryjctj();
			setQyryjctj = (Qyryjctj)this.setClass(setQyryjctj, null);
			Map map = new HashMap();
			map.put("dsjgdm", setQyryjctj.getDsjgdm());
			map.put("fxjdm", setQyryjctj.getFxjdm());
			map.put("gxdwdm", setQyryjctj.getGxdwdm());
			map.put("dsjgbz", setQyryjctj.getDsjgbz());
			map.put("fxjbz", setQyryjctj.getFxjbz());
			map.put("gxdwbz", setQyryjctj.getGxdwbz());
			
			map.put("xm", setQyryjctj.getXm());
			map.put("zjhm", setQyryjctj.getZjhm());
			map.put("cyrybh", setQyryjctj.getCyrybh());
			
			map.put("qsrq", setQyryjctj.getQsrq());
			map.put("jzrq", setQyryjctj.getJzrq());
			Page page = qyryjctjService.getListForPage(map, 1, Integer.parseInt(maxRows),null,null);
			session.setAttribute("qyryjctjList", page.getData());
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
			Qyryjctj setQyryjctj = new Qyryjctj();
			
			String bbmc = request.getParameter("bbmc");
			String tabletitle = request.getParameter("tabletitle");
			List lResult = new ArrayList(); // //开头excel
			StringBuffer sb = new StringBuffer();
			sb.append("<tr>");
			sb.append(tabletitle);
			sb.append("<th name='l_jzrqJczs' datatype='Integer' sumflag='0'>奖惩总数（至截止日期）</th>");
	     	sb.append("<th name='l_jzrqCfzs' datatype='Integer' sumflag='0'>处罚总数（至截止日期）</th>");
	     	sb.append("<th name='l_jzrqJlzs' datatype='Integer' sumflag='0'>奖励总数（至截止日期）</th>");
	     	sb.append("<th name='l_zqnJczs' datatype='Integer' sumflag='0'>奖惩总数（周期内新增）</th>");
	     	sb.append("<th name='l_zqnCfzs' datatype='Integer' sumflag='0'>处罚总数（周期内新增）</th>");
			sb.append("<th name='l_jg' datatype='Integer' sumflag='0'>警告（周期内新增）</th>");
			sb.append("<th name='l_fk' datatype='Integer' sumflag='0'>罚款（周期内新增）</th>");
			sb.append("<th name='l_jl' datatype='Integer' sumflag='0'>拘留（周期内新增）</th>");
			sb.append("<th name='l_jlbfk' datatype='Integer' sumflag='0'>拘留并罚款（周期内新增）</th>");
			sb.append("<th name='l_zjxszr' datatype='Integer' sumflag='0'>追究刑事责任（周期内新增）</th>");
			sb.append("<th name='l_xqcjhqzcj' datatype='Integer' sumflag='0'>限期出境或驱逐出境（周期内新增）</th>");
			sb.append("<th name='l_qtfklx' datatype='Integer' sumflag='0'>其他处罚（周期内新增）</th>");
			sb.append("<th name='l_zqnJlzs' datatype='Integer' sumflag='0'>奖励总数（周期内新增）</th>");
			sb.append("<th name='l_tbbycs' datatype='Integer' sumflag='0'>通报表扬（周期内新增）</th>");
			sb.append("<th name='l_wzjlcs' datatype='Integer' sumflag='0'>物质奖励（周期内新增）</th>");
			sb.append("<th name='l_qtjlcs' datatype='Integer' sumflag='0'>其他奖励（周期内新增）</th>");
			sb.append("</tr>");
			
			List lColumn = this.getExcelColumn(sb.toString());
			lResult.add(bbmc);
			lResult.add(lColumn);
			lResult.add(response);
			lResult.add((List)session.getAttribute("qyryjctjList"));
			lResult.add(setQyryjctj);
			this.setExcelCreate("fileName",lResult);  ////ztxx 默认文件名字的开头excel
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
		this.result="success";
    }
	
	public String query() throws Exception{
		try {
			Qyryjctj setQyryjctj=new Qyryjctj();
			qyryjctj=(Qyryjctj)this.setClass(setQyryjctj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryjctj=qyryjctjService.getQyryjctj(qyryjctj);
        lQyryjctj.clear();
        lQyryjctj.add(qyryjctj);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Qyryjctj setQyryjctj=new Qyryjctj();
			qyryjctj=(Qyryjctj)this.setClass(setQyryjctj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryjctj=qyryjctjService.insertQyryjctj(qyryjctj);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Qyryjctj setQyryjctj=new Qyryjctj();
			qyryjctj=(Qyryjctj)this.setClass(setQyryjctj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryjctjService.updateQyryjctj(qyryjctj);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyryjctj setQyryjctj=new Qyryjctj();
			qyryjctj=(Qyryjctj)this.setClass(setQyryjctj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyryjctjService.deleteQyryjctj(qyryjctj);
        this.result="success";
        return "success";
    }
}