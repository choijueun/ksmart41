package k1.smart.team.dto.pjh;

public class HistoryPayment {
	private String payHistoryCode;
	private String mainBusinessCode;
	private String payPlanCode;
	private int payCost;
	private int totalPlanCost;
	private String issueDate;
	private String payType;
	private String payMethod;
	private String payDate;
	private String briefs;
	private String regId;
	private String regDate;
	private String updateDate;
	public String getPayHistoryCode() {
		return payHistoryCode;
	}
	public void setPayHistoryCode(String payHistoryCode) {
		this.payHistoryCode = payHistoryCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getPayPlanCode() {
		return payPlanCode;
	}
	public void setPayPlanCode(String payPlanCode) {
		this.payPlanCode = payPlanCode;
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
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HistoryPayment [payHistoryCode=");
		builder.append(payHistoryCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", payPlanCode=");
		builder.append(payPlanCode);
		builder.append(", payCost=");
		builder.append(payCost);
		builder.append(", totalPlanCost=");
		builder.append(totalPlanCost);
		builder.append(", issueDate=");
		builder.append(issueDate);
		builder.append(", payType=");
		builder.append(payType);
		builder.append(", payMethod=");
		builder.append(payMethod);
		builder.append(", payDate=");
		builder.append(payDate);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", regId=");
		builder.append(regId);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
