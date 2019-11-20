package dk.aau.controller;

import javax.xml.catalog.Catalog;

import dk.aau.MainApp;
import dk.aau.model.PatientModel;
import dk.aau.model.ReferralModel;
import dk.aau.model.ReferralStatusModel;
import dk.aau.model.VisitationModel;
import dk.aau.view.PatientView;
import dk.aau.view.ReferralStatusView;
import dk.aau.view.ReferralView;
import dk.aau.view.VisitationView;
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
    // private PatientModel patientmodel;
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
    //ReferralButton
    @FXML
    private Button appendixButton;
    @FXML
    private Button correspondenceButton;
    @FXML
    private Button historyButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button closeButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button saveCloseButton;
    //VisitationView
    @FXML
    private TextField diagnosisCodeIcpc;
    @FXML
    private TextField referralDiagnosisCodeIcd;
    @FXML
    private TextArea note;
    @FXML
    private TextField phrase; 
    //Mangler en
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
    //ReferralView
    @FXML
    private Label course;
    @FXML
    private Label responsibleUnit;
    @FXML
    private Button editCourse;
    @FXML
    private TextArea anamnesis;
    @FXML
    private Label referralID;
    @FXML
    private Label referralSent;
    @FXML
    private Label referredBy;
    @FXML
    private Label referralType;
    @FXML
    private ComboBox waitingGroup;
    @FXML
    private TextField diagnosisText;

    private MainApp mainApp;

    // //Patientview - Skal hente oplysninger fra database og vise dem i henvisning
    // @FXML
    // private Label cprNumber;
    // @FXML
    // private Label name;
    // @FXML
    // private Label adress;

    // /**
    //  * Is called by the main application to give a reference back to itself.
    //  * 
    //  * @param mainApp
    //  */
    // public void setMainApp(MainApp mainApp) {
    //     this.mainApp = mainApp;

    
    // }
    
    public void getPatient(PatientModel patient){
        //Skriver patientinfo i labels
        // cprNumber.setText(patient.getCprNumber());
        // name.setText(patient.getName());
        // adress.setText(patient.getAdress());
        cprNumber.setText("1234");
        name.setText("Julie");
        adress.setText("erty");
    }
    
   //ReferralButton
//    @FXML
//    private Button closeButton;
//    @FXML
//    private Button saveButton;
//    @FXML
//    private Button saveCloseButton;



 
    //Metoder

    public void detectInputFromReferralView(){

    }
    public void detectInputFromReferralStatusView(){

    }
    public void detectInputFromVisitationView(){

    }
    public void detectInputFromPatientView(){

    }
    public void generateReferralView(){

    }
    public void generateReferralStatusView(){

    }
    public void generateVisitationView(){

    }
    public void generatePatientView(){

    }
    public void updateReferralView(){

    }
    public void updateReferralStatusView(){

    }
    public void updateVisitationView(){

    }
    public void updatePatientView(){

    }

    
}
