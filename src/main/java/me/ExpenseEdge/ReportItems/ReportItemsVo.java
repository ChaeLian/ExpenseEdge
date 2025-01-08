package me.ExpenseEdge.ReportItems;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class ReportItemsVo {
	//항목이 포함되는 report 고유 ID
	private String reportId;
	//비용 항목 고유 ID
	private String itemId;
	//항목 설명
	private String itemDesc;
	//본인부담금 : 지출비용 - 지원비용
	private int resultAmount;
	//지출비용
	private int amount;
	//비용 추가 날짜
	private Date addAt;
	//비용 수정 날짜
	private Date updateAt;
	//카테고리 정보
	private String costId;
	//영수증 첨부 번호
	private String attachId;
	//비용 항목이 발생한 날짜
	private Date itemDate;
	//삭제 여부
	private String ifDel;
	
	//날짜 수정 전 - flatpickr
	//flatpickr에서 받은 날짜 문자열 LocalDate를 java.util.Date로 변환
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate befoDate;
	
	//multipart/form-data에 포함된 파일을 받는 경우, MultipartFile 타입 사용
	private MultipartFile upFile;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public int getResultAmount() {
		return resultAmount;
	}
	public void setResultAmount(int resultAmount) {
		this.resultAmount = resultAmount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getAddAt() {
		return addAt;
	}
	public void setAddAt(Date addAt) {
		this.addAt = addAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public Date getItemDate() {
		return itemDate;
	}
	public void setItemDate(Date itemDate) {
		this.itemDate = itemDate;
	}
	//setter만 있음
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public void setCostId(String costId) {
		this.costId = costId;
	}
	public String getAttachId() {
		return attachId;
	}
	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}
	public LocalDate getBefoDate() {
		return befoDate;
	}
	public void setBefoDate(LocalDate befoDate) {
		this.befoDate = befoDate;
	}
	public MultipartFile getUpFile() {
		return upFile;
	}
	public void setUpFile(MultipartFile upFile) {
		this.upFile = upFile;
	}
	public String getIfDel() {
		return ifDel;
	}
	public void setIfDel(String ifDel) {
		this.ifDel = ifDel;
	}
	

}
