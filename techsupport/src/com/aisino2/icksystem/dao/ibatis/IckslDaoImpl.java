package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIckslDao;
import com.aisino2.icksystem.domain.Icksl;

public class IckslDaoImpl extends BaseDao implements IIckslDao {
	/** @param IC卡受理(t_icksl) 增加 */
	public Icksl insertIcksl(Icksl icksl){
		// TODO: implement
		//icksl.setRyid(getNextID("Ickslid"));
		icksl.setIckslid(getNextID("Ickslid"));
		insert("insertIcksl", icksl);
		return icksl;
	}

	/** @param IC卡受理(t_icksl) 删除 */
	public int deleteIcksl(Icksl icksl){
		// TODO: implement
		return delete("deleteIcksl", icksl);
	}

	/** @param 更新icksl由于人员企业变更 */
	public int updateIckslByqybg(Icksl icksl){
		// TODO: implement
		return update("updateIckslByqybg", icksl);
	}
	/** @param IC卡受理(t_icksl) 修改 */
	public int updateIcksl(Icksl icksl){
		// TODO: implement
		return update("updateIcksl", icksl);
	}

	/** @param IC卡受理(t_icksl) 查询单条 */
	public Icksl getIcksl(Icksl icksl){
		// TODO: implement
		return (Icksl)queryForObject("getIcksl", icksl);
	}
	
	/** @param IC卡受理(t_icksl) 电写入校验信息 */
	public Icksl getDxrValidate(Icksl icksl)
	{
		return (Icksl)queryForObject("getDxrValidate", icksl);
	}

	/** @param IC卡受理(t_icksl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " c.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cjsj "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zt "+ desc;
			else
				sCol = " a.cjsj desc ";
		}else{
			sCol="a.cjsj desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckslList", map, pageNo,pageSize);
	}

	/** @param IC卡受理(t_icksl) 多条查询 */
	public List getListIcksl(Icksl icksl){
		// TODO: implement
		return queryForList("getIckslListNoPage", icksl);
	}
	
	/** @param 由从业人员编号及物流ID获得IC卡受理信息 */
	public List getListIckslByCyrybhAndWlid(Map map)
	{
		return queryForList("getIckslByCyrybhAndWlid", map);
	}
	
	/** @param 由物流ID获得IC卡受理信息 */
	public List getListIckslByWlid(Map map)
	{
		return queryForList("getIckslByWlid", map);
	}
	
	/** @param 由物流ID获得IC卡受理信息 分页*/
	public Page getListIckslByWlidForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.kh "+ desc;
			else if(sort.equals("1"))
				sCol = " d.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " d.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " d.csrq "+ desc;
			else if(sort.equals("4"))
				sCol = " d.hjdxzqhdm "+ desc;
			else if(sort.equals("5"))
				sCol = " d.zt "+ desc;
			else
				sCol = " a.kh ";
		}else{
			sCol=" a.kh ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckslByWlidList", map, pageNo,pageSize);
	}
	
	/** @param 由物流ID获得IC卡受理信息 不分页*/
	public List getIckslByWlidListNoPage(Icksl icksl)
	{
		return queryForList("getIckslByWlidListNoPage", icksl);
	}
	
	/** @param 查询指定从业人员是否存在除Ic卡注销和补换卡注销外的其他记录 */
	public List getIckslExist(Icksl icksl)
	{
		return queryForList("getIckslExist", icksl);
	}
	
	/** @param 查询未进行受理的从业人员 */
	public Page getWslIckslCyryxxList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " c.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.lrsj "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zt "+ desc;
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWslIckslCyryxxList", map, pageNo,pageSize);
	}
	
	/** @param 查询已受理的从业人员 */
	public Page getYslIckslCyryxxList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " c.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.lrsj "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zt "+ desc;
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getYslIckslCyryxxList", map, pageNo,pageSize);
	}
	
	/** @param 查询具备发放条件或注销条件的IC卡的IC卡  分页查询*/
	public Page getWffOrWzxIckslList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
			    sCol = " a.ickslid "+ desc;
			else if(sort.equals("1"))
			    sCol = " a.kh "+ desc;
			else if(sort.equals("2"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("3"))
				sCol = " b.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " e.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.yxqhzrq "+ desc;
			else if(sort.equals("6"))
				sCol = " d.wlpc "+ desc;
			else
				sCol = " a.kh ";
		}else{
			sCol=" a.kh ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWffIckslList", map, pageNo,pageSize);
	}
	
	/** @param 查询具备补换卡条件的IC卡  分页查询*/
	public Page getBhkIckslList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " b.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " b.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " e.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " b.lrsj "+ desc;
			else if(sort.equals("6"))
				sCol = " b.cylbdm "+ desc;
			else if(sort.equals("7"))
				sCol = " b.zt "+ desc;
			else
				sCol = " b.lrsj desc ";
		}else{
			sCol=" b.lrsj ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBhkIckslList", map, pageNo,pageSize);
	}
	
	/** @param 查询物流包内已接收的IC卡*/
	public List getYjsIckslListInWldj(Map map)
	{
		return queryForList("getYjsIckslListInWldj", map);
	}
	
	/** @param 判断IC卡是否具备接收或发放条件*/
	public List isCyrybhExistInIckslAndWldj(Map map)
	{
		return queryForList("isCyrybhExistInIckslAndWldj", map);
	}
	
	/** @param IC卡综合查询  分页查询*/
	public Page getIckslZhList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " b.xbdm "+ desc;
			else if(sort.equals("3"))
				sCol = " b.csrq "+ desc;
			else if(sort.equals("4"))
				sCol = " b.gjdm "+ desc;
			else if(sort.equals("5"))
				sCol = " b.zjhm "+ desc;
			else if(sort.equals("6"))
				sCol = " d.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.kh "+ desc;
			else if(sort.equals("8"))
				sCol = " a.zkztbs "+ desc;
			else
				sCol = " a.kh  ";
		}else{
			sCol=" a.kh ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckslZhList", map, pageNo,pageSize);
	}
	
	/** @param 制卡端信息查询  分页查询*/
	public Page getIckslZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.kh "+ desc;
			else if(sort.equals("1"))
				sCol = " e.pch "+ desc;
			else if(sort.equals("2"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("3"))
				sCol = " b.cyrybh "+ desc;
			else if(sort.equals("4"))
				sCol = " b.zjhm "+ desc;
			else if(sort.equals("5"))
				sCol = " b.xbdm "+ desc;
			else if(sort.equals("6"))
				sCol = " a.slsj "+ desc;
			else if(sort.equals("7"))
				sCol = " a.cjdbm "+ desc;
			else if(sort.equals("8"))
				sCol = " a.zkztbs "+ desc;
			else
				sCol = " a.ickslid  ";
		}else{
			sCol=" a.ickslid ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckslZkdList", map, pageNo,pageSize);
	}
	
	/** @param 制卡端关联查询 ；采集点第三方制卡统计钻取 分页查询*/
	public Page getIckslZkdglcxList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.kh "+ desc;
			else if(sort.equals("2"))
				sCol = " b.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " b.gj "+ desc;
			else if(sort.equals("4"))
				sCol = " b.xbdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.yxqhzrq "+ desc;
			else if(sort.equals("6"))
				sCol = " a.zkztbs "+ desc;
			else
				sCol = " a.ickslid  ";
		}else{
			sCol=" a.ickslid ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckslZkdglcxList", map, pageNo,pageSize);
	}
	
	/** @param 获得物流包内所有IC卡所在场所*/
	public List getYlcsListInWldj(Icksl icksl)
	{
		return queryForList("getYlcsListInWldj", icksl);
	}
	
	/** @param 获得物流包内指定场所需打印的人员及IC卡信息*/
	public List getCyryAndIckInWldj(Icksl icksl)
	{
		return queryForList("getCyryAndIckInWldj", icksl);
	}
	
	/** @param 由从业人员编号、卡号获得IC卡受理信息*/
	public List getIckslByCyrybhAndKh(Map map)
	{
		return queryForList("getIckslByCyrybhAndKh", map);
	}
	
	/** @param 由从业人员编号判断是否已电写入*/
	public Icksl isDxr(Map map)
	{
		return (Icksl)queryForObject("getIckslByCyrybhAndKh", map);
	}
	/** @param 获得未组包的IC卡受理信息*/
	public List getWzbIckslList(Icksl icksl)
	{
		return queryForList("getWzbIckslList", icksl);
	}
	
	/** @param 判断IC卡是否具备物流组包条件 zkztbs=5(IC卡已电写入)*/
	public Icksl isWlzb(Icksl icksl)
	{
		return (Icksl)queryForObject("isWlzb", icksl);
	}
	
	/** @param 查询未审核通过照片信息  分页查询*/
	public Page getWshzpList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if (sort!=null){
			sCol = " a.ryid  ";
		}else{
			sCol=" a.ryid ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWshzpList", map, pageNo,pageSize);
	}
	
	/** @param 查询未审核通过照片信息 不分页*/
	public List getWshzpListNoPage(Icksl icksl)
	{
		return queryForList("getWshzpListNoPage", icksl);
	}
	
	/** @param IC卡受理(t_icksl) 查询单条 场所端刷卡时，查询该卡是否有效，若有效则返回有效记录 制卡状态为6、7、9时可以刷卡*/
	public Icksl getValidIcksl(Icksl icksl)
	{
		return (Icksl)queryForObject("getValidIcksl", icksl);
	}
	
	/** @param IC卡受理(t_icksl) 多条查询 采集点 第三方制卡情况统计*/
	public Page getDsfzktjList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if (sort!=null){
			sCol = " substr(a.cjdbm, 0, 7), cjdbm  ";
		}else{
			sCol=" substr(a.cjdbm, 0, 7), cjdbm ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDsfzktjList", map, pageNo,pageSize);
	}
	
	/** @param IC卡受理--企业端(t_icksl) 多条查询 采集点 第三方制卡情况统计*/
	public Page getDsfzktjListQyd(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if (sort!=null){
			sCol = " substr(a.cjdbm, 0, 7), cjdbm  ";
		}else{
			sCol=" substr(a.cjdbm, 0, 7), cjdbm ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getDsfzktjListQyd", map, pageNo,pageSize);
	}

	public Icksl getIckslWs(Icksl icksl) {
		// TODO Auto-generated method stub
		return (Icksl)queryForObject("getIckslWs", icksl);
	}

	public List getIckslListWs(Icksl icksl) {
		// TODO Auto-generated method stub
		return queryForList("getIckslListWs", icksl);
	}

	public Icksl getIckslyj(Icksl icksl) {
		// TODO Auto-generated method stub
		return (Icksl)queryForObject("getIckslyj", icksl);
	}
	public Icksl getIckTjxx(Map map){
		return (Icksl)queryForObject("getIckTjxx", map);
	}
	
	/** @param IC卡受理(t_icksl) 分页查询 采集点 台账 第三方制卡情况统计*/
	public Page getDsfzkxxList(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if (sort!=null){
			sCol = " substr(cjdbm, 0, 7), cjdbm  ";
		}else{
			sCol=" substr(cjdbm, 0, 7), cjdbm ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getTzDsfzktjList", map, pageNo,pageSize);
	}
	public Icksl getCjdIckTjxx(Map map){
		return (Icksl)queryForObject("getCjdIckTjxx", map);
	}
	
	/**取得采集端待受理IC卡信息统计数字*/
	public int getCjdIckDslCount(Map map){
		return ((Integer)queryForObject("getWslIckslCyryxxListCount", map)).intValue();
	}
	
	/** @param IC卡受理(t_icksl) 从业人员编号查询 */
	public Icksl getIckslCyrybh(Icksl icksl){
		// TODO: implement
		return (Icksl)queryForObject("getIckslCyrybh", icksl);
	}
}
