import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,23,4,2,7,10,1);
        Stream<Integer> numberStream = numbers.stream()
                .filter(val -> val >= 3)
                .peek(val -> System.out.println("after filtering: " + val))
                .map(val -> val * -1)
                .peek(val -> System.out.println("after negating: " + val))
                .sorted()
                .peek(val -> System.out.println("after sorting" + val));

        List<Integer> filteredNumberStream = numberStream.collect(Collectors.toList()); // Output:
//        after filtering: 23
//        after negating: -23
//        after filtering: 4
//        after negating: -4
//        after filtering: 7
//        after negating: -7
//        after filtering: 10
//        after negating: -10
//        after sorting-23
//        after sorting-10
//        after sorting-7
//        after sorting-4
    }
}
