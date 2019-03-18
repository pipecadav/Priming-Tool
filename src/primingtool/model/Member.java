package primingtool.model;


public class Member {

    private String firstName;
    private String lastName;
    private String birthday;
    private char gender;
    private String clubMemberId;
    private String eMail;
    private String phone;
    private String mobile;
    private String street;
    private String streetExtra;
    private String houseNumber;
    private String houseNunberExtra;
    private String zip;
    private String city;
    private String country;
    private String cardNumber;
    private String inactive;
    private String notes;
    private String unsubscribeDate;
    private String coachId;
    private String tags;
    private String bankAccountNumber;
    private String bankAccountOwner;


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
     */
    public Member(String firstName, String lastName, String birthday, char gender, String clubMemberId, String eMail, String phone, String mobile, String street, String streetExtra, String houseNumber, String houseNunberExtra, String zip, String city, String country, String cardNumber, String inactive, String notes, String unsubscribeDate, String coachId, String tags, String bankAccountNumber, String bankAccountOwner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.clubMemberId = clubMemberId;
        this.eMail = eMail;
        this.phone = phone;
        this.mobile = mobile;
        this.street = street;
        this.streetExtra = streetExtra;
        this.houseNumber = houseNumber;
        this.houseNunberExtra = houseNunberExtra;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getClubMemberId() {
        return clubMemberId;
    }

    public void setClubMemberId(String clubMemberId) {
        this.clubMemberId = clubMemberId;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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

    public void setStreetExtra(String streetExtra) {
        this.streetExtra = streetExtra;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNunberExtra() {
        return houseNunberExtra;
    }

    public void setHouseNunberExtra(String houseNunberExtra) {
        this.houseNunberExtra = houseNunberExtra;
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

    @Override
    public String toString(){
            return
                    this.getFirstName() + "," +
                            this.getLastName() + "," +
                            this.getBirthday() + "," +
                            this.getGender() + "," +
                            this.getClubMemberId() + "," +
                            this.geteMail() + "," +
                            this.getPhone() + "," +
                            this.getMobile() + "," +
                            this.getStreet() + "," +
                            this.getStreetExtra() + "," +
                            this.getHouseNumber() + "," +
                            this.getHouseNunberExtra() + "," +
                            this.getZip() + "," +
                            this.getCity() + "," +
                            this.getCountry() + "," +
                            this.getCardNumber() + "," +
                            this.getInactive() + "," +
                            this.getNotes() + "," +
                            this.getUnsubscribeDate() + "," +
                            this.getCoachId() + "," +
                            this.getTags() + "," +
                            this.getBankAccountNumber() + "," +
                            this.getBankAccountOwner();
    }

}
