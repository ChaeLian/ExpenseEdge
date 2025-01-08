package me.ExpenseEdge.Cost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import me.ExpenseEdge.Member.MemberVo;

@RestController
@RequestMapping("/costApi")
@ResponseBody
public class CostApiController {
	
	@Autowired
	private CostService costService;
	
	//로그인한 사용자가 해당 달에 제출한 보고서 list
	@PostMapping("/costList/{categoryId}")
	public String costList( @PathVariable("categoryId") String categoryId){
		List<CostVo> list = costService.costList(categoryId);
		
		//json형태로 변환
		ObjectMapper mapper = new ObjectMapper();
		try {
		    // List 전체를 JSON 문자열로 변환
		    String jsonString = mapper.writeValueAsString(list);
		    //System.out.println(jsonString);
		    return jsonString;
		} catch (JsonProcessingException e) {
		    e.printStackTrace(); // 예외 처리
		    return "에러입니다";
		}
	}

}
