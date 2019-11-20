package dk.aau.controller;

import dk.aau.MainApp;
import dk.aau.controller.*;

public class MainCtrl {
    private ReferralListCtrl referralListCtrl;
    private ReferralCtrl referralCtrl;
    private MappingListCtrl mappingListCtrl;
    private CatalogCtrl catalogCtrl;


       /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    
    }
}
