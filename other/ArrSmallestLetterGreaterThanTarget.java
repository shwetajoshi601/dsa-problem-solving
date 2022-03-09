import java.util.*;

public class ArrSmallestLetterGreaterThanTarget {
    
    static char getSmallest(char[] arr, char target) {
        char nextLetter = '$';
        int low = 0, high = arr.length-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(arr[mid] <= target) {
                low = mid+1;
            } else {
                high = mid-1;
                nextLetter = arr[mid];
            }
        }
        
        return nextLetter;
    }
  
    public static void main(String args[]) {
       char[] arr = {'a', 'c', 'f', 'h'};
       
       System.out.println(getSmallest(arr, 'g'));
       System.out.println(getSmallest(arr, 'c'));
       System.out.println(getSmallest(arr, 'z'));
    }
}