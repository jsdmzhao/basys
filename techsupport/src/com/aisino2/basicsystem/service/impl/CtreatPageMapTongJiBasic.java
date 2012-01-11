package com.aisino2.basicsystem.service.impl;

import java.util.Map;

public class CtreatPageMapTongJiBasic {
	/**
	 * 场所查询统计
	 * @param map
	 * @return
	 */
	public static Map getConditions(Map map) {
		boolean dsjgbz = ((String)map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String)map.get("fxjbz")).equalsIgnoreCase("1"); 
		boolean gxdwbz = ((String)map.get("gxdwbz")).equalsIgnoreCase("1");
	
		String groupBy = "";
		String selectConditon = "";
	
		
		if(gxdwbz)
		{
			groupBy = "gxdwdm,gxdwmc";
			selectConditon = "'' as ssddsjgdm,'' as ssddsjgmc,'' as ssdxjgajgdm,'' as ssdxjgajgmc,"+groupBy;
		}else if(fxjbz)
		{
			groupBy = "ssdxjgajgdm,ssdxjgajgmc";
			selectConditon = "'' as  ssddsjgdm,'' as  ssddsjgmc,"+groupBy + ",'' as gxdwdm,'' as gxdwmc";
		}else if(dsjgbz)
		{
			groupBy = "ssddsjgdm,ssddsjgmc";
			selectConditon = groupBy + ",'' as ssdxjgajgdm,'' as ssdxjgajgmc,'' as gxdwdm,'' as gxdwmc";
		}else
		{
			groupBy = "ssddsjgdm,ssddsjgmc,ssdxjgajgdm,ssdxjgajgmc,gxdwdm,gxdwmc";
			selectConditon =groupBy ;
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
		return map;
	}
	/**
	 * 查询统计模块
	 * @param map
	 * @return
	 */
	public static Map getConditionsTongjiChaXun(Map map) {
		
		boolean dsjgbz = ((String)map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String)map.get("fxjbz")).equalsIgnoreCase("1"); 
		boolean gxdwbz = ((String)map.get("gxdwbz")).equalsIgnoreCase("1");
		boolean csbz =false;
		if(map.get("csbz")!=null){
			csbz = ((String)map.get("csbz")).equalsIgnoreCase("1");
		}
		String groupBy = "";
		String selectConditon = "";
		if(csbz){
			groupBy = "csbm,csmc";
			selectConditon = "'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc,"+groupBy;
		}
		else if(gxdwbz)
		{
			groupBy = "gxdwdm,gxdwmc";
			selectConditon = "'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,"+groupBy+",'' as csbm,'' as csmc";
		}else if(fxjbz)
		{
			groupBy = "fxjdm,fxjmc";
			selectConditon = "'' as dsjgdm,'' as dsjgmc,"+groupBy+",'' as gxdwdm,'' as gxdwmc,'' as csbm,'' as csmc";
		}else if(dsjgbz)
		{
			groupBy = "dsjgdm,dsjgmc";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc,'' as csbm,'' as csmc";
		}else
		{
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc,gxdwdm,gxdwmc,csbm,csmc";
			selectConditon =groupBy ;
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
		return map;
	}
	
	
	/**
	 * 查询统计模块中的企业上报和未上报的查询用到得
	 * @param map
	 * @return
	 */
	public static Map getConditionsTongjiChaXunSb(Map map) {
		
		boolean dsjgbz = ((String)map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String)map.get("fxjbz")).equalsIgnoreCase("1"); 
		boolean gxdwbz = ((String)map.get("gxdwbz")).equalsIgnoreCase("1");
	
		String groupBy = "";
		String selectConditon = "";
		
		if(gxdwbz)
		{
			groupBy = "gxdwdm,gxdwmc,csbm,csmc";
			selectConditon = "'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,"+groupBy;
		}else if(fxjbz)
		{
			groupBy = "fxjdm,fxjmc,csbm,csmc";
			selectConditon = "'' as dsjgdm,'' as dsjgmc,"+"fxjdm,fxjmc"+",'' as gxdwdm,'' as gxdwmc,"+"csbm,csmc";
		}else if(dsjgbz)
		{
			groupBy = "dsjgdm,dsjgmc,csbm,csmc";
			selectConditon = "dsjgdm,dsjgmc" + ",'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc,"+"csbm,csmc";
		}else
		{
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc,gxdwdm,gxdwmc,csbm,csmc";
			selectConditon =groupBy ;
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
		return map;
	}
	
	
	
}
