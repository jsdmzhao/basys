package com.aisino2.techsupport.workflow.assignee;

import java.util.Map;

import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;
import org.springframework.stereotype.Component;

@Component("CommonAssignmentHandler")
public class CommonAssignmentHandler implements AssignmentHandler {

	public void assign(Assignable assignable, OpenExecution execution)
			throws Exception {
		//指派下一个环节操作用户
		//User curuser = (User) request.getSession().getAttribute(Constants.userKey);
		//开始流程 //### 需要指派短信发送人为候选者
		
		Map<String, Object> var = (Map<String, Object>) execution.getVariables();
		
		if(var.containsKey("assignee"))
			assignable.setAssignee(var.get("assignee").toString());
		if(var.containsKey("candidateUsers"))
			for(String userid : (String[])var.get("candidateUsers"))
				assignable.addCandidateUser(userid);
		if(var.containsKey("candidateGroups"))
			for(String groupid : (String[]) var.get("candidateGroups"))
				assignable.addCandidateGroup(groupid);
		
	}

}
