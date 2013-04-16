/**
 * 
 */
package util;

import org.apache.log4j.Logger;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;

/**
 * @author Administrator
 *
 */
public class TaobaoMessageUtil {
	
	private static final Logger logger = Logger.getLogger(TaobaoMessageUtil.class);
//	protected static String url = "http://gw.api.tbsandbox.com/router/rest";//沙箱环境调用地址
	protected static String url = "http://gw.api.taobao.com/router/rest";//正式环境调用地址
    //正式环境需要设置为:http://gw.api.taobao.com/router/rest
    protected static String appkey = "21443895";
    protected static String appSecret = "66d174539d81fc24d3e5a1c39c2a3b77";
    public static TaobaoResponse getResponse(TaobaoRequest<? extends TaobaoResponse> req) {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, appSecret);//实例化TopClient类
//        UserGetRequest req = new UserGetRequest();//实例化具体API对应的Request类
//        req.setFields("nick,sex,buyer_credit,seller_credit ,created,last_visit");
//        req.setNick("dancintherain");
//        UserGetResponse response;
        try {
//        	UserGetResponse res = 
            return client.execute(req);  //执行API请求并打印结果
//            System.out.println("result:"+response.getBody());
//            System.out.println("nick:"+response.getUser().getNick());
        } catch (ApiException e) {
        	// deal error
        	logger.error("get taobao message error:", e);
        	return null;
        }
    }
}
