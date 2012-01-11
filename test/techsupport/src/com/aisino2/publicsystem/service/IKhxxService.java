package com.aisino2.publicsystem.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Khxx;

public interface IKhxxService {
	/** @param 客户信息表(t_khxx) 增加 */
	Khxx insertKhxx(Khxx khxx);
	
	/** @param 客户信息表(t_khxx) 增加  含报警*/
	Khxx insertKhxxBj(Khxx khxx) throws Exception;

	/** @param 客户信息表(t_khxx) 删除 */
	boolean deleteKhxx(Khxx khxx);

	/** @param 客户信息表(t_khxx) 修改 */
	boolean updateKhxx(Khxx khxx);
	
	/** @param 客户信息表(t_khxx) 修改 含报警*/
	Khxx updateKhxxBj(Khxx khxx) throws Exception;
	
	/** @param 客户信息表(t_khxx) 调用报警功能*/
	int updateKhxxBjCommon(Khxx khxx,Map parameterMap) throws Exception;

	/** @param 客户信息表(t_khxx) 查询单条 */
	Khxx getKhxx(Khxx khxx);
	
	/** @param 客户信息表(t_khxx) 查询单条 获得证件号码及国籍代码相同的客户信息中最新一条信息*/
	Khxx getLatestKhxx(Khxx khxx);
	
	/**
	 * 查询客户信息 ，含外国客户信息
	 * @param khxx中传入的参数：国内人员传入zjhm;国外人员传入gjdm和zjhm
	 * @return
	 */
	Khxx getKhxxAll(Khxx khxx);
	
	/**
	 * 判断客户信息是否已存在。
	 * @param khxx中传入的参数：gjdm和zjhm
	 * @return 0-不存在 1-存在
	 */
	String isKhxxExist(Khxx khxx);
	
	/**
	 * 判断客户信息是否已存在。国内人员通过证件号码判断，外国人员通过国籍和证件号码判断
	 * @param khxx中传入的参数：国内人员传入zjhm;国外人员传入gjdm和zjhm
	 * @return Map::isKhxxExist:0-不存在 1-存在;biduiflag:1-报警
	 */
	Khxx getKhxxExistAndBj(Khxx khxx) throws Exception;

	/** @param 客户信息表(t_khxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 客户信息表(t_khxx) 多条查询 */
	List getListKhxx(Khxx khxx);
	
	/**
	 * 客户报警
	 * @param Bjxxb 报警信息表，内含业务表相关字段（ddqyid、khxxid、xm、zjhm;）
	 * @return int 0-传入参数有误,1-比中，2-未比中
	 */
	int baojingDdkhxx(Bjxxb bjxxbIn) throws IllegalAccessException, InvocationTargetException;
}
