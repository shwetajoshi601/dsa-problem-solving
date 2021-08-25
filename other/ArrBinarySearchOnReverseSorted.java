import java.util.*;

public class ArrBinarySearchOnReverseSorted {

    static int binarySearchOnReverseSorted(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        
        while(low < high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid] < key)
                high = mid;
            else
                low = mid + 1;
        }
        
        return -1;
    }
    
    
    public static void main(String args[]) {
       int[] arr = {20, 16, 12, 9, 5, 3,2,1};
        
        System.out.println(binarySearchOnReverseSorted(arr, 16));
        System.out.println(binarySearchOnReverseSorted(arr, 21));
    }
}
