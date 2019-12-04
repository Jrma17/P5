package dk.aau.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dk.aau.MainApp;
import dk.aau.model.ReferralListModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ReferralListCtrl implements Initializable {

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

        // Reference to the main application.
        private MainApp mainApp;


        @Override
        public void initialize(URL location, ResourceBundle resources) {
                recievedDateColumn.setCellValueFactory(
                                new PropertyValueFactory<ReferralListModel, String>("recievedDate"));
                referredDateColumn.setCellValueFactory(
                                new PropertyValueFactory<ReferralListModel, String>("referredDate"));
                layDaysColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("layDays"));
                statusColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("status"));
                assignedColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("assigned"));
                referredFromColumn.setCellValueFactory(
                                new PropertyValueFactory<ReferralListModel, String>("referredFrom"));
                patientColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("patient"));
                referralCauseColumn.setCellValueFactory(
                                new PropertyValueFactory<ReferralListModel, String>("referralCause"));
                referralIDColumn.setCellValueFactory(new PropertyValueFactory<ReferralListModel, String>("referralID"));
                referralTypeColumn.setCellValueFactory(
                                new PropertyValueFactory<ReferralListModel, String>("referralType"));

                
                 referralListTable.setItems(ReferralHandler.readReferralList1());
        }
                

       
    //  public String getPatientFromList(){
    //      String i = referralListTable.getSelectionModel().getSelectedItem().getPatient();
    //          System.out.println(i);
    //          return i;
    //  }
       
    


    @FXML
    public void clickItem(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) // Checking double click
        {
            String i = referralListTable.getSelectionModel().getSelectedItem().getPatient();
            System.out.println(i);
            Parent ReferralViewParent = FXMLLoader.load(getClass().getResource("/ReferralView.fxml"));
        Scene ReferralViewScene = new Scene(ReferralViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(ReferralViewScene);
        window.show();
        }
    }

}

