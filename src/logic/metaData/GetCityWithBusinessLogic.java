/**
 * 
 */
package logic.metaData;

import parser.ProtocolParser;
import service.MetaDataService;
import logic.AuthenLogic;

/**
 * @author Administrator
 *
 */
public class GetCityWithBusinessLogic extends AuthenLogic {

	/* (non-Javadoc)
	 * @see logic.LogicBase#logic(parser.ProtocolParser)
	 */
	@Override
	public Object logic(ProtocolParser parser) {
		String response = MetaDataService.getCitysWithBusiness();
		
		if(response != null) {
			System.out.println(response);
		}
		return response;
	}

}
