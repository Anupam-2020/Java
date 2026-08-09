package collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class DepartmentComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getDepartment().compareTo(o2.getDepartment());
    }
}

class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}

//class NameComparator implements Comparator<Employee> {
//
//    @Override
//    public int compare(Employee o1, Employee o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
//}

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "John", "IT", 80000));
        employees.add(new Employee(2, "Alice", "HR", 90000));
        employees.add(new Employee(3, "Bob", "IT", 70000));
        employees.add(new Employee(4, "David", "IT", 70000));
        employees.add(new Employee(5, "Sarah", "HR", 80000));
        employees.add(new Employee(6, "Mike", "Finance", 75000));

        // Department ASC
        // Salary DESC
        // Name ASC
        Comparator<Employee> comparator =
                new DepartmentComparator()
                        .thenComparing(new SalaryComparator())
                        .thenComparing(Employee::getName).reversed();

        employees.sort(comparator);

        employees.stream()
                .map(employee -> {
                    System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary() + " " + employee.getDepartment());
                    return employee;
                }).toList();
    }
}
