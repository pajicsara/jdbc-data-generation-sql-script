import helper.AddEmployees;
import helper.TestHelper;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.TestUtil.NUMBER_OF_EMPLOYEES_TO_ADD;
import static util.TestUtil.QA_DEPARTMENT;
public class AddEmployeesTest {

    @Test
    public void addRandomEmployees() throws SQLException {
        AddEmployees.addEmployeesToTable(NUMBER_OF_EMPLOYEES_TO_ADD);
        assertTrue(TestHelper.checkNumberOfEmployees(NUMBER_OF_EMPLOYEES_TO_ADD));
        AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, QA_DEPARTMENT);
        assertTrue(TestHelper.areEmployeesFromDepartmentPresent(QA_DEPARTMENT));
    }

}
