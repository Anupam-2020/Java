import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class MemoryManagement {
    public static void main(String[] args) {
        int primitiveVariable = 10;
        Person personObj = new Person(); // strong reference: Object will not be eligible for garbage collection as long as this reference exists.
        WeakReference<Person> weak = new WeakReference<>(new Person()); // weak reference: Object will be eligible for garbage collection if there are no strong references to it.
        SoftReference<Person> soft = new SoftReference<>(new Person()); // soft reference: Object will be eligible for garbage collection if the JVM is running low on memory, but it will not be collected by (GC) as aggressively as weak references.
        String stringLiteral = "24";
        MemoryManagement memObj = new MemoryManagement();
        memObj.memoryManagementTest(personObj);

        System.gc(); // Garbage Collection(GC) is called to demonstrate the behavior of weak and soft references. The garbage collector will reclaim memory from weakly reachable objects, but it may not reclaim memory from softly reachable objects unless the JVM is low on memory.
        Person val = soft.get();
        System.out.println(val); // SoftReference will return the object if it has not been collected yet, otherwise it will return null.
        Person val2 = weak.get();
        System.out.println(val2); // WeakReference will return the object if it has not been collected yet, otherwise it will return null.
        Person val3 = personObj;
        System.out.println(val3); // Strong reference will always return the object as long as the reference exists.
    }

    private void memoryManagementTest(Person personObj) {
        Person personObj2 = personObj;
        String stringLiteral2 = "24";
        String stringLiteral3 = new String("24");
    }
}
