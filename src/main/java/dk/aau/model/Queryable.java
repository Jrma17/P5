package dk.aau.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Queryable {

    void processResultSet(ResultSet rs) throws SQLException;

    String returnSqlQuery();
    
}