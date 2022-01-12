package k1.smart.team.dto.csh;

public class UserReg {
	
	//회원가입 요청 UserReg
	private String userRegCode; //회원가입요청코드(PK)
	private String mainBusinessCode; //사업장별 대표코드(FK)
	private String userLevelCode; //회원등급코드(FK)
	private String userId; //아이디
	private String userPw; //비밀번호
	private String userName; //이름
	private String userGender; //성별
	private String userAddr; //주소
	private String userMoblie; //연락처
	private String userEmail; //이메일
	private String userPosition; //직책
	private String userRegDate; //요청일자
	private String userRegStatus; //상태
	private String userRegComment; //비고
	
	//회원레벨
	private int userLevel; //회원레벨
	private String userLevelName; //레벨이름
	
	private String businessName; //사업장이름

	public String getUserRegCode() {
		return userRegCode;
	}

	public void setUserRegCode(String userRegCode) {
		this.userRegCode = userRegCode;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getUserRegDate() {
		return userRegDate;
	}

	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}

	public String getUserRegStatus() {
		return userRegStatus;
	}

	public void setUserRegStatus(String userRegStatus) {
		this.userRegStatus = userRegStatus;
	}

	public String getUserRegComment() {
		return userRegComment;
	}

	public void setUserRegComment(String userRegComment) {
		this.userRegComment = userRegComment;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserLevelName() {
		return userLevelName;
	}

	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserReg [userRegCode=");
		builder.append(userRegCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", userLevelCode=");
		builder.append(userLevelCode);
		builder.append(", userId=");
		builder.append(userId);
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
		builder.append(", userRegDate=");
		builder.append(userRegDate);
		builder.append(", userRegStatus=");
		builder.append(userRegStatus);
		builder.append(", userRegComment=");
		builder.append(userRegComment);
		builder.append(", userLevel=");
		builder.append(userLevel);
		builder.append(", userLevelName=");
		builder.append(userLevelName);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
