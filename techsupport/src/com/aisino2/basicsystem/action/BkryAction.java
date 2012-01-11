package com.aisino2.basicsystem.action;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Bkry;
import com.aisino2.basicsystem.service.IBkryService;
import com.aisino2.common.ImageUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class BkryAction extends PageAction {
	private IBkryService bkryService;

	private List lBkry = new ArrayList();

	private Bkry bkry;

	private String tabledata;

	private int totalrows;

	private String strResult;

	private String result = "";

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}

	public String getTabledata() {
		return tabledata;
	}

	public Bkry getBkry() {
		return bkry;
	}

	public List getLBkry() {
		return lBkry;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setBkryService(IBkryService bkryService) {
		this.bkryService = bkryService;
	}

	public void setTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bkryid");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("csrq");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("jg");
		lPro.add("bkfw");
		lPro.add("bkczsj");
		lPro.add("bkdqsj");

		// 这里需要根据flag参数来决定操作那要些什么项目
		Bkry setBkry = new Bkry();
		bkry = (Bkry) this.setClass(setBkry, null);
		String flag = bkry.getFlag();
		List lModify = new ArrayList();
		List lDel = new ArrayList();
		List lCol = new ArrayList();
		
		Bkry getBkry = new Bkry();
		// 如果是管理菜单，则加入操作项
		if ("manage".equals(flag)) {
			lModify.add("setModify");
			lModify.add("修改");
			lModify.add("ckbs");
			lModify.add("0");
			
			lDel.add("setDel");
			lDel.add("删除");
			
			lCol.add(lModify);
			lCol.add(lDel);
			this.setDataCustomer(getBkry, lData, lPro, null, lCol);
			// 如果是注销页面，则只要加入注销标识,查询菜单没有操作项
		} else if ("cancel".equals(flag)) {
			lDel.add("setModifyQuery");
			lDel.add("撤控");
			lCol.add(lDel);
			this.setData(getBkry, lData, lPro, lCol);
		}else{
			this.setData(getBkry, lData, lPro, lCol);
		}
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	/**境外布控人员列表*/
	public void setJwTabledata(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bkryid");
		lPro.add("zwm");
		lPro.add("ywm");
		lPro.add("ywx");
		lPro.add("zjhm");
		lPro.add("csrq");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("bkfw");
		lPro.add("bkczsj");
		lPro.add("bkdqsj");

		// 这里需要根据flag参数来决定操作那要些什么项目
		Bkry setBkry = new Bkry();
		bkry = (Bkry) this.setClass(setBkry, null);
		String flag = bkry.getFlag();
		List lModify = new ArrayList();
		List lDel = new ArrayList();
		List lCol = new ArrayList();
		Bkry getBkry = new Bkry();
		// 如果是管理菜单，则加入操作项
		if ("manage".equals(flag)) {
			lModify.add("setModify");
			lModify.add("修改");
			lModify.add("ckbs");
			lModify.add("0");
			
			lDel.add("setDel");
			lDel.add("删除");
			
			lCol.add(lModify);
			lCol.add(lDel);
			this.setDataCustomer(getBkry, lData, lPro, null, lCol);
			// 如果是注销页面，则只要加入注销标识,查询菜单没有操作项
		} else if ("cancel".equals(flag)) {
			lDel.add("setModifyQuery");
			lDel.add("撤控");
			lCol.add(lDel);
			this.setData(getBkry, lData, lPro, lCol);
		}else{
			this.setData(getBkry, lData, lPro, lCol);
		}

		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	
	
	public String querylist() throws Exception {
		Bkry setBkry = new Bkry();
		bkry = (Bkry) this.setClass(setBkry, null);
		
		String flag = bkry.getFlag();
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
		int Departlevel=user.getDepartment().getDepartlevel();
		
		Map map = new HashMap();
		map.put("xm", bkry.getXm());
		map.put("xbdm", bkry.getXb());
		if("query".equals(flag)){
			if(Departlevel>2){
				map.put("fwdwbmde", StringUtil.trimEven0(bkry.getFwdwbm()));
			}else{
				map.put("fwdwbmde1", "sss");
			}
		}else{
		  map.put("fwdwbm", bkry.getFwdwbm());
		}
		map.put("csrq", bkry.getCsrq());
		map.put("csrq2", bkry.getCsrq2());
		map.put("jgdm", bkry.getJgdm());
		map.put("gmsfhm", bkry.getGmsfhm());
		map.put("bkczsj", bkry.getBkczsj());
		map.put("bkczsj2", bkry.getBkczsj2());
		map.put("bkfwbm", bkry.getBkfw());
		map.put("jgdm", bkry.getJgdm());
		map.put("bkrylxdm", "1");//代表国内布控
		
		map.put("shsftgQuery", bkry.getShsftg());  //是否通过审核  不需要审核的认为审核通过
		
		map.put("hylbdm", bkry.getHylbdm());  ///行业类别代码
		
		//撤控的时候才有默认条件为未撤控
		if("cancel".equals(bkry.getFlag()))
		map.put("ckbs", "0");
		// 如果选择了姓名拼音的同音查询，则需要得到姓名的拼音
		if ("1".equals(bkry.getTyCheck())) {
			map.put("xmpy", PinYinUtil.getHanyuPingYin(bkry.getXm()));
			map.put("xm", "");
		}
		Page page = bkryService.getListForPage(map, pagesize, pagerow, sort,
				dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBkry = page.getData();
		setTabledata(lBkry);
		this.result = "success";
		return "success";
	}
/**
 * 境外人员的布控查询
 * */
	public String querylistJw() throws Exception {
		Bkry setBkry = new Bkry();
		bkry = (Bkry) this.setClass(setBkry, null);
		String flag = bkry.getFlag();
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
		int Departlevel=user.getDepartment().getDepartlevel();
		
		Map map = new HashMap();
		map.put("xbdm", bkry.getXb());
		//map.put("fwdwbm", bkry.getFwdwbm());
		if("query".equals(flag)){
			 if(Departlevel>2){
				map.put("fwdwbmde", StringUtil.trimEven0(bkry.getFwdwbm()));
			 }else{
				map.put("fwdwbmde1", "sss");
			 }
			  
		}else{
		  map.put("fwdwbm", bkry.getFwdwbm());
		}
		map.put("csrq", bkry.getCsrq());
		map.put("csrq2", bkry.getCsrq2());
		map.put("gjdm", bkry.getGjdm());
		map.put("zjhm", bkry.getZjhm());
		map.put("bkczsj", bkry.getBkczsj());
		map.put("bkczsj2", bkry.getBkczsj2());
		map.put("bkfwbm", bkry.getBkfw());
		map.put("zwm", bkry.getZwm());
		map.put("ywx", bkry.getYwx());
		map.put("ywm", bkry.getYwm());
		map.put("bkrylxdm", "0");//代表境外布控
		
		map.put("shsftgQuery", bkry.getShsftg());  //是否通过审核  不需要审核的认为审核通过
		
		map.put("hylbdm", bkry.getHylbdm());  ///行业类别代码
		
		//撤控的时候才有默认条件为未撤控
		if("cancel".equals(bkry.getFlag()))
		map.put("ckbs", "0");
		Page page = bkryService.getJwListForPage(map, pagesize, pagerow, sort,
				dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBkry = page.getData();
		setJwTabledata(lBkry);
		this.result = "success";
		return "success";
	}
	public String query() throws Exception {
		try {
			Bkry setBkry = new Bkry();
			bkry = (Bkry) this.setClass(setBkry, null);

			bkry = bkryService.getBkry(bkry);
			// 判断lBkry 是否为空，如果为空则应该初始化
			if (lBkry != null)
				lBkry.clear();
			else
				lBkry = new ArrayList();
			
			bkry.setBkdxzp(null);
			lBkry.add(bkry);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bkry = null;
		this.result = "success";
		return "success";
	}

	public String insert() throws Exception {
		try {
			Bkry setBkry = new Bkry();
			bkry = (Bkry) this.setClass(setBkry, null);
			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
			if (bkry.getFileload() != null) {
				byte[] bkdxzp = base64Decoder.decodeBuffer(bkry.getFileload());
				bkry.setBkdxzp(bkdxzp);
			}
			
			String deptLeve = bkry.getDeptLeve();  ///用户部门的级别 2为省级用户 
		    String bkfwbm = bkry.getBkfwbm();      /// 布控范围编码
		    if(Integer.parseInt(deptLeve)<=2){
		    	if("2".equals(bkfwbm)){
		    		////省级布控省级
		    		String bk_sbks_sh = this.getCacheGlobalpar("bk_sbks_sh").getGlobalparvalue(); ///全局变量 得到是否需要审核
		    		if("0".equals(bk_sbks_sh)){
		    			bkry.setSfxysh("0");
		    			bkry.setShsftg("1");
		    		}else if("1".equals(bk_sbks_sh)){
		    			bkry.setSfxysh("1");
		    			bkry.setShsftg("0");
		    		}
		    	} 	
		    }else{
		    	if("2".equals(bkfwbm)){
		    		////地区布控省级
		    		String bk_bbks_sh = this.getCacheGlobalpar("bk_bbks_sh").getGlobalparvalue(); ///全局变量 得到是否需要审核
		    		if("0".equals(bk_bbks_sh)){
		    			bkry.setSfxysh("0");
		    			bkry.setShsftg("1");
		    		}else if("1".equals(bk_bbks_sh)){
		    			bkry.setSfxysh("1");
		    			bkry.setShsftg("0");
		    		}
		    	}else if("1".equals(bkfwbm)){
		    		///地区布控地区
		    		String bk_bbkb_sh = this.getCacheGlobalpar("bk_bbkb_sh").getGlobalparvalue(); ///全局变量 得到是否需要审核
		    		if("0".equals(bk_bbkb_sh)){
		    			bkry.setSfxysh("0");
		    			bkry.setShsftg("1");
		    		}else if("1".equals(bk_bbkb_sh)){
		    			bkry.setSfxysh("1");
		    			bkry.setShsftg("0");
		    		}
		    	}
		    	
		    }
			
		    String bkrylxdm = bkry.getBkrylxdm(); /////布控人员类型代码  0为国外人员  1为国内人员
		    if("1".equals(bkrylxdm)){
		    	bkry.setZjhm(bkry.getGmsfhm());   ////证件号码 写入公民身份证号码
		    	bkry.setZjlx("公民身份号码");
		    }
		    
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bkry = bkryService.insertBkry(bkry);
		this.result = "success";
		return "success";
	}

	public String modify() throws Exception {
		try {
			Bkry setBkry = new Bkry();
			bkry = (Bkry) this.setClass(setBkry, null);
			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
			String fileload = bkry.getFileload();
			if ( fileload!= null && !fileload.equals("")) {
				byte[] bkdxzp = base64Decoder.decodeBuffer(fileload);
				bkry.setBkdxzp(bkdxzp);
			}
			bkryService.updateBkry(bkry);
			this.result = "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";
	}

	public String delete() throws Exception {
		try {
			Bkry setBkry = new Bkry();
			bkry = (Bkry) this.setClass(setBkry, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bkryService.deleteBkry(bkry);
		this.result = "success";
		return "success";
	}

	public String validateZjhm() {
		try {
			Bkry setBkry = new Bkry();
			bkry = (Bkry) this.setClass(setBkry, null);
			bkry.setCkbs("0"); //已撤控
			boolean result = bkryService.validateZjhm(bkry);
			strResult = "";
			if (result) {
				strResult = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.result = "";
			return "success";
		}
		this.result = "success";
		return "success";
	}

	// 根据布控id查询旅客照片
	public void queryZp() throws Exception {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest requeset = ServletActionContext.getRequest();
			String bkryid = requeset.getParameter("bkryid");

			Bkry bkryTp = new Bkry();
			bkryTp.setBkryid(Integer.valueOf(bkryid));
			Bkry bkryZp = bkryService.getBkry(bkryTp);

			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			OutputStream out = response.getOutputStream();
			byte[] by;
			if (bkryZp != null) {
				by = bkryZp.getBkdxzp();
				if (by == null || by.length == 0) {
					sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
					by = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
				}
				out.write(by);
			} else {
				sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
				by = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
				out.write(by);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getStrResult() {
		return strResult;
	}

	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}
	
	/**
	 * 布控管理  审核列表
	 * @return
	 * @throws Exception
	 */
	public String querylistSh() throws Exception {
		Bkry setBkry = new Bkry();
		bkry = (Bkry) this.setClass(setBkry, null);
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
		int Departlevel=user.getDepartment().getDepartlevel();
		
		Map map = new HashMap();
		map.put("xm", bkry.getXm());
		map.put("xbdm", bkry.getXb());
		//map.put("fwdwbm", bkry.getFwdwbm());

		if(Departlevel>2){
			map.put("fwdwbmde", StringUtil.trimEven0(bkry.getFwdwbm()));
		}else{
			map.put("fwdwbmde1", "sss");
		}
		
		map.put("csrq", bkry.getCsrq());
		map.put("csrq2", bkry.getCsrq2());
		map.put("jgdm", bkry.getJgdm());
		map.put("gmsfhm", bkry.getGmsfhm());
		map.put("bkczsj", bkry.getBkczsj());
		map.put("bkczsj2", bkry.getBkczsj2());
		map.put("bkfwbm", bkry.getBkfw());
		//map.put("jgdm", bkry.getJgdm());
		map.put("bkrylxdm", "1");//代表国内布控
		map.put("ckbs", "0");//默认条件为未撤控
		
		map.put("sfxysh", "1");//默认条件 需要审核的
		map.put("shsftg", "0");//默认条件 未审核的
		
		map.put("hylbdm", bkry.getHylbdm());  ///行业类别代码
		
		// 如果选择了姓名拼音的同音查询，则需要得到姓名的拼音
		if ("1".equals(bkry.getTyCheck())) {
			map.put("xmpy", PinYinUtil.getHanyuPingYin(bkry.getXm()));
			map.put("xm", "");
		}
		
		Page page = bkryService.getListForPage(map, pagesize, pagerow, sort,
				dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBkry = page.getData();
		setTabledataSh(lBkry);
		this.result = "success";
		return "success";
	}
   
	public void setTabledataSh(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bkryid");
		lPro.add("xm");
		lPro.add("gmsfhm");
		lPro.add("csrq");
		lPro.add("xb");
		lPro.add("minzu");
		lPro.add("jg");
		lPro.add("bkfw");
		lPro.add("bkczsj");
		lPro.add("bkdqsj");
		
		List lDel = new ArrayList();
		List lCol = new ArrayList();
		lDel.add("setModifyQuery");
		lDel.add("审核");
		lCol.add(lDel);
		
		Bkry getBkry = new Bkry();

		this.setData(getBkry, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	
	/**
	 * 境外布控人员
	 * @return
	 * @throws Exception
	 */
	public String querylistJwSh() throws Exception {
		Bkry setBkry = new Bkry();
		bkry = (Bkry) this.setClass(setBkry, null);
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
		int Departlevel=user.getDepartment().getDepartlevel();
		
		Map map = new HashMap();
		map.put("xbdm", bkry.getXb());
		//map.put("fwdwbm", bkry.getFwdwbm());
		
		if(Departlevel>2){
			map.put("fwdwbmde", StringUtil.trimEven0(bkry.getFwdwbm()));
		}else{
			map.put("fwdwbmde1", "sss");
		}
		
		map.put("csrq", bkry.getCsrq());
		map.put("csrq2", bkry.getCsrq2());
		map.put("gjdm", bkry.getGjdm());
		map.put("zjhm", bkry.getZjhm());
		map.put("bkczsj", bkry.getBkczsj());
		map.put("bkczsj2", bkry.getBkczsj2());
		map.put("bkfwbm", bkry.getBkfw());
		map.put("zwm", bkry.getZwm());
		map.put("ywx", bkry.getYwx());
		map.put("ywm", bkry.getYwm());
		map.put("bkrylxdm", "0");//代表境外布控
		
		map.put("ckbs", "0");//默认条件为未撤控    upate cuicui
		map.put("sfxysh", "1");//默认条件 需要审核的 upate cuicui
		map.put("shsftg", "0");//默认条件 未审核的 upate cuicui
		
		//map.put("shsftgQuery", bkry.getShsftg());  //是否通过审核  不需要审核的认为审核通过
		
		map.put("hylbdm", bkry.getHylbdm());  ///行业类别代码
		
		//撤控的时候才有默认条件为未撤控
		if("cancel".equals(bkry.getFlag()))
		map.put("ckbs", "0");
		Page page = bkryService.getJwListForPage(map, pagesize, pagerow, sort,
				dir);
		totalpage = page.getTotalPages();
		totalrows = page.getTotalRows();
		lBkry = page.getData();
		setJwTabledataSh(lBkry);
		this.result = "success";
		return "success";
	}
	
	
	/**境外布控人员 审核 列表*/
	public void setJwTabledataSh(List lData) throws Exception {
		List lPro = new ArrayList();
		lPro.add("bkryid");
		lPro.add("zwm");
		lPro.add("ywm");
		lPro.add("ywx");
		lPro.add("zjhm");
		lPro.add("csrq");
		lPro.add("xb");
		lPro.add("gj");
		lPro.add("bkfw");
		lPro.add("bkczsj");
		lPro.add("bkdqsj");

		
		List lDel = new ArrayList();
		List lCol = new ArrayList();
		lDel.add("setModifyQuery");
		lDel.add("审核");
		lCol.add(lDel);
		

		Bkry getBkry = new Bkry();

		this.setData(getBkry, lData, lPro, lCol);
		this.tabledata = this.getData();
		totalrows = this.getTotalrows();
	}
	
	
}