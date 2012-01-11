package com.aisino2.icksystem.service;

import com.aisino2.core.service.PageService;
import com.aisino2.icksystem.domain.AcceptIckInfoWs;

public interface IIckAcceptServiceWS extends PageService {
	/**
	 * 更新放送成功ick信息
	 * @return
	 */
	int getUpdateAcceptIckInfo(AcceptIckInfoWs acceptIckInfoWs);
	
}
