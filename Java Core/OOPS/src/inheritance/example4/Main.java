package inheritance.example4;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Sudheer", "1223");
        Employee developer = new Developer("Anupam", "1243");
        Employee seniorDeveloper = new SeniorDeveloper("Anand", "3321");
        employee.displayDetails();
        developer.displayDetails();
        seniorDeveloper.displayDetails();
        System.out.println(employee.calculateSalary());
        System.out.println(developer.calculateSalary());
        System.out.println(seniorDeveloper.calculateSalary());
    }
}
