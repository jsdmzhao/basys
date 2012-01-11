package com.aisino2.basicsystem.action;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Bkry_kz;
import com.aisino2.basicsystem.service.IBkry_kzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;

public class Bkry_kzAction extends PageAction {
	private IBkry_kzService bkry_kzService;
	private List lBkry_kz;
	private Bkry_kz bkry_kz;
	private String tabledata;
	private int totalrows;
	private String result = "";
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

	public Bkry_kz getBkry_kz() {
		return bkry_kz;
	}

	public List getLBkry_kz() {
		return lBkry_kz;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setBkry_kzService(IBkry_kzService bkry_kzService) {
		this.bkry_kzService = bkry_kzService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bjgzid");
		lPro.add("bjxxid");
		lPro.add("bkryid");
		lPro.add("bkrykzid");
		lPro.add("tbbh");
		lPro.add("xm");
		lPro.add("cym");
		lPro.add("gmsfhm");
		lPro.add("xmpy");
		lPro.add("jgdm");
		lPro.add("jg");
		lPro.add("csrq");
		lPro.add("xbdm");
		lPro.add("xb");
		lPro.add("mzdm");
		lPro.add("minzu");
		lPro.add("kybm");
		lPro.add("ky");
		lPro.add("shengao");
		lPro.add("tzbm");
		lPro.add("tz");
		lPro.add("ttbm");
		lPro.add("tt");
		lPro.add("yz");
		lPro.add("zz");
		lPro.add("fwdw");
		lPro.add("fwdwbm");
		lPro.add("ajlbbm");
		lPro.add("ajlb");
		lPro.add("tbsj");
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
		lPro.add("spr");
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
		lPro.add("xzqhbm");
		lPro.add("xzqh");
		lPro.add("fsbs");
		lPro.add("bkdxzp");

		List lModify = new ArrayList();
		lModify.add("setModifyQuery");
		lModify.add("修改");

		List lDel = new ArrayList();
		lDel.add("setDelete");
		lDel.add("删除");

		List lCol = new ArrayList();
		lCol.add(lModify);
		lCol.add(lDel);

		Bkry_kz getBkry_kz = new Bkry_kz();

		this.setData(getBkry_kz, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}

	public String querylist() throws Exception {
		Bkry_kz setBkry_kz = new Bkry_kz();
		Map map = new HashMap();
		Page page = bkry_kzService.getListForPage(map, pagesize, pagerow, sort, dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBkry_kz = page.getData();
		setTabledata(lBkry_kz);
		this.result = "success";
		return "success";
	}

	public String query() throws Exception {
		try {
			Bkry_kz setBkry_kz = new Bkry_kz();
			bkry_kz = (Bkry_kz) this.setClass(setBkry_kz, null);
			
			bkry_kz = bkry_kzService.getBkry_kz(bkry_kz);
			if(bkry_kz == null)
				bkry_kz = new Bkry_kz();
			
			bkry_kz.setBkdxzp(null);
			lBkry_kz = new ArrayList();
			lBkry_kz.add(bkry_kz);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bkry_kz = null;
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Bkry_kz setBkry_kz = new Bkry_kz();
			bkry_kz = (Bkry_kz) this.setClass(setBkry_kz, null);

			bkry_kz = bkry_kzService.insertBkry_kz(bkry_kz);

			// 照片
			HttpServletResponse response = ServletActionContext.getResponse();
			byte[] pic = null;

			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			OutputStream out = response.getOutputStream();

			pic = bkry_kz.getBkdxzp();
			if (pic != null && pic.length > 0) {
				if (pic == null || pic.length == 0) {
					sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
					pic = base64Decoder.decodeBuffer(picConTemp);
				}
				out.write(pic);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Bkry_kz setBkry_kz = new Bkry_kz();
			bkry_kz = (Bkry_kz) this.setClass(setBkry_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bkry_kzService.updateBkry_kz(bkry_kz);
		this.result = "success";
		return "success";
	}

	public String delete() throws Exception {
		try {
			Bkry_kz setBkry_kz = new Bkry_kz();
			bkry_kz = (Bkry_kz) this.setClass(setBkry_kz, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bkry_kzService.deleteBkry_kz(bkry_kz);
		this.result = "success";
		return "success";
	}

	public void queryZp() throws Exception {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest requeset = ServletActionContext.getRequest();
			String bjxxid = requeset.getParameter("bjxxid");

			Bkry_kz zp = new Bkry_kz();
			zp.setBjxxid(Integer.parseInt(bjxxid));
			zp = bkry_kzService.getBkry_kz(zp);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			OutputStream out = response.getOutputStream();
			byte[] bt;
			if (zp != null) {
				bt = zp.getBkdxzp();
				if (bt== null || bt.length == 0) {
					sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
					bt= base64Decoder.decodeBuffer(picConTemp);
				}
				out.write(bt);
			} else {
				sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
				bt= base64Decoder.decodeBuffer(picConTemp);
				out.write(bt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}