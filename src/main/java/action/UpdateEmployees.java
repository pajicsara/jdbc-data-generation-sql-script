package action;

import java.sql.SQLException;

import static util.TestUtil.INCREASE_AMOUNT;
import static util.TestUtil.QA_DEPARTMENT;

public class UpdateEmployees {
    public static void main(String[] args) throws SQLException {
        helper.UpdateEmployees.raiseSalaries(INCREASE_AMOUNT);
        helper.UpdateEmployees.raiseSalariesForSpecificDepartment(INCREASE_AMOUNT, QA_DEPARTMENT);
    }
}