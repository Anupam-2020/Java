package collections;

import java.util.Arrays;

public class Comparator_vs_comparable {
    public static void main(String[] args) {
        // Primitive collection sorting
        int[] arr = new int[10];
        Arrays.sort(arr); // this works because int is a primitive type and it implements Comparable interface.

        // Object collection sorting
        Car[] cars = new Car[3];
        cars[0] = new Car("SUV", "petrol");
        cars[1] = new Car("Sedan", "diesel");
        cars[2] = new Car("Hatchback", "CNG");

        Arrays.sort(cars, (Car obj1, Car obj2) -> obj2.carName.compareTo(obj1.carName)); // sorting in descending order based on carName using lambda expression. here we are using Comparator interface to sort the cars in descending order based on carName.

        for(Car car: cars) {
            System.out.println(car.carName);
        }

//        Arrays.sort(cars); // error -> if Car class doesn't implement Comparable interface. So we need to implement Comparable interface in Car class and override compareTo method.
    }
}

// Below is the Car class which implements Comparable interface and overrides compareTo method to sort the cars in descending order based on carName.
class Car /* implements Comparator<Car> */  implements Comparable<Car>  { // Comparator vs Comparable: Comparator is used to sort the objects of a class based on different attributes and Comparable is used to sort the objects of a class based on a single attribute.
    String carName;
    String carType;

    Car(String name, String type) {
        this.carName = name;
        carType = type;
    }

//    @Override
//    public int compare(Car o1, Car o2) {
//        o1.carName.compareTo(o2.carName);
//        return o1.carType.compareTo(o2.carType);
//    }

    @Override
    public int compareTo(Car o) {
        return o.carName.compareTo(this.carName); // here this refers to the current object and o refers to the object passed as parameter. So we are comparing the carName of the current object with the carName of the object passed as parameter. If we want to sort in ascending order then we can use this.carName.compareTo(o.carName).
    }
}
