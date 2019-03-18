package primingtool.view;

import primingtool.PrimingTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

    private PrimingTool primingTool;

    ObservableList<String> dateFormats =  FXCollections.observableArrayList("dd-mm-yyyy","mm-dd-yyyy","dd/mm/yyyy","mm/dd/yyyy");
    ObservableList<String> regions = FXCollections.observableArrayList("Northam","Latam","Europe");


    public void setController(PrimingTool primingTool){
        this.primingTool = primingTool;
    }

    public PrimingTool getPrimingTool() {
        return primingTool;
    }
}
