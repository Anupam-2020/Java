public class Basic {

    public static void printName(int N) {
        if(N == 0) {
            return;
        }
        System.out.println("Anupam "+ N);
        printName(N - 1);
    }

    public static void printNumbersFromLast(int i, int N) {
        if(i > N) {
            return;
        }

        printNumbersFromLast(i + 1, N);
        System.out.println(i);
    }

    public static void main(String[] args) {
        // printName(5);
        // printNumbersFromLast(1, 5);
    }
}