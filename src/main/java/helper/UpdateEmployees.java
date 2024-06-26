package helper;

import java.sql.*;

import static util.SqlQueries.ADD_EMPLOYEE_TO_DATABASE;

public class UpdateEmployees {

    public static void raiseSalaries(double increaseAmount) {
        try (Connection connection = DatabaseManager.connectWithDatabase();
             PreparedStatement preparedStatementSalary = connection.prepareStatement("SELECT id, salary FROM employees");
             ResultSet resultSet = preparedStatementSalary.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double currentSalary = resultSet.getDouble("salary");

                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employees SET salary = ? WHERE id = ?");
                preparedStatement.setDouble(1, currentSalary + increaseAmount);
                preparedStatement.setInt(2, id);

                double newSalary = currentSalary + increaseAmount;

                int updatedRows = preparedStatement.executeUpdate();

                if (updatedRows > 0) {
                    System.out.println("SALARY CHANGED FOR EMPLOYEE WITH ID " + id);
                    System.out.println("OLD SALARY: " + currentSalary);
                    System.out.println("NEW SALARY: " + newSalary);
                    System.out.println("--------------------");
                } else {
                    System.out.println("Something went wrong with the salary for employee with ID " + id);
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void raiseSalariesForSpecificDepartment(double increaseAmount, String department) {
        try (Connection connection = DatabaseManager.connectWithDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, salary FROM employees WHERE department = ?")) {

            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double currentSalary = resultSet.getDouble("salary");

                PreparedStatement updateStatement = connection.prepareStatement("UPDATE employees SET salary = ? WHERE id = ?");
                updateStatement.setDouble(1, currentSalary + increaseAmount);
                updateStatement.setInt(2, id);

                double newSalary = currentSalary + increaseAmount;

                int updatedRows = updateStatement.executeUpdate();

                if (updatedRows > 0) {
                    System.out.println("SALARY CHANGED FOR EMPLOYEE WITH ID " + id);
                    System.out.println("OLD SALARY: " + currentSalary);
                    System.out.println("NEW SALARY: " + String.format("%.2f", newSalary));
                    System.out.println("--------------------");
                } else {
                    System.out.println("Something went wrong with the salary for employee with ID " + id);
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
