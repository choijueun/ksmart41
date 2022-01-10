package k1.smart.team.dto.psb;



public class ManufacturingCostCalc {
	private String manufacturingCostCalcCode;
	private String manufacturingCostCode;
	private String materialCode;
	private String purchaseTsCode;
	private int cost;
	private int amount;
	private int totalCost;
	private String lsAccountName;
	private String totalPrice;
	private String itemName;
	public String getManufacturingCostCalcCode() {
		return manufacturingCostCalcCode;
	}
	public void setManufacturingCostCalcCode(String manufacturingCostCalcCode) {
		this.manufacturingCostCalcCode = manufacturingCostCalcCode;
	}
	public String getManufacturingCostCode() {
		return manufacturingCostCode;
	}
	public void setManufacturingCostCode(String manufacturingCostCode) {
		this.manufacturingCostCode = manufacturingCostCode;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public String getPurchaseTsCode() {
		return purchaseTsCode;
	}
	public void setPurchaseTsCode(String purchaseTsCode) {
		this.purchaseTsCode = purchaseTsCode;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getLsAccountName() {
		return lsAccountName;
	}
	public void setLsAccountName(String lsAccountName) {
		this.lsAccountName = lsAccountName;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ManufacturingCostCalc [manufacturingCostCalcCode=");
		builder.append(manufacturingCostCalcCode);
		builder.append(", manufacturingCostCode=");
		builder.append(manufacturingCostCode);
		builder.append(", materialCode=");
		builder.append(materialCode);
		builder.append(", purchaseTsCode=");
		builder.append(purchaseTsCode);
		builder.append(", cost=");
		builder.append(cost);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", totalCost=");
		builder.append(totalCost);
		builder.append(", lsAccountName=");
		builder.append(lsAccountName);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append("]");
		return builder.toString();
	}

	


	
	
}
