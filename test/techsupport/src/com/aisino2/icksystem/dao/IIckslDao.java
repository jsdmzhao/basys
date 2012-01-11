package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Icksl;
public interface IIckslDao {
	/** @param IC卡受理(t_icksl) 增加 */
	Icksl insertIcksl(Icksl icksl);

	/** @param IC卡受理(t_icksl) 删除 */
	int deleteIcksl(Icksl icksl);

	/** @param IC卡受理(t_icksl) 修改 */
	int updateIcksl(Icksl icksl);

	/** @param 更新icksl由于人员企业变更 */
	int updateIckslByqybg(Icksl icksl);
	
	/** @param IC卡受理(t_icksl) 查询单条 */
	Icksl getIcksl(Icksl icksl);
	
	/** @param IC卡受理(t_icksl) 电写入校验信息 */
	Icksl getDxrValidate(Icksl icksl);

	/** @param IC卡受理(t_icksl) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡受理(t_icksl) 多条查询 */
	List getListIcksl(Icksl icksl);
	
	/** @param 由从业人员编号及物流ID获得IC卡受理信息 */
	List getListIckslByCyrybhAndWlid(Map map);
	
	/** @param 由物流ID获得IC卡受理信息 不分页*/
	List getListIckslByWlid(Map map);
	
	/** @param 由物流ID获得IC卡受理信息 分页*/
	Page getListIckslByWlidForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 由物流ID获得IC卡受理信息 不分页*/
	List getIckslByWlidListNoPage(Icksl icksl);
	
	/** @param 查询指定从业人员是否存在除Ic卡注销和补换卡注销外的其他记录 */
	List getIckslExist(Icksl icksl);
	
	/** @param 查询未进行受理的从业人员  分页查询*/
	Page getWslIckslCyryxxList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 查询已受理的从业人员  分页查询*/
	Page getYslIckslCyryxxList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 查询具备发放条件或注销条件的IC卡的IC卡  分页查询*/
	Page getWffOrWzxIckslList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 查询具备补换卡条件的IC卡  分页查询*/
	Page getBhkIckslList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 查询物流包内已接收的IC卡*/
	List getYjsIckslListInWldj(Map map);
	
	/** @param 判断IC卡是否具备接收或发放条件*/
	List isCyrybhExistInIckslAndWldj(Map map);
	
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
	
	/** @param 由从业人员编号、卡号获得IC卡受理信息*/
	List getIckslByCyrybhAndKh(Map map);
	
	/** @param 由从业人员编号判断是否已电写入*/
	Icksl isDxr(Map map);
	
	/** @param 获得未组包的IC卡受理信息*/
	List getWzbIckslList(Icksl icksl);
	
	/** @param 判断IC卡是否具备物流组包条件 zkztbs=5(IC卡已电写入)*/
	Icksl isWlzb(Icksl icksl);
	
	/** @param 查询未审核通过照片信息  分页查询*/
	Page getWshzpList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 查询未审核通过照片信息 不分页*/
	List getWshzpListNoPage(Icksl icksl);
	
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
	
	/**取得制卡端IC卡信息统计数字*/
	Icksl getIckTjxx(Map map);
	
	/** @param IC卡受理(t_icksl) 分页查询 采集点 台账 第三方制卡情况统计*/
	Page getDsfzkxxList(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/**取得采集端IC卡信息统计数字*/
	Icksl getCjdIckTjxx(Map map);
	
	/**取得采集端待受理IC卡信息统计数字*/
	int getCjdIckDslCount(Map map);
	
	/** @param IC卡受理(t_icksl) 从业人员编号查询 */
	Icksl getIckslCyrybh(Icksl icksl);
}
