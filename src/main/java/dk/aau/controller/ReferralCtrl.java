package dk.aau.controller;

import java.io.IOException;
import dk.aau.MainApp;
import dk.aau.model.VisitationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReferralCtrl {
    VisitationModel visitation;

    // Patientview
    @FXML
    private Label cprNumber;
    @FXML
    private Label name;
    @FXML
    private Label adress;

    // ReferralView
    @FXML
    private Label course;
    @FXML
    private Label responsibleUnit;
    @FXML
    private Button editCourse;// Bruges ikke
    @FXML
    private TextArea anamnesis;
    @FXML
    private Label referralID;
    @FXML
    private Label referralSentDate;
    @FXML
    private Label referralRecievedDate;
    @FXML
    private Label referredBy;
    @FXML
    private Label referralType;
    @FXML
    private ComboBox waitingGroup; 
    @FXML
    private TextField diagnosisText; 
    @FXML
    private Button catalogButton; // Bruges ikke

    // VisitationView
    @FXML
    private TextField diagnosisCodeICPC;
    @FXML
    private TextField referralDiagnosisCodeICD;
    @FXML
    private TextArea note;
    @FXML
    private ComboBox phrase;

    // ReferralStatusView
    @FXML
    private DatePicker date;
    @FXML
    private TextField unit;
    @FXML
    private ComboBox patientPrivilege;
    @FXML
    private ComboBox status;
    @FXML
    private ComboBox assigned;
    @FXML
    private TextField visitator;

    // Button
    @FXML
    private Button saveButton;
    @FXML
    private Button closeButton;

    // Liste med input til ventegruppe-combobox
    ObservableList<String> waitingGroupList = FXCollections.observableArrayList("ALM ALMINDELIGT AMBULAT",
            "ALS NEUROMED.PTT.MED ALS", "DEL DAGPAT.REUMA");
    // Liste med input til Status-combobox
    ObservableList<String> StatusList = FXCollections.observableArrayList("Anulleret", "Modtaget", "Visiteret",
            "Klar til visitering", "Afventer", "Faerdigbehandlet", "Omvisiteret(RN)", "Visteret(Haster)",
            "Omvisiteret(Eksternt)", "Tilsyn - Faerdigbehandlet");
    // Liste med input til Tildelt-combobox
    ObservableList<String> assignedList = FXCollections.observableArrayList("Erna", "Jakob", "Andrea");
    // Liste med input til Patientrettighed-combobox
    ObservableList<String> patientPrivilegeList = FXCollections.observableArrayList("Udredning", "Behandling",
            "Kontrol");
    // Liste med input til frase-combobox
    ObservableList<String> phraseList = FXCollections.observableArrayList("Journal Notat", "Akut indlaeggelse");

    // Construtor
      public ReferralCtrl() {
      }
      public void getPatient() {
          // Skriver patientinfo i label
          name.setText(MainApp.patientModel.getName());
          adress.setText(MainApp.patientModel.getAddress());
          cprNumber.setText(MainApp.patientModel.getCprNumber());

      }

      public void getReferral() {
          // Skriver text i label
          
          //ReferralListModel id = ReferralListHandler.getReferralList().get(6);
          ReferralListCtrl i = new ReferralListCtrl();
        //   String l = i.getPatientFromList();
          
          course.setText(ReferralHandler.readReferral().getCourse());
          responsibleUnit.setText(ReferralHandler.readReferral().getResponsibleUnit());
          referralID.setText(ReferralHandler.readReferral().getReferralID());
         referralSentDate.setText(ReferralHandler.readReferral().getReferralSentDate());
          referralRecievedDate.setText(ReferralHandler.readReferral().getReferralRecievedDate());
          referredBy.setText(ReferralHandler.readReferral().getReferredBy());
          referralType.setText(ReferralHandler.readReferral().getReferralType());
          anamnesis.setText(ReferralHandler.readReferral().getAnamnesis());
          diagnosisText.setText(ReferralHandler.readReferral().getDiagnosisText());
         // Laver liste i combobox + skriver tekst i feltet
          waitingGroup.setValue("Vaelg ventegruppe");
          waitingGroup.setItems(waitingGroupList);

      }
     public void getVisitation() {
          // Laver liste i combobox + skriver tekst i feltet
          phrase.setValue("Vaelg frase");
          phrase.setItems(phraseList);
          //Skriver data fra databasen i feltet
          diagnosisCodeICPC.setText(MainApp.visitationModel.getDiagnosisCodeICPC());
      }

      public void getReferralStatus() {
          // Laver liste i combobox + skriver tekst i feltet
          status.setValue("Vaelg status");
        status.setItems(StatusList);
          assigned.setValue("Vaelg tildelt");
          assigned.setItems(assignedList);
          patientPrivilege.setValue("Vaelg patientrettighed");
          patientPrivilege.setItems(patientPrivilegeList);
      }

      // Knap til at lukke
      @FXML
      public void closeButtonAction(ActionEvent event) throws IOException {
          Stage stage = (Stage) closeButton.getScene().getWindow();
          stage.close();
          Parent ReferralListViewParent = FXMLLoader.load(getClass().getResource("/ReferralListView.fxml"));
          Scene ReferralListViewScene = new Scene(ReferralListViewParent);
          Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();
          window.setScene(ReferralListViewScene);
          window.show();
      }
//      public void saveButton() {
//           saveButton.setOnAction((Event -> {
//               //Henter data fra felterne.
//               VisitationModel ICPC = new VisitationModel(diagnosisCodeICPC.getText());
//               ReferralModel diagnosisTextSave = new ReferralModel(diagnosisText.getText(), null, null, null, null,
//                       null, null, null, null, null);
//              ReferralModel waitingGroupSave = new ReferralModel(waitingGroup.getSelectionModel());
//              ReferralStatusModel statusSave = new ReferralStatusModel(status.getSelectionModel());
//              ReferralStatusModel assignedSave = new ReferralStatusModel(assigned.getSelectionModel());
//              ReferralStatusModel patientPriviligeSave = new ReferralStatusModel(patientPrivilege.getSelectionModel());
//               try {
//                   //Gemmer data som er hentet fra felterne i databasen
//                 //   ReferralHandler.addICPC(ICPC);
//                 //   ReferralHandler.addReferral(diagnosisTextSave);
//                 //   ReferralHandler.addReferral(waitingGroupSave);
//                 //   ReferralHandler.addReferralStatus(statusSave);
//                 //   ReferralHandler.addReferralStatus(assignedSave);
//                 //   ReferralHandler.addReferralStatus(patientPriviligeSave);
//               } catch (ClassNotFoundException e) {
//                   // TODO Auto-generated catch block
//                   e.printStackTrace();
//               } catch (SQLException e) {
//                   // TODO Auto-generated catch block
//                   e.printStackTrace();
//               }
             
            
//            }));
//        }
    
      public void initialize() {

          getPatient();
          getReferral();
          getReferralStatus();
          //saveButton();
          getVisitation();
      }    

 }
    
    



 
    