package me.ExpenseEdge.Report;

import java.util.List;

import me.ExpenseEdge.Member.MemberVo;

public interface ReportService {

	//로그인한 사용자의 report list
	List<ReportVo> reportList(MemberVo memberVo);
	//로그인한 사용자의 승인 대기 중 보고서
	List<ReportVo> reportPend(MemberVo memberVo);
	//로그인한 사용자가 해당 달에 제출한 보고서 list
	List<ReportVo> reportMonth(MemberVo memberVo, String mon);

}
