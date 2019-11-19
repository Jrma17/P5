package dk.aau.controller;

import dk.aau.model.*;
import dk.aau.model.ReferralListModel;
import dk.aau.view.*;
import dk.aau.App;

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

    private MainApp mainApp;

    @FXML
    private TableView<ReferralListModel> referralListTable;
    @FXML
    private TableColumn<ReferralListModel, String> recievedDateColumn;
    @FXML
    private TableColumn<ReferralListModel, String> referredDateColumn;
    @FXML
    private TableColumn<ReferralListModel, String> layDaysColumn;
    @FXML
    private TableColumn<ReferralListModel, String> statusColumn;
    @FXML
    private TableColumn<ReferralListModel, String> assignedColumn;
    @FXML
    private TableColumn<ReferralListModel, String> referredFromColumn;
    @FXML
    private TableColumn<ReferralListModel, String> patientColumn;
    @FXML
    private TableColumn<ReferralListModel, String> referralCauseColumn;
    @FXML
    private TableColumn<ReferralListModel, String> referralIDColumn;
    @FXML
    private TableColumn<ReferralListModel, String> referralTypeColumn;

    @FXML
    private Label recievedDateLabel;
    @FXML
    private Label referredDateLabel;
    @FXML
    private Label layDaysLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label assignedLabel;
    @FXML
    private Label referredFromLabel;
    @FXML
    private Label patientLabel;
    @FXML
    private Label referralCauseLabel;
    @FXML
    private Label referralIDLabel;
    @FXML
    private Label referralTypeLabel;

    public ReferralListCtrl() {
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
