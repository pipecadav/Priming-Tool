package primingtool.model;

/*
 * Super class that stores the object member with all the variables a member import could contain.
 * This class doesn't store any variables
 */

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// TODO @pipe look at the Builder pattern. That seems like a good way to
//  handle this Member/USMember/EuropeMember abstraction as well as the ErroredMember. Because this subclassing is not so nice ;)
public class Member {

    private String firstName = "";
    private String lastName = "";
    private String birthday = "";
    private String gender = "";
    private String clubMemberId = "";
    private String email = "";
    private String phone = "";
    private String mobile = "";
    private String street = "";
    private String streetExtra = "";
    private String houseNumber = "";
    private String houseNumberAddition = "";
    private String zip = "";
    private String city = "";
    private String country = "";
    private String cardNumber = "";
    private String inactive = "";
    private String notes = "";
    private String unsubscribeDate = "";
    private String coachId = "";
    private String tags = "";
    private String bankAccountNumber = "";
    private String bankAccountOwner = "";


    /**
     * Constructor
     */
    public Member() {

    }

    /**
     * Constructor with all Parameters
     * @param firstName
     * @param lastName
     * @param birthday
     * @param gender
     * @param clubMemberId
     * @param email
     * @param phone
     * @param mobile
     * @param street
     * @param streetExtra
     * @param houseNumber
     * @param houseNumberAddition
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
     */
    public Member(String firstName, String lastName, String birthday, String gender, String clubMemberId, String email, String phone, String mobile, String street, String streetExtra, String houseNumber, String houseNumberAddition, String zip, String city, String country, String cardNumber, String inactive, String notes, String unsubscribeDate, String coachId, String tags, String bankAccountNumber, String bankAccountOwner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.clubMemberId = clubMemberId;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.street = street;
        this.streetExtra = streetExtra;
        this.houseNumber = houseNumber;
        this.houseNumberAddition = houseNumberAddition;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.cardNumber = cardNumber;
        this.inactive = inactive;
        this.notes = notes;
        this.unsubscribeDate = unsubscribeDate;
        this.coachId = coachId;
        this.tags = tags;
        this.bankAccountNumber = bankAccountNumber;
        this.bankAccountOwner = bankAccountOwner;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getClubMemberId() {
        return clubMemberId;
    }

    public void setClubMemberId(String clubMemberId) {
        this.clubMemberId = clubMemberId;
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

    public String getStreetExtra() {
        return streetExtra;
    }

    public void setStreetExtra(String street_extra) {
        this.streetExtra = street_extra;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumberAddition() {
        return houseNumberAddition;
    }

    public void setHouseNumberAddition(String houseNumberAddition) {
        this.houseNumberAddition = houseNumberAddition;
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

    public String getCardNumber() {
        return cardNumber;
    }

    // TODO @pipe keep the shortenings/acronyms to a minimum :)
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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

    public String getUnsubscribeDate() {
        return unsubscribeDate;
    }

    public void setUnsubscribeDate(String unsubscribeDate) {
        this.unsubscribeDate = unsubscribeDate;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountOwner() {
        return bankAccountOwner;
    }

    public void setBankAccountOwner(String bankAccountOwner) {
        this.bankAccountOwner = bankAccountOwner;
    }

    // TODO @pipe, see if this works instead! :D
    /**
     * Converts the object Data to a String
     * @return
     */
    @Override
    public String toString(){
        List<String> fieldValues = new ArrayList<>();

        try {

            Class<?> thisClass = Class.forName(getClass().getName());

            Field[] fields = thisClass.getDeclaredFields();

            for(Field field : fields){
                fieldValues.add(field.get(this).toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.join(",", fieldValues);
    }

}
