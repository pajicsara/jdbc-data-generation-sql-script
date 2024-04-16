package action;

import static util.TestUtil.NUMBER_OF_EMPLOYEES_TO_ADD;
import static util.TestUtil.IT_DEPARTMENT;
import static util.TestUtil.QA_DEPARTMENT;
import static util.TestUtil.HR_DEPARTMENT;

public class AddEmployeesInvoke {

    public static void main(String[] args) {
        //ADD 10 EMPLOYEES FOR RANDOM DEPARTMENTS
        helper.AddEmployees.addEmployeesToTable(NUMBER_OF_EMPLOYEES_TO_ADD);
        //ADD 10 EMPLOYEES FOR IT DEPARTMENT
        helper.AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, IT_DEPARTMENT);
        //ADD 10 EMPLOYEES FOR QA DEPARTMENT
        helper.AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, QA_DEPARTMENT);
        //ADD 10 EMPLOYEES FOR HR DEPARTMENT
        helper.AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, HR_DEPARTMENT);
    }
}
