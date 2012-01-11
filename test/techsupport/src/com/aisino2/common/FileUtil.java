package com.aisino2.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;




public class FileUtil {
	final static String filePath="c:/windows/system32/nbdwconfig.ini";
/**
	 * <p>读取文件</p>
	 * @param filePath 文件的路径和名字
	 */
	public static String readFile(String findStr) {
		FileInputStream fos=null;
		BufferedReader br=null;
		String nr="";
		try{
			fos = new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fos));
			String src = null;
			String newSrc = null;
			boolean bool = false;
			
			while ((src = br.readLine()) != null) {
				if (bool) {
					newSrc = src;
					bool = true;
				}
				newSrc = newSrc + src;
			}
			String[] context=newSrc.split(";");
			if(context!=null){
				for(int i=0;i<context.length;i++){
					String[] c=context[i].split("=");
					nr=c[1].trim();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally{
				br=null;
				fos=null;
			}
			
		}
		return nr;
	}

	/**
	 * 写文件
	 * @param str 需要打印的文本内容为字符串
	 * @param fileName 文件存放路径和路径
	 * @param bool 文件写入时，是否以追加方式
	 * @throws IOException
	 */
	public static boolean writeFile(String str, boolean bool){
		// 目的文件
		boolean b=false;
		FileWriter fw = null;
		try {
			fw = new FileWriter(filePath, bool);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(str+";");
			//将缓冲区中的数据全部写出
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			b=false;
		}finally{
			//关闭流
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
				b=false;
			}
		}
		return b;
	}
	
	/**
     * 判断本地的指定文件夹下的文件，是否存在
     * @param localPath
     * @param logPath
     * @return
     */
    public static boolean isExistLocalFile(){
    	 File fdir = new File(filePath);
    	 return fdir.exists();
    }
}