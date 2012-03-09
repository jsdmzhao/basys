package com.aisino2.techsupport.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.BaseAction;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.sysadmin.service.IUser_roleService;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.service.ISmsService;
import com.aisino2.techsupport.service.SupportTicketService;

@SuppressWarnings("serial")
@Component
@Scope("prototype")
public class SmsHintAction extends BaseAction {
	private int returnNO = 0;
	private String returnMsg = "";
	private ISmsService smsSendService;
	private SupportTicketService stService;
	private List<SupportTicket> lSt;

	/**
	 * 允许短信提示的状态
	 */
	private String[] smsStatus;

	/**
	 * 发送短信
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sendSms() throws Exception {
		try {
			if (lSt == null || lSt.size() == 0)
				throw new RuntimeException("没有技术支持单被选中");

			for (int i=0 ;i< lSt.size();i++) {
				SupportTicket st = lSt.get(i);
				lSt.remove(st);
				st = stService.getSupportTicket(st);
				lSt.add(i,st);
			}

			String receivePhone = null;
			String senderName = "";
			// 设置收信人的手机号码
			// 进行中为技术负责人
			// 待反馈为申请人
//			@fixed 技术负责人为多人指派，短信提示也应该多人转发
			senderName=((User)this.getRequest().getSession().getAttribute(com.aisino2.sysadmin.Constants.userKey)).getUsername();
			if (lSt.get(0).getStStatus().equals(Constants.ST_STATUS_GOING)){
				for(User sl : lSt.get(0).getLstSupportLeaders()){
					receivePhone = sl.getMobilephone();
					smsSendService.sendSms(lSt, receivePhone, senderName);
				}
				
			}
			else if (lSt.get(0).getStStatus()
					.equals(Constants.ST_STATUS_WAIT_FEEDBACK)){
				receivePhone = lSt.get(0).getApplicant().getMobilephone();
				smsSendService.sendSms(lSt, receivePhone, senderName);
			}
			
			returnMsg = "短信发送成功";

		} catch (RuntimeException e) {
			returnNO = 1;
			returnMsg = "短信发件箱添加失败:"+e.getMessage();
			log.debug(e);
		}

		return SUCCESS;
	}

	/**
	 * 获取可以发送短信的的状态
	 * 
	 * @return
	 * @throws Exception
	 */
	public String smsRoleStatus() throws Exception {
		User curUser = (User) getRequest().getSession().getAttribute(
				com.aisino2.sysadmin.Constants.userKey);
		smsStatus = smsSendService.getSmsRoleStatus(curUser);
		return SUCCESS;
	}

	public int getReturnNO() {
		return returnNO;
	}

	public void setReturnNO(int returnNO) {
		this.returnNO = returnNO;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public List<SupportTicket> getlSt() {
		return lSt;
	}

	public void setlSt(List<SupportTicket> lSt) {
		this.lSt = lSt;
	}

	@Resource(name = "SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	@Resource(name = "smsServiceImpl")
	public void setSmsSendService(ISmsService smsSendService) {
		this.smsSendService = smsSendService;
	}

	public String[] getSmsStatus() {
		return smsStatus;
	}

	public void setSmsStatus(String[] smsStatus) {
		this.smsStatus = smsStatus;
	}

}
