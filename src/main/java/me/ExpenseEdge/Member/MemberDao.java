package me.ExpenseEdge.Member;

import java.util.List;

public interface MemberDao {
	
	//목록 보기
	List<MemberVo> selectMemberList();
	
	//하나 선택
	MemberVo selectMember(String loginId);
	
	//수정하기
	void editMember(MemberVo memberVo);
	
	//등록하기
	int addMember(MemberVo memberVo);
	
	//삭제하기
	void deleteMember(String memberId);
	
	//로그인 ID중복체크
	int memberCnt(String loginId);
}
