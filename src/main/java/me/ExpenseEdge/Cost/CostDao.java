package me.ExpenseEdge.Cost;

import java.util.List;

public interface CostDao {
	
	List<CostVo> costList(String categoryId);

}
