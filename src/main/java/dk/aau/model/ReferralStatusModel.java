package dk.aau.model;

import javafx.scene.control.SingleSelectionModel;

public class ReferralStatusModel {
    private String date;
    private String time;
    private String unit;
    private String patientPrivilege;
    private String status = "Modtaget";
    private String assigned = "Ingen";
    private String visitator;

    public ReferralStatusModel(){
        
    }
    public ReferralStatusModel(SingleSelectionModel selectionModel) {
    }

    public ReferralStatusModel(String date, String time, String unit, String patientPrivilege, String status,
            String assigned, String visitator) {
        this.date = date;
        this.time = time;
        this.unit = unit;
        this.patientPrivilege = patientPrivilege;
        this.status = status;
        this.assigned = assigned;
        this.visitator = visitator;
    }

    // Getter og Setter
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getVisitator() {
        return visitator;
    }

    public void setVisitator(String visitator) {
        this.visitator = visitator;
    }

    public String getPatientPrivilege() {
        return patientPrivilege;
    }

    public void setPatientPrivilege(String patientPrivilege) {
        this.patientPrivilege = patientPrivilege;
    }

}