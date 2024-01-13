public class Lecture3 {

    public static void reverseArray(int arr[], int i) {
        if(i >= arr.length/2) return;

        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
        reverseArray(arr, i+1);
    }

    public static boolean checkPalindrome(String str, int i) {
        if(i >= str.length()/2) return true;

        if(str.charAt(i) != str.charAt(str.length() - i - 1)) return false;

        return checkPalindrome(str, i + 1);
    }
    
    public static void main(String[] args) {
        // int arr[] = {1,2,3,4,5};
        // reverseArray(arr, 0);
        // for(int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]+" ");
        // }

        String str = "malayalam";
        System.out.println(checkPalindrome(str, 0));
    }
}
