/**
 * $Id: GsonUtil.java 831 2012-10-12 07:33:30Z yang.guo $
 * Copyright(C) 2011-2016 dreamingame.com All rights reserved.
 */
package util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;

/**
 * 
 * @author <a href="mailto:shiyang.zhao@dreamingame.com">Rex Zhao</a>
 * @version 1.0 2012-2-21 上午12:04:30
 */
public class GsonUtil {
	
    private static Gson sGson = null;
    public static Gson getJsonInstance() {
        if (sGson == null) {
            synchronized(Gson.class) {
                sGson = new GsonBuilder()
//                .registerTypeAdapter(ActivityTask.class, new ActivityTaskSerializer())
//                .registerTypeAdapter(ActivityPlayer.class, new ActivityPlayerSerializer())
                .create();
            }
        }
        return sGson;
    }
    
	public static <T> JsonObject createJsonObject(T item, JsonSerializer<T> serializer) {
    	JsonObject jsonObject = new JsonObject();
    	jsonObject = (JsonObject)serializer.serialize(item, item.getClass(), null);
    	return jsonObject;
    }
    
    public static <T> JsonArray createJsonArray(List<T> items, JsonSerializer<T> serializer) {        
        JsonArray jsonArray = new JsonArray();        
        for(T t : items) {
            JsonElement e = serializer.serialize(t, t.getClass(), null);
            jsonArray.add(e);
        }        
        return jsonArray;
    }
    
    
//    public static String wrapJsonWithErrorCode(Object obj, int errorCode) {
//        Gson gson = getJsonInstance();
//        JsonElement e = gson.toJsonTree(obj);
//        return wrapJsonWithErrorCode(e,errorCode);
//    }
    
    public static String wrapJsonWithErrorCode(Object obj, int errorCode, long timestamp) {
    	Gson gson = getJsonInstance();
        JsonElement e = gson.toJsonTree(obj);
        return wrapJsonWithErrorCode(e,errorCode, timestamp);
    }
        
//    public static String wrapJsonWithErrorCode(JsonElement e, int errorCode) {
//        JsonElement root = wrapWithErrorCode(e,errorCode);
//        return root.toString();
//    }
    
//    public static String wrapJsonWithErrorCode(JsonElement e, int errorCode, long timestamp) {
//        JsonElement root = wrapWithErrorCode(e,errorCode, timestamp);
//        return root.toString();
//    }
    
//    private static JsonElement wrapWithErrorCode(JsonElement e, int errorCode) {
//        
//    	ErrorMessage[] errors = ErrorMessage.values(); 
//        if (errorCode < 0 || errorCode >= errors.length) {
//            errorCode = 0;
//        }
//        ErrorMessage errorInfo = errors[errorCode];        
//        JsonObject root = new JsonObject();
//        root.add("error", new JsonPrimitive(errorInfo.getErrorCode()));
//        root.add("errorMessage", new JsonPrimitive(LangDAOFacade.getLangContent(errorCode)));
////        root.add("errorMessage", new JsonPrimitive(errorInfo.getMessage()));
//        long time = System.currentTimeMillis();
//        root.add("timestamp", new JsonPrimitive(time));
//        root.add("data", e);
//        
//        return root;
//    }
    
//    private static JsonElement wrapWithErrorCode(JsonElement e, int errorCode, long timestamp) {
//
//    	ErrorMessage[] errors = ErrorMessage.values(); 
//        if (errorCode < 0 || errorCode >= errors.length) {
//            errorCode = 0;
//        }
//        ErrorMessage errorInfo = errors[errorCode];        
//        JsonObject root = new JsonObject();
//        root.add("error", new JsonPrimitive(errorInfo.getErrorCode()));
//        root.add("errorMessage", new JsonPrimitive(LangDAOFacade.getLangContent(errorCode)));
////        root.add("errorMessage", new JsonPrimitive(errorInfo.getMessage()));
//        root.add("timestamp", new JsonPrimitive(timestamp));
//        root.add("data", e);
//        
//        return root;
//    }
}
