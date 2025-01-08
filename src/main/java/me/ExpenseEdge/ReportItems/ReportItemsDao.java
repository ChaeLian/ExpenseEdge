package me.ExpenseEdge.ReportItems;

import java.util.List;

import me.ExpenseEdge.Report.ReportVo;
import me.ExpenseEdge.ReportItems.reportItemsDTO.ReportItemsDTO;

public interface ReportItemsDao {
	//아이템 저장
	int reportItemsAdd(ReportItemsVo reportItemsVo);
	
	//작성 중인 보고서에 저장 완료 된 item list
	List<ReportItemsDTO> itemList(ReportVo befoReport);
	
	//아이템 삭제
	int itemDel(String itemId);
	
	//아이템 조회
	ReportItemsVo itemSelect(String itemId);

}
