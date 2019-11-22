package dk.aau;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dk.aau.model.*;
import dk.aau.view.*;
import dk.aau.controller.*;

public class App extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;
    private ObservableList<ReferralListModel> referrals = FXCollections.observableArrayList();


    public App(){
        referrals.add(new ReferralListModel("1/1-2019", "1/1-2019", "30", "Modtaget", "Alle", "Lægehus A",
                "Hans 233492-1233", "Årsag 1", "ICPC-kode", "A"));
        referrals.add(new ReferralListModel("12/1-2019", "12/1-2019", "0", "Visiteret", "Alle", "Lægehus B",
                "Ruth 290506-1236", "Årsag 1", "ICD10-kode", "B"));
        referrals.add(new ReferralListModel("2/1-2019", "2/1-2019", "29", "Modtaget", "Alle", "Lægehus C",
                "Heinz 311200-9561", "Årsag 1", "ICPC-kode", "C"));
        referrals.add(new ReferralListModel("4/1-2019", "1/1-2019", "27", "Modtaget", "Alle", "Lægehus D",
                "Cornelia 290483-2096", "Årsag 1", "ICPC-kode", "D"));
        referrals.add(new ReferralListModel("7/1-2019", "6/1-2019", "24", "Modtaget", "Alle", "Lægehus E",
                "Werner 192835-1023", "Årsag 1", "ICPC-kode", "E"));
        referrals.add(new ReferralListModel("20/1-2019", "19/1-2019", "0", "Visiteret", "Alle", "Lægehus F",
                "Lydia 101039-5302", "Årsag 1", "ICD10-kode", "F"));
    }
    
    public ObservableList<ReferralListModel> getReferrals(){
        return referrals;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/ReferralListView.fxml"));
            rootLayout = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Returns the main stage.
    * @return
    */
   public Stage getPrimaryStage() {
       return primaryStage;
   }

   public static void main(String[] args) {
       launch(args);
   }

}