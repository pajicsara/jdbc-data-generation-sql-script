package action;

import helper.AddEmployees;

import static util.TestUtil.NUMBER_OF_EMPLOYEES_TO_ADD;
import static util.TestUtil.IT_DEPARTMENT;
import static util.TestUtil.QA_DEPARTMENT;
import static util.TestUtil.HR_DEPARTMENT;

public class InsertData {
    //dodaj isppisa za svakog radnika kog dodajes
    public static void main(String[] args) {
        //ADD 10 EMPLOYEES FOR RANDOM DEPARTMENTS
        AddEmployees.addEmployeesToTable(NUMBER_OF_EMPLOYEES_TO_ADD);
        //ADD 10 EMPLOYEES FOR IT DEPARTMENT
        //AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, IT_DEPARTMENT);
        //ADD 10 EMPLOYEES FOR QA DEPARTMENT
        //AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, QA_DEPARTMENT);
        //ADD 10 EMPLOYEES FOR HR DEPARTMENT
        AddEmployees.addEmployeesForSpecificDepartment(NUMBER_OF_EMPLOYEES_TO_ADD, HR_DEPARTMENT);
    }
}
