package k1.smart.team.dto.cje;

public class Delivery {
	private String deliveryCode; //운송요청내역코드
	private String shipmentPlanCode; //출하계획코드
	
	private String deliveryBusinessCode; //운송업체코드
	private String deliveryBusinessName; //운송업체상호
	
	private String contractCode; //계약코드
	private String clientCode; //거래처코드
	private String clientBusinessName; //거래처상호
	
	private String receivePlace; //도착지
	private int deliveryCost; //운송비용 
	
	private String briefs; //적요
	private String managerId; //담당자ID
	private String managerName; //담당자이름
	
	private String regDate; //등록일시
	private String updateDate; //수정일시
	
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
	public String getReceivePlace() {
		return receivePlace;
	}
	public void setReceivePlace(String receivePlace) {
		this.receivePlace = receivePlace;
	}
	public int getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(int deliveryCost) {
		this.deliveryCost = deliveryCost;
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
