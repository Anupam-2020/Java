package Encapsulation_3;

public class User_Enc {
    private String password; // Can be accessed only in this class.
    public String username; // can be accessed anywhere.
    protected String email; // can be used in subclass(extended class) outside this package.
    int age; // can be accessed in same package classes only. Can't be used in even extended(subclass) which are outside this package.

    void getName() {
        password = "";
        System.out.println(this.password);
    }
}
