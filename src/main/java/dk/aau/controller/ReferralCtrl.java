package dk.aau.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import dk.aau.model.ReferralHashMapModel;
import dk.aau.model.ReferralModel;
import dk.aau.model.ReferralStatusModel;
import dk.aau.model.VisitationModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
    private ComboBox<String> waitingGroup;
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
    private ComboBox<String> phrase;
    @FXML
    private TextField icpcDefLabel;

    // ReferralStatusView
    @FXML
    private DatePicker date; //Bruges ikke
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

    // Button
    @FXML
    private Button saveButton;
    @FXML
    private Button closeButton;

    String cpr;
    String ICPCkode;
    ReferralHashMapModel referralHashMapstructure = new ReferralHashMapModel();
    HashMap NewMapLabel;

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

   
    // Henter cpr nr.fra ReferralListCtrl.
    public void setCode(String code) {
        cpr = code;
        
        getPatient();
        getReferral();
        getReferralStatus();
        getVisitation();
        saveButton();

    }
    public void getPatient() {
        // Skriver patientinfo i label
        name.setText(DatabaseHandlerCtrl.readReferral(cpr).getName());
        adress.setText(DatabaseHandlerCtrl.readReferral(cpr).getAddress());
        cprNumber.setText(DatabaseHandlerCtrl.readReferral(cpr).getCprNumber());

    }
    public void getReferral() {
        // Skriver text i label med data fra database
        referralSentDate.setText(DatabaseHandlerCtrl.readReferral(cpr).getReferralSentDate());
        referralRecievedDate.setText(DatabaseHandlerCtrl.readReferral(cpr).getReferralRecievedDate());
        referredBy.setText(DatabaseHandlerCtrl.readReferral(cpr).getReferredBy());
        diagnosisText.setText(DatabaseHandlerCtrl.readReferral(cpr).getDiagnosisText());
        course.setText(DatabaseHandlerCtrl.readReferral(cpr).getCourse());
        referralID.setText(DatabaseHandlerCtrl.readReferral(cpr).getReferralID());
        anamnesis.setText(DatabaseHandlerCtrl.readReferral(cpr).getAnamnesis());
        referralType.setText(DatabaseHandlerCtrl.readReferral(cpr).getReferralType());
        responsibleUnit.setText(DatabaseHandlerCtrl.readReferral(cpr).getResponsibleUnit());

        // Laver liste i combobox + skriver tekst i feltet med data fra database
        waitingGroup.setValue(DatabaseHandlerCtrl.readReferral(cpr).getWaitingGroup());
        waitingGroup.setItems(waitingGroupList);

    }

    public void getVisitation() {
        // Laver liste i combobox + skriver tekst i feltet med data fra database
        note.setText(DatabaseHandlerCtrl.readVisitation(cpr).getNote());
        phrase.setValue(DatabaseHandlerCtrl.readVisitation(cpr).getPhrase());
        phrase.setItems(phraseList);
        diagnosisCodeICPC.setText(DatabaseHandlerCtrl.readVisitation(cpr).getDiagnosisCodeICPC());
        referralDiagnosisCodeICD.setText(DatabaseHandlerCtrl.readVisitation(cpr).getReferralDiagnosisCodeICD());
        
    }

    public void getReferralStatus() {
        // Laver liste i combobox + skriver tekst i feltet

        time.setText(DatabaseHandlerCtrl.readReferralStatus(cpr).getTime());
        unit.setText(DatabaseHandlerCtrl.readReferralStatus(cpr).getUnit());
        patientPrivilege.setValue(DatabaseHandlerCtrl.readReferralStatus(cpr).getPatientPrivilege());
        patientPrivilege.setItems(patientPrivilegeList);
        status.setValue(DatabaseHandlerCtrl.readReferralStatus(cpr).getStatus());
        status.setItems(StatusList);
        assigned.setValue(DatabaseHandlerCtrl.readReferralStatus(cpr).getAssigned());
        assigned.setItems(assignedList);
        visitator.setText(DatabaseHandlerCtrl.readReferralStatus(cpr).getVisitator());
        
    }

    //ICPC map
    public HashMap ICPCMapToDef() {
        NewMapLabel = referralHashMapstructure.getNewMapLabel();
        NewMapLabel.put("L80", "L80 - Luksation/subluksation");
        NewMapLabel.put("L81", "L81 - Skade på muskel-/skeletsystem IKA");
        NewMapLabel.put("L82", "L82 - Medfødt misdannelse i muskel-/skeletsystem");
        NewMapLabel.put("L83", "L83 - Cervikalsyndrom");
        NewMapLabel.put("L84", "L84 - Rygsyndrom uden smerteudstråling");
        NewMapLabel.put("L85", "L85 - Erhvervet rygdeformitet");
        NewMapLabel.put("L86", "L86 - Rygsyndrom med smerteudstråling");
        NewMapLabel.put("L87", "L87 - Bursit/tendinit/synovit IKA");
        NewMapLabel.put("L88", "L88 - Reumatoid artrit");
        NewMapLabel.put("L89", "L89 - Artrose i hofteled");
        NewMapLabel.put("L90", "L90 - Artrose i knæ");
        NewMapLabel.put("L91", "L91 - Artrose IKA ");
        NewMapLabel.put("L92", "L92 - Skuldersyndrom");
        NewMapLabel.put("L93", "L93 - Tennisalbue");
        NewMapLabel.put("L94", "L94 - Osteokondrose");
        NewMapLabel.put("L95", "L95 - Osteoporose");
        NewMapLabel.put("L96", "L96 - Akut indre knæskade");
        NewMapLabel.put("L97", "L97 - Godartet/uspecifik svulst i muskel-/skeletsystem");
        NewMapLabel.put("L98", "L98 - Erhvervet deformitet af ekstremitet");
        NewMapLabel.put("L99", "L99 - Sygdom i muskel-/skeletsystem IKA");

        return NewMapLabel;

    }

    //Bruges til at få værdien som tastes ind i feltet "diagnosisCodeICPC" i ReferralView.fxml
    @FXML
    public String getdiagnosisCodeICPC() {

        ICPCkode = diagnosisCodeICPC.getText();


        Object icpcCodeLabel = NewMapLabel.get(ICPCkode); //Henter values fra hashmappet (objekt)
        String icpcCodeLabelString = String.valueOf(icpcCodeLabel); //Omdanner objekt til String
        if (icpcCodeLabelString == "null") {
            icpcDefLabel.setText("Ugyldig ICPC-2-DK kode"); // String indsættes i textfeltet "icpcdeflabel"
        }

        else {
            icpcDefLabel.setText(icpcCodeLabelString); // String indsættes i textfeltet "icpcdeflabel"
        }
        return ICPCkode; // global
    }

    // Funktionen åbner "MappingListView" når der trykkes på knap
    @FXML
    public void handleMapning(ActionEvent event) throws IOException { // funktionen er tilsluttet knappen via.
                                                                      // scenebuilder "MappinglistView"

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/MappingListView.fxml")); // ny loader som henter
                                                                                                 // mappinglistview
        Parent root1 = (Parent) fxmlloader.load(); // herunder: laver en ny parrent + scene og sætter denne scene som
                                                   // parrent (så det fylder hele vinduet)
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

        MappingListCtrl ctrl = fxmlloader.getController(); // "giver" værdien ICPC kode (fra getdiagnosisCodeICPC()) til
                                                           // MappingListCtrl
        System.out.println(ctrl + "this is ctrl");
        ctrl.setCode(ICPCkode); // samme som ovenstående
        ctrl.IsolatedICDCodes
                .addListener((observable, oldValue, newValue) -> referralDiagnosisCodeICD.setText(newValue)); // Laver en listener på variablen "IsolatedICDCodes" fra mappinglistctrl vha. "ctrl"
        // Listeneren laves i denne ctrl fordi det er denne ctrl der styre det view som
        // skal ændres - men den listener på listview'et i mappinglistctrl
        StringProperty noget = new SimpleStringProperty(ICPCkode);
        System.out.println(noget + "this is stringproperty");
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

            MainApp.getVisitationData().add(new VisitationModel(diagnosisCodeICPC.getText()));
        }));
    }

    //Gemmer data fra henvisning op i database
     public void saveButton() {
         saveButton.setOnAction((Event -> {
             // Henter data fra felterne.
            
             VisitationModel visitation = new VisitationModel(note.getText(), phrase.getValue(), diagnosisCodeICPC.getText(), referralDiagnosisCodeICD.getText(), null);
             ReferralModel referral = new ReferralModel(name.getText(), adress.getText(), cprNumber.getText(), null, null, null, waitingGroup.getValue(), diagnosisText.getText(), null,
                     null, null, null, null);
             ReferralStatusModel referralStatus = new ReferralStatusModel(null, time.getText(), unit.getText(), patientPrivilege.getValue(), status.getValue(), assigned.getValue(),
                     visitator.getText());

             try {
                 // Gemmer data som er hentet fra felterne i databasen
               
                 DatabaseHandlerCtrl.addICPC(visitation, cpr);
                 DatabaseHandlerCtrl.addReferral(referral, cpr);
                 DatabaseHandlerCtrl.addReferralStatus(referralStatus, cpr);

             } catch (ClassNotFoundException e) {
               
                 e.printStackTrace();
             } catch (SQLException e) {
                
                 e.printStackTrace();
             }

         }));
     }

    public void initialize() {

        ICPCMapToDef();
    }

}
