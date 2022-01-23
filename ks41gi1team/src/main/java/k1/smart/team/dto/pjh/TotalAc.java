package k1.smart.team.dto.pjh;

public class TotalAc {
	private String codes;
	private String mainBusinessCode;
	private String accountingCode;
	private String salesSection;
	private String briefs;
	private String regDate;
	private String updateDate;
	private int totalPrice;
	public String getCodes() {
		return codes;
	}
	public void setCodes(String codes) {
		this.codes = codes;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getAccountingCode() {
		return accountingCode;
	}
	public void setAccountingCode(String accountingCode) {
		this.accountingCode = accountingCode;
	}
	public String getSalesSection() {
		return salesSection;
	}
	public void setSalesSection(String salesSection) {
		this.salesSection = salesSection;
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
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalAc [codes=");
		builder.append(codes);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", accountingCode=");
		builder.append(accountingCode);
		builder.append(", salesSection=");
		builder.append(salesSection);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append("]");
		return builder.toString();
	}

}
