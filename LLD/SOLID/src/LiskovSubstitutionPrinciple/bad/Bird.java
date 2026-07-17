package LiskovSubstitutionPrinciple.bad;

// Child classes should be usable wherever parent classes are expected.
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Ostrich extends Bird {
    public void fly() {
        throw new RuntimeException("Ostrich cannot fly");
    }
}
