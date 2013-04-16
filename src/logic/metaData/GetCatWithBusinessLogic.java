/**
 * 
 */
package logic.metaData;

import logic.LogicBase;
import parser.ProtocolParser;
import service.MetaDataService;

/**
 * @author Administrator
 *
 */
public class GetCatWithBusinessLogic implements LogicBase {

	/* (non-Javadoc)
	 * @see logic.LogicBase#logic(java.util.Map)
	 */
	@Override
	public Object logic(ProtocolParser parser) {
		String response = MetaDataService.getCategoryWithBusiness();
		
		if(response != null) {
			System.out.println(response);
		}
		return response;
	}

}
