package dispatch;
import java.util.HashMap;
import java.util.Map;

import logic.LogicBase;
import logic.metaData.GetCatWithBusinessLogic;
import logic.metaData.GetCityWithBusinessLogic;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class LogicFactory {

	private static Map<String, LogicBase> map = new HashMap<String, LogicBase>();
	static {
		map.put("getCatWithBusiness", new GetCatWithBusinessLogic());
		map.put("getCitys", new GetCityWithBusinessLogic());
//		map.put("categoryRecommendItem", new CategoryRecommendItemLogic());
//		map.put("productGet", new ProductGetLogic());
	}
	
	public static LogicBase getLogicBase(String name) {
		return map.get(name);
	}
}
