package primingtool.control;


import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import primingtool.business.CSVHandler;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class FileExplorerController extends Controller {

    @FXML
    private ImageView dragAndDrop;


    /**
     * Constructor
     */
    public FileExplorerController() {
    }

    @FXML
    private void handleBrowse(){
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Comma Separated Values (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extensionFilter);

        File file = fileChooser.showOpenDialog(null);
        if (file != null){
            CSVHandler.setOriginalImportFile(file);
            getPrimingTool().showStartPrimingPage();
            //Just for testing Purposes
            //System.out.println(CSVHandler.getOriginalImportFilePath());
        }
    }

    @FXML
    private void handleDrag(DragEvent event){
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);

        }
    }

    @FXML
    private void handleDrop(DragEvent event){
        List <File> files = event.getDragboard().getFiles();
        if(!files.isEmpty()) {
            if(files.get(0).getAbsolutePath().endsWith(".csv")){
                CSVHandler.setOriginalImportFile(files.get(0));
                getPrimingTool().showStartPrimingPage();
                //Just for testing Purposes
                //System.out.println(CSVHandler.getOriginalImportFilePath());
            }
        }
    }


}
