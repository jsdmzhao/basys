package com.aisino2.icksystem.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIckslDao;
import com.aisino2.icksystem.dao.IZzzxscDao;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Zzzxsc;
import com.aisino2.icksystem.service.IIckAcceptErrorServiceWS;

public class IckAcceptErrorServiceWsImpl extends BaseService implements IIckAcceptErrorServiceWS {


	private IIckslDao ickslDao;
	private IZzzxscDao zzzxscDao;
	
	public IZzzxscDao getZzzxscDao() {
		return zzzxscDao;
	}

	public void setZzzxscDao(IZzzxscDao zzzxscDao) {
		this.zzzxscDao = zzzxscDao;
	}

	public Page getPage(Map arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUpdateAcceptIckInfo(List list) {
		// TODO Auto-generated method stub
		String sApplyID="";
		if(list==null||list.size()==0){
			return sApplyID;
		}else{
				 Icksl ickslTwo = new Icksl();
				 Icksl ickslOldThird = new Icksl();
				 Zzzxsc zzzxsc=new Zzzxsc();
				 for(int a=0;a<list.size();a++){
					 ickslTwo = (Icksl)list.get(a);
					//对icksl操作
					 ickslOldThird = new Icksl();
					 ickslOldThird.setIckslid(ickslTwo.getIckslid());
					 ickslOldThird = ickslDao.getIcksl(ickslOldThird);
					 if (ickslOldThird!=null){
						 ickslTwo.setRyid(ickslOldThird.getRyid());
						 ickslTwo.setZkztbs("11");
						 ickslDao.updateIcksl(ickslTwo);
						 zzzxsc=new Zzzxsc();
						 zzzxsc.setHksj(new Date());
						 zzzxsc.setSjscbz("3");
						 zzzxsc.setIckslid(ickslOldThird.getIckslid());
						 //zzzxsc.setRyid(ickslOldThird.getRyid());
						 zzzxscDao.updateZzzxsc(zzzxsc);
						 if (sApplyID.equals(""))
							 sApplyID=""+ickslTwo.getIckslid();
						 else
							 sApplyID+=","+ickslTwo.getIckslid();
					 }
				 }
			 }
			return sApplyID;
		}
		


	public IIckslDao getIckslDao() {
		return ickslDao;
	}

	public void setIckslDao(IIckslDao ickslDao) {
		this.ickslDao = ickslDao;
	}

	
}
