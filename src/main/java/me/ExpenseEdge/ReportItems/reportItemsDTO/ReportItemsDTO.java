package me.ExpenseEdge.ReportItems.reportItemsDTO;

import me.ExpenseEdge.Cost.CostVo;
import me.ExpenseEdge.Receipt.ReceiptVo;
import me.ExpenseEdge.ReportItems.ReportItemsVo;

public class ReportItemsDTO {
	private ReportItemsVo reportItemsVo;
	private CostVo costVo;
	private ReceiptVo receiptVo;
	public ReportItemsVo getReportItemsVo() {
		return reportItemsVo;
	}
	public void setReportItemsVo(ReportItemsVo reportItemsVo) {
		this.reportItemsVo = reportItemsVo;
	}
	public CostVo getCostVo() {
		return costVo;
	}
	public void setCostVo(CostVo costVo) {
		this.costVo = costVo;
	}
	public ReceiptVo getReceiptVo() {
		return receiptVo;
	}
	public void setReceiptVo(ReceiptVo receiptVo) {
		this.receiptVo = receiptVo;
	}
}
