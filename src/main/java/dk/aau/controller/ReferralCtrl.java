package dk.aau.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import dk.aau.model.IcpcHashMapModel;
import dk.aau.model.ReferralModel;
import dk.aau.model.ReferralStatusModel;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReferralCtrl {
    
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
    private ComboBox<String> waitingGroup;
    @FXML
    private TextField diagnosisText;
    
    // VisitationView
    @FXML
    private TextField diagnosisCodeIcpc;
    @FXML
    private TextField referralDiagnosisCodeIcd;
    @FXML
    private TextArea note;
    @FXML
    private ComboBox<String> phrase;
    @FXML
    private TextField icpcDefLabel;
    
    // ReferralStatusView
    @FXML 
    private TextField date;
    @FXML
    private TextField time;
    @FXML
    private TextField unit;
    @FXML
    private ComboBox<String> patientPrivilege;
    @FXML
    private ComboBox<String> status;
    @FXML
    private ComboBox<String> assigned;
    @FXML
    private TextField visitator;
    
    // Knapper
    @FXML
    private Button saveButton;
    @FXML
    private Button closeButton;
    
    private String id;
    private String icpcCode;
    private IcpcHashMapModel icpcHashMapstructure = new IcpcHashMapModel();
    private HashMap<String, String> icpcCodesMap;
    DatabaseHandlerCtrl database = new DatabaseHandlerCtrl();
    
    // Liste med input til ventegruppe-combobox
    private ObservableList<String> waitingGroupList = FXCollections.observableArrayList("ALM ALMINDELIGT AMBULAT",
    "ALS NEUROMED.PTT.MED ALS", "DEL DAGPAT.REUMA");
    
    // Liste med input til Status-combobox
    private ObservableList<String> statusList = FXCollections.observableArrayList("Anulleret", "Modtaget", "Visiteret",
    "Klar til visitering", "Afventer", "F\u00E6rdigbehandlet", "Omvisiteret (RN)", "Visteret (Haster)",
    "Omvisiteret (Eksternt)", "Tilsyn - F\u00E6rdigbehandlet");
    
    // Liste med input til Tildelt-combobox
    private ObservableList<String> assignedList = FXCollections.observableArrayList("Alle", "Ingen", "Mille Hansen", 
    "Per Lorentsen", "L\u00E6ge", "Sygeplejerske", "Team 1", "Team 2");
    
    // Liste med input til Patientrettighed-combobox
    private ObservableList<String> patientPrivilegeList = FXCollections.observableArrayList("Udredning", "Behandling",
    "Kontrol");
    
    // Liste med input til frase-combobox
    private ObservableList<String> phraseList = FXCollections.observableArrayList("Journal notat", "Akut indl\u00E6ggelse");
    
    
    // Henter information til henvisningen ud fra cpr nr. fra "ReferralListCtrl"
    public void getReferralInformation(String code) {
        id = code;
        System.out.println(id);
        getPatient();
        getReferral();
        getReferralStatus();
        getVisitation();
        saveButton();
    }

    public void getPatient() {
        // Skriver patientinfo i label

        name.setText(database.readReferral(id).getName());
        adress.setText(database.readReferral(id).getAddress() + " " + database.readReferral(id).getPostalCode().toString() + " "
                + database.readReferral(id).getCity());
        cprNumber.setText(database.readReferral(id).getCprNumber().toString());

    }

    public void getReferral() {
        // Skriver text i label med data fra databasen

        referralSentDate.setText(database.readReferral(id).getReferralSentDate().toString());
        referralRecievedDate.setText(database.readReferral(id).getReferralRecievedDate().toString());
        referredBy.setText(database.readReferral(id).getReferredBy());
        diagnosisText.setText(database.readReferral(id).getDiagnosisText());
        course.setText(database.readReferral(id).getCourse());
        referralID.setText(database.readReferral(id).getReferralID());
        anamnesis.setText(database.readReferral(id).getAnamnesis());
        referralType.setText(database.readReferral(id).getReferralType());
        responsibleUnit.setText(database.readReferral(id).getResponsibleUnit());

        // Laver liste i combobox + skriver tekst i feltet med data fra database
        waitingGroup.setValue(database.readReferral(id).getWaitingGroup());
        waitingGroup.setItems(waitingGroupList);
    }

    public void getVisitation() {
        // Laver liste i combobox + skriver tekst i feltet med data fra database
        note.setText(database.readVisitation(id).getNote());
        phrase.setValue(database.readVisitation(id).getPhrase());
        phrase.setItems(phraseList);
        diagnosisCodeIcpc.setText(database.readVisitation(id).getDiagnosisCodeIcpc());
        referralDiagnosisCodeIcd.setText(database.readVisitation(id).getReferralDiagnosisCodeIcd());
    }

    public void getReferralStatus() {
        // Laver liste i combobox + skriver tekst i feltet
        date.setText(database.readReferralStatus(id).getDate().toString());
        time.setText(database.readReferralStatus(id).getTime().toString());
        unit.setText(database.readReferralStatus(id).getUnit());
        patientPrivilege.setValue(database.readReferralStatus(id).getPatientPrivilege());
        patientPrivilege.setItems(patientPrivilegeList);
        status.setValue(database.readReferralStatus(id).getStatus());
        status.setItems(statusList);
        assigned.setValue(database.readReferralStatus(id).getAssigned());
        assigned.setItems(assignedList);
        visitator.setText(database.readReferralStatus(id).getVisitator());
     }
    
    // ICPC map med definitioner/diagnosetekst
    public HashMap<String, String> icpcMapToDef() {
        icpcCodesMap = icpcHashMapstructure.getIcpcCodesMap();
        // NewMapLabel.put("L80", "L80 - Luksation/subluksation");
        // NewMapLabel.put("L81", "L81 - Skade på muskel-/skeletsystem IKA");
        // NewMapLabel.put("L82", "L82 - Medf\u00F8dt misdannelse i
        // muskel-/skeletsystem");
        // NewMapLabel.put("L83", "L83 - Cervikalsyndrom");
        // NewMapLabel.put("L84", "L84 - Rygsyndrom uden smerteudstr\u00E5ling");
        // NewMapLabel.put("L85", "L85 - Erhvervet rygdeformitet");
        icpcCodesMap.put("L86", "L86 - Rygsyndrom med smerteudstr\u00E5ling");
        icpcCodesMap.put("L87", "L87 - Bursit/tendinit/synovit IKA");
        icpcCodesMap.put("L88", "L88 - Reumatoid artrit");
        icpcCodesMap.put("L89", "L89 - Artrose i hofteled");
        icpcCodesMap.put("L90", "L90 - Artrose i kn\u00E6");
        icpcCodesMap.put("L91", "L91 - Artrose IKA ");
        icpcCodesMap.put("L92", "L92 - Skuldersyndrom");
        icpcCodesMap.put("L93", "L93 - Tennisalbue");
        icpcCodesMap.put("L94", "L94 - Osteokondrose");
        icpcCodesMap.put("L95", "L95 - Osteoporose");
        icpcCodesMap.put("L96", "L96 - Akut indre kn\u00E6skade");
        icpcCodesMap.put("L97", "L97 - Godartet/uspecifik svulst i muskel-/skeletsystem");
        icpcCodesMap.put("L98", "L98 - Erhvervet deformitet af ekstremitet");
        // NewMapLabel.put("L99", "L99 - Sygdom i muskel-/skeletsystem IKA");

        return icpcCodesMap;
    }

    // Bruges til at få værdien som tastes i feltet "diagnosisCodeIcpc" ind i
    // "ReferralView"
    @FXML
    public String getDiagnosisCodeIcpc() {

        icpcCode = diagnosisCodeIcpc.getText();
        // Isolerer values fra "NewMapLabel" (HashMap som har ICPC kode som key, og
        // tilhørende diagnosetekst som value), som har "icpcCode" som key
        Object icpcCodeLabel = icpcCodesMap.get(icpcCode); // Hashmaps returnere objects
        String icpcCodeLabelString = String.valueOf(icpcCodeLabel); // Omdanner Object til String (det skal være String, når det skal sættes ind i tekstfeltet)
        
        // String indsættes i tekstfeltet "icpcDefLabel" hvis koden ikke eksisterer i mappet
        if (icpcCodeLabelString == "null") {
            icpcDefLabel.setText("Ugyldig ICPC-2-DK diagnosekode!"); 
        }
        // String indsættes i tekstfeltet "icpcDefLabel" hvis koden eksisterer i mappet
        else {
            icpcDefLabel.setText(icpcCodeLabelString); 
        }
        return icpcCode;
    }
    
    // Funktionen åbner "MappingListView" når der trykkes på knap
    // Funktionen er tilsluttet knappen "Mapning" via scenebuilder, "MappinglistView"
    @FXML
    public void handleMapping(ActionEvent event) throws IOException { 
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/MappingListView.fxml")); // Ny loader som henter "Mappinglistview"
        // Laver en ny parent + scene og sætter denne scene som parent (så det fylder hele vinduet)
        Parent root1 = (Parent) fxmlloader.load(); 
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
        
        // "Giver" værdien ICPC kode (fra "getdiagnosisCodeICPC()") til "MappingListCtrl"
        MappingListCtrl ctrl = fxmlloader.getController(); 
        ctrl.setCode(icpcCode); 
        // Laver en listener på variablen "isolatedICDCodes" fra "MappingListCtrl" vha. "ctrl"
        // Listeneren laves i denne ctrl, fordi det er denne ctrl, der styrer det view som skal ændres, men den "lytter" på listview'et i "MappingListCtrl"
        ctrl.isolatedIcdCodes.addListener((observable, oldValue, newValue) -> referralDiagnosisCodeIcd.setText(newValue)); 
    }
    
    // Knap til at lukke henvisningen
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
    
     // Knap til at gemme data fra henvisning op i database
     public void saveButton() {
         saveButton.setOnAction((Event -> {
            
             // Henter data fra felterne
             VisitationModel visitation = new VisitationModel(note.getText(), phrase.getValue(), diagnosisCodeIcpc.getText(), referralDiagnosisCodeIcd.getText(), null);
             ReferralModel referral = new ReferralModel(null, null, null, null, null, null, null, null, waitingGroup.getValue(), diagnosisText.getText(), null, referralID.getText(), null, null, null);
             ReferralStatusModel referralStatus = new ReferralStatusModel(date.getText(), time.getText(), unit.getText(), patientPrivilege.getValue(), status.getValue(), assigned.getValue(), visitator.getText());
            
             try {
                 // Gemmer data som er hentet fra felterne i databasen
                 database.addVisitation(referral, referralStatus, visitation);
                 database.addReferralStatus(referralStatus);
             } 
             catch (ClassNotFoundException e) {
                 e.printStackTrace();
             } 
             catch (SQLException e) { 
                 e.printStackTrace();
             }
         }));
     }
    
    public void initialize() {
        icpcMapToDef();
    }
    
}
