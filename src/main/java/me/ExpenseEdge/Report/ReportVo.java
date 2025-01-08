package me.ExpenseEdge.Report;

import java.util.Date;

import me.ExpenseEdge.Member.MemberVo;

public class ReportVo extends MemberVo{
	//보고서 고유 ID
	private String reportId;
    //보고서 제출 날짜
    private Date reportDate;
    //환급액
    private Integer totalAmount;
    //제출한 보고서 상태
    private String reportStatus;
    //승인 대기 여부
    private String ifEnd;
    //삭제 여부
    private String ifDel;
    //작성 완료 여부
    private String ifFinish;
    //로그인
    private String loginId;
    
    
    //Getter & Setter
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
	public String getIfEnd() {
		return ifEnd;
	}
	public void setIfEnd(String ifEnd) {
		this.ifEnd = ifEnd;
	}
	public String getIfDel() {
		return ifDel;
	}
	public void setIfDel(String ifDel) {
		this.ifDel = ifDel;
	}
	public String getIfFinish() {
		return ifFinish;
	}
	public void setIfFinish(String ifFinish) {
		this.ifFinish = ifFinish;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
