package com.aisino2.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class Excel {

	private String path;
	private int type ;		// 类型：1,excel文件; 2,tsv格式	（暂时无用）
	private List list = new ArrayList();
	
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	/**
	 * 初始化
	 * @param path	文件地址
	 * @throws IOException
	 */
	public Excel(String path) throws IOException{
		this.path = path;
		try{
			this.initExcel();
		}catch(Exception e){
			// 
			try {
				initTSV();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new IOException("文件读取失败！");
			}
		}
	}
	
	/**
	 * 初始化excel
	 * @throws Exception
	 */
	public void initExcel() throws Exception{
		File file = new File(path);
		FileInputStream fs = null;
		Workbook wb = null;
        Sheet    st = null;
		try{
			wb = Workbook.getWorkbook(file);
			//得到execl第一个工作表
			st = wb.getSheet(0);
			for(int i=0 ; i<st.getRows() ; i++){
				Cell[] cell =st.getRow(i);
				String[] contents = new String[cell.length];
				for(int k=0 ; k<cell.length ; k++){
					contents[k] = cell[k].getContents();
				}
				list.add(contents);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("处理excel文件出错，转为处理TSV文件");
			throw e;
		}finally{
			wb.close();
		}
	}
	
	/**
	 * 初始化
	 * @throws IOException 
	 */
	private void initTSV() throws IOException{
		BufferedReader br = null;
		try {
			br = new BufferedReader (
			        new FileReader (this.path)
			);
			String line;
			while(( line=br.readLine())!= null ){
				String[] strs = line.split("\t");
				trim(strs);	// 格式化数据
				list.add(strs);	// 把数据放入list
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 得到excel的行数
	 * @return
	 */
	public int getRows(){
		return list.size();
	}
	
	/**
	 * 得到内容
	 * @param column
	 * @param row
	 * @return
	 */
	public String getContent(int column,int row){
		String contents[] = (String[])list.get(row-1);
		String content = contents[column-1];
		return content;
	}
	
	/**
	 * 得到指定行的数据
	 * @param row
	 * @return
	 */
	public String[] getLine(int row){
		return (String[])list.get(row-1);
	}
	
	/**
	 * 去掉前后双引号,"aaa" -> aaa
	 * @param strs
	 */
	private void trim(String[] strs){
		Pattern p = Pattern.compile("^\"(.*)\"$");
		Pattern p2 = Pattern.compile("^(0+)(\\d*)$");
		Pattern p3 = Pattern.compile("^(0+)\\.{0,1}(0+)$");


		for(int i=0 ; i<strs.length ; i++){
			strs[i] = strs[i].trim();	// 去掉空格
			Matcher m = p.matcher(strs[i]);	
			Matcher m2 = p2.matcher(strs[i]);
			Matcher m3 = p3.matcher(strs[i]);
			
//			if(m.matches()){
//				strs[i] = m.group(1);
//			}
			if(strs[i].equals("0.000")){
				System.out.print("111");
			}
			if(m3.matches()){	// 先判断是否为全零或者0.000之类
				strs[i] = "0";
			}else if(m2.matches()){	// 去掉前面的零 "000123" -> "123"
				strs[i] = m2.group(2);
			}else if(m.matches()){	// 去掉前后双引号
				strs[i] = m.group(1);
			}
		}
	}
	
	/**
	 * 打印数据
	 */
	public void print(){
		for(int i=0 ; i<list.size() ; i++){
			String[] strs = (String[])list.get(i);
			for(int k=0 ; k<strs.length ; k++){
				System.out.print( strs[k] + "#");
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * 得到excel文件列表（工具方法）
	 * @param dir	目录
	 * @param startdate	开始时间（时间戳形式）
	 * @param enddate	结束时间（时间戳形式）
	 * @return
	 */
	public static List getExcelFileList(String dir,long startdate,long enddate){
		List list = new ArrayList();
		File file = new File(dir);
		File[] files = file.listFiles();
		//System.out.println("start:" + startdate +"\n enddate:" + enddate);
		for(int i=0 ; i<files.length ; i++){

			//System.out.println(files[i].lastModified());
			if(files[i].lastModified() >=startdate && 
					files[i].lastModified() <=enddate &&
					(files[i].getName().indexOf(".xls")>0 || files[i].getName().indexOf(".XLS")>0)){
				list.add(files[i]);
				System.out.println(files[i].getName());
			}
		}
		return list;
	}
	
	/**
	 * 得到excel文件列表	（工具方法）
	 * @param dir
	 * @return
	 */
	public static List getExcelFileList(String dir){
		List list = new ArrayList();
		File file = new File(dir);
		File[] files = file.listFiles();
		//System.out.println("start:" + startdate +"\n enddate:" + enddate);
		for(int i=0 ; i<files.length ; i++){

			//System.out.println(files[i].lastModified());
			if((files[i].getName().indexOf(".xls")>0 || files[i].getName().indexOf(".XLS")>0)){
				list.add(files[i]);
//				System.out.println(files[i].getName());
			}
		}
		return list;
	}

	
	public static void main(String[] arg){
		/*File file = new File("g:\\mds\\phonebook.xls");
		System.out.println(file.delete());*/
		/*Excel csv ;
		try {
			//csv = new Excel("d:\\5.9（燃料油）.xls");
			csv = new Excel("g:\\mds\\phonebook.xls");
			csv.print();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("无法读取文件！");
		}*/

	}
}
