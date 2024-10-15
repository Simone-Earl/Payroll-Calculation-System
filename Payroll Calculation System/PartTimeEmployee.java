public class PartTimeEmployee extends Employee {
    private static final double TAX_RATE = 0.10;

    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateGrossPay() {
        return getSalary();
    }

    @Override
    public double calculateDeductions() {
        return getSalary() * TAX_RATE;
    }

    @Override
    public double calculateNetPay() {
        return calculateGrossPay() - calculateDeductions();
    }

    @Override
    public void showEmployeeDetails() {
        super.showEmployeeDetails();
        System.out.println("Employee Status: Part-Time");
        System.out.println("Gross Pay: " + calculateGrossPay());
        System.out.println("Deductions: " + calculateDeductions());
        System.out.println("Net Pay: " + calculateNetPay());
    }
}