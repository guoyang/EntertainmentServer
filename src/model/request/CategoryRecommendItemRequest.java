/**
 * 
 */
package model.request;

import model.response.CategoryRecommendItemResponse;

/**
 * @author Administrator
 *
 */
public class CategoryRecommendItemRequest<T> extends TaobaoRequestImpl<CategoryRecommendItemResponse> {

	private Integer categoryId;
	private Integer recommendType;
	private Integer count;
	private String ext;
	
	public CategoryRecommendItemRequest() {
		this.methodName = "taobao.categoryrecommend.items.get";
	}
	
	@Override
	public Class<CategoryRecommendItemResponse> getResponseClass() {
		return CategoryRecommendItemResponse.class;
	}

	@Override
	protected void filledTextParams() {
		maps.put("category_id", String.valueOf(categoryId));
		maps.put("recommend_type", String.valueOf(recommendType));
		maps.put("count", String.valueOf(count));
		maps.put("ext", ext);
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getRecommendType() {
		return recommendType;
	}

	public void setRecommendType(Integer recommendType) {
		this.recommendType = recommendType;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
}
