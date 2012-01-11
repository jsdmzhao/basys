package com.aisino2.icksystem.service;

import java.util.List;

import com.aisino2.core.service.PageService;

public interface IIckSendServiceWS extends PageService {
/**
 * 取得放送ick信息
 * @return
 */
	List getSendIckInfoList();
	/**
	 * 更新放送成功ick信息
	 * @return
	 */
	int getUpdateSendIckInfo(List list);
	
}
