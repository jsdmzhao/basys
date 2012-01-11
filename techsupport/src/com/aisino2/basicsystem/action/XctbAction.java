package com.aisino2.basicsystem.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.aisino2.basicsystem.domain.GxdwForTree;
import com.aisino2.basicsystem.domain.HylbForTree;
import com.aisino2.basicsystem.domain.Xctb;
import com.aisino2.basicsystem.domain.Xctb_fj;
import com.aisino2.basicsystem.domain.Xctbjsdw;
import com.aisino2.basicsystem.domain.YlcsjbxxForTree;
import com.aisino2.basicsystem.service.IDepartAndQiYeService;
import com.aisino2.basicsystem.service.IXctbService;
import com.aisino2.basicsystem.service.IXctb_fjService;
import com.aisino2.basicsystem.service.IXctbhfService;
import com.aisino2.basicsystem.service.IXctbjsdwService;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.json.JsonUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.sysadmin.service.IGlobalparService;
import com.opensymphony.xwork2.ActionContext;

public class XctbAction extends PageAction {
    private IXctbService xctbService;
    private IDict_itemService dict_itemService;
    private IDepartmentService departmentService;
    private IXctbhfService xctbhfService;
    private IXctbjsdwService xctbjsdwService;
    private IXctb_fjService xctb_fjService;
    private IGlobalparService globalparService;

    private IDepartAndQiYeService departAndQiYeService;

    private List lXctb = new ArrayList();
    private Xctb xctb = new Xctb();
    private String tabledata;
    private int totalrows;
    private String result = "";

    private User user;

    // ////////////////////////////////////////
    private String fileNamecon;
    private String base64codecon;
    private String fileTempNamecon;

    // //////////////////////////////////////////////////
    private String title;
    private File[] upload;
    private String[] uploadContentType;
    private String[] uploadFileName;

    // 接受依赖注入的属性
    private String savePath;

    // 接受依赖注入的方法
    public void setSavePath(String value) {
	this.savePath = value;
    }

    private String getSavePath() throws Exception {
	return ServletActionContext.getRequest().getRealPath(savePath);
    }

    public void setDepartAndQiYeService(
	    IDepartAndQiYeService departAndQiYeService) {
	this.departAndQiYeService = departAndQiYeService;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public void setUpload(File[] upload) {
	this.upload = upload;
    }

    public void setUploadContentType(String[] uploadContentType) {
	this.uploadContentType = uploadContentType;
    }

    public void setUploadFileName(String[] uploadFileName) {
	this.uploadFileName = uploadFileName;
    }

    public String getTitle() {
	return (this.title);
    }

    public File[] getUpload() {
	return (this.upload);
    }

    public String[] getUploadContentType() {
	return (this.uploadContentType);
    }

    public String[] getUploadFileName() {
	return (this.uploadFileName);
    }

    // /////////////////////////////

    public int getTotalrows() {
	return totalrows;
    }

    public void setTotalrows(int totalrows) {
	this.totalrows = totalrows;
    }

    public String getTabledata() {
	return tabledata;
    }

    public Xctb getXctb() {
	return xctb;
    }

    public List getLXctb() {
	return lXctb;
    }

    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }

    public void setXctbService(IXctbService xctbService) {
	this.xctbService = xctbService;
    }

    public void setTabledata(List lData) throws Exception {
	List lPro = new ArrayList();
	lPro.add("tbid");
	lPro.add("fbsj");
	lPro.add("fbdw");
	lPro.add("bt");
	lPro.add("fbr");
	lPro.add("gqbs");
	List lModify = new ArrayList();
	lModify.add("setModifyQueryxctb");
	lModify.add("修改");
	lModify.add("gqbs");
	lModify.add("0");

	List lDel = new ArrayList();
	lDel.add("setDelete");
	lDel.add("删除");

	List lXq = new ArrayList();
	lXq.add("setXiangQing");
	lXq.add("详情");

	List lCol = new ArrayList();
	lCol.add(lModify);
	lCol.add(lDel);
	lCol.add(lXq);
	Xctb getXctb = new Xctb();

	// this.setData(getXctb,lData,lPro,lCol);
	this.setDataCustomer(getXctb, lData, lPro, null, lCol);
	this.tabledata = this.getData();
	totalrows = this.getTotalrows();
    }

    public String querylist() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    Map map = new HashMap();

	    map.put("fbdwbm2", xctb.getFbdwbm());
	    map.put("bt", xctb.getBt());
	    map.put("fbr", xctb.getFbr());
	    map.put("gqbs", xctb.getGqbs());
	    map.put("fbkssj", xctb.getFbkssj());
	    map.put("fbjssj", xctb.getFbjssj());
	    map.put("sxhylbdm", xctb.getSxhylbdm());
	    // ///根据登陆用户 设置查询条件 只能查询本部门和所属部门的信息
	    ActionContext ctx = ActionContext.getContext();
	    HttpServletRequest request = (HttpServletRequest) ctx
		    .get(ServletActionContext.HTTP_REQUEST);
	    HttpSession session = request.getSession();
	    user = (User) session.getAttribute(Constants.userKey);
	    String depertCode0 = StringUtil.trimEven0(user.getDepartment()
		    .getDepartcode());
	    // 解决重庆铁路分局编码80开头的查询情况
	    int level = 0;
	    level = user.getDepartment().getDepartlevel();
	    if (level > 2) {
		map.put("fbdwbm", depertCode0);
	    }

	    // String userType = user.getUsertype(); ////用户类型

	    Page page = xctbService.getListForPage(map, pagesize, pagerow,
		    sort, dir);
	    totalpage = page.getTotalPages();
	    totalrows = page.getTotalRows();
	    lXctb = page.getData();
	    setTabledata(lXctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    public String query() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    xctb = xctbService.getXctb(xctb);
	    int tbid = xctb.getTbid();

	    // //start 查询接收单位名称
	    Xctbjsdw xctbjsdw = new Xctbjsdw();
	    xctbjsdw.setTbid(tbid);
	    List xctbjsdwList = xctbjsdwService.getListXctbjsdw(xctbjsdw);
	    String xctbjsdwStr = "";
	    for (int i = 0; i < xctbjsdwList.size(); i++) {
		xctbjsdw = (Xctbjsdw) xctbjsdwList.get(i);
		if ("".equals(xctbjsdwStr)) {
		    xctbjsdwStr += xctbjsdw.getJsdwmc();
		} else {
		    xctbjsdwStr += ";" + xctbjsdw.getJsdwmc();
		}
	    }
	    // System.out.println(xctbjsdwStr);
	    // ///end
	    xctb.setJsdwmc(xctbjsdwStr); // //传输接收单位名称

	    lXctb = new ArrayList();
	    lXctb.add(xctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}

	this.result = "success";
	return "success";
    }

    public String insert() throws Exception {

	try {
	    Xctb_fj xctbfj = new Xctb_fj();
	    Object[] child = { xctbfj };// / 绑定子属性

	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, child);
	    xctb.setGqbs("0"); // /////过期标志,0未过期，1过期
	    // System.out.println(xctb.getFbdwbm());

	    // /////////////start 协查通报接受单位数据
	    HttpSession session = ServletActionContext.getRequest()
		    .getSession();
	    List csjbxxList = (List) session.getAttribute("seesionCslist");
	    session.removeAttribute("seesionCslist");
	    xctb.setXctbjsdw(csjbxxList);
	    // //////////end

	    List xctbfjList = new ArrayList();
	    List fjinfoList = xctb.getLXctbfjList();
	    String serviceFile = ServletActionContext.getRequest().getRealPath(
		    "uploadTemp"); // /读取文件的目录

	    for (int i = 0; i < fjinfoList.size(); i++) {
		Xctb_fj xctb_fj = new Xctb_fj();
		xctbfj = (Xctb_fj) fjinfoList.get(i);
		String fjmc = xctbfj.getFjmc(); // 文件名称

		String[] fjlxarray = fjmc.split("\\.");
		String fjlx = fjlxarray[fjlxarray.length - 1]; // //得到附件类型

		String fjbase = xctbfj.getFjbase(); // /得到附件的临时文件名
		sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
		BufferedInputStream bis = null;
		byte[] fjnr = null; // /附件内容

		try {
		    bis = new BufferedInputStream(new FileInputStream(
			    serviceFile + "\\" + fjbase));
		    fjnr = new byte[bis.available()];
		    bis.read(fjnr);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    try {
			if (bis != null) {
			    bis.close();
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}

		// ///////删除临时文件夹中的文件
		File file = new File(serviceFile + "\\" + fjbase);
		if (file.exists()) {
		    file.delete(); // 删除文件
		}
		// ////////////////

		xctb_fj.setFjmc(fjmc);
		xctb_fj.setFjlx(fjlx);
		xctb_fj.setFjnr(fjnr);
		xctb_fj.setFjxh(i + 1);

		xctbfjList.add(xctb_fj);

	    }
	    xctb.setXctbfj(xctbfjList);
	    // ///end

	    xctb = xctbService.insertXctb(xctb);
	    xctb = null;
	    dataxml = null;
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = e.getMessage();
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    /**
     * 上传临时文件
     * 
     * @return
     * @throws Exception
     */
    public String uptempfile() throws Exception {

	BASE64Decoder base64Decoder = new BASE64Decoder();
	RandomAccessFile os = null;
	String serviceFile = ServletActionContext.getRequest().getRealPath(
		"uploadTemp"); // /文件存放路径

	long nowtime = System.currentTimeMillis(); // ///根据时间得到文件名字
	String[] fjlxarray = fileNamecon.split("\\.");
	String fjlx = fjlxarray[fjlxarray.length - 1]; // //得到附件类型
	String fileTempName = String.valueOf(nowtime) + "." + fjlx;
	try {
	    byte[] bytetemp = base64Decoder.decodeBuffer(base64codecon);
	    os = new RandomAccessFile(serviceFile + "\\" + fileTempName, "rw");
	    os.write(bytetemp, 0, bytetemp.length);
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (os != null) {
		    os.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	fileTempNamecon = fileTempName; // ///把临时文件的名字回传给页面
	base64codecon = "";
	this.result = "success";
	return "success";

    }

    /**
     * 删除单条临时文件
     * 
     * @return
     * @throws Exception
     */
    public String deleteFile() throws Exception {

	String serviceFile = ServletActionContext.getRequest().getRealPath(
		"uploadTemp"); // /文件存放路径
	File file = new File(serviceFile + "\\" + fileTempNamecon);
	if (file.exists()) {
	    file.delete(); // 删除文件
	}

	this.result = "success";
	return "success";
    }

    /**
     * 删除 本条通报的全部临时文件
     * 
     * @return
     * @throws Exception
     */
    public String deleteAllFile() throws Exception {

	try {
	    Xctb_fj xctbfj = new Xctb_fj();
	    Object[] child = { xctbfj };// / 绑定子属性
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, child);
	    List fjinfoList = xctb.getLXctbfjList();
	    String serviceFile = ServletActionContext.getRequest().getRealPath(
		    "uploadTemp"); // /读取文件的目录
	    for (int i = 0; i < fjinfoList.size(); i++) {
		xctbfj = (Xctb_fj) fjinfoList.get(i);
		String fjbase = xctbfj.getFjbase(); // /得到附件的临时文件名
		File file = new File(serviceFile + "\\" + fjbase);
		if (file.exists()) {
		    file.delete(); // 删除文件
		}
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    /**
     * 协查通报修改
     * 
     * @return
     * @throws Exception
     */
    public String modify() throws Exception {
	try {
	    Xctb_fj xctbfj = new Xctb_fj();
	    Object[] child = { xctbfj };// / 绑定子属性

	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, child);

	    // //附件 start
	    List xctbfjList = new ArrayList();
	    List fjinfoList = xctb.getLXctbfjList();
	    String serviceFile = ServletActionContext.getRequest().getRealPath(
		    "uploadTemp"); // /读取文件的目录

	    for (int i = 0; i < fjinfoList.size(); i++) {
		Xctb_fj xctb_fj = new Xctb_fj();
		xctbfj = (Xctb_fj) fjinfoList.get(i);
		String fjmc = xctbfj.getFjmc(); // 文件名称

		String[] fjlxarray = fjmc.split("\\.");
		String fjlx = fjlxarray[fjlxarray.length - 1]; // //得到附件类型

		String fjbase = xctbfj.getFjbase(); // /文件的base64码
		sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
		BufferedInputStream bis = null;
		byte[] fjnr = null; // /附件内容

		try {
		    bis = new BufferedInputStream(new FileInputStream(
			    serviceFile + "\\" + fjbase));
		    fjnr = new byte[bis.available()];
		    bis.read(fjnr);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    try {
			if (bis != null) {
			    bis.close();
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}

		// ///////删除临时文件夹中的文件
		File file = new File(serviceFile + "\\" + fjbase);
		if (file.exists()) {
		    file.delete(); // 删除文件
		}
		// ////////////////

		xctb_fj.setFjmc(fjmc);
		xctb_fj.setFjlx(fjlx);
		xctb_fj.setFjnr(fjnr);
		xctb_fj.setFjxh(i + 1);

		xctbfjList.add(xctb_fj);

	    }
	    xctb.setXctbfj(xctbfjList);
	    // ///附件 end

	    xctbService.updateXctb(xctb);
	    xctb = new Xctb();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}

	this.result = "success";
	return "success";
    }

    /**
     * 协查通报撤销
     * 
     * @return
     * @throws Exception
     */
    public String cxxctb() throws Exception {
	try {

	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);

	    xctbService.updateXctb(xctb);
	    xctb = new Xctb();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}

	this.result = "success";
	return "success";
    }

    public String delete() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);

	    /*
	     * xctb.setGqbs("1"); xctbService.updateXctb(xctb);
	     */
	    xctbService.deleteXctb(xctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    private String hylbstr;

    public String getHylbstr() {
	return hylbstr;
    }

    public void setHylbstr(String hylbstr) {
	this.hylbstr = hylbstr;
    }

    /**
     * 初始化 添加
     * 
     * @return
     * @throws Exception
     */
    public String initxctbAdd() throws Exception {

	ActionContext ctx = ActionContext.getContext();
	HttpServletRequest request = (HttpServletRequest) ctx
		.get(ServletActionContext.HTTP_REQUEST);
	HttpSession session = request.getSession();
	user = (User) session.getAttribute(Constants.userKey);

	String userType = user.getUsertype();
	int ylyflag = 0; // /娱乐业标识
	int ggcsflag = 0; // /公共场所标识
	int lgyflag = 0; // /旅馆业标识
	int ddyflag = 0; // /典当业标识

	int jxyflag = 0; // /机修业标识

	int yzyfalg = 0; // /印章业标识
	/************* New source add on 2010-1-5 begin **************/
	int esjflag = 0; // 二手机业标识
	int escflag = 0; // 二手车业标识
	/************* New source add on 2010-1-5 end **************/
	int fjjsflag = 0; // 废旧金属标识
	int czcflag = 0; // 出租车
	int qczlflag = 0; // 汽车租赁
	int czfflag = 0; // 出租房行业

	int jdhxpflag = 0; // 剧毒化学品行业
	int zddwflag = 0; // 重点单位

	int wtjmflag = 0; // 委托寄卖
	int jdccjflag = 0; // 机动车拆解

	String[] utype = userType.split(",");
	for (int i = 0; i < utype.length; i++) {
	    if ("11".equals(utype[i]))
		ylyflag = 1;
	    if ("12".equals(utype[i]))
		ylyflag = 1;
	    if ("13".equals(utype[i]))
		ylyflag = 1;
	    if ("14".equals(utype[i]))
		ylyflag = 1;

	    if ("141".equals(utype[i]) || "142".equals(utype[i])
		    || "143".equals(utype[i]) || "144".equals(utype[i]))
		ggcsflag = 1;

	    if ("24".equals(utype[i]))
		lgyflag = 1;

	    if ("33".equals(utype[i]))
		ddyflag = 1;
	    if ("34".equals(utype[i]))
		ddyflag = 1;

	    if ("44".equals(utype[i]))
		jxyflag = 1;

	    if ("51".equals(utype[i]))
		yzyfalg = 1;
	    /************* New source add on 2010-1-5 begin **************/
	    if ("64".equals(utype[i]))
		escflag = 1;

	    if ("74".equals(utype[i]))
		esjflag = 1;
	    /************* New source add on 2010-1-5 end **************/
	    if ("84".equals(utype[i]))
		fjjsflag = 1;
	    if ("94".equals(utype[i]))
		czcflag = 1;
	    if ("104".equals(utype[i]))
		qczlflag = 1;

	    if ("91".equals(utype[i]))
		czfflag = 1;
	    // modified by mds at 20100304
	    if ("112".equals(utype[i]))
		jdhxpflag = 1;
	    if ("113".equals(utype[i]))
		jdhxpflag = 1;
	    if ("114".equals(utype[i]))
		jdhxpflag = 1;
	    if ("121".equals(utype[i]))
		zddwflag = 1;
	    if ("122".equals(utype[i]))
		zddwflag = 1;
	    if ("154".equals(utype[i]))
		jdccjflag = 1;
	    if ("164".equals(utype[i]))
		wtjmflag = 1;
	}

	// String userhylx = user.getUsertypename();
	// System.out.println(userhylx);

	Dict_item dict_item = new Dict_item();
	dict_item.setDict_code("dm_hylb");

	List hylblist = dict_itemService.getListDict_item(dict_item);
	hylbstr = "";
	for (int i = 0; i < hylblist.size(); i++) {
	    dict_item = (Dict_item) hylblist.get(i);
	    if ("A".equals(dict_item.getFact_value())) {// 旅馆业
		if (lgyflag == 1)
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
	    } else if ("J".equals(dict_item.getFact_value())) {// 娱乐业
		if (ylyflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("K".equals(dict_item.getFact_value())) {// 公共场所
		if (ggcsflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("E03".equals(dict_item.getFact_value())) {// 典当业
		if (ddyflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("C".equals(dict_item.getFact_value())) {// 机修业
		if (jxyflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("B".equals(dict_item.getFact_value())) {// 印章业
		if (yzyfalg == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
		/************* New source add on 2010-1-5 begin **************/
	    } else if ("E01".equals(dict_item.getFact_value())) {// 二手车业
		if (escflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("E02".equals(dict_item.getFact_value())) {// 二手机业
		if (esjflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("E04".equals(dict_item.getFact_value())) {// 废旧金属
		if (fjjsflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("F01".equals(dict_item.getFact_value())) {// 出租车
		if (czcflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("F02".equals(dict_item.getFact_value())) {// 汽车租赁
		if (qczlflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("Z".equals(dict_item.getFact_value())) {// 出租房行业
		if (czfflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("X".equals(dict_item.getFact_value())) {// 剧毒化学品
		if (jdhxpflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		    ;
		}
	    } else if ("N".equals(dict_item.getFact_value())) {// 内保单位
		if (zddwflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		    ;
		}
	    } else if ("E07".equals(dict_item.getFact_value())) {// 委托寄卖业
		if (wtjmflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    } else if ("C01".equals(dict_item.getFact_value())) {// 机动车拆解业
		if (jdccjflag == 1) {
		    hylbstr += "<input type=\"checkbox\" name=\""
			    + dict_item.getDisplay_name()
			    + "\" id=\""
			    + dict_item.getFact_value()
			    + "\" class=\"checkbox\" onclick=\"gethylb(this);\" />"
			    + dict_item.getDisplay_name();
		}
	    }
	}
	// System.out.println(hylbstr);
	this.result = "success";
	return "success";
    }

    /**
     * 初始化 修改
     * 
     * @return
     * @throws Exception
     */
    public String initxctbupdate() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    xctb = xctbService.getXctb(xctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	this.result = "success";
	return "success";
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public void setDict_itemService(IDict_itemService dict_itemService) {
	this.dict_itemService = dict_itemService;
    }

    private String id;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    // /////////////////////////////////////////////////部门树部分 start
    /**
     * 生成部门树
     * 
     * @throws Exception
     */

    private String hylbdmall;

    public String getHylbdmall() {
	return hylbdmall;
    }

    public void setHylbdmall(String hylbdmall) {
	this.hylbdmall = hylbdmall;
    }

    public void tree2() throws Exception {

	// id = null;
	List departlistshow = new ArrayList();
	List cslist = new ArrayList(); // /场所叶子节点的list
	List hylblist = new ArrayList(); // //行业类别的节点
	Map condition = new HashMap();
	Department depart = new Department();

	// ////start
	String hylbflag = ""; // ///行业类别标志 在公安机关每一级的id前加上行业类别标志的字母如Y32
	if (id != null) {
	    hylbflag = id.substring(0, 1);
	}
	// ////end

	if (id == null) {

	    String hylbauth = ""; // 权限字段
	    String[] arrHylbAuth = null;
	    if (hylbdmall != null) {
		hylbauth = hylbdmall;
		arrHylbAuth = hylbauth.split(";");
	    }
	    Dict_item dict_item = new Dict_item();
	    dict_item.setDict_code("dm_hylb");
	    List hylblistshow = dict_itemService.getListDict_item(dict_item);

	    // //只显示选择的行业
	    for (int u = 0; u < hylblistshow.size(); u++) {
		Dict_item testdict = new Dict_item();
		testdict = (Dict_item) hylblistshow.get(u);

		/************* New source modify on 2010-1-5 begin **************/
		if (arrHylbAuth != null) {
		    for (int index = 0; index < arrHylbAuth.length; index++) {
			if (arrHylbAuth[index].equals(testdict.getFact_value())) {
			    hylblist.add(testdict);
			}
		    }
		}
		/************* New source modify on 2010-1-5 end **************/
	    }
	    // //

	    if (hylblist == null) {
		hylblist = new ArrayList();
	    }
	    id = Integer.toString(0);

	    /************* New source modify on 2010-1-5 begin **************/
	} else if ("*".equals(id.substring(0, 1))) { // 行业类别根节点
	    hylbflag = id.substring(1, 2);
	    if ("E".equals(hylbflag) || "F".equals(hylbflag)) { // 行业类别为旧货业时，行业类别为E01二手车；E02二手机；E03典当
								// F01 出租车 F02
								// 汽车租赁
		hylbflag = id.substring(1, 4);
	    } else if ("C01".equals(id.substring(1))) {// 机动车拆解
		hylbflag = id.substring(1);
	    }

	    /************* New source modify on 2010-1-5 end **************/
	    ActionContext ctx = ActionContext.getContext();
	    HttpServletRequest request = (HttpServletRequest) ctx
		    .get(ServletActionContext.HTTP_REQUEST);
	    HttpSession session = request.getSession();
	    User user = (User) session.getAttribute(Constants.userKey);
	    Department userdepartment = new Department();
	    userdepartment.setDepartid(user.getDepartid());
	    userdepartment = departmentService.getDepartment(userdepartment);
	    departlistshow.add(userdepartment);

	} else { // 公安根节点
	    String departid = id.substring(1, id.length());// /部门id
	    /************* New source modify on 2010-1-5 begin **************/
	    if ("E".equals(hylbflag) || "F".equals(hylbflag)) { // 行业类别为旧货业时，行业类别为E01二手车；E02二手机；E03典当
		hylbflag = id.substring(0, 3);
		departid = id.substring(3);
	    } else if (id.indexOf("C01") != -1) {// 机动车拆解
		hylbflag = id.substring(0, 3);
		departid = id.substring(3);
	    }

	    /************* New source modify on 2010-1-5 end **************/
	    depart.setDepartid(Integer.parseInt(departid)); // 除去第一个字母才是部门id
	    depart = departmentService.getDepartment(depart);
	    String departCode = depart.getDepartcode(); // 得到部门编码
	    String departCodetrim = StringUtil.trimEven0(departCode); // ///去掉后边0的部门编码

	    /************* New source modify on 2010-1-5 begin **************/
	    departlistshow = getdepartListall("departid", departid,
		    "departcode", departCodetrim, hylbflag); // //访问印章业的action
							     // 得到部门
	    cslist = getdataListall("gxdwbm", departCode, "isAllGxdwbm", "1",
		    hylbflag); // /访问典当业的action 得到下属的印章企业
	    /************* New source modify on 2010-1-5 begin **************/
	    if (departlistshow == null) {
		departlistshow = new ArrayList();
	    }
	    if (cslist == null) {
		cslist = new ArrayList();
	    }
	}

	String xml = "<?xml version='1.0' encoding='utf-8'?> \n";
	xml += "<tree id=\"" + id + "\"> \n";
	// ///行业类别
	for (int i = 0; i < hylblist.size(); i++) {
	    Dict_item dict_item = (Dict_item) hylblist.get(i);
	    xml += "<item text=\""
		    + dict_item.getDisplay_name()
		    + "\" id=\""
		    + "*"
		    + dict_item.getFact_value()
		    + "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
	    xml += "child=\"1\">\n";
	    xml += "</item>\n";
	}

	// /公安机关
	for (int i = 0; i < departlistshow.size(); i++) {
	    Department department = (Department) departlistshow.get(i);
	    xml += "<item text=\""
		    + department.getDepartname()
		    + "\" id=\""
		    + hylbflag
		    + Integer.toString(department.getDepartid())
		    + "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
	    xml += "child=\"1\">\n";
	    xml += "</item>\n";
	}

	// //场所节点
	for (int n = 0; n < cslist.size(); n++) {
	    YlcsjbxxForTree ylcs1 = new YlcsjbxxForTree();
	    ylcs1 = (YlcsjbxxForTree) cslist.get(n);
	    // ///userdata 字符串 场所编码||场所名称||行业类别编码||行业类别名称
	    String userdateStr = ylcs1.getHylxbm() + "||" + ylcs1.getHylxmc();
	    xml += "<item text=\""
		    + ylcs1.getCsmc()
		    + "\" id=\""
		    + "-"
		    + ylcs1.getCsbm()
		    + "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
	    xml += "child=\"0\">\n";

	    xml += "<userdata name=\"" + "-" + ylcs1.getCsbm() + "\">"
		    + userdateStr + "</userdata>\n";
	    xml += "</item>\n";
	}
	xml += "</tree>";
	// System.out.println(xml);

	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("application/xml;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.print(xml);
	// 关闭流
	out.close();

	id = null;
    }

    /**
     * 访问其他工程的action方法 得到指定管辖单位及其下属管辖单位下所有企业
     * 
     * @return
     */
    public List getdataListall(String keyvalue, String para, String keyvalue2,
	    String para2, String hylxdm) {
	List dataList = new ArrayList();

	List lParam = new ArrayList();
	List lChild = new ArrayList();
	List lChildRow = new ArrayList();
	List lChildRows = new ArrayList();
	List lChilds = new ArrayList();

	List lColValue = new ArrayList();
	lColValue.add(keyvalue);
	lColValue.add(para);
	lParam.add(lColValue);
	lColValue = new ArrayList();
	lColValue.add(keyvalue2);
	lColValue.add(para2);
	lParam.add(lColValue);

	Globalpar globalpar = new Globalpar();

	/************* New source modify on 2010-1-5 begin **************/
	dataxml = JsonUtil.getXML(lParam, lChilds);
	YlcsjbxxForTree ylcsjbxxForTree = new YlcsjbxxForTree();
	try {
	    ylcsjbxxForTree = (YlcsjbxxForTree) this.setClass(ylcsjbxxForTree,
		    null);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	dataList = departAndQiYeService.QyTreeList(ylcsjbxxForTree, hylxdm);
	/************* New source modify on 2010-1-5 end **************/
	return dataList;
    }

    /**
     * 访问其他工程的action方法 获得含有企业或其下属管辖单位含有企业的管辖单位
     * 
     * @return
     */
    public List getdepartListall(String keyvalue, String para,
	    String keyvalue2, String para2, String hylxdm) {
	List dataList = new ArrayList();

	List lParam = new ArrayList();
	List lChild = new ArrayList();
	List lChildRow = new ArrayList();
	List lChildRows = new ArrayList();
	List lChilds = new ArrayList();

	List lColValue = new ArrayList();
	lColValue.add(keyvalue);
	lColValue.add(para);
	lParam.add(lColValue);
	lColValue = new ArrayList();
	lColValue.add(keyvalue2);
	lColValue.add(para2);
	lParam.add(lColValue);

	Globalpar globalpar = new Globalpar();
	/************* New source modify on 2010-1-5 begin **************/
	dataxml = JsonUtil.getXML(lParam, lChilds);
	Department department = new Department();
	try {
	    department = (Department) this.setClass(department, null);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	dataList = departAndQiYeService.ChildDepartmentForTree(department,
		hylxdm);
	/************* New source modify on 2010-1-5 end **************/
	return dataList;
    }

    /**
     * 根据部门树的选择 返回场所信息
     * 
     * @throws Exception
     */
    private String reXml;

    public String getReXml() {
	return reXml;
    }

    public void setReXml(String reXml) {
	this.reXml = reXml;
    }

    /************* New source modify on 2010-1-5 begin **************/
    public String treeCs() throws Exception {
	// //解析id值
	String alldepartid = id; // /返回部门节点的id 第一位是行业类型的编码 后边是公安部门的部门id
	String hylxflag = id.substring(0, 1); // //行业类型编码

	List<YlcsjbxxForTree> cslist = new ArrayList(); // /场所叶子节点的list
	Department depart = new Department();

	if ("*".equals(hylxflag)) { // 行业类别根节点
	    hylxflag = id.substring(1, 2);
	    if ("E".equals(hylxflag) || "F".equals(hylxflag)) { // 行业类别为旧货业时，行业类别为E01二手车；E02二手机；E03典当
		hylxflag = id.substring(1, 4);
	    } else if ("C01".equals(id.substring(1))) {// 机动车拆解
		hylxflag = id.substring(1);
	    }

	    // /树点击的是 是顶端的行业类别
	    ActionContext ctx = ActionContext.getContext();
	    HttpServletRequest request = (HttpServletRequest) ctx
		    .get(ServletActionContext.HTTP_REQUEST);
	    HttpSession session = request.getSession();
	    user = (User) session.getAttribute(Constants.userKey);
	    depart = user.getDepartment();

	    cslist = getdataListall("gxdwbm", depart.getDepartcode(),
		    "isAllGxdwbm", "0", hylxflag); // /访问印章业的action
	    // 得到行业的机修业当企业(根据用户权限)
	} else {
	    String departid = id.substring(1); // /部门id
	    if ("E".equals(hylxflag) || "F".equals(hylxflag)) { // 行业类别为旧货业时，行业类别为E01二手车；E02二手机；E03典当
		hylxflag = id.substring(0, 3);
		departid = id.substring(3);
	    } else if (id.indexOf("C01") != -1) {// 机动车拆解
		hylxflag = id.substring(0, 3);
		departid = id.substring(3);
	    }
	    depart.setDepartid(Integer.parseInt(departid));
	    depart = departmentService.getDepartment(depart);
	    String departCode = depart.getDepartcode(); // 得到部门编码

	    cslist = getdataListall("gxdwbm", departCode, "isAllGxdwbm", "0",
		    hylxflag); // 访问action 得到该部门下的全部企业
	}
	if (cslist == null) {
	    cslist = new ArrayList();
	}
	HttpSession session = ServletActionContext.getRequest().getSession();
	List<YlcsjbxxForTree> sessionCsList = (List) session
		.getAttribute("seesionCslist");
	// sessionCsList.remove(o)
	int listLength = cslist.size();
	YlcsjbxxForTree ylcs1;
	if (sessionCsList != null && sessionCsList.size() > 0) {
	    int seListLength = sessionCsList.size();

	    if (listLength == seListLength) {
		cslist.clear();
	    }
	    listLength = cslist.size();
	}
	reXml = "";
	int firstLength = 15 > listLength ? listLength : 15;
	for (int index = 0; index < firstLength; index++) {
	    ylcs1 = (YlcsjbxxForTree) cslist.get(index);
	    reXml += ylcs1.getCsmc() + ";";
	}
	session.setAttribute("seesionCslist", cslist);
	cslist = null;
	sessionCsList = null;
	id = null;
	return "success";

    }

    /************* New source modify on 2010-1-5 end **************/
    public String treeQiye() throws Exception {
	YlcsjbxxForTree ylcsjbxxForTree = new YlcsjbxxForTree();
	ylcsjbxxForTree = (YlcsjbxxForTree) this
		.setClass(ylcsjbxxForTree, null);
	Map map = new HashMap();
	map.put("hylbbm", ylcsjbxxForTree.getHylxbm());
	map.put("qybms", ylcsjbxxForTree.getCsbm());
	List<GxdwForTree> lGxdwForTree = xctbService.getQydwList(map);

	YlcsjbxxForTree temp = new YlcsjbxxForTree();
	if (lGxdwForTree != null && lGxdwForTree.size() > 0) {
	    GxdwForTree getGxdwForTree = lGxdwForTree.get(0);
	    temp.setCsmc(getGxdwForTree.getQymc());
	    temp.setCsbm(getGxdwForTree.getQybm());
	    temp.setHylxbm(getGxdwForTree.getHylbbm());
	    temp.setHylxmc(getGxdwForTree.getHylbmc());
	    temp.setGxdwbm(getGxdwForTree.getGxdwbm());
	    temp.setGxdwmc(getGxdwForTree.getGxdwmc());
	}

	HttpSession session = ServletActionContext.getRequest().getSession();
	List<YlcsjbxxForTree> sessionCsList = (List) session
		.getAttribute("seesionCslist");
	if (sessionCsList != null && sessionCsList.size() > 0) {
	    sessionCsList.remove(temp);
	    if (reXml != null && reXml.equals("1"))
		sessionCsList.add(temp);
	} else {
	    sessionCsList = new ArrayList();
	    sessionCsList.add(temp);
	}
	reXml = "";
	int listLength = sessionCsList.size();
	int firstLength = 15 > listLength ? listLength : 15;
	for (int index = 0; index < firstLength; index++) {
	    ylcsjbxxForTree = (YlcsjbxxForTree) sessionCsList.get(index);
	    reXml += ylcsjbxxForTree.getCsmc() + ";";
	}
	session.setAttribute("seesionCslist", sessionCsList);
	sessionCsList = null;
	return "success";
    }

    public String clearQiye() throws Exception {
	HttpSession session = ServletActionContext.getRequest().getSession();
	session.removeAttribute("seesionCslist");
	return "success";
    }

    // ///////////////////////////////////////////部门树部分 end

    public void setDepartmentService(IDepartmentService departmentService) {
	this.departmentService = departmentService;
    }

    public void setXctbhfService(IXctbhfService xctbhfService) {
	this.xctbhfService = xctbhfService;
    }

    public void setXctbjsdwService(IXctbjsdwService xctbjsdwService) {
	this.xctbjsdwService = xctbjsdwService;
    }

    // ////////////////////////////协查通报查询 start
    /**
     * 协查通报查询
     * 
     * @return
     * @throws Exception
     */
    public String querylistcx() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    Map map = new HashMap();

	    map.put("fbdwbm2", xctb.getFbdwbm());
	    map.put("bt", xctb.getBt());
	    map.put("fbr", xctb.getFbr());
	    map.put("gqbs", xctb.getGqbs());
	    map.put("fbkssj", xctb.getFbkssj());
	    map.put("fbjssj", xctb.getFbjssj());
	    map.put("sxhylbdm", xctb.getSxhylbdm());
	    // ///根据登陆用户 设置查询条件 只能查询本部门和所属部门的信息
	    String fbdwbm = xctb.getFbdwbm();
	    HttpSession session = ServletActionContext.getRequest()
		    .getSession();
	    user = (User) session.getAttribute(Constants.userKey);
	    if (fbdwbm == null || fbdwbm.equals("")) {
		fbdwbm = user.getDepartment().getDepartcode();
	    }
	    // 解决重庆铁路分局编码80开头的查询情况
	    int level = 0;
	    level = user.getDepartment().getDepartlevel();
	    if (level > 2) {
		map.put("fbdwbm", StringUtil.trimEven0(fbdwbm));
	    }
	    Page page = xctbService.getListForPage(map, pagesize, pagerow,
		    sort, dir);
	    totalpage = page.getTotalPages();
	    totalrows = page.getTotalRows();
	    lXctb = page.getData();
	    setTabledatacx(lXctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    public void setTabledatacx(List lData) throws Exception {
	List lPro = new ArrayList();
	lPro.add("tbid");
	lPro.add("fbsj");
	lPro.add("fbdw");
	lPro.add("bt");
	lPro.add("fbr");
	List lXq = new ArrayList();
	lXq.add("setXiangQing");
	lXq.add("详情");
	List lCol = new ArrayList();
	lCol.add(lXq);
	Xctb getXctb = new Xctb();
	this.setData(getXctb, lData, lPro, lCol);
	this.tabledata = this.getData();
	totalrows = this.getTotalrows();
    }

    // /////////////////////////////////end

    /*
     * 内保单位公安端首页连接使用
     */
    public String querylistCxNb() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    Map map = new HashMap();
	    map.put("bt", xctb.getBt());
	    map.put("fbr", xctb.getFbr());
	    map.put("gqbs", xctb.getGqbs());
	    map.put("fbkssj", xctb.getFbkssj());
	    map.put("fbjssj", xctb.getFbjssj());
	    map.put("sxhylbdm", xctb.getSxhylbdm());
	    // ///根据登陆用户 设置查询条件 只能查询本部门和所属部门的信息
	    String fbdwbm = xctb.getFbdwbm();
	    if (fbdwbm == null || fbdwbm.equals("")) {
		HttpSession session = ServletActionContext.getRequest()
			.getSession();
		user = (User) session.getAttribute(Constants.userKey);
		fbdwbm = user.getDepartment().getDepartcode();
	    }

	    map.put("fbdwbm", StringUtil.trimEven0(fbdwbm));

	    Page page = xctbService.getListForPage(map, pagesize, pagerow,
		    sort, dir);
	    totalpage = page.getTotalPages();
	    totalrows = page.getTotalRows();
	    lXctb = page.getData();
	    setTabledatacx(lXctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    // ////////////////////////////协查通报回复情况查看 start
    /**
     * 协查通报回复查看
     */
    public String querylistreplay() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    Map map = new HashMap();

	    map.put("fbdwbm2", xctb.getFbdwbm());
	    map.put("bt", xctb.getBt());
	    map.put("fbr", xctb.getFbr());
	    map.put("gqbs", xctb.getGqbs());
	    map.put("fbkssj", xctb.getFbkssj());
	    map.put("fbjssj", xctb.getFbjssj());
	    map.put("sxhylbdm", xctb.getSxhylbdm());
	    // ///根据登陆用户 设置查询条件 只能查询本部门和所属部门的信息
	    ActionContext ctx = ActionContext.getContext();
	    HttpServletRequest request = (HttpServletRequest) ctx
		    .get(ServletActionContext.HTTP_REQUEST);
	    HttpSession session = request.getSession();
	    user = (User) session.getAttribute(Constants.userKey);
	    map.put("fbdwbm", StringUtil.trimEven0(user.getDepartment()
		    .getDepartcode()));

	    Page page = xctbService.getListForPage(map, pagesize, pagerow,
		    sort, dir);
	    totalpage = page.getTotalPages();
	    totalrows = page.getTotalRows();
	    lXctb = page.getData();
	    setTabledatareply(lXctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    public void setTabledatareply(List lData) throws Exception {
	List lPro = new ArrayList();
	lPro.add("tbid");
	lPro.add("fbsj");
	lPro.add("fbdw");
	lPro.add("bt");
	lPro.add("fbr");

	List read = new ArrayList();
	read.add("readstatus");
	read.add("阅读情况");
	List replay = new ArrayList();
	replay.add("replaystatus");
	replay.add("回复情况");

	List lXq = new ArrayList();
	lXq.add("setXiangQing");
	lXq.add("详情");

	List lCol = new ArrayList();
	lCol.add(read);
	lCol.add(replay);
	lCol.add(lXq);

	Xctb getXctb = new Xctb();
	this.setData(getXctb, lData, lPro, lCol);
	this.tabledata = this.getData();
	totalrows = this.getTotalrows();
    }

    // /////////////////////////////////end

    // ////////////////////////////协查通报撤销 start
    /**
     * 协查通报撤销
     */
    public String querylistdis() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    Map map = new HashMap();

	    map.put("fbdwbm2", xctb.getFbdwbm());
	    map.put("bt", xctb.getBt());
	    map.put("fbr", xctb.getFbr());
	    map.put("gqbs", xctb.getGqbs());
	    map.put("fbkssj", xctb.getFbkssj());
	    map.put("fbjssj", xctb.getFbjssj());
	    map.put("sxhylbdm", xctb.getSxhylbdm());
	    // ///根据登陆用户 设置查询条件 只能查询本部门和所属部门的信息
	    ActionContext ctx = ActionContext.getContext();
	    HttpServletRequest request = (HttpServletRequest) ctx
		    .get(ServletActionContext.HTTP_REQUEST);
	    HttpSession session = request.getSession();
	    user = (User) session.getAttribute(Constants.userKey);
	    map.put("fbdwbm", StringUtil.trimEven0(user.getDepartment()
		    .getDepartcode()));

	    Page page = xctbService.getListForPage(map, pagesize, pagerow,
		    sort, dir);
	    totalpage = page.getTotalPages();
	    totalrows = page.getTotalRows();
	    lXctb = page.getData();
	    setTabledatadis(lXctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    public void setTabledatadis(List lData) throws Exception {
	List lPro = new ArrayList();
	lPro.add("tbid");
	lPro.add("fbsj");
	lPro.add("fbdw");
	lPro.add("bt");
	lPro.add("fbr");

	List lCol = new ArrayList();
	List dis = new ArrayList();
	dis.add("tbid"); // //只是一个表示
	dis.add("撤销");
	dis.add("gqbs");
	dis.add("0");
	lCol.add(dis);

	List lXq = new ArrayList();
	lXq.add("setXiangQing");
	lXq.add("详情");

	lCol.add(lXq);

	/*
	 * List lCol=new ArrayList(); List dis =new ArrayList();
	 * dis.add("disfork"); dis.add("撤销"); lCol.add(dis);
	 */

	Xctb getXctb = new Xctb();
	// this.setData(getXctb,lData,lPro,lCol);
	this.setDataCustomer(getXctb, lData, lPro, null, lCol);

	this.tabledata = this.getData();
	totalrows = this.getTotalrows();
    }

    // /////////////////////////////////end

    // ////////////////////////////场所协查通报回复 start

    /**
     * 协查通报回复查看 场所
     */
    public String querylistcs() throws Exception {

	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    Map map = new HashMap();

	    map.put("bt", xctb.getBt());
	    map.put("gqbs", "0");
	    map.put("fbkssj", xctb.getFbkssj());
	    map.put("fbjssj", xctb.getFbjssj());

	    ActionContext ctx = ActionContext.getContext();
	    HttpServletRequest request = (HttpServletRequest) ctx
		    .get(ServletActionContext.HTTP_REQUEST);
	    HttpSession session = request.getSession();
	    user = (User) session.getAttribute(Constants.userKey);

	    /*
	     * String userType = user.getUsertype(); String useraccount =
	     * user.getUseraccount();
	     * if("B02".equals(useraccount.substring(0,3))){ map.put("jsdwbm",
	     * user.getUseraccount().substring(0,15)); }else{ map.put("jsdwbm",
	     * user.getUseraccount().substring(0,14)); }
	     */

	    map.put("jsdwbm", user.getSsdwbm());

	    Page page = xctbService.getcsListForPage(map, pagesize, pagerow,
		    sort, dir);
	    totalpage = page.getTotalPages();
	    totalrows = page.getTotalRows();
	    lXctb = page.getData();
	    setTabledatacs(lXctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    public void setTabledatacs(List lData) throws Exception {
	List lPro = new ArrayList();
	lPro.add("tbid");
	lPro.add("fbsj");
	lPro.add("fbdw");
	lPro.add("bt");
	lPro.add("fbr");

	List replay = new ArrayList();
	replay.add("set_replay");
	replay.add("回复");
	List replaydetail = new ArrayList();
	replaydetail.add("replaystatus");
	replaydetail.add("回复情况");

	List lXq = new ArrayList();
	lXq.add("setXiangQing");
	lXq.add("详情");

	List lCol = new ArrayList();
	lCol.add(replay);
	lCol.add(replaydetail);
	lCol.add(lXq);

	Xctb getXctb = new Xctb();
	this.setData(getXctb, lData, lPro, lCol);
	this.tabledata = this.getData();
	totalrows = this.getTotalrows();
    }

    // //////////////////end

    /**
     * 协查通报查看首页关联
     */
    public String querylistSygl() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    Map map = new HashMap();

	    map.put("jsdwbm", xctb.getJsdwbm());

	    Page page = xctbService.getcsListForPage(map, pagesize, pagerow,
		    sort, dir);
	    totalpage = page.getTotalPages();
	    totalrows = page.getTotalRows();
	    lXctb = page.getData();
	    setTabledataSygl(lXctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    public void setTabledataSygl(List lData) throws Exception {
	List lPro = new ArrayList();
	lPro.add("tbid");
	lPro.add("fbsj");
	lPro.add("fbdw");
	lPro.add("bt");
	lPro.add("fbr");

	List lXq = new ArrayList();
	lXq.add("setXiangQing");
	lXq.add("详情");

	List lCol = new ArrayList();
	lCol.add(lXq);

	Xctb getXctb = new Xctb();
	this.setData(getXctb, lData, lPro, lCol);
	this.tabledata = this.getData();
	totalrows = this.getTotalrows();
    }

    // //////////////////end
    public String querylistFortitile() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    ActionContext ctx = ActionContext.getContext();
	    HttpServletRequest request = (HttpServletRequest) ctx
		    .get(ServletActionContext.HTTP_REQUEST);
	    HttpSession session = request.getSession();
	    user = (User) session.getAttribute(Constants.userKey);
	    String fullcode = user.getDepartment().getDepartfullcode();
	    String[] fullcodes = fullcode.split(".");
	    String fbdwbms = "";
	    for (int i = 0; i < fullcodes.length; i++) {
		if (i != fullcodes.length - 1) {
		    fbdwbms += "'" + fullcodes[i] + "',";
		} else {
		    fbdwbms += "'" + fullcodes[i] + "'";
		}
	    }
	    String[] usertypes = user.getUsertype().split(",");
	    String usertype = "";
	    int len = usertypes.length;
	    for (int i = 0; i < len; i++) {
		if (i != len - 1) {
		    usertype = "'" + usertypes[i].toString() + "',";
		} else {
		    usertype = "'" + usertypes[i].toString() + "'";
		}
	    }
	    Map setmap = new HashMap();
	    setmap.put("sxhylbdms", usertype);
	    setmap.put("fbdwbmforIn", fbdwbms);
	    lXctb = xctbService.getXctbListForBt(setmap);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	this.result = "success";
	return "success";
    }

    // ////////////////////////////场所协查通报场所端主页面 start

    /**
     * 协查通报 场所主页面
     */
    public String querylistcsMain() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);

	    ActionContext ctx = ActionContext.getContext();
	    HttpServletRequest request = (HttpServletRequest) ctx
		    .get(ServletActionContext.HTTP_REQUEST);
	    HttpSession session = request.getSession();
	    user = (User) session.getAttribute(Constants.userKey);
	    // map.put("jsdwbm", user.getUseraccount());
	    Xctb xctbcsman = new Xctb();
	    xctbcsman.setJsdwbm(user.getUseraccount());
	    List xctbcsList = xctbService.getListXctb(xctbcsman);

	    setTabledatacsMain(xctbcsList);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    public void setTabledatacsMain(List lData) throws Exception {
	List lPro = new ArrayList();
	lPro.add("tbid");
	lPro.add("rowno");
	lPro.add("bt");
	lPro.add("fbdw");
	lPro.add("fbsj");

	Xctb getXctb = new Xctb();
	this.setData(getXctb, lData, lPro, null);
	this.tabledata = this.getData();
	totalrows = this.getTotalrows();
    }

    // //////////////////end

    /**
     * 剧毒化学品协查通报 单位主页面跑马灯
     */
    public String querydwpmdlist() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);

	    ActionContext ctx = ActionContext.getContext();
	    HttpServletRequest request = ServletActionContext.getRequest();
	    HttpSession session = request.getSession();
	    user = (User) session.getAttribute(Constants.userKey);
	    Xctb xctbcsman = new Xctb();
	    xctbcsman.setJsdwbm(user.getSsdwbm());
	    lXctb = xctbService.getXctbWydList(xctbcsman);
	    this.result = "success";
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return "success";
    }

    /**
     * 定时协查通报
     * 
     * @return
     * @throws Exception
     */
    /*
     * public String timeCxxctb() throws Exception{ try {
     * System.out.println("start!"); Xctb xctbt=new Xctb(); Xctb setXctb=new
     * Xctb(); xctb=(Xctb)this.setClass(setXctb, null); //Date jzrqauto = new
     * Date(); //xctbt.setJzrqauto(jzrqauto); xctbt.setGqbs("1");
     * xctbt.setTbid(67); xctbService.updateXctb(xctbt);
     * System.out.println("success!"); //xctb = new Xctb(); } catch (Exception
     * e) { // TODO Auto-generated catch block e.printStackTrace();
     * this.result=""; return "success"; }
     * 
     * this.result="success"; return "success"; }
     */

    /**
     * 打印功能的单条查询
     * 
     * @return
     * @throws Exception
     */
    public String queryforPrint() throws Exception {
	try {
	    Xctb setXctb = new Xctb();
	    xctb = (Xctb) this.setClass(setXctb, null);
	    xctb = xctbService.getXctb(xctb);
	    int tbid = xctb.getTbid();

	    // //start 查询接收单位名称
	    Xctbjsdw xctbjsdw = new Xctbjsdw();
	    xctbjsdw.setTbid(tbid);
	    List xctbjsdwList = xctbjsdwService.getListXctbjsdw(xctbjsdw);
	    String xctbjsdwStr = "";
	    for (int i = 0; i < xctbjsdwList.size(); i++) {
		xctbjsdw = (Xctbjsdw) xctbjsdwList.get(i);
		if ("".equals(xctbjsdwStr)) {
		    xctbjsdwStr += xctbjsdw.getJsdwmc();
		} else {
		    xctbjsdwStr += ";" + xctbjsdw.getJsdwmc();
		}
	    }
	    // System.out.println(xctbjsdwStr);
	    // ///end
	    xctb.setJsdwmc(xctbjsdwStr); // //传输接收单位名称

	    Xctb_fj xctbfj = new Xctb_fj();
	    xctbfj.setTbid(tbid);
	    List xctbfjList = xctb_fjService.getListXctb_fj(xctbfj);
	    String xctbfjstr = "";
	    for (int k = 0; k < xctbfjList.size(); k++) {
		xctbfj = (Xctb_fj) xctbfjList.get(k);
		if ("".equals(xctbfjstr)) {
		    xctbfjstr += xctbfj.getFjmc();
		} else {
		    xctbfjstr += ";" + xctbfj.getFjmc();
		}
	    }
	    xctb.setFjname(xctbfjstr);

	    lXctb = new ArrayList();
	    lXctb.add(xctb);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}

	this.result = "success";
	return "success";
    }

    public void setXctb_fjService(IXctb_fjService xctb_fjService) {
	this.xctb_fjService = xctb_fjService;
    }

    public void setGlobalparService(IGlobalparService globalparService) {
	this.globalparService = globalparService;
    }

    public String getFileNamecon() {
	return fileNamecon;
    }

    public void setFileNamecon(String fileNamecon) {
	this.fileNamecon = fileNamecon;
    }

    public String getBase64codecon() {
	return base64codecon;
    }

    public void setBase64codecon(String base64codecon) {
	this.base64codecon = base64codecon;
    }

    public String getFileTempNamecon() {
	return fileTempNamecon;
    }

    public void setFileTempNamecon(String fileTempNamecon) {
	this.fileTempNamecon = fileTempNamecon;
    }

    /**
     * 获取行业类别下拉列表数据
     * 
     * @throws Exception
     */
    private String hylbdm;
    private static int level = 1;

    public String getHylbdm() {
	return hylbdm;
    }

    public void setHylbdm(String hylbdm) {
	this.hylbdm = hylbdm;
    }

    public void hylbTree() throws Exception {
	List hylblist = new ArrayList();
	List hylblistshow = new ArrayList();
	Dict_item dict_item = new Dict_item();
	Map condition = new HashMap();
	String hylbflag = "";
	// 显示行业类别根节点
	if (id == null) {
	    String hylbauth = "";
	    if (hylbdm != null) {
		hylbauth = hylbdm;
	    }
	    dict_item.setDict_code("dm_hylb");
	    hylblistshow = dict_itemService.getListDict_item(dict_item);
	    // 只显示选择的行业
	    if (!"".equals(hylbauth)) {
		for (int u = 0; u < hylblistshow.size(); u++) {
		    Dict_item testdict = new Dict_item();
		    testdict = (Dict_item) hylblistshow.get(u);
		    if (hylbauth.equals(testdict.getFact_value())) {
			hylblist.add(testdict);
		    }
		}
	    }
	    id = Integer.toString(0);
	    level = 1;
	    // 显示行业类别细化2级节点,
	} else if ("1".equals(id.substring(0, 1))) {
	    // 行业类别"A"旅业，"N"内保，"J"娱乐
	    hylbflag = id.substring(1, 2);
	    // 显示旅业下级子行业
	    if ("A".equals(hylbflag)) {
		dict_item.setDict_code("dm_ywlb");
		hylblist = dict_itemService.getListDict_item(dict_item);
		// 显示内保下级子行业
	    } else if ("N".equals(hylbflag)) {
		dict_item.setDict_code("dm_nbdw_hyfl");
		hylblist = dict_itemService.getListDict_item(dict_item);
		// 显示娱乐下级子行业
	    } else if ("J".equals(hylbflag)) {
		dict_item.setDict_code("dm_ylcsfl(bzh)");
		hylblist = dict_itemService.getListDict_item(dict_item);
	    }
	    // 显示行业类别细化3级节点,金融和学校行业类别细分
	} else if ("2".equals(id.substring(0, 1))) {
	    dict_item.setDict_code("dm_dwlb_nbdw");
	    dict_item.setQuery_simplepin(id.substring(1, 3));
	    hylblist = dict_itemService.getListDict_item(dict_item);
	}

	String xml = "<?xml version='1.0' encoding='utf-8'?> \n";
	xml += "<tree id=\"" + id + "\"> \n";
	// 行业类别节点
	for (int i = 0; i < hylblist.size(); i++) {
	    dict_item = (Dict_item) hylblist.get(i);
	    String userdateStr = dict_item.getFact_value();
	    xml += "<item text=\""
		    + dict_item.getDisplay_name()
		    + "\" id=\""
		    + level
		    + dict_item.getFact_value()
		    + "\" im0=\"leaf.gif\" im1=\"folderOpen.gif\" im2=\"folderClosed.gif\" ";
	    xml += "child=\"";
	    if (level == 1
		    || ("N".equals(hylbflag) && level == 2 && ("01"
			    .equals(userdateStr) || "02".equals(userdateStr)))) {
		xml += "1";
	    } else {
		xml += "0";
	    }
	    xml += "\">\n";
	    xml += "<userdata name=\"" + "-" + userdateStr + "\">"
		    + userdateStr + "</userdata>\n";
	    xml += "</item>\n";
	}
	xml += "</tree>";
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("application/xml;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.print(xml);
	id = null;
	hylblist.clear();
	level++;
	out.close();
    }

    // 设置选择的行业类别存入session中
    public String setHylb() throws Exception {

	HylbForTree hylbForTree = new HylbForTree();
	hylbForTree = (HylbForTree) this.setClass(hylbForTree, null);
	HttpSession session = ServletActionContext.getRequest().getSession();
	List<HylbForTree> sessionHylbList = (List) session
		.getAttribute("sessionHylbList");

	// 内保存在三级行业类别的情况
	String hylbbm = hylbForTree.getHylbbm();
	if ("01".equals(hylbbm) || "02".equals(hylbbm)) {
	    Dict_item dict_item = new Dict_item();
	    List hylblist = new ArrayList();
	    dict_item.setDict_code("dm_dwlb_nbdw");
	    dict_item.setQuery_simplepin(hylbbm);
	    hylblist = dict_itemService.getListDict_item(dict_item);
	    for (int i = 0; i < hylblist.size(); i++) {
		HylbForTree temp = new HylbForTree();
		dict_item = (Dict_item) hylblist.get(i);
		temp.setHylbbm(dict_item.getFact_value());
		temp.setHylbmc(dict_item.getDisplay_name());
		if (sessionHylbList != null && sessionHylbList.size() > 0) {
		    sessionHylbList.remove(temp);
		    if (reXml != null && reXml.equals("1"))
			sessionHylbList.add(temp);
		} else {
		    sessionHylbList = new ArrayList();
		    sessionHylbList.add(temp);
		}
	    }
	} else {
	    if (sessionHylbList != null && sessionHylbList.size() > 0) {
		sessionHylbList.remove(hylbForTree);
		if (reXml != null && reXml.equals("1"))
		    sessionHylbList.add(hylbForTree);
	    } else {
		sessionHylbList = new ArrayList();
		sessionHylbList.add(hylbForTree);
	    }
	}
	// 回显选中的行业类别
	reXml = "";
	int listLength = sessionHylbList.size();
	int firstLength = 15 > listLength ? listLength : 15;
	for (int index = 0; index < firstLength; index++) {
	    hylbForTree = (HylbForTree) sessionHylbList.get(index);
	    reXml += hylbForTree.getHylbmc() + ";";
	}
	session.setAttribute("sessionHylbList", sessionHylbList);
	sessionHylbList = null;
	return "success";
    }

    // 设置行业类别根节点下的所有行业
    public String setHylbAll() throws Exception {
	// 行业类型编码
	String hylbflag = id.substring(0, 1);
	Dict_item dict_item = new Dict_item();
	List hylbList = new ArrayList();
	List hylbListTemp = new ArrayList();
	List<HylbForTree> hylbListForTree = new ArrayList();
	// 行业类别根节点
	if ("1".equals(hylbflag)) {
	    // 行业类别"A"旅业，"N"内保，"J"娱乐
	    hylbflag = id.substring(1, 2);
	    // 显示旅业下级子行业
	    if ("A".equals(hylbflag)) {
		dict_item.setDict_code("dm_ywlb");
		hylbList = dict_itemService.getListDict_item(dict_item);
		// 显示内保下级子行业
	    } else if ("N".equals(hylbflag)) {
		// 先获取第三级行业类别
		// 银行
		Dict_item dict_itemYh = new Dict_item();
		dict_itemYh.setDict_code("dm_dwlb_nbdw");
		dict_itemYh.setQuery_simplepin("01");
		hylbListTemp = dict_itemService.getListDict_item(dict_itemYh);
		hylbList.addAll(hylbListTemp);
		// 学校
		Dict_item dict_itemXx = new Dict_item();
		dict_itemXx.setDict_code("dm_dwlb_nbdw");
		dict_itemXx.setQuery_simplepin("02");
		hylbListTemp = dict_itemService.getListDict_item(dict_itemXx);
		hylbList.addAll(hylbListTemp);

		// 再获取第二级行业类别
		dict_item.setDict_code("dm_nbdw_hyfl");
		hylbListTemp = dict_itemService.getListDict_item(dict_item);
		for (int i = 0; i < hylbListTemp.size(); i++) {
		    String hylbbm = ((Dict_item) hylbListTemp.get(i))
			    .getFact_value();
		    if (!"01".equals(hylbbm) && !"02".equals(hylbbm)) {
			hylbList.add(hylbListTemp.get(i));
		    }
		}
		// 显示娱乐下级子行业
	    } else if ("J".equals(hylbflag)) {
		dict_item.setDict_code("dm_ylcsfl(bzh)");
		hylbList = dict_itemService.getListDict_item(dict_item);
	    }
	}
	// 行业类别节点
	for (int i = 0; i < hylbList.size(); i++) {
	    dict_item = (Dict_item) hylbList.get(i);
	    HylbForTree hylbForTree = new HylbForTree();
	    hylbForTree.setHylbmc(dict_item.getDisplay_name());
	    hylbForTree.setHylbbm(dict_item.getFact_value());
	    hylbListForTree.add(hylbForTree);
	}

	HttpSession session = ServletActionContext.getRequest().getSession();
	List<HylbForTree> sessionHylbList = (List) session
		.getAttribute("sessionHylbList");
	int listLength = hylbListForTree.size();
	if (sessionHylbList != null && sessionHylbList.size() > 0) {
	    int seListLength = sessionHylbList.size();
	    if (listLength == seListLength) {
		hylbListForTree.clear();
	    }
	    listLength = hylbListForTree.size();
	}
	// 回显选中的行业类别
	reXml = "";
	int firstLength = 15 > listLength ? listLength : 15;
	for (int index = 0; index < firstLength; index++) {
	    HylbForTree hylbForTree = new HylbForTree();
	    hylbForTree = (HylbForTree) hylbListForTree.get(index);
	    reXml += hylbForTree.getHylbmc() + ";";
	}
	session.setAttribute("sessionHylbList", hylbListForTree);
	hylbListForTree = null;
	sessionHylbList = null;
	id = null;
	return "success";
    }

    // 清除行业类别session
    public String clearHylb() throws Exception {
	HttpSession session = ServletActionContext.getRequest().getSession();
	session.removeAttribute("sessionHylbList");
	return "success";
    }

    // 根据查询条件，查询企业单位
    public String queryQydwList() throws Exception {
	try {
	    GxdwForTree gxdwForTree = new GxdwForTree();
	    gxdwForTree = (GxdwForTree) this.setClass(gxdwForTree, null);
	    Map map = new HashMap();
	    map.put("gxdwbm", gxdwForTree.getGxdwbm());
	    map.put("hylbbm", gxdwForTree.getHylbbm());
	    String hylbbmNext = "";
	    HttpSession session = ServletActionContext.getRequest()
		    .getSession();
	    List<HylbForTree> sessionHylbList = (List) session
		    .getAttribute("sessionHylbList");
	    if (sessionHylbList != null && sessionHylbList.size() > 0) {
		int listLength = sessionHylbList.size();
		for (int index = 0; index < listLength; index++) {
		    HylbForTree hylbForTree = new HylbForTree();
		    hylbForTree = (HylbForTree) sessionHylbList.get(index);
		    hylbbmNext += "'" + hylbForTree.getHylbbm() + "',";
		}
		hylbbmNext = hylbbmNext.substring(0, hylbbmNext.length() - 1);
	    }
	    map.put("hylbbmNext", hylbbmNext);
	    Page page = xctbService.getQydwListForPage(map, 1, 999999999, sort,
		    dir);
	    totalpage = page.getTotalPages();
	    totalrows = page.getTotalRows();
	    List<GxdwForTree> lGxdwForTree = new ArrayList<GxdwForTree>();
	    lGxdwForTree = page.getData();
	    setQydwTabledata(lGxdwForTree);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    this.result = "";
	    return "success";
	}
	this.result = "success";
	return "success";
    }

    public void setQydwTabledata(List lData) throws Exception {
	List lPro = new ArrayList();
	lPro.add("qybm");
	lPro.add("qybm");
	lPro.add("qymc");
	List lCol = new ArrayList();
	GxdwForTree getGxdwForTree = new GxdwForTree();
	this.setData(getGxdwForTree, lData, lPro, lCol);
	this.tabledata = this.getData();
	totalrows = this.getTotalrows();
    }

    public String addQydw() throws Exception {
	/*
	 * userData += "<Param name='csmc'>"+csString+"</Param>"; userData +=
	 * "<Param name='csbm'>"+cscode+"</Param>"; userData +=
	 * "<Param name='hylxbm'>"+hylxcode+"</Param>"; userData +=
	 * "<Param name='hylxmc'>"+hylxString+"</Param>";
	 */
	GxdwForTree gxdwForTree = new GxdwForTree();
	gxdwForTree = (GxdwForTree) this.setClass(gxdwForTree, null);
	Map map = new HashMap();
	map.put("hylbbm", gxdwForTree.getHylbbm());
	map.put("qybms", gxdwForTree.getQybms());
	List<GxdwForTree> lGxdwForTree = xctbService.getQydwList(map);

	HttpSession session = ServletActionContext.getRequest().getSession();
	List<YlcsjbxxForTree> sessionCsList = (List) session
		.getAttribute("seesionCslist");
	if (sessionCsList != null && sessionCsList.size() > 0) {
	    session.removeAttribute("seesionCslist");
	} else {
	    sessionCsList = new ArrayList();
	    for (int i = 0; i < lGxdwForTree.size(); i++) {
		GxdwForTree getGxdwForTree = lGxdwForTree.get(i);
		YlcsjbxxForTree ylcsjbxxForTree = new YlcsjbxxForTree();
		ylcsjbxxForTree.setCsmc(getGxdwForTree.getQymc());
		ylcsjbxxForTree.setCsbm(getGxdwForTree.getQybm());
		ylcsjbxxForTree.setHylxbm(getGxdwForTree.getHylbbm());
		ylcsjbxxForTree.setHylxmc(getGxdwForTree.getHylbmc());
		ylcsjbxxForTree.setGxdwbm(getGxdwForTree.getGxdwbm());
		ylcsjbxxForTree.setGxdwmc(getGxdwForTree.getGxdwmc());
		sessionCsList.add(ylcsjbxxForTree);
	    }
	}
	session.setAttribute("seesionCslist", sessionCsList);
	sessionCsList = null;
	return "success";
    }

}