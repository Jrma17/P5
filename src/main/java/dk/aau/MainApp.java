package dk.aau;

import java.io.IOException;

import dk.aau.controller.MainCtrl;
import dk.aau.controller.ReferralCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import dk.aau.controller.ReferralCtrl;
import dk.aau.model.PatientModel;


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
            loader.setLocation(MainApp.class.getResource("/ReferralView.fxml"));
            mainView = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(mainView);
            primaryStage.setScene(scene);
            primaryStage.show();

            ReferralCtrl controller = loader.getController();
        //controller.setMainApp(this);
        controller.getPatient();
        controller.getReferral();
        controller.getReferralStatus();
        controller.getVisitation();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     
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