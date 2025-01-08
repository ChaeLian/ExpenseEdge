package me.ExpenseEdge.ReportItems;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.ExpenseEdge.Report.ReportVo;
import me.ExpenseEdge.ReportItems.reportItemsDTO.ReportItemsDTO;

@Repository
public class ReportItemsDaoImpl implements ReportItemsDao {
	
	@Autowired
	private SqlSession sql;
	
	//보고서 아이템 등록
	@Override
	public int reportItemsAdd(ReportItemsVo reportItemsVo) {
		return sql.insert("reportItems.reportItemsAdd", reportItemsVo);
	}
	
	//작성 중인 보고서에 저장 완료 된 item list
	@Override
	public List<ReportItemsDTO> itemList(ReportVo befoReport) {
		return sql.selectList("reportItems.itemList", befoReport);
	}
	
	//아이템 삭제
	@Override
	public int itemDel(String itemId) {
		return sql.update("reportItems.itemDel", itemId);
	}
	
	//아이템 조회
	@Override
	public ReportItemsVo itemSelect(String itemId) {
		return sql.selectOne("reportItems.itemSelect", itemId);
	}
	
	
	
	
	
}
