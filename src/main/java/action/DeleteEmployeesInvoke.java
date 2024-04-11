package action;

import helper.DeleteEmployees;

import static util.TestUtil.LOW_SALARY_BOUND;
import static util.TestUtil.QA_DEPARTMENT;

public class DeleteEmployeesInvoke {

    public static void main(String[] args) {
        //DELETE ALL EMPLOYEES WITH SALARY BELLOW X
        //DeleteEmployees.deleteEmployeesWithSalaryBelow(LOW_SALARY_BOUND);

        //DELETE ALL EMPLOYEES FROM DATABASE
        //DeleteEmployees.deleteAllEmployeesFromDB();

        //DELETE ALL EMPLOYEES FROM SPECIFIC DEPARTMENTS
        DeleteEmployees.deleteAllEmployeesFromDepartment(QA_DEPARTMENT);
    }
}


