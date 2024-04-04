package helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseHelper {

    private static final Logger logger = Logger.getLogger(DatabaseHelper.class.getName());

    static void printResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String lastName = resultSet.getString("last_name");
            String firstName = resultSet.getString("first_name");
            String email = resultSet.getString("email");
            String department = resultSet.getString("department");
            double salary = resultSet.getDouble("salary");

            logger.info(String.format("**** ID: %d last name: %s first name: %s email: %s department: %s salary: %.2f ***",
                    id, lastName, firstName, email, department, salary));
        }
    }
}
