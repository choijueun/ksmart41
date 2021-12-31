package k1.smart.team.dto.pjh;

public class PlanPayment {
	private String payPlanCode;
	private String mainBusinessCode;
	private String clientCode;
	private String totalAccountCode;
	private String contractCode;
	private String totalPlanCost;
	private String briefs;
	private String managerId;
	private String regId;
	private String regDate;
	private String purchaseTsCode; //명세서코드
	private String salesTsCode;
	private String itemCode;
	private String madeCompany;
	private int materialCost;
	private int tax;
	private int productPrice;
	private int vat;
	private int count;
	private int sum;
	private String isEnd;
	private String endDate;
	private String comment;
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
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
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
	public int getMaterialCost() {
		return materialCost;
	}
	public void setMaterialCost(int materialCost) {
		this.materialCost = materialCost;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
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
		builder.append("PlanPayment [payPlanCode=");
		builder.append(payPlanCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", totalAccountCode=");
		builder.append(totalAccountCode);
		builder.append(", contractCode=");
		builder.append(contractCode);
		builder.append(", totalPlanCost=");
		builder.append(totalPlanCost);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", managerId=");
		builder.append(managerId);
		builder.append(", regId=");
		builder.append(regId);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", purchaseTsCode=");
		builder.append(purchaseTsCode);
		builder.append(", salesTsCode=");
		builder.append(salesTsCode);
		builder.append(", itemCode=");
		builder.append(itemCode);
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
