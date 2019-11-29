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

import dk.aau.model.DatabaseDetails;
import dk.aau.model.PatientModel;
import dk.aau.model.Queryable;
import dk.aau.model.ReferralListModel;
import dk.aau.model.ReferralModel;
import dk.aau.model.VisitationModel;

public class ReferralHandler {

    private static ArrayList databaseReaderHelperFunction(String sqlQuery) {
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<Object> referralList = new ArrayList<>(); // resultList er en erstatning for at returnere et
                                                            // ResultSet. resultList er en ArrayList som indeholder
                                                            // flere ArrayLists der indeholder typen Object
        ArrayList<Object> row = null; // row er en ArrayList som indeholder information om en enkelt række i databasen

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // String connectionUrl =
            // "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2019_19gr5402?serverTimezone=UTC";
            conn = DriverManager.getConnection(DatabaseDetails.host, DatabaseDetails.username,
                    DatabaseDetails.password);

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

    public static ReferralModel readReferral() {

        String sqlQuery = "SELECT referralSentDate, referralRecievedDate, referredBy, referralType, waitingGroup, diagnosisText, course, responsibleUnit, referralID, anamnesis FROM Referral"; // Vælger
                                                                                                                                                                                                  // first-
                                                                                                                                                                                                  // og
                                                                                                                                                                                                  // lastname
                                                                                                                                                                                                  // fra
                                                                                                                                                                                                  // listen
                                                                                                                                                                                                  // "persons
        ArrayList referralList = databaseReaderHelperFunction(sqlQuery); // Anvender hjælperfunktionen til at definere
                                                                         // et ResultSet med resultatet af forespørgslen

        ReferralModel referralModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> referralData = (ArrayList<Object>) referral;
            String DreferralSentDate = (String) referralData.get(0);
            String DreferralRecievedDate = (String) referralData.get(1);
            String DreferredBy = (String) referralData.get(2);
            String DreferralType = (String) referralData.get(3);
            String DwaitingGroup = (String) referralData.get(4);
            String DdiagnosisText = (String) referralData.get(5);
            String Dcourse = (String) referralData.get(6);
            String DresponsibleUnit = (String) referralData.get(7);
            String DreferralID = (String) referralData.get(8);
            String Danamnesis = (String) referralData.get(9);

            referralModel = new ReferralModel(DreferralSentDate, DreferralRecievedDate, DreferredBy, DreferralType,
                    DwaitingGroup, DdiagnosisText, Dcourse, DresponsibleUnit, DreferralID, Danamnesis);
        }

        return referralModel;

    }

    public static PatientModel readPatientData() {
        String sqlQuery = "SELECT name, address, cprNumber FROM Patient"; // Vælger first- og lastname fra listen
                                                                          // "persons
        ArrayList referralList = databaseReaderHelperFunction(sqlQuery); // Anvender hjælperfunktionen til at definere
                                                                         // et ResultSet med resultatet af forespørgslen
        PatientModel patientModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> patientData = (ArrayList<Object>) referral;
            String name = (String) patientData.get(0);
            String address = (String) patientData.get(2);
            String cprNumber = (String) patientData.get(1);

            patientModel = new PatientModel(name, address, cprNumber);
        }

        return patientModel;
    }

    public static ReferralListModel readReferralList() {

        String sqlQuery = "SELECT referralSentDate, referralRecievedDate, referredBy, referralType, waitingGroup, diagnosisText, course, responsibleUnit, referralID, anamnesis FROM Referral"; // Vælger
                                                                                                                                                                                      // "persons
        ArrayList referralList = databaseReaderHelperFunction(sqlQuery); // Anvender hjælperfunktionen til at definere
                                                                         // et ResultSet med resultatet af forespørgslen

        ReferralListModel referralListModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> referralListData = (ArrayList<Object>) referral;
            String referralSentDate = (String) referralListData.get(0);
            String referralRecievedDate = (String) referralListData.get(1);
            String referralType = (String) referralListData.get(3);
            String referredFrom = (String) referralListData.get(2);
            String referralID = (String) referralListData.get(8);

            referralListModel = new ReferralListModel(referralRecievedDate, referralSentDate, null, null, null,
                    referredFrom, null, null, referralID, referralType);
        }

        return referralListModel;

    }

    public static VisitationModel readVisitation() {

        String sqlQuery = "SELECT note, phrase, diagnosisCodeICPC, scheduledProcedure FROM Visitation"; // Vælger
                                                                                                                                                                                      // "persons
        ArrayList referralList = databaseReaderHelperFunction(sqlQuery); // Anvender hjælperfunktionen til at definere
                                                                         // et ResultSet med resultatet af forespørgslen

        VisitationModel visitationModel = null;
        for (Object referral : referralList) {
            ArrayList<Object> visitationData = (ArrayList<Object>) referral;
            //String note = (String) visitationData.get(0);
           // String rphrase = (String) visitationData.get(1);
            String diagnosisCodeICPC = (String) visitationData.get(3);
           // String referralDiagnosisCodeICD = (String) visitationData.get(2);
           // String scheduledProcedure = (String) visitationData.get(8);

            visitationModel = new VisitationModel(diagnosisCodeICPC);
        }

        return visitationModel;

    }
    private static void databaseWriteHelperFunction(String sqlQuery) throws ClassNotFoundException, SQLException {
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DatabaseDetails.host, DatabaseDetails.username,
                    DatabaseDetails.password);
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlQuery);
            conn.close();
        } catch (SQLDataException e) {
            throw e;
        }
    }

    public static void addICPC(VisitationModel visitationModel) throws SQLException, ClassNotFoundException {
        String updateStmt = null;
        if (visitationModel.getDiagnosisCodeICPC() != null) {
            updateStmt = "INSERT INTO Visitation\n"+"(diagnosisCodeICPC\n)"+"VALUES('"+ visitationModel.getDiagnosisCodeICPC() +"');";
           
                    
                    
                    //"VALUES ('"+ Main.patient.getCprSerialNumber() ficDrug.getDrug().getGenericName()+"');";
        }
        try {
            databaseWriteHelperFunction(updateStmt);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error occurred while trying to insert into database: " + e.getMessage());
            throw e;
        }

    }
    
}
