package me.ExpenseEdge.Cost;

import java.util.List;

public interface CostService {
	
	List<CostVo> costList(String categoryId);
}
