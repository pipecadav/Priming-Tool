package primingtool.business;

import java.io.File;

public interface MemberBusinessRules {

    void AddMemberfromFile();
    void readFile();
    String fixEmailFormat(String email);
    void findDuplicates();
    String checkDateFormat(String dateFormat, String date);
    char convertGenderToLowCase(char gender);
    String trimFields(String value);




}
