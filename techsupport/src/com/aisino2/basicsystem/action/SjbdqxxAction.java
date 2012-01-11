package com.aisino2.basicsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.basicsystem.domain.Sjbdqxx;
import com.aisino2.basicsystem.service.ISjbdqxxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

public class SjbdqxxAction extends PageAction{
	private ISjbdqxxService sjbdqxxService;
	private List lSjbdqxx=new ArrayList();
	private Sjbdqxx sjbdqxx=new Sjbdqxx();
	private String tabledata="";
	private int totalrows=0;
	private String result="success";
	private String vsjbdqxxid = "";
	private String vsjch = "";
	private String exitResult = "";
	
	public int getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}
	public String getTabledata() {
		return tabledata;
	}
	public Sjbdqxx getSjbdqxx() {
		return sjbdqxx;
	}
	public List getLSjbdqxx() {
		return lSjbdqxx;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setSjbdqxxService(ISjbdqxxService sjbdqxxService) {
		this.sjbdqxxService = sjbdqxxService;
	}
	public void setVsjbdqxxid(String vsjbdqxxid) {
		this.vsjbdqxxid = vsjbdqxxid;
	}
	public void setVsjch(String vsjch) {
		this.vsjch = vsjch;
	}
	public String getExitResult() {
		return exitResult;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sjbdqxxid");
		lPro.add("sjch");
		lPro.add("pp");
		lPro.add("xh");
		lPro.add("ys");
		lPro.add("djrq");
		lPro.add("lxr");
		lPro.add("ajlb");
    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDelete");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Sjbdqxx getSjbdqxx=new Sjbdqxx();
    	
        this.setData(getSjbdqxx,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception{
		try {
			Sjbdqxx setSjbdqxx = new Sjbdqxx();
			setSjbdqxx = (Sjbdqxx)this.setClass(setSjbdqxx, null);
			Map map = new HashMap();
			mapProperty(map, setSjbdqxx);
			Page page = sjbdqxxService.getListForPage(map, pagesize, pagerow,sort,dir);
			totalpage=page.getTotalPages();
			totalrows=page.getTotalRows();
			setTabledata(page.getData()); 
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	public String query() throws Exception{
		try {
			Sjbdqxx setSjbdqxx=new Sjbdqxx();
			sjbdqxx=(Sjbdqxx)this.setClass(setSjbdqxx, null);
			sjbdqxx=sjbdqxxService.getSjbdqxx(sjbdqxx);
			lSjbdqxx.add(sjbdqxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	public String insert() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.userKey);
		if(user==null){
			result="";
			return "success";
		}
		try {
			Sjbdqxx setSjbdqxx = new Sjbdqxx();
			setSjbdqxx = (Sjbdqxx)this.setClass(setSjbdqxx, null);
			setSjbdqxx.setDjr(user.getUseraccount());
			setSjbdqxx.setBadwbm(user.getDepartment().getDepartcode());
			setSjbdqxx.setBadw(user.getDepartment().getDepartname());
			sjbdqxxService.insertSjbdqxx(setSjbdqxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Sjbdqxx setSjbdqxx = new Sjbdqxx();
			setSjbdqxx = (Sjbdqxx)this.setClass(setSjbdqxx, null);
			sjbdqxxService.updateSjbdqxx(setSjbdqxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Sjbdqxx setSjbdqxx = new Sjbdqxx();
			setSjbdqxx = (Sjbdqxx)this.setClass(setSjbdqxx, null);
			sjbdqxxService.deleteSjbdqxx(setSjbdqxx);
		} catch (Exception e) {
			e.printStackTrace();
			this.result="";
		}
        return "success";
    }
	
	/** 判断手机被盗抢信息 是否存在 */
	public String sjbdqxxExist(){
		try {
			Sjbdqxx setSjbdqxx = new Sjbdqxx();
			setSjbdqxx.setSjch(vsjch);
			if(vsjbdqxxid!=null&&!"".equals(vsjbdqxxid)){
				setSjbdqxx.setSjbdqxxid(Integer.parseInt(vsjbdqxxid));
			}
			exitResult = sjbdqxxService.isSjbdqxxExist(setSjbdqxx);
		} catch (Exception e) {
			e.printStackTrace();
			result="请重试";
		}
		return SUCCESS;
	}
	
	public void mapProperty(Map map, Sjbdqxx sjbdqxx){
		map.put("superbWhere", sjbdqxx.getSuperbWhere()); //高级查询条件
		map.put("superbOrderBy", sjbdqxx.getSuperbOrderBy());
		
		map.put("pp", sjbdqxx.getPp());
		map.put("xh", sjbdqxx.getXh());
		map.put("ys", sjbdqxx.getYs());
		map.put("sjch", sjbdqxx.getSjch());
		map.put("djr", sjbdqxx.getDjr());
		map.put("ajjbbm", sjbdqxx.getAjjbbm());
		map.put("ajlbbm", sjbdqxx.getAjlbbm());
		map.put("ladqbm", sjbdqxx.getLadqbm());
		map.put("lxr", sjbdqxx.getLxr());
		map.put("djrq", sjbdqxx.getDjrq());
		map.put("djrqt", sjbdqxx.getDjrqt());
	}
}