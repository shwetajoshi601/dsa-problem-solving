import java.util.*;
import java.lang.*;
import java.io.*;

public class ArrCheckIfNumIsMajorityElement {
    public static boolean isMajorityElement (int[] arr, int target) {
        if(arr.length == 0) return false;
        // since the array is sorted, find the first occurence of the target using binary search
        // we assume that the element is present in the array
        System.out.println("isMajorityElement(): " + arr.length);
        int firstOccurence = binarySearch(arr, target);
        System.out.println(firstOccurence);
        int lastIndex = firstOccurence + arr.length / 2;
        // check if the element at index firstOccurence + N/2 is equal to the target
        return lastIndex < arr.length && arr[lastIndex] == target;
    }

    private static int binarySearch(int[] arr, int target) {
        System.out.println("binarySearch()");
        int left = 0, right=arr.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            System.out.println(mid);
            // only shrink the array in each step
            /* Check if arr[mid] is the first occurrence of x.
            arr[mid] is first occurrence if x is one of the following
            is true:
            (i)  mid == 0 and arr[mid] == x
            (ii) arr[mid-1] < x and arr[mid] == x
        */
            if((mid == 0 || arr[mid-1] < target) && arr[mid] == target)
                return mid;
            if(arr[mid] < target)
                left = mid+1;
            else
                right = mid;
        }

        // first occurence index
        System.out.println("left: " + left);
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 5, 5, 5, 5, 6};
        int target = 5;
        System.out.println("in main()");
        System.out.println(isMajorityElement(arr, target));

    }
}