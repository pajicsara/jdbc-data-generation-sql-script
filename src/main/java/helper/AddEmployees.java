package helper;

import java.sql.*;

import static util.SqlQueries.ADD_EMPLOYEE_TO_DATABASE;

public class AddEmployees {

    //Generate one common method for those two methods, so if department is sent as a parameter add that department, and if not add random department?
    public static void addEmployeesToTable(double numberOfEmployees) {
        try(Connection connection = DatabaseManager.connectWithDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_TO_DATABASE))
        {
                for(int i = 0; i < numberOfEmployees; i++) {

                    String firstName = EmployeeDataGenerator.generateFirstName();
                    String lastname = EmployeeDataGenerator.generateLastName();
                    String email = EmployeeDataGenerator.generateEmail();
                    String department = EmployeeDataGenerator.generateDepartment();
                    double salary = EmployeeDataGenerator.generateRandomSalary();

                    preparedStatement.setString(1, firstName);
                    preparedStatement.setString(2, lastname);
                    preparedStatement.setString(3, email);
                    preparedStatement.setString(4, department);
                    preparedStatement.setDouble(5, salary);

                    preparedStatement.executeUpdate();
                }

        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void addEmployeesForSpecificDepartment(int numberOfEmployees, String deparment) {
        System.out.println(numberOfEmployees + " employees for department " + deparment + " will be added to a database.");
        try(Connection connection = DatabaseManager.connectWithDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_TO_DATABASE))
        {
            for(int i = 0; i < numberOfEmployees; i++) {

                String firstName = EmployeeDataGenerator.generateFirstName();
                String lastname = EmployeeDataGenerator.generateLastName();
                String email = EmployeeDataGenerator.generateEmail();
                double salary = EmployeeDataGenerator.generateRandomSalary();

                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastname);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, deparment);
                preparedStatement.setDouble(5, salary);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
