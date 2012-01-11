package com.aisino2.publicsystem.service;

import com.aisino2.basicsystem.domain.Gabrkxx;
import com.aisino2.publicsystem.domain.Qyryxx;

public interface ICheckQyryxxService {
	
	/** @param 公安人口库比对程序  更新从业人员状态及制卡状态，且比对错误信息插入t_garkktbsj表及t_cyryxxhc表*/
	boolean updateCheckCyryxx(Qyryxx qyryxx) throws Exception;
	/**
	 * 关掉比对开关时，将人员自动置为已核对
	 * @param qyryxx
	 */
	void updateFindRecord(Qyryxx qyryxx) throws Exception;
	/**
	 * 与公安人口库比对，返回姓名相符记录时，对人员状态和制卡状态置位
	 * @param qyryxx
	 */
	void updateFindCorrectRecord(Qyryxx qyryxx) throws Exception;
	/**
	 * 与公安人口库比对，返回姓名不相符记录或空记录(查无此人)时对人员状态和制卡状态置位，并插入t_garkktbsj和t_qyryxxhc
	 * @param qyryxx
	 * @param gabrkxx 从公安人口库返回的人员信息
	 * @param hcFlag 与公安人口库比对后的标志 0-未找到此人，1-姓名相符，2-姓名不符，-1-web服务内部错误，-2-没有权限访问wb服务
	 * @throws Exception 
	 */
	void updateFindUncorrectRecord(Qyryxx qyryxx,Gabrkxx gabrkxx,int hcFlag) throws Exception;
}
