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
	private String status; //상태
	
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
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
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
		builder.append(", status=");
		builder.append(status);
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
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adjCount;
		result = prime * result + ((adjDate == null) ? 0 : adjDate.hashCode());
		result = prime * result + adjWeight;
		result = prime * result + afterCount;
		result = prime * result + amount;
		result = prime * result + ((briefs == null) ? 0 : briefs.hashCode());
		result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
		result = prime * result + ((clientCode == null) ? 0 : clientCode.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((contractCode == null) ? 0 : contractCode.hashCode());
		result = prime * result + ((contractSection == null) ? 0 : contractSection.hashCode());
		result = prime * result + ((defectHandlingType == null) ? 0 : defectHandlingType.hashCode());
		result = prime * result + ((defectType == null) ? 0 : defectType.hashCode());
		result = prime * result + ((deliveryCode == null) ? 0 : deliveryCode.hashCode());
		result = prime * result + deliveryCost;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((inventoryCode == null) ? 0 : inventoryCode.hashCode());
		result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((mainBusinessCode == null) ? 0 : mainBusinessCode.hashCode());
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result + ((materialOrderCode == null) ? 0 : materialOrderCode.hashCode());
		result = prime * result + ((productOrderCode == null) ? 0 : productOrderCode.hashCode());
		result = prime * result + ((purchaseTsCode == null) ? 0 : purchaseTsCode.hashCode());
		result = prime * result + ((receiveAddr == null) ? 0 : receiveAddr.hashCode());
		result = prime * result + ((receivePlanDate == null) ? 0 : receivePlanDate.hashCode());
		result = prime * result + ((receiveWarehouse == null) ? 0 : receiveWarehouse.hashCode());
		result = prime * result + ((receiveWarehouseLocation == null) ? 0 : receiveWarehouseLocation.hashCode());
		result = prime * result + ((receiveWarehouseName == null) ? 0 : receiveWarehouseName.hashCode());
		result = prime * result + ((receiveWarehouseOutPlace == null) ? 0 : receiveWarehouseOutPlace.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + ((returnRegCode == null) ? 0 : returnRegCode.hashCode());
		result = prime * result + ((salesTsCode == null) ? 0 : salesTsCode.hashCode());
		result = prime * result + ((sendPlanDate == null) ? 0 : sendPlanDate.hashCode());
		result = prime * result + ((sendWarehouse == null) ? 0 : sendWarehouse.hashCode());
		result = prime * result + ((sendWarehouseLocation == null) ? 0 : sendWarehouseLocation.hashCode());
		result = prime * result + ((sendWarehouseName == null) ? 0 : sendWarehouseName.hashCode());
		result = prime * result + ((sendWarehouseOutPlace == null) ? 0 : sendWarehouseOutPlace.hashCode());
		result = prime * result + ((shipPlanDetailCode == null) ? 0 : shipPlanDetailCode.hashCode());
		result = prime * result + ((shipmentPlanCode == null) ? 0 : shipmentPlanCode.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stockAdjCode == null) ? 0 : stockAdjCode.hashCode());
		result = prime * result + ((stockAdjDetailCode == null) ? 0 : stockAdjDetailCode.hashCode());
		result = prime * result + ((stockReason == null) ? 0 : stockReason.hashCode());
		result = prime * result + stockReasonCode;
		result = prime * result + ((stockReasonEng == null) ? 0 : stockReasonEng.hashCode());
		result = prime * result + stockWeight;
		result = prime * result + totalPrice;
		result = prime * result + totalWeight;
		result = prime * result + unitPrice;
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Storing other = (Storing) obj;
		if (adjCount != other.adjCount)
			return false;
		if (adjDate == null) {
			if (other.adjDate != null)
				return false;
		} else if (!adjDate.equals(other.adjDate))
			return false;
		if (adjWeight != other.adjWeight)
			return false;
		if (afterCount != other.afterCount)
			return false;
		if (amount != other.amount)
			return false;
		if (briefs == null) {
			if (other.briefs != null)
				return false;
		} else if (!briefs.equals(other.briefs))
			return false;
		if (businessName == null) {
			if (other.businessName != null)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (clientCode == null) {
			if (other.clientCode != null)
				return false;
		} else if (!clientCode.equals(other.clientCode))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (contractCode == null) {
			if (other.contractCode != null)
				return false;
		} else if (!contractCode.equals(other.contractCode))
			return false;
		if (contractSection == null) {
			if (other.contractSection != null)
				return false;
		} else if (!contractSection.equals(other.contractSection))
			return false;
		if (defectHandlingType == null) {
			if (other.defectHandlingType != null)
				return false;
		} else if (!defectHandlingType.equals(other.defectHandlingType))
			return false;
		if (defectType == null) {
			if (other.defectType != null)
				return false;
		} else if (!defectType.equals(other.defectType))
			return false;
		if (deliveryCode == null) {
			if (other.deliveryCode != null)
				return false;
		} else if (!deliveryCode.equals(other.deliveryCode))
			return false;
		if (deliveryCost != other.deliveryCost)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (inventoryCode == null) {
			if (other.inventoryCode != null)
				return false;
		} else if (!inventoryCode.equals(other.inventoryCode))
			return false;
		if (itemCode == null) {
			if (other.itemCode != null)
				return false;
		} else if (!itemCode.equals(other.itemCode))
			return false;
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (mainBusinessCode == null) {
			if (other.mainBusinessCode != null)
				return false;
		} else if (!mainBusinessCode.equals(other.mainBusinessCode))
			return false;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		if (materialOrderCode == null) {
			if (other.materialOrderCode != null)
				return false;
		} else if (!materialOrderCode.equals(other.materialOrderCode))
			return false;
		if (productOrderCode == null) {
			if (other.productOrderCode != null)
				return false;
		} else if (!productOrderCode.equals(other.productOrderCode))
			return false;
		if (purchaseTsCode == null) {
			if (other.purchaseTsCode != null)
				return false;
		} else if (!purchaseTsCode.equals(other.purchaseTsCode))
			return false;
		if (receiveAddr == null) {
			if (other.receiveAddr != null)
				return false;
		} else if (!receiveAddr.equals(other.receiveAddr))
			return false;
		if (receivePlanDate == null) {
			if (other.receivePlanDate != null)
				return false;
		} else if (!receivePlanDate.equals(other.receivePlanDate))
			return false;
		if (receiveWarehouse == null) {
			if (other.receiveWarehouse != null)
				return false;
		} else if (!receiveWarehouse.equals(other.receiveWarehouse))
			return false;
		if (receiveWarehouseLocation == null) {
			if (other.receiveWarehouseLocation != null)
				return false;
		} else if (!receiveWarehouseLocation.equals(other.receiveWarehouseLocation))
			return false;
		if (receiveWarehouseName == null) {
			if (other.receiveWarehouseName != null)
				return false;
		} else if (!receiveWarehouseName.equals(other.receiveWarehouseName))
			return false;
		if (receiveWarehouseOutPlace == null) {
			if (other.receiveWarehouseOutPlace != null)
				return false;
		} else if (!receiveWarehouseOutPlace.equals(other.receiveWarehouseOutPlace))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (returnRegCode == null) {
			if (other.returnRegCode != null)
				return false;
		} else if (!returnRegCode.equals(other.returnRegCode))
			return false;
		if (salesTsCode == null) {
			if (other.salesTsCode != null)
				return false;
		} else if (!salesTsCode.equals(other.salesTsCode))
			return false;
		if (sendPlanDate == null) {
			if (other.sendPlanDate != null)
				return false;
		} else if (!sendPlanDate.equals(other.sendPlanDate))
			return false;
		if (sendWarehouse == null) {
			if (other.sendWarehouse != null)
				return false;
		} else if (!sendWarehouse.equals(other.sendWarehouse))
			return false;
		if (sendWarehouseLocation == null) {
			if (other.sendWarehouseLocation != null)
				return false;
		} else if (!sendWarehouseLocation.equals(other.sendWarehouseLocation))
			return false;
		if (sendWarehouseName == null) {
			if (other.sendWarehouseName != null)
				return false;
		} else if (!sendWarehouseName.equals(other.sendWarehouseName))
			return false;
		if (sendWarehouseOutPlace == null) {
			if (other.sendWarehouseOutPlace != null)
				return false;
		} else if (!sendWarehouseOutPlace.equals(other.sendWarehouseOutPlace))
			return false;
		if (shipPlanDetailCode == null) {
			if (other.shipPlanDetailCode != null)
				return false;
		} else if (!shipPlanDetailCode.equals(other.shipPlanDetailCode))
			return false;
		if (shipmentPlanCode == null) {
			if (other.shipmentPlanCode != null)
				return false;
		} else if (!shipmentPlanCode.equals(other.shipmentPlanCode))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stockAdjCode == null) {
			if (other.stockAdjCode != null)
				return false;
		} else if (!stockAdjCode.equals(other.stockAdjCode))
			return false;
		if (stockAdjDetailCode == null) {
			if (other.stockAdjDetailCode != null)
				return false;
		} else if (!stockAdjDetailCode.equals(other.stockAdjDetailCode))
			return false;
		if (stockReason == null) {
			if (other.stockReason != null)
				return false;
		} else if (!stockReason.equals(other.stockReason))
			return false;
		if (stockReasonCode != other.stockReasonCode)
			return false;
		if (stockReasonEng == null) {
			if (other.stockReasonEng != null)
				return false;
		} else if (!stockReasonEng.equals(other.stockReasonEng))
			return false;
		if (stockWeight != other.stockWeight)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		if (totalWeight != other.totalWeight)
			return false;
		if (unitPrice != other.unitPrice)
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}
	
}
