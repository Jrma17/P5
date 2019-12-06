package dk.aau.model;

public class VisitationModel{
    private String note;
    private String phrase;
    private String diagnosisCodeICPC;
    private String referralDiagnosisCodeICD ;
    private String scheduledProcedure;


    //Constructor
    public VisitationModel(String note, String phrase, String diagnosisCodeICPC, String referralDiagnosisCodeICD, String scheduledProcedure) {
        this.note = note;
        this.phrase = phrase;
        this.diagnosisCodeICPC = diagnosisCodeICPC;
        this.referralDiagnosisCodeICD = referralDiagnosisCodeICD;
        this.scheduledProcedure = scheduledProcedure;
        
    }

    //Getter og Setter
    public String getNote() {
        return note;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getDiagnosisCodeICPC() {
        return diagnosisCodeICPC;
    }

    public String getReferralDiagnosisCodeICD() {
        return referralDiagnosisCodeICD;
    }

    public String getScheduledProcedure() {
        return scheduledProcedure;
    }
    
}