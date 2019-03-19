package primingtool.view.fileexplorer;

import primingtool.business.impl.MemberRulesImpl;
import primingtool.view.Controller;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;

public class FileExplorerController extends Controller {

    MemberRulesImpl rules;

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
            rules = new MemberRulesImpl(file);
            //System.out.println(rules.getOriginalImportFile());
        }
    }

}
