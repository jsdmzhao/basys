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
import com.aisino2.publicsystem.domain.Clxx_zp;
import com.aisino2.publicsystem.service.IClxx_zpService;

public class Clxx_zpAction extends PageAction{
	private IClxx_zpService clxx_zpService;
	private List lClxx_zp=new ArrayList();
	private Clxx_zp clxx_zp=new Clxx_zp();
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

	public Clxx_zp getClxx_zp() {
		return clxx_zp;
	}
	
	public List getLClxx_zp() {
		return lClxx_zp;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setClxx_zpService(IClxx_zpService clxx_zpService) {
		this.clxx_zpService = clxx_zpService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("cljbxxid");
		lPro.add("clxxzpid");
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
    	
    	Clxx_zp getClxx_zp=new Clxx_zp();
    	
        this.setData(getClxx_zp,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Clxx_zp setClxx_zp=new Clxx_zp();
        Map map = new HashMap();
        Page page = clxx_zpService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lClxx_zp=page.getData();
        setTabledata(lClxx_zp); 
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
				String clxxzpid = request.getParameter("clxxzpid");
				byte[]tpnr = null;
				if(clxxzpid!=null){
					clxx_zp.setClxxzpid(new Integer(clxxzpid));
					clxx_zp = clxx_zpService.getClxx_zp(clxx_zp);
					tpnr = clxx_zp.getTpnr();
					if(tpnr==null || tpnr.length==0){
						BASE64Decoder base64Decoder = new BASE64Decoder();
						tpnr = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
					}
					input = new ByteArrayInputStream(tpnr);
					int readBytes = 0;
					byte[] buffer = new byte[512];
					while ((readBytes = input.read(buffer, 0, buffer.length)) != -1) {
						out.write(buffer, 0, readBytes);
					}
				}
				out.flush();
				response.setStatus(response.SC_OK);
				response.flushBuffer();	
				clxx_zp = null;
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
			Clxx_zp setClxx_zp=new Clxx_zp();
			clxx_zp=(Clxx_zp)this.setClass(setClxx_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxx_zp=clxx_zpService.getClxx_zp(clxx_zp);
        lClxx_zp.clear();
        lClxx_zp.add(clxx_zp);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Clxx_zp setClxx_zp=new Clxx_zp();
			clxx_zp=(Clxx_zp)this.setClass(setClxx_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxx_zp=clxx_zpService.insertClxx_zp(clxx_zp);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Clxx_zp setClxx_zp=new Clxx_zp();
			clxx_zp=(Clxx_zp)this.setClass(setClxx_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxx_zpService.updateClxx_zp(clxx_zp);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Clxx_zp setClxx_zp=new Clxx_zp();
			clxx_zp=(Clxx_zp)this.setClass(setClxx_zp, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clxx_zpService.deleteClxx_zp(clxx_zp);
        this.result="success";
        return "success";
    }
}