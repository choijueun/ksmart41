package k1.smart.team.dto.psb;

public class MaterialOrder {
	private String materialOrderCode;
	private String mainBusinessCode;
	private String contractCode;
	private String clientCode;
	private int totalCount;
	private int totalPrice;
	private String orderDate;
	private String predictDate;
	private String status;
	private String briefs;
	private String managerId;
	private String regDate;
	private String updateDate;
	private String itemName;
	private String businessName;
	private String userName;
	private String clientBusinessName;
	public String getMaterialOrderCode() {
		return materialOrderCode;
	}
	public void setMaterialOrderCode(String materialOrderCode) {
		this.materialOrderCode = materialOrderCode;
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPredictDate() {
		return predictDate;
	}
	public void setPredictDate(String predictDate) {
		this.predictDate = predictDate;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getClientBusinessName() {
		return clientBusinessName;
	}
	public void setClientBusinessName(String clientBusinessName) {
		this.clientBusinessName = clientBusinessName;
	}
	@Override
	public String toString() {
		return "MaterialOrder [materialOrderCode=" + materialOrderCode + ", mainBusinessCode=" + mainBusinessCode
				+ ", contractCode=" + contractCode + ", clientCode=" + clientCode + ", totalCount=" + totalCount
				+ ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", predictDate=" + predictDate
				+ ", status=" + status + ", briefs=" + briefs + ", managerId=" + managerId + ", regDate=" + regDate
				+ ", updateDate=" + updateDate + ", itemName=" + itemName + ", businessName=" + businessName
				+ ", userName=" + userName + ", clientBusinessName=" + clientBusinessName + "]";
	}
	
	
	
}
