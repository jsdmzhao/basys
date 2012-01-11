package com.aisino2.basicsystem.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IQgztjxDao;
import com.aisino2.basicsystem.domain.Qgztjx;
import com.aisino2.basicsystem.service.IQgztjxService;
import com.aisino2.cache.CacheManager;
import com.aisino2.common.DateToString;
import com.aisino2.common.FileUtils;
import com.aisino2.common.FtpFile;
import com.aisino2.common.ReadFile;
import com.aisino2.common.StringUtils;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.core.util.StringUtil;
import com.aisino2.core.util.ZipUtil;
import com.aisino2.sysadmin.domain.Dict_item;

public class QgztjxServiceImpl extends BaseService implements IQgztjxService {

	private IQgztjxDao qgztjxDao;

	/** @param 全国在逃简项(t_qgztjx) 增加 */
	public Qgztjx insertQgztjx(Qgztjx qgztjx){
		// TODO: implement
		return (Qgztjx)qgztjxDao.insertQgztjx(qgztjx);
	}

	/** @param 全国在逃简项(t_qgztjx) 删除 */
	public boolean deleteQgztjx(Qgztjx qgztjx){
		// TODO: implement
		return qgztjxDao.deleteQgztjx(qgztjx)>0;
	}

	/** @param 全国在逃简项(t_qgztjx) 修改 */
	public boolean updateQgztjx(Qgztjx qgztjx){
		// TODO: implement
		return qgztjxDao.updateQgztjx(qgztjx)>0;
	}

	/** @param 全国在逃简项(t_qgztjx) 查询单条 */
	public Qgztjx getQgztjx(Qgztjx qgztjx){
		// TODO: implement
		return (Qgztjx)qgztjxDao.getQgztjx(qgztjx);
	}

	/** @param 全国在逃简项(t_qgztjx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qgztjxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 全国在逃简项(t_qgztjx) 多条查询 */
	public List getListQgztjx(Qgztjx qgztjx){
		// TODO: implement
		return qgztjxDao.getListQgztjx(qgztjx);
	}
	
	public String getFtpUpdate(){
		String  sLog="开始更新\n";
		sLog+=DateToString.getDateTimeChinese(new Date())+" 开始下载数据\n";
		FtpFile ftpFile=new FtpFile(QgztjxServiceImpl.class.getClassLoader().getResource("").getPath()+"ftpFile.xml","全国在逃简项");
		
		
		String[] aFiles=ftpFile.getfilenamelist(ftpFile.getFilepostfix());
		int iFiles=aFiles.length;
		String sFile=aFiles[iFiles-1];
		String sFileDate=sFile.replaceFirst(ftpFile.getFilepostfix(), "");
		
		Date date=DateToString.toDate(sFileDate);
		String sReadFile=DateToString.RespDateByDay(ftpFile.getFiledays(),date,"yyyy-MM-dd")+".txt";
		String sDate=DateToString.RespDateByDay(ftpFile.getDowndays(),date,"yyyy-MM-dd");
			//sDate+ftpFile.getFilepostfix();
		ftpFile.DownloadFile(sFile, ftpFile.getSFilePath()+"/Download/qgztjx/"+sFile);
		sLog+=DateToString.getDateTimeChinese(new Date())+" 下载数据结束\n";
		ZipUtil zipUtil=new ZipUtil();
		ReadFile readFile=new ReadFile();
		List lRead=new ArrayList();
		try {
			sLog+=DateToString.getDateTimeChinese(new Date())+" 开始解压缩文件\n";
			zipUtil.unZip(ftpFile.getSFilePath()+"/Download/qgztjx/"+sFile, ftpFile.getSFilePath()+"/Download/qgztjx/extend");
			sLog+=DateToString.getDateTimeChinese(new Date())+" 解压缩文件结束\n";
			sLog+=DateToString.getDateTimeChinese(new Date())+" 开始读取文件\n";
			lRead=readFile.readTxt(ftpFile.getSFilePath()+"/Download/qgztjx/extend/"+sReadFile,"gbk");
			sLog+=DateToString.getDateTimeChinese(new Date())+" 读取文件结束\n";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		sLog+=DateToString.getDateTimeChinese(new Date())+" 开始生成importdata.txt文件\n";
		
		Qgztjx qgztjx=new Qgztjx();
		String sRow="";
		String[] aCol;
		List lQgztjx=new ArrayList();
		String sPath=ftpFile.getSFilePath()+"/Import/qgztjx/"+sDate+"/importdata.txt";
		String sCmdPath=ftpFile.getSFilePath()+"/Import/qgztjx/"+sDate;
		String sCopyPath=ftpFile.getSFilePath()+"/Import/qgztjx";
		try {
			FileUtils.deleteDirectory(sCmdPath);
			createFilePath(sCmdPath,sCopyPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		String sCsrq="";
		String sDjrq="";
		String sConect="";
		File writefile;
		CacheManager cacheManager=new CacheManager();
		/**
		Dict_item dictitem=new Dict_item();
		dictitem.setItem_allpin("");
		dictitem.setItem_simplepin("");
		dictitem.setFact_value("");
		dictitem.setDisplay_name(""); 
		dictitem.setAppend_value("");
		dictitem.setDict_code("dm_xb");
		List lXb=cacheManager.getCacheDictitem(dictitem);
		dictitem.setDict_code("dm_xzqh");
		List lXzqh=cacheManager.getCacheDictitem(dictitem);
		dictitem.setDict_code("dm_ajlb(gb)");
		List lAjlb=cacheManager.getCacheDictitem(dictitem);
		**/
		int dictitems=0;
		for (int i=0;i<lRead.size();i++){
			if (i==48){
				dictitems=0;
			}	
			dictitems=0;
			sRow=(String)lRead.get(i);
			sRow=sRow.replace("\";", "");
			aCol=sRow.split("\",\"");
			qgztjx=new Qgztjx();
			qgztjx.setQgztjxid(i+1);
			qgztjx.setTbbh(aCol[0].replace("\"", ""));
			qgztjx.setXm(aCol[1].replace(",", "、"));
			qgztjx.setXmpy(PinYinUtil.getHanyuPingYinInitial(aCol[1]).replace(",", "、"));
			qgztjx.setBm(aCol[2].replace(",", "、"));
			qgztjx.setXbdm(aCol[3].replace(",", "、"));
			/**
			for (int a=0;a<lXb.size();a++){
				dictitem=(Dict_item)lXb.get(a);
				if (dictitem.getFact_value().equals(aCol[3].replace(",", "、"))){
					qgztjx.setXb(dictitem.getDisplay_name());
					break;
				}	
			}
			for (int a=0;a<lXzqh.size();a++){
				dictitem=(Dict_item)lXzqh.get(a);
				if (dictitem.getFact_value().equals(aCol[7].replace(",", "、"))){
					qgztjx.setHjd(dictitem.getDisplay_name());
					dictitems=dictitems+1;
				}	
				if (dictitem.getFact_value().equals(aCol[9].replace(",", "、"))){
					qgztjx.setXzdq(dictitem.getDisplay_name());
					dictitems=dictitems+1;
				}
				if (dictitem.getFact_value().equals(aCol[23].replace(",", "、"))){
					qgztjx.setLadq(dictitem.getDisplay_name());
					dictitems=dictitems+1;
				}	
				if (dictitems==3)
					break;
			}
			for (int a=0;a<lAjlb.size();a++){
				dictitem=(Dict_item)lAjlb.get(a);
				if (dictitem.getFact_value().equals(aCol[17].replace(",", "、"))){
					qgztjx.setAjlb(dictitem.getDisplay_name());
					break;
				}	
			}
			**/
			if (!aCol[4].equals("") && !aCol[4].equals(" ")){
				qgztjx.setCsrq(DateToString.toDate(aCol[4].replace(",", "、")));
				if (qgztjx.getCsrq()!=null)
				sCsrq=aCol[4].replace(",", "、");
			}else if (!aCol[5].equals("") && !aCol[5].equals(" ")){
				qgztjx.setCsrq(DateToString.toDate(aCol[5].replace(",", "、")));
				if (qgztjx.getCsrq()!=null)
				sCsrq=aCol[5].replace(",", "、");
			}	
			String sSfhm=aCol[6].replace(",", "、");
			if (sSfhm.length()==15){
				if (StringUtil.isNumeric(sSfhm))
					sSfhm=StringUtils.getSfhm18(sSfhm);
			}	
			qgztjx.setGmsfhm(sSfhm);
			qgztjx.setHjdbm(aCol[7].replace(",", "、"));
			qgztjx.setHjxxdz(aCol[8].replace(",", "、"));
			qgztjx.setXzdqbm(aCol[9].replace(",", "、"));
			qgztjx.setXzdxxdz(aCol[10].replace(",", "、"));
			if (!aCol[11].equals("") && !aCol[11].equals(" ")){
				qgztjx.setQtzjlx(aCol[11].replace(",", "、"));
				qgztjx.setQtzjhm(aCol[12].replace(",", "、"));
			}else if (!aCol[13].equals("") && !aCol[13].equals(" ")){
				qgztjx.setQtzjlx(aCol[13].replace(",", "、"));
				qgztjx.setQtzjhm(aCol[14].replace(",", "、"));
			}
	
			qgztjx.setShengao(aCol[15].replace(",", "、"));
			qgztjx.setAjlbbm(aCol[17].replace(",", "、"));
			
			if (!aCol[18].equals("") && !aCol[18].equals(" ")){
				qgztjx.setDjrq(DateToString.toDate(aCol[18].replace(",", "、")));
				if (qgztjx.getDjrq()!=null)
				sDjrq=aCol[18].replace(",", "、");
			}	
			qgztjx.setLadqbm(aCol[23].replace(",", "、"));
			
			qgztjx.setLxr(aCol[24].replace(",", "、"));
			qgztjx.setLxfs(aCol[25].replace(",", "、"));
			sConect=qgztjx.getQgztjxid()+","+
					qgztjx.getTbbh()+","+
					qgztjx.getXzdqbm()+","+
					qgztjx.getXzqh()+","+
					qgztjx.getXmpy()+","+
					qgztjx.getXm()+","+
					qgztjx.getBm()+","+
					qgztjx.getXbdm()+","+
					qgztjx.getXb()+","+
					sCsrq+","+
					qgztjx.getGmsfhm()+","+
					qgztjx.getHjdbm()+","+
					qgztjx.getHjd()+","+
					qgztjx.getHjxxdz()+","+
					qgztjx.getXzdqbm()+","+
					qgztjx.getXzdq()+","+
					qgztjx.getXzdxxdz()+","+
					qgztjx.getQtzjlx()+","+
					qgztjx.getQtzjhm()+","+
					qgztjx.getAjjbbm()+","+
					qgztjx.getAjjb()+","+
					qgztjx.getAjlbbm()+","+
					qgztjx.getAjlb()+","+
					qgztjx.getJyaq()+","+
					sDjrq+","+
					qgztjx.getDjr()+","+
					qgztjx.getLadqbm()+","+
					qgztjx.getLadq()+","+
					qgztjx.getBadwbm()+","+
					qgztjx.getBadw()+","+
					qgztjx.getTbr()+","+
					qgztjx.getLxr()+","+
					qgztjx.getLxfs()+","+
					qgztjx.getShengao()+"\n";
			sConect=sConect.replace("null","");
			
	        try {
	            
	            writefile = new File(sPath);
	            // 如果文本文件不存在则创建它
	            if (writefile.exists() == false) {
	                writefile.createNewFile();
	                writefile = new File(sPath); // 重新实例化
	            }
	            FileOutputStream fw = new FileOutputStream(writefile,true);
	            fw.write(sConect.getBytes());
	            fw.flush();
	            fw.close();
	        } catch (Exception ex) { 
	            //System.out.println(ex.getMessage());
	            return ex.getMessage();
	        }
		}
		sLog+=DateToString.getDateTimeChinese(new Date())+" 生成importdata.txt文件结束\n";
		Runtime rt = Runtime.getRuntime();
		try{
			File dir = new File(sCmdPath);
			rt.exec("cmd /c start impdata.bat",null,dir);
		} catch (Exception ex){
			ex.printStackTrace();
			return ex.getMessage();
		}
		File logFile= new File(sCmdPath+"/control.log");
		FileOutputStream fw;
		try {
			fw = new FileOutputStream(logFile,true);
		
				fw.write(sLog.getBytes());
				fw.flush();
			    fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			//return e.getMessage();
	       
		} 
		//lQgztjx=qgztjxDao.insertListQgztjxIn(lRead);
		//qgztjxDao.insertQgztjxIn();
		return  sDate;
	}
	public List getDictitem(){
		Dict_item dict_item=new Dict_item();
		dict_item.setDict_code("dm_mz");
		dict_item.setItem_simplepin("y");
		dict_item.setItem_allpin("y");
		dict_item.setFact_value("y");
		dict_item.setDisplay_name("y");
		dict_item.setAppend_value("y");
		
		
		List lDictitem=CacheManager.getCacheDictitem(dict_item);
		return lDictitem;
	}
	public IQgztjxDao getQgztjxDao() {
		return qgztjxDao;
	}

	public void setQgztjxDao(IQgztjxDao qgztjxDao) {
		this.qgztjxDao = qgztjxDao;
	}

	public List getListExportQgztjx(Map map, String sort, String desc) {
		// TODO Auto-generated method stub
		return qgztjxDao.getListExportQgztjx(map,sort,desc);
	}
	//生成文件路径
	private void createFilePath(String sPath,String sCopyPath) throws IOException{
		try
		{
			String[] aPath=sPath.split("/");
			String sCreatePath=aPath[0]+"\\";
			for (int i=1;i<aPath.length;i++){
				sCreatePath+="\\"+aPath[i];
				if(!(new File(sCreatePath).isDirectory()))
				{
					new File(sCreatePath).mkdir();	
				}
			}
			FileUtils.copyToDir(sCopyPath+"/alter.sql", sPath);
			FileUtils.copyToDir(sCopyPath+"/impdata.bat", sPath);
			FileUtils.copyToDir(sCopyPath+"/impdata.ctl", sPath);
		}
		catch(SecurityException e)
		{
		     System.out.println(e.getMessage());
		}
	}
}
