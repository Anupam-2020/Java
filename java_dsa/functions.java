import java.util.Scanner;

public class functions {
    public static void printName(String name) {
        System.out.println(name);
    }

    public static int sumCalculate(int a, int b) {
        return a + b;
    }

    public static int factorial(int num) {
        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void sumOfOddNumbers(int num) {
        int sumOfFirstAndLastNumber = 0;
        if (num % 2 != 0) {
            sumOfFirstAndLastNumber = num + 1;
        } else {
            sumOfFirstAndLastNumber = num;
        }
        System.out.println(((1 + num) / 2) * (sumOfFirstAndLastNumber) / 2);
    }

    public static void average(int num1, int num2, int num3) {
        System.out.println((num1 + num2 + num3) / 3);
    }

    public static void numberGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter yes/no");
        int value = sc.nextInt();
        if (value == 1) {
            System.out.println("Enter number");
            int num = sc.nextInt();

            int countPos = 0;
            int countNeg = 0;
            int countZero = 0;

            while (value == 1) {
                if (num > 0) {
                    countPos = countPos + 1;
                } else if (num < 0) {
                    countNeg = countNeg + 1;
                } else {
                    countZero = countZero + 1;
                }
                System.out.println("Do you want to play more(yes/no)");
                value = sc.nextInt();
                if (value == 1) {
                    System.out.println("Enter number");
                    num = sc.nextInt();
                }
            }

            System.out.println("positive no. - " + countPos + " negative no. - " + countNeg + " zeros - " + countZero);
        } else {
            return;
        }
    }

    public static void powerOfNumbers(int base, int pow) {
        int i = pow, prod = 1;
        while (i >= 1) {
            prod = prod * base;
            i--;
        }
        System.out.println(prod);
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        if (a == b) {
            return a;
        }

        else if (a > b) {
            return gcd(a - b, b);
        }

        else {
            return gcd(a, b - a);
        }
    }

    public static void fibonacci(int num) {
        int first = 0;
        int second = 1;
        System.out.print("0 1 ");
        if(num == 0) {
            System.out.println(first);
        } else if(num == 1) {
            System.out.println(second);
        } else if(num < 0) {
            System.out.println(-1);
        } else {
            int i = 2;
            int series = 0;
            while(i < num) {
                series = first + second;
                System.out.print(series+" ");
                first = second;
                second = series;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();

        // printName(name);

        // int value1 = sc.nextInt();
        // int value2 = sc.nextInt();

        // int sum = sumCalculate(value1, value2);
        // System.out.println(sum);

        // int fact = sc.nextInt();
        // System.out.println(factorial(fact));

        // average(2, 5, 5);

        // sumOfOddNumbers(1);

        // numberGame();

        // powerOfNumbers(2, 3);

        // System.out.println(gcd(27, 3));

        fibonacci(8);
    }
}
