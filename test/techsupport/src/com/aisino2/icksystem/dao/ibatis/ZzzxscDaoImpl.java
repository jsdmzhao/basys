package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IZzzxscDao;
import com.aisino2.icksystem.domain.Zzzxsc;

public class ZzzxscDaoImpl extends BaseDao implements IZzzxscDao {
	/** @param 制证中心上传(t_zzzxsc) 增加 */
	public Zzzxsc insertZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		zzzxsc.setZzzxscid(getNextID("Zzzxscid"));
		return (Zzzxsc)insert("insertZzzxsc", zzzxsc);
	}

	/** @param 制证中心上传(t_zzzxsc) 删除 */
	public int deleteZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		return delete("deleteZzzxsc", zzzxsc);
	}

	/** @param 制证中心上传(t_zzzxsc) 修改 */
	public int updateZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		return update("updateZzzxsc", zzzxsc);
	}

	/** @param 制证中心上传(t_zzzxsc) 查询单条 */
	public Zzzxsc getZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		return (Zzzxsc)queryForObject("getZzzxsc", zzzxsc);
	}

	/** @param 制证中心上传(t_zzzxsc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getZzzxscList", map, pageNo,pageSize);
	}

	/** @param 制证中心上传(t_zzzxsc) 多条查询 */
	public List getListZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		return queryForList("getZzzxscListNoPage", zzzxsc);
	}
}
