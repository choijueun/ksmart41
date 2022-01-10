package k1.smart.team.dto.psb;

public class EtcPurchase {
	private String etcPurchaseCode;
	private String mainBusinessCode;
	private int lsAccountCode;
	private String totalAccountCode;
	private int amount;
	private String dealDate;
	private String reportPoint;
	private String briefs;
	private String regDate;
	private String updateDate;
	public String getEtcPurchaseCode() {
		return etcPurchaseCode;
	}
	public void setEtcPurchaseCode(String etcPurchaseCode) {
		this.etcPurchaseCode = etcPurchaseCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public int getLsAccountCode() {
		return lsAccountCode;
	}
	public void setLsAccountCode(int lsAccountCode) {
		this.lsAccountCode = lsAccountCode;
	}
	public String getTotalAccountCode() {
		return totalAccountCode;
	}
	public void setTotalAccountCode(String totalAccountCode) {
		this.totalAccountCode = totalAccountCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getReportPoint() {
		return reportPoint;
	}
	public void setReportPoint(String reportPoint) {
		this.reportPoint = reportPoint;
	}
	public String getBriefs() {
		return briefs;
	}
	public void setBriefs(String briefs) {
		this.briefs = briefs;
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
		builder.append("EtcPurchase [etcPurchaseCode=");
		builder.append(etcPurchaseCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", lsAccountCode=");
		builder.append(lsAccountCode);
		builder.append(", totalAccountCode=");
		builder.append(totalAccountCode);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", dealDate=");
		builder.append(dealDate);
		builder.append(", reportPoint=");
		builder.append(reportPoint);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}
	
}
