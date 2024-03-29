/**
 * $Id: CloseUtil.java 320 2012-06-13 06:23:50Z yang.guo $
 * Copyright(C) 2011-2016 dreamingame.com. All rights reserved.
 */
package util;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * 
 * @author <a href="mailto:shiyang.zhao@dreamingame.com">Rex Zhao</a>
 * @version 1.0
 * @since 1.0 Sep 26, 2011 10:25:16 AM
 */
public class CloseUtil {

	private static final CloseUtil instance = new CloseUtil();
	
	private static final Logger logger = Logger.getLogger(CloseUtil.class); 
	
	private CloseUtil() {}
	
	public static CloseUtil instance() {
		return instance;
	}
	
	public static void close(Closeable obj) {
		if (obj == null) return;
		try {
			obj.close();
		} catch (IOException e) {
			logger.error("无法关闭流对象[" + obj + "]", e);
		}
	}
	
	public static void close(Closeable... objs) {
		for (Closeable obj : objs) {
			close(obj);
		}
	}
	
	public static void close(Statement stmt) {
		if (stmt == null) return;
		try {
			if (!stmt.isClosed()) stmt.close();
		} catch (SQLException e) {
			logger.error("关闭Statement发生异常[" + stmt + "]", e);
		}
	}
	
	public static void close(ResultSet rs) {
		if (rs == null) return;
		try {
			if (!rs.isClosed()) rs.close();
		} catch (SQLException e) {
			logger.error("关闭Result发生异常[" + rs + "]", e);
		}
	}
	
	public static void close(ResultSet rs, Statement stmt) {
		close(rs);
		close(stmt);
	}
	
	public static void close(Connection conn) {
		if (conn == null) return;
		try {
			if (!conn.isClosed()) conn.close();
		} catch (SQLException e) {
			logger.error("关闭Connection发生异常[" + conn + "]", e);
		}
	}
}
