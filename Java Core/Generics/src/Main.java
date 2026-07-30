import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GenericClass_1<Integer> printObj1 = new GenericClass_1<>(); // M-1 of creating a generic object
        printObj1.setValue(1);
        Integer printValue = printObj1.getValue();

        if(printValue == 1) { // We can't use printValue directly, we've to typecast it, else it'll give compile time error.

        }

        GenericClass_1 rawTypeObject = new GenericClass_1(); // M-2 => Internally, it passes Object as parametrized type.
        rawTypeObject.setValue(1);
        rawTypeObject.setValue("Hello");

        NonGenericSubClass_3 colorPrintObj = new NonGenericSubClass_3();
        colorPrintObj.setValue("2");

        GenericSubClass_2<String> genericSubClassObj = new GenericSubClass_2<>();
        genericSubClassObj.setValue("4");

        MoreThanOneGenericClass_4<String, Integer> pairObj = new MoreThanOneGenericClass_4<>("hello", 0);
        pairObj.put("hello", 1234);

        GenericMethod_5 obj = new GenericMethod_5();
        obj.setValue("Name"); // we can provide any value in generic type.
        obj.setValue(new Truck()); // even objects can be passed in generic type...

        A obj1 = new A();
        MultiBoundDemo<A> printObj = new MultiBoundDemo<>();

        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new Car());
        vehicleList.add(new Truck());

        List<Truck> truckList = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

//        vehicleList = truckList; // not valid.

        WildCardGenerics_7 wildCardGenerics7 = new WildCardGenerics_7();
        wildCardGenerics7.setValuesUpperBound(truckList);
        wildCardGenerics7.setValuesLowerBound(objects);
    }
}