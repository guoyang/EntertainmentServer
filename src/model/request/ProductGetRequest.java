/**
 * 
 */
package model.request;

import model.response.ProductGetResponse;

/**
 * @author Administrator
 *
 */
public class ProductGetRequest<T> extends TaobaoRequestImpl<ProductGetResponse> {

	private String fields;
	private String nick;
	private Integer pageNo;
	private Integer pageSize;
	
	public ProductGetRequest() {
		this.methodName = "taobao.products.get";
	}
	@Override
	public Class<ProductGetResponse> getResponseClass() {
		return ProductGetResponse.class;
	}

	@Override
	protected void filledTextParams() {
		maps.put("fields", fields);
		maps.put("nick", nick);
		maps.put("page_no", String.valueOf(pageNo));
		maps.put("page_size", String.valueOf(pageSize));
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

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
