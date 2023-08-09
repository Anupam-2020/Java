public class Lecture5 {

    public static int fibonacciAtNthIndex(int index) {
        if(index <= 1) {
            return index;
        }
        return fibonacciAtNthIndex(index - 1) + fibonacciAtNthIndex(index - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciAtNthIndex(6));
    }
}
