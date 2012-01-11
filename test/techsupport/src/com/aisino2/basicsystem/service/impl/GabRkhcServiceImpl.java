package com.aisino2.basicsystem.service.impl;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxy;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import sun.misc.BASE64Decoder;

import com.aisino2.basicsystem.domain.Gabrkhc;
import com.aisino2.basicsystem.domain.Gabrkxx;
import com.aisino2.basicsystem.service.IGabRkhcService;
import com.aisino2.cache.CacheResult;
import com.aisino2.sysadmin.domain.Dict_item;
import com.neusoft.webservice.InJbxxBean;
import com.neusoft.webservice.OutJbxxChxxBean;
import com.neusoft.webservice.OutSigJbxxBean;
import com.neusoft.webservice.PopulationServicePortType;

public class GabRkhcServiceImpl implements IGabRkhcService{
    
	private Gabrkhc gabrkhc;
	private Gabrkxx gabrkxx;
 
	//判断公安部库中是否有此人信息
	public boolean hasRkxx(OutJbxxChxxBean outBean){
		boolean flag=false;
		if(outBean!=null){
			if(outBean.getCode().equals("1")){ //公安部库中找到对应的记录
				flag=true;
			}
		}
		return flag;
	}
	
	
	public OutSigJbxxBean[] getOutBeanJbxxs(OutJbxxChxxBean outBean) {
		OutSigJbxxBean[] signBeans=null;
		if(hasRkxx(outBean)){
			signBeans=outBean.getJbxxs();
		}
		return signBeans;
	}
	
	public Gabrkxx getGabrkxx(OutJbxxChxxBean outBean) throws IOException{
		Gabrkxx gabrkxx=null;
		if(hasRkxx(outBean)){
			OutSigJbxxBean[] signBeans=outBean.getJbxxs();
			Dict_item di=null;
			if(signBeans!=null){
				CacheResult cr=new CacheResult(); 
				gabrkxx=new Gabrkxx();
				gabrkxx.setXingming(signBeans[0].getCzrkXm());
				gabrkxx.setGmsfhm(signBeans[0].getCzrkGmsfhm());
				String xb=signBeans[0].getCzrkXb();
				di=cr.getCacheDictItem("dm_xb", xb, null, null, null);
				gabrkxx.setXingbie(di.getDisplay_name());
				String mz=signBeans[0].getCzrkMz();
				di=cr.getCacheDictItem("dm_mz", mz, null, null, null);
				gabrkxx.setMinzu(di.getDisplay_name());
				gabrkxx.setCengyongming(signBeans[0].getCzrkCym());
				gabrkxx.setChushengriqi(signBeans[0].getCzrkCsrq());
				String ssx=signBeans[0].getCzrkJgSsx();
				di=cr.getCacheDictItem("dm_xzqh", ssx, null, null, null);
				if(di!=null){
					gabrkxx.setJiguanssx(di.getDisplay_name());
				}else
					gabrkxx.setJiguanssx(ssx);
				gabrkxx.setShengao(signBeans[0].getCzrkSg());
				gabrkxx.setZhuzhi(signBeans[0].getCzrkZz());
				String zp=signBeans[0].getCzrkXp();
				if(zp!=null){
					BASE64Decoder decoder = new BASE64Decoder(); 
		            gabrkxx.setZhaopian(decoder.decodeBuffer(zp)) ; 
				}
				//gabrkxx.setZhaopian(signBeans[0].getCzrkXp());
				gabrkxx.setPaichusuobm(signBeans[0].getCzrkPcsJgdm());
				gabrkxx.setPaichusuomc(signBeans[0].getCzrkPcsMc());
				gabrkxx.setZxbs(signBeans[0].getCzrkZxbs());
			}
		}
		return gabrkxx;		
	}
	
	//获取带有冗余信息的公安部人口信息
	public Gabrkxx getGabrkxxRy(OutJbxxChxxBean outBean) throws IOException{
		Gabrkxx gabrkxx=null;
		if(hasRkxx(outBean)){
			OutSigJbxxBean[] signBeans=outBean.getJbxxs();
			Dict_item di=null;
			if(signBeans!=null){
				CacheResult cr=new CacheResult(); 
				gabrkxx=new Gabrkxx();
				gabrkxx.setXingming(signBeans[0].getCzrkXm());
				gabrkxx.setGmsfhm(signBeans[0].getCzrkGmsfhm());
				String xb=signBeans[0].getCzrkXb();
				gabrkxx.setXingbie(xb);
				di=cr.getCacheDictItem("dm_xb", xb, null, null, null);
				gabrkxx.setXingbie_zh(di.getDisplay_name());
				String mz=signBeans[0].getCzrkMz();
				gabrkxx.setMinzu(mz);
				di=cr.getCacheDictItem("dm_mz", mz, null, null, null);
				gabrkxx.setMinzu_zh(di.getDisplay_name());
				gabrkxx.setCengyongming(signBeans[0].getCzrkCym());
				gabrkxx.setChushengriqi(signBeans[0].getCzrkCsrq());
				String ssx=signBeans[0].getCzrkJgSsx();
				gabrkxx.setJiguanssx(ssx);
				di=cr.getCacheDictItem("dm_xzqh", ssx, null, null, null);
				if(di!=null){
					gabrkxx.setJiguanssx_zh(di.getDisplay_name());
				}else
					gabrkxx.setJiguanssx(ssx);
				gabrkxx.setShengao(signBeans[0].getCzrkSg());
				gabrkxx.setZhuzhi(signBeans[0].getCzrkZz());
				String zp=signBeans[0].getCzrkXp();
				if(zp!=null){
					BASE64Decoder decoder = new BASE64Decoder(); 
		            gabrkxx.setZhaopian(decoder.decodeBuffer(zp)) ; 
				}
				//gabrkxx.setZhaopian(signBeans[0].getCzrkXp());
				gabrkxx.setPaichusuobm(signBeans[0].getCzrkPcsJgdm());
				gabrkxx.setPaichusuomc(signBeans[0].getCzrkPcsMc());
				gabrkxx.setZxbs(signBeans[0].getCzrkZxbs());
			}
		}
		return gabrkxx;		
	}
	
	public OutJbxxChxxBean getOutJbxxBean(String gmsfzh) {
//		创建服务模型
	    Service serviceModel = new ObjectServiceFactory().create(PopulationServicePortType.class);	  
//	获取XFire的代理对象
	    XFire xfire = XFireFactory.newInstance().getXFire();
	    XFireProxyFactory factory = new XFireProxyFactory(xfire);
		OutJbxxChxxBean outBean = null;
	//定义web服务接口实例
	    try {
	    	String m_serviceUrl=gabrkhc.getM_serviceUrl();
	    	PopulationServicePortType service = (PopulationServicePortType) factory.create(serviceModel,
					m_serviceUrl);
	    	//System.out.println(m_serviceUrl);
			XFireProxy proxy = (XFireProxy) Proxy.getInvocationHandler(service);
			Client client = proxy.getClient();
			client.setProperty("mtom-enabled", "true");
			client.setProperty("urn:xfire:transport:http:chunking-enabled", "true");
			InJbxxBean inBean = null;
			inBean=new InJbxxBean();
			inBean.setCzrkGmsfhm(gmsfzh);
			inBean.setCzrkZxbs("2");  //在未注销范围内进行查询
			if(service !=null){
				//System.out.println("**********************&&&&&&&&&&&&&&&&&&"+gmsfzh);
				outBean= service.getRkxxByGmsfhmXm (inBean);
				//System.out.println("***************************finish********");
			}
	   } catch(MalformedURLException e) {
	         e.printStackTrace();
	   } catch (RemoteException e) {
		e.printStackTrace();
	   }
	   return  outBean;
	}

	public Gabrkhc getGabrkhc() {
		return gabrkhc;
	}

	public void setGabrkhc(Gabrkhc gabrkhc) {
		this.gabrkhc = gabrkhc;
	}

	//1:补齐成功   非1数字：返回调用公安部接口时错误号
	public int sjbqFlag(String gmsfzh){
		int flag = 0;
		String flagString=null;
		OutJbxxChxxBean outBean=getOutJbxxBean(gmsfzh);
		if(outBean!=null){
			flagString=outBean.getCode();
		}
		if("1".equals(flagString)){
			try {
				Gabrkxx gabrkxx=getGabrkxxRy(outBean);
				this.setGabrkxx(gabrkxx);
				flag=1;
			}catch(IOException e){
				e.printStackTrace();
			}			
		}else{
			flag=new Integer(flagString);
		}
		return flag;
	}
	
	//返回值： 1：查询到此人信息且姓名与身份证相符 2：姓名与身份证号不符 0：查无此人
	public int hcFlag(String gmsfzh, String xingming) {
		int flag = 0;
		String flagString=null;
		OutJbxxChxxBean outBean=getOutJbxxBean(gmsfzh);
		if(outBean!=null){
			flagString=outBean.getCode();
		}
		if(flagString.equals("1")){
			try {
				Gabrkxx gabrkxx=getGabrkxx(outBean);
				if(gabrkxx!=null)
					if(xingming.equals(gabrkxx.getXingming())){
						flag = 1;
					}else{ 
						flag = 2;
					}	
				this.setGabrkxx(gabrkxx);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			flag=new Integer(flagString);
		}
		return flag;
	}


	public Gabrkxx getGabrkxx() {
		return gabrkxx;
	}


	public void setGabrkxx(Gabrkxx gabrkxx) {
		this.gabrkxx = gabrkxx;
	}

}
