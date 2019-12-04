package dk.aau.model;

import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;

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
     * @param singleSelectionModel
     */
     public ReferralModel(SingleSelectionModel singleSelectionModel) {
         this(null, null, null, null, null, null, null, null, null, null);
     }
    public ReferralModel(String referralSentDate, String referralRecievedDate, String referredBy, String referralType, String waitingGroup, String diagnosisText,
             String course, String referralID, String responsibleUnit, String anamnesis) {
        this.referralSentDate = referralSentDate;
        this.referralRecievedDate = referralRecievedDate;
        this.referredBy = referredBy;
        this.referralType = referralType;        
        this.waitingGroup = waitingGroup;
        this.diagnosisText = diagnosisText;
        this.course = course;
        this.responsibleUnit = responsibleUnit;
        this.referralID = referralID;
        this.anamnesis = anamnesis;
    }

	public ReferralModel() {
    }
    
	//Getter og Setter
    public String getReferralSentDate() {
        return referralSentDate;
    }

    public String getReferralRecievedDate() {
        return referralRecievedDate;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public String getWaitingGroup() {
        return waitingGroup;
    }

    public String getDiagnosisText() {
        return diagnosisText;
    }

    public String getCourse() {
        return course;
    }

    public String getReferralID() {
        return referralID;
    }

    public String getAnamnesis() {
        return anamnesis;
    }


    public String getReferralType() {
        return referralType;
    }

    public String getResponsibleUnit() {
        return responsibleUnit;
    }

    
    
}