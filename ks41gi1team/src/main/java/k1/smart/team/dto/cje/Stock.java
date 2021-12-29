package k1.smart.team.dto.cje;

public class Stock {
	private String inventoryCode; //재고코드
	private String mainBusinessCode; //사업장별 대표코드
	private String itemCode; //품목코드
	private String itemName; //품목명
	private String itemType; //품목분류
	private String categoryCode; //카테고리
	private String largeCategory; //대분류
	private String middleCategory; //중분류
	private String smallCategory; //소분류
	private String itemStandard; //품목규격
	private String itemOrigin; //품목원산지
	private String productPriceCode; //제품 단가 코드
	private int productPrice; //제품 단가
	private int itemCount; //수량
	private int totalPrice; //합계금액
	private int stockWeight; //중량(kg)
	private String warehouseCode; //창고 코드
	private String warehouseName; //창고명
	private String loaction; //창고위치
	private String outPlace; //창고소재지
	private String status; //재고상태
	private String comment; //비고
	private String regDate; //등록일시
	private String updateDate; //수정일시
	
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
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
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getLargeCategory() {
		return largeCategory;
	}
	public void setLargeCategory(String largeCategory) {
		this.largeCategory = largeCategory;
	}
	public String getMiddleCategory() {
		return middleCategory;
	}
	public void setMiddleCategory(String middleCategory) {
		this.middleCategory = middleCategory;
	}
	public String getSmallCategory() {
		return smallCategory;
	}
	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}
	public String getItemStandard() {
		return itemStandard;
	}
	public void setItemStandard(String itemStandard) {
		this.itemStandard = itemStandard;
	}
	public String getItemOrigin() {
		return itemOrigin;
	}
	public void setItemOrigin(String itemOrigin) {
		this.itemOrigin = itemOrigin;
	}
	public String getProductPriceCode() {
		return productPriceCode;
	}
	public void setProductPriceCode(String productPriceCode) {
		this.productPriceCode = productPriceCode;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getStockWeight() {
		return stockWeight;
	}
	public void setStockWeight(int stockWeight) {
		this.stockWeight = stockWeight;
	}
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getLoaction() {
		return loaction;
	}
	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}
	public String getOutPlace() {
		return outPlace;
	}
	public void setOutPlace(String outPlace) {
		this.outPlace = outPlace;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stock [inventoryCode=");
		builder.append(inventoryCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", itemType=");
		builder.append(itemType);
		builder.append(", categoryCode=");
		builder.append(categoryCode);
		builder.append(", largeCategory=");
		builder.append(largeCategory);
		builder.append(", middleCategory=");
		builder.append(middleCategory);
		builder.append(", smallCategory=");
		builder.append(smallCategory);
		builder.append(", itemStandard=");
		builder.append(itemStandard);
		builder.append(", itemOrigin=");
		builder.append(itemOrigin);
		builder.append(", productPriceCode=");
		builder.append(productPriceCode);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", itemCount=");
		builder.append(itemCount);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", stockWeight=");
		builder.append(stockWeight);
		builder.append(", warehouseCode=");
		builder.append(warehouseCode);
		builder.append(", warehouseName=");
		builder.append(warehouseName);
		builder.append(", loaction=");
		builder.append(loaction);
		builder.append(", outPlace=");
		builder.append(outPlace);
		builder.append(", status=");
		builder.append(status);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}
}
