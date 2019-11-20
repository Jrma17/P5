package dk.aau.controller;

import dk.aau.MainApp;
import dk.aau.controller.*;
import javafx.fxml.FXML;

public class MainCtrl {
    private ReferralListCtrl referralListCtrl;
    @FXML public ReferralCtrl referralCtrl;
    private MappingListCtrl mappingListCtrl;
    private CatalogCtrl catalogCtrl;

    // Reference to the main application.
    private MainApp mainApp;

       /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    
    }

    @FXML private void initialize(){
        referralCtrl.initialize(this);
    }
        
}
