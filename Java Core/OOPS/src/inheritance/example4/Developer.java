package inheritance.example4;

public class Developer extends Employee {
    Developer(String name, String empId) {
        super(name, empId);
    }

    public String work() {
        return "Adds programming language";
    }

    @Override
    protected int calculateSalary() {
        return super.calculateSalary() + 30_000;
    }
}
