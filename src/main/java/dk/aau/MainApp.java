package dk.aau;

import java.io.IOException;

import dk.aau.controller.MainCtrl;
import dk.aau.controller.ReferralCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import dk.aau.controller.ReferralCtrl;
import dk.aau.model.PatientModel;


import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane mainView;

    private static ObservableList<PatientModel> patientData = FXCollections.observableArrayList();

    public MainApp() {
        patientData.add(new PatientModel("Hans", "byvej 1", "233492-1233"));
        // patientData.add(new PatientModel("Ruth", "Årsagvej 1", "290506-1236"));
        // patientData.add(new PatientModel("Heinz", "Årsagvej 2", "311200-9561"));
        // patientData.add(new PatientModel("Cornelia ", "Årsagvej 3", "290483-2096"));
        // patientData.add(new PatientModel("Werner", "Årsagvej 4", " 192835-1023"));
        // patientData.add(new PatientModel("Lydia", "Årsagvej 5", "101039-5302"));
    }

    /**
     * Returns the data as an observable list of Persons.
     * 
     * @return
     */
    public static ObservableList<PatientModel> getPatientData() {
        return patientData;
    }
    // personTable.setItems(mainApp.getPersonData());
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