package com.aisino2.publicsystem.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.aisino2.common.ImageUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Pmt;
import com.aisino2.publicsystem.service.IPmtService;

public class PmtAction extends PageAction{
	private IPmtService pmtService;
	private List lPmt=new ArrayList();
	private Pmt pmt=new Pmt();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	private String requestType="";
	private String picConTemp = ImageUtil.picConTemp;
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Pmt getPmt() {
		return pmt;
	}
	
	public List getLPmt() {
		return lPmt;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setPmtService(IPmtService pmtService) {
		this.pmtService = pmtService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sPmtid");
		lPro.add("pmtlxdm");
		lPro.add("pmtlxmc");

		List lCol=new ArrayList();
		List lDel=new ArrayList();
		lDel.add("pmt_setDelete");
		lDel.add("删除");
		lCol.add(lDel);
    	
    	Pmt getPmt=new Pmt();
    	
        this.setData(getPmt,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			requestType="";
			Pmt setPmt=new Pmt();
			setPmt=(Pmt)this.setClass(setPmt, null);
			requestType=setPmt.getPmtRequetType();
			Map map = new HashMap();
			map.put("qyid", setPmt.getQyid());
			Page page = pmtService.getListForPage(map, pagesize, pagerow,null,null);
			lPmt=page.getData();
			setObjectIdForHtmlList(lPmt);
			setTabledata(lPmt);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Pmt setPmt=new Pmt();
			Object[] objA={setPmt};
			setPmt=(Pmt)this.setClass(setPmt, objA);
			oldList = setPmt.getLPmtList();
			String sPmtId = setPmt.getSPmtid();
			
			Pmt queryPmt = new Pmt();
			if(oldList!=null&&oldList.size()>0){
				if(sPmtId.contains("NEW")){ //新增加
					for(int index=0,max=oldList.size();index<max;index++){
						Pmt pmt = (Pmt)oldList.get(index);
						if(sPmtId.equals(pmt.getSPmtid())){
							queryPmt = pmt;
						}
					}
				} else { //数据库原有
					queryPmt.setPmtid(Integer.parseInt(setPmt.getSPmtid()));
					queryPmt = pmtService.getPmtNoBlob(queryPmt);
				}
			}
			lPmt = new ArrayList();
	        lPmt.add(queryPmt);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Pmt setPmt=new Pmt();
			Object[] objA={setPmt};
			setPmt=(Pmt)this.setClass(setPmt, objA);
			oldList = setPmt.getLPmtList();
			
			BASE64Decoder base64Decoder = new BASE64Decoder();
			RandomAccessFile os = null;
			String serviceFile = ServletActionContext.getRequest().getRealPath("pmtUploadTemp");
			long nowtime = System.currentTimeMillis();
			String fileName = String.valueOf(nowtime)+".jpg";
			try {
				byte[] bytetemp = base64Decoder.decodeBuffer(setPmt.getPmtStringContent());
				os = new RandomAccessFile(serviceFile+"\\"+fileName,"rw");
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
			setPmt.setSPmtid("NEW="+fileName);
			oldList.add(setPmt);
			setTabledata(oldList); 
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
			Pmt setPmt=new Pmt();
			setPmt=(Pmt)this.setClass(setPmt, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
        pmtService.updatePmt(pmt);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		requestType = "";
		try {
			List oldList = new ArrayList();
			Pmt setPmt=new Pmt();
			Object[] objA={setPmt};
			setPmt=(Pmt)this.setClass(setPmt, objA);
			oldList = setPmt.getLPmtList();
			String sPmtId = setPmt.getSPmtid();
			if(oldList!=null&&oldList.size()>0){
				for(int index=0,max=oldList.size();index<max;index++){
					Pmt pmt = (Pmt)oldList.get(index);
					if(sPmtId.equals(pmt.getSPmtid())){
						oldList.remove(index);
						if(sPmtId.contains("NEW=")){
							String serviceFile = ServletActionContext.getRequest().getRealPath("pmtUploadTemp");
							File file = new File(serviceFile+"\\"+sPmtId.replace("NEW=", ""));
							if(file.exists()){
								file.delete();
							}
						}
						break;
					}
				}
			}
			setTabledata(oldList); 
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.result="success";
        return "success";
    }
	
	public void setObjectIdForHtmlList(List allResult){
		if(allResult!=null&&allResult.size()>0){
			for(int index=0,max=allResult.size();index<max;index++){
				Pmt temp = (Pmt)allResult.get(index);
				if(temp.getPmtid()!=null){ //数据库拿出来的
					temp.setSPmtid(String.valueOf(temp.getPmtid()));
				}
			}
		}
	}
	
	public void getCyryzpImg(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest requeset = ServletActionContext.getRequest();
		String pmtId = requeset.getParameter("pmtId");
		try {
			byte[] tempbyteArr = null;
			if(pmtId.contains("NEW")){ //新增加
				BufferedInputStream bis = null;
				try {
					String serviceFile = ServletActionContext.getRequest().getRealPath("pmtUploadTemp");
					bis = new BufferedInputStream(new FileInputStream(serviceFile+"\\"+pmtId.replace("NEW=", "")));
					tempbyteArr = new byte[bis.available()];
					bis.read(tempbyteArr);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(bis!=null){ bis.close(); }
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			} else { //数据库原有
				Pmt queryPmt = new Pmt();
				queryPmt.setPmtid(Integer.parseInt(pmtId));
				queryPmt = pmtService.getPmt(queryPmt);
				if(queryPmt!=null){
					tempbyteArr = queryPmt.getPmtz();
				}
			}
			BASE64Decoder base64Decoder = new BASE64Decoder();
			BASE64Encoder base64encoder = new BASE64Encoder();
			if(tempbyteArr!=null&&tempbyteArr.length>0){
			} else {
				tempbyteArr = base64Decoder.decodeBuffer(picConTemp);
			}
			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			response.getOutputStream().write(tempbyteArr);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return;
		}
		this.result="success";
	}
}