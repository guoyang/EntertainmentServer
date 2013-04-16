package model.request;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taobao.api.ApiRuleException;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;

public abstract class TaobaoRequestImpl<T extends TaobaoResponse> implements TaobaoRequest<T> {

	protected static final Log logger = LogFactory.getLog(TaobaoRequestImpl.class);
	protected Map<String, String> maps = new HashMap<String, String>();
	protected String methodName;
	private Long timestamp;
	
	@Override
	public String getApiMethodName() {
		if(methodName == null || "".equals(methodName)) {
			logger.error("methodName not reset");
		}
		return methodName;
	}
	
	

	@Override
	public Long getTimestamp() {
		return timestamp;
	}

	@Override
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public Map<String, String> getTextParams() {
		filledTextParams();
		return maps;
	}
	
	protected abstract void filledTextParams();
	
//	@Override
//	public Class<T> getResponseClass() {
//		return TaobaoResponse.class;
//	}

	@Override
	public void check() throws ApiRuleException {
		//TODO nothing to do now......
		
	}

	@Override
	public Map<String, String> getHeaderMap() {
		//TODO don't know how to use......
		return maps;
	}

}
