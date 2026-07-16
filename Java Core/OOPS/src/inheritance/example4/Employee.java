package inheritance.example4;

public class Employee {
     protected String name;
     protected String empId;

     Employee(String name, String empId) {
         this.name = name;
         this.empId = empId;
     }

     protected int calculateSalary() {
         return 25_000;
     }

     public void displayDetails() {
         System.out.println("name -> "+ name);
         System.out.println("Emp Id -> "+empId);
     }
}
