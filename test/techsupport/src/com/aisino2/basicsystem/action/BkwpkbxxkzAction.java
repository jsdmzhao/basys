package com.aisino2.basicsystem.action;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Bkclkz;
import com.aisino2.basicsystem.domain.Bksjkz;
import com.aisino2.basicsystem.domain.Bkwpkbxxkz;
import com.aisino2.basicsystem.service.IBkclkzService;
import com.aisino2.basicsystem.service.IBksjkzService;
import com.aisino2.basicsystem.service.IBkwpkbxxkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class BkwpkbxxkzAction extends PageAction{
	private IBkwpkbxxkzService bkwpkbxxkzService;
	private IBkclkzService bkclkzService;
	private IBksjkzService bksjkzService;
	private List lBkwpkbxxkz=new ArrayList();
	private Bkwpkbxxkz bkwpkbxxkz=new Bkwpkbxxkz();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	private String picConTemp = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/wAALCAAgACABAREA/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/9oACAEBAAA/APf65/xJq1xby2mmadKI767YsZSobyIV+++DwT0UZ7n2qDwrr1xe3F9pGpSK+oWTBhIFC+fC33XwOAexx3FdPUc88VtbyTzOscUal3djgKoGSTXnY1Ty7DWfGF9aySIsBnEA4ZbdP9XHz0J5c/WsbUtXfTrrQ/F9pbyxwXEC3Hkt95oHALxn1K5BFeuW1zDeWsVzbyLJDKgdHU8MCMg1wXxN1/ybWPRIPnknAkuFXqUzhE/4Ew/JT61eltIrf4Z6jZ6vexI8thKt1cy8KhdCMnA6DIH4VBrGj22s/DSxtNMuIpXgs4nspo+VfagAxnswGPxrG+EHigT203h25bbLbgy2qsedmfmT/gJ/QiszxR4W8UzeKLy8hsLi5DXJmhuIJE+7/AME5BUAD8PeoJLf4lPE0RtL5onG1kcQMrD0IPWojbfFMRrHHBepGowqKIAFHYADpVDw14J8aWXi6w1FtPmgK3IllmkkXofv5wecgmv/2Q==";
	
	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Bkwpkbxxkz getBkwpkbxxkz() {
		return bkwpkbxxkz;
	}
	
	public List getLBkwpkbxxkz() {
		return lBkwpkbxxkz;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBkwpkbxxkzService(IBkwpkbxxkzService bkwpkbxxkzService) {
		this.bkwpkbxxkzService = bkwpkbxxkzService;
	}
	
	public void setBkclkzService(IBkclkzService bkclkzService) {
		this.bkclkzService = bkclkzService;
	}
	
	public void setBksjkzService(IBksjkzService bksjkzService) {
		this.bksjkzService = bksjkzService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("bjxxid2");
		lPro.add("bkwpjbxxkzid");
		lPro.add("hylbdm");
		lPro.add("hylb");
		lPro.add("bkwplxdm");
		lPro.add("bkwplx");
		lPro.add("bkwpmc");
		lPro.add("bkwpms");
		lPro.add("fwdw");
		lPro.add("fwdwbm");
		lPro.add("ajlbbm");
		lPro.add("ajlb");
		lPro.add("tbbh");
		lPro.add("tbsj2");
		lPro.add("jyaq");
		lPro.add("cljg");
		lPro.add("bkr");
		lPro.add("bkczy");
		lPro.add("bkczsj");
		lPro.add("bkdqsj");
		lPro.add("bkfwbm");
		lPro.add("bkfw");
		lPro.add("bkspyj");
		lPro.add("lxr");
		lPro.add("lxfs");
		lPro.add("sftyfb");
		lPro.add("spdw");
		lPro.add("spr2");
		lPro.add("sprq");
		lPro.add("qqckbs");
		lPro.add("ckbs");
		lPro.add("ckyy");
		lPro.add("cksj");
		lPro.add("ckr");
		lPro.add("ckczy");
		lPro.add("ckczsj");
		lPro.add("ckbmbm");
		lPro.add("ckbmmc");
		lPro.add("ckspdw");
		lPro.add("ckspr");
		lPro.add("ckspyj");
		lPro.add("cksprq");
		lPro.add("xzqh");
		lPro.add("fsbs");
		lPro.add("bkdxzp");
		lPro.add("wpjp");

    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Bkwpkbxxkz getBkwpkbxxkz=new Bkwpkbxxkz();
    	
        this.setData(getBkwpkbxxkz,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
        Bkwpkbxxkz setBkwpkbxxkz=new Bkwpkbxxkz();
        Map map = new HashMap();
        Page page = bkwpkbxxkzService.getListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lBkwpkbxxkz=page.getData();
        setTabledata(lBkwpkbxxkz); 
		 this.result="success";
        return "success";
    }
	
	public String query() throws Exception{
		try {
			// 布控物品基本信息取得
			Bkwpkbxxkz setBkwpkbxxkz=new Bkwpkbxxkz();
			setBkwpkbxxkz=(Bkwpkbxxkz)this.setClass(setBkwpkbxxkz, null);
			setBkwpkbxxkz=bkwpkbxxkzService.getBkwpkbxxkz(setBkwpkbxxkz);
			// 布控车辆信息取得
			Bkclkz setBkclkz=new Bkclkz();
			setBkclkz.setBjxxid2(setBkwpkbxxkz.getBjxxid2());
			setBkclkz=bkclkzService.getBkclkz(setBkclkz);
			// 布控手机信息取得
			Bksjkz setBksjkz=new Bksjkz();
			setBksjkz.setBjxxid2(setBkwpkbxxkz.getBjxxid2());
			setBksjkz=bksjkzService.getBksjkz(setBksjkz);
			setBkwpkbxxkz.setBkclkz(setBkclkz);
			setBkwpkbxxkz.setBksjkz(setBksjkz);
			
			
	        if(lBkwpkbxxkz != null){
	            lBkwpkbxxkz.clear();
	        }else{
	        	lBkwpkbxxkz = new ArrayList();
	        }
	        
	        lBkwpkbxxkz.add(setBkwpkbxxkz);
			this.result = "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = "";
		}
        return "success";
    }
	
	// 根据报警信息ID查询物品照片
	public void queryZp() throws Exception {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest requeset = ServletActionContext.getRequest();
			String bjxxid2 = requeset.getParameter("bjxxid2");

			Bkwpkbxxkz setBkwpkbxxkz=new Bkwpkbxxkz();
			setBkwpkbxxkz.setBjxxid2(Integer.valueOf(bjxxid2));
			setBkwpkbxxkz = bkwpkbxxkzService.getBkwpkbxxkz(setBkwpkbxxkz);

			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			OutputStream out = response.getOutputStream();
			byte[] by;
			if (setBkwpkbxxkz != null) {
				by = setBkwpkbxxkz.getBkdxzp();
				if (by == null || by.length == 0) {
					sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
					by = base64Decoder.decodeBuffer(picConTemp);
				}
				out.write(by);
			} else {
				sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
				by = base64Decoder.decodeBuffer(picConTemp);
				out.write(by);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String insert() throws Exception{
		try {
			Bkwpkbxxkz setBkwpkbxxkz=new Bkwpkbxxkz();
			bkwpkbxxkz=(Bkwpkbxxkz)this.setClass(setBkwpkbxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bkwpkbxxkz=bkwpkbxxkzService.insertBkwpkbxxkz(bkwpkbxxkz);
        this.result="success";
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Bkwpkbxxkz setBkwpkbxxkz=new Bkwpkbxxkz();
			bkwpkbxxkz=(Bkwpkbxxkz)this.setClass(setBkwpkbxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bkwpkbxxkzService.updateBkwpkbxxkz(bkwpkbxxkz);
        this.result="success";
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Bkwpkbxxkz setBkwpkbxxkz=new Bkwpkbxxkz();
			bkwpkbxxkz=(Bkwpkbxxkz)this.setClass(setBkwpkbxxkz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bkwpkbxxkzService.deleteBkwpkbxxkz(bkwpkbxxkz);
        this.result="success";
        return "success";
    }
}