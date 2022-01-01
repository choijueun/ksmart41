package k1.smart.team.dto.cje;

public class Storing {
	private String stockAdjCode; //재고조정내역코드
	private String mainBusinessCode; //사업장별 대표코드
	private int stockReasonCode; //재고조정사유코드
	private String stockReason; //*재고조정사유
	
	private String clientCode; //거래처 대표코드
	private String businessName; //*상호
	
	private String contractCode; //계약코드
	private String contractSection; //*계약 주문유형 - 수주발주 택1이면 없어도 될지도
	
	private String materialOrderCode; //발주 코드
	private String deliveryCode; //운송요청내역코드
	private String shipmentPlanCode; //*출하계획코드
	
	private String returnRegCode; //반품 요청 코드
	
	private String sendWarehouse; //보내는창고
	private String sendWarehouseName; //*보내는창고이름
	private String receiveWarehouse; //받는창고
	private String receiveWarehouseName; //*받는창고이름
	
	private int deliveryCost; //운송비용
	private int totalPrice; //총가격
	
	private String sendPlanDate; //발송예정일
	private String receivePlanDate; //수송예정일
	
	private String requestDate; //요청일자
	private String adjDate; //조정일자
	private String endDate; //완료일자
	
	private String briefs; //적요
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
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", stockReasonCode=");
		builder.append(stockReasonCode);
		builder.append(", stockReason=");
		builder.append(stockReason);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", contractCode=");
		builder.append(contractCode);
		builder.append(", contractSection=");
		builder.append(contractSection);
		builder.append(", materialOrderCode=");
		builder.append(materialOrderCode);
		builder.append(", deliveryCode=");
		builder.append(deliveryCode);
		builder.append(", shipmentPlanCode=");
		builder.append(shipmentPlanCode);
		builder.append(", returnRegCode=");
		builder.append(returnRegCode);
		builder.append(", sendWarehouse=");
		builder.append(sendWarehouse);
		builder.append(", sendWarehouseName=");
		builder.append(sendWarehouseName);
		builder.append(", receiveWarehouse=");
		builder.append(receiveWarehouse);
		builder.append(", receiveWarehouseName=");
		builder.append(receiveWarehouseName);
		builder.append(", deliveryCost=");
		builder.append(deliveryCost);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
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
}
