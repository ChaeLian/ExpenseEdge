package me.ExpenseEdge.Cost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ExpenseEdge.Member.MemberVo;

@Service
public class  CostServiceImpl implements  CostService {
	
	@Autowired
	private CostDao costDao;


	@Override
	public List<CostVo> costList(String categoryId) {
		return costDao.costList(categoryId);
	}

	

}
