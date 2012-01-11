package com.aisino2.sysadmin.test;

import java.util.HashMap;
import java.util.Map;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IUserService;

public class UserTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IUserService userService;

	/** @param 用户(t_user) */

	public void test() {
		User user = new User();

	/** @ 用户ID(userid) */
	//user.setUserid(0);

	/** @ 机构ID(departid) */
	//user.setDepartid(0);

	/** @ 用户帐号名(useraccount) */
	//user.setUseraccount("test");

	/** @ 用户姓名(username) */
	//user.setUsername("test");

	/** @ 用户口令(password) */
	//user.setPassword("test");

	/** @ 用户顺序(userorder) */
	//user.setUserorder(0);

	/** @ 是否有效(isvalid) */
	//user.setIsvalid("te");

	/** @ 用户类别(usertype) */
	//user.setUsertype("test");

		/*
		//插入对象
		userService.insertUser(user);

		//读取对象比较
		BaseObject bo = userService.getUser(user);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		User userNew = (User)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(userNew.getUserid(), user.getUserid());
		assertEquals(userNew.getDepartid(), user.getDepartid());
		assertEquals(userNew.getUseraccount(), user.getUseraccount());
		assertEquals(userNew.getUsername(), user.getUsername());
		assertEquals(userNew.getPassword(), user.getPassword());
		assertEquals(userNew.getUserorder(), user.getUserorder());
		assertEquals(userNew.getIsvalid(), user.getIsvalid());
		assertEquals(userNew.getUsertype(), user.getUsertype());

		//删除对象
		// @ 用户ID(userid) 
		user.setUserid(1)
		// @ 机构ID(departid) 
		user.setDepartid(1)

		userService.deleteUser(user);

		//修改对象
		// @ 用户ID(userid) 
		user.setUserid(1)
		// @ 机构ID(departid) 
		user.setDepartid(1)

		userService.updateUser(user);

		//查询单条
		// @ 用户ID(userid) 
		user.setUserid(1)
		// @ 机构ID(departid) 
		user.setDepartid(1)

		userService.getUser(user);

		//查询多条
		// @ 用户ID(userid) 
		user.setUserid(1)
		// @ 机构ID(departid) 
		user.setDepartid(1)

		userService.getListUser(user);

		//翻页查询
		// @ 用户ID(userid) 
		user.setUserid(1)
		// @ 机构ID(departid) 
		user.setDepartid(1)

		userService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/
	/*User userSort = new User();
	userSort.setUserid(42);
	userSort.setUserorder(0);
	//userSort.setWay("置顶");
	//userSort.setWay("上移");
	//userSort.setWay("下移");
	userSort.setWay("置底");
	userService.updateUserEditEdOrder(userSort);*/
	Map map = new HashMap();
	map.put("mrjs11", "30");
	map.put("mrjs12", "29");
	map.put("mrjs13", "31");
	map.put("mrjs14", "28");
	map.put("mrjs24", "");
	user.setUseraccount("test12");
	user.setUsername("测试默认角色11");
	user.setPassword("b59c67bf196a4758191e42f76670ceba");
	user.setUserorder(8);
	user.setDepartid(14);
	user.setUsertype("11,12,14,24");
	user.setDefaultRoleMap(map);
		//插入对象
		userService.insertUser(user);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
