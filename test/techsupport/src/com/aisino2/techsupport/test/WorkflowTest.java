package com.aisino2.techsupport.test;

import java.util.List;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.techsupport.domain.Worksheet;
import com.aisino2.techsupport.service.WorksheetService;

public class WorkflowTest extends BaseTestCase{

	/**
	 * @param args
	 */
	private WorksheetService worksheetService;
	
	public void testWorksheetList(){
		List<Worksheet> worksheetlist = worksheetService.getWorksheetTaskList(null, null,null, null, null);
		assertNotNull(worksheetlist);
		System.out.println(worksheetlist.size());
		
		assertNotNull(worksheetlist.get(0).getActivityName());
		System.out.println(worksheetlist.get(0).getActivityName());
		assertNotNull(worksheetlist.get(0).getStStatusName());
		System.out.println(worksheetlist.get(0).getStStatusName());
		assertNotNull(worksheetlist.get(0).getSupportLeaderName());
		System.out.println(worksheetlist.get(0).getSupportLeaderName());
	}

	public void setWorksheetService(WorksheetService worksheetService) {
		this.worksheetService = worksheetService;
	}

	
	
	
}
