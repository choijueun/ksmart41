package k1.smart.team.dto.psb;

import javax.validation.constraints.NotNull;

import groovy.transform.NullCheck;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;

public class ProductPrice {
	private String productPriceCode;
	private String mainBusinessCode;
	private String businessName;
	private String itemName;
	private String manufacCostCode;
	private String manufacturingCostCode;
	private String lsAccountCode;
	private int count;
	private int manufacCost;
	private int unitCost;
	private int totalEtcCost;
	private int totalPrice;
	private int productPrice;
	private String productCode;
	@Nullable
	private String comment;
	private float profitPercentage;
	private String regId;
	private String regName;
	private String regDate;
	private String updateDate;
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
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getManufacCostCode() {
		return manufacCostCode;
	}
	public void setManufacCostCode(String manufacCostCode) {
		this.manufacCostCode = manufacCostCode;
	}
	public String getManufacturingCostCode() {
		return manufacturingCostCode;
	}
	public void setManufacturingCostCode(String manufacturingCostCode) {
		this.manufacturingCostCode = manufacturingCostCode;
	}
	public String getLsAccountCode() {
		return lsAccountCode;
	}
	public void setLsAccountCode(String lsAccountCode) {
		this.lsAccountCode = lsAccountCode;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getManufacCost() {
		return manufacCost;
	}
	public void setManufacCost(int manufacCost) {
		this.manufacCost = manufacCost;
	}
	public int getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}
	public int getTotalEtcCost() {
		return totalEtcCost;
	}
	public void setTotalEtcCost(int totalEtcCost) {
		this.totalEtcCost = totalEtcCost;
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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getProfitPercentage() {
		return profitPercentage;
	}
	public void setProfitPercentage(float profitPercentage) {
		this.profitPercentage = profitPercentage;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
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
		builder.append("ProductPrice [productPriceCode=");
		builder.append(productPriceCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", manufacCostCode=");
		builder.append(manufacCostCode);
		builder.append(", manufacturingCostCode=");
		builder.append(manufacturingCostCode);
		builder.append(", lsAccountCode=");
		builder.append(lsAccountCode);
		builder.append(", count=");
		builder.append(count);
		builder.append(", manufacCost=");
		builder.append(manufacCost);
		builder.append(", unitCost=");
		builder.append(unitCost);
		builder.append(", totalEtcCost=");
		builder.append(totalEtcCost);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", profitPercentage=");
		builder.append(profitPercentage);
		builder.append(", regId=");
		builder.append(regId);
		builder.append(", regName=");
		builder.append(regName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}

	


}
