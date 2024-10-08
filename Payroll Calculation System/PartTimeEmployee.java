public class PartTimeEmployee extends Employee {
    private static final double TAX_RATE = 0.15;

    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateGrossPay() {
        return getSalary() + calculateOvertimePay() + getBonus();
    }

    @Override
    public double calculateDeductions() {
        return calculateGrossPay() * TAX_RATE;
    }

    @Override
    public double calculateNetPay() {
        return calculateGrossPay() - calculateDeductions();
    }
}
