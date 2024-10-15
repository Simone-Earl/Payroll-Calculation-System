public class ContractualEmployee extends Employee {

    public ContractualEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateGrossPay() {
        return getSalary();
    }

    @Override
    public double calculateDeductions() {
        return 0.0; // No deductions for contractual employees
    }

    @Override
    public double calculateNetPay() {
        return calculateGrossPay(); // No deductions
    }

    @Override
    public void showEmployeeDetails() {
        super.showEmployeeDetails();
        System.out.println("Employee Status: Contractual");
        System.out.println("Gross Pay: " + calculateGrossPay());
        System.out.println("Deductions: " + calculateDeductions());
        System.out.println("Net Pay: " + calculateNetPay());
    }
}