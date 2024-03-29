/*
 * The Priming Tool is an application made for the Client Success and Key Accounts Team
 * It allows them to prepare and fix files faster so that they can do imports faster
 *
 *
 */

package primingtool;

import javafx.scene.control.ScrollPane;
import primingtool.control.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URI;
import java.net.URL;

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
        this.primaryStage.setTitle("Virtuagym Priming Tool");
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/primingtool/view/img/priming_tool_16x16.png")));
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/primingtool/view/img/priming_tool_32x32.png")));
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/primingtool/view/img/priming_tool_64x64.png")));
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/primingtool/view/img/priming_tool_128x128.png")));
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/primingtool/view/img/priming_tool_256x256.png")));
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/primingtool/view/img/priming_tool_512x512.png")));

        initMainMenu();

    }

    /**
     * Loads the main menu which is also the parent screen
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



    /**
     * Loads the member import settings when the Member Import Button is clicked.
     */
    public void showMemberImportSettings(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/MemberImportSettings.fxml"));
            AnchorPane memberImportSettings = (AnchorPane) loader.load();

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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/ContractImportSettings.fxml"));
            AnchorPane contractImportSettings = (AnchorPane) loader.load();

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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/MembershipImportSettings.fxml"));
            AnchorPane membershipImportSettings = (AnchorPane) loader.load();

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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/CreditImportSettings.fxml"));
            AnchorPane creditImportSettings = (AnchorPane) loader.load();

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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/ProgressImportSettings.fxml"));
            AnchorPane progressImportSettings = (AnchorPane) loader.load();

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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/FileExplorer.fxml"));
            AnchorPane fileExplorer = (AnchorPane) loader.load();

            mainMenu.setCenter(fileExplorer);

            FileExplorerController controller = loader.getController();
            controller.setController(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showStartPrimingPage(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/StartPriming.fxml"));
            AnchorPane startPrimingPage = (AnchorPane) loader.load();

            mainMenu.setCenter(startPrimingPage);


            StartPrimingController controller = loader.getController();
            controller.setController(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showFieldSelectionPage(){
        try{
            URL url = PrimingTool.class.getResource("view/FieldSelection.fxml");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            AnchorPane fieldSelection = loader.load();
            //scrollPaneContainer.setContent(FXMLLoader.load(getClass().getResource("view/CreditImportSettings.fxml")));
            ScrollPane scrollPaneContainer = new ScrollPane();
            scrollPaneContainer.setContent(fieldSelection);
            scrollPaneContainer.setPannable(true);



            mainMenu.setCenter(scrollPaneContainer);
            FieldSelectionController controller = loader.getController();
            controller.setController(this);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showOverviewPage(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/PrimingOverview.fxml"));
            AnchorPane primingOverview = (AnchorPane) loader.load();

            mainMenu.setCenter(primingOverview);

            PrimingOverviewController controller = loader.getController();
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
