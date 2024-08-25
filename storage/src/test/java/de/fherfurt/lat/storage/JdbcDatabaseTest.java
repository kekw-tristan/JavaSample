package de.fherfurt.lat.storage;

import de.fherfurt.lat.storage.data.core.DatabaseConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcDatabaseTest {


    @Test
    public void testMariadb() {

        boolean testCreatedInserted = testCreateInsert();
        boolean testedQuery = testQuery();
        boolean testedDrop = testDeleteAndDrop();

        Assertions.assertTrue(testCreatedInserted, "Connection was closed without exceptions");
        Assertions.assertTrue(testedQuery , "Queries Data is correct and Connection was closed without exceptions");
        Assertions.assertTrue(testedDrop, "Connection was closed without exceptions");
    }

    boolean testCreateInsert () {
        boolean result = false;

        try{
            DatabaseConnection db = DatabaseConnection.getInstance();
            db.connectToDatabase("jdbc:mariadb://localhost:3306/lat");

            Statement stmt = db.getConnection().createStatement();
            stmt.execute("CREATE TABLE persons (ID INT PRIMARY KEY, Name VARCHAR(255) )");

            PreparedStatement pStmt = db.getConnection().prepareStatement("INSERT INTO persons VALUES (?, ?)");
            pStmt.setInt(1, 1);
            pStmt.setString(2, "Hans");
            pStmt.execute();

            db.closeDatabaseConnection();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    boolean testQuery()
    {
        boolean result = false;

        try {
            DatabaseConnection db = DatabaseConnection.getInstance();
            db.connectToDatabase("jdbc:mariadb://localhost:3306/lat");

            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID, Name from persons");

            while (rs.next()) {
                int entryId = rs.getInt("ID");
                String entryName = rs.getString("Name");

                result = entryId == 1 && entryName.equals("Hans");
            }

            db.closeDatabaseConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    boolean testDeleteAndDrop()
    {
        boolean result = false;

        try {
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connectToDatabase("jdbc:mariadb://localhost:3306/lat");

        Statement stmt = db.getConnection().createStatement();
        stmt.execute("DROP TABLE persons");

        db.closeDatabaseConnection();
        result = true;
    }
        catch (SQLException e) {
        e.printStackTrace();
        result = false;
    }

        return result;
}

}
