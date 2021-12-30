package k1.smart.team.dto.csh;

public class Client {
	private String clientCode; //거래처 대표코드
	private String mainBusinessCode; //사업장별 대표코드
	private String businessCategory; //거래처 구분 코드
	private String userId; //거래처 대표아이디
	private String businessName; //상호
	private String businessRepresentative; //대표자명
	private String businessType1; //업종
	private String businessType2; //업태
	private String businessNum; //사업자번호
	private int businessCount; //종사업장번호
	private String businessMobile; //연락처
	private String businessPlace; //소재지
	private String businessEmail; //이메일
	private String regDate; //등록일시
	private String updateDate; //수정일시
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getMainBusinessCode() {
		return mainBusinessCode;
	}
	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}
	public String getBusinessCategory() {
		return businessCategory;
	}
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessRepresentative() {
		return businessRepresentative;
	}
	public void setBusinessRepresentative(String businessRepresentative) {
		this.businessRepresentative = businessRepresentative;
	}
	public String getBusinessType1() {
		return businessType1;
	}
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}
	public String getBusinessType2() {
		return businessType2;
	}
	public void setBusinessType2(String businessType2) {
		this.businessType2 = businessType2;
	}
	public String getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}
	public int getBusinessCount() {
		return businessCount;
	}
	public void setBusinessCount(int businessCount) {
		this.businessCount = businessCount;
	}
	public String getBusinessMobile() {
		return businessMobile;
	}
	public void setBusinessMobile(String businessMobile) {
		this.businessMobile = businessMobile;
	}
	public String getBusinessPlace() {
		return businessPlace;
	}
	public void setBusinessPlace(String businessPlace) {
		this.businessPlace = businessPlace;
	}
	public String getBusinessEmail() {
		return businessEmail;
	}
	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
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
		builder.append("Client [clientCode=");
		builder.append(clientCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", businessCategory=");
		builder.append(businessCategory);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", businessRepresentative=");
		builder.append(businessRepresentative);
		builder.append(", businessType1=");
		builder.append(businessType1);
		builder.append(", businessType2=");
		builder.append(businessType2);
		builder.append(", businessNum=");
		builder.append(businessNum);
		builder.append(", businessCount=");
		builder.append(businessCount);
		builder.append(", businessMobile=");
		builder.append(businessMobile);
		builder.append(", businessPlace=");
		builder.append(businessPlace);
		builder.append(", businessEmail=");
		builder.append(businessEmail);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
