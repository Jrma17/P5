package dk.aau.model;

import java.util.Date;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReferralListModel {

    private ReferralModel referralModel;
    private int waitingDays;
    private ReferralStatusModel referralStatusModel;
    private PatientModel patientModel;
    private VisitationModel visitationModel;
    private SortListModel sortListModel;
    private Date todaysDate;

    //Fra java fx tutorial
    private final ObjectProperty<LocalDate> recievedDate;
    private final ObjectProperty<LocalDate> referredDate;
    private final IntegerProperty layDays;
    private final StringProperty status;
    private final StringProperty assigned;
    private final StringProperty referredFrom;
    private final StringProperty patient;
    private final StringProperty referralCause;
    private final StringProperty referralID;
    private final StringProperty referralType;


    public ReferralListModel() {
        this(null, null);
    }

    public ReferralListModel(String patient, String referralID) {
        this.recievedDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
        this.referredDate = new SimpleObjectProperty<LocalDate>(LocalDate.of(1998, 2, 21));
        this.layDays = new SimpleIntegerProperty(1234);
        this.status = new SimpleStringProperty(status);
        this.assigned = new SimpleStringProperty(assigned);
        
        // Some initial dummy data, just for convenient testing.
        this.referredFrom = new SimpleStringProperty("Lægehuset");

        this.patient = new SimpleStringProperty(patient);
        this.referralCause = new SimpleStringProperty(referralCause);
        this.referralID = new SimpleStringProperty(referralID);
        this.referralType = new SimpleStringProperty(referralType);
        
    }

    public LocalDate getRecievedDate() {
        return recievedDate.get();
    }

    public void setRecievedDate(LocalDate recievedDate) {
        this.recievedDate.set(recievedDate);
    }
    
    public ObjectProperty<LocalDate> recievedDateProperty() {
        return recievedDate;
    }
    
    public LocalDate getReferredDate() {
        return referredDate.get();
    }

    public void setReferredDate(LocalDate referredDate) {
        this.referredDate.set(referredDate);
    }
    
    public ObjectProperty<LocalDate> referredDateProperty() {
        return referredDate;
    }

    public int getLayDays() {
        return layDays.get();
    }

    public void setLayDays(int layDays) {
        this.layDays.set(layDays);
    }
    
    public IntegerProperty layDaysProperty() {
        return layDays;
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
    
    public StringProperty statusProperty() {
        return status;
    }

    public String getAssigned() {
        return assigned.get();
    }

    public void setAssigned(String assigned) {
        this.assigned.set(assigned);
    }
    
    public StringProperty assignedProperty() {
        return assigned;
    }


    public String getReferredFrom() {
        return referredFrom.get();
    }

    public void setReferredFrom(String referredFrom) {
        this.referredFrom.set(referredFrom);
    }
    
    public StringProperty referredFromProperty() {
        return referredFrom;
    }

    public String getPatient() {
        return patient.get();
    }

    public void setPatient(String patient) {
        this.patient.set(patient);
    }
    
    public StringProperty patientProperty() {
        return patient;
    }
    public String getReferralCause() {
        return referralCause.get();
    }

    public void setReferralCause(String referralCause) {
        this.referralCause.set(referralCause);
    }
    
    public StringProperty referralCauseProperty() {
        return referralCause;
    }

    public String getReferralID() {
        return referralID.get();
    }

    public void setReferralID(String referralID) {
        this.referralID.set(referralID);
    }
    
    public StringProperty referralIDProperty() {
        return referralID;
    }

    public String getReferralType() {
        return referralType.get();
    }

    public void setReferralType(String referralType) {
        this.referralID.set(referralID);
    }
    
    public StringProperty referralTypeProperty() {
        return referralType;
    }

    
    
    //fx tutorial slut

    
    //Getter og Setter
    public int calculateWaitingDays(Date ReferralSentDate, Date todaysDate)
    {
        return waitingDays;
         
    } 

    public ReferralModel getReferralModel() {
        return referralModel;
    }

    public void setReferralModel(ReferralModel referralModel) {
        this.referralModel = referralModel;
    }

    public int getWaitingDays() {
        return waitingDays;
    }

    public void setWaitingDays(int waitingDays) {
        this.waitingDays = waitingDays;
    }

    public ReferralStatusModel getReferralStatusModel() {
        return referralStatusModel;
    }

    public void setReferralStatusModel(ReferralStatusModel referralStatusModel) {
        this.referralStatusModel = referralStatusModel;
    }

    public PatientModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(PatientModel patientModel) {
        this.patientModel = patientModel;
    }

    public VisitationModel getVisitationModel() {
        return visitationModel;
    }

    public void setVisitationModel(VisitationModel visitationModel) {
        this.visitationModel = visitationModel;
    }

    public SortListModel getSortListModel() {
        return sortListModel;
    }

    public void setSortListModel(SortListModel sortListModel) {
        this.sortListModel = sortListModel;
    }

    public Date getTodaysDate() {
        return todaysDate;
    }

    public void setTodaysDate(Date todaysDate) {
        this.todaysDate = todaysDate;
    }



}