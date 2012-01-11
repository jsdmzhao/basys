package com.aisino2.publicsystem.action;

import java.util.ArrayList;
import java.util.List;

import com.aisino2.common.QjblUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.service.ICheckQyryxxService;
import com.aisino2.publicsystem.service.IQyryxxService;

public class CheckQyryxxAction extends PageAction{
	private IQyryxxService qyryxxService;
	private ICheckQyryxxService checkQyryxxService;
	
	/**
	 * 从业人员信息核查核验服务
	 */
	public void scanQyryxx() throws Exception
	{
		String sfjxgarkkbd = QjblUtil.queryQjblVal("sfjxgarkkbd");//是否进行人口库核查 1-进行核查
		
			List dhcQyryxxList = new ArrayList();
			Qyryxx qyryxx = new Qyryxx();
			dhcQyryxxList = qyryxxService.getDhdQyryxxList(qyryxx);
			if(dhcQyryxxList!=null)
			{
				if("1".equals(sfjxgarkkbd))
				{
					for(int i = 0;i<dhcQyryxxList.size();i++)
					{
						qyryxx = (Qyryxx)dhcQyryxxList.get(i);
						try
						{
							checkQyryxxService.updateCheckCyryxx(qyryxx);
						}
						catch(Exception e)
						{
							e.printStackTrace();
							System.out.println("从业人员核查程序:部级人口核查服务内部错误");
						}
					}
				}
				else
				{
					for(int i = 0;i<dhcQyryxxList.size();i++)
					{
						qyryxx = (Qyryxx)dhcQyryxxList.get(i);
						try
						{
							checkQyryxxService.updateFindRecord(qyryxx);
						}
						catch(Exception e)
						{
							e.printStackTrace();
							System.out.println("从业人员核查程序:自动置标程序内部错误");
						}
						
					}
				}
		}
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}

	public void setCheckQyryxxService(ICheckQyryxxService checkQyryxxService) {
		this.checkQyryxxService = checkQyryxxService;
	}
	
	
}