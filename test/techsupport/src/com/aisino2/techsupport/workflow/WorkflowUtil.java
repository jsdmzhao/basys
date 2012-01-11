package com.aisino2.techsupport.workflow;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jbpm.api.Configuration;
import org.jbpm.api.Deployment;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.IdentityService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IUserService;
import com.aisino2.sysadmin.service.IUser_roleService;
import com.aisino2.techsupport.common.CommonUtil;
import com.aisino2.techsupport.common.Constants;

@Component("WorkflowUtil")
public class WorkflowUtil {
	private  ProcessEngine processEngine;
	private  RepositoryService repositoryService;
	private  ExecutionService executionService;
	private  TaskService taskService;
	private  IdentityService identityService;

	/**
	 * 设置日志记录器
	 */
	private static Logger log=Logger.getLogger(WorkflowUtil.class);
	//用户服务
	private IUserService userService;
	private CommonUtil util;
	private IUser_roleService userroleService;
	private IDepartmentService departmentService;
	//单位服务
	public  ProcessEngine getProcessEngine() {
		if (processEngine == null)
			processEngine = Configuration.getProcessEngine();
		return processEngine;
	}

	public  RepositoryService getRepositoryService() {
		if (repositoryService == null)
			repositoryService = getProcessEngine().getRepositoryService();
		return repositoryService;
	}

	public  ExecutionService getExecutionService() {
		if (executionService == null)
			executionService = getProcessEngine().getExecutionService();
		return executionService;
	}

	public  TaskService getTaskService() {
		if (taskService == null)
			taskService = getProcessEngine().getTaskService();
		return taskService;
	}

	public  IdentityService getIdentityService() {
		if (identityService == null)
			identityService = getProcessEngine().getIdentityService();
		return identityService;
	}

	/**
	 * 流程开始
	 * 
	 * @param var
	 *            流程变量
	 */
	public  void workflowStart(Map<String, Object> var) {

		List<ProcessDefinition> pdList = getRepositoryService()
				.createProcessDefinitionQuery()
				.processDefinitionName(Constants.workflowName).list();
		String deployid = null;
//		if (pdList.size() >= 0 ) {
//			deployid = workflowDeploy();
//
//			getExecutionService().startProcessInstanceById(
//					getRepositoryService().createProcessDefinitionQuery()
//							.deploymentId(deployid).list().get(0).getId(), var);
//		}
		try{
			deployid = workflowDeploy();
	
			getExecutionService().startProcessInstanceById(
					getRepositoryService().createProcessDefinitionQuery()
							.deploymentId(deployid).list().get(0).getId(), var);
		}catch (org.jbpm.api.JbpmException e) {
			ProcessDefinition pd = pdList.get(pdList.size() - 1);
			getExecutionService().startProcessInstanceById(pd.getId(), var);
		}
//		else {
//			ProcessDefinition pd = pdList.get(pdList.size() - 1);
//			getExecutionService().startProcessInstanceById(pd.getId(), var);
//		}

	}

	/**
	 * 流程下一个环节
	 * 
	 * @param var
	 *            流程变量
	 */
	public  void workflowNext(Map<String, Object> var) {
		if (var.containsKey("transition")) {
			getTaskService().completeTask(String.valueOf(var.get("taskId")),
					String.valueOf(var.get("transition")), var);
		} else {
			getTaskService().completeTask(String.valueOf(var.get("taskId")),
					var);
		}
	}

	/**
	 * 新发布流程
	 */
	public  String workflowDeploy() {
		Deployment deployment = getRepositoryService()
				.createDeployment()
				.addResourceFromClasspath(
						"com/aisino2/techsupport/workflow/techsupport.jpdl.xml");
		return ((DeploymentImpl)deployment).deploy();
	}

	/**
	 * 设置流程变量
	 * 
	 * @param taskId
	 *            工作流任务ID
	 * @param assignee
	 *            任务指派映射名单（具体指派，只能单一指派）
	 * @param candidateUsers
	 *            指派任务候选人 （候选指派，可以有多个用户，分别用逗号隔开）
	 * @param params
	 *            附带业务参数
	 * @return 流程变量
	 */
	public  Map<String, Object> setVariable(String taskId,
			Map<String, Object> assignee, Map<String, Object> candidateUsers,
			Map<String, Object> params) {
		Map<String, Object> var = new HashMap<String, Object>();

		if (taskId != null)
			var.put("taskId", taskId);
		if (assignee != null)
			var.putAll(assignee);
		if (candidateUsers != null)
			var.putAll(candidateUsers);
		if (params != null)
			var.putAll( params);
		return var;
	}

	/**
	 * 设置流程变量
	 * 
	 * @param taskId
	 *            工作流任务ID
	 * @param params
	 *            附带业务参数
	 * @return 流程变量
	 */
	public  Map<String, Object> setVariable(String taskId,
			Map<String, Object> params) {
		Map<String, Object> var = new HashMap<String, Object>();

		if (taskId != null)
			var.put("taskId", taskId);
		if (params != null)
			var.putAll( params);
		return var;
	}

	/**
	 * 设置流程变量
	 * 
	 * @param taskId
	 *            工作流任务ID
	 * @param transition
	 *            线路名称
	 * @param params
	 *            附带业务参数
	 * @return 流程变量
	 */
	public  Map<String, Object> setVariable(String taskId,
			String transition, Map<String, Object> params) {
		Map<String, Object> var = new HashMap<String, Object>();

		if (taskId != null)
			var.put("taskId", taskId);
		if (params != null)
			var.putAll(params);

		if (transition != null)
			var.put("transition", transition);

		return var;
	}

	public  Map<String, Object> setDeptAssigneeVariable(
			List<Department> asssigneeDeptList) {
		Map<String, Object> params = new HashMap<String, Object>();

		if(asssigneeDeptList==null)
			throw new RuntimeException("需要指派的单位列表为空");
		params.put("deptApprovalUsers", "");
		try {

			// 通过选定的单位找到拥有部门经理角色的用户 来做指派
			String assigneeDeptUsersId = "";
			for (Department dept : asssigneeDeptList) {
				if(dept==null)
					continue;
				Department department=new Department();
				department.setDepartcode(dept.getDepartcode());
				department=departmentService.getDepartment(department);
				
				User user = new User();
				user.setDepartid(department.getDepartid());
				List<User> deptUsers = userService.getListUser(user);
				for (User deptUser : deptUsers) {
					User_role deptUserRole = new User_role();
					deptUserRole.setUserid(deptUser.getUserid());
					
					List<User_role> userrolelist = userroleService.getUser_roleListByUserid(deptUserRole);
					for (User_role userRole : userrolelist) {
						try {
							if (userRole
									.getRolename()
									.equals(util
											.getTechSupportEnvConfig("techsupport.role.tech_department_approve"))) {
								assigneeDeptUsersId += userRole.getUserid()
										+ ",";
							}
						} catch (IOException e) {
							log.error(e, e.fillInStackTrace());
						}
					}
				}

			}
			assigneeDeptUsersId = assigneeDeptUsersId.substring(0,
					assigneeDeptUsersId.length() - 1);

			params.put("deptApprovalUsers", assigneeDeptUsersId);
		} catch (IndexOutOfBoundsException e) {
		} catch (NullPointerException e) {
		} finally{
			return params;
		}
	}
	
	@Resource(name="userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Resource(name="CommonUtil")
	public void setUtil(CommonUtil util) {
		this.util = util;
	}

	@Resource(name="user_roleService")
	public void setUserroleService(IUser_roleService userroleService) {
		this.userroleService = userroleService;
	}

	@Resource(name="departmentService")
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
}
