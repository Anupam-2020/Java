public class Lecture2 {
    public static int parameterised_way_of_printing_sum_of_natural_numbers(int i, int sum) {
        if(i == 0) {
            return sum;
        }

        return parameterised_way_of_printing_sum_of_natural_numbers(i - 1, sum + i);
    }

    public static int functional_way_of_printing_sum_of_natural_numbers(int N) {
        if(N == 0) {
            return 0;
        }

        return N + functional_way_of_printing_sum_of_natural_numbers(N - 1);
    }

    public static int factorialOfANumber(int i) {
        if(i == 1) {
            return 1;
        }

        return i * factorialOfANumber(i - 1);
    }

    public static void main(String[] args) {
        // System.out.println(parameterised_way_of_printing_sum_of_natural_numbers(5, 0));
        // System.out.println(functional_way_of_printing_sum_of_natural_numbers(5));
        System.out.println(factorialOfANumber(5));
    }
}
