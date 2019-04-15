package primingtool.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import primingtool.business.CSVHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;

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
        successfulRecords.setText(Integer.toString(CSVHandler.getSuccessfulRecords()));
        erroredRecords.setText(Integer.toString(CSVHandler.getErroredRecords()));
        processedRecords.setText(Integer.toString(CSVHandler.getSuccessfulRecords()+CSVHandler.getErroredRecords()));
    }

    /**
     * Opens the location of where the primed file
     */
    @FXML
    private void handleOpenPrimedFile(){
        openDesktop("Successful Imports");
    }

    /**
     * Opens the location of the errored File
     */
    @FXML
    private void handleOpenErroredFile(){
        openDesktop("Failed Imports");

    }

    /**
     * Initializes destop folder
     * @param filepath
     */
    private void openDesktop(String filepath){
        File file = new File(filepath);
        Desktop desktop = Desktop.getDesktop();
        try{
            desktop.open(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
