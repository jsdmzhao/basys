package com.aisino2.publicsystem.service;

import com.aisino2.publicsystem.domain.GgQyyh;





public interface IGgQyyhService {

	
	
	/** 同步增加企业员工用户 */
	public int insertQyYgyh(GgQyyh qyyh);
	
	/** 同步修改企业员工用户 */
	public int updateQyYgyh(GgQyyh qyyh);

	/** 同步注销企业员工用户 */
	public int zhuxQyYgyh(GgQyyh qyyh);

	/** 同步删除企业员工用户 */
	public int delQyYgyh(GgQyyh qyyh);
	
	

}
