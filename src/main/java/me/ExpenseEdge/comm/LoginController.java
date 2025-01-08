package me.ExpenseEdge.comm;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.ExpenseEdge.Member.MemberSerivce;
import me.ExpenseEdge.Member.MemberVo;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private MemberSerivce memberService;
	
	@GetMapping("/login")
	public String loginForm() {
		return "login/loginForm";
	}
	
	@PostMapping("/login")
	public String login(MemberVo memberVo, HttpSession session){
		MemberVo mem = memberService.selectMember(memberVo.getLoginId());
		
		//로그인Id가 있는 경우
		if(mem != null && mem.getLoginId() != null && !mem.getLoginId().equals("")) {
			if(memberVo.getLoginPassword().equals(mem.getLoginPassword())) {
				session.setAttribute("loginUser", mem);
				System.out.println(mem.getLoginId());
				return "redirect:/";				
			}else {
				return "redirect:/login/login";
			}
		}else {
			return "redirect:/login/login";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/login";
	}
	
}
