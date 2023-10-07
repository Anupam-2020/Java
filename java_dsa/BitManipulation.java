import java.lang.reflect.Array;

public class BitManipulation {
    static int binarysearch(int arr[], int n, int k) {
        // code here
        int start = 0;
        int end = arr.length - 1;
        int mid = ( start + end ) / 2;
        while(start < end) {
            if(arr[mid] == k) return mid;
            else if(arr[mid] > k) end = mid - 1;
            else start = mid + 1;
            mid = (start + end) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Operations which come under bit manipulation..................
        // 1. get -> to get which bit is available at particular position of a number.. 
        // 2. set -> to make a bit 1 if it is 0 and leave it as it is if it is 1 at particular position of a number.......... 
        // 3. clear -> clear is opposite of set..  to make a bit 0 if it 1. And leave as it is if it is 0...
        // 4. update -> to update a bit at particular position....

        // 1. get bit at a particular position......................................
        // step1:- Bit mask:- 1 << pos....
        // step2:- operation:- perform `and` operation between bit masked no. and given no.....

        // int n = 5; 
        // int pos = 2;
        // int bitMask = 1 << pos;

        // System.out.println(bitMask & n);
        // System.out.println(bitMask & n);

        // if((bitMask & n) == 0) {
        //     System.out.println("bit was zero");
        // } else {
        //     System.out.println("bit was one");
        // }


        // 2. set bit (means -> change the bit at particular pos. with 1)..............................
        // step1:- Bait mask:- 1 << i....
        // step2: operation:- perform `OR` operation b/w masked no. and given no......

        // int n1 = 5;
        // int pos1 = 1;
        // int bitMask1 = 1 << pos1;
        // System.out.println(bitMask1 | n1);

        // 3. clear bit ( opposite of set bit)......................................
        // step1:- Bit mask:- 1 << pos
        // step2:- perform AND operation b/w num and NOT of BitMask...... 

        // int n2 = 5;
        // int pos2 = 2;
        // int bitMask2 = 1 << pos2;
        // System.out.println(n2 & ~(bitMask2));

        // 4. reverse bit............................................................................
        // step1:- check if the bit is 0 or 1.
        // step2:- if 0 then apply set-bit method else get-bit method.
    
        // int num = 5;
        // int pos = 2;
        // int bitMask3 = 1 << pos;
        // int updatedNum;

        // System.out.println(num & bitMask3);

        // if((num & bitMask3) != 0) {
        //     updatedNum = num & ~(bitMask3);
        // } else {
        //     updatedNum = num | bitMask3;
        // }

        // System.out.println(updatedNum);


        // update bit ......................................
        // step1:- check if the operation is to convert to 0 or 1...
        // step2:- if 0 apply clear operation else set operation.

        // int num2 = 5;
        // int pos = 2;
        // int bitmasked = 1 << pos;
        // int operation = 0;

        // switch(operation) {
        //     case 1: 
        //         // set
        //         System.out.println(bitmasked | num2);
        //         break;
        //     case 0:
        //         // clear
        //         System.out.println(num2 & ~bitmasked);
        //         break;
        //     default:
        //         System.out.println("Invalid operation");
        // }


        // binary to decimal conversion.....................

        // int binary = 1001001;
        // int temp = binary;
        // int digit = 0;
        // int base = 1;
        // while(temp != 0) {
        //     digit = digit + ((temp%10)*base);
        //     temp = temp / 10;
        //     base = base * 2;
        // }
        // System.out.println("Decimal of a binary form -> "+ digit);

        // decimal to binary conversion.................

        // M-1 using bit method.............
        // int decimal = 11;
        // int space_in_bits = Integer.BYTES * 8 - 1;
        // String binary = "";
        // // System.out.println(space_in_bits);
        // while(space_in_bits >= 0) {
        //     int k = decimal >> space_in_bits;
        //     if((k & 1) == 1) {
        //         binary = binary + "1";
        //     } else {
        //         binary = binary + "0";
        //     }
        //     space_in_bits -= 1;
        // }
        // System.out.println("Binary of a decimal number -> "+ binary);


        // M-2 using normal method.................... 
        // int num = 5, num1, binary = 0, i = 1, rem;
        // num1 = num;
        // while( num != 0) {
        //     rem = num % 2;
        //     binary = binary + (rem * i);
        //     num = num / 2;
        //     i = i * 10;
        // }
        // System.out.println("Binary of a decimal number -> "+binary);

        // to count no. of 1s in binary of an no.
        // int num = 5;
        // int count = 0;
        // while(num != 0) {
        //     count = count + (num & 1);
        //     num = num >> 1;
        // }
        // System.out.println("No. of 1s in a number's binary form -> "+count);

        // to find if a number is power of 2 or not................
        // int num = 7;
        // if((num & (num-1)) == 0) {
        //     System.out.println("The given number "+num+" is power of 2");
        // } else {
        //     System.out.println("The given number "+num+" is not the power of 2");
        // }

        // find first set bit....
        // int comp = 1;
        // int num = 8;
        // for(int i = 0; i < num; i++) {
        //     if((num & comp) != 0)  {
        //         System.out.println(i+1);
        //         break;
        //     }
        //     comp = comp << 1;
        // }

        // String s = "11111110100";
        
        // int count = 0;
        // for(int i = 0; i < s.length(); i++) {
        //     if(s.charAt(i) == '1') count++;
        // }
        // System.out.println(count);

        int arr[] = {1 ,2 ,3 ,4 ,5 ,6 ,8, 9, 10, 14 ,16 ,19, 22 ,23, 25, 26 ,27 ,29, 31, 34, 35 ,36 ,38, 39, 40 ,45, 46 ,48, 50, 51, 52, 57 ,59, 60, 61, 63, 67, 68, 69, 71, 75, 76 ,77 ,79, 81, 82, 83, 86 ,87, 88, 90 ,92, 93, 94, 95, 96, 98, 99, 100};
        System.out.println(binarysearch(arr, arr.length, 93));
    }
}
