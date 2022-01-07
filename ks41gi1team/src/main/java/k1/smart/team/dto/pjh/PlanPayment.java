package k1.smart.team.dto.pjh;

public class PlanPayment {
	private String managerId;
	private String managerName;
	private String regId;
	private String regName;
	private String businessName;
	private String payPlanCode;
	private String mainBusinessCode;
	private String clientCode;
	private String totalAccountCode;
	private String contractCode;
	private String type;
	private String totalPlanCost;
	private String briefs;
	private String regDate;
	private String updateDate;
	private String payPlanDetailCode;
	private String purchaseTsCode;
	private String salesTsCode;
	private String itemCode;
	private String itemName;
	private String madeCompany;
	private String materialCost;
	private String tax;
	private String productPrice;
	private String vat;
	private String count;
	private String sum;
	private String isEnd;
	private String endDate;
	private String comment;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getPayPlanCode() {
		return payPlanCode;
	}
	public void setPayPlanCode(String payPlanCode) {
		this.payPlanCode = payPlanCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getTotalAccountCode() {
		return totalAccountCode;
	}
	public void setTotalAccountCode(String totalAccountCode) {
		this.totalAccountCode = totalAccountCode;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTotalPlanCost() {
		return totalPlanCost;
	}
	public void setTotalPlanCost(String totalPlanCost) {
		this.totalPlanCost = totalPlanCost;
	}
	public String getBriefs() {
		return briefs;
	}
	public void setBriefs(String briefs) {
		this.briefs = briefs;
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
	public String getPayPlanDetailCode() {
		return payPlanDetailCode;
	}
	public void setPayPlanDetailCode(String payPlanDetailCode) {
		this.payPlanDetailCode = payPlanDetailCode;
	}
	public String getPurchaseTsCode() {
		return purchaseTsCode;
	}
	public void setPurchaseTsCode(String purchaseTsCode) {
		this.purchaseTsCode = purchaseTsCode;
	}
	public String getSalesTsCode() {
		return salesTsCode;
	}
	public void setSalesTsCode(String salesTsCode) {
		this.salesTsCode = salesTsCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getMadeCompany() {
		return madeCompany;
	}
	public void setMadeCompany(String madeCompany) {
		this.madeCompany = madeCompany;
	}
	public String getMaterialCost() {
		return materialCost;
	}
	public void setMaterialCost(String materialCost) {
		this.materialCost = materialCost;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(String isEnd) {
		this.isEnd = isEnd;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlanPayment [managerId=");
		builder.append(managerId);
		builder.append(", managerName=");
		builder.append(managerName);
		builder.append(", regId=");
		builder.append(regId);
		builder.append(", regName=");
		builder.append(regName);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", payPlanCode=");
		builder.append(payPlanCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", totalAccountCode=");
		builder.append(totalAccountCode);
		builder.append(", contractCode=");
		builder.append(contractCode);
		builder.append(", type=");
		builder.append(type);
		builder.append(", totalPlanCost=");
		builder.append(totalPlanCost);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", payPlanDetailCode=");
		builder.append(payPlanDetailCode);
		builder.append(", purchaseTsCode=");
		builder.append(purchaseTsCode);
		builder.append(", salesTsCode=");
		builder.append(salesTsCode);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", madeCompany=");
		builder.append(madeCompany);
		builder.append(", materialCost=");
		builder.append(materialCost);
		builder.append(", tax=");
		builder.append(tax);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", vat=");
		builder.append(vat);
		builder.append(", count=");
		builder.append(count);
		builder.append(", sum=");
		builder.append(sum);
		builder.append(", isEnd=");
		builder.append(isEnd);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", comment=");
		builder.append(comment);
		builder.append("]");
		return builder.toString();
	}
	
	
}
