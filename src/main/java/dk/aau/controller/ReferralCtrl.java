package dk.aau.controller;

import java.io.IOException;
import dk.aau.MainApp;
//import dk.aau.model.PatientModel;
//import dk.aau.model.ReferralModel;
import dk.aau.model.VisitationModel;
//import dk.aau.controller.ReferralHandler;
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
     //private PatientModel patientmodel;
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
    ObservableList<String> phraseList = FXCollections.observableArrayList("Journal Notat", "Akut indlaeggelse");

    // Construtor
    public ReferralCtrl() {
    }
    

     public void getPatient() {
        // Skriver patientinfo i labels

         name.setText(MainApp.patientModel.getName());
         adress.setText(MainApp.patientModel.getAdress());
         cprNumber.setText(MainApp.patientModel.getCprNumber());
    
     }

    public void getReferral() {
        // Skriver text i label
        
         course.setText(MainApp.referralModel.getCourse());
         responsibleUnit.setText(MainApp.referralModel.getResponsibleUnit());
         referralID.setText(MainApp.referralModel.getReferralID());
        referralSentDate.setText(MainApp.referralModel.getReferralSentDate());
        referralRecievedDate.setText(MainApp.referralModel.getReferralRecievedDate());
         referredBy.setText(MainApp.referralModel.getReferredBy());
         referralType.setText(MainApp.referralModel.getReferralType());
         anamnesis.setText(MainApp.referralModel.getAnamnesis());
         diagnosisText.setText(MainApp.referralModel.getDiagnosisText());

        // Laver liste i combobox + skriver tekst i feltet
        waitingGroup.setValue("Vaelg ventegruppe");
        waitingGroup.setItems(waitingGroupList);

    }

    public void getVisitation() {
        // Laver liste i combobox + skriver tekst i feltet
        phrase.setValue("Vaelg frase");
         phrase.setItems(phraseList);
        //Hvis pladsen i array er optaget skrive dette eller tomt felt.
        // if(MainApp.getVisitationData().get(0) != null){
            // diagnosisCodeICPC.setText(visitation.getDiagnosisCodeICPC());

         //}
         //else{
           // diagnosisCodeICPC.setText("");
         //}
        
        //anamnesis.setText(visitation.getDiagnosisCodeICPC());
        //MainApp.getVisitationData().get(0);
        
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

    // public void saveButton1(){
    //     saveButton.setOnAction((Event -> {
    //         String ICPC = diagnosisCodeICPC.getText();
    //          System.out.println(diagnosisCodeICPC.getText());
    //         ReferralHandler.addICPC(ICPC);
    //         MainApp.getVisitationData().add(new VisitationModel(diagnosisCodeICPC.getText()));
    //         //getVisitation(MainApp.getVisitationData().get(0));
    //     }));
    // }
    
    public void initialize() {

        getPatient();
        getReferral();
        getReferralStatus();
        //saveButton1();
        getVisitation();
   

       
        

    }    

}
    
    



 
    