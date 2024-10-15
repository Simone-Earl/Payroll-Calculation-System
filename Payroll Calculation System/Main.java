import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollCalculator payrollCalculator = new PayrollCalculator();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nPayroll Calculation System");
            System.out.println("1. Add Employee");
            System.out.println("2. Calculate Payroll");
            System.out.println("3. Filter Employees by Type");
            System.out.println("4. Retrieve Employee Information");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addEmployee(scanner, payrollCalculator);
                case 2 -> payrollCalculator.calculatePayroll();
                case 3 -> filterEmployeesByType(scanner, payrollCalculator);
                case 4 -> retrieveEmployeeInformation(scanner, payrollCalculator);
                case 5 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addEmployee(Scanner scanner, PayrollCalculator payrollCalculator) {
        System.out.println("Select Employee Type:");
        System.out.println("1. Full-Time");
        System.out.println("2. Part-Time");
        System.out.println("3. Contractual");
        System.out.print("Enter your choice: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine().trim();

        double salary = getValidDoubleInput(scanner, "Enter employee salary: ");
        int hoursWorked = 0;
        if (typeChoice != 3) {
            hoursWorked = getValidIntInput(scanner, "Enter hours worked: ");
        }

        Employee employee = switch (typeChoice) {
            case 1 -> new FullTimeEmployee(name, salary);
            case 2 -> new PartTimeEmployee(name, salary);
            case 3 -> new ContractualEmployee(name, salary);
            default -> {
                System.out.println("Invalid employee type. Employee not added.");
                yield null;
            }
        };

        if (employee != null) {
            employee.setHoursWorked(hoursWorked); // Set hours worked
            payrollCalculator.addEmployee(employee);
            System.out.println("Employee added successfully.");
        }
    }

    private static double getValidDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Input must be non-negative.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static int getValidIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Input must be non-negative.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static void filterEmployeesByType(Scanner scanner, PayrollCalculator payrollCalculator) {
        System.out.println("Select Employee Type to Filter:");
        System.out.println("1. Full-Time");
        System.out.println("2. Part-Time");
        System.out.println("3. Contractual");
        System.out.print("Enter your choice: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String type = switch (typeChoice) {
            case 1 -> "FullTimeEmployee";
            case 2 -> "PartTimeEmployee";
            case 3 -> "ContractualEmployee";
            default -> {
                System.out.println("Invalid type.");
                yield null;
            }
        };

        if (type != null) {
            System.out.println("Employees of type: " + type);
            payrollCalculator.filterByType(type).forEach(e -> System.out.println(e.getName()));
        }
    }

    // New method to retrieve employee information
    private static void retrieveEmployeeInformation(Scanner scanner, PayrollCalculator payrollCalculator) {
        System.out.print("Enter the employee name: ");
        String name = scanner.nextLine().trim();

        payrollCalculator.getEmployeeByName(name)
            .ifPresentOrElse(
                employee -> System.out.println(employee.getEmployeeInfo()),
                () -> System.out.println("Employee not found.")
            );
    }
}