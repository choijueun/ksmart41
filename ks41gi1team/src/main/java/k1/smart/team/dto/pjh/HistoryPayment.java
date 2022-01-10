package k1.smart.team.dto.pjh;

public class HistoryPayment {
	private String payHistoryCode;
	private String payPlanCode;
	private String businessName;
	private int payCost;
	private int totalPlanCost;
	private String issueDate;
	private String type;
	private String payType;
	private String payMethod;
	private String payDate;
	private String briefs;
	private String regDate;
	private String updateDate;
	private String payStatus;
	private String endDate;
	private String regName;
	private String managerName;
	private String payHistoryDetailCode;
	private String itemName;
	private int materialCost;
	private int tax;
	private int productPrice;
	private int vat;
	private int count;
	private int sum;
	private String itemCode;
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getPayHistoryCode() {
		return payHistoryCode;
	}
	public void setPayHistoryCode(String payHistoryCode) {
		this.payHistoryCode = payHistoryCode;
	}
	public String getPayPlanCode() {
		return payPlanCode;
	}
	public void setPayPlanCode(String payPlanCode) {
		this.payPlanCode = payPlanCode;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public int getPayCost() {
		return payCost;
	}
	public void setPayCost(int payCost) {
		this.payCost = payCost;
	}
	public int getTotalPlanCost() {
		return totalPlanCost;
	}
	public void setTotalPlanCost(int totalPlanCost) {
		this.totalPlanCost = totalPlanCost;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
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
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPayHistoryDetailCode() {
		return payHistoryDetailCode;
	}
	public void setPayHistoryDetailCode(String payHistoryDetailCode) {
		this.payHistoryDetailCode = payHistoryDetailCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HistoryPayment [payHistoryCode=");
		builder.append(payHistoryCode);
		builder.append(", payPlanCode=");
		builder.append(payPlanCode);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", payCost=");
		builder.append(payCost);
		builder.append(", totalPlanCost=");
		builder.append(totalPlanCost);
		builder.append(", issueDate=");
		builder.append(issueDate);
		builder.append(", type=");
		builder.append(type);
		builder.append(", payType=");
		builder.append(payType);
		builder.append(", payMethod=");
		builder.append(payMethod);
		builder.append(", payDate=");
		builder.append(payDate);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", payStatus=");
		builder.append(payStatus);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", regName=");
		builder.append(regName);
		builder.append(", managerName=");
		builder.append(managerName);
		builder.append(", payHistoryDetailCode=");
		builder.append(payHistoryDetailCode);
		builder.append(", itemName=");
		builder.append(itemName);
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
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
