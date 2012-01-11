package com.aisino2.techsupport.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IDict_itemDao;
import com.aisino2.sysadmin.service.IDict_itemService;

@Component("CommonUtil")
public class CommonUtil {
	private   Properties techSupportEnvConfigProperty;
	private  IDict_itemService dict_itemService;
	/**
	 * 获取消息，基础消息模板转换器
	 * @param msg_template 消息模板（模板变量通过{I}的形式I为0-99的整数）
	 * @param args 模板参数值
	 * @return 转换后 的消息
	 */
	public   String getMsg(String msg_template,Object[] args){
		String msg=null;
		
		if(msg_template==null)
			throw new RuntimeException("消息模板必须不为空");
		
		msg=msg_template;
		if(args!=null && args.length>0)
			for(int i=0;i<args.length;i++)
				msg=msg.replaceAll("\\{"+i+"\\}", args[i].toString());
		return msg; 
	}
	
	/**
	 * 通过身份证号码得到生日
	 * @param id_num 身份证号码
	 * @return 生日
	 */
	public   Date get_birthday_from_id(String id_num){
		Date birthday=null;
		birthday=(Date) get_contentmap_from_id(id_num).get("birthday");
		return birthday;
	}
	
	/**
	 * 通过身份证得到性别
	 * @param id_num 身份证
	 * @return 性别
	 */
	public   String get_sex_from_id(String id_num){
		String sex=(String) get_contentmap_from_id(id_num).get("sex");
		return sex;
	}
	
	
	/**
	 *  通过身份证得到出生地
	 * @param id_num 身份证
	 * @return 出生地
	 */
	public   String get_homeplace_from_id(String id_num){
		String homeplace=(String)get_contentmap_from_id(id_num).get("homeplace");
		return homeplace;
	}
	/**
	 * 通过身份证号码得到所有属性
	 * @param id_num 身份证号码
	 * @return 所有内容属性映射
	 */
	public   Map<String, Object> get_contentmap_from_id(String id_num){
		Map<String, Object> cmap=new HashMap<String, Object>();
		
		if(id_num == null || "".equals(id_num))
			throw new RuntimeException("身份证号码为空;");
		
		try{
//			处理18位身份证号码
			if(id_num.length() == 18){
				Pattern regexp=  Pattern.compile("(\\d{6})(\\d{8})(\\d{3})[0-9A-Za-z]");
				Matcher matcher=regexp.matcher(id_num);
				if(matcher.matches()){
//					处理生日
					Date birthday=null;
					SimpleDateFormat birthday_sdf=new SimpleDateFormat("yyyyMMdd");
					birthday= birthday_sdf.parse(matcher.group(2));
					cmap.put("birthday", birthday);
					
//					处理性别
//					1为男性,0为女性
					int sex_dm=Integer.parseInt(matcher.group(3));
					cmap.put("sex", String.valueOf(sex_dm % 2));
					
//					处理出身地
//					6位制
					String homeplace=matcher.group(1);
					cmap.put("homeplace", homeplace);
				}
				
			}
//			处理15位身份证号码
			else if(id_num.length() == 15){
				Pattern regexp=  Pattern.compile("(\\d{6})(\\d{6})(\\d{3})");
				Matcher matcher=regexp.matcher(id_num);
				if(matcher.matches()){
//					处理生日
					Date birthday=null;
					SimpleDateFormat birthday_sdf=new SimpleDateFormat("yyyyMMdd");
					birthday= birthday_sdf.parse("19"+matcher.group(2));
					cmap.put("birthday", birthday);
//					处理性别
//					1为男性,0为女性
					int sex_dm=Integer.parseInt(matcher.group(3));
					cmap.put("sex", String.valueOf(sex_dm % 2));
//					处理出生地
//					6位制
					String homeplace=matcher.group(1);
					cmap.put("homeplace", homeplace);
				}

			}
			
//			都不是的话，标记为错误的身份证抛出异常
			else {
				throw new RuntimeException("无效的身份证");
			}
		}catch (RuntimeException e) {
			throw new RuntimeException("无效的身份证");
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("转换的时间格式不对应");
		}

		return cmap;
	}
	
	/**
	 * 技术支持单环境配置
	 * @param propKey 配置选项名称
	 * @return 配置值
	 * @throws IOException
	 */
	public   String getTechSupportEnvConfig(String propKey) throws IOException{
		if(techSupportEnvConfigProperty ==null){
			 techSupportEnvConfigProperty=new Properties();
			 FileInputStream fis=null;
			 String filepath=CommonUtil.class.getResource("").getPath()+"techsupport_env_config.properties";
			 filepath=filepath.replaceAll("%20", " ");
			 fis = new FileInputStream(new File(filepath));
			 techSupportEnvConfigProperty.load(fis);
			 fis.close();
		}
		return techSupportEnvConfigProperty.getProperty(propKey);
	}

	public  String buildConstantItem(String prefix,String dictcode){
		StringBuffer constantItemBuffer=new StringBuffer();
		
		return constantItemBuffer.toString();
	}
	
	public  void buildConstrants(){
		
	}
	@Resource(name="dict_itemService")
	public  void setDict_itemService(IDict_itemService dict_itemService) {
		this.dict_itemService = dict_itemService;
	}
}
