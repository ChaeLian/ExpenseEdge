package me.ExpenseEdge.comm;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import me.ExpenseEdge.Member.MemberVo;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String mainForm(HttpSession session ,Model model) {
		MemberVo memberVo = (MemberVo) session.getAttribute("loginUser");
		if(memberVo != null) {
			//로그인되었을 경우
			model.addAttribute("loginUser", memberVo);
		}
		return "main";
	}
	
}
