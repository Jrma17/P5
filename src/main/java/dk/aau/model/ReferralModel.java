package dk.aau.model;

import java.util.Date;

public class ReferralModel {
    private Date referralSentDate;
    private Date referralRecievedDate;
    private String referredBy;
    private String waitingGroup;
    private String diagnosisText;
    private String course;
    private String referralID;
    private String anamnesis;
    private String referralType;
    private String responsibleUnit;


    //Getter og Setter
    public Date getReferralSentDate() {
        return referralSentDate;
    }

    public void setReferralSentDate(Date referralSentDate) {
        this.referralSentDate = referralSentDate;
    }

    public Date getReferralRecievedDate() {
        return referralRecievedDate;
    }

    public void setReferralRecievedDate(Date referralRecievedDate) {
        this.referralRecievedDate = referralRecievedDate;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getWaitingGroup() {
        return waitingGroup;
    }

    public void setWaitingGroup(String waitingGroup) {
        this.waitingGroup = waitingGroup;
    }

    public String getDiagnosisText() {
        return diagnosisText;
    }

    public void setDiagnosisText(String diagnosisText) {
        this.diagnosisText = diagnosisText;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getReferralID() {
        return referralID;
    }

    public void setReferralID(String referralID) {
        this.referralID = referralID;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getReferralType() {
        return referralType;
    }

    public void setReferralType(String referralType) {
        this.referralType = referralType;
    }

    public String getResponsibleUnit() {
        return responsibleUnit;
    }

    public void setResponsibleUnit(String responsibleUnit) {
        this.responsibleUnit = responsibleUnit;
    }
}