package me.ExpenseEdge.Receipt;

public class ReceiptVo {
	//영수증 첨부 시, 고유 ID
	private String attachId;
	//첨부파일의 원래 이름
	private String attachOrgName;
	//첨부파일의 수정된 이름
	private String attachNewName;
	//삭제여부
	private String ifDel;
	
	public String getAttachId() {
		return attachId;
	}
	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}
	public String getAttachOrgName() {
		return attachOrgName;
	}
	public void setAttachOrgName(String attachOrgName) {
		this.attachOrgName = attachOrgName;
	}
	public String getAttachNewName() {
		return attachNewName;
	}
	public void setAttachNewName(String attachNewName) {
		this.attachNewName = attachNewName;
	}
	public String getIfDel() {
		return ifDel;
	}
	public void setIfDel(String ifDel) {
		this.ifDel = ifDel;
	}
}
