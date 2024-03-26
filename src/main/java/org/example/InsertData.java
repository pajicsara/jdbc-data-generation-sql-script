package org.example;

import java.sql.*;
import java.util.Random;

import com.github.javafaker.Faker;

public class InsertData {

    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        PreparedStatement myStmntNew = null;
        ResultSet myRs = null;
        //Faker faker = new Faker(new Random());
        Random random = new Random();

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "student");


            for(int i=0; i<2; i++) {
                Faker faker = new Faker(new Random());
                String firstName = faker.name().firstName();
                String lastname = faker.name().lastName();
                String email = faker.internet().emailAddress();
                String department = faker.company().industry();
                double salary = 1000 + (random.nextDouble() * (5000 - 1000));
                // 2. Prepare statement
                myStmntNew = myConn.prepareStatement("INSERT INTO `demo`.`employees` (`last_name`, `first_name`, `email`, `department`, `salary`) VALUES (?, ?, ?, ?, ?)");

                // 3. Set the parameters
                myStmntNew.setString(1, firstName);
                myStmntNew.setString(2, lastname);
                myStmntNew.setString(3, email);
                myStmntNew.setString(4, department);
                myStmntNew.setDouble(5, salary); // Trebate koristiti setDouble za postavljanje decimalnih vrijednosti

                // 4. Execute SQL query
                myStmntNew.executeUpdate();

                System.out.println("Data inserted successfully!");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmntNew != null) {
                myStmntNew.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
}
