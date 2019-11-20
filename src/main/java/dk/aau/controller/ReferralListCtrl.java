package dk.aau.controller;

import dk.aau.model.*;
import dk.aau.model.ReferralListModel;
import dk.aau.view.*;
import dk.aau.App;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    /*
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
*/
    //Knapper i sortListView
    @FXML
    private RadioButton sortByDateBtn;
    @FXML
    private RadioButton sortByStatusBtn;
    @FXML
    private Button searchButton;

    //Knapper i rootLayout
    @FXML
    private Button closeButton;

    public ReferralListCtrl() {
    }

    private App app;

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
        //Load af data
        referralListTableView.setItems(getReferralList());
    }

// recievedDate,  referredDate,  layDays,  status,  assigned,  referredFrom, patient,  referralCause,  referralID,  referralType

    public ObservableList<ReferralListModel> getReferralList() {
        ObservableList<ReferralListModel> referrals = FXCollections.observableArrayList();
        referrals.add(new ReferralListModel("1/1-2019","1/1-2019","30","Modtaget","Alle","Lægehus A","Hans 233492-1233","Årsag 1","ICPC-kode","A"));
        referrals.add(new ReferralListModel("12/1-2019","12/1-2019","0","Visiteret","Alle","Lægehus B","Ruth 290506-1236","Årsag 1","ICD10-kode","B"));
        referrals.add(new ReferralListModel("2/1-2019","2/1-2019","29","Modtaget","Alle","Lægehus C","Heinz 311200-9561","Årsag 1","ICPC-kode","C"));
        referrals.add(new ReferralListModel("4/1-2019","1/1-2019","27","Modtaget","Alle","Lægehus D","Cornelia 290483-2096","Årsag 1","ICPC-kode","D"));
        referrals.add(new ReferralListModel("7/1-2019","6/1-2019","24","Modtaget","Alle","Lægehus E","Werner 192835-1023", "Årsag 1","ICPC-kode","E"));
        referrals.add(new ReferralListModel("20/1-2019","19/1-2019","0","Visiteret","Alle","Lægehus F","Lydia 101039-5302","Årsag 1", "ICD10-kode","F"));

        return referrals;
    }



    public void setApp(App app) {
        this.app = app;

        // Add observable list data to the table
        referralListTableView.setItems(ReferralListCtrl.getReferralList());
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
}
