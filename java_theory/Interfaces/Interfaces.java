package Interfaces;
interface Computer {
    // Variables in interface are static and final by default...........
    String area = "Patna";
    int age = 25;
    void code();
}

class Desktop implements Computer {
    public void code() {
        System.out.println("code, compile, run: faster");
    }
}

class Laptop implements Computer {
    public void code() {
        System.out.println("code, compile, run");
    }
}

class Developer {
    public void devApp(Computer lap) {
        lap.code();
    }
}

public class Interfaces {
    public static void main(String[] args) {
        Developer dev = new Developer();
        Computer lap = new Laptop();
        Computer des = new Desktop();
        dev.devApp(des);

        System.out.println(Computer.area);
    }
}

// Types of interfaces -> 
// 1. Normal Interface
// 2. Functional / SAM(Single Interface Method)
// 3. Marker Interface