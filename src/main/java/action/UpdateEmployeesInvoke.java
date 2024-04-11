package action;

import helper.AddEmployees;

import static util.TestUtil.INCREASE_AMOUNT;
import static util.TestUtil.QA_DEPARTMENT;
import static util.TestUtil.NUMBER_OF_EMPLOYEES_TO_ADD;

public class UpdateEmployeesInvoke {
    public static void main(String[] args)  {
        AddEmployees.addEmployeesToTable(NUMBER_OF_EMPLOYEES_TO_ADD);
        helper.UpdateEmployees.raiseSalaries(INCREASE_AMOUNT);
        AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, QA_DEPARTMENT);
        helper.UpdateEmployees.raiseSalariesForSpecificDepartment(INCREASE_AMOUNT, QA_DEPARTMENT);
    }
}
