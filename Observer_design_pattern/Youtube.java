package Observer_design_pattern;

public class Youtube {
    public static void main(String[] args) {
        Channel telusko = new Channel();

        Subscriber s1 = new Subscriber("Anupam");
        Subscriber s2 = new Subscriber("Anand");

        telusko.subscribe(s2);
        telusko.subscribe(s1);

        s1.subscribeChannel(telusko);
        s2.subscribeChannel(telusko);

       System.out.println(telusko.geSubs());

        telusko.upload("How To learn programming");
    }
}
