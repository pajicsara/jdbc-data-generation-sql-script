package helper;

import java.sql.*;

public class UpdateEmployees {

    private static Connection myConnection;
    static PreparedStatement preparedStatement = null;
    static ResultSet results = null;

    public static void raiseSalaries(double increaseAmount) throws SQLException {
        try {

            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");

            PreparedStatement preparedStatementSalary = myConnection.prepareStatement("SELECT id, salary FROM `demo`.`employees`");
            ResultSet resultSet = preparedStatementSalary.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                double currentSalary = resultSet.getDouble("salary");

                // Pripremite SQL upit za ažuriranje plate za određeni ID
                PreparedStatement preparedStatement = myConnection.prepareStatement("UPDATE `demo`.`employees` SET salary = ? WHERE id = ?");

                // Postavite novu vrijednost plate i ID kao parametre upita
                preparedStatement.setDouble(1, currentSalary + increaseAmount);
                preparedStatement.setInt(2, id);

                int updatedRows = preparedStatement.executeUpdate();

                if (updatedRows > 0) {
                    System.out.println("SALARY CHANGED for employee with ID " + id);
                } else {
                    System.out.println("Nesto nije ok sa platom za employee with ID " + id);
                }
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (results != null) {
                results.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if(myConnection != null) {
                myConnection.close();
            }
        }
    }

    public static void raiseSalariesForSpecificDepartment(double povisica, String department) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student")) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, salary FROM `demo`.`employees` WHERE department = ?");
            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double currentSalary = resultSet.getDouble("salary");

                // Pripremite SQL upit za ažuriranje plate za određeni ID
                PreparedStatement updateStatement = connection.prepareStatement("UPDATE `demo`.`employees` SET salary = ? WHERE id = ?");
                // Postavite novu vrijednost plate i ID kao parametre upita
                updateStatement.setDouble(1, currentSalary + povisica);
                updateStatement.setInt(2, id);

                updateStatement.executeUpdate();
                System.out.println("Salary for employee with ID " + id + " in department " + department + " changed.");
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
