package me.ExpenseEdge.Receipt;

import java.io.File;
import java.util.List;

import me.ExpenseEdge.Cost.CostVo;
import me.ExpenseEdge.Member.MemberVo;
import me.ExpenseEdge.Receipt.ReceiptVo;
import me.ExpenseEdge.ReportItems.reportItemsDTO.ReportItemsDTO;

public interface ReceiptService{
	//첨부파일 정보 가져오기
	ReceiptVo receiptSelect(String attachId);
	
	//첨부파일 가져오기
	File getReceiptFile(String attachNewName);
	

}
