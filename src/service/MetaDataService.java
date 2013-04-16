/**
 * 
 */
package service;

import java.util.Map;

import util.CollectionUtil;
import util.DianpingMessageUtil;

/**
 * @author Administrator
 *
 */
public class MetaDataService {

	public static String getCategoryWithBusiness() {
		Map<String, String> paramMap = CollectionUtil.newHashMap();
		String response = DianpingMessageUtil.sendMessage(paramMap, "v1/metadata/get_categories_with_businesses");
		
		if(response == null || "".equals(response)) {
			return null;
		}
		
		return response;
	}
	
	public static String getCitysWithBusiness() {
		Map<String, String> paramMap = CollectionUtil.newHashMap();
		String response = DianpingMessageUtil.sendMessage(paramMap, "v1/metadata/get_cities_with_businesses");
		
		if(response == null || "".equals(response)) {
			return null;
		}
		
		return response;
	}
	
//	public static void main(String[] args) {
//		System.out.println(getCategoryWithBusiness());;
//	}
}
