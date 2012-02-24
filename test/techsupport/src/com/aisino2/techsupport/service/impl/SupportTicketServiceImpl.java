package com.aisino2.techsupport.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IUserService;
import com.aisino2.techsupport.dao.ISupportDeptDao;
import com.aisino2.techsupport.dao.ISupportLeaderRelationDao;
import com.aisino2.techsupport.dao.SupportTicketDao;
import com.aisino2.techsupport.domain.Attachment;
import com.aisino2.techsupport.domain.SupportDept;
import com.aisino2.techsupport.domain.SupportLeaderRelation;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.IAttachmentService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;

/**
 * 
 * 技术支持单服务
 */
@Component("SupportTicketServiceImpl")
public class SupportTicketServiceImpl extends BaseService implements
		SupportTicketService {

	private SupportTicketDao supportTicketDao;
	private static final Logger log = Logger
			.getLogger(SupportTicketService.class);

	private TrackingService trackService;

	private ISupportDeptDao supportDeptDao;

	private IDepartmentService departmentService;
	
	private ISupportLeaderRelationDao supportLeaderRelationDao;
	
	//附件服务, 这里是把关联的附件信息和技术支持单一起保存在数据库里面
	private IAttachmentService attachmentService;
	
	private IUserService user_service;
	
	@Resource(name="userService")
	public void setUser_service(IUserService user_service) {
		this.user_service = user_service;
	}

	public SupportTicketDao getSupportTicketDao() {
		return supportTicketDao;
	}

	@Resource(name = "SupportTicketDaoImpl")
	public void setSupportTicketDao(SupportTicketDao supportTicketDao) {
		this.supportTicketDao = supportTicketDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aisino2.techsupport.service.SupportTicketService#getListSupportTicket
	 * (com.aisino2.techsupport.domain.SupportTicket)
	 */

	public List<SupportTicket> getListSupportTicket(SupportTicket st) {
		List<SupportTicket> list = null;
		try {
			list = this.supportTicketDao.getListSupportTickets(st);
		} catch (RuntimeException e) {
			log.error(e);
			throw e;
		}
		return list;
	}

	public SupportTicket getSupportTicket(SupportTicket st) {
		SupportTicket supportTicket = null;
		try {
			if(st.getApplicant()==null)
				st.setApplicant(new User());
			supportTicket = this.supportTicketDao.getSupportTicket(st);
		} catch (RuntimeException e) {
			log.error(e);
			throw e;
		}
		return supportTicket;
	}

	public SupportTicket insertSupportTicket(SupportTicket st) {
		SupportTicket supportTicket = null;
		try {

			supportTicket = this.supportTicketDao.insertSupportTicket(st);

			if (supportTicket.getTrackList() != null
					&& supportTicket.getTrackList().size() > 0)
				for (int i = 0; i < supportTicket.getTrackList().size(); i++) {
					Tracking track = supportTicket.getTrackList().get(i);
					track.setStId(supportTicket.getId());
					trackService.insertTracking(track);
				}

			// 插入单位关联信息
			if (supportTicket.getSupportDeptList() != null
					&& supportTicket.getSupportDeptList().size() > 0) {
				for (Department dept : supportTicket.getSupportDeptList()) {
					if (dept == null)
						continue;
					SupportDept sdept = new SupportDept();
					Department department=new Department();
					department.setDepartcode(dept.getDepartcode());
					department=departmentService.getDepartment(department);
					sdept.setDeptId(department.getDepartid());
					sdept.setStId(supportTicket.getId());

					supportDeptDao.insertSupportDept(sdept);
				}
			}
			
			//保存附件信息
			if(supportTicket.getAttachment_list()!=null && supportTicket.getAttachment_list().size()>0){
				for(Attachment attachment : supportTicket.getAttachment_list()){
					attachment.setStId(supportTicket.getId());
					
					//插入附件信息到数据库
					attachmentService.insertAttachment(attachment);
				}
			}
		} catch (RuntimeException e) {
			log.error(e, e.fillInStackTrace());
			throw e;
		}
		return supportTicket;
	}

	public void updateSupportTicket(SupportTicket st) {
		try {
			if (st == null || st.getId() == null)
				throw new RuntimeException("技术支持单ID为空");

			// 保存支持单信息
			this.supportTicketDao.updateSupportTicket(st);

			// 更新指派关联单位信息
			if (st.getSupportDeptList() != null
					&& st.getSupportDeptList().size() > 0) {
				// 删除以前的指派单位记录，并且重新设置指派单位记录
				SupportDept supportDept = new SupportDept();
				supportDept.setStId(st.getId());
				this.supportDeptDao.removeSupportDept(supportDept);
				
				for (Department dept : st.getSupportDeptList()) {
					if (dept == null)
						continue;
					
					SupportDept sdept = new SupportDept();
					Department department=new Department();
					department.setDepartcode(dept.getDepartcode());
					department=departmentService.getDepartment(department);
					sdept.setDeptId(department.getDepartid());
					sdept.setStId(st.getId());
//					//检查是不是已有该部门了，如果没有在执行插入操作
//					SupportDept check_supportDept = null;
//					try{
//						check_supportDept = supportDeptDao.getListSupportDepts(sdept).get(0);
//					}catch (Exception e) {
//						log.debug(e,e.fillInStackTrace());
//					}
//					
//					if(check_supportDept!=null)
						this.supportDeptDao.insertSupportDept(sdept);

				}

			}
//			添加 技术负责人关联信息
			if(st.getLstSupportLeaders() != null
					&& st.getLstSupportLeaders().size() > 0){
				
				for(User sl : st.getLstSupportLeaders()){
					if(sl.getUserid() == null || sl.getUserid()==0)
						continue;
						
					//先删除以前的再添加新的负责人
					
					SupportLeaderRelation check_slrelation = new SupportLeaderRelation();
					sl = user_service.getUser(sl);
					
					check_slrelation.setDepartid(sl.getDepartid());
					check_slrelation.setStId(st.getId());
					this.supportLeaderRelationDao.delete(check_slrelation);
					
					SupportLeaderRelation slrelation=new SupportLeaderRelation();
					slrelation.setStId(st.getId());
					slrelation.setSupportLeaderId(sl.getUserid());
					//添加部门ID
					slrelation.setDepartid(sl.getDepartid());
					
//					SupportLeaderRelation check_slrelation=null;
//					try{
//						check_slrelation = this.supportLeaderRelationDao.query(slrelation).get(0);
//					}catch (Exception e) {
//						log.debug(e,e.fillInStackTrace());
//					}
//					if(check_slrelation==null)
						this.supportLeaderRelationDao.insert(slrelation);
				}
			}
			
			//保存附件信息
			if(st.getAttachment_list()!=null && st.getAttachment_list().size()>0){
				for(Attachment attachment : st.getAttachment_list()){
					attachment.setStId(st.getId());
					
					//插入附件信息到数据库
					attachmentService.insertAttachment(attachment);
				}
			}
		} catch (RuntimeException e) {
			log.error(e);
			throw e;
		}
	}

	public void deleteSupportTicket(SupportTicket st) {
		try {
			if (st == null || st.getId() == null)
				throw new RuntimeException("SupportTicket ID 为空");

			this.supportTicketDao.deleteSupportTicket(st);

		} catch (RuntimeException e) {
			log.error(e);
			throw e;
		}
	}

	public String generateSupportTicketCode() {
		
		// 河北-20110113-01
		return null;
	}

	@Resource(name = "TrackingServiceImpl")
	public void setTrackService(TrackingService trackService) {
		this.trackService = trackService;
	}

	@Resource(name = "SupportDeptDaoImpl")
	public void setSupportDeptDao(ISupportDeptDao supportDeptDao) {
		this.supportDeptDao = supportDeptDao;
	}

	public Page getListSupportTicketForPage(Map<String, Object> map,
			int pageNo, int pageSize, String sort, String desc) {
		
		return this.supportTicketDao.getSupportTicketListForPage(map, pageNo, pageSize, sort, desc);
	}

	@Resource(name="departmentService")
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Resource(name="supportLeaderDaoImpl")
	public void setSupportLeaderRelationDao(
			ISupportLeaderRelationDao supportLeaderRelationDao) {
		this.supportLeaderRelationDao = supportLeaderRelationDao;
	}

	@Resource(name="attachmentServiceImpl")
	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

}
