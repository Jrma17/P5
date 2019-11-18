package dk.aau.model;

import java.util.Date;

public class ReferralListModel {

    private ReferralModel referralModel;
    private int waitingDays;
    private ReferralStatusModel referralStatusModel;
    private PatientModel patientModel;
    private VisitationModel visitationModel;
    private SortListModel sortListModel;
    private Date todaysDate;


    //Getter og Setter
    public int calculateWaitingDays(Date ReferralSentDate, Date todaysDate)
    {
        return waitingDays;
         
    } 

    public ReferralModel getReferralModel() {
        return referralModel;
    }

    public void setReferralModel(ReferralModel referralModel) {
        this.referralModel = referralModel;
    }

    public int getWaitingDays() {
        return waitingDays;
    }

    public void setWaitingDays(int waitingDays) {
        this.waitingDays = waitingDays;
    }

    public ReferralStatusModel getReferralStatusModel() {
        return referralStatusModel;
    }

    public void setReferralStatusModel(ReferralStatusModel referralStatusModel) {
        this.referralStatusModel = referralStatusModel;
    }

    public PatientModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(PatientModel patientModel) {
        this.patientModel = patientModel;
    }

    public VisitationModel getVisitationModel() {
        return visitationModel;
    }

    public void setVisitationModel(VisitationModel visitationModel) {
        this.visitationModel = visitationModel;
    }

    public SortListModel getSortListModel() {
        return sortListModel;
    }

    public void setSortListModel(SortListModel sortListModel) {
        this.sortListModel = sortListModel;
    }

    public Date getTodaysDate() {
        return todaysDate;
    }

    public void setTodaysDate(Date todaysDate) {
        this.todaysDate = todaysDate;
    }



}