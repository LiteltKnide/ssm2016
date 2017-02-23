package com.atguigu.p2p.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.regex.Pattern;

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
	
	public static String capitalize(String str) {
		return changeFirstCharacterCase(str, true);
	}

	public static String uncapitalize(String str) {
		return changeFirstCharacterCase(str, false);
	}

	private static String changeFirstCharacterCase(String str,
			boolean capitalize) {
		if (str == null || str.length() == 0)
			return str;
		StringBuffer buf = new StringBuffer(str.length());
		if (capitalize)
			buf.append(Character.toUpperCase(str.charAt(0)));
		else
			buf.append(Character.toLowerCase(str.charAt(0)));
		buf.append(str.substring(1));
		return buf.toString();
	}

	public static String defaultIfEmpty(String str, String defaultString) {
		if (str == null)
			return defaultString;
		if (str.trim().length() == 0)
			return defaultString;
		else
			return str;
	}
 
 

	public static boolean hasContent(String s) {
		if (s == null)
			return false;
		return s.trim().length() != 0;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
	

    public static String toString(Object obj)
    {
        if(obj == null)
            return null;
        if(obj instanceof Date)
            return DateUtils.toDateStr((Date)obj);
        else
            return obj.toString();
    }

    public static String getFormat(int intLength, int scaleLength)
    {
        return getFormat(intLength, scaleLength, defaultType);
    }
     
 
//    public static String toString(Object obj, EiColumn col)
//    {
//        return toString(obj, col.getFieldLength(), col.getScaleLength());
//    }

    public static String toString(Object obj, int filedLength, int scaleLength)
    {
        int intLength = filedLength;
        if(scaleLength > 0)
            intLength = intLength - scaleLength - 1;
        if(obj == null)
            return null;
        if(obj instanceof Integer)
        {
            if(((Integer)obj).intValue() < 0)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength));
            return format.format((Integer)obj);
        }
        if(obj instanceof Long)
        {
            if(((Long)obj).longValue() < 0L)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength));
            return format.format((Long)obj);
        }
        if(obj instanceof Float)
        {
            if(((Float)obj).floatValue() < 0.0F)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength));
            return format.format((Float)obj);
        }
        if(obj instanceof Double)
        {
            if(((Double)obj).doubleValue() < 0.0D)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength));
            return format.format((Double)obj);
        }
        if(obj instanceof BigDecimal)
        {
            if(((BigDecimal)obj).doubleValue() < 0.0D)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength));
            return format.format((BigDecimal)obj);
        }
        if(obj instanceof Date)
            return DateUtils.toDateStr((Date)obj);
        else
            return obj.toString();
    }

    public static String toString(Object obj, int filedLength, int scaleLength, int type)
    {
        int intLength = filedLength;
        if(scaleLength > 0)
            intLength = intLength - scaleLength - 1;
        if(obj == null)
            return null;
        if(obj instanceof Integer)
        {
            if(((Integer)obj).intValue() < 0)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength, type));
            return format.format((Integer)obj);
        }
        if(obj instanceof Long)
        {
            if(((Long)obj).longValue() < 0L)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength, type));
            return format.format((Long)obj);
        }
        if(obj instanceof Float)
        {
            if(((Float)obj).floatValue() < 0.0F)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength, type));
            return format.format((Float)obj);
        }
        if(obj instanceof Double)
        {
            if(((Double)obj).doubleValue() < 0.0D)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength, type));
            return format.format((Double)obj);
        }
        if(obj instanceof BigDecimal)
        {
            if(((BigDecimal)obj).doubleValue() < 0.0D)
                intLength--;
            DecimalFormat format = new DecimalFormat(getFormat(intLength, scaleLength, type));
            return format.format((BigDecimal)obj);
        }
        if(obj instanceof Date)
            return DateUtils.toDateStr((Date)obj);
        else
            return obj.toString();
    }
 


    public static String getFormat(int intLength, int scaleLength, int type)
    {
        StringBuffer formatStr = new StringBuffer(intLength + scaleLength + 1);
        if(type == 4 || type == 1)
        {
            for(int i = 0; i < intLength - 1; i++)
                formatStr.append("0");

        }
        formatStr.append("0");
        if(scaleLength > 0)
        {
            formatStr.append(".");
            if(type == 3 || type == 1)
            {
                for(int i = 0; i < scaleLength; i++)
                    formatStr.append("0");

            } else
            {
                for(int i = 0; i < scaleLength; i++)
                    if(i == 0)
                        formatStr.append("0");
                    else
                        formatStr.append("#");

            }
        }
        return formatStr.toString();
    }
    
	public static final int INT_NEED = 4;

	public static final int SCALE_NEED = 3;

	public static final int NOT_NEED = 2;

	public static final int ALL_NEED = 1;

	public static int defaultType = 3;
}
