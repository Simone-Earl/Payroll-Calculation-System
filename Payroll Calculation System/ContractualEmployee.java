public class ContractualEmployee extends Employee {
    public ContractualEmployee(String name, double salary, double hoursWorked) {
        super(name, salary, hoursWorked);
    }

    @Override
    public double calculateGrossPay() {
        return getSalary(); // Fixed salary for contractual employees
    }

    @Override
    public double calculateDeductions() {
        return getDeductions(); // No deductions for contractual employees
    }

    @Override
    public String getEmployeeType() {
        return "Contractual";
    }
}
