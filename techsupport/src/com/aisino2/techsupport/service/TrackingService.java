package com.aisino2.techsupport.service;

import java.util.List;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;

public interface TrackingService {
	/**
	 * 提请反馈（即插入并且移动流程）
	 * @param tracking 追踪批复实体
	 * @param taskId 流程ID
	 * @return 插入后的 追踪批复
	 */
	Tracking insertTrackingAndGo(Tracking tracking,String taskId,SupportTicket st);
	/**
	 * 保存新进度
	 * @param tracking 追踪批复实体
	 * @return 插入后的 追踪批复
	 */
	Tracking insertTracking(Tracking tracking);
	/**
	 * 修改 追踪批复
	 * @param tracking 追踪批复实体
	 * @return 是否修改成功
	 */
	int updateTracking(Tracking tracking);
	/**
	 * 删除 追踪批复
	 * @param tracking 追踪批复实体
	 * @return 是否修改成功
	 */
	int deleteTracking(Tracking tracking);
	/**
	 * 获取 追踪批复列表 (不分页)
	 * @param tracking 追踪批复(查询条件)
	 * @return 追踪批复列表
	 */ 
	List<Tracking> getTrackingList(Tracking tracking);
	/**
	 * 获取 追踪批复列表 (分页)
	 * @param pageno 页数
	 * @param pagesize 页最大记录
	 * @param tracking 追踪批复
	 * @param sort 排序 “0” 通过ID，“1” 通过 地区区域代码，“2” 通过填写日期，其他 通过填写人员 进行排序
	 * @param desc 升序或者降序
	 * @return 追踪批复列表 PAGE
	 */
	Page getTrackingListForPage(int pageno,int pagesize,Tracking tracking,String sort,String desc);
	/**
	 * 获取 单一 追踪批复实体
	 * @param tracking 追踪批复实体(查询条件需要id)
	 * @return 追踪批复实体
	 */
	Tracking getTracking(Tracking tracking);
}
