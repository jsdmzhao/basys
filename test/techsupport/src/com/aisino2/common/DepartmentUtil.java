package com.aisino2.common;

public class DepartmentUtil {
	/**
	 * 采集点用户根据不同省市处理部门编码
	 * @param deptCode
	 * @return
	 */
	public static String doWithDepartmentCode(String deptCode){
		deptCode = com.aisino2.common.StringUtil.trimEven0(deptCode);
		if(deptCode != null)
		{
			if(deptCode.indexOf("CJD")!=-1)
			{
				if(deptCode.substring(3).length()<=4)
					deptCode = deptCode.substring(3);
				else 
				{
					//deptCode = StringUtil.add0(deptCode.substring(3), 4).substring(0,4);
					if(!deptCode.substring(3).substring(0,2).equals("11")//不属于四个直辖市
							&&!deptCode.substring(3).substring(0,2).equals("12")
							&&!deptCode.substring(3).substring(0,2).equals("31")
							&&!deptCode.substring(3).substring(0,2).equals("50"))
					{
						deptCode = deptCode.substring(3).substring(0,4);
					}
					else//属于四个直辖市时，取前6位 20101018mds
					{
						if(deptCode.substring(3).length()<6)
						{
							deptCode = deptCode.substring(3).substring(0,2);
						}
						else
						{
							deptCode = deptCode.substring(3).substring(0,6);
						}
					}
				}
			}
		}
		return deptCode;
	}
	/**
	 * 检验机构是否是 直辖市
	 */
	public static boolean departIsZxs(String deptCode){
		boolean iszxs = false;
		if(deptCode.startsWith("11")||deptCode.startsWith("12")
				||deptCode.startsWith("31")||deptCode.startsWith("50")){
			iszxs = true;
		}
		return iszxs;
	}
	
	public static void main(String[] args) {
		System.out.println(DepartmentUtil.departIsZxs("31asdf"));	
	}
}