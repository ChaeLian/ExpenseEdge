package me.ExpenseEdge.Report;

import java.util.List;
import java.util.Map;

import me.ExpenseEdge.Member.MemberVo;

public interface ReportDao {
	
	//로그인한 사용자의 report list
	List<ReportVo> reportList(MemberVo memberVo);
	//로그인한 사용자의 승인 대기 중 보고서
	List<ReportVo> reportPend(MemberVo memberVo);
	//로그인한 사용자가 해당 달에 제출한 보고서 list
	List<ReportVo> reportMonth(Map<String, String> monthValue);
	
	//아이템 등록 전 보고서 선등록
	void unFinishAdd(MemberVo memberVo);
	//등록 중인 보고서가 있는지 확인
	int beforeCount(MemberVo memberVo);
	//등록 중인 보고서
	ReportVo beforeSelect(MemberVo memberVo);
}
