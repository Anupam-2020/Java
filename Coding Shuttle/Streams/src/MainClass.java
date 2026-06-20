public class MainClass {
    public static void main(String[] args) {

        // Older way.
//        Walkable obj = new WalkFast();
//        obj.walk(3);


//        Walkable obj = new Walkable() {
//            @Override
//            public int walk(int steps) {
//                return 0;
//            }
//        };

        Walkable obj = (steps, isEnable) -> {
            System.out.println("Walking fast "+ steps + " steps.");
            return 2 * steps;
        };

        obj.walk(6, true);


        Walkable obj2 = ((step, isEnable) -> 2 * step);
        System.out.println(obj2.walk(3, true));
    }
}


@FunctionalInterface
interface Walkable {
    int walk(int steps, boolean isEnabled);
}


class WalkFast implements Walkable {

    @Override
    public int walk(int steps, boolean isEnabled) {
        System.out.println("Walking fast "+ steps + " steps.");
        return 2 * steps;
    }
}