public class strings {

    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        int max = 1;
        char cha = '|';
        for(int i = 0; i < line.length()-1; i++) {
            int count = 0;
            char ch = line.charAt(i);
            for(int j = i; j < line.length();j++) {
                char ch1 = line.charAt(j);
                if(ch == ch1) {
                    count++;
                }
            }

            if((count >= max) && (int)ch < (int)cha) {
                max = count;
                cha = ch;
            }
        }
        return cha;
    }


    public static void main(String[] args) {
        // String name = "Anupam";
        // String name1 = "Anand";
        // String fullName = name + " " + name1;
        // System.out.println(fullName);
        // System.out.println(fullName.length());

        // charAt...................................................
        // for(int i = 0; i < fullName.length(); i++) {
        //     System.out.println(fullName.charAt(i));
        // }

        // String name2 = new String("Anupam"); // 2nd way of declaring String.... This is also the way of declaring non-primitive data types......
        // String name3 = "Anupam";
        // compareTo method.......................................
        // // Strings should be compared with `compareTo` method only..... `==` can be worng sometimes........
        // System.out.println(name2 == name3); // it will return false....
        // System.out.println(name2.compareTo(name3)); // it will return 0(equal)............

        // substring method..................................
        String name4 = "Anupam Anand";
        System.out.println(name4.substring(7));

        name4 = name4 + "H";
        System.out.println(name4);

        name4 = name4.substring(0, 6) + "MZ" + name4.substring(6);
        System.out.println(name4);

        System.out.println((char)122);

        System.out.println(getMaxOccuringChar("abcc"));
    }
}
