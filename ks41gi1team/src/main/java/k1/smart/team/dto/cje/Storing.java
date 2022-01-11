package k1.smart.team.dto.cje;

public class Storing {
	private String stockAdjCode; //재고조정내역코드
	private String stockAdjDetailCode; //재고조정내역코드
	private String mainBusinessCode; //사업장별 대표코드
	private int stockReasonCode; //재고조정사유코드
	private String stockReason; //*재고조정사유
	private String stockReasonEng; //*재고조정사유
	
	private String clientCode; //거래처 대표코드
	private String businessName; //*상호
	
	private String inventoryCode; //재고코드
	private String itemCode; //*품목코드
	private String itemName; //*품목이름
	private String itemList; //*품목배열(GROUP_CONCAT)
	
	private String contractCode; //계약코드
	private String contractSection; //*계약 주문유형 - 수주발주 택1이면 없어도 될지도
	
	private String materialOrderCode; //발주 코드
	private String productOrderCode; //수주 코드
	private String deliveryCode; //운송요청내역코드
	private String shipmentPlanCode; //*출하계획코드
	private String shipPlanDetailCode; //*출하계획상세코드
	
	private String returnRegCode; //반품 요청 코드
	
	private String sendWarehouse; //보내는창고
	private String sendWarehouseName; //*보내는창고이름
	private String sendWarehouseLocation; //*보내는창고위치
	private String sendWarehouseOutPlace; //*보내는창고소재지
	private String receiveWarehouse; //받는창고
	private String receiveWarehouseName; //*받는창고이름
	private String receiveWarehouseLocation; //*받는창고위치
	private String receiveWarehouseOutPlace; //*받는창고소재지
	
	private String purchaseTsCode; //비용거래명세서코드
	private String salesTsCode; //매출거래명세서코드
	
	private int adjCount; //조정수량
	private int afterCount; //최종수량
	private int adjWeight; //조정중량
	private int stockWeight; //최종중량
	private int totalWeight; //합계중량
	private int amount;
	
	private int deliveryCost; //운송비용
	private int unitPrice; //단가
	private int totalPrice; //총가격
	private String receiveAddr; //도착지
	
	private String sendPlanDate; //발송예정일
	private String receivePlanDate; //수송예정일
	
	private String requestDate; //요청일자
	private String adjDate; //조정일자
	private String endDate; //완료일자
	
	private String briefs; //적요
	private String stockStatus; //상태
	private String comment; //비고
	
	private String defectType; //불량유형
	private String defectHandlingType; //불량처리유형
	
	private String managerId; //담당자ID
	private String managerName; //*담당자이름
	
	private String regDate; //등록일시
	private String updateDate; //수정일시
	
	public String getStockAdjCode() {
		return stockAdjCode;
	}
	public void setStockAdjCode(String stockAdjCode) {
		this.stockAdjCode = stockAdjCode;
	}
	public String getStockAdjDetailCode() {
		return stockAdjDetailCode;
	}
	public void setStockAdjDetailCode(String stockAdjDetailCode) {
		this.stockAdjDetailCode = stockAdjDetailCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
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
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getStockReasonEng() {
		return stockReasonEng;
	}
	public void setStockReasonEng(String stockReasonEng) {
		this.stockReasonEng = stockReasonEng;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
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
	public String getItemList() {
		return itemList;
	}
	public void setItemList(String itemList) {
		this.itemList = itemList;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getContractSection() {
		return contractSection;
	}
	public void setContractSection(String contractSection) {
		this.contractSection = contractSection;
	}
	public String getMaterialOrderCode() {
		return materialOrderCode;
	}
	public void setMaterialOrderCode(String materialOrderCode) {
		this.materialOrderCode = materialOrderCode;
	}
	public String getProductOrderCode() {
		return productOrderCode;
	}
	public void setProductOrderCode(String productOrderCode) {
		this.productOrderCode = productOrderCode;
	}
	public String getDeliveryCode() {
		return deliveryCode;
	}
	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}
	public String getShipmentPlanCode() {
		return shipmentPlanCode;
	}
	public void setShipmentPlanCode(String shipmentPlanCode) {
		this.shipmentPlanCode = shipmentPlanCode;
	}
	public String getShipPlanDetailCode() {
		return shipPlanDetailCode;
	}
	public void setShipPlanDetailCode(String shipPlanDetailCode) {
		this.shipPlanDetailCode = shipPlanDetailCode;
	}
	public String getReturnRegCode() {
		return returnRegCode;
	}
	public void setReturnRegCode(String returnRegCode) {
		this.returnRegCode = returnRegCode;
	}
	public String getSendWarehouse() {
		return sendWarehouse;
	}
	public void setSendWarehouse(String sendWarehouse) {
		this.sendWarehouse = sendWarehouse;
	}
	public String getSendWarehouseName() {
		return sendWarehouseName;
	}
	public void setSendWarehouseName(String sendWarehouseName) {
		this.sendWarehouseName = sendWarehouseName;
	}
	public String getSendWarehouseLocation() {
		return sendWarehouseLocation;
	}
	public void setSendWarehouseLocation(String sendWarehouseLocation) {
		this.sendWarehouseLocation = sendWarehouseLocation;
	}
	public String getSendWarehouseOutPlace() {
		return sendWarehouseOutPlace;
	}
	public void setSendWarehouseOutPlace(String sendWarehouseOutPlace) {
		this.sendWarehouseOutPlace = sendWarehouseOutPlace;
	}
	public String getReceiveWarehouse() {
		return receiveWarehouse;
	}
	public void setReceiveWarehouse(String receiveWarehouse) {
		this.receiveWarehouse = receiveWarehouse;
	}
	public String getReceiveWarehouseName() {
		return receiveWarehouseName;
	}
	public void setReceiveWarehouseName(String receiveWarehouseName) {
		this.receiveWarehouseName = receiveWarehouseName;
	}
	public String getReceiveWarehouseLocation() {
		return receiveWarehouseLocation;
	}
	public void setReceiveWarehouseLocation(String receiveWarehouseLocation) {
		this.receiveWarehouseLocation = receiveWarehouseLocation;
	}
	public String getReceiveWarehouseOutPlace() {
		return receiveWarehouseOutPlace;
	}
	public void setReceiveWarehouseOutPlace(String receiveWarehouseOutPlace) {
		this.receiveWarehouseOutPlace = receiveWarehouseOutPlace;
	}
	public String getPurchaseTsCode() {
		return purchaseTsCode;
	}
	public void setPurchaseTsCode(String purchaseTsCode) {
		this.purchaseTsCode = purchaseTsCode;
	}
	public String getSalesTsCode() {
		return salesTsCode;
	}
	public void setSalesTsCode(String salesTsCode) {
		this.salesTsCode = salesTsCode;
	}
	public int getAdjCount() {
		return adjCount;
	}
	public void setAdjCount(int adjCount) {
		this.adjCount = adjCount;
	}
	public int getAfterCount() {
		return afterCount;
	}
	public void setAfterCount(int afterCount) {
		this.afterCount = afterCount;
	}
	public int getAdjWeight() {
		return adjWeight;
	}
	public void setAdjWeight(int adjWeight) {
		this.adjWeight = adjWeight;
	}
	public int getStockWeight() {
		return stockWeight;
	}
	public void setStockWeight(int stockWeight) {
		this.stockWeight = stockWeight;
	}
	public int getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getReceiveAddr() {
		return receiveAddr;
	}
	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}
	public String getSendPlanDate() {
		return sendPlanDate;
	}
	public void setSendPlanDate(String sendPlanDate) {
		this.sendPlanDate = sendPlanDate;
	}
	public String getReceivePlanDate() {
		return receivePlanDate;
	}
	public void setReceivePlanDate(String receivePlanDate) {
		this.receivePlanDate = receivePlanDate;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getAdjDate() {
		return adjDate;
	}
	public void setAdjDate(String adjDate) {
		this.adjDate = adjDate;
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
	public String getStockStatus() {
		return stockStatus;
	}
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDefectType() {
		return defectType;
	}
	public void setDefectType(String defectType) {
		this.defectType = defectType;
	}
	public String getDefectHandlingType() {
		return defectHandlingType;
	}
	public void setDefectHandlingType(String defectHandlingType) {
		this.defectHandlingType = defectHandlingType;
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
		builder.append("Storing [stockAdjCode=");
		builder.append(stockAdjCode);
		builder.append(", stockAdjDetailCode=");
		builder.append(stockAdjDetailCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", stockReasonCode=");
		builder.append(stockReasonCode);
		builder.append(", stockReason=");
		builder.append(stockReason);
		builder.append(", stockReasonEng=");
		builder.append(stockReasonEng);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", inventoryCode=");
		builder.append(inventoryCode);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", itemList=");
		builder.append(itemList);
		builder.append(", contractCode=");
		builder.append(contractCode);
		builder.append(", contractSection=");
		builder.append(contractSection);
		builder.append(", materialOrderCode=");
		builder.append(materialOrderCode);
		builder.append(", productOrderCode=");
		builder.append(productOrderCode);
		builder.append(", deliveryCode=");
		builder.append(deliveryCode);
		builder.append(", shipmentPlanCode=");
		builder.append(shipmentPlanCode);
		builder.append(", shipPlanDetailCode=");
		builder.append(shipPlanDetailCode);
		builder.append(", returnRegCode=");
		builder.append(returnRegCode);
		builder.append(", sendWarehouse=");
		builder.append(sendWarehouse);
		builder.append(", sendWarehouseName=");
		builder.append(sendWarehouseName);
		builder.append(", sendWarehouseLocation=");
		builder.append(sendWarehouseLocation);
		builder.append(", sendWarehouseOutPlace=");
		builder.append(sendWarehouseOutPlace);
		builder.append(", receiveWarehouse=");
		builder.append(receiveWarehouse);
		builder.append(", receiveWarehouseName=");
		builder.append(receiveWarehouseName);
		builder.append(", receiveWarehouseLocation=");
		builder.append(receiveWarehouseLocation);
		builder.append(", receiveWarehouseOutPlace=");
		builder.append(receiveWarehouseOutPlace);
		builder.append(", purchaseTsCode=");
		builder.append(purchaseTsCode);
		builder.append(", salesTsCode=");
		builder.append(salesTsCode);
		builder.append(", adjCount=");
		builder.append(adjCount);
		builder.append(", afterCount=");
		builder.append(afterCount);
		builder.append(", adjWeight=");
		builder.append(adjWeight);
		builder.append(", stockWeight=");
		builder.append(stockWeight);
		builder.append(", totalWeight=");
		builder.append(totalWeight);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", deliveryCost=");
		builder.append(deliveryCost);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", receiveAddr=");
		builder.append(receiveAddr);
		builder.append(", sendPlanDate=");
		builder.append(sendPlanDate);
		builder.append(", receivePlanDate=");
		builder.append(receivePlanDate);
		builder.append(", requestDate=");
		builder.append(requestDate);
		builder.append(", adjDate=");
		builder.append(adjDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", stockStatus=");
		builder.append(stockStatus);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", defectType=");
		builder.append(defectType);
		builder.append(", defectHandlingType=");
		builder.append(defectHandlingType);
		builder.append(", managerId=");
		builder.append(managerId);
		builder.append(", managerName=");
		builder.append(managerName);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", getStockAdjCode()=");
		builder.append(getStockAdjCode());
		builder.append(", getStockAdjDetailCode()=");
		builder.append(getStockAdjDetailCode());
		builder.append(", getMainBusinessCode()=");
		builder.append(getMainBusinessCode());
		builder.append(", getStockReasonCode()=");
		builder.append(getStockReasonCode());
		builder.append(", getStockReason()=");
		builder.append(getStockReason());
		builder.append(", getUnitPrice()=");
		builder.append(getUnitPrice());
		builder.append(", getStockReasonEng()=");
		builder.append(getStockReasonEng());
		builder.append(", getClientCode()=");
		builder.append(getClientCode());
		builder.append(", getBusinessName()=");
		builder.append(getBusinessName());
		builder.append(", getInventoryCode()=");
		builder.append(getInventoryCode());
		builder.append(", getItemCode()=");
		builder.append(getItemCode());
		builder.append(", getItemName()=");
		builder.append(getItemName());
		builder.append(", getItemList()=");
		builder.append(getItemList());
		builder.append(", getContractCode()=");
		builder.append(getContractCode());
		builder.append(", getContractSection()=");
		builder.append(getContractSection());
		builder.append(", getMaterialOrderCode()=");
		builder.append(getMaterialOrderCode());
		builder.append(", getProductOrderCode()=");
		builder.append(getProductOrderCode());
		builder.append(", getDeliveryCode()=");
		builder.append(getDeliveryCode());
		builder.append(", getShipmentPlanCode()=");
		builder.append(getShipmentPlanCode());
		builder.append(", getShipPlanDetailCode()=");
		builder.append(getShipPlanDetailCode());
		builder.append(", getReturnRegCode()=");
		builder.append(getReturnRegCode());
		builder.append(", getSendWarehouse()=");
		builder.append(getSendWarehouse());
		builder.append(", getSendWarehouseName()=");
		builder.append(getSendWarehouseName());
		builder.append(", getSendWarehouseLocation()=");
		builder.append(getSendWarehouseLocation());
		builder.append(", getSendWarehouseOutPlace()=");
		builder.append(getSendWarehouseOutPlace());
		builder.append(", getReceiveWarehouse()=");
		builder.append(getReceiveWarehouse());
		builder.append(", getReceiveWarehouseName()=");
		builder.append(getReceiveWarehouseName());
		builder.append(", getReceiveWarehouseLocation()=");
		builder.append(getReceiveWarehouseLocation());
		builder.append(", getReceiveWarehouseOutPlace()=");
		builder.append(getReceiveWarehouseOutPlace());
		builder.append(", getPurchaseTsCode()=");
		builder.append(getPurchaseTsCode());
		builder.append(", getSalesTsCode()=");
		builder.append(getSalesTsCode());
		builder.append(", getAdjCount()=");
		builder.append(getAdjCount());
		builder.append(", getAfterCount()=");
		builder.append(getAfterCount());
		builder.append(", getAdjWeight()=");
		builder.append(getAdjWeight());
		builder.append(", getStockWeight()=");
		builder.append(getStockWeight());
		builder.append(", getTotalWeight()=");
		builder.append(getTotalWeight());
		builder.append(", getAmount()=");
		builder.append(getAmount());
		builder.append(", getDeliveryCost()=");
		builder.append(getDeliveryCost());
		builder.append(", getTotalPrice()=");
		builder.append(getTotalPrice());
		builder.append(", getReceiveAddr()=");
		builder.append(getReceiveAddr());
		builder.append(", getSendPlanDate()=");
		builder.append(getSendPlanDate());
		builder.append(", getReceivePlanDate()=");
		builder.append(getReceivePlanDate());
		builder.append(", getRequestDate()=");
		builder.append(getRequestDate());
		builder.append(", getAdjDate()=");
		builder.append(getAdjDate());
		builder.append(", getEndDate()=");
		builder.append(getEndDate());
		builder.append(", getBriefs()=");
		builder.append(getBriefs());
		builder.append(", getStockStatus()=");
		builder.append(getStockStatus());
		builder.append(", getComment()=");
		builder.append(getComment());
		builder.append(", getDefectType()=");
		builder.append(getDefectType());
		builder.append(", getDefectHandlingType()=");
		builder.append(getDefectHandlingType());
		builder.append(", getManagerId()=");
		builder.append(getManagerId());
		builder.append(", getManagerName()=");
		builder.append(getManagerName());
		builder.append(", getRegDate()=");
		builder.append(getRegDate());
		builder.append(", getUpdateDate()=");
		builder.append(getUpdateDate());
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
