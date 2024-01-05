class M {
    public void show() {
        System.out.println("In M class");
    }
}

class N extends M {
    @Override
    public void show() {
        super.show();
    }
}

public class AnnotationsDemo {
    public static void main(String[] args) {
        N obj = new N();
        obj.show();
    }
}
