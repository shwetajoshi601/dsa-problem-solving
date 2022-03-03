import java.util.*;

public class ArrCeilInSortedArray {
    
    static int ceil(int[] arr, int target) {
        int ceil = -1;
        int low = 0, high = arr.length-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(arr[mid] == target)
                return mid;
            
            if(arr[mid] < target)
                low = mid+1;
            else {
                high = mid-1;
                ceil = mid;
            }
        }
        
        return ceil;
    }
  
    public static void main(String args[]) {
       int[] arr = {1, 2, 8, 10, 10, 12, 19};
       
       System.out.println(ceil(arr, 0));
       System.out.println(ceil(arr, 5));
       System.out.println(ceil(arr, 20));
    }
}
