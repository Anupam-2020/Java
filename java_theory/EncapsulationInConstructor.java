class Human {
    private int age;
    private String name;

    public Human() {  // default constructor
        age = 23;
        name = "Anupam Anand";
    }

    public Human(int a, String name) {  // parameterised constructor
        age = a;
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class EncapsulationInConstructor {
    public static void main(String[] args) {
        Human obj = new Human();
        System.out.println(obj.getAge());
        obj.setAge(25);
        System.out.println(obj.getAge());
        Human obj2 = new Human(27, "Anupam");
        obj2.setName("Anurag");
        System.out.println(obj2.getName());
    }
}
