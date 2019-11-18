package dk.aau.controller;

import dk.aau.model.PatientModel;
import dk.aau.model.ReferralModel;
import dk.aau.model.ReferralStatusModel;
import dk.aau.model.SortListModel;
import dk.aau.model.VisitationModel;
import dk.aau.view.ReferralListModel;
import dk.aau.view.SortListView;

public class ReferralListCtrl {
    private ReferralListModel referralListView;
    private ReferralStatusModel referralStatusModel;
    private int waitingDays;
    private ReferralModel referralModel;
    private PatientModel patientModel;
    private VisitationModel visitationModel;
    private SortListModel sortListModel;
    private SortListView sortListView;
    private ReferralCtrl referralCtrl;


    public int calculateWaitingDays(){
        return waitingDays;

    }
    public void detectInputFromSortListView(){

    }
    public void sortListBy(){

    }
    public void recieveReferralList(){

    }
    public void detectInputFromReferralListView(){

    }
    public void generateReferralListView(){

    }
    public void updateReferralListView(){
        
    }
}