package dk.aau.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ReferralListModel {

    private  StringProperty recievedDate;
    private  StringProperty referredDate;
    private  StringProperty layDays;
    private  StringProperty status;
    private  StringProperty assigned;
    private  StringProperty referredFrom;
    private  StringProperty patient;
    private StringProperty referralCause;
    private  StringProperty referralID;
    private StringProperty referralType;

    //Constructor
    public ReferralListModel(String recievedDate, String referredDate, String layDays, String status, String assigned,
            String referredFrom, String patient, String referralCause, String referralID, String referralType
            ) {
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

    public String getRecievedDate() {
        return recievedDate.get();
    }

    
    public String getReferredDate() {
        return referredDate.get();
    }

    public String getLayDays() {
        return layDays.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getAssigned() {
        return assigned.get();
    }

    public String getReferredFrom() {
        return referredFrom.get();
    }

    public String getPatient() {
        return patient.get();
    }

    public String getReferralCause() {
        return referralCause.get();
    }

      public String getReferralID() {
        return referralID.get();
    }

      
    public String getReferralType() {
        return referralType.get();
    }


    

}