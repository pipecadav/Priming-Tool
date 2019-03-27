package primingtool.business.impl;


import primingtool.business.CSVHandler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class MemberRulesImpl {

    private static String dateFormatSelected = "";
    private static String regionSelected = "";

    public MemberRulesImpl(){
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
        if((email != null) || (!email.equals(""))){
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
                return "Invalid E-mail";
            }

        }
        return "";
    }


    public void findDuplicates() {

    }

    /**
     * Makes sure that date values are well formatted
     * @param date
     * @return
     */
    public static String checkDateFormat(String date) {
        if(date.equals("")){
            return "";
        }else{
            switch(MemberRulesImpl.dateFormatSelected){
                case "d-m-yyyy":
                    try{
                        return convertDate("d-M-yyyy", date);
                    } catch (ParseException dateException){
                        dateException.printStackTrace();
                        return "";
                    }
                case "m-d-yyyy":
                    try{
                        convertDate("M-d-yyyy", date);
                    } catch (ParseException dateException){
                        dateException.printStackTrace();
                        return "";
                    }
                case "dd-mm-yyyy":
                    return date.replaceAll("[-/.]","-");
                case "mm-dd-yyyy":
                    try{
                        return convertDate("MM-dd-yyyy", date);
                    } catch (ParseException dateException){
                        dateException.printStackTrace();
                        return "";
                    }
                case "d/m/yyyy":
                    try{
                        return convertDate("d/M/yyyy", date);
                    } catch (ParseException dateException){
                        dateException.printStackTrace();
                        return "";
                    }
                case "m/d/yyyy":
                    try{
                        return convertDate("M/d/yyyy", date);
                    } catch (ParseException dateException){
                        dateException.printStackTrace();
                        return "";
                    }
                case "dd/mm/yyyy":
                    return date.replaceAll("[-/.]","-");
                case "mm/dd/yyy":
                    try{
                        return convertDate("MM/dd/yyyy", date);
                    } catch (ParseException dateException){
                        dateException.printStackTrace();
                        return "";
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
     * @throws ParseException
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
        if(gender == ""){
            return "";
        }else{
            char trimmedGender = gender.charAt(0);
            return Character.toString(Character.toLowerCase(trimmedGender));
        }
    }

    /**
     * Makes sure that every field doesn't have extra spaces
     * @param value Any field brought from the member object
     * @return Trimmed field
     */
    public static String trimFields(String value) {
        return value.trim();
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
         MemberRulesImpl.dateFormatSelected = dateFormatSelected;
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
        MemberRulesImpl.regionSelected = regionSelected;
    }


    public static String [] primeFields(String member){
        String [] memberRecords = member.split(",");
        for(int i=0; i<memberRecords.length; i++){
            memberRecords[i] = MemberRulesImpl.trimFields(memberRecords[i]);
        }
        if(!CSVHandler.getColumnsIndex().get("email").equals("-1")){
            int emailIndex = Integer.parseInt(CSVHandler.getColumnsIndex().get("email"));
            memberRecords[emailIndex] = MemberRulesImpl.fixEmailFormat(memberRecords[emailIndex]);
        }
        if(!CSVHandler.getColumnsIndex().get("birthday").equals("-1")){
            int birthdayIndex = Integer.parseInt(CSVHandler.getColumnsIndex().get("birthday"));
            memberRecords[birthdayIndex] = MemberRulesImpl.checkDateFormat(memberRecords[birthdayIndex]);
        }
        if(!CSVHandler.getColumnsIndex().get("unsubscribe").equals("-1")){
            int unsubscribeIndex = Integer.parseInt(CSVHandler.getColumnsIndex().get("unsubscribe"));
            memberRecords[unsubscribeIndex] = MemberRulesImpl.checkDateFormat(memberRecords[unsubscribeIndex]);
        }
        if(!CSVHandler.getColumnsIndex().get("gender").equals("-1")){
            int genderIndex = Integer.parseInt(CSVHandler.getColumnsIndex().get("gender"));
            memberRecords[genderIndex] = MemberRulesImpl.convertGenderToLowCase(memberRecords[genderIndex]);
        }
        return memberRecords;
    }






}
