package com.aisino2.icksystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.publicsystem.domain.Qyryxx;

public interface IIckslService {
	/** @param IC卡受理(t_icksl) 增加 */
	Icksl insertIcksl(Icksl icksl);

	/** @param IC卡受理(t_icksl) 删除 */
	boolean deleteIcksl(Icksl icksl);

	/** @param IC卡受理(t_icksl) 修改 */
	boolean updateIcksl(Icksl icksl) throws Exception;
	
	/**
	 * 照片审核
	 * @param ickslOrigin: sfjxgarkkbd,czr,gxdwbm,cjdbm
	 * @return
	 */
	boolean updateIckslZpsh(Icksl icksl) throws Exception;
	
	/**
	 * 照片审核 全部通过 
	 * @param ickslOrigin: sfjxgarkkbd,czr,gxdwbm,cjdbm
	 * @return
	 */
	boolean updateIckslZpshAll(Icksl ickslOrigin) throws Exception;
	
	/** @param IC卡受理(t_icksl) 重印刷 */
	boolean updateIckslCys(Icksl icksl) throws Exception;
	
	/** @param IC卡受理(t_icksl) IC卡电写入 */
	boolean updateIckslDxr(Icksl icksl) throws Exception;
	
	/** @param IC卡受理(t_icksl) 重电写入 */
	boolean updateIckslCdxr(Icksl icksl) throws Exception;
	
	/** @param icksl.kh IC卡受理(t_icksl)物流接受不成功而被反馈回制卡端的卡的物流发送 */
	boolean updateIckslWlfs(Icksl icksl) throws Exception;
	
	/** @param IC卡常规发放 */
	boolean updateIckslFf(Icksl icksl) throws Exception;
	
	/** @param IC卡强制发放*/
	boolean updateIckslQzff(Icksl icksl) throws Exception;
	
	/** @param IC卡补换卡*/
	boolean updateIckslBhk(Icksl icksl) throws Exception;
	
	/** @param IC卡 注销*/
	boolean updateIckslZx(Icksl icksl) throws Exception;

	/** @param IC卡受理(t_icksl) 查询单条 */
	Icksl getIcksl(Icksl icksl);
	
	/** @param IC卡受理(t_icksl) 电写入校验信息 */
	Icksl getDxrValidate(Icksl icksl);

	/** @param IC卡受理(t_icksl) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡受理(t_icksl) 多条查询 */
	List getListIcksl(Icksl icksl);
	
	/** @param 由物流ID获得IC卡受理信息 分页*/
	Page getListIckslByWlidForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 由物流ID获得IC卡受理信息 不分页*/
	List getIckslByWlidListNoPage(Icksl icksl);
	
	/** @param 查询未进行受理的从业人员 */
	Page getWslIckslCyryxxList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 查询已受理的从业人员 */
	Page getYslIckslCyryxxList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 查询具备发放条件或注销条件的IC卡  分页查询*/
	Page getWffOrWzxIckslList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 查询具备补换卡条件的IC卡  分页查询*/
	Page getBhkIckslList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 判断IC卡是否具备接收或发放条件*/
	List isCyrybhExistInIckslAndWldj(Map map);
	
	/** @param 判断IC卡是否已电写入，若是，则返回从业人员编号*/
	String sfDxr(Icksl icksl);
	
	/**
	 * 查询指定从业人员是否存在除Ic卡注销和补换卡注销外的其他记录
	 * @param icksl中存放ryid
	 * @return boolean true-存在受理记录，false-不存在受理记录
	 */
	boolean getIckslExist(Icksl icksl);
	
	
	/** @param IC卡综合查询  分页查询*/
	Page getIckslZhList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 制卡端信息查询  分页查询*/
	Page getIckslZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 制卡端关联查询 ；采集点第三方制卡统计钻取 分页查询*/
	Page getIckslZkdglcxList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 获得物流包内所有IC卡所在场所*/
	List getYlcsListInWldj(Icksl icksl);
	
	/** @param 获得物流包内指定场所需打印的人员及IC卡信息*/
	List getCyryAndIckInWldj(Icksl icksl);
	
	/** @param 获得未组包的IC卡受理信息*/
	List getWzbIckslList(Icksl icksl);
	
	/** @param 判断IC卡是否具备物流组包条件 zkztbs=5(IC卡已电写入) 用于首次被确认的卡 返回icksl=null：验证未通过，icksl!=null:验证通过*/
	Icksl isWlzb(Icksl icksl);
	
	/** @param 判断IC卡是否具备物流组包条件 zkztbs=5(IC卡已电写入) 用于非首次被确认的卡 0-验证不通过，1-验证通过*/
	String isWlzb2(Icksl icksl);
	
	/** @param icksl.ickslid 判断IC卡是否组过物流包，若组过物流包，则是否被反馈过*/
	String isExistWlzb(Icksl icksl);
	
	/** @param icksl.kh 判断IC卡是否组过物流包，若组过物流包，则是否被反馈过*/
	String isExistWlzbByKh(Icksl icksl);
	
	/** @param 查询未审核通过照片信息  分页查询*/
	Page getWshzpList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param IC卡受理(t_icksl) 查询单条 场所端刷卡时，查询该卡是否有效，若有效则返回有效记录 制卡状态为6、7、9时可以刷卡*/
	Icksl getValidIcksl(Icksl icksl);
	
	/** @param IC卡受理(t_icksl) 分页查询 采集点 第三方制卡情况统计*/
	Page getDsfzktjList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param IC卡受理--企业端(t_icksl) 分页查询 采集点 第三方制卡情况统计*/
	Page getDsfzktjListQyd(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param webservice 根据kh取得人员和受理信息*/
	Icksl getIckslWs(Icksl icksl);
	
	/** @param webservice 根据kh取得icksl多条数据*/
	List getIckslListWs(Icksl icksl);
	
	//刷卡上传，预警用到得
	Icksl getIckslyj(Icksl icksl);
	
	/** 取得制卡端IC卡信息统计数字*/
	Icksl getIckTjxx(Map map);
	
	/** @param IC卡受理(t_icksl) 分页查询 采集点 台账 第三方制卡情况统计*/
	Page getDsfzkxxList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/**取得采集端IC卡信息统计数字*/
	Icksl getCjdIckTjxx(Map map);
	
	/**取得采集端待受理IC卡信息统计数字*/
	int getCjdIckDslCount(Map map);
	
	/** @param IC卡受理(t_icksl) 从业人员编号查询 */
	Icksl getIckslCyrybh(Icksl icksl);
	
	/**
	 * 用于电写入时部分卡的芯片号负号被认为去掉的情况。
	 * 将受理表中相应芯片号的负号加上，并在受理临时表中增加一条记录
	 * @param Icksl-ickh 芯片号
	 * @return boolean
	 */
	boolean updateIckslIckh(Icksl icksl);
	
	/** @param 根据芯片号和制卡状态查询从业人员编号查询 */
	public List getIckslByCyrybhAndKh(Map map);
	
	/** @param 人员注册，更新对应的icksl记录 
	 * @throws Exception */
	boolean updateIckslByryzc(Qyryxx qyryxx) throws Exception;
}
