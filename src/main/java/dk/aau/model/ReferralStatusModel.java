package dk.aau.model;

import java.sql.Date;


public class ReferralStatusModel {
    private Date date;
    private String time;
    private String unit;
    private String patientPrivilege;
    private String status;
    private String assigned;
    private String visitator;

    //Constructor
    public ReferralStatusModel(Date date, String time, String unit, String patientPrivilege, String status,
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
    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getUnit() {
        return unit;
    }

    public String getStatus() {
        return status;
    }
    
    public String getAssigned() {
        return assigned;
    }

    public String getVisitator() {
        return visitator;
    }

    public String getPatientPrivilege() {
        return patientPrivilege;
    }

}