package k1.smart.team.dto;

import java.security.Timestamp;

public class Contract {
	private String contractCode;
	private String mainBusinessCode;
	private String clientCode;
	private String clientManagerId;
	private String contractSection;
	private String contractType;
	private Timestamp startDate;
	private Timestamp endDate;
	private String managerId;
	private String regId;
	private String approvalId;
	private Timestamp contractDate;
	private String contractStatus;
	private String briefs;
	private Timestamp regDate;
	private Timestamp uodateDate;
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
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
	public String getClientManagerId() {
		return clientManagerId;
	}
	public void setClientManagerId(String clientManagerId) {
		this.clientManagerId = clientManagerId;
	}
	public String getContractSection() {
		return contractSection;
	}
	public void setContractSection(String contractSection) {
		this.contractSection = contractSection;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
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
	public String getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}
	public Timestamp getContractDate() {
		return contractDate;
	}
	public void setContractDate(Timestamp contractDate) {
		this.contractDate = contractDate;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getBriefs() {
		return briefs;
	}
	public void setBriefs(String briefs) {
		this.briefs = briefs;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getUodateDate() {
		return uodateDate;
	}
	public void setUodateDate(Timestamp uodateDate) {
		this.uodateDate = uodateDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contract [contractCode=");
		builder.append(contractCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", clientManagerId=");
		builder.append(clientManagerId);
		builder.append(", contractSection=");
		builder.append(contractSection);
		builder.append(", contractType=");
		builder.append(contractType);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", managerId=");
		builder.append(managerId);
		builder.append(", regId=");
		builder.append(regId);
		builder.append(", approvalId=");
		builder.append(approvalId);
		builder.append(", contractDate=");
		builder.append(contractDate);
		builder.append(", contractStatus=");
		builder.append(contractStatus);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", uodateDate=");
		builder.append(uodateDate);
		builder.append("]");
		return builder.toString();
	}
	
}
