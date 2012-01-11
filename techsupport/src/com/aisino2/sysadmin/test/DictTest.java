package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.service.IDictService;

public class DictTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IDictService dictService;

	/** @param 字典(t_dict) */

	public void test() {
		Dict dict = new Dict();

	/** @ 字典编码(dict_code) */
	dict.setDict_code("test");

	/** @ 字典名(dict_name) */
	dict.setDict_name("test");

	/** @ 上级字典编码(super_dict_code) */
	dict.setSuper_dict_code("test");

	/** @ 兄弟排序(sib_order) */
	dict.setSib_order(0);

	/** @ 叶节点标志(leaf_flag) */
	dict.setLeaf_flag("te");

	/** @ 维护标志(maint_flag) */
	dict.setMaint_flag(0);

	/** @ 字典类型(dict_type) */
	dict.setDict_type("te");

	/** @ 字典名称简拼(dict_simplepin) */
	dict.setDict_simplepin("test");

	/** @ 字典名称全拼(dict_allpin) */
	dict.setDict_allpin("test");

	/** @ 字典项的表名(dict_itemtablename) */
	dict.setDict_itemtablename("test");

	/** @ 版本号(dict_versionid) */
	dict.setDict_versionid("test");

	/** @ 字典id(dict_id) */
	dict.setDict_id(0);

		/*
		//插入对象
		dictService.insertDict(dict);

		//读取对象比较
		BaseObject bo = dictService.getDict(dict);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Dict dictNew = (Dict)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(dictNew.getDict_code(), dict.getDict_code());
		assertEquals(dictNew.getDict_name(), dict.getDict_name());
		assertEquals(dictNew.getSuper_dict_code(), dict.getSuper_dict_code());
		assertEquals(dictNew.getSib_order(), dict.getSib_order());
		assertEquals(dictNew.getLeaf_flag(), dict.getLeaf_flag());
		assertEquals(dictNew.getMaint_flag(), dict.getMaint_flag());
		assertEquals(dictNew.getDict_type(), dict.getDict_type());
		assertEquals(dictNew.getDict_simplepin(), dict.getDict_simplepin());
		assertEquals(dictNew.getDict_allpin(), dict.getDict_allpin());
		assertEquals(dictNew.getDict_itemtablename(), dict.getDict_itemtablename());
		assertEquals(dictNew.getDict_versionid(), dict.getDict_versionid());
		assertEquals(dictNew.getDict_id(), dict.getDict_id());

		//删除对象
		// @ 字典编码(dict_code) 
		dict.setDict_code(1)

		dictService.deleteDict(dict);

		//修改对象
		// @ 字典编码(dict_code) 
		dict.setDict_code(1)

		dictService.updateDict(dict);

		//查询单条
		// @ 字典编码(dict_code) 
		dict.setDict_code(1)

		dictService.getDict(dict);

		//查询多条
		// @ 字典编码(dict_code) 
		dict.setDict_code(1)

		dictService.getListDict(dict);

		//翻页查询
		// @ 字典编码(dict_code) 
		dict.setDict_code(1)

		dictService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		dictService.insertDict(dict);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setDictService(IDictService dictService) {
		this.dictService = dictService;
	}
}
