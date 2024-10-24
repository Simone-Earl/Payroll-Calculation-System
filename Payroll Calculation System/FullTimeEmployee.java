class FullTimeEmployee extends Employee {
    private double bonus;
    private double overtimeHours;

    public FullTimeEmployee(String name, double salary, double hoursWorked) {
        super(name, salary, hoursWorked);
    }

    @Override
    public double calculateGrossPay() {
        return getSalary() + getBonuses() + (getHoursWorked() > 160 ? 
                (getHoursWorked() - 160) * (getSalary() / 160) : 0); // Overtime calculation
    }

    @Override
    public double calculateDeductions() {
        return getDeductions() + (calculateGrossPay() * 0.15); // 15% deductions
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time";
    }
}