import java.util.List;
import java.util.Objects;

public class WildCardGenerics_7 {
    // wild card method(upper bound)
    public void setValuesUpperBound(List<? extends Vehicle> vehicles ) {

    }

    // wild card method(lower bound)
    public void setValuesLowerBound(List<? super Vehicle> vehicles) {

    }

    // generic type method.
    public <T extends Number> void computeListGenericType(List<T> source, List<T> destination) {

    }

    /*
    generic vs wildCard -
    1. In Generic type method, we can use the same type in both source and destination list, but in wild card method, we can use different types in source and destination list.
    2. In Generic type method, we can use multiple bounds, but in wild card method, we can only use single bound.
    3. In Wild Card method, we can use lower bound and upper bound, but in generic type method, we can only use upper bound.
    */


    // wild card method(unbound) // we can use any type in source and destination list.
    public void computeListWildCard(List<?> source, List<?> destination) {
        Object ob = source.get(0); // we can only get the object from the list, but we can't add any object to the list.
    }
}

class Vehicle {

}


class Truck extends Vehicle {

}

class Car extends Vehicle {

}