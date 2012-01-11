package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.ISystemDao;
import com.aisino2.sysadmin.domain.System;
import com.aisino2.sysadmin.service.ISystemService;

public class SystemServiceImpl extends BaseService implements ISystemService {

	private ISystemDao systemDao;

	/** @param 系统(t_system) 增加 */
	public System insertSystem(System system){
		// TODO: implement
		   System parentSystem = getParentSystem(system);
		    if (parentSystem != null) {
		      if ("Y".equals(parentSystem.getIsleaf())) {
		        parentSystem.setIsleaf("N");
		        systemDao.updateSystem(parentSystem);
		      }
		      system.setFullcode(parentSystem.getFullcode() + system.getSystemcode() + ".");
		    }else {
		    	system.setFullcode(system.getSystemcode() + ".");
		    	system.setParentsystemcode("0");
		      }
		    return (System)systemDao.insertSystem(system);
	}

	/** @param 系统(t_system) 删除 */
	public boolean deleteSystem(System system){
		// TODO: implement
		system = getSystem(system);
		 String  parentsystemcode = system.getParentsystemcode();
		int i= systemDao.deleteSystem(system);
			System parentSystem  = new System();
			parentSystem.setParentsystemcode(parentsystemcode);
	
			boolean flag = systemDao.checkChild(parentSystem);
			if(!flag){
				parentSystem =systemDao.getParentSystem(parentSystem);
				parentSystem.setIsleaf("Y");
				systemDao.updateSystem(parentSystem);
			}
		    return i==-1?true:false;
	}
	
	/**
	    * 系统的上移、下移、置顶、置底
	    * @param system
	    * system.way取值：上移,下移,置顶,置底
	    * @return
	    */
	public  boolean updateSystemEditEdOrder(System systemOrigin)
	{
		boolean isSuccess = false;
		System system = new System();
		System parentSystem  = new System();
		System swapSystem = new System();
		int swapNodeorder = -1;
		int swapNodeorderTwo = -1;
		String systemCode = "";
		//获得system的父节点
		system.setSystemcode(systemOrigin.getSystemcode());
		system = systemDao.getSystem(system);
		parentSystem.setParentsystemcode(system.getParentsystemcode());
		parentSystem = systemDao.getParentSystem(parentSystem);
		//获得system的所有兄弟节点,包括自身
		if(parentSystem == null)//若该菜单为顶级菜单，则其父菜单的systemcode为0
		{
			parentSystem = new System();
			parentSystem.setSystemcode("0");
		}
		List siblingList = systemDao.getChildSystem(parentSystem);
		
		//若无兄弟节点，则无需进行移动操作
		if(siblingList == null)
			return true;
		else if(siblingList.size()==0)
			return true;

		if(systemOrigin !=null)
		{
			systemCode = system.getSystemcode();
			swapNodeorder = system.getNodeorder();
			if(systemCode != null)
			{
				if(systemOrigin.getWay()!=null)
				{
					for(int i = 0;i<siblingList.size();i++)
					{
						system = (System)siblingList.get(i);
						if(systemCode.equals(system.getSystemcode()))
						{
							if(systemOrigin.getWay().equals("上移"))
							{
								if(i>0)//第一个子节点无需上移
								{
									//交换需上移节点与其上一个节点的排序号
									swapSystem = (System)siblingList.get(i-1);
									system.setNodeorder(swapSystem.getNodeorder());
									swapSystem.setNodeorder(swapNodeorder);
									systemDao.updateSystem(swapSystem);
									systemDao.updateSystem(system);
									
								}
								else
									break;
							}
							else if(systemOrigin.getWay().equals("下移"))
							{
								if(i<siblingList.size()-1)//最后一个子节点无需下移
								{
									//交换需下移节点与其下一个节点的排序号
									swapSystem = (System)siblingList.get(i+1);
									system.setNodeorder(swapSystem.getNodeorder());
									swapSystem.setNodeorder(swapNodeorder);
									systemDao.updateSystem(swapSystem);
									systemDao.updateSystem(system);
									
								}
								else
									break;
							}
							else if(systemOrigin.getWay().equals("置顶"))
							{
								if(i>0)//第一个子节点无需置顶
								{
									swapSystem = (System)siblingList.get(0);
									system.setNodeorder(swapSystem.getNodeorder());
									systemDao.updateSystem(system);
									for(int j = i;j>0;j--)
									{
										swapSystem = (System)siblingList.get(j-1);
										swapNodeorderTwo = swapSystem.getNodeorder();
										swapSystem.setNodeorder(swapNodeorder);
										systemDao.updateSystem(swapSystem);
										swapNodeorder = swapNodeorderTwo;
									}
									
								}
								else
									break;
							}
							else if(systemOrigin.getWay().equals("置底"))
							{
								if(i<siblingList.size()-1)//最后一个子节点无需置底
								{
									swapSystem = (System)siblingList.get(siblingList.size()-1);
									system.setNodeorder(swapSystem.getNodeorder());
									systemDao.updateSystem(system);
									for(int j = i;j<siblingList.size()-1;j++)
									{
										swapSystem = (System)siblingList.get(j+1);
										swapNodeorderTwo = swapSystem.getNodeorder();
										swapSystem.setNodeorder(swapNodeorder);
										systemDao.updateSystem(swapSystem);
										swapNodeorder = swapNodeorderTwo;
									}
								}
								else
									break;
							}
						}
					}
				}
			}
		}
		return true;  
	}

	/** @param 系统(t_system) 修改 */
	public boolean updateSystem(System system){
		// TODO: implement
		return systemDao.updateSystem(system)>0;
	}

	/** @param 系统(t_system) 查询单条 */
	public System getSystem(System system){
		// TODO: implement
		return (System)systemDao.getSystem(system);
	}

	/** @param 系统(t_system) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return systemDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 系统(t_system) 多条查询 */
	public List getListSystem(System system){
		// TODO: implement
		return systemDao.getListSystem(system);
	}

	public ISystemDao getSystemDao() {
		return systemDao;
	}

	public void setSystemDao(ISystemDao systemDao) {
		this.systemDao = systemDao;
	}

	public List getChildSystem(System system) {
		// TODO Auto-generated method stub
		return systemDao.getChildSystem(system);
	}
	/**
	 * 当前用户所拥有的菜单
	 */
	public List getTheUserChildSystem(System system){
		return systemDao.getTheUserChildSystem(system);
	}

	public System getParentSystem(System system) {
		// TODO Auto-generated method stub
		 return systemDao.getParentSystem(system);
	}

	public List getSystemByUserID(System system) {
		// TODO Auto-generated method stub
		 return systemDao.getSystemByUserID(system);
	}

	public boolean isExit(Map condition) {
		// TODO Auto-generated method stub
		return systemDao.isExit(condition);
	}
	
	/**
	   * 获得下一个排序号
	   * @param system.parentsystemcode
	   * @return 
	*/
	public Integer getNextNodeorder(System system)
	{
		Integer nextNodeorder = 0;
		System newSystem = new System();
		newSystem = systemDao.getNextNodeorder(system);
		if(newSystem != null)
		{
			nextNodeorder = newSystem.getNodeorder();
		}
		return nextNodeorder;
	}
}
