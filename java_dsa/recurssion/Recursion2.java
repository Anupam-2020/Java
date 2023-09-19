import java.util.HashSet;
import java.util.Scanner;

public class Recursion2 {

    public static int index = 0;

    public static boolean checkForSortedArray(int arr[]) {
        if (index == arr.length - 1) {
            return true;
        }

        if (arr[index] >= arr[index + 1]) {
            return false;
        }
        index++;
        return checkForSortedArray(arr);
    }

    public static String str = new String("");
    public static int countOfParticularChar = 0;

    public static void moveParticularCharToLastOfString(String str, char ch) {
        if (str.isEmpty()) {
            for (int i = 0; i < countOfParticularChar; i++) {
                Recursion2.str += 'x';
            }
            return;
        }

        if (str.charAt(0) != ch) {
            Recursion2.str += str.charAt(0);
        } else {
            countOfParticularChar++;
        }

        moveParticularCharToLastOfString(str.substring(1), ch);
    }

    public static boolean map[] = new boolean[26];

    public static void removeDuplicates(String str, String newString) {
        if (str.length() == 0) {
            System.out.println(newString);
            return;
        }

        if (!map[str.charAt(0) - 'a']) {
            map[str.charAt(0) - 'a'] = true;
            newString += str.charAt(0);
        }
        removeDuplicates(str.substring(1), newString);
    }

    public static void subSequenceOfString(String str, String newString, int index) {
        if (index == str.length()) {
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);
        subSequenceOfString(str, newString + currChar, index + 1);
        subSequenceOfString(str, newString, index + 1);
    }

    public static void uniqueSubsequence(String str, int index, String newString, HashSet<String> set) {
        if(str.length() == index) {
            if(set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currChar = str.charAt(index);
        uniqueSubsequence(str, index+1, newString+currChar, set);
        uniqueSubsequence(str, index+1, newString, set);
    }

    public static String keypad[] = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void nokiaKeypad(String str, int index, String combination) {
        if(str.length() == index) {
            System.out.println(combination);
            return;
        }
        String currString = keypad[str.charAt(index) - '0'];
        for(int i = 0; i < currString.length(); i++) {
            nokiaKeypad(str, index+1, combination+currString.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // function 1...........................................................
        // System.out.println("Enter size of array");
        // int size = sc.nextInt();
        // int arr[] = new int[size];
        // for(int i = 0; i < size; i++) {
        // arr[i] = sc.nextInt();
        // }
        // System.out.println(checkForSortedArray(arr));

        // function 2..............................................................
        // String str = sc.nextLine();
        // moveParticularCharToLastOfString(str, 'x');
        // System.out.println(Recursion2.str);

        // function 3......................................................
        // System.out.println("Enter string");
        // String str = sc.nextLine();
        // String newString = "";
        // removeDuplicates(str, newString);

        // function 4...............................................
        subSequenceOfString("abc", "", 0);

        // function 5.....................................................
        // HashSet<String> set = new HashSet<>(0);
        // uniqueSubsequence("abc", 0, "", set);

        // function 6..................................................
        nokiaKeypad("26",0, "");
    }
}
