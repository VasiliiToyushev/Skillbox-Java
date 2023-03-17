package src;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Company implements Employee{

    double companyIncome = 10_000_000;
    double monthSalary = 50_000;
    List<Employee> workers = new ArrayList<>();


    public void hire(Employee employee) {
        workers.add(employee);
    }

    public void hireAll(Collection<Employee> employes) {
        workers.addAll(employes);
    }

    public void fire(Employee employee) {
        workers.remove(employee);
    }


    public List<Employee> getTopSalaryStaff(int count) {
        workers.sort(Comparator.comparing(Employee::getMonthSalary).reversed());
        return IntStream.range(0, count).mapToObj(i -> workers.get(i)).collect(Collectors.toList());
    }

    List<Employee> getLowestSalaryStaff(int count) {
        workers.sort(Comparator.comparing(Employee::getMonthSalary));
        return IntStream.range(0, count).mapToObj(i -> workers.get(i)).collect(Collectors.toList());
    }

    public List<Employee> getWorkers() {
        return workers;
    }

    public double getCompanyIncome() {
        return companyIncome;
    }

    @Override
    public double getMonthSalary() {
        return 0;
    }
}
