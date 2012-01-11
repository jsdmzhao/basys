package com.aisino2.icksystem.dao;
import java.util.List;

import com.aisino2.publicsystem.domain.Qyyyrztj;
public interface IGzrztjDao {
	/** @param 营业日志分析按人员 多条查询 */
	List getListForPagePeop(Qyyyrztj qyyyrztj);
	
	/** @param 营业日志分析按人员 多条查询 行数*/
	Integer getPeopRows(Qyyyrztj qyyyrztj);
	
	/** @param 营业日志分析按场所 多条查询 */
	List getListForPageUnit(Qyyyrztj qyyyrztj);
	
	/** @param 营业日志分析按场所 多条查询 行数*/
	Integer getUnitRows(Qyyyrztj qyyyrztj);
}
