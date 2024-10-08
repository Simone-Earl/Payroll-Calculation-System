import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PayrollCalculator {
    private List<Employee> employees;
    private static final Logger logger = Logger.getLogger(PayrollCalculator.class.getName());

    public PayrollCalculator() {
        this.employees = new ArrayList<>();
    }

    // Create: Add a new employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
        logger.info("Employee " + employee.getName() + " added.");
    }

    // Read: Retrieve information about a particular employee by name
    public Optional<Employee> getEmployee(String name) {
        return employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Update: Modify the attributes of an existing employee
    public void updateEmployee(String name, int hoursWorked, double bonus) {
        Optional<Employee> optionalEmployee = getEmployee(name);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setHoursWorked(hoursWorked);
            employee.setBonus(bonus);
            logger.info("Updated " + employee.getName() + "'s details.");
        } else {
            logger.warning("Employee not found: " + name);
        }
    }

    // Delete: Remove an employee by name
    public void deleteEmployee(String name) {
        Optional<Employee> optionalEmployee = getEmployee(name);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employees.remove(employee);
            logger.info("Employee " + name + " removed.");
        } else {
            logger.warning("Employee not found: " + name);
        }
    }

    // Method to calculate payroll for all employees
    public void calculatePayroll() {
        for (Employee employee : employees) {
            try {
                logger.info("Calculating payroll for " + employee.getName());
                System.out.println("Employee: " + employee.getName());
                System.out.println("Gross Pay: " + employee.calculateGrossPay());
                System.out.println("Deductions: " + employee.calculateDeductions());
                System.out.println("Net Pay: " + employee.calculateNetPay());
                System.out.println();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error calculating payroll for " + employee.getName(), e);
            }
        }
    }

    // Filter employees by salary
    public List<Employee> filterBySalary(double minSalary) {
        return employees.stream()
                .filter(employee -> employee.calculateGrossPay() > minSalary)
                .collect(Collectors.toList());
    }
}
