package com.aisino2.icksystem.service;

import java.util.List;

import com.aisino2.core.service.PageService;

public interface IIckAcceptErrorServiceWS extends PageService {
	/**
	 * 更新放送成功ick信息
	 * @return
	 */
	String getUpdateAcceptIckInfo(List  list);
	
}
