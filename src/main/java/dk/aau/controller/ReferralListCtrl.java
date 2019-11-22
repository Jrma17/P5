package dk.aau.controller;

import dk.aau.model.*;

import java.time.LocalDate;
import java.util.Comparator;

import dk.aau.App;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReferralListCtrl {
    /* //Attributter fra MVC'en
    private ReferralListModel referralListModel;
    private ReferralStatusModel referralStatusModel;
    private int waitingDays;
    private ReferralModel referralModel;
    private PatientModel patientModel;
    private VisitationModel visitationModel;
    private SortListModel sortListModel;
    private SortListView sortListView;
    private ReferralCtrl referralCtrl;
*/

    @FXML
    private TableView<ReferralListModel> referralListTableView;
    @FXML
    private TableColumn<ReferralListModel, LocalDate> recievedDateColumn;
    @FXML
    private TableColumn<ReferralListModel, LocalDate> referredDateColumn;
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

    //Knapper i sortListView
    @FXML
    private RadioButton sortByDateBtn;
    @FXML
    private RadioButton sortByStatusBtn;
    @FXML
    private Button searchButton;
    //Når klapper trykkes
    @FXML 
    private void handleSortByDate(){
        App.getReferrals.sort(Comparator.comparing(ReferralListModel::getText));  
        Comparator<ReferralListModel> comparator = Comparator.comparingInt(ReferralListModel::getRecievedDate);
    }
    @FXML 
    private void handleSortByStatus(){   
    }

    private App app;

    
    public ReferralListCtrl(){
    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Opstilling af kolonnerne i tabellen
        recievedDateColumn.setCellValueFactory(cellData -> cellData.getValue().recievedDateProperty());
        referredDateColumn.setCellValueFactory(cellData -> cellData.getValue().referredDateProperty());
        layDaysColumn.setCellValueFactory(cellData -> cellData.getValue().layDaysProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        assignedColumn.setCellValueFactory(cellData -> cellData.getValue().assignedProperty());
        referredFromColumn.setCellValueFactory(cellData -> cellData.getValue().referredFromProperty());
        patientColumn.setCellValueFactory(cellData -> cellData.getValue().patientProperty());
        referralCauseColumn.setCellValueFactory(cellData -> cellData.getValue().referralCauseProperty());
        referralIDColumn.setCellValueFactory(cellData -> cellData.getValue().referralIDProperty());
        referralTypeColumn.setCellValueFactory(cellData -> cellData.getValue().referralTypeProperty());

    }
    
    public void setApp (App app){
        this.app = app;

        referralListTableView.setItems(app.getReferrals());
    }

}


    //Metoder fra MVC'en
    /*public int calculateWaitingDays(){
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
    */
