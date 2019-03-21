import primingtool.business.impl.MemberRulesImpl;
import primingtool.dao.impl.MemberList;
import primingtool.model.impl.EuropeMember;

public class MainTest {

    public static void main(String[] args) {


        String firstName = "test",
                lastName = "test",
                birthday = "08-10-2018/48/20.25",
                clubmID = "test",
                emai = "test",
                phone = "test",
                cell = "test",
                street = "test",
                extra = "test",
                houseNumber = "test",
                extrahouse = "test",
                zip = "test",
                city = "test",
                country = "test",
                cardN = "test",
                inactive = "test",
                notes = "test",
                unsubscribed = "8-10-2018",
                coachId = "test",
                tags = "test",
                bankAccount = "test",
                bankAccountO = "test",
                bic = "it's saved even if Casted",
                sortCode = "This is also saved";
        char gender = 't';





        EuropeMember theMember;
        EuropeMember theMember2;

        MemberList theList = new MemberList();






        theMember = new EuropeMember(firstName, lastName, birthday, gender, clubmID, emai, phone, cell,
                street, extra, houseNumber, extrahouse, zip, city, country, cardN,
                inactive, notes, unsubscribed, coachId, tags, bankAccount,
                bankAccountO, bic, sortCode);
        theMember2 = new EuropeMember(bic, sortCode);

        //theList.addMember(theMember);

        //theMember = (EuropeMember) theList.searchMember(clubmID);

        //theMember.getBicCode();

        //System.out.println(theMember.getBicCode());
        //System.out.println(theMember2.toString());

        //String splitDate [] = birthday.split("[-/.]");







    }
}
