package primingtool.view;

import javafx.fxml.FXML;

public class FieldSelectionController extends Controller {




    /**
     * Constructor
     */
    public FieldSelectionController() {
    }

    public void initialize(){

    }

    @FXML
    private void handleDataMappingButton(){
        getPrimingTool().showProcessingPage();
    }




}
