package com.aisino2.sysadmin.dao;
import java.util.Date;

import com.aisino2.core.dao.AbstractOperateLog;
import com.aisino2.sysadmin.domain.Operatelog;




public class OperateLogNote extends AbstractOperateLog {

	public Object doParameterObject() {
		Operatelog operatelog = new Operatelog();
		Operatelog operatelogOne = new Operatelog();
		String menuCode = getMenuCode();
		String useraccount = getOperator();
		operatelog.setUseraccount(useraccount);
		Object log=new Object();
		log = getSqlMapClientTemplate().queryForObject("getUserDepartmentlog", operatelog);
        if(log==null)return null;
        else{
        	operatelog = (Operatelog)log;
        }
        Object logOne=new Object();
		operatelogOne.setOperatemodule(menuCode);
		logOne = getSqlMapClientTemplate().queryForObject("getMenuSystemlog", operatelogOne);
		 if(logOne==null)return null;
	        else{
	        	operatelogOne = (Operatelog)logOne;
	        }
		operatelog.setOperatesystem(operatelogOne.getOperatesystem());
		operatelog.setOperatemodule(operatelogOne.getOperatemodule());
		
			operatelog.setOperatesql(getSql());
	
		
			operatelog.setOperatetype(getOperateType());
		
		operatelog.setOperatedate(new Date());
		return operatelog;
	}

	public String doStatementName() {
		
		return "insertOperatelog";
	}

	

}
