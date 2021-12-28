package k1.smart.team.dto;

public class Member {
	private String userRegCode;
	private String mainBusinessCode;
	private String userLevelCode;
	private String userId;
	private String userPw;
	private String userName;
	private String userGender;
	private String userAddr;
	private String userMoblie;
	private String userEmail;
	private String userPosition;
	private String userRegDate;
	private String userRegStatus;
	private String userRegComment;
	private String joinDate;
	private String updateDate;
	
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
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String regDate) {
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
		builder.append("Member [userRegCode=");
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
		builder.append(", joinDate=");
		builder.append(joinDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append("]");
		return builder.toString();
	}
}
