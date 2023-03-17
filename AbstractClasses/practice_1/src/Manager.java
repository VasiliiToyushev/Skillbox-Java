package src;

public class Manager extends Company {
    int incomeManager = (int) (115_000 + (Math.random() * 25_000));
    @Override
    public double getMonthSalary() {
        return super.monthSalary + (incomeManager * 0.05);
    }
}
