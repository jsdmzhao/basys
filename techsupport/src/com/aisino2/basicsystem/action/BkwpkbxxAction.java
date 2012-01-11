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

import com.aisino2.basicsystem.domain.Bkcl;
import com.aisino2.basicsystem.domain.Bksj;
import com.aisino2.basicsystem.domain.Bkwpkbxx;
import com.aisino2.basicsystem.service.IBkwpkbxxService;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class BkwpkbxxAction extends PageAction{
	private IBkwpkbxxService bkwpkbxxService;
	private List lBkwpkbxx=new ArrayList();
	private Bkwpkbxx bkwpkbxx=new Bkwpkbxx();
	private String tabledata="";
	private int totalrows=0;
	private String result="";
	private User user;
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

	public Bkwpkbxx getBkwpkbxx() {
		return bkwpkbxx;
	}
	
	public List getLBkwpkbxx() {
		return lBkwpkbxx;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setBkwpkbxxService(IBkwpkbxxService bkwpkbxxService) {
		this.bkwpkbxxService = bkwpkbxxService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro = new ArrayList();
		lPro.add("bkwpjbxxid");
		lPro.add("bkwpmc");
		lPro.add("bkwplx");
		lPro.add("fwdw");
		lPro.add("bkfw");
		lPro.add("bkczsj");
		lPro.add("bkdqsj");
    	
		List lModify = new ArrayList();
		List lDel = new ArrayList();
		List lSH = new ArrayList();
		List lCol = new ArrayList();
		// 布控管理
		if ("1".equals(bkwpkbxx.getCmdID())){
    	    lModify.add("setModifyQuery");
    	    lModify.add("修改");
    	    lCol.add(lModify);    
		} else if("2".equals(bkwpkbxx.getCmdID())){// 撤控管理
			lDel.add("ckQuery");
			lDel.add("撤控");
			lCol.add(lDel);
		} else if("4".equals(bkwpkbxx.getCmdID())){// 审核
			lSH.add("shQuery");
			lSH.add("审核");
			lCol.add(lSH);
		}
    	
    	Bkwpkbxx getBkwpkbxx=new Bkwpkbxx();
    	
        this.setData(getBkwpkbxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try{
			Bkwpkbxx setBkwpkbxx=new Bkwpkbxx();
	        Map map = new HashMap();
	        
	        bkwpkbxx = (Bkwpkbxx) this.setClass(setBkwpkbxx, null);
	        map.put("hylbdm", bkwpkbxx.getHylbdm());
	        // 如果选择了姓名拼音的同音查询，则需要得到姓名的拼音
			if ("1".equals(bkwpkbxx.getTyCheck())) {
				map.put("wpqp", PinYinUtil.getHanyuPingYin(bkwpkbxx.getBkwpmc()));
				map.put("bkwpmc", "");
			} else{
				map.put("bkwpmc", bkwpkbxx.getBkwpmc());
			}
			map.put("bkwplxdm", bkwpkbxx.getBkwplxdm());
			map.put("bkczsjks", bkwpkbxx.getBkczsjks());
			map.put("bkczsjjs", bkwpkbxx.getBkczsjjs());
			map.put("bkfwbm", bkwpkbxx.getBkfwbm());
			if ("1".equals(bkwpkbxx.getBkwplxdm())){
			    map.put("sjch", bkwpkbxx.getSjch());
			    map.put("pp", bkwpkbxx.getPp());
			    map.put("xh", bkwpkbxx.getXh());
			}
			if ("2".equals(bkwpkbxx.getBkwplxdm())){
			    map.put("clpp", bkwpkbxx.getClpp());
			    map.put("clxh", bkwpkbxx.getClxh());
			    map.put("hphm", bkwpkbxx.getHphm());
			    map.put("fdjh", bkwpkbxx.getFdjh());
			    map.put("cjh", bkwpkbxx.getCjh());
			}
			if("1".equals(bkwpkbxx.getCmdID()) || "3".equals(bkwpkbxx.getCmdID())){
			    // 是否通过审核  不需要审核的认为审核通过
			    map.put("shjg", bkwpkbxx.getShjg());
			    map.put("ckbs", bkwpkbxx.getCkbs());
			}
			// 撤控管理时，只检索未撤控的信息	
			if("2".equals(bkwpkbxx.getCmdID())){
			    map.put("ckbs", "0");
			    map.put("shjg", bkwpkbxx.getShjg());
			}
			// 布控审核时，只检索未审核的信息
			if("4".equals(bkwpkbxx.getCmdID())){
				map.put("shjg", "0");
				map.put("ckbs", bkwpkbxx.getCkbs());
			}
	        
	        //根据登陆用户 设置查询条件  只能查询本部门和所属部门的信息
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			HttpSession session= request.getSession();
			user= (User)session.getAttribute(Constants.userKey);
			String depertCode0 = StringUtil.trimEven0(user.getDepartment().getDepartcode());
			if("1".equals(bkwpkbxx.getCmdID())){//布控管理，只能修改本单位的
				map.put("fwdwbm", user.getDepartment().getDepartcode());
			}else{
				map.put("fwdwbm1", depertCode0);
			}
			// 高级查询条件
        	map.put("superbWhere", bkwpkbxx.getSuperbWhere()); 
			map.put("superbOrderBy", bkwpkbxx.getSuperbOrderBy());
	        Page page = bkwpkbxxService.getListForPage(map, pagesize, pagerow,sort,dir);
	        totalpage=page.getTotalPages();
	        totalrows=page.getTotalRows();
	        lBkwpkbxx=page.getData();
	        setTabledata(lBkwpkbxx); 
	        
	        this.result="success";
			return "success";
        } catch (Exception e) {
        	// TODO Auto-generated catch block
    		e.printStackTrace();
    		 this.result="";
    	     return "success";
	     }
    }
	
	public String query() throws Exception{
		try {
			Bkwpkbxx setBkwpkbxx=new Bkwpkbxx();
			bkwpkbxx=(Bkwpkbxx)this.setClass(setBkwpkbxx, null);
			bkwpkbxx=bkwpkbxxService.getBkwpkbxx(bkwpkbxx);
			if (lBkwpkbxx != null){
				lBkwpkbxx.clear();
			} else{
				lBkwpkbxx = new ArrayList();
			}
			/*String fileload = null;
			byte[] bkdxzp = bkwpkbxx.getBkdxzp();
			if (bkdxzp != null && bkdxzp.length > 0) {
				sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
				fileload = base64Encoder.encode(bkdxzp);

				StringReader sr = new StringReader(fileload);
				BufferedReader br = new BufferedReader(sr);
				String line = null;
				String temp = "";
				while ((line = br.readLine()) != null) {
					temp += line;
				}
				fileload = temp;
			}
			bkwpkbxx.setFileload("");*/
			bkwpkbxx.setBkdxzp(null);
			lBkwpkbxx.add(bkwpkbxx);
			
			this.result="success";
	        return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
   	        return "success";
		}
    }
	
	public String insert() throws Exception{
		try {
			// 布控物品信息取得
			Bkwpkbxx setBkwpkbxx=new Bkwpkbxx();
			bkwpkbxx=(Bkwpkbxx)this.setClass(setBkwpkbxx, null);
			
			// 行业类别代码
			//bkwpkbxx.setHylbdm("E");
			// 行业类别
			//bkwpkbxx.setHylb("典当业");
			
			// 照片类型转换
			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
			if (bkwpkbxx.getFileload() != null) {
				byte[] bkdxzp = base64Decoder.decodeBuffer(bkwpkbxx.getFileload());
				bkwpkbxx.setBkdxzp(bkdxzp);
			}
			// 设定审核结果
			setSHJG();
		    // 发文单位编码设置
		    bkwpkbxx.setFwdwbm(user.getDepartment().getDepartcode());
		    // 物品简拼设置
		    bkwpkbxx.setWpjp(PinYinUtil.getHanyuPingYinInitial(bkwpkbxx.getBkwpmc()));
		    // 物品全拼设置
		    bkwpkbxx.setWpqp(PinYinUtil.getHanyuPingYin(bkwpkbxx.getBkwpmc()));
		    // 未撤控
		    bkwpkbxx.setCkbs("0");
		    
		    // 根据布控类型设置相应的物品信息
		    doWithBKLX();
		    
		    // 执行布控物品信息插入操作
		    bkwpkbxx=bkwpkbxxService.insertBkwpkbxx(bkwpkbxx);
		    // 释放内存
		    bkwpkbxx = null;
		    this.result="success";
	        return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
	        return "success";
		}
    }
	
	public String modify() throws Exception{
		try {
			// 布控物品信息取得
			Bkwpkbxx setBkwpkbxx=new Bkwpkbxx();
			bkwpkbxx=(Bkwpkbxx)this.setClass(setBkwpkbxx, null);
			
			// 照片类型转换
			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
			if (bkwpkbxx.getFileload() != null && !"".equals(bkwpkbxx.getFileload())) {
				byte[] bkdxzp = base64Decoder.decodeBuffer(bkwpkbxx.getFileload());
				bkwpkbxx.setBkdxzp(bkdxzp);
			}
			
			// 设定审核结果
			setSHJG();
			
		    // 物品简拼
		    bkwpkbxx.setWpjp(PinYinUtil.getHanyuPingYinInitial(bkwpkbxx.getBkwpmc()));
		    // 物品全拼设置
		    bkwpkbxx.setWpqp(PinYinUtil.getHanyuPingYin(bkwpkbxx.getBkwpmc()));
		    
		    // 根据布控类型设置相应的物品信息
		    doWithBKLX();
		    
		    // 执行布控物品信息修改操作
		    bkwpkbxxService.updateBkwpkbxx(bkwpkbxx);
		    // 释放内存
		    bkwpkbxx = null;
		    this.result="success";
	        return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
	        return "success";
		}
    }
	
	public String delete() throws Exception{
		try {
			Bkwpkbxx setBkwpkbxx=new Bkwpkbxx();
			bkwpkbxx=(Bkwpkbxx)this.setClass(setBkwpkbxx, null);
			
			bkwpkbxxService.deleteBkwpkbxx(bkwpkbxx);
	        this.result="success";
	        return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
	        return "success";
		}
    }
	
	// 根据布控id查询物品照片
	public void queryZp() throws Exception {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest requeset = ServletActionContext.getRequest();
			String bkwpjbxxid = requeset.getParameter("bkwpjbxxid");

			Bkwpkbxx setBkwpkbxx=new Bkwpkbxx();
			setBkwpkbxx.setBkwpjbxxid(Integer.valueOf(bkwpjbxxid));
			setBkwpkbxx = bkwpkbxxService.getBkwpkbxx(setBkwpkbxx);

			response.setCharacterEncoding("UTF-8");
			response.setContentType("image/jpeg");
			OutputStream out = response.getOutputStream();
			byte[] by;
			if (setBkwpkbxx != null) {
				by = setBkwpkbxx.getBkdxzp();
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
	
	public String ckUpdate() throws Exception{
		try {
			// 布控物品信息取得
			Bkwpkbxx setBkwpkbxx=new Bkwpkbxx();
			bkwpkbxx=(Bkwpkbxx)this.setClass(setBkwpkbxx, null);
			
		    // 执行布控物品基本信息修改操作
		    bkwpkbxxService.updateBkwpkbxxOne(bkwpkbxx);
		    
		    this.result="success";
	        return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result="";
	        return "success";
		}
	}
	
	private void doWithBKLX() throws Exception{
		// 物品类型
		String wplx = "";
		// 布控车辆
		Bkcl bkcl;
		// 布控手机
		Bksj bksj;
		
		// 物品类型取得(0.一般物品；2.车辆；1.手机)
	    wplx = bkwpkbxx.getBkwplxdm();
	    if ("2".equals(wplx)){
	    	bkcl = new Bkcl();
	    	bkcl.setCllxdm(bkwpkbxx.getCllxdm());
	    	bkcl.setCllx(bkwpkbxx.getCllx());
	    	bkcl.setClpp(bkwpkbxx.getClpp());
	    	bkcl.setClxh(bkwpkbxx.getClxh());
	    	bkcl.setHphm(bkwpkbxx.getHphm());
	    	bkcl.setSyr(bkwpkbxx.getSyr());
	    	bkcl.setFdjh(bkwpkbxx.getFdjh());
	    	bkcl.setCjh(bkwpkbxx.getCjh());
	    	bkcl.setCsys(bkwpkbxx.getCsys());
	    	bkcl.setCcdjrq(bkwpkbxx.getCcdjrq());
	    	bkwpkbxx.setBkcl(bkcl);
	    } else if("1".equals(wplx)){
	    	bksj = new Bksj();
	    	bksj.setPp(bkwpkbxx.getPp());
	    	bksj.setXh(bkwpkbxx.getXh());
	    	bksj.setSjch(bkwpkbxx.getSjch());
	    	bksj.setYs(bkwpkbxx.getYs());
	    	bkwpkbxx.setBksj(bksj);
	    } else{
	    	bkwpkbxx.setBkcl(null);
	    	bkwpkbxx.setBksj(null);
	    }
	}
	
	private void setSHJG() throws Exception{
		// 用户级别
		String deptLeve = "";
		// 布控范围编码
		String bkfwbm = "";
		
		// 当前用户信息取得
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		user= (User)session.getAttribute(Constants.userKey);
		// 当前用户的级别 2为省级用户
		deptLeve = user.getDepartment().getDepartlevel().toString();
		// 布控范围编码取得
	    bkfwbm = bkwpkbxx.getBkfwbm();
	    if(Integer.parseInt(deptLeve)<=2){
	    	if("2".equals(bkfwbm)){
	    		// 省级布控省级
	    		String bk_sbks_sh = this.getCacheGlobalpar("bk_sbks_sh").getGlobalparvalue(); ///全局变量 得到是否需要审核
	    		if("0".equals(bk_sbks_sh)){
	    			bkwpkbxx.setShjg("1");
	    		}else if("1".equals(bk_sbks_sh)){
	    			bkwpkbxx.setShjg("0");
	    		}
	    	} 	
	    }else{
	    	if("2".equals(bkfwbm)){
	    		// 地区布控省级
	    		String bk_bbks_sh = this.getCacheGlobalpar("bk_bbks_sh").getGlobalparvalue(); ///全局变量 得到是否需要审核
	    		if("0".equals(bk_bbks_sh)){
	    			bkwpkbxx.setShjg("1");
	    		}else if("1".equals(bk_bbks_sh)){
	    			bkwpkbxx.setShjg("0");
	    		}
	    	}else if("1".equals(bkfwbm)){
	    		///地区布控地区
	    		String bk_bbkb_sh = this.getCacheGlobalpar("bk_bbkb_sh").getGlobalparvalue(); ///全局变量 得到是否需要审核
	    		if("0".equals(bk_bbkb_sh)){
	    			bkwpkbxx.setShjg("1");
	    		}else if("1".equals(bk_bbkb_sh)){
	    			bkwpkbxx.setShjg("0");
	    		}
	    	}
	    }
	}
	
}