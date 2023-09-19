import java.util.ArrayList;
import java.util.Collections;

public class CollectionsJava {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(6);
        arr.add(2);
        arr.add(3);
        arr.add(0);


        // for(int i = 0; i < arr.size(); i++) {
        //     System.out.print(arr.get(i)+" ");
        // }
        
        System.out.println(arr);

        arr.add(1,1);
        
        System.out.println(arr);

        arr.remove(0); // remove array element.

        System.out.println(arr);

        Collections.sort(arr); // sort array list.

        System.out.println(arr);
    }
}
