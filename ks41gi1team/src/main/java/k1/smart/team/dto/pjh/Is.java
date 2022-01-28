package k1.smart.team.dto.pjh;


public class Is {
	private String lsAccountCode;
	private String lsAccountName;
	private String lsCategoryCode;
	private String isUse;
	private String isModify;
	private int totalPrice;
	private int totalSales;
	private int SQ1;
	private int SQ2;
	private int SQ3;
	private int SQ4;
	private int PQ1;
	private int PQ2;
	private int PQ3;
	private int PQ4;
	private int EQ1;
	private int EQ2;
	private int EQ3;
	private int EQ4;
	
	
	public int getSQ1() {
		return SQ1;
	}
	public void setSQ1(int sQ1) {
		SQ1 = sQ1;
	}
	public int getSQ2() {
		return SQ2;
	}
	public void setSQ2(int sQ2) {
		SQ2 = sQ2;
	}
	public int getSQ3() {
		return SQ3;
	}
	public void setSQ3(int sQ3) {
		SQ3 = sQ3;
	}
	public int getSQ4() {
		return SQ4;
	}
	public void setSQ4(int sQ4) {
		SQ4 = sQ4;
	}
	public int getPQ1() {
		return PQ1;
	}
	public void setPQ1(int pQ1) {
		PQ1 = pQ1;
	}
	public int getPQ2() {
		return PQ2;
	}
	public void setPQ2(int pQ2) {
		PQ2 = pQ2;
	}
	public int getPQ3() {
		return PQ3;
	}
	public void setPQ3(int pQ3) {
		PQ3 = pQ3;
	}
	public int getPQ4() {
		return PQ4;
	}
	public void setPQ4(int pQ4) {
		PQ4 = pQ4;
	}
	public int getEQ1() {
		return EQ1;
	}
	public void setEQ1(int eQ1) {
		EQ1 = eQ1;
	}
	public int getEQ2() {
		return EQ2;
	}
	public void setEQ2(int eQ2) {
		EQ2 = eQ2;
	}
	public int getEQ3() {
		return EQ3;
	}
	public void setEQ3(int eQ3) {
		EQ3 = eQ3;
	}
	public int getEQ4() {
		return EQ4;
	}
	public void setEQ4(int eQ4) {
		EQ4 = eQ4;
	}
	//비용
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	//매출
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	public String getLsAccountCode() {
		return lsAccountCode;
	}
	public void setLsAccountCode(String lsAccountCode) {
		this.lsAccountCode = lsAccountCode;
	}
	public String getLsAccountName() {
		return lsAccountName;
	}
	public void setLsAccountName(String lsAccountName) {
		this.lsAccountName = lsAccountName;
	}
	public String getLsCategoryCode() {
		return lsCategoryCode;
	}
	public void setLsCategoryCode(String lsCategoryCode) {
		this.lsCategoryCode = lsCategoryCode;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getIsModify() {
		return isModify;
	}
	public void setIsModify(String isModify) {
		this.isModify = isModify;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Is [lsAccountCode=");
		builder.append(lsAccountCode);
		builder.append(", lsAccountName=");
		builder.append(lsAccountName);
		builder.append(", lsCategoryCode=");
		builder.append(lsCategoryCode);
		builder.append(", isUse=");
		builder.append(isUse);
		builder.append(", isModify=");
		builder.append(isModify);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", totalSales=");
		builder.append(totalSales);
		builder.append(", SQ1=");
		builder.append(SQ1);
		builder.append(", SQ2=");
		builder.append(SQ2);
		builder.append(", SQ3=");
		builder.append(SQ3);
		builder.append(", SQ4=");
		builder.append(SQ4);
		builder.append(", PQ1=");
		builder.append(PQ1);
		builder.append(", PQ2=");
		builder.append(PQ2);
		builder.append(", PQ3=");
		builder.append(PQ3);
		builder.append(", PQ4=");
		builder.append(PQ4);
		builder.append(", EQ1=");
		builder.append(EQ1);
		builder.append(", EQ2=");
		builder.append(EQ2);
		builder.append(", EQ3=");
		builder.append(EQ3);
		builder.append(", EQ4=");
		builder.append(EQ4);
		builder.append("]");
		return builder.toString();
	}
	
	
}
