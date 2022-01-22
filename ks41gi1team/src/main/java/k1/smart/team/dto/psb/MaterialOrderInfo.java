package k1.smart.team.dto.psb;

public class MaterialOrderInfo {
	private String materialOrderOngoingCode;
	private String orderCode;
	private String itemCode;
	private String itemName;
	private int itemCount;
	private int itemPrice;
	private int totalPrice;
	private String realReceiveDate;
	private String reserveStatus;
	private String comment;
	
	public String getMaterialOrderOngoingCode() {
		return materialOrderOngoingCode;
	}
	public void setMaterialOrderOngoingCode(String materialOrderOngoingCode) {
		this.materialOrderOngoingCode = materialOrderOngoingCode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
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
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getRealReceiveDate() {
		return realReceiveDate;
	}
	public void setRealReceiveDate(String realReceiveDate) {
		this.realReceiveDate = realReceiveDate;
	}
	public String getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MaterialOrderInfo [materialOrderOngoingCode=");
		builder.append(materialOrderOngoingCode);
		builder.append(", orderCode=");
		builder.append(orderCode);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", itemCount=");
		builder.append(itemCount);
		builder.append(", itemPrice=");
		builder.append(itemPrice);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", realReceiveDate=");
		builder.append(realReceiveDate);
		builder.append(", reserveStatus=");
		builder.append(reserveStatus);
		builder.append(", comment=");
		builder.append(comment);
		builder.append("]");
		return builder.toString();
	}
}
