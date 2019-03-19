package primingtool.model.impl;

/* This class creates an object member with additional attributes that are only applicable to the USA
 * It contains Bank Account Routing Number, Bank Account Type and Bank Account Place
 * This class extends Member and therefore contains all its attributes
 *
 *
 *
 */

import primingtool.model.Member;

public class USMember extends Member {

    private String bankRoutingUS;
    private String bankAccountType;
    private String bankAccountPlace;

    public USMember(String bankRoutingUS, String bankAccountType, String bankAccountPlace) {
        this.bankRoutingUS = bankRoutingUS;
        this.bankAccountType = bankAccountType;
        this.bankAccountPlace = bankAccountPlace;
    }

    public USMember(String firstName, String lastName, String birthday, char gender, String clubMemberId, String eMail, String phone, String mobile, String street, String streetExtra, String houseNumber, String houseNunberExtra, String zip, String city, String country, String cardNumber, String inactive, String notes, String unsubscribeDate, String coachId, String tags, String bankAccountNumber, String bankAccountOwner, String bankRoutingUS, String bankAccountType, String bankAccountPlace) {
        super(firstName, lastName, birthday, gender, clubMemberId, eMail, phone, mobile, street, streetExtra, houseNumber, houseNunberExtra, zip, city, country, cardNumber, inactive, notes, unsubscribeDate, coachId, tags, bankAccountNumber, bankAccountOwner);
        this.bankRoutingUS = bankRoutingUS;
        this.bankAccountType = bankAccountType;
        this.bankAccountPlace = bankAccountPlace;
    }

    public String getBankRoutingUS() {
        return bankRoutingUS;
    }

    public void setBankRoutingUS(String bankRoutingUS) {
        this.bankRoutingUS = bankRoutingUS;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getBankAccountPlace() {
        return bankAccountPlace;
    }

    public void setBankAccountPlace(String bankAccountPlace) {
        this.bankAccountPlace = bankAccountPlace;
    }

    /**
     * Converts the object Data to a String
     * @return
     */
    @Override
    public String toString(){
        return
                super.toString() + "," +
                this.getBankRoutingUS() + "," +
                this.getBankAccountType() + "," +
                this.getBankAccountPlace();
    }
}
