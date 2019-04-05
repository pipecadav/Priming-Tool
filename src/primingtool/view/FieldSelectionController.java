package primingtool.view;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import primingtool.business.CSVHandler;
import primingtool.dao.impl.MemberList;


public class FieldSelectionController extends Controller {

    private MemberList memberList = new MemberList();

    private ObservableList<String> columns = FXCollections.observableArrayList(CSVHandler.getOriginalColumns());

    @FXML
    private JFXComboBox<String> firstname = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> lastname = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> birthday = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> gender = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> club_member_id = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> email = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> phone = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> mobile = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> street = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> street_extra = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> house_number = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> house_number_addition = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> zip = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> city = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> country = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> card_nr = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> inactive = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> notes = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> unsubscribe = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> coach_id = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> tags = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> bank_account_number = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> bank_account_owner = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> bank_bic_code = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> bank_sort_code = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> us_bank_routing_number = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> us_bank_account_type = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> us_bank_account_place = new JFXComboBox<String>();

    @FXML
    private Label firstnameRequired;

    @FXML
    private Label lastRequired;

    @FXML
    private Label clubMemberIdRequired;

    /**
     * Constructor
     */
    public FieldSelectionController() {
    }

    public void initialize() {
        firstname.setItems(columns);
        lastname.setItems(columns);
        birthday.setItems(columns);
        gender.setItems(columns);
        club_member_id.setItems(columns);
        email.setItems(columns);
        phone.setItems(columns);
        mobile.setItems(columns);
        street.setItems(columns);
        street_extra.setItems(columns);
        house_number.setItems(columns);
        house_number_addition.setItems(columns);
        zip.setItems(columns);
        city.setItems(columns);
        country.setItems(columns);
        card_nr.setItems(columns);
        inactive.setItems(columns);
        notes.setItems(columns);
        unsubscribe.setItems(columns);
        coach_id.setItems(columns);
        tags.setItems(columns);
        bank_account_number.setItems(columns);
        bank_account_owner.setItems(columns);
        bank_bic_code.setItems(columns);
        bank_sort_code.setItems(columns);
        us_bank_routing_number.setItems(columns);
        us_bank_account_type.setItems(columns);
        us_bank_account_place.setItems(columns);
    }

    // TODO @pipe how does this work? Is there always one CSV loaded in memory and values are set to those?
    private void setColumnOrder() {
        CSVHandler.addValueToColumn("firstname", getColumnIndex(firstname));
        CSVHandler.addValueToColumn("lastname", getColumnIndex(lastname));
        CSVHandler.addValueToColumn("birthday", getColumnIndex(birthday));
        CSVHandler.addValueToColumn("gender", getColumnIndex(gender));
        CSVHandler.addValueToColumn("club_member_id", getColumnIndex(club_member_id));
        CSVHandler.addValueToColumn("email", getColumnIndex(email));
        CSVHandler.addValueToColumn("phone", getColumnIndex(phone));
        CSVHandler.addValueToColumn("mobile", getColumnIndex(mobile));
        CSVHandler.addValueToColumn("street", getColumnIndex(street));
        CSVHandler.addValueToColumn("street_extra", getColumnIndex(street_extra));
        CSVHandler.addValueToColumn("house_number", getColumnIndex(house_number));
        CSVHandler.addValueToColumn("house_number_addition", getColumnIndex(house_number_addition));
        CSVHandler.addValueToColumn("zip", getColumnIndex(zip));
        CSVHandler.addValueToColumn("city", getColumnIndex(city));
        CSVHandler.addValueToColumn("country", getColumnIndex(country));
        CSVHandler.addValueToColumn("card_nr", getColumnIndex(card_nr));
        CSVHandler.addValueToColumn("inactive", getColumnIndex(inactive));
        CSVHandler.addValueToColumn("notes", getColumnIndex(notes));
        CSVHandler.addValueToColumn("unsubscribe", getColumnIndex(unsubscribe));
        CSVHandler.addValueToColumn("coach_id", getColumnIndex(coach_id));
        CSVHandler.addValueToColumn("tags", getColumnIndex(tags));
        CSVHandler.addValueToColumn("bank_account_number", getColumnIndex(bank_account_number));
        CSVHandler.addValueToColumn("bank_account_owner", getColumnIndex(bank_account_owner));
        CSVHandler.addValueToColumn("bank_bic_code", getColumnIndex(bank_bic_code));
        CSVHandler.addValueToColumn("bank_sort_code", getColumnIndex(bank_sort_code));
        CSVHandler.addValueToColumn("us_bank_routing_number", getColumnIndex(us_bank_routing_number));
        CSVHandler.addValueToColumn("us_bank_account_type", getColumnIndex(us_bank_account_type));
        CSVHandler.addValueToColumn("us_bank_account_place", getColumnIndex(us_bank_account_place));
    }

    private String getColumnIndex(JFXComboBox<String> field) {
        return Integer.toString(field.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void handleDataMappingButton() {
        if (firstname.getSelectionModel().getSelectedIndex() == -1) {
            firstnameRequired.setText("*");
        }
        if (lastname.getSelectionModel().getSelectedIndex() == -1) {
            lastRequired.setText("*");
        }
        if (club_member_id.getSelectionModel().getSelectedIndex() == -1) {
            clubMemberIdRequired.setText("*");
        }

        // TODO @pipe I'm sure you can make this little if-pyramid a bit nicer ;)
        if (firstname.getSelectionModel().getSelectedIndex() != -1) {

            if (lastname.getSelectionModel().getSelectedIndex() != -1) {

                if (club_member_id.getSelectionModel().getSelectedIndex() != -1) {
                    setColumnOrder();

                    memberList.createHeaders();
                    memberList.readFileAndCreateMembers();

                    CSVHandler.setOutputFilenames(CSVHandler.getDate(), CSVHandler.getFileName());
                    CSVHandler.createFileDirectory();
                    CSVHandler.createFile(CSVHandler.successfulRecordFileNamePath, memberList.getMembers());
                    CSVHandler.createFile(CSVHandler.failedRecordFileNamePath, memberList.getFailedMembers());
                    CSVHandler.setSuccessfulRecords(memberList.getMembers().size());
                    CSVHandler.getFailedRecords(memberList.getFailedMembers().size());

                    getPrimingTool().showOverviewPage();

                }

            }

        }

    }

}
