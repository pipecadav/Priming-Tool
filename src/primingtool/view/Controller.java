package primingtool.view;

import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import primingtool.PrimingTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Controller {

    private PrimingTool primingTool;

    ObservableList<String> dateFormats =  FXCollections.observableArrayList("d-m-yyyy","m-d-yyyy", "dd-mm-yyy", "mm-dd-yyyy", "d/m/yyyy","m/d/yyyy", "dd/mm/yyyy","mm/dd/yyyy");
    ObservableList<String> regions = FXCollections.observableArrayList("Northam","Europe", "Other");


    public void setController(PrimingTool primingTool){
        this.primingTool = primingTool;
    }


    public PrimingTool getPrimingTool() {
        return primingTool;
    }


    public void InstallContextMenu(String tooltipMessage, Label label, ContextMenu contextMenu){
        label.setContextMenu(contextMenu);
        MenuItem menuItem = new MenuItem();
        menuItem.setText(tooltipMessage);
        contextMenu.getItems().addAll(menuItem);

        label.setOnMouseEntered(event ->
                label.getContextMenu().show(label, Side.TOP, 0, 0));

        label.setOnMouseExited(event ->
                label.getContextMenu().hide());
    }
}
