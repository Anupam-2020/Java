//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop(
                "i7",
                16,
                512,
                "RTX4060"
        );

        Laptop laptop1 = new Laptop.Builder()
                .cpu("i7")
                .ram(16)
                .storage(512)
                .ram(23) // It overrides 16.
                .build();

        System.out.println(laptop1);
    }
}