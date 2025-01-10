package me.ExpenseEdge.Receipt;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import me.ExpenseEdge.Cost.CostVo;
import me.ExpenseEdge.Member.MemberVo;
import me.ExpenseEdge.Receipt.ReceiptDao;
import me.ExpenseEdge.Receipt.ReceiptVo;
import me.ExpenseEdge.Report.ReportDao;
import me.ExpenseEdge.Report.ReportVo;
import me.ExpenseEdge.ReportItems.reportItemsDTO.ReportItemsDTO;

@Service
public class ReceiptServiceImpl implements ReceiptService {
	
	@Autowired
	private ReceiptDao receiptDao;
	
	//첨부파일 저장 경로
	@Value("${reportItem.upload}")
	private String upload;
	
	//첨부파일 정보 가져오기
	@Override
	public ReceiptVo receiptSelect(String attachId) {
		return receiptDao.receiptSelect(attachId);
	}
	
	//첨부파일 가져오기
	@Override
	public File getReceiptFile(String attachNewName) {
		return new File(upload, attachNewName);
	}

}
