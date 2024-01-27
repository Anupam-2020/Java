package Strings;

public class Strings {
    public static String reverseString(String string) {
        if(string.isEmpty()) {
            return string;
        }
        return reverseString(string.substring(1)) + string.charAt(0);
    }

    public static boolean checkPalindrome(String string, int index) {
        if(index == string.length()/2) {
            return true;
        }

        if(string.charAt(index) != string.charAt(string.length() - index - 1)) {
            return false;
        }
        return checkPalindrome(string, index+1);
    }

    public static int countWords(String string) {
        int count = 1;
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == ' ' && string.charAt(i+1) != ' ') {
                count++;
            }
        }
        return string.isEmpty() ? 0: count;
    }

    public static int compareToPolyfill(String string1, String string2) {
        int str1 = 0;
        int str2 = 0;
        while (str2 < string2.length() && str1 < string1.length()) {
            if(string1.charAt(str1) != string2.charAt(str2)) {
                return (int) string1.charAt(str1) - (int) string2.charAt(str2);
            }
            str1++;
            str2++;
        }

        if(string1.length() != string2.length()) {
            return string1.length() - string2.length();
        }
        return 0;
    }

    public static int charIndex(String string, char ch) {
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    public static boolean stringSearch(String string2, String string) {
        if(string.length() == string2.length()) {
            return false;
        }

        String subString = string.substring(0, string2.length());
        if(subString.equals(string2)) {
            return true;
        }

        return stringSearch(string2, string.substring(1));
    }

    public static void main(String[] args) {
        // 3 ways of declaring String
        // 1. string literal -> String str = "hello world"; // stores value in SCP(String constant pool).
        // 2. using new keyword. -> String str = new String("hello world"); // creates two objects (one in SCP and one in heap).
        // 3. converting character array inti string.

        // M-1...................
        String str = "Anupam";
        String str1 = new String("Anupam");
        char []arr = {'a','n','u','p','a','m'};
        String str2 = new String(arr);
        System.out.println(str2);

        // toCharArray().
        String str3 = "anupam";
        char strChr[] = str3.toCharArray();
        System.out.println("to char array -> "+strChr);

        // chatAt().
        String str4 = "hello";
        System.out.println("String at "+2+" -> " +str4.charAt(2));

        // compareTo()
        String str5 = "hello";
        String str6 = "hz";
        System.out.println("Compare to -> "+str5.compareTo(str6));

        // Note:-> == -> reference comparison, equals() -> Object comparison

        // H.W
        String str7 = "helloa";
        String str8 = "helloaw";
        String str9 = reverseString(str8);
        System.out.println(str9);
        System.out.println((checkPalindrome("anupam", 0)));
        System.out.println("Count words -> "+countWords( ""));
        System.out.println("Compare To polyfill -> " +compareToPolyfill("anupam", "anupams"));
        System.out.println("char index -> "+charIndex("mnupam", 'a'));
        String str10 = "anupam", str11 = "dsvanupasvcadanupamf5rv";
        System.out.println("check for string1 in string2 -> "+stringSearch(str10, str11));
    }
}
