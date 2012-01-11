package com.aisino2.publicsystem.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyzlxx;
import com.aisino2.publicsystem.domain.Qyzlxxfj;
import com.aisino2.publicsystem.service.IQyzlxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;


public class QyzlxxAction extends PageAction{
	private IQyzlxxService qyzlxxService;
	private List lQyzlxx=new ArrayList();
	private Qyzlxx qyzlxx=new Qyzlxx();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	private String uploadpath; //上传路径
	private User user;
	private Qyzlxxfj qyzlxx_fj;	
	
//////////////////////////////////////////
	private String fileNamecon;
	private String base64codecon;
	private String fileTempNamecon;
	
	////////////////////////////////////////////////////
	private String title;
    private File[] upload;
    private String[] uploadContentType;
    private String[] uploadFileName;
    		
	public String getFileNamecon() {
		return fileNamecon;
	}

	public void setFileNamecon(String fileNamecon) {
		this.fileNamecon = fileNamecon;
	}

	public String getBase64codecon() {
		return base64codecon;
	}

	public void setBase64codecon(String base64codecon) {
		this.base64codecon = base64codecon;
	}

	public String getFileTempNamecon() {
		return fileTempNamecon;
	}

	public void setFileTempNamecon(String fileTempNamecon) {
		this.fileTempNamecon = fileTempNamecon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Qyzlxxfj getQyzlxx_fj() {
		return qyzlxx_fj;
	}

	public void setQyzlxx_fj(Qyzlxxfj qyzlxx_fj) {
		this.qyzlxx_fj = qyzlxx_fj;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUploadpath() {
		return uploadpath;
	}

	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Qyzlxx getQyzlxx() {
		return qyzlxx;
	}
	
	public List getLQyzlxx() {
		return lQyzlxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setQyzlxxService(IQyzlxxService qyzlxxService) {
		this.qyzlxxService = qyzlxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		 lPro.add("qyzlxxid");
		// lPro.add("hylbdm");
		// lPro.add("hylb");
		// lPro.add("fbdwdm");
		lPro.add("fbdwmc");
		// lPro.add("fbr");
		lPro.add("fbsj");
		//lPro.add("scbz");
		lPro.add("fjmc");
    	
    	// List lModify=new ArrayList();
    	//lModify.add("setModifyQuery");
    	// lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDeleteqyzlxx");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	// lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Qyzlxx getQyzlxx=new Qyzlxx();
    	
        this.setData(getQyzlxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Qyzlxx setQyzlxx=new Qyzlxx();
        qyzlxx=(Qyzlxx)this.setClass(setQyzlxx, null);
        java.util.Calendar c=java.util.Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
        Map map = new HashMap();
        if(qyzlxx.getFbdwdm()!=null&&!qyzlxx.getFbdwdm().equals("")){
        	 map.put("fbdwdm", qyzlxx.getFbdwdm());
        }
        if(qyzlxx.getFjmc()!=null&&!qyzlxx.getFjmc().equals("")){
        	String fjmc=qyzlxx.getFjmc();
        	if(fjmc!=null&&!fjmc.equals("")){
        		int i = fjmc.indexOf("*");
				int j = fjmc.indexOf("×");
				if (i >= 0 || j >= 0) {// 有任意一种通配标识,将通配符*转换成%
					String str1 = fjmc.replace("*", "%");
					String str2 = str1.replace("×", "%");
					map.put("fjmc", str2);
					
				} else {
					map.put("fjmc", qyzlxx.getFjmc());
				}
        	}
        	 
        }
        if(qyzlxx.getHylbdm()!=null&&!qyzlxx.getHylbdm().equals("")){
        	map.put("hylbdm",qyzlxx.getHylbdm());
       }
        if(qyzlxx.getFbsj()!=null&&!qyzlxx.getFbsj().equals("")){
        	 map.put("fbsj", qyzlxx.getFbsj());
        	 if(qyzlxx.getFbjzsj()!=null&&!qyzlxx.getFbjzsj().equals("")){
          	   map.put("fbjzsj",qyzlxx.getFbjzsj());
             }
        	 else{
        		 Date time=sdf.parse(sdf.format(c.getTime()));
     			map.put("fbjzsj", time);
        	 }
        }
       
        
       
        
        Page page = qyzlxxService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
       // page.getClass(); //在页面上给附件名称加上链接
        lQyzlxx=page.getData();
        Iterator it=lQyzlxx.iterator();
        List newlist=new ArrayList();
        while(it.hasNext()){
        //	System.out.println(it.next());
        	Qyzlxx setQyzlxx_old=(Qyzlxx)it.next();
        	String fjmc=setQyzlxx_old.getFjmc();
        	int qyzlxxid=setQyzlxx_old.getQyzlxx_fjid();
        	fjmc="<a href='#' onclick='(downloadFJ(this.id));' id='"+qyzlxxid+"'>"+fjmc+"</a>";
        	setQyzlxx_old.setFjmc(fjmc);
        	newlist.add(setQyzlxx_old);
        }
       
        setTabledata(newlist); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Qyzlxx setQyzlxx=new Qyzlxx();
			qyzlxx=(Qyzlxx)this.setClass(setQyzlxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzlxx=qyzlxxService.getQyzlxx(qyzlxx);
        lQyzlxx.clear();
        lQyzlxx.add(qyzlxx);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{				
		try {
			Qyzlxx setQyzlxx=new Qyzlxx();
			Qyzlxxfj QyzlxxFj=new Qyzlxxfj();
			Object[] child = {QyzlxxFj};///  绑定子属性
			
			qyzlxx=(Qyzlxx)this.setClass(setQyzlxx, child);
			// 取得附件
		   /* uploadpath=qyzlxx.getFjmc();
		    if(uploadpath!=null||!uploadpath.equals("")){
		    	fjupload(uploadpath);
		    }*/
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			List csjbxxList = (List)session.getAttribute("seesionCslist");
			session.removeAttribute("seesionCslist");
			user= (User)session.getAttribute(Constants.userKey);
			String departName=user.getDepartment().getDepartname();
			String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
			if(depertCode0.length()<12){
				depertCode0=depertCode0+"00000000000";
				depertCode0=depertCode0.substring(0, 12);
			}
			String userName=user.getUsername();	
			// Qyzlxx setQyzlxx=new Qyzlxx();
			java.util.Calendar c=java.util.Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date nowtime=new Date();			
			setQyzlxx.setFbr(userName);
			setQyzlxx.setFbdwdm(depertCode0);
			System.out.println(sdf.parse(sdf.format(nowtime)));
			setQyzlxx.setFbsj(sdf.parse(sdf.format(nowtime)));
			// setQyzlxx.setFbsj(sdf.parse(sdf.format(nowtime)));
			 setQyzlxx.setHylbdm(qyzlxx.getHylbdm());
			setQyzlxx.setHylb("营业性娱乐场所");
			setQyzlxx.setFbdwmc(departName);
			setQyzlxx.setScbz(0);
			
			List qyzlxxfj=new ArrayList();
			List fj_list=qyzlxx.getLXctbfjList();
			String serviceFile = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("uploadTemp");  ///读取文件的目录
			for(int i=0;i<fj_list.size();i++){
				
				Qyzlxxfj zl_fj = new Qyzlxxfj();
				qyzlxx_fj = (Qyzlxxfj)fj_list.get(i);
				String fjmc = qyzlxx_fj.getFjmc();           //文件名称
				
				String[] fjlxarray = fjmc.split("\\.");
				String fjlx = fjlxarray[fjlxarray.length-1];  ////得到附件类型
				
				String fjbase = qyzlxx_fj.getFjbase(); ///得到附件的临时文件名
				sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
				BufferedInputStream bis = null;
				byte[] fjnr = null;        ///附件内容
				
				try {
					bis = new BufferedInputStream(new FileInputStream(serviceFile+"\\"+fjbase));
					fjnr = new byte[bis.available()];
					bis.read(fjnr);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(bis!=null){ bis.close(); }
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				/////////删除临时文件夹中的文件
				File file = new File(serviceFile+"\\"+fjbase);
				if(file.exists()){
					file.delete(); //删除文件
				}
				//////////////////
				
				zl_fj.setFjmc(fjmc);
				zl_fj.setFjlx(fjlx);
				zl_fj.setFjnr(fjnr);								
				qyzlxxfj.add(zl_fj);				
				
			}
			setQyzlxx.setFj_obj(qyzlxxfj);
			qyzlxx=qyzlxxService.insertQyzlxx(setQyzlxx);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       // qyzlxx=qyzlxxService.insertQyzlxx(qyzlxx);
        this.result="success";
        return "success";
    }
	
	// 附件上传
	public void fjupload(String path) throws IOException, ParseException{
	FileInputStream in=null;
	String allpath=path;
	String [] paths=allpath.split(",");
	if(paths!=null){
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		user= (User)session.getAttribute(Constants.userKey);
		String departName=user.getDepartment().getDepartname();
		String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
		if(depertCode0.length()<12){
			depertCode0=depertCode0+"00000000";
			depertCode0=depertCode0.substring(0, 12);
		}
		String userName=user.getUsername();	
		
		for(int a=0;a<paths.length;a++){			
			java.util.Calendar c=java.util.Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		
			Qyzlxx setQyzlxx=new Qyzlxx();
			setQyzlxx.setFbr(userName);
			setQyzlxx.setFbdwdm(depertCode0);
			setQyzlxx.setFbsj(sdf.parse(sdf.format(c.getTime())));
			setQyzlxx.setHylbdm("J");
			setQyzlxx.setHylb("营业性娱乐场所");
			setQyzlxx.setFbdwmc(departName);
			setQyzlxx.setScbz(0);
			
			//附件处理
			String fileName=paths[a].substring(paths[a].lastIndexOf("\\")+1);
			// byte[] b = fileName.getBytes("GBK");
			// fileName = new String(b, "8859_1");
			
			String[] fjhz=fileName.split("\\.");
			
			Qyzlxxfj qyzlxx_fjs=new Qyzlxxfj();
			qyzlxx_fjs.setFjlx(fjhz[fjhz.length-1]);
			qyzlxx_fjs.setFjmc(fileName);
			try {
				in=new FileInputStream(paths[a]);
				byte[] byt=new byte[in.available()];
				in.read(byt);
				qyzlxx_fjs.setFjnr(byt);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List list=new ArrayList();
			list.add(qyzlxx_fjs);
			setQyzlxx.setFj_obj(list);
			qyzlxx=qyzlxxService.insertQyzlxx(setQyzlxx);
		}
	}
	}
	
	public String modify() throws Exception{
		try {
			Qyzlxx setQyzlxx=new Qyzlxx();
			qyzlxx=(Qyzlxx)this.setClass(setQyzlxx, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        qyzlxxService.updateQyzlxx(qyzlxx);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Qyzlxx setQyzlxx=new Qyzlxx();
			qyzlxx=(Qyzlxx)this.setClass(setQyzlxx, null);
			qyzlxx.setScbz(1); //设置删除标识:1 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qyzlxxService.updateQyzlxx(qyzlxx);
        this.result="success";
        return "success";
    }
	
	// 查看和下载附件
	//下载附件
	public void download() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		int jbxsfjid=Integer.parseInt(request.getParameter("qyzlxxid"));
		//System.out.println(new String(request.getParameter("fjmc").getBytes("8859_1"),"utf-8"));
		//String fjmc=new String(request.getParameter("fjmc").getBytes("8859_1"),"utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		Qyzlxxfj setQyzlxxfj=new Qyzlxxfj();
		//获取参数id和附件的名称
		// jbxs_fj=(Jbxsfj)this.setClass(jbxsfj, null);
		setQyzlxxfj.setQyzlxxfjid(jbxsfjid);
		//setQyzlxxfj.setFjmc(fjmc);
		System.out.println("----fjid:----"+setQyzlxxfj.getQyzlxxid());
		Qyzlxxfj qyryfj=qyzlxxService.downloadFJ(setQyzlxxfj);
		OutputStream output = null;
		InputStream in=null;
		if(qyryfj!=null){
			byte[] fjnr=qyryfj.getFjnr();
			
			String fileName=qyryfj.getFjmc();//设置文件名
			byte[] b = fileName.getBytes("GBK");
			fileName = new String(b, "8859_1");
		//	fileName = URLEncoder.encode(fileName,"GBK");
			response.reset(); 			
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition","attachment;filename=" + fileName);
			if(fjnr!=null){
				try{
					
					output = response.getOutputStream();												
			        output.write(fjnr);		          			    
			        output.flush();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try{
					if(in!=null){
						in.close();
					}if(output!=null){
						output.close();
						output=null;											
					}
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			}			
		}
	} 
//-------------------------------------------修改上传
	/**
	 * 上传临时文件
	 * @return
	 * @throws Exception
	 */
	public String uptempfile() throws Exception{
		
		BASE64Decoder base64Decoder = new BASE64Decoder();
		RandomAccessFile os = null;
		// String serviceFile = ServletActionContext.getRequest().getRealPath("uploadTemp"); ///文件存放路径
		String serviceFile =ServletActionContext.getRequest().getSession().getServletContext().getRealPath("uploadTemp");
		long nowtime = System.currentTimeMillis();   /////根据时间得到文件名字
		String[] fjlxarray = fileNamecon.split("\\.");
		String fjlx = fjlxarray[fjlxarray.length-1];  ////得到附件类型
		String fileTempName = String.valueOf(nowtime)+"."+fjlx;
		try {
			byte[] bytetemp = base64Decoder.decodeBuffer(base64codecon);
			os = new RandomAccessFile(serviceFile+"\\"+fileTempName,"rw");
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
		fileTempNamecon = fileTempName;   /////把临时文件的名字回传给页面
		base64codecon = "";
		this.result="success";
        return "success";
		
	}
	/**
	 * 删除单条临时文件
	 * @return
	 * @throws Exception
	 */
	public String deleteFile() throws Exception{
		
		String serviceFile = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("uploadTemp"); ///文件存放路径
		File file = new File(serviceFile+"\\"+fileTempNamecon);
		if(file.exists()){
			file.delete(); //删除文件
		}
		
		this.result="success";
        return "success";
	}
	/**
	 * 删除 全部临时文件
	 * @return
	 * @throws Exception
	 */
	public String deleteAllFile() throws Exception{
		
		try{
		   Qyzlxxfj qyzlfj = new Qyzlxxfj();
		   Object[] child = {qyzlfj};///  绑定子属性
		   Qyzlxx setXctb=new Qyzlxx();
		   qyzlxx=(Qyzlxx)this.setClass(setXctb, child);
		   List fjinfoList = qyzlxx.getLXctbfjList();
		   String serviceFile = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("uploadTemp");  ///读取文件的目录
		   for(int i=0;i<fjinfoList.size();i++){
			   qyzlfj = (Qyzlxxfj)fjinfoList.get(i);
			   String fjbase = qyzlfj.getFjbase(); ///得到附件的临时文件名
			   File file = new File(serviceFile+"\\"+fjbase);
				if(file.exists()){
					file.delete(); //删除文件
				}
		   }
			
		}catch(Exception e){
			e.printStackTrace();
			this.result="";
	        return "success";
		}
		this.result="success";
        return "success";
	}
	
}
