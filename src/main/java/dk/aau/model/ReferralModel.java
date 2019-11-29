package dk.aau.model;

import java.util.Date;

import javafx.scene.control.Button;

public class ReferralModel {
    private String referralSentDate;
    private String referralRecievedDate;
    private String referredBy;
    private String waitingGroup;
    private String diagnosisText;
    private String course;
    private String referralID;
    private String anamnesis;
    private String referralType;
    private String responsibleUnit;
    private Button saveButton;

    /**
     * Default constructor.
     */
    public ReferralModel() {
        this(null, null, null, null, null, null, null, null, null);
    }
    public ReferralModel(String referralSentDate, String referralRecievedDate, String referredBy, String diagnosisText,
             String course, String referralID, String anamnesis, String referralType,
            String responsibleUnit) {
        this.referralSentDate = referralSentDate;
        this.referralRecievedDate = referralRecievedDate;
        this.referredBy = referredBy;
        this.diagnosisText = diagnosisText;
        this.course = course;
        this.referralID = referralID;
        this.anamnesis = anamnesis;
        this.referralType = referralType;
        this.responsibleUnit = responsibleUnit;
    }

	//Getter og Setter
    public String getReferralSentDate() {
        return referralSentDate;
    }

    public void setReferralSentDate(String referralSentDate) {
        this.referralSentDate = referralSentDate;
    }

    public String getReferralRecievedDate() {
        return referralRecievedDate;
    }

    public void setReferralRecievedDate(String referralRecievedDate) {
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