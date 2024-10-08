public abstract class Employee {
    private String name;
    private double salary;
    private int hoursWorked;
    private double overtime;
    private double bonus;

    public Employee(String name, double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary must be non-negative.");
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateGrossPay();
    public abstract double calculateDeductions();
    public abstract double calculateNetPay();

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
        if (hoursWorked < 0) throw new IllegalArgumentException("Hours worked must be non-negative.");
        this.hoursWorked = hoursWorked;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        if (overtime < 0) throw new IllegalArgumentException("Overtime must be non-negative.");
        this.overtime = overtime;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus < 0) throw new IllegalArgumentException("Bonus must be non-negative.");
        this.bonus = bonus;
    }

    // Common logic for calculating overtime pay
    protected double calculateOvertimePay() {
        return (getHoursWorked() > 40 ? (getHoursWorked() - 40) * (getSalary() / 40) * 1.5 : 0);
    }
}
