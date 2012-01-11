package com.aisino2.publicsystem.dao;
import com.aisino2.publicsystem.domain.Qyzhtb;
public interface IQyzhtbDao {
	/** 同步增加场所用户 */
	int insertQyzhtb(Qyzhtb qyzhtb);
	/** 同步注销场所用户 */
	int deleteQyzhtb(Qyzhtb qyzhtb);
	
	/** 同步修改场所用户 */
	int updateQyzhtb(Qyzhtb qyzhtb);
}

