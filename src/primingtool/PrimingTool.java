package primingtool;

import primingtool.view.fileexplorer.FileExplorerController;
import primingtool.view.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import primingtool.view.*;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URI;

public class PrimingTool extends Application{

    private Stage primaryStage;
    private BorderPane mainMenu;

    /**
     * Constructor
     */
    public PrimingTool(){

    }


    /**
     * Loads the application. It's the primary page
     * @param primaryStage It's the initial scene that will be shown when loading the application
     */
    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Virtuagym Import Tool");
        this.primaryStage.getIcons().add(new Image("file:src/primingtool/view/img/import_tool_logo.png"));
        initMainMenu();
    }

    /**
     * Loads the main menu
     */
    public void initMainMenu(){
        try{
            //Loads Main Menu
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/MainMenu.fxml"));
            mainMenu = (BorderPane) loader.load();

            //Shows scene with Main Menu
            Scene scene = new Scene(mainMenu);
            primaryStage.setScene(scene);

            //Gives access to the Controller
            MainMenuController controller = loader.getController();
            controller.setController(this);


            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void loadimportData(File file){

    }

    /**
     * Loads the member import settings when the Button is Clicked
     */
    public void showMemberImportSettings(){
        try{
            //Loads the Import Settings
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/MemberImportSettings.fxml"));
            AnchorPane memberImportSettings = (AnchorPane) loader.load();

            //Sets the Member Import Settings in the Center of the Layout
            mainMenu.setCenter(memberImportSettings);

            MemberImportSettingsController controller = loader.getController();
            controller.setController(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads the contract import settings when the Button is Clicked
     */
    public void showContractImportSettings(){
        try{
            //Loads the Contract Settings
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/ContractImportSettings.fxml"));
            AnchorPane contractImportSettings = (AnchorPane) loader.load();

            //Sets the Member Import Settings in the Center of the Layout
            mainMenu.setCenter(contractImportSettings);

            ContractImportSettingsController controller = loader.getController();
            controller.setController(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads the membership import settings when the Button is Clicked
     */
    public void showMembershipImportSettings(){
        try{
            //Loads the Contract Settings
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/MembershipImportSettings.fxml"));
            AnchorPane membershipImportSettings = (AnchorPane) loader.load();

            //Sets the Member Import Settings in the Center of the Layout
            mainMenu.setCenter(membershipImportSettings);

            MembershipImportSettingsController controller = loader.getController();
            controller.setController(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads the credit import settings when the Button is Clicked
     */
    public void showCreditImportSettings(){
        try{
            //Loads the Contract Settings
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/CreditImportSettings.fxml"));
            AnchorPane creditImportSettings = (AnchorPane) loader.load();

            //Sets the Member Import Settings in the Center of the Layout
            mainMenu.setCenter(creditImportSettings);

            CreditImportSettingsController controller = loader.getController();
            controller.setController(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads the progress import settings when the Button is Clicked
     */
    public void showProgressImportSettings(){
        try{
            //Loads the Contract Settings
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/ProgressImportSettings.fxml"));
            AnchorPane progressImportSettings = (AnchorPane) loader.load();

            //Sets the Member Import Settings in the Center of the Layout
            mainMenu.setCenter(progressImportSettings);

            ProgressImportSettingsController controller = loader.getController();
            controller.setController(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads the progress import settings when the Button is Clicked
     */
    public void showUploader(){
        try{
            //Loads the Contract Settings
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/FileExplorer/FileExplorer.fxml"));
            AnchorPane fileExplorer = (AnchorPane) loader.load();

            //Sets the Member Import Settings in the Center of the Layout
            mainMenu.setCenter(fileExplorer);

            FileExplorerController controller = loader.getController();
            controller.setController(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showHelp() throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://virtuagymdev.atlassian.net/wiki/spaces/API/pages/1048641651/Import+Tool"));
    }


    /**
     * Returns the Main Page of the App
     * @return the primary stage where the main menu is casted
     */
    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
