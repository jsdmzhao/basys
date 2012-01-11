package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class St_device  {

	/** @param 无线终端设备(ST_DEVICE) */

	/** @ --设备序号--dev_serial--Integer--10-- */
	private Integer dev_serial;

	/** @ --设备名称--dev_name--String--100-- */
	private String dev_name;

	/** @ --设备IP--dev_ip--String--20-- */
	private String dev_ip;

	/** @ --设备连接密码--dev_password--String--20-- */
	private String dev_password;

	/** @ --设备日志--dev_log--String--500-- */
	private String dev_log;

	/** @ --常关规则--dev_devrulezuc--Integer--10-- */
	private Integer dev_devrulezuc;

	/** @ --常开规则--dev_devrulezuo--Integer--10-- */
	private Integer dev_devrulezuo;

	/** @ --管理员编号--gly_no--String--16-- */
	private String gly_no;

	/** @ --设备更新时间--dev_update--Date---- */
	private Date dev_update;

	/** @ --联机，禁用时段设置--dev_devrulezul--String--100-- */
	private String dev_devrulezul;

	/** @ --连接类型--com--Integer--3-- */
	private Integer com;

	/** @ --端口号--port--Integer--10-- */
	private Integer port;

	/** @ --波特率--btl--Integer--10-- */
	private Integer btl;

	/** @ --终端显示信息--xs--String--50-- */
	private String xs;

	/** @ --管理员密码--gly_psw--String--16-- */
	private String gly_psw;

	/** @ --档案最近更新时间--dw_sj--Date---- */
	private Date dw_sj;

	/** @ --所属服务序号--parent--Integer--10-- */
	private Integer parent;

	/** @ --终端MAC地址--mac--String--25-- */
	private String mac;

	/** @ --脱机数据实时存数据库标志--tjkq--Integer--3-- */
	private Integer tjkq;

	/** @ --设备最后在线时间--on_line--Date---- */
	private Date on_line;

	/** @ --设备当前状态--run_state--Integer--1-- */
	private Integer run_state;

	/** @ --下发通知状态--note_ok--Integer--1-- */
	private Integer note_ok;

	/** @ --档案变更时间--da_update--Date---- */
	private Date da_update;

	/** @ --协查通报编号--notice_serial--Integer--10-- */
	private Integer notice_serial;

	/** @ --设备CPU型号--dev_cpu--String--50-- */
	private String dev_cpu;

	/** @ --操作系统版本--dev_os--String--50-- */
	private String dev_os;

	/** @ --本次流量（字节）--flow_rate--Integer--10-- */
	private Integer flow_rate;

	/** @ --场所编码--csbm--String--30-- */
	private String csbm;

	/** @ --保存时间--savetime--Date---- */
	private Date savetime;

	/** @ --本设备采集的最大流水号--max_flow_no--Integer--10-- */
	private Integer max_flow_no;

	/** @ --本设备内核版本号--dev_version--String--100-- */
	private String dev_version;

	/** @ --设备更新状态--dev_up--Integer--1-- */
	private Integer dev_up;

	/** @ --设备更新状态显示中文 */
	private String dev_upName;

	/** @ --场所id--qyid--Integer--10-- */
	private Integer qyid;

	/** 分页排序 */
	private String pageSort;
	
	private String qymc;//场所名称
	
	private String parentName;//所属服务名称
	
	private String hylbdm;//行业类别代码
	
	private String hylb;//行业类别

	
	/** 筛选字段 */
	private String query_simplepinfuwu;



	/** @ 设备序号(dev_serial) */
	public Integer getDev_serial() {
		return dev_serial;
	}

	public void setDev_serial(Integer dev_serial) {
		this.dev_serial = dev_serial;
	}

	/** @ 设备名称(dev_name) */
	public String getDev_name() {
		return dev_name;
	}

	public void setDev_name(String dev_name) {
		this.dev_name = dev_name;
	}

	/** @ 设备IP(dev_ip) */
	public String getDev_ip() {
		return dev_ip;
	}

	public void setDev_ip(String dev_ip) {
		this.dev_ip = dev_ip;
	}

	/** @ 设备连接密码(dev_password) */
	public String getDev_password() {
		return dev_password;
	}

	public void setDev_password(String dev_password) {
		this.dev_password = dev_password;
	}

	/** @ 设备日志(dev_log) */
	public String getDev_log() {
		return dev_log;
	}

	public void setDev_log(String dev_log) {
		this.dev_log = dev_log;
	}

	/** @ 常关规则(dev_devrulezuc) */
	public Integer getDev_devrulezuc() {
		return dev_devrulezuc;
	}

	public void setDev_devrulezuc(Integer dev_devrulezuc) {
		this.dev_devrulezuc = dev_devrulezuc;
	}

	/** @ 常开规则(dev_devrulezuo) */
	public Integer getDev_devrulezuo() {
		return dev_devrulezuo;
	}

	public void setDev_devrulezuo(Integer dev_devrulezuo) {
		this.dev_devrulezuo = dev_devrulezuo;
	}

	/** @ 管理员编号(gly_no) */
	public String getGly_no() {
		return gly_no;
	}

	public void setGly_no(String gly_no) {
		this.gly_no = gly_no;
	}

	/** @ 设备更新时间(dev_update) */
	public Date getDev_update() {
		return dev_update;
	}

	public void setDev_update(Date dev_update) {
		this.dev_update = dev_update;
	}

	/** @ 联机，禁用时段设置(dev_devrulezul) */
	public String getDev_devrulezul() {
		return dev_devrulezul;
	}

	public void setDev_devrulezul(String dev_devrulezul) {
		this.dev_devrulezul = dev_devrulezul;
	}

	/** @ 连接类型(com) */
	public Integer getCom() {
		return com;
	}

	public void setCom(Integer com) {
		this.com = com;
	}

	/** @ 端口号(port) */
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	/** @ 波特率(btl) */
	public Integer getBtl() {
		return btl;
	}

	public void setBtl(Integer btl) {
		this.btl = btl;
	}

	/** @ 终端显示信息(xs) */
	public String getXs() {
		return xs;
	}

	public void setXs(String xs) {
		this.xs = xs;
	}

	/** @ 管理员密码(gly_psw) */
	public String getGly_psw() {
		return gly_psw;
	}

	public void setGly_psw(String gly_psw) {
		this.gly_psw = gly_psw;
	}

	/** @ 档案最近更新时间(dw_sj) */
	public Date getDw_sj() {
		return dw_sj;
	}

	public void setDw_sj(Date dw_sj) {
		this.dw_sj = dw_sj;
	}

	/** @ 所属服务序号(parent) */
	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	/** @ 终端MAC地址(mac) */
	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	/** @ 脱机数据实时存数据库标志(tjkq) */
	public Integer getTjkq() {
		return tjkq;
	}

	public void setTjkq(Integer tjkq) {
		this.tjkq = tjkq;
	}

	/** @ 设备最后在线时间(on_line) */
	public Date getOn_line() {
		return on_line;
	}

	public void setOn_line(Date on_line) {
		this.on_line = on_line;
	}

	/** @ 设备当前状态(run_state) */
	public Integer getRun_state() {
		return run_state;
	}

	public void setRun_state(Integer run_state) {
		this.run_state = run_state;
	}

	/** @ 下发通知状态(note_ok) */
	public Integer getNote_ok() {
		return note_ok;
	}

	public void setNote_ok(Integer note_ok) {
		this.note_ok = note_ok;
	}

	/** @ 档案变更时间(da_update) */
	public Date getDa_update() {
		return da_update;
	}

	public void setDa_update(Date da_update) {
		this.da_update = da_update;
	}

	/** @ 协查通报编号(notice_serial) */
	public Integer getNotice_serial() {
		return notice_serial;
	}

	public void setNotice_serial(Integer notice_serial) {
		this.notice_serial = notice_serial;
	}

	/** @ 设备CPU型号(dev_cpu) */
	public String getDev_cpu() {
		return dev_cpu;
	}

	public void setDev_cpu(String dev_cpu) {
		this.dev_cpu = dev_cpu;
	}

	/** @ 操作系统版本(dev_os) */
	public String getDev_os() {
		return dev_os;
	}

	public void setDev_os(String dev_os) {
		this.dev_os = dev_os;
	}

	/** @ 本次流量（字节）(flow_rate) */
	public Integer getFlow_rate() {
		return flow_rate;
	}

	public void setFlow_rate(Integer flow_rate) {
		this.flow_rate = flow_rate;
	}

	/** @ 场所编码(csbm) */
	public String getCsbm() {
		return csbm;
	}

	public void setCsbm(String csbm) {
		this.csbm = csbm;
	}

	/** @ 保存时间(savetime) */
	public Date getSavetime() {
		return savetime;
	}

	public void setSavetime(Date savetime) {
		this.savetime = savetime;
	}

	/** @ 本设备采集的最大流水号(max_flow_no) */
	public Integer getMax_flow_no() {
		return max_flow_no;
	}

	public void setMax_flow_no(Integer max_flow_no) {
		this.max_flow_no = max_flow_no;
	}

	/** @ 本设备内核版本号(dev_version) */
	public String getDev_version() {
		return dev_version;
	}

	public void setDev_version(String dev_version) {
		this.dev_version = dev_version;
	}

	/** @ 设备更新状态(dev_up) */
	public Integer getDev_up() {
		return dev_up;
	}

	public void setDev_up(Integer dev_up) {
		this.dev_up = dev_up;
	}



	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getDev_upName() {
		return dev_upName;
	}

	public void setDev_upName(String dev_upName) {
		this.dev_upName = dev_upName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getQuery_simplepinfuwu() {
		return query_simplepinfuwu;
	}

	public void setQuery_simplepinfuwu(String query_simplepinfuwu) {
		this.query_simplepinfuwu = query_simplepinfuwu;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}




}
