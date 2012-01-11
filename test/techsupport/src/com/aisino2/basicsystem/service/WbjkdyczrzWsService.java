package com.aisino2.basicsystem.service;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.aisino2.basicsystem.dao.IWbjkczrzmxDao;
import com.aisino2.basicsystem.dao.IWbjkdyczrzDao;
import com.aisino2.basicsystem.domain.Wbjkczrzmx;
import com.aisino2.basicsystem.domain.Wbjkdyczrz;
import com.aisino2.sysadmin.dao.IDict_itemDao;
import com.aisino2.sysadmin.domain.Dict_item;
public class WbjkdyczrzWsService {
	private IWbjkdyczrzDao wbjkdyczrzDao;
	private IWbjkczrzmxDao wbjkczrzmxDao;
	private IDict_itemDao dict_itemDao;
	String xx="";
	StringTokenizer commaToker =null; 
	  //tsxzflag:记录太多的标志
	
	/**
	 * of 操作结果说明，
	 * tn 记录总数
	 * sn 记录成功数
	 * list 错误的list
	 * tsxzflag:记录太多的标志
	 * tiaoshu 每次限制的条数
	 * czzh 操作人账号
	 * gsmc 公司名称
	 * hymc 行业名称
	 * hybm 行业编码
	 * czlx 操作类型
	 * dyjkmc 调用接口名称
	 */
	
	public  void insertWbjkdyczrzAndmx(String czzh,String czgsmc ,String hybm,String czlx ,String dyjkmc,String of,int tn,int sn,List list,String tsxzflag,int tiaoshu){
		
		Wbjkdyczrz wbjkdyczrz = new Wbjkdyczrz();
		wbjkdyczrz.setCzzh(czzh);
		wbjkdyczrz.setCzgsmc(czgsmc);
		wbjkdyczrz.setCzsj(new Date());
		wbjkdyczrz.setDyjkmc(dyjkmc);
		wbjkdyczrz.setCzlx(czlx);
		wbjkdyczrz.setZgts(tn);
		wbjkdyczrz.setCzjg(of);
		wbjkdyczrz.setCgts(sn);
		wbjkdyczrz.setSbts(tn-sn);
		wbjkdyczrz.setHybm(hybm);
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code("dm_hylb");
		dict_item.setFact_value(hybm);
		wbjkdyczrz.setHymc(dict_itemDao.getDictItemNameByDcFv(dict_item));
		wbjkdyczrz =wbjkdyczrzDao.insertWbjkdyczrz(wbjkdyczrz);
		
		Wbjkczrzmx wbjkczrzmx = new Wbjkczrzmx();
		
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				xx=(String)list.get(i);
				commaToker =new StringTokenizer(xx, "_|"); 
				wbjkczrzmx = new Wbjkczrzmx();
				wbjkczrzmx.setCzrzid(wbjkdyczrz.getCzrzid());
				wbjkczrzmx.setCzjglx("失败");
				wbjkczrzmx.setDjt(Integer.parseInt(String.valueOf(commaToker.nextToken())));
				wbjkczrzmx.setSbyy(String.valueOf(commaToker.nextToken()));
				wbjkczrzmxDao.insertWbjkczrzmx(wbjkczrzmx);
			}
		}else{
			if(tsxzflag.endsWith("yes")){
					wbjkczrzmx = new Wbjkczrzmx();
					wbjkczrzmx.setCzrzid(wbjkdyczrz.getCzrzid());
					wbjkczrzmx.setCzjglx("失败");
					wbjkczrzmx.setDjt(-1);
					wbjkczrzmx.setSbyy("-1-记录条数超出限制:"+tiaoshu+"条");
					wbjkczrzmxDao.insertWbjkczrzmx(wbjkczrzmx);
			}
			
		}
		
	}
	
	
	
	
	public IWbjkdyczrzDao getWbjkdyczrzDao() {
		return wbjkdyczrzDao;
	}
	public void setWbjkdyczrzDao(IWbjkdyczrzDao wbjkdyczrzDao) {
		this.wbjkdyczrzDao = wbjkdyczrzDao;
	}
	public IWbjkczrzmxDao getWbjkczrzmxDao() {
		return wbjkczrzmxDao;
	}
	public void setWbjkczrzmxDao(IWbjkczrzmxDao wbjkczrzmxDao) {
		this.wbjkczrzmxDao = wbjkczrzmxDao;
	}





	public IDict_itemDao getDict_itemDao() {
		return dict_itemDao;
	}





	public void setDict_itemDao(IDict_itemDao dict_itemDao) {
		this.dict_itemDao = dict_itemDao;
	}

}
