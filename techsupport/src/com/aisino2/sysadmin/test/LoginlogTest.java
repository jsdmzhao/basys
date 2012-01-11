package com.aisino2.sysadmin.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Loginlog;
import com.aisino2.sysadmin.service.ILoginlogService;

public class LoginlogTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ILoginlogService loginlogService;

	/** @param 登录日志表(t_loginlog) */

	public void test() {
		Loginlog loginlog = new Loginlog();

	/** @ 登录日志ID(loginlogid) */
	loginlog.setLoginlogid(0);

	/** @ 登录用户ID(loginuserid) */
	loginlog.setLoginuserid(0);

	/** @ 登录用户名(useraccount) */
	loginlog.setUseraccount("test");

	/** @ 姓名(username) */
	loginlog.setUsername("test");

	/** @ 登录单位代码(loginunitcode) */
	loginlog.setLoginunitcode("test");

	/** @ 登录单位名称(loginunitname) */
	loginlog.setLoginunitname("test");

	/** @ 登录IP(loginip) */
	loginlog.setLoginip("test");

	/** @ 登录MAC(loginmac) */
	loginlog.setLoginmac("test");

	/** @ 登录时间(logintiime) */
	loginlog.setLogintiime(new Date());

	/** @ 退出时间(quittime) */
	loginlog.setQuittime(new Date());

		/*
		//插入对象
		loginlogService.insertLoginlog(loginlog);

		//读取对象比较
		BaseObject bo = loginlogService.getLoginlog(loginlog);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Loginlog loginlogNew = (Loginlog)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(loginlogNew.getLoginlogid(), loginlog.getLoginlogid());
		assertEquals(loginlogNew.getLoginuserid(), loginlog.getLoginuserid());
		assertEquals(loginlogNew.getUseraccount(), loginlog.getUseraccount());
		assertEquals(loginlogNew.getUsername(), loginlog.getUsername());
		assertEquals(loginlogNew.getLoginunitcode(), loginlog.getLoginunitcode());
		assertEquals(loginlogNew.getLoginunitname(), loginlog.getLoginunitname());
		assertEquals(loginlogNew.getLoginip(), loginlog.getLoginip());
		assertEquals(loginlogNew.getLoginmac(), loginlog.getLoginmac());
		assertEquals(loginlogNew.getLogintiime(), loginlog.getLogintiime());
		assertEquals(loginlogNew.getQuittime(), loginlog.getQuittime());

		//删除对象
		// @ 登录日志ID(loginlogid) 
		loginlog.setLoginlogid(1)

		loginlogService.deleteLoginlog(loginlog);

		//修改对象
		// @ 登录日志ID(loginlogid) 
		loginlog.setLoginlogid(1)

		loginlogService.updateLoginlog(loginlog);

		//查询单条
		// @ 登录日志ID(loginlogid) 
		loginlog.setLoginlogid(1)

		loginlogService.getLoginlog(loginlog);

		//查询多条
		// @ 登录日志ID(loginlogid) 
		loginlog.setLoginlogid(1)

		loginlogService.getListLoginlog(loginlog);

		//翻页查询
		// @ 登录日志ID(loginlogid) 
		loginlog.setLoginlogid(1)

		loginlogService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		loginlogService.insertLoginlog(loginlog);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setLoginlogService(ILoginlogService loginlogService) {
		this.loginlogService = loginlogService;
	}
}
