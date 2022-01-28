package k1.smart.team.dto.psb;

public class MaterialOrder {
	private String materialOrderCode;
	private String materialOrderOngoingCode;
	private String itemCode;
	private int itemCount;
	private int itemPrice;
	private String realReceiveDate;
	private String reserveStatus;
	private String comment;
	private String mainBusinessCode;
	private String contractCode;
	private String clientCode;
	private int totalCount;
	private int totalPrice;
	private String orderDate;
	private String predictDate;
	private String status;
	private String briefs;
	private String managerId;
	private String regDate;
	private String updateDate;
	private String itemName;
	private String businessName;
	private String userName;
	private String clientBusinessName;
	private String managerName;
	public String getMaterialOrderCode() {
		return materialOrderCode;
	}
	public void setMaterialOrderCode(String materialOrderCode) {
		this.materialOrderCode = materialOrderCode;
	}
	public String getMaterialOrderOngoingCode() {
		return materialOrderOngoingCode;
	}
	public void setMaterialOrderOngoingCode(String materialOrderOngoingCode) {
		this.materialOrderOngoingCode = materialOrderOngoingCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPredictDate() {
		return predictDate;
	}
	public void setPredictDate(String predictDate) {
		this.predictDate = predictDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getClientBusinessName() {
		return clientBusinessName;
	}
	public void setClientBusinessName(String clientBusinessName) {
		this.clientBusinessName = clientBusinessName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((briefs == null) ? 0 : briefs.hashCode());
		result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
		result = prime * result + ((clientBusinessName == null) ? 0 : clientBusinessName.hashCode());
		result = prime * result + ((clientCode == null) ? 0 : clientCode.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((contractCode == null) ? 0 : contractCode.hashCode());
		result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
		result = prime * result + itemCount;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + itemPrice;
		result = prime * result + ((mainBusinessCode == null) ? 0 : mainBusinessCode.hashCode());
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result + ((materialOrderCode == null) ? 0 : materialOrderCode.hashCode());
		result = prime * result + ((materialOrderOngoingCode == null) ? 0 : materialOrderOngoingCode.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((predictDate == null) ? 0 : predictDate.hashCode());
		result = prime * result + ((realReceiveDate == null) ? 0 : realReceiveDate.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((reserveStatus == null) ? 0 : reserveStatus.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + totalCount;
		result = prime * result + totalPrice;
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		MaterialOrder other = (MaterialOrder) obj;
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
		if (clientBusinessName == null) {
			if (other.clientBusinessName != null)
				return false;
		} else if (!clientBusinessName.equals(other.clientBusinessName))
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
		if (itemCode == null) {
			if (other.itemCode != null)
				return false;
		} else if (!itemCode.equals(other.itemCode))
			return false;
		if (itemCount != other.itemCount)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemPrice != other.itemPrice)
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
		if (materialOrderOngoingCode == null) {
			if (other.materialOrderOngoingCode != null)
				return false;
		} else if (!materialOrderOngoingCode.equals(other.materialOrderOngoingCode))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (predictDate == null) {
			if (other.predictDate != null)
				return false;
		} else if (!predictDate.equals(other.predictDate))
			return false;
		if (realReceiveDate == null) {
			if (other.realReceiveDate != null)
				return false;
		} else if (!realReceiveDate.equals(other.realReceiveDate))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (reserveStatus == null) {
			if (other.reserveStatus != null)
				return false;
		} else if (!reserveStatus.equals(other.reserveStatus))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalCount != other.totalCount)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
	
	
	
	
}
