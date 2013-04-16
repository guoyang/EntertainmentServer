/**
 * 
 */
package logic;

import org.apache.log4j.Logger;

/**
 * @author Administrator
 *
 */
public abstract class AuthenLogic implements LogicBase {

	protected static final Logger logger = Logger.getLogger(AuthenLogic.class);
	public int checkPara() {
		//TODO player check
		logger.info("checkPara success~");
		return 0;
	}
	/* (non-Javadoc)
	 * @see logic.LogicBase#logic(java.util.Map)
	 */
//	public abstract int logic(Map<String, String> paraMap) {
//		//TODO need to do...
//		return 0;
//	}

}
