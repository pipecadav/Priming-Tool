package primingtool.dao;

import primingtool.model.Member;

import java.util.List;

public interface MemberDAO {
    void addMember(Member member);
    Member findMemberByEmailOrId(String emailOrId);
    List<Member> getMembers();
    List<Member> getFailedMembers();
    void deleteMember(String emailOrId);

}
