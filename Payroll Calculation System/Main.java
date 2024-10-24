import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Prepopulate with some employees for demonstration
        employees.add(new FullTimeEmployee("Alice", 50000, 170));
        employees.add(new PartTimeEmployee("Bob", 20, 30));
        employees.add(new ContractualEmployee("Charlie", 30000, 40));

        while (running) {
            System.out.println("\nPayroll System Menu:");
            System.out.println("1. Calculate Employee Payroll");
            System.out.println("2. Update Employee Salary, Bonuses, or Deductions");
            System.out.println("3. Check Current Employee Status");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    calculatePayroll(scanner);
                    break;
                case 2:
                    updateEmployeeDetails(scanner);
                    break;
                case 3:
                    checkEmployeeStatus(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void calculatePayroll(Scanner scanner) {
        System.out.println("Select Employee Type:");
        System.out.println("1. Full Time");
        System.out.println("2. Part Time");
        System.out.println("3. Contractual");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Employee> selectedEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if ((typeChoice == 1 && employee instanceof FullTimeEmployee) ||
                (typeChoice == 2 && employee instanceof PartTimeEmployee) ||
                (typeChoice == 3 && employee instanceof ContractualEmployee)) {
                selectedEmployees.add(employee);
            }
        }

        if (selectedEmployees.isEmpty()) {
            System.out.println("No employees found for the selected type.");
            return;
        }

        System.out.println("Select an Employee:");
        for (int i = 0; i < selectedEmployees.size(); i++) {
            System.out.println((i + 1) + ". " + selectedEmployees.get(i).getName());
        }

        int employeeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (employeeChoice < 1 || employeeChoice > selectedEmployees.size()) {
            System.out.println("Invalid employee selection.");
            return;
        }

        Employee employee = selectedEmployees.get(employeeChoice - 1);
        System.out.println("\nPayroll Information for " + employee.getName() + ":");
        System.out.println("Gross Pay: " + employee.calculateGrossPay());
        System.out.println("Deductions: " + employee.calculateDeductions());
        System.out.println("Net Pay: " + employee.calculateNetPay());
    }

    private static void updateEmployeeDetails(Scanner scanner) {
        System.out.println("Select an Employee to Update:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getName());
        }

        int employeeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (employeeChoice < 1 || employeeChoice > employees.size()) {
            System.out.println("Invalid employee selection.");
            return;
        }

        Employee employee = employees.get(employeeChoice - 1);
        System.out.print("Enter New Salary for " + employee.getName() + " (current: " + employee.getSalary() + "): ");
        double newSalary = scanner.nextDouble();
        employee.setSalary(newSalary);

        System.out.print("Enter New Bonuses for " + employee.getName() + " (current: " + employee.getBonuses() + "): ");
        double newBonuses = scanner.nextDouble();
        employee.setBonuses(newBonuses);

        System.out.print("Enter New Deductions for " + employee.getName() + " (current: " + employee.getDeductions() + "): ");
        double newDeductions = scanner.nextDouble();
        employee.setDeductions(newDeductions);

        System.out.println("Updated Employee Information:");
        System.out.println(employee.getEmployeeInfo());
    }

    private static void checkEmployeeStatus(Scanner scanner) {
        System.out.println("Select an Employee to Check Status:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getName());
        }

        int employeeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (employeeChoice < 1 || employeeChoice > employees.size()) {
            System.out.println("Invalid employee selection.");
            return;
        }

        Employee employee = employees.get(employeeChoice - 1);
        System.out.println("Current Status for " + employee.getName() + ":");
        System.out.println(employee.getEmployeeInfo());
    }
}
