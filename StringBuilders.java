public class StringBuilders {
    public static String conRevstr(String S1, String S2) {
        // code here
        // String S3 = S1.concat(S2);
        // StringBuilder S4 = new StringBuilder(); 
        // S4.append(S3);
        // return (S4.reverse()).toString();
        
        String S3 = S1.concat(S2);
        String reverse = "";
        for(int i = 0;  i< S3.length(); i++) {
            reverse =  S3.charAt(i) + reverse;
        }
        return reverse;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Anupam");
        System.out.println(sb);

        // // char at index 0
        // System.out.println(sb.charAt(0));

        // // set char at index 0;
        // sb.setCharAt(0, 'B');
        // System.out.println(sb);

        // set char using insert.
        // sb.insert(2, 'Z');
        // System.out.println(sb);

        // // delete character at index.
        // sb.deleteCharAt(0);
        // System.out.println(sb);

        // // delete characters
        // sb.delete(0, 5);
        // System.out.println(sb);

        // // append at last
        // sb.append("ix");
        // System.out.println(sb);

        // // reverse
        // sb.reverse();
        // System.out.println(sb);
        // for(int i = 0, j = sb.length()-1; i <= j; i++, j--) {
        //     char character = sb.charAt(i);
        //     char character2 = sb.charAt(j);
        //     sb.setCharAt(i, character2);
        //     sb.setCharAt(j, character);
        // }

        // System.out.println(sb);
        System.out.println(conRevstr("Anupam", "Anand"));

        System.out.println((char)('a' - 32));
    }
}
