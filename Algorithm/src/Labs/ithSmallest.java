package Labs;

import java.util.Arrays;
import java.util.Scanner;

public class ithSmallest {
    public static int findIthSmallest(int arr[],int i){
        if (arr.length == 1) {
            // base case: if the list has only one element, it is the ith smallest
            return arr[0];
        }

        // divide the list into two sublists
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // find the ith smallest in each sublist
        int leftSmallest = findIthSmallest(left, i);
        int rightSmallest = findIthSmallest(right, i - mid);

        // return the smaller of the two if it is the ith smallest overall,
        // or the ith smallest in the larger sublist if not
        if (leftSmallest < rightSmallest) {
            return (i <= mid) ? leftSmallest : rightSmallest;
        } else {
            return (i <= mid) ? rightSmallest : leftSmallest;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,6,1,3,4};
        int i = 3;  // find the 3rd smallest number
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter the size of the array:");
//        int size = in.nextInt();
//        int arr[] = new int[size];
//
//        System.out.println("Enter the Array:");
//        for (int i=0;i<size;i++){
//            arr[i] = in.nextInt();
//        }
//
//        System.out.println("Enter array is :");
//        for (int i=0;i<size;i++){
//            System.out.println(arr[i]);
//        }
//
//        System.out.println("Enter the ith smallest number:");
//        int i = in.nextInt();
        int result = findIthSmallest(arr, i);
        System.out.println("The " + i + "th smallest number is " + result);
    }
}

