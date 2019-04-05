package primingtool.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import primingtool.business.CSVHandler;

public class StartPrimingController extends Controller {

    @FXML
    Button startPriming;

    /**
     * Constructor
     */
    public StartPrimingController() {
    }

    @FXML
    private void handleStartButton(){
        CSVHandler.setOriginalColumns();
        getPrimingTool().showFieldSelectionPage();
    }

}