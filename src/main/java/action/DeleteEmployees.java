package action;

import static util.TestUtil.HR_DEPARTMENT;

public class DeleteEmployees {

    public static void main(String[] args) {
        //DELETE ALL EMPLOYEES WITH SALARY BELLOW X
        //DeleteEmployees.deleteEmployeesWithSalaryBelow(LOW_SALARY_BOUND);

        //DELETE ALL EMPLOYEES FROM DATABASE
        //DeleteEmployees.deleteAllEmployeesFromDB();

        //DELETE ALL EMPLOYEES FROM SPECIFIC DEPARTMENTS
        helper.DeleteEmployees.deleteAllEmployeesFromDepartment(HR_DEPARTMENT);
    }
}


