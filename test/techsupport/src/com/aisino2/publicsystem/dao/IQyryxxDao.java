package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyryxx;
public interface IQyryxxDao {
	/** @param 企业人员信息(t_qyryxx) 增加 */
	Qyryxx insertQyryxx(Qyryxx qyryxx);

	/** @param 企业人员信息(t_qyryxx) 删除 */
	int deleteQyryxx(Qyryxx qyryxx);

	/** @param 企业人员信息(t_qyryxx) 修改 */
	int updateQyryxx(Qyryxx qyryxx);

	/** @param 企业人员信息(t_qyryxx) 查询单条 */
	Qyryxx getQyryxx(Qyryxx qyryxx);

	/** @param 企业人员信息(t_qyryxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员信息(t_qyryxx) 多条查询 */
	List getListQyryxx(Qyryxx qyryxx);
	
	/** @param 企业人员信息(t_qyryxx) 多条查询 获得需进行公安人口库比对的人员*/
	List getDhdQyryxxList(Qyryxx qyryxx);
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  制卡端关联查询*/
	Page getListZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  制卡端关联查询 场所所属人员*/
	Page getListZkdByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	//以下是新增的
	/** @param 从业人员信息(t_Qyryxx) 分页查询  公安端人员查询 注销查询*/
	Page getListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 从业人员信息(t_Qyryxx) 分页查询  企业段筛选框查询*/
	Page getQyryxxListQydDictForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	

	/** @param 从业人员信息(t_Qyryxx) 分页查询  企业端人员查询*/
	Page getListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_Qyryxx) 分页查询  由场所ID或场所编码获得该场所下从业人员*/
	Page getQyryxxListByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_Qyryxx) 分页查询  公安端 删除查询*/
	Page getScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 从业人员信息(t_Qyryxx) 分页查询  公安端 变更查询*/
	Page getBgListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_Qyryxx) 分页查询  公安端人员处罚信息查询*/
	Page getListCfForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_cyryxx) 多条查询 获得未提交从业人员*/
	List getWtjListQyryxx(Qyryxx qyryxx);

	
	/** @param 由身份证号码获得户籍代码及名称 */
	Qyryxx getHjdxzqh(Qyryxx qyryxx);
	
	/** @param 由证件号码判断从业人员是否已录入(修改时，需判断不同ryid的证件号码不能重复) */
	List getIsQyryxxExist(Map map);
	
	/**
	 * 取得由注销企业人员list
	 * @param jxcyryxx
	 * @return
	 */
	List getMakeRyLzList(Qyryxx qyryxx);
	
	/** @param 更新从业人员离职由于企业注销 */
	int updateQyryxxLzByqyzxGg(Qyryxx qyryxx);
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  采集点提交*/
	Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryxx) 多条查询 获得已进行公安人口库比对的人员（人员状态为1、4、5的记录）*/
	List getYhcCyryxxList(Qyryxx qyryxx);
	
}


