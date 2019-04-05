/*
 * The Priming Tool is an application made for the Client Success and Key Accounts Team
 * It allows them to prepare and fix files faster so that they can do imports faster
 *
 *
 */

package primingtool;

import javafx.scene.control.ScrollPane;
import primingtool.view.*;
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

public class PrimingTool extends Application {

    private Stage primaryStage;
    private BorderPane mainMenu;

    /**
     * Constructor
     */
    public PrimingTool() {

    }

    /**
     * Loads the application. It's the primary page
     *
     * @param primaryStage It's the initial scene that will be shown when loading the application
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Virtuagym Import Tool");
        this.primaryStage.getIcons().add(new Image("file:src/primingtool/view/img/import_tool_logo.png"));

        initMainMenu();
    }

    /**
     * Loads the main menu which is also the parent screen
     */
    private void initMainMenu() {
        try {

            //Loads Main Menu
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/MainMenu.fxml"));
            mainMenu = loader.load();

            //Shows scene with Main Menu
            Scene scene = new Scene(mainMenu);
            primaryStage.setScene(scene);

            //Gives access to the Controller
            MainMenuController controller = loader.getController();
            controller.setController(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the member import settings when the Member Import Button is clicked.
     */
    public void showMemberImportSettings() {
        showSimplePane("MemberImportSettings");
    }

    /**
     * Loads the contract import settings when the Button is Clicked
     */
    public void showContractImportSettings() {
        showSimplePane("ContractImportSettings");
    }

    /**
     * Loads the membership import settings when the Button is Clicked
     */
    public void showMembershipImportSettings() {
        showSimplePane("MembershipImportSettings");
    }

    /**
     * Loads the credit import settings when the Button is Clicked
     */
    public void showCreditImportSettings() {
        showSimplePane("CreditImportSettings");
    }

    /**
     * Loads the progress import settings when the Button is Clicked
     */
    public void showProgressImportSettings() {
        showSimplePane("ProgressImportSettings");
    }

    /**
     * Loads the progress import settings when the Button is Clicked
     */
    public void showUploader() {
        showSimplePane("FileExplorer");
    }

    public void showStartPrimingPage() {
        showSimplePane("StartPriming");
    }

    public void showFieldSelectionPage() {
        try {
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


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showProcessingPage() {
        showSimplePane("ProcessingPage");
    }

    public void showOverviewPage() {
        showSimplePane("PrimingOverview");
    }

    private void showSimplePane(String viewName) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PrimingTool.class.getResource("view/" + viewName + ".fxml"));
            AnchorPane pane = loader.load();

            mainMenu.setCenter(pane);

            ((Controller) loader.getController()).setController(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showHelp() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://virtuagymdev.atlassian.net/wiki/spaces/API/pages/1048641651/Import+Tool"));
    }

    /**
     * Returns the Main Page of the App
     *
     * @return the primary stage where the main menu is casted
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
