package me.ExpenseEdge.ReportItems;

import java.io.File;
import java.util.List;

import me.ExpenseEdge.Cost.CostVo;
import me.ExpenseEdge.Member.MemberVo;
import me.ExpenseEdge.Receipt.ReceiptVo;
import me.ExpenseEdge.ReportItems.reportItemsDTO.ReportItemsDTO;

public interface ReportItemsService{
	//item 저장
	int reportItemsAdd(MemberVo memberVo, ReportItemsVo reportItemsVo);
	
	//작성 중인 보고서에 저장 완료 된 item list
	List<ReportItemsDTO> itemList(MemberVo memberVo);
	
	//아이템 삭제
	int itemDel(String itemId);
	
	//비용항목 수정
	int itemUpdate(ReportItemsVo reportItemsVo);
	
}
