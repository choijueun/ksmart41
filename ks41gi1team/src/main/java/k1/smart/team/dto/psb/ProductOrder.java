package k1.smart.team.dto.psb;

public class ProductOrder {
	private String productOrderCode;
	private String mainBusinessCode;
	private String contractCode;
	private String productPriceCode;
	private int count;
	private String orderDate;
	private String productDate;
	public String getProductOrderCode() {
		return productOrderCode;
	}
	public void setProductOrderCode(String productOrderCode) {
		this.productOrderCode = productOrderCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getProductPriceCode() {
		return productPriceCode;
	}
	public void setProductPriceCode(String productPriceCode) {
		this.productPriceCode = productPriceCode;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductOrder [productOrderCode=");
		builder.append(productOrderCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", contractCode=");
		builder.append(contractCode);
		builder.append(", productPriceCode=");
		builder.append(productPriceCode);
		builder.append(", count=");
		builder.append(count);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", productDate=");
		builder.append(productDate);
		builder.append("]");
		return builder.toString();
	}

}
