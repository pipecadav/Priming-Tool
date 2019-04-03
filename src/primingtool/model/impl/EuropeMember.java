package primingtool.model.impl;

/* This class creates an object member with additional attributes that are only applicable to EUROPA
 * It contains the Bic Code and Sort Code
 * This class extends Member and therefore contains all its attributes
 */

import primingtool.model.Member;

public class EuropeMember extends Member {

    private String bank_bic_code = "";
    private String bank_sort_code = "";

    public EuropeMember() {
    }

    /**
     * Constructor
     * @param bank_bic_code
     * @param bank_sort_code
     */
    public EuropeMember(String bank_bic_code, String bank_sort_code) {
        this.bank_bic_code = bank_bic_code;
        this.bank_sort_code = bank_sort_code;
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
     * @param bank_bic_code
     * @param bank_sort_code
     */
    public EuropeMember(String messageResult, String firstname, String lastname, String birthday, String gender, String club_member_id, String email, String phone, String mobile, String street, String street_extra, String house_number, String house_number_addition, String zip, String city, String member_since, String country, String language, String card_nr, String inactive, String notes, String unsubscribe, String coach_id, String tags, String bank_account_number, String bank_account_owner, String bank_bic_code, String bank_sort_code) {
        super(messageResult, firstname, lastname, birthday, gender, club_member_id, email, phone, mobile, street, street_extra, house_number, house_number_addition, zip, city, member_since, country, language, card_nr, inactive, notes, unsubscribe, coach_id, tags, bank_account_number, bank_account_owner);
        this.bank_bic_code = bank_bic_code;
        this.bank_sort_code = bank_sort_code;
    }

    public String getBank_bic_code() {
        return bank_bic_code;
    }

    public void setBank_bic_code(String bank_bic_code) {
        this.bank_bic_code = bank_bic_code;
    }

    public String getBank_sort_code() {
        return bank_sort_code;
    }

    public void setBank_sort_code(String bank_sort_code) {
        this.bank_sort_code = bank_sort_code;
    }

    /**
     * Converts the object Data to a String
     * @return
     */
    @Override
    public String toString() {
        return
                super.toString().replaceAll(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)",";") + ";" +
                this.getBank_bic_code() + ";" +
                this.getBank_sort_code();
    }
}
