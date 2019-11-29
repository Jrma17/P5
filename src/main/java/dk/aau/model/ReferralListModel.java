package dk.aau.model;




import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ReferralListModel {

    /*
     * private final ReferralModel referralModel; private final int waitingDays;
     * private final ReferralStatusModel referralStatusModel; private final
     * PatientModel patientModel; private final VisitationModel visitationModel;
     * private final SortListModel sortListModel; private final Date todaysDate;
     */

    // Fra java fx tutorial
    private final StringProperty recievedDate;
    private final StringProperty referredDate;
    private final StringProperty layDays;
    private final StringProperty status;
    private final StringProperty assigned;
    private final StringProperty referredFrom;
    private final StringProperty patient;
    private final StringProperty referralCause;
    private final StringProperty referralID;
    private final StringProperty referralType;

    /**
     * Default constructor.
     */
    public ReferralListModel() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public ReferralListModel(String recievedDate, String referredDate, String layDays, String status, String assigned,
            String referredFrom, String patient, String referralCause, String referralID, String referralType) {
        this.recievedDate = new SimpleStringProperty(recievedDate);
        this.referredDate = new SimpleStringProperty(referredDate);
        this.layDays = new SimpleStringProperty(layDays);
        this.status = new SimpleStringProperty(status);
        this.assigned = new SimpleStringProperty(assigned);
        this.referredFrom = new SimpleStringProperty(referredFrom);
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

    public StringProperty recievedDateProperty() {
        return recievedDate;
    }

    public String getReferredDate() {
        return referredDate.get();
    }

    public void setReferredDate(LocalDate referredDate) {
        this.referredDate.set(referredDate);
    }

    public StringProperty referredDateProperty() {
        return referredDate;
    }

    public String getLayDays() {
        return layDays.get();
    }

    public void setLayDays(String layDays) {
        this.layDays.set(layDays);
    }

    public StringProperty layDaysProperty() {
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
        this.referralID.set(referralType);
    }

    public StringProperty referralTypeProperty() {
        return referralType;
    }

}