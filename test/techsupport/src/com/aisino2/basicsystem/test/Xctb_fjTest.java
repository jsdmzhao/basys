package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Xctb_fj;
import com.aisino2.basicsystem.service.IXctb_fjService;
import com.aisino2.core.test.BaseTestCase;

public class Xctb_fjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IXctb_fjService xctb_fjService;

	/** @param 协查通报_附件(t_xctb_fj) */

	public void test() {
		Xctb_fj xctb_fj = new Xctb_fj();

	/** @ 通报ID(tbid) */
	//xctb_fj.setTbid(0);

	/** @ 附件ID(附件id) */
	//xctb_fj.set附件id(0);

	/** @ 附件名称(附件名称) */
	//xctb_fj.set附件名称("test");

	/** @ 附件类型(附件类型) */
	//xctb_fj.set附件类型("test");

	/** @ 附件内容(附件内容) */
	//xctb_fj.set附件内容(null);

	/** @ 附件序号(附件序号) */
	//xctb_fj.set附件序号(0);

		/*
		//插入对象
		xctb_fjService.insertXctb_fj(xctb_fj);

		//读取对象比较
		BaseObject bo = xctb_fjService.getXctb_fj(xctb_fj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Xctb_fj xctb_fjNew = (Xctb_fj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(xctb_fjNew.getTbid(), xctb_fj.getTbid());
		assertEquals(xctb_fjNew.get附件id(), xctb_fj.get附件id());
		assertEquals(xctb_fjNew.get附件名称(), xctb_fj.get附件名称());
		assertEquals(xctb_fjNew.get附件类型(), xctb_fj.get附件类型());
		assertEquals(xctb_fjNew.get附件内容(), xctb_fj.get附件内容());
		assertEquals(xctb_fjNew.get附件序号(), xctb_fj.get附件序号());

		//删除对象
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 附件ID(附件id) 
		xctb_fj.set附件id(1)

		xctb_fjService.deleteXctb_fj(xctb_fj);

		//修改对象
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 附件ID(附件id) 
		xctb_fj.set附件id(1)

		xctb_fjService.updateXctb_fj(xctb_fj);

		//查询单条
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 附件ID(附件id) 
		xctb_fj.set附件id(1)

		xctb_fjService.getXctb_fj(xctb_fj);

		//查询多条
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 附件ID(附件id) 
		xctb_fj.set附件id(1)

		xctb_fjService.getListXctb_fj(xctb_fj);

		//翻页查询
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 通报ID(tbid) 
		xctb_fj.setTbid(1)
		// @ 附件ID(附件id) 
		xctb_fj.set附件id(1)

		xctb_fjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		xctb_fjService.insertXctb_fj(xctb_fj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setXctb_fjService(IXctb_fjService xctb_fjService) {
		this.xctb_fjService = xctb_fjService;
	}
}
