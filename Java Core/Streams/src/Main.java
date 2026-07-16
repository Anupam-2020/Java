import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(3000);
        salaryList.add(4100);
        salaryList.add(9000);
        salaryList.add(3500);

        // without stream.
        int count =0;
        for(Integer salary: salaryList) {
            if(salary > 3000) count++;
        }

        System.out.println("Total Employee with salary > 3000: " + count);

        // with stream.
        long count2 = salaryList.stream().filter((Integer salary) -> salary > 3000).count();

        System.out.println("Total Employee with salary > 3000: " + count2);

        // Step: 1 -> Creating stream..................................................
        // 1. From Collection.
        List<Integer> salarysList = Arrays.asList(3000, 4000, 5000, 6000, 3200);
        Stream<Integer> streamFromIntegerList = salarysList.stream();

        // 2. From Array
        Integer[] salaryArray = {2000, 3000};
        Stream<Integer> streamFromIntegerArray = Arrays.stream(salaryArray);

        // 3. From Static Method:
        Stream<Integer> streamFromStaticMethod = Stream.of(1000, 3500, 4000, 9000);

        // 4. From Stream Builder
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(1000).add(3000).add(3200);

        Stream<Integer> streamFromStreamBuilder = streamBuilder.build();

        // 5. From Stream Iterate:
        Stream<Integer> streamFromIterate = Stream.iterate(1000, (Integer n) -> n + 5000).limit(5);



        // Step 2 -> Intermediate operations............................................
        // 1. Filter(Predicate<T> predicate)
        Stream<String> nameStream = Stream.of("HELLO", "EVERYBODY", "HOW", "ARE", "YOU", "DOING");
        Stream<String> filteredStream = nameStream.filter((String name) -> name.length() <= 3);
        List<String> filteredNameList = filteredStream.collect(Collectors.toList());
        System.out.println(filteredNameList); // output: [HOW, ARE, YOU]

        // 2. Map(Function<T, R> mapper)
        Stream<String> nameStream1 =  Stream.of("HELLO", "EVERYBODY", "HOW", "ARE", "YOU", "DOING");
        Stream<String> filteredStream1 = nameStream1.map((String name) -> name.toLowerCase());
        List<String> filteredNameList1 = filteredStream1.toList();
        System.out.println(filteredNameList1); // Output: [hello, everybody, how, are, you, doing]

        // 3. flattMap(Function<T, Stream<R>>mapper)
        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("I", "LOVE", "JAVA"),
                Arrays. asList("CONCEPTS", "ARE", "CLEAR"),
                Arrays. asList("ITS", "VERY", "EASY")
        );

        Stream<String> wordsStream1 = sentenceList.stream().flatMap((List<String> sentence) -> sentence.stream());
        System.out.println(wordsStream1.toList()); // [I, LOVE, JAVA, CONCEPTS, ARE, CLEAR, ITS, VERY, EASY]

        // 4. distinct()
        Integer[] arr = {1,2,3,4,4,6,7,0,2};

        Stream<Integer> arrStream = Arrays.stream(arr).distinct();
        System.out.println(arrStream.toList()); // output: - [1, 2, 3, 4, 6, 7, 0]

        // 5. sorted()
        Integer[] arr2 = {1,2,3,4,4,6,7,0,2};
        Stream<Integer> arrStream1 = Arrays.stream(arr2).sorted();
        System.out.println(arrStream1.toList()); // output: - [0, 1, 2, 2, 3, 4, 4, 6, 7]

        Stream<Integer> arrStream2 = Arrays.stream(arr2).sorted((val, val2) -> val2 - val);
        System.out.println(arrStream2.collect(Collectors.toList())); // output - [7, 6, 4, 4, 3, 2, 2, 1, 0]

        // Step 3 -> Terminal operation.............................................

        List<Integer> numbers = Arrays.asList(2,1,4,7,10);
        Stream<Integer> filteredNumbers = numbers.stream()
                .filter(val -> val >= 3);
//
        filteredNumbers.forEach(System.out::println);
        // Output: 4, 7, 10

        List<Integer> listFromStream = filteredNumbers.collect(Collectors.toList()); // error:- stream has already been operated upon or closed
    }
}