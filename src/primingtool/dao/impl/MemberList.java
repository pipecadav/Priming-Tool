package primingtool.dao.impl;

import primingtool.business.CSVHandler;
import primingtool.business.impl.MemberRulesImpl;
import primingtool.dao.MemberDAO;
import primingtool.model.Member;

import primingtool.model.impl.EuropeMember;
import primingtool.model.impl.USMember;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberList implements MemberDAO {

    private final static List<Member> memberDatabase = new ArrayList<Member>();
    private final static List<Member> erroredMembersDatabase = new ArrayList<Member>();

    public MemberList() {
    }

    public void readFileAndCreateMembers() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(CSVHandler.getOriginalImportFilePath()));
            String memberRecord = bufferedReader.readLine();;
            while((memberRecord = bufferedReader.readLine()) != null){
                //addMember(convertRecordtoObject(memberRecord));
                System.out.println(memberRecord);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Adds a member object. Duplicates are validated here.
     * @param member
     */
    public void addMember(Member member) {
        if((searchMember(member.getEmail()) != null) || (searchMember(member.getClub_member_id()) != null)){
            erroredMembersDatabase.add(member);
        }else{
            memberDatabase.add(member);
        }
    }

    public Member searchMember(String emailOrId) {
        for(Member memberToFind:memberDatabase){
            if(memberToFind.getEmail().equals(emailOrId) || memberToFind.getClub_member_id().equals(emailOrId)){
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

    private Member convertRecordtoObject(String memberRecord){
        String [] memberFields = MemberRulesImpl.primeFields(memberRecord);
        switch (MemberRulesImpl.getRegionSelected()){
            case "Northam":
                USMember usMember = new USMember();
                usMember.setFirstname(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("firstname"))]);

                usMember.setLastname(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("lastname"))]);

                usMember.setClub_member_id(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("club_member_id"))]);

                if(!CSVHandler.getColumnsIndex().get("birthday").equals("-1")){
                    usMember.setBirthday(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("birthday"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("gender").equals("-1")){
                    usMember.setGender(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("gender"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("email").equals("-1")){
                    usMember.setEmail(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("email"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("phone").equals("-1")){
                    usMember.setPhone(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("phone"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("mobile").equals("-1")){
                    usMember.setMobile(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("mobile"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("street").equals("-1")){
                    usMember.setStreet(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("street"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("street_extra").equals("-1")){
                    usMember.setStreet_extra(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("street_extra"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("house_number").equals("-1")){
                    usMember.setHouse_number(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("house_number"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("house_number_addition").equals("-1")){
                    usMember.setHouse_number_addition(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("house_number_addition"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("zip").equals("-1")){
                    usMember.setZip(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("zip"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("city").equals("-1")){
                    usMember.setCity(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("city"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("country").equals("-1")){
                    usMember.setCountry(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("country"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("card_nr").equals("-1")){
                    usMember.setCard_nr(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("card_nr"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("inactive").equals("-1")){
                    usMember.setInactive(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("inactive"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("notes").equals("-1")){
                    usMember.setNotes(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("notes"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("unsubscribe").equals("-1")){
                    usMember.setUnsubscribe(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("unsubscribe"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("coach_id").equals("-1")){
                    usMember.setCoach_id(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("coach_id"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("tags").equals("-1")){
                    usMember.setTags(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("tags"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("bank_account_number").equals("-1")){
                    usMember.setBank_account_number(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("bank_account_number"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("bank_account_owner").equals("-1")){
                    usMember.setBank_account_owner(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("bank_account_owner"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("us_bank_routing_number").equals("-1")){
                    usMember.setUs_bank_routing_number(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("us_bank_routing_number"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("us_bank_account_type").equals("-1")){
                    usMember.setUs_bank_account_type(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("us_bank_account_type"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("us_bank_account_place").equals("-1")){
                    usMember.setUs_bank_account_place(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("us_bank_account_place"))]);
                }
                return usMember;
            case "Europe":
                EuropeMember europeMember = new EuropeMember();
                europeMember.setFirstname(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("firstname"))]);

                europeMember.setLastname(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("lastname"))]);

                europeMember.setClub_member_id(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("club_member_id"))]);

                if(!CSVHandler.getColumnsIndex().get("birthday").equals("-1")){
                    europeMember.setBirthday(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("birthday"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("gender").equals("-1")){
                    europeMember.setGender(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("gender"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("email").equals("-1")){
                    europeMember.setEmail(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("email"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("phone").equals("-1")){
                    europeMember.setPhone(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("phone"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("mobile").equals("-1")){
                    europeMember.setMobile(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("mobile"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("street").equals("-1")){
                    europeMember.setStreet(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("street"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("street_extra").equals("-1")){
                    europeMember.setStreet_extra(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("street_extra"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("house_number").equals("-1")){
                    europeMember.setHouse_number(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("house_number"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("house_number_addition").equals("-1")){
                    europeMember.setHouse_number_addition(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("house_number_addition"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("zip").equals("-1")){
                    europeMember.setZip(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("zip"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("city").equals("-1")){
                    europeMember.setCity(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("city"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("country").equals("-1")){
                    europeMember.setCountry(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("country"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("card_nr").equals("-1")){
                    europeMember.setCard_nr(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("card_nr"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("inactive").equals("-1")){
                    europeMember.setInactive(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("inactive"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("notes").equals("-1")){
                    europeMember.setNotes(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("notes"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("unsubscribe").equals("-1")){
                    europeMember.setUnsubscribe(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("unsubscribe"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("coach_id").equals("-1")){
                    europeMember.setCoach_id(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("coach_id"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("tags").equals("-1")){
                    europeMember.setTags(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("tags"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("bank_account_number").equals("-1")){
                    europeMember.setBank_account_number(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("bank_account_number"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("bank_account_owner").equals("-1")){
                    europeMember.setBank_account_owner(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("bank_account_owner"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("bank_sort_code").equals("-1")){
                    europeMember.setBank_sort_code(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("bank_sort_code"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("bank_bic_code").equals("-1")){
                    europeMember.setBank_bic_code(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("bank_code"))]);
                }
                return europeMember;
            case "Other":
                Member otherMember = new Member();
                otherMember.setFirstname(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("firstname"))]);

                otherMember.setLastname(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("lastname"))]);

                otherMember.setClub_member_id(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("club_member_id"))]);

                if(!CSVHandler.getColumnsIndex().get("birthday").equals("-1")){
                    otherMember.setBirthday(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("birthday"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("gender").equals("-1")){
                    otherMember.setGender(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("gender"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("email").equals("-1")){
                    otherMember.setEmail(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("email"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("phone").equals("-1")){
                    otherMember.setPhone(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("phone"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("mobile").equals("-1")){
                    otherMember.setMobile(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("mobile"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("street").equals("-1")){
                    otherMember.setStreet(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("street"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("street_extra").equals("-1")){
                    otherMember.setStreet_extra(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("street_extra"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("house_number").equals("-1")){
                    otherMember.setHouse_number(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("house_number"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("house_number_addition").equals("-1")){
                    otherMember.setHouse_number_addition(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("house_number_addition"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("zip").equals("-1")){
                    otherMember.setZip(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("zip"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("city").equals("-1")){
                    otherMember.setCity(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("city"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("country").equals("-1")){
                    otherMember.setCountry(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("country"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("card_nr").equals("-1")){
                    otherMember.setCard_nr(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("card_nr"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("inactive").equals("-1")){
                    otherMember.setInactive(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("inactive"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("notes").equals("-1")){
                    otherMember.setNotes(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("notes"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("unsubscribe").equals("-1")){
                    otherMember.setUnsubscribe(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("unsubscribe"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("coach_id").equals("-1")){
                    otherMember.setCoach_id(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("coach_id"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("tags").equals("-1")){
                    otherMember.setTags(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("tags"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("bank_account_number").equals("-1")){
                    otherMember.setBank_account_number(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("bank_account_number"))]);
                }
                if(!CSVHandler.getColumnsIndex().get("bank_account_owner").equals("-1")){
                    otherMember.setBank_account_owner(memberFields[Integer.parseInt(CSVHandler.getColumnsIndex().get("bank_account_owner"))]);
                }
                return otherMember;
        }
        return null;
    }

    public void createHeaders(){
        switch (MemberRulesImpl.getRegionSelected()){
            case "Northam":
                USMember usHeader = new USMember(
                        "firstname",
                        "lastname",
                        "birthday",
                        "gender",
                        "club_member_id",
                        "email",
                        "phone",
                        "mobile",
                        "street",
                        "street_extra",
                        "house_number",
                        "house_number_addition",
                        "zip",
                        "city",
                        "country",
                        "card_nr",
                        "inactive",
                        "notes",
                        "unsubscribe",
                        "coach_id",
                        "tags",
                        "bank_account_number",
                        "bank_account_owner",
                        "us_bank_routing_number",
                        "us_bank_account_type",
                        "us_bank_account_place"
                        );
                memberDatabase.add(usHeader);
                erroredMembersDatabase.add(usHeader);
                break;
            case "Europe":
                EuropeMember europeHeader = new EuropeMember(
                        "firstname",
                        "lastname",
                        "birthday",
                        "gender",
                        "club_member_id",
                        "email",
                        "phone",
                        "mobile",
                        "street",
                        "street_extra",
                        "house_number",
                        "house_number_addition",
                        "zip",
                        "city",
                        "country",
                        "card_nr",
                        "inactive",
                        "notes",
                        "unsubscribe",
                        "coach_id",
                        "tags",
                        "bank_account_number",
                        "bank_account_owner",
                        "bank_bic_code",
                        "bank_sort_code"
                        );
                memberDatabase.add(europeHeader);
                erroredMembersDatabase.add(europeHeader);
                break;
            case "Other":
                Member otherMemberHeader = new Member(
                        "firstname",
                        "lastname",
                        "birthday",
                        "gender",
                        "club_member_id",
                        "email",
                        "phone",
                        "mobile",
                        "street",
                        "street_extra",
                        "house_number",
                        "house_number_addition",
                        "zip",
                        "city",
                        "country",
                        "card_nr",
                        "inactive",
                        "notes",
                        "unsubscribe",
                        "coach_id",
                        "tags",
                        "bank_account_number",
                        "bank_account_owner");
                memberDatabase.add(otherMemberHeader);
                erroredMembersDatabase.add(otherMemberHeader);
                break;
        }
    }







}
