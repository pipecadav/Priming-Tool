/*
 * CONTROLLER OF THE MEMBER IMPORT SETTINGS PAGE
 *
 * This controller handles the view for the the Member Import Settings Page:
 *  - Installs the tooltips for help
 *  - Shows the Drop down Menus for Region and Date format with the options to choose from
 *
 */

package primingtool.view;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import primingtool.business.CSVHandler;
import primingtool.business.impl.MemberRulesImpl;

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
    private void initialize() {
        dateTypeSelection.setItems(dateFormats);
        regionSelection.setItems(regions);

        installContextMenu(
                "Date format that was used in the original Import File",
                selectFormatLabel,
                contextMenuFormat
        );

        installContextMenu(
                "Import format that was used depending on the region/market of the client",
                selectRegionLabel,
                contextMenuRegionLabel
        );

        installContextMenu(
                "No Special Characters are Allowed (#$&%$&;,.)",
                fileNameFieldLabel,
                contextMenuSubdomain
        );
    }

    /**
     * Takes the user to the next page and stores the Date Format and Region in the Member Rules*
     */
    @FXML
    private void handleNextButton() {
        if (regionSelection.getSelectionModel().getSelectedIndex() == -1) {
            regionRequired.setText("*");
        }

        if (dateTypeSelection.getSelectionModel().getSelectedIndex() == -1) {
            formatRequired.setText("*");
        }

        if (!isValidInputText(fileNameField.getText())) {
            fileNameRequired.setText("*");
            fileNameField.clear();
        }

        if (isValidInputText(fileNameField.getText())) {

            if (regionSelection.getSelectionModel().getSelectedIndex() != -1) {

                if (dateTypeSelection.getSelectionModel().getSelectedIndex() != -1) {
                    MemberRulesImpl.setRegionSelected(regionSelection.getSelectionModel().getSelectedItem().toString());
                    MemberRulesImpl.setDateFormatSelected(dateTypeSelection.getSelectionModel().getSelectedItem().toString());
                    CSVHandler.setFileName(fileNameField.getText());
                    CSVHandler.setDate();
                    getPrimingTool().showUploader();
                }

            }

        }

        //Just for testing Purposes
        //System.out.println(MemberRulesImpl.getRegionSelected());
        //System.out.println(MemberRulesImpl.getDateFormatSelected());
        //System.out.println(CSVHandler.getFileName());
        //System.out.println(CSVHandler.getDate());
    }

}
