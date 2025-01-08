package me.ExpenseEdge.Report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ExpenseEdge.Member.MemberVo;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
	//로그인한 사용자의 report list
	@Override
	public List<ReportVo> reportList(MemberVo memberVo) {
		return reportDao.reportList(memberVo);
	}
	
	//로그인한 사용자의 승인 대기 중 보고서
	@Override
	public List<ReportVo> reportPend(MemberVo memberVo) {
		return reportDao.reportPend(memberVo);
	}
	
	//로그인한 사용자가 해당 달에 제출한 보고서 list
	@Override
	public List<ReportVo> reportMonth(MemberVo memberVo, String mon) {
		Map<String, String> monthValue = new HashMap<String, String>();
		monthValue.put("loginId", memberVo.getLoginId());
		monthValue.put("mon", mon);
		
		return reportDao.reportMonth(monthValue);
	}

}
