package me.ExpenseEdge.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("customerService")
public class MemberServiceImpl implements MemberSerivce {
	
	@Autowired
	private MemberDao memberDao;

	//목록 가져오기
	public List<MemberVo> selectMemberList() {
		return memberDao.selectMemberList();
	}

	//한명 조회하기
	public MemberVo selectMember(String loginId) {
		return memberDao.selectMember(loginId);
	}
	
	//수정하기
	public void editMember(MemberVo memberVo) {
		memberDao.editMember(memberVo);
	}
	
	//등록하기
	public int addMember(MemberVo memberVo) {
		int num = memberDao.addMember(memberVo);
		return num;
	}
	
	//삭제하기
	public void deleteMember(String memberId) {
		memberDao.deleteMember(memberId);
	}

	//갯수세기
	public int memberCnt(String loginId) {
		int num = memberDao.memberCnt(loginId);
		return num;
	}

	
	
}
