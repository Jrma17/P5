package dk.aau.model;


public class ReferralStatusModel {
    private String date;
    private String time;
    private String unit;
    private String patientPrivilege;
    private String status;
    private String assigned;
    private String visitator;
    
    // Constructor
    public ReferralStatusModel(String date, String time, String unit, String patientPrivilege, String status, String assigned, String visitator) {
        this.date = date;
        this.time = time;
        this.unit = unit;
        this.patientPrivilege = patientPrivilege;
        this.status = status;
        this.assigned = assigned;
        this.visitator = visitator;
    }
    
    // Getters
    public String getDate() {
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