package dk.aau.controller;

import dk.aau.model.*;
import dk.aau.view.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReferralListCtrl {
    private ReferralListModel referralListModel;
    private ReferralStatusModel referralStatusModel;
    private int waitingDays;
    private ReferralModel referralModel;
    private PatientModel patientModel;
    private VisitationModel visitationModel;
    private SortListModel sortListModel;
    private SortListView sortListView;
    private ReferralCtrl referralCtrl;

        @FXML
        private TableView<ReferralListModel> personTable;
        @FXML
        private TableColumn<ReferralListModel, String> firstNameColumn;
        @FXML
        private TableColumn<ReferralListModel, String> lastNameColumn;
    
        @FXML
        private Label firstNameLabel;
        @FXML
        private Label lastNameLabel;
        @FXML
        private Label streetLabel;
        @FXML
        private Label postalCodeLabel;
        @FXML
        private Label cityLabel;
        @FXML
        private Label birthdayLabel;
    
        // Reference to the main application.
        private MainApp mainApp;
    
        /**
         * The constructor.
         * The constructor is called before the initialize() method.
         */
        public PersonOverviewController() {
        }
    
        /**
         * Initializes the controller class. This method is automatically called
         * after the fxml file has been loaded.
         */
        @FXML
        private void initialize() {
            // Initialize the person table with the two columns.
            firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().patientProperty());
            lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().referralIDProperty());
        }
    
        /**
         * Is called by the main application to give a reference back to itself.
         * 
         * @param mainApp
         */
        public void setMainApp(MainApp mainApp) {
            this.mainApp = mainApp;
    
            // Add observable list data to the table
            personTable.setItems(mainApp.getPersonData());
        }
    }

    public int calculateWaitingDays(){
        return waitingDays;

    }
    public void detectInputFromSortListView(){

    }
    public void sortListBy(){

    }
    public void recieveReferralList(){

    }
    public void detectInputFromReferralListView(){

    }
    public void generateReferralListView(){

    }
    public void updateReferralListView(){
        
    }
}