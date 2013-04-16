/**
 * 
 */
package enums;

import java.util.Collections;
import java.util.Map;

import util.CollectionUtil;

/**
 * @author Administrator
 *
 */
public enum ErrorMessage {

	ERROR_NONE("0", "ERROR NONE");
	
	private String errorCode;
	private String message;
	
	private static Map<String, ErrorMessage> map = CollectionUtil.newHashMap();
	
	static {
		Map<String, ErrorMessage> tmp = CollectionUtil.newHashMap();
		for(ErrorMessage em : ErrorMessage.values()) {
			tmp.put(em.getErrorCode(), em);
		}
		
		map = Collections.unmodifiableMap(tmp);
	}
	
	ErrorMessage(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public ErrorMessage getErrorMessage(int errorCode) {
		if(map == null) {
			return null;
		}
		return map.get(errorCode);
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getMessage() {
		return message;
	}
}
