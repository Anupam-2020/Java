package non_primitive;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        List<Integer> list = List.of(23, 24);
        person.setEmpId(list);
        System.out.println(person.getEmpId());


        String s1 = "hello";
        String s2 = "hello";

        System.out.println(s1 == s2); // checks the memory location where these references s1 and s2 are pointing.
        System.out.println(s1.equals(s2)); // checks content of the variable s1 and s2.

        int[] arr = new int[3];
        int[] arr2 = {1,2,34,5};
        int[][] arr3 = {{1,3}, {3,4}};
        int[][] arr4 = new int[3][4];

        int a = 10;
        Integer a1 = a; // autoboxing.
        Integer a2 = a;

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d); // false.

        Integer e = 100;
        Integer f = 100;
        System.out.println(e == f); // true -> Java caches Integer objects for values -128 to 127 (Integer.valueOf() reuses instances from this cache). Outside that range, autoboxing creates brand-new objects, so == compares references and fails.

        int x1 = a1; // unboxing.
    }
}
