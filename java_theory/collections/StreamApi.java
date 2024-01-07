// package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(12,23,43,11,76,32);
        // nums.forEach(n -> {
        //     System.out.println(n);
        // });

        // Stream<Integer> s1 = nums.stream();
        // Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
        // Stream<Integer> s3 = s2.map(n -> n * 2);
        // Integer result = s3.reduce(0, (c,e) -> c+e);
        // System.out.println(result);

        int result = nums.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * 2)
        .reduce(0,(n,m) -> n+m);
        System.out.println(result);
    }
}
