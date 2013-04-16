/**
 * 
 */
package model.request;

import model.response.CatUrlGetResponse;

/**
 * @author Administrator
 * @param <T>
 *
 */
public class CatUrlGetRequest<T> extends TaobaoRequestImpl<CatUrlGetResponse> {

	private String q;
	private Number cid;
	private String nick;
	private String outer_code;
	private Number pid;
	
	public CatUrlGetRequest() {
		this.methodName = "taobao.taobaoke.caturl.get";
	}
	
	@Override
	public Class<CatUrlGetResponse> getResponseClass() {
		return CatUrlGetResponse.class;
	}

	@Override
	protected void filledTextParams() {
		maps.put("q", q);
		maps.put("cid", String.valueOf(cid));
		maps.put("nick", nick);
		maps.put("qouter_code", outer_code);
		maps.put("pid", String.valueOf(pid));
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public Number getCid() {
		return cid;
	}

	public void setCid(Number cid) {
		this.cid = cid;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getOuter_code() {
		return outer_code;
	}

	public void setOuter_code(String outer_code) {
		this.outer_code = outer_code;
	}

	public Number getPid() {
		return pid;
	}

	public void setPid(Number pid) {
		this.pid = pid;
	}
}
