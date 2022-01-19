package k1.smart.team.dto.csh;

public class User {
	private String userId; //회원아이디(PK)
	private String mainBusinessCode; //사업장별 대표코드(FK)
	private String userLevelCode; //회원등급코드(FK)
	private String userPw; //비밀번호
	private String userName; //이름
	private String userGender; //성별
	private String userAddr; //주소
	private String userMoblie; //연락처
	private String userEmail; //이메일
	private String userPosition; //직책
	private String regDate; //등록일시
	private String updateDate; //수정일시
	
	//사업장
	private String businessName; //사업장 이름
	
	//회원등급
	private String userLevelName;  //회원등급

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMainBusinessCode() {
		return mainBusinessCode;
	}

	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}

	public String getUserLevelCode() {
		return userLevelCode;
	}

	public void setUserLevelCode(String userLevelCode) {
		this.userLevelCode = userLevelCode;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserMoblie() {
		return userMoblie;
	}

	public void setUserMoblie(String userMoblie) {
		this.userMoblie = userMoblie;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
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

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getUserLevelName() {
		return userLevelName;
	}

	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", userLevelCode=");
		builder.append(userLevelCode);
		builder.append(", userPw=");
		builder.append(userPw);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userGender=");
		builder.append(userGender);
		builder.append(", userAddr=");
		builder.append(userAddr);
		builder.append(", userMoblie=");
		builder.append(userMoblie);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", userPosition=");
		builder.append(userPosition);
		builder.append(", regDate=");
		builder.append(regDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", userLevelName=");
		builder.append(userLevelName);
		builder.append("]");
		return builder.toString();
	}
	
	

	
	

}
