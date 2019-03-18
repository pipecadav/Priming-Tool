package primingtool.model.impl;

import primingtool.model.Member;

public class EuropeMember extends Member {

    private String bicCode;
    private String sortCode;

    public EuropeMember(String bicCode, String sortCode) {
        this.bicCode = bicCode;
        this.sortCode = sortCode;
    }

    public EuropeMember(String firstName, String lastName, String birthday, char gender, String clubMemberId, String eMail, String phone, String mobile, String street, String streetExtra, String houseNumber, String houseNunberExtra, String zip, String city, String country, String cardNumber, String inactive, String notes, String unsubscribeDate, String coachId, String tags, String bankAccountNumber, String bankAccountOwner, String bicCode, String sortCode) {
        super(firstName, lastName, birthday, gender, clubMemberId, eMail, phone, mobile, street, streetExtra, houseNumber, houseNunberExtra, zip, city, country, cardNumber, inactive, notes, unsubscribeDate, coachId, tags, bankAccountNumber, bankAccountOwner);
        this.bicCode = bicCode;
        this.sortCode = sortCode;
    }

    public String getBicCode() {
        return bicCode;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    @Override
    public String toString() {
        return
                super.toString() + "," +
                this.getBicCode() + "," +
                this.getSortCode();
    }
}
