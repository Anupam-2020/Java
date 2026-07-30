public class GenericMethod_5 {
    public <K, V> void printValue(MoreThanOneGenericClass_4<K, V> pair1, MoreThanOneGenericClass_4<K, V> pair2) { // generic method.
        if(pair2.getKey().equals(pair1.getKey())) {
            // do something
        }
    }

    public <T> void setValue(T busObject) { // Generic method.
        // Do something
    }
}

class Bus {

}
