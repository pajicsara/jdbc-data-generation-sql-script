package helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseHelper {

    static void printResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String lastName = resultSet.getString("last_name");
            String firstName = resultSet.getString("first_name");
            String email = resultSet.getString("email");
            String department = resultSet.getString("department");
            double salary = resultSet.getDouble("salary");

            System.out.println("New employee added:");
            System.out.println("ID: " + id);
            System.out.println("First name: " + firstName);
            System.out.println("Last name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Department: " + department);
            System.out.println("Salary: " + String.format("%.2f", salary));
            System.out.println("--------------------");
        }
    }
}
