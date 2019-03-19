package primingtool.business.impl;


import primingtool.business.MemberBusinessRules;
import primingtool.dao.impl.MemberList;

import java.io.File;
import java.util.regex.Pattern;

public class MemberRulesImpl implements MemberBusinessRules {

    private File originalImportFile;
    private MemberList memberList;

    public MemberRulesImpl(File file){
        this.originalImportFile = file;
    }

    @Override
    public void AddMemberfromFile() {


    }

    @Override
    public void readFile() {

    }


    /**
     * Checks the validity of an e-mail address.
     * If e-mail is null or empty, returns an empty String
     * If e-mail has common typos like commas or extra spaces, it will be fixed
     * But if the e-mail doesn't have a proper structure, it will return the message Invalid E-mail Address
     * @param email String that represents the email of a member
     * @return resulting trimmed e-mail address or invalid response.
     */
    public String fixEmailFormat(String email) {
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

    @Override
    public void findDuplicates() {

    }

    @Override
    public String checkDateFormat(String dateformat, String date) {
        String splitDate [] = date.split("[-/.]");

        switch(dateformat){
            case "dd-mm-yyyy":
                return date.replaceAll("[-/.]","-");
            case "mm-dd-yyy":
                //String splitDate [] = date.split("[-/.]");
                //return splitDate[1] + "-" + splitDate[0]
        }
        return "";
    }

    /**
     * Converts the gender to LowCase
     * @param gender
     * @return
     */
    public char convertGenderToLowCase(char gender) {
        return Character.toLowerCase(gender);
    }


    /**
     * Makes sure that every field doesn't have extra spaces
     * @param value Any field brought from the member object
     * @return Trimmed field
     */
    public String trimFields(String value) {
        return value.trim();
    }

    public String getOriginalImportFile() {
        return originalImportFile.getAbsolutePath();
    }
}
