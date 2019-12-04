package dk.aau;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import dk.aau.model.PatientModel;
import dk.aau.model.ReferralModel;
import dk.aau.model.ReferralStatusModel;
import dk.aau.model.ReferralListModel;
import dk.aau.model.VisitationModel;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    public static ReferralModel referralModel = new ReferralModel();
    public static PatientModel patientModel = new PatientModel();
    public static ReferralListModel referralListModel = new ReferralListModel();
    public static VisitationModel visitationModel = new VisitationModel();
    public static ReferralStatusModel referralStatusModel = new ReferralStatusModel();
    
    
     //Arrayliste med patientdata og henvisningsdata
     private static ObservableList<PatientModel> patientData = FXCollections.observableArrayList();
     private static ObservableList<ReferralModel> referralData = FXCollections.observableArrayList();
     private static ObservableList<VisitationModel> visitationData = FXCollections.observableArrayList();
    
    
     //Tilføjer data til arraylisten Patientdata og referralData
     public MainApp() {
         patientData.add(new PatientModel("Hans", "byvej 1", "233492-1233"));
         
                  
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
    
            
            showReferralListView();

           
              
    }
    
        
        
          
        public void showReferralListView() {
            try {
                                
                   //MainApp.patientModel = ReferralHandler.readPatientData();
                   //MainApp.referralModel =  ReferralHandler.readReferral();
                  //MainApp.visitationModel = ReferralHandler1.readVisitation();
                   //MainApp.referralStatusModel = ReferralHandler1.readReferralStatus();

            
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