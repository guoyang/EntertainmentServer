/**
 * 
 */
package parser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import util.CloseUtil;
import util.GsonUtil;
import util.StringUtil;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * @author Administrator
 *	TODO 需要根据接收和返回值类型是json还是xml确定parser类的写法
 */
public class ProtocolParser {

	private Logger logger = Logger.getLogger(ProtocolParser.class);
	private HttpServletRequest request;
	private String logicName;
	private Map<String, Object> paraMap = new HashMap<String, Object>();
	private ProtocolHeader header;
	
	public ProtocolParser(HttpServletRequest request) {
		this.request = request;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		if (!paraMap.containsKey(key)) return null;
    	Object value = paraMap.get(key);
    	return (value instanceof JsonPrimitive) ? (T)((JsonPrimitive)value).getAsString() : (T)paraMap.get(key);
	}
	
	public void parser() {
		byte[] data = getRequestContent(request);
		logicName = getLogicCode(request.getRequestURI());
		Map<String, Object> map = new HashMap<String, Object>();
		
		Gson gson = GsonUtil.getJsonInstance();
		JsonParser parser = new JsonParser();
		Reader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
//			throw new NxException("不支持的编码格式:{0}", e, "UTF-8");
			logger.error("不支持的编码格式" + "UTF-8", e);
		}
		JsonElement rootElement = null;
		try {
			rootElement = parser.parse(reader);
		} catch(JsonParseException e) {
			logger.error("parser errorr :" + new String(data));
			throw e;
		} finally {
			CloseUtil.close(reader);
		}
		JsonObject rootObj = rootElement.getAsJsonObject();
		
		this.header = gson.fromJson(rootObj.getAsJsonObject("header"), ProtocolHeader.class);
		JsonObject commandObj = rootObj.getAsJsonObject("command");
        for (Map.Entry<String, JsonElement> entry : commandObj.entrySet()) {
        	map.put(entry.getKey(), entry.getValue());
        }
		this.paraMap = Collections.unmodifiableMap(map);
		logger.info("parser success~");
	}
	
	public String getLogicName() {
		return logicName;
	}
	
	public Map<String, Object> getParaMap() {
		return paraMap;
	}
	
	private String getLogicCode(String url) {
		String logicCode = url.replaceAll("^.*/action/(.+)$", "$1");
		if (StringUtil.isEmpty(logicCode))
//			throw new NxException("无法解析的URI：{0}", url);
			logger.error("无法解析的URI：" + url);
		return logicCode;
	}

	private final byte[] getRequestContent(HttpServletRequest request) {
		int CONTENT_MAX_READ_TIMES = 5;
		//get request content length
		final int contentLength = request.getContentLength();
		if (contentLength <= 0)
//			throw new NxException("错误的输入流长度:{0}", contentLength);
			logger.error("错误的输入流长度" + contentLength);
		
		//get request content
		byte[] data = new byte[contentLength];
		try {
			BufferedInputStream bis = new BufferedInputStream(request.getInputStream());
			int readLength = bis.read(data, 0, contentLength);
			int count = 0;
			while (readLength < contentLength) {
				//读取次数超过最大设置读取次数时还没有读取全部请求内容，返回错误
				if ((++count) > CONTENT_MAX_READ_TIMES) {
//					throw new NxException("can't get full request content.({0}/{1})", readLength, contentLength);
					logger.error("can't get full request content. readLength :" + readLength + ",contentLength :" + contentLength);
					return "".getBytes();
				}
				readLength += bis.read(data, readLength, contentLength - readLength);
			}
		} catch (IOException e) {
//			throw new NxException("获得请求内容发生异常", e);
			logger.error("获得请求内容发生异常", e);
		}
		return data;
	}
	
	public ProtocolHeader getHeader() {
    	return this.header;
    }
    
    @Override
    public String toString() {
    	return header.toString() + "\n" + paraMap.toString();
    }
}
