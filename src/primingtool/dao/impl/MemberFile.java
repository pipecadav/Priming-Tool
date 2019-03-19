package primingtool.dao.impl;

import primingtool.dao.MemberDAO;
import primingtool.model.Member;

import java.util.List;

public class MemberFile implements MemberDAO {

    private static final String FILE_NAME = "Member_import_File";

    @Override
    public void addMember(Member member) {


    }

    @Override
    public Member searchMember(String emailOrId) {
        return null;
    }

    @Override
    public List<Member> getMembers() {
        return null;
    }

    @Override
    public List<Member> getErroredMembers() {
        return null;
    }

    @Override
    public void deleteMember(String emailOrId) {

    }


}
