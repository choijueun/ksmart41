package k1.smart.team.dto.csh;

public class MainBusiness {
	private String mainBusinessCode; //사업장별 대표코드(PK)
	private String businessCategory; //사업장 구분 코드(FK)
	private String businessLevel; //사업장 권한(FK)
	private String businessName; //상호
	private String businessRepresentative; //대표자명
	private String businessType1; //업종
	private String businessType2; //업태
	private String businessNum; //사업자번호
	private int businessCount; //종사업장번호
	private String businessMobile; //연락처
	private String businessPlace; //소재지
	private String businessEmail; //이메일
	private String openDate; //개업년월일
	private String joinDate; //플랫폼 가입일시
	private String updateDate; //수정일시
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
	public String getBusinessLevel() {
		return businessLevel;
	}
	public void setBusinessLevel(String businessLevel) {
		this.businessLevel = businessLevel;
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
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
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
		builder.append("Business [mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", businessCategory=");
		builder.append(businessCategory);
		builder.append(", businessLevel=");
		builder.append(businessLevel);
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
		builder.append(", openDate=");
		builder.append(openDate);
		builder.append(", joinDate=");
		builder.append(joinDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}
	

}
