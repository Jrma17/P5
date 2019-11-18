package dk.aau.model;

import java.util.Date;

public class ReferralStatusModel{
    private Date date;
    private Date time;
    private String unit;
    private String patientPrivilege;
    private String status = "Modtaget";
    private String assigned = "Ingen";
    private String visitator;


    //Getter og Setter
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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