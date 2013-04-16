package control;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * 
 * @author <a href="mailto:shiyang.zhao@dreamingame.com">Rex.Zhao</a>
 * @version 1.0
 * @since 1.0 Oct 24, 2011 2:59:40 PM
 */
public class ServletGlobal {

	private static final Logger logger = Logger.getLogger(ServletGlobal.class);
	private static final ThreadLocal<String> localIP = new ThreadLocal<String>();
	private static final ThreadLocal<HttpServletRequest> localRequest = new ThreadLocal<HttpServletRequest>();
	private static final List<ThreadLocal<?>> removeCache = new ArrayList<ThreadLocal<?>>();
	static {
		try {
			for (Field field : ServletGlobal.class.getDeclaredFields()) {
				if (field.getType() == ThreadLocal.class) {
					removeCache.add((ThreadLocal<?>)field.get(null));
				}
			}
		} catch (Exception e) {
			logger.error("Game Internal Error.", e);
//			throw new Exception();
		}
	}
	
	private ServletGlobal() {}
	
	public static void init(HttpServletRequest request) {
		localRequest.set(request);
		if (request.getHeader("X-Real-IP") != null) {
			localIP.set(request.getHeader("X-Real-IP"));
        } else {
        	localIP.set(request.getRemoteAddr());
        }
	}
	
	public static String getUserIP() {
		return localIP.get();
	}
	
	public static void removeAll() {
		for (ThreadLocal<?> local : removeCache) {
			local.remove();
		}
	}
	
	public static HttpServletRequest getRequest() {
		return localRequest.get();
	}
//	public static void setRequest(HttpServletRequest request) {
//		localRequest.set(request);
//	}
}
