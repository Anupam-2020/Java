public class Recursion1 {

    public static void printNumbers(int initial) {

        if (initial == 0) { // base condition
            return;
        }

        System.out.println(initial); // print in sequence
        printNumbers(initial - 1);
        System.out.println(initial); // print in reverse sequence
    }

    public static int sumOfNaturalNumbers(int number) {
        if (number == 0) {
            return 0;
        }
        return number + sumOfNaturalNumbers(number - 1);
    }

    public static int factorial(int fact) {
        if (fact <= 1) {
            return 1;
        }
        return fact * factorial(fact - 1);
    }

    public static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        } else {
            return (fibonacci(num - 1) + fibonacci(num - 2));
        }
    }

    public static void fibonacciOptimized(int num, int a, int b) {
        if (num == 0) {
            return;
        }
        int c = a + b;
        System.out.print(c + " ");
        fibonacciOptimized(num - 1, b, c);
    }

    public static int calcPower(int x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        } else {
            return x * calcPower(x, n - 1);
        }
    }

    public static int calcPowerOptimized(int x, int n) { // space complexity -> O(log n)
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        } else {
            int temp = calcPowerOptimized(x, n/2);
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return temp * temp * x;
            }
        }
    }

    public static void towerOfHanoi(int n, String start, String helper, String destination) {
        if(n == 0) {
            return;
        } 
        
        towerOfHanoi(n - 1, start, destination, helper);
        System.out.println("Disk "+ n +" moves from "+start+" to "+destination);
        towerOfHanoi(n-1, helper, start, destination);
    }

    public static String reverseString(String str) {
        if(str.isEmpty()){
            return str;
         } else {
            return reverseString(str.substring(1))+str.charAt(0);
         }
    }

    public static int first = -1;
    public static int last = -1;
    public static int count = 0;
    public static String findFirstAndLastOccurance(String str, char ch) {
        if(str.isEmpty()) {
            return str;
        }

        if(str.charAt(0) != ch) {
            count++;
        } else {
            if(first == -1) {
                first = count;
                last = count;
            } else {
                last = count;
            }
            count++;
        }

        findFirstAndLastOccurance(str.substring(1), ch);
        return "first occurance-> "+first+"  last occurance -> "+last;
    }

    

    public static void main(String[] args) {
        // printNumbers(5);

        // System.out.println(sumOfNaturalNumbers(10));

        // System.out.println(factorial(5));

        // System.out.println(fibonacci(8));

        // fibonacciOptimized(7, 0, 1);

        // System.out.println( calcPower(2, 5));

        // System.out.println(calcPowerOptimized(5, 3));

        // towerOfHanoi(3, "start", "helper", "destination");

        // System.out.println(reverseString("A nupam"));

        // System.out.println(findFirstAndLastOccurance("aacsdaec", 'c'));
    }
}
