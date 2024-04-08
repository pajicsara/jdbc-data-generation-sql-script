package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestHelper {

    public static boolean checkNumberOfEmployees(int requiredNumber) throws SQLException {
        boolean exists = false;
        try (Connection connection = DatabaseManager.connectWithDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS total FROM `demo`.`employees`");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                int totalEmployees = resultSet.getInt("total");
                exists = totalEmployees >= requiredNumber;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exists;
    }

    public static boolean areEmployeesWithSalaryBelowPresent(double threshold) {
        boolean present = false;
        try (Connection connection = DatabaseManager.connectWithDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM employees WHERE salary < ?")) {
            preparedStatement.setDouble(1, threshold);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                present = count > 0;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return present;
    }

    public static boolean areEmployeesFromDepartmentPresent(String department) {
        boolean present = false;
        try (Connection connection = DatabaseManager.connectWithDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM employees WHERE department = ?")) {
            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                present = count > 0;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return present;
    }

    public static boolean areEmployesPresenetedInDB() {
        boolean present = false;
        try(Connection connection = DatabaseManager.connectWithDatabase();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS count FROM employees")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                present = count > 0;
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return present;
    }



}
