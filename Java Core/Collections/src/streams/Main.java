package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Given a list of integers, filter the even numbers.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> even = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(even);

        // Find the maximum number from a list of integers.
        List<Integer> numbers2 = Arrays.asList(10, 20, 30, 40, 50);
       Integer maximun = numbers2.stream()
                .max((num1, num2) -> Integer.compare(num1, num2)).orElseThrow();
        System.out.println(maximun);

        // Sort a list of integers in descending order.
        List<Integer> numbers3 = Arrays.asList(3, 5, 1, 4, 2);
        List<Integer> desc = numbers3.stream()
                .sorted(Comparator.reverseOrder()).toList();
        System.out.println(desc);

        // Count strings starting with a specific prefix, e.g., "A".
        List<String> names = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .toList();

        System.out.println(filteredNames);

        // Convert all strings in a list to uppercase.
        List<String> names2 = Arrays.asList("java", "stream", "api");
        List<String> upper = names2.stream()
                .map(name -> name.toUpperCase())
                .toList();

        System.out.println(upper);

        //  Calculate the sum of all numbers in a list.
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = numbers4.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        // Find the longest string in a list.
        List<String> words = Arrays.asList("Java", "Stream", "API", "Development");
        String longest = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .orElse(null);
        System.out.println(longest);

        // Count the frequency of each character in a string.
        String input = "success";
        Map<Character, Long> frequency = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(frequency);

        // Concatenate all strings in a list into a single string.
        List<String> strings = Arrays.asList("Hello", "World", "!");
        String concatenated = strings.stream()
                .reduce("", (s1, s2) -> s1 + " " + s2);
        System.out.println(concatenated);

        // Group a list of strings based on their length.
        List<String> words2 = Arrays.asList("Java", "Stream", "API", "Development");
//        Map<List<String>,Integer> groupedByLength = words2.stream()
//                .collect(Collectors.groupingBy(word -> List.of(word), Collectors.summingInt((word) -> word.length())));

        Map<Integer, List<String>> groupedByLength = words2.stream()
                .collect(Collectors.groupingBy(word -> word.length(), Collectors.toList()));
        System.out.println(groupedByLength);
    }
}
