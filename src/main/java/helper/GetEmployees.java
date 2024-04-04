package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetEmployees {

    private static final Logger logger = Logger.getLogger(GetEmployees.class.getName());
    DatabaseHelper helper = new DatabaseHelper();

    private static Connection connectWithDatabase() throws SQLException {
        return DatabaseManager.connectWithDatabase();
    }

    public static void selectUserWithSalaryHigher(double salary) {
        try (Connection connection = connectWithDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `demo`.`employees` WHERE salary > ? ")) {

            preparedStatement.setDouble(1, salary);
            ResultSet resultSet = preparedStatement.executeQuery();

            DatabaseHelper.printResultSet(resultSet);

        } catch (SQLException exception) {
            logger.log(Level.FINE, "An error occurred while selecting users with salary higher: " + exception.getMessage());
        }
    }

    public static void selectAllEmployees() {
        try (Connection connection = connectWithDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `demo`.`employees`")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            DatabaseHelper.printResultSet(resultSet);

        } catch (SQLException exception) {
            logger.log(Level.FINE, "An error occurred while selecting all employees: " + exception.getMessage());
        }
    }

}
