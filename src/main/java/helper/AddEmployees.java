package helper;

import java.sql.*;

import static util.SqlQueries.ADD_EMPLOYEE_TO_DATABASE;

public class AddEmployees {


    //Generate one common method for those two methods, so if department is sent as a parameter add that department, and if not add random department?
    public static void addEmployeesToTable(int numberOfEmployees) {
        System.out.printf("%d EMPLOYEES WILL BE ADDED TO DATABASE:%n", numberOfEmployees);
        System.out.println("--------------------");
        try(Connection connection = DatabaseManager.connectWithDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_TO_DATABASE))
        {
                for(int i = 0; i < numberOfEmployees; i++) {

                    String firstName = EmployeeDataGenerator.generateFirstName();
                    String lastName = EmployeeDataGenerator.generateLastName();
                    String email = EmployeeDataGenerator.generateEmail();
                    String department = EmployeeDataGenerator.generateDepartment();
                    double salary = EmployeeDataGenerator.generateRandomSalary();

                    preparedStatement.setString(1, firstName);
                    preparedStatement.setString(2, lastName);
                    preparedStatement.setString(3, email);
                    preparedStatement.setString(4, department);
                    preparedStatement.setDouble(5, salary);

                    preparedStatement.executeUpdate();

                    EmployeeDataGenerator.printEmployees(firstName, lastName, email, department, salary);
                }

        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void addEmployeesForSpecificDepartment(int numberOfEmployees, String department) {
        System.out.printf("%d EMPLOYEES FOR DEPARTMENT %s WILL BE ADDED TO DATABASE:%n", numberOfEmployees, department);
        System.out.println("--------------------");
        try(Connection connection = DatabaseManager.connectWithDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_TO_DATABASE))
        {
            for(int i = 0; i < numberOfEmployees; i++) {

                String firstName = EmployeeDataGenerator.generateFirstName();
                String lastName = EmployeeDataGenerator.generateLastName();
                String email = EmployeeDataGenerator.generateEmail();
                double salary = EmployeeDataGenerator.generateRandomSalary();

                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, department);
                preparedStatement.setDouble(5, salary);

                preparedStatement.executeUpdate();

                EmployeeDataGenerator.printEmployees(firstName, lastName, email, department, salary);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
