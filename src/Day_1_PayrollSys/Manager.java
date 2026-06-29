package Day_1_PayrollSys;

public class Manager extends Employee{
    private int teamSize;
    private double projectBonus;

    public Manager(String name, double salary, String dept, int teamSize){
        super(name,salary,dept);
        this.teamSize = teamSize;
        this.projectBonus = 0;
        setEmployeeId(generateEmployeeId());
    }

    @Override
    public double calculateSalary() {
        double base = getBaseSalary();
        double baseBonus = base * 0.20;

        return base + baseBonus + projectBonus + getBonus();

    }

    @Override
    public double getBonus() {
        return teamSize*500;
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    public void setProjectBonus(double bonus) {
        if(bonus<0) throw new IllegalArgumentException("Invalid Bonus");
        this.projectBonus = bonus;
    }

    public void setProjectBonus(String bonus) {

        try {
            this.projectBonus = Double.parseDouble(bonus);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid bonus string");
        }

    }
}
