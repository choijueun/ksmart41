package k1.smart.team.dto.psb;

public class ProductOrder {
	private String productOrderCode;
	private String mainBusinessCode;
	private String contractCode;
	private String clientCode;
	private String productPriceCode;
	private int totalCount;
	private int totalPrice;
	private String productOrderDate;
	private String productDate;
	private String predictProductDate;
	private String status;
	private String briefs;
	private String managerId;
	private String regDate;
	private String updateDate;
	private String itemName;
	private String businessName;
	private String clientBusinessName;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
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
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getClientBusinessName() {
		return clientBusinessName;
	}
	public void setClientBusinessName(String clientBusinessName) {
		this.clientBusinessName = clientBusinessName;
	}
	@Override
	public String toString() {
		return "ProductOrder [productOrderCode=" + productOrderCode + ", mainBusinessCode=" + mainBusinessCode
				+ ", contractCode=" + contractCode + ", clientCode=" + clientCode + ", productPriceCode="
				+ productPriceCode + ", totalCount=" + totalCount + ", totalPrice="
				+ totalPrice + ", productOrderDate=" + productOrderDate + ", productDate=" + productDate
				+ ", predictProductDate=" + predictProductDate + ", status=" + status + ", briefs=" + briefs
				+ ", managerId=" + managerId + ", regDate=" + regDate + ", updateDate=" + updateDate + ", itemName="
				+ itemName + ", businessName=" + businessName + ", clientBusinessName=" + clientBusinessName + "]";
	}


	


}
