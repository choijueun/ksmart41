package k1.smart.team.dto.psb;

public class SalesTransaction {
	private String salesTsCode;
	private String mainBusinessCode;
	private String clientCode;
	private String lsAccountCode;
	private String contractCode;
	private String vatType;
	private int amount;
	private int vat;
	private int totalPrice;
	private int unitPrice;
	private String dealDate;
	private String briefs;
	private String regId;
	private String regDate;
	private String updateDate;
	public String getSalesTsCode() {
		return salesTsCode;
	}
	public void setSalesTsCode(String salesTsCode) {
		this.salesTsCode = salesTsCode;
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
	public String getLsAccountCode() {
		return lsAccountCode;
	}
	public void setLsAccountCode(String lsAccountCode) {
		this.lsAccountCode = lsAccountCode;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
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
		builder.append("SalesTransaction [salesTsCode=");
		builder.append(salesTsCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", lsAccountCode=");
		builder.append(lsAccountCode);
		builder.append(", contractCode=");
		builder.append(contractCode);
		builder.append(", vatType=");
		builder.append(vatType);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", vat=");
		builder.append(vat);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append(", dealDate=");
		builder.append(dealDate);
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
