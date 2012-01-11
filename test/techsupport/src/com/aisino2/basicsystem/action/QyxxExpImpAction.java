package com.aisino2.basicsystem.action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.aisino2.basicsystem.domain.QyxxExpImp;
import com.aisino2.basicsystem.service.IQyxxExpImpService;
import com.aisino2.common.StringUtil;
import com.aisino2.common.XmlReader;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.DateUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

public class QyxxExpImpAction extends PageAction{
	private IQyxxExpImpService qyxxExpImpService;
	private String tabledata = "";
	private int totalrows =0;
	private String result = "success";
	private String expFileName = "";
	
	public int getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}
	public String getTabledata() {
		return tabledata;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getExpFileName() {
		return expFileName;
	}
	public void setQyxxExpImpService(IQyxxExpImpService qyxxExpImpService) {
		this.qyxxExpImpService = qyxxExpImpService;
	}
	
	public void setTabledata(List lData) throws Exception {
		List lPro=new ArrayList();
		lPro.add("qyid");
		lPro.add("checktab");
		lPro.add("qybm");
		lPro.add("qymc");
		lPro.add("frxm");
		lPro.add("lxdh");
		lPro.add("dizhi");
		lPro.add("gxdwmc");

    	List lCol = new ArrayList();
    	QyxxExpImp getSjb = new QyxxExpImp();
        this.setData(getSjb,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylistExp() throws Exception {
		try {
			List list = new ArrayList();
			QyxxExpImp setQyxxExpImp = new QyxxExpImp();
			setQyxxExpImp=(QyxxExpImp)this.setClass(setQyxxExpImp, null);
			
			Map map = new HashMap();
			queryMapOper(map, setQyxxExpImp);
			Page page = qyxxExpImpService.getListForPage(map, pagesize, pagerow,sort,dir);
			if(page!=null){
				totalpage=page.getTotalPages();
				totalrows=page.getTotalRows();
				list = page.getData();
				listOper(list);
			}
			setTabledata(list);
		} catch (Exception e) {
			e.printStackTrace();
			result="";
	        return "success";
		}
        return "success";
    }
	
	public void queryMapOper(Map map,QyxxExpImp setQyxxExpImp){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		String gxdwbm = "";
		if(user!=null&&user.getDepartment().getDepartcode().length()==12){
			gxdwbm = user.getDepartment().getDepartcode();
		}
		String qtGxdwdm = setQyxxExpImp.getGxdwbm();
		if(qtGxdwdm!=null&&!"".equals(qtGxdwdm)){
			gxdwbm = qtGxdwdm;
		}
		
		map.put("hylbdm", setQyxxExpImp.getHylbdm());
		map.put("qybm", setQyxxExpImp.getQybm());
		map.put("qymc", setQyxxExpImp.getQymc());
		map.put("gxdwbm", StringUtil.trimEven0(gxdwbm));
		map.put("cxtjDcbs", setQyxxExpImp.getCxtjDcbs());
		map.put("cxtjDcsj", setQyxxExpImp.getCxtjDcsj());
	}
	public void listOper(List list){
		for(int indexYlcs=0,max=list.size();indexYlcs<max;indexYlcs++){
			QyxxExpImp tempQyxx = (QyxxExpImp)list.get(indexYlcs);
			String csqp = "<input type='checkbox' id='tijiao_"+tempQyxx.getQyid()+"'"+
				" onclick='cstjCheck(this)' />";
			tempQyxx.setChecktab(csqp);
		}
	}
	
	/**
	 * 全部提交
	 * @return
	 */
	public String quanbuExp() throws Exception {
		try {
			QyxxExpImp setQyxxExpImp = new QyxxExpImp();
			setQyxxExpImp=(QyxxExpImp)this.setClass(setQyxxExpImp, null);
			if(!qyxxExpImpService.updateExpAllQxx(setQyxxExpImp)){
				result="";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result="";
			return "success";
		}
		expFileName = "aaa";
		return "success";
	}
	
	/**
	 * 部分提交
	 * @return
	 */
	public String bufenExp(){
		try {
			QyxxExpImp setQyxxExpImp = new QyxxExpImp();
			setQyxxExpImp =(QyxxExpImp)this.setClass(setQyxxExpImp, null);
			String hylbdm = setQyxxExpImp.getHylbdm();
			String selQyid = setQyxxExpImp.getSelQyid();
			String[] qyidArr = selQyid.split(",");
			if(!qyxxExpImpService.updateExpBufenQyxx(qyidArr,hylbdm)){
				this.result="";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
			return "success";
		}
		return "success";
	}
	
	public String uploadQyxxXml() throws Exception {
		String res = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		BASE64Decoder base64Decoder = new BASE64Decoder();
		try {
			QyxxExpImp setQyxxExpImp = new QyxxExpImp();
			setQyxxExpImp =(QyxxExpImp)this.setClass(setQyxxExpImp, null);
			byte[] bytetemp = base64Decoder.decodeBuffer(setQyxxExpImp.getSqwjCon());
			String fileName = writeXmlFile(bytetemp);
			if(!"".equals(fileName)){
				List listNode = XmlReader.getNodeList(fileName, "Package/Data/Record");
				if(listNode!=null&&listNode.size()>0){
					res = qyxxExpImpService.uploadXmlMessage(listNode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			res += "上传过程中存在异常,请联系管理员.\r\n";
			result = "";
		}
		if(!"".equals(res)){
			res += DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss", new Date());
			HttpSession session = request.getSession();
			session.setAttribute("logResultMes", res);
			result = "";
		}
		return "success";
	}
	public String writeXmlFile(byte[] bytetemp){
		String serviceFile = ServletActionContext.getRequest().getRealPath("qyrzxxTemp");
		long nowtime = System.currentTimeMillis();
		String fileName = serviceFile+"\\"+String.valueOf(nowtime)+".xml";
		RandomAccessFile os = null;
		try {
			os = new RandomAccessFile(fileName,"rw");
			os.write(bytetemp, 0, bytetemp.length);
		} catch (Exception e) {
			e.printStackTrace();
			fileName="";
		} finally {
			try {
				if(os!=null){ os.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fileName;
	}
	/**
	 * 导出XML
	 */
	public void resExpXml() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String expFile = (String)session.getAttribute("qyxxKfFile");
		if(expFile!=null){
			byte[] bytetemp = null;
			BufferedInputStream bis = null;
			try {
				bis = new BufferedInputStream(new FileInputStream(expFile));
				bytetemp = new byte[bis.available()];
				bis.read(bytetemp);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(bis!=null){ bis.close(); }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date nowDate = new Date();
			String dateNowStr=dateFormat.format(nowDate);
			String fileName = "KFSJ-"+dateNowStr+String.valueOf(System.currentTimeMillis()).substring(7, 13)+".XML";
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition","attachment;filename=\""
					+ new String(fileName.getBytes("GB2312"), "ISO8859_1")+ "\"");
			response.getOutputStream().write(bytetemp);
		}
	}
	
	/**
	 * 导出日志txt
	 */
	public void resExpLogTxt() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String logContent = (String)session.getAttribute("logResultMes");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date nowDate = new Date();
		String dateNowStr=dateFormat.format(nowDate);
		String fileName = "LOG-"+dateNowStr+String.valueOf(System.currentTimeMillis()).substring(7, 13)+".TXT";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-msdownload");
		response.addHeader("Content-Disposition","attachment;filename=\""
				+ new String(fileName.getBytes("GB2312"), "ISO8859_1")+ "\"");
		response.getOutputStream().write(logContent.getBytes());
	}
}