package com.aisino2.techsupport.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.sysadmin.service.IUser_roleService;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.dao.ISmsBoxSendingDao;
import com.aisino2.techsupport.domain.SmsBoxSending;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.ISmsService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;

/**
 * 短信提示服务
 * 
 */
@Component
public class SmsServiceImpl implements ISmsService {

	private ISmsBoxSendingDao sendingDao;
	private IUser_roleService user_roleService;
	private IDict_itemService dict_itemService;
	private TrackingService trackingService;

	/*
	 * 发送短信
	 * 
	 * @see com.aisino2.techsupport.service.ISmsService#sendSms(java.util.List)
	 */
	public void sendSms(List<SupportTicket> lSt, String receivePhone,
			String senderName) {
		if (lSt == null || lSt.size() == 0)
			throw new RuntimeException("支持单列表为空");
		if (receivePhone == null || receivePhone.trim().length() == 0)
			throw new RuntimeException("收件人号码为空");

		for (SupportTicket st : lSt) {
			Tracking tracking = new Tracking();
			tracking.setStId(st.getId());
			st.setTrackList(trackingService.getTrackingList(tracking));

			SmsBoxSending sms = new SmsBoxSending();
			sms.setInpool("0");
			sms.setPri("5");
			sms.setSendmode("1");
			sms.setReceiver(receivePhone);
			sms.setSender(senderName);
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");

			// 设置发送时间
			sms.setInserttime(format.format(new Date()));
			sms.setSendtime(sms.getInserttime());

			// 单位
			String deptNames = "";
			for (Department dept : st.getSupportDeptList()) {
				deptNames += "," + dept.getDepartname();
			}
			deptNames = deptNames.substring(1);
			// @fixed 技术负责人变成多个指派
			String supportLeaderNames = "";
			for (User sl : st.getLstSupportLeaders())
				supportLeaderNames = "," + sl.getUsername();
			supportLeaderNames = supportLeaderNames.length() > 0 ? supportLeaderNames
					.substring(1) : supportLeaderNames;
			sms.setContent("支持单进度: ["
					+ st.getStNo()
					+ "],申请人:"
					+ st.getApplicant().getUsername()
					+ ",技术负责人:"
					+ "["
					+ supportLeaderNames
					+ "]"
					+ ",技术支持部门:"
					+ deptNames
					+ ",技术支持单内容:"
					+ st.getSupportContent()
					+ ",当前进展:"
					+ st.getTrackList().get(st.getTrackList().size() - 1)
							.getNewProcess());

			this.sendingDao.insert(sms);
		}
	}

	@Resource(name = "smsBoxSendingDaoImpl")
	public void setSendingDao(ISmsBoxSendingDao sendingDao) {
		this.sendingDao = sendingDao;
	}

	@Resource(name = "user_roleService")
	public void setUser_roleService(IUser_roleService user_roleService) {
		this.user_roleService = user_roleService;
	}

	@Resource(name = "dict_itemService")
	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aisino2.techsupport.service.ISmsService#getSmsRoleStauts(com.aisino2
	 * .sysadmin.domain.User)
	 */
	public String[] getSmsRoleStatus(User curUser) {
		Set<String> smsStatus = new HashSet<String>();
		User_role user_role = new User_role();
		user_role.setUserid(curUser.getUserid());
		List<User_role> lstUserRole = user_roleService
				.getUser_roleListByUserid(user_role);
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code(Constants.ST_SMS_ROLE_STATUS_DICT_CODE);
		List<Dict_item> lstDictItem = dict_itemService
				.getListDict_item(dict_item);
		for (User_role ur : lstUserRole) {
			for (Dict_item di : lstDictItem) {
				if (di.getDisplay_name().contains(ur.getRolename())) {
					smsStatus.add(di.getFact_value());
				}
			}
		}
		String[] a = null;
		if (smsStatus.size() > 0) {
			a = new String[smsStatus.size()];
			a = smsStatus.toArray(a);
		}

		return a;
	}

	@Resource(name = "TrackingServiceImpl")
	public void setTrackingService(TrackingService trackingService) {
		this.trackingService = trackingService;
	}

}
