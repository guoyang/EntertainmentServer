/**
 * 
 */
package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.nx.commons.lang.NxConsts;
import com.nx.commons.lang.util.PathUtil;

/**
 * @author Administrator
 *
 */
public class ServerInitServlet extends HttpServlet {

//	private static Logger logger;
	private static final long serialVersionUID = -1679080502638401412L;

	@Override
	public void init() throws ServletException {
		String appRootPath = this.getServletContext().getRealPath(NxConsts.DFT_STRING_VAL);
		PathUtil.setAppRootPath(appRootPath);
		
//		String appRootPath = this.getServletConfig().getServletContext().getRealPath("/WEB-INF/");
		//初始化log4j
//		PropertyConfigurator.configure(new File(appRootPath,
//				"conf/logger.properties").getAbsolutePath());
//		logger = Logger.getLogger(this.getClass());
//		logger.info("log init success");
	}
}
