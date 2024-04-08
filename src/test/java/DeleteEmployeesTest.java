import helper.AddEmployees;
import helper.DeleteEmployees;
import helper.TestHelper;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.TestUtil.*;

public class DeleteEmployeesTest {

    @Test
    public void deleteAllEmployee() throws SQLException {
        AddEmployees.addEmployeesToTable(NUMBER_OF_EMPLOYEES_TO_ADD);
        assertTrue(TestHelper.checkNumberOfEmployees(NUMBER_OF_EMPLOYEES_TO_ADD));
        DeleteEmployees.deleteAllEmployeesFromDB();
        assertFalse(TestHelper.checkNumberOfEmployees(NUMBER_OF_EMPLOYEES_TO_ADD));
    }

    @Test
    public void deleteEmployeesWithSalaryBelow() throws SQLException {
        AddEmployees.addEmployeesToTable(NUMBER_OF_EMPLOYEES_TO_ADD);
        assertTrue(TestHelper.checkNumberOfEmployees(NUMBER_OF_EMPLOYEES_TO_ADD));
        DeleteEmployees.deleteEmployeesWithSalaryBelow(1000);
        assertFalse(TestHelper.areEmployeesWithSalaryBelowPresent(1000));
    }

    @Test
    public void deleteEmployeesFromDepartment() {
        AddEmployees.addEmployeesForSpecificDepartment(10, HR_DEPARTMENT);
        AddEmployees.addEmployeesForSpecificDepartment(15, IT_DEPARTMENT);
        AddEmployees.addEmployeesForSpecificDepartment(20, QA_DEPARTMENT);
        DeleteEmployees.deleteAllEmployeesFromDepartment(HR_DEPARTMENT);
        assertFalse(TestHelper.areEmployeesFromDepartmentPresent(HR_DEPARTMENT));
    }

}
