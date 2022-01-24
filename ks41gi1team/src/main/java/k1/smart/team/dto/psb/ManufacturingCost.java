package k1.smart.team.dto.psb;

public class ManufacturingCost {
	private String manufacturingCostCode;
	private String mainBusinessCode;
	private String itemCode;
	private String itemName;
	private String businessName;
	private int totalCost;
	private int unitCost;
	private String regDate;
	private String updateDate;
	public String getManufacturingCostCode() {
		return manufacturingCostCode;
	}
	public void setManufacturingCostCode(String manufacturingCostCode) {
		this.manufacturingCostCode = manufacturingCostCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public int getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
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
		builder.append("ManufacturingCost [manufacturingCostCode=");
		builder.append(manufacturingCostCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", totalCost=");
		builder.append(totalCost);
		builder.append(", unitCost=");
		builder.append(unitCost);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}



	
}
