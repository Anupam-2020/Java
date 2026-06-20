package Interface_7;

public class StaticFinalInstance {
    final int data = 10; // final instance variable can't be updated again. Needs to be initialized at the time declaration.

    final int getDat() { // final function can't be inherited.
        return data;
    }
}
