public class Main {
    public static void main(String[] args) {
        PayrollCalculator payrollCalculator = new PayrollCalculator();

        // Create employees
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("John Doe", 50000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Jane Doe", 20000);
        ContractualEmployee contractualEmployee = new ContractualEmployee("Bob Smith", 30000);

        // Add employees
        payrollCalculator.addEmployee(fullTimeEmployee);
        payrollCalculator.addEmployee(partTimeEmployee);
        payrollCalculator.addEmployee(contractualEmployee);

        // Update employee details
        payrollCalculator.updateEmployee("John Doe", 45, 1000); // Update hoursWorked and bonus for John
        payrollCalculator.updateEmployee("Jane Doe", 30, 500);  // Update hoursWorked and bonus for Jane

        // Calculate payroll for all employees
        payrollCalculator.calculatePayroll();

        // Read employee details
        payrollCalculator.getEmployee("John Doe").ifPresentOrElse(
            employee -> System.out.println("Retrieved Employee: " + employee.getName()),
            () -> System.out.println("Employee not found")
        );

        // Delete an employee
        payrollCalculator.deleteEmployee("Bob Smith");

        // Calculate payroll again to verify Bob was removed
        payrollCalculator.calculatePayroll();

        // Testing filtering employees with salary over 30000
        System.out.println("Employees with salary over 30000:");
        payrollCalculator.filterBySalary(30000).forEach(e -> System.out.println(e.getName()));
    }
}
