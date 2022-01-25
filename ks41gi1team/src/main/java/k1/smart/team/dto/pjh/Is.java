package k1.smart.team.dto.pjh;


public class Is {
	private String lsAccountCode;
	private String lsAccountName;
	private String lsCategoryCode;
	private String isUse;
	private String isModify;
	private int totalPrice;
	private int totalSales;
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
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
	public String getLsCategoryCode() {
		return lsCategoryCode;
	}
	public void setLsCategoryCode(String lsCategoryCode) {
		this.lsCategoryCode = lsCategoryCode;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getIsModify() {
		return isModify;
	}
	public void setIsModify(String isModify) {
		this.isModify = isModify;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Invoice [lsAccountCode=");
		builder.append(lsAccountCode);
		builder.append(", lsAccountName=");
		builder.append(lsAccountName);
		builder.append(", lsCategoryCode=");
		builder.append(lsCategoryCode);
		builder.append(", isUse=");
		builder.append(isUse);
		builder.append(", isModify=");
		builder.append(isModify);
		builder.append(", applyYear=");
		builder.append("]");
		return builder.toString();
	}
}
