package primingtool.model.impl;

public class USErroredMember extends USMember {

    private String errorMessage = "";


    public USErroredMember() {
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
     * @param us_bank_routing_number
     * @param us_bank_account_type
     * @param us_bank_account_place
     */
    public USErroredMember(String firstname, String lastname, String birthday, String gender, String club_member_id, String email, String phone, String mobile, String street, String street_extra, String house_number, String house_number_addition, String zip, String city, String country, String card_nr, String inactive, String notes, String unsubscribe, String coach_id, String tags, String bank_account_number, String bank_account_owner, String us_bank_routing_number, String us_bank_account_type, String us_bank_account_place, String erroMessage) {
        super(firstname, lastname, birthday, gender, club_member_id, email, phone, mobile, street, street_extra, house_number, house_number_addition, zip, city, country, card_nr, inactive, notes, unsubscribe, coach_id, tags, bank_account_number, bank_account_owner, us_bank_routing_number, us_bank_account_type, us_bank_account_place);
        this.errorMessage = erroMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return
                super.toString() + "," +
                this.getErrorMessage();
    }
}
