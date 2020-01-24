package dk.aau.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dk.aau.model.ReferralListModel;
import dk.aau.model.ReferralModel;
import dk.aau.model.ReferralStatusModel;
import dk.aau.model.VisitationModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHandlerCtrl {
    private final static String username = "hst_2019_19gr5402";
    private final static String password = "aiyozatheiyaigageize";
    private final static String host = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr5402?serverTimezone=UTC";

    private static ArrayList<Object> databaseReadHelp(String sqlQuery) {
        Connection conn = null;
        ResultSet rs = null;

        // "referralList" er en erstatning for at returnere et ResultSet. referralList
        // er en ArrayList som indeholder flere ArrayLists der indeholder typen Object
        ArrayList<Object> referralList = new ArrayList<>();
        ArrayList<Object> row = null; // "row" er en ArrayList som indeholder information om en enkelt række i
                                      // databasen

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(host, username, password);

            rs = conn.prepareStatement(sqlQuery).executeQuery(); // Bruges til at vælge data i database
            ResultSetMetaData metaData = rs.getMetaData(); // Metadata for ResultSet indeholder data om tabellen der
                                                           // returneres fra databasen
            Integer columnCount = metaData.getColumnCount(); // Metadata indeholder antal kolonner i tabellen, hvilket
                                                             // gemmes i værdien columnCount
            while (rs.next()) {
                row = new ArrayList<Object>(); // For hver RÆKKE i databasen oprettes en ny Arraylist
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i)); // For hver database-KOLONNE i den aktuelle række, tilføjes kolonnens
                                              // værdi til ArrayList "row" som et Object
                }
                referralList.add(row); // Den ArrayList som repræsenterer den aktuelle række, tilføjes til ArrayList
                                       // "referralList", som er erstatning for ResultSet
            }
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close(); // Lukker ResultSet
                }
            } catch (Exception e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close(); // Lukker Connection
                }
            } catch (Exception e) {
                /* ignored */ }
        }
        return referralList; // Returnerer "referralList" som er en ArrayList
    }

    // Henter data som indsættes i tableview i "ReferralListCtrl"
    public ObservableList<ReferralListModel> readReferralList() {
        Connection conn = null;
        ResultSet rs = null;
        ObservableList<ReferralListModel> referralList = FXCollections.observableArrayList(); // "referralList" laves om
                                                                                              // til en ObservableList
                                                                                              // for at kunne lægges i
                                                                                              // tableview
        
        String sqlQuery = "SELECT Referral.referralSentDate, Referral.referralReceivedDate,  Referral.referredBy,  Referral.referralID, Referral.referralType, Patient.cprNumber, Patient.name, DATEDIFF(CURDATE(), Referral.referralSentDate) AS layDays, Visitation.assigned, Visitation.referralStatus, Visitation.referralDiagnosisCodeICD, Visitation.statusTime, Visitation.statusDate FROM Referral JOIN Patient ON Referral.cprNumber=Patient.cprNumber JOIN Visitation ON Referral.referralID=Visitation.visitationID ORDER BY Visitation.statusTime AND Visitation.statusDate DESC";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(host, username, password);

            rs = conn.prepareStatement(sqlQuery).executeQuery(); // Bruges til at vælge data i database

            while (rs.next()) {

                     ReferralListModel referralListData = new ReferralListModel(rs.getString("Referral.referralSentDate"),
                             rs.getString("Referral.referralReceivedDate"), rs.getString("layDays"),
                             rs.getString("Visitation.referralStatus"), rs.getString("Visitation.assigned"),
                             rs.getString("Referral.referredBy"), rs.getString("Patient.cprNumber") + "\n" + rs.getString("Patient.name"),
                             rs.getString("Visitation.referralDiagnosisCodeICD"), rs.getString("Referral.referralID"),
                            rs.getString("Referral.referralType"));
                referralList.add(referralListData);
            }
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close(); // Lukker ResultSet
                }
            } catch (Exception e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close(); // Lukker Connection
                }
            } catch (Exception e) {
                /* ignored */ }
        }
        return referralList; // Returnerer referralList som er en ObservableList
    }

    // Henter data fra databasen som lægges i "ReferralModel" og metoden indsættes i
    // "ReferralCtrl"
    public ReferralModel readReferral(String id) {

        String sqlQuery = "SELECT Patient.name, Patient.address, Patient.cprNumber, Patient.postalCode, Patient.city, Referral.referralSentDate, Referral.referralReceivedDate, Referral.referredBy, Visitation.waitingGroup, Referral.diagnosisText, Referral.referralID, ResponsibleUnit.course, Referral.anamnesis, Referral.referralType, ResponsibleUnit.responsibleUnit FROM Patient JOIN Referral ON Patient.cprNumber=Referral.cprNumber JOIN Visitation ON Referral.referralID=Visitation.visitationID JOIN ResponsibleUnit ON Visitation.responsibleUnit=ResponsibleUnit.responsibleUnit WHERE Visitation.visitationID = "+id+" ORDER BY Visitation.statusTime AND Visitation.statusDate DESC LIMIT 1";

        ArrayList<Object> referralList = databaseReadHelp(sqlQuery); // Anvender hjælperfunktionen til at definere et
                                                                     // ResultSet med resultatet af forespørgslen
        ReferralModel referralModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> referralData = (ArrayList<Object>) referral;
            String name = (String) referralData.get(0);
            String address = (String) referralData.get(1);
            Integer cprNumber = (Integer) referralData.get(2);
            Integer postalCode = (Integer) referralData.get(3);
            String city = (String) referralData.get(4);
            Date referralSentDate = (Date) referralData.get(5);
            Date referralRecievedDate = (Date) referralData.get(6);
            String referredBy = (String) referralData.get(7);
            String waitingGroup = (String) referralData.get(8);
            String diagnosisText = (String) referralData.get(9);
            String course = (String) referralData.get(11);
            String referralID = (String) referralData.get(10);
            String anamnesis = (String) referralData.get(12);
            String referralType = (String) referralData.get(13);
            String responsibleUnit = (String) referralData.get(14);

            referralModel = new ReferralModel(name, address, cprNumber, postalCode, city, referralSentDate,
                    referralRecievedDate, referredBy, waitingGroup, diagnosisText, course, referralID, anamnesis,
                    referralType, responsibleUnit);
        }
        return referralModel;
    }

    // Henter data fra databasen som lægges i "VisitationModel" og metoden indsættes
    // i "ReferralCtrl"
    public VisitationModel readVisitation(String id) {
        String sqlQuery = "SELECT note, phrase, diagnosisCodeIcpc, referralDiagnosisCodeIcd, scheduledProcedure FROM Visitation WHERE Visitation.visitationID = "+id;
        

        ArrayList<Object> referralList = databaseReadHelp(sqlQuery); // Anvender hjælperfunktionen til at definere et
                                                                     // ResultSet med resultatet af forespørgslen
        VisitationModel visitationModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> visitationData = (ArrayList<Object>) referral;
            String note = (String) visitationData.get(0);
            String phrase = (String) visitationData.get(1);
            String diagnosisCodeICPC = (String) visitationData.get(2);
            String referralDiagnosisCodeICD = (String) visitationData.get(3);
            // String scheduledProcedure = (String) visitationData.get(4);

            visitationModel = new VisitationModel(note, phrase, diagnosisCodeICPC, referralDiagnosisCodeICD, null);
        }
        return visitationModel;
    }

    // Henter data fra databasen som lægges i "ReferralStatusModel" og metoden
    // indsættes i "ReferralCtrl"
    public ReferralStatusModel readReferralStatus(String id) {

        String sqlQuery = "SELECT Visitation.statusDate, Visitation.statusTime, Visitator.unit, Visitation.patientPrivilege, Visitation.referralstatus, Visitation.assigned, Visitator.visitator FROM Visitation JOIN Visitator ON Visitation.visitator=Visitator.visitator WHERE Visitation.visitationID="
                + id;
        
        ArrayList<Object> referralList = databaseReadHelp(sqlQuery); // Anvender hjælperfunktionen til at definere et
                                                                     // ResultSet med resultatet af forespørgslen
        ReferralStatusModel referralStatusModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> referralStatus = (ArrayList<Object>) referral;
            String date = (String) referralStatus.get(0);
            String time = (String) referralStatus.get(1);
            String unit = (String) referralStatus.get(2);
            String patientPrivilege = (String) referralStatus.get(3);
            String status = (String) referralStatus.get(4);
            String assigned = (String) referralStatus.get(5);
            String visitator = (String) referralStatus.get(6);

            referralStatusModel = new ReferralStatusModel(date, time, unit, patientPrivilege, status, assigned,
                    visitator);
        }
        return referralStatusModel;
    }

    // Hjælper med at skrive forespøgelser til databasen
    private static void databaseWriteHelp(String sqlQuery) throws ClassNotFoundException, SQLException {
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(host, username, password);
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlQuery);
            conn.close();
        } catch (SQLDataException e) {
            throw e;
        }
    }

    // Nedenstående funktioner bruges til at tilføje data til databasen i
    // eksisterende rækker - bruges i "ReferralCtrl"
    


    public void addReferralStatus(ReferralStatusModel referralStatusModel)
            throws SQLException, ClassNotFoundException {
        String updateStmt = null;
        if (referralStatusModel.getVisitator() != null || referralStatusModel.getUnit()!= null) {
            updateStmt = "INSERT INTO Visitator\n"
                    + "(visitator, unit\n)" + "VALUE('"
                    + referralStatusModel.getVisitator() + "','" + referralStatusModel.getUnit() + "');";

        }
        try {
            databaseWriteHelp(updateStmt);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error occurred while trying to insert into database: " + e.getMessage());
            throw e;
        }
    }

    public void addVisitation(ReferralModel referralModel, ReferralStatusModel referralStatusModel,
            VisitationModel visitationModel) throws SQLException, ClassNotFoundException {
        String updateStmt = null;
        if (referralStatusModel.getAssigned() != null || referralStatusModel.getDate() != null
                || referralStatusModel.getPatientPrivilege() != null || referralStatusModel.getStatus() != null
                || referralStatusModel.getUnit() != null || visitationModel.getDiagnosisCodeIcpc() != null
                || visitationModel.getReferralDiagnosisCodeIcd() != null || visitationModel.getNote() != null
                || visitationModel.getPhrase() != null || referralModel.getWaitingGroup() != null ||referralStatusModel.getVisitator() != null || referralModel.getReferralID() != null) {
            updateStmt = "INSERT INTO Visitation\n"
                    + "(PatientPrivilege, referralStatus, assigned, statusTime, statusDate, diagnosisCodeIcpc, referralDiagnosisCodeIcd, note, phrase, waitingGroup, visitator, responsibleUnit, visitationID\n)"
                    + "VALUE('" + referralStatusModel.getPatientPrivilege() + "','" + referralStatusModel.getStatus()
                    + "','" + referralStatusModel.getAssigned() + "','" + referralStatusModel.getTime() + "','"
                    + referralStatusModel.getDate() + "','" + visitationModel.getDiagnosisCodeIcpc() + "','"
                    + visitationModel.getReferralDiagnosisCodeIcd() + "','" + visitationModel.getNote() + "','"
                    + visitationModel.getPhrase() +"','"+ referralModel.getWaitingGroup()+"','" + referralStatusModel.getVisitator() + "','"+ referralStatusModel.getUnit()+"','" + referralModel.getReferralID()+ "');";
        }

        try {
            databaseWriteHelp(updateStmt);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error occurred while trying to insert into database: " + e.getMessage());
            throw e;
        }
    }
}
