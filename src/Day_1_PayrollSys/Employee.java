package Day_1_PayrollSys;

import java.util.Random;

public abstract class Employee {
    private String employeeId;
    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private double baseSalary;
    private String department;

    //Constructor
    Employee(String fullName, double baseSalary, String department){
        this.fullName = formatName(fullName);
        this.baseSalary = baseSalary;
        this.department = department;
        
        parseName();
        //this.employeeId = generateEmployeeId();
    }

    protected void setEmployeeId(String id) {
        this.employeeId = id;
    }

    //EmpIdGenerate
    protected String generateEmployeeId() {
        Random random = new Random();
        int number = 1000+ random.nextInt(9000);
        String roleCode = getRole().substring(0,3).toUpperCase();
        return roleCode+"_"+getInitials()+"_"+number;
    }


    //getInitials
    public String getInitials(){
        StringBuilder sb = new StringBuilder();

        if(!firstName.isEmpty()){
            sb.append(firstName.charAt(0));
        }
        if(!lastName.isEmpty()){
            sb.append(lastName.charAt(0));
        }

        return sb.toString().toUpperCase();
    }

    //parseName
    private void parseName() {
        String[] parts = fullName.split("\\s+");
        if(parts.length==1){
            firstName = parts[0];
            middleName = "";
            lastName = "";
        }else if(parts.length==2){
            firstName = parts[0];
            middleName = "";
            lastName = parts[1];
        }else{
            firstName = parts[0];
            middleName = parts[1];;
            lastName = parts[2];
        }
    }

    //formatName
    private String formatName(String name) {
        String[] words = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(String word : words){
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }

    //paySlip
    public String generatePayslip() {
        StringBuilder slip = new StringBuilder();

        slip.append("===== PAYSLIP =====\n");
        slip.append("Employee ID : ").append(employeeId).append("\n");
        slip.append("Name        : ").append(formatName(fullName)).append("\n");
        slip.append("Department  : ").append(department).append("\n");
        slip.append("Role        : ").append(getRole()).append("\n");
        slip.append("Base Salary : ").append(baseSalary).append("\n");
        slip.append("Bonus       : ").append(getBonus()).append("\n");
        slip.append("Total Salary: ").append(calculateSalary()).append("\n");
        slip.append("===================\n");

        return slip.toString();
    }


    //abstract methods
    public abstract double calculateSalary();
    public abstract double getBonus();
    public abstract String getRole();


    //getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }
        this.fullName = fullName;
    }

    public double getBaseSalary() {

        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
        this.baseSalary = baseSalary;
    }

    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

}
