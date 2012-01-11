package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.service.IDepartmentService;

public class DepartmentTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IDepartmentService departmentService;

	/** @param 机构(t_department) */

	public void test() {
		Department department = new Department();

	/** @ 机构ID(departid) */
	department.setDepartid(12309);

	/** @ 机构代码(departcode) */
	//department.setDepartcode("CJD3206");

	/** @ 机构名称(departname) */
	//department.setDepartname("南通");

	/** @ 机构层次(departlevel) */
	//department.setDepartlevel(3);

	/** @ 父机构ID(parentdepartid) */
	//department.setParentdepartid(514);

	/** @ 机构全路径代码(departfullcode) */
	//department.setDepartfullcode("111.CJD32.CJD3206.");

	/** @ 节点顺序(nodeorder) */
	department.setNodeorder(6);

	/** @ 是否叶结点(isleaf) */
	//department.setIsleaf("N");

	/** @ 机构名称简拼(departsimplepin) */
	//department.setDepartsimplepin("NT");

	/** @ 机构名称全拼(departallpin) */
	//department.setDepartallpin("nantong");

		/*
		//插入对象
		departmentService.insertDepartment(department);

		//读取对象比较
		BaseObject bo = departmentService.getDepartment(department);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Department departmentNew = (Department)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(departmentNew.getDepartid(), department.getDepartid());
		assertEquals(departmentNew.getDepartcode(), department.getDepartcode());
		assertEquals(departmentNew.getDepartname(), department.getDepartname());
		assertEquals(departmentNew.getDepartlevel(), department.getDepartlevel());
		assertEquals(departmentNew.getParentdepartid(), department.getParentdepartid());
		assertEquals(departmentNew.getDepartfullcode(), department.getDepartfullcode());
		assertEquals(departmentNew.getNodeorder(), department.getNodeorder());
		assertEquals(departmentNew.getIsleaf(), department.getIsleaf());
		assertEquals(departmentNew.getDepartsimplepin(), department.getDepartsimplepin());
		assertEquals(departmentNew.getDepartallpin(), department.getDepartallpin());

		//删除对象
		// @ 机构ID(departid) 
		department.setDepartid(1)

		departmentService.deleteDepartment(department);

		//修改对象
		// @ 机构ID(departid) 
		department.setDepartid(1)

		departmentService.updateDepartment(department);

		//查询单条
		// @ 机构ID(departid) 
		department.setDepartid(1)

		departmentService.getDepartment(department);

		//查询多条
		// @ 机构ID(departid) 
		department.setDepartid(1)

		departmentService.getListDepartment(department);

		//翻页查询
		// @ 机构ID(departid) 
		department.setDepartid(1)

		departmentService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/
		department.setWay("置顶");
	//department.setWay("上移");
		//department.setWay("下移");
		//department.setWay("置底");
		departmentService.updateDeptEditEdOrder(department);
		//插入对象
		//departmentService.insertDepartment(department);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
}
