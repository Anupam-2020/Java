package DependencyInversion.bad;

//High-level classes should not directly depend on low-level classes. Both should depend on abstraction.
// Problem: UserService is tightly coupled with MySQLDatabase.

public class MySQLDatabase {
    public void save() {
        System.out.println("Saving data to MySQL database");
    }
}


class UserService {
    private final MySQLDatabase database = new MySQLDatabase();
    public void saveUser() {
        database.save();
    }
}