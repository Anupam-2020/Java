public class ArraySubsetOfAnother {
    static boolean isIsogram(String data){
        //Your code here
        int []chArr = new int[26];
        for(int i = 0; i < data.length(); i++) {
            chArr[data.charAt(i)-'a']++;
        }
        for(int i : chArr) {
            System.out.print(i+" ");
        }
        return true;
    }
    public static void main(String[] args) {
        isIsogram("anupam");
    }
}
