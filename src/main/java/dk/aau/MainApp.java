package dk.aau;

import java.io.IOException;

import dk.aau.controller.ReferralCtrl;
import dk.aau.controller.ReferralHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import dk.aau.model.DatabaseManipulator;
import dk.aau.model.PatientModel;
import dk.aau.model.ReferralModel;
import dk.aau.model.ReferralListModel;
import dk.aau.model.VisitationModel;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    public static ReferralModel referralModel = new ReferralModel();
    public static PatientModel patientModel = new PatientModel();
    public static ReferralListModel referralListModel = new ReferralListModel();
    
    
     //Arrayliste med patientdata og henvisningsdata
     private static ObservableList<PatientModel> patientData = FXCollections.observableArrayList();
     private static ObservableList<ReferralModel> referralData = FXCollections.observableArrayList();
     private static ObservableList<VisitationModel> visitationData = FXCollections.observableArrayList();
    
    
     //Tilføjer data til arraylisten Patientdata og referralData
     public MainApp() {
         patientData.add(new PatientModel("Hans", "byvej 1", "233492-1233"));
         // patientData.add(new PatientModel("Ruth", "Årsagvej 1", "290506-1236"));
         // patientData.add(new PatientModel("Heinz", "Årsagvej 2", "311200-9561"));
         // patientData.add(new PatientModel("Cornelia ", "Årsagvej 3", "290483-2096"));
         // patientData.add(new PatientModel("Werner", "Årsagvej 4", " 192835-1023"));
         // patientData.add(new PatientModel("Lydia", "Årsagvej 5", "101039-5302"));
        
         //referralData.add(new ReferralModel("12/1-2019", "12/1-2019", "Laegehus A","Hoste",  "Aarsag 1", "1234567", "ICPC-kode", "XML", "Afdeling 2"));
                  
     }
     
    
     //Returner data fra de to lister
     public static ObservableList<PatientModel> getPatientData() {
         return patientData;
     }
     public static ObservableList<ReferralModel> getReferralData() {
         return referralData;
     }
      public static ObservableList<VisitationModel> getVisitationData() {
            return visitationData;
     }
    
    
        @Override
        public void start(Stage primaryStage) {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("AddressApp");
            this.primaryStage.getIcons().add(new Image("file:resources/images/iconfinder_Address_Book_86957.png"));
    
            //initRootLayout();
            showReferralListView();
    
        }
        
          
        public void showReferralListView() {
            try {
               MainApp.referralModel =  ReferralHandler.readReferral();
               MainApp.patientModel = ReferralHandler.readPatientData();
               MainApp.referralListModel = ReferralHandler.readReferralList();
               //MainApp.patientModel = PatientModel.readPatientData();
                // Load Sort List View
                FXMLLoader loader = new FXMLLoader();
                
                loader.setLocation(MainApp.class.getResource("/ReferralListView.fxml"));
                AnchorPane ReferralListView = (AnchorPane) loader.load();
                
                // Set person overview into the center of root layout.
                //rootLayout.setCenter(SortListView);
        
        
                // Show the scene containing the root layout.
                Scene sceneReferralListView = new Scene(ReferralListView);
                primaryStage.setScene(sceneReferralListView);
                //ReferralCtrl controller = loader.getController();
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