package encapsulation;

public class Employee {
    private final int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {

        if(id <= 0) throw new IllegalArgumentException("ID must be > 0");
        this.id = id;


        this.name = name;
        this.salary = salary;
    }

    private void validateName() {

    }
}
