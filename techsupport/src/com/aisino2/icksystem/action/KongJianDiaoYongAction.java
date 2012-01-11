package com.aisino2.icksystem.action;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.codehaus.xfire.client.Client;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import sun.misc.BASE64Decoder;

import com.aisino2.basicsystem.service.IXctbService;
import com.aisino2.cache.CacheManager;
import com.aisino2.common.QjblUtil;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.util.EncryptUtil;
import com.aisino2.core.web.PageAction;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Ickyj;
import com.aisino2.icksystem.domain.Qyryskjl;
import com.aisino2.icksystem.service.IIckslService;
import com.aisino2.icksystem.service.IIckyjService;
import com.aisino2.icksystem.service.IQyryskjlService;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyryxx;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.IQyjbxxService;
import com.aisino2.publicsystem.service.IQyryxxService;
import com.aisino2.publicsystem.service.IWgcyryxxService;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.Dict;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IDictService;
import com.aisino2.sysadmin.service.IDict_itemService;
import com.aisino2.sysadmin.service.ISystemService;
import com.aisino2.sysadmin.service.IUserService;

public class KongJianDiaoYongAction extends PageAction {

	private IIckslService ickslService;
	private IDict_itemService dict_itemService;
	private IQyjbxxService qyjbxxService;
	private IQyryskjlService qyryskjlService; // 刷卡记录
	private IQyryxxService qyryxxService; // 从业人员信息
	private IWgcyryxxService wgcyryxxService;
	private IXctbService xctbService;
	private IUserService userService;
	private IDepartmentService departmentService;
	private IDictService dictService;
	private IIckyjService ickyjService;
	private ISystemService systemService;
	
	private String type;
	private String cardid;
	private String value;
	private String cyrybh;
	private String id;
	private String pwd;
	private String coid; // 字典dict_id
	private String devicetype;
	private String jcz;
	private String gajg;
	private String gmsfhm;//人员注册时从卡内读出的证件号码

	public void kongJianDiaoYong() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if (isUserStr(type) && "verifycardid".equals(type)) { // 校验卡号是否已电写入
				// --- 电写入

				if (isUserStr(cardid)) {
					//  modify on 2010-08-13 by mds begin
					//cardid = cardid.replace("-", ""); // 有的卡号带 - 号
				    //  modify on 2010-08-13 by mds end
					Icksl icksl = new Icksl();
					icksl.setIckh(cardid);
					String isDxr = ickslService.sfDxr(icksl);
					if (isUserStr(isDxr)) {
						renderText(response, isDxr);
					}
				} else {
					renderText(response, "FALSE"); // 错误
				}
				renderText(response, "");
			}

			// 判断卡是否已经在服务器中注销 - OK
			if (isUserStr(type) && "islogout".equals(type)) {
				if (isUserStr(cardid)) {
					// modify on 2010-08-13 by mds begin
					//cardid = cardid.replace("-", ""); // 有的卡号带 - 号
				    //  modify on 2010-08-13 by mds end
					Icksl icksl = new Icksl();
					icksl.setIckh(cardid);
					icksl = ickslService.getIcksl(icksl); // 判断此卡号 是否已经注销
					if ("7".equals(icksl.getZkztbs())
							|| "8".equals(icksl.getZkztbs())
							|| "9".equals(icksl.getZkztbs())) {
						renderText(response, "TRUE");
					}
				} else {
					renderText(response, ""); // 09.06.09 晚 打电话确认！ 如果传来空返回空
				}
				renderText(response, "");
			}

			// 获取版本号 - OK
			if (isUserStr(type) && "offlineversion".equals(type)) {
				Globalpar globalpar = new Globalpar();
				Globalpar temp = null;
				// globalpar.setGlobalparcode("offline-bbhtest"); //离线
				globalpar.setGlobalparcode("offline-bbh");
				List globList = CacheManager.getCacheGlobalpar(globalpar);
				if (globList != null && globList.size() > 0) {
					temp = (Globalpar) globList.get(0);
				}
				String OfflineVersion = temp.getGlobalparvalue().trim()
						.replaceAll(",", "").substring(0, 4);
				renderText(response, OfflineVersion);
			}

			// 下载prjwebcontrol.ocx - OK
			if (isUserStr(type) && "prjwebcontrol".equals(type)) {
//				String httpHead = request.getScheme() + "://"
//						+ request.getServerName() + ":"
//						+ request.getServerPort() + request.getContextPath()
//						+ "/";
//				String prjWebControlPatch = httpHead
//						+ "active/prjWebControl.ocx";
				String activePatch = "";// active目录地址
				activePatch = QjblUtil.queryQjblVal("active-url");
				String prjWebControlPatch = activePatch + "prjWebControl.ocx";
				String exeDataString = "";
				try {
					URL fileurl = new URL(prjWebControlPatch);
					exeDataString = fileToBase64(fileurl);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (exeDataString == null) {
					exeDataString = "";
				}
				renderText(response, exeDataString);
			}

			// 下载离线 - OK
			if (isUserStr(type) && "offline".equals(type)) {
//				String httpHead = request.getScheme() + "://"
//						+ request.getServerName() + ":"
//						+ request.getServerPort() + request.getContextPath()
//						+ "/";
//				String offlineExePatch = httpHead + "active/offline.exe";
				String activePatch = "";// active目录地址
				activePatch = QjblUtil.queryQjblVal("active-url");
				String offlineExePatch = activePatch + "offline.exe";
				String exeDataString = "";
				try {
					URL fileurl = new URL(offlineExePatch);
					exeDataString = fileToBase64(fileurl);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (exeDataString == null) {
					exeDataString = "";
				}
				renderText(response, exeDataString);
			}

			// 下载prjupdate.exe - OK
			if (isUserStr(type) && "prjupdate".equals(type)) {
//				String httpHead = request.getScheme() + "://"
//						+ request.getServerName() + ":"
//						+ request.getServerPort() + request.getContextPath()
//						+ "/";
//				String offlineExePatch = httpHead + "active/prjupdate.exe";
				String activePatch = "";// active目录地址
				activePatch = QjblUtil.queryQjblVal("active-url");
				String prjupdateExePatch = activePatch + "prjupdate.exe";
				String exeDataString = "";
				try {
					URL fileurl = new URL(prjupdateExePatch);
					exeDataString = fileToBase64(fileurl);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (exeDataString == null) {
					exeDataString = "";
				}
				renderText(response, exeDataString);
			}
			// 刷卡信息上传 - 这个需要注意 单条串问题 - OK
			if (isUserStr(type) && "upload".equals(type)) {
		
				//刷卡上传
				Icksl icksl = null;
				Date sksjDates = null;
				String yjFlag = ""; // 预警标志 0：注销 1：过期 2：假卡 3 未收回卡

				String yjyy = ""; // 预警原因
				String dwlb ="";  //单位类别 ，内保用
				String dwlbdm=""; //单位类别代码 ，内保用
				Dict_item dict_item = new Dict_item();
				dict_item.setDict_code("dm_ickyjyy");

				SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyyMMddHHmmss");
				if (isUserStr(value)) {
					value = value.replace('_', '+');
					value = value.replace('$', '=');
					value = getFromBASE64(value);

					String[] valueArray = value.split("%");
					
					String skzdzc = QjblUtil.queryQjblVal("skzdzc");//刷卡自动注册到该场所 0-否 1-是
					for (int index = 0; index < valueArray.length; index++) {
						yjFlag = "";// 初始化

						yjyy = "";// 初始化

						icksl = null;// 初始化

						sksjDates = null;// 初始化

						String dantiaoString = valueArray[index];
						dantiaoString = dantiaoString.replace("$", "%");
						String[] dantiaoArray = dantiaoString.split("%");
						// String eg =
						// "CHN$张宁宁$J024103030004000253$$$$$$20090615155236$2048070716$郑州测试平面图修改$J023200000003$";
						// String eg =
						// "CHN$朱雯燕$J014103020003090001$310106197709090823$2$$$20090619134629$690744610$测试核查$J044101050005$";
						String qybm = String.valueOf(dantiaoArray[11]);
						Qyjbxx qyjbxx = new Qyjbxx();
						qyjbxx.setQybm(qybm);
						qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);
						
						Date sxsj = null;// 卡失效时间，暂时没用到 ,废卡查询会用到

						Integer ryid = null; // 暂时没用到 ,废卡查询会用到

						String kh = null;

						String sksj = String.valueOf(dantiaoArray[8]);
						sksj = sksj.substring(0, 4) + "-"
								+ sksj.substring(4, 6) + "-"
								+ sksj.substring(6, 8) + " "
								+ sksj.substring(8, 10) + ":"
								+ sksj.substring(10, 12) + ":"
								+ sksj.substring(12, 14);
						sksjDates = stringToDate(sksj, "yyyy-MM-dd HH:mm:ss");
						String ickh = String.valueOf(dantiaoArray[9]);

						String cyrybh = dantiaoArray[2];
						String zjhm=dantiaoArray[3];
						
						
						//刷卡立即注册 20100903根据重庆需求修改
						if(skzdzc==null ||"".equals(skzdzc)|| "1".equals(skzdzc))
						{
							if (qyjbxx != null) {
								int qyid = qyjbxx.getQyid();
								Qyryxx qyryxx = new Qyryxx();
								//对于从业人员编号为14位的江苏老卡，不能用人员编号查询，而应使用证件号码查询 20110131 mds
								if(StringUtil.isNotEmpty(cyrybh)&&cyrybh.length()==14)
									qyryxx.setZjhm(zjhm);
								else
									qyryxx.setCyrybh(cyrybh);
								qyryxx = qyryxxService.getQyryxx(qyryxx);
									
								if (qyryxx != null)
								{
									int qyrrxxQyid = qyryxx.getQyid();
									dwlb = qyryxx.getCylb();
									dwlbdm=qyryxx.getCylbdm();
									//异构系统的人员不能注册
									if (Integer.parseInt(qyryxx.getZt())<90&&qyrrxxQyid!=qyid) 
									{
										qyryxx.setQyid(qyid);
										qyryxx.setRzrq(new Date());
										ickslService.updateIckslByryzc(qyryxx);//更新表t_icksl，人员注册就是人员场所更新
									}
								} 
							} 
						}

						// 江苏老卡从业人员编号14位刷卡的情况,通过芯片号（ICKH）查询新从业人员编号 --modify at 20100610
						/*  20100817暂时注释掉。由于原来程序将芯片号的负号去掉了，造成刷卡时关联不上受理表，现暂时注释掉此段代码，知道所有有问题的IC卡处理完成后，再放开此段代码
						 if (cyrybh != null && cyrybh.length() == 14) {
							// 调用service根据ickh（芯片号）查询新从业人员编号
							icksl = new Icksl();
							icksl.setIckh(ickh);
							icksl = ickslService.getIckslCyrybh(icksl);
							if (icksl != null) {
								cyrybh = icksl.getCyrybh();
								kh = icksl.getKh();
								icksllsh = icksl.getIckslid();
							}
						}*/
						/**
						 * 代替上面20100817注释掉的代码，当所有有问题的IC卡均处理完成后，可去掉此段代码，
						 * 还原上面注释掉的代码 ---start---
						 */
						int icksllsh = 0;
							// 调用service根据ickh（芯片号）查询新从业人员编号
							icksl = new Icksl();
							icksl.setIckh(ickh);
							icksl = ickslService.getIckslCyrybh(icksl);
							if (icksl != null) {
								cyrybh = icksl.getCyrybh();
								kh = icksl.getKh();
								icksllsh = icksl.getIckslid();
							}
							/**
							 * 若在IC卡受理表中查不到记录，则可能这张卡的芯片号被人为去掉了负号，需调用如下过程处理
							 * 2010-08-16修改 mds
							 */
							else
							{
								Icksl ickslTemp = new Icksl();
								ickslTemp.setIckh(ickh);
								ickslService.updateIckslIckh(ickslTemp);
							}
						/**
						 * 代替上面20100817注释掉的代码，当所有有问题的IC卡均处理完成后，可去掉此段代码，
						 * 还原上面注释掉的代码 ---end---
						 */

						if (dantiaoArray.length > 12) {
							kh = dantiaoArray[12];
						}

//						String jczt =dantiaoArray[dantiaoArray.length];
						if (qyjbxx != null) {
							int qyid = qyjbxx.getQyid();
							Qyryskjl qyryskjl = new Qyryskjl();
							qyryskjl.setQyid(qyid);
							qyryskjl.setIckh(ickh); // 有的卡号带 - 号 ,

							qyryskjl.setSksj(sksjDates);
							qyryskjl.setScsj(new Date());
							qyryskjl.setCyrybh(cyrybh);
							if (dantiaoArray.length > 12) {
								qyryskjl.setKh(dantiaoArray[12]);
							}
							// 102025新增start
							qyryskjl.setQybm(qybm);
							qyryskjl.setHylb(qyjbxx.getHylb());
							qyryskjl.setHylbdm(qyjbxx.getHylbdm());
							// end

							// --modify on 20100610
							if (icksl != null) {
								qyryskjl.setKh(kh);
								qyryskjl.setIcksllsh(icksllsh);
							}
							// --modify on 20100610

							if("N".equals(qyjbxx.getHylbdm())){
								qyryskjl.setJczt(dantiaoArray[dantiaoArray.length-1]);
								qyryskjl.setDwlb(dwlb);
								qyryskjl.setDwlbdm(dwlbdm);
								qyryskjl = qyryskjlService.insertQyryskjl(qyryskjl);
								Qyskfbxx qyskfbxx =new Qyskfbxx();
								qyskfbxx.insertqyskfb(qyryskjl);
							}else{
								qyryskjl = qyryskjlService.insertQyryskjl(qyryskjl);
							}
							// 无论什么情况先存库 在看有问题 就预警：方便以后找到问题卡都出现在什么场所
							Integer ickslid = null;
							String ickslslh = null;// 这个字段，不知道填什么值

							Icksl ickslOne = new Icksl();
						    //  modify on 2010-08-13 by mds begin
							//ickslOne.setIckh(String.valueOf(dantiaoArray[9]).replace("-", ""));
							ickslOne.setIckh(String.valueOf(dantiaoArray[9]));
						    //  modify on 2010-08-13 by mds end
							List list = ickslService.getListIcksl(ickslOne);
							if (list == null || list.size() == 0) {
								yjFlag = "2";// 卡有问题 不存在于我们的数据库中 //假卡
							} else {

								icksl = new Icksl();
							    // modify on 2010-08-13 by mds begin
								//icksl.setIckh(String.valueOf(dantiaoArray[9]).replace("-", "")); // 有的卡号带 - 号
								icksl.setIckh(String.valueOf(dantiaoArray[9]));
							    //  modify on 2010-08-13 by mds end
								icksl.setCyrybh(dantiaoArray[2]);
								icksl = ickslService.getIckslyj(icksl);
								if (icksl == null) {
									yjFlag = "2";
								} // 卡有问题 不存在于我们的数据库中 //假卡
								else {
									ickslid = icksl.getIckslid();
									// sxsj = icksl.getIckzxsj();
									// ickslh = icksl.getIckslh();
									ryid = icksl.getRyid();

									Qyryxx qyryxx = new Qyryxx();
									qyryxx.setRyid(ryid);
									qyryxx.setScbz(0);
									qyryxx = qyryxxService.getQyryxx(qyryxx);

									if (kh == null) {
										kh = icksl.getKh();
									}

									if ("7".equals(icksl.getZkztbs())
											|| "8".equals(icksl.getZkztbs())
											|| "9".equals(icksl.getZkztbs())) {
										if ("9".equals(icksl.getZkztbs())) {
											yjFlag = "3"; // 未收回卡
											sxsj = icksl.getYxqhzrq();
										} else {
											yjFlag = "0"; // 卡注销
											sxsj = icksl.getIckzxsj();

										}

									} else if (!"7".equals(icksl.getZkztbs())
											&& !"8".equals(icksl.getZkztbs())
											&& !"9".equals(icksl.getZkztbs())) {
										String sksjtemp = sksj.substring(0, 10);
										Date sksjDate = stringToDate(sksjtemp,
												"yyyy-MM-dd");
										if (sksjDate.compareTo(icksl
												.getYxqhzrq()) >= 0) {
											yjFlag = "1"; // 卡过期
											sxsj = icksl.getYxqhzrq();

										}
									} else if ("1".endsWith(qyryxx.getYjbz())) {
										yjFlag = "4"; // 虚假身份信息预警
										sxsj = qyryxx.getYjsj();
									}

									// 刷卡未上传卡号，则从icksl表中取出，保存到qyryskjl表中去

									if (qyryskjl.getKh() == null) {
										qyryskjl.setKh(kh);

									}
									qyryskjl.setIcksllsh(ickslid);
									qyryskjlService.updateQyryskjl(qyryskjl);

								}

							}

						} else {
							yjFlag = "2"; // 场所不存在 预警 //假卡
						}

						if (!"".equals(yjFlag)) { // 需要预警

							Ickyj tempIckyj = new Ickyj(); // 预警表

							Qyryxx cyryxx = new Qyryxx();
							Wgcyryxx wgcyryxx = new Wgcyryxx();
							if (icksl != null) {
								cyryxx.setRyid(icksl.getRyid());
								cyryxx = qyryxxService.getQyryxx(cyryxx);

								tempIckyj.setIckh(icksl.getIckh());
							}
							if ("2".equals(yjFlag)) { // 假卡
								cyryxx.setCyrybh(dantiaoArray[2]);
								cyryxx = qyryxxService.getQyryxx(cyryxx);
								tempIckyj.setCyrybh(dantiaoArray[2]);
								// modify on 2010-08-13 by mds begin
								//tempIckyj.setIckh(String.valueOf(dantiaoArray[9]).replace("-", "")); // 有的卡号带- 号
								tempIckyj.setIckh(String.valueOf(dantiaoArray[9]));
							    //  modify on 2010-08-13 by mds end

							}

							if (cyryxx != null) {
								tempIckyj.setXmpy(cyryxx.getXm());
								tempIckyj.setXb(cyryxx.getXb());
								tempIckyj.setCyzj(cyryxx.getCyzj());
								tempIckyj.setZjhm(cyryxx.getZjhm());
								tempIckyj.setCylb(cyryxx.getCylb());
								tempIckyj.setCylbdm(cyryxx.getCylbdm());
								tempIckyj.setXmpy(cyryxx.getXmpy());
								tempIckyj.setCyrybh(cyryxx.getCyrybh());

								tempIckyj.setXm(cyryxx.getXm());
								tempIckyj.setCyzjdm(cyryxx.getCyzjdm());
								ryid = cyryxx.getRyid();

								wgcyryxx.setRyid(cyryxx.getRyid());
								wgcyryxx = wgcyryxxService
										.getWgcyryxx(wgcyryxx);
								if (wgcyryxx != null) {
									tempIckyj.setYwm(wgcyryxx.getYwm());
									tempIckyj.setYwx(wgcyryxx.getYwx());
									tempIckyj.setWgrjyxkz(wgcyryxx
											.getWgrjyxkz());
								}
							}

							qybm = "不存在";
							String qymc = "场所不存在";
							String gxdwdm = "不存在";
							String gxdwmc = "不存在";
							String dsjgdm = "不存在";
							String fxjdm = "不存在";
							String dsjgmc = "不存在";
							String fxjmc = "不存在";
							if (qyjbxx != null) {
								qybm = qyjbxx.getQybm();
								qymc = qyjbxx.getQymc();
								gxdwdm = qyjbxx.getGxdwbm();
								gxdwmc = qyjbxx.getGxdwmc();

								String qybmTemp = qybm.substring(3, qybm
										.length());
								dsjgdm = qybmTemp.substring(0, 4) + "00000000";
								fxjdm = qybmTemp.substring(0, 6) + "000000";
								dsjgmc = "";
								fxjmc = "";

								// 得到地市及分县局 代码 >>> 场所编码去前三位 = N;
								// N前4位+8个0=地市编码、N前6位+6个0=分县局编码(6.19问小苗)
								Department userDepartment = new Department();
								userDepartment.setDepartcode(dsjgdm); // 地市机关
								userDepartment = departmentService
										.getDepartment(userDepartment);
								dsjgmc = (userDepartment != null) ? userDepartment
										.getDepartname()
										: "不存在";
								userDepartment = new Department();
								userDepartment.setDepartcode(fxjdm); // 分县机关
								userDepartment = departmentService
										.getDepartment(userDepartment);
								fxjmc = (userDepartment != null) ? userDepartment
										.getDepartname()
										: "不存在";
								tempIckyj.setQyid(qyjbxx.getQyid());

							}
							// 单位信息
							tempIckyj.setQybm(qybm);
							tempIckyj.setQymc(qymc);
							tempIckyj.setGxdwdm(gxdwdm);
							tempIckyj.setGxdwmc(gxdwmc);

							tempIckyj.setDsjgdm(dsjgdm);
							tempIckyj.setDsjgmc(dsjgmc);
							tempIckyj.setFxjdm(fxjdm);
							tempIckyj.setFxjmc(fxjmc);

							if (!"".equals(yjFlag)) { // 预警原因
								dict_item.setFact_value(yjFlag);
								List list = CacheManager
										.getCacheDictitem(dict_item);
								if (list != null && list.size() > 0) {
									yjyy = ((Dict_item) list.get(0))
											.getDisplay_name();
								}
							}

							tempIckyj.setSksj(sksjDates);
							tempIckyj.setYjyy(yjyy);
							tempIckyj.setSxsj(sxsj);
							tempIckyj.setRyid(ryid);
							tempIckyj.setKh(kh);
							ickyjService.insertIckyj(tempIckyj);
							tempIckyj = null;
						}
					}
				}
				renderText(response, "OK");
			}

			// 人员注册 - OK
			if (isUserStr(type) && "reg".equals(type)) {
				Qyjbxx qyjbxx = new Qyjbxx();
				qyjbxx.setQybm(id);
				qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);

				if (qyjbxx != null) {
					int qyid = qyjbxx.getQyid();
					Qyryxx qyryxx = new Qyryxx();
					//对于从业人员编号为14位的江苏老卡，不能用人员编号查询，而应使用证件号码查询 20110131 mds
					if(StringUtil.isNotEmpty(cyrybh)&&cyrybh.length()==14)
						qyryxx.setZjhm(gmsfhm);
					else
						qyryxx.setCyrybh(cyrybh);
					try {
						qyryxx = qyryxxService.getQyryxx(qyryxx);
						if (qyryxx != null) {
							int qyrrxxQyid = qyryxx.getQyid();
							//金盾系统采集的人员可以手动注册，异构系统的卡暂时不能注册 20100914
							if(90>Integer.parseInt(qyryxx.getZt()))
							{
								if (qyrrxxQyid == qyid) {
									renderText(response, "已注册");
								} else {
									qyryxx.setQyid(qyid);
									qyryxx.setRzrq(new Date());
									ickslService.updateIckslByryzc(qyryxx);//更新表t_icksl,人员注册就是人员场所更新
									renderText(response, "注册成功");
								}
							}
							else
							{
								renderText(response, "该从业人员为异构系统人员，暂不提供注册功能");
							}
							
						} else {
							renderText(response, "从业人员不存在");
						}
					} catch (Exception e) {
						renderText(response, "此人员信息有问题，核查数据库");
					}
				} else {
					renderText(response, "场所不存在");
				}
			}

			// 消息 - 每隔一定的时间就请求这里 - OK
			if (isUserStr(type) && "message".equals(type)) {
				Map map = new HashMap();
				map.put("jsdwbm", id); // 场所编码 - jsdwbm
				map.put("csck", "0"); // /未查看

				map.put("gqbs", "0");
				Page page = xctbService
						.getcsListForPage(map, 1, 10, null, null);
				if (page.getData().size() > 0) {
					renderText(response, "TRUE");
				} else {
					renderText(response, "FALSE");
				}
			}

			// IC卡 最近20天刷卡历史记录 - OK
			if (isUserStr(type) && "history".equals(type)) {
				String skkssj1 = RespDateByDay(-20);
				Date sksjf = stringToDate(skkssj1, "yyyy-MM-dd");
				Date sksjt = new Date();
				Qyjbxx qyjbxx = new Qyjbxx();
				qyjbxx.setQybm(id);
				qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);
				if (qyjbxx == null) {
					renderText(response, "<CSMC></CSMC>", 1);
				} else {
					/** ****************modify on 20100721********************* */
					/*
					 * int csid = qyjbxx.getQyid(); Map map = new HashMap();
					 * map.put("qybm", id); map.put("cyrybh", cyrybh);
					 * map.put("sksjf", sksjf); map.put("sksjt", sksjt); Page
					 * page = qyryskjlService.getListForPage(map, 1, 10, null,
					 * null); int total = page.getTotalRows(); page =
					 * qyryskjlService .getListForPage(map, 1, total, null,
					 * null); List list = page.getData();
					 */
					Qyryskjl setQyryskjl = new Qyryskjl();
					setQyryskjl.setQybm(id);
					setQyryskjl.setCyrybh(cyrybh);
					setQyryskjl.setSksjf(sksjf);
					setQyryskjl.setSksjt(sksjt);
					List list = qyryskjlService.getListQyryskjl(setQyryskjl);
					/** ****************modify on 20100721********************* */

					String fanhuiString = "<CSMC></CSMC>";
					if (list != null && list.size() > 0) {
						fanhuiString = "<CSMC>" + qyjbxx.getQymc() + "</CSMC>";
						for (int index = 0; index < list.size(); index++) {
							Qyryskjl qyryskjl = (Qyryskjl) list.get(index);
							fanhuiString += "<RECORD>"
									+ dateToString(qyryskjl.getSksj(),
											"yyyy-MM-dd HH:mm:ss") + kongGe(6)
									+ qyryskjl.getCyrybh() + kongGe(6)
									+ qyryskjl.getXm() + "</RECORD>";
						}
					}
					renderText(response, fanhuiString, 1);
				}
			}

			// 测试连接是否正常 - OK
			if (isUserStr(type) && "connect".equals(type)) {
				renderText(response, "OK");
			}
			// 时间同步和版本号 -OK
			if (isUserStr(type) && "date".equals(type)) {
				try {
					String fanhuiString = dateToString(new Date(),
							"yyyyMMddHHmmss");

					Globalpar globalpar = new Globalpar();
					Globalpar temp = null;
					// globalpar.setGlobalparcode("offline-bbhtest"); //离线
					globalpar.setGlobalparcode("offline-bbh"); // 离线
					List globList = CacheManager.getCacheGlobalpar(globalpar);
					if (globList != null && globList.size() > 0) {
						temp = (Globalpar) globList.get(0);
					}
					fanhuiString += "$"
							+ temp.getGlobalparvalue().replaceAll(",", "");

					// globalpar.setGlobalparcode("prjweb-bbhtest");
					globalpar.setGlobalparcode("prjweb-bbh");
					globList = CacheManager.getCacheGlobalpar(globalpar);
					if (globList != null && globList.size() > 0) {
						temp = (Globalpar) globList.get(0);
					}
					fanhuiString += "$"
							+ temp.getGlobalparvalue().replaceAll(",", "");

					globalpar.setGlobalparcode("gsweb-bbh");
					globList = CacheManager.getCacheGlobalpar(globalpar);
					if (globList != null && globList.size() > 0) {
						temp = (Globalpar) globList.get(0);
					}
					fanhuiString += "$"
							+ temp.getGlobalparvalue().replaceAll(",", "");
					renderText(response, fanhuiString);
				} catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("");
				}
			}
			// 场所登录13 - login 民警登录14 - login2 - OK
			if ((isUserStr(type) && "login".equals(type))
					|| (isUserStr(type) && "login2".equals(type))) {
				String userType = "";
				if ("login".equals(type)) {
					userType = "13";
				}
				if ("login2".equals(type)) {
					userType = "14";
				}
				User user = new User();
				user.setUseraccount(id);
				user = userService.checkUser(user);
				if (user != null) {
					String password = user.getPassword();
					String type = user.getUsertype();
					if (password.equals(EncryptUtil.getMD5Code(pwd))) { // 密码正确
						if (type.contains(userType)) { // 娱乐业公安端用户
							if ("13".equals(type)) {
								String qykfkg = QjblUtil
										.queryQjblVal("qykf-kg");
								if ("1".equals(qykfkg)) { // 验证开关

									try {
										String content = wsdlResult(user
												.getUseraccount());
										Document doc = DocumentHelper
												.parseText(content);
										Element root = doc.getRootElement();
										String isright = root.element(
												"ISVERIFY").getText();
										if ("1".equals(isright)) {
											renderText(response, "OK");
										} else {
											renderText(response,
													"ERROR软件授权无效，请与维护人员联系");
										}
									} catch (Exception e) {
										e.printStackTrace();
										renderText(response,
												"ERROR软件授权验证失败，请与维护人员联系");
									}
								} else {
									renderText(response, "OK");
								}
							} else {
								renderText(response, "OK");
							}
						} else { // 非娱乐业公安端用户

							renderText(response, "NOTOK");
						}
					} else {
						renderText(response, "FALSE");
					}
				} else {
					renderText(response, "FALSE");
				}
			}
			// 客户校验 2009-12-11 add
			// type=verify&id=&devicetype=
			// 如果通过返回<OUTPUT>TRUE</OUTPUT>没通过就返回<OUTPUT>错误原因</OUTPUT>
			// 成功的提示信息为：<OUTPUT>TRUE提示信息</OUTPUT>
			// 问题两个：娱乐业前台软件代码、提示信息

			if (isUserStr(type) && "verify".equals(type)) {
				User user = new User();
				user.setUseraccount(id);
				try {
					user = userService.checkUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					renderText(response, "");
				}

				if (user != null) {
					String qykfkg = QjblUtil.queryQjblVal("qykf-kg");
					String sksblx = QjblUtil.queryQjblVal("deviceType");// 刷卡设备类型

					if (!sksblx.equals(devicetype)) {
						renderText(response, "设备类型不一致");
					} else {
						if ("1".equals(qykfkg)) { // 验证开关

							try {
								String content = wsdlResult(user
										.getUseraccount());
								Document doc = DocumentHelper
										.parseText(content);
								Element root = doc.getRootElement();
								String isright = root.element("ISVERIFY")
										.getText();
								String endDate = root.element("ENDDATE")
										.getText();
								if ("1".equals(isright)) {
									int difday = difDay(endDate);
									if (difday < 31) {
										renderText(response,
												"TRUE软件授权即将到期，请与维护人员联系");
									} else {
										renderText(response, "TRUE");
									}
								} else {
									renderText(response, "软件授权无效，请与维护人员联系");
								}
							} catch (Exception e) {
								e.printStackTrace();
								renderText(response, "软件授权验证失败，请与维护人员联系");
							}
						} else {
							renderText(response, "TRUE");
						}
					}
				} else {
					renderText(response, "企业用户不存在，请与维护人员联系");
				}
			}
			// 下载代码定义（即字典表）- OK
			if (isUserStr(type) && "coding".equals(type)) {
				StringBuffer condingString = new StringBuffer("<output>");
				Dict dict = new Dict();
				dict.setKongjianDicts("'dm_mz','dm_gj(lgy)','dm_xzqh'");
				List list = dictService.getListDict(dict);
				if (list != null && list.size() > 0) {
					for (int index = 0; index < list.size(); index++) {
						dict = (Dict) list.get(index);
						// 15342003,物流管理状态,DICTIONARY,DI_SN,DI_CVALUE,DI_SELNO,DI_MNEMONIC,DI_PROMPT,DI_DFID=1330,,,,WLGLZT,,1
						condingString.append(nullCheck(String.valueOf(dict
								.getDict_id()))
								+ ","
								+ nullCheck(dict.getDict_name())
								+ ","
								+ nullCheck(dict.getDict_itemtablename())
								+ ","
								+ "DI_SN"
								+ ","
								+ "DI_CVALUE"
								+ ","
								+ "DI_SELNO"
								+ ","
								+ "DI_MNEMONIC"
								+ ","
								+ "DI_PROMPT"
								+ ","
								+ "DI_DFID="
								+ dict.getDict_id()
								+ ","
								+ ""
								+ ","
								+ ""
								+ ","
								+ ""
								+ ","
								+ nullCheck(dict.getDict_simplepin())
								+ ","
								+ ""
								+ ","
								+ nullCheck(dict.getDict_versionid() + "\r\n"));
					}
				}
				condingString.append("</output>");
				renderText(response, condingString.toString(), 1);
			}

			// 获取某个字典数据（即字典项）- OK
			if (isUserStr(type) && "dict".equals(type)) {
				Dict dict = new Dict();
				dict.setDict_id(Integer.parseInt(coid));
				List list = dict_itemService.getOfflineDict_item(dict);
				StringBuffer returnString = new StringBuffer("<output>");
				if (list != null && list.size() > 0) {
					for (int index = 0; index < list.size(); index++) {
						Dict_item dict_item = (Dict_item) list.get(index);
						returnString.append(nullCheck(String.valueOf(dict_item
								.getItem_id()))
								+ ","
								+ nullCheck(dict_item.getDisplay_name())
								+ ","
								+ nullCheck(dict_item.getItem_simplepin())
								+ ","
								+ nullCheck(dict_item.getFact_value())
								+ "," + coid + "\r\n");
					}
				}
				returnString.append("</output>");
				renderText(response, returnString.toString(), 1);
			}
			
			// 获取场所的密码（config配置密码）
			if(isUserStr(type) && "password".equals(type)){
				String password = QjblUtil.queryQjblVal("offline-config-password");
				renderText(response, password);
			}
			
			// 获取offline登陆的方式(0为普通用户口令登陆方式；1为证书登陆方式)
			if(isUserStr(type) && "logintype".equals(type)){
				String logintype = QjblUtil.queryQjblVal("login-type");
				renderText(response, logintype);
			}
			
			//民警刷卡登陆验证
			if (isUserStr(type) && "policecardlogin".equals(type)) {
				Map map = new HashMap();
				map.put("tableName", "t_mjjczsl");
				map.put("zkztbs", "5");
				map.put("mjjczbh", jcz);
				boolean jczexit = systemService.isExit(map);
				if (jczexit){
					String deptJcz=StringUtil.trimEven0(gajg);
					Qyjbxx qyjbxx = new Qyjbxx();
					qyjbxx.setQybm(id);
					qyjbxx = qyjbxxService.getQyjbxx(qyjbxx);
					String deptQyxx=qyjbxx.getGxdwbm();
					String mjjcqxms = QjblUtil.queryQjblVal("mjjcqxms");
					if (mjjcqxms.equals("2")){
						if(deptQyxx.indexOf(deptJcz)==0){
							renderText(response, "OK");
						}else{
							renderText(response, "该卡无此场所权限");
						}
					}else {
						renderText(response, "OK");
					} 
				} else {
					renderText(response, "民警卡不存在");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			renderText(response, "操作失败或数据库连接失败");
		}
	}

	public String creatKongJianSession() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();

		String resultRed = "";
		String userType = "";
		if ("vlogin".equals(type)) { // 场所
			userType = "13";
		}
		if ("plogin".equals(type)) { // 公安
			userType = "14";
		}
		User user = new User();
		user.setUseraccount(id);
		user = userService.checkUser(user);
		if (user != null) {
			String password = user.getPassword();
			String type = user.getUsertype();
			if (password.equals(EncryptUtil.getMD5Code(pwd))
					&& type.contains(userType)) {
				Department userDepartment = new Department();
				userDepartment.setDepartid(user.getDepartid());
				userDepartment = departmentService
						.getDepartment(userDepartment);
				user.setDepartment(userDepartment);
				session.setAttribute(Constants.userKey, user);
				resultRed = "OK";
			} else {
				removeSession(session);
			}
		} else {
			removeSession(session);
		}
		session.setAttribute("ret", resultRed);
		session.setAttribute("redirectFlag", "Y");
		return "success";
	}

	public void removeSession(HttpSession session) {
		if (session.getAttribute(Constants.userKey) != null) {
			session.removeAttribute(Constants.userKey);
		}
		if (session.getAttribute("ret") != null) {
			session.removeAttribute("ret");
		}
		if (session.getAttribute("redirectFlag") != null) {
			session.removeAttribute("redirectFlag");
		}
	}

	protected void renderText(HttpServletResponse response, String text) {
		StringBuffer result = new StringBuffer("");
		result.append("<OUTPUT>");
		result.append(text);
		result.append("</OUTPUT>");
		renderText(response, result.toString(), "UTF-8");
	}

	protected void renderText(HttpServletResponse response, String text,
			int flag) {
		StringBuffer result = new StringBuffer("");
		result.append(text);
		renderText(response, result.toString(), "UTF-8");
	}

	protected void renderText(HttpServletResponse response, String text,
			String encoding) {
		renderContent(response, text,
				(new StringBuilder("text/plain;charset=")).append(encoding)
						.toString());
	}

	private void renderContent(HttpServletResponse response, String text,
			String contentType) {
		try {
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * 检查参数是否为空
	 * 
	 * @return true:此字符串不为空可以使用、false字符串为空不可以使用
	 */
	public static boolean isUserStr(String str) {
		boolean temp = false;
		if (str != null) {
			str = str.trim();
			if (!"".equals(str)) {
				temp = true;
			}
		}
		return temp;
	}

	public String nullCheck(String string) {
		if (string == null) {
			return "";
		} else {
			return string;
		}
	}

	public static String fileToBase64(URL sPath) throws IOException {
		String ret = new String();
		try {
			byte[] bytes = new byte[1024];
			InputStream in = sPath.openStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);

			int size = 0;
			size = in.read(bytes);
			while (size != -1) {
				baos.write(bytes, 0, size);
				size = in.read(bytes);
			}
			ret = new sun.misc.BASE64Encoder().encode(baos.toByteArray()); // 具体的编码方法

			in.close();
			baos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		}
		ret = ret.replaceAll("\r\n", "");
		ret = ret.replaceAll("\n", "");
		return ret;
	}

	// 将 BASE64 编码的字符串 s 进行解码
	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	public String kongGe(int leng) {
		String kongGe = "";
		for (int i = 0; i < leng; i++) {
			kongGe += " ";
		}
		return kongGe;
	}

	/*
	 * 返回与当前日期相差几天的日期；
	 * 
	 */
	public static String RespDateByDay(int iDays) {
		if (iDays == 0)
			iDays = -1;
		if (iDays == 1)
			iDays = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar dCurrDate = Calendar.getInstance();
		dCurrDate.add(Calendar.DATE, iDays);
		String sDate = formatter.format(dCurrDate.getTime());
		return sDate;
	}

	public static Date stringToDate(String yyyymmdd, String style) {
		Date date = null;
		try {
			return new java.text.SimpleDateFormat(style).parse(yyyymmdd);
		} catch (ParseException ex) {
			return null;
		}
	}

	public static String dateToString(Date yyyymmdd, String style) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(style);
			String sDate = formatter.format(yyyymmdd);
			return sDate;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 客服webserver验证 返回XML描述 ---客户校验 用到
	 * 
	 * @param qybm
	 * @return
	 * @throws Exception
	 */
	public String wsdlResult(String qybm) throws Exception {
		String qykfwsdl = QjblUtil.queryQjblVal("qykf-wsdl");
		Client client = new Client(new java.net.URL(qykfwsdl));
		return client.invoke("licenseVerifyByID", new String[] { qybm })[0]
				.toString();
	}

	/**
	 * 日期相差的天数 ---客户校验 用到
	 * 
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public int difDay(String endDate) throws Exception {
		SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		String dateNowStr = dateFormat.format(nowDate);

		Date dateEnd = formatter.parse(endDate);
		Date dateNow = formatter.parse(dateNowStr);
		int day1 = (int) dateEnd.getTime() / 24 * 60 * 1000;
		int day2 = (int) dateNow.getTime() / 24 * 60 * 1000;
		return (day1 - day2);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public void setIckslService(IIckslService ickslService) {
		this.ickslService = ickslService;
	}

	public void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setQyjbxxService(IQyjbxxService qyjbxxService) {
		this.qyjbxxService = qyjbxxService;
	}

	public void setQyryskjlService(IQyryskjlService qyryskjlService) {
		this.qyryskjlService = qyryskjlService;
	}

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setQyryxxService(IQyryxxService qyryxxService) {
		this.qyryxxService = qyryxxService;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setDictService(IDictService dictService) {
		this.dictService = dictService;
	}

	public String getCoid() {
		return coid;
	}

	public void setCoid(String coid) {
		this.coid = coid;
	}

	public String getJcz() {
		return jcz;
	}

	public void setJcz(String jcz) {
		this.jcz = jcz;
	}

	public String getGajg() {
		return gajg;
	}

	public void setGajg(String gajg) {
		this.gajg = gajg;
	}

	public void setXctbService(IXctbService xctbService) {
		this.xctbService = xctbService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setWgcyryxxService(IWgcyryxxService wgcyryxxService) {
		this.wgcyryxxService = wgcyryxxService;
	}

	public void setIckyjService(IIckyjService ickyjService) {
		this.ickyjService = ickyjService;
	}
	
	public void setSystemService(ISystemService systemService) {
		this.systemService = systemService;
	}
	
	public String getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
}