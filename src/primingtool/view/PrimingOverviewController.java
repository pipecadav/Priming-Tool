package primingtool.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimingOverviewController extends Controller {

    @FXML
    private Button primedFileButton;

    @FXML
    private Button erroredFileButton;

    @FXML
    private Label processedRecords;

    @FXML
    private Label successfulRecords;

    @FXML
    private Label erroredRecords;


    /**
     * Constructor
     */
    public PrimingOverviewController() {
    }

    /**
     * Initializes the Controller Class. This method is automatically called
     * when the FXML file is loaded
     */
    @FXML
    private void initialize(){


    }

    /**
     * Opens the location of where the primed file
     */
    @FXML
    private void handleOpenPrimedFile(){

    }

    /**
     * Opens the location of the errored File
     */
    @FXML
    private void handleOpenErroredFile(){

    }

}
