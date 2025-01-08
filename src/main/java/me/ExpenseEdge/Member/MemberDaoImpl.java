package me.ExpenseEdge.Member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSession sql;
	
	@Override
	public List<MemberVo> selectMemberList() {
		return sql.selectList("member.selectMemberList");
	}

	@Override
	public MemberVo selectMember(String loginId) {
		return sql.selectOne("member.selectMember",loginId);
	}

	@Override
	public void editMember(MemberVo memberVo) {
		sql.update("member.editMember", memberVo);
	}

	@Override
	public int addMember(MemberVo memberVo) {
		int num = sql.insert("member.addMember", memberVo);
		return num;
	}

	@Override
	public void deleteMember(String memberId) {
		sql.update("member.deleteMember", memberId);

	}

	@Override
	public int memberCnt(String loginId) {
		int num = sql.selectOne("member.memberCnt", loginId);
		return num;
	}

}
