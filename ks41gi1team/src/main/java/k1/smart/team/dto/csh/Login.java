package k1.smart.team.dto.csh;

public class Login {
	private String loginCode; //로그인 코드
	private String mainBusinessCode; //사업장별 대표코드
	private String loginId; //로그인아이디
	private String loginDate; //로그인 일자
	private String logoutDate; //로그아웃 일자
	
	//사업장 이름
	private String businessName;//사업장이름

	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}

	public String getMainBusinessCode() {
		return mainBusinessCode;
	}

	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(String logoutDate) {
		this.logoutDate = logoutDate;
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
		builder.append("Login [loginCode=");
		builder.append(loginCode);
		builder.append(", mainBusinessCode=");
		builder.append(mainBusinessCode);
		builder.append(", loginId=");
		builder.append(loginId);
		builder.append(", loginDate=");
		builder.append(loginDate);
		builder.append(", logoutDate=");
		builder.append(logoutDate);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	

}
