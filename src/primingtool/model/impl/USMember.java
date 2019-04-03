package primingtool.model.impl;

/* This class creates an object member with additional attributes that are only applicable to the USA
 * It contains Bank Account Routing Number, Bank Account Type and Bank Account Place
 * This class extends Member and therefore contains all its attributes
 */

import primingtool.model.Member;

public class USMember extends Member {

    private String us_bank_routing_number = "";
    private String us_bank_account_type = "";
    private String us_bank_account_place = "";


    public USMember() {
    }

    /**
     * Constructor
     * @param messageResult
     * @param firstname
     * @param lastname
     * @param birthday
     * @param gender
     * @param club_member_id
     * @param email
     * @param phone
     * @param mobile
     * @param street
     * @param street_extra
     * @param house_number
     * @param house_number_addition
     * @param zip
     * @param city
     * @param member_since
     * @param country
     * @param language
     * @param card_nr
     * @param inactive
     * @param notes
     * @param unsubscribe
     * @param coach_id
     * @param tags
     * @param bank_account_number
     * @param bank_account_owner
     * @param us_bank_routing_number
     * @param us_bank_account_type
     * @param us_bank_account_place
     */
    public USMember(String messageResult, String firstname, String lastname, String birthday, String gender, String club_member_id, String email, String phone, String mobile, String street, String street_extra, String house_number, String house_number_addition, String zip, String city, String member_since, String country, String language, String card_nr, String inactive, String notes, String unsubscribe, String coach_id, String tags, String bank_account_number, String bank_account_owner, String us_bank_routing_number, String us_bank_account_type, String us_bank_account_place) {
        super(messageResult, firstname, lastname, birthday, gender, club_member_id, email, phone, mobile, street, street_extra, house_number, house_number_addition, zip, city, member_since, country, language, card_nr, inactive, notes, unsubscribe, coach_id, tags, bank_account_number, bank_account_owner);
        this.us_bank_routing_number = us_bank_routing_number;
        this.us_bank_account_type = us_bank_account_type;
        this.us_bank_account_place = us_bank_account_place;
    }

    public String getUs_bank_routing_number() {
        return us_bank_routing_number;
    }

    public void setUs_bank_routing_number(String us_bank_routing_number) {
        this.us_bank_routing_number = us_bank_routing_number;
    }

    public String getUs_bank_account_type() {
        return us_bank_account_type;
    }

    public void setUs_bank_account_type(String us_bank_account_type) {
        this.us_bank_account_type = us_bank_account_type;
    }

    public String getUs_bank_account_place() {
        return us_bank_account_place;
    }

    public void setUs_bank_account_place(String us_bank_account_place) {
        this.us_bank_account_place = us_bank_account_place;
    }

    /**
     * Converts the object Data to a String
     * @return
     */
    @Override
    public String toString(){
        return
                super.toString() + "," +
                this.getUs_bank_routing_number() + "," +
                this.getUs_bank_account_type() + "," +
                this.getUs_bank_account_place();
    }
}
