package lab2;

import java.util.Arrays;

public class InitArray {

    public static void main(String[] args) {
     // updated lines 11-15 to use a[0] through a[4].
        int[] a = new int[5];

        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;

        System.out.println(Arrays.toString(a));        
    }
}