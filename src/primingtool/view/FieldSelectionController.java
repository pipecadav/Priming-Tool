package primingtool.view;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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






    /**
     * Constructor
     */
    public FieldSelectionController() {
    }

    public void initialize(){
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

    private void setColumnOrder(){
        CSVHandler.addValuestoConlumnIndex("firstname", Integer.toString(firstname.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("lastname", Integer.toString(lastname.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("birthday", Integer.toString(birthday.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("gender", Integer.toString(gender.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("club_member_id", Integer.toString(club_member_id.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("email", Integer.toString(email.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("phone", Integer.toString(phone.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("mobile", Integer.toString(mobile.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("street", Integer.toString(street.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("street_extra", Integer.toString(street_extra.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("house_number", Integer.toString(house_number.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("house_number_addition", Integer.toString(house_number_addition.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("zip", Integer.toString(zip.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("city", Integer.toString(city.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("country", Integer.toString(country.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("card_nr", Integer.toString(card_nr.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("inactive", Integer.toString(inactive.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("notes", Integer.toString(notes.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("unsubscribe", Integer.toString(unsubscribe.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("coach_id", Integer.toString(coach_id.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("tags", Integer.toString(tags.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("bank_account_number", Integer.toString(bank_account_number.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("bank_account_owner", Integer.toString(bank_account_owner.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("bank_bic_code", Integer.toString(bank_bic_code.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("bank_sort_code", Integer.toString(bank_sort_code.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("us_bank_routing_number", Integer.toString(us_bank_routing_number.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("us_bank_account_type", Integer.toString(us_bank_account_type.getSelectionModel().getSelectedIndex()));
        CSVHandler.addValuestoConlumnIndex("us_bank_account_place", Integer.toString(us_bank_account_place.getSelectionModel().getSelectedIndex()));



    }

    @FXML
    private void handleDataMappingButton(){
        setColumnOrder();
        memberList.createHeaders();
        memberList.readFileAndCreateMembers();
        //for (int i = 0; i<memberList.getMembers().size(); i++){
        //    System.out.println(memberList.getMembers().get(i).toString());
        //
        //}

        CSVHandler.setOutputFilenames(CSVHandler.getDate(),CSVHandler.getFileName());
        CSVHandler.createFileDirectory();
        CSVHandler.createFile(CSVHandler.successfulFileNamePath, memberList.getMembers());
        CSVHandler.createFile(CSVHandler.erroredFileNamePath, memberList.getErroredMembers());
        CSVHandler.setSuccessfulRecords(memberList.getMembers().size());
        CSVHandler.setErroredRecords(memberList.getErroredMembers().size());
        getPrimingTool().showOverviewPage();

    }


}
