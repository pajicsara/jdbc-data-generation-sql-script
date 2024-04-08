package helper;

import java.sql.*;

import static util.SqlQueries.ADD_EMPLOYEE_TO_DATABASE;

public class AddEmployees {

    //Generate one common method for those two methods, so if department is sent as a parameter add that department, and if not add random department?
    public static void addEmployeesToTable(double numberOfEmployees) {
        System.out.println(numberOfEmployees + " employees for department will be added to a database.");
        System.out.println("--------------------");
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

                    System.out.println("New employee added:");
                    System.out.println("First name: " + firstName);
                    System.out.println("Last name: " + lastname);
                    System.out.println("Email: " + email);
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + String.format("%.2f", salary));
                    System.out.println("--------------------");
                }

        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void addEmployeesForSpecificDepartment(int numberOfEmployees, String department) {
        System.out.println(numberOfEmployees + " employees for department " + department + " will be added to a database.");
        System.out.println("--------------------");
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
                preparedStatement.setString(4, department);
                preparedStatement.setDouble(5, salary);

                preparedStatement.executeUpdate();

                //vidi da li ovo izdvojiti u posebnu metodu
                System.out.println("New employee added:");
                System.out.println("First name: " + firstName);
                System.out.println("Last name: " + lastname);
                System.out.println("Email: " + email);
                System.out.println("Department: " + department);
                System.out.println("Salary: " + String.format("%.2f", salary));
                System.out.println("--------------------");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
