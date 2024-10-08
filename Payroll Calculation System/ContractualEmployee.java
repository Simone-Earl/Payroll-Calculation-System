public class ContractualEmployee extends Employee {
    public ContractualEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateGrossPay() {
        return getSalary() + getBonus();
    }

    @Override
    public double calculateDeductions() {
        return 0; // No deductions for contractual employees
    }

    @Override
    public double calculateNetPay() {
        return calculateGrossPay();
    }
}
