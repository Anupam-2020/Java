package DependencyInversion.better;

public class UserService {
    private final Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public void saveUser() {
        database.save();
    }
}
