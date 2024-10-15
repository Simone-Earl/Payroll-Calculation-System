import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PayrollCalculator {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void calculatePayroll() {
        employees.forEach(Employee::showEmployeeDetails); // Calls showEmployeeDetails polymorphically
    }

    public List<Employee> filterByType(String type) {
        return employees.stream()
            .filter(employee -> employee.getClass().getSimpleName().equals(type))
            .collect(Collectors.toList());
    }

    // New method to retrieve employee by name
    public Optional<Employee> getEmployeeByName(String name) {
        return employees.stream()
            .filter(employee -> employee.getName().equalsIgnoreCase(name))
            .findFirst();
    }
}