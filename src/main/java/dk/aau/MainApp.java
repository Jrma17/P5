package dk.aau;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane mainView;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Visiter henvisning");

        initRootLayout();


        
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/MainView.fxml"));
            mainView = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(mainView);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    // public void showReferralButton() {
    //      try {
    //          // Load person overview.
    //          FXMLLoader loader = new FXMLLoader();
    //          loader.setLocation(MainApp.class.getResource("/view/ReferralButton.fxml"));
    //          AnchorPane ReferralButton = (AnchorPane) loader.load();
            
    //          // Set person overview into the center of root layout.
    //          mainView.setBottom(ReferralButton);
    //      } catch (IOException e) {
    //          e.printStackTrace();
    //      }
    //  }
    
     
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}