public class FullTimeEmployee extends Employee {
    private static final double TAX_RATE = 0.20;
    private static final double BENEFITS = 500.00;

    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateGrossPay() {
        return getSalary();
    }

    @Override
    public double calculateDeductions() {
        return getSalary() * TAX_RATE + BENEFITS;
    }

    @Override
    public double calculateNetPay() {
        return calculateGrossPay() - calculateDeductions();
    }

    @Override
    public void showEmployeeDetails() {
        super.showEmployeeDetails();
        System.out.println("Employee Status: Full-Time");
        System.out.println("Gross Pay: " + calculateGrossPay());
        System.out.println("Deductions: " + calculateDeductions());
        System.out.println("Net Pay: " + calculateNetPay());
    }
}