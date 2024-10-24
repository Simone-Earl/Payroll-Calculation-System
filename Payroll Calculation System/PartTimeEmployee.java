class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double salary, double hoursWorked) {
        super(name, salary, hoursWorked);
    }

    @Override
    public double calculateGrossPay() {
        return getSalary() * getHoursWorked(); // Salary is per hour
    }

    @Override
    public double calculateDeductions() {
        return getDeductions() + (calculateGrossPay() * 0.10); // 10% deductions
    }

    @Override
    public String getEmployeeType() {
        return "Part-Time";
    }
}