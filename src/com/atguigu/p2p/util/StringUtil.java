package com.atguigu.p2p.util;

public class StringUtil {
	
	/**
	 * 判断字符串是否是一个数字字符串
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str){
		if (str == null || str == "") {
			return false;
		}
		
		char[] chs = str.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			char ch = chs[i];
			if(ch < '0' || ch > '9'){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 两位小数
	 * @param str
	 * @return
	 */
	public static boolean has2Point(String str){
		if (str == null || str == "") {
			return false;
		}
		
		String reg = "^[0-9]+(.[0-9]{2})?$";
		if (str.matches(reg)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 只能输入由数字和26个英文字母组成的字符串
	 * @param str
	 * @return
	 */
	public static boolean isA2ZAndNum(String str){
		if (str == null || str == "") {
			return false;
		}
		
		String reg = "^[A-Za-z0-9]+$";
		if(str.matches(reg)){
			return true;
		}
		
		return false;
	}
}
