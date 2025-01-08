package me.ExpenseEdge.Receipt;

public interface ReceiptDao {
	//첨부파일 저장
	void add(ReceiptVo receiptVo);

	//첨부파일 조회
	ReceiptVo receiptSelect(String attachId);
	
	//첨부파일 삭제
	void attachDel(String attachId);

}
