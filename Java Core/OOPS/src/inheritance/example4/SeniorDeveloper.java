package inheritance.example4;

public class SeniorDeveloper extends Developer {
    SeniorDeveloper(String name, String empId) {
        super(name, empId);
    }

    @Override
    protected int calculateSalary() {
        return super.calculateSalary() + 20_000;
    }

    @Override
    public String work() {
        return "Adds bonus";
    }
}
