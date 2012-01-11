package com.aisino2.sysadmin.common;

import java.util.ArrayList;
import java.util.List;

import com.aisino2.sysadmin.domain.Menu;
/**
	 * 递归生成树，输入参数为list
	 * @author mds zs
	 */
public class TreeMenu {
	
	private StringBuffer returnXml = new StringBuffer();//返回的树状xml串
	//private List parentlist = new ArrayList();//所有顶级节点形成的list
	public  static int count =0;
	
	/**
	 * id    |  parentId
	 * 
	 * 100   |  0
	 * 101   |  0
	 * 102   |  0
	 * 103   |  0
	 * 1000  |  100
	 * 1001  |  100
	 * 1002  |  100
	 * 10000 |  1001
	 * 10001 |  1001
	 * 10002 |  1001
	 * 10003 |  1001
	 * 10004 |   1001
	 * 
	 */
	/**
	 * 将list输出为树形结构串
	 * @param list 平板结构list
	 * @return
	 */
	public String buildTree(List list)
	{
		boolean param = false;
		boolean flag = false;
		
		List parentlist = new ArrayList();
		//提取出LIST中所有的根节点
		for(int k = 0; k<list.size();k++)
		{
			param =false; 
			Menu compareparentTree = new Menu();
			compareparentTree = (Menu)list.get(k);
			
			//如果该节点的parentId跟list中所有节点的ID不相等，则该节点为根节点
			for(int h =0;h<list.size();h++)
			{
				Menu parentTree = new Menu();
				parentTree = (Menu)list.get(h); 
				if(compareparentTree.getParentmenucode().equals(parentTree.getMenucode()))
					param =true; 
			}
			
			if(!param)
				parentlist.add(compareparentTree);
		}
		//生成根节点树形串
		for(int g =0;g<parentlist.size();g++)
		{
			Menu node = new Menu();
			node = (Menu)parentlist.get(g); 
			flag = false;
			
			//为叶子菜单的链接添加menuCodeValueParam参数，参数值为menucode
			String menuCodeValueParam = "menuCodeValueParam=";
			if(node.getFuncentry()!=null)
			{
				if(node.getFuncentry().indexOf("?")==-1)
					menuCodeValueParam = "?"+menuCodeValueParam;
				else if(node.getFuncentry().indexOf("?")!=-1)
					menuCodeValueParam = "&"+menuCodeValueParam;
			}

			//判断叶子节点，判定规则(如果该节点的id在所有节点的parentID中不存在，则该节点为叶子节点)
			for(int i=0;i<list.size();i++)
			{
				Menu tempTree = new Menu();
				tempTree = (Menu)list.get(i);
				if(node.getMenucode().equals(tempTree.getParentmenucode()))
				{
					flag = true;
					break;
				}
			}
			//returnXml.append("<" + node.getMenucode() + ">");
			//returnXml.append("<li><img src='../images/navline.gif' /></li>");
			returnXml.append("<li class='navline'></li>");
			returnXml.append("<li>");
			//如果不为叶节点，则递归
			if(flag)
			{
				returnXml.append("<a  href='#'  onmouseover='setBeginMenu()'  onclick='setBeginMenu()' class='"+node.getMenucode()+"'>" + node.getMenuname() + "</a>");
				returnXml.append("<ul>");
				for (int w = 0; w < list.size(); w++) 
				{
					Menu leaf = new Menu();
					leaf = (Menu) list.get(w);
					if (leaf.getParentmenucode().equals(node.getMenucode())) 
					{
						buildTree(list,leaf);
					}
				}
				returnXml.append("</ul>");
			}
			else
				returnXml.append("<a  href='#'  path='"+node.getFuncentry()+menuCodeValueParam+node.getMenucode()+"' onclick='showContent(this)'  id='"+node.getMenucode()+"'>" + node.getMenuname() + "</a>");
			
			returnXml.append("</li>");
		}
		return returnXml.toString();
		
		
	}
	
	
	
	/**
	 * 生成指定根节点下的所有子节点串
	 * @param list 平板结构list
	 * @param node 指定的根节点
	 * @return
	 */
	public String buildTree(List list,Menu node)
	{
			boolean isleaf = false;
			for(int i=0;i<list.size();i++)
			{
				Menu tempTree = new Menu();
				tempTree = (Menu)list.get(i);
				if(node.getMenucode().equals(tempTree.getParentmenucode()))
				{
					isleaf = true;
					break;
				}
			}
			
			//为叶子菜单的链接添加menuCodeValueParam参数，参数值为menucode
			String menuCodeValueParam = "menuCodeValueParam=";
			if(node.getFuncentry()!=null)
			{
				if(node.getFuncentry().indexOf("?")==-1)
					menuCodeValueParam = "?"+menuCodeValueParam;
				else if(node.getFuncentry().indexOf("?")!=-1)
					menuCodeValueParam = "&"+menuCodeValueParam;
			}
			
			//returnXml.append("<" + node.getMenucode() + ">");
			returnXml.append("<li>");
			if(isleaf)
			{
				returnXml.append("<a  href='#'  class='"+node.getMenucode()+"'>" + node.getMenuname() + "</a>");
				returnXml.append("<ul>");
				for (int w = 0; w < list.size(); w++) 
				{
					Menu leaf = new Menu();
					leaf = (Menu) list.get(w);
					if (leaf.getParentmenucode().equals(node.getMenucode())) 
					{
						buildTree(list,leaf);
					}
				}
				returnXml.append("</ul>");
			}
			else
				returnXml.append("<a  href='#' path='"+node.getFuncentry()+menuCodeValueParam+node.getMenucode()+"' onclick='showContent(this)' id='"+node.getMenucode()+"'>" + node.getMenuname() + "</a>");
			
			//returnXml.append("</" + node.getMenucode() + ">");
			returnXml.append("</li>");


		return returnXml.toString();
		
	}

	public StringBuffer getReturnXml() {
		return returnXml;
	}




	public void setReturnXml(List list) {
		this.returnXml = new StringBuffer(buildTree(list));
	}



/*
	public List getParentlist() {
		return parentlist;
	}




	public void setParentlist(List parentlist) {
		this.parentlist = parentlist;
	}*/




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 List menuList = new ArrayList();
		Menu menu = null;
		menu = new Menu();
		menu.setMenucode("ppp");
		menu.setMenuname("系统管理2");
		menu.setParentmenucode("0");
		menu.setFuncentry("business/Lgyzagl/PlbdMan.jsp");
		menuList.add(menu);
		
		menu = null;
		menu = new Menu();
		menu.setMenucode("kkk");
		menu.setMenuname("系统管理14");
		menu.setParentmenucode("0");
		menu.setFuncentry("sysadminDefault/deptTreeForm_tree.action?treeFalg=user");
		menuList.add(menu);
		
		menu = null;
		menu = new Menu();
		menu.setMenucode("amdin");
		menu.setMenuname("系统管理7");
		menu.setParentmenucode("0");
		menu.setFuncentry("sysadminDefault/deptTreeForm_tree.action?treeFalg=user");
		menuList.add(menu);

		menu = null;
		menu = new Menu();
		menu.setMenucode("hyhhh");
		menu.setMenuname("系统管理5");
		menu.setParentmenucode("0");
		menu.setFuncentry("sysadminDefault/deptTreeForm_tree.action?treeFalg=user");
		menuList.add(menu);
		

		menu = null;
		menu = new Menu();
		menu.setMenucode("gngl");
		menu.setMenuname("系统管理9");
		menu.setParentmenucode("amdin");
		menu.setFuncentry("sysadminDefault/deptTreeForm_tree.action?treeFalg=user");
		menuList.add(menu);

		menu = null;
		menu = new Menu();
		menu.setMenucode("cdgl");
		menu.setMenuname("菜单管理4");
		menu.setParentmenucode("amdin");
		menu.setFuncentry("sysadminDefault/deptTreeForm_tree.action?treeFalg=user");
		menuList.add(menu);
		
		menu = null;
		menu = new Menu();
		menu.setMenucode("asdfasdf");
		menu.setMenuname("菜单管理12");
		menu.setParentmenucode("gngl");
		menu.setFuncentry("sysadminDefault/deptTreeForm_tree.action?treeFalg=user");
		menuList.add(menu);
		 
		 /*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder dob = null;
		Document doc = null;
		try {
			dob = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		doc = dob.newDocument();

		StringBuffer str = new StringBuffer();
		Menu tree = null;
		List list = new ArrayList(0);
		for (int i = 100; i < 103; i++) {
			tree = new Menu();
			tree.setId(String.valueOf(i));
			tree.setParentId("0");
			list.add(tree);
			tree = null;
		}
		for (int i = 1000; i < 1003; i++) {
			tree = new Menu();
			tree.setId(String.valueOf(i));
			tree.setParentId("100");
			list.add(tree);
			tree = null;
		}
		for (int i = 10000; i < 10008; i++) {
			tree = new Menu();
			tree.setId(String.valueOf(i));
			tree.setParentId("1002");
			list.add(tree);
			tree = null;
		}
		for (int i = 100000; i < 100005; i++) {
			tree = new Menu();
			tree.setId(String.valueOf(i));
			tree.setParentId("10003");
			list.add(tree);
			tree = null;
		}
		for (int i = 1000000; i < 1000006; i++) {
			tree = new Menu();
			tree.setId(String.valueOf(i));
			tree.setParentId("100002");
			list.add(tree);
			tree = null;
		}
		for (int i = 10000000; i < 10000006; i++) {
			tree = new Menu();
			tree.setId(String.valueOf(i));
			tree.setParentId("1000002");
			list.add(tree);
			tree = null;
		}
		for (int i = 100000000; i < 100000006; i++) {
			tree = new Menu();
			tree.setId(String.valueOf(i));
			tree.setParentId("10000002");
			list.add(tree);
			tree = null;
		}

		*/
		TreeMenu treeMenu = new TreeMenu();
		//	System.out.println(list.size());
		long startTime = System.currentTimeMillis();
		treeMenu.setReturnXml(menuList);
		//System.out.println(treeMenu.buildTree(menuList));
		System.out.println(treeMenu.getReturnXml());

		long endTime = System.currentTimeMillis();
		System.out.println("执行时间："+(endTime-startTime)/(1000)+"秒");
		System.out.println(count);

	}
	

}
