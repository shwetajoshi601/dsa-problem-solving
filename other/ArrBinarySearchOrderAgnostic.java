import java.util.*;

public class ArrBinarySearchOrderAgnostic {
    
    static int binarySearch(int[] arr, int key) {
        int result = -1;
        if(arr.length == 0)
            return result;
        
        // in order agnostic search we do not know if the array is sorted in asc or desc
        if(arr.length > 1) {
            // compare the first and last element
            // if first is < last, it means the array is ascending
            if(arr[0] < arr[arr.length-1])
                result = binarySearchHelperAsc(arr, key);
            else
                result = binarySearchHelperDesc(arr, key);
        } else
        // only one element in the array
            result = arr[0] == key ? 0 : -1;
        
        return result;
    }
    
    // binary search on ascending order array
    static int binarySearchHelperAsc(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid] < key)
                low = mid+1;
            else
                high = mid;
        }
        
        return -1;
    }
    
    // binary search on descending order array
    static int binarySearchHelperDesc(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        
        // less than condition is important to avoid infinite loop
        while(low < high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid] < key)
                high = mid;
            else
                low = mid+1;
        }
        
        return -1;
    }
    
    
    public static void main(String args[]) {
       int[] arr = {2,4,5,6,7,8,12,15,20};
       int[] arr2 = {9,8,7,5,4,2};
       
        System.out.println(binarySearch(arr, 15));
        System.out.println(binarySearch(arr, 21));
        
        System.out.println(binarySearch(arr2, 8));
        System.out.println(binarySearch(arr2, 21));
    }
}
