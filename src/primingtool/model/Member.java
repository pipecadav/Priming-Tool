package primingtool.model;

/*
 * Super class that stores the object member with all the variables a member import could contain.
 *
 */

public class Member {

    private String messageResult = "";
    private String firstname = "";
    private String lastname = "";
    private String birthday = "";
    private String gender = "";
    private String club_member_id = "";
    private String email = "";
    private String phone = "";
    private String mobile = "";
    private String street = "";
    private String street_extra = "";
    private String house_number = "";
    private String house_number_addition = "";
    private String zip = "";
    private String city = "";
    private String member_since = "";
    private String country = "";
    private String language = "";
    private String card_nr = "";
    private String inactive = "";
    private String notes = "";
    private String unsubscribe = "";
    private String coach_id = "";
    private String tags = "";
    private String bank_account_number = "";
    private String bank_account_owner = "";


    /**
     * Constructor
     */
    public Member() {

    }

    /**
     * Constructor with all Parameters
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
     */
    public Member(String messageResult, String firstname, String lastname, String birthday, String gender, String club_member_id, String email, String phone, String mobile, String street, String street_extra, String house_number, String house_number_addition, String zip, String city, String member_since, String country, String language, String card_nr, String inactive, String notes, String unsubscribe, String coach_id, String tags, String bank_account_number, String bank_account_owner) {
        this.messageResult = messageResult;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.gender = gender;
        this.club_member_id = club_member_id;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.street = street;
        this.street_extra = street_extra;
        this.house_number = house_number;
        this.house_number_addition = house_number_addition;
        this.zip = zip;
        this.city = city;
        this.member_since = member_since;
        this.country = country;
        this.language = language;
        this.card_nr = card_nr;
        this.inactive = inactive;
        this.notes = notes;
        this.unsubscribe = unsubscribe;
        this.coach_id = coach_id;
        this.tags = tags;
        this.bank_account_number = bank_account_number;
        this.bank_account_owner = bank_account_owner;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClub_member_id() {
        return club_member_id;
    }

    public void setClub_member_id(String club_member_id) {
        this.club_member_id = club_member_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_extra() {
        return street_extra;
    }

    public void setStreet_extra(String street_extra) {
        this.street_extra = street_extra;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getHouse_number_addition() {
        return house_number_addition;
    }

    public void setHouse_number_addition(String house_number_addition) {
        this.house_number_addition = house_number_addition;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCard_nr() {
        return card_nr;
    }

    public void setCard_nr(String card_nr) {
        this.card_nr = card_nr;
    }

    public String getInactive() {
        return inactive;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUnsubscribe() {
        return unsubscribe;
    }

    public void setUnsubscribe(String unsubscribeDate) {
        this.unsubscribe = unsubscribeDate;
    }

    public String getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(String coach_id) {
        this.coach_id = coach_id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getBank_account_number() {
        return bank_account_number;
    }

    public void setBank_account_number(String bank_account_number) {
        this.bank_account_number = bank_account_number;
    }

    public String getBank_account_owner() {
        return bank_account_owner;
    }

    public void setBank_account_owner(String bank_account_owner) {
        this.bank_account_owner = bank_account_owner;
    }

    public String getMessageResult() {
        return messageResult;
    }

    public void setMessageResult(String messageResult) {
        this.messageResult = messageResult;
    }

    public String getMember_since() {
        return member_since;
    }

    public void setMember_since(String member_since) {
        this.member_since = member_since;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Converts the object Data to a String
     * @return
     */
    @Override
    public String toString(){
            return
                    this.getMessageResult() + "," +
                            this.getFirstname() + "," +
                            this.getLastname() + "," +
                            this.getBirthday() + "," +
                            this.getGender() + "," +
                            this.getClub_member_id() + "," +
                            this.getEmail() + "," +
                            this.getPhone() + "," +
                            this.getMobile() + "," +
                            this.getStreet() + "," +
                            this.getStreet_extra() + "," +
                            this.getHouse_number() + "," +
                            this.getHouse_number_addition() + "," +
                            this.getZip() + "," +
                            this.getCity() + "," +
                            this.getMember_since() + "," +
                            this.getCountry() + "," +
                            this.getLanguage() + "," +
                            this.getCard_nr() + "," +
                            this.getInactive() + "," +
                            this.getNotes() + "," +
                            this.getUnsubscribe() + "," +
                            this.getCoach_id() + "," +
                            this.getTags() + "," +
                            this.getBank_account_number() + "," +
                            this.getBank_account_owner();
    }

}
