package projectCode20280.Algorithms;

import java.util.Arrays;

public class Recursion {

    private static int[] reverseArray(int[] a, int i, int j) {
        if (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            a = reverseArray(a, i + 1, j - 1);
        }
        return a;
    }

    public static void main(String[] args) {
        //Testing reverseArray method
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Reversed array: " + Arrays.toString(reverseArray(arr, 0, 7)));
    }

}
