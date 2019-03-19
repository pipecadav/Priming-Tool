package primingtool.dao;

import primingtool.model.Member;

import java.util.List;

public interface MemberDAO {
    void addMember(Member member);
    Member searchMember(String emailOrId);
    List<Member> getMembers();
    List<Member> getErroredMembers();
    void deleteMember(String emailOrId);

}
