package me.ExpenseEdge.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ExpenseEdge.Member.MemberVo;

@Service
public class  CategoryServiceImpl implements  CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<CategoryVo> categoryList() {
		return categoryDao.categoryList();
	}

	

}
