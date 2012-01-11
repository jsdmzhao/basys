package com.aisino2.basicsystem.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.Element;

import com.aisino2.basicsystem.dao.IQyxxExpImpDao;
import com.aisino2.basicsystem.domain.QyxxExpImp;
import com.aisino2.basicsystem.service.IQyxxExpImpService;
import com.aisino2.cache.CacheManager;
import com.aisino2.common.QjblUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.common.XmlCreater;
import com.aisino2.common.XmlReader;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.Dict_item;

public class QyxxExpImpImpl extends BaseService implements IQyxxExpImpService {

	private IQyxxExpImpDao qyxxExpImpDao;
	private String startData = "<Data/>";
	private String startData1 = "<Data>";
	private String endData = "</Data>";
	private String endCon = "</Package>";
	private int onePageSize = 100;
	private int add = 10001;
	private String oldChar = "utf-8";
	private String newChar = "ISO8859_1";
	private int succNum = 0;
	private int errNum = 0;
	private QyxxExpLgyImpl qyxxExpLgy = null; //旅馆业
	private QyxxExpPubImpl qyxxExpPub = null; //公共模块
	private QyxxExpDdyImpl qyxxExpDdy = null; //典当业
	private QyxxExpYzyImpl qyxxExpYzy = null; //印章业
	
	/** 企业信息 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return qyxxExpImpDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	/** 旅馆业信息XML 查询 */
	public List getListLgyXmlMes(QyxxExpImp qyxxExpImp){
		return qyxxExpImpDao.getListLgyXmlMes(qyxxExpImp);
	}
	/** 企业信息 全部 导出 */
	public boolean updateExpAllQxx(QyxxExpImp qyxxExpImp) throws Exception {
		boolean res = true;
		qyxxExpImp.setDcsj(new Date());
		qyxxExpImp.setDcbs("1");
		List templist = null;
		String hylbdm = qyxxExpImp.getHylbdm();
		
		String fileName = createXmlFile();
		Document doc = XmlCreater.creatDocument();
		Element pdata = creteHeadAndDateXml(doc);
		createTouMes(doc, fileName);
		
		String contentRecord = "";
		
		qyxxExpImp.setGxdwbm(StringUtil.trimEven0(qyxxExpImp.getGxdwbm()));
		
		Map map = new HashMap();
		map.put("cxtjDcbs", qyxxExpImp.getCxtjDcbs());
		map.put("cxtjDcsj", qyxxExpImp.getCxtjDcsj());
		map.put("qybm", qyxxExpImp.getQybm());
		map.put("qymc", qyxxExpImp.getQymc());
		map.put("gxdwbm", qyxxExpImp.getGxdwbm());
		map.put("hylbdm", hylbdm);
		if("A".equals(hylbdm)){ //旅馆
			Page page = qyxxExpImpDao.getListLgyXmlMesPage(map, 1, onePageSize);
			int totalpage=page.getTotalPages();
			for(int index=1;index<=totalpage;index++){
				page = qyxxExpImpDao.getListLgyXmlMesPage(map, index, onePageSize);
				contentRecord = createXmlMes(pdata, page.getData(), hylbdm,fileName); //文件数据内容
				XmlCreater.appendMethodA(fileName, contentRecord, oldChar, newChar); //数据内容
			}
			qyxxExpImpDao.updateLgyxx(qyxxExpImp);
		}
		if("Z".equals(hylbdm)){ //出租房
			Page page = qyxxExpImpDao.getListCzfwyXmlMesPage(map, 1, onePageSize);
			int totalpage=page.getTotalPages();
			for(int index=1;index<=totalpage;index++){
				page = qyxxExpImpDao.getListCzfwyXmlMesPage(map, index, onePageSize);
				contentRecord = createXmlMes(pdata, page.getData(), hylbdm,fileName); //文件数据内容
				XmlCreater.appendMethodA(fileName, contentRecord, oldChar, newChar); //数据内容
			}
			qyxxExpImpDao.updateCzfwyxx(qyxxExpImp);
		}
		if("J".equals(hylbdm)||"H".equals(hylbdm)||"E01".equals(hylbdm)||"E02".equals(hylbdm)||"E04".equals(hylbdm)||
				"F01".equals(hylbdm)||"F02".equals(hylbdm)||"C".equals(hylbdm)||"X".equals(hylbdm)||
				"E03".equals(hylbdm)||"B".equals(hylbdm)){ 
				//公用模块-JH娱乐业、E01二手车、E02二手机、F01汽车出租、F02汽车租赁、E04废旧金属、C机修业、X剧毒、E03典当、B印章
			Page page = qyxxExpImpDao.getListPubXmlMesPage(map, 1, onePageSize);
			int totalpage=page.getTotalPages();
			for(int index=1;index<=totalpage;index++){
				page = qyxxExpImpDao.getListPubXmlMesPage(map, index, onePageSize);
				contentRecord = createXmlMes(pdata, page.getData(), hylbdm,fileName); //文件数据内容
				XmlCreater.appendMethodA(fileName, contentRecord, oldChar, newChar); //数据内容
			}
			qyxxExpImpDao.updatePubxx(qyxxExpImp);
		}
		createWeiMes(fileName);
		return res;
	}
	
	/** 企业信息 部分 导出 */
	public boolean updateExpBufenQyxx(String[] qyidArr,String hylbdm) throws Exception {
		boolean res = true;
		QyxxExpImp temps = null;
		QyxxExpImp lgyXml = null;
		List templist = null;
		
		String fileName = createXmlFile();
		Document doc = XmlCreater.creatDocument();
		Element pdata = creteHeadAndDateXml(doc);
		createTouMes(doc, fileName);
		
		String contentRecord = "";
		
		for(int index=0,max=qyidArr.length;index<max;index++){ //文件数据内容
			temps = new QyxxExpImp();
			temps.setQyid(new Integer(Integer.parseInt(qyidArr[index])));
			temps.setDcsj(new Date());
			temps.setDcbs("1");
			temps.setHylbdm(hylbdm);
			if("A".equals(hylbdm)){ //旅馆
				qyxxExpImpDao.updateLgyxx(temps);
				templist = qyxxExpImpDao.getListLgyXmlMes(temps);
			}
			if("Z".equals(hylbdm)){ //出租房
				qyxxExpImpDao.updateCzfwyxx(temps);
				templist = qyxxExpImpDao.getListCzfwyXmlMes(temps);
			}
			if("J".equals(hylbdm)||"H".equals(hylbdm)||"E01".equals(hylbdm)||"E02".equals(hylbdm)||"E04".equals(hylbdm)||
					"F01".equals(hylbdm)||"F02".equals(hylbdm)||"C".equals(hylbdm)||"X".equals(hylbdm)||
					"E03".equals(hylbdm)||"B".equals(hylbdm)){
					//公用模块-JH娱乐业、E01二手车、E02二手机、F01汽车出租、F02汽车租赁、E04废旧金属、C机修、X剧毒、E03典当、B印章
				qyxxExpImpDao.updatePubxx(temps);
				templist = qyxxExpImpDao.getListPubXmlMes(temps);
			}
			if(templist!=null&&templist.size()>0){
				QyxxExpImp qyxxExpImp = (QyxxExpImp)templist.get(0);
				if(qyxxExpImp!=null&&qyxxExpImp.getGxdwbm()!=null){
					contentRecord += createRecodeXml(pdata, qyxxExpImp, hylbdm,fileName);
				}
			} else {
				res = false;
			}
		}
		XmlCreater.appendMethodA(fileName, contentRecord, oldChar, newChar); //数据内容
		createWeiMes(fileName);
		return res;
	}
	
	
	/** 上传 
	 * @throws Exception */
	public String uploadXmlMessage(List listNode) throws Exception{
		String result = "";
		QyxxExpImp qyxxExpImp = new QyxxExpImp();
		Element recode = null;
		
		int max = listNode.size();
		succNum = 0; errNum = 0;
		for(int index=0;index<max;index++){
			String resultTemp = "";
			recode = (Element)listNode.get(index);
			String qyfl = XmlReader.getNodeText(recode,"K_JXQYFL");
			String qybm = XmlReader.getNodeText(recode,"STATIONID");
			String sqbm = XmlReader.getNodeText(recode,"ENCODESTR");
			qyxxExpImp.setQybm(qybm);
			qyxxExpImp.setStationid(qybm);
			qyxxExpImp.setEncodestr(sqbm);
			qyxxExpImp.setHylbdm(qybm);
			
			resultTemp = uploadLicense(sqbm, index, qyxxExpImp); //已经存在企业：导入授权信息
			if("".equals(resultTemp)){
				if (qyfl.contains("A")){ //旅馆业编码不包含字母
					resultTemp = uploadInsertLgyQyxx(recode, index, qyxxExpImp);
				} else if (qyfl.contains("J")||qyfl.contains("H")||qyfl.contains("E01")||qyfl.contains("E02")||qyfl.contains("E04")||
						qyfl.contains("F01")||qyfl.contains("F02")||qyfl.contains("C")||qyfl.contains("X")||
						qyfl.contains("E03")||qyfl.contains("B")){
					//公用模块-JH娱乐业、E01二手车、E02二手机、F01汽车出租、F02汽车租赁、E04废旧金属、C机修业、X剧毒、E03典当、B印章
					resultTemp = uploadInsertPubQyxx(recode, index);
				}
				//如果不包含这些企业标志 那么直接导入授权信息 这种情况例如：导入管理员、公安等特殊需求的授权信息
				if("".equals(resultTemp)||resultTemp.contains("已经存在")){
					if(resultTemp.contains("旅馆")){
						upLgyWwtbbz(qyxxExpImp); //修改外网同步标志、授权码
					}
				}
			}
			result += resultTemp;
		}
		if(!"".equals(result)){
			result = "本次数据共 "+max+" 条,成功导入 "+succNum+" 条,失败 "+errNum+" 条. 下面是详细信息:\r\n"+result;
		}
		return result;
	}
	/** 上传授权LICENSE数据 */
	public String uploadLicense(String sqbm, int index, QyxxExpImp qyxxExpImp){
		String resultTemp = "";
		if(!"".equals(sqbm)){
			qyxxExpImpDao.deleteSjbdqxx(qyxxExpImp);
			qyxxExpImpDao.insertSjbdqxx(qyxxExpImp);
		} else {
			errNum++;
			resultTemp = "第 "+(index+1)+" 条数据上传失败:[ENCODESTR]授权码为空值.\r\n";
		}
		return resultTemp;
	}
	/**
	 * 上传旅馆业信息
	 */
	public String uploadInsertLgyQyxx(Element recode, int index, QyxxExpImp qyxxExpImp){
		String qysjlyyScpt = QjblUtil.queryQjblVal("qysjlyyScpt"); //企业数据来源于社采平台
		String result = "";
		String res = "";
		if(qyxxExpLgy==null){
			qyxxExpLgy = new QyxxExpLgyImpl();
		}
		if("0".equals(qysjlyyScpt)){ //来源于客服系统则导入企业数据,企业存在则变更外网同步标志、授权码
			res = qyxxExpLgy.uploadLvGaunQyxx(recode);
		} else { //来源于社采平台 修改外网同步标志、授权码
			res = qyxxExpLgy.uploadLvGaunSqxxVal(recode); //只留下验证功能
			if("".equals(res)){
				upLgyWwtbbz(qyxxExpImp);
			}
		}
		result += sucOrErrMessage(res, index);
		return result;
	}
	//修改旅馆业 外网同步标志
	public void upLgyWwtbbz(QyxxExpImp qyxxExpImp){
		qyxxExpImp.setWwtbbz("0");
		qyxxExpImpDao.updateLgyxx(qyxxExpImp);
	}
	/**
	 * 上传公共模块信息
	 */
	public String uploadInsertPubQyxx(Element recode, int index) throws Exception{
		String result = "";
		String qysjlyyScpt = QjblUtil.queryQjblVal("qysjlyyScpt"); //企业数据来源于社采平台
		if("0".equals(qysjlyyScpt)){ //不来源于社采平台，来源于客服系统则导入企业数据
			if(qyxxExpPub==null){
				qyxxExpPub = new QyxxExpPubImpl();
			}
			String res = qyxxExpPub.uploadPubQyxx(recode);
			result += sucOrErrMessage(res, index);
		}
		return result;
	}
	/**
	 * 上传典当业信息
	 */
	public String uploadInsertDdyQyxx(Element recode, int index) throws Exception{
		String result = "";
		String qysjlyyScpt = QjblUtil.queryQjblVal("qysjlyyScpt"); //企业数据来源于社采平台
		 
		if("0".equals(qysjlyyScpt)){ //不来源于社采平台，来源于客服系统则导入企业数据
			if(qyxxExpDdy==null){
				qyxxExpDdy = new QyxxExpDdyImpl();
			}
			String res = qyxxExpDdy.uploadDdyQyxx(recode);
			result += sucOrErrMessage(res, index);
		}
		return result;
	}
	/**
	 * 上传印章业信息
	 */
	public String uploadInsertYzyQyxx(Element recode, int index) throws Exception{
		String result = "";
		String qysjlyyScpt = QjblUtil.queryQjblVal("qysjlyyScpt"); //企业数据来源于社采平台
		 
		if("0".equals(qysjlyyScpt)){ //不来源于社采平台，来源于客服系统则导入企业数据
			if(qyxxExpYzy==null){
				qyxxExpYzy = new QyxxExpYzyImpl();
			}
			String res = qyxxExpYzy.uploadJxyQyxx(recode);
			result += sucOrErrMessage(res, index);
		}
		return result;
	}
	public String sucOrErrMessage(String res,int index){
		String result = "";
		if(!"".equals(res)){
			if(res.contains("已经存在")){
				succNum++;
				if(res.contains("旅馆")){
					result += "第 "+(index+1)+" 条数据成功上传了授权信息并修改外网同步标志，没有上传企业其他信息，因为"+res;
				} else {
					result += "第 "+(index+1)+" 条数据没有上传企业信息，只上传了授权信息，因为"+res;
				}
			} else{
				errNum++;
				result += "第 "+(index+1)+" 条数据上传失败:"+res;
			}
		} else {
			succNum++;
		}
		return result;
	}
	/**
	 * 向license表 添加数据
	 * @param qyxxExpImp
	 */
	public void uploadQysqxx(QyxxExpImp qyxxExpImp){
		qyxxExpImpDao.deleteSjbdqxx(qyxxExpImp);
		qyxxExpImpDao.insertSjbdqxx(qyxxExpImp);
	}
	
	public Element creteHeadAndDateXml(Document doc) throws Exception {
		String kfsjxzqydm = QjblUtil.queryQjblVal("kfsjxzqydm"); //区域代码
		String kfsjxzqymc = QjblUtil.queryQjblVal("kfsjxzqymc"); //区域名称
		Element root = XmlCreater.createElement(doc, "Package");
		Element phead = XmlCreater.createElement(root, "PackageHead");
		Element pdata = XmlCreater.createElement(root, "Data");
		XmlCreater.createElement(phead, "PROV_ID", kfsjxzqydm);
		XmlCreater.createElement(phead, "PROV_NAME", kfsjxzqymc);
		XmlCreater.createElement(phead, "BZ", "");
		return pdata;
	}
	
	public String xxqhdm(String sssf){
		Dict_item dict_item = new Dict_item();
		dict_item.setDict_code("dm_xzqh");
		dict_item.setDisplay_name(sssf);
		List list = CacheManager.getCacheDictitem(dict_item);
		if(list!=null&&list.size()>0){
			dict_item = (Dict_item)list.get(0);
		}
		return dict_item.getFact_value();
	}
	
	public String createXmlMes(Element pdata,List templist,String hylbdm,String fileName) throws Exception{
		String resContent = "";
		if(templist!=null&&templist.size()>0){
			for (int index = 0; index < templist.size(); index++) {
				QyxxExpImp qyxxExpImp = (QyxxExpImp)templist.get(index);
				if(qyxxExpImp!=null&&qyxxExpImp.getGxdwbm()!=null){
					resContent += createRecodeXml(pdata, qyxxExpImp, hylbdm,fileName);
				}
			}
		}
		return resContent;
	}
	
	public String createRecodeXml(Element pdata,QyxxExpImp qyxxExpImp,String hylbdm,String fileName) throws Exception{
		Element record = XmlCreater.createElement(pdata, "Record");
		XmlCreater.createElement(record, "K_KHLX", hylbdm); //客户类型
		recodeJibenxx(record, qyxxExpImp);
		if("A".equals(hylbdm)){ //旅馆
			XmlCreater.createElement(record, "K_KHCPLX", "20"); //**客户产品类型编码---
			
			XmlCreater.createElement(record, "K_FANGJIANSHU", qyxxExpImp.getFjs()); //房间数
			XmlCreater.createElement(record, "K_CHUANGWEISHU", qyxxExpImp.getCws()); //床位数
			XmlCreater.createElement(record, "K_GUANXINGJI", 
					("".equals(qyxxExpImp.getBgxj()))?"9":qyxxExpImp.getBgdj()); //**宾馆星级---
			XmlCreater.createElement(record, "K_GUANDENGJI", 
					("".equals(qyxxExpImp.getBgdj()))?"9":qyxxExpImp.getBgdj()); //**宾馆等级---
		} else if ("J".equals(hylbdm)||"H".equals(hylbdm)){ //娱乐 JH
			XmlCreater.createElement(record, "K_KHCPLX", "99"); //**客户产品类型编码---

			XmlCreater.createElement(record, "K_BAOXIANGSHU", qyxxExpImp.getBxsl()); //包厢数量数
			XmlCreater.createElement(record, "K_HEDINGXIAOFEIZHESHU", ""); //核定消费者数
			XmlCreater.createElement(record, "K_GETINGSHU", ""); //歌厅数
			XmlCreater.createElement(record, "K_WUCHISHU", qyxxExpImp.getBgdj()); //舞池数
			XmlCreater.createElement(record, "K_CHUKOUSHU", qyxxExpImp.getCksl()); //出口数量
		} else {
			XmlCreater.createElement(record, "K_KHCPLX", "99"); //**客户产品类型编码---
		}
		return XmlCreater.getXmlStringByXmlObj(record);
	}
	
	public void recodeJibenxx(Element record, QyxxExpImp jbxxExpImp){
		String zhuangtai = jbxxExpImp.getQyzt();
		zhuangtai = (zhuangtai==null||"".equals(zhuangtai))?"9":String.valueOf(Integer.parseInt(zhuangtai));
		String qyxz = jbxxExpImp.getQyxz();
		qyxz = (qyxz==null||"".equals(qyxz))?"03":"0"+String.valueOf(Integer.parseInt(qyxz));
		
		String gxdwbm = jbxxExpImp.getGxdwbm();
		String city = (gxdwbm!=null&&gxdwbm.length()>=4)?gxdwbm.substring(0, 4)+"00":"";
		String suozaiDiqu = (gxdwbm!=null&&gxdwbm.length()>=6)?gxdwbm.substring(0, 6):"";
		
		String ztgbrqs = jbxxExpImp.getQyztgbrq();
		String ztgbrq = (ztgbrqs!=null&&ztgbrqs.length()>=10)?ztgbrqs.substring(0, 10):"";
		
		XmlCreater.createElement(record, "K_JXQYFL", jbxxExpImp.getZflbm()); //企业分类 eg J01
		XmlCreater.createElement(record, "K_DAIMA", jbxxExpImp.getQybm()); //**客户代码---
		XmlCreater.createElement(record, "K_MINGCHENG", jbxxExpImp.getQymc()); //**客户名称---
		XmlCreater.createElement(record, "K_FARENMINGCHENG", jbxxExpImp.getFrxm()); //法人名称
		XmlCreater.createElement(record, "K_ZONGJINGLI", jbxxExpImp.getZjl()); //总经理
		
		XmlCreater.createElement(record, "K_ZHIANZERENREN", jbxxExpImp.getZafzr()); //制安责任人
		XmlCreater.createElement(record, "K_XIANGZHI", jbxxExpImp.getDizhi()); //详细地址
		XmlCreater.createElement(record, "K_LIANXIDIANHUA", jbxxExpImp.getLxdh()); //联系电话

		XmlCreater.createElement(record, "K_BAOANBUDIANHUA", jbxxExpImp.getBabdh()); //保安部电话
		XmlCreater.createElement(record, "K_CITY",city); //**市级行政区域代---
		XmlCreater.createElement(record, "K_SUOZAIDIQU",suozaiDiqu); //**区县级行政区域代码---
		
		XmlCreater.createElement(record, "K_ZHUANGTAI",zhuangtai); //**客户状态---
		XmlCreater.createElement(record, "K_ZTGBRQ", ztgbrq); //状态改变日期
		XmlCreater.createElement(record, "STATIONID", "30000"+(add+1)); //机器号(机器编码)
		add++;
		
		XmlCreater.createElement(record, "K_UPLOADTIME", "6:30"); //上传时间
		XmlCreater.createElement(record, "K_PAICHUSUOBM", jbxxExpImp.getGxdwbm()); //派出所编码
		XmlCreater.createElement(record, "K_PAICHUSUO", jbxxExpImp.getGxdwmc()); //派出所名称
		
		XmlCreater.createElement(record, "K_QIYEXINGZHI", qyxz); //**企业性质---
		XmlCreater.createElement(record, "K_CONGYERENSHU", jbxxExpImp.getCyrs()); //从业人数
		XmlCreater.createElement(record, "K_ZHIBAORENYUANSHU", jbxxExpImp.getZbrys()); //治保人员数
		
		XmlCreater.createElement(record, "K_JINGPEIXUNDE", jbxxExpImp.getJpxrs()); //经培训数
		XmlCreater.createElement(record, "K_GONGSIYEWURENYUAN", jbxxExpImp.getYwry()); //公司业务人员
		XmlCreater.createElement(record, "K_FWQKSRQ", ""); //服务期开始日期
		
		XmlCreater.createElement(record, "K_FWQJSRQ", ""); //服务期结束日期
		XmlCreater.createElement(record, "K_HTBH", jbxxExpImp.getHtbh()); //合同编号
		XmlCreater.createElement(record, "K_WLZK", "4"); //**网络状况---
		
		XmlCreater.createElement(record, "K_SFDR", "0"); //是否导入
		XmlCreater.createElement(record, "K_SHANCHU", "0"); //是否删除
	}
	/** 先生产文件 再追加内容 */
	public String createXmlFile(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String serviceFile = request.getRealPath("qyrzxxTemp");
		isNotFindFileCreate(serviceFile);
		long nowtime = System.currentTimeMillis();
		String fileName = serviceFile+"\\"+nowtime+".xml";
		session.setAttribute("qyxxKfFile", fileName);
		try {
			File fileXml = new File(fileName);
			fileXml.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	/**
	 * 头文件
	 * @param obj
	 * @param fileName
	 * @throws Exception
	 */
	public void createTouMes(Object obj,String fileName) throws Exception {
		String contentPdata = XmlCreater.getXmlStringByXmlObj(obj);
		contentPdata = contentPdata.replace(endCon, "");
		contentPdata = contentPdata.replace(startData, startData1);
		XmlCreater.appendMethodA(fileName, contentPdata, oldChar, newChar);
	}
	/**
	 * 文件收尾
	 * @param fileName
	 * @throws Exception
	 */
	public void createWeiMes(String fileName) throws Exception {
		XmlCreater.appendMethodA(fileName, endData, oldChar, newChar);
		XmlCreater.appendMethodA(fileName, endCon, oldChar, newChar);
	}
	
	public void isNotFindFileCreate(String fileName){
		File file = new File(fileName);
		if(!file.exists()){
			try {
				file.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setQyxxExpImpDao(IQyxxExpImpDao qyxxExpImpDao) {
		this.qyxxExpImpDao = qyxxExpImpDao;
	}
	
}
