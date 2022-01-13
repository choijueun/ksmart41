package k1.smart.team.dto.pjh;


public class Slip {
	private String purchaseSlipCode; //비용전표코드
	private String salesSlipCode; //매출전표코드
	
	
	private String mainBusinessCode; //삭제할지말지?
	private String totalAccountCode; //통합 회계 관리코드
	private String purchaseTsCode; //비용 거래명세서 코드
	private String salesTsCode; //매출 거래명세서 코드
	private String clientCode; //거래처코드
	private String businessName; //거래처상호
	private int amount; //단가
	private int tax;  //개당 세금
	private int vat;  //개당 세금
	private int count;  //수량
	private int amt;  //((단가+세금)*수량) = amt
	private String briefs;
	private String regId;
	private String userName; //담당자이름
	private String comment;
	private String regDate;
	private String updateDate;
	
	private String slipDate; //전표일자
	private String TsCode; //명세서
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
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
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
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public String getSlipDate() {
		return slipDate;
	}
	public void setSlipDate(String slipDate) {
		this.slipDate = slipDate;
	}
	public String getTsCode() {
		return TsCode;
	}
	public void setTsCode(String tsCode) {
		TsCode = tsCode;
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
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", tax=");
		builder.append(tax);
		builder.append(", vat=");
		builder.append(vat);
		builder.append(", count=");
		builder.append(count);
		builder.append(", amt=");
		builder.append(amt);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", regId=");
		builder.append(regId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", slipDate=");
		builder.append(slipDate);
		builder.append(", TsCode=");
		builder.append(TsCode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
	

	

