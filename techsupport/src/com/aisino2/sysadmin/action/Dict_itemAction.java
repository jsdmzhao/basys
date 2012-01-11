package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.cache.CacheManager;
import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.opensymphony.xwork2.ActionContext;

public class Dict_itemAction extends PageAction{
	private IDict_itemService dict_itemService;
	private List lDict_item = new ArrayList();
	private List ldata;
	private Dict_item dict_item;
	private String tabledata;
	private String dict_code;
	private String query_simplepin;
	private String orderBySib_order;
	private int totalrows;
	private String result="";
	
	private String delvalue;
	
	public void setDelvalue(String delvalue) {
		this.delvalue = delvalue;
	}

	public List getLdata() {
		return ldata;
	}

	public void setOrderBySib_order(String orderBySib_order) {
		this.orderBySib_order = orderBySib_order;
	}

	public void setLdata(List ldata) {
		this.ldata = ldata;
	}

	public void setQuery_simplepin(String query_simplepin) {
		this.query_simplepin = query_simplepin;
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

	public Dict_item getDict_item() {
		return dict_item;
	}
	
	public List getLDict_item() {
		return lDict_item;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}
	
	public void setTabledata(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("item_id");
		lPro.add("display_name");
		lPro.add("fact_value");
		lPro.add("append_value");
		lPro.add("item_simplepin");


    	List lDetail=new ArrayList();
    	lDetail.add("setQueryDict_item");
    	lDetail.add("详情");
    	
    	List lModify=new ArrayList();
    	lModify.add("setModifyQuery");
    	lModify.add("修改");
    	
    	List lDel=new ArrayList();
    	lDel.add("setDeleteDict_item");
    	lDel.add("删除");
    	
    	List lCol=new ArrayList();
    	lCol.add(lDetail);
    	lCol.add(lModify);
    	lCol.add(lDel);
    	
    	Dict_item getDict_item=new Dict_item();
    	
        this.setData(getDict_item,lData,lPro,lCol);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	
	public void setTabledataDict(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("item_id");
		
		lPro.add("display_name");
		lPro.add("item_simplepin");
		lPro.add("item_allpin");
		lPro.add("fact_value");
    	
    	Dict_item getDict_item=new Dict_item();
    	
        this.setData(getDict_item,lData,lPro,null);
        this.tabledata=this.getData();
        totalrows=this.getTotalrows();
	}
	
	private List setChildrenData(List list, List lstTree){
		
		for(java.util.Iterator iter=list.iterator();iter.hasNext();){
			Dict_item myItem = (Dict_item)iter.next();
			lstTree.add(myItem);
			List lstChild = dict_itemService.getChildDict_itemListByItemIDAndDictCode(myItem);
			if(lstChild!=null&&lstChild.size()>0){
				setChildrenData(lstChild, lstTree);
			}
		}
		return lstTree;
	}
	
	public String querylist() throws Exception{
        try{
            Dict_item setDict_item=new Dict_item();
        	dict_item = (Dict_item)this.setClass(setDict_item, null); Map map = new HashMap();
            if(dict_item!=null){
            	map.put("dict_code", dict_item.getDict_code());
            	//if(dict_item.getFact_value()!=null&&!dict_item.getFact_value().equals(""))
            		//map.put("like_factValue", StringUtil.trim0(dict_item.getFact_value()));

            	map.put("display_name", dict_item.getDisplay_name());
            	map.put("super_item_id", dict_item.getSuper_item_id());
            }
            Page page = dict_itemService.getListForPage(map, pagesize, pagerow,sort,dir);
            lDict_item=page.getData();
            totalpage=page.getTotalPages();
            totalrows=page.getTotalRows();
            setTabledata(lDict_item); 
            dict_item=null;
        }catch(Exception e){
        	e.printStackTrace();
        }
		 this.result="success";
        return "success";
    }
	
	/*移动dict_item,更改dict_item的排列顺序(上移、下移、置顶、置底)*/
	public String moveDictItem () throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			dict_item = (Dict_item)this.setClass(setDict_item, null);
			
			if(dict_item!=null && dict_item.getItem_id()!=null){
				String moveWay = dict_item.getWay();
			
				dict_item = dict_itemService.getDict_item(dict_item);
				
				dict_item.setWay(moveWay);
			
				dict_itemService.updateDict_itemEditEdOrder(dict_item);
			}
			this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result="移动失败";
			e.printStackTrace();
		}
	
        return "success";
    }
	
	public String manage() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String dict_code = request.getParameter("dict_code");
		if(dict_code==null||"".equals(dict_code)){
			dict_code = "0";
		}
		request.setAttribute("dict_code", dict_code);
		return SUCCESS;
    }	
	
	public String manageTree() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String item_id = request.getParameter("item_id");
		String fact_value = request.getParameter("fact_value");
		if(item_id==null||"".equals(item_id)){
			item_id = "0";
		}
		String displayValue = null;
		if(!item_id.equals("0")){
			Dict_item superItem = new Dict_item();
			superItem.setItem_id(new Integer(item_id));
			superItem = dict_itemService.getDict_item(superItem);
			displayValue = superItem.getDisplay_name();
		}

		request.setAttribute("dict_code", dict_code);
		request.setAttribute("fact_value", fact_value);
		request.setAttribute("item_id", item_id);
		request.setAttribute("display_name", displayValue);
		return SUCCESS;
    }
	
	
	public String query() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			dict_item=(Dict_item)this.setClass(setDict_item, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dict_item=dict_itemService.getDict_item(dict_item);
        lDict_item = new ArrayList();
        lDict_item.add(dict_item);
		this.result="success";
        return "success";
    }	
	
	//查找行政区划
	public String queryXZQH() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			dict_item=(Dict_item)this.setClass(setDict_item, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        lDict_item = CacheManager.getCacheDictitem(dict_item);
		this.result="success";
        return "success";
    }
	
	public String insert() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			dict_item=(Dict_item)this.setClass(setDict_item, null);
			
			String displayName = dict_itemService.getDictItemNameByDcFv(dict_item);
			if(displayName!=null){
				this.result = "该实际值已经存在";
				return "success";
			}
	        dict_item=dict_itemService.insertDict_item(dict_item);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	public String modify() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			dict_item=(Dict_item)this.setClass(setDict_item, null);		
			
			String displayName = dict_itemService.getDictItemNameByDcFv(dict_item);
			if(displayName!=null){
				this.result = "该实际值已经存在";
				return "success";
			}
	        dict_itemService.updateDict_item(dict_item);
	        this.result="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "success";
    }
	
	public String delete() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			dict_item=(Dict_item)this.setClass(setDict_item, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dict_itemService.deleteDict_item(dict_item);
        this.result="success";
        return "success";
    }
	
	/**
	 * 字典下拉列表查询,不分页 暂时注释掉
	 * @return
	 * @throws Exception
	 */
	public String queryForDictNoPage() throws Exception{
	try {
		Dict_item setDict_item=new Dict_item();
		dict_item=(Dict_item)this.setClass(setDict_item, null);
		dict_item.setExclude_factValue(query_simplepin);
		dict_item.setDict_code(dict_code);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(lDict_item ==null)
		lDict_item = new ArrayList();
	lDict_item.clear();
	//lDict_item=dict_itemService.getListDict_item(dict_item);
	//setTabledataDict(lDict_item);
    //lDict_item.add(dict_item);
	this.result="success";
    return "success";
}
	
	/**
	 * 字典下拉列表查询
	 * @return
	 * @throws Exception
	 */	
	public String querySelDict() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			
			setDict_item.setDict_code(dict_code);
			
			sheZhiDict_item(setDict_item);
			
			if(query_simplepin!=null && !query_simplepin.equals("")){
				setDict_item.setSuper_item_id(new Integer(query_simplepin));
			}

			ldata = CacheManager.getCacheDictitem(setDict_item);
			
			if(dict_code!=null && dict_code.equals("dm_bez")){
				Dict_item oneDict_item = (Dict_item)ldata.remove(0);
				ldata.add(oneDict_item);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}
	
	
	
	/**
	 * 字典下拉列表查询 删除部分
	 * @return
	 * @throws Exception
	 */	
	public String querySelDictDel() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			
			setDict_item.setDict_code(dict_code);

			sheZhiDict_item(setDict_item);
			
			if(query_simplepin!=null && !query_simplepin.equals("")){
				setDict_item.setSuper_item_id(new Integer(query_simplepin));
			}

			ldata = CacheManager.getCacheDictitem(setDict_item);
			
			if(dict_code!=null && dict_code.equals("dm_bez")){
				Dict_item oneDict_item = (Dict_item)ldata.remove(0);
				ldata.add(oneDict_item);
			}
			
			int num = Integer.parseInt(delvalue);
			for(int i=0;i<num;i++){
				ldata.remove(0);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
		return "success";
		
		
	}

	/**
	 * 字典树形下拉列表查询
	 * @return
	 * @throws Exception
	 */	
	public String queryTreeSelDict() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			
			setDict_item.setDict_code(dict_code);
			
			sheZhiDict_item(setDict_item);
			
			ldata = CacheManager.getCacheDictitem(setDict_item);
		
			if(ldata!=null && query_simplepin!=null && !query_simplepin.equals("")){
				int length = ldata.size();
				String fact_value = null;
				for(int index=0;index<ldata.size();){
					setDict_item = (Dict_item)ldata.get(index);
					fact_value = setDict_item.getFact_value();
					if(fact_value.indexOf(query_simplepin)!=0
							|| fact_value.equals(query_simplepin)){
						ldata.remove(setDict_item);
					}else{
						index++;
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}

	
	private void sheZhiDict_item(Dict_item setDict_item){
		setDict_item.setItem_allpin("");
		setDict_item.setItem_simplepin("");
		setDict_item.setFact_value("");
		setDict_item.setDisplay_name("");
		setDict_item.setAppend_value("");
	}
	
	/**
	 * 字典下拉列表查询
	 * @return
	 * @throws Exception
	 */	
	
	public String queryChSelDict() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			//dict_item=(Dict_item)this.setClass(setDict_item, null);
			//if(dict_item.getDict_code()==null||dict_item.getDict_code().equals("")){
			setDict_item.setDict_code(dict_code);
			//}
			setDict_item.setExclude_factValue(query_simplepin);
			setDict_item.setOrderBySib_order(orderBySib_order);
			if(ldata == null)
				ldata = new ArrayList();
			ldata.clear();
			ldata=dict_itemService.getListDict_item(setDict_item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}
	
	/**
	 * 行业类别字典下拉列表查询
	 * @return
	 * @throws Exception
	 */	
	public String querySelDicthylb() throws Exception{
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
		String userType = user.getUsertype();

		int ylyflag = 0;  ///娱乐业标识
		int ggcsflag =0;  ///公共场所标识
		int lgyflag = 0;  ///旅馆业标识
		int ddyflag = 0; //典当业标志
		int jxyflag = 0; //机修业标志
		int yzyflag = 0;  //印章业标志
		int escflag = 0;	//二手车标志
		int jyddhjyflag = 0;	//旧移动电话交易业
		int fjjssgflag = 0;	//废旧金属收购业
		int czqcflag = 0;	//出租汽车
		int qczlflag = 0;	//汽车租赁
		int czfwflag = 0;   //出租房屋标识
		int jdhxpflag = 0;   //剧毒化学品标识
		int neibaoflag = 0;   //内保行业标识
		int wtjmflag = 0;   //委托寄卖行业标识
		int jdccjflag = 0;   //机动车拆解行业标识
		
		String[] utype = userType.split(",");
		
		for(int i=0;i<utype.length;i++){
			if("9998".equals(utype[i])){
				ylyflag=1;
				ggcsflag = 1;
				lgyflag = 1;
				ddyflag = 1;
				jxyflag = 1;
				yzyflag = 1;
				escflag = 1;
				jyddhjyflag = 1;
				fjjssgflag = 1;
				czqcflag = 1;
				jdhxpflag = 1;
				neibaoflag = 1;
				jdccjflag = 1;
				jdccjflag = 1;
			}else{
				if("11".equals(utype[i]) || "12".equals(utype[i]) || "13".equals(utype[i]) || "14".equals(utype[i]))
					ylyflag = 1;
				if("141".equals(utype[i]) || "142".equals(utype[i]) || "143".equals(utype[i]) || "144".equals(utype[i]))
					ggcsflag = 1;
				
				if("24".equals(utype[i]))
					lgyflag = 1;
				
				if("32".equals(utype[i]) || "33".equals(utype[i]) || "34".equals(utype[i])|| "35".equals(utype[i])|| "36".equals(utype[i]))
					ddyflag = 1;
				
				if("42".equals(utype[i]) || "43".equals(utype[i]) || "44".equals(utype[i]) || "45".equals(utype[i]) || "46".equals(utype[i]))
					jxyflag = 1;
				
				if("51".equals(utype[i]) || "52".equals(utype[i]) || "53".equals(utype[i]) || "55".equals(utype[i]) || "56".equals(utype[i]))
					yzyflag = 1;

				if("62".equals(utype[i]) || "63".equals(utype[i]) || "64".equals(utype[i]) || "65".equals(utype[i]) || "66".equals(utype[i]))
					escflag = 1;

				if("72".equals(utype[i]) || "73".equals(utype[i]) || "74".equals(utype[i]) || "75".equals(utype[i]) || "76".equals(utype[i]))
					jyddhjyflag = 1;
				
				if("82".equals(utype[i]) || "83".equals(utype[i]) || "84".equals(utype[i]) || "85".equals(utype[i]) || "86".equals(utype[i]))
					fjjssgflag = 1;
				
				if("92".equals(utype[i]) || "93".equals(utype[i]) || "94".equals(utype[i]) || "95".equals(utype[i]) || "96".equals(utype[i]))
					czqcflag = 1;
				
				if("102".equals(utype[i]) || "103".equals(utype[i]) || "104".equals(utype[i]) || "105".equals(utype[i]) || "106".equals(utype[i]))
					qczlflag = 1;

				if("91".equals(utype[i]))
					czfwflag = 1;
				
				if("112".equals(utype[i]) || "113".equals(utype[i]) || "114".equals(utype[i]) || "115".equals(utype[i]) || "116".equals(utype[i]))
					jdhxpflag = 1;
				
				if("121".equals(utype[i]) || "122".equals(utype[i]) || "125".equals(utype[i])|| "126".equals(utype[i])|| "9998".equals(utype[i]))
					neibaoflag = 1;
				
				if("164".equals(utype[i]) || "163".equals(utype[i]) || "162".equals(utype[i]) || "165".equals(utype[i]) || "166".equals(utype[i]))
					wtjmflag = 1;
				
				if("154".equals(utype[i]) || "153".equals(utype[i])|| "152".equals(utype[i]) || "156".equals(utype[i]) || "155".equals(utype[i]))
					jdccjflag = 1;
			}			
		}
		
		if(dict_code!=null){
			if(dict_code.equals("ggmk")){
				ggcsflag =0;ylyflag = 0;lgyflag = 0;czfwflag = 0; //ddyflag = 0;yzyflag = 0;
			}else if(dict_code.equals("flgy")){
				lgyflag = 0;
			}else if(dict_code.equals("J")){
				lgyflag = 0;  ///旅馆业标识
				ddyflag = 0; //典当业标志
				jxyflag = 0; //机修业标志
				yzyflag = 0;  //印章业标志
				escflag = 0;	//二手车标志
				jyddhjyflag = 0;	//旧移动电话交易业
				fjjssgflag = 0;	//废旧金属收购业
				czqcflag = 0;	//出租汽车
				qczlflag = 0;	//汽车租赁
				czfwflag = 0;   //出租房屋标识
				jdhxpflag = 0;   //剧毒化学品标识
				neibaoflag = 0;   //内保行业标识
				wtjmflag = 0;   //委托寄卖行业标识
				jdccjflag = 0;   //机动车拆解行业标识
			}
		}
		
		try {
			Dict_item setDict_item=new Dict_item();
			setDict_item.setDict_code("dm_hylb");

			sheZhiDict_item(setDict_item);
			ldata = new ArrayList();
			List alldata = CacheManager.getCacheDictitem(setDict_item);
			for(int i=0; i<alldata.size(); i++){
				Dict_item d_item = (Dict_item)alldata.get(i);
				if("A".equals(d_item.getFact_value())){
					if(lgyflag==1){
						ldata.add(d_item);
					}
				}else if("J".equals(d_item.getFact_value())){
					if(ylyflag==1){
						ldata.add(d_item);
					}
				}else if("K".equals(d_item.getFact_value())){
					if(ggcsflag==1){
						ldata.add(d_item);
					}
				}else if("E03".equals(d_item.getFact_value())){
					if(ddyflag==1){
						ldata.add(d_item);
					}
				}else if("C".equals(d_item.getFact_value())){
					if(jxyflag==1){
						ldata.add(d_item);
					}
				}else if("B".equals(d_item.getFact_value())){
					if(yzyflag==1){
						ldata.add(d_item);
					}
				}else if("E01".equals(d_item.getFact_value())){
					if(escflag==1){
						ldata.add(d_item);
					}
				}else if("E02".equals(d_item.getFact_value())){
					if(jyddhjyflag==1){
						ldata.add(d_item);
					}
				}else if("E04".equals(d_item.getFact_value())){
					if(fjjssgflag==1){
						ldata.add(d_item);
					}
				}else if("F01".equals(d_item.getFact_value())){
					if(czqcflag==1){
						ldata.add(d_item);
					}
				}else if("F02".equals(d_item.getFact_value())){
					if(qczlflag==1){
						ldata.add(d_item);
					}
				}else if("Z".equals(d_item.getFact_value())){
					if(czfwflag==1){
						ldata.add(d_item);
					}
				}else if("X".equals(d_item.getFact_value())){
					if(jdhxpflag==1){
						ldata.add(d_item);
					}
				}else if("N".equals(d_item.getFact_value())){
					if(neibaoflag==1){
						ldata.add(d_item);
					}
				}else if("E07".equals(d_item.getFact_value())){
					if(wtjmflag==1){
						ldata.add(d_item);
					}
				}else if("C01".equals(d_item.getFact_value())){
					if(jdccjflag==1){
						ldata.add(d_item);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}
	
	/**
	 * 行业类别字典下拉列表查询 in 方式
	 * @return
	 * @throws Exception
	 */	
	public String querySelDictinhylb() throws Exception{
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session= request.getSession();
		User user= (User)session.getAttribute(Constants.userKey);
		String userType = user.getUsertype();
		
		int ylyflag = 0;  ///娱乐业标识
		int ggcsflag =0;  ///公共场所标识
		int lgyflag = 0;  ///旅馆业标识
		int ddyflag = 0; //典当业标志
		int jxyflag = 0; //机修业标志
		int yzyflag = 0;  //印章业标志
		int escflag = 0;	//二手车标志
		int jyddhjyflag = 0;	//旧移动电话交易业
		int fjjssgflag = 0;	//废旧金属收购业
		int czqcflag = 0;	//出租汽车
		int qczlflag = 0;	//汽车租赁
		int czfwflag = 0;   //出租房屋标识
		int jdhxpflag = 0;   //剧毒化学品标识
		int neibaoflag = 0;   //内保行业标识

		String[] utype = userType.split(",");
		for(int i=0;i<utype.length;i++){
			if("11".equals(utype[i]) || "12".equals(utype[i]) || "13".equals(utype[i]) || "14".equals(utype[i]))
				ylyflag = 1;
			if("141".equals(utype[i]) || "142".equals(utype[i]) || "143".equals(utype[i]) || "144".equals(utype[i]))
				ggcsflag = 1;		
			if("24".equals(utype[i]))
				lgyflag = 1;
			if("32".equals(utype[i]) || "33".equals(utype[i]) || "34".equals(utype[i]) || "35".equals(utype[i])|| "36".equals(utype[i]))
				ddyflag = 1;	
			if("42".equals(utype[i]) || "43".equals(utype[i]) || "44".equals(utype[i])|| "45".equals(utype[i])|| "46".equals(utype[i]))
				jxyflag = 1;
			if("51".equals(utype[i]) || "52".equals(utype[i]) || "53".equals(utype[i])|| "55".equals(utype[i])|| "56".equals(utype[i]))
				yzyflag = 1;
			if("62".equals(utype[i]) || "63".equals(utype[i]) || "64".equals(utype[i])|| "65".equals(utype[i])|| "66".equals(utype[i]))
				escflag = 1;
			if("72".equals(utype[i]) || "73".equals(utype[i]) || "74".equals(utype[i])|| "75".equals(utype[i])|| "76".equals(utype[i]))
				jyddhjyflag = 1;	
			if("82".equals(utype[i]) || "83".equals(utype[i]) || "84".equals(utype[i])|| "85".equals(utype[i])|| "86".equals(utype[i]))
				fjjssgflag = 1;		
			if("92".equals(utype[i]) || "93".equals(utype[i]) || "94".equals(utype[i])|| "95".equals(utype[i])|| "96".equals(utype[i]))
				czqcflag = 1;
			if("102".equals(utype[i]) || "103".equals(utype[i]) || "104".equals(utype[i])|| "105".equals(utype[i])|| "106".equals(utype[i]))
				qczlflag = 1;
			if("91".equals(utype[i]))
				czfwflag = 1;
			if("112".equals(utype[i]) || "113".equals(utype[i]) || "114".equals(utype[i])|| "115".equals(utype[i])|| "116".equals(utype[i]))
				jdhxpflag = 1;
			if("121".equals(utype[i]) || "122".equals(utype[i]) || "125".equals(utype[i]) || "126".equals(utype[i]))
				neibaoflag = 1;
		}
		///过滤代码
		if(dict_code!=null){
			if(dict_code.equals("ggmk")){
				ggcsflag =0;ylyflag = 0;lgyflag = 0;czfwflag = 0; //ddyflag = 0;yzyflag = 0;
			}else if(dict_code.equals("flgy")){
				lgyflag = 0;
			}else if(dict_code.equals("J")){
				lgyflag = 0;  ///旅馆业标识
				ddyflag = 0; //典当业标志
				jxyflag = 0; //机修业标志
				yzyflag = 0;  //印章业标志
				escflag = 0;	//二手车标志
				jyddhjyflag = 0;	//旧移动电话交易业
				fjjssgflag = 0;	//废旧金属收购业
				czqcflag = 0;	//出租汽车
				qczlflag = 0;	//汽车租赁
				czfwflag = 0;   //出租房屋标识
				jdhxpflag = 0;   //剧毒化学品标识
				neibaoflag = 0;   //内保行业标识
			}
		}
		///生成组合字符
			String allhylbdm="";
			String Separator="','";
			if(ylyflag == 1)
				allhylbdm=allhylbdm+Separator+"J";
			if(ggcsflag == 1)
				allhylbdm=allhylbdm+Separator+"K";		
			if(lgyflag == 1)
				allhylbdm=allhylbdm+Separator+"A";		
			if(ddyflag == 1)
				allhylbdm=allhylbdm+Separator+"E03";			
			if(jxyflag == 1)
				allhylbdm=allhylbdm+Separator+"C";	
			if(yzyflag == 1)
				allhylbdm=allhylbdm+Separator+"B";
			if(escflag == 1)
				allhylbdm=allhylbdm+Separator+"E01";
			if(jyddhjyflag == 1)
				allhylbdm=allhylbdm+Separator+"E02";		
			if(fjjssgflag == 1)
				allhylbdm=allhylbdm+Separator+"E04";		
			if(czqcflag == 1)
				allhylbdm=allhylbdm+Separator+"F01";			
			if(qczlflag == 1)
				allhylbdm=allhylbdm+Separator+"F02";
			if(czfwflag == 1)
				allhylbdm=allhylbdm+Separator+"Z";		
			if(jdhxpflag == 1)
				allhylbdm=allhylbdm+Separator+"X";		
			if(neibaoflag == 1)
				allhylbdm=allhylbdm+Separator+"N";
		
		try {
			Dict_item setDict_item=new Dict_item();
			setDict_item.setDict_code("dm_hylb");
		
			setDict_item.setExclude_factValue(query_simplepin);

			sheZhiDict_item(setDict_item);
			
			ldata = new ArrayList();
			Dict_item d_item_all=new Dict_item();
			d_item_all.setDisplay_name("");
			d_item_all.setFact_value(allhylbdm.substring(3));
			ldata.add(d_item_all);
			
			List alldata = CacheManager.getCacheDictitem(setDict_item);
			for(int i=0; i<alldata.size(); i++){
				Dict_item d_item = (Dict_item)alldata.get(i);
				if("A".equals(d_item.getFact_value())){
					if(lgyflag==1){
						ldata.add(d_item);
					}
				}else if("J".equals(d_item.getFact_value())){
					if(ylyflag==1){
						ldata.add(d_item);
					}
				}else if("K".equals(d_item.getFact_value())){
					if(ggcsflag==1){
						ldata.add(d_item);
					}
				}else if("E03".equals(d_item.getFact_value())){
					if(ddyflag==1){
						ldata.add(d_item);
					}
				}else if("C".equals(d_item.getFact_value())){
					if(jxyflag==1){
						ldata.add(d_item);
					}
				}else if("B".equals(d_item.getFact_value())){
					if(yzyflag==1){
						ldata.add(d_item);
					}
				}else if("E01".equals(d_item.getFact_value())){
					if(escflag==1){
						ldata.add(d_item);
					}
				}else if("E02".equals(d_item.getFact_value())){
					if(jyddhjyflag==1){
						ldata.add(d_item);
					}
				}else if("E04".equals(d_item.getFact_value())){
					if(fjjssgflag==1){
						ldata.add(d_item);
					}
				}else if("F01".equals(d_item.getFact_value())){
					if(czqcflag==1){
						ldata.add(d_item);
					}
				}else if("F02".equals(d_item.getFact_value())){
					if(qczlflag==1){
						ldata.add(d_item);
					}
				}else if("Z".equals(d_item.getFact_value())){
					if(czfwflag==1){
						ldata.add(d_item);
					}
				}else if("X".equals(d_item.getFact_value())){
					if(jdhxpflag==1){
						ldata.add(d_item);
					}
				}else if("N".equals(d_item.getFact_value())){
					if(neibaoflag==1){
						ldata.add(d_item);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.result="success";
		return "success";
	}
	/**
	 * 字典下拉列表查询,分页,用于每次从数据库中取值，勿删！！
	 * @return
	 * @throws Exception
	 */
	/*public String queryForDict() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			dict_item=(Dict_item)this.setClass(setDict_item, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map map = new HashMap();
        //字典编码
        map.put("dict_code", dict_item.getDict_code());
        //筛选条件
        if(dict_item.getQuery_simplepin() != null)
        	map.put("query_simplepin", dict_item.getQuery_simplepin());
        
        if(lDict_item ==null)
			lDict_item = new ArrayList();
		lDict_item.clear();
        Page page = dict_itemService.getDropdownListForPage(map, pagesize, pagerow,sort,dir);
        totalpage=page.getTotalPages();
        totalrows=page.getTotalRows();
        lDict_item=page.getData();
        setTabledataDict(lDict_item); 
		this.result="success";
        return "success";
    }*/
	
	/**
	 * 字典下拉列表查询,分页,用于每次从内存中取值
	 * @return
	 * @throws Exception
	 */
	public String queryForDict() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			dict_item=(Dict_item)this.setClass(setDict_item, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Map map = new HashMap();
        //字典编码
        //map.put("dict_code", dict_item.getDict_code());
        //筛选条件
        //if(dict_item.getQuery_simplepin() != null)
        //	map.put("query_simplepin", dict_item.getQuery_simplepin());
		if(dict_item.getQuery_simplepin() != null)
		{
			String tempStr = dict_item.getQuery_simplepin();
			
			dict_item.setItem_allpin(tempStr);
			dict_item.setItem_simplepin(tempStr);
			dict_item.setFact_value(tempStr);
			dict_item.setDisplay_name(tempStr);
			dict_item.setAppend_value(tempStr);
		}
        if(lDict_item ==null)
			lDict_item = new ArrayList();
		lDict_item.clear();
		
		List tempDict_itemList = new ArrayList();
		//内存中查询数据
		tempDict_itemList = CacheManager.getCacheDictitem(dict_item);
		//总页数及总记录数
		totalpage=(tempDict_itemList.size()%pagerow==0)?tempDict_itemList.size()%pagerow:tempDict_itemList.size()%pagerow+1;
        totalrows=tempDict_itemList.size();
        //当前页开始及结束序号
		int startIndex = 0;
		int endIndex = 0;
		startIndex  = (pagesize-1)*pagerow;
		endIndex = (totalrows<pagesize*pagerow)?totalrows:pagesize*pagerow;
		//取得当前页记录列表
		lDict_item = tempDict_itemList.subList(startIndex, endIndex);
		
        setTabledataDict(lDict_item); 
		this.result="success";
        return "success";
    }

	public void setDict_code(String dict_code) {
		this.dict_code = dict_code;
	}
	private String xb;
	private String minzu;
	private String gj;
	private String hjsx;
	/**
	 * 对卡中的数据进行翻译
	 * @return
	 */
	public String codeChangeDisplayName(){
		
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code("dm_xb");
		dict_item.setFact_value(xb);
		String xbFactValue = dict_itemService.getDictItemNameByDcFv(dict_item);  ///性别
		if(xbFactValue==null)
			xbFactValue = "";
		
		dict_item.setDict_code("dm_mz");
		dict_item.setFact_value(minzu);
		String minzuFactValue = dict_itemService.getDictItemNameByDcFv(dict_item);  ///民族
		if(minzuFactValue==null)
			minzuFactValue = "";
		
		dict_item.setDict_code("dm_gj(lgy)");
		dict_item.setFact_value(gj);
		String gjFactValue = dict_itemService.getDictItemNameByDcFv(dict_item);  ///国籍
		 if(gjFactValue==null)
			 gjFactValue = "";
		
		dict_item.setDict_code("dm_xzqh");
		dict_item.setFact_value(hjsx);
		String hjsxFactValue = dict_itemService.getDictItemNameByDcFv(dict_item);  ///户籍市县
		 if(hjsxFactValue==null)
			 hjsxFactValue = "";
		
		String displayNameInfo = xbFactValue+",|"+minzuFactValue+",|"+gjFactValue+",|"+hjsxFactValue;
		this.result=displayNameInfo;
		return "success";
	}
	
	public String nextNodeorder() throws Exception{
		try {
			Dict_item setDict_item=new Dict_item();
			dict_item=(Dict_item)this.setClass(setDict_item, null);
			Integer sib_order = null;
			if(dict_item!=null){
				sib_order = dict_itemService.getNextNodeorder(dict_item);
			}
			if(dict_item!=null){
				dict_item.setSib_order(sib_order);
			}else{
				dict_item = new Dict_item();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.result="success";
	    return "success";
	}
	public String getXb() {
		return xb;
	}
	
	public void setXb(String xb) {
		this.xb = xb;
	}
	
	public String getMinzu() {
		return minzu;
	}
	
	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}
	
	public String getGj() {
		return gj;
	}
	
	public void setGj(String gj) {
		this.gj = gj;
	}
	
	public String getHjsx() {
		return hjsx;
	}
	
	public void setHjsx(String hjsx) {
		this.hjsx = hjsx;
	}
	
	 ////出租房 详细地址 变量
	private String itemId;         ///字典项id
	private String allFact_value;  ////详细地址全部
	
	
	/**
	 * 得到得到 详细地址
	 * @return
	 * @throws Exception
	 */
	public String tDictItemallvalue() throws Exception{
		
		//System.out.println(itemId);
		
		allFact_value = getallFact_value(Integer.parseInt(itemId));
		
		//allFact_value = dict_item.getDisplay_name();
		
		return "success";
		
	}
	/**
	 * 递归得到 全部相信地址
	 * @param item_id
	 * @return
	 */
	private String getallFact_value(int item_id) throws Exception{
		Dict_item dict_item = new Dict_item();
		dict_item.setItem_id(item_id);
		dict_item = dict_itemService.getDict_item(dict_item);
		String allFact="";
		//System.out.println(dict_item.getSuper_item_id());
		if(dict_item.getSuper_item_id()==null||dict_item.getSuper_item_id()==0){
			
			allFact = dict_item.getDisplay_name();
			return allFact;
		}else{
			allFact = getallFact_value(dict_item.getSuper_item_id())+dict_item.getDisplay_name();
			return allFact;
		}
		
		//return null;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getAllFact_value() {
		return allFact_value;
	}

	public void setAllFact_value(String allFact_value) {
		this.allFact_value = allFact_value;
	}
}