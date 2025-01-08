package me.ExpenseEdge.Member;

import me.ExpenseEdge.Department.DepartmentVo;

public class MemberVo extends DepartmentVo{
	//고유ID
	private String memberId;
	//이름
	private String memberName;
	//전화번호
	private String memberPhone;
	//주소 고유 ID
	private String address;
	//로그인 아이디
	private String loginId;
	//로그인 비밀번호
	private String loginPassword;
	//비밀번호 힌트
	private String passwordHint;
	//비밀번호 정답
	private String passwordCnsr;
	//이메일 추가할 것
	private String email;
	//이메일Id
	private String emailId;
	//이메일도메인
	private String emailDomain;
	//로그인타입
	private String loginType;
	//가입일자
	private java.util.Date addAt;
	//관리자 여부
	private String ifAdmin;
	//탈퇴회원 여부
	private String ifDel;
	//부서+직급
	private String deptId;
	//
	//약관동의 - 이용약관
	private String agree01;
	//약관동의 - 개인정보 수집
	private String agree02;
	//약관동의 - 개인정보 제3자제공
	private String agree03;
	//
	// Getter & Setter
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	public String getPasswordCnsr() {
		return passwordCnsr;
	}
	public void setPasswordCnsr(String passwordCnsr) {
		this.passwordCnsr = passwordCnsr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public java.util.Date getAddAt() {
		return addAt;
	}
	public void setAddAt(java.util.Date addAt) {
		this.addAt = addAt;
	}
	public String getIfAdmin() {
		return ifAdmin;
	}
	public void setIfAdmin(String ifAdmin) {
		this.ifAdmin = ifAdmin;
	}
	public String getIfDel() {
		return ifDel;
	}
	public void setIfDel(String ifDel) {
		this.ifDel = ifDel;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getAgree01() {
		return agree01;
	}
	public void setAgree01(String agree01) {
		this.agree01 = agree01;
	}
	public String getAgree02() {
		return agree02;
	}
	public void setAgree02(String agree02) {
		this.agree02 = agree02;
	}
	public String getAgree03() {
		return agree03;
	}
	public void setAgree03(String agree03) {
		this.agree03 = agree03;
	}
}
