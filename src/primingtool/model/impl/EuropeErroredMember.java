package primingtool.model.impl;

import primingtool.model.impl.EuropeMember;

public class EuropeErroredMember extends EuropeMember {

    private String errorMessage = "";


    public EuropeErroredMember() {
    }

    /**
     * Constructor
     *
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
     * @param country
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
    public EuropeErroredMember(String firstname, String lastname, String birthday, String gender, String club_member_id, String email, String phone, String mobile, String street, String street_extra, String house_number, String house_number_addition, String zip, String city, String country, String card_nr, String inactive, String notes, String unsubscribe, String coach_id, String tags, String bank_account_number, String bank_account_owner, String bank_bic_code, String bank_sort_code, String errorMessage) {
        super(firstname, lastname, birthday, gender, club_member_id, email, phone, mobile, street, street_extra, house_number, house_number_addition, zip, city, country, card_nr, inactive, notes, unsubscribe, coach_id, tags, bank_account_number, bank_account_owner, bank_bic_code, bank_sort_code);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Converts the object Data to a String
     * @return
     */
    @Override
    public String toString() {
        return
                super.toString() + "," +
                this.getErrorMessage();
    }
}

