// package ExceptionHandling;
public class ExceptionHandling {
    public static void main(String[] args) {
        int i = 2;
        int j = 18;
        int arr[] = new int[5];
        try {
            System.out.println(j/i);
            System.out.println(arr[5]);
        }
        catch(Exception e) {
            System.out.println("Something went wrong "+ e);
        }
        System.out.println(arr[0]);
    }
}
