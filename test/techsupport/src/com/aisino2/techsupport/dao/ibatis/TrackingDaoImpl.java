package com.aisino2.techsupport.dao.ibatis;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.dao.TrackingDao;
import com.aisino2.techsupport.domain.Tracking;


/**
 * 追踪批复 数据库访问 
 *
 */
@Component("TrackingDaoImpl")
public class TrackingDaoImpl extends TechSupportBaseDao implements TrackingDao {

	public Tracking insertTracking(Tracking tracking) {
		tracking.setId(this.getNextID("SEQ_TS_TRACK"));
		return (Tracking) insert("tracking.insert", tracking);
		
	}

	public int updateTracking(Tracking tracking) {
		return update("tracking.update", tracking);
	}

	public int deleteTracking(Tracking tracking) {
		return delete("tracking.delete", tracking);
	}

	@SuppressWarnings("unchecked")
	public List<Tracking> getTrackingList(Tracking tracking) {
		
		return queryForList("tracking.getList", tracking);
	}

	
	public Page getTrackingListForPage(int pageNo, int pagesize,
			Tracking tracking,String sort, String desc) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String sCol="";
		
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " t.id "+ desc;
			else if(sort.equals("1"))
				sCol = " t.REGION "+ desc;
			else if(sort.equals("2"))
				sCol = " t.TRACKING_DATE "+ desc;
			else if(sort.equals("99"))
				sCol = " t.TYPE " + desc;
			else
				sCol = " t.id " + desc;
		}else{
			sCol=" t.id ";
		}
		
		if(tracking!=null){
			if(tracking.getStId()!=null)
				params.put("stId",tracking.getStId());
			if(tracking.getTrackingDate()!=null)
				params.put("trackingDate", tracking.getTrackingDate());
		}
			
		params.put("pageSort", sCol);
		return queryForPage("tracking.getPage", params, pageNo,pagesize);
	}
	
	public Tracking getTracking(Tracking tracking){
		
		return (Tracking) queryForObject("tracking.get", tracking);
	}
}
