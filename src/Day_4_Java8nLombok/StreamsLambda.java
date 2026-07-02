package Day_4_Java8nLombok;

import java.util.*;
import java.util.stream.Collectors;

class Employee{
    private String name;
    private double salary;
    private String department;

    Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString(){
        return " {" + name + " | " + salary + " | " + department + "} ";
    }
}

public class StreamsLambda {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 75000, "IT"),
                new Employee("Bob", 82000, "Finance"),
                new Employee("Charlie", 65000, "IT"),
                new Employee("David", 90000, "Finance"),
                new Employee("Eve", 72000, "HR")
        );

        //Filter employees with salary > 70000 and collect to a new list
        List<Employee> highestEarners = employees.stream()
                .filter(e -> e.getSalary()>70000)
                .collect(Collectors.toList());
        System.out.println("Earners more than 70000: " +highestEarners);

        //Get a list of all unique departments using distinct()
        List<String> departments = employees.stream()
                        .map(e -> e.getDepartment())
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println("Departments: " +departments);
        
        //Find the average salary of all employees using Stream.average() 
        double avgSalary = employees.stream()
                .mapToDouble(e -> e.getSalary())
                .average()
                .orElse(0);
        System.out.println("Average Salary: " +avgSalary);

        //Group employees by department using Collectors.groupingBy()
        Map<String,List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Grouped by Department: " +byDept);

        //Find the highest paid employee using max() with a comparator
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Highest Paid: " +highestPaid.orElse(null));

        //Convert all employee names to uppercase using map()
        List<String> upperNames = employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Employee names in uppercase: " +upperNames);

        //Use Optional to safely handle the case where no employee is found
        Optional<Employee> notFound = employees.stream()
                .filter(e -> e.getDepartment().equals("Sales"))
                .findFirst();
        String result = notFound
                .map(Employee::getName)
                .orElse("No Employee found in sale.");
        System.out.println(result);

        //Rewrite all lambda expressions using method references where possible

        // Utilized both lambda expressions and method references throughout the program
        // to demonstrate different Stream API coding styles and enhance code clarity.



    }
}
