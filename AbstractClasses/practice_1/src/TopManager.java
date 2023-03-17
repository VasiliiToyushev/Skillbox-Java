package src;

public class TopManager extends Company {
    @Override
    public double getMonthSalary() {
        double salaryTopManager;
        if (getCompanyIncome() >= 10_000_000)salaryTopManager = super.monthSalary + (super.monthSalary * 1.5);
        else salaryTopManager = super.monthSalary;
        return salaryTopManager;
    }
}
