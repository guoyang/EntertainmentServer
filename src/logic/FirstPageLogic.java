/**
 * 
 */
package logic;

import parser.ProtocolParser;
import util.TextContent;

/**
 * @author Administrator
 *
 */
public class FirstPageLogic extends AuthenLogic {

	public String logic(ProtocolParser parser) {
		
		return TextContent.MAIN_MENU;
	}

}
