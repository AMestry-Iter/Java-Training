package Day_1_PayrollSys;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PayrollSystem system = new PayrollSystem("RandomOrg");

        Manager manager = new Manager("John Smith", 50000, "IT", 5);
        manager.setProjectBonus(3000);

        Developer developer = new Developer("Alice Brown", 40000, "Tech", "Java", "Senior");
        developer.completeProject(4);

        Designer designer = new Designer("Mark Lee", 35000, "Design", "Figma", "UI/UX");
        designer.completeDesign(3);
        designer.completeDesign("4");

        system.addEmployee(manager);
        system.addEmployee(developer);
        system.addEmployee(designer);

        //Encapsulation
        System.out.println(manager.getFullName());
        manager.setProjectBonus("4000");

        //Inheritance
        Employee e1 = manager;
        Employee e2 = developer;
        Employee e3 = designer;

        System.out.println(e1.getRole());
        System.out.println(e2.getRole());
        System.out.println(e3.getRole());

        //PolyMorphism
        System.out.println(manager.calculateSalary());
        System.out.println(developer.calculateSalary());
        System.out.println(designer.calculateSalary());

        designer.completeDesign("2");
        developer.completeProject(2);

        //Abstraction
        for (Employee emp : new Employee[]{manager, developer, designer}) {
            System.out.println(emp.getRole());
            System.out.println(emp.getBonus());
        }

        //String Manipulation
        System.out.println("Manager ID: " + manager.getEmployeeId());
        System.out.println("Developer Email: " + developer.generateEmail());
        System.out.println("Designer Portfolio: " + designer.generatePortfolioURL());
        System.out.println("Designer Signature: " + designer.createSignature());

        //Overview
        system.displayAllEmployees();

        List<Employee> searchName = system.searchByName("John");
        for (Employee emp : searchName) {
            System.out.println(emp.generatePayslip());
        }

        List<Employee> searchRole = system.searchByRole("Developer");
        for (Employee emp : searchRole) {
            System.out.println(emp.generatePayslip());
        }

        System.out.println(system.calculateTotalPayroll());
        system.generateSummaryReport();


    }
}
