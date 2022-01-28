package k1.smart.team.dto.psb;

public class MaterialOrder {
	private String materialOrderCode;
	private String materialOrderOngoingCode;
	private String itemCode;
	private String itemCount;
	private String itemPrice;
	private String realReceiveDate;
	private String reserveStatus;
	private String comment;
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
	private String managerName;
	public String getMaterialOrderCode() {
		return materialOrderCode;
	}
	public void setMaterialOrderCode(String materialOrderCode) {
		this.materialOrderCode = materialOrderCode;
	}
	public String getMaterialOrderOngoingCode() {
		return materialOrderOngoingCode;
	}
	public void setMaterialOrderOngoingCode(String materialOrderOngoingCode) {
		this.materialOrderOngoingCode = materialOrderOngoingCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemCount() {
		return itemCount;
	}
	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getRealReceiveDate() {
		return realReceiveDate;
	}
	public void setRealReceiveDate(String realReceiveDate) {
		this.realReceiveDate = realReceiveDate;
	}
	public String getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MaterialOrder [materialOrderCode=");
		builder.append(materialOrderCode);
		builder.append(", materialOrderOngoingCode=");
		builder.append(materialOrderOngoingCode);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", itemCount=");
		builder.append(itemCount);
		builder.append(", itemPrice=");
		builder.append(itemPrice);
		builder.append(", realReceiveDate=");
		builder.append(realReceiveDate);
		builder.append(", reserveStatus=");
		builder.append(reserveStatus);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", contractCode=");
		builder.append(contractCode);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", predictDate=");
		builder.append(predictDate);
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
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", clientBusinessName=");
		builder.append(clientBusinessName);
		builder.append(", managerName=");
		builder.append(managerName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
