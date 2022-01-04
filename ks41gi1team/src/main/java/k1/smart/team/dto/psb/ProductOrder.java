package k1.smart.team.dto.psb;

public class ProductOrder {
	private String productOrderCode;
	private String mainBusinessCode;
	private String contractCode;
	private String clientCode;
	private String productPriceCode;
	private int totalProductCount;
	private int totalProductPrice;
	private String productOrderDate;
	private String productDate;
	private String predictProductDate;
	private String status;
	private String briefs;
	private String managerId;
	private String regDate;
	private String updateDate;
	private String itemName;
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
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getProductPriceCode() {
		return productPriceCode;
	}
	public void setProductPriceCode(String productPriceCode) {
		this.productPriceCode = productPriceCode;
	}
	public int getTotalProductCount() {
		return totalProductCount;
	}
	public void setTotalProductCount(int totalProductCount) {
		this.totalProductCount = totalProductCount;
	}
	public int getTotalProductPrice() {
		return totalProductPrice;
	}
	public void setTotalProductPrice(int totalProductPrice) {
		this.totalProductPrice = totalProductPrice;
	}
	public String getProductOrderDate() {
		return productOrderDate;
	}
	public void setProductOrderDate(String productOrderDate) {
		this.productOrderDate = productOrderDate;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public String getPredictProductDate() {
		return predictProductDate;
	}
	public void setPredictProductDate(String predictProductDate) {
		this.predictProductDate = predictProductDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBriefs() {
		return briefs;
	}
	public void setBriefs(String briefs) {
		this.briefs = briefs;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", productPriceCode=");
		builder.append(productPriceCode);
		builder.append(", totalProductCount=");
		builder.append(totalProductCount);
		builder.append(", totalProductPrice=");
		builder.append(totalProductPrice);
		builder.append(", productOrderDate=");
		builder.append(productOrderDate);
		builder.append(", productDate=");
		builder.append(productDate);
		builder.append(", predictProductDate=");
		builder.append(predictProductDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", managerId=");
		builder.append(managerId);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append("]");
		return builder.toString();
	}
	


}
