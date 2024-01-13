// package SealedClass;

// Sealed class is used for the scenario where we want to make our class inherited by only specific classes, not any class...
// Example -> class A should allow inheritance to class B and class C only...
// To achieve this parent class need to permit which classes will inherit. Child classes which is allowed to inherit should be either final, sealed or non-sealed... 

sealed class A extends Thread permits B,C { // the class B and C should be final/sealed or non-sealed...

}

non-sealed class B extends A { 

}

final class C extends A {

}

// class D extends A { // D is not allowed to inherit A

// }

// interfaces can also be sealed...
sealed interface Y permits X {

}

sealed interface X extends Y {

}

// sealed interface Z extends Y { // Z can't extend Y

// }

public class SealedDemo {
    public static void main(String[] args) {
        
    }
}
