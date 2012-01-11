package com.aisino2.basicsystem.service;

import com.aisino2.basicsystem.domain.Gabrkxx;
public interface IGabRkhcService {
	//OutJbxxChxxBean getOutJbxxBean(String gmsfzh);
	//OutSigJbxxBean[] getOutBeanJbxxs(OutJbxxChxxBean outBean);
	//Gabrkxx getGabrkxx(OutJbxxChxxBean outBean) throws IOException;
	// 1：查询到此人信息且姓名与身份证相符 2：姓名与身份证号不符 0：查无此人
	int hcFlag(String gmsfzh,String xingming);  
	//1:补齐成功   非1数字：返回调用公安部接口时错误号
	int sjbqFlag(String gmsfzh);
	// 查询到此人信息时候(相符或不相符)返回Garkxx对象
	Gabrkxx getGabrkxx();
}
