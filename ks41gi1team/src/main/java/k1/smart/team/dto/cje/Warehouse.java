package k1.smart.team.dto.cje;

public class Warehouse {
	private String warehouseCode; //창고코드
	private String mainBusinessCode; //사업장별 대표코드
	private String warehouseName; //창고명
	
	private String category1; //분류 - 일반 냉장 냉동
	private String category2; //유형 - 재고 출하
	
	private int area; //면적
	private String location; //위치
	private String outPlace; //외부소재지
	
	private int currentWeight; //현재 적재중량
	private int maxWeight; //최대 적재중량
	private int weightPer; //현재 적재현황
	
	private String status; //창고상태
	private String regDate; //등록일시
	private String updateDate; //수정일시
	
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
		builder.append("Warehouse [warehouseCode=");
		builder.append(warehouseCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", warehouseName=");
		builder.append(warehouseName);
		builder.append(", category1=");
		builder.append(category1);
		builder.append(", category2=");
		builder.append(category2);
		builder.append(", area=");
		builder.append(area);
		builder.append(", location=");
		builder.append(location);
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
