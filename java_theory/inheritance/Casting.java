class Upper {
    public void getValue() {
        System.out.println("Hello from Upper");
    }
}

class Lower extends Upper {
    public void getValue1() {
        System.out.println("Hello from lower");
    }
}

public class Casting {
    public static void main(String[] args) {
       Upper obj = (Upper) new Lower(); // Upper Casting...
       obj.getValue();


       Lower obj2 =  (Lower)obj;
       obj2.getValue();
    }
}

// Note:- Upper class can't be casted to lower class...