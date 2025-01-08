package me.ExpenseEdge.Receipt;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReceiptDaoImpl implements ReceiptDao {
	
	@Autowired
	private SqlSession sql;
	
	//첨부파일 저장
	@Override
	public void add(ReceiptVo receiptVo) {
		sql.insert("receipt.receiptAdd", receiptVo);
	}
	
	//첨부파일 조회
	@Override
	public ReceiptVo receiptSelect(String attachId) {
		return sql.selectOne("receipt.receiptSelect", attachId);
	}
	
	//첨부파일 삭제
	@Override
	public void attachDel(String attachId) {
		sql.update("receipt.attachDel", attachId);
	}

}
