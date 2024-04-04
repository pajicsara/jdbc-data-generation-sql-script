package util;

public class SqlQueries {

    public static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM demo.employees";
    public static final String DELETE_FIRST_TWO_EMPLOYEES = "DELETE FROM demo.employees WHERE id IN (SELECT TOP(2) id FROM demo.employees ORDER BY salary)";
    public static final String DELETE_ALL_EMPLOYEES = "DELETE FROM demo.employees";
    public static final String ADD_EMPLOYEE_TO_DATABASE = "INSERT INTO `demo`.`employees` (`last_name`, `first_name`, `email`, `department`, `salary`) VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE_LOW_SALARY_EMPLOYEES = "DELETE FROM `demo`.`employees` WHERE salary < ?";
}
