package me.ExpenseEdge.Cost;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.ExpenseEdge.Member.MemberDao;
import me.ExpenseEdge.Member.MemberVo;

@Repository
public class CostDaoImpl implements CostDao {
	
	@Autowired
	private SqlSession sql;

	@Override
	public List<CostVo> costList(String categoryId) {
		return sql.selectList("cost.costList", categoryId);
	}
}
