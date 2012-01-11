package com.aisino2.basicsystem.dao.ibatis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGjcxfaDao;
import com.aisino2.basicsystem.domain.Dtcxpx;
import com.aisino2.basicsystem.domain.Dtcxtj;
import com.aisino2.basicsystem.domain.Gjcxfa;
import com.aisino2.basicsystem.domain.Zdycxtj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class GjcxfaDaoImpl extends BaseDao implements IGjcxfaDao {
	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 增加
	 */
	public static final String DYNAMICQUERY = "动态";
	public static final String CUSTOMIZESQL = "SQL";

	public Gjcxfa insertGjcxfa(Gjcxfa gjcxfa) {
		// TODO: implement
		gjcxfa.setGjcxfaid(getNextID("Gjcxfaid"));
		Gjcxfa re = (Gjcxfa) insert("insertGjcxfa", gjcxfa);
		if (gjcxfa.getGjcxlx().equalsIgnoreCase(DYNAMICQUERY)) {
			insertDtcxtj(gjcxfa);
			insertDtcxpx(gjcxfa);
		}
		if (gjcxfa.getGjcxlx().equalsIgnoreCase(CUSTOMIZESQL)) {
			insertZdycxtj(gjcxfa);
		}
		return re;
	}

	private void insertZdycxtj(Gjcxfa gjcxfa) {
		Zdycxtj zdycxtj = gjcxfa.getZdycxtj();
		if (zdycxtj != null) {
			zdycxtj.setZdycxtjid(getNextID("Zdycxtj"));
			zdycxtj.setGjcxfaid(gjcxfa.getGjcxfaid());
			insert("insertZdycxtj", zdycxtj);
		}
	}

	private void insertDtcxpx(Gjcxfa gjcxfa) {
		Iterator it = gjcxfa.getLPxgz_table().iterator();
		while (it.hasNext()) {
			Dtcxpx dtcxpx = (Dtcxpx) it.next();
			dtcxpx.setDtcxpxid(getNextID("Dtcxpxid"));
			dtcxpx.setGjcxfaid(gjcxfa.getGjcxfaid());
			insert("insertDtcxpx", dtcxpx);
		}
	}

	private void insertDtcxtj(Gjcxfa gjcxfa) {
		Iterator it = gjcxfa.getLPptj_table().iterator();
		while (it.hasNext()) {
			Dtcxtj dtcxtj = (Dtcxtj) it.next();
			dtcxtj.setDtcxtjid(getNextID("Dtcxtjid"));
			dtcxtj.setGjcxfaid(gjcxfa.getGjcxfaid());
			insert("insertDtcxtj", dtcxtj);
		}
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 删除
	 */
	public int deleteGjcxfa(Gjcxfa gjcxfa) {
		// TODO: implement
		deleteDtcxtj(gjcxfa);
		deleteDtcxpx(gjcxfa);
		deleteZdycxtj(gjcxfa);
		return delete("deleteGjcxfa", gjcxfa);
	}

	private void deleteZdycxtj(Gjcxfa gjcxfa) {
		Zdycxtj zdycxtj = new Zdycxtj();
		zdycxtj.setGjcxfaid(gjcxfa.getGjcxfaid());
		delete("deleteZdycxtj", zdycxtj);
	}

	private void deleteDtcxpx(Gjcxfa gjcxfa) {
		Dtcxpx dtcxpx = new Dtcxpx();
		dtcxpx.setGjcxfaid(gjcxfa.getGjcxfaid());
		delete("deleteDtcxpx", dtcxpx);
	}

	private void deleteDtcxtj(Gjcxfa gjcxfa) {

		Dtcxtj dtcxtj = new Dtcxtj();
		dtcxtj.setGjcxfaid(gjcxfa.getGjcxfaid());
		delete("deleteDtcxtj", dtcxtj);

	}

	public int updateGjcxfa(Gjcxfa gjcxfa) {

//		if (gjcxfa.getGjcxlx().equalsIgnoreCase(DYNAMICQUERY)) {
//			deleteDtcxtj(gjcxfa);
//			deleteDtcxpx(gjcxfa);
//			insertDtcxtj(gjcxfa);
//			insertDtcxpx(gjcxfa);
//		}
//		if (gjcxfa.getGjcxlx().equalsIgnoreCase(CUSTOMIZESQL)) {
//			deleteZdycxtj(gjcxfa);
//			insertZdycxtj(gjcxfa);
//		}
//		return 1;
		return 0;
	}

	public int updateGjcxfamc(Gjcxfa gjcxfa) {

		return update("updateGjcxfa", gjcxfa);
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 查询单条
	 */
	public Gjcxfa getGjcxfa(Gjcxfa gjcxfa) {
		// TODO: implement
		Gjcxfa result = (Gjcxfa) queryForObject("getGjcxfa", gjcxfa);
		if (result != null) {
			if (result.getGjcxlx().equalsIgnoreCase(DYNAMICQUERY)) {
				result.setLPptj_table(getDtcxtjList(gjcxfa));
				result.setLPxgz_table(getDtcxpxList(gjcxfa));
			}
			if (result.getGjcxlx().equalsIgnoreCase(CUSTOMIZESQL))
				result.setZdycxtj(getZdycxtj(gjcxfa));
		}

		return result;
	}

	private Zdycxtj getZdycxtj(Gjcxfa gjcxfa) {
		Zdycxtj zdycxtj = new Zdycxtj();
		zdycxtj.setGjcxfaid(gjcxfa.getGjcxfaid());
		return (Zdycxtj) queryForObject("getZdycxtj", zdycxtj);
	}

	private List getDtcxpxList(Gjcxfa gjcxfa) {
		Dtcxpx dtcxpx = new Dtcxpx();
		dtcxpx.setGjcxfaid(gjcxfa.getGjcxfaid());
		return queryForList("getDtcxpxListNoPage", dtcxpx);
	}

	private List getDtcxtjList(Gjcxfa gjcxfa) {
		Dtcxtj dtcxtj = new Dtcxtj();
		dtcxtj.setGjcxfaid(gjcxfa.getGjcxfaid());
		return queryForList("getDtcxtjListNoPage", dtcxtj);
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		// TODO: implement
		String sCol = "";
		if (sort != null) {
		} else {
			sCol = "a.Gjcxfaid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getGjcxfaList", map, pageNo, pageSize);
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 多条查询
	 */
	public List getListGjcxfa(Gjcxfa gjcxfa) {
		// TODO: implement
		return queryForList("getGjcxfaListNoPage", gjcxfa);
	}
}
