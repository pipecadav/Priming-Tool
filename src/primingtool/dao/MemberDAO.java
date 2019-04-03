package primingtool.dao;

import primingtool.model.Member;

import java.util.List;

public interface MemberDAO {
    void addMember(Member member);
    boolean isDuplicateClubMemberID(String emailOrId);
    List<Member> getMembers();
    List<Member> getErroredMembers();

}
