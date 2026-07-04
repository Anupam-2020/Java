package DependencyInversion.better;

public interface Database {
    void save();
}

class MySQLDatabase implements Database {

    @Override
    public void save() {
        System.out.println("Saving to MySQL");
    }
}


class MongoDB implements Database {

    @Override
    public void save() {
        System.out.println("Saving to MongoDB");
    }
}