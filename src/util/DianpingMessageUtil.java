/**
 * 
 */
package util;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;

/**
 * @author Administrator
 * 
 */
public class DianpingMessageUtil {

	private static final Logger logger = Logger .getLogger(DianpingMessageUtil.class);
	// 定义申请获得的appKey和appSecret
	private static String appkey = "9727577107";
	private static String secret = "6fbfa991c6564194914599bcc61be169";
	private static String apiUrl = "http://api.dianping.com/";

	public static String sendMessage(Map<String, String> paramMap, String protocolName) {
		// 创建参数表
//		paramMap = CollectionUtil.newHashMap();
//		paramMap.put("format", "json");
//		paramMap.put("city", "上海");
//		paramMap.put("latitude", "31.21524");
//		paramMap.put("longitude", "121.420033");
//		paramMap.put("category", "美食");
//		paramMap.put("region", "长宁区");
//		paramMap.put("limit", "20");
//		paramMap.put("radius", "2000");
//		paramMap.put("offset_type", "0");
//		paramMap.put("has_coupon", "1");
//		paramMap.put("has_deal", "1");
//		paramMap.put("keyword", "泰国菜");
//		paramMap.put("sort", "7");
		String apiUrlTmp = apiUrl + protocolName;
		// 拼接有序的参数名-值串
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(appkey);
		if(paramMap != null && paramMap.size() > 0) {
			
			// 对参数名进行字典排序
			String[] keyArray = paramMap.keySet().toArray(new String[0]);
			Arrays.sort(keyArray);
			
			for (String key : keyArray) {
				stringBuilder.append(key).append(paramMap.get(key));
			}
			
		}

		stringBuilder.append(secret);
		String codes = stringBuilder.toString();

		/*
		 * 以下sha1签名代码效果等同 byte[] sha =
		 * org.apache.commons.codec.digest.DigestUtils
		 * .sha(org.apache.commons.codec
		 * .binary.StringUtils.getBytesUtf8(codes)); String sign =
		 * org.apache.commons
		 * .codec.binary.Hex.encodeHexString(sha).toUpperCase();
		 */
		String sign = org.apache.commons.codec.digest.DigestUtils.shaHex(codes)
				.toUpperCase();

		// 签名示例
		// 7D78381BC58E1DB1DBA4BD965916FE6B4D5DC892

		// 使用签名生成访问URL
		stringBuilder = new StringBuilder();
		stringBuilder.append("appkey=").append(appkey).append("&sign=")
				.append(sign);
		for (Entry<String, String> entry : paramMap.entrySet()) {
			stringBuilder.append('&').append(entry.getKey()).append('=')
					.append(entry.getValue());
		}

		String requestUrl = apiUrlTmp + "?" + stringBuilder.toString();

		System.out.println(requestUrl);

		HttpConnectionManager httpClientManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams params = httpClientManager.getParams();
		params.setStaleCheckingEnabled(true);
		params.setMaxTotalConnections(320);
		params.setDefaultMaxConnectionsPerHost(160);
		params.setConnectionTimeout(2000);
		params.setSoTimeout(2000);
		HttpClient httpClient = new HttpClient(httpClientManager);

		try {
			URI uri = new URI(requestUrl, false);
			GetMethod get = new GetMethod(uri.getEscapedURI());
			int statusCode = httpClient.executeMethod(get);
			if (statusCode == 200) {
				String response = get.getResponseBodyAsString();
				System.out.println(response);
				logger.info(response);
				return response;
			} else {
				System.out.println("query data error~");
				logger.error("query data error~");
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] a) {
//		sendMessage();
	}
}
