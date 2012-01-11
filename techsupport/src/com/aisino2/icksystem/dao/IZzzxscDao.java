package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Zzzxsc;
public interface IZzzxscDao {
	/** @param 制证中心上传(t_zzzxsc) 增加 */
	Zzzxsc insertZzzxsc(Zzzxsc zzzxsc);

	/** @param 制证中心上传(t_zzzxsc) 删除 */
	int deleteZzzxsc(Zzzxsc zzzxsc);

	/** @param 制证中心上传(t_zzzxsc) 修改 */
	int updateZzzxsc(Zzzxsc zzzxsc);

	/** @param 制证中心上传(t_zzzxsc) 查询单条 */
	Zzzxsc getZzzxsc(Zzzxsc zzzxsc);

	/** @param 制证中心上传(t_zzzxsc) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 制证中心上传(t_zzzxsc) 多条查询 */
	List getListZzzxsc(Zzzxsc zzzxsc);
}
