package servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parser.ProtocolParser;
import util.CloseUtil;
import control.ServletGlobal;
import dispatch.LogicRouter;

public class Handler extends HttpServlet {

	private static final long serialVersionUID = -2604279784853738462L;
//	private static final Logger logger = Logger.getLogger(Handler.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO 为了调试方便~暂时这么写~应该只用post
		this.doPost(request, response);
		//TODO this is user.get protocol
//		UserGetRequest<UserGetResponse> req = new UserGetRequest<UserGetResponse>();// 实例化具体API对应的Request类
//		req.setFields("nick,sex,buyer_credit,seller_credit ,created,last_visit");
//		req.setNick("dancintherain");
//		UserGetResponse res = (UserGetResponse) TaobaoMessageUtil.getResponse(req);

		//TODO this is caturl.get protocol
//		CatUrlGetRequest<CatUrlGetResponse> req = new CatUrlGetRequest<CatUrlGetResponse>();
//		req.setCid(1255225);
//		req.setNick("dancintherain");
//		CatUrlGetResponse res = (CatUrlGetResponse) TaobaoMessageUtil.getResponse(req);
		
		//TODO item's catagory get
//		ItemscatsGetRequest<ItemcatsGetResponse> req = new ItemscatsGetRequest<ItemcatsGetResponse>();
//		req.setFields("cid,parent_cid,name,is_parent");
//		req.setParent_cid(0);
//		ItemcatsGetResponse res = (ItemcatsGetResponse) TaobaoMessageUtil.getResponse(req);
//		
//		if (res != null) {
//			System.out.println("result:" + res.getBody());
//		} else {
//			System.out.println("taobao response is null~");
//		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置全局变量
		ServletGlobal.init(request);
		
		//解析参数
		ProtocolParser parser = new ProtocolParser(request);
		parser.parser();
		
		//
		byte[] ret = LogicRouter.execute(parser);
		
		output(200, ret, response);
	}

	private void output(int status, byte[] retValue, HttpServletResponse response) throws IOException {
		
		response.setStatus(status);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=" + "UTF-8");
		
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(retValue);
			os.write("\0".getBytes("UTF-8"));
			os.flush();
		} finally {
			CloseUtil.close(os);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		this.doPost(req, res);
	}
}
