package k1.smart.team.dto.cje;

public class Delivery {
	private String deliveryCode; //운송요청내역코드
	private String shipmentPlanCode; //출하계획코드
	private String returnRegCode; //반품요청코드
	
	private String deliveryBusinessCode; //운송업체코드
	private String deliveryBusinessName; //운송업체상호
	
	private String contractCode; //계약코드
	private String clientCode; //거래처코드
	private String clientBusinessName; //거래처상호
	
	private String receiveAddr; //도착지
	private int deliveryCost; //운송비용 
	
	private String stockAdjCode; //물류이동코드
	private String stockReasonCode; //물류이동사유코드
	private String stockReason; //물류이동사유
	private String stockReasonEng; //물류이동사유
	
	private String warehouseCode; //창고코드
	private String warehouseName; //창고이름
	private String loaction; //위치
	private String outPlace; //외부소재지
	
	private String briefs; //적요
	private String managerId; //담당자ID
	private String managerName; //담당자이름
	
	private String regDate; //등록일시
	private String updateDate; //수정일시
	
	public String getReturnRegCode() {
		return returnRegCode;
	}
	public void setReturnRegCode(String returnRegCode) {
		this.returnRegCode = returnRegCode;
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
	public String getDeliveryBusinessCode() {
		return deliveryBusinessCode;
	}
	public void setDeliveryBusinessCode(String deliveryBusinessCode) {
		this.deliveryBusinessCode = deliveryBusinessCode;
	}
	public String getDeliveryBusinessName() {
		return deliveryBusinessName;
	}
	public void setDeliveryBusinessName(String deliveryBusinessName) {
		this.deliveryBusinessName = deliveryBusinessName;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getClientBusinessName() {
		return clientBusinessName;
	}
	public void setClientBusinessName(String clientBusinessName) {
		this.clientBusinessName = clientBusinessName;
	}
	public String getReceiveAddr() {
		return receiveAddr;
	}
	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}
	public int getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public String getStockAdjCode() {
		return stockAdjCode;
	}
	public void setStockAdjCode(String stockAdjCode) {
		this.stockAdjCode = stockAdjCode;
	}
	public String getStockReasonCode() {
		return stockReasonCode;
	}
	public void setStockReasonCode(String stockReasonCode) {
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
}
