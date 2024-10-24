import java.io.Serializable;

public abstract class Employee implements Serializable, IPayroll {
    private String name;
    private double salary;
    private double hoursWorked;
    private double deductions;
    private double bonuses;

    public Employee(String name, double salary, double hoursWorked) {
        this.name = name;
        this.salary = salary;
        this.hoursWorked = hoursWorked;
        this.deductions = 0; // default deductions
        this.bonuses = 0; // default bonuses
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getBonuses() {
        return bonuses;
    }

    public void setBonuses(double bonuses) {
        this.bonuses = bonuses;
    }

    @Override
    public double calculateNetPay() {
        return calculateGrossPay() - calculateDeductions();
    }

    public abstract String getEmployeeType(); // Add an abstract method for employee type

    public String getEmployeeInfo() {
        return "Name: " + name + ", Salary: " + salary + ", Hours Worked: " + hoursWorked + 
               ", Bonuses: " + bonuses + ", Deductions: " + deductions;
    }
}