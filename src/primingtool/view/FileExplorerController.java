package primingtool.view;


import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import primingtool.business.impl.MemberRulesImpl;
import primingtool.view.Controller;
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

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Comma Separated Files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extensionFilter);

        File file = fileChooser.showOpenDialog(null);
        if (file != null){
            MemberRulesImpl.setOriginalImportFile(file);
            getPrimingTool().showStartPrimingPage();
            //Just for testing Purposes
            System.out.println(MemberRulesImpl.getOriginalImportFile());
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
                MemberRulesImpl.setOriginalImportFile(files.get(0));
                getPrimingTool().showStartPrimingPage();
                //Just for testing Purposes
                System.out.println(MemberRulesImpl.getOriginalImportFile());
            }
        }
    }


}
