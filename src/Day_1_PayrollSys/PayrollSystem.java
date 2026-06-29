package Day_1_PayrollSys;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PayrollSystem {

    private List<Employee> employees;
    private String companyName;


    public PayrollSystem(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<>();
    }


    public void addEmployee(Employee emp) {
        if (emp != null) {
            employees.add(emp);
        }
    }

    public void removeEmployee(String id) {
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getEmployeeId().equalsIgnoreCase(id)) {
                iterator.remove();
            }
        }
    }

    public List<Employee> searchByName(String name) {
        List<Employee> result = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(emp);
            }
        }
        return result;
    }


    public List<Employee> searchByRole(String role) {
        List<Employee> result = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getRole().toLowerCase().contains(role.toLowerCase())) {
                result.add(emp);
            }
        }
        return result;
    }


    public double calculateTotalPayroll() {
        double total = 0;

        for (Employee emp : employees) {
            total += emp.calculateSalary();
        }

        return total;
    }


    public void displayAllEmployees() {
        System.out.println("=== " + companyName + " Employee List ===");

        for (Employee emp : employees) {
            System.out.println("----------------------------");
            System.out.println("ID   : " + emp.getEmployeeId());
            System.out.println("Name : " + emp.getFullName());
            System.out.println("Role : " + emp.getRole());
            System.out.println("Salary: " + emp.calculateSalary());

        }
        System.out.println("----------------------------");
    }


    public void generateSummaryReport() {
        int managerCount = 0;
        int developerCount = 0;
        int designerCount = 0;

        double managerTotal = 0;
        double developerTotal = 0;
        double designerTotal = 0;

        for (Employee emp : employees) {
            String role = emp.getRole().toLowerCase();

            if (role.contains("manager")) {
                managerCount++;
                managerTotal += emp.calculateSalary();

            } else if (role.contains("developer")) {
                developerCount++;
                developerTotal += emp.calculateSalary();

            } else if (role.contains("designer")) {
                designerCount++;
                designerTotal += emp.calculateSalary();
            }
        }

        System.out.println("\n=== SUMMARY REPORT ===");
        System.out.println("Managers  : " + managerCount + " | Total Salary: " + managerTotal);
        System.out.println("Developers: " + developerCount + " | Total Salary: " + developerTotal);
        System.out.println("Designers : " + designerCount + " | Total Salary: " + designerTotal);

        System.out.println("Overall Payroll: " + calculateTotalPayroll());
    }

}
