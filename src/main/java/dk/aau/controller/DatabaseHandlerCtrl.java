package dk.aau.controller;

import java.sql.Connection;
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

    private static ArrayList databaseReadHelp(String sqlQuery) {
        Connection conn = null;
        ResultSet rs = null;

        ArrayList<Object> referralList = new ArrayList<>(); // resultList er en erstatning for at returnere et
                                                            // ResultSet. resultList er en ArrayList som indeholder
                                                            // flere ArrayLists der indeholder typen Object
        ArrayList<Object> row = null; // row er en ArrayList som indeholder information om en enkelt række i databasen

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(host, username, password);

            rs = conn.prepareStatement(sqlQuery).executeQuery(); // Bruges til at vælge data i database
            ResultSetMetaData metaData = rs.getMetaData(); // Metadata for ResultSet indeholder data om tabellen der
                                                           // returneres fra DB.
            Integer columnCount = metaData.getColumnCount(); // Metadata indeholder antal kolonner i tabellen, hvilket
                                                             // her gemmes i værdien columnCount
            while (rs.next()) {
                row = new ArrayList<Object>(); // For hver RÆKKE i databasen oprettes en ny Arraylist
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i)); // For hver database-KOLONNE i den aktuelle række, tilføjes kolonnens
                                              // værdi til ArrayList "row" som et Object
                }
                referralList.add(row); // Den ArrayList som repræsenterer den aktuelle række, tilføjes til ArrayList
                                       // "resultList", som er erstatning for ResultSet
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
        return referralList; // Returnerer resultList som er en ArrayList
    }

    // Henter data som indsætte i table view i referralListCtrl
    public ObservableList<ReferralListModel> readReferralList() {
        Connection conn = null;
        ResultSet rs = null;
        ObservableList<ReferralListModel> referralList = FXCollections.observableArrayList(); // resultList er en
                                                                                              // erstatning for at
                                                                                              // returnere et
        String sqlQuery = "SELECT Referral.referralSentDate, Referral.referralRecievedDate, Referral.referredBy, Referral.referralType, Referral.referralID, Referral.referralDiagnosisCodeICD, Patient.cprNumber, Patient.name, Referral.referralStatus, Referral.assigned, DATEDIFF(CURDATE(), Referral.referralSentDate) AS layDays FROM Referral JOIN Patient ON Referral.cprNumber=Patient.cprNumber";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(host, username, password);

            rs = conn.prepareStatement(sqlQuery).executeQuery(); // Bruges til at vælge data i database

            while (rs.next()) {
                ReferralListModel referralListData = new ReferralListModel(rs.getString("Referral.referralSentDate"),
                        rs.getString("Referral.referralRecievedDate"), rs.getString("layDays"),
                        rs.getString("Referral.referralStatus"), rs.getString("Referral.assigned"),
                        rs.getString("Referral.referredBy"), rs.getString("Patient.cprNumber"),
                        rs.getString("Referral.ReferralDiagnosisCodeICD"), rs.getString("Referral.referralID"),
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
        return referralList; // Returnerer resultList som er en ArrayList
    }

    // Henter data fra databasen som indsætte i referralCtrl
    public ReferralModel readReferral(String id) {
        String sqlQuery = "SELECT Patient.name, Patient.address, Patient.cprNumber, Referral.referralSentDate, Referral.referralRecievedDate, Referral.referredBy, Referral.waitingGroup, Referral.diagnosisText, Referral.course, Referral.referralID, Referral.anamnesis, Referral.referralType, Referral.responsibleUnit FROM Referral JOIN Patient ON Referral.cprNumber=Patient.cprNumber WHERE Referral.cprNumber ="
                + id;

        ArrayList referralList = databaseReadHelp(sqlQuery);
        ReferralModel referralModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> referralData = (ArrayList<Object>) referral;
            String name = (String) referralData.get(0);
            String address = (String) referralData.get(1);
            String cprNumber = (String) referralData.get(2);
            String referralSentDate = (String) referralData.get(3);
            String referralRecievedDate = (String) referralData.get(4);
            String referredBy = (String) referralData.get(5);
            String waitingGroup = (String) referralData.get(6);
            String diagnosisText = (String) referralData.get(7);
            String course = (String) referralData.get(8);
            String referralID = (String) referralData.get(9);
            String anamnesis = (String) referralData.get(10);
            String referralType = (String) referralData.get(11);
            String responsibleUnit = (String) referralData.get(12);

            referralModel = new ReferralModel(name, address, cprNumber, referralSentDate, referralRecievedDate,
                    referredBy, waitingGroup, diagnosisText, course, referralID, anamnesis, referralType,
                    responsibleUnit);
        }
        return referralModel;
    }

    // Henter data fra databasen som indsætte i referralCtrl
    public VisitationModel readVisitation(String id) {
        String sqlQuery = "SELECT referralSentDate, referralRecievedDate, referredBy, referralType, waitingGroup, diagnosisText, course, responsibleUnit, referralID, anamnesis, layDays, note, phrase, diagnosisCodeICPC, referralDiagnosisCodeICD, scheduledProcedure, date, unit, time, patientPrivilege, referralStatus, assigned, visitator FROM Referral WHERE cprNumber= "
                + id;
        ArrayList referralList = databaseReadHelp(sqlQuery); // Anvender hjælperfunktionen til at definere
                                                                         // et ResultSet med resultatet af forespørgslen

        VisitationModel visitationModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> visitationData = (ArrayList<Object>) referral;
            String note = (String) visitationData.get(11);
            String phrase = (String) visitationData.get(12);
            String diagnosisCodeICPC = (String) visitationData.get(13);
            String referralDiagnosisCodeICD = (String) visitationData.get(14);
            String scheduledProcedure = (String) visitationData.get(16);

            visitationModel = new VisitationModel(note, phrase, diagnosisCodeICPC, referralDiagnosisCodeICD, null);
        }

        return visitationModel;

    }

    // Henter data fra databasen som indsætte i referralCtrl
    public ReferralStatusModel readReferralStatus(String id) {

        String sqlQuery = "SELECT referralSentDate, referralRecievedDate, referredBy, referralType, waitingGroup, diagnosisText, course, responsibleUnit, referralID, anamnesis, layDays, note, phrase, diagnosisCodeICPC, referralDiagnosisCodeICD, scheduledProcedure, date, unit, time, patientPrivilege, referralStatus, assigned, visitator FROM Referral WHERE cprNumber= "
                + id;

        ArrayList referralList = databaseReadHelp(sqlQuery); // Anvender hjælperfunktionen til at definere
                                                                         // et ResultSet med resultatet af forespørgslen
        ReferralStatusModel referralStatusModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> referralStatus = (ArrayList<Object>) referral;
            // Date date = (Date) referralStatus.get(16);
            String time = (String) referralStatus.get(18);
            String unit = (String) referralStatus.get(17);
            String patientPrivilege = (String) referralStatus.get(19);
            String status = (String) referralStatus.get(20);
            String assigned = (String) referralStatus.get(21);
            String visitator = (String) referralStatus.get(22);

            referralStatusModel = new ReferralStatusModel(null, time, unit, patientPrivilege, status, assigned,
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

    // NEDENSTÅENDE FUNKTIONER BRUGES TIL AT TILFØJE DATA TIL DATABASEN I
    // EKSISTERENDE RÆKKER - BRUGES I REFERRALCTRL
    public void addIcpc(VisitationModel visitationModel, String id) throws SQLException, ClassNotFoundException {
        String updateStmt = null;

        if (visitationModel.getDiagnosisCodeIcpc() != null || visitationModel.getReferralDiagnosisCodeIcd() != null
                || visitationModel.getNote() != null || visitationModel.getPhrase() != null) {
            updateStmt = "UPDATE Referral SET referralDiagnosisCodeICD = '"
                    + visitationModel.getReferralDiagnosisCodeIcd() + "', diagnosisCodeICPC = '"
                    + visitationModel.getDiagnosisCodeIcpc() + "', note = '" + visitationModel.getNote()
                    + "', phrase = '" + visitationModel.getPhrase() + "'WHERE cprNumber ='" + id + "'";

        }
        try {
            databaseWriteHelp(updateStmt);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error occurred while trying to insert into database: " + e.getMessage());
            throw e;
        }

    }

    public void addReferral(ReferralModel referralModel, String id) throws SQLException, ClassNotFoundException {
        String updateStmt = null;
        if (referralModel.getWaitingGroup() != null || referralModel.getDiagnosisText() != null) {
            updateStmt = "UPDATE Referral SET diagnosisText = '" + referralModel.getDiagnosisText()
                    + "', waitingGroup = '" + referralModel.getWaitingGroup() + "'WHERE cprNumber ='" + id + "'";

        }
        try {
            databaseWriteHelp(updateStmt);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error occurred while trying to insert into database: " + e.getMessage());
            throw e;
        }

    }

    public void addReferralStatus(ReferralStatusModel referralStatusModel, String id)
            throws SQLException, ClassNotFoundException {
        String updateStmt = null;
        if (referralStatusModel.getAssigned() != null || referralStatusModel.getDate() != null
                || referralStatusModel.getPatientPrivilege() != null || referralStatusModel.getStatus() != null
                || referralStatusModel.getUnit() != null || referralStatusModel.getVisitator() != null) {
            updateStmt = "UPDATE Referral SET unit = '" + referralStatusModel.getUnit() + "', visitator = '"
                    + referralStatusModel.getVisitator() + "', patientPrivilege = '"
                    + referralStatusModel.getPatientPrivilege() + "', referralStatus = '"
                    + referralStatusModel.getStatus() + "', assigned = '" + referralStatusModel.getAssigned()
                    + "', time = '" + referralStatusModel.getTime() + "'WHERE cprNumber ='" + id + "'";

        }
        try {
            databaseWriteHelp(updateStmt);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error occurred while trying to insert into database: " + e.getMessage());
            throw e;
        }

    }

}
