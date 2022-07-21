package model;

import util.Validator;

import java.io.Serializable;
import java.util.Scanner;

public class Department implements Serializable {
    private String id;
    private String name;
    private String domain;

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        while (!Validator.getInstance().validateDepartmentId(id)){
            System.out.println("Format id Department(5 char, 'DExxx'): ");
            id = new Scanner(System.in).nextLine();
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        while (!Validator.getInstance().validateDomain(domain)){
            System.out.println("Domain FIN|MAR|CRM|TOD|ADM|HRM|TCD : ");
            domain = new Scanner(System.in).nextLine();
        }
        this.domain = domain;
    }

    public Department(String id, String name, String domain) {
        this.id = id;
        this.name = name;
        this.domain = domain;
    }

    public Department() {
    }
}
