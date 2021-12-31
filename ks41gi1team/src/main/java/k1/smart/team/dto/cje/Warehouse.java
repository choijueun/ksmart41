package k1.smart.team.dto.cje;

import java.util.Date;

public class Warehouse {
	private String warehouseCode;
	private String warehouseName;
	private String category1;
	private String category2;
	private int area;
	private String loaction;
	private String outPlace;
	private int currentWeight;
	private int maxWeight;
	private int weightPer;
	private String status;
	private Date regDate; 
	private Date updateDate;
	
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
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
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
	public int getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public int getWeightPer() {
		return weightPer;
	}
	public void setWeightPer(int weightPer) {
		this.weightPer = weightPer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Warehouse [warehouseCode=");
		builder.append(warehouseCode);
		builder.append(", warehouseName=");
		builder.append(warehouseName);
		builder.append(", category1=");
		builder.append(category1);
		builder.append(", category2=");
		builder.append(category2);
		builder.append(", area=");
		builder.append(area);
		builder.append(", loaction=");
		builder.append(loaction);
		builder.append(", outPlace=");
		builder.append(outPlace);
		builder.append(", currentWeight=");
		builder.append(currentWeight);
		builder.append(", maxWeight=");
		builder.append(maxWeight);
		builder.append(", weightPer=");
		builder.append(weightPer);
		builder.append(", status=");
		builder.append(status);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}
} 
