package k1.smart.team.dto.pjh;

import java.util.Date;

public class Cost {
	private String etcPurchaseCode;
	private String mainBusinessCode;
	private String lsAccountCode; // 계정과목코드
	private String totalAccountCode; //통합회계관리코드
	private int amount; // 총액
	private Date dealDate; //거래일자
	private String reportPoint; //결산시점
	private String briefs;
	private Date regDate;
	private Date updateDate;
	
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
	public String getLsAccountCode() {
		return lsAccountCode;
	}
	public void setLsAccountCode(String lsAccountCode) {
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
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
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
		builder.append("Cost [etcPurchaseCode=");
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
