package services;

import model.Department;

public interface ServiceDepartment {
    boolean createDepartment();
    Department searchDepartmentByName();
    boolean addEmployeeToDepartment();
    boolean removeEmployeeFromDepartmentById();
    void displayByIdDepartment();
}
