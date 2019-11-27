package dk.aau.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dk.aau.MainApp;
import dk.aau.model.ReferralListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import dk.aau.model.*;

import java.time.LocalDate;
import java.util.Comparator;

import dk.aau.MainApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ReferralListCtrl implements Initializable {

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

    // Reference to the main application.
    private MainApp mainApp;

    /***
     * The constructor. The constructor is called before the initialize() method.
     */
    public ReferralListCtrl() {
    }


    //Knapper i sortListView
    @FXML
    private RadioButton sortByDateBtn;
    @FXML
    private RadioButton sortByStatusBtn;
    @FXML
    private Button searchButton;
    //Når klapper trykkes
    /*
    @FXML 
    private void handleSortByDate(){
        App.getReferrals.sort(Comparator.comparing(ReferralListModel::getText));  
        Comparator<ReferralListModel> comparator = Comparator.comparingInt(ReferralListModel::getRecievedDate);
    }
    @FXML 
    private void handleSortByStatus(){   
    }
    */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recievedDateColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("recievedDate"));
        referredDateColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("referredDate"));
        layDaysColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("layDays"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("status"));
        assignedColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("assigned"));
        referredFromColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("referredFrom"));
        patientColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("patient"));
        referralCauseColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("referralCause"));
        referralIDColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("referralID"));
        referralTypeColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("referralType"));

        referralListTable.setItems(getReferralListData());

    }

    /**
     * Returns the data as an observable list of Persons.
     * 
     * @return
     */
    public ObservableList<ReferralListModel> getReferralListData() {
        ObservableList<ReferralListModel> referralListData = FXCollections.observableArrayList();
        referralListData.add(new ReferralListModel("1/1-2019", "1/12-2019", "30", "Modtaget", "Alle", "Laegehus A",
                "Hans 233492-1233", "Aarsag 1", "ICPC-kode", "A"));
        referralListData.add(new ReferralListModel("12/1-2019", "12/1-2019", "0", "Visiteret", "Alle", "Laegehus B",
                "Ruth 290506-1236", "Aarsag 1", "ICD10-kode", "B"));
        referralListData.add(new ReferralListModel("2/1-2019", "2/1-2019", "29", "Modtaget", "Alle", "Laegehus C",
                "Heinz 311200-9561", "Aarsag 1", "ICPC-kode", "C"));
        referralListData.add(new ReferralListModel("4/1-2019", "1/1-2019", "27", "Modtaget", "Alle", "Laegehus D",
                "Cornelia 290483-2096", "Aarsag 1", "ICPC-kode", "D"));
        referralListData.add(new ReferralListModel("7/1-2019", "6/1-2019", "24", "Modtaget", "Alle", "Laegehus E",
                "Werner 192835-1023", "Aarsag 1", "ICPC-kode", "E"));
        referralListData.add(new ReferralListModel("20/1-2019", "19/1-2019", "0", "Visiteret", "Alle", "Laegehus F",
                "Lydia 101039-5302", "Aarsag 1", "ICD10-kode", "F"));

        return referralListData;
    }


    /*
     * Denne funktion henter "referralView" og gør den til den nye scene, når der
     * trykkes på knappen. ("Knappen" den den knap som vælges i scene-builder, hvor
     * denne funktion tilknyttes)
     */
    // public void handleButton(ActionEvent event) throws IOException {

    //     Parent ReferralViewParent = FXMLLoader.load(getClass().getResource("/ReferralView.fxml"));
    //     Scene ReferralViewScene = new Scene(ReferralViewParent);

    //     Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

    //     window.setScene(ReferralViewScene);
    //     window.show();
    // }


    @FXML
    public void clickItem(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) // Checking double click
        {
            Parent ReferralViewParent = FXMLLoader.load(getClass().getResource("/ReferralView.fxml"));
        Scene ReferralViewScene = new Scene(ReferralViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(ReferralViewScene);
        window.show();
        }
    }

}
