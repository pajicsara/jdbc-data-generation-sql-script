import helper.AddEmployees;
import helper.DeleteEmployees;
import helper.TestHelper;
import helper.UpdateEmployees;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.TestUtil.*;

public class WorkflowTestSuite {

    @BeforeAll()
    public static void beforeAll() {
        DeleteEmployees.deleteAllEmployeesFromDB();
    }

    @Test
    public void testCompleteWorkflow() throws SQLException {
        AddEmployees.addEmployeesToTable(NUMBER_OF_EMPLOYEES_TO_ADD);
        assertTrue(TestHelper.checkNumberOfEmployees(NUMBER_OF_EMPLOYEES_TO_ADD));
        AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, QA_DEPARTMENT);
        assertTrue(TestHelper.areEmployeesFromDepartmentPresent(QA_DEPARTMENT));
        AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, IT_DEPARTMENT);
        assertTrue(TestHelper.areEmployeesFromDepartmentPresent(IT_DEPARTMENT));
        AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, HR_DEPARTMENT);
        assertTrue(TestHelper.areEmployeesFromDepartmentPresent(HR_DEPARTMENT));
        UpdateEmployees.raiseSalaries(INCREASE_AMOUNT);
        assertFalse(TestHelper.areEmployeesWithSalaryBelowPresent(INCREASE_AMOUNT + MINIMUM_SALARY));
        UpdateEmployees.raiseSalariesForSpecificDepartment(INCREASE_AMOUNT, QA_DEPARTMENT);
        assertFalse(TestHelper.isEmployeeWithSalaryBelowInDepartment(2 * INCREASE_AMOUNT + MINIMUM_SALARY, QA_DEPARTMENT));
        DeleteEmployees.deleteAllEmployeesFromDepartment(HR_DEPARTMENT);
        assertFalse(TestHelper.areEmployeesFromDepartmentPresent(HR_DEPARTMENT));
        DeleteEmployees.deleteAllEmployeesFromDB();
        assertTrue(TestHelper.checkNumberOfEmployees(ZERO_EMPLOYEES));
    }

}
