package v6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IOSQLite implements Saving {
    private static final String DATABASE_URL = "jdbc:sqlite:calculations.db";

    @Override
    public void save(double result) {
        String createTable = "CREATE TABLE IF NOT EXISTS calculations ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, result REAL NOT NULL)";
        String insertResult = "INSERT INTO calculations(result) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
                PreparedStatement createStatement = connection.prepareStatement(createTable);
                PreparedStatement insertStatement = connection.prepareStatement(insertResult)) {
            createStatement.executeUpdate();
            insertStatement.setDouble(1, result);
            insertStatement.executeUpdate();
            System.out.println("Result saved to SQLite database.");
        } catch (SQLException exception) {
            System.out.println("SQLite unavailable; simulated save for result " + result
                    + ". " + exception.getMessage());
        }
    }
}
