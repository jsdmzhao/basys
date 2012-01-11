package com.aisino2.publicsystem.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.cache.CacheManager;
import com.aisino2.common.QjblUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.publicsystem.dao.IGgQyyhDao;
import com.aisino2.publicsystem.dao.IQyZrsProcDao;
import com.aisino2.publicsystem.dao.IQyjbxxDao;
import com.aisino2.publicsystem.dao.IQyry_tjxxDao;
import com.aisino2.publicsystem.dao.IQyry_zpDao;
import com.aisino2.publicsystem.dao.IQyryshDao;
import com.aisino2.publicsystem.dao.IQyryxxDao;
import com.aisino2.publicsystem.dao.IQyryxx_lsxxDao;
import com.aisino2.publicsystem.dao.IQyryxxhcDao;
import com.aisino2.publicsystem.dao.IRyjcxxDao;
import com.aisino2.publicsystem.dao.IRyxxczrzDao;
import com.aisino2.publicsystem.dao.IWgcyryxxDao;
import com.aisino2.publicsystem.domain.Garkktbsj;
import com.aisino2.publicsystem.domain.GgQyyh;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyry_tjxx;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.domain.Qyrysh;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;
import com.aisino2.publicsystem.domain.Qyryxxhc;
import com.aisino2.publicsystem.domain.Ryjcxx;
import com.aisino2.publicsystem.domain.Ryxxczrz;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.IGarkktbsjService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IQyryxxhcService;
import com.aisino2.sysadmin.dao.IUserDao;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;

public class QyryxxServiceImpl extends BaseService implements IQyryxxService {

	private IQyryxxDao qyryxxDao;
	private IQyryxx_lsxxDao qyryxx_lsxxDao;
	private IWgcyryxxDao wgcyryxxDao;
	private IRyxxczrzDao ryxxczrzDao;
	private IQyjbxxDao qyjbxxDao;
	private IQyry_zpDao qyry_zpDao;
	private IScbmDao scbmDao;
	private IUserDao userDao;
	private IQyryshDao qyryshDao;
	private IQyZrsProcDao qyZrsProcDao;//计算场所人数的服务
	private IRyjcxxDao ryjcxxDao;//人员奖惩
	private IQyry_tjxxDao qyry_tjxxDao;//企业人员体检
	private IQyryxxhcDao qyryxxhcDao;//企业人员核查
	//private IQyryshService qyryshService;//审核,先不做
	private IGarkktbsjService garkktbsjService; //公安人口库同步数据
	private IQyryxxhcService qyryxxhcService;//核查
	private IGgQyyhDao ggQyyhDao;//同步企业用户和企业员工用户的方法===t_user
	
	//查看是否有账号
	public  String getUser(String useraccount){
		User user = new User();
		user.setUseraccount(useraccount);
		user =userDao.getUser(user);
		if(user!=null&&user.getUseraccount()!=null){
			return "1";
		}else{
			return "0";
		}
	}
	
	
	/** 
	 * 取得全局变量
	 * @param String key
	 * @return String value
	 * */
	public String queryQjbl(String key)throws Exception{
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode(key);
		List list = CacheManager.getCacheGlobalpar(globalpar);
		String value="0";
		if(list!=null&&list.size()>0){
			value =( ((Globalpar)list.get(0)).getGlobalparvalue()).toString();
			}
		return value;
	}
	
	/** 
	 * 是否生成账号标志
	 * @param String key 行业类别+gwbh
	 * @return String value
	 * */
	public String sczhFlag(String key,String gwbh)throws Exception{
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode(key+"gwbh");
		List list = CacheManager.getCacheGlobalpar(globalpar);
		String value="0";
		if(list!=null&&list.size()>0){
				value =( ((Globalpar)list.get(0)).getGlobalparvalue()).toString();
			 String [] gwbhs=	value.split(",");
			 for(int i=0;i<gwbhs.length;i++)
				if(gwbhs[i].equals(gwbh)){
					return "1";
				}
			  
			}
		return "0";
	}
	
	/** @param 企业人员信息(t_qyryxx) 增加 */
	public Qyryxx insertQyryxx(Qyryxx qyryxx) throws Exception {
		// TODO: implement	
		Date currentDate = new Date();
		Qyryxx qyryxxNew = new Qyryxx();
		Qyry_zp qyry_zp = new Qyry_zp();
		Wgcyryxx wgcyryxx = new Wgcyryxx();
		List qyry_zpList = new ArrayList();
		
		Qyjbxx qyjbxx  = new Qyjbxx();
		
		
		qyjbxx.setQyid(qyryxx.getQyid());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		//得到从业人员编号
		//娱乐业、公共场所行业规则：企业编码前9位+8位年份+4位流水号
		//其他行业规则 ：企业编码+2位年份+4位流水号 (modified by mds at 20100120)
		String hylbdm = qyjbxx.getHylbdm();

		Map scbmMap = new HashMap();
		scbmMap.put("p_bmfl", "RY");
		if(hylbdm.equals("J")||hylbdm.equals("K"))
			scbmMap.put("p_xzqh", qyjbxx.getQybm().substring(0, 9));
		else
			scbmMap.put("p_xzqh", qyjbxx.getQybm());
		String sssf = QjblUtil.queryQjblVal("sssf");//所属省份

		scbmMap.put("p_sssf", sssf);
		if(hylbdm.equals("J")||hylbdm.equals("K"))
			scbmMap.put("p_scgz", 2);
		else
			scbmMap.put("p_scgz", 4);
		//若前台传入的cyrybh为空，则调用编码生成程序生成编码。


		if(qyryxx.getCyrybh()==null||"".equals(qyryxx.getCyrybh()))
			qyryxx.setCyrybh(scbmDao.getScbm(scbmMap));
		//增加从业人员信息表
		qyryxx.setScbz(0);
		qyryxx.setZxbz("0");
		qyryxx.setBiduiflag("0");//未比对
	
		//增加从业人员信息表
		if("0".equals(qyryxx.getCyrylbdm()))
		{
			qyryxx.setCyzjdm("111");
			qyryxx.setCyzj("公民身份号码");
			qyryxx.setGjdm("CHN");
			qyryxx.setGj("中国");
			if(qyryxx.getZjzt()!=null)
			{
				if("0".equals(qyryxx.getZjzt()))//公民身份号码符合校验规则
				{
					qyryxx.setZt("0");
				}
				else
					qyryxx.setZt("5");
			}
			else 
				qyryxx.setZt("0");
		}
		else
		{
			//若为境外从业人员,则姓名字段为英文名+" "+英文姓

			if(qyryxx.getXm()==null||"".equals(qyryxx.getXm())){
				qyryxx.setXm(qyryxx.getWgcyryxx().getYwm()+" "+qyryxx.getWgcyryxx().getYwx());
			}
			
			qyryxx.setZt("0");
		}
		qyryxx.setXmpy(PinYinUtil.getHanyuPingYin(qyryxx.getXm()));
		qyryxx.setLrsj(currentDate);
		qyryxxNew = qyryxxDao.insertQyryxx(qyryxx);
		if(qyryxx.getQyry_zp()!=null)
		{
			qyry_zp = qyryxx.getQyry_zp();
			qyry_zp.setRyid(qyryxxNew.getRyid());
			qyry_zp.setQyid(qyryxxNew.getQyid());
			qyry_zp.setTplx("0");
			qyry_zp = qyry_zpDao.insertQyry_zp(qyry_zp);
		}
		//增加外国从业人员信息表


		if(qyryxx.getWgcyryxx()!=null)
		{
			wgcyryxx = qyryxx.getWgcyryxx();
			wgcyryxx.setRyid(qyryxxNew.getRyid());
			wgcyryxx = wgcyryxxDao.insertWgcyryxx(wgcyryxx);
		}
		
		//若从业人员状态为5-证件号码错，则插入从业人员核查表
		if(qyryxx.getWgcyryxx()==null)
		{
			if("5".equals(qyryxxNew.getZt()))
			{
				Garkktbsj garkktbsj = new com.aisino2.publicsystem.domain.Garkktbsj();
				garkktbsj = garkktbsjService.insertGarkktbsj(garkktbsj);
				Qyryxxhc qyryxxhc = new Qyryxxhc();
				qyryxxhc.setRyid(qyryxxNew.getRyid());
				qyryxxhc.setGarkktbsjid(garkktbsj.getGarkktbsjid());
				qyryxxhc.setHcwt("证件号码错");
				qyryxxhcService.insertQyryxxhcByRyid(qyryxxhc);
			}
		}
		//更新场所总人数


		Map map = new HashMap();
		map.put("p_oldQyid", 0);
		map.put("p_newQyid", qyryxxNew.getQyid());
		
		qyZrsProcDao.updateQyzrs(map);
		//人员信息操作日志
		Ryxxczrz ryxxczrz = new Ryxxczrz();
		ryxxczrz.setCzsj(currentDate);
		ryxxczrz.setCzlx("增加");
		ryxxczrz.setQybm(qyjbxx.getQybm());
		ryxxczrz.setCzr(qyryxx.getLrr());
		ryxxczrz.setCyrybh(qyryxxNew.getCyrybh());
		ryxxczrzDao.insertRyxxczrz(ryxxczrz);
		
		
		qyryxxNew.setQyry_zp(qyry_zp);
		qyryxxNew.setWgcyryxx(wgcyryxx);
		
		//生成从业人员账号
	   int errCode=0;
		if(sczhFlag(qyryxxNew.getHylbdm(),qyryxxNew.getGwbh()).equals("1")){
			if("1".equals(queryQjbl(qyryxxNew.getHylbdm()+"tbsczh"))){//同步生成账号
				GgQyyh qyyh = new GgQyyh();
				qyyh.setRyid(qyryxxNew.getRyid());
				errCode =ggQyyhDao.insertQyYgyh(qyyh);
				if(errCode==1) return null;
			}
		}
		return qyryxxNew;	
		
	}

	/** @param 企业人员信息(t_qyryxx) 删除 */
	public boolean deleteQyryxx(Qyryxx qyryxx) throws Exception{
		// TODO: implement
		boolean isSuccess = false;
		Date currentDate = new Date();
		//保存人员历史信息
		Qyryxx_lsxx qyryxx_lsxx = new Qyryxx_lsxx();
		Qyryxx qyryxx_bak = new Qyryxx();
		Wgcyryxx wgcyryxx_bak = new Wgcyryxx();
		qyryxx_bak.setRyid(qyryxx.getRyid());
		qyryxx_bak = qyryxxDao.getQyryxx(qyryxx_bak);
		wgcyryxx_bak.setRyid(qyryxx.getRyid());
		wgcyryxx_bak = wgcyryxxDao.getWgcyryxx(wgcyryxx_bak);
		if(qyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, qyryxx_bak);
		if(wgcyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, wgcyryxx_bak);
		qyryxx_lsxx.setCzlx("删除");
		qyryxx_lsxxDao.insertQyryxx_lsxx(qyryxx_lsxx);
		
		//修改从业人员信息表
		qyryxx.setScbz(1);
		qyryxx.setZxsj(currentDate);
		qyryxx.setZxr(qyryxx.getCzr());
		qyryxxDao.updateQyryxx(qyryxx);
		
		//更新场所总人数
		Map map = new HashMap();
		map.put("p_oldQyid",  qyryxx_bak.getQyid());
		map.put("p_newQyid",0);
		qyZrsProcDao.updateQyzrs(map);
		
		//人员信息操作日志
		Qyjbxx qyjbxx  = new Qyjbxx();
		qyjbxx.setQyid(qyryxx_bak.getQyid());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		Ryxxczrz ryxxczrz = new Ryxxczrz();
		ryxxczrz.setCzsj(currentDate);
		ryxxczrz.setCzlx("删除");
		ryxxczrz.setCzr(qyryxx.getZxr());
		ryxxczrz.setQybm(qyjbxx.getQybm());
		ryxxczrz.setCyrybh(qyryxx_bak.getCyrybh());
		ryxxczrzDao.insertRyxxczrz(ryxxczrz);
		
		  int errCode=0;
		
			//删除员工用户
			if(sczhFlag(qyryxx_bak.getHylbdm(),qyryxx_bak.getGwbh()).equals("1")){
				if(getUser(qyryxx_bak.getCyrybh()).equals("1")){
					GgQyyh qyyh = new GgQyyh();
					qyyh.setRyid(qyryxx_bak.getRyid());
					errCode =ggQyyhDao.delQyYgyh(qyyh); //删除员工用户
				
				}
			}
		
		if(errCode==1) return false;
		
		return isSuccess;
		
		
	}

	/** @param 企业人员信息(t_qyryxx) 修改 */
	public boolean updateQyryxx(Qyryxx qyryxx) throws Exception{
	//	qyryxx.setQyid(2);
		// TODO: implement
		boolean isSuccess = false;
		Date currentDate = new Date();
		Qyry_zp qyry_zp = new Qyry_zp();
		Wgcyryxx wgcyryxx = new Wgcyryxx();
		
		
		//保存人员历史信息
		Qyryxx_lsxx qyryxx_lsxx = new Qyryxx_lsxx();
		Qyryxx qyryxx_bak = new Qyryxx();
		Wgcyryxx wgcyryxx_bak = new Wgcyryxx();
		qyryxx_bak.setRyid(qyryxx.getRyid());
		wgcyryxx_bak.setRyid(qyryxx.getRyid());
		qyryxx_bak = qyryxxDao.getQyryxx(qyryxx_bak);
		wgcyryxx_bak = wgcyryxxDao.getWgcyryxx(wgcyryxx_bak);
		if(qyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, qyryxx_bak);
		if(wgcyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, wgcyryxx_bak);
		qyryxx_lsxx.setCzlx("修改");
		qyryxx_lsxx.setBcsj(new Date());
		qyryxx_lsxx = qyryxx_lsxxDao.insertQyryxx_lsxx(qyryxx_lsxx);

		//修改从业人员信息表


		if(qyryxx.getWgcyryxx()==null)
		{
			if(qyryxx_bak.getZt() != null)
			{
				if(qyryxx_bak.getZt().equals("2"))
				{
					qyryxx.setZt("3");
				}
				
				else if(qyryxx_bak.getZt().equals("0"))
				{
					if("1".equals(qyryxx.getZjzt()))
					{
						qyryxx.setZt("5");
					}
				}
				else if(qyryxx_bak.getZt().equals("11"))
				{
					qyryxx.setZt("12");
				}
			}
		}
		else
		{
			//若为境外从业人员,则姓名字段为英文名+" "+英文姓

			if(qyryxx.getXm()==null||"".equals(qyryxx.getXm())){
				qyryxx.setXm(qyryxx.getWgcyryxx().getYwm()+" "+qyryxx.getWgcyryxx().getYwx());
			}
			
			if(qyryxx_bak.getZt() != null)
			{
				if(qyryxx_bak.getZt().equals("2"))
				{
					qyryxx.setZt("3");
				}
				else if(qyryxx_bak.getZt().equals("11"))
				{
					qyryxx.setZt("12");
				}
			}
		}
		if(qyryxx.getXm() != null)
			qyryxx.setXmpy(PinYinUtil.getHanyuPingYin(qyryxx.getXm()));
		
		
		int zpidfalg=0;//0 表示没有变更企业，1表示变更企业了


		//若从业人员服务场所改变，则需修改与t_cyryxx表有直接或间接外键关联的所有表的qyid,但不包括人员历史表和IC卡受理变更表
		if(!qyryxx_bak.getQyid().equals(qyryxx.getQyid()))
		{
			Qyjbxx qyjbxxNow = new Qyjbxx();
			qyjbxxNow.setQyid(qyryxx.getQyid());
			qyjbxxNow = qyjbxxDao.getQyjbxx(qyjbxxNow);
			qyryxx.setHylbdm(qyjbxxNow.getHylbdm());
			qyryxx.setHylb(qyjbxxNow.getHylb());
			updateQyryxxForeignKey(qyryxx,qyryxx_bak);
			zpidfalg=1;
		
		}else{
			qyryxxDao.updateQyryxx(qyryxx);
		}
		
		//更新账号
		String errCode="0";
		errCode = updateUser( qyryxx, qyryxx_bak);
		if(errCode.equals("1")) return false;
		
		
		//修改从业人员照片表
		if(qyryxx.getQyry_zp()!=null)
		{
			//照片
			Qyry_zp qyry_zpbak = new Qyry_zp();
			qyry_zpbak.setRyid(qyryxx_bak.getRyid());
			qyry_zpbak.setQyid(qyryxx_bak.getQyid());
			qyry_zpbak.setTplx("0");
			qyry_zpbak = qyry_zpDao.getQyry_zp(qyry_zpbak);
			
			if(qyry_zpbak==null){
				//无，新增
				qyry_zp = qyryxx.getQyry_zp();
				qyry_zp.setRyid(qyryxx.getRyid());
				qyry_zp.setQyid(qyryxx.getQyid());
				qyry_zp.setTplx("0");
				qyry_zp=qyry_zpDao.insertQyry_zp(qyry_zp);
				qyryxx.setZpid(qyry_zp.getZpid());
			}else{
				//有，更新
				qyry_zp = qyryxx.getQyry_zp();
				qyry_zp.setTplx("0");
				qyry_zp.setRyid(qyryxx.getRyid());
				if(zpidfalg==1){
					qyry_zp.setZpid(qyryxx.getZpid());
				}
				qyry_zpDao.updateQyry_zp(qyry_zp);
				
			}
		}
		
		//若从业人员状态为5-证件号码错，则插入从业人员核查表
		if(qyryxx.getWgcyryxx()==null)
		{
			if("5".equals(qyryxx.getZt()))
			{
				Garkktbsj garkktbsj = new Garkktbsj();
				garkktbsj = garkktbsjService.insertGarkktbsj(garkktbsj);
				Qyryxxhc qyryxxhc = new Qyryxxhc();
				qyryxxhc.setRyid(qyryxx.getRyid());
				qyryxxhc.setGarkktbsjid(garkktbsj.getGarkktbsjid());
				qyryxxhc.setHcwt("证件号码错");
				qyryxxhcService.insertQyryxxhcByRyid(qyryxxhc);
			}
		}
		
		//更新外国从业人员信息
		if(qyryxx.getWgcyryxx()!=null)
		{
			wgcyryxx = qyryxx.getWgcyryxx();
			wgcyryxx.setRyid(qyryxx.getRyid());
			wgcyryxxDao.updateWgcyryxx(wgcyryxx);
		}
			
		//更新场所总人数
		if(!qyryxx_bak.getQyid().equals(qyryxx.getQyid()))
		{
			Map map = new HashMap();
			map.put("p_oldQyid", qyryxx_bak.getQyid());
			map.put("p_newQyid", qyryxx.getQyid());
			qyZrsProcDao.updateQyzrs(map);
		}
		//人员信息操作日志
		Qyjbxx qyjbxx  = new Qyjbxx();
		qyjbxx.setQyid(qyryxx.getQyid());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		Ryxxczrz ryxxczrz = new Ryxxczrz();
		ryxxczrz.setCzsj(currentDate);
		ryxxczrz.setCzlx("修改");
		ryxxczrz.setCzr(qyryxx.getCzr());
		ryxxczrz.setQybm(qyjbxx.getQybm());
		ryxxczrz.setCyrybh(qyryxx_bak.getCyrybh());
		ryxxczrzDao.insertRyxxczrz(ryxxczrz);
		
		isSuccess = true;
		return isSuccess;
	}
	
//更新账号
   public String updateUser(Qyryxx qyryxx,Qyryxx qyryxx_bak) throws Exception{
	
	   int errCode=0;
	//更新账号
	   if(sczhFlag(qyryxx_bak.getHylbdm(),qyryxx_bak.getGwbh()).equals("1")){
			if(getUser(qyryxx_bak.getCyrybh()).equals("1")){
				//如果旧的有账号,
				   if(sczhFlag(qyryxx.getHylbdm(),qyryxx.getGwbh()).equals("1")){
					  //新的也要生成账号,则更新


					    GgQyyh qyyh = new GgQyyh();
						qyyh.setRyid(qyryxx.getRyid());
						errCode=	ggQyyhDao.updateQyYgyh(qyyh);
						if(errCode==1){
							return "1";
						}
				   }else{
					   //新的不生成账号,则删除账号


					    GgQyyh qyyh = new GgQyyh();
						qyyh.setRyid(qyryxx.getRyid());
						errCode= ggQyyhDao.delQyYgyh(qyyh); //删除员工用户
						if(errCode==1){
							return "1";
						}
				   }
			}
		}else{
			//如果旧的没有账号，


			if(sczhFlag(qyryxx.getHylbdm(),qyryxx.getGwbh()).equals("1")){
				//新的要生成账号


				if("1".equals(queryQjbl(qyryxx.getHylbdm()+"tbsczh"))){//同步生成账号
					GgQyyh qyyh = new GgQyyh();
					qyyh.setRyid(qyryxx.getRyid());
					errCode=	ggQyyhDao.insertQyYgyh(qyyh);
					if(errCode==1){
						return "1";
					}
				}
			}
			
		}
   
	   return "0";
  }
	
    /** @param 从业人员信息(t_cyryxx) 多条查询 获得未提交从业人员*/
    public List getWtjListQyryxx(Qyryxx qyryxx)
	{
		return qyryxxDao.getWtjListQyryxx(qyryxx);
	}
	
	
	/** @param 从业人员信息(t_qyryxx) 修改与t_qyryxx表有直接或间接外键关联的所有表的qyid,但不包括人员历史表 */
	public boolean updateQyryxxForeignKey(Qyryxx qyryxx,Qyryxx qyryxx_bak)
	{
		int ryid_bak=qyryxx_bak.getRyid();
		int qyid_bak = qyryxx_bak.getQyid();
		
		
		boolean isSuccess = false;
		Qyryxx	 qyryxxlz = new Qyryxx();
		qyryxxlz.setRyid(qyryxx_bak.getRyid());
		Date currentDate = new Date();
		qyryxxlz.setScbz(2);
		
		qyryxxDao.updateQyryxx(qyryxxlz);
		
		//插入旧的从业人员信息，企业id改变了
		Qyryxx	 qyryxxOld = new Qyryxx();
		qyryxxOld = qyryxx_bak;
		qyryxxOld.setQyid(qyryxx.getQyid());
		qyryxxOld =qyryxxDao.insertQyryxx(qyryxxOld);
		qyryxx.setRyid(qyryxxOld.getRyid());
		//更新新插入的信息
		qyryxxDao.updateQyryxx(qyryxx);
		
		
		//更新icksl表

		Qyjbxx qyjbxxa = new Qyjbxx();
		qyjbxxa.setQyid(qyryxx.getQyid());
		qyjbxxa =qyjbxxDao.getQyjbxx(qyjbxxa);

		/*Icksl icksla = new Icksl();
		icksla.setRyid(ryid_bak);
		icksla.setZxbz("0");
		icksla =ickslDao.getIckslyj(icksla);//拿出这个ryid的最后的icksl记录
		
		Icksl ickslgx = new Icksl();
		ickslgx.setIckslid(icksla.getIckslid());
		ickslgx.setQybm(qyjbxxa.getQybm());
		ickslgx.setQyid(qyjbxxa.getQyid());
		ickslgx.setRyid(qyryxx.getRyid());
		ickslgx.setHylbdm(qyryxx.getHylbdm());
		ickslgx.setHylb(qyryxx.getHylb());
		ickslDao.updateIckslByqybg(ickslgx);*/
		
		//更新qyrysh
		Qyrysh qyrysh = new Qyrysh();
		qyrysh.setRyid(ryid_bak);
		qyrysh.setQyid(qyjbxxa.getQyid());
		qyrysh.setNewRyid(qyryxx.getRyid());
		 
		isSuccess = qyryshDao.updateQyryshByqybg(qyrysh)>0;
	
		//新插入从表数据
		int ryid = qyryxx.getRyid();
		int qyid = qyryxx.getQyid();
		
		//照片
		Qyry_zp qyry_zp = new Qyry_zp();
		qyry_zp.setRyid(ryid_bak);
		qyry_zp.setQyid(qyid_bak);
		qyry_zp.setTplx("0");
		qyry_zp = qyry_zpDao.getQyry_zp(qyry_zp);
		if(qyry_zp!=null){
			qyry_zp.setRyid(ryid);
			qyry_zp.setQyid(qyid);
			qyry_zp =qyry_zpDao.insertQyry_zp(qyry_zp);
			qyryxx.setZpid(qyry_zp.getZpid());
		}
	
		//外国
		Wgcyryxx wgcyryxx = new Wgcyryxx();
		wgcyryxx.setRyid(ryid_bak);
		wgcyryxx.setQyid(qyid_bak);
		wgcyryxx = wgcyryxxDao.getWgcyryxx(wgcyryxx);
		if(wgcyryxx!=null){
		wgcyryxx.setRyid(ryid);
		wgcyryxx.setQyid(qyid);
		wgcyryxxDao.insertWgcyryxx(wgcyryxx);
		}
		//奖惩
		Ryjcxx ryjcxx = new Ryjcxx();
		ryjcxx.setRyid(ryid_bak);
		ryjcxx.setQyid(qyid_bak);
		
		List list =ryjcxxDao.getListRyjcxx(ryjcxx);
	
		 if(list!=null){
			 for(int i=0;i<list.size();i++){
				 ryjcxx = (Ryjcxx)list.get(i);
					ryjcxx.setRyid(ryid);
					ryjcxx.setQyid(qyid);
					ryjcxxDao.insertRyjcxx(ryjcxx);
			 }
		 }
	  //核查
		Qyryxxhc qyryxxhc = new Qyryxxhc();
		qyryxxhc.setRyid(ryid_bak);
		qyryxxhc.setQyid(qyid_bak);
		qyryxxhc =qyryxxhcDao.getQyryxxhc(qyryxxhc);
		if(qyryxxhc!=null){
			qyryxxhc.setRyid(ryid);
			qyryxxhc.setQyid(qyid);
			qyryxxhcDao.insertQyryxxhc(qyryxxhc);
		}
		
	   //体检
		Qyry_tjxx qyry_tjxx = new Qyry_tjxx();
		qyry_tjxx.setRyid(ryid_bak);
		qyry_tjxx.setQyid(qyid_bak);
		
		List listTjxx = qyry_tjxxDao.getListQyry_tjxx(qyry_tjxx);
		
		if(listTjxx!=null){
			for(int j=0 ;j<listTjxx.size();j++){
				qyry_tjxx = (Qyry_tjxx)listTjxx.get(j);
				qyry_tjxx.setRyid(ryid);
				qyry_tjxx.setQyid(qyid);
				qyry_tjxxDao.insertQyry_tjxx(qyry_tjxx);
			}
			
		}
		qyryxx_bak.setRyid(ryid_bak);
		qyryxx_bak.setQyid(qyid_bak);
		
		return isSuccess;
	}
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  制卡端关联查询*/
	public Page getListZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryxxDao.getListZkdForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  制卡端关联查询 场所所属人员*/
	public Page getListZkdByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryxxDao.getListZkdByCsidForPage(map, pageNo, pageSize, sort, desc);
	}
	
	
	
	/**
	 * @author mds 其他人请不要修改此方法，或在修改之前通知我！！
	 * 公用方法 修改主表  不包含修改所属企业，不能修改人员姓名
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public boolean updateQyryxxOnly(Qyryxx qyryxx) throws Exception
	{
		boolean isSuccess = false;
		Date currentDate = new Date();
		//保存人员历史信息
		Qyryxx_lsxx qyryxx_lsxx = new Qyryxx_lsxx();
		Qyryxx qyryxx_bak = new Qyryxx();
		Wgcyryxx wgcyryxx_bak = new Wgcyryxx();
		qyryxx_bak.setRyid(qyryxx.getRyid());
		wgcyryxx_bak.setRyid(qyryxx.getRyid());
		qyryxx_bak = qyryxxDao.getQyryxx(qyryxx_bak);
		wgcyryxx_bak = wgcyryxxDao.getWgcyryxx(wgcyryxx_bak);
		if(qyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, qyryxx_bak);
		if(wgcyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, wgcyryxx_bak);
		qyryxx_lsxx.setCzlx(qyryxx.getCzlx());
		qyryxx_lsxxDao.insertQyryxx_lsxx(qyryxx_lsxx);
		//修改从业人员信息
		qyryxx.setBcsj(currentDate);
		qyryxxDao.updateQyryxx(qyryxx);

		//人员信息操作日志
		Qyjbxx qyjbxx  = new Qyjbxx();
		Qyryxx qyryxxTemp = new Qyryxx();
		qyryxxTemp.setRyid(qyryxx.getRyid());
		qyryxxTemp = qyryxxDao.getQyryxx(qyryxxTemp);
		qyjbxx.setQyid(qyryxxTemp.getQyid());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		Ryxxczrz ryxxczrz = new Ryxxczrz();
		ryxxczrz.setCzsj(currentDate);
		ryxxczrz.setCzlx(qyryxx.getCzlx());
		ryxxczrz.setCzr(qyryxx.getCzr());
		ryxxczrz.setQybm(qyjbxx.getQybm());
		ryxxczrz.setCyrybh(qyryxxTemp.getCyrybh());
		ryxxczrzDao.insertRyxxczrz(ryxxczrz);

		isSuccess = true;
		return isSuccess;
	}
	/** @param 娱乐场所基本信息(qyryxx:ryid,czr)  人员提交 */
	public boolean updateQyryxxTj(List qyryxxList) throws Exception
	{
		boolean isSuccess = false;
		
		Qyryxx qyryxx = new Qyryxx();
		Qyryxx qyryxxBak = null;
		if(qyryxxList!=null)
		{
			String ryhcdxkg = QjblUtil.queryQjblVal("ryhcdxkg");//人员核查单项开关 0-关 1-开（人员提交时状态置为核查）
			for(int i=0;i<qyryxxList.size();i++)
			{
				qyryxx = (Qyryxx)qyryxxList.get(i);
				qyryxxBak = new Qyryxx();
				qyryxxBak.setRyid(qyryxx.getRyid());
				qyryxxBak = qyryxxDao.getQyryxx(qyryxxBak);
				if(qyryxxBak!=null)
				{
					if(qyryxxBak.getZt()!=null)
					{
						if(!"1".equals(ryhcdxkg))
						{
							//境外从业人员提交时，人员状态置为已核查（zt=1）
							if("0".equals(qyryxxBak.getCyrylbdm()))
							{
								if(qyryxxBak.getZt().equals("0"))
								{
									qyryxx.setZt("6");
									qyryxx.setCzlx("人员提交");
									isSuccess = updateQyryxxOnly(qyryxx);
								}
								else if(qyryxxBak.getZt().equals("3"))
								{
									qyryxx.setZt("7");
									qyryxx.setCzlx("人员提交");
									isSuccess = updateQyryxxOnly(qyryxx);
								}
							}
							else if("1".equals(qyryxxBak.getCyrylbdm()))
							{
								qyryxx.setZt("1");
								qyryxx.setCzlx("人员提交");
								isSuccess = updateQyryxxOnly(qyryxx);
							}
						}
						else
						{
							qyryxx.setZt("1");
							qyryxx.setCzlx("人员提交");
							isSuccess = updateQyryxxOnly(qyryxx);
						}
					}
				}
				qyryxxBak = null;
			}
		}
		return isSuccess;
	}
	
	/** @param 娱乐场所基本信息(qyryxx 存放页面查询参数及lrdwbm和czr,hylbdm)  人员全部提交 */
	public boolean updateQyryxxQbtj(Qyryxx qyryxxOrigin) throws Exception
	{
		boolean isSuccess = false;
		List qyryxxList = new ArrayList();
		qyryxxList = qyryxxDao.getWtjListQyryxx(qyryxxOrigin);
		Qyryxx qyryxx = new Qyryxx();
		Qyryxx qyryxxBak = null;
		if(qyryxxList!=null)
		{
			String ryhcdxkg = QjblUtil.queryQjblVal("ryhcdxkg");//人员核查单项开关 0-关 1-开（人员提交时状态置为核查）
			for(int i=0;i<qyryxxList.size();i++)
			{
				qyryxx = (Qyryxx)qyryxxList.get(i);
				qyryxxBak = new Qyryxx();
				qyryxxBak.setRyid(qyryxx.getRyid());
				qyryxxBak = qyryxxDao.getQyryxx(qyryxxBak);
				if(qyryxxBak!=null)
				{
					if(qyryxxBak.getZt()!=null)
					{
						if(!"1".equals(ryhcdxkg))
						{
							if("0".equals(qyryxxBak.getCyrylbdm()))
							{
								if(qyryxxBak.getZt().equals("0"))
								{
									qyryxx.setZt("6");
									qyryxx.setCzlx("人员提交");
									qyryxx.setCzr(qyryxxOrigin.getCzr());
									isSuccess = updateQyryxxOnly(qyryxx);
								}
								else if(qyryxxBak.getZt().equals("3"))
								{
									qyryxx.setZt("7");
									qyryxx.setCzlx("人员提交");
									qyryxx.setCzr(qyryxxOrigin.getCzr());
									isSuccess = updateQyryxxOnly(qyryxx);
								}
							}
							else
							{
								qyryxx.setZt("1");
								qyryxx.setCzlx("人员提交");
								qyryxx.setCzr(qyryxxOrigin.getCzr());
								isSuccess = updateQyryxxOnly(qyryxx);
							}
						}
						else
						{
							qyryxx.setZt("1");
							qyryxx.setCzlx("人员提交");
							isSuccess = updateQyryxxOnly(qyryxx);
						}
					}
					
				}
				qyryxxBak = null;
			}
		}
		return isSuccess;
	}

	/** @param 企业人员信息(t_qyryxx) 查询单条 */
	public Qyryxx getQyryxx(Qyryxx qyryxx){
		// TODO: implement
		return (Qyryxx)qyryxxDao.getQyryxx(qyryxx);
	}

	/** @param 企业人员信息(t_qyryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyryxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业人员信息(t_qyryxx) 多条查询 */
	public List getListQyryxx(Qyryxx qyryxx){
		// TODO: implement
		return qyryxxDao.getListQyryxx(qyryxx);
	}
	
	/** @param 企业人员信息(t_qyryxx) 多条查询 获得需进行公安人口库比对的人员*/
	public List getDhdQyryxxList(Qyryxx qyryxx)
	{
		return qyryxxDao.getDhdQyryxxList(qyryxx);
	}

	public IQyryxxDao getQyryxxDao() {
		return qyryxxDao;
	}

	public void setQyryxxDao(IQyryxxDao qyryxxDao) {
		this.qyryxxDao = qyryxxDao;
	}
	public IQyryxx_lsxxDao getQyryxx_lsxxDao() {
		return qyryxx_lsxxDao;
	}

	public void setQyryxx_lsxxDao(IQyryxx_lsxxDao qyryxx_lsxxDao) {
		this.qyryxx_lsxxDao = qyryxx_lsxxDao;
	}

	public IRyxxczrzDao getRyxxczrzDao() {
		return ryxxczrzDao;
	}

	public void setRyxxczrzDao(IRyxxczrzDao ryxxczrzDao) {
		this.ryxxczrzDao = ryxxczrzDao;
	}

	public IWgcyryxxDao getWgcyryxxDao() {
		return wgcyryxxDao;
	}

	public void setWgcyryxxDao(IWgcyryxxDao wgcyryxxDao) {
		this.wgcyryxxDao = wgcyryxxDao;
	}

	public IQyjbxxDao getQyjbxxDao() {
		return qyjbxxDao;
	}

	public void setQyjbxxDao(IQyjbxxDao qyjbxxDao) {
		this.qyjbxxDao = qyjbxxDao;
	}


	public Qyryxx getHjdxzqh(Qyryxx qyryxx) {
		// TODO Auto-generated method stub
		String hjdxzqh = "";
		String hjdxzqhdm = "";
		if(qyryxx != null)
		{
			if(qyryxx.getZjhm()!=null)
			{
				if(qyryxx.getZjhm().length()>=6)
				{
					qyryxx.setZjhm(qyryxx.getZjhm().substring(0, 6));
					qyryxx = qyryxxDao.getHjdxzqh(qyryxx);
				}
			}
		}
		if(qyryxx == null)
			qyryxx = new Qyryxx();
		if(qyryxx.getHjdxzqh()==null)
			qyryxx.setHjdxzqh(hjdxzqh);
		if(qyryxx.getHjdxzqhdm()==null)
			qyryxx.setHjdxzqhdm(hjdxzqhdm);
		return qyryxx;
	}

	public List getIsQyryxxExist(Qyryxx qyryxx) {
		// TODO Auto-generated method stub
		List qyryxxList  = new ArrayList();
		Map map = new HashMap();
		if(qyryxx != null)
		{
			map.put("zjhm", qyryxx.getZjhm());
			if(qyryxx.getRyid()!=null)
			{
				map.put("ryid", qyryxx.getRyid());
			}
		}
		qyryxxList = qyryxxDao.getIsQyryxxExist(map);
		return qyryxxList;
	}

	public Page getListCfForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return qyryxxDao.getListCfForPage(map, pageNo, pageSize, sort, desc);
	}

	public Page getListGadForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return qyryxxDao.getListGadForPage(map, pageNo, pageSize, sort, desc);
	}



	public Page getListQydForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return qyryxxDao.getListQydForPage(map, pageNo, pageSize, sort, desc);
	}

	public Page getQyryxxListByCsidForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return qyryxxDao.getQyryxxListByCsidForPage(map, pageNo, pageSize, sort, desc);
	}
	public Page getQyryxxListQydDictForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return qyryxxDao.getQyryxxListQydDictForPage(map, pageNo, pageSize, sort, desc);
	}

	public Page getScListGadForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return qyryxxDao.getScListGadForPage(map,pageNo,pageSize,sort,desc);
	}
	
	public Page getBgListGadForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return qyryxxDao.getBgListGadForPage(map,pageNo,pageSize,sort,desc);
	}




	/** @param 从业人员信息(t_cyryxx) 修改 公用服务*/
	public boolean updateQyryxxCommon(Qyryxx qyryxx) throws Exception {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		Date currentDate = new Date();
		//保存人员历史信息
		Qyryxx_lsxx qyryxx_lsxx = new Qyryxx_lsxx();
		Qyryxx qyryxx_bak = new Qyryxx();
		Wgcyryxx wgcyryxx_bak = new Wgcyryxx();
		qyryxx_bak.setRyid(qyryxx.getRyid());
		wgcyryxx_bak.setRyid(qyryxx.getRyid());
		qyryxx_bak = qyryxxDao.getQyryxx(qyryxx_bak);
		wgcyryxx_bak = wgcyryxxDao.getWgcyryxx(wgcyryxx_bak);
		if(qyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, qyryxx_bak);
		if(wgcyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, wgcyryxx_bak);
		qyryxx_lsxx.setCzlx(qyryxx.getCzlx());
		qyryxx_lsxxDao.insertQyryxx_lsxx(qyryxx_lsxx);
		//修改从业人员信息
		qyryxxDao.updateQyryxx(qyryxx);
			//更新账号
			String errCode="0";
			errCode = updateUser( qyryxx, qyryxx_bak);
			if(errCode.equals("1")) return false;
		
		
		//人员信息操作日志
		Qyjbxx qyjbxx  = new Qyjbxx();
		Qyryxx qyryxxTemp = new Qyryxx();
		qyryxxTemp.setRyid(qyryxx.getRyid());
		qyryxxTemp = qyryxxDao.getQyryxx(qyryxxTemp);
		qyjbxx.setQyid(qyryxxTemp.getQyid());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		Ryxxczrz ryxxczrz = new Ryxxczrz();
		ryxxczrz.setCzsj(currentDate);
		ryxxczrz.setCzlx(qyryxx.getCzlx());
		ryxxczrz.setCzr(qyryxx.getCzr());
		ryxxczrz.setQybm(qyjbxx.getQybm());
		ryxxczrz.setCyrybh(qyryxxTemp.getCyrybh());
		ryxxczrzDao.insertRyxxczrz(ryxxczrz);

		isSuccess = true;
		return isSuccess;
	}

	/** @param 从业人员信息(t_cyryxx) 注销 */
	public boolean updateQyryxxZx(Qyryxx qyryxx) throws Exception {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		Date currentDate = new Date();
		//保存人员历史信息
		Qyryxx_lsxx qyryxx_lsxx = new Qyryxx_lsxx();
		Qyryxx qyryxx_bak = new Qyryxx();
		Wgcyryxx wgcyryxx_bak = new Wgcyryxx();
		qyryxx_bak.setRyid(qyryxx.getRyid());
		wgcyryxx_bak.setRyid(qyryxx.getRyid());
		qyryxx_bak = qyryxxDao.getQyryxx(qyryxx_bak);
		wgcyryxx_bak = wgcyryxxDao.getWgcyryxx(wgcyryxx_bak);
		if(qyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, qyryxx_bak);
		if(wgcyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, wgcyryxx_bak);
		qyryxx_lsxx.setCzlx("注销");
		qyryxx_lsxxDao.insertQyryxx_lsxx(qyryxx_lsxx);
		//修改从业人员信息
		qyryxx.setZxbz("1");
		qyryxx.setZxsj(currentDate);
		qyryxxDao.updateQyryxx(qyryxx);

		//人员信息操作日志
		Qyjbxx qyjbxx  = new Qyjbxx();
		qyjbxx.setQyid(qyryxx.getQyid());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		Ryxxczrz ryxxczrz = new Ryxxczrz();
		ryxxczrz.setCzsj(currentDate);
		ryxxczrz.setCzlx("注销");
		ryxxczrz.setCzr(qyryxx.getZxr());
		ryxxczrz.setQybm(qyjbxx.getQybm());
		ryxxczrz.setCyrybh(qyryxx.getCyrybh());
		ryxxczrzDao.insertRyxxczrz(ryxxczrz);
		
		//更新场所总人数
		//if(!cyryxx_bak.getCsid().equals(cyryxx.getCsid()))
		//{
		Map map = new HashMap();
		map.put("p_oldQyid", qyryxx_bak.getQyid());
		map.put("p_newQyid", 0);
		qyZrsProcDao.updateQyzrs(map);
		//}
		
		 ////注销员工用户
		int errResult = 0;	
		if(sczhFlag(qyryxx_bak.getHylbdm(),qyryxx_bak.getGwbh()).equals("1")){
				if(getUser(qyryxx_bak.getCyrybh()).equals("1")){
					GgQyyh qyyh = new GgQyyh();
					qyyh.setRyid(qyryxx.getRyid());
					qyyh.setIsval("0"); //是否可见
					errResult =ggQyyhDao.zhuxQyYgyh(qyyh); 
				 }
		}

		if(errResult==1){
			return false;
		}
		isSuccess = true;
		return isSuccess;
	}
	/** @param 从业人员信息(t_cyryxx) 注销恢复 */
	public boolean updateQyryxxZxhf(Qyryxx qyryxx) throws Exception{
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		Date currentDate = new Date();
		//保存人员历史信息
		Qyryxx_lsxx qyryxx_lsxx = new Qyryxx_lsxx();
		Qyryxx qyryxx_bak = new Qyryxx();
		Wgcyryxx wgcyryxx_bak = new Wgcyryxx();
		qyryxx_bak.setRyid(qyryxx.getRyid());
		wgcyryxx_bak.setRyid(qyryxx.getRyid());
		qyryxx_bak = qyryxxDao.getQyryxx(qyryxx_bak);
		wgcyryxx_bak = wgcyryxxDao.getWgcyryxx(wgcyryxx_bak);
		if(qyryxx_bak!=null)
				BeanUtils.copyProperties(qyryxx_lsxx, qyryxx_bak);
		if(wgcyryxx_bak!=null)
			BeanUtils.copyProperties(qyryxx_lsxx, wgcyryxx_bak);
		qyryxx_lsxx.setCzlx("注销恢复");
		qyryxx_lsxxDao.insertQyryxx_lsxx(qyryxx_lsxx);
		//修改从业人员信息
		qyryxx.setZxbz("0");
		qyryxx.setZxsj(currentDate);//将注销恢复时间保存在此
		qyryxx.setZxr("");
		qyryxx.setZxyy("");
		qyryxxDao.updateQyryxx(qyryxx);

		//人员信息操作日志
		Qyjbxx qyjbxx  = new Qyjbxx();
		qyjbxx.setQyid(qyryxx.getQyid());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		Ryxxczrz ryxxczrz = new Ryxxczrz();
		ryxxczrz.setCzsj(currentDate);
		ryxxczrz.setCzlx("注销恢复");
		ryxxczrz.setCzr(qyryxx.getCzr());
		ryxxczrz.setQybm(qyjbxx.getQybm());
		ryxxczrz.setCyrybh(qyryxx.getCyrybh());
		ryxxczrzDao.insertRyxxczrz(ryxxczrz);
		
		//更新场所总人数


		Map map = new HashMap();
		map.put("p_oldQyid", 0);
		map.put("p_newQyid", qyryxx_bak.getQyid());
		qyZrsProcDao.updateQyzrs(map);
		
		
		int errResult = 0;
		//回复注销员工用户
			if(sczhFlag(qyryxx_bak.getHylbdm(),qyryxx_bak.getGwbh()).equals("1")){
				if(getUser(qyryxx_bak.getCyrybh()).equals("1")){
					GgQyyh qyyh = new GgQyyh();
					qyyh.setRyid(qyryxx.getRyid());
					qyyh.setIsval("1"); //是否可见
					errResult =ggQyyhDao.zhuxQyYgyh(qyyh); 
				}
			}
		
	
		if(errResult==1){
			return false;
		}
		
		
		isSuccess = true;
		return isSuccess;
	}

	
	public boolean makeCyryxxLizhiByqyZx(Qyjbxx qyjbxx) throws Exception{
		// TODO Auto-generated method stub
		
		
		Qyryxx qyryxx = new Qyryxx();
		qyryxx.setQyid(qyjbxx.getQyid());
		List rylist = qyryxxDao.getMakeRyLzList(qyryxx);
		
	    if(rylist!=null && rylist.size()>0){
	    	//更新企业下的员工离职状态和离职时间
	    	qyryxx.setLzrq(new Date());
	    	qyryxx.setCyryztdm("20");
	    	qyryxx.setCyryzt("离职");
	    	qyryxxDao.updateQyryxxLzByqyzxGg(qyryxx);
	    	Qyryxx_lsxx qyryxx_lsxx = new Qyryxx_lsxx();
			Qyryxx qyryxxbak = new Qyryxx();
			int errResult = 0;
			for(int i=0;i<rylist.size();i++){
				qyryxxbak = (Qyryxx)rylist.get(i);
				if(qyryxxbak!=null)
				{
					BeanUtils.copyProperties(qyryxx_lsxx, qyryxxbak);
				}
				qyryxx_lsxx.setCzlx("公司注销员工离职");
				qyryxx_lsxxDao.insertQyryxx_lsxx(qyryxx_lsxx);
				//操作日志
				Ryxxczrz ryxxczrz = new Ryxxczrz();
				ryxxczrz.setCzsj(new Date());
				ryxxczrz.setCzlx("公司注销员工离职");
				
				ryxxczrz.setCzr(qyjbxx.getCzr());
				ryxxczrz.setCyrybh(qyryxxbak.getCyrybh());
				ryxxczrz.setQybm(qyjbxx.getQybm());
				ryxxczrzDao.insertRyxxczrz(ryxxczrz);
				//注销员工用户
				
					if(sczhFlag(qyryxxbak.getHylbdm(),qyryxxbak.getGwbh()).equals("1")){
						if(getUser(qyryxxbak.getCyrybh()).equals("1")){
							GgQyyh qyyh = new GgQyyh();
							qyyh.setRyid(qyryxxbak.getRyid());
							qyyh.setIsval("0"); //是否可见
							errResult =ggQyyhDao.zhuxQyYgyh(qyyh);
							if(errResult==1){
								return false;
							}
						 }
						}
				
			}
	    }
	    return true;
		
	}
	
	/** @param 从业人员信息(t_qyryxx) 多条查询 获得已进行公安人口库比对的人员（人员状态为1、4、5的记录）*/
	public List getYhcCyryxxList(Qyryxx qyryxx)
	{
		return qyryxxDao.getYhcCyryxxList(qyryxx);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  采集点提交*/
	public Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryxxDao.getWtjListForPage(map, pageNo, pageSize, sort, desc);
	}

	public IQyry_zpDao getQyry_zpDao() {
		return qyry_zpDao;
	}

	public void setQyry_zpDao(IQyry_zpDao qyry_zpDao) {
		this.qyry_zpDao = qyry_zpDao;
	}

	public IScbmDao getScbmDao() {
		return scbmDao;
	}

	public void setScbmDao(IScbmDao scbmDao) {
		this.scbmDao = scbmDao;
	}

	public IQyZrsProcDao getQyZrsProcDao() {
		return qyZrsProcDao;
	}

	public void setQyZrsProcDao(IQyZrsProcDao qyZrsProcDao) {
		this.qyZrsProcDao = qyZrsProcDao;
	}

	public IRyjcxxDao getRyjcxxDao() {
		return ryjcxxDao;
	}

	public void setRyjcxxDao(IRyjcxxDao ryjcxxDao) {
		this.ryjcxxDao = ryjcxxDao;
	}

	public IQyryxxhcDao getQyryxxhcDao() {
		return qyryxxhcDao;
	}

	public void setQyryxxhcDao(IQyryxxhcDao qyryxxhcDao) {
		this.qyryxxhcDao = qyryxxhcDao;
	}

	public IQyry_tjxxDao getQyry_tjxxDao() {
		return qyry_tjxxDao;
	}

	public void setQyry_tjxxDao(IQyry_tjxxDao qyry_tjxxDao) {
		this.qyry_tjxxDao = qyry_tjxxDao;
	}

//	public IQyryshService getQyryshService() {
//		return qyryshService;
//	}
//
//	public void setQyryshService(IQyryshService qyryshService) {
//		this.qyryshService = qyryshService;
//	}

	public IGarkktbsjService getGarkktbsjService() {
		return garkktbsjService;
	}

	public void setGarkktbsjService(IGarkktbsjService garkktbsjService) {
		this.garkktbsjService = garkktbsjService;
	}

	public IQyryxxhcService getQyryxxhcService() {
		return qyryxxhcService;
	}

	public void setQyryxxhcService(IQyryxxhcService qyryxxhcService) {
		this.qyryxxhcService = qyryxxhcService;
	}

	public IGgQyyhDao getGgQyyhDao() {
		return ggQyyhDao;
	}

	public void setGgQyyhDao(IGgQyyhDao ggQyyhDao) {
		this.ggQyyhDao = ggQyyhDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IQyryshDao getQyryshDao() {
		return qyryshDao;
	}


	public void setQyryshDao(IQyryshDao qyryshDao) {
		this.qyryshDao = qyryshDao;
	}
	
	/** @param 企业人员信息导出标识(t_qyryxx) 修改 */
	public boolean updateQyryxxDcgs(Qyryxx qyryxx)throws Exception {
		return qyryxxDao.updateQyryxx(qyryxx)>0;
	}
	
}
