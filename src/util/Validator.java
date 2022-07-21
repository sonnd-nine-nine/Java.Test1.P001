package util;

import model.Department;
import model.Employee;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static Validator instance;

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public boolean validateEmployeeId(String employeeId) {
        String regex = "^[EM]{2}[\\w]{5}$";
        return Pattern.compile(regex).matcher(employeeId).find();
    }

    public boolean validateDepartmentId(String departmentId) {
        String regex = "^[DE]{2}[\\w]{3}$";
        return Pattern.compile(regex).matcher(departmentId).find();
    }

    public boolean validateTitle(String titleEmployee){
        return Pattern.compile("^[Mr|Ms|Mrs]{2,3}$").matcher(titleEmployee).find();
    }

    public boolean validateDomain(String domain){
        return Pattern.compile("^[FIN|MAR|CRM|TOD|ADM|HRM|TCD]{3}$").matcher(domain).find();
    }

    public boolean validateDepartIdExist(String departmentId, List<Department> departments){
        for (Department d: departments){
            if (d.getId().equals(departmentId))
                return true;
        }
        return false;
    }

    public boolean validateEmployeeIdExist(String employeeId, List<Employee> employees){
        for (Employee e : employees){
            if (e.getId().equals(employeeId))
                return true;
        }
        return false;
    }
}