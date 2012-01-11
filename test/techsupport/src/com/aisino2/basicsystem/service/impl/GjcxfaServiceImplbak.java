package com.aisino2.basicsystem.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGjcxfaDao;
import com.aisino2.basicsystem.dao.ISjbDao;
import com.aisino2.basicsystem.dao.ISjbjgDao;
import com.aisino2.basicsystem.dao.ibatis.GjcxfaDaoImpl;
import com.aisino2.basicsystem.domain.Dtcxpx;
import com.aisino2.basicsystem.domain.Dtcxtj;
import com.aisino2.basicsystem.domain.Gjcxfa;
import com.aisino2.basicsystem.domain.Sjb;
import com.aisino2.basicsystem.domain.Sjbjg;
import com.aisino2.basicsystem.service.IGjcxfaService;
import com.aisino2.cache.CacheManager;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.Dict_item;

public class GjcxfaServiceImplbak extends BaseService implements IGjcxfaService {

	private IGjcxfaDao gjcxfaDao;

	private ISjbDao sjbDao;
	private ISjbjgDao sjbjgDao;

	public ISjbjgDao getSjbjgDao() {
		return sjbjgDao;
	}

	public void setSjbjgDao(ISjbjgDao sjbjgDao) {
		this.sjbjgDao = sjbjgDao;
	}

	public ISjbDao getSjbDao() {
		return sjbDao;
	}

	public void setSjbDao(ISjbDao sjbDao) {
		this.sjbDao = sjbDao;
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 增加
	 */
	public Gjcxfa insertGjcxfa(Gjcxfa gjcxfa) {
		// TODO: implement
		dealGjcxfa(gjcxfa);

		return (Gjcxfa) gjcxfaDao.insertGjcxfa(gjcxfa);
	}

	private void dealGjcxfa(Gjcxfa gjcxfa) {
		if (gjcxfa == null)
			return;
		List tj = new ArrayList();
		Iterator it = gjcxfa.getLPptj_table().iterator();
		while (it.hasNext()) {
			tj.add(decodeByDictionary(fullBean((Dtcxtj) it.next())));
		}
		gjcxfa.setLPptj_table(tj);

		List px = new ArrayList();
		Iterator it1 = gjcxfa.getLPxgz_table().iterator();
		while (it1.hasNext()) {
			px.add(decodeByDictionary(fullBean((Dtcxpx) it1.next())));
		}
		gjcxfa.setLPxgz_table(px);
	}

	/**
	 * 将如逻辑符，匹配符的实际值转化成为现实值
	 * 
	 * @param dtcxpx
	 * @return
	 */
	private Dtcxpx decodeByDictionary(Dtcxpx dtcxpx) {

		decode(dtcxpx, "");

		return dtcxpx;
	}

	/**
	 * 暂用
	 * 
	 * @param dtcxpx
	 * @param dict_code
	 */
	private void decode(Dtcxpx dtcxpx, String dict_code) {
		if (dtcxpx.getPxfs().equalsIgnoreCase("顺序")) {
			dtcxpx.setPxfs("asc");
		}
		if (dtcxpx.getPxfs().equalsIgnoreCase("倒序")) {
			dtcxpx.setPxfs("desc");
		}
	}

	/**
	 * 将如逻辑符，匹配符的实际值转化成为现实值
	 * 
	 * @param dtcxtj
	 * @return
	 */
	private Dtcxtj decodeByDictionary(Dtcxtj dtcxtj) {

		 decode(dtcxtj, "dm_ljf");
		 decode(dtcxtj, "dm_ppf");

		return dtcxtj;
	}

	private void decode(Dtcxtj dtcxtj, String dict_code) {
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(dict_code);
		if (dict_code.equalsIgnoreCase("dm_ljf")) {
			dict_item.setDisplay_name(dtcxtj.getGxf());
			
			List list = CacheManager.getCacheDictitem(dict_item);
			if (list != null && list.size() > 0)
				dtcxtj.setGxf(((Dict_item) list.get(0)).getFact_value());
		}
		if (dict_code.equalsIgnoreCase("dm_ppf")) {
			dict_item.setDisplay_name(dtcxtj.getPpf());

			List list = CacheManager.getCacheDictitem(dict_item);
			if (list != null && list.size() > 0)
				dtcxtj.setPpf(((Dict_item) list.get(0)).getFact_value());
		}
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 删除
	 */
	public boolean deleteGjcxfa(Gjcxfa gjcxfa) {
		// TODO: implement
		if (gjcxfa == null)
			return false;
		return gjcxfaDao.deleteGjcxfa(gjcxfa) > 0;
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 修改
	 */
	public boolean updateGjcxfa(Gjcxfa gjcxfa) {
		// TODO: implement
		deleteGjcxfa(gjcxfa);
		insertGjcxfa(gjcxfa);
		return true;
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 查询单条
	 */
	public Gjcxfa getGjcxfa(Gjcxfa gjcxfa) {
		// TODO: implement
		return getGjcxfaEncoded(gjcxfa, true);
	}

	protected Gjcxfa getGjcxfaUnencoded(Gjcxfa gjcxfa) {
		return getGjcxfaEncoded(gjcxfa, false);
	}

	private Gjcxfa getGjcxfaEncoded(Gjcxfa gjcxfa, boolean needEncode) {
		// TODO: implement
		Gjcxfa result = null;
		if (gjcxfaDao.getGjcxfa(gjcxfa) != null) {
			result = (Gjcxfa) gjcxfaDao.getGjcxfa(gjcxfa);
			if (needEncode) {
				List tj = new ArrayList();
				Iterator it = result.getLPptj_table().iterator();
				while (it.hasNext()) {
					tj.add(encodeByDictionary((Dtcxtj) it.next()));
				}
				result.setLPptj_table(tj);

				List px = new ArrayList();
				Iterator its = result.getLPxgz_table().iterator();
				while (its.hasNext()) {
					px.add(encodeByDictionary((Dtcxpx) its.next()));
				}
				result.setLPxgz_table(px);
			}
		}
		return result;
	}

	private Object encodeByDictionary(Dtcxpx dtcxpx) {

		encode(dtcxpx, "");

		return dtcxpx;
	}

	private Dtcxtj encodeByDictionary(Dtcxtj dtcxtj) {

		encode(dtcxtj, "dm_ljf");
		encode(dtcxtj, "dm_ppf");

		return dtcxtj;
	}

	/**
	 * 暂用
	 * 
	 * @param dtcxpx
	 * @param dict_code
	 */
	private void encode(Dtcxpx dtcxpx, String dict_code) {
		if (dtcxpx.getPxfs().equalsIgnoreCase("asc")) {
			dtcxpx.setPxfs("顺序");
		}
		if (dtcxpx.getPxfs().equalsIgnoreCase("desc")) {
			dtcxpx.setPxfs("倒序");
		}
	}

	private void encode(Dtcxtj dtcxtj, String dict_code) {
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(dict_code);
		if (dict_code.equalsIgnoreCase("dm_ljf")) {
			dict_item.setFact_value(dtcxtj.getGxf());
			List list = CacheManager.getCacheDictitem(dict_item);
			if (list != null && list.size() > 0)
				dtcxtj.setGxf(((Dict_item) list.get(0)).getDisplay_name());
		}
		if (dict_code.equalsIgnoreCase("dm_ppf")) {
			dict_item.setFact_value(dtcxtj.getPpf());
			List list = CacheManager.getCacheDictitem(dict_item);
			if (list != null && list.size() > 0)
				dtcxtj.setPpf(((Dict_item) list.get(0)).getDisplay_name());
		}
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 分页查询
	 */
	public Page getListForPage(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		// TODO: implement
		return gjcxfaDao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	/**
	 * @param 高级查询方案
	 *            (t_gjcxfa) 多条查询
	 */
	public List getListGjcxfa(Gjcxfa gjcxfa) {
		// TODO: implement
		return gjcxfaDao.getListGjcxfa(gjcxfa);
	}

	public IGjcxfaDao getGjcxfaDao() {
		return gjcxfaDao;
	}

	public void setGjcxfaDao(IGjcxfaDao gjcxfaDao) {
		this.gjcxfaDao = gjcxfaDao;
	}

	/**
	 * 填充bean的属性
	 * 
	 * @param dtcxtj
	 * @return
	 */
	private Dtcxtj fullBean(Dtcxtj dtcxtj) {
		Sjbjg sjbjg = new Sjbjg();
		sjbjg.setSjbjgid(dtcxtj.getSjbjgid());
		sjbjg = sjbjgDao.getSjbjg(sjbjg);
		dtcxtj.setZdm(sjbjg.getZdm());
		dtcxtj.setZdlx(sjbjg.getZdlx());
		//将dtcxtj的字段值通过显示值转化后添加进bean
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(sjbjg.getXlknr());
		dict_item.setDisplay_name(dtcxtj.getXsz());
		List list = CacheManager.getCacheDictitem(dict_item);
		if (list != null && list.size() > 0)
			dtcxtj.setZdz(((Dict_item) list.get(0)).getFact_value());
		else
			dtcxtj.setZdz(dtcxtj.getXsz());
		
		Sjb sjb = new Sjb();
		sjb.setSjbid(sjbjg.getSjbid());
		sjb = sjbDao.getSjb(sjb);
		dtcxtj.setSjbm(sjb.getSjbm());
		return dtcxtj;
	}

	/**
	 * 填充bean的属性
	 * 
	 * @param dtcxpx
	 * @return
	 */
	private Dtcxpx fullBean(Dtcxpx dtcxpx) {
		Sjbjg sjbjg = new Sjbjg();
		sjbjg.setSjbjgid(dtcxpx.getSjbjgid());
		sjbjg = sjbjgDao.getSjbjg(sjbjg);
		dtcxpx.setZdm(sjbjg.getZdm());
		
		
		
		Sjb sjb = new Sjb();
		sjb.setSjbid(sjbjg.getSjbid());
		sjb = sjbDao.getSjb(sjb);
		dtcxpx.setSjbm(sjb.getSjbm());
		return dtcxpx;
	}

	/**
	 * 取得所有的高级查询方案
	 */
	public List getAllGjcxfa() {
		List result = getListGjcxfa(new Gjcxfa());
		if (result == null)
			return new ArrayList();
		return result;
	}

	/**
	 * 得到最终的sql的wehere条件
	 * 
	 * @param gjcxfa
	 * @param tableAlias
	 *            查询条件中表明的别名
	 */
	public String getQueryCondition(Gjcxfa gjcxfa, String tableAlias) {

		//if (gjcxfa.getGjcxfaid() == null)
			return getQueryConditionNotSaveInDb(gjcxfa, tableAlias);

		//return getQueryConditionFromDb(gjcxfa, tableAlias);
	}

	private String getQueryConditionFromDb(Gjcxfa gjcxfa, String tableAlias) {
		Gjcxfa gjcxfaTemp = getGjcxfaUnencoded(gjcxfa);
		return combineSQL(gjcxfaTemp, tableAlias);
	}

	private String combineSQL(Gjcxfa gjcxfa, String tableAlias) {
		StringBuffer sb = new StringBuffer();
		if (gjcxfa != null) {
			if (gjcxfa.getGjcxlx().equalsIgnoreCase(GjcxfaDaoImpl.DYNAMICQUERY)) {
				List tjList = gjcxfa.getLPptj_table();
				List pxList = gjcxfa.getLPxgz_table();
				sb.append(createTjCondition(tjList, tableAlias));
				sb.append(createPxCondition(pxList, tableAlias,true));
			}
			if (gjcxfa.getGjcxlx().equalsIgnoreCase(GjcxfaDaoImpl.CUSTOMIZESQL))
				sb.append(createZdycxTjCondition(gjcxfa));
		}
		return sb.toString();
	}

	private String getQueryConditionNotSaveInDb(Gjcxfa gjcxfa, String tableAlias) {
		dealGjcxfa(gjcxfa);
		return combineSQL(gjcxfa, tableAlias);
	}

	private String createZdycxTjCondition(Gjcxfa gjcxfa) {
		StringBuffer sb = new StringBuffer();
		sb.append(" " + nulltoBlank(gjcxfa.getZdycxtj().getCxtj()));
		sb.append(" " + nulltoBlank(gjcxfa.getZdycxtj().getCxpx()));
		return sb.toString();
	}

	/**
	 * 得到最终的sql的wehere条件
	 * 
	 * @param gjcxfa
	 *            查询条件中表明的别名默认为"a"
	 */
	public String getQueryCondition(Gjcxfa gjcxfa) {
		return getQueryCondition(gjcxfa, "a");
	}

	private String createPxCondition(List pxList, String tableAlias , boolean hasOrderBy) {
		if (pxList == null)
			return "";
		StringBuffer sb = new StringBuffer();
		Iterator it = pxList.iterator();
		String seperatorTemp = "";
		if(hasOrderBy)
			seperatorTemp = " ORDER BY ";
		while (it.hasNext()) {
			sb.append(seperatorTemp);
			Dtcxpx dtcxpx = (Dtcxpx) it.next();
			// sb.append(nulltoBlank(dtcxpx.getSjbm()));
			if (tableAlias != null && !("".equalsIgnoreCase(tableAlias))) {
				sb.append(tableAlias);
				sb.append(".");
			}
			sb.append(nulltoBlank(dtcxpx.getZdm()));
			sb.append(" " + nulltoBlank(dtcxpx.getPxfs()) + " ");
			seperatorTemp = ",";
		}
		return sb.toString();
	}

	private String createTjCondition(List tjList, String tableAlias) {
		if (tjList == null)
			return "";
		StringBuffer sb = new StringBuffer();
		Iterator it = tjList.iterator();
		String gxfTemp = "";
		while (it.hasNext()) {
			sb.append(" " + gxfTemp + " ");
			Dtcxtj dtcxtj = (Dtcxtj) it.next();
			sb.append(nulltoBlank(dtcxtj.getKskh()));
			// sb.append(nulltoBlank(dtcxtj.getSjbm()));
			sb.append(getSqlByZdlx(dtcxtj, tableAlias));
			sb.append(nulltoBlank(dtcxtj.getJskh()));
			gxfTemp = nulltoBlank(dtcxtj.getGxf());
		}
		return sb.toString();
	}

	private String getSqlByZdlx(Dtcxtj dtcxtj, String tableAlias) {
		StringBuffer sb = new StringBuffer();
		if (dtcxtj.getZdlx().equalsIgnoreCase("VARCHAR2")) {
			if (tableAlias != null && !("".equalsIgnoreCase(tableAlias))) {
				sb.append(tableAlias);
				sb.append(".");
			}
			sb.append(nulltoBlank(dtcxtj.getZdm()));
			sb.append(nulltoBlank(dtcxtj.getPpf()));
			sb.append("'");
			sb.append(nulltoBlank(dtcxtj.getZdz()));
			sb.append("'");
		}
		if(dtcxtj.getZdlx().equalsIgnoreCase("NUMBER")){
			if (tableAlias != null && !("".equalsIgnoreCase(tableAlias))) {
				sb.append(tableAlias);
				sb.append(".");
			}
			sb.append(nulltoBlank(dtcxtj.getZdm()));
			sb.append(nulltoBlank(dtcxtj.getPpf()));
			sb.append(nulltoBlank(dtcxtj.getZdz()));
		}
		if(dtcxtj.getZdlx().equalsIgnoreCase("DATE"))
		{
			sb.append("to_date(to_char(");
			if (tableAlias != null && !("".equalsIgnoreCase(tableAlias))) {
				sb.append(tableAlias);
				sb.append(".");
			}
			sb.append(nulltoBlank(dtcxtj.getZdm()));
			sb.append(",'yyyy-mm-dd'),'yyyy-mm-dd')");
			sb.append(nulltoBlank(dtcxtj.getPpf()));
			sb.append("to_date('");
			sb.append(nulltoBlank(dtcxtj.getZdz()));
			sb.append("','yyyy-mm-dd')");
		}
		return sb.toString();
	}
	private String getZdzByZdlx(Dtcxtj dtcxtj) {
		if(dtcxtj.getZdz() == null)
			return "";
		if(dtcxtj.getZdlx().equalsIgnoreCase("VARCHAR2"))
			return "'" +dtcxtj.getZdz()+ "'";
		if(dtcxtj.getZdlx().equalsIgnoreCase("NUMBER"))
			return dtcxtj.getZdz();
		if(dtcxtj.getZdlx().equalsIgnoreCase("DATE"))
			return "to_date('" +dtcxtj.getZdz()+ "','yyyy-mm-dd')";
		return dtcxtj.getZdz();
	}

	private String nulltoBlank(String string) {
		if (string == null)
			return "";
		return string;
	}

	public String[] getQueryConditions(Gjcxfa gjcxfa) {
		return getQueryConditions(gjcxfa, "a");
	}

	public String[] getQueryConditions(Gjcxfa gjcxfa, String tableAlias) {
		dealGjcxfa(gjcxfa);
			String []result = {"",""};
			if (gjcxfa != null) {
				if (gjcxfa.getGjcxlx().equalsIgnoreCase(GjcxfaDaoImpl.DYNAMICQUERY)) {
					List tjList = gjcxfa.getLPptj_table();
					List pxList = gjcxfa.getLPxgz_table();
					result[0] = (createTjCondition(tjList, tableAlias));
					result[1] = (createPxCondition(pxList, tableAlias, false));
				}
				if (gjcxfa.getGjcxlx().equalsIgnoreCase(GjcxfaDaoImpl.CUSTOMIZESQL))
				{
					result[0] = nulltoBlank(gjcxfa.getZdycxtj().getCxtj());
					result[1] = nulltoBlank(gjcxfa.getZdycxtj().getCxpx());
				}
			}
		return result;
	}

	public boolean updateGjcxfamc(Gjcxfa gjcxfa) {
		// TODO Auto-generated method stub
		return false;
	}
}
