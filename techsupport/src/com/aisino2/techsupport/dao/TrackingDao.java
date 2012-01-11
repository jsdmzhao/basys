package com.aisino2.techsupport.dao;

import java.util.List;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.domain.Tracking;

public interface TrackingDao {
	Tracking insertTracking(Tracking tracking);
	int updateTracking(Tracking tracking);
	int deleteTracking(Tracking tracking);
	List<Tracking> getTrackingList(Tracking tracking);
	Page getTrackingListForPage(int pageno,int pagesize,Tracking tracking,String sort,String desc);
	Tracking getTracking(Tracking tracking);
}
