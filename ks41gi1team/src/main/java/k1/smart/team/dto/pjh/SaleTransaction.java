package k1.smart.team.dto.pjh;

public class SaleTransaction {
	private String salesTsCode;
	private String clientCode;
	private int amount;
	private int VAT;
	private int totalPrice;
	private String briefs;
	public String getSalesTsCode() {
		return salesTsCode;
	}
	public void setSalesTsCode(String salesTsCode) {
		this.salesTsCode = salesTsCode;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getVAT() {
		return VAT;
	}
	public void setVAT(int vAT) {
		VAT = vAT;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getBriefs() {
		return briefs;
	}
	public void setBriefs(String briefs) {
		this.briefs = briefs;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SaleTransaction [salesTsCode=");
		builder.append(salesTsCode);
		builder.append(", clientCode=");
		builder.append(clientCode);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", VAT=");
		builder.append(VAT);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", briefs=");
		builder.append(briefs);
		builder.append("]");
		return builder.toString();
	}
	
	
}
