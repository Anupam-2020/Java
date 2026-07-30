public class Calculation {
    final String name;
    private Calculation() {
        name = "Anupam";
    }

    public static Calculation getInstance() {
        return new Calculation();
    }
}
