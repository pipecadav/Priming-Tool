package primingtool.model.impl;

/* This class creates an object member with additional attributes that are only applicable to EUROPA
 * It contains the Bic Code and Sort Code
 * This class extends Member and therefore contains all its attributes
 *
 *
 */

import primingtool.model.Member;

public class EuropeMember extends Member {

    private String bicCode;
    private String sortCode;

    /**
     * Constructor
     * @param bicCode
     * @param sortCode
     */
    public EuropeMember(String bicCode, String sortCode) {
        this.bicCode = bicCode;
        this.sortCode = sortCode;
    }

    /**
     * Constructor
     * @param firstName
     * @param lastName
     * @param birthday
     * @param gender
     * @param clubMemberId
     * @param eMail
     * @param phone
     * @param mobile
     * @param street
     * @param streetExtra
     * @param houseNumber
     * @param houseNunberExtra
     * @param zip
     * @param city
     * @param country
     * @param cardNumber
     * @param inactive
     * @param notes
     * @param unsubscribeDate
     * @param coachId
     * @param tags
     * @param bankAccountNumber
     * @param bankAccountOwner
     * @param bicCode
     * @param sortCode
     */
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

    /**
     * Converts the object Data to a String
     * @return
     */
    @Override
    public String toString() {
        return
                super.toString() + "," +
                this.getBicCode() + "," +
                this.getSortCode();
    }
}
