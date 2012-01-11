package com.aisino2.publicsystem.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aisino2.common.ImageUtil;
import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Cljbxx;
import com.aisino2.publicsystem.domain.Clxx_zp;
import com.aisino2.publicsystem.domain.Clxxry_zp;
import com.aisino2.publicsystem.domain.Clxxwgryxx;
import com.aisino2.publicsystem.service.ICljbxxService;

public class CljbxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ICljbxxService cljbxxService;

	/** @param 车辆基本信息(t_cljbxx) */
	@Override
	protected String[] getConfigLocations() {
		String [] paths = 
			new String[]{"/config/spring/applicationContext.xml",
				"/config/spring/basicsystem-service.xml",
				"/config/spring/basicsystem-dao.xml",
				"/config/spring/publicsystem-service.xml",
				"/config/spring/publicsystem-dao.xml",
				"/config/spring/sysadmin-service.xml",
				"/config/spring/sysadmin-dao.xml"};
		return paths;
	}
	
	public void test() {
		Cljbxx cljbxx = new Cljbxx();

	/** @ 车辆基本信息ID(cljbxxid) */
	cljbxx.setCljbxxid(1);

	/** @ 车辆登记序号(cldjxh) */
	cljbxx.setCldjxh("test");

	/** @ 车辆类型编码(cllxbm) */
	cljbxx.setCllxbm("t");

	/** @ 车辆类型(cllx) */
	cljbxx.setCllx("test");

	/** @ 车辆品牌编码(clppbm) */
	cljbxx.setClppbm("test");

	/** @ 车辆品牌(clpp) */
	cljbxx.setClpp("test");

	/** @ 车身主色编码(cszsbm) */
	cljbxx.setCszsbm("tes");

	/** @ 车身主色(cszs) */
	cljbxx.setCszs("test");

	/** @ 第一辅色编码(dyfsbm) */
	cljbxx.setDyfsbm("tes");

	/** @ 第一辅色(dyfs) */
	cljbxx.setDyfs("test");

	/** @ 第二辅色编码(drfsbm) */
	cljbxx.setDrfsbm("tes");

	/** @ 第二辅色(drfs) */
	cljbxx.setDrfs("test");

	/** @ 车牌号(cph) */
	cljbxx.setCph("test");

	/** @ 是否有车牌标志(sfycphbz) */
	cljbxx.setSfycphbz("t");

	/** @ 无车牌号原因编码(wcphyybm) */
	cljbxx.setWcphyybm("te");

	/** @ 无车牌号原因(wcphyy) */
	cljbxx.setWcphyy("test");

	/** @ 无车牌号原因描述(wcphyyms) */
	cljbxx.setWcphyyms("test");

	/** @ 号牌种类编码(hpzlbm) */
	cljbxx.setHpzlbm("te");

	/** @ 号牌种类(hpzl) */
	cljbxx.setHpzl("test");

	/** @ 发动机号(fdjh) */
	cljbxx.setFdjh("test");

	/** @ 车架号(cjh) */
	cljbxx.setCjh("test");

	/** @ 受理时间(slsj) */
	cljbxx.setSlsj(new Date());

	/** @ 受理人(slr) */
	cljbxx.setSlr("test");

	/** @ 录入时间(lrsj) */
	cljbxx.setLrsj(new Date());

	/** @ 录入人(lrr) */
	cljbxx.setLrr("test");

	/** @ 撤销时间(cxsj) */
	cljbxx.setCxsj(new Date());

	/** @ 撤销标志(cxbz) */
	cljbxx.setCxbz("te");

	/** @ 撤销人(cxr) */
	cljbxx.setCxr("test");

	/** @ 车辆性质(clxz) */
	cljbxx.setClxz("t");

	/** @ 车主(czm) */
	cljbxx.setCzm("test");

	/** @ 车主电话(czdh) */
	cljbxx.setCzdh("test");

	/** @ 车主国籍代码(czgjdm) */
	cljbxx.setCzgjdm("tes");

	/** @ 车主国籍(czgj) */
	cljbxx.setCzgj("test");

	/** @ 车主户籍地址(czhjdz) */
	cljbxx.setCzhjdz("test");

	/** @ 车主行政区划代码(czxzqhdm) */
	cljbxx.setCzxzqhdm("test");

	/** @ 车主行政区划(czxzqh) */
	cljbxx.setCzxzqh("test");

	/** @ 车主性别代码(czxbdm) */
	cljbxx.setCzxbdm("t");

	/** @ 车主性别(czxb) */
	cljbxx.setCzxb("te");

	/** @ 车主常用证件类型代码(czcyzjlxdm) */
	cljbxx.setCzcyzjlxdm("test");

	/** @ 车主常用证件(czcyzj) */
	cljbxx.setCzcyzj("test");

	/** @ 车主证件号码(czzjhm) */
	cljbxx.setCzzjhm("test");

	/** @ 行驶里程(xslc) */
	cljbxx.setXslc(0);

	/** @ 车辆状态(clzt) */
	cljbxx.setClzt("te");

	/** @ 备注(bz) */
	cljbxx.setBz("test");
	
	cljbxx.setClxxwgryxx(getClxxWgryxx());  
	//cljbxx.setLClxx_zpList(getClxx_zpList());
	cljbxx.setLClxxry_zpList(getClxxry_zpList());

		/*

		//读取对象比较
		BaseObject bo = cljbxxService.getCljbxx(cljbxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Cljbxx cljbxxNew = (Cljbxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(cljbxxNew.getCljbxxid(), cljbxx.getCljbxxid());
		assertEquals(cljbxxNew.getCldjxh(), cljbxx.getCldjxh());
		assertEquals(cljbxxNew.getCllxbm(), cljbxx.getCllxbm());
		assertEquals(cljbxxNew.getCllx(), cljbxx.getCllx());
		assertEquals(cljbxxNew.getClppbm(), cljbxx.getClppbm());
		assertEquals(cljbxxNew.getClpp(), cljbxx.getClpp());
		assertEquals(cljbxxNew.getCszsbm(), cljbxx.getCszsbm());
		assertEquals(cljbxxNew.getCszs(), cljbxx.getCszs());
		assertEquals(cljbxxNew.getDyfsbm(), cljbxx.getDyfsbm());
		assertEquals(cljbxxNew.getDyfs(), cljbxx.getDyfs());
		assertEquals(cljbxxNew.getDrfsbm(), cljbxx.getDrfsbm());
		assertEquals(cljbxxNew.getDrfs(), cljbxx.getDrfs());
		assertEquals(cljbxxNew.getCph(), cljbxx.getCph());
		assertEquals(cljbxxNew.getSfycphbz(), cljbxx.getSfycphbz());
		assertEquals(cljbxxNew.getWcphyybm(), cljbxx.getWcphyybm());
		assertEquals(cljbxxNew.getWcphyy(), cljbxx.getWcphyy());
		assertEquals(cljbxxNew.getWcphyyms(), cljbxx.getWcphyyms());
		assertEquals(cljbxxNew.getHpzlbm(), cljbxx.getHpzlbm());
		assertEquals(cljbxxNew.getHpzl(), cljbxx.getHpzl());
		assertEquals(cljbxxNew.getFdjh(), cljbxx.getFdjh());
		assertEquals(cljbxxNew.getCjh(), cljbxx.getCjh());
		assertEquals(cljbxxNew.getSlsj(), cljbxx.getSlsj());
		assertEquals(cljbxxNew.getSlr(), cljbxx.getSlr());
		assertEquals(cljbxxNew.getLrsj(), cljbxx.getLrsj());
		assertEquals(cljbxxNew.getLrr(), cljbxx.getLrr());
		assertEquals(cljbxxNew.getCxsj(), cljbxx.getCxsj());
		assertEquals(cljbxxNew.getCxbz(), cljbxx.getCxbz());
		assertEquals(cljbxxNew.getCxr(), cljbxx.getCxr());
		assertEquals(cljbxxNew.getClxz(), cljbxx.getClxz());
		assertEquals(cljbxxNew.getCzm(), cljbxx.getCzm());
		assertEquals(cljbxxNew.getCzdh(), cljbxx.getCzdh());
		assertEquals(cljbxxNew.getCzgjdm(), cljbxx.getCzgjdm());
		assertEquals(cljbxxNew.getCzgj(), cljbxx.getCzgj());
		assertEquals(cljbxxNew.getCzhjdz(), cljbxx.getCzhjdz());
		assertEquals(cljbxxNew.getCzxzqhdm(), cljbxx.getCzxzqhdm());
		assertEquals(cljbxxNew.getCzxzqh(), cljbxx.getCzxzqh());
		assertEquals(cljbxxNew.getCzxbdm(), cljbxx.getCzxbdm());
		assertEquals(cljbxxNew.getCzxb(), cljbxx.getCzxb());
		assertEquals(cljbxxNew.getCzcyzjlxdm(), cljbxx.getCzcyzjlxdm());
		assertEquals(cljbxxNew.getCzcyzj(), cljbxx.getCzcyzj());
		assertEquals(cljbxxNew.getCzzjhm(), cljbxx.getCzzjhm());
		assertEquals(cljbxxNew.getXslc(), cljbxx.getXslc());
		assertEquals(cljbxxNew.getClzt(), cljbxx.getClzt());
		assertEquals(cljbxxNew.getBz(), cljbxx.getBz());

		//删除对象
		// @ 车辆基本信息ID(cljbxxid) 
		cljbxx.setCljbxxid(1)

		cljbxxService.deleteCljbxx(cljbxx);

		//修改对象
		// @ 车辆基本信息ID(cljbxxid) 
		cljbxx.setCljbxxid(1)

		cljbxxService.updateCljbxx(cljbxx);

		//查询单条
		// @ 车辆基本信息ID(cljbxxid) 
		cljbxx.setCljbxxid(1)

		cljbxxService.getCljbxx(cljbxx);

		//查询多条
		// @ 车辆基本信息ID(cljbxxid) 
		cljbxx.setCljbxxid(1)

		cljbxxService.getListCljbxx(cljbxx);

		//翻页查询
		// @ 车辆基本信息ID(cljbxxid) 
		cljbxx.setCljbxxid(1)

		cljbxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//cljbxxService.insertCljbxx(cljbxx);
		cljbxxService.updateCljbxx(cljbxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	private Clxxwgryxx getClxxWgryxx(){

		Clxxwgryxx clxxwgryxx = new Clxxwgryxx();

		/** @ 车辆基本信息ID(cljbxxid) */
		clxxwgryxx.setCljbxxid(0);

		/** @ 外国人信息ID(wgrxxid) */
		clxxwgryxx.setWgrxxid(0);

		/** @ 外国人员类别(wgrylb) */
		clxxwgryxx.setWgrylb("te");

		/** @ 英文姓(ywx) */
		clxxwgryxx.setYwx("test");

		/** @ 英文名(ywm) */
		clxxwgryxx.setYwm("test");

		/** @ 签证种类代码(qzzldm) */
		clxxwgryxx.setQzzldm("test");

		/** @ 签证种类(qzzl) */
		clxxwgryxx.setQzzl("test");

		/** @ 签证号码(qzhm) */
		clxxwgryxx.setQzhm("test");

		/** @ 在华停留期至(zatlq) */
		clxxwgryxx.setZatlq(new Date());

		/** @ 签发机关(qfjg) */
		clxxwgryxx.setQfjg("test");

		/** @ 入境日期(rjrq) */
		clxxwgryxx.setRjrq(new Date());

		/** @ 入境口岸(rjka) */
		clxxwgryxx.setRjka("test");
		
		return clxxwgryxx;
	}
	
	private List getClxx_zpList(){
		List list = new ArrayList();
		Clxx_zp clxx_zp;
		sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
		try {
			byte[] by = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
			for(int index=0;index<4;index++){
				clxx_zp = new Clxx_zp();
				int zpid = index + 1;
				clxx_zp.setClxxzpid(zpid);
				if(zpid==1){
					clxx_zp.setTpnr(by);
				}else if(zpid==4)
					clxx_zp.setZpsfsc("1");
				
				clxx_zp.setTplx("jpg");
				list.add(clxx_zp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	private List getClxxry_zpList(){
		List list = new ArrayList();
		Clxxry_zp clxxry_zp;
		sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
		try {
			byte[] by = base64Decoder.decodeBuffer(ImageUtil.picConTemp);
			for(int index=0;index<1;index++){
				clxxry_zp = new Clxxry_zp();
				clxxry_zp.setClxxryzpid(1);
				clxxry_zp.setTplx("jpg");
				clxxry_zp.setTpnr(by);
				list.add(clxxry_zp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void setCljbxxService(ICljbxxService cljbxxService) {
		this.cljbxxService = cljbxxService;
	}
}
