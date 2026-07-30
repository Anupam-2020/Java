public class GenericClass_1<T> { // T can be replaced with any non-primitive object.
//    Object value; // Since all classes in java extend Object class, Object's object can be considered for generic, but we'll need to typecast to any non-primitive object at the place where we're using this object.
    T value; // replacing Object with T. With T we don't need to typecast everywhere. We can set the type during object creation only.

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
