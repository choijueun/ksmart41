package k1.smart.team.dto.psb;

public class PurchaseTransaction {
	private String purchaseTsCode;
	private String purchaseTsDetailCode;
	private String mainBusinessCode;
	private String clientCode;
	private String contractCode;
	private String briefs;
	private String dealDate;
	private String regId;
	private int count;
	private int unitPrice;
	private int vat;
	private int totalPrice;
	private String regDate;
	private String updateDate;
	private String userName;
	private String itemName;
	private String itemCode;
	private String businessName;
	private String lsAccountCode;
	private String lsAccountName;
	private String clientBusinessName;
	public String getPurchaseTsCode() {
		return purchaseTsCode;
	}
	public void setPurchaseTsCode(String purchaseTsCode) {
		this.purchaseTsCode = purchaseTsCode;
	}
	public String getPurchaseTsDetailCode() {
		return purchaseTsDetailCode;
	}
	public void setPurchaseTsDetailCode(String purchaseTsDetailCode) {
		this.purchaseTsDetailCode = purchaseTsDetailCode;
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
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getBriefs() {
		return briefs;
	}
	public void setBriefs(String briefs) {
		this.briefs = briefs;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getLsAccountCode() {
		return lsAccountCode;
	}
	public void setLsAccountCode(String lsAccountCode) {
		this.lsAccountCode = lsAccountCode;
	}
	public String getLsAccountName() {
		return lsAccountName;
	}
	public void setLsAccountName(String lsAccountName) {
		this.lsAccountName = lsAccountName;
	}
	public String getClientBusinessName() {
		return clientBusinessName;
	}
	public void setClientBusinessName(String clientBusinessName) {
		this.clientBusinessName = clientBusinessName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PurchaseTransaction [purchaseTsCode=");
		builder.append(purchaseTsCode);
		builder.append(", purchaseTsDetailCode=");
		builder.append(purchaseTsDetailCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", contractCode=");
		builder.append(contractCode);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", dealDate=");
		builder.append(dealDate);
		builder.append(", regId=");
		builder.append(regId);
		builder.append(", count=");
		builder.append(count);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append(", vat=");
		builder.append(vat);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", lsAccountCode=");
		builder.append(lsAccountCode);
		builder.append(", lsAccountName=");
		builder.append(lsAccountName);
		builder.append(", clientBusinessName=");
		builder.append(clientBusinessName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
