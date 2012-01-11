package com.aisino2.common;
/**
 * 字符串方法
 * @author mds
 */
public class StringUtil {
	
	/**
	 * 去掉字符串尾部偶数个0 (trimEven0("3206100000")=="320610")
	 * @param str 原始字符串
	 * @return
	 */
	public static String trimEven0(String str)
	{
		String returnStr = str;
		int numOf0 = 0;//str末尾0的个数
		if(str != null)
		{
			if(!"".equals(str))
			{
				//获得str尾部0的个数
				for (int i = str.length(); i > 0; i--) 
				{
					if (str.substring(i - 1, i).equals("0"))
						//returnStr = str.substring(0, i - 1);
						numOf0++;
					else
						break;
				}
				//若str尾部有奇数个0，则numOf0减1
				if(numOf0 >0)
				{
					if(numOf0%2 != 0)
					{
						numOf0 = numOf0-1;
					}
				}
				//去掉str尾部numOf0个0
				returnStr = returnStr.substring(0, returnStr.length() -numOf0);
			}
		}

		return returnStr;
	}
	/**
	* 去除字符串尾部所有0（trim0("3206000")=="3206"）
	* 注意：此方法会把尾部所有0去掉，无论是奇数还是偶数个。
	* @param str
	* @return
	*/
	public static String trim0(String str)
	{
		String returnStr = str;
		for (int i = str.length(); i > 0; i--) 
		{
			if (str.substring(i - 1, i).equals("0"))
				returnStr = str.substring(0, i - 1);
			else
				break;
		}
		return returnStr;
	}
		
	/**
	* str不足len位补0
	* @param str 原字符串
	* @param int 字符串需要达到的位数
	* @return
	*/
	public static String add0(String str,int len)
	{
		String returnStr = "";
		returnStr = str;
		if(str != null)
		{
			if(str.length()<len)
		    {
		    	for(int i=0;i<(len-str.length());i++)
				{
		    		returnStr+="0";
				}
		    }
		}
		return returnStr;
	}
	
	
	
	/**
	 * 15位身份证号码到18位身份证号码的转换
	 * @param IDCardNO15 15位身份证号码
	 * @return 18位身份证号码
	 */
	public static String IDCardNO15To18(String IDCardNO15)
	{
			String IDCardNO18 = "";
			if(IDCardNO15.length() == 15)
			{
			String IDCardNO17 = "";
			if(Integer.parseInt(IDCardNO15.substring(6, 8))>20)
				IDCardNO17 = IDCardNO15.substring(0, 6)+"19"+IDCardNO15.substring(6,15);
			else
				IDCardNO17 = IDCardNO15.substring(0, 6)+"20"+IDCardNO15.substring(6,15);
			IDCardNO18 = IDCardNO17 + getVerifyBit(IDCardNO17);
			}
			else
				IDCardNO18 = IDCardNO15;
			return IDCardNO18;
	}
	
	/**
	 * 获得18位身份证号码的最后一位
	 * @param IDCardNO18 17位身份证号码
	 * @return 18位身份证号码的最后一位
	 */
	public static String getVerifyBit(String IDCardNO17)
	{
		String lastBit = "";
		int tempNo =0;
		tempNo = (Integer.parseInt(IDCardNO17.substring(0,1))*7+Integer.parseInt(IDCardNO17.substring(1,2))*9+
				Integer.parseInt(IDCardNO17.substring(2,3))*10+Integer.parseInt(IDCardNO17.substring(3,4))*5+
				Integer.parseInt(IDCardNO17.substring(4,5))*8+Integer.parseInt(IDCardNO17.substring(5,6))*4+
				Integer.parseInt(IDCardNO17.substring(6,7))*2+Integer.parseInt(IDCardNO17.substring(7,8))*1+
				Integer.parseInt(IDCardNO17.substring(8,9))*6+
				Integer.parseInt(IDCardNO17.substring(9,10))*3+Integer.parseInt(IDCardNO17.substring(10,11))*7+
				Integer.parseInt(IDCardNO17.substring(11,12))*9+Integer.parseInt(IDCardNO17.substring(12,13))*10+
				Integer.parseInt(IDCardNO17.substring(13,14))*5+
				Integer.parseInt(IDCardNO17.substring(14,15))*8+Integer.parseInt(IDCardNO17.substring(15,16))*4+
				Integer.parseInt(IDCardNO17.substring(16,17))*2)%11;
		
		switch(tempNo)
		{
			case 0 :
				lastBit="1";
	          break;
			case 1 :
				lastBit="0";
	          break;
			case 2 :
	          lastBit="X";
	          break;
			case 3 :
	          lastBit="9";
	          break;
			case 4 :
	          lastBit="8";
	          break;
			case 5 :
	          lastBit="7";
	          break;
			case 6 :
	          lastBit="6";
	          break;
			case 7 :
	          lastBit="5";
	          break;
			case 8 :
	          lastBit="4";
	          break;
			case 9 :
	          lastBit="3";
	          break;
			case 10 :
	          lastBit="2";
	          break;
		}
		return lastBit;
	}
	
	public static String getNowTimeString() {
		java.lang.StringBuffer sb = new java.lang.StringBuffer("");
		java.util.Date loginDate = new java.util.Date();
		String dateStr = "";

		if ((loginDate.getMonth() + 1) < 10) {
			sb.append("0");
		}
		sb.append(loginDate.getMonth() + 1);
		sb.append("/");
		if (loginDate.getDate() < 10) {
			sb.append("0");
		}
		sb.append(loginDate.getDate());
		sb.append(" ");
		if (loginDate.getHours() < 10) {
			sb.append("0");
		}
		sb.append(loginDate.getHours());
		sb.append(":");
		if (loginDate.getMinutes() < 10) {
			sb.append("0");
		}
		sb.append(loginDate.getMinutes());
		sb.append(":");
		if (loginDate.getSeconds() < 10) {
			sb.append("0");
		}
		sb.append(loginDate.getSeconds());
		return sb.toString();
	}
	
	/**
	 * 获得非null字符串。若str不等于null，则返回str，否则返回空串
	 * @param str
	 * @return
	 */
	public static String getNotnullStr(String str)
	{
		String newStr = "";
		if(str!=null)
			newStr = str;
		return newStr;
	}
	
	/**
	 * 判断字符串时候为null或空串
	 * @param Str
	 * @return false-null或空串,true-非空串
	 */
	public static boolean isNotEmpty(String Str)
	{
		boolean isNotEmpty = false;
		if(Str!=null&&!"".equals(Str))
			isNotEmpty = true;
		return isNotEmpty;
	}
	
	public static void main(String[] args)
	{
		String str = "1";
		//System.out.println("---"+StringUtil.trimEven0(str)+"---");
		System.out.println("---"+str+"---");
		System.out.println("---"+StringUtil.isNotEmpty(str)+"---");
	}

}
