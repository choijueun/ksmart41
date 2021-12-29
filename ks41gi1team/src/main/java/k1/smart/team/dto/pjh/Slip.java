package k1.smart.team.dto.pjh;

import java.sql.Timestamp;

public class Slip {
	private String purchaseSlipCode; //비용전표코드
	private String salesSlipCode; //매출전표코드
	private String mainBusinessCode; 
	private String totalAccountCode; //통합 회계 관리코드
	private String purchaseTsCode; //비용 거래명세서 코드
	private String salesTsCode; //비용 거래명세서 코드
	private String payCost;
	private String briefs;
	private String regId;
	private Timestamp regDate;
	private Timestamp updateDate;
	
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
	public String getPayCost() {
		return payCost;
	}
	public void setPayCost(String payCost) {
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
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
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
