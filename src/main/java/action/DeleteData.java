package action;

import helper.DeleteEmployees;

import static util.TestUtil.HR_DEPARTMENT;
import static util.TestUtil.MINIMUM_SALARY;

public class DeleteData {

    public static void main(String[] args) {
        //DELETE ALL EMPLOYEES WITH SALARY BELLOW X
        //DeleteEmployees.deleteEmployeesWithSalaryBelow(MINIMUM_SALARY);
        //DELETE ALL EMPLOYEES FROM DATABASE
        //DeleteEmployees.deleteAllEmployeesFromDB();
        DeleteEmployees.deleteAllEmployeesFromDepartment(HR_DEPARTMENT);
    }
}


