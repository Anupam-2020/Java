package InterfaceSegregation.bad;

// Do not force a class to implement methods it does not need.

interface Worker {
    void work();
    void eat();
}

class HumanWorker implements Worker {
    public void work() {
        System.out.println("Human working");
    }

    public void eat() {
        System.out.println("Human eating");
    }
}

class RobotWorker implements Worker {
    public void work() {
        System.out.println("Robot working");
    }

    public void eat() {
        throw new RuntimeException("Robot does not eat");
    }
}