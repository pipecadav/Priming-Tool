package primingtool.control;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import primingtool.business.CSVHandler;
import primingtool.dao.impl.MemberList;


public class FieldSelectionController extends Controller {

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
    private JFXComboBox <String> member_since = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> country = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> language = new JFXComboBox<String>();

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

    @FXML
    private Label errorMessage;

    /**
     * Constructor
     */
    public FieldSelectionController() {
    }

    public void initialize(){
        //Pending: How can I simplify this?
        firstname.setItems(columns);
        clearComboBox(firstname);

        lastname.setItems(columns);
        clearComboBox(lastname);

        birthday.setItems(columns);
        clearComboBox(birthday);

        gender.setItems(columns);
        clearComboBox(gender);

        club_member_id.setItems(columns);
        clearComboBox(club_member_id);

        email.setItems(columns);
        clearComboBox(email);

        phone.setItems(columns);
        clearComboBox(phone);

        mobile.setItems(columns);
        clearComboBox(mobile);

        street.setItems(columns);
        clearComboBox(street);

        street_extra.setItems(columns);
        clearComboBox(street_extra);

        house_number.setItems(columns);
        clearComboBox(house_number);

        house_number_addition.setItems(columns);
        clearComboBox(house_number_addition);

        zip.setItems(columns);
        clearComboBox(zip);

        city.setItems(columns);
        clearComboBox(city);

        member_since.setItems(columns);
        clearComboBox(member_since);

        country.setItems(columns);
        clearComboBox(country);

        language.setItems(columns);
        clearComboBox(language);

        card_nr.setItems(columns);
        clearComboBox(card_nr);

        inactive.setItems(columns);
        clearComboBox(inactive);

        notes.setItems(columns);
        clearComboBox(notes);

        unsubscribe.setItems(columns);
        clearComboBox(unsubscribe);

        coach_id.setItems(columns);
        clearComboBox(coach_id);

        tags.setItems(columns);
        clearComboBox(tags);

        bank_account_number.setItems(columns);
        clearComboBox(bank_account_number);

        bank_account_owner.setItems(columns);
        clearComboBox(bank_account_owner);

        bank_bic_code.setItems(columns);
        clearComboBox(bank_bic_code);

        bank_sort_code.setItems(columns);
        clearComboBox(bank_sort_code);

        us_bank_routing_number.setItems(columns);
        clearComboBox(us_bank_routing_number);

        us_bank_account_type.setItems(columns);
        clearComboBox(us_bank_account_type);

        us_bank_account_place.setItems(columns);
        clearComboBox(us_bank_account_place);
    }

    private void setColumnOrder(){
        CSVHandler.addValuestoConlumnIndex("firstname", firstname.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("lastname", lastname.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("birthday", birthday.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("gender", gender.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("club_member_id", club_member_id.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("email", email.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("phone", phone.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("mobile", mobile.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("street", street.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("street_extra", street_extra.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("house_number", house_number.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("house_number_addition", house_number_addition.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("zip", zip.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("city", city.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("member_since", member_since.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("country", country.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("language", language.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("card_nr", card_nr.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("inactive", inactive.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("notes", notes.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("unsubscribe", unsubscribe.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("coach_id", coach_id.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("tags", tags.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("bank_account_number", bank_account_number.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("bank_account_owner", bank_account_owner.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("bank_bic_code", bank_bic_code.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("bank_sort_code", bank_sort_code.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("us_bank_routing_number", us_bank_routing_number.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("us_bank_account_type", us_bank_account_type.getSelectionModel().getSelectedIndex());
        CSVHandler.addValuestoConlumnIndex("us_bank_account_place", us_bank_account_place.getSelectionModel().getSelectedIndex());
    }

    private void runPriming(){
        setColumnOrder();

        MemberList memberList = new MemberList();
        memberList.createHeaders();
        memberList.readFileAndCreateMembers();

        CSVHandler.setOutputFilenames(CSVHandler.getDate(),CSVHandler.getFileName());
        CSVHandler.createFileDirectory();
        CSVHandler.createFile(CSVHandler.successfulFileNamePath, memberList.getMembers());
        CSVHandler.createFile(CSVHandler.erroredFileNamePath, memberList.getErroredMembers());
        CSVHandler.setSuccessfulRecords(memberList.getMembers().size()-1);
        CSVHandler.setErroredRecords(memberList.getErroredMembers().size()-1);
        memberList.getMembers().clear();
        memberList.getErroredMembers().clear();
        getPrimingTool().showOverviewPage();
    }

    @FXML
    private void handleDataMappingButton(){

        if(firstname.getSelectionModel().getSelectedIndex() != -1){
            if(lastname.getSelectionModel().getSelectedIndex() != -1){
                if(club_member_id.getSelectionModel().getSelectedIndex() != -1){
                    runPriming();
                }else {
                    errorMessage.setVisible(true);
                }
            }else {
                errorMessage.setVisible(true);
            }
        }else {
            errorMessage.setVisible(true);
        }
    }


}
