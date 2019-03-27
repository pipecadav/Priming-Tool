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

        String values = "Abhishek,Mahapatra     ,,abhi_nist@yahoo.com,30/06/1984,m,3166280579,Cl 107A # 7C-49,110221,BOGOTA";
        String [] splitValues = values.split(",");
        System.out.println(splitValues[2] + "Empty");




        //theList.addMember(theMember);

        //theMember = (EuropeMember) theList.searchMember(clubmID);

        //theMember.getBank_bic_code();

        //System.out.println(theMember.getBank_bic_code());
        //System.out.println(theMember2.toString());

        //String splitDate [] = birthday.split("[-/.]");







    }
}
