/**
 * 
 */
package dispatch;

import java.io.UnsupportedEncodingException;

import logic.LogicBase;

import org.apache.log4j.Logger;

import parser.ProtocolParser;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * @author Administrator
 *
 */
public class LogicRouter {

	private static final Logger logger = Logger.getLogger(LogicRouter.class);
	public static byte[] execute(ProtocolParser parser) {
		LogicBase base = LogicFactory.getLogicBase(parser.getLogicName());
		if(base == null) {
			logger.error("logic is not exist~logic name is " + parser.getLogicName());
			return "".getBytes();
		}
		
		Object ret = base.logic(parser);
		return handleReturn(ret);
	}
	
	private static byte[] handleReturn(Object obj) {
		try {
			if(obj == null) {
				logger.info("logic return is null~");
				return handleNullReturn();
			} else if(obj instanceof String) {
				return handleStringReturn(obj);
			} else if(obj instanceof Integer) {
				return handleIntReturn(obj);
			}
			
			logger.info("logic return is not the right type~");
			return "".getBytes();
		} catch (UnsupportedEncodingException e) {
			logger.error("handle return error~", e);
		}
		
		return "".getBytes();
	} 
	
	private static byte[] handleStringReturn(Object obj) throws UnsupportedEncodingException {
		String ret = (String)obj;

		JsonObject root = new JsonObject();
		root.add("code", new JsonPrimitive(0));
		root.add("message", new JsonPrimitive(""));
		root.add("data", new JsonPrimitive(ret));
		
		return root.toString().getBytes("UTF-8");
	}
	
	private static byte[] handleIntReturn(Object obj) throws UnsupportedEncodingException {
		int ret = Integer.parseInt((String)obj);
		
		JsonObject root = new JsonObject();
		root.add("code", new JsonPrimitive(ret));
		root.add("message", new JsonPrimitive(errorMessage(ret)));
		root.add("data", new JsonPrimitive(""));
		
		return root.toString().getBytes("UTF-8");
	}
	
	private static byte[] handleNullReturn() throws UnsupportedEncodingException {
		JsonObject root = new JsonObject();
		root.add("code", new JsonPrimitive(0));
		root.add("message", new JsonPrimitive(""));
		root.add("data", new JsonPrimitive(""));
		
		return root.toString().getBytes("UTF-8");
	}
	
	private static String errorMessage(int code) {
		//TODO need to do
		
		return "";
	}
}
