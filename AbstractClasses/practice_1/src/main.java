package src;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        Company company = new Company();

        List<Employee> countWorkers = new ArrayList<>();
        for (int i = 0; i < 180; i++) {
            company.hire(new Operator());
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Manager());
        }
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager());
        }
        company.hireAll(countWorkers);

        System.out.println("Список из 15 самых высоких зарплат в компании");
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
        topSalaryStaff.forEach(employee -> System.out.println(employee.getClass().getName() + " " + employee.getMonthSalary()));
        System.out.println();
        System.out.println("Список из 30 самых низких зарплат в компании");
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(30);
        lowestSalaryStaff.forEach(employee -> System.out.println(employee.getClass().getName() + " " + employee.getMonthSalary()));
        System.out.println();

        System.out.println("Всего сотрудников " + company.getWorkers().size());

        int halfEmployees = company.getWorkers().size()/2;
        for (int i = 0; i < halfEmployees; i++) {
            company.fire(company.getWorkers().get(i));
        }

        System.out.println("Осталось сотрудников после увольнения " + company.getWorkers().size());

        System.out.println();
        System.out.println("Список из 15 самых высоких зарплат в компании");
        topSalaryStaff = company.getTopSalaryStaff(15);
        topSalaryStaff.forEach(employee -> System.out.println(employee.getClass().getName() + " " + employee.getMonthSalary()));
        System.out.println();
        System.out.println("Список из 30 самых низких зарплат в компании");
        lowestSalaryStaff = company.getLowestSalaryStaff(30);
        lowestSalaryStaff.forEach(employee -> System.out.println(employee.getClass().getName() + " " + employee.getMonthSalary()));
        System.out.println();
        System.out.println("Всего сотрудников " + company.getWorkers().size());

    }
}
