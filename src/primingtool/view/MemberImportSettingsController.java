package primingtool.view;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
        //System.out.println(regionSelection.getSelectionModel().getSelectedItem().toString());
        //System.out.println(dateTypeSelection.getSelectionModel().getSelectedItem().toString());


    }

}
