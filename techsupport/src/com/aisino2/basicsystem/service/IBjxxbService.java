package com.aisino2.basicsystem.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.core.dao.Page;

public interface IBjxxbService {
	/** @param 报警信息表(t_bjxxb) 增加 */
	Bjxxb insertBjxxb(Bjxxb bjxxb);

	/** @param 报警信息表(t_bjxxb) 删除 */
	boolean deleteBjxxb(Bjxxb bjxxb);

	/** @param 报警信息表(t_bjxxb) 修改 */
	boolean updateBjxxb(Bjxxb bjxxb);

	/** @param 报警信息表(t_bjxxb) 查询单条 */
	Bjxxb getBjxxb(Bjxxb bjxxb);
	
	/** @param 报警信息表(t_bjxxb) 查询快照表名称 */
	Map getKzbmc(Bjxxb bjxxb);

	/** @param 报警信息表(t_bjxxb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 报警信息表(t_bjxxb) 多条查询 */
	List getListBjxxb(Bjxxb bjxxb);
	
	/** @param 报警信息表(t_bjxxb) 分页查询 主页面 */
	Page getMainListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	List getListExportBjxxb(Map map, String sort, String dir);
	
	/** @param 报警信息表(t_bjxxb) 分页查询 报警客户端得页面 */
	Page getClientListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 报警信息表(t_bjxxb)条数 */
	int getBjxxbCount(Map map);
	
	/** ByTy 按照比对规则SQL执行查询，由于身份证重号现象，所以返回报警信息列表 bjgz-报警规则（业务表名，业务表字段名）, bdtjSql-自定义sql,zjhm-证件号码*/
	List getBjxxByBdtjSql(Bjgz bjgz, String bdtjSql,String zjhm);
	
	/**
	 * 客户信息报警
	 * @param bjxxbIn 存放：ywbzj1-客户id，ywbzj2-企业id，xm-姓名，zjhm-证件号码
	 * @param hylbdm 行业类别代码
	 * @param sfyx 报警规则有效标志,增加新的行业时，可增加如下注释说明：
	 * @param sfyx 0-所有人员报警条件无效
	 * @param sfyx 1-从业人员自动报警条件有效
	 * @param sfyx 2-典当业客户
	 * @param sfyx 31-机修业送车人, 32-机修业取车人
	 * @param sfyx 4-公用模块车主
	 * @param sfyx 5-二手车车主委托人、购买人、卖车人、卖车委托人、卖车被委托人
	 * @param sfyx 61-出租车驾驶员
	 * @param sfyx 71-二手手机出售人员，72-二手手机摊主,73-摊位从业人员
	 * @param sfyx 8-汽车租赁业租车客户
	 * 
	 * @return int 0-传入参数有误,1-比中，2-未比中
	 */
	int baojingKhxx(Bjxxb bjxxbIn,String hylbdm,String sfyx)throws IllegalAccessException, InvocationTargetException;
}
