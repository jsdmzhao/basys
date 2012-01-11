package com.aisino2.publicsystem.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.common.QjblUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.publicsystem.dao.IAqjcsbDao;
import com.aisino2.publicsystem.dao.IBafwhtDao;
import com.aisino2.publicsystem.dao.IBaryxxDao;
import com.aisino2.publicsystem.dao.IBldsjksbDao;
import com.aisino2.publicsystem.dao.IBwryxxDao;
import com.aisino2.publicsystem.dao.IPmtDao;
import com.aisino2.publicsystem.dao.IQybgxxDao;
import com.aisino2.publicsystem.dao.IQyfflDao;
import com.aisino2.publicsystem.dao.IQyjbxxDao;
import com.aisino2.publicsystem.dao.IQyjbxx_lsDao;
import com.aisino2.publicsystem.dao.IQyxxczrzDao;
import com.aisino2.publicsystem.dao.IQyzhtbDao;
import com.aisino2.publicsystem.dao.IQyzjbDao;
import com.aisino2.publicsystem.dao.IWgtzrxxDao;
import com.aisino2.publicsystem.dao.IZjb_lsDao;
import com.aisino2.publicsystem.domain.Aqjcsb;
import com.aisino2.publicsystem.domain.Bafwht;
import com.aisino2.publicsystem.domain.Baryxx;
import com.aisino2.publicsystem.domain.Bldsjksb;
import com.aisino2.publicsystem.domain.Bwryxx;
import com.aisino2.publicsystem.domain.Pmt;
import com.aisino2.publicsystem.domain.Qybgxx;
import com.aisino2.publicsystem.domain.Qyffl;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyjbxx_ls;
import com.aisino2.publicsystem.domain.Qysh;
import com.aisino2.publicsystem.domain.Qyxxczrz;
import com.aisino2.publicsystem.domain.Qyzhtb;
import com.aisino2.publicsystem.domain.Qyzjb;
import com.aisino2.publicsystem.domain.Wgtzrxx;
import com.aisino2.publicsystem.domain.Zjb_ls;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IQyshService;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IUserService;

public class QyjbxxServiceImpl extends BaseService implements IQyjbxxService {

	private IQyjbxxDao qyjbxxDao;
	private IScbmDao scbmDao;
	private IQyzjbDao qyzjbDao;
	private IQyfflDao qyfflDao;
	private IWgtzrxxDao wgtzrxxDao;
	private IBafwhtDao bafwhtDao;
	private IBldsjksbDao bldsjksbDao;
	private IAqjcsbDao aqjcsbDao;
	private IPmtDao pmtDao;
	private IBaryxxDao baryxxDao;
	private IBwryxxDao bwryxxDao;
	private IQyxxczrzDao qyxxczrzDao;
	private IQyjbxx_lsDao qyjbxx_lsDao;
	private IZjb_lsDao zjb_lsDao;
	private IDepartmentService departmentService;
	private IQyzhtbDao qyzhtbDao;
	private IQyryxxService qyryxxService;
	private IQyshService qyshService;
	private IUserService userService;
	private IQybgxxDao qybgxxDao; //企业变更信息
	private String[] bglxdm = { "01","02","03","04","05","06","07","08","99" };
	private String[] bglx = { "变更名称","变更经营地址","变更法定代表人或主要负责人","变更投资人","变更经营范围",
						"变更娱乐项目","变更主要设施设备","改建、扩建营业场所","其他变更事项" };

	/** @param 企业基本信息(t_qyjbxx) 增加 */
	public Qyjbxx insertQyjbxx(Qyjbxx qyjbxx){
		// TODO: implement
		List baryxxList;
		Qyzjb qyzjb  = new Qyzjb();
		Qyffl qyffl = new Qyffl();
		Wgtzrxx wgtzrxx = new Wgtzrxx();
		Bafwht bafwht = new Bafwht();
		Bldsjksb bldsjksb = new Bldsjksb();
		Aqjcsb aqjcsb = new Aqjcsb();
		Pmt pmt = new Pmt();
		Baryxx baryxx = new Baryxx();//保安人员信息
		Bwryxx bwryxx;//保卫人员信息
		Qyxxczrz qyxxczrz = new Qyxxczrz();
		Department department = new Department();
		Date currentDate = new Date();
		
		
		Qyjbxx qyjbxxNew = new Qyjbxx();
		
		
		//获得企业编码
		//娱乐业及公共场所行业：企业主分类+6位行政区划+5位流水号
		//其他行业：企业主分类+6位行政区划+4位流水号
		Map scbmMap = new HashMap();
		String qyzflbm = qyjbxx.getQyzflbm();
		if(qyzflbm.startsWith("J")||qyzflbm.startsWith("H")
				||qyzflbm.startsWith("G")||qyzflbm.startsWith("K")||qyzflbm.startsWith("L")
				||qyzflbm.startsWith("M")||qyzflbm.startsWith("N")||qyzflbm.startsWith("O")
				||qyzflbm.startsWith("P")||qyzflbm.startsWith("Y")){ //yangbo update 20100301 ;mds modified at 20100818 增加公共场所的判断
			scbmMap.put("p_bmfl", qyjbxx.getQyzflbm().substring(0,1));
			scbmMap.put("p_xzqh", qyjbxx.getQyzflbm().substring(1,qyjbxx.getQyzflbm().length())+StringUtil.add0(qyjbxx.getGxdwbm(), 6).substring(0, 6));
		}
		else
		{
			scbmMap.put("p_bmfl", qyjbxx.getQyzflbm());
			scbmMap.put("p_xzqh", StringUtil.add0(qyjbxx.getGxdwbm(), 6).substring(0, 6));
		}
		String sssf = "hn";//所属省份，默认为hn，需从全局参数中取值
		String tempSssf = QjblUtil.queryQjblVal("sssf");
		if(tempSssf!=null&&!"".equals(tempSssf))
			sssf = tempSssf;
		scbmMap.put("p_sssf", sssf);
		scbmMap.put("p_scgz", 3);
		//若前台传入的qybm为空，则调用编码生成程序生成编码。
		if(qyjbxx.getQybm()==null||"".equals(qyjbxx.getQybm()))
			qyjbxx.setQybm(scbmDao.getScbm(scbmMap));
		//企业主表增加
		qyjbxx.setBabh(qyjbxx.getQybm());//备案编码即为企业编码 (modified by mds at 20100113)
		qyjbxx.setBarq(currentDate);//备案日期为当前日期 (modified by mds at 20100113)
		
		//企业核查开关移到提交时判定
//		String qyhckg = QjblUtil.queryQjblVal("qyhckg");//企业核查开关 0-关（企业增加时直接生成账号，无需核查）1-开
		if(!"90".equals(qyjbxx.getZt())){
//			if(!"0".equals(qyhckg))
//			{
				//采集点增加企业时，默认状态为0；公安端增加企业，默认状态为3 (modified by mds at 20100531)
				if(qyjbxx.getLrdwbm().indexOf("CJD")!=-1)
				{
					qyjbxx.setZt("0");
				}
				else
				{
					qyjbxx.setZt("3");
				}
//			}
//			else
//			{
//				qyjbxx.setZt("1");
//			}
		}
		
		
		qyjbxx.setZxbz("0");
		qyjbxx.setBcsj(currentDate);
		qyjbxx.setLrsj(currentDate);
		if(qyjbxx.getDjrq()==null){
			qyjbxx.setDjrq(currentDate);
		}
		if(qyjbxx.getQymc()!=null)
		{
			qyjbxx.setQyjp(PinYinUtil.getHanyuPingYinInitial(qyjbxx.getQymc()));
			qyjbxx.setQyqp(PinYinUtil.getHanyuPingYin(qyjbxx.getQymc()));
		}
		if(qyjbxx.getQyjc()!=null&&!"".equals(qyjbxx.getQyjc()))
		{
			qyjbxx.setQyjcjp(PinYinUtil.getHanyuPingYinInitial(qyjbxx.getQyjc()));
			qyjbxx.setQyjcqp(PinYinUtil.getHanyuPingYin(qyjbxx.getQyjc()));
		}
		if(qyjbxx.getGxdwbm()!=null)
		{
			
			//获得地市机关代码和名称
			//四个直辖市的地市机关截取前2位
			if(!qyjbxx.getGxdwbm().substring(0, 2).equals("11")
					&&!qyjbxx.getGxdwbm().substring(0, 2).equals("12")
					&&!qyjbxx.getGxdwbm().substring(0, 2).equals("31")
					&&!qyjbxx.getGxdwbm().substring(0, 2).equals("50"))
				qyjbxx.setSsddsjgdm(StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 4),12));
			else
				qyjbxx.setSsddsjgdm(StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 2),12));
			department.setDepartcode(qyjbxx.getSsddsjgdm());
			department = departmentService.getDepartment(department);
			if(department != null)
				qyjbxx.setSsddsjgmc(department.getDepartname());
			
			//获得分县局机关代码和名称
			department = new Department();
			qyjbxx.setSsdxjgajgdm(StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 6),12));
			department.setDepartcode(qyjbxx.getSsdxjgajgdm());
			department = departmentService.getDepartment(department);
			if(department != null)
				qyjbxx.setSsdxjgajgmc(department.getDepartname());
			
		}
		//将副分类编码和名称拼成串，以“|”分隔，存入主表
		qyjbxx.setQyfflbm(getQyfflStr(qyjbxx.getLQyfflList(),"0"));
		qyjbxx.setQyfflmc(getQyfflStr(qyjbxx.getLQyfflList(),"1"));
		qyjbxx.setZrs(0);
		qyjbxxNew = qyjbxxDao.insertQyjbxx(qyjbxx);
		
		//若场所核查开关关掉，则直接生成账号
//		if("0".equals(qyhckg))
//		{
//			Qyzhtb qyzhtb = new Qyzhtb();
//			qyzhtb.setQybm(qyjbxxNew.getQybm());
//			qyzhtbDao.insertQyzhtb(qyzhtb);
//		}
		
		Integer qyNewId = qyjbxxNew.getQyid();
		//证件表增加
		if(qyjbxx.getLQyzjbList() != null)
		{
			for(int i=0;i<qyjbxx.getLQyzjbList().size();i++)
			{
				qyzjb = (Qyzjb)qyjbxx.getLQyzjbList().get(i);
				qyzjb.setQyid(qyNewId);
				qyzjbDao.insertQyzjb(qyzjb);
			}
		}
		
		//场所副分类增加
		if(qyjbxx.getLQyfflList() != null)
		{
			if(qyjbxx.getLQyfflList().size()>0)
			{
				for(int i=0;i<qyjbxx.getLQyfflList().size();i++)
				{
					qyffl = (Qyffl)qyjbxx.getLQyfflList().get(i);
					qyffl.setQyid(qyNewId);
					qyfflDao.insertQyffl(qyffl);
				}
			}
		}
		//外国投资人信息增加
		//经济类型为港澳台投资或外国投资时才增加外国投资人信息
		if(qyjbxx.getJjlxbm()!=null)
		{
			if(qyjbxx.getJjlxbm().length()>0)
			{
				String jjlx = "";
				jjlx = qyjbxx.getJjlxbm();
				if(jjlx.substring(0, 1).equals("2")||jjlx.substring(0, 1).equals("3"))
				{
					if(qyjbxx.getLWgtzrxxList()!=null)
					{
						if(qyjbxx.getLWgtzrxxList().size()>0)
						{
							for(int i=0;i<qyjbxx.getLWgtzrxxList().size();i++)
							{
								wgtzrxx = (Wgtzrxx)qyjbxx.getLWgtzrxxList().get(i);
								wgtzrxx.setQyid(qyNewId);
								wgtzrxxDao.insertWgtzrxx(wgtzrxx);
							}
						}
					}
				}
			}
		}
		
		//保安服务合同增加
		if(qyjbxx.getLBafwhtList()!=null)
		{
			if(qyjbxx.getLBafwhtList().size()>0)
			{
				for(int i=0;i<qyjbxx.getLBafwhtList().size();i++)
				{
					bafwht = (Bafwht)qyjbxx.getLBafwhtList().get(i);
					bafwht.setQyid(qyNewId);
					//合同结束日期通过 签订日期+合同有效期 计算
					if(bafwht.getQdrq()!=null&&bafwht.getHtyxq()!=null)
					{
						Calendar c = Calendar.getInstance();
						c.setTime(bafwht.getQdrq());
						c.add(c.YEAR, bafwht.getHtyxq());
						if(c!=null)
							bafwht.setJsrq(c.getTime());
					}
					bafwhtDao.insertBafwht(bafwht);
				}
			}
		}
		//闭路电视监控设备增加
		if(qyjbxx.getLBldsjksbList()!=null)
		{
			if(qyjbxx.getLBldsjksbList().size()>0)
			{
				for(int i=0;i<qyjbxx.getLBldsjksbList().size();i++)
				{
					bldsjksb = (Bldsjksb)qyjbxx.getLBldsjksbList().get(i);
					bldsjksb.setQyid(qyNewId);
					bldsjksb.setZt("1");  //添加时默认是使用状态
					//获得闭路电视监控设备序号,企业编码+ 一位大写英文字母“A”+四位顺序码 （0001～9999）
					scbmMap = new HashMap();
					scbmMap.put("p_bmfl", "BLDSJK");
					scbmMap.put("p_xzqh", qyjbxxNew.getQybm()+"B");
					scbmMap.put("p_sssf", sssf);
					scbmMap.put("p_scgz", 3);
					bldsjksb.setSbxh(scbmDao.getScbm(scbmMap));
					bldsjksbDao.insertBldsjksb(bldsjksb);
				}
			}
		}
		//安全检查设备增加

		if(qyjbxx.getLAqjcsbList()!=null)
		{
			if(qyjbxx.getLAqjcsbList().size()>0)
			{
				for(int i=0;i<qyjbxx.getLAqjcsbList().size();i++)
				{
					aqjcsb = (Aqjcsb)qyjbxx.getLAqjcsbList().get(i);
					aqjcsb.setQyid(qyNewId);
					aqjcsb.setZt("1");
					//获得闭路电视监控设备序号,企业编码+ 一位大写英文字母“A”+四位顺序码 （0001～9999）
					scbmMap = new HashMap();
					scbmMap.put("p_bmfl", "AQJCSB");
					scbmMap.put("p_xzqh", qyjbxxNew.getQybm()+"A");
					scbmMap.put("p_sssf", sssf);
					scbmMap.put("p_scgz", 3);
					aqjcsb.setSbxh(scbmDao.getScbm(scbmMap));
					aqjcsb.setLrr(qyjbxx.getLrr());
					aqjcsb.setLrsj(qyjbxx.getLrsj());
					aqjcsbDao.insertAqjcsb(aqjcsb);
				}
			}
		}
		//平面图增加

		if(qyjbxx.getLPmtList()!=null)
		{
			if(qyjbxx.getLPmtList().size()>0)
			{
				for(int i=0;i<qyjbxx.getLPmtList().size();i++)
				{
					pmt = (Pmt)qyjbxx.getLPmtList().get(i);
					pmt.setQyid(qyNewId);
					pmtDao.insertPmt(pmt);
				}
			}
		}
		//保安人员信息添加
		baryxxList = qyjbxx.getLBaryxxList();
		if(baryxxList != null && baryxxList.size() > 0){
			for(int indexNum=0;indexNum<baryxxList.size();indexNum++){
				baryxx = (Baryxx)baryxxList.get(indexNum);
				baryxx.setQyid(qyNewId);
				baryxx.setLrr(qyjbxx.getLrr());
				baryxx.setZt("1");//添加时，默认在职状态
				baryxx.setLrsj(qyjbxx.getLrsj());
				baryxxDao.insertBaryxx(baryxx);
			}
		}

		//保卫人员添加
		List bwryxxList = qyjbxx.getLBwryxxList();
		if(bwryxxList!=null){
			int bwryLstLength = bwryxxList.size();
			for(int index=0;index<bwryLstLength;index++){
				bwryxx = (Bwryxx)bwryxxList.get(index);
				bwryxx.setZt("1");//添加时，默认在职状态
				bwryxx.setQyid(qyNewId);
				bwryxxDao.insertBwryxx(bwryxx);
			}
		}
		
		
		//企业信息操作日志
		qyxxczrz.setQybm(qyjbxxNew.getQybm());
		qyxxczrz.setCzlx("增加");
		qyxxczrz.setCzr(qyjbxx.getLrr());
		/*qyxxczrz.setCznr(cznr);*/
		qyxxczrz.setCzsj(currentDate);
		qyxxczrzDao.insertQyxxczrz(qyxxczrz);
		
		return qyjbxxNew;
	}

	/** @param 企业基本信息(t_qyjbxx) 删除 */
	public boolean deleteQyjbxx(Qyjbxx qyjbxx){
		// TODO: implement
		return qyjbxxDao.deleteQyjbxx(qyjbxx)>0;
	}

	/** @param 企业基本信息(t_qyjbxx) 修改 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public boolean updateQyjbxx(Qyjbxx qyjbxx) throws Exception{
		// TODO: implement
		boolean isSuccess = false;
		Qyzjb qyzjb  = new Qyzjb();
		Qyzjb qyzjbbak  = null;
		Zjb_ls zjb_ls = null;
		List qyzjbList = new ArrayList();
		Qyffl qyffl = new Qyffl();
		Wgtzrxx wgtzrxx = new Wgtzrxx();
		Bafwht bafwht = new Bafwht();
		Bldsjksb bldsjksb = new Bldsjksb();
		Bldsjksb bldsjksbExist = new Bldsjksb();
		List bldsjksbExistList = new ArrayList();
		Aqjcsb aqjcsb = new Aqjcsb();
		Aqjcsb aqjcsbExist = new Aqjcsb();
		List aqjcsbExistList = new ArrayList();
		Pmt pmt = new Pmt();
		List pmtExistList = new ArrayList();
		Pmt pmtExist = new Pmt();
		Baryxx baryxx = new Baryxx();
		Baryxx baryxxExist = new Baryxx();
		List baryxxExistList = new ArrayList();
		List baryxxList;
		Bwryxx bwryxx = new Bwryxx();
		Bwryxx bwryxxExist = new Bwryxx();
		List bwryxxExistList = new ArrayList();
		List bwryxxList;
		
		Qyxxczrz qyxxczrz = new Qyxxczrz();
		Department department = new Department();
		boolean isPmtExist = false;//数据库中平面图是否在提交数据中存在
		boolean isBldsjksbExist = false;//数据库中闭路电视监控设备是否在提交数据中存在
		boolean isAqjcsbExist = false;//数据库中安全检查设备是否在提交数据中存在
		boolean isBaryxxExist = false;//数据库中保安人员是否在提交数据中存在
		boolean isBwryxxExist = false;//数据库中保卫人员是否在提交数据中存在
		
		String webserviceFlag = qyjbxx.getWebserviceFlag();// webservice调用标示
		
		Map scbmMap = new HashMap();
		String sssf = "hn";//所属省份，默认为hn，需从全局参数中取值
		String tempSssf = QjblUtil.queryQjblVal("sssf");
		if(tempSssf!=null&&!"".equals(tempSssf))
			sssf = tempSssf;

		Date currentDate = new Date();
		
		//保存企业历史信息
		int qyid = qyjbxx.getQyid();
		Qyjbxx_ls qyjbxx_ls = new Qyjbxx_ls();
		Qyjbxx qyjbxx_bak = new Qyjbxx();
		qyjbxx_bak.setQyid(qyid);
		qyjbxx_bak = qyjbxxDao.getQyjbxx(qyjbxx_bak);
		if(qyjbxx_bak!=null)
			BeanUtils.copyProperties(qyjbxx_ls, qyjbxx_bak);
		if(qyjbxx.getCzlx()==null||"".equals(qyjbxx.getCzlx()))
			qyjbxx_ls.setCzlx("修改");
		else{
			qyjbxx_ls.setCzlx(qyjbxx.getCzlx());
			qyjbxx_ls.setZtgbrq(new Date());
		}
		//变更涉及的信息项
		if(qyjbxx.getBgdjxh() != null)
			qyjbxx_ls.setBgdjxh(qyjbxx.getBgdjxh());
		if(qyjbxx.getBgyy() != null)
			qyjbxx_ls.setBgyy(qyjbxx.getBgyy());
		if(qyjbxx.getBglbdm() != null)
			qyjbxx_ls.setBglbdm(qyjbxx.getBglbdm());
		if(qyjbxx.getBglb() != null)
			qyjbxx_ls.setBglb(qyjbxx.getBglb());
		
		qyjbxx_ls = qyjbxx_lsDao.insertQyjbxx_ls(qyjbxx_ls);
		
		//保存证件表历史信息
		qyzjb.setQyid(qyid);
		qyzjbList = qyzjbDao.getListQyzjb(qyzjb);
		if(qyzjbList != null)
		{
			for(int i=0;i<qyzjbList.size();i++)
			{
				qyzjbbak = new Qyzjb();
				qyzjbbak = (Qyzjb)qyzjbList.get(i);
				zjb_ls = new Zjb_ls();
				if(qyzjbbak!=null)
					BeanUtils.copyProperties(zjb_ls, qyzjbbak);
				zjb_ls.setFk_zjid(qyzjbbak.getZjid());
				zjb_ls.setQyid(qyid);
				zjb_ls.setQylsid(qyjbxx_ls.getQylsid());
				zjb_lsDao.insertZjb_ls(zjb_ls);
				zjb_ls = null;
				qyzjbbak = null;
			}
		}
		//场所主表修改
		//将副分类编码和名称拼成串，以“\|”分隔，存入主表
		qyjbxx.setQyfflbm(getQyfflStr(qyjbxx.getLQyfflList(),"0"));
		qyjbxx.setQyfflmc(getQyfflStr(qyjbxx.getLQyfflList(),"1"));
		qyjbxx.setBcsj(currentDate);
		if(qyjbxx.getQymc()!=null)
		{
			qyjbxx.setQyjp(PinYinUtil.getHanyuPingYinInitial(qyjbxx.getQymc()));
			qyjbxx.setQyqp(PinYinUtil.getHanyuPingYin(qyjbxx.getQymc()));
		}
		if(qyjbxx.getQyjc()!=null&&!"".equals(qyjbxx.getQyjc()))
		{
			qyjbxx.setQyjcjp(PinYinUtil.getHanyuPingYinInitial(qyjbxx.getQyjc()));
			qyjbxx.setQyjcqp(PinYinUtil.getHanyuPingYin(qyjbxx.getQyjc()));
		}
		if(qyjbxx.getGxdwbm()!=null)
		{
			if(!qyjbxx_ls.getGxdwbm().equals(qyjbxx.getGxdwbm()))
			{
				//获得地市机关代码和名称
				//四个直辖市的地市机关截取前2位
				if(!qyjbxx.getGxdwbm().substring(0, 2).equals("11")
						&&!qyjbxx.getGxdwbm().substring(0, 2).equals("12")
						&&!qyjbxx.getGxdwbm().substring(0, 2).equals("31")
						&&!qyjbxx.getGxdwbm().substring(0, 2).equals("50"))
					qyjbxx.setSsddsjgdm(StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 4),12));
				else
					qyjbxx.setSsddsjgdm(StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 2),12));
				department.setDepartcode(qyjbxx.getSsddsjgdm());
				department = departmentService.getDepartment(department);
				if(department != null)
					qyjbxx.setSsddsjgmc(department.getDepartname());
				
				//获得分县局机关代码和名称
				department = new Department();
				qyjbxx.setSsdxjgajgdm(StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 6),12));
				department.setDepartcode(qyjbxx.getSsdxjgajgdm());
				department = departmentService.getDepartment(department);
				if(department != null)
					qyjbxx.setSsdxjgajgmc(department.getDepartname());
			}
			
		}
		//若场所原状态为11，则修改后状态置为12 11-派出所审核失败 12-派出所审核已修改
		if(qyjbxx_ls.getZt().equals("11"))
			qyjbxx.setZt("12");
		qyjbxxDao.updateQyjbxx(qyjbxx);
		String qyhckg = QjblUtil.queryQjblVal("qyhckg");//企业核查开关 0-关（企业增加时直接生成账号，无需核查）1-开
 		if("0".equals(qyhckg)&&!qyjbxx_bak.getQymc().equals(qyjbxx.getQymc())
 				&&"变更".equals(qyjbxx.getCzlx()))
 		{
 				Qyzhtb qyzhtb = new Qyzhtb();
 				qyzhtb.setQybm(qyjbxx_bak.getQybm());
 				int errCode = qyzhtbDao.updateQyzhtb(qyzhtb);
 		}
		
		
		//场所副分类修改
		qyffl.setQyid(qyid);
		qyfflDao.deleteQyffl(qyffl);
		if(qyjbxx.getLQyfflList() != null)
		{
			if(qyjbxx.getLQyfflList().size()>0)
			{
				for(int i=0;i<qyjbxx.getLQyfflList().size();i++)
				{
					qyffl = (Qyffl)qyjbxx.getLQyfflList().get(i);
					qyffl.setQyid(qyid);
					qyfflDao.insertQyffl(qyffl);
				}
			}
		}
		addQybgxxQyzjb(qyjbxx); //记录变化的 证件表信息 yb 2010-02-26
		//证件表修改
		qyzjb.setQyid(qyid);
		qyzjbDao.deleteQyzjb(qyzjb);
		if(qyjbxx.getLQyzjbList() != null)
		{
			for(int i=0;i<qyjbxx.getLQyzjbList().size();i++)
			{
				qyzjb = (Qyzjb)qyjbxx.getLQyzjbList().get(i);
				qyzjb.setQyid(qyid);
				qyzjbDao.insertQyzjb(qyzjb);
			}
		}

		//第二个页签被点击 里面内容被加载
		if("1".equals(qyjbxx.getActivePageTwo()))
		{
			addQybgxxBafwht(qyjbxx); //记录变化的保安服务合同信息 yb 2010-02-25
			addQybgxxPmt(qyjbxx); //记录变化的平面图信息 yb 2010-02-25
			addQybgxxBldsjksb(qyjbxx); //记录变化的闭路电视信息 yb 2010-02-26
			addQybgxxAqjcsb(qyjbxx); //记录变化的安全检查设备信息 yb 2010-02-26
			//addQybgxxBaryxx(qyjbxx); //记录变化的保安人员信息信息
			//保安服务合同修改
			bafwht.setQyid(qyid);
			bafwhtDao.deleteBafwht(bafwht);
			if(qyjbxx.getLBafwhtList()!=null)
			{
				if(qyjbxx.getLBafwhtList().size()>0)
				{
					for(int i=0;i<qyjbxx.getLBafwhtList().size();i++)
					{
						bafwht = (Bafwht)qyjbxx.getLBafwhtList().get(i);
						bafwht.setQyid(qyid);
						//合同结束日期通过 签订日期+合同有效期 计算,若二者有一项为空，则清空结束日期
						if(bafwht.getQdrq()!=null&&bafwht.getHtyxq()!=null)
						{
							Calendar c = Calendar.getInstance();
							c.setTime(bafwht.getQdrq());
							c.add(c.YEAR, bafwht.getHtyxq());
							if(c!=null)
								bafwht.setJsrq(c.getTime());
						}
						else
						{
							bafwht.setIsJsrqNull("1");
						}
						bafwhtDao.insertBafwht(bafwht);
					}
				}
			}
			
			if(webserviceFlag != null && !"".equals(webserviceFlag)){
				//闭路电视监控设备修改
				bldsjksb.setQyid(qyid);
				bldsjksbDao.deleteBldsjksb(bldsjksb);
				if(qyjbxx.getLBldsjksbList()!=null)
				{
					if(qyjbxx.getLBldsjksbList().size()>0)
					{
						for(int i=0;i<qyjbxx.getLBldsjksbList().size();i++)
						{
							bldsjksb = (Bldsjksb)qyjbxx.getLBldsjksbList().get(i);
							bldsjksb.setQyid(qyid);
							bldsjksbDao.insertBldsjksb(bldsjksb);
						}
					}
				}
				
				//安全检查设备修改
				aqjcsb.setQyid(qyid);
				aqjcsbDao.deleteAqjcsb(aqjcsb);
				if(qyjbxx.getLAqjcsbList()!=null)
				{
					if(qyjbxx.getLAqjcsbList().size()>0)
					{
						for(int i=0;i<qyjbxx.getLAqjcsbList().size();i++)
						{
							aqjcsb = (Aqjcsb)qyjbxx.getLAqjcsbList().get(i);
							aqjcsb.setQyid(qyjbxx.getQyid());
							aqjcsbDao.insertAqjcsb(aqjcsb);
						}
					}
				}
				
				//保卫人员修改
				baryxx.setQyid(qyid);
				baryxxDao.deleteBaryxx(baryxx);
				baryxxList = qyjbxx.getLBaryxxList();
				if(baryxxList != null && baryxxList.size() > 0){
					for(int index=0;index<baryxxList.size();index++){
						baryxx = (Baryxx)baryxxList.get(index);
						baryxx.setQyid(qyjbxx.getQyid());
						baryxxDao.insertBaryxx(baryxx);
					}
				}
				
				//保卫人员修改
				bwryxx.setQyid(qyid);
				bwryxxDao.deleteBwryxx(bwryxx);
				bwryxxList = qyjbxx.getLBwryxxList();
				if(bwryxxList != null && bwryxxList.size() > 0){
					for(int index=0;index<bwryxxList.size();index++){
						bwryxx = (Bwryxx)bwryxxList.get(index);
						bwryxx.setQyid(qyjbxx.getQyid());
						bwryxxDao.insertBwryxx(bwryxx);
					}
				}
			}else{
				//闭路电视监控设备修改
				List lBldsjksbList = qyjbxx.getLBldsjksbList();
				if(lBldsjksbList!=null)
				{
					//前台保存闭路电视监控设备列表大小
					int qtbcLength = lBldsjksbList.size();
					if(qtbcLength>0)
					{
						/*先从数据库中删除已从页面中删除的记录， 再修改未删除的记录，最后增加新记录*/
						//取出数据库中该场所已有的闭路电视监控设备，若其中闭路电视监控设备不在qyjbxx.getLBldsjksbList()中，则删除该记录;若存在，则修改该记录
						bldsjksbExist.setQyid(qyid);
						bldsjksbExistList = bldsjksbDao.getListBldsjksb(bldsjksbExist);
						if(bldsjksbExistList != null)
						{
							for(int j = 0;j<bldsjksbExistList.size();j++)
							{
								bldsjksbExist = (Bldsjksb)bldsjksbExistList.get(j);
								isBldsjksbExist = false;
								for(int k = 0;k<qtbcLength;k++)
								{
									bldsjksb = (Bldsjksb)qyjbxx.getLBldsjksbList().get(k);
									if(bldsjksbExist.getBldsjksbid().equals(bldsjksb.getBldsjksbid()))
									{
										isBldsjksbExist = true;
										break;
									}
								}
								if(!isBldsjksbExist){
									//bldsjksbDao.deleteBldsjksb(bldsjksbExist);
									bldsjksbExist.setZt("2");//停用
									bldsjksbDao.updateBldsjksb(bldsjksbExist);
								}else{
									bldsjksbDao.updateBldsjksb(bldsjksb);
								}
							}
						}
						//若qyjbxx.getLBldsjksbList()中闭路电视监控设备id为空，则增加该记录
						for(int i=0;i<qtbcLength;i++)
						{
							bldsjksb = (Bldsjksb)qyjbxx.getLBldsjksbList().get(i);
							if(bldsjksb.getBldsjksbid()==null || bldsjksb.getBldsjksbid()==0)
							{
								bldsjksb.setQyid(qyid);
								//获得闭路电视监控设备序号,企业编码+ 一位大写英文字母“B”+四位顺序码 （0001～9999）
								scbmMap = new HashMap();
								scbmMap.put("p_bmfl", "BLDSJK");
								scbmMap.put("p_xzqh", qyjbxx_bak.getQybm()+"B");
								scbmMap.put("p_sssf", sssf);
								scbmMap.put("p_scgz", 3);
								bldsjksb.setSbxh(scbmDao.getScbm(scbmMap));
								bldsjksb.setZt("1");//使用
								bldsjksbDao.insertBldsjksb(bldsjksb);
							}
						}
					}
					else
					{
						bldsjksb.setQyid(qyid);
						//bldsjksbDao.deleteBldsjksb(bldsjksb);
						bldsjksb.setZt("2");//停用
						bldsjksbDao.updateBldsjksb(bldsjksb);
					}
				}
				else
				{
					bldsjksb.setQyid(qyid);
					//bldsjksbDao.deleteBldsjksb(bldsjksb);
					bldsjksb.setZt("2");//停用
					bldsjksbDao.updateBldsjksb(bldsjksb);
				}
				
				//安全检查设备修改
				if(qyjbxx.getLAqjcsbList()!=null)
				{
					if(qyjbxx.getLAqjcsbList().size()>0)
					{
						/*先从数据库中删除已从页面中删除的记录， 再修改未删除的记录，最后增加新记录*/
						//取出数据库中该场所已有的安全检查设备，若其中安全检查设备不在qyjbxx.getLAqjcsbList()中，则删除该记录;若存在，则修改该记录
						aqjcsbExist.setQyid(qyid);
						aqjcsbExistList = aqjcsbDao.getListAqjcsb(aqjcsbExist);
						if(aqjcsbExistList != null)
						{
							for(int j = 0;j<aqjcsbExistList.size();j++)
							{
								aqjcsbExist = (Aqjcsb)aqjcsbExistList.get(j);
								isAqjcsbExist = false;
								for(int k = 0;k<qyjbxx.getLAqjcsbList().size();k++)
								{
									aqjcsb = (Aqjcsb)qyjbxx.getLAqjcsbList().get(k);
									if(aqjcsbExist.getAnjcsbid().equals(aqjcsb.getAnjcsbid()))
									{
										isAqjcsbExist = true;
										break;
									}
								}
								if(!isAqjcsbExist){
									//aqjcsbDao.deleteAqjcsb(aqjcsbExist);
									aqjcsbExist.setZt("2");//停用
									aqjcsbDao.updateAqjcsb(aqjcsbExist);
								}else{
									aqjcsbDao.updateAqjcsb(aqjcsb);
								}
							}
						}
						//若qyjbxx.getLAqjcsbList()中安全检查设备id为空，则增加该记录
						for(int i=0;i<qyjbxx.getLAqjcsbList().size();i++)
						{
							aqjcsb = (Aqjcsb)qyjbxx.getLAqjcsbList().get(i);
							if(aqjcsb.getAnjcsbid()==null || aqjcsb.getAnjcsbid()==1)
							{
								aqjcsb.setQyid(qyid);
								//获得安全检查设备序号,企业编码+ 一位大写英文字母“A”+四位顺序码 （0001～9999）
								scbmMap = new HashMap();
								scbmMap.put("p_bmfl", "AQJCSB");
								scbmMap.put("p_xzqh", qyjbxx_bak.getQybm()+"A");
								scbmMap.put("p_sssf", sssf);
								scbmMap.put("p_scgz", 3);
								aqjcsb.setSbxh(scbmDao.getScbm(scbmMap));
								aqjcsb.setLrr(qyjbxx.getCzr());
								aqjcsb.setLrsj(qyjbxx.getBcsj());
								aqjcsb.setZt("1");//使用
								aqjcsbDao.insertAqjcsb(aqjcsb);
							}
						}
					}
					else
					{
						aqjcsb.setQyid(qyid);
						//aqjcsbDao.deleteAqjcsb(aqjcsb);
						aqjcsb.setZt("2");//停用
						aqjcsbDao.updateAqjcsb(aqjcsb);
						
					}
				}
				else
				{
					aqjcsb.setQyid(qyid);
					//aqjcsbDao.deleteAqjcsb(aqjcsb);
					aqjcsb.setZt("2");//停用
					aqjcsbDao.updateAqjcsb(aqjcsb);
				}
				
				// 保安人员修改
				baryxxList = qyjbxx.getLBaryxxList();
				if(baryxxList != null && baryxxList.size()>0){
					/*先从数据库中删除已从页面中删除的记录， 再修改未删除的记录，最后增加新记录*/
					//取出数据库中该场所已有的保安人员信息，若其中保安人员不在baryxxList中，则删除该记录;若存在，则修改该记录
					baryxxExist.setQyid(qyid);
					baryxxExistList = baryxxDao.getListBaryxx(baryxxExist);
					if(baryxxExistList != null && baryxxExistList.size() > 0){
						for(int j = 0;j<baryxxExistList.size();j++){
							baryxxExist = (Baryxx)baryxxExistList.get(j);
							isBaryxxExist = false;
							for(int k = 0;k<baryxxList.size();k++){
								baryxx = (Baryxx)baryxxList.get(k);
								if(baryxxExist.getBaryid().equals(baryxx.getBaryid())){
									isBaryxxExist = true;
									break;
								}
							}
							if(!isBaryxxExist){
								//baryxxDao.deleteBaryxx(baryxxExist);
								baryxxExist.setZt("2");//停职
								baryxxDao.updateBaryxx(baryxxExist);
							}else{
								baryxxDao.updateBaryxx(baryxx);
							}
						}
					}
					//若baryxxList中保安人员id为空，则增加该记录
					for(int i=0;i<baryxxList.size();i++){
						baryxx = (Baryxx)baryxxList.get(i);
						if(baryxx.getBaryid()==null || baryxx.getBaryid()==1){
							baryxx.setQyid(qyid);
							baryxx.setLrr(qyjbxx.getCzr());
							baryxx.setLrsj(qyjbxx.getBcsj());
							baryxx.setZt("1");//新增保安人员为在职状态
							baryxxDao.insertBaryxx(baryxx);
						}
					}
				}else {
					baryxx.setQyid(qyid);
					//baryxxDao.deleteBaryxx(baryxx);
					baryxx.setZt("2");//停职
					baryxxDao.updateBaryxx(baryxx);
				}
				
				// 保卫人员修改
				bwryxxList = qyjbxx.getLBwryxxList();
				if(bwryxxList != null && bwryxxList.size()>0){
					/*先从数据库中删除已从页面中删除的记录， 再修改未删除的记录，最后增加新记录*/
					//取出数据库中该场所已有的保卫人员信息，若其中保卫人员不在bwryxxList中，则删除该记录;若存在，则修改该记录
					bwryxxExist.setQyid(qyid);
					bwryxxExistList = bwryxxDao.getListBwryxx(bwryxxExist);
					if(bwryxxExistList != null && bwryxxExistList.size() > 0){
						for(int j = 0;j<bwryxxExistList.size();j++){
							bwryxxExist = (Bwryxx)bwryxxExistList.get(j);
							isBwryxxExist = false;
							for(int k = 0;k<bwryxxList.size();k++){
								bwryxx = (Bwryxx)bwryxxList.get(k);
								if(bwryxxExist.getBwryid().equals(bwryxx.getBwryid())){
									isBwryxxExist = true;
									break;
								}
							}
							if(!isBwryxxExist){
								//bwryxxDao.deleteBwryxx(bwryxxExist);
								bwryxxExist.setZt("2");//停职
								bwryxxDao.updateBwryxx(bwryxxExist);
							}else{
								bwryxxDao.updateBwryxx(bwryxx);
							}
						}
					}
					//若bwryxxList中保安人员id为空，则增加该记录
					for(int i=0;i<bwryxxList.size();i++){
						bwryxx = (Bwryxx)bwryxxList.get(i);
						if(bwryxx.getBwryid()==null || bwryxx.getBwryid()==0){
							bwryxx.setQyid(qyid);
							bwryxx.setZt("1");
							bwryxxDao.insertBwryxx(bwryxx);
						}
					}
				}else {
					bwryxx.setQyid(qyid);
					//bwryxxDao.deleteBwryxx(bwryxx);
					bwryxx.setZt("2");//停职
					bwryxxDao.updateBwryxx(bwryxx);
				}
			}
			
			//平面图修改
			if(qyjbxx.getLPmtList()!=null)
			{
				if(qyjbxx.getLPmtList().size()>0)
				{
					/*先从数据库中删除已从页面中删除的记录，再增加新记录*/
					//取出数据库中该场所已有的平面图，若其中平面图不在qyjbxx.getLPmtList()中，则删除该记录
					pmtExist.setQyid(qyid);
					pmtExistList = pmtDao.getListPmt(pmtExist);
					if(pmtExistList != null)
					{
						for(int j = 0;j<pmtExistList.size();j++)
						{
							pmtExist = (Pmt)pmtExistList.get(j);
							isPmtExist = false;
							for(int k = 0;k<qyjbxx.getLPmtList().size();k++)
							{
								pmt = (Pmt)qyjbxx.getLPmtList().get(k);
								if(pmtExist.getPmtid().equals(pmt.getSPmtid()))
								{
									isPmtExist = true;
									break;
								}
							}
							if(!isPmtExist)
								pmtDao.deletePmt(pmtExist);
						}
					}
					//若qyjbxx.getLPmtList()中平面图的sPmtid为NEW,则增加该平面图
					for(int i=0;i<qyjbxx.getLPmtList().size();i++)
					{
						pmt = (Pmt)qyjbxx.getLPmtList().get(i);
						pmt.setQyid(qyid);
						/*if(pmt.getPmtjlzt().equals("OLD_DELETED"))
						{
							pmtDao.deletePmt(pmt);
						}
						else if(pmt.getPmtjlzt().equals("NEW"))
						{
							pmtDao.insertPmt(pmt);
						}*/
						if(pmt.getSPmtid()!=null)
						{
							if(pmt.getSPmtid().length()>=3)
							{
								if(pmt.getSPmtid().substring(0, 3).equals("NEW"))
								{
									pmtDao.insertPmt(pmt);
								}
							}
						}
					}
				}
				else
				{
					pmt.setQyid(qyid);
					pmtDao.deletePmt(pmt);
				}
			}
			else
			{
				pmt.setQyid(qyid);
				pmtDao.deletePmt(pmt);
			}
		}
		//第三个页签被点击 里面内容被加载

		if("1".equals(qyjbxx.getActivePageThree()))
		{
			addQybgxxWgtzrxx(qyjbxx); //记录变化的 外国投资人信息 yb 2010-02-26
			//外国投资人信息修改
			wgtzrxx.setQyid(qyid);
			wgtzrxxDao.deleteWgtzrxx(wgtzrxx);
			//经济类型为港澳台投资或外国投资时才增加外国投资人信息
			if(qyjbxx.getJjlxbm()!=null)
			{
				if(qyjbxx.getJjlxbm().length()>0)
				{
					String jjlx = "";
					jjlx = qyjbxx.getJjlxbm();
					if(jjlx.substring(0, 1).equals("2")||jjlx.substring(0, 1).equals("3"))
					{
						if(qyjbxx.getLWgtzrxxList()!=null)
						{
							if(qyjbxx.getLWgtzrxxList().size()>0)
							{
								for(int i=0;i<qyjbxx.getLWgtzrxxList().size();i++)
								{
									wgtzrxx = (Wgtzrxx)qyjbxx.getLWgtzrxxList().get(i);
									wgtzrxx.setQyid(qyid);
									wgtzrxxDao.insertWgtzrxx(wgtzrxx);
								}
							}
						}
					}
				}
			}
		}
		else if("0".equals(qyjbxx.getActivePageThree()))//第三个页签未被点击 里面内容未被加载
		{
			//外国投资人信息修改
			//经济类型不是港澳台投资和外国投资时，删除原有信息
			String hylbdm = qyjbxx.getHylbdm();
			if("B".equals(hylbdm) || "K".equals(hylbdm)){
				String oldJjlxbm = qyjbxx_bak.getJjlxbm();
				String newJjlxbm = qyjbxx.getJjlxbm();
				if(!"".equals(oldJjlxbm) && !"".equals(newJjlxbm))
				{
					oldJjlxbm = oldJjlxbm.substring(0,1);
					newJjlxbm = newJjlxbm.substring(0,1);
					if((oldJjlxbm.equals("2") || oldJjlxbm.equals("3")) && (!newJjlxbm.equals("2") || !newJjlxbm.equals("3")))
					{
						addQybgxxWgtzrxx(qyjbxx); //记录变化的 外国投资人信息 yb 2010-02-26
						wgtzrxx.setQyid(qyid);
						wgtzrxxDao.deleteWgtzrxx(wgtzrxx);
					}
				}
			}
		}
		//场所信息操作日志
		qyxxczrz.setQybm(qyjbxx_ls.getQybm());
		if(qyjbxx.getCzlx()==null||"".equals(qyjbxx.getCzlx()))
			qyxxczrz.setCzlx("修改");
		else
			qyxxczrz.setCzlx(qyjbxx.getCzlx());
		/*csxxczrz.setCznr(cznr);*/
		qyxxczrz.setCzr(qyjbxx.getCzr());
		qyxxczrz.setCzsj(currentDate);
		qyxxczrzDao.insertQyxxczrz(qyxxczrz);
		
		insertQybgxx(qyjbxx, qyjbxx_ls.getQylsid()); //添加企业变更信息 2010-02-25 yb:需要历史ID放在这里添加
		
		isSuccess = true;
		return isSuccess;
	}
	
	/** @param 企业基本信息(t_qyjbxx) 修改  只修改场所主表*/
	public boolean updateQyjbxxOnly(Qyjbxx qyjbxx) throws Exception
	{
		boolean isSuccess = false;
		Qyxxczrz qyxxczrz = new Qyxxczrz();
		Department department = new Department();

		Date currentDate = new Date();
		
		//保存企业历史信息
		int qyid = qyjbxx.getQyid();
		Qyjbxx_ls qyjbxx_ls = new Qyjbxx_ls();
		Qyjbxx qyjbxx_bak = new Qyjbxx();
		qyjbxx_bak.setQyid(qyid);
		qyjbxx_bak = qyjbxxDao.getQyjbxx(qyjbxx_bak);
		if(qyjbxx_bak!=null)
			BeanUtils.copyProperties(qyjbxx_ls, qyjbxx_bak);
		if(qyjbxx.getCzlx()==null||"".equals(qyjbxx.getCzlx()))
			qyjbxx_ls.setCzlx("修改");
		else
			qyjbxx_ls.setCzlx(qyjbxx.getCzlx());
		if(qyjbxx.getBgyy() != null)
			qyjbxx_ls.setBgyy(qyjbxx.getBgyy());
		qyjbxx_ls = qyjbxx_lsDao.insertQyjbxx_ls(qyjbxx_ls);
		//场所主表修改
		qyjbxx.setBcsj(currentDate);
		if(qyjbxx.getQymc()!=null)
		{
			qyjbxx.setQyjp(PinYinUtil.getHanyuPingYinInitial(qyjbxx.getQymc()));
			qyjbxx.setQyqp(PinYinUtil.getHanyuPingYin(qyjbxx.getQymc()));
		}
		if(qyjbxx.getQyjc()!=null&&!"".equals(qyjbxx.getQyjc()))
		{
			qyjbxx.setQyjcjp(PinYinUtil.getHanyuPingYinInitial(qyjbxx.getQyjc()));
			qyjbxx.setQyjcqp(PinYinUtil.getHanyuPingYin(qyjbxx.getQyjc()));
		}
		if(qyjbxx.getGxdwbm()!=null)
		{
			if(!qyjbxx_ls.getGxdwbm().equals(qyjbxx.getGxdwbm()))
			{
				//获得地市机关代码和名称
				//四个直辖市的地市机关截取前2位
				if(!qyjbxx.getGxdwbm().substring(0, 2).equals("11")
						&&!qyjbxx.getGxdwbm().substring(0, 2).equals("12")
						&&!qyjbxx.getGxdwbm().substring(0, 2).equals("31")
						&&!qyjbxx.getGxdwbm().substring(0, 2).equals("50"))
					qyjbxx.setSsddsjgdm(StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 4),12));
				else
					qyjbxx.setSsddsjgdm(StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 2),12));
				department.setDepartcode(qyjbxx.getSsddsjgdm());
				department = departmentService.getDepartment(department);
				if(department != null)
					qyjbxx.setSsddsjgmc(department.getDepartname());
				
				//获得分县局机关代码和名称
				department = null;
				department = new Department();
				qyjbxx.setSsdxjgajgdm(StringUtil.add0(qyjbxx.getGxdwbm().substring(0, 6),12));
				department.setDepartcode(qyjbxx.getSsdxjgajgdm());
				department = departmentService.getDepartment(department);
				if(department != null)
					qyjbxx.setSsdxjgajgmc(department.getDepartname());
			}
			
		}
		
		qyjbxxDao.updateQyjbxx(qyjbxx);
		//场所信息操作日志
		qyxxczrz.setQybm(qyjbxx_ls.getQybm());
		if(qyjbxx.getCzlx()==null||"".equals(qyjbxx.getCzlx()))
			qyxxczrz.setCzlx("修改");
		else
			qyxxczrz.setCzlx(qyjbxx.getCzlx());
		/*csxxczrz.setCznr(cznr);*/
		qyxxczrz.setCzr(qyjbxx.getCzr());
		qyxxczrz.setCzsj(currentDate);
		qyxxczrzDao.insertQyxxczrz(qyxxczrz);
		
		isSuccess = true;
		return isSuccess;
	}
	
	/** @param 企业基本信息(t_qyjbxx) 企业核查
	 * @throws Exception */
	public boolean updateQyjbxxHc(Qyjbxx qyjbxx) throws Exception
	{
		boolean isSuccess = false;
		int errCode = -1;//账号同步返回标识
		String oldZt = "";
		Qyzhtb qyzhtb = new Qyzhtb();
		Qyjbxx qyjbxxOld = new Qyjbxx();
		Date currentDate = new Date();
		
		if(qyjbxx != null)
		{
			qyjbxxOld.setQyid(qyjbxx.getQyid());
			qyjbxxOld = qyjbxxDao.getQyjbxx(qyjbxxOld);
			qyzhtb.setQybm(qyjbxxOld.getQybm());
			//记录场所更改前的状态

			oldZt = qyjbxxOld.getZt();
			//修改场所信息
			qyjbxx.setZt("1");
			qyjbxx.setHcsj(currentDate);
			qyjbxx.setZtgbrq(currentDate);
			qyjbxx.setCzlx("信息确认");
			//qyjbxx.setCzlx("核查");
			qyjbxx.setCzr(qyjbxx.getHcr());
			qyjbxx.setBcsj(currentDate);
			updateQyjbxx(qyjbxx);
			//原状态为0，则同步增加企业用户
			//zhtbDao.insertZhtb(zhtb);
			if("0".equals(oldZt)||"3".equals(oldZt))
			{
				errCode = qyzhtbDao.insertQyzhtb(qyzhtb);
			}
			else if("2".equals(oldZt))//原状态为2，则同步修改企业用户
			{
				errCode = qyzhtbDao.updateQyzhtb(qyzhtb);
			}
			if(errCode==0)
				isSuccess = true;
		}
		
		return isSuccess;
	}
	
	/** @param 企业基本信息(t_qyjbxx) 派出所审核 qyjbxx中存放qyid、sftg及qysh*/
	public boolean updateQyjbxxsh_pcs(Qyjbxx qyjbxx) throws Exception
	{
		boolean isSuccess = false;
		Date currentDate = new Date();
		String sftg = qyjbxx.getSftg();//审核是否通过标识 0-不通过 1-通过
		Qysh qysh = new Qysh();
		//企业状态 10-派出所审核通过 11-派出所审核失败
		if(sftg.equals("1"))
		{
			qyjbxx.setZt("10");
		}
		else if(sftg.equals("0"))
		{
			qyjbxx.setZt("11");
		}
		qyjbxx.setZtgbrq(currentDate);
		qyjbxx.setBcsj(currentDate);
		qyjbxx.setCzlx("派出所审核");

		if(qyjbxx.getQysh()!=null)
		{
			qysh = qyjbxx.getQysh();
			qysh.setQyid(qyjbxx.getQyid());
			qysh.setShsj(currentDate);
			//上级审核id取值：取上次审核(无论是派出所审核还是市局审核)记录的csshid
			Qysh qyshOld = new Qysh();
			qyshOld = qyshService.getSjshid(qysh);
			qysh.setSjshid(qyshOld.getSjshid());
			qysh.setShzt("0");//审核状态 0-派出所审核 1-市局审核
				
			qyjbxx.setCzr(qysh.getShr());
		}
		updateQyjbxxOnly(qyjbxx);
		qyshService.insertQysh(qysh);

		isSuccess = true;
		return isSuccess;
	}
	
	/** @param 企业基本信息(t_qyjbxx) 市局审核  qyjbxx中存放qyid、sftg及qysh*/
	public boolean updateQyjbxxsh_sj(Qyjbxx qyjbxx) throws Exception
	{
		boolean isSuccess = false;
		boolean isCsuserExist = false;
		int errCode = -1;//账号同步返回标识
		String oldZt = "";
		Qyzhtb qyzhtb = new Qyzhtb();
		Qyjbxx qyjbxxOld = new Qyjbxx();
		qyjbxxOld.setQyid(qyjbxx.getQyid());
		qyjbxxOld = qyjbxxDao.getQyjbxx(qyjbxxOld);
		
		Date currentDate = new Date();
		String sftg = qyjbxx.getSftg();//审核是否通过标识 0-不通过 1-通过
		Qysh qysh = new Qysh();
		//场所状态 1-已核查 13-市局审核失败
		if(sftg.equals("1"))
		{
			qyjbxx.setZt("1");
		}
		else if(sftg.equals("0"))
		{
			qyjbxx.setZt("13");
		}
		qyjbxx.setZtgbrq(currentDate);
		qyjbxx.setBcsj(currentDate);
		qyjbxx.setCzlx("市局审核");

		if(qyjbxx.getQysh()!=null)
		{
			qysh = qyjbxx.getQysh();
			qysh.setQyid(qyjbxx.getQyid());
			qysh.setShsj(currentDate);
			//上级审核id取值：取上次审核(无论是派出所审核还是市局审核)记录的csshid
			Qysh qyshOld = new Qysh();
			qyshOld = qyshService.getSjshid(qysh);
			qysh.setSjshid(qyshOld.getSjshid());
			qysh.setShzt("1");//审核状态 0-派出所审核 1-市局审核
			
			qyjbxx.setCzr(qysh.getShr());
		}
		updateQyjbxxOnly(qyjbxx);
		qyshService.insertQysh(qysh);
		
		//若用户表中无此场所用户，则同步增加场所用户 ，否则同步修改场所用户
		User user = new User();
		user.setUseraccount(qyjbxxOld.getQybm());
		user = userService.getUser(user);
		if(user!=null)
			isCsuserExist = true;
		qyzhtb.setQybm(qyjbxxOld.getQybm());
		if(!isCsuserExist)
		{
			errCode = qyzhtbDao.insertQyzhtb(qyzhtb);
		}
		else if(isCsuserExist)
		{
			errCode = qyzhtbDao.updateQyzhtb(qyzhtb);
		}
		if(errCode==0)
			isSuccess = true;
		return isSuccess;
	}
	
	/** @param 企业基本信息(t_qyjbxx) 企业变更*/
	//原有变更方法 20100127注释 勿删！
	/*public boolean updateQyjbxxBg(Qyjbxx qyjbxx) throws Exception
	{
		boolean isSuccess = false;
		Qyjbxx qyjbxxOld = new Qyjbxx();
		Date currentDate = new Date();
		if(qyjbxx != null)
		{
			qyjbxxOld.setQyid(qyjbxx.getQyid());
			qyjbxxOld = qyjbxxDao.getQyjbxx(qyjbxxOld);
			//修改企业信息
			// 当企业名称、经营地址、法人代表姓名、证件类型、证件号码、经营范围（主、兼）、企业类别（主、副）等
			// 重要相关事项发生变更时，需重新进行核查
			if(qyjbxxOld.getQymc()==null)
				qyjbxxOld.setQymc("");
			if(qyjbxxOld.getJydz()==null)
				qyjbxxOld.setJydz("");
			if(qyjbxxOld.getFrdb()==null)
				qyjbxxOld.setFrdb("");
			if(qyjbxxOld.getFrdbzjlb()==null)
				qyjbxxOld.setFrdbzjlb("");
			if(qyjbxxOld.getFrdbzjhm()==null)
				qyjbxxOld.setFrdbzjhm("");
			if(qyjbxxOld.getJyfwzy()==null)
				qyjbxxOld.setJyfwzy("");
			if(qyjbxxOld.getJyfwjy()==null)
				qyjbxxOld.setJyfwjy("");
			if(qyjbxxOld.getQyzflbm()==null)
				qyjbxxOld.setQyzflbm("");
			//企业副分类是否发生变更
			boolean isQyfflChanged = false;
			if(qyjbxxOld.getQyfflbm() == null)
				qyjbxxOld.setQyfflbm("");
			if(qyjbxx.getQyfflbm() == null)
				qyjbxx.setQyfflbm("");
			String[] csfflbmOldArr = new String[qyjbxxOld.getQyfflbm().split("|").length];
			String csfflbm = getQyfflStr(qyjbxx.getLQyfflList(),"0");
			if(csfflbm==null)
				csfflbm = "";
			String[] csfflbmArr = new String[csfflbm.split("|").length];
			csfflbmOldArr = qyjbxxOld.getQyfflbm().split("|");
			csfflbmArr = csfflbm.split("|");
			if(csfflbmOldArr.length!=csfflbmArr.length)
				isQyfflChanged = true;
			else
			{
				for(int i = 0;i<csfflbmOldArr.length;i++)
				{
					if(qyjbxx.getQyfflbm().indexOf(csfflbmOldArr[i])==-1)
					{
						isQyfflChanged = true;
						break;
					}
				}
				for(int i = 0;i<csfflbmArr.length;i++)
				{
					if(qyjbxxOld.getQyfflbm().indexOf(csfflbmArr[i])==-1)
					{
						isQyfflChanged = true;
						break;
					}
				}
			}
				
			if(!qyjbxxOld.getQymc().equals(qyjbxx.getQymc())||
				!qyjbxxOld.getJydz().equals(qyjbxx.getJydz())||
				!qyjbxxOld.getFrdb().equals(qyjbxx.getFrdb())||
				!qyjbxxOld.getFrdbzjlb().equals(qyjbxx.getFrdbzjlb())||
				!qyjbxxOld.getFrdbzjhm().equals(qyjbxx.getFrdbzjhm())||
				!qyjbxxOld.getJyfwzy().equals(qyjbxx.getJyfwzy())||
				!qyjbxxOld.getJyfwjy().equals(qyjbxx.getJyfwjy())||
				!qyjbxxOld.getQyzflbm().equals(qyjbxx.getQyzflbm())||
				isQyfflChanged)
			{
				qyjbxx.setZt("2");
				qyjbxx.setZtgbrq(currentDate);
			}
			
			//获得变更登记序号
			Map scbmMap = new HashMap();
			scbmMap.put("p_bmfl", "BGDJXH");
			scbmMap.put("p_xzqh", qyjbxxOld.getQybm());//企业编码不会变化，所以采用历史记录的编码即可
			String sssf = "hn";//所属省份，默认为hn，需从全局参数中取值
			String tempSssf = QjblUtil.queryQjblVal("sssf");
			if(tempSssf!=null&&!"".equals(tempSssf))
				sssf = tempSssf;
			scbmMap.put("p_sssf", sssf);
			scbmMap.put("p_scgz", 2);
			qyjbxx.setBgdjxh(scbmDao.getScbm(scbmMap));
			
			qyjbxx.setCzlx("变更");
			qyjbxx.setBcsj(currentDate);
			updateQyjbxx(qyjbxx);
			isSuccess = true;
		}
		
		return isSuccess;
	}*/
	public boolean updateQyjbxxBg(Qyjbxx qyjbxx) throws Exception
	{
		boolean isSuccess = false;
		Qyjbxx qyjbxxOld = new Qyjbxx();
		Date currentDate = new Date();
		if(qyjbxx != null)
		{
			qyjbxxOld.setQyid(qyjbxx.getQyid());
			qyjbxxOld = qyjbxxDao.getQyjbxx(qyjbxxOld);
			//修改企业信息
			// 当企业名称、经营地址、法人代表姓名、证件类型、证件号码、经营范围（主、兼）、企业类别（主、副）等
			// 重要相关事项发生变更时，需重新进行核查
			if(qyjbxxOld.getQymc()==null)
				qyjbxxOld.setQymc("");
			if(qyjbxxOld.getJydz()==null)
				qyjbxxOld.setJydz("");
			if(qyjbxxOld.getFrdb()==null)
				qyjbxxOld.setFrdb("");
			if(qyjbxxOld.getFrdbzjlb()==null)
				qyjbxxOld.setFrdbzjlb("");
			if(qyjbxxOld.getFrdbzjhm()==null)
				qyjbxxOld.setFrdbzjhm("");
			if(qyjbxxOld.getJyfwzy()==null)
				qyjbxxOld.setJyfwzy("");
			if(qyjbxxOld.getJyfwjy()==null)
				qyjbxxOld.setJyfwjy("");
			if(qyjbxxOld.getQyzflbm()==null)
				qyjbxxOld.setQyzflbm("");
			
			if(qyjbxx.getQymc()==null)
				qyjbxx.setQymc("");
			if(qyjbxx.getJydz()==null)
				qyjbxx.setJydz("");
			if(qyjbxx.getFrdb()==null)
				qyjbxx.setFrdb("");
			if(qyjbxx.getFrdbzjlb()==null)
				qyjbxx.setFrdbzjlb("");
			if(qyjbxx.getFrdbzjhm()==null)
				qyjbxx.setFrdbzjhm("");
			if(qyjbxx.getJyfwzy()==null)
				qyjbxx.setJyfwzy("");
			if(qyjbxx.getJyfwjy()==null)
				qyjbxx.setJyfwjy("");
			if(qyjbxx.getQyzflbm()==null)
				qyjbxx.setQyzflbm("");
			
			//企业副分类是否发生变更
			boolean isQyfflChanged = false;
			if(qyjbxxOld.getQyfflbm() == null)
				qyjbxxOld.setQyfflbm("");
			if(qyjbxx.getQyfflbm() == null)
				qyjbxx.setQyfflbm("");
			String[] csfflbmOldArr = new String[qyjbxxOld.getQyfflbm().split("|").length];
			String csfflbm = getQyfflStr(qyjbxx.getLQyfflList(),"0");
			if(csfflbm==null)
				csfflbm = "";
			String[] csfflbmArr = new String[csfflbm.split("|").length];
			csfflbmOldArr = qyjbxxOld.getQyfflbm().split("|");
			csfflbmArr = csfflbm.split("|");
			if(csfflbmOldArr.length!=csfflbmArr.length)
				isQyfflChanged = true;
			else
			{
				for(int i = 0;i<csfflbmOldArr.length;i++)
				{
					if(qyjbxx.getQyfflbm().indexOf(csfflbmOldArr[i])==-1)
					{
						isQyfflChanged = true;
						break;
					}
				}
				for(int i = 0;i<csfflbmArr.length;i++)
				{
					if(qyjbxxOld.getQyfflbm().indexOf(csfflbmArr[i])==-1)
					{
						isQyfflChanged = true;
						break;
					}
				}
			}
			
			//企业核查开关,根据重庆需求修改 20101213 mds
     		String qyhckg = QjblUtil.queryQjblVal("qyhckg");//企业核查开关 0-关（企业增加时直接生成账号，无需核查）1-开
     		if(!"0".equals(qyhckg))
     		{
     			if(!qyjbxxOld.getQymc().equals(qyjbxx.getQymc())||
     					!qyjbxxOld.getJydz().equals(qyjbxx.getJydz())||
     					!qyjbxxOld.getFrdb().equals(qyjbxx.getFrdb())||
     					!qyjbxxOld.getFrdbzjlb().equals(qyjbxx.getFrdbzjlb())||
     					!qyjbxxOld.getFrdbzjhm().equals(qyjbxx.getFrdbzjhm())||
     					!qyjbxxOld.getJyfwzy().equals(qyjbxx.getJyfwzy())||
     					!qyjbxxOld.getJyfwjy().equals(qyjbxx.getJyfwjy())||
     					!qyjbxxOld.getQyzflbm().equals(qyjbxx.getQyzflbm())||
     					isQyfflChanged)
     				{
     					qyjbxx.setZt("2");
     					qyjbxx.setZtgbrq(currentDate);
     				}
     		}
			
			
			//获得变更登记序号
			Map scbmMap = new HashMap();
			scbmMap.put("p_bmfl", "BGDJXH");
			scbmMap.put("p_xzqh", qyjbxxOld.getQybm());//企业编码不会变化，所以采用历史记录的编码即可
			String sssf = "hn";//所属省份，默认为hn，需从全局参数中取值
			String tempSssf = QjblUtil.queryQjblVal("sssf");
			if(tempSssf!=null&&!"".equals(tempSssf))
				sssf = tempSssf;
			scbmMap.put("p_sssf", sssf);
			scbmMap.put("p_scgz", 2);
			qyjbxx.setBgdjxh(scbmDao.getScbm(scbmMap));
			
			qyjbxx.setCzlx("变更");
			qyjbxx.setBcsj(currentDate);
			updateQyjbxx(qyjbxx);
			isSuccess = true;
		}
		
		return isSuccess;
	}
	
	/** @param 企业基本信息(t_qyjbxx) 企业注销*/
	public boolean updateQyjbxxZx(Qyjbxx qyjbxx) throws Exception
	{
		boolean isSuccess = false;
		Qyzhtb qyzhtb = new Qyzhtb();
		Date currentDate = new Date();
		String oldZt = "";
		int zhtbflag = -1;
		if(qyjbxx!=null)
		{
			Qyjbxx qyjbxxOld = new Qyjbxx();
			qyjbxxOld.setQyid(qyjbxx.getQyid());
			qyjbxxOld = qyjbxxDao.getQyjbxx(qyjbxxOld);
			oldZt = qyjbxxOld.getZt();
			//场所注销时，需将营业状态变更为“注销”,娱乐和公共场所还要将装机状态置为“装机停业”
			//娱乐业和公共场所行业
			if("J".equals(qyjbxxOld.getHylbdm())||"K".equals(qyjbxxOld.getHylbdm()))
			{
				qyjbxx.setYyztdm("5");
				qyjbxx.setYyztmc("注销");
				qyjbxx.setZjztdm("2");
				qyjbxx.setZjztmc("装机停业");
			}
			else//其他行业
			{
				qyjbxx.setYyztdm("10");
				qyjbxx.setYyztmc("注销");
			}
			
			qyjbxx.setZxbz("1");
			qyjbxx.setZtgbrq(currentDate);
			qyjbxx.setBcsj(currentDate);
			qyjbxx.setCzlx("注销");
			updateQyjbxxOnly(qyjbxx);
					
			qyzhtb.setQybm(qyjbxxOld.getQybm());
			if(qyjbxx.getZt()==null||qyjbxx.getZt().equals("")||Integer.parseInt(qyjbxx.getZt())<90){
				zhtbflag = qyzhtbDao.deleteQyzhtb(qyzhtb);
			}
			
			if(zhtbflag==0)
				isSuccess = true;
			
			//该企业下所有从业人员离职
			boolean zxryFlag = false;
			qyjbxxOld.setCzr(qyjbxx.getCzr());
			zxryFlag = qyryxxService.makeCyryxxLizhiByqyZx(qyjbxxOld);
			
			isSuccess = isSuccess & zxryFlag;
		}
			
		return isSuccess;
	}
	
	
	/** @param 获得企业副分类串，以"|" 分隔。
	 * @param  qyfflList 企业副分类list
	 * @param  flag 标识：0-返回副分类编码串，1-返回副分类名称串*/
	public String getQyfflStr(List qyfflList,String flag)
	{
		StringBuffer returnStr = new StringBuffer();
		
		if(qyfflList!=null&&qyfflList.size()>0)
		{
			Qyffl qyffl = new Qyffl();
			for(int i = 0;i<qyfflList.size();i++)
			{
				qyffl = (Qyffl)qyfflList.get(i);
				if("0".equals(flag))
				{
					returnStr.append(qyffl.getQyflbm());
				}
				else if("1".equals(flag))
				{
					returnStr.append(qyffl.getQyflmc());
				}
				returnStr.append("|");
			}
			if(returnStr.length()>1)
			{
				returnStr.delete(returnStr.length()-1,returnStr.length());
			}
		}
		else
			returnStr.append("");
		return returnStr.toString();
	}

	/**
	 * 添加企业变更信息
	 * @param qyjbxx
	 */
	public void insertQybgxx(Qyjbxx qyjbxx,Integer qylsid){
		if("变更".equals(qyjbxx.getCzlx())&&"J".equals(qyjbxx.getHylbdm())){
			String sssf = "hn";//所属省份，默认为hn，需从全局参数中取值
			List qybgxxList = qyjbxx.getQybgxxList();
			Qybgxx qybgxx = null;
			if(qybgxxList!=null&&qybgxxList.size()>0){
				String tempSssf = QjblUtil.queryQjblVal("sssf");
				if(tempSssf!=null&&!"".equals(tempSssf)){ sssf = tempSssf; }
				Map scbmMap = addScbmMap("BGDJXH", qyjbxx.getQybm(), sssf, 2);
				for (int index=0,max=qybgxxList.size();index<max;index++) {
					qybgxx = (Qybgxx)qybgxxList.get(index);
					qybgxx.setBgdjxh(scbmDao.getScbm(scbmMap));
					qybgxx.setQyid(qyjbxx.getQyid());
					qybgxx.setQylsid(qylsid);
					qybgxx.setBgrq(new Date()); //----------
					qybgxx.setBgyy(qyjbxx.getBgyy());
					qybgxxDao.insertQybgxx(qybgxx);
				}
			}
		}
	}
	public Map addScbmMap(String bmfl,String xzqh,String sssf,int scgz){
		Map scbmMap = new HashMap();
		scbmMap.put("p_bmfl",bmfl);
		scbmMap.put("p_xzqh",xzqh);
		scbmMap.put("p_sssf",sssf);
		scbmMap.put("p_scgz",scgz);
		return scbmMap;
	}
	/** @param 企业基本信息(t_qyjbxx) 查询单条 */
	public Qyjbxx getQyjbxx(Qyjbxx qyjbxx){
		qyjbxx = (Qyjbxx)qyjbxxDao.getQyjbxx(qyjbxx);
		return qyjbxx;
	}
	
	/** 
	 * 查询单条 (包含保安人员数量、保卫人员数量、视频设备数量、技防设备数量)
	 * @param 企业基本信息qyjbxx 
	 * 
	 * */
	public Qyjbxx getQyjbxxAll(Qyjbxx qyjbxx){
		// 保安人员
		Baryxx baryxx = new Baryxx(); 
		// 保卫人员
		Bwryxx bwryxx = new Bwryxx();
		// 视频监控设备
		Bldsjksb bldsjksb = new Bldsjksb();
		// 技防设备
		Aqjcsb aqjcsb = new Aqjcsb();
		// 企业id
		int qyid;
		// 企业基本信息查询
		qyjbxx = getQyjbxx(qyjbxx);
		if(qyjbxx != null){
			// 取得企业id
			qyid = qyjbxx.getQyid();
			// 设定保安人员的企业id
			baryxx.setQyid(qyid);
			// 取得保安人员数量
			qyjbxx.setBarysl(baryxxDao.getBaryxxCount(baryxx));
			// 设定保卫人员的企业id
			bwryxx.setQyid(qyid);
			// 取得保卫人员数量
			qyjbxx.setBwrysl(bwryxxDao.getBwryxxCount(bwryxx));
			// 设定视频监控设备的企业id
			bldsjksb.setQyid(qyid);
			qyjbxx.setSxtsl(bldsjksbDao.getSpjksbCount(bldsjksb));
			// 设定技防设备的企业id
			aqjcsb.setQyid(qyid);
			qyjbxx.setJfsbsl(aqjcsbDao.getJfsbCount(aqjcsb));
		}
		return qyjbxx;
	}
	
	public Qyjbxx getQyjbxxUsbkey(Qyjbxx qyjbxx){
		
		// 企业基本信息查询
		qyjbxx = (Qyjbxx)qyjbxxDao.getQyjbxx(qyjbxx);
		return qyjbxx;
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询 采集点提交  */
	public Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyjbxxDao.getWtjListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业基本信息(t_qyjbxx) 分页查询 企业管理页面 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyjbxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业核查(即信息确认)、派出所审核查询、市局审核查询*/
	public Page getListForPageHc(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyjbxxDao.getListForPageHc(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  公安端企业查询*/
	public Page getListForPageQycx(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyjbxxDao.getListForPageQycx(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业变更、注销查询*/
	public Page getListForPageQybg(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyjbxxDao.getListForPageQybg(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业变更详情*/
	public Page getListForPageQybgxq(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyjbxxDao.getListForPageQybgxq(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询 制卡端关联查询*/
	public Page getListForPageZkd(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyjbxxDao.getListForPageZkd(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业基本信息(t_qyjbxx) 多条查询 */
	public List getListQyjbxx(Qyjbxx qyjbxx){
		// TODO: implement
		return qyjbxxDao.getListQyjbxx(qyjbxx);
	}
	
	/**
	 * 判断企业是否已存在
	 * @param qyjbxx(qyid,zjbh)
	 * @return 0-不存在，1-存在
	 */
	public String isQyjbxxExist(Qyjbxx qyjbxx)
	{
		String isQyjbxxExist = "1";
		Qyjbxx QyjbxxExist = new Qyjbxx();
		if(qyjbxx.getZjbh()==null)
			qyjbxx.setZjbh("");
		QyjbxxExist = qyjbxxDao.isQyjbxxExist(qyjbxx);
		if(QyjbxxExist == null)
			isQyjbxxExist = "0";
		
		return isQyjbxxExist;
	}
	
	
	/**
	 * 保安服务合同 记录变化的需要添加到企业变更信息表里 2010-02-25 yb
	 * @param qyjbxx
	 * @param lyxyycsList
	 */
	public void addQybgxxBafwht(Qyjbxx qyjbxx){
		boolean isChange = false;
		String bgqnr = "";
		String bghnr = "";
		List qybgxxList = qyjbxx.getQybgxxList();
		Map bafwhtMap = new HashMap();
		Bafwht temp = new Bafwht();
		Qybgxx qybgxx = null;
		List bafwhtList = qyjbxx.getLBafwhtList();
		if(bafwhtList != null){
			for(int index=0,max=bafwhtList.size();index<max;index++){
				temp = (Bafwht)bafwhtList.get(index);
				bghnr += appendBafwhtxx(temp);
				if(index!=max-1) bghnr += ";";
				Integer bafwhtid = temp.getBafwhtid();
				if(bafwhtid!=null&&bafwhtid>0){
					bafwhtMap.put(bafwhtid, "1"); //原数据没有被删除的放到Map里
				} else { //新加的内容
					isChange = true;
				}
			}
		}
		
		temp.setQyid(qyjbxx.getQyid());
		List oldList = bafwhtDao.getListBafwht(temp);
		if(oldList != null){
			for(int indexo=0,max=oldList.size();indexo<max;indexo++){
				temp = (Bafwht)oldList.get(indexo);
				bgqnr += appendBafwhtxx(temp);
				if(indexo!=max-1) bgqnr += ";";
				Integer bafwhtid = temp.getBafwhtid();
				if(bafwhtMap.get(bafwhtid)==null){ //页面上删除的数据
					isChange = true;
				}
			}
		}
		if(isChange){
			addQybgxx(qyjbxx,qybgxxList, qybgxx, bgqnr, bghnr, 8, false);
		}
	}
	public String appendBafwhtxx(Bafwht temp){
		return "'"+temp.getBafwhtid()+"','"+temp.getQyid()+"','"+temp.getBafwgsmc()+"','"+temp.getBaryzgzsmc()+"','"
					+temp.getBarypxjsrq()+"','"+temp.getHtbh()+"','"+temp.getQdrq()+"','"+temp.getJsrq()+"','"
					+temp.getHtyxq()+"','"+temp.getBarypxnr()+"'";
	}
	/**
	 * 平面图 记录变化的需要添加到企业变更信息表里 2010-02-25 yb
	 * @param qyjbxx
	 * @param lyxyycsList
	 */
	public void addQybgxxPmt(Qyjbxx qyjbxx){
		boolean isChange = false;
		String bgqnr = "";
		String bghnr = "";
		List qybgxxList = qyjbxx.getQybgxxList();
		Map pmtMap = new HashMap();
		Pmt temp = new Pmt();
		Qybgxx qybgxx = null;
		List pmtList = qyjbxx.getLPmtList();
		if(pmtList != null){
			for(int index=0,max=pmtList.size();index<max;index++){
				temp = (Pmt)pmtList.get(index);
				bghnr += appendPmt(temp);
				if(index!=max-1) bghnr += ";";
				String spmtid = temp.getSPmtid();
				if(spmtid!=null&&spmtid.contains("NEW")){ //新加的内容
					isChange = true;
				} else {
					pmtMap.put(spmtid, "1"); //原数据没有被删除的放到Map里
				}
			}
		}
		
		temp.setQyid(qyjbxx.getQyid());
		List oldList = pmtDao.getListPmt(temp);
		if(oldList != null){
			for(int indexo=0,max=oldList.size();indexo<max;indexo++){
				temp = (Pmt)oldList.get(indexo);
				bgqnr += appendPmt(temp);
				if(indexo!=max-1) bgqnr += ";";
				String pmtid = String.valueOf(temp.getPmtid());
				if(pmtMap.get(pmtid)==null){ //页面上删除的数据
					isChange = true;
				}
			}
		}
		
		if(isChange){
			addQybgxx(qyjbxx,qybgxxList, qybgxx, bgqnr, bghnr, 8, false);
		}
	}
	public String appendPmt(Pmt temp){
		String pmtz = (temp.getPmtz()!=null)?new String(temp.getPmtz()):"";
		return "'"+temp.getQyid()+"','"+temp.getPmtid()+"','"+temp.getPmtlxdm()+"','"+temp.getPmtlxmc()+"','"+pmtz+"'";
	}
	/**
	 * 闭路电视 记录变化的需要添加到企业变更信息表里 2010-02-26 yb
	 * @param qyjbxx
	 * @param lyxyycsList
	 */
	public void addQybgxxBldsjksb(Qyjbxx qyjbxx){
		boolean isChange = false;
		String bgqnr = "";
		String bghnr = "";
		List qybgxxList = qyjbxx.getQybgxxList();
		Map BldsjksbMap = new HashMap();
		Bldsjksb temp = new Bldsjksb();
		Qybgxx qybgxx = null;
		List BldsjksbList = qyjbxx.getLBldsjksbList();
		if(BldsjksbList != null){
			for(int index=0,max=BldsjksbList.size();index<max;index++){
				temp = (Bldsjksb)BldsjksbList.get(index);
				bghnr += appendBldsjksb(temp);
				if(index!=max-1) bghnr += ";";
				Integer bldsjksbid = temp.getBldsjksbid();
				if(bldsjksbid!=null&&bldsjksbid>0){
					BldsjksbMap.put(bldsjksbid, "1"); //原数据没有被删除的放到Map里
				} else { //新加的内容
					isChange = true;
				}
			}
		}
		
		temp.setQyid(qyjbxx.getQyid());
		List oldList = bldsjksbDao.getListBldsjksb(temp);
		if(oldList != null){
			for(int indexo=0,max=oldList.size();indexo<max;indexo++){
				temp = (Bldsjksb)oldList.get(indexo);
				bgqnr += appendBldsjksb(temp);
				if(indexo!=max-1) bgqnr += ";";
				Integer bldsjksbid = temp.getBldsjksbid();
				if(BldsjksbMap.get(bldsjksbid)==null){ //页面上删除的数据
					isChange = true;
				}
			}
		}
		
		if(isChange){
			addQybgxx(qyjbxx,qybgxxList, qybgxx, bgqnr, bghnr, 6, false);
		}
	}
	public String appendBldsjksb(Bldsjksb temp){
		return "'"+temp.getQyid()+"','"+temp.getBldsjksbid()+"','"+temp.getWlcslxbm()+"','"+temp.getWlcslxmc()+"','"+
					temp.getSbjcjgmc()+"','"+temp.getAzsxtsl()+"','"+temp.getSbxh()+"','"+temp.getSccsmc()+"','"+
					temp.getGgxh()+"','"+temp.getAzsl()+"','"+temp.getSbmc()+"','"+temp.getSflx()+temp.getIpdz()+"','"+
					temp.getAnwz()+"'";
	}
	/**
	 * 安全检查设备 记录变化的需要添加到企业变更信息表里 2010-02-26 yb
	 * @param qyjbxx
	 * @param lyxyycsList
	 */
	public void addQybgxxAqjcsb(Qyjbxx qyjbxx){
		boolean isChange = false;
		String bgqnr = "";
		String bghnr = "";
		List qybgxxList = qyjbxx.getQybgxxList();
		Map aqjcsbMap = new HashMap();
		Aqjcsb temp = new Aqjcsb();
		Qybgxx qybgxx = null;
		List aqjcsbList = qyjbxx.getLAqjcsbList();
		if(aqjcsbList != null){
			for(int index=0,max=aqjcsbList.size();index<max;index++){
				temp = (Aqjcsb)aqjcsbList.get(index);
				bghnr += appendAqjcsb(temp);
				if(index!=max-1) bghnr += ";";
				Integer aqjcsbid = temp.getAnjcsbid();
				if(aqjcsbid!=null&&aqjcsbid>0){
					aqjcsbMap.put(aqjcsbid, "1"); //原数据没有被删除的放到Map里
				} else { //新加的内容
					isChange = true;
				}
			}
		}
		
		temp.setQyid(qyjbxx.getQyid());
		List oldList = aqjcsbDao.getListAqjcsb(temp);
		if(oldList != null){
			for(int indexo=0,max=oldList.size();indexo<max;indexo++){
				temp = (Aqjcsb)oldList.get(indexo);
				bgqnr += appendAqjcsb(temp);
				if(indexo!=max-1) bgqnr += ";";
				Integer aqjcsbid = temp.getAnjcsbid();
				if(aqjcsbMap.get(aqjcsbid)==null){ //页面上删除的数据
					isChange = true;
				}
			}
		}
		
		if(isChange){
			addQybgxx(qyjbxx,qybgxxList, qybgxx, bgqnr, bghnr, 6, false);
		}
	}
	public String appendAqjcsb(Aqjcsb temp){
		return "'"+temp.getQyid()+"','"+temp.getAnjcsbid()+"','"+temp.getAqjcsbzlbm()+"','"+temp.getAqjcsbzlmc()+"','"+
					temp.getSbxh()+"','"+temp.getGgxh()+"','"+temp.getSbmc()+"','"+temp.getAzsl()+"'";
	}
	/**
	 * 保安人员信息 记录变化的需要添加到企业变更信息表里
	 * @param qyjbxx
	 */
	public void addQybgxxBaryxx(Qyjbxx qyjbxx){
		boolean isChange = false;
		String bgqnr = "";
		String bghnr = "";
		List qybgxxList = qyjbxx.getQybgxxList();
		Map baryxxMap = new HashMap();
		Baryxx temp = new Baryxx();
		Qybgxx qybgxx = null;
		List baryxxbList = qyjbxx.getLBaryxxList();
		if(baryxxbList != null){
			for(int index=0,max=baryxxbList.size();index<max;index++){
				temp = (Baryxx)baryxxbList.get(index);
				bghnr += appendBaryxx(temp);
				if(index!=max-1) bghnr += ";";
				Integer baryid = temp.getBaryid();
				if(baryid!=null&&baryid>0){
					baryxxMap.put(baryid, "1"); //原数据没有被删除的放到Map里
				} else { //新加的内容
					isChange = true;
				}
			}
		}
		
		temp.setQyid(qyjbxx.getQyid());
		List oldList = baryxxDao.getListBaryxx(temp);
		if(oldList != null){
			for(int indexo=0,max=oldList.size();indexo<max;indexo++){
				temp = (Baryxx)oldList.get(indexo);
				bgqnr += appendBaryxx(temp);
				if(indexo!=max-1) bgqnr += ";";
				Integer baryid = temp.getBaryid();
				if(baryxxMap.get(baryid)==null){ //页面上删除的数据
					isChange = true;
				}
			}
		}
		
		if(isChange){
			addQybgxx(qyjbxx,qybgxxList, qybgxx, bgqnr, bghnr, 6, false);
		}
	}
	public String appendBaryxx(Baryxx temp){
		return "'"+temp.getQyid()+"','"+temp.getBaryid()+"','"+temp.getXm()+"','"+temp.getXbdm()+"','"+
					temp.getXb()+"','"+temp.getCsrq()+"','"+temp.getGmsfhm()+"','"+temp.getHjdxzqh()+"','"+temp.getHjdxzqhdm()
					+"','"+temp.getHjdxz()+"','"+temp.getBalxbm()+"','"+temp.getBalx()+"','"+temp.getFzjg()
					+"','"+temp.getSgrq()+"','"+temp.getLzyy()+"','"+temp.getLzrq()+"','"+temp.getZt()
					+"','"+temp.getBz()+"','"+temp.getLrr()+"','"+temp.getLrsj()+"'";
	}
	/**
	 * 外国投资人 记录变化的需要添加到企业变更信息表里 2010-02-26 yb
	 * @param qyjbxx
	 * @param lyxyycsList
	 */
	public void addQybgxxWgtzrxx(Qyjbxx qyjbxx){
		boolean isChange = false;
		String bgqnr = "";
		String bghnr = "";
		List qybgxxList = qyjbxx.getQybgxxList();
		if(qybgxxList==null)qybgxxList = new ArrayList();
		Map wgtzrxxMap = new HashMap();
		Wgtzrxx temp = new Wgtzrxx();
		Qybgxx qybgxx = null;
		List wgtzrxxList = qyjbxx.getLWgtzrxxList();
		if(wgtzrxxList!=null){
			for(int index=0,max=wgtzrxxList.size();index<max;index++){
				temp = (Wgtzrxx)wgtzrxxList.get(index);
				bghnr += appendWgtzrxx(temp);
				if(index!=max-1) bghnr += ";";
				Integer wgtzrxxid = temp.getWgtzrxxid();
				if(wgtzrxxid!=null&&wgtzrxxid>0){
					wgtzrxxMap.put(wgtzrxxid, "1"); //原数据没有被删除的放到Map里
				} else { //新加的内容
					isChange = true;
				}
			}
		}
		
		temp.setQyid(qyjbxx.getQyid());
		List oldList = wgtzrxxDao.getListWgtzrxx(temp);
		int max;
		if(oldList!=null && (max=oldList.size())>0){
			for(int indexo=0;indexo<max;indexo++){
				temp = (Wgtzrxx)oldList.get(indexo);
				bgqnr += appendWgtzrxx(temp);
				if(indexo!=max-1) bgqnr += ";";
				Integer wgtzrxxid = temp.getWgtzrxxid();
				if(wgtzrxxMap.get(wgtzrxxid)==null){ //页面上删除的数据
					isChange = true;
				}
			}
		}
		if(isChange){
			addQybgxx(qyjbxx,qybgxxList, qybgxx, bgqnr, bghnr, 8, false);
		}
	}
	public String appendWgtzrxx(Wgtzrxx temp){
		return "'"+temp.getWgtzrxxid()+"','"+temp.getQyid()+"','"+temp.getTzzxm()+"','"+temp.getLxdh()+"','"+
					temp.getGjdm()+"','"+temp.getGj()+"','"+temp.getQzzldm()+"','"+temp.getQzzlmc()+"','"+temp.getQzhm()+"','"+
					temp.getHzzldm()+"','"+temp.getHzzlmc()+"','"+temp.getHzhm()+"'";
	}
	/**
	 * 证件表 记录变化的需要添加到企业变更信息表里 2010-02-26 yb
	 * @param qyjbxx
	 * @param lyxyycsList
	 */
	public void addQybgxxQyzjb(Qyjbxx qyjbxx){
		Map qyzjbMap = new HashMap();
		Qyzjb temp = new Qyzjb();
		boolean ischange = false;
		List qyzjbList = qyjbxx.getLQyzjbList();
		if(qyzjbList!=null){
			for(int index=0,max=qyzjbList.size();index<max;index++){
				temp = (Qyzjb)qyzjbList.get(index);
				String zjlx = temp.getZjfl();
				qyzjbMap.put(zjlx, temp);
			}
			
			temp.setQyid(qyjbxx.getQyid());
			List oldList = qyzjbDao.getListQyzjb(temp);
			if(qyzjbList.size()==oldList.size()){
				for(int indexo=0,max=oldList.size();indexo<max;indexo++){
					temp = (Qyzjb)oldList.get(indexo);
					String zjlx = temp.getZjfl();
					if(qyzjbMap.get(zjlx)==null){
						ischange = true; //变化了
					} else {
						if(zjbIsChange((Qyzjb)qyzjbMap.get(zjlx), temp)){
							ischange = true; //变化了
						}
					}
				}
			} else {
				ischange = true; //变化了
			}
			if(ischange){
				appendZjbList(qyjbxx, qyzjbList, oldList);
			}
		}
	}
	public boolean zjbIsChange(Qyzjb temp,Qyzjb old){
		String zjbh = (temp.getZjbh()==null)?"":temp.getZjbh();
		String fzjg = (temp.getFzjg()==null)?"":temp.getFzjg();
		String qsrq = (temp.getQsrq()==null)?"":String.valueOf(temp.getQsrq());
		String jzrq = (temp.getJzrq()==null)?"":String.valueOf(temp.getJzrq());
		
		String zjbhOld = (old.getZjbh()==null)?"":old.getZjbh();
		String fzjgOld = (old.getFzjg()==null)?"":old.getFzjg();
		String qsrqOld = (old.getQsrq()==null)?"":String.valueOf(old.getQsrq());
		String jzrqOld = (old.getJzrq()==null)?"":String.valueOf(old.getJzrq());
		if(!zjbh.equals(zjbhOld)||!fzjg.equals(fzjgOld)||!qsrq.equals(qsrqOld)||!jzrq.equals(jzrqOld)){
			return true;
		} else {
			return false;			
		}
	}
	public void appendZjbList(Qyjbxx qyjbxx,List tempList,List oldList){
		List qybgxxList = qyjbxx.getQybgxxList();
		Qybgxx qybgxx = null;
		Qyzjb temp = null;
		String bgqnr = "";
		String bghnr = "";
		for(int index=0,max=tempList.size();index<max;index++){
			temp = (Qyzjb)tempList.get(index);
			bghnr += appendZjb(temp);
			if(index!=max-1) bghnr += ";";
		}
		for(int index=0,max=oldList.size();index<max;index++){
			temp = (Qyzjb)oldList.get(index);
			bgqnr += appendZjb(temp);
			if(index!=max-1) bgqnr += ";";
		}
		addQybgxx(qyjbxx,qybgxxList, qybgxx, bgqnr, bghnr, 6, false);
	}
	public String appendZjb(Qyzjb temp){
		return "'"+temp.getZjid()+"','"+temp.getQyid()+"','"+temp.getZjfl()+"','"+temp.getZjbh()+"','"+
					temp.getFzjg()+"','"+temp.getQsrq()+"','"+temp.getJzrq()+"'";
	}
	public void addQybgxx(Qyjbxx qyjbxx,List qybgxxList,Qybgxx qybgxx,String bgqnr,String bghnr,int bglxIndex,boolean isDbnr){
		if(!("变更".equals(qyjbxx.getCzlx())&&"J".equals(qyjbxx.getHylbdm()))){ return; } //不是娱乐业不是变更动作 返回
		if(isDbnr){ if(bgqnr.equals(bghnr)){ return; } } //如果相同返回
		qybgxx = new Qybgxx();
		qybgxx.setBglxdm(bglxdm[bglxIndex]);
		qybgxx.setBglx(bglx[bglxIndex]);
		qybgxx.setBgqnr(bgqnr);
		qybgxx.setBghnr(bghnr);
		qybgxxList.add(qybgxx);
	}
	
	/** 根据企业主分类 公安端查询场所数量 娱乐业标准化 */
	public List getQyzflCountList(Map map){
		return qyjbxxDao.getQyzflCountList(map);
	}
	
	public IQyjbxxDao getQyjbxxDao() {
		return qyjbxxDao;
	}

	public void setQyjbxxDao(IQyjbxxDao qyjbxxDao) {
		this.qyjbxxDao = qyjbxxDao;
	}

	public IScbmDao getScbmDao() {
		return scbmDao;
	}

	public void setScbmDao(IScbmDao scbmDao) {
		this.scbmDao = scbmDao;
	}

	public IQyzjbDao getQyzjbDao() {
		return qyzjbDao;
	}

	public void setQyzjbDao(IQyzjbDao qyzjbDao) {
		this.qyzjbDao = qyzjbDao;
	}

	public IQyfflDao getQyfflDao() {
		return qyfflDao;
	}

	public void setQyfflDao(IQyfflDao qyfflDao) {
		this.qyfflDao = qyfflDao;
	}

	public IWgtzrxxDao getWgtzrxxDao() {
		return wgtzrxxDao;
	}

	public void setWgtzrxxDao(IWgtzrxxDao wgtzrxxDao) {
		this.wgtzrxxDao = wgtzrxxDao;
	}

	public IBafwhtDao getBafwhtDao() {
		return bafwhtDao;
	}

	public void setBafwhtDao(IBafwhtDao bafwhtDao) {
		this.bafwhtDao = bafwhtDao;
	}

	public IBldsjksbDao getBldsjksbDao() {
		return bldsjksbDao;
	}

	public void setBldsjksbDao(IBldsjksbDao bldsjksbDao) {
		this.bldsjksbDao = bldsjksbDao;
	}

	public IAqjcsbDao getAqjcsbDao() {
		return aqjcsbDao;
	}

	public void setAqjcsbDao(IAqjcsbDao aqjcsbDao) {
		this.aqjcsbDao = aqjcsbDao;
	}

	public IPmtDao getPmtDao() {
		return pmtDao;
	}

	public void setPmtDao(IPmtDao pmtDao) {
		this.pmtDao = pmtDao;
	}

	public IQyxxczrzDao getQyxxczrzDao() {
		return qyxxczrzDao;
	}

	public void setQyxxczrzDao(IQyxxczrzDao qyxxczrzDao) {
		this.qyxxczrzDao = qyxxczrzDao;
	}

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public IQyjbxx_lsDao getQyjbxx_lsDao() {
		return qyjbxx_lsDao;
	}

	public void setQyjbxx_lsDao(IQyjbxx_lsDao qyjbxx_lsDao) {
		this.qyjbxx_lsDao = qyjbxx_lsDao;
	}

	public IZjb_lsDao getZjb_lsDao() {
		return zjb_lsDao;
	}

	public void setZjb_lsDao(IZjb_lsDao zjb_lsDao) {
		this.zjb_lsDao = zjb_lsDao;
	}

	public IQyzhtbDao getQyzhtbDao() {
		return qyzhtbDao;
	}

	public void setQyzhtbDao(IQyzhtbDao qyzhtbDao) {
		this.qyzhtbDao = qyzhtbDao;
	}

	public IQyryxxService getQyryxxService() {
		return qyryxxService;
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}

	public void setQyshService(IQyshService qyshService) {
		this.qyshService = qyshService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setQybgxxDao(IQybgxxDao qybgxxDao) {
		this.qybgxxDao = qybgxxDao;
	}
	
	/** 待核查场所数 娱乐业标准化 */
	public int getDhccsCount(Map map){
		// TODO: implement
		return qyjbxxDao.getDhccsCount(map);
	}
	
	/** @param 企业基本信息导出标识(t_qyjbxx) 修改 */
	public boolean updateQyjbxxDcbs(Qyjbxx qyjbxx) throws Exception{
		return qyjbxxDao.updateQyjbxx(qyjbxx)>0;
	}

	public void setBaryxxDao(IBaryxxDao baryxxDao) {
		this.baryxxDao = baryxxDao;
	}

	public void setBwryxxDao(IBwryxxDao bwryxxDao) {
		this.bwryxxDao = bwryxxDao;
	}
}
