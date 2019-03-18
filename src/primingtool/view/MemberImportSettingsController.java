package primingtool.view;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;

public class MemberImportSettingsController extends Controller {


    @FXML
    private JFXComboBox<String> dateTypeSelection = new JFXComboBox<String>();

    @FXML
    private JFXComboBox<String> regionSelection = new JFXComboBox<String>();


    /**
     * Constructor
     */
    public MemberImportSettingsController() {

    }

    @FXML
    private void  initialize(){
        dateTypeSelection.setItems(dateFormats);
        regionSelection.setItems(regions);

    }


    @FXML
    private void handleNextButton(){
        getPrimingTool().showUploader();

    }

}
