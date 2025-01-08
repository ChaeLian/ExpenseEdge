package me.ExpenseEdge.Cost;

import me.ExpenseEdge.Category.CategoryVo;

public class CostVo extends CategoryVo{
	//고유 ID
	private String costId;
	//상세 항목 이름
	private String costName;
	//최대 지원 비용
	private int maxAmount;
	
	public String getCostId() {
		return costId;
	}
	public void setCostId(String costId) {
		this.costId = costId;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public int getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}
	
	
}
