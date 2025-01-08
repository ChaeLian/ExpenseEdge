package me.ExpenseEdge.ReportItems;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import me.ExpenseEdge.Cost.CostVo;
import me.ExpenseEdge.Member.MemberVo;
import me.ExpenseEdge.Receipt.ReceiptVo;
import me.ExpenseEdge.Report.ReportVo;
import me.ExpenseEdge.ReportItems.reportItemsDTO.ReportItemsDTO;

@RestController
@RequestMapping("/reportItemsApi")
@ResponseBody
public class ReportItemsApiController {
	
	@Autowired
	private ReportItemsService reportItemsService;
	
	//비용항목 추가
	@PostMapping("/add")
	public String add(@SessionAttribute("loginUser") MemberVo memberVo, ReportItemsVo reportItemsVo) {
		reportItemsVo.setReportId(memberVo.getMemberId());
		
		//LocalDate를 java.util.Date로 변환
		LocalDate local = reportItemsVo.getBefoDate();
		System.out.println(local);
		
		Date date = java.sql.Date.valueOf(local);
		System.out.println(date);
		
		reportItemsVo.setItemDate(date);
		
		reportItemsService.reportItemsAdd(memberVo, reportItemsVo);
		System.out.println(memberVo.getLoginId());
		
		return "controller 완료!";
	}
	
	//비용항목 조회
	@PostMapping("/itemList")
	public List<ReportItemsDTO> itemList(@SessionAttribute("loginUser") MemberVo memberVo) {
		List<ReportItemsDTO> list = reportItemsService.itemList(memberVo);
		
		return list;
	}
	
	//비용항목 삭제
	@GetMapping("/reportItemsApi/del/{itemId}")
	public int itemDel(@PathVariable("itemId") String itemId) {
		int num = reportItemsService.itemDel(itemId);
		return num;
	}
	
	//비용항목 수정
	

}
