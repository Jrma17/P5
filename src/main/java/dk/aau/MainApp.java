package dk.aau;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Visitering");
   

        showReferralListView();

    }

    public void showReferralListView() {
        try {

            // Load Sort List View
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("/ReferralListView.fxml"));
            AnchorPane ReferralListView = (AnchorPane) loader.load();

           // Show the scene containing the root layout.
            Scene sceneReferralListView = new Scene(ReferralListView);
            primaryStage.setScene(sceneReferralListView);
            // ReferralCtrl controller = loader.getController();
            primaryStage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    /**
     * Returns the main stage.
     * 
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);

    }

}