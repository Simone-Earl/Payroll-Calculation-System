public class FullTimeEmployee extends Employee {
    private static final double TAX_RATE = 0.25;
    private static final double BENEFITS_RATE = 0.10;

    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateGrossPay() {
        return getSalary() + calculateOvertimePay() + getBonus();
    }

    @Override
    public double calculateDeductions() {
        return calculateGrossPay() * (TAX_RATE + BENEFITS_RATE);
    }

    @Override
    public double calculateNetPay() {
        return calculateGrossPay() - calculateDeductions();
    }
}
