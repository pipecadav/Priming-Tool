package primingtool.business.impl;

import primingtool.business.CSVHandler;
import primingtool.data.Operation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class MemberRulesImpl {

    private static String DATE_FORMAT_SELECTED = "";
    private static String REGION_SELECTED = "";

    public MemberRulesImpl() {
    }

    public void findDuplicates() {

    }

    /**
     * Returns the date format that was used in the original import file
     *
     * @return date formate pattern
     */
    public static String getDateFormatSelected() {
        return DATE_FORMAT_SELECTED;
    }

    // TODO @pipe Why set a static? Can you use the instance of this class and make it a member variable?
    /**
     * Sets the date format that was used in the original import file
     *
     * @param dateFormatSelected
     */
    public static void setDateFormatSelected(String dateFormatSelected) {
        MemberRulesImpl.DATE_FORMAT_SELECTED = dateFormatSelected;
    }

    /**
     * The member import file varies depending on the region
     * This method retrieves the region that was selected for the import file template
     *
     * @return Region selected such as, Northam, Europe or Other.
     */
    public static String getRegionSelected() {
        return REGION_SELECTED;
    }

    /**
     * The member import file varies depending on the region
     * This method sets the region of the import file template
     *
     * @param regionSelected
     */
    public static void setRegionSelected(String regionSelected) {
        MemberRulesImpl.REGION_SELECTED = regionSelected;
    }

    public static String[] primeFields(String member) {
        String[] memberRecords = member.split(",");

        for (int i = 0; i < memberRecords.length; i++) {
            memberRecords[i] = trimFields(memberRecords[i].trim());
        }

        primeWhenGiven(memberRecords, "email", MemberRulesImpl::fixEmailFormat);
        primeWhenGiven(memberRecords, "birthday", MemberRulesImpl::fixDateFormat);
        primeWhenGiven(memberRecords, "unsubscribe", MemberRulesImpl::fixDateFormat);
        primeWhenGiven(memberRecords, "gender", MemberRulesImpl::convertGenderToLowCase);

        return memberRecords;
    }

    /**
     * Makes sure that every field doesn't have extra spaces
     *
     * @param value Any field brought from the member object
     * @return Trimmed field
     */
    private static String trimFields(String value) {
        return value.trim();
    }

    private static void primeWhenGiven(String[] records, String columnName, Operation<String, String> operation) {

        if (CSVHandler.hasValueFor(columnName)) {
            int index = CSVHandler.getIndexFor(columnName);
            records[index] = operation.apply(records[index]);
        }

    }

    /**
     * Checks the validity of an e-mail address.
     * If e-mail is null or empty, returns an empty String
     * If e-mail has common typos like commas or extra spaces, it will be fixed
     * But if the e-mail doesn't have a proper structure, it will return the message Invalid E-mail Address
     *
     * @param email String that represents the email of a member
     * @return resulting fixed e-mail address or invalid response.
     */
    private static String fixEmailFormat(String email) {
        if ((email != null) || (!email.equals(""))) {

            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";

            String fixedEmail = email.replaceAll("\\s+", "");

            fixedEmail = fixedEmail.replace(",", ".");

            Pattern pattern = Pattern.compile(emailRegex);

            if (pattern.matcher(fixedEmail).matches()) {
                return fixedEmail;
            } else {
                return "Invalid E-mail";
            }

        }

        return "";
    }

    // TODO @pipe I move this below here, in general it's a good rule of thumb to put methods below the method
    //  that calls it. In this case primeWhenGiven & fixDateFormat below, primeFields. Keeps it readable. Now after
    //  I reordered a bit more. You can see that all the public methods are at the start of the class. This makes
    //  it clear for future use because when opening the class you can more easily read what the intended use of
    //  the class is by looking at it's public methods.

    /**
     * Makes sure that date values are well formatted
     *
     * @param date
     * @return
     */
    private static String fixDateFormat(String date) {
        if (date.equals("")) {
            return "";

        } else {
            switch (MemberRulesImpl.DATE_FORMAT_SELECTED) {
                case "d-m-yyyy":
                    return convertDateSafe("d-M-yyyy", date);
                case "m-d-yyyy":
                    return convertDateSafe("M-d-yyyy", date);
                case "dd-mm-yyyy":
                    return date.replaceAll("[-/.]", "-");
                case "mm-dd-yyyy":
                    return convertDateSafe("MM-dd-yyyy", date);
                case "d/m/yyyy":
                    return convertDateSafe("d/M/yyyy", date);
                case "m/d/yyyy":
                    return convertDateSafe("M/d/yyyy", date);
                case "dd/mm/yyyy":
                    return date.replaceAll("[-/.]", "-");
                case "mm/dd/yyy":
                    return convertDateSafe("MM/dd/yyyy", date);
            }
        }

        return "";
    }

    private static String convertDateSafe(String pattern, String date) {
        try {
            return convertDate(pattern, date);
        } catch (ParseException dateException) {
            dateException.printStackTrace();
            return "";
        }
    }

    /**
     * Converts a given date expressed in a String and converts it to dd-MM-yyyy
     *
     * @param pattern valid patter for Java Date Formatter
     * @param date    date represented in a String value
     * @return
     * @throws ParseException
     */
    private static String convertDate(String pattern, String date) throws ParseException {
        SimpleDateFormat fromFormat = new SimpleDateFormat(pattern);
        Date inputDate = fromFormat.parse(date);

        DateFormat toFormat = new SimpleDateFormat("dd-MM-yyyy");

        return toFormat.format(inputDate);
    }

    // TODO @pipe don't compare strings with the == since this will check their equality
    //  by the reference of the object in memory not the value. And when using 'equal' but the
    //  empty string "" as first otherwise it'll cause crashes when the String object is null.
    /**
     * Trims and converts a gender value to a char.
     *
     * @param gender Male or Female
     * @return a single char reference to the gender m or f
     */
    private static String convertGenderToLowCase(String gender) {
        if ("".equals(gender)) {
            return "";
        } else {
            char trimmedGender = gender.charAt(0);
            return Character.toString(Character.toLowerCase(trimmedGender));
        }
    }

}