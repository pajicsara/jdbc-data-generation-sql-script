import helper.TestHelper;
import helper.UpdateEmployees;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static util.TestUtil.INCREASE_AMOUNT;
import static util.TestUtil.MINIMUM_SALARY;
import static util.TestUtil.QA_DEPARTMENT;

public class UpdateEmployeesTest {

    @Test
    public void raiseSalaries() throws SQLException {
        UpdateEmployees.raiseSalaries(INCREASE_AMOUNT);
        assertFalse(TestHelper.areEmployeesWithSalaryBelowPresent(INCREASE_AMOUNT + MINIMUM_SALARY));
    }

    @Test
    public void raiseSalriesForSpecificDepartment() throws SQLException {
        UpdateEmployees.raiseSalariesForSpecificDepartment(2 * INCREASE_AMOUNT, QA_DEPARTMENT);
        assertFalse(TestHelper.areEmployeesWithSalaryBelowPresent(3 * INCREASE_AMOUNT + MINIMUM_SALARY));
    }

}
