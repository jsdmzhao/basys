package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bjbdtj;
import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.core.dao.Page;
public interface IBjbdtjDao {
	/** @param 报警比对条件(t_bjbdtj) 增加 */
	Bjbdtj insertBjbdtj(Bjbdtj bjbdtj);

	/** @param 报警比对条件(t_bjbdtj) 删除 */
	int deleteBjbdtj(Bjbdtj bjbdtj);

	/** @param 报警比对条件(t_bjbdtj) 修改 */
	int updateBjbdtj(Bjbdtj bjbdtj);

	/** @param 报警比对条件(t_bjbdtj) 查询单条 */
	Bjbdtj getBjbdtj(Bjbdtj bjbdtj);
	
	/**通过比对规则获取比对条件*/
	String getBjbdtjSql(Bjgz bjgz,Bjxxb bjxxbIn);

	/** @param 报警比对条件(t_bjbdtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 报警比对条件(t_bjbdtj) 多条查询 */
	List getListBjbdtj(Bjbdtj bjbdtj);
}
