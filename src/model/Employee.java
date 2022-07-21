package model;

import util.Validator;

import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable {
    private String id;
    private String title;
    private String fullName;
    private String workingDomain;
    private String positions;
    private Double monthlySalary;
    private String departmentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        while (!Validator.getInstance().validateEmployeeId(id)){
            System.out.println("Format id Employee (7 char, 'EMxxxxx'): ");
            id = new Scanner(System.in).nextLine();
        }
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        while (!Validator.getInstance().validateTitle(title)){
            System.out.println("Title Ms, Mrs or Mr: ");
            title = new Scanner(System.in).nextLine();
        }
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWorkingDomain() {
        return workingDomain;
    }

    public void setWorkingDomain(String workingDomain) {
        this.workingDomain = workingDomain;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Employee(String id, String title, String fullName, String workingDomain, String positions, Double monthlySalary, String departmentId) {
        this.id = id;
        this.title = title;
        this.fullName = fullName;
        this.workingDomain = workingDomain;
        this.positions = positions;
        this.monthlySalary = monthlySalary;
        this.departmentId = departmentId;
    }

    /**
     * construct non Id department.
     * @param id
     * @param title
     * @param fullName
     * @param positions
     * @param monthlySalary
     */
    public Employee(String id, String title, String fullName, String positions, Double monthlySalary) {
        this.id = id;
        this.title = title;
        this.fullName = fullName;
        this.positions = positions;
        this.monthlySalary = monthlySalary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", fullName='" + fullName + '\'' +
                ", workingDomain='" + workingDomain + '\'' +
                ", positions='" + positions + '\'' +
                ", monthlySalary=" + monthlySalary +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
