package com.aisino2.publicsystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.common.QjblUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.icksystem.dao.IIckslDao;
import com.aisino2.icksystem.dao.IIcksl_ickzbDao;
import com.aisino2.icksystem.dao.IIcksl_wldjDao;
import com.aisino2.icksystem.dao.IQyryskxxtjDao;
import com.aisino2.icksystem.dao.IZzzxscDao;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Zzzxsc;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.publicsystem.dao.ICyryxxDao;
import com.aisino2.publicsystem.dao.IQyZrsProcDao;
import com.aisino2.publicsystem.dao.IQyjbxxDao;
import com.aisino2.publicsystem.dao.IQyry_tjxxDao;
import com.aisino2.publicsystem.dao.IQyry_zpDao;
import com.aisino2.publicsystem.dao.IQyryxxDao;
import com.aisino2.publicsystem.dao.IQyryxx_lsxxDao;
import com.aisino2.publicsystem.dao.IQyryxxhcDao;
import com.aisino2.publicsystem.dao.IRyxxczrzDao;
import com.aisino2.publicsystem.dao.IWgcyryxxDao;
import com.aisino2.publicsystem.domain.Garkktbsj;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;
import com.aisino2.publicsystem.domain.Qyryxxhc;
import com.aisino2.publicsystem.domain.Ryxxczrz;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.ICyryxxService;
import com.aisino2.publicsystem.service.IGarkktbsjService;
import com.aisino2.publicsystem.service.IQyryshService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IQyryxxhcService;

public class CyryxxServiceImpl extends BaseService implements ICyryxxService {

	private ICyryxxDao cyryxxtjDao;
	private IQyry_zpDao qyry_zpDao;
	private IWgcyryxxDao wgcyryxxDao;
	private IRyxxczrzDao ryxxczrzDao;
	private IQyryxx_lsxxDao qyryxx_lsxxDao;
	private IScbmDao scbmDao;
	private IQyZrsProcDao qyZrsProcDao;
	private IQyjbxxDao qyjbxxDao;
	private IIckslDao ickslDao;
	private IZzzxscDao zzzxscDao;
	private IIckslService ickslService;

	private IQyryxxhcDao qyryxxhcDao;
	private IQyry_tjxxDao qyry_tjxxDao;
	private IIcksl_wldjDao icksl_wldjDao;
	private IIcksl_ickzbDao icksl_ickzbDao;
	private IQyryskxxtjDao qyryskxxtjDao;
	private IQyryshService qyryshService;
	private IGarkktbsjService garkktbsjService;
	private IQyryxxhcService qyryxxhcService;
	private IQyryxxDao qyryxxDao;
	private IQyryxxService qyryxxService;
	
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
		qyjbxx.setQybm(qyryxx.getQybm());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		qyryxx.setQyid(qyjbxx.getQyid()); //企业端相当于采集点 获取不到QYID
		//得到从业人员编号
		//新从业人员编号生辰规则 ：企业编码前位+8位年份+4位流水号 (modified by mds at 20100120)
		Map scbmMap = new HashMap();
		scbmMap.put("p_bmfl", "RY");
		scbmMap.put("p_xzqh", qyjbxx.getQybm().substring(0, 9));
		String sssf = QjblUtil.queryQjblVal("sssf");


		/*if(qyryxx.getSssf()!=null)
			if(!"".equals(qyryxx.getSssf()))
				sssf = qyryxx.getSssf();*/
		scbmMap.put("p_sssf", sssf);
		scbmMap.put("p_scgz", 2);
		//若前台传入的cyrybh为空，则调用编码生成程序生成编码。


		if(qyryxx.getCyrybh()==null||"".equals(qyryxx.getCyrybh()))
			qyryxx.setCyrybh(scbmDao.getScbm(scbmMap));
		//增加从业人员信息表

		qyryxx.setHylbdm(qyjbxx.getHylbdm());
		qyryxx.setHylb(qyjbxx.getHylb());
		qyryxx.setScbz(0);
		qyryxx.setZxbz("0");
		qyryxx.setBiduiflag("0");//未比对

		qyryxx.setXmpy(PinYinUtil.getHanyuPingYin(qyryxx.getXm()));
		qyryxx.setLrsj(currentDate);
		qyryxx.setCyryztdm("10");//人员状态默认离职

		qyryxx.setCyryzt("在职");
		
		//增加从业人员信息表


		if("0".equals(qyryxx.getCyrylbdm()))
		{
			qyryxx.setCyzjdm("111");
			qyryxx.setCyzj("公民身份号码");
			qyryxx.setGjdm("CHN");
			qyryxx.setGj("中国");
			if(qyryxx.getZjzt()!=null)
			{
				if(!"90".equals(qyryxx.getZt())){
					if("0".equals(qyryxx.getZjzt()))//公民身份号码符合校验规则
					{
						qyryxx.setZt("0");
					}else
						qyryxx.setZt("5");
				}
			}else {
				qyryxx.setZt("0");
			}
		}else
		{
			if(!"90".equals(qyryxx.getZt())){
				//若为境外从业人员,则姓名字段为英文名+" "+英文姓
				//qyryxx.setXm(qyryxx.getWgcyryxx().getYwm()+" "+qyryxx.getWgcyryxx().getYwx());
				qyryxx.setZt("0");
			}
		}
		qyryxxNew = qyryxxDao.insertQyryxx(qyryxx);
		
		if(qyryxx.getQyry_zp()==null)
			qyry_zp = new Qyry_zp();
		else
			qyry_zp = qyryxx.getQyry_zp();
		
		qyry_zp.setRyid(qyryxxNew.getRyid());
		qyry_zp.setQyid(qyryxxNew.getQyid());
		qyry_zp.setTplx("0");
		qyry_zp = qyry_zpDao.insertQyry_zp(qyry_zp);
			
		//增加外国从业人员信息表


		if(qyryxx.getWgcyryxx()!=null)
		{
			wgcyryxx = qyryxx.getWgcyryxx();
			wgcyryxx.setRyid(qyryxxNew.getRyid());
			wgcyryxx.setQyid(qyryxxNew.getQyid());
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
		
		
		return qyryxxNew;	
		
	}

	/** @param 从业人员信息(t_qyryxx) 修改 */
	public boolean updateQyryxx(Qyryxx qyryxx) throws Exception{
		// TODO: implement
		//return cyryxxDao.updateQyryxx(qyryxx)>0;
		boolean isSuccess = false;
		Date currentDate = new Date();
		Qyry_zp cyry_zp = new Qyry_zp();
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

			//qyryxx.setXm(qyryxx.getWgcyryxx().getYwm()+" "+qyryxx.getWgcyryxx().getYwx());
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
		
		//马志勇修改start
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
				cyry_zp = qyryxx.getQyry_zp();
				cyry_zp.setRyid(qyryxx.getRyid());
				cyry_zp.setQyid(qyryxx.getQyid());
				cyry_zp=qyry_zpDao.insertQyry_zp(cyry_zp);
				qyryxx.setZpid(cyry_zp.getZpid());
			}else{
				//有，更新
				cyry_zp = qyryxx.getQyry_zp();
				cyry_zp.setRyid(qyryxx.getRyid());
				if(zpidfalg==1){
					cyry_zp.setZpid(qyryxx.getZpid());
				}
				qyry_zpDao.updateQyry_zp(cyry_zp);
				
			}
		}
		//end
	
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
		
		//若该人员目前存在有效的受理记录，且当前制卡状态为11质量(回馈照片不合格)，则：

		//1 采用金盾制卡端时 zkztbs置为1( IC卡受理已结束)
		//2 采用外包制卡端时 zkztbs置为1，且t_zzzxsc表的sjscbz(数据上传标志)=0未上传制证中心 
		Icksl icksl =new Icksl();
		Zzzxsc zzzxsc = new Zzzxsc();
		List ickslExistList = new ArrayList();
		icksl.setRyid(qyryxx.getRyid());
		ickslExistList = ickslDao.getIckslExist(icksl);
		if(ickslExistList != null)
		{
			for(int i = 0;i<ickslExistList.size();i++)
			{
				icksl = null;
				icksl =new Icksl();
				icksl = (Icksl)ickslExistList.get(i);
				if("11".equals(icksl.getZkztbs()))
				{
					icksl.setZkztbs("1");
					icksl.setCzr(qyryxx.getCzr());
					ickslService.updateIcksl(icksl);
				
					//采用外包制证中心。 2009-07-28修改：由于每次发送到制卡中心都要在t_zzzxsc中新增一条记录，所以无需再修改sjscbz,原来的记录可作为历史信息，以标识该卡被发送到制证中心的次数

					/*if("1".equals(qyryxx.getJdzkd()))
					{
						zzzxsc.setRyid(qyryxx.getRyid());
						zzzxsc.setIckslid(icksl.getIckslid());
						zzzxsc.setSjscbz("0");
						zzzxscDao.updateZzzxsc(zzzxsc);
					}*/
				}
			}
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
		qyjbxx.setQyid(qyryxx_bak.getQyid());
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
	
	/** @param 从业人员信息(t_qyryxx) 修改与t_qyryxx表有直接或间接外键关联的所有表的qyid,但不包括人员历史表和IC卡受理变更表 */
	public boolean updateQyryxxForeignKey(Qyryxx qyryxx,Qyryxx qyryxx_bak)
	{
		boolean isSuccess = false;
		int ryid=qyryxx_bak.getRyid();
		int qyid = qyryxx_bak.getQyid();
		
		isSuccess = qyryxxService.updateQyryxxForeignKey(qyryxx, qyryxx_bak);
		
		Icksl icksla = new Icksl();
		icksla.setRyid(ryid);
		icksla.setZxbz("0");
		icksla =ickslDao.getIckslyj(icksla);//拿出这个ryid的最后的icksl记录
		if(icksla!=null)
		{
			Icksl ickslgx = new Icksl();
			ickslgx.setIckslid(icksla.getIckslid());
			Qyjbxx qyjbxx = new Qyjbxx();
			qyjbxx.setQyid(qyryxx.getQyid());
			qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
			ickslgx.setQybm(qyjbxx.getQybm());
			ickslgx.setQyid(qyryxx.getQyid());
			ickslgx.setRyid(qyryxx.getRyid());
			ickslgx.setHylbdm(qyryxx.getHylbdm());
			ickslgx.setHylb(qyryxx.getHylb());
			isSuccess = (ickslDao.updateIckslByqybg(ickslgx)>0)&&isSuccess;
		}
	
		return isSuccess;
	}
	
	/** @param 从业人员信息(t_qyryxx) 删除 */
	public boolean deleteQyryxx(Qyryxx qyryxx) throws Exception
	{
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
		
		return isSuccess;
	}
	
	/** @param 从业人员信息(t_qyryxx) 注销 */
	public boolean updateQyryxxZx(Qyryxx qyryxx) throws Exception
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
		qyryxx_lsxx.setCzlx("注销");
		qyryxx_lsxxDao.insertQyryxx_lsxx(qyryxx_lsxx);
		//修改从业人员信息
		qyryxx.setZxbz("1");
		qyryxx.setZxsj(currentDate);
		qyryxxDao.updateQyryxx(qyryxx);

		//人员信息操作日志
		Qyjbxx qyjbxx  = new Qyjbxx();
		qyjbxx.setQyid(qyryxx_bak.getQyid());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		Ryxxczrz ryxxczrz = new Ryxxczrz();
		ryxxczrz.setCzsj(currentDate);
		ryxxczrz.setCzlx("注销");
		ryxxczrz.setCzr(qyryxx.getZxr());
		ryxxczrz.setQybm(qyjbxx.getQybm());
		ryxxczrz.setCyrybh(qyryxx_bak.getCyrybh());
		ryxxczrzDao.insertRyxxczrz(ryxxczrz);
		
		//更新场所总人数

		//if(!qyryxx_bak.getQyid().equals(qyryxx.getQyid()))
		//{
			Map map = new HashMap();
			map.put("p_oldQyid", qyryxx_bak.getQyid());
			map.put("p_newQyid", 0);
			qyZrsProcDao.updateQyzrs(map);
		//}
		
		//若该人员的IC卡已发放，则注销IC卡。
		Icksl icksl =new Icksl();
		Zzzxsc zzzxsc = new Zzzxsc();
		List ickslExistList = new ArrayList();
		icksl.setRyid(qyryxx.getRyid());
		ickslExistList = ickslDao.getIckslExist(icksl);
		if(ickslExistList != null)
		{
			for(int i = 0;i<ickslExistList.size();i++)
			{
				icksl = null;
				icksl =new Icksl();
				icksl = (Icksl)ickslExistList.get(i);
				if("6".equals(icksl.getZkztbs()))
				{
					icksl.setZkztbs("8");
					icksl.setIckzxr(qyryxx.getZxr());
					icksl.setIckzxyy("人注销");
					icksl.setCzlx("人注销");
					ickslService.updateIckslZx(icksl);
				}
			}
		}
		isSuccess = true;
		return isSuccess;
	}
	
	/** @param 娱乐场所基本信息(qyryxx:ryid,czr)  采集点提交 */
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
									qyryxx.setCzlx("采集点提交");
									isSuccess = qyryxxService.updateQyryxxOnly(qyryxx);
								}
								else if(qyryxxBak.getZt().equals("3"))
								{
									qyryxx.setZt("7");
									qyryxx.setCzlx("采集点提交");
									isSuccess = qyryxxService.updateQyryxxOnly(qyryxx);
								}
							}
							else if("1".equals(qyryxxBak.getCyrylbdm()))
							{
								qyryxx.setZt("1");
								qyryxx.setCzlx("采集点提交");
								isSuccess = qyryxxService.updateQyryxxOnly(qyryxx);
							}
						}
						else
						{
							qyryxx.setZt("1");
							qyryxx.setCzlx("采集点提交");
							isSuccess = qyryxxService.updateQyryxxOnly(qyryxx);
						}
					}
				}
				qyryxxBak = null;
			}
		}
		return isSuccess;
	}
	
	/** @param 娱乐场所基本信息(qyryxx 存放页面查询参数及lrdwbm和czr,hylbdm)  采集点全部提交 */
	public boolean updateQyryxxQbtj(Qyryxx qyryxxOrigin) throws Exception
	{
		boolean isSuccess = false;
		List qyryxxList = new ArrayList();
		qyryxxList = cyryxxtjDao.getWtjListQyryxx(qyryxxOrigin);
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
									qyryxx.setCzlx("采集点提交");
									qyryxx.setCzr(qyryxxOrigin.getCzr());
									isSuccess = qyryxxService.updateQyryxxOnly(qyryxx);
								}
								else if(qyryxxBak.getZt().equals("3"))
								{
									qyryxx.setZt("7");
									qyryxx.setCzlx("采集点提交");
									qyryxx.setCzr(qyryxxOrigin.getCzr());
									isSuccess = qyryxxService.updateQyryxxOnly(qyryxx);
								}
							}
							else
							{
								qyryxx.setZt("1");
								qyryxx.setCzlx("采集点提交");
								qyryxx.setCzr(qyryxxOrigin.getCzr());
								isSuccess = qyryxxService.updateQyryxxOnly(qyryxx);
							}
						}
						else
						{
							qyryxx.setZt("1");
							qyryxx.setCzlx("采集点提交");
							isSuccess = qyryxxService.updateQyryxxOnly(qyryxx);
						}
					}
					
				}
				qyryxxBak = null;
			}
		}
		return isSuccess;
	}
	
	/** @param 从业人员信息(t_qyryxx) 注销恢复 */
	public boolean updateQyryxxZxhf(Qyryxx qyryxx) throws Exception
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
		qyjbxx.setQyid(qyryxx_bak.getQyid());
		qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
		Ryxxczrz ryxxczrz = new Ryxxczrz();
		ryxxczrz.setCzsj(currentDate);
		ryxxczrz.setCzlx("注销恢复");
		ryxxczrz.setCzr(qyryxx.getCzr());
		ryxxczrz.setQybm(qyjbxx.getQybm());
		ryxxczrz.setCyrybh(qyryxx_bak.getCyrybh());
		ryxxczrzDao.insertRyxxczrz(ryxxczrz);
		
		//更新场所总人数

		Map map = new HashMap();
		map.put("p_oldQyid", 0);
		map.put("p_newQyid", qyryxx_bak.getQyid());
		qyZrsProcDao.updateQyzrs(map);
		isSuccess = true;
		return isSuccess;
	}
	
	
	/** @param 从业人员信息(t_qyryxx) 修改 派出所审核*//*
	public boolean updateQyryxxRysh_pcs(Qyryxx qyryxx) throws Exception
	{
		boolean isSuccess = false;
		try
		{
			Date currentDate = new Date();
			Qyryxx qyryxxOld = new Qyryxx();
			qyryxxOld.setRyid(qyryxx.getRyid());
			//qyryxxOld = cyryxxDao.getQyryxx(qyryxxOld);
			String sftg = qyryxx.getSftg();//审核是否通过标识 0-不通过 1-通过
			Qyrysh qyrysh = new Qyrysh();
			//场所状态 10-派出所审核通过 11-派出所审核失败
			if(sftg.equals("1"))
			{
				qyryxx.setZt("10");
			}
			else if(sftg.equals("0"))
			{
				qyryxx.setZt("11");
			}
			qyryxx.setCzlx("派出所审核");

			if(qyryxx.getQyrysh()!=null)
			{
				qyrysh = qyryxx.getQyrysh();
				qyrysh.setQyid(qyryxxOld.getQyid());
				qyrysh.setRyid(qyryxx.getRyid());
				qyrysh.setShsj(currentDate);
				//上级审核id取值：取上次审核(无论是派出所审核还是市局审核)记录的csshid
				qyrysh.setSjshid(qyryshService.getSjshid(qyrysh));
				qyrysh.setShzt("0");//审核状态 0-派出所审核 1-市局审核
				
				qyryxx.setCzr(qyrysh.getShr());
			}
			updateQyryxxCommon(qyryxx);
			qyryshService.insertQyrysh(qyrysh);

			isSuccess = true;
		}
		catch(Exception e)
		{
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	*//** @param 从业人员信息(t_qyryxx) 修改 市局审核*//*
	public boolean updateQyryxxRysh_sj(Qyryxx qyryxx) throws Exception
	{
		boolean isSuccess = false;
		try
		{
			Date currentDate = new Date();
			Qyryxx qyryxxOld = new Qyryxx();
			qyryxxOld.setRyid(qyryxx.getRyid());
			//qyryxxOld = cyryxxDao.getQyryxx(qyryxxOld);
			String sftg = qyryxx.getSftg();//审核是否通过标识 0-不通过 1-通过
			Qyrysh qyrysh = new Qyrysh();
			//场所状态 10-派出所审核通过 11-派出所审核失败
			if(sftg.equals("1"))
			{
				qyryxx.setZt("1");
			}
			else if(sftg.equals("0"))
			{
				qyryxx.setZt("13");
			}
			qyryxx.setCzlx("市局审核");

			if(qyryxx.getQyrysh()!=null)
			{
				qyrysh = qyryxx.getQyrysh();
				qyrysh.setQyid(qyryxxOld.getQyid());
				qyrysh.setRyid(qyryxx.getRyid());
				qyrysh.setShsj(currentDate);
				//上级审核id取值：取上次审核(无论是派出所审核还是市局审核)记录的csshid
				qyrysh.setSjshid(qyryshService.getSjshid(qyrysh));
				qyrysh.setShzt("1");//审核状态 0-派出所审核 1-市局审核
				
				qyryxx.setCzr(qyrysh.getShr());
			}
			updateQyryxxCommon(qyryxx);
			qyryshService.insertQyrysh(qyrysh);
			if(sftg.equals("1"))
			{
				//查询该人员是否已受理，且制卡状态为0(IC卡受理未结束)，若存在则制卡状态置为1(IC卡受理已结束)
				Icksl icksl = new Icksl();
				icksl.setRyid(qyryxx.getRyid());
				icksl.setZkztbs("0");
				icksl = ickslService.getIcksl(icksl);
				if(icksl != null)
				{
					icksl.setZkztbs("1");// IC卡受理已结束
					icksl.setCzlx("市局审核");
					icksl.setCzr(qyryxx.getCzr());
					ickslService.updateIcksl(icksl);
				}
			}
			isSuccess = true;
		}
		catch(Exception e)
		{
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}*/

	/** @param 从业人员信息(t_qyryxx) 分页查询 采集点查询*/
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return cyryxxtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  采集点提交*/
	public Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getWtjListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询 公安端 人员查询、注销查询*/
	public Page getListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return cyryxxtjDao.getListGadForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  公安端 派出所审核查询 市局审核查询*/
	public Page getListGadForPageRysh(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getListGadForPageRysh(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  企业端人员查询*/
	public Page getListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return cyryxxtjDao.getListQydForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  由场所ID或场所编码获得该场所下从业人员*/
	public Page getQyryxxListByQyidForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		//return cyryxxDao.getQyryxxListByQyidForPage(map,pageNo,pageSize,sort,desc);
		return null;
	}
	
	/** @param 从业人员信息(t_qyryxx) 多条查询 获得需进行公安人口库比对的人员(只比对国内人员)*/
	public List getDhdQyryxxList(Qyryxx qyryxx)
	{
		//return cyryxxDao.getDhdQyryxxList(qyryxx);
		return null;
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端国内人员历史查询 */
	public Page getCyryxx_lsxxListQydGnForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getCyryxx_lsxxListQydGnForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 从业人员信息核查(t_cyryxxhc) 分页查询 */
	public Page getCyryxxhcListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return cyryxxtjDao.getCyryxxhcListForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 采集点查询*/
	public Page getJwListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getJwListForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 人员查询、注销查询*/
	public Page getJwListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getJwListGadForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  公安端 派出所审核查询 市局审核查询*/
	public Page getJwListGadForPageRysh(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getJwListGadForPageRysh(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 企业人员查询*/
	public Page getJwListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getJwListQydForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 删除查询*/
	public Page getScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getScListGadForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 删除查询*/
	public Page getJwScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getJwScListGadForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端境外人员历史查询 */
	public Page getCyryxx_lsxxListQydJwForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getCyryxx_lsxxListQydJwForPage(map, pageNo, pageSize, sort, desc);
	}
	/** @param 从业人员信息(t_qyryxx) 分页查询  采集端台账 已采集人员查询*/
	public Page getYcjCyryListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return cyryxxtjDao.getYcjCyryListForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  根据江苏老版14位人员编号查询人员信息 20101109 mds*/
	public Page getQyryxxByOldcyrybh(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return cyryxxtjDao.getQyryxxByOldcyrybh(map, pageNo, pageSize, sort, desc);
	}

	public void setCyryxxtjDao(ICyryxxDao cyryxxDao) {
		this.cyryxxtjDao = cyryxxDao;
	}

	public void setQyry_zpDao(IQyry_zpDao qyry_zpDao) {
		this.qyry_zpDao = qyry_zpDao;
	}

	public void setWgcyryxxDao(IWgcyryxxDao wgcyryxxDao) {
		this.wgcyryxxDao = wgcyryxxDao;
	}

	public void setRyxxczrzDao(IRyxxczrzDao ryxxczrzDao) {
		this.ryxxczrzDao = ryxxczrzDao;
	}

	public void setQyryxx_lsxxDao(IQyryxx_lsxxDao qyryxx_lsxxDao) {
		this.qyryxx_lsxxDao = qyryxx_lsxxDao;
	}

	public void setScbmDao(IScbmDao scbmDao) {
		this.scbmDao = scbmDao;
	}

	public void setQyZrsProcDao(IQyZrsProcDao qyZrsProcDao) {
		this.qyZrsProcDao = qyZrsProcDao;
	}

	public void setQyjbxxDao(IQyjbxxDao qyjbxxDao) {
		this.qyjbxxDao = qyjbxxDao;
	}

	public void setIckslDao(IIckslDao ickslDao) {
		this.ickslDao = ickslDao;
	}

	public void setZzzxscDao(IZzzxscDao zzzxscDao) {
		this.zzzxscDao = zzzxscDao;
	}

	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}

	public void setQyryxxhcDao(IQyryxxhcDao qyryxxhcDao) {
		this.qyryxxhcDao = qyryxxhcDao;
	}

	public void setQyry_tjxxDao(IQyry_tjxxDao qyry_tjxxDao) {
		this.qyry_tjxxDao = qyry_tjxxDao;
	}

	public void setIcksl_wldjDao(IIcksl_wldjDao icksl_wldjDao) {
		this.icksl_wldjDao = icksl_wldjDao;
	}

	public void setIcksl_ickzbDao(IIcksl_ickzbDao icksl_ickzbDao) {
		this.icksl_ickzbDao = icksl_ickzbDao;
	}

	public void setQyryskxxtjDao(IQyryskxxtjDao qyryskxxtjDao) {
		this.qyryskxxtjDao = qyryskxxtjDao;
	}

	public void setQyryshService(IQyryshService qyryshService) {
		this.qyryshService = qyryshService;
	}

	public void setGarkktbsjService(IGarkktbsjService garkktbsjService) {
		this.garkktbsjService = garkktbsjService;
	}

	public void setQyryxxhcService(IQyryxxhcService qyryxxhcService) {
		this.qyryxxhcService = qyryxxhcService;
	}

	public void setQyryxxDao(IQyryxxDao qyryxxDao) {
		this.qyryxxDao = qyryxxDao;
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}
}
