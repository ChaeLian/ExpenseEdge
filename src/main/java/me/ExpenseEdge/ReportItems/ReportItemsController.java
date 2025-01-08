package me.ExpenseEdge.ReportItems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import me.ExpenseEdge.Category.CategoryService;
import me.ExpenseEdge.Category.CategoryVo;
import me.ExpenseEdge.Cost.CostVo;
import me.ExpenseEdge.Member.MemberVo;
import me.ExpenseEdge.Receipt.ReceiptVo;

@Controller
@RequestMapping("/reportItems")
public class ReportItemsController {
	
	@Autowired
	private ReportItemsService reportItemsService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/itemList")
	public String checkListForm(Model model) {
		return "/reportItems/itemList";
	}
	
	//비용항목 추가 폼
	@GetMapping("/add")
	public String addForm(Model model) {
		List<CategoryVo> category = categoryService.categoryList();
		model.addAttribute("categoryList", category);
		return "/reportItems/addForm";
	}
	
}
