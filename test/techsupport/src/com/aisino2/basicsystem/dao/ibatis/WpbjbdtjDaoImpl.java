package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IWpbjbdtjDao;
import com.aisino2.basicsystem.domain.Wpbjbdtj;
import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.common.QjblUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyjbxxDao;
import com.aisino2.publicsystem.domain.Qyjbxx;

public class WpbjbdtjDaoImpl extends BaseDao implements IWpbjbdtjDao {
	private IQyjbxxDao qyjbxxDao;
	/** @param 物品报警比对条件(t_wpbjbdtj) 增加 */
	public Wpbjbdtj insertWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		wpbjbdtj.setBjxxid2(getNextID("Bjxxid2"));
		return (Wpbjbdtj)insert("insertWpbjbdtj", wpbjbdtj);
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 删除 */
	public int deleteWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		return delete("deleteWpbjbdtj", wpbjbdtj);
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 修改 */
	public int updateWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		return update("updateWpbjbdtj", wpbjbdtj);
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 查询单条 */
	public Wpbjbdtj getWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		return (Wpbjbdtj)queryForObject("getWpbjbdtj", wpbjbdtj);
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjxxid2 desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWpbjbdtjList", map, pageNo,pageSize);
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 多条查询 */
	public List getListWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		return queryForList("getWpbjbdtjListNoPage", wpbjbdtj);
	}
	
	
	private List getBiduitjListByGzID(Integer wpbjgzid){
		return queryForList("getWpbjbdtjListByGzID",wpbjgzid);
	}
	
	/**
	 * 得到报警比对的sql
	 * @param bjgz
	 * @return
	 */
	public String getBjbdtjSql(Wpbjgz wpbjgz,Wpbjxxb wpbjxxbIn){
		StringBuffer sb=null;
		Integer wpbjgzid = wpbjgz.getWpbjgzid();
		
		String ywbm=wpbjgz.getYwbm();//业务表名称
		String bdbm=wpbjgz.getBdbm();//比对表名称
		String txdwxx=wpbjgz.getTxdwzd(); //特行单位信息
		String gxdwxx=wpbjgz.getGxdwzd(); //管辖单位信息
		String hylb=wpbjgz.getHylb();      //行业类别
		String hylbdm=wpbjgz.getHylbdm();  //行业类别代码
		
		//公共模块从业人员信息报警时，报警规则中无法提供行业类别名称和代码，需由wpbjxxbIn传入。
		if(ywbm.toUpperCase().equals("T_CLJBXX"))
		{
			Qyjbxx qyjbxx = new Qyjbxx();
			qyjbxx.setQyid(wpbjxxbIn.getYwbzj2());
			qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
			hylb=qyjbxx.getHylb();
			hylbdm=qyjbxx.getHylbdm();
		}
		
		//StringBuffer FromYWBM=new StringBuffer(ywbm);
		StringBuffer FromYWBM=new StringBuffer("");
		
		String txdwmc=null,txdwdz=null;
		String gxdwmc=null,gxdwbm=null;
		String y_gxdwmc=null,y_gxdwbm=null;
		String ywlb=null;  //业务类别
		String ywlbbm=null; //业务类别代码
		
		String wpmc = null;  //物品名称
		String wpjp = null;  //物品简拼
		String wpqp = null;  //物品全拼
		
		/**20110216目前各地系统存在新老版本典当系统并用的情况，因此物品报警程序需同时支持新老版本典当系统。
        以全局参数ddyversion区别新老系统，ddyversion=new表示该地区使用新系统，ddyversion=old表示该地区使用新系统
        当无此参数时，默认为新系统*/
		String ddyversion = QjblUtil.queryQjblVal("ddyversion");
		if("old".equals(ddyversion))
		{
			//典当物品车辆
			if(ywbm!=null&&ywbm.toUpperCase().equals("T_DDWPCL")){
				if(txdwxx!=null){
					txdwmc="t_ddqyxx.DDQYMC SSQYMC"; //特行单位名称
					txdwdz="t_ddqyxx.JYDZ SSQYDZ"; //特行单位地址
					//FromYWBM=FromYWBM.append(" left join t_ddqyxx on V_DDWPXX_DDWPCL.ddqyid=t_ddqyxx.ddqyid");
					FromYWBM=FromYWBM.append(" (select * from t_ddqyxx t where t.ddqyid="+wpbjxxbIn.getYwbzj2()+") t_ddqyxx");
				}
				if(gxdwxx!=null){
					gxdwmc="t_ddqyxx.gxdwmc GXDWMC";  //管辖单位名称
					gxdwbm="t_ddqyxx.gxdwbm GXDWBM";  //管辖单位编码
					y_gxdwmc="t_ddqyxx.gxdwmc Y_GXDWMC"; //原管辖单位编码
					y_gxdwbm="t_ddqyxx.gxdwbm Y_GXDWBM"; //原管辖单位编码
				}
				wpmc = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpmc())+"'";
				wpjp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpjp())+"'";	
	            wpqp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpqp())+"'";
	 		}
			//典当物品手机
			if(ywbm!=null&&ywbm.toUpperCase().equals("T_DDWPSJ"))
			{
				if(txdwxx!=null){
					txdwmc="t_ddqyxx.DDQYMC SSQYMC"; //特行单位名称
					txdwdz="t_ddqyxx.JYDZ SSQYDZ"; //特行单位地址
					//FromYWBM=FromYWBM.append(" left join t_ddqyxx on V_DDWPXX_DDWPSJ.ddqyid=t_ddqyxx.ddqyid");
					FromYWBM=FromYWBM.append(" (select * from t_ddqyxx t where t.ddqyid="+wpbjxxbIn.getYwbzj2()+") t_ddqyxx");
				}
				if(gxdwxx!=null){
					gxdwmc="t_ddqyxx.gxdwmc GXDWMC";  //管辖单位名称
					gxdwbm="t_ddqyxx.gxdwbm GXDWBM";  //管辖单位编码
					y_gxdwmc="t_ddqyxx.gxdwmc Y_GXDWMC"; //原管辖单位编码
					y_gxdwbm="t_ddqyxx.gxdwbm Y_GXDWBM"; //原管辖单位编码
				}
				wpmc = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpmc())+"'";
				wpjp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpjp())+"'";	
	            wpqp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpqp())+"'";	
			}
		}
		
		
		//机修业车辆
		/*if(ywbm!=null&&ywbm.toUpperCase().equals("T_JXCLJBXX")){
			if(txdwxx!=null){
				txdwmc="t_jxqyxx.JXQYMC SSQYMC"; //特行单位名称
				txdwdz="t_jxqyxx.JYDZ SSQYDZ"; //特行单位地址
				//FromYWBM=FromYWBM.append(" left join t_ddqyxx on V_DDWPXX_DDWPCL.ddqyid=t_ddqyxx.ddqyid");
				FromYWBM=FromYWBM.append(" (select * from t_jxqyxx t where t.jxqyid="+wpbjxxbIn.getYwbzj2()+") t_jxqyxx");
			}
			if(gxdwxx!=null){
				gxdwmc="t_jxqyxx.gxdwmc GXDWMC";  //管辖单位名称
				gxdwbm="t_jxqyxx.gxdwdm GXDWBM";  //管辖单位编码
				y_gxdwmc="t_jxqyxx.gxdwmc Y_GXDWMC"; //原管辖单位编码
				y_gxdwbm="t_jxqyxx.gxdwdm Y_GXDWBM"; //原管辖单位编码
			}
	
			wpmc = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpmc())+"'";
			wpjp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpjp())+"'";	
            wpqp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpqp())+"'";
		}*/
		//公共车辆，新版本机修车辆，新版本典当车辆及典当手机，二手机
		if(ywbm!=null&&
				(ywbm.toUpperCase().equals("T_CLJBXX")||
				ywbm.toUpperCase().equals("T_JXCLJBXX")||
				ywbm.toUpperCase().equals("T_ESJJY")||
				((ddyversion==null||"new".equals(ddyversion))&&(ywbm.toUpperCase().equals("T_DDWPSJ")||ywbm.toUpperCase().equals("T_DDWPCL")))
				)){
			if(txdwxx!=null){
				txdwmc="t_qyjbxx.QYMC SSQYMC"; //特行单位名称
				txdwdz="t_qyjbxx.JYDZ SSQYDZ"; //特行单位地址
				//FromYWBM=FromYWBM.append(" left join t_ddqyxx on V_DDWPXX_DDWPCL.ddqyid=t_ddqyxx.ddqyid");
				FromYWBM=FromYWBM.append(" (select * from t_qyjbxx t where t.qyid="+wpbjxxbIn.getYwbzj2()+") t_qyjbxx");
			}
			if(gxdwxx!=null){
				gxdwmc="t_qyjbxx.gxdwmc GXDWMC";  //管辖单位名称
				gxdwbm="t_qyjbxx.gxdwbm GXDWBM";  //管辖单位编码
				y_gxdwmc="t_qyjbxx.gxdwmc Y_GXDWMC"; //原管辖单位编码
				y_gxdwbm="t_qyjbxx.gxdwbm Y_GXDWBM"; //原管辖单位编码
			}
			
			wpmc = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpmc())+"'";
			wpjp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpjp())+"'";	
            wpqp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpqp())+"'";
		}
		
		//二手手机
		/*if(ywbm!=null&&ywbm.toUpperCase().equals("T_ESJJY"))
		{
			if(txdwxx!=null){
				txdwmc="t_qyjbxx.QYMC SSQYMC"; //特行单位名称
				txdwdz="t_qyjbxx.JYDZ SSQYDZ"; //特行单位地址
				//FromYWBM=FromYWBM.append(" left join t_ddqyxx on V_DDWPXX_DDWPCL.ddqyid=t_ddqyxx.ddqyid");
				FromYWBM=FromYWBM.append(" (select * from t_qyjbxx t where t.qyid="+wpbjxxbIn.getYwbzj2()+") t_qyjbxx");
			}
			if(gxdwxx!=null){
				gxdwmc="t_qyjbxx.gxdwmc GXDWMC";  //管辖单位名称
				gxdwbm="t_qyjbxx.gxdwbm GXDWBM";  //管辖单位编码
				y_gxdwmc="t_qyjbxx.gxdwmc Y_GXDWMC"; //原管辖单位编码
				y_gxdwbm="t_qyjbxx.gxdwbm Y_GXDWBM"; //原管辖单位编码
			}
			wpmc = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpmc())+"'";
			wpjp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpjp())+"'";	
            wpqp = "'"+StringUtil.getNotnullStr(wpbjxxbIn.getWpqp())+"'";
		}*/

		String ywbzjzd=wpbjgz.getYwbzdm(); //业务表主键字段
		String bdbzjzd=wpbjgz.getBdbzdm(); //比对表主键字段
		String bjlxdm=wpbjgz.getBjlxdm(); //报警类型代码  
		String bjlx=wpbjgz.getBjlx(); //报警类型 名称
		
		String jyaq=null,ladwbm=null,ladwmc=null;//简要案情、立案单位编码、立案单位名称
		
		if(bdbm!=null&&(bdbm.toUpperCase().equals("T_BKCL")||bdbm.toUpperCase().equals("T_BKSJ"))){
			
			//jyaq="t_bkwpjbxx.jyaq"; //////暂时不写入报警信息表简要案情
			ladwbm="t_bkwpjbxx.fwdwbm";     ////布控信息的发布单位编码 和名称 要关联布控基本信息表
			ladwmc="t_bkwpjbxx.fwdw";
		}
		if(bdbm!=null&&bdbm.toUpperCase().equals("T_BDQCLXX")){//被盗抢车辆信息
			//jyaq="t_qgztjx.jyaq";  //////暂时不写入报警信息表简要案情
			ladwbm="t_bdqclxx.ladwbm";
			ladwmc="t_bdqclxx.ladwmc";
		}
		if(bdbm!=null&&bdbm.toUpperCase().equals("T_SJBDQXX")){//被盗抢手机信息
			//jyaq="t_qgztjx.jyaq";  //////暂时不写入报警信息表简要案情
			ladwbm="t_sjbdqxx.ladqbm";
			ladwmc="t_sjbdqxx.ladq";
		}
		
		List wpbdtjList=getBiduitjListByGzID(wpbjgzid);
		if(wpbdtjList!=null){
			if(bdbm!=null&&(bdbm.toUpperCase().equals("T_BKCL")||bdbm.toUpperCase().equals("T_BKSJ"))){
				sb = new StringBuffer("SELECT  " + wpbjgzid + " WPBJGZID," + wpbjxxbIn.getYwbzj1()
						+  " YWBZJ," + bdbm + "." + bdbzjzd + " BDBZJ,"
						+ txdwmc + "," + txdwdz + "," + gxdwbm + "," + gxdwmc + ","
						+ y_gxdwbm + "," + y_gxdwmc + ",'" + bjlxdm + "' BJLXDM,'"
						+ bjlx + "' BJLX,'" + ywbm + "' YWBM,'" + bdbm + "' BDBM,'"
						+ hylb + "' HYLB,'" + hylbdm + "' HYLBDM," + ladwbm
						+ " LADWBM," + ladwmc + " LADWMC" + "," + wpmc + " wpmc," + wpjp + " wpjp," + wpqp + " wpqp"
						//ywlbbm + " YWLBDM," + ywlb + " YWLB" + 
						+ " FROM " + FromYWBM + "," + bdbm + " , t_bkwpjbxx "
						+ " WHERE ");
			}else if(bdbm!=null&&(bdbm.toUpperCase().equals("T_BDQCLXX")||bdbm.toUpperCase().equals("T_SJBDQXX"))){
				
				sb = new StringBuffer("SELECT  " + wpbjgzid + " WPBJGZID," + wpbjxxbIn.getYwbzj1()
						+  " YWBZJ," + bdbm + "." + bdbzjzd + " BDBZJ,"
						+ txdwmc + "," + txdwdz + "," + gxdwbm + "," + gxdwmc + ","
						+ y_gxdwbm + "," + y_gxdwmc + ",'" + bjlxdm + "' BJLXDM,'"
						+ bjlx + "' BJLX,'" + ywbm + "' YWBM,'" + bdbm + "' BDBM,'"
						+ hylb + "' HYLB,'" + hylbdm + "' HYLBDM," + ladwbm
						+ " LADWBM," + ladwmc + " LADWMC" + "," + wpmc + " wpmc," + wpjp + " wpjp," + wpqp + " wpqp"
						//ywlbbm + " YWLBDM," + ywlb + " YWLB" + 
						+" FROM " + FromYWBM + "," + bdbm
						+ " WHERE ");
				
			}
		    
			for(int i=0;i<wpbdtjList.size();i++){
				Wpbjbdtj wpbjdbtj = (Wpbjbdtj)wpbdtjList.get(i);
				
				Integer jibie=wpbjdbtj.getJibie(); //级别
				String ywbzdm=wpbjdbtj.getYwbzdm();//业务表字段名
				String bdbzdm=wpbjdbtj.getBdbzdm();//比对表字段名
				//String tjlx=bjbdtj.getTjlx();//条件类型
				String ljgx=wpbjdbtj.getLjgx();//逻辑关系
				String bdgx=wpbjdbtj.getBdgx();//比对关系
				String gxc=wpbjdbtj.getGxc();   //关系串
				
				if(ywbm!=null&&ywbm.toUpperCase().equals("T_DDWPCL"))
				{
					if(bdbm!=null&&(bdbm.toUpperCase().equals("T_BKCL")))
					{
						sb.append(" (t_bkcl.hphm='"+wpbjxxbIn.getHphm()+"' ");
						sb.append(" or t_bkcl.clsbdh='"+wpbjxxbIn.getClsbdh()+"' ");
						sb.append(" or t_bkcl.fdjh='"+wpbjxxbIn.getFdjh()+"' ");
						sb.append(" or t_bkcl.cjh='"+wpbjxxbIn.getCjh()+"' )");
					}
					else if(bdbm!=null&&(bdbm.toUpperCase().equals("T_BDQCLXX")))
					{
						sb.append(" (t_bdqclxx.hphm='"+wpbjxxbIn.getHphm()+"' ");
						sb.append(" or t_bdqclxx.clsbdh='"+wpbjxxbIn.getClsbdh()+"' ");
						sb.append(" or t_bdqclxx.fdjh='"+wpbjxxbIn.getFdjh()+"' ");
						sb.append(" or t_bdqclxx.cjh='"+wpbjxxbIn.getCjh()+"' )");
					}
				}
				
				
				if(ywbm!=null&&(ywbm.toUpperCase().equals("T_JXCLJBXX")||ywbm.toUpperCase().equals("T_CLJBXX")))
				{
					if(bdbm!=null&&(bdbm.toUpperCase().equals("T_BKCL")))
					{
						sb.append(" (t_bkcl.hphm='"+wpbjxxbIn.getHphm()+"' ");
						sb.append(" or t_bkcl.fdjh='"+wpbjxxbIn.getFdjh()+"' ");
						sb.append(" or t_bkcl.cjh='"+wpbjxxbIn.getCjh()+"' )");
					}
					else if(bdbm!=null&&(bdbm.toUpperCase().equals("T_BDQCLXX")))
					{
						sb.append(" (t_bdqclxx.hphm='"+wpbjxxbIn.getHphm()+"' ");
						sb.append(" or t_bdqclxx.fdjh='"+wpbjxxbIn.getFdjh()+"' ");
						sb.append(" or t_bdqclxx.cjh='"+wpbjxxbIn.getCjh()+"' )");
					}
				}
				
				
				
				if(gxc!=null){
					sb.append(" "+gxc+" ");
				}else{
					if(bdgx!=null){
						/*if(bdgx.toLowerCase().equals("like")){
							sb.append(ywbm+"."+ywbzdm+" "+bdgx+" "+bdbm+"."+bdbzdm+"||%");
						}else{
							sb.append(ywbm+"."+ywbzdm+" "+bdgx+" "+bdbm+"."+bdbzdm);
						}*/	
						if(ywbm!=null&&ywbm.toUpperCase().equals("T_DDWPSJ")
								||ywbm.toUpperCase().equals("T_ESJJY"))
						{
							if(bdgx.toLowerCase().equals("like")){
								sb.append(bdbm+"."+bdbzdm+" "+bdgx+" '"+wpbjxxbIn.getSjch()+"%'");
							}else{
								sb.append(bdbm+"."+bdbzdm+" "+bdgx+" '"+wpbjxxbIn.getSjch()+"'");
							}
						}
					} 
				 }
				
				if(ljgx!=null){
					/////逻辑关系
					sb.append(" "+ljgx+" ");
				 }	
			}
			
			if(bdbm!=null&&(bdbm.toUpperCase().equals("T_BKCL")||bdbm.toUpperCase().equals("T_BKSJ"))){
				sb.append(" and "+bdbm+".bkwpjbxxid = t_bkwpjbxx.bkwpjbxxid ");
			}
			//sb.append(" and "+ywbm+".biduiflag='0' ");
		}
		
		if(sb!=null){
			return sb.toString();
		}else{
			return null;
		}
	}

	public void setQyjbxxDao(IQyjbxxDao qyjbxxDao) {
		this.qyjbxxDao = qyjbxxDao;
	}
}
