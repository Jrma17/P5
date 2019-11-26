package dk.aau.controller;

import java.io.IOException;
import dk.aau.MainApp;
import dk.aau.model.PatientModel;
import dk.aau.model.ReferralModel;
import dk.aau.model.VisitationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
// import dk.aau.model.ReferralModel;
// import dk.aau.model.ReferralStatusModel;
// import dk.aau.model.VisitationModel;
// import dk.aau.view.PatientView;
// import dk.aau.view.ReferralStatusView;
// import dk.aau.view.ReferralView;
// import dk.aau.view.VisitationView;
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

public class ReferralCtrl{
    // private ReferralModel referralModel;
    // private ReferralStatusModel referralStatusModel;
    // private VisitationModel visitationModel;
     private PatientModel patientmodel;
    // private ReferralView referralview;
    // private ReferralStatusView referralStatusView;
    // private VisitationView visitationview;
    // private PatientView patientview;
    // private MappingListCtrl mappingListCtrl;
    // private CatalogCtrl catalogCtrl;
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
    private ComboBox waitingGroup; // Bruges ikke
    @FXML
    private TextField diagnosisText; // Bruges ikke
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
    ObservableList<String> phraseList = FXCollections.observableArrayList("JournalNotat", "Akut indlaeggelse");

    // Construtor
    public ReferralCtrl() {
    }

    public void getPatient(PatientModel patient) {
        // Skriver patientinfo i labels

        name.setText(patient.getName());
        adress.setText(patient.getAdress());
        cprNumber.setText(patient.getCprNumber());
        // cprNumber.setText("1234-5678");
        // name.setText("Abcde");
        // adress.setText("ertyui");
    }

    public void getReferral(ReferralModel referral) {
        // Skriver text i label
        course.setText(referral.getCourse());
        responsibleUnit.setText(referral.getResponsibleUnit());
        referralID.setText(referral.getReferralID());
        referralSentDate.setText(referral.getReferralSentDate());
        referralRecievedDate.setText(referral.getReferralRecievedDate());
        referredBy.setText(referral.getReferredBy());
        referralType.setText(referral.getReferralType());
        anamnesis.setText(referral.getAnamnesis());
        diagnosisText.getText();

        // Laver liste i combobox + skriver tekst i feltet
        waitingGroup.setValue("Vaelg ventegruppe");
        waitingGroup.setItems(waitingGroupList);

    }

    public void getVisitation(VisitationModel visitation) {
        // Laver liste i combobox + skriver tekst i feltet
        // phrase.setItems(phraseList);
        // if(){

        // }
        diagnosisCodeICPC.setText(visitation.getDiagnosisCodeICPC());
        anamnesis.setText(visitation.getDiagnosisCodeICPC());
        
        // System.out.println(MainApp.getVisitationData().get(0));

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
        // ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // // do what you have to do
        stage.close();

        Parent ReferralListViewParent = FXMLLoader.load(getClass().getResource("/ReferralListView.fxml"));
        Scene ReferralListViewScene = new Scene(ReferralListViewParent);

        Stage window = (Stage) ((Button) event.getSource()).getScene().getWindow();

        window.setScene(ReferralListViewScene);
        window.show();

    }
    public void saveButton1(){
        saveButton.setOnAction((Event -> {
            // System.out.println(diagnosisCodeICPC.getText());

            MainApp.getVisitationData().add(new VisitationModel(diagnosisCodeICPC.getText()));
        }));
    }

    public void initialize() {

        getPatient(MainApp.getPatientData().get(0));
        getReferral(MainApp.getReferralData().get(0));
        getReferralStatus();
        saveButton1();
        //getVisitation(MainApp.getVisitationData().get(2));

        
        

    }



    

    
   
    
}
    
    
    



 
    