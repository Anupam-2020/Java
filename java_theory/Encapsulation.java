class Human {
    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public void setAge(int age) {
        this.age = age;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Human obj = new Human();
        // obj.age = 23; // private variables can't be accessed outside of that function........
        int age = 24;
        String name = "Anupam";
        obj.setAge(age);
        obj.setName(name);
        System.out.println("Name"+" "+obj.getName());
        System.out.println("Age"+" "+obj.getAge());
    }
    
}
