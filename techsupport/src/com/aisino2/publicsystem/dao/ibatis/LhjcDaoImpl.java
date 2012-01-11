package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.ILhjcDao;
import com.aisino2.publicsystem.domain.Lhjc;
import com.aisino2.publicsystem.domain.Qyjbxx;

public class LhjcDaoImpl extends BaseDao implements ILhjcDao {
	/** @param 联合检查(t_lhjc) 增加 */
	public Lhjc insertLhjc(Lhjc lhjc){
		// TODO: implement
		lhjc.setLhjcid(getNextID("lhjcid"));
		return (Lhjc)insert("insertLhjc", lhjc);
	}

	/** @param 联合检查(t_lhjc) 删除 */
	public int deleteLhjc(Lhjc lhjc){
		// TODO: implement
		return delete("deleteLhjc", lhjc);
	}

	/** @param 联合检查(t_lhjc) 修改 */
	public int updateLhjc(Lhjc lhjc){
		// TODO: implement
		return update("updateLhjc", lhjc);
	}

	/** @param 联合检查(t_lhjc) 查询单条 */
	public Lhjc getLhjc(Lhjc lhjc){
		// TODO: implement
		return (Lhjc)queryForObject("getLhjc", lhjc);
	}
	/** @param 查询单条企业基本信息 */
	public Qyjbxx getLhjc(Qyjbxx qyjbxx){
		// TODO: implement
		return (Qyjbxx)queryForObject("getQyjbxx", qyjbxx);
	}

	/** @param 联合检查(t_lhjc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " t.qymc "+ desc;
			else if (sort.equals("1"))
				sCol = " a.glbmlhjcdjxh "+ desc;
			else if (sort.equals("2"))
				sCol = " a.lcjgjb "+ desc;
			else if (sort.equals("3"))
				sCol = " a.lcjglx "+ desc;
			else if (sort.equals("4"))
				sCol = " a.lcjgmc "+ desc;
			else if (sort.equals("5"))
				sCol = " a.lcsj "+ desc;
			else if (sort.equals("6"))
				sCol = " a.lcryxm "+ desc;
			else 
				sCol="a.kyqkid desc";
		}else{
			sCol="a.Csid desc";
		}
		
		if (sort!=null){
		}else{
			sCol="a.lhjcid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getLhjcList", map, pageNo,pageSize);
	}

	/** @param 联合检查(t_lhjc) 多条查询 */
	public List getListLhjc(Lhjc lhjc){
		// TODO: implement
		return queryForList("getLhjcListNoPage", lhjc);
	}
}
