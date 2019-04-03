package primingtool.control;

import primingtool.PrimingTool;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuController {

    //Reference to the primingtool.PrimingTool Class
    private PrimingTool primingTool;


    /**
     * Is called by the main application to give a reference back to itself.
     * @param primingTool Main Application
     */
    public void setController (PrimingTool primingTool){
        this.primingTool = primingTool;
    }

    /**
     * Function that displays the member import settings after clicking on the Member Import Button
     */
    @FXML
    private void handleMemberImportButton(){
        primingTool.showMemberImportSettings();
    }

    /**
     * Function that displays the member import settings after clicking on the Member Import Button
     */
    @FXML
    private void handleMembershipImportButton(){
        primingTool.showMembershipImportSettings();
    }

    /**
     * Function that displays the member import settings after clicking on the Member Import Button
     */
    @FXML
    private void handleContractsImportButton(){
        primingTool.showContractImportSettings();
    }

    /**
     * Function that displays the member import settings after clicking on the Member Import Button
     */
    @FXML
    private void handleCreditsImportButton(){
        primingTool.showCreditImportSettings();
    }

    /**
     * Function that displays the member import settings after clicking on the Member Import Button
     */
    @FXML
    private void handleProgressImportButton(){
        primingTool.showProgressImportSettings();

    }

    /**
     * Opens the help and Resources for learning
     */
    @FXML
    private void handleHelpButton() throws IOException, URISyntaxException {
        primingTool.showHelp();

    }

    /**
     * Exits Application after clicking the button Exit
     */
    @FXML
    private void handleExit(){
        System.exit(0);
    }






}
