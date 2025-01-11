package me.ExpenseEdge.ReportItems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import me.ExpenseEdge.Receipt.ReceiptService;
import me.ExpenseEdge.Receipt.ReceiptVo;
import me.ExpenseEdge.Report.ReportVo;
import me.ExpenseEdge.ReportItems.reportItemsDTO.ReportItemsDTO;

@RestController
@RequestMapping("/reportItemsApi")
@ResponseBody
public class ReportItemsApiController {
	
	@Autowired
	private ReportItemsService reportItemsService;
	
	@Autowired
	private ReceiptService receiptService;
	
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
	@GetMapping("/del/{itemId}")
	public int itemDel(@PathVariable("itemId") String itemId) {
		int num = reportItemsService.itemDel(itemId);
		return num;
	}
	
	//비용항목 수정
	@PatchMapping("/update/{itemId}")
	public int itemUpdate(@PathVariable("itemId") String itemId, ReportItemsVo changeVo) {
		int num = reportItemsService.itemUpdate(changeVo);
		System.out.println(changeVo.getItemId());
		return num;
	}
	
	
	//첨부파일 미리보기
	@GetMapping("/previewShow/{attachId}")
	public void previewShow(@PathVariable("attachId") String attachId, HttpServletResponse resp) throws IOException {
		// 첨부파일 정보를 조회
	    ReceiptVo receiptVo = receiptService.receiptSelect(attachId);

	    // 저장한 경로에서 파일 가져오기
	    File file = receiptService.getReceiptFile(receiptVo.getAttachNewName());

	    if (!file.exists()) {
	        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
	        return;
	    }

	    // 첨부파일의 MIME 타입 설정 (파일 확장자에 따라 다름)
	    String mimeType = Files.probeContentType(file.toPath());
	    if (mimeType == null) {
	        mimeType = "application/octet-stream"; // 기본 MIME 타입
	    }
	    resp.setContentType(mimeType);

	    // 브라우저에서 직접 열리도록 Content-Disposition 헤더 제거
	    // 또는 필요에 따라 inline으로 설정
	    resp.setHeader("Content-Disposition", "inline; filename=\"" + receiptVo.getAttachOrgName() + "\"");

	    // 첨부파일의 내용을 응답 객체에 쓰기
	    FileCopyUtils.copy(new FileInputStream(file), resp.getOutputStream());
	}

	
	//첨부파일 다운로드
		@GetMapping("/fileDown/{attachId}")
		public void fileDown(@PathVariable("attachId") String attachId, HttpServletResponse resp) throws FileNotFoundException, IOException {
			//첨부파일 정보를 조회
			ReceiptVo receiptVo = receiptService.receiptSelect(attachId);
			
			//저장한 경로에서 파일형태로 첨부파일 가져오기
			File file = receiptService.getReceiptFile(receiptVo.getAttachNewName());
			
			if (!file.exists()) {
	            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
	            return;
	        }
			
			//어떤 형식의 파일이든지 무조건 다운로드 되도록 설정
			resp.setContentType( MediaType.APPLICATION_OCTET_STREAM_VALUE );
			
			//다운로드한 파일을 저장할 때 사용할 파일명(이름) 설정 ,한글 또는 특수문자가 포함된 파일명은 인코딩 작업 필요
			String fname = URLEncoder.encode(receiptVo.getAttachOrgName(), "UTF-8").replace("+", "%20");
			resp.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + fname);
			
			//첨부파일의 내용을 읽어서, 응답객체의 내용에 쓰기
			FileCopyUtils.copy( new FileInputStream(file), resp.getOutputStream() );
		}

}
