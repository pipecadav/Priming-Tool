import primingtool.model.impl.EuropeMember;

public class MainTest {

    public static void main(String[] args) {


        String firstName = "test",
                lastName = "test",
                birthday = "test",
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
                unsubscribed = "test",
                coachId = "test",
                tags = "test",
                bankAccount = "test",
                bankAccountO = "test",
                bic = "test",
                sortCode = "test";
        char gender = 't';





        EuropeMember theMember;
        EuropeMember theMember2;


        theMember = new EuropeMember(firstName, lastName, birthday, gender, clubmID, emai, phone, cell,
                street, extra, houseNumber, extrahouse, zip, city, country, cardN,
                inactive, notes, unsubscribed, coachId, tags, bankAccount,
                bankAccountO, bic, sortCode);
        theMember2 = new EuropeMember(bic, sortCode);


        System.out.println(theMember.toString());
        System.out.println(theMember2.toString());

    }
}
