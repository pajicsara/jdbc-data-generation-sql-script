package action;

import helper.UpdateEmployees;

import java.sql.SQLException;

import static util.TestUtil.INCREASE_AMOUNT;
import static util.TestUtil.QA_DEPARTMENT;

public class UpdateData {
    public static void main(String[] args) throws SQLException {
        UpdateEmployees.raiseSalaries(INCREASE_AMOUNT);
        UpdateEmployees.raiseSalariesForSpecificDepartment(INCREASE_AMOUNT, QA_DEPARTMENT);
    }
}
