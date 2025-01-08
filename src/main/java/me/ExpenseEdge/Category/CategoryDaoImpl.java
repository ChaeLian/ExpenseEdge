package me.ExpenseEdge.Category;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.ExpenseEdge.Member.MemberDao;
import me.ExpenseEdge.Member.MemberVo;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SqlSession sql;

	@Override
	public List<CategoryVo> categoryList() {
		return sql.selectList("category.categoryList");
	}
	
	
}
