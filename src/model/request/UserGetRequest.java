package model.request;

import model.response.UserGetResponse;

import com.taobao.api.TaobaoResponse;

public class UserGetRequest<T extends TaobaoResponse> extends TaobaoRequestImpl<UserGetResponse> {

	private String fields;
	private String nick;
//	protected String methodName = "taobao.user.get";
	
	public UserGetRequest() {
		this.methodName = "taobao.user.get";
	}
	@Override
	public Class<UserGetResponse> getResponseClass() {
		return UserGetResponse.class;
	}
	
	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	protected void filledTextParams() {
		maps.put("nick", nick);
		maps.put("fields", fields);
	}
}
