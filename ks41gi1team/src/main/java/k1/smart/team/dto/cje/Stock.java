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
	private String microCategory; //소소분류
	
	private String itemStandard; //품목규격
	private String itemOrigin; //품목원산지
	private String itemStatus; //품목상태
	private String itemComment; //품목비고
	
	private String productPriceCode; //제품단가코드
	private int productPrice; //제품단가
	private int itemCount; //품목수량
	private int totalPrice; //합계금액
	private int stockWeight; //중량(kg)
	
	private String warehouseCode; //창고 코드
	private String warehouseName; //창고명
	private String loaction; //창고위치
	private String outPlace; //창고소재지
	
	private String status; //재고상태
	private String comment; //재고비고
	
	private String itemRegDate; //품목등록일시
	private String itemUpdateDate; //품목수정일시
	private String stockRegDate; //재고등록일시
	private String stockUpdateDate; //재고수정일시
	
	private String stockAdjCode; //물류이동내역코드
	private int stockReasonCode; //사유코드
	private String stockReason; //사유
	private String stockReasonEng; //사유
	private String endDate; //완료일자
	private String briefs; //적요
	private String managerId; //담당자ID
	private String managerName; //담당자이름
	private String storingUpdateDate; //수정일자
	
	public String getStockAdjCode() {
		return stockAdjCode;
	}
	public void setStockAdjCode(String stockAdjCode) {
		this.stockAdjCode = stockAdjCode;
	}
	public int getStockReasonCode() {
		return stockReasonCode;
	}
	public void setStockReasonCode(int stockReasonCode) {
		this.stockReasonCode = stockReasonCode;
	}
	public String getStockReason() {
		return stockReason;
	}
	public void setStockReason(String stockReason) {
		this.stockReason = stockReason;
	}
	public String getStockReasonEng() {
		return stockReasonEng;
	}
	public void setStockReasonEng(String stockReasonEng) {
		this.stockReasonEng = stockReasonEng;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBriefs() {
		return briefs;
	}
	public void setBriefs(String briefs) {
		this.briefs = briefs;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getStoringUpdateDate() {
		return storingUpdateDate;
	}
	public void setStoringUpdateDate(String storingUpdateDate) {
		this.storingUpdateDate = storingUpdateDate;
	}
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
	public String getMicroCategory() {
		return microCategory;
	}
	public void setMicroCategory(String microCategory) {
		this.microCategory = microCategory;
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
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public String getItemComment() {
		return itemComment;
	}
	public void setItemComment(String itemComment) {
		this.itemComment = itemComment;
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
	public String getItemRegDate() {
		return itemRegDate;
	}
	public void setItemRegDate(String itemRegDate) {
		this.itemRegDate = itemRegDate;
	}
	public String getItemUpdateDate() {
		return itemUpdateDate;
	}
	public void setItemUpdateDate(String itemUpdateDate) {
		this.itemUpdateDate = itemUpdateDate;
	}
	public String getStockRegDate() {
		return stockRegDate;
	}
	public void setStockRegDate(String stockRegDate) {
		this.stockRegDate = stockRegDate;
	}
	public String getStockUpdateDate() {
		return stockUpdateDate;
	}
	public void setStockUpdateDate(String stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
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
		builder.append(", microCategory=");
		builder.append(microCategory);
		builder.append(", itemStandard=");
		builder.append(itemStandard);
		builder.append(", itemOrigin=");
		builder.append(itemOrigin);
		builder.append(", itemStatus=");
		builder.append(itemStatus);
		builder.append(", itemComment=");
		builder.append(itemComment);
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
		builder.append(", itemRegDate=");
		builder.append(itemRegDate);
		builder.append(", itemUpdateDate=");
		builder.append(itemUpdateDate);
		builder.append(", stockRegDate=");
		builder.append(stockRegDate);
		builder.append(", stockUpdateDate=");
		builder.append(stockUpdateDate);
		builder.append("]");
		return builder.toString();
	}
}
