package Day_1_PayrollSys;

public class Designer extends Employee{
    private String designTool;
    private int designsCompleted;
    private String specialization;

    public Designer(String name, double salary, String dept,
                    String designTool, String specialization) {
        super(name, salary, dept);
        this.designTool = designTool;
        this.specialization = specialization;
        this.designsCompleted = 0;
        setEmployeeId(generateEmployeeId());
    }

    @Override
    public double calculateSalary() {
        double base = getBaseSalary();
        double creativityAllowance = base * 0.15;

        return base + creativityAllowance + getBonus();
    }

    @Override
    public double getBonus() {
        return designsCompleted*250;
    }

    @Override
    public String getRole() {
        return specialization + " Designer";
    }


    public void completeDesign() {
        this.designsCompleted++;
    }

    public void completeDesign(int count) {
        if (count > 0) {
            this.designsCompleted += count;
        }
    }

    public void completeDesign(String num) {
        try {
            int count = Integer.parseInt(num);

            if (count > 0) {
                this.designsCompleted += count;
            } else {
                System.out.println("Count must be positive");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number string.");
        }
    }


    public String generatePortfolioURL() {
        String fullName = getFullName().trim().toLowerCase();
        String[] parts = fullName.split("\\s+");

        String firstName = parts[0];
        String lastName = parts.length > 1 ? parts[parts.length - 1] : "";

        return "https://portfolio.techcorp.com/" + firstName + lastName;
    }


    public String createSignature() {
        String initials = getInitials();

        return "✎ " + initials + " | "
                + designTool + " | "
                + specialization;
    }



}
