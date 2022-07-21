package view;

import model.Department;
import services.ServiceDepartment;
import services.ServiceDepartmentImp;
import services.ServiceEmployee;

import java.awt.*;
import java.util.Scanner;

public class Test {
    static ServiceDepartment department = new ServiceDepartmentImp();
    static ServiceEmployee employee = new ServiceDepartmentImp();
    public static void main(String[] args) {
        int choose;
        do {
            choose = Menu();
            switch (choose){
                case 1:
                    System.out.println(department.createDepartment() ? "complete" : "Create fail!");
                    break;
                case 2:
                    System.out.println(employee.createEmployee() ? "complete" : "Create fail!");
                    break;
                case 3:
                    Department d = department.searchDepartmentByName();
                    if(d==null){
                        System.out.println("Department non exist!");
                    }else {
                        System.out.println(d.toString());
                    }
                    break;
                case 4:
                    department.addEmployeeToDepartment();
                    break;
                case 5:
                    System.out.println((department.removeEmployeeFromDepartmentById() ? "Removed!!" : "Employee non exist from Department"));
                    break;
                case 6:
                    department.displayByIdDepartment();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Must choose a func....");
                    break;
            }
        }while (choose!=0);
    }

    static int Menu(){
        System.out.println("___Department Managent___\n" +
                "1. Create Department.\n" +
                "2. Create Employee.\n" +
                "3. Search Department by name\n" +
                "4. Add employee to Department.\n" +
                "5. Remove Employee by id.\n" +
                "6. Display all Employee with Department ID\n" +
                "0. Finish ");
        return new Scanner(System.in).nextInt();
    }
}
