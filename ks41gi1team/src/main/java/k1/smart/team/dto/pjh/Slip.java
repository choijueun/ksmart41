package k1.smart.team.dto.pjh;


public class Slip {
	private String purchaseSlipCode; //비용전표코드
	private String salesSlipCode; //매출전표코드
	private String mainBusinessCode; //삭제할지말지?
	private String totalAccountCode; //통합 회계 관리코드
	private String purchaseTsCode; //비용 거래명세서 코드
	private String salesTsCode; //비용 거래명세서 코드
	private int payCost;
	private int saleCost;
	private String briefs;
	private String regId;
	private String comment;
	private String regDate;
	private String updateDate;
	
	public int getSaleCost() {
		return saleCost;
	}
	public void setSaleCost(int saleCost) {
		this.saleCost = saleCost;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPurchaseSlipCode() {
		return purchaseSlipCode;
	}
	public void setPurchaseSlipCode(String purchaseSlipCode) {
		this.purchaseSlipCode = purchaseSlipCode;
	}
	public String getSalesSlipCode() {
		return salesSlipCode;
	}
	public void setSalesSlipCode(String salesSlipCode) {
		this.salesSlipCode = salesSlipCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getTotalAccountCode() {
		return totalAccountCode;
	}
	public void setTotalAccountCode(String totalAccountCode) {
		this.totalAccountCode = totalAccountCode;
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
	public int getPayCost() {
		return payCost;
	}
	public void setPayCost(int payCost) {
		this.payCost = payCost;
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
		builder.append("Slip [purchaseSlipCode=");
		builder.append(purchaseSlipCode);
		builder.append(", salesSlipCode=");
		builder.append(salesSlipCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", totalAccountCode=");
		builder.append(totalAccountCode);
		builder.append(", purchaseTsCode=");
		builder.append(purchaseTsCode);
		builder.append(", salesTsCode=");
		builder.append(salesTsCode);
		builder.append(", payCost=");
		builder.append(payCost);
		builder.append(", saleCost=");
		builder.append(saleCost);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", regId=");
		builder.append(regId);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
	

	

