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

    // TODO @pipe, you can also make this an enum if you use these values in different classes as well.
    private static final String REGION_NORTHAM = "Northam";
    private static final String REGION_EUROPE = "Europe";
    private static final String REGION_OTHER = "Other";

    private final static List<Member> memberDatabase = new ArrayList<>();
    private final static List<Member> failedMemberDatabase = new ArrayList<>();

    public MemberList() {
    }

    public void readFileAndCreateMembers() {
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(CSVHandler.getOriginalImportFilePath()));
            String memberRecord = bufferedReader.readLine();

            while ((memberRecord = bufferedReader.readLine()) != null) {
                addMember(convertRecordToObject(memberRecord));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a member object. Duplicates are validated here.
     *
     * @param member
     */
    public void addMember(Member member) {
        if ((findMemberByEmailOrId(member.getEmail()) != null) || (findMemberByEmailOrId(member.getClubMemberId()) != null)) {
            failedMemberDatabase.add(member);
        } else {
            memberDatabase.add(member);
        }
    }

    public Member findMemberByEmailOrId(String emailOrId) {
        for (Member member : memberDatabase) {
            if (member.getEmail().equals(emailOrId) || member.getClubMemberId().equals(emailOrId)) {
                return member;
            }
        }

        return null;
    }

    public List<Member> getMembers() {
        return memberDatabase;
    }

    public List<Member> getFailedMembers() {
        return failedMemberDatabase;
    }

    public void deleteMember(String emailOrId) {
        Member memberToFind = findMemberByEmailOrId(emailOrId);
        if (memberToFind != null) {
            memberDatabase.remove(memberToFind);
        }
    }

    private Member convertRecordToObject(String memberRecord) {
        String[] memberFields = MemberRulesImpl.primeFields(memberRecord);

        // TODO @pipe Use the Builder here that I mentioned in the Member class. And use the
        //  hasValueFor and getIndexFor methods in CSVHandler to make this method a bit cleaner.
        //  See MemberRulesImpl#primeFields :)
        switch (MemberRulesImpl.getRegionSelected()) {
            case REGION_NORTHAM:

                USMember usMember = new USMember();
                usMember.setFirstName(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("firstname"))]);

                usMember.setLastName(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("lastname"))]);

                usMember.setClubMemberId(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("club_member_id"))]);

                if (!CSVHandler.getColumnIndex().get("birthday").equals("-1")) {
                    usMember.setBirthday(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("birthday"))]);
                }
                if (!CSVHandler.getColumnIndex().get("gender").equals("-1")) {
                    usMember.setGender(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("gender"))]);
                }
                if (!CSVHandler.getColumnIndex().get("email").equals("-1")) {
                    usMember.setEmail(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("email"))]);
                }
                if (!CSVHandler.getColumnIndex().get("phone").equals("-1")) {
                    usMember.setPhone(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("phone"))]);
                }
                if (!CSVHandler.getColumnIndex().get("mobile").equals("-1")) {
                    usMember.setMobile(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("mobile"))]);
                }
                if (!CSVHandler.getColumnIndex().get("street").equals("-1")) {
                    usMember.setStreet(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("street"))]);
                }
                if (!CSVHandler.getColumnIndex().get("street_extra").equals("-1")) {
                    usMember.setStreetExtra(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("street_extra"))]);
                }
                if (!CSVHandler.getColumnIndex().get("house_number").equals("-1")) {
                    usMember.setHouseNumber(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("house_number"))]);
                }
                if (!CSVHandler.getColumnIndex().get("house_number_addition").equals("-1")) {
                    usMember.setHouseNumberAddition(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("house_number_addition"))]);
                }
                if (!CSVHandler.getColumnIndex().get("zip").equals("-1")) {
                    usMember.setZip(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("zip"))]);
                }
                if (!CSVHandler.getColumnIndex().get("city").equals("-1")) {
                    usMember.setCity(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("city"))]);
                }
                if (!CSVHandler.getColumnIndex().get("country").equals("-1")) {
                    usMember.setCountry(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("country"))]);
                }
                if (!CSVHandler.getColumnIndex().get("card_nr").equals("-1")) {
                    usMember.setCardNumber(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("card_nr"))]);
                }
                if (!CSVHandler.getColumnIndex().get("inactive").equals("-1")) {
                    usMember.setInactive(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("inactive"))]);
                }
                if (!CSVHandler.getColumnIndex().get("notes").equals("-1")) {
                    usMember.setNotes(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("notes"))]);
                }
                if (!CSVHandler.getColumnIndex().get("unsubscribe").equals("-1")) {
                    usMember.setUnsubscribeDate(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("unsubscribe"))]);
                }
                if (!CSVHandler.getColumnIndex().get("coach_id").equals("-1")) {
                    usMember.setCoachId(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("coach_id"))]);
                }
                if (!CSVHandler.getColumnIndex().get("tags").equals("-1")) {
                    usMember.setTags(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("tags"))]);
                }
                if (!CSVHandler.getColumnIndex().get("bank_account_number").equals("-1")) {
                    usMember.setBankAccountNumber(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("bank_account_number"))]);
                }
                if (!CSVHandler.getColumnIndex().get("bank_account_owner").equals("-1")) {
                    usMember.setBankAccountOwner(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("bank_account_owner"))]);
                }
                if (!CSVHandler.getColumnIndex().get("us_bank_routing_number").equals("-1")) {
                    usMember.setUs_bank_routing_number(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("us_bank_routing_number"))]);
                }
                if (!CSVHandler.getColumnIndex().get("us_bank_account_type").equals("-1")) {
                    usMember.setUs_bank_account_type(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("us_bank_account_type"))]);
                }
                if (!CSVHandler.getColumnIndex().get("us_bank_account_place").equals("-1")) {
                    usMember.setUs_bank_account_place(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("us_bank_account_place"))]);
                }

                return usMember;

            case REGION_EUROPE:
                EuropeMember europeMember = new EuropeMember();
                europeMember.setFirstName(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("firstname"))]);

                europeMember.setLastName(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("lastname"))]);

                europeMember.setClubMemberId(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("club_member_id"))]);

                if (!CSVHandler.getColumnIndex().get("birthday").equals("-1")) {
                    europeMember.setBirthday(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("birthday"))]);
                }
                if (!CSVHandler.getColumnIndex().get("gender").equals("-1")) {
                    europeMember.setGender(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("gender"))]);
                }
                if (!CSVHandler.getColumnIndex().get("email").equals("-1")) {
                    europeMember.setEmail(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("email"))]);
                }
                if (!CSVHandler.getColumnIndex().get("phone").equals("-1")) {
                    europeMember.setPhone(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("phone"))]);
                }
                if (!CSVHandler.getColumnIndex().get("mobile").equals("-1")) {
                    europeMember.setMobile(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("mobile"))]);
                }
                if (!CSVHandler.getColumnIndex().get("street").equals("-1")) {
                    europeMember.setStreet(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("street"))]);
                }
                if (!CSVHandler.getColumnIndex().get("street_extra").equals("-1")) {
                    europeMember.setStreetExtra(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("street_extra"))]);
                }
                if (!CSVHandler.getColumnIndex().get("house_number").equals("-1")) {
                    europeMember.setHouseNumber(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("house_number"))]);
                }
                if (!CSVHandler.getColumnIndex().get("house_number_addition").equals("-1")) {
                    europeMember.setHouseNumberAddition(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("house_number_addition"))]);
                }
                if (!CSVHandler.getColumnIndex().get("zip").equals("-1")) {
                    europeMember.setZip(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("zip"))]);
                }
                if (!CSVHandler.getColumnIndex().get("city").equals("-1")) {
                    europeMember.setCity(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("city"))]);
                }
                if (!CSVHandler.getColumnIndex().get("country").equals("-1")) {
                    europeMember.setCountry(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("country"))]);
                }
                if (!CSVHandler.getColumnIndex().get("card_nr").equals("-1")) {
                    europeMember.setCardNumber(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("card_nr"))]);
                }
                if (!CSVHandler.getColumnIndex().get("inactive").equals("-1")) {
                    europeMember.setInactive(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("inactive"))]);
                }
                if (!CSVHandler.getColumnIndex().get("notes").equals("-1")) {
                    europeMember.setNotes(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("notes"))]);
                }
                if (!CSVHandler.getColumnIndex().get("unsubscribe").equals("-1")) {
                    europeMember.setUnsubscribeDate(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("unsubscribe"))]);
                }
                if (!CSVHandler.getColumnIndex().get("coach_id").equals("-1")) {
                    europeMember.setCoachId(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("coach_id"))]);
                }
                if (!CSVHandler.getColumnIndex().get("tags").equals("-1")) {
                    europeMember.setTags(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("tags"))]);
                }
                if (!CSVHandler.getColumnIndex().get("bank_account_number").equals("-1")) {
                    europeMember.setBankAccountNumber(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("bank_account_number"))]);
                }
                if (!CSVHandler.getColumnIndex().get("bank_account_owner").equals("-1")) {
                    europeMember.setBankAccountOwner(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("bank_account_owner"))]);
                }
                if (!CSVHandler.getColumnIndex().get("bank_sort_code").equals("-1")) {
                    europeMember.setBank_sort_code(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("bank_sort_code"))]);
                }
                if (!CSVHandler.getColumnIndex().get("bank_bic_code").equals("-1")) {
                    europeMember.setBank_bic_code(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("bank_code"))]);
                }

                return europeMember;

            case REGION_OTHER:
                Member otherMember = new Member();
                otherMember.setFirstName(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("firstname"))]);

                otherMember.setLastName(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("lastname"))]);

                otherMember.setClubMemberId(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("club_member_id"))]);

                if (!CSVHandler.getColumnIndex().get("birthday").equals("-1")) {
                    otherMember.setBirthday(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("birthday"))]);
                }
                if (!CSVHandler.getColumnIndex().get("gender").equals("-1")) {
                    otherMember.setGender(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("gender"))]);
                }
                if (!CSVHandler.getColumnIndex().get("email").equals("-1")) {
                    otherMember.setEmail(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("email"))]);
                }
                if (!CSVHandler.getColumnIndex().get("phone").equals("-1")) {
                    otherMember.setPhone(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("phone"))]);
                }
                if (!CSVHandler.getColumnIndex().get("mobile").equals("-1")) {
                    otherMember.setMobile(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("mobile"))]);
                }
                if (!CSVHandler.getColumnIndex().get("street").equals("-1")) {
                    otherMember.setStreet(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("street"))]);
                }
                if (!CSVHandler.getColumnIndex().get("street_extra").equals("-1")) {
                    otherMember.setStreetExtra(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("street_extra"))]);
                }
                if (!CSVHandler.getColumnIndex().get("house_number").equals("-1")) {
                    otherMember.setHouseNumber(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("house_number"))]);
                }
                if (!CSVHandler.getColumnIndex().get("house_number_addition").equals("-1")) {
                    otherMember.setHouseNumberAddition(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("house_number_addition"))]);
                }
                if (!CSVHandler.getColumnIndex().get("zip").equals("-1")) {
                    otherMember.setZip(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("zip"))]);
                }
                if (!CSVHandler.getColumnIndex().get("city").equals("-1")) {
                    otherMember.setCity(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("city"))]);
                }
                if (!CSVHandler.getColumnIndex().get("country").equals("-1")) {
                    otherMember.setCountry(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("country"))]);
                }
                if (!CSVHandler.getColumnIndex().get("card_nr").equals("-1")) {
                    otherMember.setCardNumber(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("card_nr"))]);
                }
                if (!CSVHandler.getColumnIndex().get("inactive").equals("-1")) {
                    otherMember.setInactive(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("inactive"))]);
                }
                if (!CSVHandler.getColumnIndex().get("notes").equals("-1")) {
                    otherMember.setNotes(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("notes"))]);
                }
                if (!CSVHandler.getColumnIndex().get("unsubscribe").equals("-1")) {
                    otherMember.setUnsubscribeDate(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("unsubscribe"))]);
                }
                if (!CSVHandler.getColumnIndex().get("coach_id").equals("-1")) {
                    otherMember.setCoachId(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("coach_id"))]);
                }
                if (!CSVHandler.getColumnIndex().get("tags").equals("-1")) {
                    otherMember.setTags(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("tags"))]);
                }
                if (!CSVHandler.getColumnIndex().get("bank_account_number").equals("-1")) {
                    otherMember.setBankAccountNumber(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("bank_account_number"))]);
                }
                if (!CSVHandler.getColumnIndex().get("bank_account_owner").equals("-1")) {
                    otherMember.setBankAccountOwner(memberFields[Integer.parseInt(CSVHandler.getColumnIndex().get("bank_account_owner"))]);
                }
                return otherMember;

        }

        return null;
    }

    public void createHeaders() {
        switch (MemberRulesImpl.getRegionSelected()) {

            case REGION_NORTHAM:
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
                failedMemberDatabase.add(usHeader);
                break;

            case REGION_EUROPE:
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
                failedMemberDatabase.add(europeHeader);
                break;

            case REGION_OTHER:
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
                        "bank_account_owner"
                );

                memberDatabase.add(otherMemberHeader);
                failedMemberDatabase.add(otherMemberHeader);
                break;
        }

    }

}