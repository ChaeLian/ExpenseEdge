package me.ExpenseEdge.Report;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.ExpenseEdge.Member.MemberDao;
import me.ExpenseEdge.Member.MemberVo;

@Repository
public class ReportDaoImpl implements ReportDao {
	
	@Autowired
	private SqlSession sql;
	
	//로그인한 사용자의 report list
	@Override
	public List<ReportVo> reportList(MemberVo memberVo) {
		return sql.selectList("report.reportList", memberVo);
	}
	
	//로그인한 사용자의 승인 대기 중 보고서
	@Override
	public List<ReportVo> reportPend(MemberVo memberVo) {
		return sql.selectList("report.reportPend", memberVo);
	}
	
	//로그인한 사용자가 해당 달에 제출한 보고서 list
	@Override
	public List<ReportVo> reportMonth(Map<String, String> monthValue) {
		return sql.selectList("report.reportMonth", monthValue);
	}
	
	//아이템 등록 전 보고서 선등록
	@Override
	public void unFinishAdd(MemberVo memberVo) {
		sql.insert("report.beforeAdd", memberVo);
		
	}
	
	//등록 중인 보고서가 있는지 확인
	@Override
	public int beforeCount(MemberVo memberVo) {
		return sql.selectOne("report.beforeCount", memberVo);
	}
	
	//등록 중인 보고서
	@Override
	public ReportVo beforeSelect(MemberVo memberVo) {
		return sql.selectOne("report.beforeSelect", memberVo);
	}
	
	
	
	
	
	
}
