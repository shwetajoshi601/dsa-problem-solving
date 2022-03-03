import java.util.*;

public class ArrBinarySearchNearlySortedArray {
    
    static int search(int[] arr, int low, int high, int target) {
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            // in a nearly sorted array, if we compare to the array if it was sorted
            // an element can either be at mid, mid-1 or mid+1
            // so check all neighboring elements
            if(arr[mid] == target)
                return mid;
            if(mid-1 >= low && arr[mid-1] == target)
                return mid-1;
            if(mid+1 <= high && arr[mid+1] == target)
                return mid+1;
                
            if(arr[mid] < target)
                // we skip the adjacent elements as we have already checked them
                low = mid + 2;
            else
                high = mid-2;
        }
        
        return -1;
    }
  
    public static void main(String args[]) {
       int[] arr = {10, 3, 40, 20, 50, 80, 70};
       int target = 40;
       
       int index = search(arr, 0, arr.length-1, target);
       
       if(index != -1)
            System.out.println("Found " + target + " at index " + index);
       else
            System.out.println(target + "not found!");
            
       int target2 = 100;
       int index2 = search(arr, 0, arr.length-1, target2);
       
       if(index2 != -1)
            System.out.println("Found " + target2 + " at index " + index2);
       else
            System.out.println(target2 + " not found!");
       
    }
}
