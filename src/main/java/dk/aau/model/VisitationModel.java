package dk.aau.model;

public class VisitationModel{
    private String note;
    private String phrase;
    private String diagnosisCodeIcpc;
    private String referralDiagnosisCodeIcd ;
    private String scheduledProcedure;

    // Constructor
    public VisitationModel(String note, String phrase, String diagnosisCodeIcpc, String referralDiagnosisCodeIcd, String scheduledProcedure) {
        this.note = note;
        this.phrase = phrase;
        this.diagnosisCodeIcpc = diagnosisCodeIcpc;
        this.referralDiagnosisCodeIcd = referralDiagnosisCodeIcd;
        this.scheduledProcedure = scheduledProcedure; 
    }

    // Getters
    public String getNote() {
        return note;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getDiagnosisCodeIcpc() {
        return diagnosisCodeIcpc;
    }

    public String getReferralDiagnosisCodeIcd() {
        return referralDiagnosisCodeIcd;
    }

    public String getScheduledProcedure() {
        return scheduledProcedure;
    }
    
}