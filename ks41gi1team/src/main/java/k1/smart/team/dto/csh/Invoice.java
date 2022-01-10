package k1.smart.team.dto.csh;

public class Invoice {
	private String businessName; //사업장 이름
	private String invoiceCode; //전자(세금)계산서 코드
	private String mainBusinessCode; //사업장별 대표코드
	private String invoiceType; //세금계산서 종류
	private String supplyBusinessCode; //공급자 사업장 대표코드
	private String supplyManagerId; //공급담당자
	private String demandBusinessCode; //수급자 사업장 대표코드
	private String demandManagerId; //수급담당자
	private int invoicePrice; //전체공급가액
	private int invoiceTax; //전체세액
	private int totalPrice; //전체금액
	private String issueStatus; //발행상태
	private String payMethod; //지불방식
	private String invoiceConfirm; //영수/청구
	private String briefs; //적요
	private String issueDate; //발행일자
	private String regDate; //등록일시
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getSupplyBusinessCode() {
		return supplyBusinessCode;
	}
	public void setSupplyBusinessCode(String supplyBusinessCode) {
		this.supplyBusinessCode = supplyBusinessCode;
	}
	public String getSupplyManagerId() {
		return supplyManagerId;
	}
	public void setSupplyManagerId(String supplyManagerId) {
		this.supplyManagerId = supplyManagerId;
	}
	public String getDemandBusinessCode() {
		return demandBusinessCode;
	}
	public void setDemandBusinessCode(String demandBusinessCode) {
		this.demandBusinessCode = demandBusinessCode;
	}
	public String getDemandManagerId() {
		return demandManagerId;
	}
	public void setDemandManagerId(String demandManagerId) {
		this.demandManagerId = demandManagerId;
	}
	public int getInvoicePrice() {
		return invoicePrice;
	}
	public void setInvoicePrice(int invoicePrice) {
		this.invoicePrice = invoicePrice;
	}
	public int getInvoiceTax() {
		return invoiceTax;
	}
	public void setInvoiceTax(int invoiceTax) {
		this.invoiceTax = invoiceTax;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getInvoiceConfirm() {
		return invoiceConfirm;
	}
	public void setInvoiceConfirm(String invoiceConfirm) {
		this.invoiceConfirm = invoiceConfirm;
	}
	public String getBriefs() {
		return briefs;
	}
	public void setBriefs(String briefs) {
		this.briefs = briefs;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Invoice [businessName=");
		builder.append(businessName);
		builder.append(", invoiceCode=");
		builder.append(invoiceCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", invoiceType=");
		builder.append(invoiceType);
		builder.append(", supplyBusinessCode=");
		builder.append(supplyBusinessCode);
		builder.append(", supplyManagerId=");
		builder.append(supplyManagerId);
		builder.append(", demandBusinessCode=");
		builder.append(demandBusinessCode);
		builder.append(", demandManagerId=");
		builder.append(demandManagerId);
		builder.append(", invoicePrice=");
		builder.append(invoicePrice);
		builder.append(", invoiceTax=");
		builder.append(invoiceTax);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", issueStatus=");
		builder.append(issueStatus);
		builder.append(", payMethod=");
		builder.append(payMethod);
		builder.append(", invoiceConfirm=");
		builder.append(invoiceConfirm);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append(", issueDate=");
		builder.append(issueDate);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append("]");
		return builder.toString();
	}
	

}
