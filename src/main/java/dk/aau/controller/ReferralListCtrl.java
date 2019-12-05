package dk.aau.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import dk.aau.model.ReferralListModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

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

    @FXML
    private CheckBox sortByDateBtn;
    @FXML
    private CheckBox sortByStatusBtn;
    @FXML
    private Label searchLabelTest;

    String cpr;

    //Knap til sortering af dato og status
    @FXML
    public void searchButtonPressed() {
        if (sortByDateBtn.isSelected()) {
            sortingPolicyDate();
        } else if (sortByStatusBtn.isSelected()) {
            sortingPolicyStatus();

        } else {
            referralListTable.setItems(DatabaseHandlerCtrl.readReferralList1());
        }
    }

    //Sortering af dato

    public void sortingPolicyDate() {
        referralListTable.sortPolicyProperty().set(new Callback<TableView<ReferralListModel>, Boolean>() {
           
            @Override
            public Boolean call(TableView<ReferralListModel> param) {
                Comparator<ReferralListModel> comparatorDate = new Comparator<ReferralListModel>() {
                    @Override
                    public int compare(ReferralListModel r1, ReferralListModel r2) {
                        return r1.getRecievedDate().compareTo(r2.getRecievedDate());
                    }
                };

                FXCollections.sort(referralListTable.getItems(), comparatorDate); 
                return true;
            }
        });
    }

    //Sortering af status
    public void sortingPolicyStatus() {
        referralListTable.sortPolicyProperty().set(new Callback<TableView<ReferralListModel>, Boolean>() {

            @Override
            public Boolean call(TableView<ReferralListModel> param) {
                Comparator<ReferralListModel> comparatorStatus = new Comparator<ReferralListModel>() {
                    @Override
                    public int compare(ReferralListModel r1, ReferralListModel r2) {
                        return r1.getStatus().compareTo(r2.getStatus());
                    }
                };
                FXCollections.sort(referralListTable.getItems(), comparatorStatus);
                return true;
            }
        });
    }

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

        //Sætter data i table view
        referralListTable.setItems(DatabaseHandlerCtrl.readReferralList1());

    }

    //Muligør åbning af henvisningen ved dobbelt klik
    @FXML
    public void clickItemList(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) // Checking double click
        {
            getPatientFromList();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ReferralView.fxml"));

            Parent ReferralViewParent = (Parent) fxmlLoader.load();
            Scene ReferralViewScene = new Scene(ReferralViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(ReferralViewScene);
            window.show();

            //Muliggør at cpr nr. bliver overført til ReferralCtrl
            ReferralCtrl refctrl = fxmlLoader.getController();
            
            refctrl.setCode(cpr);
        }
    }

    //Henter cpr nr. fra table view 
    public String getPatientFromList() {
        cpr = referralListTable.getSelectionModel().getSelectedItem().getPatient();
        return cpr;
    }

}
