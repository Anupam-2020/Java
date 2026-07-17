class UpperBoundDemo<T extends Number> {
    T value;


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}


class MultiBoundDemo<T extends ParentClass & Interface1 & Interface2> { // Any object of this class will require to have similar type as the class generics(the class object should extend parentClass and implement Interfaces 1 and 2.)
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}


class ParentClass {

}

interface Interface1 {

}

interface Interface2 {

}

class A extends ParentClass implements Interface1, Interface2 {

}