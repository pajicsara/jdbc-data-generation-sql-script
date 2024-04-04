package action;

import helper.GetEmployees;
import static util.TestUtil.MINIMUM_SALARY;

public class SelectData {

    public static void main(String[] args) {
        GetEmployees.selectUserWithSalaryHigher(MINIMUM_SALARY);
    }
}
