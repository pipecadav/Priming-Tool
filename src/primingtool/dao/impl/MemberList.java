package primingtool.dao.impl;

import primingtool.dao.MemberDAO;
import primingtool.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberList implements MemberDAO {

    private final static List<Member> memberDatabase = new ArrayList<Member>();
    private final static List<Member> erroredMembersDatabase = new ArrayList<Member>();


    /**
     * Adds a member object. Duplicates are validated here.
     * @param member
     */
    public void addMember(Member member) {
        if((searchMember(member.geteMail()) != null) || (searchMember(member.getClubMemberId()) != null)){
            erroredMembersDatabase.add(member);
        }else{
            memberDatabase.add(member);
        }
    }

    public Member searchMember(String emailOrId) {
        for(Member memberToFind:memberDatabase){
            if(memberToFind.geteMail().equals(emailOrId) || memberToFind.getClubMemberId().equals(emailOrId)){
                return memberToFind;
            }
        }
        return null;
    }

    public List<Member> getMembers() {
        return memberDatabase;
    }

    public List<Member> getErroredMembers() {
        return erroredMembersDatabase;
    }

    public void deleteMember(String emailOrId) {
        Member memberToFind =searchMember(emailOrId);
        if(memberToFind !=null ){
            memberDatabase.remove(memberToFind);
        }
    }
}
