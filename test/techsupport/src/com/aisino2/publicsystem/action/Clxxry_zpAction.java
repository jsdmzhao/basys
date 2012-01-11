package com.aisino2.publicsystem.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.aisino2.common.ImageUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Clxxry_zp;
import com.aisino2.publicsystem.service.IClxxry_zpService;

public class Clxxry_zpAction extends PageAction{
	private IClxxry_zpService clxxry_zpService;
	private List lClxxry_zp=new ArrayList();
	private Clxxry_zp clxxry_zp=new Clxxry_zp();
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

	public Clxxry_zp getClxxry_zp() {
		return clxxry_zp;
	}
	
	public List getLClxxry_zp() {
		return lClxxry_zp;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setClxxry_zpService(IClxxry_zpService clxxry_zpService) {
		this.clxxry_zpService = clxxry_zpService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cljbxxid");
		lPro.add("clxxryzpid");
		lPro.add("tpmc");
		lPro.add("tplx");
		lPro.add("tpnr");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Clxxry_zp getClxxry_zp=new Clxxry_zp();
    	
        this.setData(getClxxry_zp,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Clxxry_zp setClxxry_zp=new Clxxry_zp();
        Map map = new HashMap();
        Page page = clxxry_zpService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lClxxry_zp=page.getData();
        setTabledata(lClxxry_zp); 
		 this.result="success";
        return "success";
    }

	public void queryTp() throws Exception{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response =  ServletActionContext.getResponse();
			OutputStream out = response.getOutputStream();
			InputStream input = null;
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("image/jpeg");
				String clryzpid = request.getParameter("clryzpid");
				byte[]tpnr = null;
				if(clryzpid!=null){
					clxxry_zp.setClxxryzpid(new Integer(clryzpid));
					clxxry_zp = clxxry_zpService.getClxxry_zp(clxxry_zp);
					tpnr = clxxry_zp.getTpnr();
					if(tpnr==null || tpnr.length==0){
						BASE64Decoder base64Decoder = new BASE64Decoder();
						tpnr = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
					}
					input = new ByteArrayInputStream(tpnr);
					int readBytes = 0;
					byte[] buffer = new byte[512];
					while ((readBytes = input.read(buffer, 0, buffer.length)) != -1) {
						out.write(buffer, 0, readBytes);
						out.flush();
					}			
				}
				response.setStatus(response.SC_OK);
				response.flushBuffer();	
				clxxry_zp = null;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if (input != null) {
					input.close();
				}
				if (out != null) {
					out.close();
				}
			}
		}
	
	public String query() throws Exception{
		try {
			Clxxry_zp setClxxry_zp=new Clxxry_zp();
			clxxry_zp=(Clxxry_zp)this.setClass(setClxxry_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxxry_zp=clxxry_zpService.getClxxry_zp(clxxry_zp);
        lClxxry_zp.clear();
        lClxxry_zp.add(clxxry_zp);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Clxxry_zp setClxxry_zp=new Clxxry_zp();
			clxxry_zp=(Clxxry_zp)this.setClass(setClxxry_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxxry_zp=clxxry_zpService.insertClxxry_zp(clxxry_zp);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Clxxry_zp setClxxry_zp=new Clxxry_zp();
			clxxry_zp=(Clxxry_zp)this.setClass(setClxxry_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxxry_zpService.updateClxxry_zp(clxxry_zp);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Clxxry_zp setClxxry_zp=new Clxxry_zp();
			clxxry_zp=(Clxxry_zp)this.setClass(setClxxry_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxxry_zpService.deleteClxxry_zp(clxxry_zp);
        this.result="success";
        return "success";
    }
}