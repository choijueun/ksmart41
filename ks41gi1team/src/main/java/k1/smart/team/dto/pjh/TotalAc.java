package k1.smart.team.dto.pjh;

public class TotalAc {
	private String totalAccountCode;
	private String mainBusinessCode;
	private String slipGroup;
	private String salesSlipCode;
	private String purchaseSlipCode;
	private String etc_purchaseCode;
	private String salesSection;
	private String relateTable;
	private int totalPrice;
	
	public String getTotalAccountCode() {
		return totalAccountCode;
	}
	public void setTotalAccountCode(String totalAccountCode) {
		this.totalAccountCode = totalAccountCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getSlipGroup() {
		return slipGroup;
	}
	public void setSlipGroup(String slipGroup) {
		this.slipGroup = slipGroup;
	}
	public String getSalesSlipCode() {
		return salesSlipCode;
	}
	public void setSalesSlipCode(String salesSlipCode) {
		this.salesSlipCode = salesSlipCode;
	}
	public String getPurchaseSlipCode() {
		return purchaseSlipCode;
	}
	public void setPurchaseSlipCode(String purchaseSlipCode) {
		this.purchaseSlipCode = purchaseSlipCode;
	}
	public String getEtc_purchaseCode() {
		return etc_purchaseCode;
	}
	public void setEtc_purchaseCode(String etc_purchaseCode) {
		this.etc_purchaseCode = etc_purchaseCode;
	}
	public String getSalesSection() {
		return salesSection;
	}
	public void setSalesSection(String salesSection) {
		this.salesSection = salesSection;
	}
	public String getRelateTable() {
		return relateTable;
	}
	public void setRelateTable(String relateTable) {
		this.relateTable = relateTable;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalAc [totalAccountCode=");
		builder.append(totalAccountCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", slipGroup=");
		builder.append(slipGroup);
		builder.append(", salesSlipCode=");
		builder.append(salesSlipCode);
		builder.append(", purchaseSlipCode=");
		builder.append(purchaseSlipCode);
		builder.append(", etc_purchaseCode=");
		builder.append(etc_purchaseCode);
		builder.append(", salesSection=");
		builder.append(salesSection);
		builder.append(", relateTable=");
		builder.append(relateTable);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append("]");
		return builder.toString();
	}
	
}
