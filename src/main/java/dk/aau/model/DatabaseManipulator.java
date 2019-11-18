package dk.aau.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java.sql.Connection; DriverManager, ResultSet, SqlExecption, Statement

public class DatabaseManipulator{

    public static Connection getConnection(){
        Connection conn = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            try{

                conn = DriverManager.getConnection(DatabaseDetails.host, DatabaseDetails.username, DatabaseDetails.password);

            }
            catch(SQLException sqlex){

                System.out.println(sqlex.getMessage());

            }
        }
        catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        

        return conn;
    }

    public static void executeQueryWithResultSet( Queryable queryable){
        executeQueryWithResultSet(queryable.returnSqlQuery(), queryable);
    }
    
    public static void executeQueryWithResultSet(String sqlStatement, Queryable queryable){

        Connection conn = getConnection(); //Oprette forbindelse til database

        Statement stmt = null;
        ResultSet rs = null;

        if (conn != null){

            try {

                stmt = conn.createStatement();
                rs = stmt.executeQuery(sqlStatement);

                queryable.processResultSet(rs);

            } catch (SQLException sqlex) {

                System.out.println(sqlex.getMessage());
                
            }
            finally{
                
                try {
                    rs.close();
                } catch (SQLException sqlex) {
                    System.out.println(sqlex.getMessage());
                }

                try {
                    stmt.close();

                }  catch (SQLException sqlex) {
                    System.out.println(sqlex.getMessage());
                }
            }
            
        }

    }
}