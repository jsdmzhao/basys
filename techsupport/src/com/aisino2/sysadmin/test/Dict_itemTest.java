package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.service.IDict_itemService;

public class Dict_itemTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IDict_itemService dict_itemService;

	/** @param 字典项(t_dict_item) */

	public void test() {
		Dict_item dict_item = new Dict_item();

	/** @ 字典项ID(item_id) */
	dict_item.setItem_id(0);

	/** @ 字典编码(dict_code) */
	dict_item.setDict_code("test");

	/** @ 显示名称(display_name) */
	dict_item.setDisplay_name("test");

	/** @ 实际值(fact_value) */
	dict_item.setFact_value("test");

	/** @ 附加值(append_value) */
	dict_item.setAppend_value("test");

	/** @ 上级字典项ID(super_item_id) */
	dict_item.setSuper_item_id(0);

	/** @ 兄弟排序(sib_order) */
	dict_item.setSib_order(0);

	/** @ 叶节点标志(leaf_flag) */
	dict_item.setLeaf_flag("te");

	/** @ 显示标志(display_flag) */
	dict_item.setDisplay_flag(0);

	/** @ 有效标志(valid_flag) */
	dict_item.setValid_flag(0);

	/** @ 字典项名称简拼(item_simplepin) */
	dict_item.setItem_simplepin("test");

	/** @ 字典项名称全拼(item_allpin) */
	dict_item.setItem_allpin("test");

		/*
		//插入对象
		dict_itemService.insertDict_item(dict_item);

		//读取对象比较
		BaseObject bo = dict_itemService.getDict_item(dict_item);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Dict_item dict_itemNew = (Dict_item)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(dict_itemNew.getItem_id(), dict_item.getItem_id());
		assertEquals(dict_itemNew.getDict_code(), dict_item.getDict_code());
		assertEquals(dict_itemNew.getDisplay_name(), dict_item.getDisplay_name());
		assertEquals(dict_itemNew.getFact_value(), dict_item.getFact_value());
		assertEquals(dict_itemNew.getAppend_value(), dict_item.getAppend_value());
		assertEquals(dict_itemNew.getSuper_item_id(), dict_item.getSuper_item_id());
		assertEquals(dict_itemNew.getSib_order(), dict_item.getSib_order());
		assertEquals(dict_itemNew.getLeaf_flag(), dict_item.getLeaf_flag());
		assertEquals(dict_itemNew.getDisplay_flag(), dict_item.getDisplay_flag());
		assertEquals(dict_itemNew.getValid_flag(), dict_item.getValid_flag());
		assertEquals(dict_itemNew.getItem_simplepin(), dict_item.getItem_simplepin());
		assertEquals(dict_itemNew.getItem_allpin(), dict_item.getItem_allpin());

		//删除对象
		// @ 字典项ID(item_id) 
		dict_item.setItem_id(1)
		// @ 字典编码(dict_code) 
		dict_item.setDict_code(1)

		dict_itemService.deleteDict_item(dict_item);

		//修改对象
		// @ 字典项ID(item_id) 
		dict_item.setItem_id(1)
		// @ 字典编码(dict_code) 
		dict_item.setDict_code(1)

		dict_itemService.updateDict_item(dict_item);

		//查询单条
		// @ 字典项ID(item_id) 
		dict_item.setItem_id(1)
		// @ 字典编码(dict_code) 
		dict_item.setDict_code(1)

		dict_itemService.getDict_item(dict_item);

		//查询多条
		// @ 字典项ID(item_id) 
		dict_item.setItem_id(1)
		// @ 字典编码(dict_code) 
		dict_item.setDict_code(1)

		dict_itemService.getListDict_item(dict_item);

		//翻页查询
		// @ 字典项ID(item_id) 
		dict_item.setItem_id(1)
		// @ 字典编码(dict_code) 
		dict_item.setDict_code(1)

		dict_itemService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/
	Dict_item dict_itemSort = new Dict_item();
	dict_itemSort.setItem_id(1013);
	dict_itemSort.setDict_code("dm_bhkyy");
	dict_itemSort.setSib_order(0);
	dict_itemSort.setWay("置顶");
	//dict_itemSort.setWay("上移");
	//dict_itemSort.setWay("下移");
	//dict_itemSort.setWay("置底");
	dict_itemService.updateDict_itemEditEdOrder(dict_itemSort);
		//插入对象
		
	//dict_itemService.insertDict_item(dict_item);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}
}
