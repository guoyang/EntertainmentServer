/**
 * $Id: NumberUtil.java 320 2012-06-13 06:23:50Z yang.guo $
 * Copyright(C) 2011-2016 dreamingame.com All rights reserved.
 */
package util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数值工具类
 * @author <a href="mailto:shiyang.zhao@dreamingame.com">Rex Zhao</a>
 * @version 1.0 2011-09-26 00:45:07
 */
public class NumberUtil {
	/** 单例 */
	private static final NumberUtil instance = new NumberUtil();
	/** 最大整数值比较字符串 */
	private static final String MAX_JAVA_INTEGER_STR = String.valueOf(Integer.MAX_VALUE);
	/** 最小整数值比较字符串 */
	private static final String MIN_JAVA_INTEGER_STR = String.valueOf(Integer.MIN_VALUE);
	/** 最大整数值长度 */
	private static final int MAX_JAVA_INTEGER_LEN = MAX_JAVA_INTEGER_STR.length();
	/** 最小整数值长度 */
	private static final int MIN_JAVA_INTEGER_LEN = MIN_JAVA_INTEGER_STR.length();
	/** 最大短整数值比较字符串 */
	private static final String MAX_JAVA_SHORT_STR = String.valueOf(Short.MAX_VALUE);
	/** 最小短整数值比较字符串 */
	private static final String MIN_JAVA_SHORT_STR = String.valueOf(Short.MIN_VALUE);
	/** 最大短整数值长度 */
	private static final int MAX_JAVA_SHORT_LEN = MAX_JAVA_SHORT_STR.length();
	/** 最小短整数值长度*/
	private static final int MIN_JAVA_SHORT_LEN = MIN_JAVA_SHORT_STR.length();
	/** 最大长整数比较对象 */
	private static final BigInteger MAX_LONG    = new BigInteger(Long.MAX_VALUE + "");
	/** 最小长整数比较对象 */
	private static final BigInteger MIN_LONG    = new BigInteger(Long.MIN_VALUE + "");
	/** 最大单精度符点值比较对象 */
	private static final BigDecimal MAX_FLOAT   = new BigDecimal(Float.MAX_VALUE + "");
	/** 最小单精度符点值比较对象 */
	private static final BigDecimal MIN_FLOAT   = new BigDecimal(Float.MIN_VALUE + "");
	/** 最大双精度符点值比较对象 */
	private static final BigDecimal MAX_DOUBLE  = new BigDecimal(Double.MAX_VALUE + "");
	/** 最小双精度符点值比较对象 */
	private static final BigDecimal MIN_DOUBLE  = new BigDecimal(Double.MIN_VALUE + "");
	/** 匹配数值的正则表达式 */
	private static final String NUMBER_PATTERN  = "(\\-?)\\d+(\\.\\d+)?";
	/** 匹配整数正则表达式 */
	private static final String INTEGER_PATTERN = "(\\-?)\\d+";
	/** 匹配小数的正则表达式 */
	private static final String DECIMAL_PATTERN = "(\\-?)\\d+\\.\\d+";
	/** 匹配正数的正则表达式 */
	private static final String POSITIVE_NUMBER_PATTERN = "\\d+(\\.\\d+)?";
	/** 匹配正整数的正则表达式 */
	private static final String POSITIVE_INTEGER_PATTERN = "\\d+";
	/** 匹配正小数的正则表达式 */
	private static final String POSITIVE_DECIMAL_PATTERN = "\\d+\\.\\d+";
	/** 匹配负数的正则表达式 */
	private static final String NEGATIVE_NUMBER_PATTERN = "\\-\\d+(\\.\\d+)?";
	/** 匹配负正数的正则表达式 */
	private static final String NEGATIVE_INTEGER_PATTERN = "\\-\\d+";
	/** 匹配负小数的正则表达式 */
	private static final String NEGATIVE_DECIMAL_PATTERN = "\\-\\d+\\.\\d+";

	private NumberUtil() {}
	
	/**
	 * 取得该类唯一实例
	 * @return 该类唯实例
	 */
	public static NumberUtil instance() {
		return instance;
	}
	
	/**
	 * 将字符串转化为int类型的值
	 * @param input 待转化字符串
	 * @return
	 * <li>字符串可以转化为Java的整数时，返回转化后数值</li>
	 * <li>其它，返回NxConsts.DFT_INTEGER_VAL返回值</li>
	 * @see #getInteger(String, int)
	 * @see com.nx.commons.lang.NxConsts#DFT_INTEGER_VAL
	 */
	public static int getInteger(String input) {
		return getInteger(input, NxConsts.DFT_INTEGER_VAL);
	}
	
	public static int getInteger(Object input) {
		if (input == null) return NxConsts.DFT_INTEGER_VAL;
		return getInteger(input.toString());
	}
	
	public static int getInteger(Object input, int defVal) {
		if (input == null) return NxConsts.DFT_INTEGER_VAL;
		return getInteger(input.toString(), defVal);
	}
	/**
	 * 将字符串转化为int类型的值
	 * @param input 待转化字符串
	 * @param defVal 无法转换时的默认值
	 * @return
	 * <li>字符串可以转化为Java的整数时，返回转化后数值</li>
	 * <li>其它，返回参数defVal的值</li>
	 */
	public static int getInteger(String input, int defVal) {
		return isJavaInteger(input) ? Integer.parseInt(input) : defVal;
	}
	/**
	 * 判断传入字符串是否可以转化为Java整数
	 * @param input 待检测字符串
	 * @return
	 * <li>true：可以转化</li>
	 * <li>false:不能转化</li>
	 */
	public static boolean isJavaInteger(String input) {
		//整数检测
		if (!isInteger(input)) return false;
		//值域检测
		int len = input.length();
		char ch = input.charAt(0);
		boolean flg = (ch == '-');
		int borderLen = (flg) ? MIN_JAVA_INTEGER_LEN : MAX_JAVA_INTEGER_LEN;
		if (len > borderLen) return false;
		if (len < borderLen) return true;
		String border = (flg) ? MIN_JAVA_INTEGER_STR : MAX_JAVA_INTEGER_STR;
		for (int i = 0; i < len; i++) {
			ch = input.charAt(i);
			char chb = border.charAt(i);
			if (ch == chb) continue;
			return (ch < chb);
		}
		return true;
	}
	
	
	/**
	 * 将字符串转化为short类型的值
	 * @param input 待转化字符串
	 * @return
	 * <li>字符串可以转化为Java的整数时，返回转化后数值</li>
	 * <li>其它，返回NxConsts.DFT_SHORT_VAL</li>
	 * @see #getShort(String, short)
	 * @see com.nx.commons.lang.NxConsts#DFT_SHORT_VAL
	 */
	public static short getShort(String input) {
		return getShort(input, NxConsts.DFT_SHORT_VAL);
	}
	/**
	 * 将字符串转化为short类型的值
	 * @param input 待转化字符串
	 * @param defVal 无法转换时的默认值
	 * @return
	 * <li>字符串可以转化为Java的整数时，返回转化后数值</li>
	 * <li>其它，返回参数defVal的值</li>
	 */
	public static short getShort(String input, short defVal) {
		return isShort(input) ? Short.parseShort(input) : defVal;
	}
	/**
	 * 判断传入字符串是否可以转化为Java短整型
	 * @param input 待检测字符串
	 * @return
	 * <li>true：可以转化</li>
	 * <li>false:不能转化</li>
	 */
	public static boolean isShort(String input) {
		//整数检测
		if (!isInteger(input)) return false;
		//值域检测
		int len = input.length();
		char ch = input.charAt(0);
		boolean flg = (ch == '-');
		int borderLen = (flg) ? MIN_JAVA_SHORT_LEN : MAX_JAVA_SHORT_LEN;
		if (len > borderLen) return false;
		if (len < borderLen) return true;
		String border = (flg) ? MIN_JAVA_SHORT_STR : MAX_JAVA_SHORT_STR;
		for (int i = 0; i < len; i++) {
			ch = input.charAt(i);
			char chb = border.charAt(i);
			if (ch == chb) continue;
			return (ch < chb);
		}
		return true;
	}
	
	/**
	 * 将字符串转化为byte类型的值
	 * @param input 待转化字符串
	 * @return
	 * <li>字符串可以转化为byte值时，返回转化后数值</li>
	 * <li>其它，返回NxConsts.DFT_BYTE_VAL</li>
	 * @see #getByte(String, byte)
	 * @see com.nx.commons.lang.NxConsts#DFT_BYTE_VAL
	 */
	public static byte getByte(String input) {
		return getByte(input, NxConsts.DFT_BYTE_VAL);
	}
	/**
	 * 将字符串转化为byte类型的值
	 * @param input 待转化字符串
	 * @param defVal 无法转换时的默认值
	 * @return
	 * <li>字符串可以转化为byte值时，返回转化后数</li>
	 * <li>其它，返回参数defVal的值</li>
	 */
	public static byte getByte(String input, byte defVal) {
		return isByte(input) ? Byte.parseByte(input) : defVal;
	}
	/**
	 * 判断传入字符串是否可以转化为byte
	 * @param input 待检测字符串
	 * @return
	 * <li>true：可以转</li>
	 * <li>false:不能转化</li>
	 */
	public static boolean isByte(String input) {
		if (input == null || !input.matches(INTEGER_PATTERN)) return false;
		if (input.length() > 4) return false;
		int tmp = Integer.parseInt(input);
		return (tmp <= Byte.MAX_VALUE && tmp >= Byte.MIN_VALUE);
	}
	
	/**
	 * 将字符串转化为long类型的值
	 * @param input 待转化字符串
	 * @return
	 * <li>字符串可以转化为long值时，返回转化后数值</li>
	 * <li>其它，返回NxConsts.DFT_LONG_VAL</li>
	 * @see #getLong(String, long)
	 * @see com.nx.commons.lang.NxConsts#DFT_LONG_VAL
	 */
	public static long getLong(String input) {
		return getLong(input, NxConsts.DFT_LONG_VAL);
	}
	/**
	 * 将字符串转化为long类型的值
	 * @param input 待转化字符串
	 * @param defVal 无法转换时的默认值
	 * @return
	 * <li>字符串可以转化为long值时，返回转化后数值</li>
	 * <li>其它，返回参数defVal的值</li>
	 */
	public static long getLong(String input, long defVal) {
		return isLong(input) ? Long.parseLong(input) : defVal;
	}
	/**
	 * 判断传入字符串是否可以转化为long
	 * @param input 待检测字符串
	 * @return
	 * <li>true：可以转</li>
	 * <li>false:不能转化</li>
	 */
	public static boolean isLong(String input) {
		if (input == null || !input.matches(INTEGER_PATTERN)) return false;
		BigInteger bi = new BigInteger(input);
		return (bi.compareTo(MIN_LONG) >= 0 && bi.compareTo(MAX_LONG) <= 0);
	}
	
	/**
	 * 将字符串转化为float类型的值
	 * @param input 待转化字符串
	 * @return
	 * <li>字符串可以转化为float值时，返回转化后数值</li>
	 * <li>其它，返回NxConsts.DFT_FLOAT_VAL</li>
	 * @see #getFloat(String, float)
	 * @see com.nx.commons.lang.NxConsts#DFT_FLOAT_VAL
	 */
	public static float getFloat(String input) {
		return getFloat(input, NxConsts.DFT_FLOAT_VAL);
	}
	/**
	 * 将字符串转化为float类型的值
	 * @param input 待转化字符串
	 * @param defVal 无法转换时的默认值
	 * @return
	 * <li>字符串可以转化为float值时，返回转化后数值</li>
	 * <li>其它，返回参数defVal的值</li>
	 */
	public static float getFloat(String input, float defVal) {
		return isFloat(input) ? Float.parseFloat(input) : defVal;
	}
	/**
	 * 判断传入字符串是否可以转化为float
	 * @param input 待检测字符串
	 * @return
	 * <li>true：可以转</li>
	 * <li>false:不能转化</li>
	 */
	public static boolean isFloat(String input) {
		if(!isNumber(input)) return false;
		BigDecimal bd = new BigDecimal(input);
		return (bd.compareTo(MIN_FLOAT) >= 0 && bd.compareTo(MAX_FLOAT) <= 0);
	}
	
	/**
	 * 将字符串转化为double类型的值
	 * @param input 待转化字符串
	 * @return
	 * <li>字符串可以转化为double值时，返回转化后数值</li>
	 * <li>其它，返NxConsts.DFT_DOUBLE_VAL</li>
	 * @see #getDouble(String, double)
	 * @see com.nx.commons.lang.NxConsts#DFT_DOUBLE_VAL
	 */
	public static double getDouble(String input) {
		return getDouble(input, NxConsts.DFT_DOUBLE_VAL);
	}
	/**
	 * 将字符串转化为double类型的值
	 * @param input 待转化字符串
	 * @param defVal 无法转换时的默认值
	 * @return
	 * <li>字符串可以转化为double值时，返回转化后数值</li>
	 * <li>其它，返回参数defVal的值</li>
	 */
	public static double getDouble(String input, double defVal) {
		return isDouble(input) ? Double.parseDouble(input) : defVal;
	}
	/**
	 * 判断传入字符串是否可以转化为double
	 * @param input 待检测字符串
	 * @return
	 * <li>true：可以转</li>
	 * <li>false:不能转化</li>
	 */
	public static boolean isDouble(String input) {
		if(!isNumber(input)) return false;
		BigDecimal bd = new BigDecimal(input);
		return (bd.compareTo(MIN_DOUBLE) >= 0 && bd.compareTo(MAX_DOUBLE) <= 0);
	}
	
	/**
	 * 将字符串转化为boolean类型的值
	 * @param input 待转化字符串
	 * @return
	 * <li>字符串可以转化为boolean值时，返回转化后布尔值</li>
	 * <li>其它，返回NxConsts.DFT_BOOLEAN_VAL</li>
	 * @see #getBoolean(String, boolean)
	 * @see com.nx.commons.lang.NxConsts#DFT_BOOLEAN_VAL
	 */
	public static boolean getBoolean(String input) {
		return getBoolean(input, NxConsts.DFT_BOOLEAN_VAL);
	}
	/**
	 * 将字符串转化为boolean类型的值
	 * @param input 待转化字符串
	 * @param defVal 无法转换时的默认值
	 * @return <br/>
	 *   <li>字符串为"true"时(不区分大小写)，返回true</li>
	 *   <li>字符串为整数，且不为1个或多个"0"时，返回true</li>
	 *   <li>字符串为"false"时(不区分大小写)，返回false</li>
	 *   <li>字符串为1个或多个"0"时，返回false</li>
	 *   <li>其它，返回defVal指定的值</li>
	 */
	public static boolean getBoolean(String input, boolean defVal) {
		if (input == null) return defVal;
		if (input.equalsIgnoreCase("true")) return true;
		if (input.equalsIgnoreCase("false")) return false;
		if (matchesNumber(input, NUMBER_PATTERN)) {
			return (getInteger(input) != 0);
		}
		return defVal;
	}
	
	public static boolean getBoolean(Object input) {
		return getBoolean(StringUtil.getString(input), NxConsts.DFT_BOOLEAN_VAL);
	}
	
	/**
	 * 检测字符串是否可以转化为数值
	 * @param input 待检测字符串
	 * @return
	 * <li>true：可以转化成数值</li>
	 * <li>false：不能转化成数值</li>
	 */
	public static boolean isNumber(String input) {
		return matchesNumber(input, NUMBER_PATTERN);
	}
	/**
	 * 检测字符串是否可以是整数值
	 * <B>效率是正则表达式检测的20-60</B>
	 * @param input 待检测字符串
	 * @return
	 * <li>true：是整数</li>
	 * <li>false：不是整数</li>
	 */
	public static boolean isInteger(String input) {
		if (input == null) return false;
		int len = input.length();
		if (len == 0) return false;
		char ch = input.charAt(0);
		if (ch != '-' && (ch < '0' || ch > '9')) return false;
		for (int i = 1; i < len; i++) {
			ch = input.charAt(i);
			if (ch < '0' && ch > '9') return false;
		}
		return true;
	}
	/**
	 * 检测字符串是否是小数
	 * @param input 待检测字符串
	 * @return
	 * <li>true：是小数</li>
	 * <li>false：不是小数</li>
	 */
	public static boolean isDecimal(String input) {
		return matchesNumber(input, DECIMAL_PATTERN);
	}
	/**
	 * 检测字符串是否是正数
	 * @param input 待检测字符串
	 * @return
	 * <li>true：是正数</li>
	 * <li>false：不是正数</li>
	 */
	public static boolean isPositiveNumber(String input) {
		return matchesNumber(input, POSITIVE_NUMBER_PATTERN);
	}
	/**
	 * 检测字符串是否是正整数
	 * @param input 待检测字符串
	 * @return
	 * <li>true：是正整数</li>
	 * <li>false：不是正整数</li>
	 */
	public static boolean isPositiveInteger(String input) {
		return matchesNumber(input, POSITIVE_INTEGER_PATTERN);
	}
	/**
	 * 检测字符串是否是正小数
	 * @param input 待检测字符串
	 * @return
	 * <li>true：是正小数</li>
	 * <li>false：不是正小数</li>
	 */
	public static boolean isPositiveDecimal(String input) {
		return matchesNumber(input, POSITIVE_DECIMAL_PATTERN);
	}
	/**
	 * 检测字符串是否是负数
	 * @param input 待检测字符串
	 * @return
	 * <li>true：是负数</li>
	 * <li>false：不是负数</li>
	 */
	public static boolean isNegativeNumber(String input) {
		return matchesNumber(input, NEGATIVE_NUMBER_PATTERN);
	}
	/**
	 * 检测字符串是否是负整数
	 * @param input 待检测字符串
	 * @return
	 * <li>true：是负整数</li>
	 * <li>false：不是负整数</li>
	 */
	public static boolean isNegativeInteger(String input) {
		return matchesNumber(input, NEGATIVE_INTEGER_PATTERN);
	}
	/**
	 * 检测字符串是否是负小数
	 * @param input 待检测字符串
	 * @return
	 * <li>true：是负小数</li>
	 * <li>false：不是负小数</li>
	 */
	public static boolean isNegativeDecimal(String input) {
		return matchesNumber(input, NEGATIVE_DECIMAL_PATTERN);
	}
	/**
	 * 检测字符串匹配
	 * @param input 待检测字符串
	 * @param pattern 匹配规则
	 * @return
	 * <li>true：字符串不为null，且与pattern参数指定规则匹配</li>
	 * <li>false：其它</li>
	 */
	private static boolean matchesNumber(String input, String pattern) {
		return (input != null && input.matches(pattern));
	}
	/**
	 * 将字符串转化为BigDecimal类型对象
	 * @param input 待转化字符串
	 * @return
	 * <li>字符串内容为数值时，返回转化后对象</li>
	 * <li>其它，返回NxConsts.DFT_BIGDECIMAL_VAL</li>
	 * @see #getBigDecimal(String, BigDecimal)
	 * @see com.nx.commons.lang.NxConsts#DFT_BIGDECIMAL_VAL
	 */
	public static BigDecimal getBigDecimal(String input) {
		return getBigDecimal(input, NxConsts.DFT_BIGDECIMAL_VAL);
	}
	/**
	 * 将字符串传话为BigDecimal类型对象
	 * @param input 待转化字符串
	 * @param defVal 无法转化时默认返回值
	 * @return
	 * <li>字符串内容是数值时，返回转化后对象</li>
	 * <li>其它，返回null</li>
	 * @see #getBigDecimal(String)
	 */
	public static BigDecimal getBigDecimal(String input, BigDecimal defVal) {
		return isNumber(input) ? new BigDecimal(input) : defVal;
	}
	
	/**
	 * 将字符串转化为BigInteger类型对象
	 * @param input 待转化字符串
	 * @return
	 * <li>字符串内容为数值时，返回转化后对象</li>
	 * <li>其它，返回NxConsts.DFT_BIGINTEGER_VAL</li>
	 * @see #getBigInteger(String, BigInteger)
	 * @see com.nx.commons.lang.NxConsts#DFT_BIGINTEGER_VAL
	 */
	public static BigInteger getBigInteger(String input) {
		return getBigInteger(input, NxConsts.DFT_BIGINTEGER_VAL);
	}
	/**
	 * 将字符串传话为BigInteger类型对象
	 * @param input 待转化字符串
	 * @param defVal 无法转化时默认返回值
	 * @return
	 * <li>字符串内容是数值时，返回转化后对象</li>
	 * <li>其它，返回null</li>
	 * @see #getBigInteger(String)
	 */
	public static BigInteger getBigInteger(String input, BigInteger defVal) {
		return isInteger(input) ? new BigInteger(input) : defVal;
	}
}
