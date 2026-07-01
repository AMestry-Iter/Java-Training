package Day_3_OOPSnCollectionsContinue;

public class Student {
    private String name;
    private  int id;
    private double gpa;
    private String department;

    public Student(String name, int id, double gpa, String department) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString(){
        return "ID: " +id+ ",Name: " +name+ ",GPA: " +gpa+ ",Department: " +department;
    }
}
