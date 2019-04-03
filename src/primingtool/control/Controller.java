package primingtool.control;

import com.jfoenix.controls.JFXComboBox;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import primingtool.PrimingTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {

    private PrimingTool primingTool;

    ObservableList<String> dateFormats =  FXCollections.observableArrayList("d-m-yyyy","m-d-yyyy", "dd-mm-yyyy", "mm-dd-yyyy", "d/m/yyyy","m/d/yyyy", "dd/mm/yyyy","mm/dd/yyyy");
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

    public boolean isValidInputText(String input){
        if(input == null || input.trim().isEmpty()){
            return false;
        }
        Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            return false;
        }else{
            return true;
        }
    }

    public void clearComboBox(JFXComboBox <String> comboBox){


        comboBox.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DELETE || event.getCode() == KeyCode.BACK_SPACE){
                comboBox.getSelectionModel().clearSelection();
            }
        });
    }


}
