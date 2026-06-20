package Interface_7;


// Note:=> In Java, every class directly or indirectly extends Object class.
// Common methods from Object -> toString(), equals(), hasCode(), getClass(), clone(), finalize().

public class ObjectClass extends Object {
    String name;

    ObjectClass(String name) {
        this.name = name;
    }

    @Override // overriding from Object class...
    public String toString() {
        return name;
    }
}
