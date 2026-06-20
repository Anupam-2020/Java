import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is main");
        List<String> names = new ArrayList<>();
        names.add("Anupam");
        List<Integer> data = new ArrayList<>();
        data.add(23);

        List<String> data1 = new ArrayList<>();
        data1.addAll(names);
    }
}
