package Strings;

public class StringBuffers {
    // stringBuffers are thread-safe.
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("jain");
        sb.append("jain");
        sb.append("jain");
        System.out.println("append -> "+sb);

        // insert
        sb.insert(4,"am");
        System.out.println("insert -> "+sb);

        // replace
        sb.replace(0, 2, "mi");
        System.out.println("replace -> "+sb);

        // reverse()
        sb.reverse();
        System.out.println("reverse -> "+sb);

        System.out.println(sb.capacity());
    }
}
