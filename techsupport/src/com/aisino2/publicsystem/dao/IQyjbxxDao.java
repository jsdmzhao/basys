package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyjbxx;
public interface IQyjbxxDao {
	/** @param 企业基本信息(t_qyjbxx) 增加 */
	Qyjbxx insertQyjbxx(Qyjbxx qyjbxx);

	/** @param 企业基本信息(t_qyjbxx) 删除 */
	int deleteQyjbxx(Qyjbxx qyjbxx);

	/** @param 企业基本信息(t_qyjbxx) 修改 */
	int updateQyjbxx(Qyjbxx qyjbxx);

	/** @param 企业基本信息(t_qyjbxx) 查询单条 */
	Qyjbxx getQyjbxx(Qyjbxx qyjbxx);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询 采集点提交  */
	Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业基本信息(t_qyjbxx) 分页查询 企业管理页面*/
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业核查(即信息确认)*/
	Page getListForPageHc(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  公安端企业查询*/
	Page getListForPageQycx(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业变更、注销*/
	Page getListForPageQybg(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业变更详情*/
	Page getListForPageQybgxq(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询 制卡端关联查询*/
	Page getListForPageZkd(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业基本信息(t_qyjbxx) 多条查询 */
	List getListQyjbxx(Qyjbxx qyjbxx);
	
	/**
	 * 判断企业是否已存在
	 * @param qyjbxx(qyid,zjbh)
	 */
	Qyjbxx isQyjbxxExist(Qyjbxx qyjbxx);
	
	/**  获取 基本的企业信息项目 */
	Qyjbxx getQyjbxxXiangMu(Qyjbxx qyjbxx);
	
	/** 根据企业主分类 公安端查询场所数量 娱乐业标准化 */
	public List getQyzflCountList(Map map);
	
	/** 待核查场所数 娱乐业标准化 */
	int getDhccsCount(Map map);
}
