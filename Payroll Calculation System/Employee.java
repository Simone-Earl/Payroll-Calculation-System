public abstract class Employee {
    String name;
    private double salary;
    private int hoursWorked;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hoursWorked = 0; // Default to 0 for Contractual employees
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public abstract double calculateGrossPay();

    public abstract double calculateDeductions();

    public abstract double calculateNetPay();

    public void showEmployeeDetails() {
        System.out.println("Employee Name: " + getName());
        System.out.println("Salary: " + getSalary());
        System.out.println("Hours Worked: " + getHoursWorked());
    }

    // New method to retrieve basic information
    public String getEmployeeInfo() {
        return "Name: " + getName() + "\nSalary: " + getSalary() + "\nHours Worked: " + getHoursWorked();
    }
}