package dk.aau.model;

public class VisitationModel{
    private String note;
    private String phrase;
    private String diagnosisCodeICPC;
    private String referralDiagnosisCodeICD = "Ingen";
    private String scheduledProcedure;


    //Getter og Setter
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getDiagnosisCodeICPC() {
        return diagnosisCodeICPC;
    }

    public void setDiagnosisCodeICPC(String diagnosisCodeICPC) {
        this.diagnosisCodeICPC = diagnosisCodeICPC;
    }

    public String getReferralDiagnosisCodeICD() {
        return referralDiagnosisCodeICD;
    }

    public void setReferralDiagnosisCodeICD(String referralDiagnosisCodeICD) {
        this.referralDiagnosisCodeICD = referralDiagnosisCodeICD;
    }

    public String getScheduledProcedure() {
        return scheduledProcedure;
    }

    public void setScheduledProcedure(String scheduledProcedure) {
        this.scheduledProcedure = scheduledProcedure;
    }
}