/**
 * 
 */
package model.request;

import com.taobao.api.response.ItemcatsGetResponse;

/**
 * @author Administrator
 *
 */
public class ItemscatsGetRequest<T> extends TaobaoRequestImpl<ItemcatsGetResponse> {

	private String fields;
	private Number parent_cid;
	private Number[] cids;
	
	public ItemscatsGetRequest() {
		this.methodName = "taobao.itemcats.get";
	}
	
	@Override
	public Class<ItemcatsGetResponse> getResponseClass() {
		return ItemcatsGetResponse.class;
	}

	@Override
	protected void filledTextParams() {
		StringBuilder sb = new StringBuilder();
		if(cids != null) {
			for(Number cid : cids) {
				sb.append(cid).append(",");
			}
		}
		maps.put("fields", fields);
		maps.put("parent_cid", String.valueOf(parent_cid));
		maps.put("cids", sb.toString());
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public Number getParent_cid() {
		return parent_cid;
	}

	public void setParent_cid(Number parent_cid) {
		this.parent_cid = parent_cid;
	}

	public Number[] getCids() {
		return cids;
	}

	public void setCids(Number[] cids) {
		this.cids = cids;
	}
}
