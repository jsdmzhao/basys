package com.aisino2.icksystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIckslDao;
import com.aisino2.icksystem.dao.IIcksl_ickzbDao;
import com.aisino2.icksystem.dao.IIcksl_wldjDao;
import com.aisino2.icksystem.dao.IIckzbDao;
import com.aisino2.icksystem.dao.IWldjDao;
import com.aisino2.icksystem.dao.IZzzxscDao;
import com.aisino2.icksystem.domain.AcceptIckInfoWs;
import com.aisino2.icksystem.domain.AcceptIckWlInfoWs;
import com.aisino2.icksystem.domain.AcceptIckZbInfoWs;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.domain.Icksl_wldj;
import com.aisino2.icksystem.domain.Ickzb;
import com.aisino2.icksystem.domain.Wldj;
import com.aisino2.icksystem.domain.Zzzxsc;
import com.aisino2.icksystem.service.IIckAcceptServiceWS;

public class IckAcceptServiceWsImpl extends BaseService implements IIckAcceptServiceWS {

	private IIckzbDao ickzbDao;
	private IIcksl_ickzbDao ickslickzbDao;
	private IZzzxscDao zzzxscDao;
	
	public IZzzxscDao getZzzxscDao() {
		return zzzxscDao;
	}

	public void setZzzxscDao(IZzzxscDao zzzxscDao) {
		this.zzzxscDao = zzzxscDao;
	}

	private IWldjDao wldjDao;
	private IIcksl_wldjDao ickslwldjDao;
	
	private IIckslDao ickslDao;
	
	public Page getPage(Map arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getUpdateAcceptIckInfo(AcceptIckInfoWs acceptIckInfoWs) {
		// TODO Auto-generated method stub
		//test start
//			 Icksl ickslOnea = new Icksl();
//			//对icksl操作
//			 Icksl ickslOldTwoa = new Icksl();
//			  ickslOldTwoa.setIckslid(374);
//			  ickslOldTwoa = ickslDao.getIcksl(ickslOldTwoa);
//			  //设置Ryid
//			  ickslOnea.setRyid(ickslOldTwoa.getRyid());
//			 // ickslOnea.setIckzbbz(1);//已组包
//			 // ickslOnea.setWldjbz(1);//物流包已发送
//			 // ickslOnea.setZkztbs("3");//已电写入
//			  ickslOnea.setJszkzxsj(new Date());
//			  ickslDao.updateIcksl(ickslOnea);
		//test end
		
		
		
		if(acceptIckInfoWs==null){
			return 0;
		}else{
			Zzzxsc zzzxsc=new Zzzxsc();
			List   acceptIckZbInfoWsList =  acceptIckInfoWs.getAcceptIckZbInfoWsList();
			 List   acceptIckWlInfWsList = acceptIckInfoWs.getAcceptIckWlInfWsList();
			 List   acceptErrorIckslList = acceptIckInfoWs.getAcceptErrorIckslList();
			 //更改组包
			if(acceptIckZbInfoWsList!=null&&acceptIckZbInfoWsList.size()>0){
				AcceptIckZbInfoWs acceptIckZbInfoWs = new AcceptIckZbInfoWs();
				 Ickzb ickzb = new Ickzb();
				 List ickslZbList = new ArrayList();
				 Icksl_ickzb ickslickzb = new Icksl_ickzb();
				 List ickslList = new ArrayList();
				 Icksl icksl = new Icksl() ;
				 Icksl ickslOld = new Icksl() ;
						 for(int j=0;j<acceptIckZbInfoWsList.size();j++){
							 acceptIckZbInfoWs = (AcceptIckZbInfoWs) acceptIckZbInfoWsList.get(j);
							  ickzb = acceptIckZbInfoWs.getIckzb();
							  ickslZbList = ickzb.getLIcksl_ickzb();
							  //对ickzb操作
							  ickzb = ickzbDao.insertIckzb(ickzb);
							  //对受理组包中间表操作
							  for(int bb=0;bb<ickslZbList.size();bb++){
								    ickslickzb=  (Icksl_ickzb) ickslZbList.get(bb);
								    icksl = new Icksl();
								    icksl.setIckslid(ickslickzb.getIckslid());
								    icksl = ickslDao.getIcksl(icksl);
								    ickslickzb.setZbid(ickzb.getZbid());
								    /*ickslickzb.setRyid(icksl.getRyid());
								    ickslickzb.setCsid(icksl.getCsid());*/
								    ickslickzbDao.insertIcksl_ickzb(ickslickzb);
							  }
							  ickslList =  acceptIckZbInfoWs.getIckslList();
							  for(int m=0;m<ickslList.size();m++){
								  icksl = (Icksl) ickslList.get(m);
								//对icksl操作
								  ickslOld = new Icksl();
								  ickslOld.setIckslid(icksl.getIckslid());
								  ickslOld = ickslDao.getIcksl(ickslOld);
								  
								  icksl.setRyid(ickslOld.getRyid());
								  icksl.setZkztbs("5");//已组包
								  zzzxsc=new Zzzxsc();
								  zzzxsc.setHksj(new Date());
								  zzzxsc.setSjscbz("2");
								  zzzxsc.setIckslid(icksl.getIckslid());
								  //zzzxsc.setRyid(ickslOld.getRyid());
								  zzzxscDao.updateZzzxsc(zzzxsc);
								  ickslDao.updateIcksl(icksl);
							  }
						 }
						 
					 }
			//更改物流		 
			 if(acceptIckWlInfWsList!=null&&acceptIckWlInfWsList.size()>0){
				 AcceptIckWlInfoWs acceptIckWlInfoWs = new AcceptIckWlInfoWs();
				 Wldj wldj = new Wldj();
					 List ickslListOne = new ArrayList();
					 Icksl ickslOne = new Icksl();
					 List ickslWlList = new ArrayList();
					 Icksl_wldj ickslwldj = new Icksl_wldj();
					 Icksl ickslOldTwo = new Icksl();
							 for(int k=0;k<acceptIckWlInfWsList.size();k++){
								 acceptIckWlInfoWs = (AcceptIckWlInfoWs) acceptIckWlInfWsList.get(k);
								 wldj =(Wldj)acceptIckWlInfoWs.getWldj();
								 wldj.setZtdm("1");
								 wldj.setZtdmmc("已发送");
								
								 ickslWlList = wldj.getLIcksl_wldj();
								  //对Wldj操作
								 wldj.setBnksl(ickslWlList.size());
								 wldj =wldjDao.insertWldjWs(wldj);
								 
								 //对受理物流中间表操作
								 for(int bb=0;bb<ickslWlList.size();bb++){
									 ickslwldj=  (Icksl_wldj) ickslWlList.get(bb);
									 ickslOne = new Icksl();
									 ickslOne.setIckslid(ickslwldj.getIckslid());
									 ickslOne = ickslDao.getIcksl(ickslOne);
									 ickslwldj.setWlid(wldj.getWlid());
									 /*ickslwldj.setRyid(ickslOne.getRyid());
									 ickslwldj.setCsid(ickslOne.getCsid());*/
									 ickslwldjDao.insertIcksl_wldj(ickslwldj);
								  }
				
								 ickslListOne =  acceptIckWlInfoWs.getIckslList();
								  for(int n=0;n<ickslListOne.size();n++){
									  ickslOne = (Icksl) ickslListOne.get(n);
									//对icksl操作
									  ickslOldTwo = new Icksl();
									  ickslOldTwo.setIckslid(ickslOne.getIckslid());
									  ickslOldTwo = ickslDao.getIcksl(ickslOldTwo);
									  //设置Ryid
									  ickslOne.setRyid(ickslOldTwo.getRyid());
									  ickslOne.setZkztbs("23");//已电写入
									  zzzxsc=new Zzzxsc();
									  zzzxsc.setHksj(new Date());
									  zzzxsc.setIckslid(ickslOne.getIckslid());
									  ickslDao.updateIcksl(ickslOne);
									  
								  }
							 }
							 	 
							 
						 }
			 //更改错误的icksl
			 if(acceptErrorIckslList!=null&&acceptErrorIckslList.size()>0){
				 Icksl ickslTwo = new Icksl();
				 Icksl ickslOldThird = new Icksl();
				 for(int a=0;a<acceptErrorIckslList.size();a++){
					 ickslTwo = (Icksl)acceptErrorIckslList.get(a);
					//对icksl操作
					 ickslOldThird = new Icksl();
					 ickslOldThird.setIckslid(ickslTwo.getIckslid());
					 ickslOldThird = ickslDao.getIcksl(ickslOldThird);
					 
					 ickslTwo.setRyid(ickslOldThird.getRyid());
					 ickslTwo.setZkztbs("2");
					 zzzxsc=new Zzzxsc();
					 zzzxsc.setHksj(new Date());
					 zzzxsc.setSjscbz("4");
					 zzzxsc.setIckslid(ickslOldThird.getIckslid());
					 //zzzxsc.setRyid(ickslOldThird.getRyid());
					 zzzxscDao.updateZzzxsc(zzzxsc);
					 ickslDao.updateIcksl(ickslTwo);
				 }
				 
			 }
			
			return 1;
		}
		
	}

	public IIckzbDao getIckzbDao() {
		return ickzbDao;
	}

	public void setIckzbDao(IIckzbDao ickzbDao) {
		this.ickzbDao = ickzbDao;
	}

	public IIcksl_ickzbDao getIckslickzbDao() {
		return ickslickzbDao;
	}

	public void setIckslickzbDao(IIcksl_ickzbDao ickslickzbDao) {
		this.ickslickzbDao = ickslickzbDao;
	}

	public IWldjDao getWldjDao() {
		return wldjDao;
	}

	public void setWldjDao(IWldjDao wldjDao) {
		this.wldjDao = wldjDao;
	}

	public IIcksl_wldjDao getIckslwldjDao() {
		return ickslwldjDao;
	}

	public void setIckslwldjDao(IIcksl_wldjDao ickslwldjDao) {
		this.ickslwldjDao = ickslwldjDao;
	}

	public IIckslDao getIckslDao() {
		return ickslDao;
	}

	public void setIckslDao(IIckslDao ickslDao) {
		this.ickslDao = ickslDao;
	}

	
}
