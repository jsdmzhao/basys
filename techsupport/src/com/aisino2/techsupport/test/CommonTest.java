package com.aisino2.techsupport.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aisino2.techsupport.domain.SupportDept;

public class CommonTest {
	
	
	public static  void main(String[] args) throws IOException{
//		CommonUtil util = (CommonUtil) applicationContext.getBean("CommonUtil");
//		String value=util.getTechSupportEnvConfig("techsupport.role.tech_quality_control");
//		System.out.println(value);
//		CommonTest.testListContainsEquals();
		CommonTest.testListContain2();
		
	}
	
	public static void testListContainsEquals(){
		SupportDept dd = new SupportDept();
		dd.setDeptId(1000);
		dd.setStId(2);
		
		SupportDept ff=new SupportDept();
		ff.setDeptId(1000);
		ff.setId(2);
		ff.setStId(2);
		
		SupportDept cc=new SupportDept();
		cc.setDeptId(1000);
		cc.setStId(2);
		cc.setId(1000);
		
		System.out.println(cc.equals(ff));
		
		List<SupportDept> list = new ArrayList<SupportDept>();
		list.add(dd);
		list.add(ff);
		
		System.out.println(list.contains(cc));
	}
	
	public static void testListContain2(){
		SupportDept dd = new SupportDept();
		dd.setDeptId(1000);
		dd.setStId(2);
		
		SupportDept ff=new SupportDept();
		ff.setDeptId(1000);
		ff.setId(2);
		ff.setStId(2);
		
		SupportDept cc=new SupportDept();
		cc.setDeptId(1000);
		cc.setStId(2);
		cc.setId(1000);
		
		System.out.println(cc.equals(ff));
		
		List<SupportDept> list = new ArrayList<SupportDept>();
		list.add(dd);
		list.add(ff);
		
		List<SupportDept> list2=new ArrayList<SupportDept>();
		list2.add(cc);
		
		SupportDept ee=new SupportDept();
		ee.setDeptId(1000);
		ee.setStId(3);
		list2.add(ee);
		
		System.out.println(list.containsAll(list2));
	}
	
	
}
