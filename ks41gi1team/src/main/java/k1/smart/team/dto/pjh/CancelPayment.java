package k1.smart.team.dto.pjh;

public class CancelPayment {
	private String payCancelCode; //결제취소코드
	private String mainBusinessCode;
	private String payHistoryCode; //결제코드
	private int cancelCost; //취소금액
	private String issueDate; //발행일자
	private String approvalDate; //승인일자
	private String regId;
	private String regDate;
	private String updateDate;
	public String getPayCancelCode() {
		return payCancelCode;
	}
	public void setPayCancelCode(String payCancelCode) {
		this.payCancelCode = payCancelCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getPayHistoryCode() {
		return payHistoryCode;
	}
	public void setPayHistoryCode(String payHistoryCode) {
		this.payHistoryCode = payHistoryCode;
	}
	public int getCancelCost() {
		return cancelCost;
	}
	public void setCancelCost(int cancelCost) {
		this.cancelCost = cancelCost;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
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
		builder.append("CancelPayment [payCancelCode=");
		builder.append(payCancelCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", payHistoryCode=");
		builder.append(payHistoryCode);
		builder.append(", cancelCost=");
		builder.append(cancelCost);
		builder.append(", issueDate=");
		builder.append(issueDate);
		builder.append(", approvalDate=");
		builder.append(approvalDate);
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
