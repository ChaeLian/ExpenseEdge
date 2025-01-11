package me.ExpenseEdge.ReportItems;

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
public class ReportItemsServiceImpl implements ReportItemsService {
	
	@Autowired
	private ReportItemsDao reportItemsDao;
	
	@Autowired
	private ReceiptDao receiptDao;
	
	@Autowired
	private ReportDao reportDao;
	
	//첨부파일 저장 경로
	@Value("${reportItem.upload}")
	private String upload;
	
	//의존성 주입이 완료된 후 자동 실행
	@PostConstruct
	public void init() {
		//첨부파일 저장 경로에 디렉토리가 없는 경우 디렉토리 생성
		new File(upload).mkdirs();
	}
	
	//item 저장
	@Override
	@Transactional //이 메서드를 하나의 트랜잭션으로 정의
	public int reportItemsAdd(MemberVo memberVo, ReportItemsVo reportItemsVo) {
		//첨부파일 저장
		MultipartFile image = reportItemsVo.getUpFile();
		if(image != null && image.getSize() > 0) {
			String newName;
			File file;
			do {
				//중복확률이 매우 낮은 임의의 문자열을 생성
				newName = UUID.randomUUID().toString();
				file = new File(upload, newName);
			}while (file.exists());
			//존재하면 다시 생성
			
			try {
				//첨부파일의 내용을 바이트로 새로 생성한 file에 복사
				FileCopyUtils.copy(image.getBytes(), file);
				//첨부파일 객체 생성
				ReceiptVo receiptVo = new ReceiptVo();
				receiptVo.setAttachOrgName(image.getOriginalFilename());
				receiptVo.setAttachNewName(newName);
				//DB저장 (RETURNING INTO)
				receiptDao.add(receiptVo);
				//RETURNING INTO 절을 사용하여 시퀀스에 자동 증가한 값을 가져옴
				//가져온 값을 아이템의 관련 변수에 값을 넣어줌
				reportItemsVo.setAttachId(receiptVo.getAttachId());
				System.out.println("insert 후의 : " +reportItemsVo.getAttachId());
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e); //첨부파일 저장중 오류발생시 롤백되도록
			}
		}else {
			reportItemsVo.setAttachId("attach_null");
		}

		//보고서 중복이 있는지 확인, 없으면 생성
		int count = reportDao.beforeCount(memberVo);
		if(count <= 0) {
			reportDao.unFinishAdd(memberVo);
		}
		
		ReportVo befoReport = reportDao.beforeSelect(memberVo);
		
		reportItemsVo.setReportId(befoReport.getReportId());
		
		//보고서에 item 등록하기
		int num = reportItemsDao.reportItemsAdd(reportItemsVo);
		
		System.out.println(num + "개의 reportItem이 등록되었습니다.");
		return num;	
	}
	
	//작성 중인 보고서에 저장 완료 된 item list
	@Override
	public List<ReportItemsDTO> itemList(MemberVo memberVo) {
		//item이 저장되어 있는 작성 중인 보고서 정보
		ReportVo befoReport = reportDao.beforeSelect(memberVo);
		List<ReportItemsDTO> list = reportItemsDao.itemList(befoReport);
		return list;
	}
	
	//아이템 삭제
	@Override
	@Transactional
	public int itemDel(String itemId) {
		//첨부파일도 삭제해야하기 때문에 첨부파일 관련 정보 가져오기
		ReportItemsVo reportItemsVo = reportItemsDao.itemSelect(itemId);
		String attachId =  reportItemsVo.getAttachId();
		
		//관련 첨부파일 하드디스크에서 삭제
		ReceiptVo receiptVo = receiptDao.receiptSelect(attachId);
		new File(upload, receiptVo.getAttachNewName()).delete();
		
		//관련 첨부파일 DB삭제
		receiptDao.attachDel(attachId);
		
		int num = reportItemsDao.itemDel(itemId);
		return num;
	}
	
	//비용항목 수정
	@Override
	public int itemUpdate(ReportItemsVo reportItemsVo) {
		int num = reportItemsDao.itemUpdate(reportItemsVo);
		return num;
	}

}
