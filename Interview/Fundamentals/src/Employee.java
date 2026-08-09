public class Employee implements Cloneable, Comparable<Employee> {
    String name;
    Address address;
    Integer id;
    Integer age;

    Employee() {

    }

    Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

//    @Override
//    public Employee clone() throws CloneNotSupportedException {
//        Employee copy = (Employee) super.clone();
//        copy.address = new Address(this.address.city);
//
//        return copy;
//    }

    public Employee(Employee other) {
        this.id = other.id;
        this.age = other.age;
        this.address = other.address;
//        this.address = (other.address != null) ? new Address(other.address.city) : null;
        this.name = other.name;
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return "Employee: " + id.toString() + "," + name + "," + address + "," + age;
    }
}


class Address {
    String city;

    Address(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address" + ":" + city;
    }
}