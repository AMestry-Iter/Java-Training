package Day_1_PayrollSys;

public class Developer extends Employee{
    private String programmingLanguage;
    private int projectsCompleted;
    private String skillLevel;

    public Developer(
            String name, double salary, String dept,
            String programmingLanguage, String skillLevel) {
        super(name, salary, dept);
        this.programmingLanguage = programmingLanguage;
        this.skillLevel = skillLevel;
        this.projectsCompleted = 0;
        setEmployeeId(generateEmployeeId());
    }

    @Override
    public double calculateSalary() {
        double base = getBaseSalary();
        double skillAllowance = 0;

        if (skillLevel.toLowerCase().equals("senior")) {
            skillAllowance = base * 0.25;
        } else if (skillLevel.toLowerCase().equals("mid")) {
            skillAllowance = base * 0.15;
        } else if (skillLevel.toLowerCase().equals("junior")) {
            skillAllowance = base * 0.05;
        } else {
            skillAllowance = 0;
        }

        return base + skillAllowance + getBonus();
    }

    @Override
    public double getBonus() {
        return projectsCompleted*300;
    }

    @Override
    public String getRole() {
        return skillLevel + " Developer";
    }

    public void completeProject(){
        this.projectsCompleted++;
    }

    public void completeProject(int count){
        if (count > 0) {
            this.projectsCompleted += count;
        }
    }


    public String generateEmail() {
        String fullName = getFullName().trim().toLowerCase();
        String[] parts = fullName.split("\\s+");

        String firstInitial = String.valueOf(parts[0].charAt(0));
        String lastName = parts.length > 1 ? parts[parts.length - 1] : "";

        return firstInitial + "." + lastName + "@techcorp.com";
    }


}
