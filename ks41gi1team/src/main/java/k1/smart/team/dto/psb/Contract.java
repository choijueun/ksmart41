package k1.smart.team.dto.psb;

import javax.validation.constraints.NotBlank;

public class Contract {
	
	private String contractCode;
	private int contractNum;
	private String mainBusinessCode;
	private String mbBusinessName;
	private String clientCode;
	private String clientBusinessName;
	private String clientManagerId;
	private String clientManagerName;
	private String contractSection;
	private String contractType;
	@NotBlank(message="계약시작일을 입력해주세요.")
	private String startDate;
	@NotBlank(message="계약종료일을 입력해주세요.")
	private String endDate;
	private String managerId;
	private String regId;
	private String approvalId;
	private String contractDate;
	private String contractStatus;
	private String briefs;
	private String regDate;
	@NotBlank(message="수정날짜를 입력해주세요.")
	private String updateDate;
	private String businessRepresentative;
	private String userName;
	private String managerName;
	private String approvalName;
	private String userId;
	private String status;
	private String contractCodeForMaterialOrderCode;
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public int getContractNum() {
		return contractNum;
	}
	public void setContractNum(int contractNum) {
		this.contractNum = contractNum;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getMbBusinessName() {
		return mbBusinessName;
	}
	public void setMbBusinessName(String mbBusinessName) {
		this.mbBusinessName = mbBusinessName;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getClientBusinessName() {
		return clientBusinessName;
	}
	public void setClientBusinessName(String clientBusinessName) {
		this.clientBusinessName = clientBusinessName;
	}
	public String getClientManagerId() {
		return clientManagerId;
	}
	public void setClientManagerId(String clientManagerId) {
		this.clientManagerId = clientManagerId;
	}
	public String getClientManagerName() {
		return clientManagerName;
	}
	public void setClientManagerName(String clientManagerName) {
		this.clientManagerName = clientManagerName;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
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
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
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
	public String getBusinessRepresentative() {
		return businessRepresentative;
	}
	public void setBusinessRepresentative(String businessRepresentative) {
		this.businessRepresentative = businessRepresentative;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getApprovalName() {
		return approvalName;
	}
	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContractCodeForMaterialOrderCode() {
		return contractCodeForMaterialOrderCode;
	}
	public void setContractCodeForMaterialOrderCode(String contractCodeForMaterialOrderCode) {
		this.contractCodeForMaterialOrderCode = contractCodeForMaterialOrderCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contract [contractCode=");
		builder.append(contractCode);
		builder.append(", contractNum=");
		builder.append(contractNum);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", mbBusinessName=");
		builder.append(mbBusinessName);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", clientBusinessName=");
		builder.append(clientBusinessName);
		builder.append(", clientManagerId=");
		builder.append(clientManagerId);
		builder.append(", clientManagerName=");
		builder.append(clientManagerName);
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
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", businessRepresentative=");
		builder.append(businessRepresentative);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", managerName=");
		builder.append(managerName);
		builder.append(", approvalName=");
		builder.append(approvalName);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", status=");
		builder.append(status);
		builder.append(", contractCodeForMaterialOrderCode=");
		builder.append(contractCodeForMaterialOrderCode);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
