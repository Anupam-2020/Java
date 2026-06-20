import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// Lambda, Lambda Inference, Stream

public class Streams {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Kiwi", "Mango");

        Map<String, Integer> fruitsList = fruits.stream()
//                .map(fruit -> fruit.length())
//                .collect(Collectors.toSet());
//                .collect(Collectors.toList());
        .collect(Collectors.toMap(
                key -> key,
                value -> value.length()
        ));

        System.out.println(fruitsList);

//        Stream<String> stream = fruits.stream();
//        Stream<String> stream = fruits.parallelStream();
//
////        stream.sorted().forEach(System.out::println);
//
////        stream.forEach(System.out::println);
//        stream
//                .filter(fruit -> fruit.length() < 6)
//                .sorted()
//                .map(fruit -> fruit.length())
//                .map(fruitLength -> 2 * fruitLength)
//                .forEach(fruit -> System.out.println(fruit));
    }
}
