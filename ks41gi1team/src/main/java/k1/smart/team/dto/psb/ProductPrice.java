package k1.smart.team.dto.psb;

public class ProductPrice {
	private String productPriceCode;
	private String mainBusinessCode;
	private String lsAccountCode;
	private String itemCode;
	private int amount;
	private String manufacCostCode;
	private int manufacCost;
	private int totalEtcCost;
	private int totalMaterialCost;
	private int totalManufacCost;
	private int profitPercentage;
	private int totalPrice;
	private int productPrice;
	private String regId;
	private String regDate;
	private String updateDate;
	private String comment;
	public String getProductPriceCode() {
		return productPriceCode;
	}
	public void setProductPriceCode(String productPriceCode) {
		this.productPriceCode = productPriceCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getLsAccountCode() {
		return lsAccountCode;
	}
	public void setLsAccountCode(String lsAccountCode) {
		this.lsAccountCode = lsAccountCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getManufacCostCode() {
		return manufacCostCode;
	}
	public void setManufacCostCode(String manufacCostCode) {
		this.manufacCostCode = manufacCostCode;
	}
	public int getManufacCost() {
		return manufacCost;
	}
	public void setManufacCost(int manufacCost) {
		this.manufacCost = manufacCost;
	}
	public int getTotalEtcCost() {
		return totalEtcCost;
	}
	public void setTotalEtcCost(int totalEtcCost) {
		this.totalEtcCost = totalEtcCost;
	}
	public int getTotalMaterialCost() {
		return totalMaterialCost;
	}
	public void setTotalMaterialCost(int totalMaterialCost) {
		this.totalMaterialCost = totalMaterialCost;
	}
	public int getTotalManufacCost() {
		return totalManufacCost;
	}
	public void setTotalManufacCost(int totalManufacCost) {
		this.totalManufacCost = totalManufacCost;
	}
	public int getProfitPercentage() {
		return profitPercentage;
	}
	public void setProfitPercentage(int profitPercentage) {
		this.profitPercentage = profitPercentage;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductPrice [productPriceCode=");
		builder.append(productPriceCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", lsAccountCode=");
		builder.append(lsAccountCode);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", manufacCostCode=");
		builder.append(manufacCostCode);
		builder.append(", manufacCost=");
		builder.append(manufacCost);
		builder.append(", totalEtcCost=");
		builder.append(totalEtcCost);
		builder.append(", totalMaterialCost=");
		builder.append(totalMaterialCost);
		builder.append(", totalManufacCost=");
		builder.append(totalManufacCost);
		builder.append(", profitPercentage=");
		builder.append(profitPercentage);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", regId=");
		builder.append(regId);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", getProductPriceCode()=");
		builder.append(getProductPriceCode());
		builder.append(", getMainBusinessCode()=");
		builder.append(getMainBusinessCode());
		builder.append(", getLsAccountCode()=");
		builder.append(getLsAccountCode());
		builder.append(", getItemCode()=");
		builder.append(getItemCode());
		builder.append(", getAmount()=");
		builder.append(getAmount());
		builder.append(", getManufacCostCode()=");
		builder.append(getManufacCostCode());
		builder.append(", getManufacCost()=");
		builder.append(getManufacCost());
		builder.append(", getTotalEtcCost()=");
		builder.append(getTotalEtcCost());
		builder.append(", getTotalMaterialCost()=");
		builder.append(getTotalMaterialCost());
		builder.append(", getTotalManufacCost()=");
		builder.append(getTotalManufacCost());
		builder.append(", getProfitPercentage()=");
		builder.append(getProfitPercentage());
		builder.append(", getTotalPrice()=");
		builder.append(getTotalPrice());
		builder.append(", getProductPrice()=");
		builder.append(getProductPrice());
		builder.append(", getRegId()=");
		builder.append(getRegId());
		builder.append(", getRegDate()=");
		builder.append(getRegDate());
		builder.append(", getUpdateDate()=");
		builder.append(getUpdateDate());
		builder.append(", getComment()=");
		builder.append(getComment());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
