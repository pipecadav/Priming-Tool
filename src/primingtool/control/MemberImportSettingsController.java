/*
 * CONTROLLER OF THE MEMBER IMPORT SETTINGS PAGE
 *
 * This controller handles the view for the the Member Import Settings Page:
 *  - Installs the tooltips for help
 *  - Shows the Drop down Menus for Region and Date format with the options to choose from
 *
 */

package primingtool.control;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import primingtool.business.CSVHandler;
import primingtool.business.PrimingRules;

public class MemberImportSettingsController extends Controller {


    @FXML
    private JFXComboBox<String> dateTypeSelection = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> regionSelection = new JFXComboBox<String>();

    @FXML
    private Label selectFormatLabel;

    @FXML
    private Label selectRegionLabel;

    @FXML
    private Label fileNameFieldLabel;

    @FXML
    private Label formatRequired;

    @FXML
    private Label regionRequired;

    @FXML
    private Label fileNameRequired;

    @FXML
    private Button nextButton;

    @FXML
    private TextField fileNameField;



    private final ContextMenu contextMenuFormat = new ContextMenu();

    private final ContextMenu contextMenuRegionLabel = new ContextMenu();

    private final ContextMenu contextMenuSubdomain = new ContextMenu();


    /**
     * Constructor
     */
    public MemberImportSettingsController() {


    }

    /**
     * Initializes the view of the settings page and displays the drop down menus that have to be preselected
     * before starting the import process
     */
    @FXML
    private void  initialize(){
        dateTypeSelection.setItems(dateFormats);
        regionSelection.setItems(regions);
        InstallContextMenu(
                "Date format that was used in the original Import File",
                selectFormatLabel,
                contextMenuFormat
        );

        InstallContextMenu(
                "Import format that was used depending on the region/market of the client",
                selectRegionLabel,
                contextMenuRegionLabel
        );

        InstallContextMenu(
                "No Special Characters are Allowed (#$&%$&;,.)",
                fileNameFieldLabel,
                contextMenuSubdomain
        );
    }


    /**
     * Takes the user to the next page and stores the Date Format and Region in the Member Rules*
     */
    @FXML
    private void handleNextButton(){

        if(regionSelection.getSelectionModel().getSelectedIndex() == -1){
            regionRequired.setVisible(true);

        }
        if(dateTypeSelection.getSelectionModel().getSelectedIndex() == -1){
            formatRequired.setVisible(true);
        }
        if(!isValidInputText(fileNameField.getText())){
            fileNameRequired.setVisible(true);
            fileNameField.clear();
        }
        if(isValidInputText(fileNameField.getText())){
            if(regionSelection.getSelectionModel().getSelectedIndex() != -1){
                if(dateTypeSelection.getSelectionModel().getSelectedIndex() != -1){
                    PrimingRules.setRegionSelected(regionSelection.getSelectionModel().getSelectedItem().toString());
                    PrimingRules.setDateFormatSelected(dateTypeSelection.getSelectionModel().getSelectedItem().toString());
                    CSVHandler.setFileName(fileNameField.getText());
                    CSVHandler.setDate();
                    getPrimingTool().showUploader();
                }
            }
        }




        //Just for testing Purposes
        //System.out.println(PrimingRules.getRegionSelected());
        //System.out.println(PrimingRules.getDateFormatSelected());
        //System.out.println(CSVHandler.getFileName());
        //System.out.println(CSVHandler.getDate());
        }




}
