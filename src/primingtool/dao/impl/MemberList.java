package primingtool.dao.impl;

import primingtool.business.CSVHandler;
import primingtool.business.PrimingRules;
import primingtool.dao.MemberDAO;
import primingtool.model.Member;
import primingtool.model.impl.EuropeMember;
import primingtool.model.impl.USMember;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MemberList implements MemberDAO {

    private final static List<Member> memberDatabase = new ArrayList<Member>();
    private final static List<Member> erroredMembersDatabase = new ArrayList<Member>();

    public MemberList() {
    }

    /**
     * Reads through the CSV file and creates the member Line by Line
     */
    public void readFileAndCreateMembers() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(CSVHandler.getOriginalImportFilePath()), System.getProperty("file.encoding")));
            String memberRecord = bufferedReader.readLine();
            while((memberRecord = bufferedReader.readLine()) != null){
                if(!memberRecord.equals("") && !memberRecord.replaceAll("[,;\"]","").trim().isEmpty()){
                    addMember(convertRecordtoObject(memberRecord));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Adds a member object to the list
     * @param member
     */
    public void addMember(Member member) {
        if(member != null){
            if((isDuplicateClubMemberID(member.getClub_member_id())) || (isDuplicateEmail(member.getEmail())) ){
                if(isDuplicateClubMemberID(member.getClub_member_id())){
                    member.setMessageResult(member.getMessageResult()+"Club Member ID is already in Use. ");
                }
                if(isDuplicateEmail(member.getEmail())){
                    member.setMessageResult(member.getMessageResult() + "Email is already in use. ");
                }
                erroredMembersDatabase.add(member);
            }else{
                if(member.getMessageResult().equals("") || member.getMessageResult().trim().isEmpty()){
                    memberDatabase.add(member);
                }else{
                    erroredMembersDatabase.add(member);
                }
            }
        }
    }

    public boolean isDuplicateClubMemberID(String id) {
        if(id.trim().isEmpty() || id.equals("")){
            return false;
        }else{
            for(Member memberToFind:memberDatabase){
                if(memberToFind.getClub_member_id().equals(id)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDuplicateEmail(String email){
        if(email.trim().isEmpty() || email.equals("")){
         return false;
        }else{
            for(Member memberToFind:memberDatabase){
                if(memberToFind.getEmail().equals(email)){
                    return true;
                }
            }
        }
        return false;
    }

    public List<Member> getMembers() {
        return memberDatabase;
    }

    public List<Member> getErroredMembers() {
        return erroredMembersDatabase;
    }

    private Member convertRecordtoObject(String memberRecord){
        memberRecord = memberRecord+"1";
        String [] memberFields = memberRecord.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)|;(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

        for(int i=0; i<memberFields.length; i++){
            memberFields[i] = memberFields[i].trim();
        }

        switch (PrimingRules.getRegionSelected()){
            case "Northam":
                USMember usMember = new USMember();
                usMember.setFirstname(memberFields[CSVHandler.getColumnsIndex().get("firstname")]);

                usMember.setLastname(memberFields[CSVHandler.getColumnsIndex().get("lastname")]);

                usMember.setClub_member_id(memberFields[CSVHandler.getColumnsIndex().get("club_member_id")]);

                if(CSVHandler.getColumnsIndex().get("birthday") != -1){
                    usMember.setBirthday(memberFields[CSVHandler.getColumnsIndex().get("birthday")]);
                }
                if(CSVHandler.getColumnsIndex().get("gender") != -1){
                    usMember.setGender(memberFields[CSVHandler.getColumnsIndex().get("gender")]);
                }
                if(CSVHandler.getColumnsIndex().get("email") != -1){
                    usMember.setEmail(memberFields[CSVHandler.getColumnsIndex().get("email")]);
                }
                if(CSVHandler.getColumnsIndex().get("phone") != -1){
                    usMember.setPhone(memberFields[CSVHandler.getColumnsIndex().get("phone")]);
                }
                if(CSVHandler.getColumnsIndex().get("mobile") != -1){
                    usMember.setMobile(memberFields[CSVHandler.getColumnsIndex().get("mobile")]);
                }
                if(CSVHandler.getColumnsIndex().get("street") != -1){
                    usMember.setStreet(memberFields[CSVHandler.getColumnsIndex().get("street")]);
                }
                if(CSVHandler.getColumnsIndex().get("street_extra") != -1){
                    usMember.setStreet_extra(memberFields[CSVHandler.getColumnsIndex().get("street_extra")]);
                }
                if(CSVHandler.getColumnsIndex().get("house_number") != -1){
                    usMember.setHouse_number(memberFields[CSVHandler.getColumnsIndex().get("house_number")]);
                }
                if(CSVHandler.getColumnsIndex().get("house_number_addition") != -1){
                    usMember.setHouse_number_addition(memberFields[CSVHandler.getColumnsIndex().get("house_number_addition")]);
                }
                if(CSVHandler.getColumnsIndex().get("zip") != -1){
                    usMember.setZip(memberFields[CSVHandler.getColumnsIndex().get("zip")]);
                }
                if(CSVHandler.getColumnsIndex().get("city") != -1){
                    usMember.setCity(memberFields[CSVHandler.getColumnsIndex().get("city")]);
                }
                if(CSVHandler.getColumnsIndex().get("member_since") != -1){
                    usMember.setMember_since(memberFields[CSVHandler.getColumnsIndex().get("member_since")]);
                }
                if(CSVHandler.getColumnsIndex().get("country") != -1){
                    usMember.setCountry(memberFields[CSVHandler.getColumnsIndex().get("country")]);
                }
                if(CSVHandler.getColumnsIndex().get("language") != -1){
                    usMember.setLanguage(memberFields[CSVHandler.getColumnsIndex().get("language")]);
                }
                if(CSVHandler.getColumnsIndex().get("card_nr") != -1){
                    usMember.setCard_nr(memberFields[CSVHandler.getColumnsIndex().get("card_nr")]);
                }
                if(CSVHandler.getColumnsIndex().get("inactive") != -1){
                    usMember.setInactive(memberFields[CSVHandler.getColumnsIndex().get("inactive")]);
                }
                if(CSVHandler.getColumnsIndex().get("notes") != -1){
                    usMember.setNotes(memberFields[CSVHandler.getColumnsIndex().get("notes")]);
                }
                if(CSVHandler.getColumnsIndex().get("unsubscribe") != -1){
                    usMember.setUnsubscribe(memberFields[CSVHandler.getColumnsIndex().get("unsubscribe")]);
                }
                if(CSVHandler.getColumnsIndex().get("coach_id") != -1){
                    usMember.setCoach_id(memberFields[CSVHandler.getColumnsIndex().get("coach_id")]);
                }
                if(CSVHandler.getColumnsIndex().get("tags") != -1){
                    usMember.setTags(memberFields[CSVHandler.getColumnsIndex().get("tags")]);
                }
                if(CSVHandler.getColumnsIndex().get("bank_account_number") != -1){
                    usMember.setBank_account_number(memberFields[CSVHandler.getColumnsIndex().get("bank_account_number")]);
                }
                if(CSVHandler.getColumnsIndex().get("bank_account_owner") != -1){
                    usMember.setBank_account_owner(memberFields[CSVHandler.getColumnsIndex().get("bank_account_owner")]);
                }
                if(CSVHandler.getColumnsIndex().get("us_bank_routing_number") != -1){
                    usMember.setUs_bank_routing_number(memberFields[CSVHandler.getColumnsIndex().get("us_bank_routing_number")]);
                }
                if(CSVHandler.getColumnsIndex().get("us_bank_account_type") != -1){
                    usMember.setUs_bank_account_type(memberFields[CSVHandler.getColumnsIndex().get("us_bank_account_type")]);
                }
                if(CSVHandler.getColumnsIndex().get("us_bank_account_place") != -1){
                    usMember.setUs_bank_account_place(memberFields[CSVHandler.getColumnsIndex().get("us_bank_account_place")]);
                }

                validateFields(usMember);

                String bankAccountNumber = PrimingRules.validateAccountNumber(usMember.getBank_account_number());
                if(bankAccountNumber.equals("Account Number must have between 4 and 18 digits.")){
                    usMember.setMessageResult(usMember.getMessageResult()+bankAccountNumber);
                }else{
                    usMember.setBank_account_number(bankAccountNumber);
                }

                String bankRouting = PrimingRules.validateRoutingNumber(usMember.getUs_bank_routing_number());
                if(bankRouting.equals("Routing Number is invalid.")){
                    usMember.setMessageResult(usMember.getMessageResult()+bankRouting);
                }else {
                    usMember.setUs_bank_routing_number(bankRouting);
                }

                return usMember;
            case "Europe":
                EuropeMember europeMember = new EuropeMember();
                europeMember.setFirstname(memberFields[CSVHandler.getColumnsIndex().get("firstname")]);

                europeMember.setLastname(memberFields[CSVHandler.getColumnsIndex().get("lastname")]);

                europeMember.setClub_member_id(memberFields[CSVHandler.getColumnsIndex().get("club_member_id")]);

                if(CSVHandler.getColumnsIndex().get("birthday") != -1){
                    europeMember.setBirthday(memberFields[CSVHandler.getColumnsIndex().get("birthday")]);
                }
                if(CSVHandler.getColumnsIndex().get("gender") != -1){
                    europeMember.setGender(memberFields[CSVHandler.getColumnsIndex().get("gender")]);
                }
                if(CSVHandler.getColumnsIndex().get("email") != -1){
                    europeMember.setEmail(memberFields[CSVHandler.getColumnsIndex().get("email")]);
                }
                if(CSVHandler.getColumnsIndex().get("phone") != -1){
                    europeMember.setPhone(memberFields[CSVHandler.getColumnsIndex().get("phone")]);
                }
                if(CSVHandler.getColumnsIndex().get("mobile") != -1){
                    europeMember.setMobile(memberFields[CSVHandler.getColumnsIndex().get("mobile")]);
                }
                if(CSVHandler.getColumnsIndex().get("street") != -1){
                    europeMember.setStreet(memberFields[CSVHandler.getColumnsIndex().get("street")]);
                }
                if(CSVHandler.getColumnsIndex().get("street_extra") != -1){
                    europeMember.setStreet_extra(memberFields[CSVHandler.getColumnsIndex().get("street_extra")]);
                }
                if(CSVHandler.getColumnsIndex().get("house_number") != -1){
                    europeMember.setHouse_number(memberFields[CSVHandler.getColumnsIndex().get("house_number")]);
                }
                if(CSVHandler.getColumnsIndex().get("house_number_addition") != -1){
                    europeMember.setHouse_number_addition(memberFields[CSVHandler.getColumnsIndex().get("house_number_addition")]);
                }
                if(CSVHandler.getColumnsIndex().get("zip") != -1){
                    europeMember.setZip(memberFields[CSVHandler.getColumnsIndex().get("zip")]);
                }
                if(CSVHandler.getColumnsIndex().get("city") != -1){
                    europeMember.setCity(memberFields[CSVHandler.getColumnsIndex().get("city")]);
                }
                if(CSVHandler.getColumnsIndex().get("member_since") != -1){
                    europeMember.setMember_since(memberFields[CSVHandler.getColumnsIndex().get("member_since")]);
                }
                if(CSVHandler.getColumnsIndex().get("country") != -1){
                    europeMember.setCountry(memberFields[CSVHandler.getColumnsIndex().get("country")]);
                }
                if(CSVHandler.getColumnsIndex().get("language") != -1){
                    europeMember.setLanguage(memberFields[CSVHandler.getColumnsIndex().get("language")]);
                }
                if(CSVHandler.getColumnsIndex().get("card_nr") != -1){
                    europeMember.setCard_nr(memberFields[CSVHandler.getColumnsIndex().get("card_nr")]);
                }
                if(CSVHandler.getColumnsIndex().get("inactive") != -1){
                    europeMember.setInactive(memberFields[CSVHandler.getColumnsIndex().get("inactive")]);
                }
                if(CSVHandler.getColumnsIndex().get("notes") != -1){
                    europeMember.setNotes(memberFields[CSVHandler.getColumnsIndex().get("notes")]);
                }
                if(CSVHandler.getColumnsIndex().get("unsubscribe") != -1){
                    europeMember.setUnsubscribe(memberFields[CSVHandler.getColumnsIndex().get("unsubscribe")]);
                }
                if(CSVHandler.getColumnsIndex().get("coach_id") != -1){
                    europeMember.setCoach_id(memberFields[CSVHandler.getColumnsIndex().get("coach_id")]);
                }
                if(CSVHandler.getColumnsIndex().get("tags") != -1){
                    europeMember.setTags(memberFields[CSVHandler.getColumnsIndex().get("tags")]);
                }
                if(CSVHandler.getColumnsIndex().get("bank_account_number") != -1){
                    europeMember.setBank_account_number(memberFields[CSVHandler.getColumnsIndex().get("bank_account_number")]);
                }
                if(CSVHandler.getColumnsIndex().get("bank_account_owner") != -1){
                    europeMember.setBank_account_owner(memberFields[CSVHandler.getColumnsIndex().get("bank_account_owner")]);
                }
                if(CSVHandler.getColumnsIndex().get("bank_sort_code") != -1){
                    europeMember.setBank_sort_code(memberFields[CSVHandler.getColumnsIndex().get("bank_sort_code")]);
                }
                if(CSVHandler.getColumnsIndex().get("bank_bic_code") != -1){
                    europeMember.setBank_bic_code(memberFields[CSVHandler.getColumnsIndex().get("bank_code")]);
                }

                validateFields(europeMember);

                return europeMember;
            case "Other":
                Member otherMember = new Member();
                otherMember.setFirstname(memberFields[CSVHandler.getColumnsIndex().get("firstname")]);

                otherMember.setLastname(memberFields[CSVHandler.getColumnsIndex().get("lastname")]);

                otherMember.setClub_member_id(memberFields[CSVHandler.getColumnsIndex().get("club_member_id")]);

                if(CSVHandler.getColumnsIndex().get("birthday") != -1){
                    otherMember.setBirthday(memberFields[CSVHandler.getColumnsIndex().get("birthday")]);
                }
                if(CSVHandler.getColumnsIndex().get("gender") != -1){
                    otherMember.setGender(memberFields[CSVHandler.getColumnsIndex().get("gender")]);
                }
                if(CSVHandler.getColumnsIndex().get("email") != -1){
                    otherMember.setEmail(memberFields[CSVHandler.getColumnsIndex().get("email")]);
                }
                if(CSVHandler.getColumnsIndex().get("phone") != -1){
                    otherMember.setPhone(memberFields[CSVHandler.getColumnsIndex().get("phone")]);
                }
                if(CSVHandler.getColumnsIndex().get("mobile") != -1){
                    otherMember.setMobile(memberFields[CSVHandler.getColumnsIndex().get("mobile")]);
                }
                if(CSVHandler.getColumnsIndex().get("street") != -1){
                    otherMember.setStreet(memberFields[CSVHandler.getColumnsIndex().get("street")]);
                }
                if(CSVHandler.getColumnsIndex().get("street_extra") != -1){
                    otherMember.setStreet_extra(memberFields[CSVHandler.getColumnsIndex().get("street_extra")]);
                }
                if(CSVHandler.getColumnsIndex().get("house_number") != -1){
                    otherMember.setHouse_number(memberFields[CSVHandler.getColumnsIndex().get("house_number")]);
                }
                if(CSVHandler.getColumnsIndex().get("house_number_addition") != -1){
                    otherMember.setHouse_number_addition(memberFields[CSVHandler.getColumnsIndex().get("house_number_addition")]);
                }
                if(CSVHandler.getColumnsIndex().get("zip") != -1){
                    otherMember.setZip(memberFields[CSVHandler.getColumnsIndex().get("zip")]);
                }
                if(CSVHandler.getColumnsIndex().get("city") != -1){
                    otherMember.setCity(memberFields[CSVHandler.getColumnsIndex().get("city")]);
                }
                if(CSVHandler.getColumnsIndex().get("member_since") != -1){
                    otherMember.setMember_since(memberFields[CSVHandler.getColumnsIndex().get("member_since")]);
                }
                if(CSVHandler.getColumnsIndex().get("country") != -1){
                    otherMember.setCountry(memberFields[CSVHandler.getColumnsIndex().get("country")]);
                }
                if(CSVHandler.getColumnsIndex().get("language") != -1){
                    otherMember.setLanguage(memberFields[CSVHandler.getColumnsIndex().get("language")]);
                }
                if(CSVHandler.getColumnsIndex().get("card_nr") != -1){
                    otherMember.setCard_nr(memberFields[CSVHandler.getColumnsIndex().get("card_nr")]);
                }
                if(CSVHandler.getColumnsIndex().get("inactive") != -1){
                    otherMember.setInactive(memberFields[CSVHandler.getColumnsIndex().get("inactive")]);
                }
                if(CSVHandler.getColumnsIndex().get("notes") != -1){
                    otherMember.setNotes(memberFields[CSVHandler.getColumnsIndex().get("notes")]);
                }
                if(CSVHandler.getColumnsIndex().get("unsubscribe") != -1){
                    otherMember.setUnsubscribe(memberFields[CSVHandler.getColumnsIndex().get("unsubscribe")]);
                }
                if(CSVHandler.getColumnsIndex().get("coach_id") != -1){
                    otherMember.setCoach_id(memberFields[CSVHandler.getColumnsIndex().get("coach_id")]);
                }
                if(CSVHandler.getColumnsIndex().get("tags") != -1){
                    otherMember.setTags(memberFields[CSVHandler.getColumnsIndex().get("tags")]);
                }
                if(CSVHandler.getColumnsIndex().get("bank_account_number") != -1){
                    otherMember.setBank_account_number(memberFields[CSVHandler.getColumnsIndex().get("bank_account_number")]);
                }
                if(CSVHandler.getColumnsIndex().get("bank_account_owner") != -1){
                    otherMember.setBank_account_owner(memberFields[CSVHandler.getColumnsIndex().get("bank_account_owner")]);
                }

                validateFields(otherMember);

                return otherMember;
        }
        return null;
    }

    public void validateFields(Member member){
        if(member.getFirstname().equals("") || member.getFirstname().trim().isEmpty()){
            member.setMessageResult(member.getMessageResult()+ "Firstname is Required");
        }
        if(member.getLastname().equals("") || member.getLastname().trim().isEmpty()){
            member.setMessageResult(member.getMessageResult()+ "Lastname is Required");
        }
        if(member.getClub_member_id().equals("") || member.getClub_member_id().trim().isEmpty()){
            member.setMessageResult(member.getMessageResult()+ "Club member ID is Required");
        }

        String email = PrimingRules.fixEmailFormat(member.getEmail());
        if(email.equals("E-mail has invalid Format.")){
            member.setMessageResult(member.getMessageResult()+email);
        }else{
            member.setEmail(email);
        }

        String birthday = PrimingRules.checkDateFormat(member.getBirthday());
        if(birthday.equals("value couldn't be converted.")){
            member.setMessageResult(member.getMessageResult()+" Birthday "+birthday);
        }else{
            member.setBirthday(birthday);
        }

        String memberSince = PrimingRules.checkDateFormat(member.getMember_since());
        if(memberSince.equals("value couldn't be converted.")){
            member.setMessageResult(member.getMessageResult()+ " Member Since "+memberSince);
        }else{
            member.setMember_since(memberSince);
        }

        String unsubscribe = PrimingRules.checkDateFormat(member.getUnsubscribe());
        if(unsubscribe.equals("value couldn't be converted.")){
            member.setMessageResult(member.getMessageResult()+ "Unsubscribe Date "+unsubscribe);
        }else {
            member.setUnsubscribe(unsubscribe);
        }

        member.setGender(PrimingRules.convertGenderToLowCase(member.getGender()));

        String inactive = PrimingRules.isActiveClient(member.getInactive());
        if(inactive.equals("Please Indicate if client is active.")){
            member.setMessageResult(member.getMessageResult()+inactive);
        }else{
            member.setInactive(inactive);
        }

    }

    public void createHeaders(){
        switch (PrimingRules.getRegionSelected()){
            case "Northam":
                USMember usHeader = new USMember(
                        "messageResult",
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
                        "member_since",
                        "country",
                        "language",
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
                        "messageResult",
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
                        "member_since",
                        "country",
                        "language",
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
                        "messageResult",
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
                        "member_since",
                        "country",
                        "language",
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
