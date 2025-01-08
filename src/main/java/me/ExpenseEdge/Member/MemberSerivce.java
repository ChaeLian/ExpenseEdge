package me.ExpenseEdge.Member;

import java.util.List;

public interface MemberSerivce {
	
	//목록보기
	public List<MemberVo> selectMemberList();
	
	//한개 보기
	MemberVo selectMember(String loginId);
	
	//수정하기
	void editMember(MemberVo memberVo);
	
	//등록하기
	int addMember(MemberVo memberVo);

	//삭제하기
	void deleteMember(String memberId);
	
	//로그인 id 중복 세기
	int memberCnt(String loginId);
}
