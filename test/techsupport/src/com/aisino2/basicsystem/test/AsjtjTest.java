package com.aisino2.basicsystem.test;

import java.util.HashMap;
import java.util.Map;

import com.aisino2.basicsystem.service.IAsjtjService;
import com.aisino2.core.test.BaseTestCase;

public class AsjtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IAsjtjService asjtjService;

	public IAsjtjService getAsjtjService() {
		return asjtjService;
	}

	public void setAsjtjService(IAsjtjService asjtjService) {
		this.asjtjService = asjtjService;
	}

	
		public void testService()
		{
			Map map = new HashMap();
			map.put("dsjgbz", "1");
			map.put("fxjbz", "1");
			map.put("gxdwbz", "1");
			map.put("csbz","1");
			asjtjService.getAsjtjList(map, 1, 1, null, null);
		}
		public void testService1()
		{
			Map map = new HashMap();
			map.put("dsjgbz", "1");
			map.put("fxjbz", "1");
			map.put("gxdwbz", "1");
			map.put("csbz","0");
			asjtjService.getAsjtjList(map, 1, 1, null, null);
		}
		public void testService2()
		{
			Map map = new HashMap();
			map.put("dsjgbz", "1");
			map.put("fxjbz", "1");
			map.put("gxdwbz", "0");
			map.put("csbz","0");
			asjtjService.getAsjtjList(map, 1, 1, null, null);
		}
		public void testService3()
		{
			Map map = new HashMap();
			map.put("dsjgbz", "1");
			map.put("fxjbz", "0");
			map.put("gxdwbz", "0");
			map.put("csbz","0");
			asjtjService.getAsjtjList(map, 1, 1, null, null);
		}
		public void testService4()
		{
			Map map = new HashMap();
			map.put("dsjgbz", "0");
			map.put("fxjbz", "0");
			map.put("gxdwbz", "0");
			map.put("csbz","0");
			asjtjService.getAsjtjList(map, 1, 1, null, null);
		}

	}

