package me.ExpenseEdge.Report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import me.ExpenseEdge.Member.MemberVo;

@Controller
@RequestMapping("/report")
public class ReportController {
	private String path = "report/";
	
	@Autowired
	private ReportService reportService;
	
	//로그인한 사용자의 보고서 list
	@GetMapping("/list")
	public String listForm(@SessionAttribute("loginUser") MemberVo memberVo, Model model) {
		
		//승인 대기 중 보고서
		List<ReportVo> pend = reportService.reportPend(memberVo);
		model.addAttribute("pend", pend);
		
		//사용자인 경우
		if("N".equals(memberVo.getIfAdmin())) {
			//승인 대기 상태 외 모든 보고서 list 
			List<ReportVo> list =  reportService.reportList(memberVo);	
			model.addAttribute("list", list);
			return path + "listForm";
		}	
		//관리자인 경우
		return path + "admin/listAdmin";
	}

}
