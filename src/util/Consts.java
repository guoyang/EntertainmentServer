/**
 * $Id$
 * Copyright(C) 2011-2016 dreamingame.com All rights reserved.
 */
package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 常量类
 * @author <a href="mailto:shiyang.zhao@dreamingame.com">Rex Zhao</a>
 * @version 1.0 2011-09-25 23:51:30
 */
public interface Consts {
	/** 组件名称前缀 */
	public static final String MODULE_NAME_PREFIX = "nx";
	/** 组件名称前缀缩写 */
	public static final String MODULE_SHORT_NAME_PREFIX = "nx";
	
	/** 默认字符 */
	public static final String DFT_CHARSET = "UTF-8";
    /** 日期格式 */
    public static final String DFT_DATE_FORMAT = "yyyy-MM-dd";
    /** 日期时间格式 */
    public static final String DFT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 时间格式 */
    public static final String DFT_TIME_FORMAT = "HH:mm:ss";

    /** 每秒的毫秒数 */
    public static final int MILL_SECONDS_PER_SECOND = 1000;
    /** 每分钟秒数 */
    public static final int SECONDS_PER_MINUTE = 60;
    /** 每分钟毫秒数 */
    public static final int MILL_SECONDS_PER_MINUTE = MILL_SECONDS_PER_SECOND * SECONDS_PER_MINUTE;
    /** 每小时分钟数 */
    public static final int MINUTES_PER_HOUR = 60;
    /** 每小时秒数 */
    public static final int SECONDS_PER_HOUR = MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
    /** 每小时毫秒数 */
    public static final int MILL_SECONDS_PER_HOUR = SECONDS_PER_HOUR * MILL_SECONDS_PER_SECOND;
    /** 每天小时数 */
    public static final int HOURS_PER_DAY = 24;
    /** 每天分钟数 */
    public static final int MINUTES_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR;
    /** 每天秒数 */
    public static final int SECONDS_PER_DAY = MINUTES_PER_DAY * SECONDS_PER_MINUTE;
    /** 每天毫秒数 */
    public static final int MILL_SECONDS_SECOND_PER_DAY = SECONDS_PER_DAY * MILL_SECONDS_PER_SECOND;
	
	/** 默认整数值 */
	public static final int DFT_INTEGER_VAL = 0;
	/** 默认字节值 */
	public static final byte DFT_BYTE_VAL = 0;
	/** 默认短整数值 */
	public static final short DFT_SHORT_VAL = 0;
	/** 默认长整数值 */
	public static final long DFT_LONG_VAL = 0L;
	/** 默认单精度浮点数值 */
	public static final float DFT_FLOAT_VAL = 0.0F;
	/** 默认双精度浮点数值 */
	public static final double DFT_DOUBLE_VAL = 0.0D;
	/** 默认布尔值 */
	public static final boolean DFT_BOOLEAN_VAL = false;
	/** 默认字符串值 */
	public static final String DFT_STRING_VAL = "".intern();
	/** 默认空字符串值 */
	public static final String DFT_NULL_STRING_VAL = "*NULL*".intern();
	/** 默认大整数数值 */
	public static final BigInteger DFT_BIGINTEGER_VAL = new BigInteger("0");
	/** 默认大小数数值 */
	public static final BigDecimal DFT_BIGDECIMAL_VAL = new BigDecimal("0");
	/** 默认日期数值 */
	public static final Date DFT_DATE_VAL = null;
	/** 默认时间戳值 */
	public static final Timestamp DFT_TIMESTAMP_VAL = null;
	
	/** 空Object数组 */
	public static final Object[] EMPTY_OBJECT_ARRAY = new Object[]{};
	/** 空整型数组 */
	public static final int[] EMPTY_INTEGER_ARRAY = new int[]{};
	/** 空整数对象类型数组 */
	public static final Integer[] EMPTY_INTEGER_WRAP_ARRAY = new Integer[]{};
	/** 空字节类型数组 */
	public static final byte[] EMPTY_BYTE_ARRAY = new byte[]{};
	/** 空字节对象类型数组 */
	public static final Byte[] EMPTY_BYTE_WRAP_ARRAY = new Byte[]{};
	/** 空短整数类型数组 */
	public static final short[] EMPTY_SHORT_ARRAY = new short[]{};
	/** 空短整数对象类型数组 */
	public static final Short[] EMPTY_SHORT_WRAP_ARRAY = new Short[]{};
	/** 空长整数类型数组 */
	public static final long[] EMPTY_LONG_ARRAY = new long[]{};
	/** 空长整数对象类型数组 */
	public static final Long[] EMPTY_LONG_WRAP_ARRAY = new Long[]{};
	/** 空单精度浮点类型数组 */
	public static final float[] EMPTY_FLOAT_ARRAY = new float[]{};
	/** 空单精度浮点对象类型数组 */
	public static final Float[] EMPTY_FLOAT_WRAP_ARRAY = new Float[]{};
	/** 空双精度浮点类型数组 */
	public static final double[] EMPTY_DOUBLE_ARRAY = new double[]{};
	/** 空双精度浮点对象类型数组 */
	public static final Double[] EMPTY_DOUBLE_WRAP_ARRAY = new Double[]{};
	/** 空布尔类型数组 */
	public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[]{};
	/** 空布尔对象类型数组 */
	public static final Boolean[] EMPTY_BOOLEAN_WRAP_ARRAY = new Boolean[]{};
	/** 空字符串类型数组 */
	public static final String[] EMPTY_STRING_ARRAY = new String[]{};
	/** 空大整数类型数组 */
	public static final BigInteger[] EMPTY_BIGINTEGER_ARRAY = new BigInteger[]{};
	/** 空大小数类型数组 */
	public static final BigDecimal[] EMPTY_BIGDECIMAL_ARRAY = new BigDecimal[]{};
	/** 空日期类型数组 */
	public static final Date[] EMPTY_DATE_ARRAY = new Date[]{};
	/** 空时间戳类型数组 */
	public static final Timestamp[] EMPTY_TIMESTAMP_ARRAY = new Timestamp[]{};
	
	/** 加密KEY-1 */
	public static final String ENCRYPT_KEY_1 = "-idodo";
	public static final byte[] ENCRYPT_KEY_1_BYTES = ENCRYPT_KEY_1.getBytes();
	/**缓存key分隔符*/
	public static final String CACHE_KEY_SEPARATOR = "_";
}
