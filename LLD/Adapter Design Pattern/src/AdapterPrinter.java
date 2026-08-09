public class AdapterPrinter implements Printer {

    private LegacyPrinter legacyPrinter;

    public AdapterPrinter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}
