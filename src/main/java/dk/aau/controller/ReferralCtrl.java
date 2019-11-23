package dk.aau.controller;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.xml.catalog.Catalog;

import dk.aau.MainApp;
import dk.aau.model.PatientModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
// import dk.aau.model.ReferralModel;
// import dk.aau.model.ReferralStatusModel;
// import dk.aau.model.VisitationModel;
// import dk.aau.view.PatientView;
// import dk.aau.view.ReferralStatusView;
// import dk.aau.view.ReferralView;
// import dk.aau.view.VisitationView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

     
       
    //Patientview
     @FXML
     private Label cprNumber;
     @FXML
     private Label name;
     @FXML
     private Label adress;

     //ReferralView
     @FXML
     private Label course;
     @FXML
     private Label responsibleUnit;
     @FXML
     private Button editCourse;//Bruges ikke
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
     private ComboBox waitingGroup; //Bruges ikke
     @FXML
     private TextField diagnosisText; //Bruges ikke
     @FXML
     private Button catalogButton; //Bruges ikke

    //VisitationView
    @FXML
    private TextField diagnosisCodeICPC;
    @FXML
    private TextField referralDiagnosisCodeICD;
    @FXML
    private TextArea note;
    @FXML
    private ComboBox phrase;

    //ReferralStatusView
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


    //Liste med input til ventegruppe-combobox
    ObservableList<String> waitingGroupList = FXCollections.observableArrayList("ALM ALMINDELIGT AMBULAT", "ALS NEUROMED.PTT.MED ALS", "DEL DAGPAT.REUMA"); 
    //Liste med input til Status-combobox
    ObservableList<String> StatusList = FXCollections.observableArrayList("Anulleret", "Modtaget", "Visiteret", "Klar til visitering", "Afventer", "Faerdigbehandlet", "Omvisiteret(RN)", "Visteret(Haster)", "Omvisiteret(Eksternt)", "Tilsyn - Faerdigbehandlet"); 
    //Liste med input til Tildelt-combobox
    ObservableList<String> assignedList = FXCollections.observableArrayList("Erna", "Jakob", "Andrea"); 
    //Liste med input til Patientrettighed-combobox
    ObservableList<String> patientPrivilegeList = FXCollections.observableArrayList("Udredning", "Behandling", "Kontrol");
    //Liste med input til frase-combobox
    ObservableList<String> phraseList = FXCollections.observableArrayList("JournalNotat", "Akut indlaeggelse");  
    
    public ReferralCtrl(){

     }
     public void getPatient(PatientModel patient){
         //Skriver patientinfo i labels
        
         name.setText(patient.getName());
         adress.setText(patient.getAdress());
         cprNumber.setText(patient.getCprNumber());
         //cprNumber.setText("1234-5678");
         //name.setText("Abcde");
         //adress.setText("ertyui");
    }

    public void getReferral(){
        //Skriver text i label
        course.setText("ghjk");
        responsibleUnit.setText("eth");
        referralID.setText("ghjkl");
        referralSentDate.setText("1234");
        referralRecievedDate.setText("2435");
        referredBy.setText("ertgh");
        referralType.setText("sdfgh");
        anamnesis.setText("dfghjkl");

        //Laver liste i combobox + skriver tekst i feltet
        waitingGroup.setValue("Vaelg ventegruppe");
        waitingGroup.setItems(waitingGroupList);
    
    }

    public void getVisitation(){
        //Laver liste i combobox + skriver tekst i feltet
        phrase.setItems(phraseList);

    }

    public void getReferralStatus(){
        //Laver liste i combobox + skriver tekst i feltet
        status.setValue("Vaelg status");
        status.setItems(StatusList);
        assigned.setValue("Vaelg tildelt");
        assigned.setItems(assignedList);
        patientPrivilege.setValue("Vaelg patientrettighed");
        patientPrivilege.setItems(patientPrivilegeList);

    }

     public void initialize(){
            
        getPatient(MainApp.getPatientData().get(0));
        getReferral();
        getReferralStatus();
        
        
     }



    

    
   
    
}
    
    
    



 
    