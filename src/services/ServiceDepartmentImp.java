package services;

import model.Department;
import model.Employee;
import util.Validator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceDepartmentImp implements ServiceDepartment, ServiceEmployee{

    private static List<Department> departments = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    @Override
    public boolean createDepartment() {
        Department d = new Department();
        System.out.println("__Create Department");
        System.out.print("Id: ");
        String id = scanner.nextLine();
        d.setId(id);
        while (Validator.getInstance().validateDepartIdExist(id, departments)){
            System.out.print("Id Department exist, again: ");
            id = scanner.nextLine();
            d.setId(id);
        }
        System.out.print("Name: ");
        String name = scanner.nextLine();
        d.setName(name);
        System.out.print("Domain: ");
        String domain = scanner.nextLine();
        d.setDomain(domain);
        departments.add(d);
        writeToFileDepart();
        return true;
    }

    @Override
    public Department searchDepartmentByName() {
        System.out.println("Search Department by Name");
        System.out.print("Name: ");
        String id = scanner.nextLine();
        for (Department d: departments){
            if(d.getId().equals(id)){
                return d;
            }
        }
        return null;
    }

    @Override
    /**
     * If Employee.departmentID == null, set departmentId = departmentId.id
     * first: select Department by ID
     * then: find Employee.departmentID == null
     * final: set Employee.departmentId= department.id
     */
    public boolean addEmployeeToDepartment() {
        Department d = searchDepartmentByName();
        for (Employee e: employees){
            if(e.getDepartmentId()==null){
                e.setDepartmentId(d.getId());
                e.setWorkingDomain(d.getDomain());
            }
        }
        return true;
    }

    @Override
    /**
     * find Department by name.
     * find employee from department by ID
     * remove its from department , set employee.departmentId=null.
     */
    public boolean removeEmployeeFromDepartmentById() {
        Department d = searchDepartmentByName();
        System.out.print("Enter Id employee: ");
        String employeeId = scanner.nextLine();
        for (Employee e: employees){
            if(d.getId().equals(e.getDepartmentId()) && e.getId().equals(employeeId)){
                e.setWorkingDomain(null);
                e.setDepartmentId(null);
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayByIdDepartment() {
        System.out.println("Enter Id Department: ");
        String id = scanner.nextLine();
        for (Employee e: employees){
            if(e.getDepartmentId().equals(id)){
                System.out.println(e.toString());
            }
        }
    }

    @Override
    /**
     * create Employee with full attribute...(have Id department).
     */
    public boolean createEmployee() {
        System.out.println("Add Employee...");
        Employee e = new Employee();
        System.out.print("Id: ");
        String id = scanner.nextLine();
        e.setId(id);
        while (Validator.getInstance().validateEmployeeIdExist(id, employees)){
            System.out.print("Id Employee exist, again: ");
            id = scanner.nextLine();
            e.setId(id);
        }
        System.out.print("Title: ");
        String title = scanner.nextLine();
        e.setTitle(title);
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        Double salary = scanner.nextDouble();
        System.out.print("DepartmentId: ");
        String departId = scanner.nextLine();
        e.setDepartmentId(departId);
        while (!Validator.getInstance().validateDepartIdExist(departId, departments)){
            System.out.println("Department Id non exist, again..");
            departId = scanner.nextLine();
            e.setDepartmentId(departId);
        }
        String workingDomain = null;
        for (Department d: departments){
            if(d.getId().equals(departId)){
                workingDomain = d.getDomain();
            }
        }
        employees.add(new Employee(id, title, fullName,workingDomain, position, salary, departId));
        writeToFileEmployee();
        return true;
    }

    public static void readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("department.dat");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

        departments.addAll((List<Department>) objectInputStream.readObject());
        fileInputStream.close();
    }

    public static void writeToFileDepart() {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("department.dat");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            objectOutputStream.writeObject(departments);
            bufferedOutputStream.flush();
            objectOutputStream.flush();
            fileOutputStream.flush();
//            System.out.println("complete! ");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFileEmployee() {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("employee.dat");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            objectOutputStream.writeObject(employees);
            bufferedOutputStream.flush();
            objectOutputStream.flush();
            fileOutputStream.flush();
//            System.out.println("complete! ");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
