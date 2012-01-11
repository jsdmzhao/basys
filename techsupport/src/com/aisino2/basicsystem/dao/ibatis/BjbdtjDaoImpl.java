package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBjbdtjDao;
import com.aisino2.basicsystem.domain.Bjbdtj;
import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.basicsystem.domain.Bjxxb;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyjbxxDao;
import com.aisino2.publicsystem.domain.Qyjbxx;

public class BjbdtjDaoImpl extends BaseDao implements IBjbdtjDao {
	
	private IQyjbxxDao qyjbxxDao;
	/** @param 报警比对条件(t_bjbdtj) 增加 */
	public Bjbdtj insertBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		bjbdtj.setBjgzid(getNextID("Bjgzid"));
		return (Bjbdtj)insert("insertBjbdtj", bjbdtj);
	}

	/** @param 报警比对条件(t_bjbdtj) 删除 */
	public int deleteBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		return delete("deleteBjbdtj", bjbdtj);
	}

	/** @param 报警比对条件(t_bjbdtj) 修改 */
	public int updateBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		return update("updateBjbdtj", bjbdtj);
	}

	/** @param 报警比对条件(t_bjbdtj) 查询单条 */
	public Bjbdtj getBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		return (Bjbdtj)queryForObject("getBjbdtj", bjbdtj);
	}

	/** @param 报警比对条件(t_bjbdtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjgzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBjbdtjList", map, pageNo,pageSize);
	}

	/** @param 报警比对条件(t_bjbdtj) 多条查询 */
	public List getListBjbdtj(Bjbdtj bjbdtj){
		// TODO: implement
		return queryForList("getBjbdtjListNoPage", bjbdtj);
	}
	
	/**通过比对规则获取比对条件*/
	public String getBjbdtjSql(Bjgz bjgz,Bjxxb bjxxbIn) {
		StringBuffer sb=null;
		Integer gzid=bjgz.getBjgzid();  //规则ID
		String ywbm=bjgz.getYwbm();//业务表名称
		StringBuffer FromYWBM=new StringBuffer("");
		String bdbm=bjgz.getBdbm();//比对表名称
		String txdwxx=bjgz.getTxdwzd(); //特行单位信息
		String gxdwxx=bjgz.getGxdwzd(); //管辖单位信息
		String hylb=bjgz.getHylb();
		String hylbdm=bjgz.getHylbdm();
		//公共模块车主，报警规则中无法提供行业类别名称和代码，需从企业信息中取出。
		if(ywbm.toUpperCase().equals("T_CLJBXX"))
		{
			Qyjbxx qyjbxx = new Qyjbxx();
			qyjbxx.setQyid(bjxxbIn.getYwbzj2());
			qyjbxx = qyjbxxDao.getQyjbxx(qyjbxx);
			hylb=qyjbxx.getHylb();
			hylbdm=qyjbxx.getHylbdm();
		}
		String txdwmc=null,txdwdz=null;
		String gxdwmc=null,gxdwbm=null;
		String y_gxdwmc=null,y_gxdwbm=null;
		String ywlb=null;  //业务类别
		String ywlbbm=null; //业务类别代码
		String xm=null,gmsfhm=null;  //姓名、公民身份号码
		//业务表为典当客户信息
		if(ywbm!=null&&ywbm.toUpperCase().equals("T_DDKHXX")){
			if(txdwxx!=null){
				txdwmc="t_ddqyxx.DDQYMC SSQYMC"; //特行单位名称
				txdwdz="t_ddqyxx.JYDZ SSQYDZ"; //特行单位地址
				//FromYWBM=FromYWBM.append(" left join t_ddqyxx on t_ddkhxx.ddqyid=t_ddqyxx.ddqyid");
				FromYWBM=FromYWBM.append(" (select * from t_ddqyxx t where t.ddqyid="+bjxxbIn.getYwbzj2()+") t_ddqyxx");
			}
			if(gxdwxx!=null){
				gxdwmc="t_ddqyxx.gxdwmc GXDWMC";  //管辖单位名称
				gxdwbm="t_ddqyxx.gxdwbm GXDWBM";  //管辖单位编码
				y_gxdwmc="t_ddqyxx.gxdwmc Y_GXDWMC"; //原管辖单位编码
				y_gxdwbm="t_ddqyxx.gxdwbm Y_GXDWBM"; //原管辖单位编码
			}
			ywlb="'典当业'";
			ywlbbm="'E'";
			xm="'"+bjxxbIn.getXm()+"'";
			gmsfhm="'"+bjxxbIn.getZjhm()+"'";
			
			
		}
		//业务表为机修业信息,送车人，取车人
		/*if(ywbm!=null&&ywbm.toUpperCase().equals("T_JXCLJBXX")){
			if(txdwxx!=null){
				txdwmc="t_jxqyxx.JXQYMC SSQYMC"; //特行单位名称
				txdwdz="t_jxqyxx.JYDZ SSQYDZ"; //特行单位地址
				//FromYWBM=FromYWBM.append(" left join t_ddqyxx on t_ddkhxx.ddqyid=t_ddqyxx.ddqyid");
				FromYWBM=FromYWBM.append(" (select * from t_jxqyxx t where t.jxqyid="+bjxxbIn.getYwbzj2()+") t_jxqyxx");
			}
			if(gxdwxx!=null){
				gxdwmc="t_jxqyxx.gxdwmc GXDWMC";  //管辖单位名称
				gxdwbm="t_jxqyxx.gxdwdm GXDWBM";  //管辖单位编码
				y_gxdwmc="t_jxqyxx.gxdwmc Y_GXDWMC"; //原管辖单位编码
				y_gxdwbm="t_jxqyxx.gxdwdm Y_GXDWBM"; //原管辖单位编码
			}
			ywlb="'机修业'";
			ywlbbm="'C'";
			xm="'"+bjxxbIn.getXm()+"'";
			gmsfhm="'"+bjxxbIn.getZjhm()+"'";
		}*/
		//公共模块车主、二手车客户、二手机摊位从业人员、二手手机出售人员、二手手机摊主、汽车租赁业租车客户、
		//委托寄卖业物品所有人或物品委托人、委托寄卖业货物去向联系人、机修业送车人及取车人、机动车拆解业送车人
		if(ywbm!=null&&(ywbm.toUpperCase().equals("T_CLJBXX")
				||ywbm.toUpperCase().equals("T_ESCJYXX")
				||ywbm.toUpperCase().equals("T_ESJTWRYXX")
				||ywbm.toUpperCase().equals("T_ESJJY")
				||ywbm.toUpperCase().equals("T_TYZLXX")
				||ywbm.toUpperCase().equals("T_QCZLKHXXB")
				||ywbm.toUpperCase().equals("T_WTJMXX")
				||ywbm.toUpperCase().equals("T_HWQX"))
				||ywbm.toUpperCase().equals("T_JXCLJBXX")
				||ywbm.toUpperCase().equals("T_HSCLJBXX"))
		{
			if(txdwxx!=null){
				txdwmc="t_qyjbxx.qymc SSQYMC"; //特行单位名称
				txdwdz="t_qyjbxx.jydz SSQYDZ"; //特行单位地址
				//FromYWBM=FromYWBM.append(ywbm+" left join t_qyjbxx on t_qyjbxx.qyid="+bjxxbIn.getYwbzj2());
				FromYWBM=FromYWBM.append(" (select * from t_qyjbxx t where t.qyid="+bjxxbIn.getYwbzj2()+") t_qyjbxx");
			}
			if(gxdwxx!=null){
				gxdwmc="t_qyjbxx.gxdwmc GXDWMC";  //管辖单位名称
				gxdwbm="t_qyjbxx.gxdwbm GXDWBM";  //管辖单位编码
				y_gxdwmc="t_qyjbxx.gxdwmc Y_GXDWMC"; //原管辖单位编码
				y_gxdwbm="t_qyjbxx.gxdwbm Y_GXDWBM"; //原管辖单位编码
			}
			ywlb="'"+hylb+"'";
			ywlbbm="'"+hylbdm+"'";
			xm="'"+bjxxbIn.getXm()+"'";
			gmsfhm="'"+bjxxbIn.getZjhm()+"'";
		}
		
		String ywbzjzd=bjgz.getYwbzdm(); //业务表主键字段
		String bdbzjzd=bjgz.getBdbzdm(); //比对表主键字段
		String bjlxdm=bjgz.getBjlxdm(); //报警类型代码
		String bjlx=bjgz.getBjlx(); //报警类型
		
		String jyaq=null,ladwbm=null,ladwmc=null;//简要案情、立案单位编码、立案单位名称
		if(bdbm!=null&&bdbm.toUpperCase().equals("T_BKRY")){
			jyaq="t_bkry.jyaq";
			ladwbm="t_bkry.fwdwbm";
			ladwmc="t_bkry.fwdw";
		}
		if(bdbm!=null&&bdbm.toUpperCase().equals("T_QGZTJX")){
			jyaq="t_qgztjx.jyaq";
			ladwbm="t_qgztjx.ladqbm";
			ladwmc="t_qgztjx.ladq";
		}
		Bjbdtj bjbdtjTemp = new Bjbdtj();
		bjbdtjTemp.setBjgzid(gzid);
		List bdtjList=getListBjbdtj(bjbdtjTemp);
		if(bdtjList!=null){
			/*sb=new StringBuffer("SELECT  "+gzid+" BJGZID,"+ywbm+"."+ywbzjzd+" YWBZJ,"+
					bdbm+"."+bdbzjzd+" BDBZJ,"+txdwmc+","+txdwdz+","+gxdwbm+","+gxdwmc+","
					+y_gxdwbm+","+y_gxdwmc+",'"+bjlxdm+"' BJLXDM,'"+bjlx+"' BJLX,'"
					+ywbm+"' YWBM,'"+bdbm+"' BDBM,'"+hylb+"' HYLB,'"+hylbdm+"' HYLBDM,"
					+xm+" XM,"+gmsfhm+" GMSFHM,"+jyaq+" JYAQ,"+ladwbm+" LADWBM,"+ladwmc+" LADWMC,"
					+ywlbbm+" YWLBDM,"+ywlb+" YWLB"+" FROM "+FromYWBM+","+bdbm+" WHERE ");*/
			sb=new StringBuffer("SELECT  "+gzid+" BJGZID,"+bjxxbIn.getYwbzj1()+" YWBZJ,"+
					bdbm+"."+bdbzjzd+" BDBZJ,"+txdwmc+","+txdwdz+","+gxdwbm+","+gxdwmc+","
					+y_gxdwbm+","+y_gxdwmc+",'"+bjlxdm+"' BJLXDM,'"+bjlx+"' BJLX,'"
					+ywbm+"' YWBM,'"+bdbm+"' BDBM,'"+hylb+"' HYLB,'"+hylbdm+"' HYLBDM,"
					+xm+" XM,"+gmsfhm+" GMSFHM,"+jyaq+" JYAQ,"+ladwbm+" LADWBM,"+ladwmc+" LADWMC,"
					+ywlbbm+" YWLBDM,"+ywlb+" YWLB"+" FROM "+FromYWBM+","+bdbm+" WHERE ");
			for(int i=0;i<bdtjList.size();i++){
				Bjbdtj bjbdtj=(Bjbdtj)bdtjList.get(i);   
				Integer jibie=bjbdtj.getJibie(); //级别
				String ywbzdm=bjbdtj.getYwbzdm();//业务表字段名
				String bdbzdm=bjbdtj.getBdbzdm();//比对表字段名
				//String tjlx=bjbdtj.getTjlx();//条件类型
				String ljgx=bjbdtj.getLjgx();//逻辑关系
				String bdgx=bjbdtj.getBdgx();//比对关系
				String gxc=bjbdtj.getGxc();   //关系串
				if(jibie!=null&&jibie.toString().startsWith("b")){  //before
					String jibieTemp=jibie.toString(); 
					sb=sb.append(" "+jibieTemp.substring(jibieTemp.indexOf('b')+1));
				}			   
				if(gxc!=null){
					sb.append(" "+gxc+" ");
				}else{
					if(bdgx!=null){
						/*if(bdgx.toLowerCase().equals("like")){
							sb.append(ywbm+"."+ywbzdm+" "+bdgx+" "+bdbm+"."+bdbzdm+"||%");
						}else{
							sb.append(ywbm+"."+ywbzdm+" "+bdgx+" "+bdbm+"."+bdbzdm);
						}	*/	
						if(bdgx.toLowerCase().equals("like")){
							sb.append("upper("+bdbm+"."+bdbzdm+") "+bdgx+" upper('"+bjxxbIn.getZjhm()+"'||%");
						}else{
							sb.append("upper("+bdbm+"."+bdbzdm+") "+bdgx+" upper('"+bjxxbIn.getZjhm()+"')");
						}
					} 
				 }
				 if(jibie!=null&&jibie.toString().startsWith("a")){//after
					 String jibieTemp=jibie.toString();
					 sb=sb.append(jibieTemp.substring(jibieTemp.indexOf('a')+1)+" ");
				 } 
				 if(ljgx!=null){
					 sb.append(" "+ljgx+" ");
				 }	
			}
			//sb.append(" and "+ywbm+".biduiflag='0' ");
		}
		if(sb!=null){
			return sb.toString();
		}	
		else
		   return null;
	}

	public void setQyjbxxDao(IQyjbxxDao qyjbxxDao) {
		this.qyjbxxDao = qyjbxxDao;
	}
}
