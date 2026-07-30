package LiskovSubstitutionPrinciple.better;

interface Bird {
    void eat();
}

interface FlyingBird {
    void fly();
}

class Sparrow implements Bird, FlyingBird {
    public void eat() {
        System.out.println("Sparrow eating");
    }

    public void fly() {
        System.out.println("Sparrow flying");
    }
}

class Ostrich implements Bird {
    public void eat() {
        System.out.println("Ostrich eating");
    }
}
