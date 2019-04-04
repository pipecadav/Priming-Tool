package primingtool.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class PrimingRules {

    private static String dateFormatSelected = "";
    private static String regionSelected = "";

    public PrimingRules(){

    }

    /**
     * Checks the validity of an e-mail address.
     * If e-mail is null or empty, returns an empty String
     * If e-mail has common typos like commas or extra spaces, it will be fixed
     * But if the e-mail doesn't have a proper structure, it will return the message Invalid E-mail Address
     * @param email String that represents the email of a member
     * @return resulting fixed e-mail address or invalid response.
     */
    public static String fixEmailFormat(String email) {
        if(email.equals("") || email.trim().isEmpty()){
            if(email.equals("N/A") || email.equals("#N/A")){
                return "";
            }
            return "";
        }else{
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";
            String fixedEmail = email.replaceAll("\\s+","");
            fixedEmail = fixedEmail.replace(",",".");
            Pattern pattern = Pattern.compile(emailRegex);
            if(pattern.matcher(fixedEmail).matches()){
                return fixedEmail;
            }else{
                return "E-mail has invalid Format.";
            }
        }
    }

    /**
     * Makes sure that date values are well formatted
     * @param date
     * @return
     */
    public static String checkDateFormat(String date) {
        if(date.equals("") || date.trim().isEmpty()){
            if(date.equals("N/A") || date.equals("#N/A")){
                return "";
            }
            return "";
        }else{
            switch(PrimingRules.getDateFormatSelected()){
                case "d-m-yyyy":
                    try{
                        date = date.replaceAll("[/.]","-");
                        return convertDate("d-M-yyyy", date);
                    } catch (ParseException dateException){
                        return "value couldn't be converted.";
                    }
                case "m-d-yyyy":
                    try{
                        date = date.replaceAll("[/.]","-");
                        return convertDate("M-d-yyyy", date);
                    } catch (ParseException dateException){
                        return "value couldn't be converted.";
                    }
                case "dd-mm-yyyy":
                    try{
                        date = date.replaceAll("[/.]","-");
                        return convertDate("dd-MM-yyyy", date);
                    } catch (ParseException dateException){
                        return "value couldn't be converted.";
                    }
                case "mm-dd-yyyy":
                    try{
                        date = date.replaceAll("[/.]","-");
                        return convertDate("MM-dd-yyyy", date);
                    } catch (ParseException dateException){
                        return "value couldn't be converted.";
                    }
                case "d/m/yyyy":
                    try{
                        date = date.replaceAll("[-.]","/");
                        return convertDate("d/M/yyyy", date);
                    } catch (ParseException dateException){
                        return "value couldn't be converted.";
                    }
                case "m/d/yyyy":
                    try{
                        date = date.replaceAll("[-.]","/");
                        return convertDate("M/d/yyyy", date);
                    } catch (ParseException dateException){
                        return "value couldn't be converted.";
                    }
                case "dd/mm/yyyy":
                    try{
                        date = date.replaceAll("[-.]","/");
                        return convertDate("dd/MM/yyyy", date);
                    } catch (ParseException dateException){
                        return "value couldn't be converted.";
                    }
                case "mm/dd/yyy":
                    try{
                        date = date.replaceAll("[-.]","/");
                        return convertDate("MM/dd/yyyy", date);
                    } catch (ParseException dateException){
                        return "value couldn't be converted.";
                    }
            }
        }
        return "";
    }

    /**
     * Converts a given date expressed in a String and converts it to dd-MM-yyyy
     * @param pattern valid patter for Java Date Formatter
     * @param date date represented in a String value
     * @return
     * @throws ParseException when the date couldn't be formatted
     */
    private static String convertDate(String pattern, String date) throws ParseException {
        SimpleDateFormat wrongFormat = new SimpleDateFormat(pattern);
        Date inputDate = wrongFormat.parse(date);
        DateFormat correctFormat = new SimpleDateFormat("dd-MM-yyyy");
        return correctFormat.format(inputDate);
    }

    /**
     * Trims and converts a gender value to a char.
     * @param gender Male or Female
     * @return a single char reference to the gender m or f
     */
    public static String convertGenderToLowCase(String gender) {
        if(gender.equals("") || gender.trim().isEmpty()){
            return "";
        }else{
            char trimmedGender = gender.charAt(0);
            return Character.toString(Character.toLowerCase(trimmedGender));
        }
    }

    /**
     * Converts the status of the client to binary 0 or 1
     * @param active status of the member
     * @return Error if no value was added, 1 = inactive, 0 = active
     */
    public static String isActiveClient(String active){
        if(active.equals("") || active.trim().isEmpty()){
            return "Please Indicate if client is active.";
        }else {
            switch (active.trim().toLowerCase()){
                case "yes":
                    return "0";
                case "ja":
                    return "0";
                case "si":
                    return "0";
                case "oui":
                    return "0";
                case "sì":
                    return "0";
                case "sim":
                    return "0";
                case "sí":
                    return "0";
                case "0":
                    return "0";
                default:
                    return "1";
            }
        }

    }

    /**
     * Makes sure that the Routing Number for US meets size and form.
     * In this order, US Routing Number must be 9 Digits
     * @param routingNumber Routing number in the record
     * @return Routing number if valid, Error if Routing number is not valid
     */
    public static String validateRoutingNumber(String routingNumber){
        if(routingNumber.equals("") || routingNumber.trim().isEmpty()){
            return "";
        }else{
            if((routingNumber.trim().length() == 9) && (routingNumber.trim().matches("^[0-9]*$")) ){
                return routingNumber.trim();
            }else{
                return "Routing Number is invalid.";
            }
        }
    }

    /**
     * Makes sure that Account Number meets US requirements in size and form.
     * In this order, US Account Number must be between 4 and 18 Digits.
     * @param accountNumber Account Number in the Record
     * @return Account Number if valid, Error if Account Number is not valid
     */
    public static String validateAccountNumber(String accountNumber){
        if(accountNumber.equals("") || accountNumber.trim().isEmpty()){
            return "";
        }else{
            if((accountNumber.trim().length() >= 4) && (accountNumber.trim().length() <= 18)){
                return accountNumber.trim();
            }else {
                return "Account Number must have between 4 and 18 digits.";
            }
        }
    }

    /**
     * Returns the date format that was used in the original import file
     * @return date formate pattern
     */
    public static String getDateFormatSelected() {
        return dateFormatSelected;
    }

    /**
     * Sets the date format that was used in the original import file
     * @param dateFormatSelected
     */
    public static void setDateFormatSelected(String dateFormatSelected) {
         PrimingRules.dateFormatSelected = dateFormatSelected;
    }

    /**
     * The member import file varies depending on the region
     * This method retrieves the region that was selected for the import file template
     * @return Region selected such as, Northam, Europe or Other.
     */
    public static String getRegionSelected() {
        return regionSelected;
    }

    /**
     * The member import file varies depending on the region
     * This method sets the region of the import file template
     * @param regionSelected
     */
    public static void setRegionSelected(String regionSelected) {
        PrimingRules.regionSelected = regionSelected;
    }







}
